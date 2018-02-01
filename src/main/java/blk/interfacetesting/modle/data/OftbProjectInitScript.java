package blk.interfacetesting.modle.data;

import java.io.Serializable;

public class OftbProjectInitScript implements Serializable {
    private Integer opisId;

    private Integer mpId;

    private String opisSql;

    private String opisStatus;

    private String opisCreatetime;

    private String opisCreateuser;

    private String opisUpdatetime;

    private String opisUpdateuser;

    private static final long serialVersionUID = 1L;

    public Integer getOpisId() {
        return opisId;
    }

    public void setOpisId(Integer opisId) {
        this.opisId = opisId;
    }

    public Integer getMpId() {
        return mpId;
    }

    public void setMpId(Integer mpId) {
        this.mpId = mpId;
    }

    public String getOpisSql() {
        return opisSql;
    }

    public void setOpisSql(String opisSql) {
        this.opisSql = opisSql == null ? null : opisSql.trim();
    }

    public String getOpisStatus() {
        return opisStatus;
    }

    public void setOpisStatus(String opisStatus) {
        this.opisStatus = opisStatus == null ? null : opisStatus.trim();
    }

    public String getOpisCreatetime() {
        return opisCreatetime;
    }

    public void setOpisCreatetime(String opisCreatetime) {
        this.opisCreatetime = opisCreatetime == null ? null : opisCreatetime.trim();
    }

    public String getOpisCreateuser() {
        return opisCreateuser;
    }

    public void setOpisCreateuser(String opisCreateuser) {
        this.opisCreateuser = opisCreateuser == null ? null : opisCreateuser.trim();
    }

    public String getOpisUpdatetime() {
        return opisUpdatetime;
    }

    public void setOpisUpdatetime(String opisUpdatetime) {
        this.opisUpdatetime = opisUpdatetime == null ? null : opisUpdatetime.trim();
    }

    public String getOpisUpdateuser() {
        return opisUpdateuser;
    }

    public void setOpisUpdateuser(String opisUpdateuser) {
        this.opisUpdateuser = opisUpdateuser == null ? null : opisUpdateuser.trim();
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
        OftbProjectInitScript other = (OftbProjectInitScript) that;
        return (this.getOpisId() == null ? other.getOpisId() == null : this.getOpisId().equals(other.getOpisId()))
            && (this.getMpId() == null ? other.getMpId() == null : this.getMpId().equals(other.getMpId()))
            && (this.getOpisSql() == null ? other.getOpisSql() == null : this.getOpisSql().equals(other.getOpisSql()))
            && (this.getOpisStatus() == null ? other.getOpisStatus() == null : this.getOpisStatus().equals(other.getOpisStatus()))
            && (this.getOpisCreatetime() == null ? other.getOpisCreatetime() == null : this.getOpisCreatetime().equals(other.getOpisCreatetime()))
            && (this.getOpisCreateuser() == null ? other.getOpisCreateuser() == null : this.getOpisCreateuser().equals(other.getOpisCreateuser()))
            && (this.getOpisUpdatetime() == null ? other.getOpisUpdatetime() == null : this.getOpisUpdatetime().equals(other.getOpisUpdatetime()))
            && (this.getOpisUpdateuser() == null ? other.getOpisUpdateuser() == null : this.getOpisUpdateuser().equals(other.getOpisUpdateuser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOpisId() == null) ? 0 : getOpisId().hashCode());
        result = prime * result + ((getMpId() == null) ? 0 : getMpId().hashCode());
        result = prime * result + ((getOpisSql() == null) ? 0 : getOpisSql().hashCode());
        result = prime * result + ((getOpisStatus() == null) ? 0 : getOpisStatus().hashCode());
        result = prime * result + ((getOpisCreatetime() == null) ? 0 : getOpisCreatetime().hashCode());
        result = prime * result + ((getOpisCreateuser() == null) ? 0 : getOpisCreateuser().hashCode());
        result = prime * result + ((getOpisUpdatetime() == null) ? 0 : getOpisUpdatetime().hashCode());
        result = prime * result + ((getOpisUpdateuser() == null) ? 0 : getOpisUpdateuser().hashCode());
        return result;
    }
}