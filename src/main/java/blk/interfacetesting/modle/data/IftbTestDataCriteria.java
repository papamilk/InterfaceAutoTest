package blk.interfacetesting.modle.data;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class IftbTestDataCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    /**
     * search mtcName and mumName
     */
    protected boolean specialSearch;

    public boolean isSpecialSearch() {
        return specialSearch;
    }

    public void setSpecialSearch(boolean specialSearch) {
        this.specialSearch = specialSearch;
    }

    /**
     * add for merge search with dependency by Saul
     */
    protected boolean addDependency;

    public boolean isAddDependency() {
        return addDependency;
    }

    public void setAddDependency(boolean addDependency) {
        this.addDependency = addDependency;
    }

    public IftbTestDataCriteria() {
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

        public Criteria andItdNumberIsNull() {
            addCriterion("itd_number is null");
            return (Criteria) this;
        }

        public Criteria andItdNumberIsNotNull() {
            addCriterion("itd_number is not null");
            return (Criteria) this;
        }

        public Criteria andItdNumberEqualTo(String value) {
            addCriterion("itd_number =", value, "itdNumber");
            return (Criteria) this;
        }

        public Criteria andItdNumberNotEqualTo(String value) {
            addCriterion("itd_number <>", value, "itdNumber");
            return (Criteria) this;
        }

        public Criteria andItdNumberGreaterThan(String value) {
            addCriterion("itd_number >", value, "itdNumber");
            return (Criteria) this;
        }

        public Criteria andItdNumberGreaterThanOrEqualTo(String value) {
            addCriterion("itd_number >=", value, "itdNumber");
            return (Criteria) this;
        }

        public Criteria andItdNumberLessThan(String value) {
            addCriterion("itd_number <", value, "itdNumber");
            return (Criteria) this;
        }

        public Criteria andItdNumberLessThanOrEqualTo(String value) {
            addCriterion("itd_number <=", value, "itdNumber");
            return (Criteria) this;
        }

        public Criteria andItdNumberLike(String value) {
            addCriterion("itd_number like", value, "itdNumber");
            return (Criteria) this;
        }

        public Criteria andItdNumberNotLike(String value) {
            addCriterion("itd_number not like", value, "itdNumber");
            return (Criteria) this;
        }

        public Criteria andItdNumberIn(List<String> values) {
            addCriterion("itd_number in", values, "itdNumber");
            return (Criteria) this;
        }

        public Criteria andItdNumberNotIn(List<String> values) {
            addCriterion("itd_number not in", values, "itdNumber");
            return (Criteria) this;
        }

        public Criteria andItdNumberBetween(String value1, String value2) {
            addCriterion("itd_number between", value1, value2, "itdNumber");
            return (Criteria) this;
        }

        public Criteria andItdNumberNotBetween(String value1, String value2) {
            addCriterion("itd_number not between", value1, value2, "itdNumber");
            return (Criteria) this;
        }

        public Criteria andItdNameIsNull() {
            addCriterion("itd_name is null");
            return (Criteria) this;
        }

        public Criteria andItdNameIsNotNull() {
            addCriterion("itd_name is not null");
            return (Criteria) this;
        }

        public Criteria andItdNameEqualTo(String value) {
            addCriterion("itd_name =", value, "itdName");
            return (Criteria) this;
        }

        public Criteria andItdNameNotEqualTo(String value) {
            addCriterion("itd_name <>", value, "itdName");
            return (Criteria) this;
        }

        public Criteria andItdNameGreaterThan(String value) {
            addCriterion("itd_name >", value, "itdName");
            return (Criteria) this;
        }

        public Criteria andItdNameGreaterThanOrEqualTo(String value) {
            addCriterion("itd_name >=", value, "itdName");
            return (Criteria) this;
        }

        public Criteria andItdNameLessThan(String value) {
            addCriterion("itd_name <", value, "itdName");
            return (Criteria) this;
        }

        public Criteria andItdNameLessThanOrEqualTo(String value) {
            addCriterion("itd_name <=", value, "itdName");
            return (Criteria) this;
        }

        public Criteria andItdNameLike(String value) {
            addCriterion("itd_name like", value, "itdName");
            return (Criteria) this;
        }

        public Criteria andItdNameNotLike(String value) {
            addCriterion("itd_name not like", value, "itdName");
            return (Criteria) this;
        }

        public Criteria andItdNameIn(List<String> values) {
            addCriterion("itd_name in", values, "itdName");
            return (Criteria) this;
        }

        public Criteria andItdNameNotIn(List<String> values) {
            addCriterion("itd_name not in", values, "itdName");
            return (Criteria) this;
        }

        public Criteria andItdNameBetween(String value1, String value2) {
            addCriterion("itd_name between", value1, value2, "itdName");
            return (Criteria) this;
        }

        public Criteria andItdNameNotBetween(String value1, String value2) {
            addCriterion("itd_name not between", value1, value2, "itdName");
            return (Criteria) this;
        }

        public Criteria andItdColsIsNull() {
            addCriterion("itd_cols is null");
            return (Criteria) this;
        }

        public Criteria andItdColsIsNotNull() {
            addCriterion("itd_cols is not null");
            return (Criteria) this;
        }

        public Criteria andItdColsEqualTo(String value) {
            addCriterion("itd_cols =", value, "itdCols");
            return (Criteria) this;
        }

        public Criteria andItdColsNotEqualTo(String value) {
            addCriterion("itd_cols <>", value, "itdCols");
            return (Criteria) this;
        }

        public Criteria andItdColsGreaterThan(String value) {
            addCriterion("itd_cols >", value, "itdCols");
            return (Criteria) this;
        }

        public Criteria andItdColsGreaterThanOrEqualTo(String value) {
            addCriterion("itd_cols >=", value, "itdCols");
            return (Criteria) this;
        }

        public Criteria andItdColsLessThan(String value) {
            addCriterion("itd_cols <", value, "itdCols");
            return (Criteria) this;
        }

        public Criteria andItdColsLessThanOrEqualTo(String value) {
            addCriterion("itd_cols <=", value, "itdCols");
            return (Criteria) this;
        }

        public Criteria andItdColsLike(String value) {
            addCriterion("itd_cols like", value, "itdCols");
            return (Criteria) this;
        }

        public Criteria andItdColsNotLike(String value) {
            addCriterion("itd_cols not like", value, "itdCols");
            return (Criteria) this;
        }

        public Criteria andItdColsIn(List<String> values) {
            addCriterion("itd_cols in", values, "itdCols");
            return (Criteria) this;
        }

        public Criteria andItdColsNotIn(List<String> values) {
            addCriterion("itd_cols not in", values, "itdCols");
            return (Criteria) this;
        }

        public Criteria andItdColsBetween(String value1, String value2) {
            addCriterion("itd_cols between", value1, value2, "itdCols");
            return (Criteria) this;
        }

        public Criteria andItdColsNotBetween(String value1, String value2) {
            addCriterion("itd_cols not between", value1, value2, "itdCols");
            return (Criteria) this;
        }

        public Criteria andItdValuesIsNull() {
            addCriterion("itd_values is null");
            return (Criteria) this;
        }

        public Criteria andItdValuesIsNotNull() {
            addCriterion("itd_values is not null");
            return (Criteria) this;
        }

        public Criteria andItdValuesEqualTo(String value) {
            addCriterion("itd_values =", value, "itdValues");
            return (Criteria) this;
        }

        public Criteria andItdValuesNotEqualTo(String value) {
            addCriterion("itd_values <>", value, "itdValues");
            return (Criteria) this;
        }

        public Criteria andItdValuesGreaterThan(String value) {
            addCriterion("itd_values >", value, "itdValues");
            return (Criteria) this;
        }

        public Criteria andItdValuesGreaterThanOrEqualTo(String value) {
            addCriterion("itd_values >=", value, "itdValues");
            return (Criteria) this;
        }

        public Criteria andItdValuesLessThan(String value) {
            addCriterion("itd_values <", value, "itdValues");
            return (Criteria) this;
        }

        public Criteria andItdValuesLessThanOrEqualTo(String value) {
            addCriterion("itd_values <=", value, "itdValues");
            return (Criteria) this;
        }

        public Criteria andItdValuesLike(String value) {
            addCriterion("itd_values like", value, "itdValues");
            return (Criteria) this;
        }

        public Criteria andItdValuesNotLike(String value) {
            addCriterion("itd_values not like", value, "itdValues");
            return (Criteria) this;
        }

        public Criteria andItdValuesIn(List<String> values) {
            addCriterion("itd_values in", values, "itdValues");
            return (Criteria) this;
        }

        public Criteria andItdValuesNotIn(List<String> values) {
            addCriterion("itd_values not in", values, "itdValues");
            return (Criteria) this;
        }

        public Criteria andItdValuesBetween(String value1, String value2) {
            addCriterion("itd_values between", value1, value2, "itdValues");
            return (Criteria) this;
        }

        public Criteria andItdValuesNotBetween(String value1, String value2) {
            addCriterion("itd_values not between", value1, value2, "itdValues");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesIsNull() {
            addCriterion("itd_param_types is null");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesIsNotNull() {
            addCriterion("itd_param_types is not null");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesEqualTo(String value) {
            addCriterion("itd_param_types =", value, "itdParamTypes");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesNotEqualTo(String value) {
            addCriterion("itd_param_types <>", value, "itdParamTypes");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesGreaterThan(String value) {
            addCriterion("itd_param_types >", value, "itdParamTypes");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesGreaterThanOrEqualTo(String value) {
            addCriterion("itd_param_types >=", value, "itdParamTypes");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesLessThan(String value) {
            addCriterion("itd_param_types <", value, "itdParamTypes");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesLessThanOrEqualTo(String value) {
            addCriterion("itd_param_types <=", value, "itdParamTypes");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesLike(String value) {
            addCriterion("itd_param_types like", value, "itdParamTypes");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesNotLike(String value) {
            addCriterion("itd_param_types not like", value, "itdParamTypes");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesIn(List<String> values) {
            addCriterion("itd_param_types in", values, "itdParamTypes");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesNotIn(List<String> values) {
            addCriterion("itd_param_types not in", values, "itdParamTypes");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesBetween(String value1, String value2) {
            addCriterion("itd_param_types between", value1, value2, "itdParamTypes");
            return (Criteria) this;
        }

        public Criteria andItdParamTypesNotBetween(String value1, String value2) {
            addCriterion("itd_param_types not between", value1, value2, "itdParamTypes");
            return (Criteria) this;
        }

        public Criteria andItdTypeIsNull() {
            addCriterion("itd_type is null");
            return (Criteria) this;
        }

        public Criteria andItdTypeIsNotNull() {
            addCriterion("itd_type is not null");
            return (Criteria) this;
        }

        public Criteria andItdTypeEqualTo(Integer value) {
            addCriterion("itd_type =", value, "itdType");
            return (Criteria) this;
        }

        public Criteria andItdTypeNotEqualTo(Integer value) {
            addCriterion("itd_type <>", value, "itdType");
            return (Criteria) this;
        }

        public Criteria andItdTypeGreaterThan(Integer value) {
            addCriterion("itd_type >", value, "itdType");
            return (Criteria) this;
        }

        public Criteria andItdTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("itd_type >=", value, "itdType");
            return (Criteria) this;
        }

        public Criteria andItdTypeLessThan(Integer value) {
            addCriterion("itd_type <", value, "itdType");
            return (Criteria) this;
        }

        public Criteria andItdTypeLessThanOrEqualTo(Integer value) {
            addCriterion("itd_type <=", value, "itdType");
            return (Criteria) this;
        }

        public Criteria andItdTypeIn(List<Integer> values) {
            addCriterion("itd_type in", values, "itdType");
            return (Criteria) this;
        }

        public Criteria andItdTypeNotIn(List<Integer> values) {
            addCriterion("itd_type not in", values, "itdType");
            return (Criteria) this;
        }

        public Criteria andItdTypeBetween(Integer value1, Integer value2) {
            addCriterion("itd_type between", value1, value2, "itdType");
            return (Criteria) this;
        }

        public Criteria andItdTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("itd_type not between", value1, value2, "itdType");
            return (Criteria) this;
        }

        public Criteria andItdExpectTimeIsNull() {
            addCriterion("itd_expect_time is null");
            return (Criteria) this;
        }

        public Criteria andItdExpectTimeIsNotNull() {
            addCriterion("itd_expect_time is not null");
            return (Criteria) this;
        }

        public Criteria andItdExpectTimeEqualTo(Integer value) {
            addCriterion("itd_expect_time =", value, "itdExpectTime");
            return (Criteria) this;
        }

        public Criteria andItdExpectTimeNotEqualTo(Integer value) {
            addCriterion("itd_expect_time <>", value, "itdExpectTime");
            return (Criteria) this;
        }

        public Criteria andItdExpectTimeGreaterThan(Integer value) {
            addCriterion("itd_expect_time >", value, "itdExpectTime");
            return (Criteria) this;
        }

        public Criteria andItdExpectTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("itd_expect_time >=", value, "itdExpectTime");
            return (Criteria) this;
        }

        public Criteria andItdExpectTimeLessThan(Integer value) {
            addCriterion("itd_expect_time <", value, "itdExpectTime");
            return (Criteria) this;
        }

        public Criteria andItdExpectTimeLessThanOrEqualTo(Integer value) {
            addCriterion("itd_expect_time <=", value, "itdExpectTime");
            return (Criteria) this;
        }

        public Criteria andItdExpectTimeIn(List<Integer> values) {
            addCriterion("itd_expect_time in", values, "itdExpectTime");
            return (Criteria) this;
        }

        public Criteria andItdExpectTimeNotIn(List<Integer> values) {
            addCriterion("itd_expect_time not in", values, "itdExpectTime");
            return (Criteria) this;
        }

        public Criteria andItdExpectTimeBetween(Integer value1, Integer value2) {
            addCriterion("itd_expect_time between", value1, value2, "itdExpectTime");
            return (Criteria) this;
        }

        public Criteria andItdExpectTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("itd_expect_time not between", value1, value2, "itdExpectTime");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeIsNull() {
            addCriterion("itd_expect_result_type is null");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeIsNotNull() {
            addCriterion("itd_expect_result_type is not null");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeEqualTo(String value) {
            addCriterion("itd_expect_result_type =", value, "itdExpectResultType");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeNotEqualTo(String value) {
            addCriterion("itd_expect_result_type <>", value, "itdExpectResultType");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeGreaterThan(String value) {
            addCriterion("itd_expect_result_type >", value, "itdExpectResultType");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeGreaterThanOrEqualTo(String value) {
            addCriterion("itd_expect_result_type >=", value, "itdExpectResultType");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeLessThan(String value) {
            addCriterion("itd_expect_result_type <", value, "itdExpectResultType");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeLessThanOrEqualTo(String value) {
            addCriterion("itd_expect_result_type <=", value, "itdExpectResultType");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeLike(String value) {
            addCriterion("itd_expect_result_type like", value, "itdExpectResultType");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeNotLike(String value) {
            addCriterion("itd_expect_result_type not like", value, "itdExpectResultType");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeIn(List<String> values) {
            addCriterion("itd_expect_result_type in", values, "itdExpectResultType");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeNotIn(List<String> values) {
            addCriterion("itd_expect_result_type not in", values, "itdExpectResultType");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeBetween(String value1, String value2) {
            addCriterion("itd_expect_result_type between", value1, value2, "itdExpectResultType");
            return (Criteria) this;
        }

        public Criteria andItdExpectResultTypeNotBetween(String value1, String value2) {
            addCriterion("itd_expect_result_type not between", value1, value2, "itdExpectResultType");
            return (Criteria) this;
        }

        public Criteria andItdSqlIsNull() {
            addCriterion("itd_sql is null");
            return (Criteria) this;
        }

        public Criteria andItdSqlIsNotNull() {
            addCriterion("itd_sql is not null");
            return (Criteria) this;
        }

        public Criteria andItdSqlEqualTo(String value) {
            addCriterion("itd_sql =", value, "itdSql");
            return (Criteria) this;
        }

        public Criteria andItdSqlNotEqualTo(String value) {
            addCriterion("itd_sql <>", value, "itdSql");
            return (Criteria) this;
        }

        public Criteria andItdSqlGreaterThan(String value) {
            addCriterion("itd_sql >", value, "itdSql");
            return (Criteria) this;
        }

        public Criteria andItdSqlGreaterThanOrEqualTo(String value) {
            addCriterion("itd_sql >=", value, "itdSql");
            return (Criteria) this;
        }

        public Criteria andItdSqlLessThan(String value) {
            addCriterion("itd_sql <", value, "itdSql");
            return (Criteria) this;
        }

        public Criteria andItdSqlLessThanOrEqualTo(String value) {
            addCriterion("itd_sql <=", value, "itdSql");
            return (Criteria) this;
        }

        public Criteria andItdSqlLike(String value) {
            addCriterion("itd_sql like", value, "itdSql");
            return (Criteria) this;
        }

        public Criteria andItdSqlNotLike(String value) {
            addCriterion("itd_sql not like", value, "itdSql");
            return (Criteria) this;
        }

        public Criteria andItdSqlIn(List<String> values) {
            addCriterion("itd_sql in", values, "itdSql");
            return (Criteria) this;
        }

        public Criteria andItdSqlNotIn(List<String> values) {
            addCriterion("itd_sql not in", values, "itdSql");
            return (Criteria) this;
        }

        public Criteria andItdSqlBetween(String value1, String value2) {
            addCriterion("itd_sql between", value1, value2, "itdSql");
            return (Criteria) this;
        }

        public Criteria andItdSqlNotBetween(String value1, String value2) {
            addCriterion("itd_sql not between", value1, value2, "itdSql");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultIsNull() {
            addCriterion("itd_sql_expect_result is null");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultIsNotNull() {
            addCriterion("itd_sql_expect_result is not null");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultEqualTo(String value) {
            addCriterion("itd_sql_expect_result =", value, "itdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultNotEqualTo(String value) {
            addCriterion("itd_sql_expect_result <>", value, "itdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultGreaterThan(String value) {
            addCriterion("itd_sql_expect_result >", value, "itdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultGreaterThanOrEqualTo(String value) {
            addCriterion("itd_sql_expect_result >=", value, "itdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultLessThan(String value) {
            addCriterion("itd_sql_expect_result <", value, "itdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultLessThanOrEqualTo(String value) {
            addCriterion("itd_sql_expect_result <=", value, "itdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultLike(String value) {
            addCriterion("itd_sql_expect_result like", value, "itdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultNotLike(String value) {
            addCriterion("itd_sql_expect_result not like", value, "itdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultIn(List<String> values) {
            addCriterion("itd_sql_expect_result in", values, "itdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultNotIn(List<String> values) {
            addCriterion("itd_sql_expect_result not in", values, "itdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultBetween(String value1, String value2) {
            addCriterion("itd_sql_expect_result between", value1, value2, "itdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andItdSqlExpectResultNotBetween(String value1, String value2) {
            addCriterion("itd_sql_expect_result not between", value1, value2, "itdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andItdStatusIsNull() {
            addCriterion("itd_status is null");
            return (Criteria) this;
        }

        public Criteria andItdStatusIsNotNull() {
            addCriterion("itd_status is not null");
            return (Criteria) this;
        }

        public Criteria andItdStatusEqualTo(String value) {
            addCriterion("itd_status =", value, "itdStatus");
            return (Criteria) this;
        }

        public Criteria andItdStatusNotEqualTo(String value) {
            addCriterion("itd_status <>", value, "itdStatus");
            return (Criteria) this;
        }

        public Criteria andItdStatusGreaterThan(String value) {
            addCriterion("itd_status >", value, "itdStatus");
            return (Criteria) this;
        }

        public Criteria andItdStatusGreaterThanOrEqualTo(String value) {
            addCriterion("itd_status >=", value, "itdStatus");
            return (Criteria) this;
        }

        public Criteria andItdStatusLessThan(String value) {
            addCriterion("itd_status <", value, "itdStatus");
            return (Criteria) this;
        }

        public Criteria andItdStatusLessThanOrEqualTo(String value) {
            addCriterion("itd_status <=", value, "itdStatus");
            return (Criteria) this;
        }

        public Criteria andItdStatusLike(String value) {
            addCriterion("itd_status like", value, "itdStatus");
            return (Criteria) this;
        }

        public Criteria andItdStatusNotLike(String value) {
            addCriterion("itd_status not like", value, "itdStatus");
            return (Criteria) this;
        }

        public Criteria andItdStatusIn(List<String> values) {
            addCriterion("itd_status in", values, "itdStatus");
            return (Criteria) this;
        }

        public Criteria andItdStatusNotIn(List<String> values) {
            addCriterion("itd_status not in", values, "itdStatus");
            return (Criteria) this;
        }

        public Criteria andItdStatusBetween(String value1, String value2) {
            addCriterion("itd_status between", value1, value2, "itdStatus");
            return (Criteria) this;
        }

        public Criteria andItdStatusNotBetween(String value1, String value2) {
            addCriterion("itd_status not between", value1, value2, "itdStatus");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeIsNull() {
            addCriterion("itd_createtime is null");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeIsNotNull() {
            addCriterion("itd_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeEqualTo(String value) {
            addCriterion("itd_createtime =", value, "itdCreatetime");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeNotEqualTo(String value) {
            addCriterion("itd_createtime <>", value, "itdCreatetime");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeGreaterThan(String value) {
            addCriterion("itd_createtime >", value, "itdCreatetime");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("itd_createtime >=", value, "itdCreatetime");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeLessThan(String value) {
            addCriterion("itd_createtime <", value, "itdCreatetime");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("itd_createtime <=", value, "itdCreatetime");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeLike(String value) {
            addCriterion("itd_createtime like", value, "itdCreatetime");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeNotLike(String value) {
            addCriterion("itd_createtime not like", value, "itdCreatetime");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeIn(List<String> values) {
            addCriterion("itd_createtime in", values, "itdCreatetime");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeNotIn(List<String> values) {
            addCriterion("itd_createtime not in", values, "itdCreatetime");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeBetween(String value1, String value2) {
            addCriterion("itd_createtime between", value1, value2, "itdCreatetime");
            return (Criteria) this;
        }

        public Criteria andItdCreatetimeNotBetween(String value1, String value2) {
            addCriterion("itd_createtime not between", value1, value2, "itdCreatetime");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserIsNull() {
            addCriterion("itd_createuser is null");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserIsNotNull() {
            addCriterion("itd_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserEqualTo(String value) {
            addCriterion("itd_createuser =", value, "itdCreateuser");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserNotEqualTo(String value) {
            addCriterion("itd_createuser <>", value, "itdCreateuser");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserGreaterThan(String value) {
            addCriterion("itd_createuser >", value, "itdCreateuser");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("itd_createuser >=", value, "itdCreateuser");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserLessThan(String value) {
            addCriterion("itd_createuser <", value, "itdCreateuser");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserLessThanOrEqualTo(String value) {
            addCriterion("itd_createuser <=", value, "itdCreateuser");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserLike(String value) {
            addCriterion("itd_createuser like", value, "itdCreateuser");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserNotLike(String value) {
            addCriterion("itd_createuser not like", value, "itdCreateuser");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserIn(List<String> values) {
            addCriterion("itd_createuser in", values, "itdCreateuser");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserNotIn(List<String> values) {
            addCriterion("itd_createuser not in", values, "itdCreateuser");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserBetween(String value1, String value2) {
            addCriterion("itd_createuser between", value1, value2, "itdCreateuser");
            return (Criteria) this;
        }

        public Criteria andItdCreateuserNotBetween(String value1, String value2) {
            addCriterion("itd_createuser not between", value1, value2, "itdCreateuser");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeIsNull() {
            addCriterion("itd_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeIsNotNull() {
            addCriterion("itd_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeEqualTo(String value) {
            addCriterion("itd_updatetime =", value, "itdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeNotEqualTo(String value) {
            addCriterion("itd_updatetime <>", value, "itdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeGreaterThan(String value) {
            addCriterion("itd_updatetime >", value, "itdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("itd_updatetime >=", value, "itdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeLessThan(String value) {
            addCriterion("itd_updatetime <", value, "itdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("itd_updatetime <=", value, "itdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeLike(String value) {
            addCriterion("itd_updatetime like", value, "itdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeNotLike(String value) {
            addCriterion("itd_updatetime not like", value, "itdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeIn(List<String> values) {
            addCriterion("itd_updatetime in", values, "itdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeNotIn(List<String> values) {
            addCriterion("itd_updatetime not in", values, "itdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeBetween(String value1, String value2) {
            addCriterion("itd_updatetime between", value1, value2, "itdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItdUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("itd_updatetime not between", value1, value2, "itdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserIsNull() {
            addCriterion("itd_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserIsNotNull() {
            addCriterion("itd_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserEqualTo(String value) {
            addCriterion("itd_updateuser =", value, "itdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserNotEqualTo(String value) {
            addCriterion("itd_updateuser <>", value, "itdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserGreaterThan(String value) {
            addCriterion("itd_updateuser >", value, "itdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("itd_updateuser >=", value, "itdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserLessThan(String value) {
            addCriterion("itd_updateuser <", value, "itdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("itd_updateuser <=", value, "itdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserLike(String value) {
            addCriterion("itd_updateuser like", value, "itdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserNotLike(String value) {
            addCriterion("itd_updateuser not like", value, "itdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserIn(List<String> values) {
            addCriterion("itd_updateuser in", values, "itdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserNotIn(List<String> values) {
            addCriterion("itd_updateuser not in", values, "itdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserBetween(String value1, String value2) {
            addCriterion("itd_updateuser between", value1, value2, "itdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andItdUpdateuserNotBetween(String value1, String value2) {
            addCriterion("itd_updateuser not between", value1, value2, "itdUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andItdNumberLikeInsensitive(String value) {
            addCriterion("upper(itd_number) like", value.toUpperCase(), "itdNumber");
            return this;
        }

        public Criteria andItdNameLikeInsensitive(String value) {
            addCriterion("upper(itd_name) like", value.toUpperCase(), "itdName");
            return this;
        }

        public Criteria andItdColsLikeInsensitive(String value) {
            addCriterion("upper(itd_cols) like", value.toUpperCase(), "itdCols");
            return this;
        }

        public Criteria andItdValuesLikeInsensitive(String value) {
            addCriterion("upper(itd_values) like", value.toUpperCase(), "itdValues");
            return this;
        }

        public Criteria andItdParamTypesLikeInsensitive(String value) {
            addCriterion("upper(itd_param_types) like", value.toUpperCase(), "itdParamTypes");
            return this;
        }

        public Criteria andItdExpectResultTypeLikeInsensitive(String value) {
            addCriterion("upper(itd_expect_result_type) like", value.toUpperCase(), "itdExpectResultType");
            return this;
        }

        public Criteria andItdSqlLikeInsensitive(String value) {
            addCriterion("upper(itd_sql) like", value.toUpperCase(), "itdSql");
            return this;
        }

        public Criteria andItdSqlExpectResultLikeInsensitive(String value) {
            addCriterion("upper(itd_sql_expect_result) like", value.toUpperCase(), "itdSqlExpectResult");
            return this;
        }

        public Criteria andItdStatusLikeInsensitive(String value) {
            addCriterion("upper(itd_status) like", value.toUpperCase(), "itdStatus");
            return this;
        }

        public Criteria andItdCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(itd_createtime) like", value.toUpperCase(), "itdCreatetime");
            return this;
        }

        public Criteria andItdCreateuserLikeInsensitive(String value) {
            addCriterion("upper(itd_createuser) like", value.toUpperCase(), "itdCreateuser");
            return this;
        }

        public Criteria andItdUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(itd_updatetime) like", value.toUpperCase(), "itdUpdatetime");
            return this;
        }

        public Criteria andItdUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(itd_updateuser) like", value.toUpperCase(), "itdUpdateuser");
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