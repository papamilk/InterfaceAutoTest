package blk.interfacetesting.dao.impl.common;


import blk.interfacetesting.dao.common.CmtbAttachmentDao;
import blk.interfacetesting.dao.common.CmtbAttachmentMapper;
import blk.interfacetesting.dao.impl.IBaseDaoImpl;
import blk.interfacetesting.modle.common.CmtbAttachment;
import blk.interfacetesting.modle.common.CmtbAttachmentCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("attachmentDao")
public class CmtbAttachmentDaoImpl extends IBaseDaoImpl<CmtbAttachment, CmtbAttachmentCriteria> implements CmtbAttachmentDao {
    @Autowired
    public void setiBaseMapper(CmtbAttachmentMapper attachmentMapper) {
        super.setiBaseMapper(attachmentMapper);
    }

}
