package mironouz.com.models;

import java.util.Objects;

public class AccountNumber {
    private int high;
    private int low;

    public AccountNumber(int high, int low) {
        this.high = high;
        this.low = low;
    }

    @Override
    public String toString() {
        return "Account Number: " + high + "-" + low;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountNumber that = (AccountNumber) o;
        return high == that.high &&
                low == that.low;
    }

    @Override
    public int hashCode() {
        return Objects.hash(high, low);
    }
}
