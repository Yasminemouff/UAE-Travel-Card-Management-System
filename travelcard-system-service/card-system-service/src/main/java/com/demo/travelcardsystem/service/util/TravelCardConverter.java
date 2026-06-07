package com.demo.travelcardsystem.service.util;

import com.demo.travelcardsystem.entity.TravelCard;
import com.demo.travelcardsystem.model.response.TravelCardResponse;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class TravelCardConverter {

    private Function<TravelCard, TravelCardResponse> travelCard2TravelCardResponseConverter = travelCard -> {
        TravelCardResponse travelCardResponse = new TravelCardResponse();
        travelCardResponse.setCardNumber(travelCard.getCardNumber());
        travelCardResponse.setBalance(travelCard.getBalance());
        if(null != travelCard.getCurrentJourney()) {
            travelCardResponse.setTransportType(travelCard.getCurrentJourney().getTransportType());
        }
        travelCardResponse.setInTransit(travelCard.getCurrentJourney() != null);
        return travelCardResponse;
    };

    //Accessor so other classes can still use it
    public Function<TravelCard, TravelCardResponse> getConverter() {
        return travelCard2TravelCardResponseConverter;
    }
}