package com.shoueb.itworld.common.enums;

/**
 * @Description: 系列类型
 * @Author: yuangui.hu
 * @Date: 2019/1/13 15:26
 */
public enum SeriesTypeEnum {
    ALL("", "全部"),
    PROSE("0", "散文"),
    SERIAL("1", "系列文章"),
    SOLUTION("2", "解决方案"),
    OPENSOURCE("3", "优秀开源"),
    PRACTICE("4", "实践"),
    WORKPLACE_SECRET("5", "职场秘闻"),
    TITLE("6", "标题党"),
    GROWTH_HACKER("7", "增长黑客"),
    WEBSITE_DEV("8", "网站进展"),
    SOLUTION_PRACTICE("9", "解决方案实践"),
    OPENSOURCE_PRACTICE("10", "开源实践");
    private String key;
    private String value;
    /**
     * 合同是否有押金枚举
     * @param key key
     * @param value 值
     */
    SeriesTypeEnum(String key, String value) {
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
        for (SeriesTypeEnum c : SeriesTypeEnum.values()) {
            if (c.getKey().equals(key)) {
                return c.getValue();
            }
        }
        return null;
    }
}
