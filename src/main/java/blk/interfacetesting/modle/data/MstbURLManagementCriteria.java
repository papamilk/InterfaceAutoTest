package blk.interfacetesting.modle.data;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class MstbURLManagementCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public MstbURLManagementCriteria() {
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

        public Criteria andMumNumberIsNull() {
            addCriterion("mum_number is null");
            return (Criteria) this;
        }

        public Criteria andMumNumberIsNotNull() {
            addCriterion("mum_number is not null");
            return (Criteria) this;
        }

        public Criteria andMumNumberEqualTo(String value) {
            addCriterion("mum_number =", value, "mumNumber");
            return (Criteria) this;
        }

        public Criteria andMumNumberNotEqualTo(String value) {
            addCriterion("mum_number <>", value, "mumNumber");
            return (Criteria) this;
        }

        public Criteria andMumNumberGreaterThan(String value) {
            addCriterion("mum_number >", value, "mumNumber");
            return (Criteria) this;
        }

        public Criteria andMumNumberGreaterThanOrEqualTo(String value) {
            addCriterion("mum_number >=", value, "mumNumber");
            return (Criteria) this;
        }

        public Criteria andMumNumberLessThan(String value) {
            addCriterion("mum_number <", value, "mumNumber");
            return (Criteria) this;
        }

        public Criteria andMumNumberLessThanOrEqualTo(String value) {
            addCriterion("mum_number <=", value, "mumNumber");
            return (Criteria) this;
        }

        public Criteria andMumNumberLike(String value) {
            addCriterion("mum_number like", value, "mumNumber");
            return (Criteria) this;
        }

        public Criteria andMumNumberNotLike(String value) {
            addCriterion("mum_number not like", value, "mumNumber");
            return (Criteria) this;
        }

        public Criteria andMumNumberIn(List<String> values) {
            addCriterion("mum_number in", values, "mumNumber");
            return (Criteria) this;
        }

        public Criteria andMumNumberNotIn(List<String> values) {
            addCriterion("mum_number not in", values, "mumNumber");
            return (Criteria) this;
        }

        public Criteria andMumNumberBetween(String value1, String value2) {
            addCriterion("mum_number between", value1, value2, "mumNumber");
            return (Criteria) this;
        }

        public Criteria andMumNumberNotBetween(String value1, String value2) {
            addCriterion("mum_number not between", value1, value2, "mumNumber");
            return (Criteria) this;
        }

        public Criteria andMumNameIsNull() {
            addCriterion("mum_name is null");
            return (Criteria) this;
        }

        public Criteria andMumNameIsNotNull() {
            addCriterion("mum_name is not null");
            return (Criteria) this;
        }

        public Criteria andMumNameEqualTo(String value) {
            addCriterion("mum_name =", value, "mumName");
            return (Criteria) this;
        }

        public Criteria andMumNameNotEqualTo(String value) {
            addCriterion("mum_name <>", value, "mumName");
            return (Criteria) this;
        }

        public Criteria andMumNameGreaterThan(String value) {
            addCriterion("mum_name >", value, "mumName");
            return (Criteria) this;
        }

        public Criteria andMumNameGreaterThanOrEqualTo(String value) {
            addCriterion("mum_name >=", value, "mumName");
            return (Criteria) this;
        }

        public Criteria andMumNameLessThan(String value) {
            addCriterion("mum_name <", value, "mumName");
            return (Criteria) this;
        }

        public Criteria andMumNameLessThanOrEqualTo(String value) {
            addCriterion("mum_name <=", value, "mumName");
            return (Criteria) this;
        }

        public Criteria andMumNameLike(String value) {
            addCriterion("mum_name like", value, "mumName");
            return (Criteria) this;
        }

        public Criteria andMumNameNotLike(String value) {
            addCriterion("mum_name not like", value, "mumName");
            return (Criteria) this;
        }

        public Criteria andMumNameIn(List<String> values) {
            addCriterion("mum_name in", values, "mumName");
            return (Criteria) this;
        }

        public Criteria andMumNameNotIn(List<String> values) {
            addCriterion("mum_name not in", values, "mumName");
            return (Criteria) this;
        }

        public Criteria andMumNameBetween(String value1, String value2) {
            addCriterion("mum_name between", value1, value2, "mumName");
            return (Criteria) this;
        }

        public Criteria andMumNameNotBetween(String value1, String value2) {
            addCriterion("mum_name not between", value1, value2, "mumName");
            return (Criteria) this;
        }

        public Criteria andMumOrderIsNull() {
            addCriterion("mum_order is null");
            return (Criteria) this;
        }

        public Criteria andMumOrderIsNotNull() {
            addCriterion("mum_order is not null");
            return (Criteria) this;
        }

        public Criteria andMumOrderEqualTo(Double value) {
            addCriterion("mum_order =", value, "mumOrder");
            return (Criteria) this;
        }

        public Criteria andMumOrderNotEqualTo(Double value) {
            addCriterion("mum_order <>", value, "mumOrder");
            return (Criteria) this;
        }

        public Criteria andMumOrderGreaterThan(Double value) {
            addCriterion("mum_order >", value, "mumOrder");
            return (Criteria) this;
        }

        public Criteria andMumOrderGreaterThanOrEqualTo(Double value) {
            addCriterion("mum_order >=", value, "mumOrder");
            return (Criteria) this;
        }

        public Criteria andMumOrderLessThan(Double value) {
            addCriterion("mum_order <", value, "mumOrder");
            return (Criteria) this;
        }

        public Criteria andMumOrderLessThanOrEqualTo(Double value) {
            addCriterion("mum_order <=", value, "mumOrder");
            return (Criteria) this;
        }

        public Criteria andMumOrderIn(List<Double> values) {
            addCriterion("mum_order in", values, "mumOrder");
            return (Criteria) this;
        }

        public Criteria andMumOrderNotIn(List<Double> values) {
            addCriterion("mum_order not in", values, "mumOrder");
            return (Criteria) this;
        }

        public Criteria andMumOrderBetween(Double value1, Double value2) {
            addCriterion("mum_order between", value1, value2, "mumOrder");
            return (Criteria) this;
        }

        public Criteria andMumOrderNotBetween(Double value1, Double value2) {
            addCriterion("mum_order not between", value1, value2, "mumOrder");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathIsNull() {
            addCriterion("mum_url_path is null");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathIsNotNull() {
            addCriterion("mum_url_path is not null");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathEqualTo(String value) {
            addCriterion("mum_url_path =", value, "mumUrlPath");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathNotEqualTo(String value) {
            addCriterion("mum_url_path <>", value, "mumUrlPath");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathGreaterThan(String value) {
            addCriterion("mum_url_path >", value, "mumUrlPath");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathGreaterThanOrEqualTo(String value) {
            addCriterion("mum_url_path >=", value, "mumUrlPath");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathLessThan(String value) {
            addCriterion("mum_url_path <", value, "mumUrlPath");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathLessThanOrEqualTo(String value) {
            addCriterion("mum_url_path <=", value, "mumUrlPath");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathLike(String value) {
            addCriterion("mum_url_path like", value, "mumUrlPath");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathNotLike(String value) {
            addCriterion("mum_url_path not like", value, "mumUrlPath");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathIn(List<String> values) {
            addCriterion("mum_url_path in", values, "mumUrlPath");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathNotIn(List<String> values) {
            addCriterion("mum_url_path not in", values, "mumUrlPath");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathBetween(String value1, String value2) {
            addCriterion("mum_url_path between", value1, value2, "mumUrlPath");
            return (Criteria) this;
        }

        public Criteria andMumUrlPathNotBetween(String value1, String value2) {
            addCriterion("mum_url_path not between", value1, value2, "mumUrlPath");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeIsNull() {
            addCriterion("mum_method_type is null");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeIsNotNull() {
            addCriterion("mum_method_type is not null");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeEqualTo(String value) {
            addCriterion("mum_method_type =", value, "mumMethodType");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeNotEqualTo(String value) {
            addCriterion("mum_method_type <>", value, "mumMethodType");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeGreaterThan(String value) {
            addCriterion("mum_method_type >", value, "mumMethodType");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mum_method_type >=", value, "mumMethodType");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeLessThan(String value) {
            addCriterion("mum_method_type <", value, "mumMethodType");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeLessThanOrEqualTo(String value) {
            addCriterion("mum_method_type <=", value, "mumMethodType");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeLike(String value) {
            addCriterion("mum_method_type like", value, "mumMethodType");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeNotLike(String value) {
            addCriterion("mum_method_type not like", value, "mumMethodType");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeIn(List<String> values) {
            addCriterion("mum_method_type in", values, "mumMethodType");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeNotIn(List<String> values) {
            addCriterion("mum_method_type not in", values, "mumMethodType");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeBetween(String value1, String value2) {
            addCriterion("mum_method_type between", value1, value2, "mumMethodType");
            return (Criteria) this;
        }

        public Criteria andMumMethodTypeNotBetween(String value1, String value2) {
            addCriterion("mum_method_type not between", value1, value2, "mumMethodType");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeIsNull() {
            addCriterion("mum_status_code is null");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeIsNotNull() {
            addCriterion("mum_status_code is not null");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeEqualTo(String value) {
            addCriterion("mum_status_code =", value, "mumStatusCode");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeNotEqualTo(String value) {
            addCriterion("mum_status_code <>", value, "mumStatusCode");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeGreaterThan(String value) {
            addCriterion("mum_status_code >", value, "mumStatusCode");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeGreaterThanOrEqualTo(String value) {
            addCriterion("mum_status_code >=", value, "mumStatusCode");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeLessThan(String value) {
            addCriterion("mum_status_code <", value, "mumStatusCode");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeLessThanOrEqualTo(String value) {
            addCriterion("mum_status_code <=", value, "mumStatusCode");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeLike(String value) {
            addCriterion("mum_status_code like", value, "mumStatusCode");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeNotLike(String value) {
            addCriterion("mum_status_code not like", value, "mumStatusCode");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeIn(List<String> values) {
            addCriterion("mum_status_code in", values, "mumStatusCode");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeNotIn(List<String> values) {
            addCriterion("mum_status_code not in", values, "mumStatusCode");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeBetween(String value1, String value2) {
            addCriterion("mum_status_code between", value1, value2, "mumStatusCode");
            return (Criteria) this;
        }

        public Criteria andMumStatusCodeNotBetween(String value1, String value2) {
            addCriterion("mum_status_code not between", value1, value2, "mumStatusCode");
            return (Criteria) this;
        }

        public Criteria andMumStatusIsNull() {
            addCriterion("mum_status is null");
            return (Criteria) this;
        }

        public Criteria andMumStatusIsNotNull() {
            addCriterion("mum_status is not null");
            return (Criteria) this;
        }

        public Criteria andMumStatusEqualTo(String value) {
            addCriterion("mum_status =", value, "mumStatus");
            return (Criteria) this;
        }

        public Criteria andMumStatusNotEqualTo(String value) {
            addCriterion("mum_status <>", value, "mumStatus");
            return (Criteria) this;
        }

        public Criteria andMumStatusGreaterThan(String value) {
            addCriterion("mum_status >", value, "mumStatus");
            return (Criteria) this;
        }

        public Criteria andMumStatusGreaterThanOrEqualTo(String value) {
            addCriterion("mum_status >=", value, "mumStatus");
            return (Criteria) this;
        }

        public Criteria andMumStatusLessThan(String value) {
            addCriterion("mum_status <", value, "mumStatus");
            return (Criteria) this;
        }

        public Criteria andMumStatusLessThanOrEqualTo(String value) {
            addCriterion("mum_status <=", value, "mumStatus");
            return (Criteria) this;
        }

        public Criteria andMumStatusLike(String value) {
            addCriterion("mum_status like", value, "mumStatus");
            return (Criteria) this;
        }

        public Criteria andMumStatusNotLike(String value) {
            addCriterion("mum_status not like", value, "mumStatus");
            return (Criteria) this;
        }

        public Criteria andMumStatusIn(List<String> values) {
            addCriterion("mum_status in", values, "mumStatus");
            return (Criteria) this;
        }

        public Criteria andMumStatusNotIn(List<String> values) {
            addCriterion("mum_status not in", values, "mumStatus");
            return (Criteria) this;
        }

        public Criteria andMumStatusBetween(String value1, String value2) {
            addCriterion("mum_status between", value1, value2, "mumStatus");
            return (Criteria) this;
        }

        public Criteria andMumStatusNotBetween(String value1, String value2) {
            addCriterion("mum_status not between", value1, value2, "mumStatus");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeIsNull() {
            addCriterion("mum_createtime is null");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeIsNotNull() {
            addCriterion("mum_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeEqualTo(String value) {
            addCriterion("mum_createtime =", value, "mumCreatetime");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeNotEqualTo(String value) {
            addCriterion("mum_createtime <>", value, "mumCreatetime");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeGreaterThan(String value) {
            addCriterion("mum_createtime >", value, "mumCreatetime");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("mum_createtime >=", value, "mumCreatetime");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeLessThan(String value) {
            addCriterion("mum_createtime <", value, "mumCreatetime");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("mum_createtime <=", value, "mumCreatetime");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeLike(String value) {
            addCriterion("mum_createtime like", value, "mumCreatetime");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeNotLike(String value) {
            addCriterion("mum_createtime not like", value, "mumCreatetime");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeIn(List<String> values) {
            addCriterion("mum_createtime in", values, "mumCreatetime");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeNotIn(List<String> values) {
            addCriterion("mum_createtime not in", values, "mumCreatetime");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeBetween(String value1, String value2) {
            addCriterion("mum_createtime between", value1, value2, "mumCreatetime");
            return (Criteria) this;
        }

        public Criteria andMumCreatetimeNotBetween(String value1, String value2) {
            addCriterion("mum_createtime not between", value1, value2, "mumCreatetime");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserIsNull() {
            addCriterion("mum_createuser is null");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserIsNotNull() {
            addCriterion("mum_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserEqualTo(String value) {
            addCriterion("mum_createuser =", value, "mumCreateuser");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserNotEqualTo(String value) {
            addCriterion("mum_createuser <>", value, "mumCreateuser");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserGreaterThan(String value) {
            addCriterion("mum_createuser >", value, "mumCreateuser");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("mum_createuser >=", value, "mumCreateuser");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserLessThan(String value) {
            addCriterion("mum_createuser <", value, "mumCreateuser");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserLessThanOrEqualTo(String value) {
            addCriterion("mum_createuser <=", value, "mumCreateuser");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserLike(String value) {
            addCriterion("mum_createuser like", value, "mumCreateuser");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserNotLike(String value) {
            addCriterion("mum_createuser not like", value, "mumCreateuser");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserIn(List<String> values) {
            addCriterion("mum_createuser in", values, "mumCreateuser");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserNotIn(List<String> values) {
            addCriterion("mum_createuser not in", values, "mumCreateuser");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserBetween(String value1, String value2) {
            addCriterion("mum_createuser between", value1, value2, "mumCreateuser");
            return (Criteria) this;
        }

        public Criteria andMumCreateuserNotBetween(String value1, String value2) {
            addCriterion("mum_createuser not between", value1, value2, "mumCreateuser");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeIsNull() {
            addCriterion("mum_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeIsNotNull() {
            addCriterion("mum_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeEqualTo(String value) {
            addCriterion("mum_updatetime =", value, "mumUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeNotEqualTo(String value) {
            addCriterion("mum_updatetime <>", value, "mumUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeGreaterThan(String value) {
            addCriterion("mum_updatetime >", value, "mumUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("mum_updatetime >=", value, "mumUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeLessThan(String value) {
            addCriterion("mum_updatetime <", value, "mumUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("mum_updatetime <=", value, "mumUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeLike(String value) {
            addCriterion("mum_updatetime like", value, "mumUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeNotLike(String value) {
            addCriterion("mum_updatetime not like", value, "mumUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeIn(List<String> values) {
            addCriterion("mum_updatetime in", values, "mumUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeNotIn(List<String> values) {
            addCriterion("mum_updatetime not in", values, "mumUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeBetween(String value1, String value2) {
            addCriterion("mum_updatetime between", value1, value2, "mumUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMumUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("mum_updatetime not between", value1, value2, "mumUpdatetime");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserIsNull() {
            addCriterion("mum_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserIsNotNull() {
            addCriterion("mum_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserEqualTo(String value) {
            addCriterion("mum_updateuser =", value, "mumUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserNotEqualTo(String value) {
            addCriterion("mum_updateuser <>", value, "mumUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserGreaterThan(String value) {
            addCriterion("mum_updateuser >", value, "mumUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("mum_updateuser >=", value, "mumUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserLessThan(String value) {
            addCriterion("mum_updateuser <", value, "mumUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("mum_updateuser <=", value, "mumUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserLike(String value) {
            addCriterion("mum_updateuser like", value, "mumUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserNotLike(String value) {
            addCriterion("mum_updateuser not like", value, "mumUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserIn(List<String> values) {
            addCriterion("mum_updateuser in", values, "mumUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserNotIn(List<String> values) {
            addCriterion("mum_updateuser not in", values, "mumUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserBetween(String value1, String value2) {
            addCriterion("mum_updateuser between", value1, value2, "mumUpdateuser");
            return (Criteria) this;
        }

        public Criteria andMumUpdateuserNotBetween(String value1, String value2) {
            addCriterion("mum_updateuser not between", value1, value2, "mumUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andMumNumberLikeInsensitive(String value) {
            addCriterion("upper(mum_number) like", value.toUpperCase(), "mumNumber");
            return this;
        }

        public Criteria andMumNameLikeInsensitive(String value) {
            addCriterion("upper(mum_name) like", value.toUpperCase(), "mumName");
            return this;
        }

        public Criteria andMumUrlPathLikeInsensitive(String value) {
            addCriterion("upper(mum_url_path) like", value.toUpperCase(), "mumUrlPath");
            return this;
        }

        public Criteria andMumMethodTypeLikeInsensitive(String value) {
            addCriterion("upper(mum_method_type) like", value.toUpperCase(), "mumMethodType");
            return this;
        }

        public Criteria andMumStatusCodeLikeInsensitive(String value) {
            addCriterion("upper(mum_status_code) like", value.toUpperCase(), "mumStatusCode");
            return this;
        }

        public Criteria andMumStatusLikeInsensitive(String value) {
            addCriterion("upper(mum_status) like", value.toUpperCase(), "mumStatus");
            return this;
        }

        public Criteria andMumCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(mum_createtime) like", value.toUpperCase(), "mumCreatetime");
            return this;
        }

        public Criteria andMumCreateuserLikeInsensitive(String value) {
            addCriterion("upper(mum_createuser) like", value.toUpperCase(), "mumCreateuser");
            return this;
        }

        public Criteria andMumUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(mum_updatetime) like", value.toUpperCase(), "mumUpdatetime");
            return this;
        }

        public Criteria andMumUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(mum_updateuser) like", value.toUpperCase(), "mumUpdateuser");
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