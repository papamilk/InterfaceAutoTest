package blk.interfacetesting.modle.data;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class IftbExecuteMainSubCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public IftbExecuteMainSubCriteria() {
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

        public Criteria andIemIdIsNull() {
            addCriterion("iem_id is null");
            return (Criteria) this;
        }

        public Criteria andIemIdIsNotNull() {
            addCriterion("iem_id is not null");
            return (Criteria) this;
        }

        public Criteria andIemIdEqualTo(Integer value) {
            addCriterion("iem_id =", value, "iemId");
            return (Criteria) this;
        }

        public Criteria andIemIdNotEqualTo(Integer value) {
            addCriterion("iem_id <>", value, "iemId");
            return (Criteria) this;
        }

        public Criteria andIemIdGreaterThan(Integer value) {
            addCriterion("iem_id >", value, "iemId");
            return (Criteria) this;
        }

        public Criteria andIemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("iem_id >=", value, "iemId");
            return (Criteria) this;
        }

        public Criteria andIemIdLessThan(Integer value) {
            addCriterion("iem_id <", value, "iemId");
            return (Criteria) this;
        }

        public Criteria andIemIdLessThanOrEqualTo(Integer value) {
            addCriterion("iem_id <=", value, "iemId");
            return (Criteria) this;
        }

        public Criteria andIemIdIn(List<Integer> values) {
            addCriterion("iem_id in", values, "iemId");
            return (Criteria) this;
        }

        public Criteria andIemIdNotIn(List<Integer> values) {
            addCriterion("iem_id not in", values, "iemId");
            return (Criteria) this;
        }

        public Criteria andIemIdBetween(Integer value1, Integer value2) {
            addCriterion("iem_id between", value1, value2, "iemId");
            return (Criteria) this;
        }

        public Criteria andIemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("iem_id not between", value1, value2, "iemId");
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

        public Criteria andIemsOrderIsNull() {
            addCriterion("iems_order is null");
            return (Criteria) this;
        }

        public Criteria andIemsOrderIsNotNull() {
            addCriterion("iems_order is not null");
            return (Criteria) this;
        }

        public Criteria andIemsOrderEqualTo(Double value) {
            addCriterion("iems_order =", value, "iemsOrder");
            return (Criteria) this;
        }

        public Criteria andIemsOrderNotEqualTo(Double value) {
            addCriterion("iems_order <>", value, "iemsOrder");
            return (Criteria) this;
        }

        public Criteria andIemsOrderGreaterThan(Double value) {
            addCriterion("iems_order >", value, "iemsOrder");
            return (Criteria) this;
        }

        public Criteria andIemsOrderGreaterThanOrEqualTo(Double value) {
            addCriterion("iems_order >=", value, "iemsOrder");
            return (Criteria) this;
        }

        public Criteria andIemsOrderLessThan(Double value) {
            addCriterion("iems_order <", value, "iemsOrder");
            return (Criteria) this;
        }

        public Criteria andIemsOrderLessThanOrEqualTo(Double value) {
            addCriterion("iems_order <=", value, "iemsOrder");
            return (Criteria) this;
        }

        public Criteria andIemsOrderIn(List<Double> values) {
            addCriterion("iems_order in", values, "iemsOrder");
            return (Criteria) this;
        }

        public Criteria andIemsOrderNotIn(List<Double> values) {
            addCriterion("iems_order not in", values, "iemsOrder");
            return (Criteria) this;
        }

        public Criteria andIemsOrderBetween(Double value1, Double value2) {
            addCriterion("iems_order between", value1, value2, "iemsOrder");
            return (Criteria) this;
        }

        public Criteria andIemsOrderNotBetween(Double value1, Double value2) {
            addCriterion("iems_order not between", value1, value2, "iemsOrder");
            return (Criteria) this;
        }

        public Criteria andIemsStatusIsNull() {
            addCriterion("iems_status is null");
            return (Criteria) this;
        }

        public Criteria andIemsStatusIsNotNull() {
            addCriterion("iems_status is not null");
            return (Criteria) this;
        }

        public Criteria andIemsStatusEqualTo(String value) {
            addCriterion("iems_status =", value, "iemsStatus");
            return (Criteria) this;
        }

        public Criteria andIemsStatusNotEqualTo(String value) {
            addCriterion("iems_status <>", value, "iemsStatus");
            return (Criteria) this;
        }

        public Criteria andIemsStatusGreaterThan(String value) {
            addCriterion("iems_status >", value, "iemsStatus");
            return (Criteria) this;
        }

        public Criteria andIemsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("iems_status >=", value, "iemsStatus");
            return (Criteria) this;
        }

        public Criteria andIemsStatusLessThan(String value) {
            addCriterion("iems_status <", value, "iemsStatus");
            return (Criteria) this;
        }

        public Criteria andIemsStatusLessThanOrEqualTo(String value) {
            addCriterion("iems_status <=", value, "iemsStatus");
            return (Criteria) this;
        }

        public Criteria andIemsStatusLike(String value) {
            addCriterion("iems_status like", value, "iemsStatus");
            return (Criteria) this;
        }

        public Criteria andIemsStatusNotLike(String value) {
            addCriterion("iems_status not like", value, "iemsStatus");
            return (Criteria) this;
        }

        public Criteria andIemsStatusIn(List<String> values) {
            addCriterion("iems_status in", values, "iemsStatus");
            return (Criteria) this;
        }

        public Criteria andIemsStatusNotIn(List<String> values) {
            addCriterion("iems_status not in", values, "iemsStatus");
            return (Criteria) this;
        }

        public Criteria andIemsStatusBetween(String value1, String value2) {
            addCriterion("iems_status between", value1, value2, "iemsStatus");
            return (Criteria) this;
        }

        public Criteria andIemsStatusNotBetween(String value1, String value2) {
            addCriterion("iems_status not between", value1, value2, "iemsStatus");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeIsNull() {
            addCriterion("iems_createtime is null");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeIsNotNull() {
            addCriterion("iems_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeEqualTo(String value) {
            addCriterion("iems_createtime =", value, "iemsCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeNotEqualTo(String value) {
            addCriterion("iems_createtime <>", value, "iemsCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeGreaterThan(String value) {
            addCriterion("iems_createtime >", value, "iemsCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("iems_createtime >=", value, "iemsCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeLessThan(String value) {
            addCriterion("iems_createtime <", value, "iemsCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("iems_createtime <=", value, "iemsCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeLike(String value) {
            addCriterion("iems_createtime like", value, "iemsCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeNotLike(String value) {
            addCriterion("iems_createtime not like", value, "iemsCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeIn(List<String> values) {
            addCriterion("iems_createtime in", values, "iemsCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeNotIn(List<String> values) {
            addCriterion("iems_createtime not in", values, "iemsCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeBetween(String value1, String value2) {
            addCriterion("iems_createtime between", value1, value2, "iemsCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemsCreatetimeNotBetween(String value1, String value2) {
            addCriterion("iems_createtime not between", value1, value2, "iemsCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserIsNull() {
            addCriterion("iems_createuser is null");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserIsNotNull() {
            addCriterion("iems_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserEqualTo(String value) {
            addCriterion("iems_createuser =", value, "iemsCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserNotEqualTo(String value) {
            addCriterion("iems_createuser <>", value, "iemsCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserGreaterThan(String value) {
            addCriterion("iems_createuser >", value, "iemsCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("iems_createuser >=", value, "iemsCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserLessThan(String value) {
            addCriterion("iems_createuser <", value, "iemsCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserLessThanOrEqualTo(String value) {
            addCriterion("iems_createuser <=", value, "iemsCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserLike(String value) {
            addCriterion("iems_createuser like", value, "iemsCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserNotLike(String value) {
            addCriterion("iems_createuser not like", value, "iemsCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserIn(List<String> values) {
            addCriterion("iems_createuser in", values, "iemsCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserNotIn(List<String> values) {
            addCriterion("iems_createuser not in", values, "iemsCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserBetween(String value1, String value2) {
            addCriterion("iems_createuser between", value1, value2, "iemsCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemsCreateuserNotBetween(String value1, String value2) {
            addCriterion("iems_createuser not between", value1, value2, "iemsCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeIsNull() {
            addCriterion("iems_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeIsNotNull() {
            addCriterion("iems_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeEqualTo(String value) {
            addCriterion("iems_updatetime =", value, "iemsUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeNotEqualTo(String value) {
            addCriterion("iems_updatetime <>", value, "iemsUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeGreaterThan(String value) {
            addCriterion("iems_updatetime >", value, "iemsUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("iems_updatetime >=", value, "iemsUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeLessThan(String value) {
            addCriterion("iems_updatetime <", value, "iemsUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("iems_updatetime <=", value, "iemsUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeLike(String value) {
            addCriterion("iems_updatetime like", value, "iemsUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeNotLike(String value) {
            addCriterion("iems_updatetime not like", value, "iemsUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeIn(List<String> values) {
            addCriterion("iems_updatetime in", values, "iemsUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeNotIn(List<String> values) {
            addCriterion("iems_updatetime not in", values, "iemsUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeBetween(String value1, String value2) {
            addCriterion("iems_updatetime between", value1, value2, "iemsUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemsUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("iems_updatetime not between", value1, value2, "iemsUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserIsNull() {
            addCriterion("iems_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserIsNotNull() {
            addCriterion("iems_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserEqualTo(String value) {
            addCriterion("iems_updateuser =", value, "iemsUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserNotEqualTo(String value) {
            addCriterion("iems_updateuser <>", value, "iemsUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserGreaterThan(String value) {
            addCriterion("iems_updateuser >", value, "iemsUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("iems_updateuser >=", value, "iemsUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserLessThan(String value) {
            addCriterion("iems_updateuser <", value, "iemsUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("iems_updateuser <=", value, "iemsUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserLike(String value) {
            addCriterion("iems_updateuser like", value, "iemsUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserNotLike(String value) {
            addCriterion("iems_updateuser not like", value, "iemsUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserIn(List<String> values) {
            addCriterion("iems_updateuser in", values, "iemsUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserNotIn(List<String> values) {
            addCriterion("iems_updateuser not in", values, "iemsUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserBetween(String value1, String value2) {
            addCriterion("iems_updateuser between", value1, value2, "iemsUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemsUpdateuserNotBetween(String value1, String value2) {
            addCriterion("iems_updateuser not between", value1, value2, "iemsUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andIemsStatusLikeInsensitive(String value) {
            addCriterion("upper(iems_status) like", value.toUpperCase(), "iemsStatus");
            return this;
        }

        public Criteria andIemsCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(iems_createtime) like", value.toUpperCase(), "iemsCreatetime");
            return this;
        }

        public Criteria andIemsCreateuserLikeInsensitive(String value) {
            addCriterion("upper(iems_createuser) like", value.toUpperCase(), "iemsCreateuser");
            return this;
        }

        public Criteria andIemsUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(iems_updatetime) like", value.toUpperCase(), "iemsUpdatetime");
            return this;
        }

        public Criteria andIemsUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(iems_updateuser) like", value.toUpperCase(), "iemsUpdateuser");
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