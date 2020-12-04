package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);
    private TicketOffer item1 = new TicketOffer(1, 31435, "VKO", "LAX", 2570);
    private TicketOffer item2 = new TicketOffer(2, 31601, "VKO", "LAX", 2535);
    private TicketOffer item3 = new TicketOffer(3, 31600, "VKO", "LAX", 2565);
    private TicketOffer item4 = new TicketOffer(4, 32249, "DME", "LAX", 2495);
    private TicketOffer item5 = new TicketOffer(5, 32417, "DME", "LAX", 1455);
    private TicketOffer item6 = new TicketOffer(6, 33771, "DME", "ZI", 2205);

    @BeforeEach
    public void setUp() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);
    }

    @Test
    void shouldFindAndSortByPrice() {
        TicketOffer[] expected = new TicketOffer[]{item1, item3, item2};
        TicketOffer[] actual = manager.findAll("VKO", "LAX");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
        System.out.print(Arrays.toString(actual));
    }

    @Test
    void shouldNotFindAnything() {
        TicketOffer[] expected = new TicketOffer[0];
        TicketOffer[] actual = manager.findAll("ZI", "LAX");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
        System.out.print(Arrays.toString(actual));
    }

    @Test
    void shouldNotFindAny() {
        TicketOffer[] expected = new TicketOffer[0];
        TicketOffer[] actual = manager.findAll("VKO", "ZI");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
        System.out.print(Arrays.toString(actual));
    }

    @Test
    void shouldFindButNotSort() {
        TicketOffer[] expected = new TicketOffer[]{item1, item2, item3};
        TicketOffer[] actual = manager.findAll("VKO", "LAX");
        assertArrayEquals(expected, actual);
        System.out.print(Arrays.toString(actual));
    }

    @Test
    void shouldFindOne() {
        TicketOffer[] expected = new TicketOffer[]{item6};
        TicketOffer[] actual = manager.findAll("DME", "ZI");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
        System.out.print(Arrays.toString(actual));
    }
}
