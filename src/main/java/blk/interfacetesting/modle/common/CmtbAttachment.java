package blk.interfacetesting.modle.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class CmtbAttachment implements Serializable {
    private Long attId;

    private String attOriginalName;

    private String attActualName;

    private String attReferModuleid;

    private String attReferAttributeid;

    private String attReferObjectid;

    private String attStorePath;

    private String attType;

    private String attSize;

    private String attCreatedate;

    private String attCreateuser;

    private String attUpdatedate;

    private String attUpdateuser;

    private String attStatus;

    private String attRemark;

    private static final long serialVersionUID = 1L;

    public Long getAttId() {
        return attId;
    }

    public void setAttId(Long attId) {
        this.attId = attId;
    }

    public String getAttOriginalName() {
        return attOriginalName;
    }

    public void setAttOriginalName(String attOriginalName) {
        this.attOriginalName = attOriginalName == null ? null : attOriginalName.trim();
    }

    public String getAttActualName() {
        return attActualName;
    }

    public void setAttActualName(String attActualName) {
        this.attActualName = attActualName == null ? null : attActualName.trim();
    }

    public String getAttReferModuleid() {
        return attReferModuleid;
    }

    public void setAttReferModuleid(String attReferModuleid) {
        this.attReferModuleid = attReferModuleid == null ? null : attReferModuleid.trim();
    }

    public String getAttReferAttributeid() {
        return attReferAttributeid;
    }

    public void setAttReferAttributeid(String attReferAttributeid) {
        this.attReferAttributeid = attReferAttributeid == null ? null : attReferAttributeid.trim();
    }

    public String getAttReferObjectid() {
        return attReferObjectid;
    }

    public void setAttReferObjectid(String attReferObjectid) {
        this.attReferObjectid = attReferObjectid == null ? null : attReferObjectid.trim();
    }

    public String getAttStorePath() {
        return attStorePath;
    }

    public void setAttStorePath(String attStorePath) {
        this.attStorePath = attStorePath == null ? null : attStorePath.trim();
    }

    public String getAttType() {
        return attType;
    }

    public void setAttType(String attType) {
        this.attType = attType == null ? null : attType.trim();
    }

    public String getAttSize() {
        return attSize;
    }

    public void setAttSize(String attSize) {
        this.attSize = attSize == null ? null : attSize.trim();
    }

    public String getAttCreatedate() {
        return attCreatedate;
    }

    public void setAttCreatedate(String attCreatedate) {
        this.attCreatedate = attCreatedate == null ? null : attCreatedate.trim();
    }

    public String getAttCreateuser() {
        return attCreateuser;
    }

    public void setAttCreateuser(String attCreateuser) {
        this.attCreateuser = attCreateuser == null ? null : attCreateuser.trim();
    }

    public String getAttUpdatedate() {
        return attUpdatedate;
    }

    public void setAttUpdatedate(String attUpdatedate) {
        this.attUpdatedate = attUpdatedate == null ? null : attUpdatedate.trim();
    }

    public String getAttUpdateuser() {
        return attUpdateuser;
    }

    public void setAttUpdateuser(String attUpdateuser) {
        this.attUpdateuser = attUpdateuser == null ? null : attUpdateuser.trim();
    }

    public String getAttStatus() {
        return attStatus;
    }

    public void setAttStatus(String attStatus) {
        this.attStatus = attStatus == null ? null : attStatus.trim();
    }

    public String getAttRemark() {
        return attRemark;
    }

    public void setAttRemark(String attRemark) {
        this.attRemark = attRemark == null ? null : attRemark.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CmtbAttachment other = (CmtbAttachment) that;
        return (this.getAttId() == null ? other.getAttId() == null : this.getAttId().equals(other.getAttId()))
                && (this.getAttOriginalName() == null ? other.getAttOriginalName() == null : this.getAttOriginalName().equals(other.getAttOriginalName()))
                && (this.getAttActualName() == null ? other.getAttActualName() == null : this.getAttActualName().equals(other.getAttActualName()))
                && (this.getAttReferModuleid() == null ? other.getAttReferModuleid() == null : this.getAttReferModuleid().equals(other.getAttReferModuleid()))
                && (this.getAttReferAttributeid() == null ? other.getAttReferAttributeid() == null : this.getAttReferAttributeid().equals(other.getAttReferAttributeid()))
                && (this.getAttReferObjectid() == null ? other.getAttReferObjectid() == null : this.getAttReferObjectid().equals(other.getAttReferObjectid()))
                && (this.getAttStorePath() == null ? other.getAttStorePath() == null : this.getAttStorePath().equals(other.getAttStorePath()))
                && (this.getAttType() == null ? other.getAttType() == null : this.getAttType().equals(other.getAttType()))
                && (this.getAttSize() == null ? other.getAttSize() == null : this.getAttSize().equals(other.getAttSize()))
                && (this.getAttCreatedate() == null ? other.getAttCreatedate() == null : this.getAttCreatedate().equals(other.getAttCreatedate()))
                && (this.getAttCreateuser() == null ? other.getAttCreateuser() == null : this.getAttCreateuser().equals(other.getAttCreateuser()))
                && (this.getAttUpdatedate() == null ? other.getAttUpdatedate() == null : this.getAttUpdatedate().equals(other.getAttUpdatedate()))
                && (this.getAttUpdateuser() == null ? other.getAttUpdateuser() == null : this.getAttUpdateuser().equals(other.getAttUpdateuser()))
                && (this.getAttStatus() == null ? other.getAttStatus() == null : this.getAttStatus().equals(other.getAttStatus()))
                && (this.getAttRemark() == null ? other.getAttRemark() == null : this.getAttRemark().equals(other.getAttRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttId() == null) ? 0 : getAttId().hashCode());
        result = prime * result + ((getAttOriginalName() == null) ? 0 : getAttOriginalName().hashCode());
        result = prime * result + ((getAttActualName() == null) ? 0 : getAttActualName().hashCode());
        result = prime * result + ((getAttReferModuleid() == null) ? 0 : getAttReferModuleid().hashCode());
        result = prime * result + ((getAttReferAttributeid() == null) ? 0 : getAttReferAttributeid().hashCode());
        result = prime * result + ((getAttReferObjectid() == null) ? 0 : getAttReferObjectid().hashCode());
        result = prime * result + ((getAttStorePath() == null) ? 0 : getAttStorePath().hashCode());
        result = prime * result + ((getAttType() == null) ? 0 : getAttType().hashCode());
        result = prime * result + ((getAttSize() == null) ? 0 : getAttSize().hashCode());
        result = prime * result + ((getAttCreatedate() == null) ? 0 : getAttCreatedate().hashCode());
        result = prime * result + ((getAttCreateuser() == null) ? 0 : getAttCreateuser().hashCode());
        result = prime * result + ((getAttUpdatedate() == null) ? 0 : getAttUpdatedate().hashCode());
        result = prime * result + ((getAttUpdateuser() == null) ? 0 : getAttUpdateuser().hashCode());
        result = prime * result + ((getAttStatus() == null) ? 0 : getAttStatus().hashCode());
        result = prime * result + ((getAttRemark() == null) ? 0 : getAttRemark().hashCode());
        return result;
    }
}