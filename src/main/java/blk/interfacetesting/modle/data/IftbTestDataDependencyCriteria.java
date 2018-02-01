package blk.interfacetesting.modle.data;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class IftbTestDataDependencyCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * search for itdName
     */
    protected boolean addItdName;

    public boolean isAddItdName() {
        return addItdName;
    }

    public void setAddItdName(boolean addItdName) {
        this.addItdName = addItdName;
    }

    protected Page page;

    public IftbTestDataDependencyCriteria() {
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

        public Criteria andItddIdIsNull() {
            addCriterion("itdd_id is null");
            return (Criteria) this;
        }

        public Criteria andItddIdIsNotNull() {
            addCriterion("itdd_id is not null");
            return (Criteria) this;
        }

        public Criteria andItddIdEqualTo(Integer value) {
            addCriterion("itdd_id =", value, "itddId");
            return (Criteria) this;
        }

        public Criteria andItddIdNotEqualTo(Integer value) {
            addCriterion("itdd_id <>", value, "itddId");
            return (Criteria) this;
        }

        public Criteria andItddIdGreaterThan(Integer value) {
            addCriterion("itdd_id >", value, "itddId");
            return (Criteria) this;
        }

        public Criteria andItddIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("itdd_id >=", value, "itddId");
            return (Criteria) this;
        }

        public Criteria andItddIdLessThan(Integer value) {
            addCriterion("itdd_id <", value, "itddId");
            return (Criteria) this;
        }

        public Criteria andItddIdLessThanOrEqualTo(Integer value) {
            addCriterion("itdd_id <=", value, "itddId");
            return (Criteria) this;
        }

        public Criteria andItddIdIn(List<Integer> values) {
            addCriterion("itdd_id in", values, "itddId");
            return (Criteria) this;
        }

        public Criteria andItddIdNotIn(List<Integer> values) {
            addCriterion("itdd_id not in", values, "itddId");
            return (Criteria) this;
        }

        public Criteria andItddIdBetween(Integer value1, Integer value2) {
            addCriterion("itdd_id between", value1, value2, "itddId");
            return (Criteria) this;
        }

        public Criteria andItddIdNotBetween(Integer value1, Integer value2) {
            addCriterion("itdd_id not between", value1, value2, "itddId");
            return (Criteria) this;
        }

        public Criteria andItdIdIsNull() {
            addCriterion("itd_id is null");
            return (Criteria) this;
        }

        public Criteria andItdIdIsNotNull() {
            addCriterion("itd_id is not null");
            return (Criteria) this;
        }

        public Criteria andItdIdEqualTo(Integer value) {
            addCriterion("itd_id =", value, "itdId");
            return (Criteria) this;
        }

        public Criteria andItdIdNotEqualTo(Integer value) {
            addCriterion("itd_id <>", value, "itdId");
            return (Criteria) this;
        }

        public Criteria andItdIdGreaterThan(Integer value) {
            addCriterion("itd_id >", value, "itdId");
            return (Criteria) this;
        }

        public Criteria andItdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("itd_id >=", value, "itdId");
            return (Criteria) this;
        }

        public Criteria andItdIdLessThan(Integer value) {
            addCriterion("itd_id <", value, "itdId");
            return (Criteria) this;
        }

        public Criteria andItdIdLessThanOrEqualTo(Integer value) {
            addCriterion("itd_id <=", value, "itdId");
            return (Criteria) this;
        }

        public Criteria andItdIdIn(List<Integer> values) {
            addCriterion("itd_id in", values, "itdId");
            return (Criteria) this;
        }

        public Criteria andItdIdNotIn(List<Integer> values) {
            addCriterion("itd_id not in", values, "itdId");
            return (Criteria) this;
        }

        public Criteria andItdIdBetween(Integer value1, Integer value2) {
            addCriterion("itd_id between", value1, value2, "itdId");
            return (Criteria) this;
        }

        public Criteria andItdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("itd_id not between", value1, value2, "itdId");
            return (Criteria) this;
        }

        public Criteria andItddDependencyIsNull() {
            addCriterion("itdd_dependency is null");
            return (Criteria) this;
        }

        public Criteria andItddDependencyIsNotNull() {
            addCriterion("itdd_dependency is not null");
            return (Criteria) this;
        }

        public Criteria andItddDependencyEqualTo(String value) {
            addCriterion("itdd_dependency =", value, "itddDependency");
            return (Criteria) this;
        }

        public Criteria andItddDependencyNotEqualTo(String value) {
            addCriterion("itdd_dependency <>", value, "itddDependency");
            return (Criteria) this;
        }

        public Criteria andItddDependencyGreaterThan(String value) {
            addCriterion("itdd_dependency >", value, "itddDependency");
            return (Criteria) this;
        }

        public Criteria andItddDependencyGreaterThanOrEqualTo(String value) {
            addCriterion("itdd_dependency >=", value, "itddDependency");
            return (Criteria) this;
        }

        public Criteria andItddDependencyLessThan(String value) {
            addCriterion("itdd_dependency <", value, "itddDependency");
            return (Criteria) this;
        }

        public Criteria andItddDependencyLessThanOrEqualTo(String value) {
            addCriterion("itdd_dependency <=", value, "itddDependency");
            return (Criteria) this;
        }

        public Criteria andItddDependencyLike(String value) {
            addCriterion("itdd_dependency like", value, "itddDependency");
            return (Criteria) this;
        }

        public Criteria andItddDependencyNotLike(String value) {
            addCriterion("itdd_dependency not like", value, "itddDependency");
            return (Criteria) this;
        }

        public Criteria andItddDependencyIn(List<String> values) {
            addCriterion("itdd_dependency in", values, "itddDependency");
            return (Criteria) this;
        }

        public Criteria andItddDependencyNotIn(List<String> values) {
            addCriterion("itdd_dependency not in", values, "itddDependency");
            return (Criteria) this;
        }

        public Criteria andItddDependencyBetween(String value1, String value2) {
            addCriterion("itdd_dependency between", value1, value2, "itddDependency");
            return (Criteria) this;
        }

        public Criteria andItddDependencyNotBetween(String value1, String value2) {
            addCriterion("itdd_dependency not between", value1, value2, "itddDependency");
            return (Criteria) this;
        }

        public Criteria andItddTypeIsNull() {
            addCriterion("itdd_type is null");
            return (Criteria) this;
        }

        public Criteria andItddTypeIsNotNull() {
            addCriterion("itdd_type is not null");
            return (Criteria) this;
        }

        public Criteria andItddTypeEqualTo(String value) {
            addCriterion("itdd_type =", value, "itddType");
            return (Criteria) this;
        }

        public Criteria andItddTypeNotEqualTo(String value) {
            addCriterion("itdd_type <>", value, "itddType");
            return (Criteria) this;
        }

        public Criteria andItddTypeGreaterThan(String value) {
            addCriterion("itdd_type >", value, "itddType");
            return (Criteria) this;
        }

        public Criteria andItddTypeGreaterThanOrEqualTo(String value) {
            addCriterion("itdd_type >=", value, "itddType");
            return (Criteria) this;
        }

        public Criteria andItddTypeLessThan(String value) {
            addCriterion("itdd_type <", value, "itddType");
            return (Criteria) this;
        }

        public Criteria andItddTypeLessThanOrEqualTo(String value) {
            addCriterion("itdd_type <=", value, "itddType");
            return (Criteria) this;
        }

        public Criteria andItddTypeLike(String value) {
            addCriterion("itdd_type like", value, "itddType");
            return (Criteria) this;
        }

        public Criteria andItddTypeNotLike(String value) {
            addCriterion("itdd_type not like", value, "itddType");
            return (Criteria) this;
        }

        public Criteria andItddTypeIn(List<String> values) {
            addCriterion("itdd_type in", values, "itddType");
            return (Criteria) this;
        }

        public Criteria andItddTypeNotIn(List<String> values) {
            addCriterion("itdd_type not in", values, "itddType");
            return (Criteria) this;
        }

        public Criteria andItddTypeBetween(String value1, String value2) {
            addCriterion("itdd_type between", value1, value2, "itddType");
            return (Criteria) this;
        }

        public Criteria andItddTypeNotBetween(String value1, String value2) {
            addCriterion("itdd_type not between", value1, value2, "itddType");
            return (Criteria) this;
        }

        public Criteria andItddStatusIsNull() {
            addCriterion("itdd_status is null");
            return (Criteria) this;
        }

        public Criteria andItddStatusIsNotNull() {
            addCriterion("itdd_status is not null");
            return (Criteria) this;
        }

        public Criteria andItddStatusEqualTo(String value) {
            addCriterion("itdd_status =", value, "itddStatus");
            return (Criteria) this;
        }

        public Criteria andItddStatusNotEqualTo(String value) {
            addCriterion("itdd_status <>", value, "itddStatus");
            return (Criteria) this;
        }

        public Criteria andItddStatusGreaterThan(String value) {
            addCriterion("itdd_status >", value, "itddStatus");
            return (Criteria) this;
        }

        public Criteria andItddStatusGreaterThanOrEqualTo(String value) {
            addCriterion("itdd_status >=", value, "itddStatus");
            return (Criteria) this;
        }

        public Criteria andItddStatusLessThan(String value) {
            addCriterion("itdd_status <", value, "itddStatus");
            return (Criteria) this;
        }

        public Criteria andItddStatusLessThanOrEqualTo(String value) {
            addCriterion("itdd_status <=", value, "itddStatus");
            return (Criteria) this;
        }

        public Criteria andItddStatusLike(String value) {
            addCriterion("itdd_status like", value, "itddStatus");
            return (Criteria) this;
        }

        public Criteria andItddStatusNotLike(String value) {
            addCriterion("itdd_status not like", value, "itddStatus");
            return (Criteria) this;
        }

        public Criteria andItddStatusIn(List<String> values) {
            addCriterion("itdd_status in", values, "itddStatus");
            return (Criteria) this;
        }

        public Criteria andItddStatusNotIn(List<String> values) {
            addCriterion("itdd_status not in", values, "itddStatus");
            return (Criteria) this;
        }

        public Criteria andItddStatusBetween(String value1, String value2) {
            addCriterion("itdd_status between", value1, value2, "itddStatus");
            return (Criteria) this;
        }

        public Criteria andItddStatusNotBetween(String value1, String value2) {
            addCriterion("itdd_status not between", value1, value2, "itddStatus");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeIsNull() {
            addCriterion("itdd_createtime is null");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeIsNotNull() {
            addCriterion("itdd_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeEqualTo(String value) {
            addCriterion("itdd_createtime =", value, "itddCreatetime");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeNotEqualTo(String value) {
            addCriterion("itdd_createtime <>", value, "itddCreatetime");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeGreaterThan(String value) {
            addCriterion("itdd_createtime >", value, "itddCreatetime");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("itdd_createtime >=", value, "itddCreatetime");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeLessThan(String value) {
            addCriterion("itdd_createtime <", value, "itddCreatetime");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("itdd_createtime <=", value, "itddCreatetime");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeLike(String value) {
            addCriterion("itdd_createtime like", value, "itddCreatetime");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeNotLike(String value) {
            addCriterion("itdd_createtime not like", value, "itddCreatetime");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeIn(List<String> values) {
            addCriterion("itdd_createtime in", values, "itddCreatetime");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeNotIn(List<String> values) {
            addCriterion("itdd_createtime not in", values, "itddCreatetime");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeBetween(String value1, String value2) {
            addCriterion("itdd_createtime between", value1, value2, "itddCreatetime");
            return (Criteria) this;
        }

        public Criteria andItddCreatetimeNotBetween(String value1, String value2) {
            addCriterion("itdd_createtime not between", value1, value2, "itddCreatetime");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserIsNull() {
            addCriterion("itdd_createuser is null");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserIsNotNull() {
            addCriterion("itdd_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserEqualTo(String value) {
            addCriterion("itdd_createuser =", value, "itddCreateuser");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserNotEqualTo(String value) {
            addCriterion("itdd_createuser <>", value, "itddCreateuser");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserGreaterThan(String value) {
            addCriterion("itdd_createuser >", value, "itddCreateuser");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("itdd_createuser >=", value, "itddCreateuser");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserLessThan(String value) {
            addCriterion("itdd_createuser <", value, "itddCreateuser");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserLessThanOrEqualTo(String value) {
            addCriterion("itdd_createuser <=", value, "itddCreateuser");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserLike(String value) {
            addCriterion("itdd_createuser like", value, "itddCreateuser");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserNotLike(String value) {
            addCriterion("itdd_createuser not like", value, "itddCreateuser");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserIn(List<String> values) {
            addCriterion("itdd_createuser in", values, "itddCreateuser");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserNotIn(List<String> values) {
            addCriterion("itdd_createuser not in", values, "itddCreateuser");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserBetween(String value1, String value2) {
            addCriterion("itdd_createuser between", value1, value2, "itddCreateuser");
            return (Criteria) this;
        }

        public Criteria andItddCreateuserNotBetween(String value1, String value2) {
            addCriterion("itdd_createuser not between", value1, value2, "itddCreateuser");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeIsNull() {
            addCriterion("itdd_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeIsNotNull() {
            addCriterion("itdd_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeEqualTo(String value) {
            addCriterion("itdd_updatetime =", value, "itddUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeNotEqualTo(String value) {
            addCriterion("itdd_updatetime <>", value, "itddUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeGreaterThan(String value) {
            addCriterion("itdd_updatetime >", value, "itddUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("itdd_updatetime >=", value, "itddUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeLessThan(String value) {
            addCriterion("itdd_updatetime <", value, "itddUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("itdd_updatetime <=", value, "itddUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeLike(String value) {
            addCriterion("itdd_updatetime like", value, "itddUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeNotLike(String value) {
            addCriterion("itdd_updatetime not like", value, "itddUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeIn(List<String> values) {
            addCriterion("itdd_updatetime in", values, "itddUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeNotIn(List<String> values) {
            addCriterion("itdd_updatetime not in", values, "itddUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeBetween(String value1, String value2) {
            addCriterion("itdd_updatetime between", value1, value2, "itddUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItddUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("itdd_updatetime not between", value1, value2, "itddUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserIsNull() {
            addCriterion("itdd_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserIsNotNull() {
            addCriterion("itdd_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserEqualTo(String value) {
            addCriterion("itdd_updateuser =", value, "itddUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserNotEqualTo(String value) {
            addCriterion("itdd_updateuser <>", value, "itddUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserGreaterThan(String value) {
            addCriterion("itdd_updateuser >", value, "itddUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("itdd_updateuser >=", value, "itddUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserLessThan(String value) {
            addCriterion("itdd_updateuser <", value, "itddUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("itdd_updateuser <=", value, "itddUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserLike(String value) {
            addCriterion("itdd_updateuser like", value, "itddUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserNotLike(String value) {
            addCriterion("itdd_updateuser not like", value, "itddUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserIn(List<String> values) {
            addCriterion("itdd_updateuser in", values, "itddUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserNotIn(List<String> values) {
            addCriterion("itdd_updateuser not in", values, "itddUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserBetween(String value1, String value2) {
            addCriterion("itdd_updateuser between", value1, value2, "itddUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItddUpdateuserNotBetween(String value1, String value2) {
            addCriterion("itdd_updateuser not between", value1, value2, "itddUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andItddDependencyLikeInsensitive(String value) {
            addCriterion("upper(itdd_dependency) like", value.toUpperCase(), "itddDependency");
            return this;
        }

        public Criteria andItddTypeLikeInsensitive(String value) {
            addCriterion("upper(itdd_type) like", value.toUpperCase(), "itddType");
            return this;
        }

        public Criteria andItddStatusLikeInsensitive(String value) {
            addCriterion("upper(itdd_status) like", value.toUpperCase(), "itddStatus");
            return this;
        }

        public Criteria andItddCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(itdd_createtime) like", value.toUpperCase(), "itddCreatetime");
            return this;
        }

        public Criteria andItddCreateuserLikeInsensitive(String value) {
            addCriterion("upper(itdd_createuser) like", value.toUpperCase(), "itddCreateuser");
            return this;
        }

        public Criteria andItddUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(itdd_updatetime) like", value.toUpperCase(), "itddUpdatetime");
            return this;
        }

        public Criteria andItddUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(itdd_updateuser) like", value.toUpperCase(), "itddUpdateuser");
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