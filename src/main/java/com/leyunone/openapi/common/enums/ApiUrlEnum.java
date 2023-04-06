package com.leyunone.openapi.common.enums;

/**
 * @author LeYunone
 * @email 365627310@qq.com
 * @date 2023-04-06
 */
public enum ApiUrlEnum {
    /**
     * @see com.leyunone.openapi.service.ApiService#baiduEmploy
     */
    BAIDU_WEB_EMPLOY("http://data.zz.baidu.com/urls","百度站长 api收录")
    ;


    private String url;

    private String desc;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ApiUrlEnum(String url, String desc) {
        this.url = url;
        this.desc = desc;
    }
}
