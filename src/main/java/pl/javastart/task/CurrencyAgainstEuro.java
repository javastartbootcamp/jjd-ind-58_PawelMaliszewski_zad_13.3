package pl.javastart.task;

import java.math.BigDecimal;

public class CurrencyAgainstEuro {
    private String currency;
    private BigDecimal conversationRate;

    public CurrencyAgainstEuro(String currency, BigDecimal conversationRate) {
        this.currency = currency;
        this.conversationRate = conversationRate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getConversationRate() {
        return conversationRate;
    }

    public void setConversationRate(BigDecimal conversationRate) {
        this.conversationRate = conversationRate;
    }
}
