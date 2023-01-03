package com.petstore.constants;

/**
 * Created by Jay
 */
public class EndPoints {

    /**
     * This is Endpoints of users
     */
    public static final String GET_USER_BY_ID = "/user/{userID}";
    public static final String CREATE_USER = "/user";
    public static final String UPDATE_USER_BY_ID = "/user/{userID}";
    public static final String DELETE_USER_BY_ID = "/user/{userID}";

    /**
     * This is Endpoints of pet
     */

    public static final String GET_PET_BY_ID = "/pet/{petID}";
    public static final String CREATE_PET = "/pet";
    public static final String UPDATE_PET_BY_ID = "/pet";
    public static final String DELETE_PET_BY_ID = "/pet/{petID}";

}
