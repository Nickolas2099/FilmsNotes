package com.example.filmsNotes.domain.constant;

public class RegExp {

//    public static final String showTitle = "^[a-zA-Z. _()!?+=-*]{3,50}$";
    public static final String showTitle = "^[a-zA-Z0-9А-Яа-я.,:; _?!+=/'\\\\\"*(){}\\[\\]\\-]{3,50}$";

    public static final String genreName = "^[a-zA-Z -]{3,30}$";
    public static final String showTitlePart = "^[a-zA-Z0-9А-Яа-я.,:; _?!+=/'\\\\\"*(){}\\[\\]\\-]{3,50}$";


}
