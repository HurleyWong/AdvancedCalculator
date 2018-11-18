package com.example.advancedcalculator.module.bean;

import java.util.List;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/11/05
 *      github : https://github.com/HurleyJames
 *      desc : 汇率实体类
 * </pre>
 */
public class Currency {
    
    /**
     * reason : 查询成功!
     * result : [{"currencyF":"CNY","currencyF_Name":"人民币","currencyT":"JPY","currencyT_Name":"日元","currencyFD":"1","exchange":"16.3467","result":"16.3467","updateTime":"2018-11-05 22:59:41"},{"currencyF":"JPY","currencyF_Name":"日元","currencyT":"CNY","currencyT_Name":"人民币","currencyFD":"1","exchange":"0.0612","result":"0.0612","updateTime":"2018-11-05 22:59:41"}]
     * error_code : 0
     */
    
    private String reason;
    private int error_code;
    private List<ResultBean> result;
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public int getError_code() {
        return error_code;
    }
    
    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
    
    public List<ResultBean> getResult() {
        return result;
    }
    
    public void setResult(List<ResultBean> result) {
        this.result = result;
    }
    
    public static class ResultBean {
        /**
         * currencyF : CNY
         * currencyF_Name : 人民币
         * currencyT : JPY
         * currencyT_Name : 日元
         * currencyFD : 1
         * exchange : 16.3467
         * result : 16.3467
         * updateTime : 2018-11-05 22:59:41
         */
        
        public ResultBean(String exchange) {
            this.exchange = exchange;
        }

        /**
         * 转换前的货币缩写
         */
        private String currencyF;
        /**
         * 转换前的货币名称
         */
        private String currencyF_Name;
        /**
         * 转换后的货币缩写
         */
        private String currencyT;
        /**
         * 转换后的货币名称
         */
        private String currencyT_Name;
        /**
         * 金额
         */
        private String currencyFD;
        /**
         * 汇率
         */
        private String exchange;
        /**
         * 转换后的结果
         */
        private String result;
        /**
         * 获取汇率日期
         */
        private String updateTime;
        
        public String getCurrencyF() {
            return currencyF;
        }
        
        public void setCurrencyF(String currencyF) {
            this.currencyF = currencyF;
        }
        
        public String getCurrencyF_Name() {
            return currencyF_Name;
        }
        
        public void setCurrencyF_Name(String currencyF_Name) {
            this.currencyF_Name = currencyF_Name;
        }
        
        public String getCurrencyT() {
            return currencyT;
        }
        
        public void setCurrencyT(String currencyT) {
            this.currencyT = currencyT;
        }
        
        public String getCurrencyT_Name() {
            return currencyT_Name;
        }
        
        public void setCurrencyT_Name(String currencyT_Name) {
            this.currencyT_Name = currencyT_Name;
        }
        
        public String getCurrencyFD() {
            return currencyFD;
        }
        
        public void setCurrencyFD(String currencyFD) {
            this.currencyFD = currencyFD;
        }
        
        public String getExchange() {
            return exchange;
        }
        
        public void setExchange(String exchange) {
            this.exchange = exchange;
        }
        
        public String getResult() {
            return result;
        }
        
        public void setResult(String result) {
            this.result = result;
        }
        
        public String getUpdateTime() {
            return updateTime;
        }
        
        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
