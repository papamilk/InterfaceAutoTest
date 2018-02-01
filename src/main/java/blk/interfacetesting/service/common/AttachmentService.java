package blk.interfacetesting.service.common;

import blk.interfacetesting.modle.common.CmtbAttachment;
import blk.interfacetesting.modle.common.CmtbAttachmentCriteria;
import blk.interfacetesting.service.IBaseService;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService extends IBaseService<CmtbAttachment, CmtbAttachmentCriteria> {
    CmtbAttachment save(MultipartFile multipartFile);
}
