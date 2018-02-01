package blk.interfacetesting.service.impl.common;
import blk.common.exception.SystemException;
import blk.common.util.CommonUtils;
import blk.common.util.Constants;
import blk.interfacetesting.dao.common.CmtbAttachmentDao;
import blk.interfacetesting.modle.common.CmtbAttachment;
import blk.interfacetesting.modle.common.CmtbAttachmentCriteria;
import blk.interfacetesting.service.common.AttachmentService;
import blk.interfacetesting.service.impl.BaseServiceImpl;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service("attachmentService")
public class AttachmentServiceImpl extends BaseServiceImpl<CmtbAttachment, CmtbAttachmentCriteria> implements AttachmentService {
    private static final Logger logger = LoggerFactory.getLogger(AttachmentServiceImpl.class);

	@Autowired
	public void setBaseDao(CmtbAttachmentDao attachmentDao){
		super.setBaseDao(attachmentDao);
	}

	@Override
	public CmtbAttachment save(MultipartFile multipartFile) {
	    // 文件全名，包括文件后缀
        String originalFileName = multipartFile.getOriginalFilename();
        String suffix = StringUtils.substringAfterLast(originalFileName, ".");
        String fileName = StringUtils.substringBeforeLast(originalFileName, ".");
        String dateTime = CommonUtils.getFormatDate("yyyy-MM-dd-HH-mm-ss");
        // 将2018-01-24-14-04-30 转成 2018/01/24
        String dateStr = StringUtils.left(dateTime,10).replace("-",File.separator);
        String storePath = Constants.UPLOAD_FILE_PATH + File.separator + dateStr;
        String actualName = dateTime + "-" + fileName;
        String filePath = storePath + File.separator + actualName + "." + suffix;
        File file = new File(filePath);
        try {
            FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
        } catch (IOException e) {
            logger.error("上传附件出错", e);
            throw new SystemException("上传附件出错", e);
        }

        CmtbAttachment attachment = new CmtbAttachment();
        attachment.setAttOriginalName(fileName);
        attachment.setAttActualName(actualName);
        attachment.setAttReferModuleid(attachment.getAttReferModuleid());
        attachment.setAttReferObjectid(attachment.getAttReferObjectid());
        attachment.setAttReferAttributeid(attachment.getAttReferAttributeid());
        attachment.setAttStorePath(storePath);
        attachment.setAttType(suffix);
        attachment.setAttSize(String.valueOf(multipartFile.getSize()));
        attachment.setAttCreatedate(dateTime);

        try {
            getBaseDao().save(attachment);
            return attachment;
        } catch (Exception e) {
            // 如果保存附件记录失败，删除已经上传的文件
            FileUtils.deleteQuietly(file);
            logger.error("保存附件记录出错", e);
            throw new SystemException("保存附件记录出错", e);
        }
	}
}
