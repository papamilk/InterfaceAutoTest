package blk.interfacetesting.modle.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IftbURLTestCase implements Serializable {
    @Digits(integer = 11, fraction = 0, message = "{urlTestCase.iutcId.illegal}")
    @Min(value = 1, message = "{urlTestCase.iutcId.illegal}")
    private Integer iutcId;

    @Digits(integer = 11, fraction = 0, message = "{urlManagement.mumId.illegal}")
    @Min(value = 1, message = "{urlManagement.mumId.illegal}")
    private Integer mumId;

    @Digits(integer = 11, fraction = 0, message = "{testCase.mtcId.illegal}")
    @Min(value = 1, message = "{testCase.mtcId.illegal}")
    private Integer mtcId;

    private String iutcStatus;

    private String iutcCreatetime;

    private String iutcCreateuser;

    private String iutcUpdatetime;

    private String iutcUpdateuser;

    private String mtcName;

    private String mumName;

    private static final long serialVersionUID = 1L;

    public Integer getIutcId() {
        return iutcId;
    }

    public void setIutcId(Integer iutcId) {
        this.iutcId = iutcId;
    }

    public Integer getMumId() {
        return mumId;
    }

    public void setMumId(Integer mumId) {
        this.mumId = mumId;
    }

    public Integer getMtcId() {
        return mtcId;
    }

    public void setMtcId(Integer mtcId) {
        this.mtcId = mtcId;
    }

    public String getIutcStatus() {
        return iutcStatus;
    }

    public void setIutcStatus(String iutcStatus) {
        this.iutcStatus = iutcStatus == null ? null : iutcStatus.trim();
    }

    public String getIutcCreatetime() {
        return iutcCreatetime;
    }

    public void setIutcCreatetime(String iutcCreatetime) {
        this.iutcCreatetime = iutcCreatetime == null ? null : iutcCreatetime.trim();
    }

    public String getIutcCreateuser() {
        return iutcCreateuser;
    }

    public void setIutcCreateuser(String iutcCreateuser) {
        this.iutcCreateuser = iutcCreateuser == null ? null : iutcCreateuser.trim();
    }

    public String getIutcUpdatetime() {
        return iutcUpdatetime;
    }

    public void setIutcUpdatetime(String iutcUpdatetime) {
        this.iutcUpdatetime = iutcUpdatetime == null ? null : iutcUpdatetime.trim();
    }

    public String getIutcUpdateuser() {
        return iutcUpdateuser;
    }

    public void setIutcUpdateuser(String iutcUpdateuser) {
        this.iutcUpdateuser = iutcUpdateuser == null ? null : iutcUpdateuser.trim();
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
        IftbURLTestCase other = (IftbURLTestCase) that;
        return (this.getIutcId() == null ? other.getIutcId() == null : this.getIutcId().equals(other.getIutcId()))
            && (this.getMumId() == null ? other.getMumId() == null : this.getMumId().equals(other.getMumId()))
            && (this.getMtcId() == null ? other.getMtcId() == null : this.getMtcId().equals(other.getMtcId()))
            && (this.getIutcStatus() == null ? other.getIutcStatus() == null : this.getIutcStatus().equals(other.getIutcStatus()))
            && (this.getIutcCreatetime() == null ? other.getIutcCreatetime() == null : this.getIutcCreatetime().equals(other.getIutcCreatetime()))
            && (this.getIutcCreateuser() == null ? other.getIutcCreateuser() == null : this.getIutcCreateuser().equals(other.getIutcCreateuser()))
            && (this.getIutcUpdatetime() == null ? other.getIutcUpdatetime() == null : this.getIutcUpdatetime().equals(other.getIutcUpdatetime()))
            && (this.getIutcUpdateuser() == null ? other.getIutcUpdateuser() == null : this.getIutcUpdateuser().equals(other.getIutcUpdateuser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIutcId() == null) ? 0 : getIutcId().hashCode());
        result = prime * result + ((getMumId() == null) ? 0 : getMumId().hashCode());
        result = prime * result + ((getMtcId() == null) ? 0 : getMtcId().hashCode());
        result = prime * result + ((getIutcStatus() == null) ? 0 : getIutcStatus().hashCode());
        result = prime * result + ((getIutcCreatetime() == null) ? 0 : getIutcCreatetime().hashCode());
        result = prime * result + ((getIutcCreateuser() == null) ? 0 : getIutcCreateuser().hashCode());
        result = prime * result + ((getIutcUpdatetime() == null) ? 0 : getIutcUpdatetime().hashCode());
        result = prime * result + ((getIutcUpdateuser() == null) ? 0 : getIutcUpdateuser().hashCode());
        return result;
    }
}