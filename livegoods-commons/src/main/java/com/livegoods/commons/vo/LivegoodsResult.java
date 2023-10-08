package com.livegoods.commons.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class LivegoodsResult {
    // 200-成功 500-失败
    private int status;

    // 返回结果
    private Object results;

    // 提示消息
    private String msg;

    // 返回数据
    private Object data;

    // 是否还有更多的数据
    private boolean hasMore;

    // 预定时间
    private Long time;

    public static LivegoodsResult ok(){
        LivegoodsResult livegoodsResult = new LivegoodsResult();
        livegoodsResult.setStatus(200);
        return livegoodsResult;
    }

    public static LivegoodsResult ok(Object data){
        LivegoodsResult livegoodsResult = new LivegoodsResult();
        livegoodsResult.setData(data);
        livegoodsResult.setStatus(200);
        return livegoodsResult;
    }

    public static LivegoodsResult error(){
        LivegoodsResult livegoodsResult = new LivegoodsResult();
        livegoodsResult.setStatus(500);
        return livegoodsResult;
    }

    public static LivegoodsResult error(Object data){
        LivegoodsResult livegoodsResult = new LivegoodsResult();
        livegoodsResult.setStatus(500);
        livegoodsResult.setData(data);
        return livegoodsResult;
    }
}
