/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoop.Trade.CommTrade;

import jdk.internal.org.objectweb.asm.util.CheckFieldAdapter;
import lombok.Data;

/**
 *
 * @author shaji
 * @date 2021-12-13 20:04
 * @description ib_upm_trade_field表,对配置的交易接口实现类进行字段校验
 */
@Data
public class TradeFieldEntity {
    
    /**
     * 接口码
     */
   public String interfaceImpCode;
    
    
    /**
     * 字段类型
     */
    public Object fieldType;
    
    /**
     * 是否必输
     */
    public Object isRequire;
    
    /**
     * 需要检查的字段
     */
    public String checkField;
    
    /**
     * 需要检查的正则表达式
     */
    public String regularExp;
    
    /**
     * 备注信息
     */
    public String remark;
}
