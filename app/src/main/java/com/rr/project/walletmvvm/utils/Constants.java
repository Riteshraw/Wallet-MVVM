package com.rr.project.walletmvvm.utils;

/**
 * Created by admin on 22-Jun-18.
 */

public class Constants {

    public final static String API_KEY = "456545658525";
    public static final String ACCESS_TOKEN = "ACCESS_TOKEN";

    public final static int SPLASH_TIME_OUT = 1000;
    public static final String MAIN_FRAGMENT = "main_fragment";
    public static final String BOOK_TEST_LAB_FRAGMENT = "book_test_lab_fragment";
    public static final String NEW_ADDRESS_LAB_FRAGMENT = "new_address_lab_fragment";
    public static final String PREVIEW_DETAILS_FRAGMENT = "preview_details_fragment";
    public static final String FITNESS_ITEM_DETAILS_FRAGMENT = "fitness_item_details_fragment";
    public static final String FITNESS_ENTER_VALUES_FRAGMENT = "fitness_enter_values_fragment";
    public static final String PREV_DATE = "prev_date";
    public static final String DEVICE_ID = "device_id";

    public static final String SUCCESS = "SUCCESS";
    public static final boolean SHOW_CUSTOM_MSG = false;
    public static final String CUSTOM_MSG = "Error in parsing response from server";
    public static final String SLOT_DATE = "slot_date";


    public static int LOGIN = 1;
    public static int PASSWORD = 2;
    public static int FORGOT_PASSWORD = 3;
    public static int NEW_PASSWORD = 4;
    public static int SIGNUP = 5;
    public static int SET_PASSWORD = 6;
    public static int GOOGLE_PERMISSION = 7;

    public static final int EXCEPTION_CODE = 100;
    public static final String RESPONSE = "Response";
    public static final String STATUS_CODE = "StatusCode";
    public static final String MODELSTATE = "ModelState";
    public static final String MESSAGE = "Message";

    public final static int[] MENU_ITEM_ID_ARRAY = {1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007};
    public final static String[] MENU_ITEM_ARRAY = {"My Profile", "Know your Health", "Lab Test", "OPD", "Track Fitness", "My Nutrition", "My Medicines"};
//    public final static int[] MENU_ITEM_ICON_ARRAY = {R.mipmap.profile, R.mipmap.health, R.mipmap.lab, R.mipmap.opd, R.mipmap.fitness, R.mipmap.nutrition, R.mipmap.medicines};

    public final static int[] SUBMENU_ITEM_ID_ARRAY = {2000, 2001, 2002, 2003};
    public final static String[] SUBMENU_ITEM_ARRAY = {"My Info", "My Family", "Change Password", "Address Book"};
//    public final static int[] SUBMENU_ITEM_ICON_ARRAY = {R.mipmap.info, R.mipmap.family, R.mipmap.chng_pass, R.mipmap.address_book};

//    public final static int[] DASHBOARD_GRID_MENU_ITEM_ICON_ARRAY = {R.mipmap.profile_grid, R.mipmap.health_grid, R.mipmap.lab_grid, R.mipmap.opd_grid, R.mipmap.track_fitness_grid, R.mipmap.nutrition_grid, R.mipmap.medicines_grid};

    public final static int[] FITNESS_MENU_ITEM_ID_ARRAY = {1000, 1001, 1002, 1003, 1004, 1005, 1006, 1007, 1008};
    public final static String[] FITNESS_MENU_ITEM_ARRAY = {"Steps", "Distance", "Calories", "Weight", "Height", "Blood Sugar", "Blood Pressure", "Cholesterol"};
//    public final static int[] FITNESS_GRID_MENU_ITEM_ICON_ARRAY = {R.mipmap.steps, R.mipmap.running, R.mipmap.calories, R.mipmap.weight, R.mipmap.height, R.mipmap.blood_sugar, R.mipmap.blood_pressure, R.mipmap.cholesterol};

