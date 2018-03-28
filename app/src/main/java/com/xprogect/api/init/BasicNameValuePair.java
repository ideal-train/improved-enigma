package com.xprogect.api.init;

import android.support.annotation.NonNull;

public class BasicNameValuePair implements NameValuePair {
    private String name;
    private String value;

    BasicNameValuePair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof BasicNameValuePair && compareTo((BasicNameValuePair) o) == 0;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(@NonNull NameValuePair another) {
        return getName().compareTo(another.getName());
    }

    @Override
    public String toString() {
        return "[" +
                "name:'" + name + '\'' +
                ", value:'" + value + '\'' +
                ']';
    }

}
