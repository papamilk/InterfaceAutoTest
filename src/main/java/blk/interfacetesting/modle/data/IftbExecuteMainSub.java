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
public class IftbExecuteMainSub implements Serializable {
    private Integer iemsId;

    private Integer iemId;

    private Integer mumId;

    private Double iemsOrder;

    private String iemsStatus;

    private String iemsCreatetime;

    private String iemsCreateuser;

    private String iemsUpdatetime;

    private String iemsUpdateuser;

    private String iemName;

    private static final long serialVersionUID = 1L;

    public Integer getIemsId() {
        return iemsId;
    }

    public void setIemsId(Integer iemsId) {
        this.iemsId = iemsId;
    }

    public Integer getIemId() {
        return iemId;
    }

    public void setIemId(Integer iemId) {
        this.iemId = iemId;
    }

    public Integer getMumId() {
        return mumId;
    }

    public void setMumId(Integer mumId) {
        this.mumId = mumId;
    }

    public Double getIemsOrder() {
        return iemsOrder;
    }

    public void setIemsOrder(Double iemsOrder) {
        this.iemsOrder = iemsOrder;
    }

    public String getIemsStatus() {
        return iemsStatus;
    }

    public void setIemsStatus(String iemsStatus) {
        this.iemsStatus = iemsStatus == null ? null : iemsStatus.trim();
    }

    public String getIemsCreatetime() {
        return iemsCreatetime;
    }

    public void setIemsCreatetime(String iemsCreatetime) {
        this.iemsCreatetime = iemsCreatetime == null ? null : iemsCreatetime.trim();
    }

    public String getIemsCreateuser() {
        return iemsCreateuser;
    }

    public void setIemsCreateuser(String iemsCreateuser) {
        this.iemsCreateuser = iemsCreateuser == null ? null : iemsCreateuser.trim();
    }

    public String getIemsUpdatetime() {
        return iemsUpdatetime;
    }

    public void setIemsUpdatetime(String iemsUpdatetime) {
        this.iemsUpdatetime = iemsUpdatetime == null ? null : iemsUpdatetime.trim();
    }

    public String getIemsUpdateuser() {
        return iemsUpdateuser;
    }

    public void setIemsUpdateuser(String iemsUpdateuser) {
        this.iemsUpdateuser = iemsUpdateuser == null ? null : iemsUpdateuser.trim();
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
        IftbExecuteMainSub other = (IftbExecuteMainSub) that;
        return (this.getIemsId() == null ? other.getIemsId() == null : this.getIemsId().equals(other.getIemsId()))
            && (this.getIemId() == null ? other.getIemId() == null : this.getIemId().equals(other.getIemId()))
            && (this.getMumId() == null ? other.getMumId() == null : this.getMumId().equals(other.getMumId()))
            && (this.getIemsOrder() == null ? other.getIemsOrder() == null : this.getIemsOrder().equals(other.getIemsOrder()))
            && (this.getIemsStatus() == null ? other.getIemsStatus() == null : this.getIemsStatus().equals(other.getIemsStatus()))
            && (this.getIemsCreatetime() == null ? other.getIemsCreatetime() == null : this.getIemsCreatetime().equals(other.getIemsCreatetime()))
            && (this.getIemsCreateuser() == null ? other.getIemsCreateuser() == null : this.getIemsCreateuser().equals(other.getIemsCreateuser()))
            && (this.getIemsUpdatetime() == null ? other.getIemsUpdatetime() == null : this.getIemsUpdatetime().equals(other.getIemsUpdatetime()))
            && (this.getIemsUpdateuser() == null ? other.getIemsUpdateuser() == null : this.getIemsUpdateuser().equals(other.getIemsUpdateuser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIemsId() == null) ? 0 : getIemsId().hashCode());
        result = prime * result + ((getIemId() == null) ? 0 : getIemId().hashCode());
        result = prime * result + ((getMumId() == null) ? 0 : getMumId().hashCode());
        result = prime * result + ((getIemsOrder() == null) ? 0 : getIemsOrder().hashCode());
        result = prime * result + ((getIemsStatus() == null) ? 0 : getIemsStatus().hashCode());
        result = prime * result + ((getIemsCreatetime() == null) ? 0 : getIemsCreatetime().hashCode());
        result = prime * result + ((getIemsCreateuser() == null) ? 0 : getIemsCreateuser().hashCode());
        result = prime * result + ((getIemsUpdatetime() == null) ? 0 : getIemsUpdatetime().hashCode());
        result = prime * result + ((getIemsUpdateuser() == null) ? 0 : getIemsUpdateuser().hashCode());
        return result;
    }
}