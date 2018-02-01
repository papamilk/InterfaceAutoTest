package blk.interfacetesting.modle.data;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class MstbTestCaseCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public MstbTestCaseCriteria() {
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

        public Criteria andStopTimeIsNull() {
            addCriterion("stop_time is null");
            return (Criteria) this;
        }

        public Criteria andStopTimeIsNotNull() {
            addCriterion("stop_time is not null");
            return (Criteria) this;
        }

        public Criteria andStopTimeEqualTo(Integer value) {
            addCriterion("stop_time =", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotEqualTo(Integer value) {
            addCriterion("stop_time <>", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThan(Integer value) {
            addCriterion("stop_time >", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("stop_time >=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThan(Integer value) {
            addCriterion("stop_time <", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeLessThanOrEqualTo(Integer value) {
            addCriterion("stop_time <=", value, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeIn(List<Integer> values) {
            addCriterion("stop_time in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotIn(List<Integer> values) {
            addCriterion("stop_time not in", values, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeBetween(Integer value1, Integer value2) {
            addCriterion("stop_time between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andStopTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("stop_time not between", value1, value2, "stopTime");
            return (Criteria) this;
        }

        public Criteria andMtcNumberIsNull() {
            addCriterion("mtc_number is null");
            return (Criteria) this;
        }

        public Criteria andMtcNumberIsNotNull() {
            addCriterion("mtc_number is not null");
            return (Criteria) this;
        }

        public Criteria andMtcNumberEqualTo(String value) {
            addCriterion("mtc_number =", value, "mtcNumber");
            return (Criteria) this;
        }

        public Criteria andMtcNumberNotEqualTo(String value) {
            addCriterion("mtc_number <>", value, "mtcNumber");
            return (Criteria) this;
        }

        public Criteria andMtcNumberGreaterThan(String value) {
            addCriterion("mtc_number >", value, "mtcNumber");
            return (Criteria) this;
        }

        public Criteria andMtcNumberGreaterThanOrEqualTo(String value) {
            addCriterion("mtc_number >=", value, "mtcNumber");
            return (Criteria) this;
        }

        public Criteria andMtcNumberLessThan(String value) {
            addCriterion("mtc_number <", value, "mtcNumber");
            return (Criteria) this;
        }

        public Criteria andMtcNumberLessThanOrEqualTo(String value) {
            addCriterion("mtc_number <=", value, "mtcNumber");
            return (Criteria) this;
        }

        public Criteria andMtcNumberLike(String value) {
            addCriterion("mtc_number like", value, "mtcNumber");
            return (Criteria) this;
        }

        public Criteria andMtcNumberNotLike(String value) {
            addCriterion("mtc_number not like", value, "mtcNumber");
            return (Criteria) this;
        }

        public Criteria andMtcNumberIn(List<String> values) {
            addCriterion("mtc_number in", values, "mtcNumber");
            return (Criteria) this;
        }

        public Criteria andMtcNumberNotIn(List<String> values) {
            addCriterion("mtc_number not in", values, "mtcNumber");
            return (Criteria) this;
        }

        public Criteria andMtcNumberBetween(String value1, String value2) {
            addCriterion("mtc_number between", value1, value2, "mtcNumber");
            return (Criteria) this;
        }

        public Criteria andMtcNumberNotBetween(String value1, String value2) {
            addCriterion("mtc_number not between", value1, value2, "mtcNumber");
            return (Criteria) this;
        }

        public Criteria andMtcNameIsNull() {
            addCriterion("mtc_name is null");
            return (Criteria) this;
        }

        public Criteria andMtcNameIsNotNull() {
            addCriterion("mtc_name is not null");
            return (Criteria) this;
        }

        public Criteria andMtcNameEqualTo(String value) {
            addCriterion("mtc_name =", value, "mtcName");
            return (Criteria) this;
        }

        public Criteria andMtcNameNotEqualTo(String value) {
            addCriterion("mtc_name <>", value, "mtcName");
            return (Criteria) this;
        }

        public Criteria andMtcNameGreaterThan(String value) {
            addCriterion("mtc_name >", value, "mtcName");
            return (Criteria) this;
        }

        public Criteria andMtcNameGreaterThanOrEqualTo(String value) {
            addCriterion("mtc_name >=", value, "mtcName");
            return (Criteria) this;
        }

        public Criteria andMtcNameLessThan(String value) {
            addCriterion("mtc_name <", value, "mtcName");
            return (Criteria) this;
        }

        public Criteria andMtcNameLessThanOrEqualTo(String value) {
            addCriterion("mtc_name <=", value, "mtcName");
            return (Criteria) this;
        }

        public Criteria andMtcNameLike(String value) {
            addCriterion("mtc_name like", value, "mtcName");
            return (Criteria) this;
        }

        public Criteria andMtcNameNotLike(String value) {
            addCriterion("mtc_name not like", value, "mtcName");
            return (Criteria) this;
        }

        public Criteria andMtcNameIn(List<String> values) {
            addCriterion("mtc_name in", values, "mtcName");
            return (Criteria) this;
        }

        public Criteria andMtcNameNotIn(List<String> values) {
            addCriterion("mtc_name not in", values, "mtcName");
            return (Criteria) this;
        }

        public Criteria andMtcNameBetween(String value1, String value2) {
            addCriterion("mtc_name between", value1, value2, "mtcName");
            return (Criteria) this;
        }

        public Criteria andMtcNameNotBetween(String value1, String value2) {
            addCriterion("mtc_name not between", value1, value2, "mtcName");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyIsNull() {
            addCriterion("mtc_dependency is null");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyIsNotNull() {
            addCriterion("mtc_dependency is not null");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyEqualTo(String value) {
            addCriterion("mtc_dependency =", value, "mtcDependency");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyNotEqualTo(String value) {
            addCriterion("mtc_dependency <>", value, "mtcDependency");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyGreaterThan(String value) {
            addCriterion("mtc_dependency >", value, "mtcDependency");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyGreaterThanOrEqualTo(String value) {
            addCriterion("mtc_dependency >=", value, "mtcDependency");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyLessThan(String value) {
            addCriterion("mtc_dependency <", value, "mtcDependency");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyLessThanOrEqualTo(String value) {
            addCriterion("mtc_dependency <=", value, "mtcDependency");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyLike(String value) {
            addCriterion("mtc_dependency like", value, "mtcDependency");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyNotLike(String value) {
            addCriterion("mtc_dependency not like", value, "mtcDependency");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyIn(List<String> values) {
            addCriterion("mtc_dependency in", values, "mtcDependency");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyNotIn(List<String> values) {
            addCriterion("mtc_dependency not in", values, "mtcDependency");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyBetween(String value1, String value2) {
            addCriterion("mtc_dependency between", value1, value2, "mtcDependency");
            return (Criteria) this;
        }

        public Criteria andMtcDependencyNotBetween(String value1, String value2) {
            addCriterion("mtc_dependency not between", value1, value2, "mtcDependency");
            return (Criteria) this;
        }

        public Criteria andMtcTypeIsNull() {
            addCriterion("mtc_type is null");
            return (Criteria) this;
        }

        public Criteria andMtcTypeIsNotNull() {
            addCriterion("mtc_type is not null");
            return (Criteria) this;
        }

        public Criteria andMtcTypeEqualTo(Integer value) {
            addCriterion("mtc_type =", value, "mtcType");
            return (Criteria) this;
        }

        public Criteria andMtcTypeNotEqualTo(Integer value) {
            addCriterion("mtc_type <>", value, "mtcType");
            return (Criteria) this;
        }

        public Criteria andMtcTypeGreaterThan(Integer value) {
            addCriterion("mtc_type >", value, "mtcType");
            return (Criteria) this;
        }

        public Criteria andMtcTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("mtc_type >=", value, "mtcType");
            return (Criteria) this;
        }

        public Criteria andMtcTypeLessThan(Integer value) {
            addCriterion("mtc_type <", value, "mtcType");
            return (Criteria) this;
        }

        public Criteria andMtcTypeLessThanOrEqualTo(Integer value) {
            addCriterion("mtc_type <=", value, "mtcType");
            return (Criteria) this;
        }

        public Criteria andMtcTypeIn(List<Integer> values) {
            addCriterion("mtc_type in", values, "mtcType");
            return (Criteria) this;
        }

        public Criteria andMtcTypeNotIn(List<Integer> values) {
            addCriterion("mtc_type not in", values, "mtcType");
            return (Criteria) this;
        }

        public Criteria andMtcTypeBetween(Integer value1, Integer value2) {
            addCriterion("mtc_type between", value1, value2, "mtcType");
            return (Criteria) this;
        }

        public Criteria andMtcTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("mtc_type not between", value1, value2, "mtcType");
            return (Criteria) this;
        }

        public Criteria andMtcStatusIsNull() {
            addCriterion("mtc_status is null");
            return (Criteria) this;
        }

        public Criteria andMtcStatusIsNotNull() {
            addCriterion("mtc_status is not null");
            return (Criteria) this;
        }

        public Criteria andMtcStatusEqualTo(String value) {
            addCriterion("mtc_status =", value, "mtcStatus");
            return (Criteria) this;
        }

        public Criteria andMtcStatusNotEqualTo(String value) {
            addCriterion("mtc_status <>", value, "mtcStatus");
            return (Criteria) this;
        }

        public Criteria andMtcStatusGreaterThan(String value) {
            addCriterion("mtc_status >", value, "mtcStatus");
            return (Criteria) this;
        }

        public Criteria andMtcStatusGreaterThanOrEqualTo(String value) {
            addCriterion("mtc_status >=", value, "mtcStatus");
            return (Criteria) this;
        }

        public Criteria andMtcStatusLessThan(String value) {
            addCriterion("mtc_status <", value, "mtcStatus");
            return (Criteria) this;
        }

        public Criteria andMtcStatusLessThanOrEqualTo(String value) {
            addCriterion("mtc_status <=", value, "mtcStatus");
            return (Criteria) this;
        }

        public Criteria andMtcStatusLike(String value) {
            addCriterion("mtc_status like", value, "mtcStatus");
            return (Criteria) this;
        }

        public Criteria andMtcStatusNotLike(String value) {
            addCriterion("mtc_status not like", value, "mtcStatus");
            return (Criteria) this;
        }

        public Criteria andMtcStatusIn(List<String> values) {
            addCriterion("mtc_status in", values, "mtcStatus");
            return (Criteria) this;
        }

        public Criteria andMtcStatusNotIn(List<String> values) {
            addCriterion("mtc_status not in", values, "mtcStatus");
            return (Criteria) this;
        }

        public Criteria andMtcStatusBetween(String value1, String value2) {
            addCriterion("mtc_status between", value1, value2, "mtcStatus");
            return (Criteria) this;
        }

        public Criteria andMtcStatusNotBetween(String value1, String value2) {
            addCriterion("mtc_status not between", value1, value2, "mtcStatus");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeIsNull() {
            addCriterion("mtc_createtime is null");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeIsNotNull() {
            addCriterion("mtc_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeEqualTo(String value) {
            addCriterion("mtc_createtime =", value, "mtcCreatetime");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeNotEqualTo(String value) {
            addCriterion("mtc_createtime <>", value, "mtcCreatetime");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeGreaterThan(String value) {
            addCriterion("mtc_createtime >", value, "mtcCreatetime");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("mtc_createtime >=", value, "mtcCreatetime");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeLessThan(String value) {
            addCriterion("mtc_createtime <", value, "mtcCreatetime");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("mtc_createtime <=", value, "mtcCreatetime");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeLike(String value) {
            addCriterion("mtc_createtime like", value, "mtcCreatetime");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeNotLike(String value) {
            addCriterion("mtc_createtime not like", value, "mtcCreatetime");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeIn(List<String> values) {
            addCriterion("mtc_createtime in", values, "mtcCreatetime");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeNotIn(List<String> values) {
            addCriterion("mtc_createtime not in", values, "mtcCreatetime");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeBetween(String value1, String value2) {
            addCriterion("mtc_createtime between", value1, value2, "mtcCreatetime");
            return (Criteria) this;
        }

        public Criteria andMtcCreatetimeNotBetween(String value1, String value2) {
            addCriterion("mtc_createtime not between", value1, value2, "mtcCreatetime");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserIsNull() {
            addCriterion("mtc_createuser is null");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserIsNotNull() {
            addCriterion("mtc_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserEqualTo(String value) {
            addCriterion("mtc_createuser =", value, "mtcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserNotEqualTo(String value) {
            addCriterion("mtc_createuser <>", value, "mtcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserGreaterThan(String value) {
            addCriterion("mtc_createuser >", value, "mtcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("mtc_createuser >=", value, "mtcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserLessThan(String value) {
            addCriterion("mtc_createuser <", value, "mtcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserLessThanOrEqualTo(String value) {
            addCriterion("mtc_createuser <=", value, "mtcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserLike(String value) {
            addCriterion("mtc_createuser like", value, "mtcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserNotLike(String value) {
            addCriterion("mtc_createuser not like", value, "mtcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserIn(List<String> values) {
            addCriterion("mtc_createuser in", values, "mtcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserNotIn(List<String> values) {
            addCriterion("mtc_createuser not in", values, "mtcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserBetween(String value1, String value2) {
            addCriterion("mtc_createuser between", value1, value2, "mtcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMtcCreateuserNotBetween(String value1, String value2) {
            addCriterion("mtc_createuser not between", value1, value2, "mtcCreateuser");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeIsNull() {
            addCriterion("mtc_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeIsNotNull() {
            addCriterion("mtc_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeEqualTo(String value) {
            addCriterion("mtc_updatetime =", value, "mtcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeNotEqualTo(String value) {
            addCriterion("mtc_updatetime <>", value, "mtcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeGreaterThan(String value) {
            addCriterion("mtc_updatetime >", value, "mtcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("mtc_updatetime >=", value, "mtcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeLessThan(String value) {
            addCriterion("mtc_updatetime <", value, "mtcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("mtc_updatetime <=", value, "mtcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeLike(String value) {
            addCriterion("mtc_updatetime like", value, "mtcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeNotLike(String value) {
            addCriterion("mtc_updatetime not like", value, "mtcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeIn(List<String> values) {
            addCriterion("mtc_updatetime in", values, "mtcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeNotIn(List<String> values) {
            addCriterion("mtc_updatetime not in", values, "mtcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeBetween(String value1, String value2) {
            addCriterion("mtc_updatetime between", value1, value2, "mtcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMtcUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("mtc_updatetime not between", value1, value2, "mtcUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserIsNull() {
            addCriterion("mtc_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserIsNotNull() {
            addCriterion("mtc_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserEqualTo(String value) {
            addCriterion("mtc_updateuser =", value, "mtcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserNotEqualTo(String value) {
            addCriterion("mtc_updateuser <>", value, "mtcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserGreaterThan(String value) {
            addCriterion("mtc_updateuser >", value, "mtcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("mtc_updateuser >=", value, "mtcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserLessThan(String value) {
            addCriterion("mtc_updateuser <", value, "mtcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("mtc_updateuser <=", value, "mtcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserLike(String value) {
            addCriterion("mtc_updateuser like", value, "mtcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserNotLike(String value) {
            addCriterion("mtc_updateuser not like", value, "mtcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserIn(List<String> values) {
            addCriterion("mtc_updateuser in", values, "mtcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserNotIn(List<String> values) {
            addCriterion("mtc_updateuser not in", values, "mtcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserBetween(String value1, String value2) {
            addCriterion("mtc_updateuser between", value1, value2, "mtcUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMtcUpdateuserNotBetween(String value1, String value2) {
            addCriterion("mtc_updateuser not between", value1, value2, "mtcUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andMtcNumberLikeInsensitive(String value) {
            addCriterion("upper(mtc_number) like", value.toUpperCase(), "mtcNumber");
            return this;
        }

        public Criteria andMtcNameLikeInsensitive(String value) {
            addCriterion("upper(mtc_name) like", value.toUpperCase(), "mtcName");
            return this;
        }

        public Criteria andMtcDependencyLikeInsensitive(String value) {
            addCriterion("upper(mtc_dependency) like", value.toUpperCase(), "mtcDependency");
            return this;
        }

        public Criteria andMtcStatusLikeInsensitive(String value) {
            addCriterion("upper(mtc_status) like", value.toUpperCase(), "mtcStatus");
            return this;
        }

        public Criteria andMtcCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(mtc_createtime) like", value.toUpperCase(), "mtcCreatetime");
            return this;
        }

        public Criteria andMtcCreateuserLikeInsensitive(String value) {
            addCriterion("upper(mtc_createuser) like", value.toUpperCase(), "mtcCreateuser");
            return this;
        }

        public Criteria andMtcUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(mtc_updatetime) like", value.toUpperCase(), "mtcUpdatetime");
            return this;
        }

        public Criteria andMtcUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(mtc_updateuser) like", value.toUpperCase(), "mtcUpdateuser");
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