package com.xiu.utopia.entity;

import java.util.ArrayList;
import java.util.List;

public class SingerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SingerExample() {
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

        public Criteria andSignerIdIsNull() {
            addCriterion("signer_id is null");
            return (Criteria) this;
        }

        public Criteria andSignerIdIsNotNull() {
            addCriterion("signer_id is not null");
            return (Criteria) this;
        }

        public Criteria andSignerIdEqualTo(Integer value) {
            addCriterion("signer_id =", value, "signerId");
            return (Criteria) this;
        }

        public Criteria andSignerIdNotEqualTo(Integer value) {
            addCriterion("signer_id <>", value, "signerId");
            return (Criteria) this;
        }

        public Criteria andSignerIdGreaterThan(Integer value) {
            addCriterion("signer_id >", value, "signerId");
            return (Criteria) this;
        }

        public Criteria andSignerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("signer_id >=", value, "signerId");
            return (Criteria) this;
        }

        public Criteria andSignerIdLessThan(Integer value) {
            addCriterion("signer_id <", value, "signerId");
            return (Criteria) this;
        }

        public Criteria andSignerIdLessThanOrEqualTo(Integer value) {
            addCriterion("signer_id <=", value, "signerId");
            return (Criteria) this;
        }

        public Criteria andSignerIdIn(List<Integer> values) {
            addCriterion("signer_id in", values, "signerId");
            return (Criteria) this;
        }

        public Criteria andSignerIdNotIn(List<Integer> values) {
            addCriterion("signer_id not in", values, "signerId");
            return (Criteria) this;
        }

        public Criteria andSignerIdBetween(Integer value1, Integer value2) {
            addCriterion("signer_id between", value1, value2, "signerId");
            return (Criteria) this;
        }

        public Criteria andSignerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("signer_id not between", value1, value2, "signerId");
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

        public Criteria andFullNameIsNull() {
            addCriterion("full_name is null");
            return (Criteria) this;
        }

        public Criteria andFullNameIsNotNull() {
            addCriterion("full_name is not null");
            return (Criteria) this;
        }

        public Criteria andFullNameEqualTo(String value) {
            addCriterion("full_name =", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotEqualTo(String value) {
            addCriterion("full_name <>", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameGreaterThan(String value) {
            addCriterion("full_name >", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameGreaterThanOrEqualTo(String value) {
            addCriterion("full_name >=", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLessThan(String value) {
            addCriterion("full_name <", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLessThanOrEqualTo(String value) {
            addCriterion("full_name <=", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameLike(String value) {
            addCriterion("full_name like", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotLike(String value) {
            addCriterion("full_name not like", value, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameIn(List<String> values) {
            addCriterion("full_name in", values, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotIn(List<String> values) {
            addCriterion("full_name not in", values, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameBetween(String value1, String value2) {
            addCriterion("full_name between", value1, value2, "fullName");
            return (Criteria) this;
        }

        public Criteria andFullNameNotBetween(String value1, String value2) {
            addCriterion("full_name not between", value1, value2, "fullName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNull() {
            addCriterion("english_name is null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIsNotNull() {
            addCriterion("english_name is not null");
            return (Criteria) this;
        }

        public Criteria andEnglishNameEqualTo(String value) {
            addCriterion("english_name =", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotEqualTo(String value) {
            addCriterion("english_name <>", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThan(String value) {
            addCriterion("english_name >", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameGreaterThanOrEqualTo(String value) {
            addCriterion("english_name >=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThan(String value) {
            addCriterion("english_name <", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLessThanOrEqualTo(String value) {
            addCriterion("english_name <=", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameLike(String value) {
            addCriterion("english_name like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotLike(String value) {
            addCriterion("english_name not like", value, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameIn(List<String> values) {
            addCriterion("english_name in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotIn(List<String> values) {
            addCriterion("english_name not in", values, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameBetween(String value1, String value2) {
            addCriterion("english_name between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andEnglishNameNotBetween(String value1, String value2) {
            addCriterion("english_name not between", value1, value2, "englishName");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNull() {
            addCriterion("contract_id is null");
            return (Criteria) this;
        }

        public Criteria andContractIdIsNotNull() {
            addCriterion("contract_id is not null");
            return (Criteria) this;
        }

        public Criteria andContractIdEqualTo(String value) {
            addCriterion("contract_id =", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotEqualTo(String value) {
            addCriterion("contract_id <>", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThan(String value) {
            addCriterion("contract_id >", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdGreaterThanOrEqualTo(String value) {
            addCriterion("contract_id >=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThan(String value) {
            addCriterion("contract_id <", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLessThanOrEqualTo(String value) {
            addCriterion("contract_id <=", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdLike(String value) {
            addCriterion("contract_id like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotLike(String value) {
            addCriterion("contract_id not like", value, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdIn(List<String> values) {
            addCriterion("contract_id in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotIn(List<String> values) {
            addCriterion("contract_id not in", values, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdBetween(String value1, String value2) {
            addCriterion("contract_id between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andContractIdNotBetween(String value1, String value2) {
            addCriterion("contract_id not between", value1, value2, "contractId");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIsNull() {
            addCriterion("birth_place is null");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIsNotNull() {
            addCriterion("birth_place is not null");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceEqualTo(String value) {
            addCriterion("birth_place =", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotEqualTo(String value) {
            addCriterion("birth_place <>", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceGreaterThan(String value) {
            addCriterion("birth_place >", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("birth_place >=", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLessThan(String value) {
            addCriterion("birth_place <", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLessThanOrEqualTo(String value) {
            addCriterion("birth_place <=", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceLike(String value) {
            addCriterion("birth_place like", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotLike(String value) {
            addCriterion("birth_place not like", value, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceIn(List<String> values) {
            addCriterion("birth_place in", values, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotIn(List<String> values) {
            addCriterion("birth_place not in", values, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceBetween(String value1, String value2) {
            addCriterion("birth_place between", value1, value2, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthPlaceNotBetween(String value1, String value2) {
            addCriterion("birth_place not between", value1, value2, "birthPlace");
            return (Criteria) this;
        }

        public Criteria andBirthTimeIsNull() {
            addCriterion("birth_time is null");
            return (Criteria) this;
        }

        public Criteria andBirthTimeIsNotNull() {
            addCriterion("birth_time is not null");
            return (Criteria) this;
        }

        public Criteria andBirthTimeEqualTo(String value) {
            addCriterion("birth_time =", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeNotEqualTo(String value) {
            addCriterion("birth_time <>", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeGreaterThan(String value) {
            addCriterion("birth_time >", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeGreaterThanOrEqualTo(String value) {
            addCriterion("birth_time >=", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeLessThan(String value) {
            addCriterion("birth_time <", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeLessThanOrEqualTo(String value) {
            addCriterion("birth_time <=", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeLike(String value) {
            addCriterion("birth_time like", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeNotLike(String value) {
            addCriterion("birth_time not like", value, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeIn(List<String> values) {
            addCriterion("birth_time in", values, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeNotIn(List<String> values) {
            addCriterion("birth_time not in", values, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeBetween(String value1, String value2) {
            addCriterion("birth_time between", value1, value2, "birthTime");
            return (Criteria) this;
        }

        public Criteria andBirthTimeNotBetween(String value1, String value2) {
            addCriterion("birth_time not between", value1, value2, "birthTime");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNull() {
            addCriterion("profession is null");
            return (Criteria) this;
        }

        public Criteria andProfessionIsNotNull() {
            addCriterion("profession is not null");
            return (Criteria) this;
        }

        public Criteria andProfessionEqualTo(String value) {
            addCriterion("profession =", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotEqualTo(String value) {
            addCriterion("profession <>", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThan(String value) {
            addCriterion("profession >", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionGreaterThanOrEqualTo(String value) {
            addCriterion("profession >=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThan(String value) {
            addCriterion("profession <", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLessThanOrEqualTo(String value) {
            addCriterion("profession <=", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionLike(String value) {
            addCriterion("profession like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotLike(String value) {
            addCriterion("profession not like", value, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionIn(List<String> values) {
            addCriterion("profession in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotIn(List<String> values) {
            addCriterion("profession not in", values, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionBetween(String value1, String value2) {
            addCriterion("profession between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andProfessionNotBetween(String value1, String value2) {
            addCriterion("profession not between", value1, value2, "profession");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andMembersIsNull() {
            addCriterion("members is null");
            return (Criteria) this;
        }

        public Criteria andMembersIsNotNull() {
            addCriterion("members is not null");
            return (Criteria) this;
        }

        public Criteria andMembersEqualTo(String value) {
            addCriterion("members =", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersNotEqualTo(String value) {
            addCriterion("members <>", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersGreaterThan(String value) {
            addCriterion("members >", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersGreaterThanOrEqualTo(String value) {
            addCriterion("members >=", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersLessThan(String value) {
            addCriterion("members <", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersLessThanOrEqualTo(String value) {
            addCriterion("members <=", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersLike(String value) {
            addCriterion("members like", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersNotLike(String value) {
            addCriterion("members not like", value, "members");
            return (Criteria) this;
        }

        public Criteria andMembersIn(List<String> values) {
            addCriterion("members in", values, "members");
            return (Criteria) this;
        }

        public Criteria andMembersNotIn(List<String> values) {
            addCriterion("members not in", values, "members");
            return (Criteria) this;
        }

        public Criteria andMembersBetween(String value1, String value2) {
            addCriterion("members between", value1, value2, "members");
            return (Criteria) this;
        }

        public Criteria andMembersNotBetween(String value1, String value2) {
            addCriterion("members not between", value1, value2, "members");
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

        public Criteria andFirstLetterIsNull() {
            addCriterion("first_letter is null");
            return (Criteria) this;
        }

        public Criteria andFirstLetterIsNotNull() {
            addCriterion("first_letter is not null");
            return (Criteria) this;
        }

        public Criteria andFirstLetterEqualTo(String value) {
            addCriterion("first_letter =", value, "firstLetter");
            return (Criteria) this;
        }

        public Criteria andFirstLetterNotEqualTo(String value) {
            addCriterion("first_letter <>", value, "firstLetter");
            return (Criteria) this;
        }

        public Criteria andFirstLetterGreaterThan(String value) {
            addCriterion("first_letter >", value, "firstLetter");
            return (Criteria) this;
        }

        public Criteria andFirstLetterGreaterThanOrEqualTo(String value) {
            addCriterion("first_letter >=", value, "firstLetter");
            return (Criteria) this;
        }

        public Criteria andFirstLetterLessThan(String value) {
            addCriterion("first_letter <", value, "firstLetter");
            return (Criteria) this;
        }

        public Criteria andFirstLetterLessThanOrEqualTo(String value) {
            addCriterion("first_letter <=", value, "firstLetter");
            return (Criteria) this;
        }

        public Criteria andFirstLetterLike(String value) {
            addCriterion("first_letter like", value, "firstLetter");
            return (Criteria) this;
        }

        public Criteria andFirstLetterNotLike(String value) {
            addCriterion("first_letter not like", value, "firstLetter");
            return (Criteria) this;
        }

        public Criteria andFirstLetterIn(List<String> values) {
            addCriterion("first_letter in", values, "firstLetter");
            return (Criteria) this;
        }

        public Criteria andFirstLetterNotIn(List<String> values) {
            addCriterion("first_letter not in", values, "firstLetter");
            return (Criteria) this;
        }

        public Criteria andFirstLetterBetween(String value1, String value2) {
            addCriterion("first_letter between", value1, value2, "firstLetter");
            return (Criteria) this;
        }

        public Criteria andFirstLetterNotBetween(String value1, String value2) {
            addCriterion("first_letter not between", value1, value2, "firstLetter");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andBrokerIsNull() {
            addCriterion("broker is null");
            return (Criteria) this;
        }

        public Criteria andBrokerIsNotNull() {
            addCriterion("broker is not null");
            return (Criteria) this;
        }

        public Criteria andBrokerEqualTo(String value) {
            addCriterion("broker =", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerNotEqualTo(String value) {
            addCriterion("broker <>", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerGreaterThan(String value) {
            addCriterion("broker >", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerGreaterThanOrEqualTo(String value) {
            addCriterion("broker >=", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerLessThan(String value) {
            addCriterion("broker <", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerLessThanOrEqualTo(String value) {
            addCriterion("broker <=", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerLike(String value) {
            addCriterion("broker like", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerNotLike(String value) {
            addCriterion("broker not like", value, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerIn(List<String> values) {
            addCriterion("broker in", values, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerNotIn(List<String> values) {
            addCriterion("broker not in", values, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerBetween(String value1, String value2) {
            addCriterion("broker between", value1, value2, "broker");
            return (Criteria) this;
        }

        public Criteria andBrokerNotBetween(String value1, String value2) {
            addCriterion("broker not between", value1, value2, "broker");
            return (Criteria) this;
        }

        public Criteria andStratTimeIsNull() {
            addCriterion("strat_time is null");
            return (Criteria) this;
        }

        public Criteria andStratTimeIsNotNull() {
            addCriterion("strat_time is not null");
            return (Criteria) this;
        }

        public Criteria andStratTimeEqualTo(String value) {
            addCriterion("strat_time =", value, "stratTime");
            return (Criteria) this;
        }

        public Criteria andStratTimeNotEqualTo(String value) {
            addCriterion("strat_time <>", value, "stratTime");
            return (Criteria) this;
        }

        public Criteria andStratTimeGreaterThan(String value) {
            addCriterion("strat_time >", value, "stratTime");
            return (Criteria) this;
        }

        public Criteria andStratTimeGreaterThanOrEqualTo(String value) {
            addCriterion("strat_time >=", value, "stratTime");
            return (Criteria) this;
        }

        public Criteria andStratTimeLessThan(String value) {
            addCriterion("strat_time <", value, "stratTime");
            return (Criteria) this;
        }

        public Criteria andStratTimeLessThanOrEqualTo(String value) {
            addCriterion("strat_time <=", value, "stratTime");
            return (Criteria) this;
        }

        public Criteria andStratTimeLike(String value) {
            addCriterion("strat_time like", value, "stratTime");
            return (Criteria) this;
        }

        public Criteria andStratTimeNotLike(String value) {
            addCriterion("strat_time not like", value, "stratTime");
            return (Criteria) this;
        }

        public Criteria andStratTimeIn(List<String> values) {
            addCriterion("strat_time in", values, "stratTime");
            return (Criteria) this;
        }

        public Criteria andStratTimeNotIn(List<String> values) {
            addCriterion("strat_time not in", values, "stratTime");
            return (Criteria) this;
        }

        public Criteria andStratTimeBetween(String value1, String value2) {
            addCriterion("strat_time between", value1, value2, "stratTime");
            return (Criteria) this;
        }

        public Criteria andStratTimeNotBetween(String value1, String value2) {
            addCriterion("strat_time not between", value1, value2, "stratTime");
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, "pic");
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, "pic");
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, "pic");
            return (Criteria) this;
        }

        public Criteria andPicLocalIsNull() {
            addCriterion("pic_local is null");
            return (Criteria) this;
        }

        public Criteria andPicLocalIsNotNull() {
            addCriterion("pic_local is not null");
            return (Criteria) this;
        }

        public Criteria andPicLocalEqualTo(String value) {
            addCriterion("pic_local =", value, "picLocal");
            return (Criteria) this;
        }

        public Criteria andPicLocalNotEqualTo(String value) {
            addCriterion("pic_local <>", value, "picLocal");
            return (Criteria) this;
        }

        public Criteria andPicLocalGreaterThan(String value) {
            addCriterion("pic_local >", value, "picLocal");
            return (Criteria) this;
        }

        public Criteria andPicLocalGreaterThanOrEqualTo(String value) {
            addCriterion("pic_local >=", value, "picLocal");
            return (Criteria) this;
        }

        public Criteria andPicLocalLessThan(String value) {
            addCriterion("pic_local <", value, "picLocal");
            return (Criteria) this;
        }

        public Criteria andPicLocalLessThanOrEqualTo(String value) {
            addCriterion("pic_local <=", value, "picLocal");
            return (Criteria) this;
        }

        public Criteria andPicLocalLike(String value) {
            addCriterion("pic_local like", value, "picLocal");
            return (Criteria) this;
        }

        public Criteria andPicLocalNotLike(String value) {
            addCriterion("pic_local not like", value, "picLocal");
            return (Criteria) this;
        }

        public Criteria andPicLocalIn(List<String> values) {
            addCriterion("pic_local in", values, "picLocal");
            return (Criteria) this;
        }

        public Criteria andPicLocalNotIn(List<String> values) {
            addCriterion("pic_local not in", values, "picLocal");
            return (Criteria) this;
        }

        public Criteria andPicLocalBetween(String value1, String value2) {
            addCriterion("pic_local between", value1, value2, "picLocal");
            return (Criteria) this;
        }

        public Criteria andPicLocalNotBetween(String value1, String value2) {
            addCriterion("pic_local not between", value1, value2, "picLocal");
            return (Criteria) this;
        }

        public Criteria andHeigthIsNull() {
            addCriterion("heigth is null");
            return (Criteria) this;
        }

        public Criteria andHeigthIsNotNull() {
            addCriterion("heigth is not null");
            return (Criteria) this;
        }

        public Criteria andHeigthEqualTo(String value) {
            addCriterion("heigth =", value, "heigth");
            return (Criteria) this;
        }

        public Criteria andHeigthNotEqualTo(String value) {
            addCriterion("heigth <>", value, "heigth");
            return (Criteria) this;
        }

        public Criteria andHeigthGreaterThan(String value) {
            addCriterion("heigth >", value, "heigth");
            return (Criteria) this;
        }

        public Criteria andHeigthGreaterThanOrEqualTo(String value) {
            addCriterion("heigth >=", value, "heigth");
            return (Criteria) this;
        }

        public Criteria andHeigthLessThan(String value) {
            addCriterion("heigth <", value, "heigth");
            return (Criteria) this;
        }

        public Criteria andHeigthLessThanOrEqualTo(String value) {
            addCriterion("heigth <=", value, "heigth");
            return (Criteria) this;
        }

        public Criteria andHeigthLike(String value) {
            addCriterion("heigth like", value, "heigth");
            return (Criteria) this;
        }

        public Criteria andHeigthNotLike(String value) {
            addCriterion("heigth not like", value, "heigth");
            return (Criteria) this;
        }

        public Criteria andHeigthIn(List<String> values) {
            addCriterion("heigth in", values, "heigth");
            return (Criteria) this;
        }

        public Criteria andHeigthNotIn(List<String> values) {
            addCriterion("heigth not in", values, "heigth");
            return (Criteria) this;
        }

        public Criteria andHeigthBetween(String value1, String value2) {
            addCriterion("heigth between", value1, value2, "heigth");
            return (Criteria) this;
        }

        public Criteria andHeigthNotBetween(String value1, String value2) {
            addCriterion("heigth not between", value1, value2, "heigth");
            return (Criteria) this;
        }

        public Criteria andWeigthIsNull() {
            addCriterion("weigth is null");
            return (Criteria) this;
        }

        public Criteria andWeigthIsNotNull() {
            addCriterion("weigth is not null");
            return (Criteria) this;
        }

        public Criteria andWeigthEqualTo(String value) {
            addCriterion("weigth =", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthNotEqualTo(String value) {
            addCriterion("weigth <>", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthGreaterThan(String value) {
            addCriterion("weigth >", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthGreaterThanOrEqualTo(String value) {
            addCriterion("weigth >=", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthLessThan(String value) {
            addCriterion("weigth <", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthLessThanOrEqualTo(String value) {
            addCriterion("weigth <=", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthLike(String value) {
            addCriterion("weigth like", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthNotLike(String value) {
            addCriterion("weigth not like", value, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthIn(List<String> values) {
            addCriterion("weigth in", values, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthNotIn(List<String> values) {
            addCriterion("weigth not in", values, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthBetween(String value1, String value2) {
            addCriterion("weigth between", value1, value2, "weigth");
            return (Criteria) this;
        }

        public Criteria andWeigthNotBetween(String value1, String value2) {
            addCriterion("weigth not between", value1, value2, "weigth");
            return (Criteria) this;
        }

        public Criteria andBloodTypeIsNull() {
            addCriterion("blood_type is null");
            return (Criteria) this;
        }

        public Criteria andBloodTypeIsNotNull() {
            addCriterion("blood_type is not null");
            return (Criteria) this;
        }

        public Criteria andBloodTypeEqualTo(String value) {
            addCriterion("blood_type =", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeNotEqualTo(String value) {
            addCriterion("blood_type <>", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeGreaterThan(String value) {
            addCriterion("blood_type >", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeGreaterThanOrEqualTo(String value) {
            addCriterion("blood_type >=", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeLessThan(String value) {
            addCriterion("blood_type <", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeLessThanOrEqualTo(String value) {
            addCriterion("blood_type <=", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeLike(String value) {
            addCriterion("blood_type like", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeNotLike(String value) {
            addCriterion("blood_type not like", value, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeIn(List<String> values) {
            addCriterion("blood_type in", values, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeNotIn(List<String> values) {
            addCriterion("blood_type not in", values, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeBetween(String value1, String value2) {
            addCriterion("blood_type between", value1, value2, "bloodType");
            return (Criteria) this;
        }

        public Criteria andBloodTypeNotBetween(String value1, String value2) {
            addCriterion("blood_type not between", value1, value2, "bloodType");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolIsNull() {
            addCriterion("graduate_school is null");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolIsNotNull() {
            addCriterion("graduate_school is not null");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolEqualTo(String value) {
            addCriterion("graduate_school =", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolNotEqualTo(String value) {
            addCriterion("graduate_school <>", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolGreaterThan(String value) {
            addCriterion("graduate_school >", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("graduate_school >=", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolLessThan(String value) {
            addCriterion("graduate_school <", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolLessThanOrEqualTo(String value) {
            addCriterion("graduate_school <=", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolLike(String value) {
            addCriterion("graduate_school like", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolNotLike(String value) {
            addCriterion("graduate_school not like", value, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolIn(List<String> values) {
            addCriterion("graduate_school in", values, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolNotIn(List<String> values) {
            addCriterion("graduate_school not in", values, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolBetween(String value1, String value2) {
            addCriterion("graduate_school between", value1, value2, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andGraduateSchoolNotBetween(String value1, String value2) {
            addCriterion("graduate_school not between", value1, value2, "graduateSchool");
            return (Criteria) this;
        }

        public Criteria andConstellationIsNull() {
            addCriterion("constellation is null");
            return (Criteria) this;
        }

        public Criteria andConstellationIsNotNull() {
            addCriterion("constellation is not null");
            return (Criteria) this;
        }

        public Criteria andConstellationEqualTo(String value) {
            addCriterion("constellation =", value, "constellation");
            return (Criteria) this;
        }

        public Criteria andConstellationNotEqualTo(String value) {
            addCriterion("constellation <>", value, "constellation");
            return (Criteria) this;
        }

        public Criteria andConstellationGreaterThan(String value) {
            addCriterion("constellation >", value, "constellation");
            return (Criteria) this;
        }

        public Criteria andConstellationGreaterThanOrEqualTo(String value) {
            addCriterion("constellation >=", value, "constellation");
            return (Criteria) this;
        }

        public Criteria andConstellationLessThan(String value) {
            addCriterion("constellation <", value, "constellation");
            return (Criteria) this;
        }

        public Criteria andConstellationLessThanOrEqualTo(String value) {
            addCriterion("constellation <=", value, "constellation");
            return (Criteria) this;
        }

        public Criteria andConstellationLike(String value) {
            addCriterion("constellation like", value, "constellation");
            return (Criteria) this;
        }

        public Criteria andConstellationNotLike(String value) {
            addCriterion("constellation not like", value, "constellation");
            return (Criteria) this;
        }

        public Criteria andConstellationIn(List<String> values) {
            addCriterion("constellation in", values, "constellation");
            return (Criteria) this;
        }

        public Criteria andConstellationNotIn(List<String> values) {
            addCriterion("constellation not in", values, "constellation");
            return (Criteria) this;
        }

        public Criteria andConstellationBetween(String value1, String value2) {
            addCriterion("constellation between", value1, value2, "constellation");
            return (Criteria) this;
        }

        public Criteria andConstellationNotBetween(String value1, String value2) {
            addCriterion("constellation not between", value1, value2, "constellation");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNull() {
            addCriterion("language is null");
            return (Criteria) this;
        }

        public Criteria andLanguageIsNotNull() {
            addCriterion("language is not null");
            return (Criteria) this;
        }

        public Criteria andLanguageEqualTo(String value) {
            addCriterion("language =", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotEqualTo(String value) {
            addCriterion("language <>", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThan(String value) {
            addCriterion("language >", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("language >=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThan(String value) {
            addCriterion("language <", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLessThanOrEqualTo(String value) {
            addCriterion("language <=", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageLike(String value) {
            addCriterion("language like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotLike(String value) {
            addCriterion("language not like", value, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageIn(List<String> values) {
            addCriterion("language in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotIn(List<String> values) {
            addCriterion("language not in", values, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageBetween(String value1, String value2) {
            addCriterion("language between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andLanguageNotBetween(String value1, String value2) {
            addCriterion("language not between", value1, value2, "language");
            return (Criteria) this;
        }

        public Criteria andFansNameIsNull() {
            addCriterion("fans_name is null");
            return (Criteria) this;
        }

        public Criteria andFansNameIsNotNull() {
            addCriterion("fans_name is not null");
            return (Criteria) this;
        }

        public Criteria andFansNameEqualTo(String value) {
            addCriterion("fans_name =", value, "fansName");
            return (Criteria) this;
        }

        public Criteria andFansNameNotEqualTo(String value) {
            addCriterion("fans_name <>", value, "fansName");
            return (Criteria) this;
        }

        public Criteria andFansNameGreaterThan(String value) {
            addCriterion("fans_name >", value, "fansName");
            return (Criteria) this;
        }

        public Criteria andFansNameGreaterThanOrEqualTo(String value) {
            addCriterion("fans_name >=", value, "fansName");
            return (Criteria) this;
        }

        public Criteria andFansNameLessThan(String value) {
            addCriterion("fans_name <", value, "fansName");
            return (Criteria) this;
        }

        public Criteria andFansNameLessThanOrEqualTo(String value) {
            addCriterion("fans_name <=", value, "fansName");
            return (Criteria) this;
        }

        public Criteria andFansNameLike(String value) {
            addCriterion("fans_name like", value, "fansName");
            return (Criteria) this;
        }

        public Criteria andFansNameNotLike(String value) {
            addCriterion("fans_name not like", value, "fansName");
            return (Criteria) this;
        }

        public Criteria andFansNameIn(List<String> values) {
            addCriterion("fans_name in", values, "fansName");
            return (Criteria) this;
        }

        public Criteria andFansNameNotIn(List<String> values) {
            addCriterion("fans_name not in", values, "fansName");
            return (Criteria) this;
        }

        public Criteria andFansNameBetween(String value1, String value2) {
            addCriterion("fans_name between", value1, value2, "fansName");
            return (Criteria) this;
        }

        public Criteria andFansNameNotBetween(String value1, String value2) {
            addCriterion("fans_name not between", value1, value2, "fansName");
            return (Criteria) this;
        }

        public Criteria andIdolColorIsNull() {
            addCriterion("idol_color is null");
            return (Criteria) this;
        }

        public Criteria andIdolColorIsNotNull() {
            addCriterion("idol_color is not null");
            return (Criteria) this;
        }

        public Criteria andIdolColorEqualTo(String value) {
            addCriterion("idol_color =", value, "idolColor");
            return (Criteria) this;
        }

        public Criteria andIdolColorNotEqualTo(String value) {
            addCriterion("idol_color <>", value, "idolColor");
            return (Criteria) this;
        }

        public Criteria andIdolColorGreaterThan(String value) {
            addCriterion("idol_color >", value, "idolColor");
            return (Criteria) this;
        }

        public Criteria andIdolColorGreaterThanOrEqualTo(String value) {
            addCriterion("idol_color >=", value, "idolColor");
            return (Criteria) this;
        }

        public Criteria andIdolColorLessThan(String value) {
            addCriterion("idol_color <", value, "idolColor");
            return (Criteria) this;
        }

        public Criteria andIdolColorLessThanOrEqualTo(String value) {
            addCriterion("idol_color <=", value, "idolColor");
            return (Criteria) this;
        }

        public Criteria andIdolColorLike(String value) {
            addCriterion("idol_color like", value, "idolColor");
            return (Criteria) this;
        }

        public Criteria andIdolColorNotLike(String value) {
            addCriterion("idol_color not like", value, "idolColor");
            return (Criteria) this;
        }

        public Criteria andIdolColorIn(List<String> values) {
            addCriterion("idol_color in", values, "idolColor");
            return (Criteria) this;
        }

        public Criteria andIdolColorNotIn(List<String> values) {
            addCriterion("idol_color not in", values, "idolColor");
            return (Criteria) this;
        }

        public Criteria andIdolColorBetween(String value1, String value2) {
            addCriterion("idol_color between", value1, value2, "idolColor");
            return (Criteria) this;
        }

        public Criteria andIdolColorNotBetween(String value1, String value2) {
            addCriterion("idol_color not between", value1, value2, "idolColor");
            return (Criteria) this;
        }

        public Criteria andSpecialityIsNull() {
            addCriterion("speciality is null");
            return (Criteria) this;
        }

        public Criteria andSpecialityIsNotNull() {
            addCriterion("speciality is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialityEqualTo(String value) {
            addCriterion("speciality =", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotEqualTo(String value) {
            addCriterion("speciality <>", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityGreaterThan(String value) {
            addCriterion("speciality >", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityGreaterThanOrEqualTo(String value) {
            addCriterion("speciality >=", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityLessThan(String value) {
            addCriterion("speciality <", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityLessThanOrEqualTo(String value) {
            addCriterion("speciality <=", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityLike(String value) {
            addCriterion("speciality like", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotLike(String value) {
            addCriterion("speciality not like", value, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityIn(List<String> values) {
            addCriterion("speciality in", values, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotIn(List<String> values) {
            addCriterion("speciality not in", values, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityBetween(String value1, String value2) {
            addCriterion("speciality between", value1, value2, "speciality");
            return (Criteria) this;
        }

        public Criteria andSpecialityNotBetween(String value1, String value2) {
            addCriterion("speciality not between", value1, value2, "speciality");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNull() {
            addCriterion("native_place is null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIsNotNull() {
            addCriterion("native_place is not null");
            return (Criteria) this;
        }

        public Criteria andNativePlaceEqualTo(String value) {
            addCriterion("native_place =", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotEqualTo(String value) {
            addCriterion("native_place <>", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThan(String value) {
            addCriterion("native_place >", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceGreaterThanOrEqualTo(String value) {
            addCriterion("native_place >=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThan(String value) {
            addCriterion("native_place <", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLessThanOrEqualTo(String value) {
            addCriterion("native_place <=", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceLike(String value) {
            addCriterion("native_place like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotLike(String value) {
            addCriterion("native_place not like", value, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceIn(List<String> values) {
            addCriterion("native_place in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotIn(List<String> values) {
            addCriterion("native_place not in", values, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceBetween(String value1, String value2) {
            addCriterion("native_place between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andNativePlaceNotBetween(String value1, String value2) {
            addCriterion("native_place not between", value1, value2, "nativePlace");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNull() {
            addCriterion("hobby is null");
            return (Criteria) this;
        }

        public Criteria andHobbyIsNotNull() {
            addCriterion("hobby is not null");
            return (Criteria) this;
        }

        public Criteria andHobbyEqualTo(String value) {
            addCriterion("hobby =", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotEqualTo(String value) {
            addCriterion("hobby <>", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThan(String value) {
            addCriterion("hobby >", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyGreaterThanOrEqualTo(String value) {
            addCriterion("hobby >=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThan(String value) {
            addCriterion("hobby <", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLessThanOrEqualTo(String value) {
            addCriterion("hobby <=", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyLike(String value) {
            addCriterion("hobby like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotLike(String value) {
            addCriterion("hobby not like", value, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyIn(List<String> values) {
            addCriterion("hobby in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotIn(List<String> values) {
            addCriterion("hobby not in", values, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyBetween(String value1, String value2) {
            addCriterion("hobby between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andHobbyNotBetween(String value1, String value2) {
            addCriterion("hobby not between", value1, value2, "hobby");
            return (Criteria) this;
        }

        public Criteria andIsoverIsNull() {
            addCriterion("isOver is null");
            return (Criteria) this;
        }

        public Criteria andIsoverIsNotNull() {
            addCriterion("isOver is not null");
            return (Criteria) this;
        }

        public Criteria andIsoverEqualTo(Integer value) {
            addCriterion("isOver =", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsoverNotEqualTo(Integer value) {
            addCriterion("isOver <>", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsoverGreaterThan(Integer value) {
            addCriterion("isOver >", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsoverGreaterThanOrEqualTo(Integer value) {
            addCriterion("isOver >=", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsoverLessThan(Integer value) {
            addCriterion("isOver <", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsoverLessThanOrEqualTo(Integer value) {
            addCriterion("isOver <=", value, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsoverIn(List<Integer> values) {
            addCriterion("isOver in", values, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsoverNotIn(List<Integer> values) {
            addCriterion("isOver not in", values, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsoverBetween(Integer value1, Integer value2) {
            addCriterion("isOver between", value1, value2, "isOver");
            return (Criteria) this;
        }

        public Criteria andIsoverNotBetween(Integer value1, Integer value2) {
            addCriterion("isOver not between", value1, value2, "isOver");
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