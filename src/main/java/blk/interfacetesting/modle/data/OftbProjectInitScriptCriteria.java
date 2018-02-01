package blk.interfacetesting.modle.data;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class OftbProjectInitScriptCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OftbProjectInitScriptCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOpisIdIsNull() {
            addCriterion("opis_id is null");
            return (Criteria) this;
        }

        public Criteria andOpisIdIsNotNull() {
            addCriterion("opis_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpisIdEqualTo(Integer value) {
            addCriterion("opis_id =", value, "opisId");
            return (Criteria) this;
        }

        public Criteria andOpisIdNotEqualTo(Integer value) {
            addCriterion("opis_id <>", value, "opisId");
            return (Criteria) this;
        }

        public Criteria andOpisIdGreaterThan(Integer value) {
            addCriterion("opis_id >", value, "opisId");
            return (Criteria) this;
        }

        public Criteria andOpisIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("opis_id >=", value, "opisId");
            return (Criteria) this;
        }

        public Criteria andOpisIdLessThan(Integer value) {
            addCriterion("opis_id <", value, "opisId");
            return (Criteria) this;
        }

        public Criteria andOpisIdLessThanOrEqualTo(Integer value) {
            addCriterion("opis_id <=", value, "opisId");
            return (Criteria) this;
        }

        public Criteria andOpisIdIn(List<Integer> values) {
            addCriterion("opis_id in", values, "opisId");
            return (Criteria) this;
        }

        public Criteria andOpisIdNotIn(List<Integer> values) {
            addCriterion("opis_id not in", values, "opisId");
            return (Criteria) this;
        }

        public Criteria andOpisIdBetween(Integer value1, Integer value2) {
            addCriterion("opis_id between", value1, value2, "opisId");
            return (Criteria) this;
        }

        public Criteria andOpisIdNotBetween(Integer value1, Integer value2) {
            addCriterion("opis_id not between", value1, value2, "opisId");
            return (Criteria) this;
        }

        public Criteria andMpIdIsNull() {
            addCriterion("mp_id is null");
            return (Criteria) this;
        }

        public Criteria andMpIdIsNotNull() {
            addCriterion("mp_id is not null");
            return (Criteria) this;
        }

        public Criteria andMpIdEqualTo(Integer value) {
            addCriterion("mp_id =", value, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdNotEqualTo(Integer value) {
            addCriterion("mp_id <>", value, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdGreaterThan(Integer value) {
            addCriterion("mp_id >", value, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mp_id >=", value, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdLessThan(Integer value) {
            addCriterion("mp_id <", value, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdLessThanOrEqualTo(Integer value) {
            addCriterion("mp_id <=", value, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdIn(List<Integer> values) {
            addCriterion("mp_id in", values, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdNotIn(List<Integer> values) {
            addCriterion("mp_id not in", values, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdBetween(Integer value1, Integer value2) {
            addCriterion("mp_id between", value1, value2, "mpId");
            return (Criteria) this;
        }

        public Criteria andMpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mp_id not between", value1, value2, "mpId");
            return (Criteria) this;
        }

        public Criteria andOpisSqlIsNull() {
            addCriterion("opis_sql is null");
            return (Criteria) this;
        }

        public Criteria andOpisSqlIsNotNull() {
            addCriterion("opis_sql is not null");
            return (Criteria) this;
        }

        public Criteria andOpisSqlEqualTo(String value) {
            addCriterion("opis_sql =", value, "opisSql");
            return (Criteria) this;
        }

        public Criteria andOpisSqlNotEqualTo(String value) {
            addCriterion("opis_sql <>", value, "opisSql");
            return (Criteria) this;
        }

        public Criteria andOpisSqlGreaterThan(String value) {
            addCriterion("opis_sql >", value, "opisSql");
            return (Criteria) this;
        }

        public Criteria andOpisSqlGreaterThanOrEqualTo(String value) {
            addCriterion("opis_sql >=", value, "opisSql");
            return (Criteria) this;
        }

        public Criteria andOpisSqlLessThan(String value) {
            addCriterion("opis_sql <", value, "opisSql");
            return (Criteria) this;
        }

        public Criteria andOpisSqlLessThanOrEqualTo(String value) {
            addCriterion("opis_sql <=", value, "opisSql");
            return (Criteria) this;
        }

        public Criteria andOpisSqlLike(String value) {
            addCriterion("opis_sql like", value, "opisSql");
            return (Criteria) this;
        }

        public Criteria andOpisSqlNotLike(String value) {
            addCriterion("opis_sql not like", value, "opisSql");
            return (Criteria) this;
        }

        public Criteria andOpisSqlIn(List<String> values) {
            addCriterion("opis_sql in", values, "opisSql");
            return (Criteria) this;
        }

        public Criteria andOpisSqlNotIn(List<String> values) {
            addCriterion("opis_sql not in", values, "opisSql");
            return (Criteria) this;
        }

        public Criteria andOpisSqlBetween(String value1, String value2) {
            addCriterion("opis_sql between", value1, value2, "opisSql");
            return (Criteria) this;
        }

        public Criteria andOpisSqlNotBetween(String value1, String value2) {
            addCriterion("opis_sql not between", value1, value2, "opisSql");
            return (Criteria) this;
        }

        public Criteria andOpisStatusIsNull() {
            addCriterion("opis_status is null");
            return (Criteria) this;
        }

        public Criteria andOpisStatusIsNotNull() {
            addCriterion("opis_status is not null");
            return (Criteria) this;
        }

        public Criteria andOpisStatusEqualTo(String value) {
            addCriterion("opis_status =", value, "opisStatus");
            return (Criteria) this;
        }

        public Criteria andOpisStatusNotEqualTo(String value) {
            addCriterion("opis_status <>", value, "opisStatus");
            return (Criteria) this;
        }

        public Criteria andOpisStatusGreaterThan(String value) {
            addCriterion("opis_status >", value, "opisStatus");
            return (Criteria) this;
        }

        public Criteria andOpisStatusGreaterThanOrEqualTo(String value) {
            addCriterion("opis_status >=", value, "opisStatus");
            return (Criteria) this;
        }

        public Criteria andOpisStatusLessThan(String value) {
            addCriterion("opis_status <", value, "opisStatus");
            return (Criteria) this;
        }

        public Criteria andOpisStatusLessThanOrEqualTo(String value) {
            addCriterion("opis_status <=", value, "opisStatus");
            return (Criteria) this;
        }

        public Criteria andOpisStatusLike(String value) {
            addCriterion("opis_status like", value, "opisStatus");
            return (Criteria) this;
        }

        public Criteria andOpisStatusNotLike(String value) {
            addCriterion("opis_status not like", value, "opisStatus");
            return (Criteria) this;
        }

        public Criteria andOpisStatusIn(List<String> values) {
            addCriterion("opis_status in", values, "opisStatus");
            return (Criteria) this;
        }

        public Criteria andOpisStatusNotIn(List<String> values) {
            addCriterion("opis_status not in", values, "opisStatus");
            return (Criteria) this;
        }

        public Criteria andOpisStatusBetween(String value1, String value2) {
            addCriterion("opis_status between", value1, value2, "opisStatus");
            return (Criteria) this;
        }

        public Criteria andOpisStatusNotBetween(String value1, String value2) {
            addCriterion("opis_status not between", value1, value2, "opisStatus");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeIsNull() {
            addCriterion("opis_createtime is null");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeIsNotNull() {
            addCriterion("opis_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeEqualTo(String value) {
            addCriterion("opis_createtime =", value, "opisCreatetime");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeNotEqualTo(String value) {
            addCriterion("opis_createtime <>", value, "opisCreatetime");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeGreaterThan(String value) {
            addCriterion("opis_createtime >", value, "opisCreatetime");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("opis_createtime >=", value, "opisCreatetime");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeLessThan(String value) {
            addCriterion("opis_createtime <", value, "opisCreatetime");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("opis_createtime <=", value, "opisCreatetime");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeLike(String value) {
            addCriterion("opis_createtime like", value, "opisCreatetime");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeNotLike(String value) {
            addCriterion("opis_createtime not like", value, "opisCreatetime");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeIn(List<String> values) {
            addCriterion("opis_createtime in", values, "opisCreatetime");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeNotIn(List<String> values) {
            addCriterion("opis_createtime not in", values, "opisCreatetime");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeBetween(String value1, String value2) {
            addCriterion("opis_createtime between", value1, value2, "opisCreatetime");
            return (Criteria) this;
        }

        public Criteria andOpisCreatetimeNotBetween(String value1, String value2) {
            addCriterion("opis_createtime not between", value1, value2, "opisCreatetime");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserIsNull() {
            addCriterion("opis_createuser is null");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserIsNotNull() {
            addCriterion("opis_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserEqualTo(String value) {
            addCriterion("opis_createuser =", value, "opisCreateuser");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserNotEqualTo(String value) {
            addCriterion("opis_createuser <>", value, "opisCreateuser");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserGreaterThan(String value) {
            addCriterion("opis_createuser >", value, "opisCreateuser");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("opis_createuser >=", value, "opisCreateuser");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserLessThan(String value) {
            addCriterion("opis_createuser <", value, "opisCreateuser");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserLessThanOrEqualTo(String value) {
            addCriterion("opis_createuser <=", value, "opisCreateuser");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserLike(String value) {
            addCriterion("opis_createuser like", value, "opisCreateuser");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserNotLike(String value) {
            addCriterion("opis_createuser not like", value, "opisCreateuser");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserIn(List<String> values) {
            addCriterion("opis_createuser in", values, "opisCreateuser");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserNotIn(List<String> values) {
            addCriterion("opis_createuser not in", values, "opisCreateuser");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserBetween(String value1, String value2) {
            addCriterion("opis_createuser between", value1, value2, "opisCreateuser");
            return (Criteria) this;
        }

        public Criteria andOpisCreateuserNotBetween(String value1, String value2) {
            addCriterion("opis_createuser not between", value1, value2, "opisCreateuser");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeIsNull() {
            addCriterion("opis_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeIsNotNull() {
            addCriterion("opis_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeEqualTo(String value) {
            addCriterion("opis_updatetime =", value, "opisUpdatetime");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeNotEqualTo(String value) {
            addCriterion("opis_updatetime <>", value, "opisUpdatetime");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeGreaterThan(String value) {
            addCriterion("opis_updatetime >", value, "opisUpdatetime");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("opis_updatetime >=", value, "opisUpdatetime");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeLessThan(String value) {
            addCriterion("opis_updatetime <", value, "opisUpdatetime");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("opis_updatetime <=", value, "opisUpdatetime");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeLike(String value) {
            addCriterion("opis_updatetime like", value, "opisUpdatetime");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeNotLike(String value) {
            addCriterion("opis_updatetime not like", value, "opisUpdatetime");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeIn(List<String> values) {
            addCriterion("opis_updatetime in", values, "opisUpdatetime");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeNotIn(List<String> values) {
            addCriterion("opis_updatetime not in", values, "opisUpdatetime");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeBetween(String value1, String value2) {
            addCriterion("opis_updatetime between", value1, value2, "opisUpdatetime");
            return (Criteria) this;
        }

        public Criteria andOpisUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("opis_updatetime not between", value1, value2, "opisUpdatetime");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserIsNull() {
            addCriterion("opis_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserIsNotNull() {
            addCriterion("opis_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserEqualTo(String value) {
            addCriterion("opis_updateuser =", value, "opisUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserNotEqualTo(String value) {
            addCriterion("opis_updateuser <>", value, "opisUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserGreaterThan(String value) {
            addCriterion("opis_updateuser >", value, "opisUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("opis_updateuser >=", value, "opisUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserLessThan(String value) {
            addCriterion("opis_updateuser <", value, "opisUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("opis_updateuser <=", value, "opisUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserLike(String value) {
            addCriterion("opis_updateuser like", value, "opisUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserNotLike(String value) {
            addCriterion("opis_updateuser not like", value, "opisUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserIn(List<String> values) {
            addCriterion("opis_updateuser in", values, "opisUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserNotIn(List<String> values) {
            addCriterion("opis_updateuser not in", values, "opisUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserBetween(String value1, String value2) {
            addCriterion("opis_updateuser between", value1, value2, "opisUpdateuser");
            return (Criteria) this;
        }

        public Criteria andOpisUpdateuserNotBetween(String value1, String value2) {
            addCriterion("opis_updateuser not between", value1, value2, "opisUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andOpisSqlLikeInsensitive(String value) {
            addCriterion("upper(opis_sql) like", value.toUpperCase(), "opisSql");
            return this;
        }

        public Criteria andOpisStatusLikeInsensitive(String value) {
            addCriterion("upper(opis_status) like", value.toUpperCase(), "opisStatus");
            return this;
        }

        public Criteria andOpisCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(opis_createtime) like", value.toUpperCase(), "opisCreatetime");
            return this;
        }

        public Criteria andOpisCreateuserLikeInsensitive(String value) {
            addCriterion("upper(opis_createuser) like", value.toUpperCase(), "opisCreateuser");
            return this;
        }

        public Criteria andOpisUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(opis_updatetime) like", value.toUpperCase(), "opisUpdatetime");
            return this;
        }

        public Criteria andOpisUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(opis_updateuser) like", value.toUpperCase(), "opisUpdateuser");
            return this;
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}