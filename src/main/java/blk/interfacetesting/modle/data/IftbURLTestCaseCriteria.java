package blk.interfacetesting.modle.data;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class IftbURLTestCaseCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * merged search for mtcName and mumName
     */
    protected boolean mergedSearch;

    public boolean isMergedSearch() {
        return mergedSearch;
    }

    public void setMergedSearch(boolean mergedSearch) {
        this.mergedSearch = mergedSearch;
    }

    protected Page page;

    public IftbURLTestCaseCriteria() {
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

        public Criteria andIutcIdIsNull() {
            addCriterion("iutc_id is null");
            return (Criteria) this;
        }

        public Criteria andIutcIdIsNotNull() {
            addCriterion("iutc_id is not null");
            return (Criteria) this;
        }

        public Criteria andIutcIdEqualTo(Integer value) {
            addCriterion("iutc_id =", value, "iutcId");
            return (Criteria) this;
        }

        public Criteria andIutcIdNotEqualTo(Integer value) {
            addCriterion("iutc_id <>", value, "iutcId");
            return (Criteria) this;
        }

        public Criteria andIutcIdGreaterThan(Integer value) {
            addCriterion("iutc_id >", value, "iutcId");
            return (Criteria) this;
        }

        public Criteria andIutcIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("iutc_id >=", value, "iutcId");
            return (Criteria) this;
        }

        public Criteria andIutcIdLessThan(Integer value) {
            addCriterion("iutc_id <", value, "iutcId");
            return (Criteria) this;
        }

        public Criteria andIutcIdLessThanOrEqualTo(Integer value) {
            addCriterion("iutc_id <=", value, "iutcId");
            return (Criteria) this;
        }

        public Criteria andIutcIdIn(List<Integer> values) {
            addCriterion("iutc_id in", values, "iutcId");
            return (Criteria) this;
        }

        public Criteria andIutcIdNotIn(List<Integer> values) {
            addCriterion("iutc_id not in", values, "iutcId");
            return (Criteria) this;
        }

        public Criteria andIutcIdBetween(Integer value1, Integer value2) {
            addCriterion("iutc_id between", value1, value2, "iutcId");
            return (Criteria) this;
        }

        public Criteria andIutcIdNotBetween(Integer value1, Integer value2) {
            addCriterion("iutc_id not between", value1, value2, "iutcId");
            return (Criteria) this;
        }

        public Criteria andMumIdIsNull() {
            addCriterion("mum_id is null");
            return (Criteria) this;
        }

        public Criteria andMumIdIsNotNull() {
            addCriterion("mum_id is not null");
            return (Criteria) this;
        }

        public Criteria andMumIdEqualTo(Integer value) {
            addCriterion("mum_id =", value, "mumId");
            return (Criteria) this;
        }

        public Criteria andMumIdNotEqualTo(Integer value) {
            addCriterion("mum_id <>", value, "mumId");
            return (Criteria) this;
        }

        public Criteria andMumIdGreaterThan(Integer value) {
            addCriterion("mum_id >", value, "mumId");
            return (Criteria) this;
        }

        public Criteria andMumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mum_id >=", value, "mumId");
            return (Criteria) this;
        }

        public Criteria andMumIdLessThan(Integer value) {
            addCriterion("mum_id <", value, "mumId");
            return (Criteria) this;
        }

        public Criteria andMumIdLessThanOrEqualTo(Integer value) {
            addCriterion("mum_id <=", value, "mumId");
            return (Criteria) this;
        }

        public Criteria andMumIdIn(List<Integer> values) {
            addCriterion("mum_id in", values, "mumId");
            return (Criteria) this;
        }

        public Criteria andMumIdNotIn(List<Integer> values) {
            addCriterion("mum_id not in", values, "mumId");
            return (Criteria) this;
        }

        public Criteria andMumIdBetween(Integer value1, Integer value2) {
            addCriterion("mum_id between", value1, value2, "mumId");
            return (Criteria) this;
        }

        public Criteria andMumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mum_id not between", value1, value2, "mumId");
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

        public Criteria andIutcStatusIsNull() {
            addCriterion("iutc_status is null");
            return (Criteria) this;
        }

        public Criteria andIutcStatusIsNotNull() {
            addCriterion("iutc_status is not null");
            return (Criteria) this;
        }

        public Criteria andIutcStatusEqualTo(String value) {
            addCriterion("iutc_status =", value, "iutcStatus");
            return (Criteria) this;
        }

        public Criteria andIutcStatusNotEqualTo(String value) {
            addCriterion("iutc_status <>", value, "iutcStatus");
            return (Criteria) this;
        }

        public Criteria andIutcStatusGreaterThan(String value) {
            addCriterion("iutc_status >", value, "iutcStatus");
            return (Criteria) this;
        }

        public Criteria andIutcStatusGreaterThanOrEqualTo(String value) {
            addCriterion("iutc_status >=", value, "iutcStatus");
            return (Criteria) this;
        }

        public Criteria andIutcStatusLessThan(String value) {
            addCriterion("iutc_status <", value, "iutcStatus");
            return (Criteria) this;
        }

        public Criteria andIutcStatusLessThanOrEqualTo(String value) {
            addCriterion("iutc_status <=", value, "iutcStatus");
            return (Criteria) this;
        }

        public Criteria andIutcStatusLike(String value) {
            addCriterion("iutc_status like", value, "iutcStatus");
            return (Criteria) this;
        }

        public Criteria andIutcStatusNotLike(String value) {
            addCriterion("iutc_status not like", value, "iutcStatus");
            return (Criteria) this;
        }

        public Criteria andIutcStatusIn(List<String> values) {
            addCriterion("iutc_status in", values, "iutcStatus");
            return (Criteria) this;
        }

        public Criteria andIutcStatusNotIn(List<String> values) {
            addCriterion("iutc_status not in", values, "iutcStatus");
            return (Criteria) this;
        }

        public Criteria andIutcStatusBetween(String value1, String value2) {
            addCriterion("iutc_status between", value1, value2, "iutcStatus");
            return (Criteria) this;
        }

        public Criteria andIutcStatusNotBetween(String value1, String value2) {
            addCriterion("iutc_status not between", value1, value2, "iutcStatus");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeIsNull() {
            addCriterion("iutc_createtime is null");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeIsNotNull() {
            addCriterion("iutc_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeEqualTo(String value) {
            addCriterion("iutc_createtime =", value, "iutcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeNotEqualTo(String value) {
            addCriterion("iutc_createtime <>", value, "iutcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeGreaterThan(String value) {
            addCriterion("iutc_createtime >", value, "iutcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("iutc_createtime >=", value, "iutcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeLessThan(String value) {
            addCriterion("iutc_createtime <", value, "iutcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("iutc_createtime <=", value, "iutcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeLike(String value) {
            addCriterion("iutc_createtime like", value, "iutcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeNotLike(String value) {
            addCriterion("iutc_createtime not like", value, "iutcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeIn(List<String> values) {
            addCriterion("iutc_createtime in", values, "iutcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeNotIn(List<String> values) {
            addCriterion("iutc_createtime not in", values, "iutcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeBetween(String value1, String value2) {
            addCriterion("iutc_createtime between", value1, value2, "iutcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIutcCreatetimeNotBetween(String value1, String value2) {
            addCriterion("iutc_createtime not between", value1, value2, "iutcCreatetime");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserIsNull() {
            addCriterion("iutc_createuser is null");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserIsNotNull() {
            addCriterion("iutc_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserEqualTo(String value) {
            addCriterion("iutc_createuser =", value, "iutcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserNotEqualTo(String value) {
            addCriterion("iutc_createuser <>", value, "iutcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserGreaterThan(String value) {
            addCriterion("iutc_createuser >", value, "iutcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("iutc_createuser >=", value, "iutcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserLessThan(String value) {
            addCriterion("iutc_createuser <", value, "iutcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserLessThanOrEqualTo(String value) {
            addCriterion("iutc_createuser <=", value, "iutcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserLike(String value) {
            addCriterion("iutc_createuser like", value, "iutcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserNotLike(String value) {
            addCriterion("iutc_createuser not like", value, "iutcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserIn(List<String> values) {
            addCriterion("iutc_createuser in", values, "iutcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserNotIn(List<String> values) {
            addCriterion("iutc_createuser not in", values, "iutcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserBetween(String value1, String value2) {
            addCriterion("iutc_createuser between", value1, value2, "iutcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIutcCreateuserNotBetween(String value1, String value2) {
            addCriterion("iutc_createuser not between", value1, value2, "iutcCreateuser");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeIsNull() {
            addCriterion("iutc_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeIsNotNull() {
            addCriterion("iutc_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeEqualTo(String value) {
            addCriterion("iutc_updatetime =", value, "iutcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeNotEqualTo(String value) {
            addCriterion("iutc_updatetime <>", value, "iutcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeGreaterThan(String value) {
            addCriterion("iutc_updatetime >", value, "iutcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("iutc_updatetime >=", value, "iutcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeLessThan(String value) {
            addCriterion("iutc_updatetime <", value, "iutcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("iutc_updatetime <=", value, "iutcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeLike(String value) {
            addCriterion("iutc_updatetime like", value, "iutcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeNotLike(String value) {
            addCriterion("iutc_updatetime not like", value, "iutcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeIn(List<String> values) {
            addCriterion("iutc_updatetime in", values, "iutcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeNotIn(List<String> values) {
            addCriterion("iutc_updatetime not in", values, "iutcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeBetween(String value1, String value2) {
            addCriterion("iutc_updatetime between", value1, value2, "iutcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIutcUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("iutc_updatetime not between", value1, value2, "iutcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserIsNull() {
            addCriterion("iutc_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserIsNotNull() {
            addCriterion("iutc_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserEqualTo(String value) {
            addCriterion("iutc_updateuser =", value, "iutcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserNotEqualTo(String value) {
            addCriterion("iutc_updateuser <>", value, "iutcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserGreaterThan(String value) {
            addCriterion("iutc_updateuser >", value, "iutcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("iutc_updateuser >=", value, "iutcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserLessThan(String value) {
            addCriterion("iutc_updateuser <", value, "iutcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("iutc_updateuser <=", value, "iutcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserLike(String value) {
            addCriterion("iutc_updateuser like", value, "iutcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserNotLike(String value) {
            addCriterion("iutc_updateuser not like", value, "iutcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserIn(List<String> values) {
            addCriterion("iutc_updateuser in", values, "iutcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserNotIn(List<String> values) {
            addCriterion("iutc_updateuser not in", values, "iutcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserBetween(String value1, String value2) {
            addCriterion("iutc_updateuser between", value1, value2, "iutcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIutcUpdateuserNotBetween(String value1, String value2) {
            addCriterion("iutc_updateuser not between", value1, value2, "iutcUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andIutcStatusLikeInsensitive(String value) {
            addCriterion("upper(iutc_status) like", value.toUpperCase(), "iutcStatus");
            return this;
        }

        public Criteria andIutcCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(iutc_createtime) like", value.toUpperCase(), "iutcCreatetime");
            return this;
        }

        public Criteria andIutcCreateuserLikeInsensitive(String value) {
            addCriterion("upper(iutc_createuser) like", value.toUpperCase(), "iutcCreateuser");
            return this;
        }

        public Criteria andIutcUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(iutc_updatetime) like", value.toUpperCase(), "iutcUpdatetime");
            return this;
        }

        public Criteria andIutcUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(iutc_updateuser) like", value.toUpperCase(), "iutcUpdateuser");
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