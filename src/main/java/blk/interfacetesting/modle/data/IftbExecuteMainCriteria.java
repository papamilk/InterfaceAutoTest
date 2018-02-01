package blk.interfacetesting.modle.data;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class IftbExecuteMainCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * for merge search with mpName
     */
    protected boolean addMpName;

    public boolean isAddMpName() {
        return addMpName;
    }

    public void setAddMpName(boolean addMpName) {
        this.addMpName = addMpName;
    }

    protected Page page;

    public IftbExecuteMainCriteria() {
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

        public Criteria andUrlPrefixIsNull() {
            addCriterion("url_prefix is null");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixIsNotNull() {
            addCriterion("url_prefix is not null");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixEqualTo(String value) {
            addCriterion("url_prefix =", value, "urlPrefix");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixNotEqualTo(String value) {
            addCriterion("url_prefix <>", value, "urlPrefix");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixGreaterThan(String value) {
            addCriterion("url_prefix >", value, "urlPrefix");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixGreaterThanOrEqualTo(String value) {
            addCriterion("url_prefix >=", value, "urlPrefix");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixLessThan(String value) {
            addCriterion("url_prefix <", value, "urlPrefix");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixLessThanOrEqualTo(String value) {
            addCriterion("url_prefix <=", value, "urlPrefix");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixLike(String value) {
            addCriterion("url_prefix like", value, "urlPrefix");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixNotLike(String value) {
            addCriterion("url_prefix not like", value, "urlPrefix");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixIn(List<String> values) {
            addCriterion("url_prefix in", values, "urlPrefix");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixNotIn(List<String> values) {
            addCriterion("url_prefix not in", values, "urlPrefix");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixBetween(String value1, String value2) {
            addCriterion("url_prefix between", value1, value2, "urlPrefix");
            return (Criteria) this;
        }

        public Criteria andUrlPrefixNotBetween(String value1, String value2) {
            addCriterion("url_prefix not between", value1, value2, "urlPrefix");
            return (Criteria) this;
        }

        public Criteria andCSystemIsNull() {
            addCriterion("c_system is null");
            return (Criteria) this;
        }

        public Criteria andCSystemIsNotNull() {
            addCriterion("c_system is not null");
            return (Criteria) this;
        }

        public Criteria andCSystemEqualTo(String value) {
            addCriterion("c_system =", value, "cSystem");
            return (Criteria) this;
        }

        public Criteria andCSystemNotEqualTo(String value) {
            addCriterion("c_system <>", value, "cSystem");
            return (Criteria) this;
        }

        public Criteria andCSystemGreaterThan(String value) {
            addCriterion("c_system >", value, "cSystem");
            return (Criteria) this;
        }

        public Criteria andCSystemGreaterThanOrEqualTo(String value) {
            addCriterion("c_system >=", value, "cSystem");
            return (Criteria) this;
        }

        public Criteria andCSystemLessThan(String value) {
            addCriterion("c_system <", value, "cSystem");
            return (Criteria) this;
        }

        public Criteria andCSystemLessThanOrEqualTo(String value) {
            addCriterion("c_system <=", value, "cSystem");
            return (Criteria) this;
        }

        public Criteria andCSystemLike(String value) {
            addCriterion("c_system like", value, "cSystem");
            return (Criteria) this;
        }

        public Criteria andCSystemNotLike(String value) {
            addCriterion("c_system not like", value, "cSystem");
            return (Criteria) this;
        }

        public Criteria andCSystemIn(List<String> values) {
            addCriterion("c_system in", values, "cSystem");
            return (Criteria) this;
        }

        public Criteria andCSystemNotIn(List<String> values) {
            addCriterion("c_system not in", values, "cSystem");
            return (Criteria) this;
        }

        public Criteria andCSystemBetween(String value1, String value2) {
            addCriterion("c_system between", value1, value2, "cSystem");
            return (Criteria) this;
        }

        public Criteria andCSystemNotBetween(String value1, String value2) {
            addCriterion("c_system not between", value1, value2, "cSystem");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andCodeVersionIsNull() {
            addCriterion("code_version is null");
            return (Criteria) this;
        }

        public Criteria andCodeVersionIsNotNull() {
            addCriterion("code_version is not null");
            return (Criteria) this;
        }

        public Criteria andCodeVersionEqualTo(String value) {
            addCriterion("code_version =", value, "codeVersion");
            return (Criteria) this;
        }

        public Criteria andCodeVersionNotEqualTo(String value) {
            addCriterion("code_version <>", value, "codeVersion");
            return (Criteria) this;
        }

        public Criteria andCodeVersionGreaterThan(String value) {
            addCriterion("code_version >", value, "codeVersion");
            return (Criteria) this;
        }

        public Criteria andCodeVersionGreaterThanOrEqualTo(String value) {
            addCriterion("code_version >=", value, "codeVersion");
            return (Criteria) this;
        }

        public Criteria andCodeVersionLessThan(String value) {
            addCriterion("code_version <", value, "codeVersion");
            return (Criteria) this;
        }

        public Criteria andCodeVersionLessThanOrEqualTo(String value) {
            addCriterion("code_version <=", value, "codeVersion");
            return (Criteria) this;
        }

        public Criteria andCodeVersionLike(String value) {
            addCriterion("code_version like", value, "codeVersion");
            return (Criteria) this;
        }

        public Criteria andCodeVersionNotLike(String value) {
            addCriterion("code_version not like", value, "codeVersion");
            return (Criteria) this;
        }

        public Criteria andCodeVersionIn(List<String> values) {
            addCriterion("code_version in", values, "codeVersion");
            return (Criteria) this;
        }

        public Criteria andCodeVersionNotIn(List<String> values) {
            addCriterion("code_version not in", values, "codeVersion");
            return (Criteria) this;
        }

        public Criteria andCodeVersionBetween(String value1, String value2) {
            addCriterion("code_version between", value1, value2, "codeVersion");
            return (Criteria) this;
        }

        public Criteria andCodeVersionNotBetween(String value1, String value2) {
            addCriterion("code_version not between", value1, value2, "codeVersion");
            return (Criteria) this;
        }

        public Criteria andIemNameIsNull() {
            addCriterion("iem_name is null");
            return (Criteria) this;
        }

        public Criteria andIemNameIsNotNull() {
            addCriterion("iem_name is not null");
            return (Criteria) this;
        }

        public Criteria andIemNameEqualTo(String value) {
            addCriterion("iem_name =", value, "iemName");
            return (Criteria) this;
        }

        public Criteria andIemNameNotEqualTo(String value) {
            addCriterion("iem_name <>", value, "iemName");
            return (Criteria) this;
        }

        public Criteria andIemNameGreaterThan(String value) {
            addCriterion("iem_name >", value, "iemName");
            return (Criteria) this;
        }

        public Criteria andIemNameGreaterThanOrEqualTo(String value) {
            addCriterion("iem_name >=", value, "iemName");
            return (Criteria) this;
        }

        public Criteria andIemNameLessThan(String value) {
            addCriterion("iem_name <", value, "iemName");
            return (Criteria) this;
        }

        public Criteria andIemNameLessThanOrEqualTo(String value) {
            addCriterion("iem_name <=", value, "iemName");
            return (Criteria) this;
        }

        public Criteria andIemNameLike(String value) {
            addCriterion("iem_name like", value, "iemName");
            return (Criteria) this;
        }

        public Criteria andIemNameNotLike(String value) {
            addCriterion("iem_name not like", value, "iemName");
            return (Criteria) this;
        }

        public Criteria andIemNameIn(List<String> values) {
            addCriterion("iem_name in", values, "iemName");
            return (Criteria) this;
        }

        public Criteria andIemNameNotIn(List<String> values) {
            addCriterion("iem_name not in", values, "iemName");
            return (Criteria) this;
        }

        public Criteria andIemNameBetween(String value1, String value2) {
            addCriterion("iem_name between", value1, value2, "iemName");
            return (Criteria) this;
        }

        public Criteria andIemNameNotBetween(String value1, String value2) {
            addCriterion("iem_name not between", value1, value2, "iemName");
            return (Criteria) this;
        }

        public Criteria andIemTypeIsNull() {
            addCriterion("iem_type is null");
            return (Criteria) this;
        }

        public Criteria andIemTypeIsNotNull() {
            addCriterion("iem_type is not null");
            return (Criteria) this;
        }

        public Criteria andIemTypeEqualTo(String value) {
            addCriterion("iem_type =", value, "iemType");
            return (Criteria) this;
        }

        public Criteria andIemTypeNotEqualTo(String value) {
            addCriterion("iem_type <>", value, "iemType");
            return (Criteria) this;
        }

        public Criteria andIemTypeGreaterThan(String value) {
            addCriterion("iem_type >", value, "iemType");
            return (Criteria) this;
        }

        public Criteria andIemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("iem_type >=", value, "iemType");
            return (Criteria) this;
        }

        public Criteria andIemTypeLessThan(String value) {
            addCriterion("iem_type <", value, "iemType");
            return (Criteria) this;
        }

        public Criteria andIemTypeLessThanOrEqualTo(String value) {
            addCriterion("iem_type <=", value, "iemType");
            return (Criteria) this;
        }

        public Criteria andIemTypeLike(String value) {
            addCriterion("iem_type like", value, "iemType");
            return (Criteria) this;
        }

        public Criteria andIemTypeNotLike(String value) {
            addCriterion("iem_type not like", value, "iemType");
            return (Criteria) this;
        }

        public Criteria andIemTypeIn(List<String> values) {
            addCriterion("iem_type in", values, "iemType");
            return (Criteria) this;
        }

        public Criteria andIemTypeNotIn(List<String> values) {
            addCriterion("iem_type not in", values, "iemType");
            return (Criteria) this;
        }

        public Criteria andIemTypeBetween(String value1, String value2) {
            addCriterion("iem_type between", value1, value2, "iemType");
            return (Criteria) this;
        }

        public Criteria andIemTypeNotBetween(String value1, String value2) {
            addCriterion("iem_type not between", value1, value2, "iemType");
            return (Criteria) this;
        }

        public Criteria andIemCodeIsNull() {
            addCriterion("iem_code is null");
            return (Criteria) this;
        }

        public Criteria andIemCodeIsNotNull() {
            addCriterion("iem_code is not null");
            return (Criteria) this;
        }

        public Criteria andIemCodeEqualTo(String value) {
            addCriterion("iem_code =", value, "iemCode");
            return (Criteria) this;
        }

        public Criteria andIemCodeNotEqualTo(String value) {
            addCriterion("iem_code <>", value, "iemCode");
            return (Criteria) this;
        }

        public Criteria andIemCodeGreaterThan(String value) {
            addCriterion("iem_code >", value, "iemCode");
            return (Criteria) this;
        }

        public Criteria andIemCodeGreaterThanOrEqualTo(String value) {
            addCriterion("iem_code >=", value, "iemCode");
            return (Criteria) this;
        }

        public Criteria andIemCodeLessThan(String value) {
            addCriterion("iem_code <", value, "iemCode");
            return (Criteria) this;
        }

        public Criteria andIemCodeLessThanOrEqualTo(String value) {
            addCriterion("iem_code <=", value, "iemCode");
            return (Criteria) this;
        }

        public Criteria andIemCodeLike(String value) {
            addCriterion("iem_code like", value, "iemCode");
            return (Criteria) this;
        }

        public Criteria andIemCodeNotLike(String value) {
            addCriterion("iem_code not like", value, "iemCode");
            return (Criteria) this;
        }

        public Criteria andIemCodeIn(List<String> values) {
            addCriterion("iem_code in", values, "iemCode");
            return (Criteria) this;
        }

        public Criteria andIemCodeNotIn(List<String> values) {
            addCriterion("iem_code not in", values, "iemCode");
            return (Criteria) this;
        }

        public Criteria andIemCodeBetween(String value1, String value2) {
            addCriterion("iem_code between", value1, value2, "iemCode");
            return (Criteria) this;
        }

        public Criteria andIemCodeNotBetween(String value1, String value2) {
            addCriterion("iem_code not between", value1, value2, "iemCode");
            return (Criteria) this;
        }

        public Criteria andIemStatusIsNull() {
            addCriterion("iem_status is null");
            return (Criteria) this;
        }

        public Criteria andIemStatusIsNotNull() {
            addCriterion("iem_status is not null");
            return (Criteria) this;
        }

        public Criteria andIemStatusEqualTo(Integer value) {
            addCriterion("iem_status =", value, "iemStatus");
            return (Criteria) this;
        }

        public Criteria andIemStatusNotEqualTo(Integer value) {
            addCriterion("iem_status <>", value, "iemStatus");
            return (Criteria) this;
        }

        public Criteria andIemStatusGreaterThan(Integer value) {
            addCriterion("iem_status >", value, "iemStatus");
            return (Criteria) this;
        }

        public Criteria andIemStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("iem_status >=", value, "iemStatus");
            return (Criteria) this;
        }

        public Criteria andIemStatusLessThan(Integer value) {
            addCriterion("iem_status <", value, "iemStatus");
            return (Criteria) this;
        }

        public Criteria andIemStatusLessThanOrEqualTo(Integer value) {
            addCriterion("iem_status <=", value, "iemStatus");
            return (Criteria) this;
        }

        public Criteria andIemStatusIn(List<Integer> values) {
            addCriterion("iem_status in", values, "iemStatus");
            return (Criteria) this;
        }

        public Criteria andIemStatusNotIn(List<Integer> values) {
            addCriterion("iem_status not in", values, "iemStatus");
            return (Criteria) this;
        }

        public Criteria andIemStatusBetween(Integer value1, Integer value2) {
            addCriterion("iem_status between", value1, value2, "iemStatus");
            return (Criteria) this;
        }

        public Criteria andIemStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("iem_status not between", value1, value2, "iemStatus");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeIsNull() {
            addCriterion("iem_createtime is null");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeIsNotNull() {
            addCriterion("iem_createtime is not null");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeEqualTo(String value) {
            addCriterion("iem_createtime =", value, "iemCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeNotEqualTo(String value) {
            addCriterion("iem_createtime <>", value, "iemCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeGreaterThan(String value) {
            addCriterion("iem_createtime >", value, "iemCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("iem_createtime >=", value, "iemCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeLessThan(String value) {
            addCriterion("iem_createtime <", value, "iemCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeLessThanOrEqualTo(String value) {
            addCriterion("iem_createtime <=", value, "iemCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeLike(String value) {
            addCriterion("iem_createtime like", value, "iemCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeNotLike(String value) {
            addCriterion("iem_createtime not like", value, "iemCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeIn(List<String> values) {
            addCriterion("iem_createtime in", values, "iemCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeNotIn(List<String> values) {
            addCriterion("iem_createtime not in", values, "iemCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeBetween(String value1, String value2) {
            addCriterion("iem_createtime between", value1, value2, "iemCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemCreatetimeNotBetween(String value1, String value2) {
            addCriterion("iem_createtime not between", value1, value2, "iemCreatetime");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserIsNull() {
            addCriterion("iem_createuser is null");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserIsNotNull() {
            addCriterion("iem_createuser is not null");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserEqualTo(String value) {
            addCriterion("iem_createuser =", value, "iemCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserNotEqualTo(String value) {
            addCriterion("iem_createuser <>", value, "iemCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserGreaterThan(String value) {
            addCriterion("iem_createuser >", value, "iemCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("iem_createuser >=", value, "iemCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserLessThan(String value) {
            addCriterion("iem_createuser <", value, "iemCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserLessThanOrEqualTo(String value) {
            addCriterion("iem_createuser <=", value, "iemCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserLike(String value) {
            addCriterion("iem_createuser like", value, "iemCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserNotLike(String value) {
            addCriterion("iem_createuser not like", value, "iemCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserIn(List<String> values) {
            addCriterion("iem_createuser in", values, "iemCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserNotIn(List<String> values) {
            addCriterion("iem_createuser not in", values, "iemCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserBetween(String value1, String value2) {
            addCriterion("iem_createuser between", value1, value2, "iemCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemCreateuserNotBetween(String value1, String value2) {
            addCriterion("iem_createuser not between", value1, value2, "iemCreateuser");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeIsNull() {
            addCriterion("iem_updatetime is null");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeIsNotNull() {
            addCriterion("iem_updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeEqualTo(String value) {
            addCriterion("iem_updatetime =", value, "iemUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeNotEqualTo(String value) {
            addCriterion("iem_updatetime <>", value, "iemUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeGreaterThan(String value) {
            addCriterion("iem_updatetime >", value, "iemUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeGreaterThanOrEqualTo(String value) {
            addCriterion("iem_updatetime >=", value, "iemUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeLessThan(String value) {
            addCriterion("iem_updatetime <", value, "iemUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeLessThanOrEqualTo(String value) {
            addCriterion("iem_updatetime <=", value, "iemUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeLike(String value) {
            addCriterion("iem_updatetime like", value, "iemUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeNotLike(String value) {
            addCriterion("iem_updatetime not like", value, "iemUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeIn(List<String> values) {
            addCriterion("iem_updatetime in", values, "iemUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeNotIn(List<String> values) {
            addCriterion("iem_updatetime not in", values, "iemUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeBetween(String value1, String value2) {
            addCriterion("iem_updatetime between", value1, value2, "iemUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemUpdatetimeNotBetween(String value1, String value2) {
            addCriterion("iem_updatetime not between", value1, value2, "iemUpdatetime");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserIsNull() {
            addCriterion("iem_updateuser is null");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserIsNotNull() {
            addCriterion("iem_updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserEqualTo(String value) {
            addCriterion("iem_updateuser =", value, "iemUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserNotEqualTo(String value) {
            addCriterion("iem_updateuser <>", value, "iemUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserGreaterThan(String value) {
            addCriterion("iem_updateuser >", value, "iemUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("iem_updateuser >=", value, "iemUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserLessThan(String value) {
            addCriterion("iem_updateuser <", value, "iemUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("iem_updateuser <=", value, "iemUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserLike(String value) {
            addCriterion("iem_updateuser like", value, "iemUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserNotLike(String value) {
            addCriterion("iem_updateuser not like", value, "iemUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserIn(List<String> values) {
            addCriterion("iem_updateuser in", values, "iemUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserNotIn(List<String> values) {
            addCriterion("iem_updateuser not in", values, "iemUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserBetween(String value1, String value2) {
            addCriterion("iem_updateuser between", value1, value2, "iemUpdateuser");
            return (Criteria) this;
        }

        public Criteria andIemUpdateuserNotBetween(String value1, String value2) {
            addCriterion("iem_updateuser not between", value1, value2, "iemUpdateuser");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }

        public Criteria andUrlPrefixLikeInsensitive(String value) {
            addCriterion("upper(url_prefix) like", value.toUpperCase(), "urlPrefix");
            return this;
        }

        public Criteria andCSystemLikeInsensitive(String value) {
            addCriterion("upper(c_system) like", value.toUpperCase(), "cSystem");
            return this;
        }

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(description) like", value.toUpperCase(), "description");
            return this;
        }

        public Criteria andCodeVersionLikeInsensitive(String value) {
            addCriterion("upper(code_version) like", value.toUpperCase(), "codeVersion");
            return this;
        }

        public Criteria andIemNameLikeInsensitive(String value) {
            addCriterion("upper(iem_name) like", value.toUpperCase(), "iemName");
            return this;
        }

        public Criteria andIemTypeLikeInsensitive(String value) {
            addCriterion("upper(iem_type) like", value.toUpperCase(), "iemType");
            return this;
        }

        public Criteria andIemCodeLikeInsensitive(String value) {
            addCriterion("upper(iem_code) like", value.toUpperCase(), "iemCode");
            return this;
        }

        public Criteria andIemCreatetimeLikeInsensitive(String value) {
            addCriterion("upper(iem_createtime) like", value.toUpperCase(), "iemCreatetime");
            return this;
        }

        public Criteria andIemCreateuserLikeInsensitive(String value) {
            addCriterion("upper(iem_createuser) like", value.toUpperCase(), "iemCreateuser");
            return this;
        }

        public Criteria andIemUpdatetimeLikeInsensitive(String value) {
            addCriterion("upper(iem_updatetime) like", value.toUpperCase(), "iemUpdatetime");
            return this;
        }

        public Criteria andIemUpdateuserLikeInsensitive(String value) {
            addCriterion("upper(iem_updateuser) like", value.toUpperCase(), "iemUpdateuser");
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