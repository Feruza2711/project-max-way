package uz.pdp.projectmaxway.utils;


import uz.pdp.projectmaxway.controller.AuthController;

public interface AppConstants {

    String[] OPEN_PAGES = {
            AuthController.BASE_PATH + "/**",
    };

    String AUTH_HEADER = "Authorization";
    String AUTH_TYPE_BASIC = "Basic ";
    String AUTH_TYPE_BEARER = "Bearer ";

    String BASE_PATH = "/api";
}
