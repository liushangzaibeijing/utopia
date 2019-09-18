package com.xiu.utopia.entity;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-09-06
 */
public class Singer {
    /**
     * 主键
     */
    private Integer id;

    /**
     * qq音乐的主键
     */
    private Integer signerId;

    /**
     * qq音乐唯一标识
     */
    private String signerMid;

    /**
     * 歌手全名
     */
    private String fullName;

    /**
     * 英文名
     */
    private String englishName;

    /**
     * 歌手简称（别名 多个）
     */
    private String shortName;

    /**
     * 国籍
     */
    private String contractId;

    /**
     * 出生地
     */
    private String birthPlace;

    /**
     * 出生日期
     */
    private String birthTime;

    /**
     * 职业
     */
    private String profession;

    /**
     * 歌手性别
     */
    private Integer sex;

    /**
     * 组合成员 （歌手id 多个以，分隔）
     */
    private String members;

    /**
     * 歌手流派
     */
    private String school;

    /**
     * 歌手首字母
     */
    private String firstLetter;

    /**
     * 简介
     */
    private String descption;

    /**
     * 民族
     */
    private String nation;

    /**
     * 经纪公司
     */
    private String broker;

    /**
     * 出道时间
     */
    private String stratTime;

    /**
     * 歌手图片
     */
    private String pic;

    /**
     * 歌手图片 本地存储
     */
    private String picLocal;

    /**
     * 身高
     */
    private String heigth;

    /**
     * 体重
     */
    private String weigth;

    /**
     * 血型
     */
    private String bloodType;

    /**
     * 毕业院校
     */
    private String graduateSchool;

    /**
     * 星座
     */
    private String constellation;

    /**
     * 语言
     */
    private String language;

    /**
     * 粉丝名称
     */
    private String fansName;

    /**
     * 应援色
     */
    private String idolColor;

    /**
     * 特长
     */
    private String speciality;

    /**
     * 籍贯
     */
    private String nativePlace;

    /**
     * 爱好
     */
    private String hobby;


    /**
     * 0未完成 1完成下载
     */
    private Integer isOver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSignerId() {
        return signerId;
    }

    public void setSignerId(Integer signerId) {
        this.signerId = signerId;
    }

    public String getSignerMid() {
        return signerMid;
    }

    public void setSignerMid(String signerMid) {
        this.signerMid = signerMid == null ? null : signerMid.trim();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName == null ? null : englishName.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId == null ? null : contractId.trim();
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace == null ? null : birthPlace.trim();
    }

    public String getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime == null ? null : birthTime.trim();
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession == null ? null : profession.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members == null ? null : members.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(String firstLetter) {
        this.firstLetter = firstLetter == null ? null : firstLetter.trim();
    }

    public String getDescption() {
        return descption;
    }

    public void setDescption(String descption) {
        this.descption = descption == null ? null : descption.trim();
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker == null ? null : broker.trim();
    }

    public String getStratTime() {
        return stratTime;
    }

    public void setStratTime(String stratTime) {
        this.stratTime = stratTime == null ? null : stratTime.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getPicLocal() {
        return picLocal;
    }

    public void setPicLocal(String picLocal) {
        this.picLocal = picLocal == null ? null : picLocal.trim();
    }

    public String getHeigth() {
        return heigth;
    }

    public void setHeigth(String heigth) {
        this.heigth = heigth == null ? null : heigth.trim();
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth == null ? null : weigth.trim();
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType == null ? null : bloodType.trim();
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool == null ? null : graduateSchool.trim();
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation == null ? null : constellation.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getFansName() {
        return fansName;
    }

    public void setFansName(String fansName) {
        this.fansName = fansName == null ? null : fansName.trim();
    }

    public String getIdolColor() {
        return idolColor;
    }

    public void setIdolColor(String idolColor) {
        this.idolColor = idolColor == null ? null : idolColor.trim();
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality == null ? null : speciality.trim();
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    public Integer getIsOver() {
        return isOver;
    }

    public void setIsOver(Integer isOver) {
        this.isOver = isOver;
    }
}