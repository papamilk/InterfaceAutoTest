package blk.interfacetesting.modle.data;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class MstbURLParametersCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public MstbURLParametersCriteria() {
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

        public Criteria andMupIdIsNull() {
            addCriterion("mup_id is null");
            return (Criteria) this;
        }

        public Criteria andMupIdIsNotNull() {
            addCriterion("mup_id is not null");
            return (Criteria) this;
        }

        public Criteria andMupIdEqualTo(Integer value) {
            addCriterion("mup_id =", value, "mupId");
            return (Criteria) this;
        }

        public Criteria andMupIdNotEqualTo(Integer value) {
            addCriterion("mup_id <>", value, "mupId");
            return (Criteria) this;
        }

        public Criteria andMupIdGreaterThan(Integer value) {
            addCriterion("mup_id >", value, "mupId");
            return (Criteria) this;
        }

        public Criteria andMupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mup_id >=", value, "mupId");
            return (Criteria) this;
        }

        public Criteria andMupIdLessThan(Integer value) {
            addCriterion("mup_id <", value, "mupId");
            return (Criteria) this;
        }

        public Criteria andMupIdLessThanOrEqualTo(Integer value) {
            addCriterion("mup_id <=", value, "mupId");
            return (Criteria) this;
        }

        public Criteria andMupIdIn(List<Integer> values) {
            addCriterion("mup_id in", values, "mupId");
            return (Criteria) this;
        }

        public Criteria andMupIdNotIn(List<Integer> values) {
            addCriterion("mup_id not in", values, "mupId");
            return (Criteria) this;
        }

        public Criteria andMupIdBetween(Integer value1, Integer value2) {
            addCriterion("mup_id between", value1, value2, "mupId");
            return (Criteria) this;
        }

        public Criteria andMupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mup_id not between", value1, value2, "mupId");
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

        public Criteria andMupNameIsNull() {
            addCriterion("mup_name is null");
            return (Criteria) this;
        }

        public Criteria andMupNameIsNotNull() {
            addCriterion("mup_name is not null");
            return (Criteria) this;
        }

        public Criteria andMupNameEqualTo(String value) {
            addCriterion("mup_name =", value, "mupName");
            return (Criteria) this;
        }

        public Criteria andMupNameNotEqualTo(String value) {
            addCriterion("mup_name <>", value, "mupName");
            return (Criteria) this;
        }

        public Criteria andMupNameGreaterThan(String value) {
            addCriterion("mup_name >", value, "mupName");
            return (Criteria) this;
        }

        public Criteria andMupNameGreaterThanOrEqualTo(String value) {
            addCriterion("mup_name >=", value, "mupName");
            return (Criteria) this;
        }

        public Criteria andMupNameLessThan(String value) {
            addCriterion("mup_name <", value, "mupName");
            return (Criteria) this;
        }

        public Criteria andMupNameLessThanOrEqualTo(String value) {
            addCriterion("mup_name <=", value, "mupName");
            return (Criteria) this;
        }

        public Criteria andMupNameLike(String value) {
            addCriterion("mup_name like", value, "mupName");
            return (Criteria) this;
        }

        public Criteria andMupNameNotLike(String value) {
            addCriterion("mup_name not like", value, "mupName");
            return (Criteria) this;
        }

        public Criteria andMupNameIn(List<String> values) {
            addCriterion("mup_name in", values, "mupName");
            return (Criteria) this;
        }

        public Criteria andMupNameNotIn(List<String> values) {
            addCriterion("mup_name not in", values, "mupName");
            return (Criteria) this;
        }

        public Criteria andMupNameBetween(String value1, String value2) {
            addCriterion("mup_name between", value1, value2, "mupName");
            return (Criteria) this;
        }

        public Criteria andMupNameNotBetween(String value1, String value2) {
            addCriterion("mup_name not between", value1, value2, "mupName");
            return (Criteria) this;
        }

        public Criteria andMupTypeIsNull() {
            addCriterion("mup_type is null");
            return (Criteria) this;
        }

        public Criteria andMupTypeIsNotNull() {
            addCriterion("mup_type is not null");
            return (Criteria) this;
        }

        public Criteria andMupTypeEqualTo(String value) {
            addCriterion("mup_type =", value, "mupType");
            return (Criteria) this;
        }

        public Criteria andMupTypeNotEqualTo(String value) {
            addCriterion("mup_type <>", value, "mupType");
            return (Criteria) this;
        }

        public Criteria andMupTypeGreaterThan(String value) {
            addCriterion("mup_type >", value, "mupType");
            return (Criteria) this;
        }

        public Criteria andMupTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mup_type >=", value, "mupType");
            return (Criteria) this;
        }

        public Criteria andMupTypeLessThan(String value) {
            addCriterion("mup_type <", value, "mupType");
            return (Criteria) this;
        }

        public Criteria andMupTypeLessThanOrEqualTo(String value) {
            addCriterion("mup_type <=", value, "mupType");
            return (Criteria) this;
        }

        public Criteria andMupTypeLike(String value) {
            addCriterion("mup_type like", value, "mupType");
            return (Criteria) this;
        }

        public Criteria andMupTypeNotLike(String value) {
            addCriterion("mup_type not like", value, "mupType");
            return (Criteria) this;
        }

        public Criteria andMupTypeIn(List<String> values) {
            addCriterion("mup_type in", values, "mupType");
            return (Criteria) this;
        }

        public Criteria andMupTypeNotIn(List<String> values) {
            addCriterion("mup_type not in", values, "mupType");
            return (Criteria) this;
        }

        public Criteria andMupTypeBetween(String value1, String value2) {
            addCriterion("mup_type between", value1, value2, "mupType");
            return (Criteria) this;
        }

        public Criteria andMupTypeNotBetween(String value1, String value2) {
            addCriterion("mup_type not between", value1, value2, "mupType");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionIsNull() {
            addCriterion("mup_description is null");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionIsNotNull() {
            addCriterion("mup_description is not null");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionEqualTo(String value) {
            addCriterion("mup_description =", value, "mupDescription");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionNotEqualTo(String value) {
            addCriterion("mup_description <>", value, "mupDescription");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionGreaterThan(String value) {
            addCriterion("mup_description >", value, "mupDescription");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("mup_description >=", value, "mupDescription");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionLessThan(String value) {
            addCriterion("mup_description <", value, "mupDescription");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionLessThanOrEqualTo(String value) {
            addCriterion("mup_description <=", value, "mupDescription");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionLike(String value) {
            addCriterion("mup_description like", value, "mupDescription");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionNotLike(String value) {
            addCriterion("mup_description not like", value, "mupDescription");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionIn(List<String> values) {
            addCriterion("mup_description in", values, "mupDescription");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionNotIn(List<String> values) {
            addCriterion("mup_description not in", values, "mupDescription");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionBetween(String value1, String value2) {
            addCriterion("mup_description between", value1, value2, "mupDescription");
            return (Criteria) this;
        }

        public Criteria andMupDescriptionNotBetween(String value1, String value2) {
            addCriterion("mup_description not between", value1, value2, "mupDescription");
            return (Criteria) this;
        }

        public Criteria andMupStatusIsNull() {
            addCriterion("mup_status is null");
            return (Criteria) this;
        }

        public Criteria andMupStatusIsNotNull() {
            addCriterion("mup_status is not null");
            return (Criteria) this;
        }

        public Criteria andMupStatusEqualTo(String value) {
            addCriterion("mup_status =", value, "mupStatus");
            return (Criteria) this;
        }

        public Criteria andMupStatusNotEqualTo(String value) {
            addCriterion("mup_status <>", value, "mupStatus");
            return (Criteria) this;
        }

        public Criteria andMupStatusGreaterThan(String value) {
            addCriterion("mup_status >", value, "mupStatus");
            return (Criteria) this;
        }

        public Criteria andMupStatusGreaterThanOrEqualTo(String value) {
            addCriterion("mup_status >=", value, "mupStatus");
            return (Criteria) this;
        }

        public Criteria andMupStatusLessThan(String value) {
            addCriterion("mup_status <", value, "mupStatus");
            return (Criteria) this;
        }

        public Criteria andMupStatusLessThanOrEqualTo(String value) {
            addCriterion("mup_status <=", value, "mupStatus");
            return (Criteria) this;
        }

        public Criteria andMupStatusLike(String value) {
            addCriterion("mup_status like", value, "mupStatus");
            return (Criteria) this;
        }

        public Criteria andMupStatusNotLike(String value) {
            addCriterion("mup_status not like", value, "mupStatus");
            return (Criteria) this;
        }

        public Criteria andMupStatusIn(List<String> values) {
            addCriterion("mup_status in", values, "mupStatus");
            return (Criteria) this;
        }

        public Criteria andMupStatusNotIn(List<String> values) {
            addCriterion("mup_status not in", values, "mupStatus");
            return (Criteria) this;
        }

        public Criteria andMupStatusBetween(String value1, String value2) {
            addCriterion("mup_status between", value1, value2, "mupStatus");
            return (Criteria) this;
        }

        public Criteria andMupStatusNotBetween(String value1, String value2) {
            addCriterion("mup_status not between", value1, value2, "mupStatus");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeIsNull() {
            addCriterion("mup_createtime is null");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeIsNotNull() {
            addCriterion("mup_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeEqualTo(String value) {
            addCriterion("mup_createtime =", value, "mupCreatetime");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeNotEqualTo(String value) {
            addCriterion("mup_createtime <>", value, "mupCreatetime");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeGreaterThan(String value) {
            addCriterion("mup_createtime >", value, "mupCreatetime");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("mup_createtime >=", value, "mupCreatetime");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeLessThan(String value) {
            addCriterion("mup_createtime <", value, "mupCreatetime");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("mup_createtime <=", value, "mupCreatetime");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeLike(String value) {
            addCriterion("mup_createtime like", value, "mupCreatetime");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeNotLike(String value) {
            addCriterion("mup_createtime not like", value, "mupCreatetime");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeIn(List<String> values) {
            addCriterion("mup_createtime in", values, "mupCreatetime");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeNotIn(List<String> values) {
            addCriterion("mup_createtime not in", values, "mupCreatetime");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeBetween(String value1, String value2) {
            addCriterion("mup_createtime between", value1, value2, "mupCreatetime");
            return (Criteria) this;
        }

        public Criteria andMupCreatetimeNotBetween(String value1, String value2) {
            addCriterion("mup_createtime not between", value1, value2, "mupCreatetime");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserIsNull() {
            addCriterion("mup_createuser is null");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserIsNotNull() {
            addCriterion("mup_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserEqualTo(String value) {
            addCriterion("mup_createuser =", value, "mupCreateuser");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserNotEqualTo(String value) {
            addCriterion("mup_createuser <>", value, "mupCreateuser");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserGreaterThan(String value) {
            addCriterion("mup_createuser >", value, "mupCreateuser");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("mup_createuser >=", value, "mupCreateuser");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserLessThan(String value) {
            addCriterion("mup_createuser <", value, "mupCreateuser");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserLessThanOrEqualTo(String value) {
            addCriterion("mup_createuser <=", value, "mupCreateuser");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserLike(String value) {
            addCriterion("mup_createuser like", value, "mupCreateuser");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserNotLike(String value) {
            addCriterion("mup_createuser not like", value, "mupCreateuser");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserIn(List<String> values) {
            addCriterion("mup_createuser in", values, "mupCreateuser");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserNotIn(List<String> values) {
            addCriterion("mup_createuser not in", values, "mupCreateuser");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserBetween(String value1, String value2) {
            addCriterion("mup_createuser between", value1, value2, "mupCreateuser");
            return (Criteria) this;
        }

        public Criteria andMupCreateuserNotBetween(String value1, String value2) {
            addCriterion("mup_createuser not between", value1, value2, "mupCreateuser");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeIsNull() {
            addCriterion("mup_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeIsNotNull() {
            addCriterion("mup_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeEqualTo(String value) {
            addCriterion("mup_updatetime =", value, "mupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeNotEqualTo(String value) {
            addCriterion("mup_updatetime <>", value, "mupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeGreaterThan(String value) {
            addCriterion("mup_updatetime >", value, "mupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("mup_updatetime >=", value, "mupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeLessThan(String value) {
            addCriterion("mup_updatetime <", value, "mupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("mup_updatetime <=", value, "mupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeLike(String value) {
            addCriterion("mup_updatetime like", value, "mupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeNotLike(String value) {
            addCriterion("mup_updatetime not like", value, "mupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeIn(List<String> values) {
            addCriterion("mup_updatetime in", values, "mupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeNotIn(List<String> values) {
            addCriterion("mup_updatetime not in", values, "mupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeBetween(String value1, String value2) {
            addCriterion("mup_updatetime between", value1, value2, "mupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMupUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("mup_updatetime not between", value1, value2, "mupUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserIsNull() {
            addCriterion("mup_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserIsNotNull() {
            addCriterion("mup_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserEqualTo(String value) {
            addCriterion("mup_updateuser =", value, "mupUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserNotEqualTo(String value) {
            addCriterion("mup_updateuser <>", value, "mupUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserGreaterThan(String value) {
            addCriterion("mup_updateuser >", value, "mupUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("mup_updateuser >=", value, "mupUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserLessThan(String value) {
            addCriterion("mup_updateuser <", value, "mupUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("mup_updateuser <=", value, "mupUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserLike(String value) {
            addCriterion("mup_updateuser like", value, "mupUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserNotLike(String value) {
            addCriterion("mup_updateuser not like", value, "mupUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserIn(List<String> values) {
            addCriterion("mup_updateuser in", values, "mupUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserNotIn(List<String> values) {
            addCriterion("mup_updateuser not in", values, "mupUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserBetween(String value1, String value2) {
            addCriterion("mup_updateuser between", value1, value2, "mupUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMupUpdateuserNotBetween(String value1, String value2) {
            addCriterion("mup_updateuser not between", value1, value2, "mupUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andMupNameLikeInsensitive(String value) {
            addCriterion("upper(mup_name) like", value.toUpperCase(), "mupName");
            return this;
        }

        public Criteria andMupTypeLikeInsensitive(String value) {
            addCriterion("upper(mup_type) like", value.toUpperCase(), "mupType");
            return this;
        }

        public Criteria andMupDescriptionLikeInsensitive(String value) {
            addCriterion("upper(mup_description) like", value.toUpperCase(), "mupDescription");
            return this;
        }

        public Criteria andMupStatusLikeInsensitive(String value) {
            addCriterion("upper(mup_status) like", value.toUpperCase(), "mupStatus");
            return this;
        }

        public Criteria andMupCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(mup_createtime) like", value.toUpperCase(), "mupCreatetime");
            return this;
        }

        public Criteria andMupCreateuserLikeInsensitive(String value) {
            addCriterion("upper(mup_createuser) like", value.toUpperCase(), "mupCreateuser");
            return this;
        }

        public Criteria andMupUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(mup_updatetime) like", value.toUpperCase(), "mupUpdatetime");
            return this;
        }

        public Criteria andMupUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(mup_updateuser) like", value.toUpperCase(), "mupUpdateuser");
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