package blk.interfacetesting.modle.common;

import blk.common.util.Page;

import java.util.ArrayList;
import java.util.List;

public class CmtbAttachmentCriteria {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected Page page;

	public CmtbAttachmentCriteria() {
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

		public Criteria andAttIdIsNull() {
			addCriterion("att_id is null");
			return (Criteria) this;
		}

		public Criteria andAttIdIsNotNull() {
			addCriterion("att_id is not null");
			return (Criteria) this;
		}

		public Criteria andAttIdEqualTo(Long value) {
			addCriterion("att_id =", value, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdNotEqualTo(Long value) {
			addCriterion("att_id <>", value, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdGreaterThan(Long value) {
			addCriterion("att_id >", value, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdGreaterThanOrEqualTo(Long value) {
			addCriterion("att_id >=", value, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdLessThan(Long value) {
			addCriterion("att_id <", value, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdLessThanOrEqualTo(Long value) {
			addCriterion("att_id <=", value, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdIn(List<Long> values) {
			addCriterion("att_id in", values, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdNotIn(List<Long> values) {
			addCriterion("att_id not in", values, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdBetween(Long value1, Long value2) {
			addCriterion("att_id between", value1, value2, "attId");
			return (Criteria) this;
		}

		public Criteria andAttIdNotBetween(Long value1, Long value2) {
			addCriterion("att_id not between", value1, value2, "attId");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameIsNull() {
			addCriterion("att_original_name is null");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameIsNotNull() {
			addCriterion("att_original_name is not null");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameEqualTo(String value) {
			addCriterion("att_original_name =", value, "attOriginalName");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameNotEqualTo(String value) {
			addCriterion("att_original_name <>", value, "attOriginalName");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameGreaterThan(String value) {
			addCriterion("att_original_name >", value, "attOriginalName");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameGreaterThanOrEqualTo(String value) {
			addCriterion("att_original_name >=", value, "attOriginalName");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameLessThan(String value) {
			addCriterion("att_original_name <", value, "attOriginalName");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameLessThanOrEqualTo(String value) {
			addCriterion("att_original_name <=", value, "attOriginalName");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameLike(String value) {
			addCriterion("att_original_name like", value, "attOriginalName");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameNotLike(String value) {
			addCriterion("att_original_name not like", value, "attOriginalName");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameIn(List<String> values) {
			addCriterion("att_original_name in", values, "attOriginalName");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameNotIn(List<String> values) {
			addCriterion("att_original_name not in", values, "attOriginalName");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameBetween(String value1, String value2) {
			addCriterion("att_original_name between", value1, value2, "attOriginalName");
			return (Criteria) this;
		}

		public Criteria andAttOriginalNameNotBetween(String value1, String value2) {
			addCriterion("att_original_name not between", value1, value2, "attOriginalName");
			return (Criteria) this;
		}

		public Criteria andAttActualNameIsNull() {
			addCriterion("att_actual_name is null");
			return (Criteria) this;
		}

		public Criteria andAttActualNameIsNotNull() {
			addCriterion("att_actual_name is not null");
			return (Criteria) this;
		}

		public Criteria andAttActualNameEqualTo(String value) {
			addCriterion("att_actual_name =", value, "attActualName");
			return (Criteria) this;
		}

		public Criteria andAttActualNameNotEqualTo(String value) {
			addCriterion("att_actual_name <>", value, "attActualName");
			return (Criteria) this;
		}

		public Criteria andAttActualNameGreaterThan(String value) {
			addCriterion("att_actual_name >", value, "attActualName");
			return (Criteria) this;
		}

		public Criteria andAttActualNameGreaterThanOrEqualTo(String value) {
			addCriterion("att_actual_name >=", value, "attActualName");
			return (Criteria) this;
		}

		public Criteria andAttActualNameLessThan(String value) {
			addCriterion("att_actual_name <", value, "attActualName");
			return (Criteria) this;
		}

		public Criteria andAttActualNameLessThanOrEqualTo(String value) {
			addCriterion("att_actual_name <=", value, "attActualName");
			return (Criteria) this;
		}

		public Criteria andAttActualNameLike(String value) {
			addCriterion("att_actual_name like", value, "attActualName");
			return (Criteria) this;
		}

		public Criteria andAttActualNameNotLike(String value) {
			addCriterion("att_actual_name not like", value, "attActualName");
			return (Criteria) this;
		}

		public Criteria andAttActualNameIn(List<String> values) {
			addCriterion("att_actual_name in", values, "attActualName");
			return (Criteria) this;
		}

		public Criteria andAttActualNameNotIn(List<String> values) {
			addCriterion("att_actual_name not in", values, "attActualName");
			return (Criteria) this;
		}

		public Criteria andAttActualNameBetween(String value1, String value2) {
			addCriterion("att_actual_name between", value1, value2, "attActualName");
			return (Criteria) this;
		}

		public Criteria andAttActualNameNotBetween(String value1, String value2) {
			addCriterion("att_actual_name not between", value1, value2, "attActualName");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidIsNull() {
			addCriterion("att_refer_moduleid is null");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidIsNotNull() {
			addCriterion("att_refer_moduleid is not null");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidEqualTo(String value) {
			addCriterion("att_refer_moduleid =", value, "attReferModuleid");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidNotEqualTo(String value) {
			addCriterion("att_refer_moduleid <>", value, "attReferModuleid");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidGreaterThan(String value) {
			addCriterion("att_refer_moduleid >", value, "attReferModuleid");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidGreaterThanOrEqualTo(String value) {
			addCriterion("att_refer_moduleid >=", value, "attReferModuleid");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidLessThan(String value) {
			addCriterion("att_refer_moduleid <", value, "attReferModuleid");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidLessThanOrEqualTo(String value) {
			addCriterion("att_refer_moduleid <=", value, "attReferModuleid");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidLike(String value) {
			addCriterion("att_refer_moduleid like", value, "attReferModuleid");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidNotLike(String value) {
			addCriterion("att_refer_moduleid not like", value, "attReferModuleid");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidIn(List<String> values) {
			addCriterion("att_refer_moduleid in", values, "attReferModuleid");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidNotIn(List<String> values) {
			addCriterion("att_refer_moduleid not in", values, "attReferModuleid");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidBetween(String value1, String value2) {
			addCriterion("att_refer_moduleid between", value1, value2, "attReferModuleid");
			return (Criteria) this;
		}

		public Criteria andAttReferModuleidNotBetween(String value1, String value2) {
			addCriterion("att_refer_moduleid not between", value1, value2, "attReferModuleid");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidIsNull() {
			addCriterion("att_refer_attributeid is null");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidIsNotNull() {
			addCriterion("att_refer_attributeid is not null");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidEqualTo(String value) {
			addCriterion("att_refer_attributeid =", value, "attReferAttributeid");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidNotEqualTo(String value) {
			addCriterion("att_refer_attributeid <>", value, "attReferAttributeid");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidGreaterThan(String value) {
			addCriterion("att_refer_attributeid >", value, "attReferAttributeid");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidGreaterThanOrEqualTo(String value) {
			addCriterion("att_refer_attributeid >=", value, "attReferAttributeid");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidLessThan(String value) {
			addCriterion("att_refer_attributeid <", value, "attReferAttributeid");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidLessThanOrEqualTo(String value) {
			addCriterion("att_refer_attributeid <=", value, "attReferAttributeid");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidLike(String value) {
			addCriterion("att_refer_attributeid like", value, "attReferAttributeid");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidNotLike(String value) {
			addCriterion("att_refer_attributeid not like", value, "attReferAttributeid");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidIn(List<String> values) {
			addCriterion("att_refer_attributeid in", values, "attReferAttributeid");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidNotIn(List<String> values) {
			addCriterion("att_refer_attributeid not in", values, "attReferAttributeid");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidBetween(String value1, String value2) {
			addCriterion("att_refer_attributeid between", value1, value2, "attReferAttributeid");
			return (Criteria) this;
		}

		public Criteria andAttReferAttributeidNotBetween(String value1, String value2) {
			addCriterion("att_refer_attributeid not between", value1, value2, "attReferAttributeid");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidIsNull() {
			addCriterion("att_refer_objectid is null");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidIsNotNull() {
			addCriterion("att_refer_objectid is not null");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidEqualTo(String value) {
			addCriterion("att_refer_objectid =", value, "attReferObjectid");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidNotEqualTo(String value) {
			addCriterion("att_refer_objectid <>", value, "attReferObjectid");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidGreaterThan(String value) {
			addCriterion("att_refer_objectid >", value, "attReferObjectid");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidGreaterThanOrEqualTo(String value) {
			addCriterion("att_refer_objectid >=", value, "attReferObjectid");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidLessThan(String value) {
			addCriterion("att_refer_objectid <", value, "attReferObjectid");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidLessThanOrEqualTo(String value) {
			addCriterion("att_refer_objectid <=", value, "attReferObjectid");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidLike(String value) {
			addCriterion("att_refer_objectid like", value, "attReferObjectid");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidNotLike(String value) {
			addCriterion("att_refer_objectid not like", value, "attReferObjectid");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidIn(List<String> values) {
			addCriterion("att_refer_objectid in", values, "attReferObjectid");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidNotIn(List<String> values) {
			addCriterion("att_refer_objectid not in", values, "attReferObjectid");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidBetween(String value1, String value2) {
			addCriterion("att_refer_objectid between", value1, value2, "attReferObjectid");
			return (Criteria) this;
		}

		public Criteria andAttReferObjectidNotBetween(String value1, String value2) {
			addCriterion("att_refer_objectid not between", value1, value2, "attReferObjectid");
			return (Criteria) this;
		}

		public Criteria andAttStorePathIsNull() {
			addCriterion("att_store_path is null");
			return (Criteria) this;
		}

		public Criteria andAttStorePathIsNotNull() {
			addCriterion("att_store_path is not null");
			return (Criteria) this;
		}

		public Criteria andAttStorePathEqualTo(String value) {
			addCriterion("att_store_path =", value, "attStorePath");
			return (Criteria) this;
		}

		public Criteria andAttStorePathNotEqualTo(String value) {
			addCriterion("att_store_path <>", value, "attStorePath");
			return (Criteria) this;
		}

		public Criteria andAttStorePathGreaterThan(String value) {
			addCriterion("att_store_path >", value, "attStorePath");
			return (Criteria) this;
		}

		public Criteria andAttStorePathGreaterThanOrEqualTo(String value) {
			addCriterion("att_store_path >=", value, "attStorePath");
			return (Criteria) this;
		}

		public Criteria andAttStorePathLessThan(String value) {
			addCriterion("att_store_path <", value, "attStorePath");
			return (Criteria) this;
		}

		public Criteria andAttStorePathLessThanOrEqualTo(String value) {
			addCriterion("att_store_path <=", value, "attStorePath");
			return (Criteria) this;
		}

		public Criteria andAttStorePathLike(String value) {
			addCriterion("att_store_path like", value, "attStorePath");
			return (Criteria) this;
		}

		public Criteria andAttStorePathNotLike(String value) {
			addCriterion("att_store_path not like", value, "attStorePath");
			return (Criteria) this;
		}

		public Criteria andAttStorePathIn(List<String> values) {
			addCriterion("att_store_path in", values, "attStorePath");
			return (Criteria) this;
		}

		public Criteria andAttStorePathNotIn(List<String> values) {
			addCriterion("att_store_path not in", values, "attStorePath");
			return (Criteria) this;
		}

		public Criteria andAttStorePathBetween(String value1, String value2) {
			addCriterion("att_store_path between", value1, value2, "attStorePath");
			return (Criteria) this;
		}

		public Criteria andAttStorePathNotBetween(String value1, String value2) {
			addCriterion("att_store_path not between", value1, value2, "attStorePath");
			return (Criteria) this;
		}

		public Criteria andAttTypeIsNull() {
			addCriterion("att_type is null");
			return (Criteria) this;
		}

		public Criteria andAttTypeIsNotNull() {
			addCriterion("att_type is not null");
			return (Criteria) this;
		}

		public Criteria andAttTypeEqualTo(String value) {
			addCriterion("att_type =", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeNotEqualTo(String value) {
			addCriterion("att_type <>", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeGreaterThan(String value) {
			addCriterion("att_type >", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeGreaterThanOrEqualTo(String value) {
			addCriterion("att_type >=", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeLessThan(String value) {
			addCriterion("att_type <", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeLessThanOrEqualTo(String value) {
			addCriterion("att_type <=", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeLike(String value) {
			addCriterion("att_type like", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeNotLike(String value) {
			addCriterion("att_type not like", value, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeIn(List<String> values) {
			addCriterion("att_type in", values, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeNotIn(List<String> values) {
			addCriterion("att_type not in", values, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeBetween(String value1, String value2) {
			addCriterion("att_type between", value1, value2, "attType");
			return (Criteria) this;
		}

		public Criteria andAttTypeNotBetween(String value1, String value2) {
			addCriterion("att_type not between", value1, value2, "attType");
			return (Criteria) this;
		}

		public Criteria andAttSizeIsNull() {
			addCriterion("att_size is null");
			return (Criteria) this;
		}

		public Criteria andAttSizeIsNotNull() {
			addCriterion("att_size is not null");
			return (Criteria) this;
		}

		public Criteria andAttSizeEqualTo(String value) {
			addCriterion("att_size =", value, "attSize");
			return (Criteria) this;
		}

		public Criteria andAttSizeNotEqualTo(String value) {
			addCriterion("att_size <>", value, "attSize");
			return (Criteria) this;
		}

		public Criteria andAttSizeGreaterThan(String value) {
			addCriterion("att_size >", value, "attSize");
			return (Criteria) this;
		}

		public Criteria andAttSizeGreaterThanOrEqualTo(String value) {
			addCriterion("att_size >=", value, "attSize");
			return (Criteria) this;
		}

		public Criteria andAttSizeLessThan(String value) {
			addCriterion("att_size <", value, "attSize");
			return (Criteria) this;
		}

		public Criteria andAttSizeLessThanOrEqualTo(String value) {
			addCriterion("att_size <=", value, "attSize");
			return (Criteria) this;
		}

		public Criteria andAttSizeLike(String value) {
			addCriterion("att_size like", value, "attSize");
			return (Criteria) this;
		}

		public Criteria andAttSizeNotLike(String value) {
			addCriterion("att_size not like", value, "attSize");
			return (Criteria) this;
		}

		public Criteria andAttSizeIn(List<String> values) {
			addCriterion("att_size in", values, "attSize");
			return (Criteria) this;
		}

		public Criteria andAttSizeNotIn(List<String> values) {
			addCriterion("att_size not in", values, "attSize");
			return (Criteria) this;
		}

		public Criteria andAttSizeBetween(String value1, String value2) {
			addCriterion("att_size between", value1, value2, "attSize");
			return (Criteria) this;
		}

		public Criteria andAttSizeNotBetween(String value1, String value2) {
			addCriterion("att_size not between", value1, value2, "attSize");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateIsNull() {
			addCriterion("att_createdate is null");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateIsNotNull() {
			addCriterion("att_createdate is not null");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateEqualTo(String value) {
			addCriterion("att_createdate =", value, "attCreatedate");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateNotEqualTo(String value) {
			addCriterion("att_createdate <>", value, "attCreatedate");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateGreaterThan(String value) {
			addCriterion("att_createdate >", value, "attCreatedate");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateGreaterThanOrEqualTo(String value) {
			addCriterion("att_createdate >=", value, "attCreatedate");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateLessThan(String value) {
			addCriterion("att_createdate <", value, "attCreatedate");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateLessThanOrEqualTo(String value) {
			addCriterion("att_createdate <=", value, "attCreatedate");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateLike(String value) {
			addCriterion("att_createdate like", value, "attCreatedate");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateNotLike(String value) {
			addCriterion("att_createdate not like", value, "attCreatedate");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateIn(List<String> values) {
			addCriterion("att_createdate in", values, "attCreatedate");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateNotIn(List<String> values) {
			addCriterion("att_createdate not in", values, "attCreatedate");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateBetween(String value1, String value2) {
			addCriterion("att_createdate between", value1, value2, "attCreatedate");
			return (Criteria) this;
		}

		public Criteria andAttCreatedateNotBetween(String value1, String value2) {
			addCriterion("att_createdate not between", value1, value2, "attCreatedate");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserIsNull() {
			addCriterion("att_createuser is null");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserIsNotNull() {
			addCriterion("att_createuser is not null");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserEqualTo(String value) {
			addCriterion("att_createuser =", value, "attCreateuser");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserNotEqualTo(String value) {
			addCriterion("att_createuser <>", value, "attCreateuser");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserGreaterThan(String value) {
			addCriterion("att_createuser >", value, "attCreateuser");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserGreaterThanOrEqualTo(String value) {
			addCriterion("att_createuser >=", value, "attCreateuser");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserLessThan(String value) {
			addCriterion("att_createuser <", value, "attCreateuser");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserLessThanOrEqualTo(String value) {
			addCriterion("att_createuser <=", value, "attCreateuser");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserLike(String value) {
			addCriterion("att_createuser like", value, "attCreateuser");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserNotLike(String value) {
			addCriterion("att_createuser not like", value, "attCreateuser");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserIn(List<String> values) {
			addCriterion("att_createuser in", values, "attCreateuser");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserNotIn(List<String> values) {
			addCriterion("att_createuser not in", values, "attCreateuser");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserBetween(String value1, String value2) {
			addCriterion("att_createuser between", value1, value2, "attCreateuser");
			return (Criteria) this;
		}

		public Criteria andAttCreateuserNotBetween(String value1, String value2) {
			addCriterion("att_createuser not between", value1, value2, "attCreateuser");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateIsNull() {
			addCriterion("att_updatedate is null");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateIsNotNull() {
			addCriterion("att_updatedate is not null");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateEqualTo(String value) {
			addCriterion("att_updatedate =", value, "attUpdatedate");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateNotEqualTo(String value) {
			addCriterion("att_updatedate <>", value, "attUpdatedate");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateGreaterThan(String value) {
			addCriterion("att_updatedate >", value, "attUpdatedate");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateGreaterThanOrEqualTo(String value) {
			addCriterion("att_updatedate >=", value, "attUpdatedate");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateLessThan(String value) {
			addCriterion("att_updatedate <", value, "attUpdatedate");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateLessThanOrEqualTo(String value) {
			addCriterion("att_updatedate <=", value, "attUpdatedate");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateLike(String value) {
			addCriterion("att_updatedate like", value, "attUpdatedate");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateNotLike(String value) {
			addCriterion("att_updatedate not like", value, "attUpdatedate");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateIn(List<String> values) {
			addCriterion("att_updatedate in", values, "attUpdatedate");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateNotIn(List<String> values) {
			addCriterion("att_updatedate not in", values, "attUpdatedate");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateBetween(String value1, String value2) {
			addCriterion("att_updatedate between", value1, value2, "attUpdatedate");
			return (Criteria) this;
		}

		public Criteria andAttUpdatedateNotBetween(String value1, String value2) {
			addCriterion("att_updatedate not between", value1, value2, "attUpdatedate");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserIsNull() {
			addCriterion("att_updateuser is null");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserIsNotNull() {
			addCriterion("att_updateuser is not null");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserEqualTo(String value) {
			addCriterion("att_updateuser =", value, "attUpdateuser");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserNotEqualTo(String value) {
			addCriterion("att_updateuser <>", value, "attUpdateuser");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserGreaterThan(String value) {
			addCriterion("att_updateuser >", value, "attUpdateuser");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserGreaterThanOrEqualTo(String value) {
			addCriterion("att_updateuser >=", value, "attUpdateuser");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserLessThan(String value) {
			addCriterion("att_updateuser <", value, "attUpdateuser");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserLessThanOrEqualTo(String value) {
			addCriterion("att_updateuser <=", value, "attUpdateuser");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserLike(String value) {
			addCriterion("att_updateuser like", value, "attUpdateuser");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserNotLike(String value) {
			addCriterion("att_updateuser not like", value, "attUpdateuser");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserIn(List<String> values) {
			addCriterion("att_updateuser in", values, "attUpdateuser");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserNotIn(List<String> values) {
			addCriterion("att_updateuser not in", values, "attUpdateuser");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserBetween(String value1, String value2) {
			addCriterion("att_updateuser between", value1, value2, "attUpdateuser");
			return (Criteria) this;
		}

		public Criteria andAttUpdateuserNotBetween(String value1, String value2) {
			addCriterion("att_updateuser not between", value1, value2, "attUpdateuser");
			return (Criteria) this;
		}

		public Criteria andAttStatusIsNull() {
			addCriterion("att_status is null");
			return (Criteria) this;
		}

		public Criteria andAttStatusIsNotNull() {
			addCriterion("att_status is not null");
			return (Criteria) this;
		}

		public Criteria andAttStatusEqualTo(String value) {
			addCriterion("att_status =", value, "attStatus");
			return (Criteria) this;
		}

		public Criteria andAttStatusNotEqualTo(String value) {
			addCriterion("att_status <>", value, "attStatus");
			return (Criteria) this;
		}

		public Criteria andAttStatusGreaterThan(String value) {
			addCriterion("att_status >", value, "attStatus");
			return (Criteria) this;
		}

		public Criteria andAttStatusGreaterThanOrEqualTo(String value) {
			addCriterion("att_status >=", value, "attStatus");
			return (Criteria) this;
		}

		public Criteria andAttStatusLessThan(String value) {
			addCriterion("att_status <", value, "attStatus");
			return (Criteria) this;
		}

		public Criteria andAttStatusLessThanOrEqualTo(String value) {
			addCriterion("att_status <=", value, "attStatus");
			return (Criteria) this;
		}

		public Criteria andAttStatusLike(String value) {
			addCriterion("att_status like", value, "attStatus");
			return (Criteria) this;
		}

		public Criteria andAttStatusNotLike(String value) {
			addCriterion("att_status not like", value, "attStatus");
			return (Criteria) this;
		}

		public Criteria andAttStatusIn(List<String> values) {
			addCriterion("att_status in", values, "attStatus");
			return (Criteria) this;
		}

		public Criteria andAttStatusNotIn(List<String> values) {
			addCriterion("att_status not in", values, "attStatus");
			return (Criteria) this;
		}

		public Criteria andAttStatusBetween(String value1, String value2) {
			addCriterion("att_status between", value1, value2, "attStatus");
			return (Criteria) this;
		}

		public Criteria andAttStatusNotBetween(String value1, String value2) {
			addCriterion("att_status not between", value1, value2, "attStatus");
			return (Criteria) this;
		}
	}

	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}

		public Criteria andAttOriginalNameLikeInsensitive(String value) {
			addCriterion("upper(att_original_name) like", value.toUpperCase(), "attOriginalName");
			return this;
		}

		public Criteria andAttActualNameLikeInsensitive(String value) {
			addCriterion("upper(att_actual_name) like", value.toUpperCase(), "attActualName");
			return this;
		}

		public Criteria andAttReferModuleidLikeInsensitive(String value) {
			addCriterion("upper(att_refer_moduleid) like", value.toUpperCase(), "attReferModuleid");
			return this;
		}

		public Criteria andAttReferAttributeidLikeInsensitive(String value) {
			addCriterion("upper(att_refer_attributeid) like", value.toUpperCase(), "attReferAttributeid");
			return this;
		}

		public Criteria andAttReferObjectidLikeInsensitive(String value) {
			addCriterion("upper(att_refer_objectid) like", value.toUpperCase(), "attReferObjectid");
			return this;
		}

		public Criteria andAttStorePathLikeInsensitive(String value) {
			addCriterion("upper(att_store_path) like", value.toUpperCase(), "attStorePath");
			return this;
		}

		public Criteria andAttTypeLikeInsensitive(String value) {
			addCriterion("upper(att_type) like", value.toUpperCase(), "attType");
			return this;
		}

		public Criteria andAttSizeLikeInsensitive(String value) {
			addCriterion("upper(att_size) like", value.toUpperCase(), "attSize");
			return this;
		}

		public Criteria andAttCreatedateLikeInsensitive(String value) {
			addCriterion("upper(att_createdate) like", value.toUpperCase(), "attCreatedate");
			return this;
		}

		public Criteria andAttCreateuserLikeInsensitive(String value) {
			addCriterion("upper(att_createuser) like", value.toUpperCase(), "attCreateuser");
			return this;
		}

		public Criteria andAttUpdatedateLikeInsensitive(String value) {
			addCriterion("upper(att_updatedate) like", value.toUpperCase(), "attUpdatedate");
			return this;
		}

		public Criteria andAttUpdateuserLikeInsensitive(String value) {
			addCriterion("upper(att_updateuser) like", value.toUpperCase(), "attUpdateuser");
			return this;
		}

		public Criteria andAttStatusLikeInsensitive(String value) {
			addCriterion("upper(att_status) like", value.toUpperCase(), "attStatus");
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