package com.xiu.followdouban.commonrpc.model;

import java.util.ArrayList;
import java.util.List;

public class MovieExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MovieExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNull() {
            addCriterion("director is null");
            return (Criteria) this;
        }

        public Criteria andDirectorIsNotNull() {
            addCriterion("director is not null");
            return (Criteria) this;
        }

        public Criteria andDirectorEqualTo(String value) {
            addCriterion("director =", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotEqualTo(String value) {
            addCriterion("director <>", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThan(String value) {
            addCriterion("director >", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorGreaterThanOrEqualTo(String value) {
            addCriterion("director >=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThan(String value) {
            addCriterion("director <", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLessThanOrEqualTo(String value) {
            addCriterion("director <=", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorLike(String value) {
            addCriterion("director like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotLike(String value) {
            addCriterion("director not like", value, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorIn(List<String> values) {
            addCriterion("director in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotIn(List<String> values) {
            addCriterion("director not in", values, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorBetween(String value1, String value2) {
            addCriterion("director between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andDirectorNotBetween(String value1, String value2) {
            addCriterion("director not between", value1, value2, "director");
            return (Criteria) this;
        }

        public Criteria andScreenWriterIsNull() {
            addCriterion("screen_writer is null");
            return (Criteria) this;
        }

        public Criteria andScreenWriterIsNotNull() {
            addCriterion("screen_writer is not null");
            return (Criteria) this;
        }

        public Criteria andScreenWriterEqualTo(String value) {
            addCriterion("screen_writer =", value, "screenWriter");
            return (Criteria) this;
        }

        public Criteria andScreenWriterNotEqualTo(String value) {
            addCriterion("screen_writer <>", value, "screenWriter");
            return (Criteria) this;
        }

        public Criteria andScreenWriterGreaterThan(String value) {
            addCriterion("screen_writer >", value, "screenWriter");
            return (Criteria) this;
        }

        public Criteria andScreenWriterGreaterThanOrEqualTo(String value) {
            addCriterion("screen_writer >=", value, "screenWriter");
            return (Criteria) this;
        }

        public Criteria andScreenWriterLessThan(String value) {
            addCriterion("screen_writer <", value, "screenWriter");
            return (Criteria) this;
        }

        public Criteria andScreenWriterLessThanOrEqualTo(String value) {
            addCriterion("screen_writer <=", value, "screenWriter");
            return (Criteria) this;
        }

        public Criteria andScreenWriterLike(String value) {
            addCriterion("screen_writer like", value, "screenWriter");
            return (Criteria) this;
        }

        public Criteria andScreenWriterNotLike(String value) {
            addCriterion("screen_writer not like", value, "screenWriter");
            return (Criteria) this;
        }

        public Criteria andScreenWriterIn(List<String> values) {
            addCriterion("screen_writer in", values, "screenWriter");
            return (Criteria) this;
        }

        public Criteria andScreenWriterNotIn(List<String> values) {
            addCriterion("screen_writer not in", values, "screenWriter");
            return (Criteria) this;
        }

        public Criteria andScreenWriterBetween(String value1, String value2) {
            addCriterion("screen_writer between", value1, value2, "screenWriter");
            return (Criteria) this;
        }

        public Criteria andScreenWriterNotBetween(String value1, String value2) {
            addCriterion("screen_writer not between", value1, value2, "screenWriter");
            return (Criteria) this;
        }

        public Criteria andLeadActorIsNull() {
            addCriterion("lead_actor is null");
            return (Criteria) this;
        }

        public Criteria andLeadActorIsNotNull() {
            addCriterion("lead_actor is not null");
            return (Criteria) this;
        }

        public Criteria andLeadActorEqualTo(String value) {
            addCriterion("lead_actor =", value, "leadActor");
            return (Criteria) this;
        }

        public Criteria andLeadActorNotEqualTo(String value) {
            addCriterion("lead_actor <>", value, "leadActor");
            return (Criteria) this;
        }

        public Criteria andLeadActorGreaterThan(String value) {
            addCriterion("lead_actor >", value, "leadActor");
            return (Criteria) this;
        }

        public Criteria andLeadActorGreaterThanOrEqualTo(String value) {
            addCriterion("lead_actor >=", value, "leadActor");
            return (Criteria) this;
        }

        public Criteria andLeadActorLessThan(String value) {
            addCriterion("lead_actor <", value, "leadActor");
            return (Criteria) this;
        }

        public Criteria andLeadActorLessThanOrEqualTo(String value) {
            addCriterion("lead_actor <=", value, "leadActor");
            return (Criteria) this;
        }

        public Criteria andLeadActorLike(String value) {
            addCriterion("lead_actor like", value, "leadActor");
            return (Criteria) this;
        }

        public Criteria andLeadActorNotLike(String value) {
            addCriterion("lead_actor not like", value, "leadActor");
            return (Criteria) this;
        }

        public Criteria andLeadActorIn(List<String> values) {
            addCriterion("lead_actor in", values, "leadActor");
            return (Criteria) this;
        }

        public Criteria andLeadActorNotIn(List<String> values) {
            addCriterion("lead_actor not in", values, "leadActor");
            return (Criteria) this;
        }

        public Criteria andLeadActorBetween(String value1, String value2) {
            addCriterion("lead_actor between", value1, value2, "leadActor");
            return (Criteria) this;
        }

        public Criteria andLeadActorNotBetween(String value1, String value2) {
            addCriterion("lead_actor not between", value1, value2, "leadActor");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaIsNull() {
            addCriterion("filmmaking_area is null");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaIsNotNull() {
            addCriterion("filmmaking_area is not null");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaEqualTo(String value) {
            addCriterion("filmmaking_area =", value, "filmmakingArea");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaNotEqualTo(String value) {
            addCriterion("filmmaking_area <>", value, "filmmakingArea");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaGreaterThan(String value) {
            addCriterion("filmmaking_area >", value, "filmmakingArea");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaGreaterThanOrEqualTo(String value) {
            addCriterion("filmmaking_area >=", value, "filmmakingArea");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaLessThan(String value) {
            addCriterion("filmmaking_area <", value, "filmmakingArea");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaLessThanOrEqualTo(String value) {
            addCriterion("filmmaking_area <=", value, "filmmakingArea");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaLike(String value) {
            addCriterion("filmmaking_area like", value, "filmmakingArea");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaNotLike(String value) {
            addCriterion("filmmaking_area not like", value, "filmmakingArea");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaIn(List<String> values) {
            addCriterion("filmmaking_area in", values, "filmmakingArea");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaNotIn(List<String> values) {
            addCriterion("filmmaking_area not in", values, "filmmakingArea");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaBetween(String value1, String value2) {
            addCriterion("filmmaking_area between", value1, value2, "filmmakingArea");
            return (Criteria) this;
        }

        public Criteria andFilmmakingAreaNotBetween(String value1, String value2) {
            addCriterion("filmmaking_area not between", value1, value2, "filmmakingArea");
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

        public Criteria andReleaseTimeIsNull() {
            addCriterion("release_time is null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIsNotNull() {
            addCriterion("release_time is not null");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeEqualTo(String value) {
            addCriterion("release_time =", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotEqualTo(String value) {
            addCriterion("release_time <>", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThan(String value) {
            addCriterion("release_time >", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeGreaterThanOrEqualTo(String value) {
            addCriterion("release_time >=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThan(String value) {
            addCriterion("release_time <", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLessThanOrEqualTo(String value) {
            addCriterion("release_time <=", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeLike(String value) {
            addCriterion("release_time like", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotLike(String value) {
            addCriterion("release_time not like", value, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeIn(List<String> values) {
            addCriterion("release_time in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotIn(List<String> values) {
            addCriterion("release_time not in", values, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeBetween(String value1, String value2) {
            addCriterion("release_time between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andReleaseTimeNotBetween(String value1, String value2) {
            addCriterion("release_time not between", value1, value2, "releaseTime");
            return (Criteria) this;
        }

        public Criteria andMovieLengthIsNull() {
            addCriterion("movie_length is null");
            return (Criteria) this;
        }

        public Criteria andMovieLengthIsNotNull() {
            addCriterion("movie_length is not null");
            return (Criteria) this;
        }

        public Criteria andMovieLengthEqualTo(String value) {
            addCriterion("movie_length =", value, "movieLength");
            return (Criteria) this;
        }

        public Criteria andMovieLengthNotEqualTo(String value) {
            addCriterion("movie_length <>", value, "movieLength");
            return (Criteria) this;
        }

        public Criteria andMovieLengthGreaterThan(String value) {
            addCriterion("movie_length >", value, "movieLength");
            return (Criteria) this;
        }

        public Criteria andMovieLengthGreaterThanOrEqualTo(String value) {
            addCriterion("movie_length >=", value, "movieLength");
            return (Criteria) this;
        }

        public Criteria andMovieLengthLessThan(String value) {
            addCriterion("movie_length <", value, "movieLength");
            return (Criteria) this;
        }

        public Criteria andMovieLengthLessThanOrEqualTo(String value) {
            addCriterion("movie_length <=", value, "movieLength");
            return (Criteria) this;
        }

        public Criteria andMovieLengthLike(String value) {
            addCriterion("movie_length like", value, "movieLength");
            return (Criteria) this;
        }

        public Criteria andMovieLengthNotLike(String value) {
            addCriterion("movie_length not like", value, "movieLength");
            return (Criteria) this;
        }

        public Criteria andMovieLengthIn(List<String> values) {
            addCriterion("movie_length in", values, "movieLength");
            return (Criteria) this;
        }

        public Criteria andMovieLengthNotIn(List<String> values) {
            addCriterion("movie_length not in", values, "movieLength");
            return (Criteria) this;
        }

        public Criteria andMovieLengthBetween(String value1, String value2) {
            addCriterion("movie_length between", value1, value2, "movieLength");
            return (Criteria) this;
        }

        public Criteria andMovieLengthNotBetween(String value1, String value2) {
            addCriterion("movie_length not between", value1, value2, "movieLength");
            return (Criteria) this;
        }

        public Criteria andAliasIsNull() {
            addCriterion("alias is null");
            return (Criteria) this;
        }

        public Criteria andAliasIsNotNull() {
            addCriterion("alias is not null");
            return (Criteria) this;
        }

        public Criteria andAliasEqualTo(String value) {
            addCriterion("alias =", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotEqualTo(String value) {
            addCriterion("alias <>", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThan(String value) {
            addCriterion("alias >", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasGreaterThanOrEqualTo(String value) {
            addCriterion("alias >=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThan(String value) {
            addCriterion("alias <", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLessThanOrEqualTo(String value) {
            addCriterion("alias <=", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasLike(String value) {
            addCriterion("alias like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotLike(String value) {
            addCriterion("alias not like", value, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasIn(List<String> values) {
            addCriterion("alias in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotIn(List<String> values) {
            addCriterion("alias not in", values, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasBetween(String value1, String value2) {
            addCriterion("alias between", value1, value2, "alias");
            return (Criteria) this;
        }

        public Criteria andAliasNotBetween(String value1, String value2) {
            addCriterion("alias not between", value1, value2, "alias");
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

        public Criteria andScoreEqualTo(Float value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(Float value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(Float value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(Float value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(Float value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(Float value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<Float> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<Float> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(Float value1, Float value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(Float value1, Float value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumberIsNull() {
            addCriterion("evaluate_number is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumberIsNotNull() {
            addCriterion("evaluate_number is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumberEqualTo(Integer value) {
            addCriterion("evaluate_number =", value, "evaluateNumber");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumberNotEqualTo(Integer value) {
            addCriterion("evaluate_number <>", value, "evaluateNumber");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumberGreaterThan(Integer value) {
            addCriterion("evaluate_number >", value, "evaluateNumber");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_number >=", value, "evaluateNumber");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumberLessThan(Integer value) {
            addCriterion("evaluate_number <", value, "evaluateNumber");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumberLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_number <=", value, "evaluateNumber");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumberIn(List<Integer> values) {
            addCriterion("evaluate_number in", values, "evaluateNumber");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumberNotIn(List<Integer> values) {
            addCriterion("evaluate_number not in", values, "evaluateNumber");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumberBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_number between", value1, value2, "evaluateNumber");
            return (Criteria) this;
        }

        public Criteria andEvaluateNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_number not between", value1, value2, "evaluateNumber");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andLinkIsNull() {
            addCriterion("link is null");
            return (Criteria) this;
        }

        public Criteria andLinkIsNotNull() {
            addCriterion("link is not null");
            return (Criteria) this;
        }

        public Criteria andLinkEqualTo(String value) {
            addCriterion("link =", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotEqualTo(String value) {
            addCriterion("link <>", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThan(String value) {
            addCriterion("link >", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkGreaterThanOrEqualTo(String value) {
            addCriterion("link >=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThan(String value) {
            addCriterion("link <", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLessThanOrEqualTo(String value) {
            addCriterion("link <=", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkLike(String value) {
            addCriterion("link like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotLike(String value) {
            addCriterion("link not like", value, "link");
            return (Criteria) this;
        }

        public Criteria andLinkIn(List<String> values) {
            addCriterion("link in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotIn(List<String> values) {
            addCriterion("link not in", values, "link");
            return (Criteria) this;
        }

        public Criteria andLinkBetween(String value1, String value2) {
            addCriterion("link between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andLinkNotBetween(String value1, String value2) {
            addCriterion("link not between", value1, value2, "link");
            return (Criteria) this;
        }

        public Criteria andSetNumberIsNull() {
            addCriterion("set_number is null");
            return (Criteria) this;
        }

        public Criteria andSetNumberIsNotNull() {
            addCriterion("set_number is not null");
            return (Criteria) this;
        }

        public Criteria andSetNumberEqualTo(Integer value) {
            addCriterion("set_number =", value, "setNumber");
            return (Criteria) this;
        }

        public Criteria andSetNumberNotEqualTo(Integer value) {
            addCriterion("set_number <>", value, "setNumber");
            return (Criteria) this;
        }

        public Criteria andSetNumberGreaterThan(Integer value) {
            addCriterion("set_number >", value, "setNumber");
            return (Criteria) this;
        }

        public Criteria andSetNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("set_number >=", value, "setNumber");
            return (Criteria) this;
        }

        public Criteria andSetNumberLessThan(Integer value) {
            addCriterion("set_number <", value, "setNumber");
            return (Criteria) this;
        }

        public Criteria andSetNumberLessThanOrEqualTo(Integer value) {
            addCriterion("set_number <=", value, "setNumber");
            return (Criteria) this;
        }

        public Criteria andSetNumberIn(List<Integer> values) {
            addCriterion("set_number in", values, "setNumber");
            return (Criteria) this;
        }

        public Criteria andSetNumberNotIn(List<Integer> values) {
            addCriterion("set_number not in", values, "setNumber");
            return (Criteria) this;
        }

        public Criteria andSetNumberBetween(Integer value1, Integer value2) {
            addCriterion("set_number between", value1, value2, "setNumber");
            return (Criteria) this;
        }

        public Criteria andSetNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("set_number not between", value1, value2, "setNumber");
            return (Criteria) this;
        }

        public Criteria andQuaternaryNumberIsNull() {
            addCriterion("quaternary_number is null");
            return (Criteria) this;
        }

        public Criteria andQuaternaryNumberIsNotNull() {
            addCriterion("quaternary_number is not null");
            return (Criteria) this;
        }

        public Criteria andQuaternaryNumberEqualTo(Integer value) {
            addCriterion("quaternary_number =", value, "quaternaryNumber");
            return (Criteria) this;
        }

        public Criteria andQuaternaryNumberNotEqualTo(Integer value) {
            addCriterion("quaternary_number <>", value, "quaternaryNumber");
            return (Criteria) this;
        }

        public Criteria andQuaternaryNumberGreaterThan(Integer value) {
            addCriterion("quaternary_number >", value, "quaternaryNumber");
            return (Criteria) this;
        }

        public Criteria andQuaternaryNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("quaternary_number >=", value, "quaternaryNumber");
            return (Criteria) this;
        }

        public Criteria andQuaternaryNumberLessThan(Integer value) {
            addCriterion("quaternary_number <", value, "quaternaryNumber");
            return (Criteria) this;
        }

        public Criteria andQuaternaryNumberLessThanOrEqualTo(Integer value) {
            addCriterion("quaternary_number <=", value, "quaternaryNumber");
            return (Criteria) this;
        }

        public Criteria andQuaternaryNumberIn(List<Integer> values) {
            addCriterion("quaternary_number in", values, "quaternaryNumber");
            return (Criteria) this;
        }

        public Criteria andQuaternaryNumberNotIn(List<Integer> values) {
            addCriterion("quaternary_number not in", values, "quaternaryNumber");
            return (Criteria) this;
        }

        public Criteria andQuaternaryNumberBetween(Integer value1, Integer value2) {
            addCriterion("quaternary_number between", value1, value2, "quaternaryNumber");
            return (Criteria) this;
        }

        public Criteria andQuaternaryNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("quaternary_number not between", value1, value2, "quaternaryNumber");
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