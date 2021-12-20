/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoop.Mappers;

import hoop.Trade.CommTrade.TradeFieldEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 *
 * @author shaji
 */
@Mapper
public interface TradeFieldMapper {
     /**
     * 根据接口码和场景码查询表ib_upm_trade_field
     * @param tfe
     * @return 
     */
    TradeFieldEntity queryTradeFieldByInterfaceAndScene(TradeFieldEntity tfe);
}
