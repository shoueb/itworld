package com.shoueb.itworld.common.enums;

/**
 * @Description: 显示位置
 * @Author: yuangui.hu
 * @Date: 2019/1/13 15:26
 */
public enum  BlogShowPositionEnum {
    DEFUALT("0", "默认"),
    CANDIDATE("1", "候选"),
    ESSENCE("2", "精华");
    private String key;
    private String value;

    BlogShowPositionEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
    /**
     * 通过key 获取value
     * @param key  key
     * @return
     */
    public static String getName(Integer key) {
        if( null == key){
            return  null;
        }
        for (BlogShowPositionEnum c : BlogShowPositionEnum.values()) {
            if (c.getKey().equals(key)) {
                return c.getValue();
            }
        }
        return null;
    }
}
