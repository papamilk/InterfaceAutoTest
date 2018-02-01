package blk.interfacetesting.modle.data;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MstbDynamicParamCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public MstbDynamicParamCriteria() {
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

        public Criteria andMdpIdIsNull() {
            addCriterion("mdp_id is null");
            return (Criteria) this;
        }

        public Criteria andMdpIdIsNotNull() {
            addCriterion("mdp_id is not null");
            return (Criteria) this;
        }

        public Criteria andMdpIdEqualTo(Integer value) {
            addCriterion("mdp_id =", value, "mdpId");
            return (Criteria) this;
        }

        public Criteria andMdpIdNotEqualTo(Integer value) {
            addCriterion("mdp_id <>", value, "mdpId");
            return (Criteria) this;
        }

        public Criteria andMdpIdGreaterThan(Integer value) {
            addCriterion("mdp_id >", value, "mdpId");
            return (Criteria) this;
        }

        public Criteria andMdpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("mdp_id >=", value, "mdpId");
            return (Criteria) this;
        }

        public Criteria andMdpIdLessThan(Integer value) {
            addCriterion("mdp_id <", value, "mdpId");
            return (Criteria) this;
        }

        public Criteria andMdpIdLessThanOrEqualTo(Integer value) {
            addCriterion("mdp_id <=", value, "mdpId");
            return (Criteria) this;
        }

        public Criteria andMdpIdIn(List<Integer> values) {
            addCriterion("mdp_id in", values, "mdpId");
            return (Criteria) this;
        }

        public Criteria andMdpIdNotIn(List<Integer> values) {
            addCriterion("mdp_id not in", values, "mdpId");
            return (Criteria) this;
        }

        public Criteria andMdpIdBetween(Integer value1, Integer value2) {
            addCriterion("mdp_id between", value1, value2, "mdpId");
            return (Criteria) this;
        }

        public Criteria andMdpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("mdp_id not between", value1, value2, "mdpId");
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

        public Criteria andMdpNameIsNull() {
            addCriterion("mdp_name is null");
            return (Criteria) this;
        }

        public Criteria andMdpNameIsNotNull() {
            addCriterion("mdp_name is not null");
            return (Criteria) this;
        }

        public Criteria andMdpNameEqualTo(String value) {
            addCriterion("mdp_name =", value, "mdpName");
            return (Criteria) this;
        }

        public Criteria andMdpNameNotEqualTo(String value) {
            addCriterion("mdp_name <>", value, "mdpName");
            return (Criteria) this;
        }

        public Criteria andMdpNameGreaterThan(String value) {
            addCriterion("mdp_name >", value, "mdpName");
            return (Criteria) this;
        }

        public Criteria andMdpNameGreaterThanOrEqualTo(String value) {
            addCriterion("mdp_name >=", value, "mdpName");
            return (Criteria) this;
        }

        public Criteria andMdpNameLessThan(String value) {
            addCriterion("mdp_name <", value, "mdpName");
            return (Criteria) this;
        }

        public Criteria andMdpNameLessThanOrEqualTo(String value) {
            addCriterion("mdp_name <=", value, "mdpName");
            return (Criteria) this;
        }

        public Criteria andMdpNameLike(String value) {
            addCriterion("mdp_name like", value, "mdpName");
            return (Criteria) this;
        }

        public Criteria andMdpNameNotLike(String value) {
            addCriterion("mdp_name not like", value, "mdpName");
            return (Criteria) this;
        }

        public Criteria andMdpNameIn(List<String> values) {
            addCriterion("mdp_name in", values, "mdpName");
            return (Criteria) this;
        }

        public Criteria andMdpNameNotIn(List<String> values) {
            addCriterion("mdp_name not in", values, "mdpName");
            return (Criteria) this;
        }

        public Criteria andMdpNameBetween(String value1, String value2) {
            addCriterion("mdp_name between", value1, value2, "mdpName");
            return (Criteria) this;
        }

        public Criteria andMdpNameNotBetween(String value1, String value2) {
            addCriterion("mdp_name not between", value1, value2, "mdpName");
            return (Criteria) this;
        }

        public Criteria andMdpTypeIsNull() {
            addCriterion("mdp_type is null");
            return (Criteria) this;
        }

        public Criteria andMdpTypeIsNotNull() {
            addCriterion("mdp_type is not null");
            return (Criteria) this;
        }

        public Criteria andMdpTypeEqualTo(Byte value) {
            addCriterion("mdp_type =", value, "mdpType");
            return (Criteria) this;
        }

        public Criteria andMdpTypeNotEqualTo(Byte value) {
            addCriterion("mdp_type <>", value, "mdpType");
            return (Criteria) this;
        }

        public Criteria andMdpTypeGreaterThan(Byte value) {
            addCriterion("mdp_type >", value, "mdpType");
            return (Criteria) this;
        }

        public Criteria andMdpTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("mdp_type >=", value, "mdpType");
            return (Criteria) this;
        }

        public Criteria andMdpTypeLessThan(Byte value) {
            addCriterion("mdp_type <", value, "mdpType");
            return (Criteria) this;
        }

        public Criteria andMdpTypeLessThanOrEqualTo(Byte value) {
            addCriterion("mdp_type <=", value, "mdpType");
            return (Criteria) this;
        }

        public Criteria andMdpTypeIn(List<Byte> values) {
            addCriterion("mdp_type in", values, "mdpType");
            return (Criteria) this;
        }

        public Criteria andMdpTypeNotIn(List<Byte> values) {
            addCriterion("mdp_type not in", values, "mdpType");
            return (Criteria) this;
        }

        public Criteria andMdpTypeBetween(Byte value1, Byte value2) {
            addCriterion("mdp_type between", value1, value2, "mdpType");
            return (Criteria) this;
        }

        public Criteria andMdpTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("mdp_type not between", value1, value2, "mdpType");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaIsNull() {
            addCriterion("mdp_formula is null");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaIsNotNull() {
            addCriterion("mdp_formula is not null");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaEqualTo(String value) {
            addCriterion("mdp_formula =", value, "mdpFormula");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaNotEqualTo(String value) {
            addCriterion("mdp_formula <>", value, "mdpFormula");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaGreaterThan(String value) {
            addCriterion("mdp_formula >", value, "mdpFormula");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaGreaterThanOrEqualTo(String value) {
            addCriterion("mdp_formula >=", value, "mdpFormula");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaLessThan(String value) {
            addCriterion("mdp_formula <", value, "mdpFormula");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaLessThanOrEqualTo(String value) {
            addCriterion("mdp_formula <=", value, "mdpFormula");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaLike(String value) {
            addCriterion("mdp_formula like", value, "mdpFormula");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaNotLike(String value) {
            addCriterion("mdp_formula not like", value, "mdpFormula");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaIn(List<String> values) {
            addCriterion("mdp_formula in", values, "mdpFormula");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaNotIn(List<String> values) {
            addCriterion("mdp_formula not in", values, "mdpFormula");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaBetween(String value1, String value2) {
            addCriterion("mdp_formula between", value1, value2, "mdpFormula");
            return (Criteria) this;
        }

        public Criteria andMdpFormulaNotBetween(String value1, String value2) {
            addCriterion("mdp_formula not between", value1, value2, "mdpFormula");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionIsNull() {
            addCriterion("mdp_description is null");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionIsNotNull() {
            addCriterion("mdp_description is not null");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionEqualTo(String value) {
            addCriterion("mdp_description =", value, "mdpDescription");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionNotEqualTo(String value) {
            addCriterion("mdp_description <>", value, "mdpDescription");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionGreaterThan(String value) {
            addCriterion("mdp_description >", value, "mdpDescription");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("mdp_description >=", value, "mdpDescription");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionLessThan(String value) {
            addCriterion("mdp_description <", value, "mdpDescription");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionLessThanOrEqualTo(String value) {
            addCriterion("mdp_description <=", value, "mdpDescription");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionLike(String value) {
            addCriterion("mdp_description like", value, "mdpDescription");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionNotLike(String value) {
            addCriterion("mdp_description not like", value, "mdpDescription");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionIn(List<String> values) {
            addCriterion("mdp_description in", values, "mdpDescription");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionNotIn(List<String> values) {
            addCriterion("mdp_description not in", values, "mdpDescription");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionBetween(String value1, String value2) {
            addCriterion("mdp_description between", value1, value2, "mdpDescription");
            return (Criteria) this;
        }

        public Criteria andMdpDescriptionNotBetween(String value1, String value2) {
            addCriterion("mdp_description not between", value1, value2, "mdpDescription");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("create_user like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("create_user not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("update_user is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("update_user is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("update_user =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("update_user <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("update_user >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("update_user >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("update_user <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("update_user <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("update_user like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("update_user not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("update_user in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("update_user not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("update_user between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("update_user not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andMdpNameLikeInsensitive(String value) {
            addCriterion("upper(mdp_name) like", value.toUpperCase(), "mdpName");
            return this;
        }

        public Criteria andMdpFormulaLikeInsensitive(String value) {
            addCriterion("upper(mdp_formula) like", value.toUpperCase(), "mdpFormula");
            return this;
        }

        public Criteria andMdpDescriptionLikeInsensitive(String value) {
            addCriterion("upper(mdp_description) like", value.toUpperCase(), "mdpDescription");
            return this;
        }

        public Criteria andCreateUserLikeInsensitive(String value) {
            addCriterion("upper(create_user) like", value.toUpperCase(), "createUser");
            return this;
        }

        public Criteria andUpdateUserLikeInsensitive(String value) {
            addCriterion("upper(update_user) like", value.toUpperCase(), "updateUser");
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