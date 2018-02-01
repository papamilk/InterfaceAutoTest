package blk.interfacetesting.dao.common;

import blk.interfacetesting.dao.IBaseMapper;
import blk.interfacetesting.modle.common.CmtbAttachment;
import blk.interfacetesting.modle.common.CmtbAttachmentCriteria;
import org.springframework.stereotype.Repository;

@Repository("attachmentMapper")
public interface CmtbAttachmentMapper extends IBaseMapper<CmtbAttachment, CmtbAttachmentCriteria> {
}
