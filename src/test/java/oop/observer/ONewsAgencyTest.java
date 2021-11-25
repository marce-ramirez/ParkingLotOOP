package oop.observer;

import org.junit.Test;

public class ONewsAgencyTest {

    @Test
    public void itShouldNotifyNewsAvailable() {
        PCLNewsAgency observable = new PCLNewsAgency();
        PCLNewsChannel observer = new PCLNewsChannel();

        observable.addPropertyChangeListener(observer);
        observable.setNews("p1");
        observable.setNews("p2");
    }
}