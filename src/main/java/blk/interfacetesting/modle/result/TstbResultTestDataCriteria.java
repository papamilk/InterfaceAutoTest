package blk.interfacetesting.modle.result;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class TstbResultTestDataCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TstbResultTestDataCriteria() {
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

        public Criteria andTrtdIdIsNull() {
            addCriterion("trtd_id is null");
            return (Criteria) this;
        }

        public Criteria andTrtdIdIsNotNull() {
            addCriterion("trtd_id is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdIdEqualTo(Integer value) {
            addCriterion("trtd_id =", value, "trtdId");
            return (Criteria) this;
        }

        public Criteria andTrtdIdNotEqualTo(Integer value) {
            addCriterion("trtd_id <>", value, "trtdId");
            return (Criteria) this;
        }

        public Criteria andTrtdIdGreaterThan(Integer value) {
            addCriterion("trtd_id >", value, "trtdId");
            return (Criteria) this;
        }

        public Criteria andTrtdIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("trtd_id >=", value, "trtdId");
            return (Criteria) this;
        }

        public Criteria andTrtdIdLessThan(Integer value) {
            addCriterion("trtd_id <", value, "trtdId");
            return (Criteria) this;
        }

        public Criteria andTrtdIdLessThanOrEqualTo(Integer value) {
            addCriterion("trtd_id <=", value, "trtdId");
            return (Criteria) this;
        }

        public Criteria andTrtdIdIn(List<Integer> values) {
            addCriterion("trtd_id in", values, "trtdId");
            return (Criteria) this;
        }

        public Criteria andTrtdIdNotIn(List<Integer> values) {
            addCriterion("trtd_id not in", values, "trtdId");
            return (Criteria) this;
        }

        public Criteria andTrtdIdBetween(Integer value1, Integer value2) {
            addCriterion("trtd_id between", value1, value2, "trtdId");
            return (Criteria) this;
        }

        public Criteria andTrtdIdNotBetween(Integer value1, Integer value2) {
            addCriterion("trtd_id not between", value1, value2, "trtdId");
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

        public Criteria andTruIdIsNull() {
            addCriterion("tru_id is null");
            return (Criteria) this;
        }

        public Criteria andTruIdIsNotNull() {
            addCriterion("tru_id is not null");
            return (Criteria) this;
        }

        public Criteria andTruIdEqualTo(Integer value) {
            addCriterion("tru_id =", value, "truId");
            return (Criteria) this;
        }

        public Criteria andTruIdNotEqualTo(Integer value) {
            addCriterion("tru_id <>", value, "truId");
            return (Criteria) this;
        }

        public Criteria andTruIdGreaterThan(Integer value) {
            addCriterion("tru_id >", value, "truId");
            return (Criteria) this;
        }

        public Criteria andTruIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tru_id >=", value, "truId");
            return (Criteria) this;
        }

        public Criteria andTruIdLessThan(Integer value) {
            addCriterion("tru_id <", value, "truId");
            return (Criteria) this;
        }

        public Criteria andTruIdLessThanOrEqualTo(Integer value) {
            addCriterion("tru_id <=", value, "truId");
            return (Criteria) this;
        }

        public Criteria andTruIdIn(List<Integer> values) {
            addCriterion("tru_id in", values, "truId");
            return (Criteria) this;
        }

        public Criteria andTruIdNotIn(List<Integer> values) {
            addCriterion("tru_id not in", values, "truId");
            return (Criteria) this;
        }

        public Criteria andTruIdBetween(Integer value1, Integer value2) {
            addCriterion("tru_id between", value1, value2, "truId");
            return (Criteria) this;
        }

        public Criteria andTruIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tru_id not between", value1, value2, "truId");
            return (Criteria) this;
        }

        public Criteria andTrtdNameIsNull() {
            addCriterion("trtd_name is null");
            return (Criteria) this;
        }

        public Criteria andTrtdNameIsNotNull() {
            addCriterion("trtd_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdNameEqualTo(String value) {
            addCriterion("trtd_name =", value, "trtdName");
            return (Criteria) this;
        }

        public Criteria andTrtdNameNotEqualTo(String value) {
            addCriterion("trtd_name <>", value, "trtdName");
            return (Criteria) this;
        }

        public Criteria andTrtdNameGreaterThan(String value) {
            addCriterion("trtd_name >", value, "trtdName");
            return (Criteria) this;
        }

        public Criteria andTrtdNameGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_name >=", value, "trtdName");
            return (Criteria) this;
        }

        public Criteria andTrtdNameLessThan(String value) {
            addCriterion("trtd_name <", value, "trtdName");
            return (Criteria) this;
        }

        public Criteria andTrtdNameLessThanOrEqualTo(String value) {
            addCriterion("trtd_name <=", value, "trtdName");
            return (Criteria) this;
        }

        public Criteria andTrtdNameLike(String value) {
            addCriterion("trtd_name like", value, "trtdName");
            return (Criteria) this;
        }

        public Criteria andTrtdNameNotLike(String value) {
            addCriterion("trtd_name not like", value, "trtdName");
            return (Criteria) this;
        }

        public Criteria andTrtdNameIn(List<String> values) {
            addCriterion("trtd_name in", values, "trtdName");
            return (Criteria) this;
        }

        public Criteria andTrtdNameNotIn(List<String> values) {
            addCriterion("trtd_name not in", values, "trtdName");
            return (Criteria) this;
        }

        public Criteria andTrtdNameBetween(String value1, String value2) {
            addCriterion("trtd_name between", value1, value2, "trtdName");
            return (Criteria) this;
        }

        public Criteria andTrtdNameNotBetween(String value1, String value2) {
            addCriterion("trtd_name not between", value1, value2, "trtdName");
            return (Criteria) this;
        }

        public Criteria andTrtdDataIsNull() {
            addCriterion("trtd_data is null");
            return (Criteria) this;
        }

        public Criteria andTrtdDataIsNotNull() {
            addCriterion("trtd_data is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdDataEqualTo(String value) {
            addCriterion("trtd_data =", value, "trtdData");
            return (Criteria) this;
        }

        public Criteria andTrtdDataNotEqualTo(String value) {
            addCriterion("trtd_data <>", value, "trtdData");
            return (Criteria) this;
        }

        public Criteria andTrtdDataGreaterThan(String value) {
            addCriterion("trtd_data >", value, "trtdData");
            return (Criteria) this;
        }

        public Criteria andTrtdDataGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_data >=", value, "trtdData");
            return (Criteria) this;
        }

        public Criteria andTrtdDataLessThan(String value) {
            addCriterion("trtd_data <", value, "trtdData");
            return (Criteria) this;
        }

        public Criteria andTrtdDataLessThanOrEqualTo(String value) {
            addCriterion("trtd_data <=", value, "trtdData");
            return (Criteria) this;
        }

        public Criteria andTrtdDataLike(String value) {
            addCriterion("trtd_data like", value, "trtdData");
            return (Criteria) this;
        }

        public Criteria andTrtdDataNotLike(String value) {
            addCriterion("trtd_data not like", value, "trtdData");
            return (Criteria) this;
        }

        public Criteria andTrtdDataIn(List<String> values) {
            addCriterion("trtd_data in", values, "trtdData");
            return (Criteria) this;
        }

        public Criteria andTrtdDataNotIn(List<String> values) {
            addCriterion("trtd_data not in", values, "trtdData");
            return (Criteria) this;
        }

        public Criteria andTrtdDataBetween(String value1, String value2) {
            addCriterion("trtd_data between", value1, value2, "trtdData");
            return (Criteria) this;
        }

        public Criteria andTrtdDataNotBetween(String value1, String value2) {
            addCriterion("trtd_data not between", value1, value2, "trtdData");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameIsNull() {
            addCriterion("trtd_depend_name is null");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameIsNotNull() {
            addCriterion("trtd_depend_name is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameEqualTo(String value) {
            addCriterion("trtd_depend_name =", value, "trtdDependName");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameNotEqualTo(String value) {
            addCriterion("trtd_depend_name <>", value, "trtdDependName");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameGreaterThan(String value) {
            addCriterion("trtd_depend_name >", value, "trtdDependName");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_depend_name >=", value, "trtdDependName");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameLessThan(String value) {
            addCriterion("trtd_depend_name <", value, "trtdDependName");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameLessThanOrEqualTo(String value) {
            addCriterion("trtd_depend_name <=", value, "trtdDependName");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameLike(String value) {
            addCriterion("trtd_depend_name like", value, "trtdDependName");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameNotLike(String value) {
            addCriterion("trtd_depend_name not like", value, "trtdDependName");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameIn(List<String> values) {
            addCriterion("trtd_depend_name in", values, "trtdDependName");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameNotIn(List<String> values) {
            addCriterion("trtd_depend_name not in", values, "trtdDependName");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameBetween(String value1, String value2) {
            addCriterion("trtd_depend_name between", value1, value2, "trtdDependName");
            return (Criteria) this;
        }

        public Criteria andTrtdDependNameNotBetween(String value1, String value2) {
            addCriterion("trtd_depend_name not between", value1, value2, "trtdDependName");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeIsNull() {
            addCriterion("trtd_time is null");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeIsNotNull() {
            addCriterion("trtd_time is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeEqualTo(String value) {
            addCriterion("trtd_time =", value, "trtdTime");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeNotEqualTo(String value) {
            addCriterion("trtd_time <>", value, "trtdTime");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeGreaterThan(String value) {
            addCriterion("trtd_time >", value, "trtdTime");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_time >=", value, "trtdTime");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeLessThan(String value) {
            addCriterion("trtd_time <", value, "trtdTime");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeLessThanOrEqualTo(String value) {
            addCriterion("trtd_time <=", value, "trtdTime");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeLike(String value) {
            addCriterion("trtd_time like", value, "trtdTime");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeNotLike(String value) {
            addCriterion("trtd_time not like", value, "trtdTime");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeIn(List<String> values) {
            addCriterion("trtd_time in", values, "trtdTime");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeNotIn(List<String> values) {
            addCriterion("trtd_time not in", values, "trtdTime");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeBetween(String value1, String value2) {
            addCriterion("trtd_time between", value1, value2, "trtdTime");
            return (Criteria) this;
        }

        public Criteria andTrtdTimeNotBetween(String value1, String value2) {
            addCriterion("trtd_time not between", value1, value2, "trtdTime");
            return (Criteria) this;
        }

        public Criteria andTrtdComparedResultIsNull() {
            addCriterion("trtd_compared_result is null");
            return (Criteria) this;
        }

        public Criteria andTrtdComparedResultIsNotNull() {
            addCriterion("trtd_compared_result is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdComparedResultEqualTo(Integer value) {
            addCriterion("trtd_compared_result =", value, "trtdComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdComparedResultNotEqualTo(Integer value) {
            addCriterion("trtd_compared_result <>", value, "trtdComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdComparedResultGreaterThan(Integer value) {
            addCriterion("trtd_compared_result >", value, "trtdComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdComparedResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("trtd_compared_result >=", value, "trtdComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdComparedResultLessThan(Integer value) {
            addCriterion("trtd_compared_result <", value, "trtdComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdComparedResultLessThanOrEqualTo(Integer value) {
            addCriterion("trtd_compared_result <=", value, "trtdComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdComparedResultIn(List<Integer> values) {
            addCriterion("trtd_compared_result in", values, "trtdComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdComparedResultNotIn(List<Integer> values) {
            addCriterion("trtd_compared_result not in", values, "trtdComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdComparedResultBetween(Integer value1, Integer value2) {
            addCriterion("trtd_compared_result between", value1, value2, "trtdComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdComparedResultNotBetween(Integer value1, Integer value2) {
            addCriterion("trtd_compared_result not between", value1, value2, "trtdComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionIsNull() {
            addCriterion("trtd_error_description is null");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionIsNotNull() {
            addCriterion("trtd_error_description is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionEqualTo(String value) {
            addCriterion("trtd_error_description =", value, "trtdErrorDescription");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionNotEqualTo(String value) {
            addCriterion("trtd_error_description <>", value, "trtdErrorDescription");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionGreaterThan(String value) {
            addCriterion("trtd_error_description >", value, "trtdErrorDescription");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_error_description >=", value, "trtdErrorDescription");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionLessThan(String value) {
            addCriterion("trtd_error_description <", value, "trtdErrorDescription");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionLessThanOrEqualTo(String value) {
            addCriterion("trtd_error_description <=", value, "trtdErrorDescription");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionLike(String value) {
            addCriterion("trtd_error_description like", value, "trtdErrorDescription");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionNotLike(String value) {
            addCriterion("trtd_error_description not like", value, "trtdErrorDescription");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionIn(List<String> values) {
            addCriterion("trtd_error_description in", values, "trtdErrorDescription");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionNotIn(List<String> values) {
            addCriterion("trtd_error_description not in", values, "trtdErrorDescription");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionBetween(String value1, String value2) {
            addCriterion("trtd_error_description between", value1, value2, "trtdErrorDescription");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDescriptionNotBetween(String value1, String value2) {
            addCriterion("trtd_error_description not between", value1, value2, "trtdErrorDescription");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailIsNull() {
            addCriterion("trtd_error_detail is null");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailIsNotNull() {
            addCriterion("trtd_error_detail is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailEqualTo(String value) {
            addCriterion("trtd_error_detail =", value, "trtdErrorDetail");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailNotEqualTo(String value) {
            addCriterion("trtd_error_detail <>", value, "trtdErrorDetail");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailGreaterThan(String value) {
            addCriterion("trtd_error_detail >", value, "trtdErrorDetail");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_error_detail >=", value, "trtdErrorDetail");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailLessThan(String value) {
            addCriterion("trtd_error_detail <", value, "trtdErrorDetail");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailLessThanOrEqualTo(String value) {
            addCriterion("trtd_error_detail <=", value, "trtdErrorDetail");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailLike(String value) {
            addCriterion("trtd_error_detail like", value, "trtdErrorDetail");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailNotLike(String value) {
            addCriterion("trtd_error_detail not like", value, "trtdErrorDetail");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailIn(List<String> values) {
            addCriterion("trtd_error_detail in", values, "trtdErrorDetail");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailNotIn(List<String> values) {
            addCriterion("trtd_error_detail not in", values, "trtdErrorDetail");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailBetween(String value1, String value2) {
            addCriterion("trtd_error_detail between", value1, value2, "trtdErrorDetail");
            return (Criteria) this;
        }

        public Criteria andTrtdErrorDetailNotBetween(String value1, String value2) {
            addCriterion("trtd_error_detail not between", value1, value2, "trtdErrorDetail");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeIsNull() {
            addCriterion("trtd_status_code is null");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeIsNotNull() {
            addCriterion("trtd_status_code is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeEqualTo(String value) {
            addCriterion("trtd_status_code =", value, "trtdStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeNotEqualTo(String value) {
            addCriterion("trtd_status_code <>", value, "trtdStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeGreaterThan(String value) {
            addCriterion("trtd_status_code >", value, "trtdStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_status_code >=", value, "trtdStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeLessThan(String value) {
            addCriterion("trtd_status_code <", value, "trtdStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeLessThanOrEqualTo(String value) {
            addCriterion("trtd_status_code <=", value, "trtdStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeLike(String value) {
            addCriterion("trtd_status_code like", value, "trtdStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeNotLike(String value) {
            addCriterion("trtd_status_code not like", value, "trtdStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeIn(List<String> values) {
            addCriterion("trtd_status_code in", values, "trtdStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeNotIn(List<String> values) {
            addCriterion("trtd_status_code not in", values, "trtdStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeBetween(String value1, String value2) {
            addCriterion("trtd_status_code between", value1, value2, "trtdStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusCodeNotBetween(String value1, String value2) {
            addCriterion("trtd_status_code not between", value1, value2, "trtdStatusCode");
            return (Criteria) this;
        }

        public Criteria andTrtdResultIsNull() {
            addCriterion("trtd_result is null");
            return (Criteria) this;
        }

        public Criteria andTrtdResultIsNotNull() {
            addCriterion("trtd_result is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdResultEqualTo(Integer value) {
            addCriterion("trtd_result =", value, "trtdResult");
            return (Criteria) this;
        }

        public Criteria andTrtdResultNotEqualTo(Integer value) {
            addCriterion("trtd_result <>", value, "trtdResult");
            return (Criteria) this;
        }

        public Criteria andTrtdResultGreaterThan(Integer value) {
            addCriterion("trtd_result >", value, "trtdResult");
            return (Criteria) this;
        }

        public Criteria andTrtdResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("trtd_result >=", value, "trtdResult");
            return (Criteria) this;
        }

        public Criteria andTrtdResultLessThan(Integer value) {
            addCriterion("trtd_result <", value, "trtdResult");
            return (Criteria) this;
        }

        public Criteria andTrtdResultLessThanOrEqualTo(Integer value) {
            addCriterion("trtd_result <=", value, "trtdResult");
            return (Criteria) this;
        }

        public Criteria andTrtdResultIn(List<Integer> values) {
            addCriterion("trtd_result in", values, "trtdResult");
            return (Criteria) this;
        }

        public Criteria andTrtdResultNotIn(List<Integer> values) {
            addCriterion("trtd_result not in", values, "trtdResult");
            return (Criteria) this;
        }

        public Criteria andTrtdResultBetween(Integer value1, Integer value2) {
            addCriterion("trtd_result between", value1, value2, "trtdResult");
            return (Criteria) this;
        }

        public Criteria andTrtdResultNotBetween(Integer value1, Integer value2) {
            addCriterion("trtd_result not between", value1, value2, "trtdResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultIsNull() {
            addCriterion("trtd_sql_execute_result is null");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultIsNotNull() {
            addCriterion("trtd_sql_execute_result is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultEqualTo(String value) {
            addCriterion("trtd_sql_execute_result =", value, "trtdSqlExecuteResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultNotEqualTo(String value) {
            addCriterion("trtd_sql_execute_result <>", value, "trtdSqlExecuteResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultGreaterThan(String value) {
            addCriterion("trtd_sql_execute_result >", value, "trtdSqlExecuteResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_sql_execute_result >=", value, "trtdSqlExecuteResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultLessThan(String value) {
            addCriterion("trtd_sql_execute_result <", value, "trtdSqlExecuteResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultLessThanOrEqualTo(String value) {
            addCriterion("trtd_sql_execute_result <=", value, "trtdSqlExecuteResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultLike(String value) {
            addCriterion("trtd_sql_execute_result like", value, "trtdSqlExecuteResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultNotLike(String value) {
            addCriterion("trtd_sql_execute_result not like", value, "trtdSqlExecuteResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultIn(List<String> values) {
            addCriterion("trtd_sql_execute_result in", values, "trtdSqlExecuteResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultNotIn(List<String> values) {
            addCriterion("trtd_sql_execute_result not in", values, "trtdSqlExecuteResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultBetween(String value1, String value2) {
            addCriterion("trtd_sql_execute_result between", value1, value2, "trtdSqlExecuteResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExecuteResultNotBetween(String value1, String value2) {
            addCriterion("trtd_sql_execute_result not between", value1, value2, "trtdSqlExecuteResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultIsNull() {
            addCriterion("trtd_sql_expect_result is null");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultIsNotNull() {
            addCriterion("trtd_sql_expect_result is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultEqualTo(String value) {
            addCriterion("trtd_sql_expect_result =", value, "trtdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultNotEqualTo(String value) {
            addCriterion("trtd_sql_expect_result <>", value, "trtdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultGreaterThan(String value) {
            addCriterion("trtd_sql_expect_result >", value, "trtdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_sql_expect_result >=", value, "trtdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultLessThan(String value) {
            addCriterion("trtd_sql_expect_result <", value, "trtdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultLessThanOrEqualTo(String value) {
            addCriterion("trtd_sql_expect_result <=", value, "trtdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultLike(String value) {
            addCriterion("trtd_sql_expect_result like", value, "trtdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultNotLike(String value) {
            addCriterion("trtd_sql_expect_result not like", value, "trtdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultIn(List<String> values) {
            addCriterion("trtd_sql_expect_result in", values, "trtdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultNotIn(List<String> values) {
            addCriterion("trtd_sql_expect_result not in", values, "trtdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultBetween(String value1, String value2) {
            addCriterion("trtd_sql_expect_result between", value1, value2, "trtdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlExpectResultNotBetween(String value1, String value2) {
            addCriterion("trtd_sql_expect_result not between", value1, value2, "trtdSqlExpectResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlComparedResultIsNull() {
            addCriterion("trtd_sql_compared_result is null");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlComparedResultIsNotNull() {
            addCriterion("trtd_sql_compared_result is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlComparedResultEqualTo(Integer value) {
            addCriterion("trtd_sql_compared_result =", value, "trtdSqlComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlComparedResultNotEqualTo(Integer value) {
            addCriterion("trtd_sql_compared_result <>", value, "trtdSqlComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlComparedResultGreaterThan(Integer value) {
            addCriterion("trtd_sql_compared_result >", value, "trtdSqlComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlComparedResultGreaterThanOrEqualTo(Integer value) {
            addCriterion("trtd_sql_compared_result >=", value, "trtdSqlComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlComparedResultLessThan(Integer value) {
            addCriterion("trtd_sql_compared_result <", value, "trtdSqlComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlComparedResultLessThanOrEqualTo(Integer value) {
            addCriterion("trtd_sql_compared_result <=", value, "trtdSqlComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlComparedResultIn(List<Integer> values) {
            addCriterion("trtd_sql_compared_result in", values, "trtdSqlComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlComparedResultNotIn(List<Integer> values) {
            addCriterion("trtd_sql_compared_result not in", values, "trtdSqlComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlComparedResultBetween(Integer value1, Integer value2) {
            addCriterion("trtd_sql_compared_result between", value1, value2, "trtdSqlComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdSqlComparedResultNotBetween(Integer value1, Integer value2) {
            addCriterion("trtd_sql_compared_result not between", value1, value2, "trtdSqlComparedResult");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusIsNull() {
            addCriterion("trtd_status is null");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusIsNotNull() {
            addCriterion("trtd_status is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusEqualTo(String value) {
            addCriterion("trtd_status =", value, "trtdStatus");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusNotEqualTo(String value) {
            addCriterion("trtd_status <>", value, "trtdStatus");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusGreaterThan(String value) {
            addCriterion("trtd_status >", value, "trtdStatus");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_status >=", value, "trtdStatus");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusLessThan(String value) {
            addCriterion("trtd_status <", value, "trtdStatus");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusLessThanOrEqualTo(String value) {
            addCriterion("trtd_status <=", value, "trtdStatus");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusLike(String value) {
            addCriterion("trtd_status like", value, "trtdStatus");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusNotLike(String value) {
            addCriterion("trtd_status not like", value, "trtdStatus");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusIn(List<String> values) {
            addCriterion("trtd_status in", values, "trtdStatus");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusNotIn(List<String> values) {
            addCriterion("trtd_status not in", values, "trtdStatus");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusBetween(String value1, String value2) {
            addCriterion("trtd_status between", value1, value2, "trtdStatus");
            return (Criteria) this;
        }

        public Criteria andTrtdStatusNotBetween(String value1, String value2) {
            addCriterion("trtd_status not between", value1, value2, "trtdStatus");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeIsNull() {
            addCriterion("trtd_createtime is null");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeIsNotNull() {
            addCriterion("trtd_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeEqualTo(String value) {
            addCriterion("trtd_createtime =", value, "trtdCreatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeNotEqualTo(String value) {
            addCriterion("trtd_createtime <>", value, "trtdCreatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeGreaterThan(String value) {
            addCriterion("trtd_createtime >", value, "trtdCreatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_createtime >=", value, "trtdCreatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeLessThan(String value) {
            addCriterion("trtd_createtime <", value, "trtdCreatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("trtd_createtime <=", value, "trtdCreatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeLike(String value) {
            addCriterion("trtd_createtime like", value, "trtdCreatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeNotLike(String value) {
            addCriterion("trtd_createtime not like", value, "trtdCreatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeIn(List<String> values) {
            addCriterion("trtd_createtime in", values, "trtdCreatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeNotIn(List<String> values) {
            addCriterion("trtd_createtime not in", values, "trtdCreatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeBetween(String value1, String value2) {
            addCriterion("trtd_createtime between", value1, value2, "trtdCreatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdCreatetimeNotBetween(String value1, String value2) {
            addCriterion("trtd_createtime not between", value1, value2, "trtdCreatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserIsNull() {
            addCriterion("trtd_createuser is null");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserIsNotNull() {
            addCriterion("trtd_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserEqualTo(String value) {
            addCriterion("trtd_createuser =", value, "trtdCreateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserNotEqualTo(String value) {
            addCriterion("trtd_createuser <>", value, "trtdCreateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserGreaterThan(String value) {
            addCriterion("trtd_createuser >", value, "trtdCreateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_createuser >=", value, "trtdCreateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserLessThan(String value) {
            addCriterion("trtd_createuser <", value, "trtdCreateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserLessThanOrEqualTo(String value) {
            addCriterion("trtd_createuser <=", value, "trtdCreateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserLike(String value) {
            addCriterion("trtd_createuser like", value, "trtdCreateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserNotLike(String value) {
            addCriterion("trtd_createuser not like", value, "trtdCreateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserIn(List<String> values) {
            addCriterion("trtd_createuser in", values, "trtdCreateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserNotIn(List<String> values) {
            addCriterion("trtd_createuser not in", values, "trtdCreateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserBetween(String value1, String value2) {
            addCriterion("trtd_createuser between", value1, value2, "trtdCreateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdCreateuserNotBetween(String value1, String value2) {
            addCriterion("trtd_createuser not between", value1, value2, "trtdCreateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeIsNull() {
            addCriterion("trtd_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeIsNotNull() {
            addCriterion("trtd_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeEqualTo(String value) {
            addCriterion("trtd_updatetime =", value, "trtdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeNotEqualTo(String value) {
            addCriterion("trtd_updatetime <>", value, "trtdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeGreaterThan(String value) {
            addCriterion("trtd_updatetime >", value, "trtdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_updatetime >=", value, "trtdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeLessThan(String value) {
            addCriterion("trtd_updatetime <", value, "trtdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("trtd_updatetime <=", value, "trtdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeLike(String value) {
            addCriterion("trtd_updatetime like", value, "trtdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeNotLike(String value) {
            addCriterion("trtd_updatetime not like", value, "trtdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeIn(List<String> values) {
            addCriterion("trtd_updatetime in", values, "trtdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeNotIn(List<String> values) {
            addCriterion("trtd_updatetime not in", values, "trtdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeBetween(String value1, String value2) {
            addCriterion("trtd_updatetime between", value1, value2, "trtdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("trtd_updatetime not between", value1, value2, "trtdUpdatetime");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserIsNull() {
            addCriterion("trtd_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserIsNotNull() {
            addCriterion("trtd_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserEqualTo(String value) {
            addCriterion("trtd_updateuser =", value, "trtdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserNotEqualTo(String value) {
            addCriterion("trtd_updateuser <>", value, "trtdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserGreaterThan(String value) {
            addCriterion("trtd_updateuser >", value, "trtdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("trtd_updateuser >=", value, "trtdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserLessThan(String value) {
            addCriterion("trtd_updateuser <", value, "trtdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("trtd_updateuser <=", value, "trtdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserLike(String value) {
            addCriterion("trtd_updateuser like", value, "trtdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserNotLike(String value) {
            addCriterion("trtd_updateuser not like", value, "trtdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserIn(List<String> values) {
            addCriterion("trtd_updateuser in", values, "trtdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserNotIn(List<String> values) {
            addCriterion("trtd_updateuser not in", values, "trtdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserBetween(String value1, String value2) {
            addCriterion("trtd_updateuser between", value1, value2, "trtdUpdateuser");
            return (Criteria) this;
        }

        public Criteria andTrtdUpdateuserNotBetween(String value1, String value2) {
            addCriterion("trtd_updateuser not between", value1, value2, "trtdUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andTrtdNameLikeInsensitive(String value) {
            addCriterion("upper(trtd_name) like", value.toUpperCase(), "trtdName");
            return this;
        }

        public Criteria andTrtdDataLikeInsensitive(String value) {
            addCriterion("upper(trtd_data) like", value.toUpperCase(), "trtdData");
            return this;
        }

        public Criteria andTrtdDependNameLikeInsensitive(String value) {
            addCriterion("upper(trtd_depend_name) like", value.toUpperCase(), "trtdDependName");
            return this;
        }

        public Criteria andTrtdTimeLikeInsensitive(String value) {
            addCriterion("upper(trtd_time) like", value.toUpperCase(), "trtdTime");
            return this;
        }

        public Criteria andTrtdErrorDescriptionLikeInsensitive(String value) {
            addCriterion("upper(trtd_error_description) like", value.toUpperCase(), "trtdErrorDescription");
            return this;
        }

        public Criteria andTrtdErrorDetailLikeInsensitive(String value) {
            addCriterion("upper(trtd_error_detail) like", value.toUpperCase(), "trtdErrorDetail");
            return this;
        }

        public Criteria andTrtdStatusCodeLikeInsensitive(String value) {
            addCriterion("upper(trtd_status_code) like", value.toUpperCase(), "trtdStatusCode");
            return this;
        }

        public Criteria andTrtdSqlExecuteResultLikeInsensitive(String value) {
            addCriterion("upper(trtd_sql_execute_result) like", value.toUpperCase(), "trtdSqlExecuteResult");
            return this;
        }

        public Criteria andTrtdSqlExpectResultLikeInsensitive(String value) {
            addCriterion("upper(trtd_sql_expect_result) like", value.toUpperCase(), "trtdSqlExpectResult");
            return this;
        }

        public Criteria andTrtdStatusLikeInsensitive(String value) {
            addCriterion("upper(trtd_status) like", value.toUpperCase(), "trtdStatus");
            return this;
        }

        public Criteria andTrtdCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(trtd_createtime) like", value.toUpperCase(), "trtdCreatetime");
            return this;
        }

        public Criteria andTrtdCreateuserLikeInsensitive(String value) {
            addCriterion("upper(trtd_createuser) like", value.toUpperCase(), "trtdCreateuser");
            return this;
        }

        public Criteria andTrtdUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(trtd_updatetime) like", value.toUpperCase(), "trtdUpdatetime");
            return this;
        }

        public Criteria andTrtdUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(trtd_updateuser) like", value.toUpperCase(), "trtdUpdateuser");
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