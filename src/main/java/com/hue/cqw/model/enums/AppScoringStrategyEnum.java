package com.hue.cqw.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum AppScoringStrategyEnum {
    REVIEWING("待审核", 0),
    PASS("通过", 1),
    REJECT("拒绝", 2);


    private final String text;

    private final int value;

    AppScoringStrategyEnum(String text, int value) {

        this.text = text;
        this.value = value;
    }

    /**
     * 根据value获取枚举值
     * @return
     */
    public static AppScoringStrategyEnum getEnumByValue(Integer value){
        if(ObjectUtils.isEmpty(value)){
            return null;
        }
        for(AppScoringStrategyEnum anEnum : AppScoringStrategyEnum.values()){
            if(anEnum.value == value){
                return anEnum;
            }
        }
        return null;
    }

    /**
     * 获取值的列表  给前端用的
     * @return
     */
    public static List<Integer> getValues(){
        return Arrays.stream(values())//拿到所有的枚举常量
                .map(item -> item.value)//将枚举值变成对应的数字
                .collect(Collectors.toList());//把这些数字收集成一个集合
    }


    public String getText() {return text;}

    public int getValue() {return value;}
}
