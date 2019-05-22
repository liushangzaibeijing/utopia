//
///**
// * Created by jiajun.chen on 2018/2/5.
// */
//public enum SettingTypeEnum {
//
//    CUR_HOTEL(1,"当前酒店"),
//    UNKNOWN(-1,"UNKNOWN");
//
//    private int code;
//    private String name;
//
//    SettingTypeEnum(int code, String name){
//        this.code = code;
//        this.name = name;
//    }
//
//    public static SettingTypeEnum fromCode(int code) {
//        for (SettingTypeEnum type : SettingTypeEnum.values()) {
//            if (type.getCode() == code) {
//                return type;
//            }
//        }
//        return SettingTypeEnum.UNKNOWN;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getCode() {
//        return code;
//    }
//
//    public void setCode(int code) {
//        this.code = code;
//    }
//}
