package model;

public class Card extends BaseModel {
    //private UUID userId;
    private User owner;
    private String cardNum;
    private String cvv;

    public Card(String owner, String cardNum, String cvv) {

        this.cardNum = cardNum;
        this.cvv = cvv;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString() {
        return "Card{" +
                  "owner=" + owner +
                  ", cardNum='" + cardNum + '\'' +
                  ", cvv='" + cvv + '\'' +
                  '}';
    }
}
