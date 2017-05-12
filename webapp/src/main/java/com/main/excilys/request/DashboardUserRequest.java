package com.main.excilys.request;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class DashboardUserRequest {
    @NumberFormat(style = Style.NUMBER)
    private int page;

    @NumberFormat(style = Style.NUMBER)
    private int nbObject;
}
