package com.xiu.utopia.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlbumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AlbumExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIsNull() {
            addCriterion("album_id is null");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIsNotNull() {
            addCriterion("album_id is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumIdEqualTo(Integer value) {
            addCriterion("album_id =", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotEqualTo(Integer value) {
            addCriterion("album_id <>", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdGreaterThan(Integer value) {
            addCriterion("album_id >", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("album_id >=", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLessThan(Integer value) {
            addCriterion("album_id <", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLessThanOrEqualTo(Integer value) {
            addCriterion("album_id <=", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIn(List<Integer> values) {
            addCriterion("album_id in", values, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotIn(List<Integer> values) {
            addCriterion("album_id not in", values, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdBetween(Integer value1, Integer value2) {
            addCriterion("album_id between", value1, value2, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotBetween(Integer value1, Integer value2) {
            addCriterion("album_id not between", value1, value2, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumMidIsNull() {
            addCriterion("album_mid is null");
            return (Criteria) this;
        }

        public Criteria andAlbumMidIsNotNull() {
            addCriterion("album_mid is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumMidEqualTo(String value) {
            addCriterion("album_mid =", value, "albumMid");
            return (Criteria) this;
        }

        public Criteria andAlbumMidNotEqualTo(String value) {
            addCriterion("album_mid <>", value, "albumMid");
            return (Criteria) this;
        }

        public Criteria andAlbumMidGreaterThan(String value) {
            addCriterion("album_mid >", value, "albumMid");
            return (Criteria) this;
        }

        public Criteria andAlbumMidGreaterThanOrEqualTo(String value) {
            addCriterion("album_mid >=", value, "albumMid");
            return (Criteria) this;
        }

        public Criteria andAlbumMidLessThan(String value) {
            addCriterion("album_mid <", value, "albumMid");
            return (Criteria) this;
        }

        public Criteria andAlbumMidLessThanOrEqualTo(String value) {
            addCriterion("album_mid <=", value, "albumMid");
            return (Criteria) this;
        }

        public Criteria andAlbumMidLike(String value) {
            addCriterion("album_mid like", value, "albumMid");
            return (Criteria) this;
        }

        public Criteria andAlbumMidNotLike(String value) {
            addCriterion("album_mid not like", value, "albumMid");
            return (Criteria) this;
        }

        public Criteria andAlbumMidIn(List<String> values) {
            addCriterion("album_mid in", values, "albumMid");
            return (Criteria) this;
        }

        public Criteria andAlbumMidNotIn(List<String> values) {
            addCriterion("album_mid not in", values, "albumMid");
            return (Criteria) this;
        }

        public Criteria andAlbumMidBetween(String value1, String value2) {
            addCriterion("album_mid between", value1, value2, "albumMid");
            return (Criteria) this;
        }

        public Criteria andAlbumMidNotBetween(String value1, String value2) {
            addCriterion("album_mid not between", value1, value2, "albumMid");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIsNull() {
            addCriterion("album_name is null");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIsNotNull() {
            addCriterion("album_name is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumNameEqualTo(String value) {
            addCriterion("album_name =", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotEqualTo(String value) {
            addCriterion("album_name <>", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameGreaterThan(String value) {
            addCriterion("album_name >", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameGreaterThanOrEqualTo(String value) {
            addCriterion("album_name >=", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLessThan(String value) {
            addCriterion("album_name <", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLessThanOrEqualTo(String value) {
            addCriterion("album_name <=", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameLike(String value) {
            addCriterion("album_name like", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotLike(String value) {
            addCriterion("album_name not like", value, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameIn(List<String> values) {
            addCriterion("album_name in", values, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotIn(List<String> values) {
            addCriterion("album_name not in", values, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameBetween(String value1, String value2) {
            addCriterion("album_name between", value1, value2, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumNameNotBetween(String value1, String value2) {
            addCriterion("album_name not between", value1, value2, "albumName");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeIsNull() {
            addCriterion("album_type is null");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeIsNotNull() {
            addCriterion("album_type is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeEqualTo(String value) {
            addCriterion("album_type =", value, "albumType");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeNotEqualTo(String value) {
            addCriterion("album_type <>", value, "albumType");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeGreaterThan(String value) {
            addCriterion("album_type >", value, "albumType");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeGreaterThanOrEqualTo(String value) {
            addCriterion("album_type >=", value, "albumType");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeLessThan(String value) {
            addCriterion("album_type <", value, "albumType");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeLessThanOrEqualTo(String value) {
            addCriterion("album_type <=", value, "albumType");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeLike(String value) {
            addCriterion("album_type like", value, "albumType");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeNotLike(String value) {
            addCriterion("album_type not like", value, "albumType");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeIn(List<String> values) {
            addCriterion("album_type in", values, "albumType");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeNotIn(List<String> values) {
            addCriterion("album_type not in", values, "albumType");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeBetween(String value1, String value2) {
            addCriterion("album_type between", value1, value2, "albumType");
            return (Criteria) this;
        }

        public Criteria andAlbumTypeNotBetween(String value1, String value2) {
            addCriterion("album_type not between", value1, value2, "albumType");
            return (Criteria) this;
        }

        public Criteria andAlbumPicIsNull() {
            addCriterion("album_pic is null");
            return (Criteria) this;
        }

        public Criteria andAlbumPicIsNotNull() {
            addCriterion("album_pic is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumPicEqualTo(String value) {
            addCriterion("album_pic =", value, "albumPic");
            return (Criteria) this;
        }

        public Criteria andAlbumPicNotEqualTo(String value) {
            addCriterion("album_pic <>", value, "albumPic");
            return (Criteria) this;
        }

        public Criteria andAlbumPicGreaterThan(String value) {
            addCriterion("album_pic >", value, "albumPic");
            return (Criteria) this;
        }

        public Criteria andAlbumPicGreaterThanOrEqualTo(String value) {
            addCriterion("album_pic >=", value, "albumPic");
            return (Criteria) this;
        }

        public Criteria andAlbumPicLessThan(String value) {
            addCriterion("album_pic <", value, "albumPic");
            return (Criteria) this;
        }

        public Criteria andAlbumPicLessThanOrEqualTo(String value) {
            addCriterion("album_pic <=", value, "albumPic");
            return (Criteria) this;
        }

        public Criteria andAlbumPicLike(String value) {
            addCriterion("album_pic like", value, "albumPic");
            return (Criteria) this;
        }

        public Criteria andAlbumPicNotLike(String value) {
            addCriterion("album_pic not like", value, "albumPic");
            return (Criteria) this;
        }

        public Criteria andAlbumPicIn(List<String> values) {
            addCriterion("album_pic in", values, "albumPic");
            return (Criteria) this;
        }

        public Criteria andAlbumPicNotIn(List<String> values) {
            addCriterion("album_pic not in", values, "albumPic");
            return (Criteria) this;
        }

        public Criteria andAlbumPicBetween(String value1, String value2) {
            addCriterion("album_pic between", value1, value2, "albumPic");
            return (Criteria) this;
        }

        public Criteria andAlbumPicNotBetween(String value1, String value2) {
            addCriterion("album_pic not between", value1, value2, "albumPic");
            return (Criteria) this;
        }

        public Criteria andSignerMidIsNull() {
            addCriterion("signer_mid is null");
            return (Criteria) this;
        }

        public Criteria andSignerMidIsNotNull() {
            addCriterion("signer_mid is not null");
            return (Criteria) this;
        }

        public Criteria andSignerMidEqualTo(String value) {
            addCriterion("signer_mid =", value, "signerMid");
            return (Criteria) this;
        }

        public Criteria andSignerMidNotEqualTo(String value) {
            addCriterion("signer_mid <>", value, "signerMid");
            return (Criteria) this;
        }

        public Criteria andSignerMidGreaterThan(String value) {
            addCriterion("signer_mid >", value, "signerMid");
            return (Criteria) this;
        }

        public Criteria andSignerMidGreaterThanOrEqualTo(String value) {
            addCriterion("signer_mid >=", value, "signerMid");
            return (Criteria) this;
        }

        public Criteria andSignerMidLessThan(String value) {
            addCriterion("signer_mid <", value, "signerMid");
            return (Criteria) this;
        }

        public Criteria andSignerMidLessThanOrEqualTo(String value) {
            addCriterion("signer_mid <=", value, "signerMid");
            return (Criteria) this;
        }

        public Criteria andSignerMidLike(String value) {
            addCriterion("signer_mid like", value, "signerMid");
            return (Criteria) this;
        }

        public Criteria andSignerMidNotLike(String value) {
            addCriterion("signer_mid not like", value, "signerMid");
            return (Criteria) this;
        }

        public Criteria andSignerMidIn(List<String> values) {
            addCriterion("signer_mid in", values, "signerMid");
            return (Criteria) this;
        }

        public Criteria andSignerMidNotIn(List<String> values) {
            addCriterion("signer_mid not in", values, "signerMid");
            return (Criteria) this;
        }

        public Criteria andSignerMidBetween(String value1, String value2) {
            addCriterion("signer_mid between", value1, value2, "signerMid");
            return (Criteria) this;
        }

        public Criteria andSignerMidNotBetween(String value1, String value2) {
            addCriterion("signer_mid not between", value1, value2, "signerMid");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNull() {
            addCriterion("school is null");
            return (Criteria) this;
        }

        public Criteria andSchoolIsNotNull() {
            addCriterion("school is not null");
            return (Criteria) this;
        }

        public Criteria andSchoolEqualTo(String value) {
            addCriterion("school =", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotEqualTo(String value) {
            addCriterion("school <>", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThan(String value) {
            addCriterion("school >", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("school >=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThan(String value) {
            addCriterion("school <", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLessThanOrEqualTo(String value) {
            addCriterion("school <=", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolLike(String value) {
            addCriterion("school like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotLike(String value) {
            addCriterion("school not like", value, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolIn(List<String> values) {
            addCriterion("school in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotIn(List<String> values) {
            addCriterion("school not in", values, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolBetween(String value1, String value2) {
            addCriterion("school between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andSchoolNotBetween(String value1, String value2) {
            addCriterion("school not between", value1, value2, "school");
            return (Criteria) this;
        }

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(String value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(String value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(String value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(String value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(String value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(String value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLike(String value) {
            addCriterion("score like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotLike(String value) {
            addCriterion("score not like", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<String> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<String> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(String value1, String value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(String value1, String value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andLanIsNull() {
            addCriterion("lan is null");
            return (Criteria) this;
        }

        public Criteria andLanIsNotNull() {
            addCriterion("lan is not null");
            return (Criteria) this;
        }

        public Criteria andLanEqualTo(String value) {
            addCriterion("lan =", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanNotEqualTo(String value) {
            addCriterion("lan <>", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanGreaterThan(String value) {
            addCriterion("lan >", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanGreaterThanOrEqualTo(String value) {
            addCriterion("lan >=", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanLessThan(String value) {
            addCriterion("lan <", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanLessThanOrEqualTo(String value) {
            addCriterion("lan <=", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanLike(String value) {
            addCriterion("lan like", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanNotLike(String value) {
            addCriterion("lan not like", value, "lan");
            return (Criteria) this;
        }

        public Criteria andLanIn(List<String> values) {
            addCriterion("lan in", values, "lan");
            return (Criteria) this;
        }

        public Criteria andLanNotIn(List<String> values) {
            addCriterion("lan not in", values, "lan");
            return (Criteria) this;
        }

        public Criteria andLanBetween(String value1, String value2) {
            addCriterion("lan between", value1, value2, "lan");
            return (Criteria) this;
        }

        public Criteria andLanNotBetween(String value1, String value2) {
            addCriterion("lan not between", value1, value2, "lan");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNull() {
            addCriterion("pub_time is null");
            return (Criteria) this;
        }

        public Criteria andPubTimeIsNotNull() {
            addCriterion("pub_time is not null");
            return (Criteria) this;
        }

        public Criteria andPubTimeEqualTo(Date value) {
            addCriterion("pub_time =", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotEqualTo(Date value) {
            addCriterion("pub_time <>", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThan(Date value) {
            addCriterion("pub_time >", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pub_time >=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThan(Date value) {
            addCriterion("pub_time <", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeLessThanOrEqualTo(Date value) {
            addCriterion("pub_time <=", value, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeIn(List<Date> values) {
            addCriterion("pub_time in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotIn(List<Date> values) {
            addCriterion("pub_time not in", values, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeBetween(Date value1, Date value2) {
            addCriterion("pub_time between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andPubTimeNotBetween(Date value1, Date value2) {
            addCriterion("pub_time not between", value1, value2, "pubTime");
            return (Criteria) this;
        }

        public Criteria andDescptionIsNull() {
            addCriterion("descption is null");
            return (Criteria) this;
        }

        public Criteria andDescptionIsNotNull() {
            addCriterion("descption is not null");
            return (Criteria) this;
        }

        public Criteria andDescptionEqualTo(String value) {
            addCriterion("descption =", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionNotEqualTo(String value) {
            addCriterion("descption <>", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionGreaterThan(String value) {
            addCriterion("descption >", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionGreaterThanOrEqualTo(String value) {
            addCriterion("descption >=", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionLessThan(String value) {
            addCriterion("descption <", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionLessThanOrEqualTo(String value) {
            addCriterion("descption <=", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionLike(String value) {
            addCriterion("descption like", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionNotLike(String value) {
            addCriterion("descption not like", value, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionIn(List<String> values) {
            addCriterion("descption in", values, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionNotIn(List<String> values) {
            addCriterion("descption not in", values, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionBetween(String value1, String value2) {
            addCriterion("descption between", value1, value2, "descption");
            return (Criteria) this;
        }

        public Criteria andDescptionNotBetween(String value1, String value2) {
            addCriterion("descption not between", value1, value2, "descption");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
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