    public static final String MY_RECODING_FRAGMENT = "my_recoding_fragment";
    public static final String ADDRESS_LAB_FRAGMENT = "address_lab_fragment";
    public static final String KNOW_YOUR_HEALTH_FRAGMENT = "know_your_health_fragment";
    public static final String LAB_TEST_FRAGMENT = "lab_test_fragment";
    public static final String OPD_FRAGMENT = "opd_fragment";
    public static final String TRACK_FITNESS_FRAGMENT = "track_fitness_fragment";
    public static final String MY_NUTRITION_FRAGMENT = "my_nutrition_fragment";
    public static final String MY_MEDICINES_FRAGMENT = "my_medicines_fragment";

    public static String GOOGLE_FIT_PERMISSION = "google_fit_permission";
    public static final String USER_MOBILE = "user_mobile";
    public static final String USER_NAME = "user_name";
    public static final String USER_ID = "UserID";
    public static final String USER_FIRST_NAME = "user_first_name";
    public static final String USER_MIDDLE_NAME = "user_middle_name";
    public static final String USER_LAST_NAME = "user_last_name";
    public static final String USER_EMAIL = "user_email";
    public static final String LOGGED_IN = "loggedIn";

    public static final String FIRST_NAME = "first_name";
    public static final String MIDDLE_NAME = "middle_name";
    public static final String LAST_NAME = "last_name";
    public static final String GENDER = "gender";
    public static final String DOB = "dob";
    public static final String EMAIL = "email";
    public static final String MOBILE = "mobile";

    public static String BASE_URL = "http://uathealthapi.nubiz.co.in/api/";

    public static final String REGISTRATION = "UserRegistration/Registration";
    public static final String SETPASSWORD = "UserRegistration/VerifyUser";
    public static final String UPDATE_USER_GOOGLE_FIT_INFO = "UserRegistration/UpdateUserGoogleFitInfo";
    public static final String LOGIN_WITH_PWD = /*"api/login"*/"UserRegistration/LoginWithPwd";
    public static final String LOGIN_WITH_OTP = "UserRegistration/LoginWithOtp";
    public static final String RESEND_OTP = "UserRegistration/ResendOtp";
    public static final String VERIFY_OTP = "UserRegistration/VerifyOtp";
    public static final String UPDATE_USER_PWD = "UserRegistration/UpdateUserPwd";

    public static final String AUTHORISE_API = "http://uathealthapi.nubiz.co.in/api/AuthoriseApi?ApiKey=";

    public static final String GET_ALL_LOCALITY = "AddressLocality/GetAllLocality";
    public static final String GET_ALL_CITY = "AddressLocality/GetAllCity";
    public static final String GET_ALL_STATE = "AddressLocality/GetAllState";
    public static final String ADD_USER_INFO = "UserFamilyRelations/AddUserInfoInFamily";
    public static final String GET_USER_ADDRESS_LIST_BY_MOBILE_NUMBER = "AddressLocality/GetUserAddressListByMobileNumber?MobileNumber=";
    public static final String RETORFIT_GET_USER_ADDRESS_LIST_BY_MOBILE_NUMBER = "AddressLocality/GetUserAddressListByMobileNumber";
    public static final String ADD_USER_ADDRESS = "AddressLocality/AddUserAddress";
    public static final String GET_USER_FAMILY_LIST_BY_MOBILE_NUMBER = "UserFamilyRelations/GetUserFamilyInfoInByMNumber?UserMobileNumber=";
    public static final String ADD_USER_FAMILY_INFO = "UserFamilyRelations/AddUserFamilyInfoInFamily";
    public static final String GET_ALL_TIME_SOLTS = "BookUserTest/GetAllTimeSoltDetailLocalityWise?LocalityID=";
    public static final String ADD_USER_TEST = "BookUserTest/AddUserTest";
    public static final String GET_USER_TEST_LIST = "/BookUserTest/GetUserTestlist?MobileNumber=";

}
