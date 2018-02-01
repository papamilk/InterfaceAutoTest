package blk.interfacetesting.modle.data;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class MstbProjectCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public MstbProjectCriteria() {
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

        public Criteria andMpNameIsNull() {
            addCriterion("mp_name is null");
            return (Criteria) this;
        }

        public Criteria andMpNameIsNotNull() {
            addCriterion("mp_name is not null");
            return (Criteria) this;
        }

        public Criteria andMpNameEqualTo(String value) {
            addCriterion("mp_name =", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameNotEqualTo(String value) {
            addCriterion("mp_name <>", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameGreaterThan(String value) {
            addCriterion("mp_name >", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameGreaterThanOrEqualTo(String value) {
            addCriterion("mp_name >=", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameLessThan(String value) {
            addCriterion("mp_name <", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameLessThanOrEqualTo(String value) {
            addCriterion("mp_name <=", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameLike(String value) {
            addCriterion("mp_name like", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameNotLike(String value) {
            addCriterion("mp_name not like", value, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameIn(List<String> values) {
            addCriterion("mp_name in", values, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameNotIn(List<String> values) {
            addCriterion("mp_name not in", values, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameBetween(String value1, String value2) {
            addCriterion("mp_name between", value1, value2, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpNameNotBetween(String value1, String value2) {
            addCriterion("mp_name not between", value1, value2, "mpName");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionIsNull() {
            addCriterion("mp_description is null");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionIsNotNull() {
            addCriterion("mp_description is not null");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionEqualTo(String value) {
            addCriterion("mp_description =", value, "mpDescription");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionNotEqualTo(String value) {
            addCriterion("mp_description <>", value, "mpDescription");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionGreaterThan(String value) {
            addCriterion("mp_description >", value, "mpDescription");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("mp_description >=", value, "mpDescription");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionLessThan(String value) {
            addCriterion("mp_description <", value, "mpDescription");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionLessThanOrEqualTo(String value) {
            addCriterion("mp_description <=", value, "mpDescription");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionLike(String value) {
            addCriterion("mp_description like", value, "mpDescription");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionNotLike(String value) {
            addCriterion("mp_description not like", value, "mpDescription");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionIn(List<String> values) {
            addCriterion("mp_description in", values, "mpDescription");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionNotIn(List<String> values) {
            addCriterion("mp_description not in", values, "mpDescription");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionBetween(String value1, String value2) {
            addCriterion("mp_description between", value1, value2, "mpDescription");
            return (Criteria) this;
        }

        public Criteria andMpDescriptionNotBetween(String value1, String value2) {
            addCriterion("mp_description not between", value1, value2, "mpDescription");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionIsNull() {
            addCriterion("mp_url_prefixion is null");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionIsNotNull() {
            addCriterion("mp_url_prefixion is not null");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionEqualTo(String value) {
            addCriterion("mp_url_prefixion =", value, "mpUrlPrefixion");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionNotEqualTo(String value) {
            addCriterion("mp_url_prefixion <>", value, "mpUrlPrefixion");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionGreaterThan(String value) {
            addCriterion("mp_url_prefixion >", value, "mpUrlPrefixion");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionGreaterThanOrEqualTo(String value) {
            addCriterion("mp_url_prefixion >=", value, "mpUrlPrefixion");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionLessThan(String value) {
            addCriterion("mp_url_prefixion <", value, "mpUrlPrefixion");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionLessThanOrEqualTo(String value) {
            addCriterion("mp_url_prefixion <=", value, "mpUrlPrefixion");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionLike(String value) {
            addCriterion("mp_url_prefixion like", value, "mpUrlPrefixion");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionNotLike(String value) {
            addCriterion("mp_url_prefixion not like", value, "mpUrlPrefixion");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionIn(List<String> values) {
            addCriterion("mp_url_prefixion in", values, "mpUrlPrefixion");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionNotIn(List<String> values) {
            addCriterion("mp_url_prefixion not in", values, "mpUrlPrefixion");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionBetween(String value1, String value2) {
            addCriterion("mp_url_prefixion between", value1, value2, "mpUrlPrefixion");
            return (Criteria) this;
        }

        public Criteria andMpUrlPrefixionNotBetween(String value1, String value2) {
            addCriterion("mp_url_prefixion not between", value1, value2, "mpUrlPrefixion");
            return (Criteria) this;
        }

        public Criteria andMpStatusIsNull() {
            addCriterion("mp_status is null");
            return (Criteria) this;
        }

        public Criteria andMpStatusIsNotNull() {
            addCriterion("mp_status is not null");
            return (Criteria) this;
        }

        public Criteria andMpStatusEqualTo(String value) {
            addCriterion("mp_status =", value, "mpStatus");
            return (Criteria) this;
        }

        public Criteria andMpStatusNotEqualTo(String value) {
            addCriterion("mp_status <>", value, "mpStatus");
            return (Criteria) this;
        }

        public Criteria andMpStatusGreaterThan(String value) {
            addCriterion("mp_status >", value, "mpStatus");
            return (Criteria) this;
        }

        public Criteria andMpStatusGreaterThanOrEqualTo(String value) {
            addCriterion("mp_status >=", value, "mpStatus");
            return (Criteria) this;
        }

        public Criteria andMpStatusLessThan(String value) {
            addCriterion("mp_status <", value, "mpStatus");
            return (Criteria) this;
        }

        public Criteria andMpStatusLessThanOrEqualTo(String value) {
            addCriterion("mp_status <=", value, "mpStatus");
            return (Criteria) this;
        }

        public Criteria andMpStatusLike(String value) {
            addCriterion("mp_status like", value, "mpStatus");
            return (Criteria) this;
        }

        public Criteria andMpStatusNotLike(String value) {
            addCriterion("mp_status not like", value, "mpStatus");
            return (Criteria) this;
        }

        public Criteria andMpStatusIn(List<String> values) {
            addCriterion("mp_status in", values, "mpStatus");
            return (Criteria) this;
        }

        public Criteria andMpStatusNotIn(List<String> values) {
            addCriterion("mp_status not in", values, "mpStatus");
            return (Criteria) this;
        }

        public Criteria andMpStatusBetween(String value1, String value2) {
            addCriterion("mp_status between", value1, value2, "mpStatus");
            return (Criteria) this;
        }

        public Criteria andMpStatusNotBetween(String value1, String value2) {
            addCriterion("mp_status not between", value1, value2, "mpStatus");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeIsNull() {
            addCriterion("mp_createtime is null");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeIsNotNull() {
            addCriterion("mp_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeEqualTo(String value) {
            addCriterion("mp_createtime =", value, "mpCreatetime");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeNotEqualTo(String value) {
            addCriterion("mp_createtime <>", value, "mpCreatetime");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeGreaterThan(String value) {
            addCriterion("mp_createtime >", value, "mpCreatetime");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("mp_createtime >=", value, "mpCreatetime");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeLessThan(String value) {
            addCriterion("mp_createtime <", value, "mpCreatetime");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("mp_createtime <=", value, "mpCreatetime");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeLike(String value) {
            addCriterion("mp_createtime like", value, "mpCreatetime");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeNotLike(String value) {
            addCriterion("mp_createtime not like", value, "mpCreatetime");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeIn(List<String> values) {
            addCriterion("mp_createtime in", values, "mpCreatetime");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeNotIn(List<String> values) {
            addCriterion("mp_createtime not in", values, "mpCreatetime");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeBetween(String value1, String value2) {
            addCriterion("mp_createtime between", value1, value2, "mpCreatetime");
            return (Criteria) this;
        }

        public Criteria andMpCreatetimeNotBetween(String value1, String value2) {
            addCriterion("mp_createtime not between", value1, value2, "mpCreatetime");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserIsNull() {
            addCriterion("mp_createuser is null");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserIsNotNull() {
            addCriterion("mp_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserEqualTo(String value) {
            addCriterion("mp_createuser =", value, "mpCreateuser");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserNotEqualTo(String value) {
            addCriterion("mp_createuser <>", value, "mpCreateuser");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserGreaterThan(String value) {
            addCriterion("mp_createuser >", value, "mpCreateuser");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("mp_createuser >=", value, "mpCreateuser");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserLessThan(String value) {
            addCriterion("mp_createuser <", value, "mpCreateuser");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserLessThanOrEqualTo(String value) {
            addCriterion("mp_createuser <=", value, "mpCreateuser");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserLike(String value) {
            addCriterion("mp_createuser like", value, "mpCreateuser");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserNotLike(String value) {
            addCriterion("mp_createuser not like", value, "mpCreateuser");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserIn(List<String> values) {
            addCriterion("mp_createuser in", values, "mpCreateuser");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserNotIn(List<String> values) {
            addCriterion("mp_createuser not in", values, "mpCreateuser");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserBetween(String value1, String value2) {
            addCriterion("mp_createuser between", value1, value2, "mpCreateuser");
            return (Criteria) this;
        }

        public Criteria andMpCreateuserNotBetween(String value1, String value2) {
            addCriterion("mp_createuser not between", value1, value2, "mpCreateuser");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeIsNull() {
            addCriterion("mp_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeIsNotNull() {
            addCriterion("mp_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeEqualTo(String value) {
            addCriterion("mp_updatetime =", value, "mpUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeNotEqualTo(String value) {
            addCriterion("mp_updatetime <>", value, "mpUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeGreaterThan(String value) {
            addCriterion("mp_updatetime >", value, "mpUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("mp_updatetime >=", value, "mpUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeLessThan(String value) {
            addCriterion("mp_updatetime <", value, "mpUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("mp_updatetime <=", value, "mpUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeLike(String value) {
            addCriterion("mp_updatetime like", value, "mpUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeNotLike(String value) {
            addCriterion("mp_updatetime not like", value, "mpUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeIn(List<String> values) {
            addCriterion("mp_updatetime in", values, "mpUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeNotIn(List<String> values) {
            addCriterion("mp_updatetime not in", values, "mpUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeBetween(String value1, String value2) {
            addCriterion("mp_updatetime between", value1, value2, "mpUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMpUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("mp_updatetime not between", value1, value2, "mpUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserIsNull() {
            addCriterion("mp_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserIsNotNull() {
            addCriterion("mp_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserEqualTo(String value) {
            addCriterion("mp_updateuser =", value, "mpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserNotEqualTo(String value) {
            addCriterion("mp_updateuser <>", value, "mpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserGreaterThan(String value) {
            addCriterion("mp_updateuser >", value, "mpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("mp_updateuser >=", value, "mpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserLessThan(String value) {
            addCriterion("mp_updateuser <", value, "mpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("mp_updateuser <=", value, "mpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserLike(String value) {
            addCriterion("mp_updateuser like", value, "mpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserNotLike(String value) {
            addCriterion("mp_updateuser not like", value, "mpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserIn(List<String> values) {
            addCriterion("mp_updateuser in", values, "mpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserNotIn(List<String> values) {
            addCriterion("mp_updateuser not in", values, "mpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserBetween(String value1, String value2) {
            addCriterion("mp_updateuser between", value1, value2, "mpUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMpUpdateuserNotBetween(String value1, String value2) {
            addCriterion("mp_updateuser not between", value1, value2, "mpUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andMpNameLikeInsensitive(String value) {
            addCriterion("upper(mp_name) like", value.toUpperCase(), "mpName");
            return this;
        }

        public Criteria andMpDescriptionLikeInsensitive(String value) {
            addCriterion("upper(mp_description) like", value.toUpperCase(), "mpDescription");
            return this;
        }

        public Criteria andMpUrlPrefixionLikeInsensitive(String value) {
            addCriterion("upper(mp_url_prefixion) like", value.toUpperCase(), "mpUrlPrefixion");
            return this;
        }

        public Criteria andMpStatusLikeInsensitive(String value) {
            addCriterion("upper(mp_status) like", value.toUpperCase(), "mpStatus");
            return this;
        }

        public Criteria andMpCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(mp_createtime) like", value.toUpperCase(), "mpCreatetime");
            return this;
        }

        public Criteria andMpCreateuserLikeInsensitive(String value) {
            addCriterion("upper(mp_createuser) like", value.toUpperCase(), "mpCreateuser");
            return this;
        }

        public Criteria andMpUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(mp_updatetime) like", value.toUpperCase(), "mpUpdatetime");
            return this;
        }

        public Criteria andMpUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(mp_updateuser) like", value.toUpperCase(), "mpUpdateuser");
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