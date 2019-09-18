package com.xiu.utopia.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-09-15
 */
public class Song {
    /**
     * 主键
     */
    private Integer id;

    /**
     * qq音乐id
     */
    private Integer songId;

    /**
     * qq音乐mid
     */
    private String songMid;

    /**
     * 歌曲名称
     */
    private String songName;

    /**
     * 歌曲类型
     */
    private String songType;

    /**
     * 所属专辑
     */
    private String albumId;

    /**
     * 所属歌手
     */
    private String singerMid;

    /**
     * 发行时间
     */
    private String timePublic;

    /**
     * 歌曲属性
     */
    private String songAttr;

    /**
     * 歌曲时长
     */
    private String duration;

    /**
     * 歌词信息
     */
    private String lyric;

    /**
     * 歌曲路径
     */
    private String songUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public String getSongMid() {
        return songMid;
    }

    public void setSongMid(String songMid) {
        this.songMid = songMid == null ? null : songMid.trim();
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName == null ? null : songName.trim();
    }

    public String getSongType() {
        return songType;
    }

    public void setSongType(String songType) {
        this.songType = songType == null ? null : songType.trim();
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId == null ? null : albumId.trim();
    }

    public String getSingerMid() {
        return singerMid;
    }

    public void setSingerMid(String singerMid) {
        this.singerMid = singerMid == null ? null : singerMid.trim();
    }

    public String getTimePublic() {
        return timePublic;
    }

    public void setTimePublic(String timePublic) {
        this.timePublic = timePublic == null ? null : timePublic.trim();
    }

    public String getSongAttr() {
        return songAttr;
    }

    public void setSongAttr(String songAttr) {
        this.songAttr = songAttr == null ? null : songAttr.trim();
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric == null ? null : lyric.trim();
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl == null ? null : songUrl.trim();
    }
}