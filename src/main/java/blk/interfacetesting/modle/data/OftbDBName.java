package blk.interfacetesting.modle.data;

import java.io.Serializable;

public class OftbDBName implements Serializable {
    private Integer odId;

    private String dbName;

    private static final long serialVersionUID = 1L;

    public Integer getOdId() {
        return odId;
    }

    public void setOdId(Integer odId) {
        this.odId = odId;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName == null ? null : dbName.trim();
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
        OftbDBName other = (OftbDBName) that;
        return (this.getOdId() == null ? other.getOdId() == null : this.getOdId().equals(other.getOdId()))
            && (this.getDbName() == null ? other.getDbName() == null : this.getDbName().equals(other.getDbName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOdId() == null) ? 0 : getOdId().hashCode());
        result = prime * result + ((getDbName() == null) ? 0 : getDbName().hashCode());
        return result;
    }
}