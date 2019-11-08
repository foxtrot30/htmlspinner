package com.foxtrot30.htmlspinner;

public class HtmlSpinnerModel {
    private String key;
    private String value;

    public String getKey() {
        if (key == null) {
            return "";
        }

        return key.trim();
    }

    public HtmlSpinnerModel setKey(String key) {
        this.key = key.trim();

        return this;
    }

    public String getValue() {
        if (value == null) {
            return "";
        }

        return value.trim();
    }

    public HtmlSpinnerModel setValue(String value) {
        this.value = value.trim();

        return this;
    }
}
