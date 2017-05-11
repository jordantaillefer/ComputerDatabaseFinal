package com.main.excilys.repository;

public enum FieldSort {
    NAME("name"), INTRODUCED("introduced"), DISCONTINUED("discontinued"), COMPANY_NAME(
            "company.name");
    private final String text;
    private static final String NAME_STR         = "name";
    private static final String INTRODUCED_STR   = "introduced";
    private static final String DISCONTINUED_STR = "discontinued";
    private static final String COMPANY_STR      = "co.name";

    /**
     * The constructor.
     * @param text the text representing the field in the database
     */
    FieldSort(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public static FieldSort getFieldSort(String sort) {
        if (sort != null) {
            switch (sort) {
            case NAME_STR:
                return FieldSort.NAME;
            case INTRODUCED_STR:
                return FieldSort.INTRODUCED;
            case DISCONTINUED_STR:
                return FieldSort.DISCONTINUED;
            case COMPANY_STR:
                return FieldSort.COMPANY_NAME;
            default:
                return FieldSort.NAME;
            }
        } else {
            return FieldSort.NAME;
        }
    }
}
