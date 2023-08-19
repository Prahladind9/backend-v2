package edu.prahlad.java.concepts;

import java.util.Objects;

public class EqualsConcept {

    protected static class MoneyWithEquals{
        private final int money;
        private final String currencyCode;

        public MoneyWithEquals(int money, String currencyCode) {
            this.money = money;
            this.currencyCode = currencyCode;
        }

        @Override
        public String toString() {
            return "MoneyWithoutEquals{" +
                    "money=" + money +
                    ", currencyCode='" + currencyCode + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MoneyWithEquals that = (MoneyWithEquals) o;
            return money == that.money && Objects.equals(currencyCode, that.currencyCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(money, currencyCode);
        }
    }

    protected static class MoneyWithoutEquals {
        private final int money;
        private final String currencyCode;

        public MoneyWithoutEquals(int money, String currencyCode) {
            this.money = money;
            this.currencyCode = currencyCode;
        }

        @Override
        public String toString() {
            return "MoneyWithoutEquals{" +
                    "money=" + money +
                    ", currencyCode='" + currencyCode + '\'' +
                    '}';
        }
    }
}
