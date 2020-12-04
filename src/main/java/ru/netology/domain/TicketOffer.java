package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TicketOffer implements Comparable<TicketOffer> {
    private int id;
    private int price;
    private String from;
    private String to;
    private double timeMin;


    @Override
    public int compareTo(TicketOffer comparePrice) {
        return price - comparePrice.price;
    }

    @Override
    public String toString() {
        return "TicketOffer{" +
                "id=" + id +
                ", price=" + price +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", timeMin=" + timeMin +
                '}';
    }
}


