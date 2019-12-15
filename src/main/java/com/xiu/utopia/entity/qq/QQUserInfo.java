package com.xiu.utopia.entity.qq;

/**
 * qq用户信息
 */
public class QQUserInfo {
    /**
     * 返回码
     */
    private int ret;
    /**
     * 如果ret<0，会有相应的错误信息提示
     */
    private String msg;
    /**
     * 是否丢失
     */
    private int is_lost;
    /**
     * 用户在QQ空间的昵称
      */
    private String nickname;
    /**
     * 性别
     */
    private String gender;
    /**
     * 性别类型
     */
    private Integer gender_type;
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 出生年
     */
    private String year;
    /**
     * 星座
     */
    private String constellation;
    /**
     * qq空间头像 30 X 30
     */
    private String figureurl;
    /**
     * qq空间头像 50 X 50
     */
    private String figureurl_1;
    /**
     * qq空间头像 100 X 100
     */
    private String figureurl_2;
    /**
     * qq登录大小为40×40像素的QQ头像URL。 一定有
     */
    private String figureurl_qq_1;
    /**
     * 	qq登录大小为100×100像素的QQ头像
     */
    private String figureurl_qq_2;
    /**
     * qq登录头像 140 X 140
     */
    private String figureurl_qq;

    private String figureurl_type;
    /**
     * 是否黄钻  0 否 1是
     */
    private String is_yellow_vip;
    /**
     * vip 是否vip 0 否 1是
     */
    private String vip;
    /**
     * 黄钻等级
     */
    private String yellow_vip_level;
    /**
     * 等级
     */
    private String level;
    /**
     * 是否黄钻年卡vip
     */
    private String is_yellow_year_vip;
    public void setRet(int ret) {
        this.ret = ret;
    }
    public int getRet() {
        return ret;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }

    public void setIs_lost(int is_lost) {
        this.is_lost = is_lost;
    }
    public int getIs_lost() {
        return is_lost;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getNickname() {
        return nickname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getGender() {
        return gender;
    }

    public Integer getGender_type() {
        return gender_type;
    }

    public void setGender_type(Integer gender_type) {
        this.gender_type = gender_type;
    }

    public void setProvince(String province) {
        this.province = province;
    }
    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String getYear() {
        return year;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }
    public String getConstellation() {
        return constellation;
    }

    public void setFigureurl(String figureurl) {
        this.figureurl = figureurl;
    }
    public String getFigureurl() {
        return figureurl;
    }

    public void setFigureurl_1(String figureurl_1) {
        this.figureurl_1 = figureurl_1;
    }
    public String getFigureurl_1() {
        return figureurl_1;
    }

    public void setFigureurl_2(String figureurl_2) {
        this.figureurl_2 = figureurl_2;
    }
    public String getFigureurl_2() {
        return figureurl_2;
    }

    public void setFigureurl_qq_1(String figureurl_qq_1) {
        this.figureurl_qq_1 = figureurl_qq_1;
    }
    public String getFigureurl_qq_1() {
        return figureurl_qq_1;
    }

    public void setFigureurl_qq_2(String figureurl_qq_2) {
        this.figureurl_qq_2 = figureurl_qq_2;
    }
    public String getFigureurl_qq_2() {
        return figureurl_qq_2;
    }

    public void setFigureurl_qq(String figureurl_qq) {
        this.figureurl_qq = figureurl_qq;
    }
    public String getFigureurl_qq() {
        return figureurl_qq;
    }

    public void setFigureurl_type(String figureurl_type) {
        this.figureurl_type = figureurl_type;
    }
    public String getFigureurl_type() {
        return figureurl_type;
    }

    public void setIs_yellow_vip(String is_yellow_vip) {
        this.is_yellow_vip = is_yellow_vip;
    }
    public String getIs_yellow_vip() {
        return is_yellow_vip;
    }

    public void setVip(String vip) {
        this.vip = vip;
    }
    public String getVip() {
        return vip;
    }

    public void setYellow_vip_level(String yellow_vip_level) {
        this.yellow_vip_level = yellow_vip_level;
    }
    public String getYellow_vip_level() {
        return yellow_vip_level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
    public String getLevel() {
        return level;
    }

    public void setIs_yellow_year_vip(String is_yellow_year_vip) {
        this.is_yellow_year_vip = is_yellow_year_vip;
    }
    public String getIs_yellow_year_vip() {
        return is_yellow_year_vip;
    }
}
