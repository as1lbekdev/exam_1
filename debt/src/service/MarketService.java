package service;

import model.Market;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MarketService {
    private List<Market> markets;

    public MarketService() {
        this.markets = new ArrayList<>();
    }

    public Market addMarket(Market market) {
        market.setId(UUID.randomUUID());
        markets.add(market);
        return market;
    }

    public Market getMarketById(UUID marketId) {
        for (Market market : markets) {
            if (market.getId().equals(marketId)) {
                return market;
            }
        }
        return null; // topilmasa
    }
}
