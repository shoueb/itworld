package com.shoueb.itworld.common.enums;

/**
 * @Description: 编辑推荐 1是0否
 * @Author: yuangui.hu
 * @Date: 2019/1/13 15:26
 */
public enum BlogEditorRecommendEnum {
    NO("0", "否"),
    YES("1", "是");



    private String key;
    private String value;

    /**
     * 合同是否有押金枚举
     * @param key key
     * @param value 值
     */
    BlogEditorRecommendEnum(String key, String value) {
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
        for (BlogEditorRecommendEnum c : BlogEditorRecommendEnum.values()) {
            if (c.getKey().equals(key)) {
                return c.getValue();
            }
        }
        return null;
    }
}
