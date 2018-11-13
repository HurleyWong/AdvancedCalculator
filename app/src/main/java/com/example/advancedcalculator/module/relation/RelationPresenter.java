package com.example.advancedcalculator.module.relation;

import android.content.Context;
import android.util.Log;

import com.example.advancedcalculator.base.BasePresenter;
import com.example.advancedcalculator.module.bean.Coin;
import com.example.advancedcalculator.module.bean.Relation;
import com.example.advancedcalculator.util.FileUtils;
import com.example.advancedcalculator.util.GsonUtils;

import java.util.List;

/**
 * <pre>
 *      author : Hurley
 *      e-mail : 1401682479@qq.com
 *      time   : 2018/10/23
 * </pre>
 */
public class RelationPresenter extends BasePresenter implements RelationContract.Presenter {
    private static final String TAG = "RelationPresenter";

    private RelationContract.View mView;

    public static RelationPresenter newInstance() {
        return new RelationPresenter();
    }

    //从本地读取数据
    public List getRelationByJSON(final List<Relation.ResultBean.RelationBean> relationList, Context context){
        String jsonContext = FileUtils.readFileFromAssets("relation.json", context);
        final Relation relation = GsonUtils.getInstance().getObject(jsonContext, Relation.class);
        for (int i = 0; i < relation.getResult().getRelation().size(); i++) {
            relationList.add(new Relation.ResultBean.RelationBean(relation.getResult().getRelation().get(i).getName(),
                    relation.getResult().getRelation().get(i).getFather(),
                    relation.getResult().getRelation().get(i).getMother(),
                    relation.getResult().getRelation().get(i).getBro1(),
                    relation.getResult().getRelation().get(i).getBro2(),
                    relation.getResult().getRelation().get(i).getSis1(),
                    relation.getResult().getRelation().get(i).getSis2(),
                    relation.getResult().getRelation().get(i).getHusband(),
                    relation.getResult().getRelation().get(i).getWife(),
                    relation.getResult().getRelation().get(i).getSon(),
                    relation.getResult().getRelation().get(i).getDaughter()));
            //Log.e(TAG, relation.getResult().getRelation().get(i).getName());
        }
        return relationList;
    }


    public String getRelationship(StringBuffer buffer, List<Relation.ResultBean.RelationBean> relationList) {
        //去除所有"的"字符
        String call = buffer.toString().replace("的", "");
        Log.e(TAG, call.substring(1,3));
        //中间称呼
        String temp = "";
        //下一个关系
        String nextRelation;
        for (int i = 0; i < relationList.size(); i++) {
            Log.d(TAG, "list长度：" + relationList.size());
            Log.d(TAG, "buffer长度：" + buffer.length());
            Log.d(TAG, "去掉'的'后的长度：" + call.length());
            //第一个关系是"我的XX"，肯定称呼为"XX"，所以直接判断哪些等于"XX"
            if (relationList.get(i).getName().equals(call.substring(1, 3))) {
                Log.d(TAG, "i的位置：" + i);
                for (int j = 3; j < call.length(); j = j + 2) {
                    nextRelation = call.substring(j, j + 2);
                    Log.e(TAG, "下一个关系：" + nextRelation);

                    if (nextRelation.equals("爸爸")) {
                        temp = relationList.get(i).getFather();
                        Log.e(TAG, "temp改变：" + temp);
                        //切换成"爸爸"的序号
                        //i = 1;
                    }
                    if (nextRelation.equals("妈妈")) {
                        temp = relationList.get(i).getMother();
                        Log.e(TAG, "temp改变：" + temp);
                        //切换成"妈妈"的序号
                        //i = 2;
                    }
                    if (nextRelation.equals("哥哥")) {
                        temp = relationList.get(i).getBro1();
                        Log.e(TAG, "temp改变：" + temp);
                        //切换成"哥哥"的序号
                        //i = 3;
                    }
                    if (nextRelation.equals("弟弟")) {
                        temp = relationList.get(i).getBro2();
                        Log.e(TAG, "temp改变：" + temp);
                        //切换成"弟弟"的序号
                        //i = 4;
                    }
                    if (nextRelation.equals("姐姐")) {
                        temp = relationList.get(i).getSis1();
                        Log.e(TAG, "temp改变：" + temp);
                        //切换成"姐姐"的序号
                        //i = 5;
                    }
                    if (nextRelation.equals("妹妹")) {
                        temp = relationList.get(i).getSis2();
                        Log.e(TAG, "temp改变：" + temp);
                        //切换成"妹妹"的序号
                        //i = 6;
                    }
                    if (nextRelation.equals("丈夫")) {
                        temp = relationList.get(i).getHusband();
                        Log.e(TAG, "temp改变：" + temp);
                        //切换成"丈夫"的序号
                        //i = 7;
                    }
                    if (nextRelation.equals("妻子")) {
                        temp = relationList.get(i).getWife();
                        Log.e(TAG, "temp改变：" + temp);
                        //切换成"妻子"的序号
                        //i = 8;
                    }
                    if (nextRelation.equals("儿子")) {
                        temp = relationList.get(i).getSon();
                        Log.e(TAG, "temp改变：" + temp);
                        //切换成"儿子"的序号
                        //i = 9;
                    }
                    if (nextRelation.equals("女儿")) {
                        temp = relationList.get(i).getDaughter();
                        Log.e(TAG, "temp改变：" + temp);
                        //切换成"女儿"的序号
                        //i = 10;
                    }

                    Log.d(TAG, "temp：" + temp);
                    //获取temp的位置
                    for (int k = 0; k < relationList.size(); k++) {
                        if (relationList.get(k).getName().equals(temp)) {
                            i = k;
                            Log.e(TAG, "temp的位置："  + i);
                        }
                    }
                }
                break;
            }
        }
        call = temp;
        Log.e(TAG, "最终称呼：" + call);
        return call;
    }
}
