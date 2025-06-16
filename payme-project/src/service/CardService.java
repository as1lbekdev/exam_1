package service;

import model.Card;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CardService implements BaseService<Card> {
    private ArrayList<Card> cards;

    @Override
    public Card add(Card card) {
        cards.add(card);
        return card;
    }

    @Override
    public List<Card> getAll() {
        return cards;
    }

    @Override
    public Card update(UUID id, Card card) {
        Card found = getById(id);
        if (found != null) {
            found.setOwner(card.getOwner());
            found.setCardNum(card.getCardNum());
        }
        return found;
    }

    @Override
    public void remove(UUID id) {
        Card found = (Card) getCardsByUserId(id);
        if (found != null) {
            found.setActive(false);
        }
    }

    @Override
    public Card getById(UUID id) {
        for (Card c : cards) {
            if (c.isActive() && id.equals(c.getId())) {
                return c;
            }
        }
        return null;
    }

    public List<Card> getCardsByUserId(UUID id) {
        List<Card> userCards = new ArrayList<>();
        for (Card c : cards) {
            if (c.isActive() && c.getOwner().getId().equals(id)) {
                userCards.add(c);
            }
        }
        return userCards;
    }
}
