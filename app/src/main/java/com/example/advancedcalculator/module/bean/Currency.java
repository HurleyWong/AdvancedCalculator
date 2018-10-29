package com.example.advancedcalculator.module.bean;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/27
 * </pre>
 */
public class Currency{
    /**
     * name : 人民币
     * code : CNY
     */

    private String name;
    private String code;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code=code;
    }
}
