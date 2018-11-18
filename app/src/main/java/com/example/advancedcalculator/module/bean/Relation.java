package com.example.advancedcalculator.module.bean;

import java.util.List;

/**
 * <pre>
 *      @author hurley
 *      date : 2018/11/05
 *      github : https://github.com/HurleyJames
 *      desc : 亲戚关系实体类
 * </pre>
 */
public class Relation {

    /**
     * reason : 查询成功
     * result : {"relation":[{"name":"我","father":"爸爸","mother":"妈妈","bro1":"哥哥","sis1":"姐姐","husband":"丈夫","wife":"妻子","bro2":"弟弟","sis2":"妹妹","son":"儿子","daughter":"女儿"},{"name":"爷爷","father":"太公","mother":"太婆","bro1":"伯公","sis1":"姑婆","husband":"是男是女不重要，是你就好","wife":"奶奶","bro2":"叔伯","sis2":"姑婆","son":"伯父/爸爸/叔叔","daughter":"姑姑"},{"name":"奶奶","father":"外太公","mother":"外太婆","bro1":"舅公","sis1":"姨婆","husband":"爷爷","wife":"是男是女不重要，是你就好","bro2":"舅公","sis2":"姨婆","son":"伯父/爸爸/叔叔","daughter":"姑姑"},{"name":"外公","father":"外太公","mother":"外太婆","bro1":"外伯公","sis1":"姑姥姥","husband":"是男是女不重要，是你就好","wife":"外婆","bro2":"外叔公","sis2":"姑姥姥","son":"舅舅","daughter":"姨妈"},{"name":"外婆","father":"外太公","mother":"外太婆","bro1":"外舅公","sis1":"姑姥姥","husband":"外公","wife":"是男是女不重要，是你就好","bro2":"外舅公","sis2":"姑姥姥","son":"舅舅","daughter":"姨妈"},{"name":"姑姑","father":"爷爷","mother":"奶奶","bro1":"伯父/爸爸/叔叔","sis1":"姑姑","husband":"姑父","wife":"是男是女不重要，是你就好","bro2":"伯父/爸爸/叔叔","sis2":"姑姑","son":"表哥/表弟/你","daughter":"表姐/表妹/你"},{"name":"姑父","father":"姑爷","mother":"姑奶","bro1":"姑父","sis1":"姑妈","husband":"是男是女不重要，是你就好","wife":"姑姑","bro2":"姑父","sis2":"姑妈","son":"表哥/表弟/你","daughter":"表姐/表妹/你"},{"name":"叔叔","father":"爷爷","mother":"奶奶","bro1":"伯父/爸爸/叔叔","sis1":"姑姑","husband":"是男是女不重要，是你就好","wife":"婶婶","bro2":"叔叔","sis2":"姑姑","son":"堂哥/堂弟/你","daughter":"堂姐/堂妹/你"},{"name":"婶婶","father":"爷爷","mother":"奶奶","bro1":"叔叔","sis1":"婶婶","husband":"叔叔","wife":"是男是女不重要，是你就好","bro2":"叔叔","sis2":"婶婶","son":"堂哥/堂弟/你","daughter":"堂姐/堂妹/你"},{"name":"伯父","father":"爷爷","mother":"奶奶","bro1":"伯父","sis1":"姑姑","husband":"是男是女不重要，是你就好","wife":"伯母","bro2":"伯父/爸爸/叔叔","sis2":"姑姑","son":"堂哥/堂弟/你","daughter":"堂姐/堂妹/你"},{"name":"伯母","father":"爷爷","mother":"奶奶","bro1":"伯父","sis1":"姑姑","husband":"伯父","wife":"是男是女不重要，是你就好","bro2":"叔叔","sis2":"姑姑","son":"堂哥/堂弟/你","daughter":"堂姐/堂妹/你"},{"name":"爸爸","father":"爷爷","mother":"奶奶","bro1":"伯父","sis1":"姑姑","husband":"是男是女不重要，是你就好","wife":"妈妈","bro2":"叔叔","sis2":"姑姑","son":"哥哥/弟弟/你","daughter":"姐姐/妹妹/你"},{"name":"妈妈","father":"外公","mother":"外婆","bro1":"大舅舅","sis1":"姨妈","husband":"爸爸","wife":"是男是女不重要，是你就好","bro2":"小舅舅","sis2":"姨妈","son":"哥哥/弟弟/你","daughter":"姐姐/妹妹/你"},{"name":"舅舅","father":"外公","mother":"外婆","bro1":"舅舅","sis1":"姨妈","husband":"是男是女不重要，是你就好","wife":"舅妈","bro2":"舅舅","sis2":"姨妈","son":"表哥/表弟/你","daughter":"表姐/表妹/你"},{"name":"舅妈","father":"外公","mother":"外婆","bro1":"舅舅","sis1":"姨妈","husband":"舅舅","wife":"是男是女不重要，是你就好","bro2":"舅舅","sis2":"姨妈","son":"表哥/表弟/你","daughter":"表姐/表妹/你"},{"name":"姨妈","father":"外公","mother":"外婆","bro1":"舅舅","sis1":"姨妈","husband":"姨夫","wife":"是男是女不重要，是你就好","bro2":"舅舅","sis2":"姨妈","son":"表哥/表弟/你","daughter":"表姐/表妹/你"},{"name":"姨夫","father":"爷爷","mother":"奶奶","bro1":"叔叔","sis1":"姑姑","husband":"是男是女不重要，是你就好","wife":"姨妈","bro2":"叔叔","sis2":"姑姑","son":"表哥/表弟/你","daughter":"表姐/表妹/你"},{"name":"哥哥","father":"爸爸","mother":"妈妈","bro1":"哥哥","sis1":"姐姐/妹妹/你","husband":"是男是女不重要，是你就好","wife":"嫂子","bro2":"弟弟/你","sis2":"姐姐/妹妹/你","son":"侄子","daughter":"侄女"},{"name":"嫂子","father":"叔叔","mother":"婶婶","bro1":"叔叔","sis1":"婶婶","husband":"哥哥","wife":"是男是女不重要，是你就好","bro2":"叔叔","sis2":"婶婶","son":"侄子","daughter":"侄女"},{"name":"弟弟","father":"爸爸","mother":"妈妈","bro1":"哥哥/你","sis1":"姐姐/妹妹/你","husband":"是男是女不重要，是你就好","wife":"弟媳","bro2":"弟弟","sis2":"姐姐/妹妹/你","son":"侄子","daughter":"侄女"},{"name":"弟媳","father":"叔叔","mother":"婶婶","bro1":"关系有点远啦~","sis1":"关系有点远啦~","husband":"弟弟","wife":"是男是女不重要，是你就好","bro2":"关系有点远啦~","sis2":"关系有点远啦~","son":"侄子","daughter":"侄女"},{"name":"妹妹","father":"爸爸","mother":"妈妈","bro1":"哥哥/你/弟弟","sis1":"姐姐/妹妹","husband":"姐夫","wife":"是男是女不重要，是你就好","bro2":"哥哥/你/弟弟","sis2":"姐姐/妹妹","son":"外甥","daughter":"外甥女"},{"name":"姐夫","father":"叔叔","mother":"婶婶","bro1":"关系有点远啦~","sis1":"关系有点远啦~","husband":"是男是女不重要，是你就好","wife":"姐姐","bro2":"关系有点远啦~","sis2":"关系有点远啦~","son":"外甥","daughter":"外甥女"},{"name":"姐姐","father":"爸爸","mother":"妈妈","bro1":"哥哥/你/弟弟","sis1":"姐姐/妹妹","husband":"妹夫","wife":"是男是女不重要，是你就好","bro2":"哥哥/你/弟弟","sis2":"姐姐/妹妹","son":"外甥","daughter":"外甥女"},{"name":"妹夫","father":"叔叔","mother":"婶婶","bro1":"关系有点远啦~","sis1":"关系有点远啦~","husband":"是男是女不重要，是你就好","wife":"妹妹","bro2":"关系有点远啦~","sis2":"关系有点远啦~","son":"外甥","daughter":"外甥女"},{"name":"儿子","father":"我","mother":"我","bro1":"儿子","sis1":"女儿","husband":"是男是女不重要，是你就好","wife":"儿媳妇","bro2":"儿子","sis2":"女儿","son":"孙子","daughter":"孙女"},{"name":"儿媳妇","father":"亲家公","mother":"亲家母","bro1":"关系有点远啦~","sis1":"关系有点远啦~","husband":"儿子","wife":"是男是女不重要，是你就好","bro2":"关系有点远啦~","sis2":"关系有点远啦~","son":"孙子","daughter":"孙女"},{"name":"女儿","father":"我","mother":"我","bro1":"儿子","sis1":"女儿","husband":"女婿","wife":"是男是女不重要，是你就好","bro2":"儿子","sis2":"女儿","son":"外孙","daughter":"外孙女"},{"name":"女婿","father":"亲家公","mother":"亲家母","bro1":"关系有点远啦~","sis1":"关系有点远啦~","husband":"是男是女不重要，是你就好","wife":"女儿","bro2":"关系有点远啦~","sis2":"关系有点远啦~","son":"外孙","daughter":"外孙女"},{"name":"丈夫","father":"公公","mother":"婆婆","bro1":"大伯子","sis1":"大姑子","husband":"是男是女不重要，是你就好","wife":"我","bro2":"小叔子","sis2":"小姑子","son":"儿子","daughter":"女儿"},{"name":"妻子","father":"岳父","mother":"岳母","bro1":"大舅子","sis1":"大姨子","husband":"我","wife":"是男是女不重要，是你就好","bro2":"小舅子","sis2":"小姨子","son":"儿子","daughter":"女儿"},{"name":"孙子","father":"儿子","mother":"儿媳妇","bro1":"孙子","sis1":"孙女","husband":"是男是女不重要，是你就好","wife":"孙媳妇","bro2":"孙子","sis2":"孙女","son":"关系有点远啦~","daughter":"关系有点远啦~"},{"name":"孙女","father":"儿子","mother":"儿媳妇","bro1":"孙子","sis1":"孙女","husband":"孙女婿","wife":"是男是女不重要，是你就好","bro2":"孙子","sis2":"孙女","son":"关系有点远啦~","daughter":"关系有点远啦~"},{"name":"外孙","father":"女婿","mother":"女儿","bro1":"外孙","sis1":"外孙女","husband":"是男是女不重要，是你就好","wife":"孙媳妇","bro2":"外孙","sis2":"外孙女","son":"关系有点远啦~","daughter":"关系有点远啦~"},{"name":"外孙女","father":"女婿","mother":"女儿","bro1":"外孙","sis1":"外孙女","husband":"外孙女婿","wife":"是男是女不重要，是你就好","bro2":"外孙","sis2":"外孙女","son":"关系有点远啦~","daughter":"关系有点远啦~"}]}
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
        private List<RelationBean> relation;

        public List<RelationBean> getRelation() {
            return relation;
        }

        public void setRelation(List<RelationBean> relation) {
            this.relation = relation;
        }

        public static class RelationBean {
            /**
             * name : 我
             * father : 爸爸
             * mother : 妈妈
             * bro1 : 哥哥
             * sis1 : 姐姐
             * husband : 丈夫
             * wife : 妻子
             * bro2 : 弟弟
             * sis2 : 妹妹
             * son : 儿子
             * daughter : 女儿
             */

