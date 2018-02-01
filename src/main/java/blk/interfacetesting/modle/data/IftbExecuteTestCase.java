package blk.interfacetesting.modle.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IftbExecuteTestCase implements Serializable {
    private Integer ietcId;

    private Integer iemsId;

    private Integer mtcId;

    private String ietcStatus;

    private String ietcCreatetime;

    private String ietcCreateuser;

    private String ietcUpdatetime;

    private String ietcUpdateuser;

    private String mtcName;

    private static final long serialVersionUID = 1L;

    public Integer getIetcId() {
        return ietcId;
    }

    public void setIetcId(Integer ietcId) {
        this.ietcId = ietcId;
    }

    public Integer getIemsId() {
        return iemsId;
    }

    public void setIemsId(Integer iemsId) {
        this.iemsId = iemsId;
    }

    public Integer getMtcId() {
        return mtcId;
    }

    public void setMtcId(Integer mtcId) {
        this.mtcId = mtcId;
    }

    public String getIetcStatus() {
        return ietcStatus;
    }

    public void setIetcStatus(String ietcStatus) {
        this.ietcStatus = ietcStatus == null ? null : ietcStatus.trim();
    }

    public String getIetcCreatetime() {
        return ietcCreatetime;
    }

    public void setIetcCreatetime(String ietcCreatetime) {
        this.ietcCreatetime = ietcCreatetime == null ? null : ietcCreatetime.trim();
    }

    public String getIetcCreateuser() {
        return ietcCreateuser;
    }

    public void setIetcCreateuser(String ietcCreateuser) {
        this.ietcCreateuser = ietcCreateuser == null ? null : ietcCreateuser.trim();
    }

    public String getIetcUpdatetime() {
        return ietcUpdatetime;
    }

    public void setIetcUpdatetime(String ietcUpdatetime) {
        this.ietcUpdatetime = ietcUpdatetime == null ? null : ietcUpdatetime.trim();
    }

    public String getIetcUpdateuser() {
        return ietcUpdateuser;
    }

    public void setIetcUpdateuser(String ietcUpdateuser) {
        this.ietcUpdateuser = ietcUpdateuser == null ? null : ietcUpdateuser.trim();
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
        IftbExecuteTestCase other = (IftbExecuteTestCase) that;
        return (this.getIetcId() == null ? other.getIetcId() == null : this.getIetcId().equals(other.getIetcId()))
            && (this.getIemsId() == null ? other.getIemsId() == null : this.getIemsId().equals(other.getIemsId()))
            && (this.getMtcId() == null ? other.getMtcId() == null : this.getMtcId().equals(other.getMtcId()))
            && (this.getIetcStatus() == null ? other.getIetcStatus() == null : this.getIetcStatus().equals(other.getIetcStatus()))
            && (this.getIetcCreatetime() == null ? other.getIetcCreatetime() == null : this.getIetcCreatetime().equals(other.getIetcCreatetime()))
            && (this.getIetcCreateuser() == null ? other.getIetcCreateuser() == null : this.getIetcCreateuser().equals(other.getIetcCreateuser()))
            && (this.getIetcUpdatetime() == null ? other.getIetcUpdatetime() == null : this.getIetcUpdatetime().equals(other.getIetcUpdatetime()))
            && (this.getIetcUpdateuser() == null ? other.getIetcUpdateuser() == null : this.getIetcUpdateuser().equals(other.getIetcUpdateuser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIetcId() == null) ? 0 : getIetcId().hashCode());
        result = prime * result + ((getIemsId() == null) ? 0 : getIemsId().hashCode());
        result = prime * result + ((getMtcId() == null) ? 0 : getMtcId().hashCode());
        result = prime * result + ((getIetcStatus() == null) ? 0 : getIetcStatus().hashCode());
        result = prime * result + ((getIetcCreatetime() == null) ? 0 : getIetcCreatetime().hashCode());
        result = prime * result + ((getIetcCreateuser() == null) ? 0 : getIetcCreateuser().hashCode());
        result = prime * result + ((getIetcUpdatetime() == null) ? 0 : getIetcUpdatetime().hashCode());
        result = prime * result + ((getIetcUpdateuser() == null) ? 0 : getIetcUpdateuser().hashCode());
        return result;
    }
}