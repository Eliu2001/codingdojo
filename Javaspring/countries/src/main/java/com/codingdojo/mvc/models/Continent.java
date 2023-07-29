package com.codingdojo.mvc.models;

public enum Continent {
        EUROPE("Europe"),
        ASIA("Asia"),
        NORTH_AMERICA("North America"),
        AFRICA("Africa"),
        OCEANIA("Oceania"),
        ANTARCTICA("Antarctica"),
        SOUTH_AMERICA("South America");
        private final String displayName;

        Continent(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
