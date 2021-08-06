package com.example.restaurants.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueueList {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.queue, item);
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Food name " + position, makeDetails(position), "TIME FAKE");
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("name :").append(position);
        for (int i = 0; i < position; i++) {
            builder.append(i);
        }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of name_food.
     */
    public static class DummyItem {
        public final String queue;
        public final String name_food;
        public final String name_customer;
        public final String time;

        public DummyItem(String queue, String name_food, String name_customer, String time) {
            this.queue = queue;
            this.name_food = name_food;
            this.name_customer = name_customer;
            this.time = time;
        }

        @Override
        public String toString() {
            return name_food;
        }
    }
}
