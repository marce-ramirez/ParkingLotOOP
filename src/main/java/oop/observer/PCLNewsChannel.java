package oop.observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PCLNewsChannel implements PropertyChangeListener {

    private String news;

    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("There are news!!!");
        this.setNews((String) evt.getNewValue());
    }

    private void setNews(String news) {
        this.news = news;
    }

    public String getNews() {
        return news;
    }
}

