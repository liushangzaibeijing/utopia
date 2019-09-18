package com.xiu.utopia.entity;

import java.util.ArrayList;
import java.util.List;

public class SongExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SongExample() {
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

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2019-09-15
     */
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

        public Criteria andSongIdIsNull() {
            addCriterion("song_id is null");
            return (Criteria) this;
        }

        public Criteria andSongIdIsNotNull() {
            addCriterion("song_id is not null");
            return (Criteria) this;
        }

        public Criteria andSongIdEqualTo(Integer value) {
            addCriterion("song_id =", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdNotEqualTo(Integer value) {
            addCriterion("song_id <>", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdGreaterThan(Integer value) {
            addCriterion("song_id >", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("song_id >=", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdLessThan(Integer value) {
            addCriterion("song_id <", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdLessThanOrEqualTo(Integer value) {
            addCriterion("song_id <=", value, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdIn(List<Integer> values) {
            addCriterion("song_id in", values, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdNotIn(List<Integer> values) {
            addCriterion("song_id not in", values, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdBetween(Integer value1, Integer value2) {
            addCriterion("song_id between", value1, value2, "songId");
            return (Criteria) this;
        }

        public Criteria andSongIdNotBetween(Integer value1, Integer value2) {
            addCriterion("song_id not between", value1, value2, "songId");
            return (Criteria) this;
        }

        public Criteria andSongMidIsNull() {
            addCriterion("song_mid is null");
            return (Criteria) this;
        }

        public Criteria andSongMidIsNotNull() {
            addCriterion("song_mid is not null");
            return (Criteria) this;
        }

        public Criteria andSongMidEqualTo(String value) {
            addCriterion("song_mid =", value, "songMid");
            return (Criteria) this;
        }

        public Criteria andSongMidNotEqualTo(String value) {
            addCriterion("song_mid <>", value, "songMid");
            return (Criteria) this;
        }

        public Criteria andSongMidGreaterThan(String value) {
            addCriterion("song_mid >", value, "songMid");
            return (Criteria) this;
        }

        public Criteria andSongMidGreaterThanOrEqualTo(String value) {
            addCriterion("song_mid >=", value, "songMid");
            return (Criteria) this;
        }

        public Criteria andSongMidLessThan(String value) {
            addCriterion("song_mid <", value, "songMid");
            return (Criteria) this;
        }

        public Criteria andSongMidLessThanOrEqualTo(String value) {
            addCriterion("song_mid <=", value, "songMid");
            return (Criteria) this;
        }

        public Criteria andSongMidLike(String value) {
            addCriterion("song_mid like", value, "songMid");
            return (Criteria) this;
        }

        public Criteria andSongMidNotLike(String value) {
            addCriterion("song_mid not like", value, "songMid");
            return (Criteria) this;
        }

        public Criteria andSongMidIn(List<String> values) {
            addCriterion("song_mid in", values, "songMid");
            return (Criteria) this;
        }

        public Criteria andSongMidNotIn(List<String> values) {
            addCriterion("song_mid not in", values, "songMid");
            return (Criteria) this;
        }

        public Criteria andSongMidBetween(String value1, String value2) {
            addCriterion("song_mid between", value1, value2, "songMid");
            return (Criteria) this;
        }

        public Criteria andSongMidNotBetween(String value1, String value2) {
            addCriterion("song_mid not between", value1, value2, "songMid");
            return (Criteria) this;
        }

        public Criteria andSongNameIsNull() {
            addCriterion("song_name is null");
            return (Criteria) this;
        }

        public Criteria andSongNameIsNotNull() {
            addCriterion("song_name is not null");
            return (Criteria) this;
        }

        public Criteria andSongNameEqualTo(String value) {
            addCriterion("song_name =", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameNotEqualTo(String value) {
            addCriterion("song_name <>", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameGreaterThan(String value) {
            addCriterion("song_name >", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameGreaterThanOrEqualTo(String value) {
            addCriterion("song_name >=", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameLessThan(String value) {
            addCriterion("song_name <", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameLessThanOrEqualTo(String value) {
            addCriterion("song_name <=", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameLike(String value) {
            addCriterion("song_name like", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameNotLike(String value) {
            addCriterion("song_name not like", value, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameIn(List<String> values) {
            addCriterion("song_name in", values, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameNotIn(List<String> values) {
            addCriterion("song_name not in", values, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameBetween(String value1, String value2) {
            addCriterion("song_name between", value1, value2, "songName");
            return (Criteria) this;
        }

        public Criteria andSongNameNotBetween(String value1, String value2) {
            addCriterion("song_name not between", value1, value2, "songName");
            return (Criteria) this;
        }

        public Criteria andSongTypeIsNull() {
            addCriterion("song_type is null");
            return (Criteria) this;
        }

        public Criteria andSongTypeIsNotNull() {
            addCriterion("song_type is not null");
            return (Criteria) this;
        }

        public Criteria andSongTypeEqualTo(String value) {
            addCriterion("song_type =", value, "songType");
            return (Criteria) this;
        }

        public Criteria andSongTypeNotEqualTo(String value) {
            addCriterion("song_type <>", value, "songType");
            return (Criteria) this;
        }

        public Criteria andSongTypeGreaterThan(String value) {
            addCriterion("song_type >", value, "songType");
            return (Criteria) this;
        }

        public Criteria andSongTypeGreaterThanOrEqualTo(String value) {
            addCriterion("song_type >=", value, "songType");
            return (Criteria) this;
        }

        public Criteria andSongTypeLessThan(String value) {
            addCriterion("song_type <", value, "songType");
            return (Criteria) this;
        }

        public Criteria andSongTypeLessThanOrEqualTo(String value) {
            addCriterion("song_type <=", value, "songType");
            return (Criteria) this;
        }

        public Criteria andSongTypeLike(String value) {
            addCriterion("song_type like", value, "songType");
            return (Criteria) this;
        }

        public Criteria andSongTypeNotLike(String value) {
            addCriterion("song_type not like", value, "songType");
            return (Criteria) this;
        }

        public Criteria andSongTypeIn(List<String> values) {
            addCriterion("song_type in", values, "songType");
            return (Criteria) this;
        }

        public Criteria andSongTypeNotIn(List<String> values) {
            addCriterion("song_type not in", values, "songType");
            return (Criteria) this;
        }

        public Criteria andSongTypeBetween(String value1, String value2) {
            addCriterion("song_type between", value1, value2, "songType");
            return (Criteria) this;
        }

        public Criteria andSongTypeNotBetween(String value1, String value2) {
            addCriterion("song_type not between", value1, value2, "songType");
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

        public Criteria andAlbumIdEqualTo(String value) {
            addCriterion("album_id =", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotEqualTo(String value) {
            addCriterion("album_id <>", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdGreaterThan(String value) {
            addCriterion("album_id >", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdGreaterThanOrEqualTo(String value) {
            addCriterion("album_id >=", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLessThan(String value) {
            addCriterion("album_id <", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLessThanOrEqualTo(String value) {
            addCriterion("album_id <=", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdLike(String value) {
            addCriterion("album_id like", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotLike(String value) {
            addCriterion("album_id not like", value, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdIn(List<String> values) {
            addCriterion("album_id in", values, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotIn(List<String> values) {
            addCriterion("album_id not in", values, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdBetween(String value1, String value2) {
            addCriterion("album_id between", value1, value2, "albumId");
            return (Criteria) this;
        }

        public Criteria andAlbumIdNotBetween(String value1, String value2) {
            addCriterion("album_id not between", value1, value2, "albumId");
            return (Criteria) this;
        }

        public Criteria andSingerMidIsNull() {
            addCriterion("singer_mid is null");
            return (Criteria) this;
        }

        public Criteria andSingerMidIsNotNull() {
            addCriterion("singer_mid is not null");
            return (Criteria) this;
        }

        public Criteria andSingerMidEqualTo(String value) {
            addCriterion("singer_mid =", value, "singerMid");
            return (Criteria) this;
        }

        public Criteria andSingerMidNotEqualTo(String value) {
            addCriterion("singer_mid <>", value, "singerMid");
            return (Criteria) this;
        }

        public Criteria andSingerMidGreaterThan(String value) {
            addCriterion("singer_mid >", value, "singerMid");
            return (Criteria) this;
        }

        public Criteria andSingerMidGreaterThanOrEqualTo(String value) {
            addCriterion("singer_mid >=", value, "singerMid");
            return (Criteria) this;
        }

        public Criteria andSingerMidLessThan(String value) {
            addCriterion("singer_mid <", value, "singerMid");
            return (Criteria) this;
        }

        public Criteria andSingerMidLessThanOrEqualTo(String value) {
            addCriterion("singer_mid <=", value, "singerMid");
            return (Criteria) this;
        }

        public Criteria andSingerMidLike(String value) {
            addCriterion("singer_mid like", value, "singerMid");
            return (Criteria) this;
        }

        public Criteria andSingerMidNotLike(String value) {
            addCriterion("singer_mid not like", value, "singerMid");
            return (Criteria) this;
        }

        public Criteria andSingerMidIn(List<String> values) {
            addCriterion("singer_mid in", values, "singerMid");
            return (Criteria) this;
        }

        public Criteria andSingerMidNotIn(List<String> values) {
            addCriterion("singer_mid not in", values, "singerMid");
            return (Criteria) this;
        }

        public Criteria andSingerMidBetween(String value1, String value2) {
            addCriterion("singer_mid between", value1, value2, "singerMid");
            return (Criteria) this;
        }

        public Criteria andSingerMidNotBetween(String value1, String value2) {
            addCriterion("singer_mid not between", value1, value2, "singerMid");
            return (Criteria) this;
        }

        public Criteria andTimePublicIsNull() {
            addCriterion("time_public is null");
            return (Criteria) this;
        }

        public Criteria andTimePublicIsNotNull() {
            addCriterion("time_public is not null");
            return (Criteria) this;
        }

        public Criteria andTimePublicEqualTo(String value) {
            addCriterion("time_public =", value, "timePublic");
            return (Criteria) this;
        }

        public Criteria andTimePublicNotEqualTo(String value) {
            addCriterion("time_public <>", value, "timePublic");
            return (Criteria) this;
        }

        public Criteria andTimePublicGreaterThan(String value) {
            addCriterion("time_public >", value, "timePublic");
            return (Criteria) this;
        }

        public Criteria andTimePublicGreaterThanOrEqualTo(String value) {
            addCriterion("time_public >=", value, "timePublic");
            return (Criteria) this;
        }

        public Criteria andTimePublicLessThan(String value) {
            addCriterion("time_public <", value, "timePublic");
            return (Criteria) this;
        }

        public Criteria andTimePublicLessThanOrEqualTo(String value) {
            addCriterion("time_public <=", value, "timePublic");
            return (Criteria) this;
        }

        public Criteria andTimePublicLike(String value) {
            addCriterion("time_public like", value, "timePublic");
            return (Criteria) this;
        }

        public Criteria andTimePublicNotLike(String value) {
            addCriterion("time_public not like", value, "timePublic");
            return (Criteria) this;
        }

        public Criteria andTimePublicIn(List<String> values) {
            addCriterion("time_public in", values, "timePublic");
            return (Criteria) this;
        }

        public Criteria andTimePublicNotIn(List<String> values) {
            addCriterion("time_public not in", values, "timePublic");
            return (Criteria) this;
        }

        public Criteria andTimePublicBetween(String value1, String value2) {
            addCriterion("time_public between", value1, value2, "timePublic");
            return (Criteria) this;
        }

        public Criteria andTimePublicNotBetween(String value1, String value2) {
            addCriterion("time_public not between", value1, value2, "timePublic");
            return (Criteria) this;
        }

        public Criteria andSongAttrIsNull() {
            addCriterion("song_attr is null");
            return (Criteria) this;
        }

        public Criteria andSongAttrIsNotNull() {
            addCriterion("song_attr is not null");
            return (Criteria) this;
        }

        public Criteria andSongAttrEqualTo(String value) {
            addCriterion("song_attr =", value, "songAttr");
            return (Criteria) this;
        }

        public Criteria andSongAttrNotEqualTo(String value) {
            addCriterion("song_attr <>", value, "songAttr");
            return (Criteria) this;
        }

        public Criteria andSongAttrGreaterThan(String value) {
            addCriterion("song_attr >", value, "songAttr");
            return (Criteria) this;
        }

        public Criteria andSongAttrGreaterThanOrEqualTo(String value) {
            addCriterion("song_attr >=", value, "songAttr");
            return (Criteria) this;
        }

        public Criteria andSongAttrLessThan(String value) {
            addCriterion("song_attr <", value, "songAttr");
            return (Criteria) this;
        }

        public Criteria andSongAttrLessThanOrEqualTo(String value) {
            addCriterion("song_attr <=", value, "songAttr");
            return (Criteria) this;
        }

        public Criteria andSongAttrLike(String value) {
            addCriterion("song_attr like", value, "songAttr");
            return (Criteria) this;
        }

        public Criteria andSongAttrNotLike(String value) {
            addCriterion("song_attr not like", value, "songAttr");
            return (Criteria) this;
        }

        public Criteria andSongAttrIn(List<String> values) {
            addCriterion("song_attr in", values, "songAttr");
            return (Criteria) this;
        }

        public Criteria andSongAttrNotIn(List<String> values) {
            addCriterion("song_attr not in", values, "songAttr");
            return (Criteria) this;
        }

        public Criteria andSongAttrBetween(String value1, String value2) {
            addCriterion("song_attr between", value1, value2, "songAttr");
            return (Criteria) this;
        }

        public Criteria andSongAttrNotBetween(String value1, String value2) {
            addCriterion("song_attr not between", value1, value2, "songAttr");
            return (Criteria) this;
        }

        public Criteria andDurationIsNull() {
            addCriterion("duration is null");
            return (Criteria) this;
        }

        public Criteria andDurationIsNotNull() {
            addCriterion("duration is not null");
            return (Criteria) this;
        }

        public Criteria andDurationEqualTo(String value) {
            addCriterion("duration =", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotEqualTo(String value) {
            addCriterion("duration <>", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThan(String value) {
            addCriterion("duration >", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationGreaterThanOrEqualTo(String value) {
            addCriterion("duration >=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThan(String value) {
            addCriterion("duration <", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLessThanOrEqualTo(String value) {
            addCriterion("duration <=", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationLike(String value) {
            addCriterion("duration like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotLike(String value) {
            addCriterion("duration not like", value, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationIn(List<String> values) {
            addCriterion("duration in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotIn(List<String> values) {
            addCriterion("duration not in", values, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationBetween(String value1, String value2) {
            addCriterion("duration between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andDurationNotBetween(String value1, String value2) {
            addCriterion("duration not between", value1, value2, "duration");
            return (Criteria) this;
        }

        public Criteria andLyricIsNull() {
            addCriterion("lyric is null");
            return (Criteria) this;
        }

        public Criteria andLyricIsNotNull() {
            addCriterion("lyric is not null");
            return (Criteria) this;
        }

        public Criteria andLyricEqualTo(String value) {
            addCriterion("lyric =", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotEqualTo(String value) {
            addCriterion("lyric <>", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricGreaterThan(String value) {
            addCriterion("lyric >", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricGreaterThanOrEqualTo(String value) {
            addCriterion("lyric >=", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricLessThan(String value) {
            addCriterion("lyric <", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricLessThanOrEqualTo(String value) {
            addCriterion("lyric <=", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricLike(String value) {
            addCriterion("lyric like", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotLike(String value) {
            addCriterion("lyric not like", value, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricIn(List<String> values) {
            addCriterion("lyric in", values, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotIn(List<String> values) {
            addCriterion("lyric not in", values, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricBetween(String value1, String value2) {
            addCriterion("lyric between", value1, value2, "lyric");
            return (Criteria) this;
        }

        public Criteria andLyricNotBetween(String value1, String value2) {
            addCriterion("lyric not between", value1, value2, "lyric");
            return (Criteria) this;
        }

        public Criteria andSongUrlIsNull() {
            addCriterion("song_url is null");
            return (Criteria) this;
        }

        public Criteria andSongUrlIsNotNull() {
            addCriterion("song_url is not null");
            return (Criteria) this;
        }

        public Criteria andSongUrlEqualTo(String value) {
            addCriterion("song_url =", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlNotEqualTo(String value) {
            addCriterion("song_url <>", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlGreaterThan(String value) {
            addCriterion("song_url >", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlGreaterThanOrEqualTo(String value) {
            addCriterion("song_url >=", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlLessThan(String value) {
            addCriterion("song_url <", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlLessThanOrEqualTo(String value) {
            addCriterion("song_url <=", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlLike(String value) {
            addCriterion("song_url like", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlNotLike(String value) {
            addCriterion("song_url not like", value, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlIn(List<String> values) {
            addCriterion("song_url in", values, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlNotIn(List<String> values) {
            addCriterion("song_url not in", values, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlBetween(String value1, String value2) {
            addCriterion("song_url between", value1, value2, "songUrl");
            return (Criteria) this;
        }

        public Criteria andSongUrlNotBetween(String value1, String value2) {
            addCriterion("song_url not between", value1, value2, "songUrl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 
     * 
     * @author wcyong
     * 
     * @date 2019-09-15
     */
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