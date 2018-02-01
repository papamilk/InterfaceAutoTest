package blk.interfacetesting.modle.data;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class IftbExecuteTestCaseCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public IftbExecuteTestCaseCriteria() {
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

        public Criteria andIetcIdIsNull() {
            addCriterion("ietc_id is null");
            return (Criteria) this;
        }

        public Criteria andIetcIdIsNotNull() {
            addCriterion("ietc_id is not null");
            return (Criteria) this;
        }

        public Criteria andIetcIdEqualTo(Integer value) {
            addCriterion("ietc_id =", value, "ietcId");
            return (Criteria) this;
        }

        public Criteria andIetcIdNotEqualTo(Integer value) {
            addCriterion("ietc_id <>", value, "ietcId");
            return (Criteria) this;
        }

        public Criteria andIetcIdGreaterThan(Integer value) {
            addCriterion("ietc_id >", value, "ietcId");
            return (Criteria) this;
        }

        public Criteria andIetcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ietc_id >=", value, "ietcId");
            return (Criteria) this;
        }

        public Criteria andIetcIdLessThan(Integer value) {
            addCriterion("ietc_id <", value, "ietcId");
            return (Criteria) this;
        }

        public Criteria andIetcIdLessThanOrEqualTo(Integer value) {
            addCriterion("ietc_id <=", value, "ietcId");
            return (Criteria) this;
        }

        public Criteria andIetcIdIn(List<Integer> values) {
            addCriterion("ietc_id in", values, "ietcId");
            return (Criteria) this;
        }

        public Criteria andIetcIdNotIn(List<Integer> values) {
            addCriterion("ietc_id not in", values, "ietcId");
            return (Criteria) this;
        }

        public Criteria andIetcIdBetween(Integer value1, Integer value2) {
            addCriterion("ietc_id between", value1, value2, "ietcId");
            return (Criteria) this;
        }

        public Criteria andIetcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ietc_id not between", value1, value2, "ietcId");
            return (Criteria) this;
        }

        public Criteria andIemsIdIsNull() {
            addCriterion("iems_id is null");
            return (Criteria) this;
        }

        public Criteria andIemsIdIsNotNull() {
            addCriterion("iems_id is not null");
            return (Criteria) this;
        }

        public Criteria andIemsIdEqualTo(Integer value) {
            addCriterion("iems_id =", value, "iemsId");
            return (Criteria) this;
        }

        public Criteria andIemsIdNotEqualTo(Integer value) {
            addCriterion("iems_id <>", value, "iemsId");
            return (Criteria) this;
        }

        public Criteria andIemsIdGreaterThan(Integer value) {
            addCriterion("iems_id >", value, "iemsId");
            return (Criteria) this;
        }

        public Criteria andIemsIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("iems_id >=", value, "iemsId");
            return (Criteria) this;
        }

        public Criteria andIemsIdLessThan(Integer value) {
            addCriterion("iems_id <", value, "iemsId");
            return (Criteria) this;
        }

        public Criteria andIemsIdLessThanOrEqualTo(Integer value) {
            addCriterion("iems_id <=", value, "iemsId");
            return (Criteria) this;
        }

        public Criteria andIemsIdIn(List<Integer> values) {
            addCriterion("iems_id in", values, "iemsId");
            return (Criteria) this;
        }

        public Criteria andIemsIdNotIn(List<Integer> values) {
            addCriterion("iems_id not in", values, "iemsId");
            return (Criteria) this;
        }

        public Criteria andIemsIdBetween(Integer value1, Integer value2) {
            addCriterion("iems_id between", value1, value2, "iemsId");
            return (Criteria) this;
        }

        public Criteria andIemsIdNotBetween(Integer value1, Integer value2) {
            addCriterion("iems_id not between", value1, value2, "iemsId");
            return (Criteria) this;
        }

        public Criteria andMtcIdIsNull() {
            addCriterion("mtc_id is null");
            return (Criteria) this;
        }

        public Criteria andMtcIdIsNotNull() {
            addCriterion("mtc_id is not null");
            return (Criteria) this;
        }

        public Criteria andMtcIdEqualTo(Integer value) {
            addCriterion("mtc_id =", value, "mtcId");
            return (Criteria) this;
        }

        public Criteria andMtcIdNotEqualTo(Integer value) {
            addCriterion("mtc_id <>", value, "mtcId");
            return (Criteria) this;
        }

        public Criteria andMtcIdGreaterThan(Integer value) {
            addCriterion("mtc_id >", value, "mtcId");
            return (Criteria) this;
        }

        public Criteria andMtcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mtc_id >=", value, "mtcId");
            return (Criteria) this;
        }

        public Criteria andMtcIdLessThan(Integer value) {
            addCriterion("mtc_id <", value, "mtcId");
            return (Criteria) this;
        }

        public Criteria andMtcIdLessThanOrEqualTo(Integer value) {
            addCriterion("mtc_id <=", value, "mtcId");
            return (Criteria) this;
        }

        public Criteria andMtcIdIn(List<Integer> values) {
            addCriterion("mtc_id in", values, "mtcId");
            return (Criteria) this;
        }

        public Criteria andMtcIdNotIn(List<Integer> values) {
            addCriterion("mtc_id not in", values, "mtcId");
            return (Criteria) this;
        }

        public Criteria andMtcIdBetween(Integer value1, Integer value2) {
            addCriterion("mtc_id between", value1, value2, "mtcId");
            return (Criteria) this;
        }

        public Criteria andMtcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mtc_id not between", value1, value2, "mtcId");
            return (Criteria) this;
        }

        public Criteria andIetcStatusIsNull() {
            addCriterion("ietc_status is null");
            return (Criteria) this;
        }

        public Criteria andIetcStatusIsNotNull() {
            addCriterion("ietc_status is not null");
            return (Criteria) this;
        }

        public Criteria andIetcStatusEqualTo(String value) {
            addCriterion("ietc_status =", value, "ietcStatus");
            return (Criteria) this;
        }

        public Criteria andIetcStatusNotEqualTo(String value) {
            addCriterion("ietc_status <>", value, "ietcStatus");
            return (Criteria) this;
        }

        public Criteria andIetcStatusGreaterThan(String value) {
            addCriterion("ietc_status >", value, "ietcStatus");
            return (Criteria) this;
        }

        public Criteria andIetcStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ietc_status >=", value, "ietcStatus");
            return (Criteria) this;
        }

        public Criteria andIetcStatusLessThan(String value) {
            addCriterion("ietc_status <", value, "ietcStatus");
            return (Criteria) this;
        }

        public Criteria andIetcStatusLessThanOrEqualTo(String value) {
            addCriterion("ietc_status <=", value, "ietcStatus");
            return (Criteria) this;
        }

        public Criteria andIetcStatusLike(String value) {
            addCriterion("ietc_status like", value, "ietcStatus");
            return (Criteria) this;
        }

        public Criteria andIetcStatusNotLike(String value) {
            addCriterion("ietc_status not like", value, "ietcStatus");
            return (Criteria) this;
        }

        public Criteria andIetcStatusIn(List<String> values) {
            addCriterion("ietc_status in", values, "ietcStatus");
            return (Criteria) this;
        }

        public Criteria andIetcStatusNotIn(List<String> values) {
            addCriterion("ietc_status not in", values, "ietcStatus");
            return (Criteria) this;
        }

        public Criteria andIetcStatusBetween(String value1, String value2) {
            addCriterion("ietc_status between", value1, value2, "ietcStatus");
            return (Criteria) this;
        }

        public Criteria andIetcStatusNotBetween(String value1, String value2) {
            addCriterion("ietc_status not between", value1, value2, "ietcStatus");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeIsNull() {
            addCriterion("ietc_createtime is null");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeIsNotNull() {
            addCriterion("ietc_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeEqualTo(String value) {
            addCriterion("ietc_createtime =", value, "ietcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeNotEqualTo(String value) {
            addCriterion("ietc_createtime <>", value, "ietcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeGreaterThan(String value) {
            addCriterion("ietc_createtime >", value, "ietcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("ietc_createtime >=", value, "ietcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeLessThan(String value) {
            addCriterion("ietc_createtime <", value, "ietcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("ietc_createtime <=", value, "ietcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeLike(String value) {
            addCriterion("ietc_createtime like", value, "ietcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeNotLike(String value) {
            addCriterion("ietc_createtime not like", value, "ietcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeIn(List<String> values) {
            addCriterion("ietc_createtime in", values, "ietcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeNotIn(List<String> values) {
            addCriterion("ietc_createtime not in", values, "ietcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeBetween(String value1, String value2) {
            addCriterion("ietc_createtime between", value1, value2, "ietcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIetcCreatetimeNotBetween(String value1, String value2) {
            addCriterion("ietc_createtime not between", value1, value2, "ietcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserIsNull() {
            addCriterion("ietc_createuser is null");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserIsNotNull() {
            addCriterion("ietc_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserEqualTo(String value) {
            addCriterion("ietc_createuser =", value, "ietcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserNotEqualTo(String value) {
            addCriterion("ietc_createuser <>", value, "ietcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserGreaterThan(String value) {
            addCriterion("ietc_createuser >", value, "ietcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("ietc_createuser >=", value, "ietcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserLessThan(String value) {
            addCriterion("ietc_createuser <", value, "ietcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserLessThanOrEqualTo(String value) {
            addCriterion("ietc_createuser <=", value, "ietcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserLike(String value) {
            addCriterion("ietc_createuser like", value, "ietcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserNotLike(String value) {
            addCriterion("ietc_createuser not like", value, "ietcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserIn(List<String> values) {
            addCriterion("ietc_createuser in", values, "ietcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserNotIn(List<String> values) {
            addCriterion("ietc_createuser not in", values, "ietcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserBetween(String value1, String value2) {
            addCriterion("ietc_createuser between", value1, value2, "ietcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIetcCreateuserNotBetween(String value1, String value2) {
            addCriterion("ietc_createuser not between", value1, value2, "ietcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeIsNull() {
            addCriterion("ietc_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeIsNotNull() {
            addCriterion("ietc_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeEqualTo(String value) {
            addCriterion("ietc_updatetime =", value, "ietcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeNotEqualTo(String value) {
            addCriterion("ietc_updatetime <>", value, "ietcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeGreaterThan(String value) {
            addCriterion("ietc_updatetime >", value, "ietcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("ietc_updatetime >=", value, "ietcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeLessThan(String value) {
            addCriterion("ietc_updatetime <", value, "ietcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("ietc_updatetime <=", value, "ietcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeLike(String value) {
            addCriterion("ietc_updatetime like", value, "ietcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeNotLike(String value) {
            addCriterion("ietc_updatetime not like", value, "ietcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeIn(List<String> values) {
            addCriterion("ietc_updatetime in", values, "ietcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeNotIn(List<String> values) {
            addCriterion("ietc_updatetime not in", values, "ietcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeBetween(String value1, String value2) {
            addCriterion("ietc_updatetime between", value1, value2, "ietcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIetcUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("ietc_updatetime not between", value1, value2, "ietcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserIsNull() {
            addCriterion("ietc_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserIsNotNull() {
            addCriterion("ietc_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserEqualTo(String value) {
            addCriterion("ietc_updateuser =", value, "ietcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserNotEqualTo(String value) {
            addCriterion("ietc_updateuser <>", value, "ietcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserGreaterThan(String value) {
            addCriterion("ietc_updateuser >", value, "ietcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("ietc_updateuser >=", value, "ietcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserLessThan(String value) {
            addCriterion("ietc_updateuser <", value, "ietcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("ietc_updateuser <=", value, "ietcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserLike(String value) {
            addCriterion("ietc_updateuser like", value, "ietcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserNotLike(String value) {
            addCriterion("ietc_updateuser not like", value, "ietcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserIn(List<String> values) {
            addCriterion("ietc_updateuser in", values, "ietcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserNotIn(List<String> values) {
            addCriterion("ietc_updateuser not in", values, "ietcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserBetween(String value1, String value2) {
            addCriterion("ietc_updateuser between", value1, value2, "ietcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIetcUpdateuserNotBetween(String value1, String value2) {
            addCriterion("ietc_updateuser not between", value1, value2, "ietcUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andIetcStatusLikeInsensitive(String value) {
            addCriterion("upper(ietc_status) like", value.toUpperCase(), "ietcStatus");
            return this;
        }

        public Criteria andIetcCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(ietc_createtime) like", value.toUpperCase(), "ietcCreatetime");
            return this;
        }

        public Criteria andIetcCreateuserLikeInsensitive(String value) {
            addCriterion("upper(ietc_createuser) like", value.toUpperCase(), "ietcCreateuser");
            return this;
        }

        public Criteria andIetcUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(ietc_updatetime) like", value.toUpperCase(), "ietcUpdatetime");
            return this;
        }

        public Criteria andIetcUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(ietc_updateuser) like", value.toUpperCase(), "ietcUpdateuser");
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