            private String name;
            private String father;
            private String mother;
            private String bro1;
            private String sis1;
            private String husband;
            private String wife;
            private String bro2;
            private String sis2;
            private String son;
            private String daughter;

            public RelationBean() {

            }

            public RelationBean(String name,
                                String father,
                                String mother,
                                String bro1,
                                String bro2,
                                String sis1,
                                String sis2,
                                String husband,
                                String wife,
                                String son,
                                String daughter) {
                this.name = name;
                this.father = father;
                this.mother = mother;
                this.bro1 = bro1;
                this.bro2 = bro2;
                this.sis1 = sis1;
                this.sis2 = sis2;
                this.husband = husband;
                this.wife = wife;
                this.son = son;
                this.daughter = daughter;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getFather() {
                return father;
            }

            public void setFather(String father) {
                this.father = father;
            }

            public String getMother() {
                return mother;
            }

            public void setMother(String mother) {
                this.mother = mother;
            }

            public String getBro1() {
                return bro1;
            }

            public void setBro1(String bro1) {
                this.bro1 = bro1;
            }

            public String getSis1() {
                return sis1;
            }

            public void setSis1(String sis1) {
                this.sis1 = sis1;
            }

            public String getHusband() {
                return husband;
            }

            public void setHusband(String husband) {
                this.husband = husband;
            }

            public String getWife() {
                return wife;
            }

            public void setWife(String wife) {
                this.wife = wife;
            }

            public String getBro2() {
                return bro2;
            }

            public void setBro2(String bro2) {
                this.bro2 = bro2;
            }

            public String getSis2() {
                return sis2;
            }

            public void setSis2(String sis2) {
                this.sis2 = sis2;
            }

            public String getSon() {
                return son;
            }

            public void setSon(String son) {
                this.son = son;
            }

            public String getDaughter() {
                return daughter;
            }

            public void setDaughter(String daughter) {
                this.daughter = daughter;
            }
        }
    }
}
