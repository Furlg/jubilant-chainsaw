/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoop.Trade.CommTrade;

import hoop.Mappers.TradeFieldMapper;
import hoop.message.ErrorCodeAndMessage;
import hoop.message.GlobalException;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author shaji
 */
@Service
public class TradeFieldServiceImp implements TradeFielService {

    @Resource
    TradeFieldMapper tradeFieldMapper;
    
    @Override
    public TradeFieldEntity queryTradeFieldByInterfaceAndScene(TradeFieldEntity tfe) {
      TradeFieldEntity tradeFieldEntity =  tradeFieldMapper.queryTradeFieldByInterfaceAndScene(tfe);
        if(tradeFieldEntity == null){
            throw new GlobalException(ErrorCodeAndMessage.QUERY_NULL);
        }
        return  tradeFieldEntity;
    }
    
}
