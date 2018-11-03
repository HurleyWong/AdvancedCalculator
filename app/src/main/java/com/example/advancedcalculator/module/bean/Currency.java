package com.example.advancedcalculator.module.bean;

import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/27
 * </pre>
 */
public class Currency {
    
    /**
     * reason : 查询成功
     * result : {"list":[{"name":"人民币","code":"CNY"},{"name":"美元","code":"USD"},{"name":"日元","code":"JPY"},{"name":"欧元","code":"EUR"},{"name":"英镑","code":"GBP"},{"name":"韩元","code":"KER"},{"name":"港币","code":"HKD"},{"name":"澳大利亚元","code":"AUD"},{"name":"加拿大元","code":"CAD"},{"name":"阿尔及利亚第纳尔","code":"DZD"},{"name":"阿根廷比索","code":"ARS"},{"name":"爱尔兰镑","code":"IEP"},{"name":"埃及镑","code":"EGP"},{"name":"阿联酋迪拉姆","code":"AED"},{"name":"阿曼里亚尔","code":"OMR"},{"name":"奥地利先令","code":"ATS"},{"name":"澳门元","code":"MOP"},{"name":"百慕大元","code":"BMD"},{"name":"巴基斯坦卢比","code":"PKR"},{"name":"巴拉圭瓜拉尼","code":"PYG"},{"name":"巴林第纳尔","code":"BHD"},{"name":"巴拿马巴尔博亚","code":"PAB"},{"name":"保加利亚列弗","code":"BGN"},{"name":"巴西雷亚尔","code":"BRL"},{"name":"比利时法郎","code":"BEF"},{"name":"冰岛克朗","code":"ISK"},{"name":"博茨瓦纳普拉","code":"BWP"},{"name":"波兰兹罗提","code":"PLN"},{"name":"玻利维亚诺","code":"BOB"},{"name":"丹麦克朗","code":"DKK"},{"name":"德国马克","code":"DEM"},{"name":"法国法郎","code":"FRF"},{"name":"菲律宾比索","code":"PHP"},{"name":"芬兰马克","code":"FIM"},{"name":"哥伦比亚比索","code":"COP"},{"name":"古巴比索","code":"CUP"},{"name":"哈萨克坚戈","code":"KZT"},{"name":"荷兰盾","code":"NLG"},{"name":"加纳塞地","code":"GHC"},{"name":"捷克克朗","code":"CZK"},{"name":"津巴布韦元","code":"ZWD"},{"name":"卡塔尔里亚尔","code":"QAR"},{"name":"克罗地亚库纳","code":"HRK"},{"name":"肯尼亚先令","code":"KES"},{"name":"科威特第纳尔","code":"KWD"},{"name":"老挝基普","code":"LAK"},{"name":"拉脱维亚拉图","code":"LVL"},{"name":"黎巴嫩镑","code":"LBP"},{"name":"林吉特","code":"MYR"},{"name":"立陶宛立特","code":"LTL"},{"name":"卢布","code":"RUB"},{"name":"罗马尼亚新列伊","code":"RON"},{"name":"毛里求斯卢比","code":"MUR"},{"name":"蒙古图格里克","code":"MNT"},{"name":"孟加拉塔卡","code":"BDT"},{"name":"缅甸缅元","code":"BUK"},{"name":"秘鲁新索尔","code":"PEN"},{"name":"摩洛哥迪拉姆","code":"MAD"},{"name":"墨西哥比索","code":"MXN"},{"name":"南非兰特","code":"ZAR"},{"name":"挪威克朗","code":"NOK"},{"name":"葡萄牙埃斯库多","code":"PTE"},{"name":"瑞典克朗","code":"SEK"},{"name":"瑞士法郎","code":"CHF"},{"name":"沙特里亚尔","code":"SAR"},{"name":"斯里兰卡卢比","code":"LKR"},{"name":"索马里先令","code":"SOS"},{"name":"泰国铢","code":"THB"},{"name":"坦桑尼亚先令","code":"TZS"},{"name":"土耳其新里拉","code":"TRY"},{"name":"突尼斯第纳尔","code":"TND"},{"name":"危地马拉格查尔","code":"GTQ"},{"name":"委内瑞拉玻利瓦尔","code":"VEB"},{"name":"乌拉圭新比索","code":"UYU"},{"name":"西班牙比塞塔","code":"ESP"},{"name":"希腊德拉克马","code":"GRD"},{"name":"新加坡元","code":"SGD"},{"name":"新台币","code":"TWD"},{"name":"新西兰元","code":"NZD"},{"name":"匈牙利福林","code":"HUF"},{"name":"牙买加元","code":"JMD"},{"name":"义大利里拉","code":"ITL"},{"name":"印度卢比","code":"INR"},{"name":"印尼盾","code":"IDR"},{"name":"以色列谢克尔","code":"ILS"},{"name":"约旦第纳尔","code":"JOD"},{"name":"越南盾","code":"VND"},{"name":"智利比索","code":"CLP"}]}
     * error_code : 0
     */
    
    private String reason;
    private ResultBean result;
    private int error_code;
    
    public String getReason() {
        return reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    
    public ResultBean getResult() {
        return result;
    }
    
    public void setResult(ResultBean result) {
        this.result = result;
    }
    
    public int getError_code() {
        return error_code;
    }
    
    public void setError_code(int error_code) {
        this.error_code = error_code;
    }
    
    public static class ResultBean {
        private List<ListBean> list;
        
        public List<ListBean> getList() {
            return list;
        }
        
        public void setList(List<ListBean> list) {
            this.list = list;
        }
        
        public static class ListBean {
            /**
             * name : 人民币
             * code : CNY
             */
            
            private String name;
            private String code;
            
            public ListBean() {
            
            }
            
            public ListBean(String name, String code) {
                this.name = name;
                this.code = code;
            }
            
            public String getName() {
                return name;
            }
            
            public void setName(String name) {
                this.name = name;
            }
            
            public String getCode() {
                return code;
            }
            
            public void setCode(String code) {
                this.code = code;
            }
        }
    }
}
