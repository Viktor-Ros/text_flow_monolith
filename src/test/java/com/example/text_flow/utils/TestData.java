package com.example.text_flow.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {

    /**
     *
     * EMPLOYEE VARIABLES
     *
     */
    public static String EMP_1_ID = "emp000000000001";
    public static String EMP_2_ID = "emp000000000002";
    public static String EMP_3_ID = "emp000000000003";

    public static String EMP_1_NAME = "testUser1";
    public static String EMP_2_NAME = "testUser2";
    public static String EMP_3_NAME = "testUser3";
    public static String EMP_NAME_NEW = "testUser4";
    public static String EMP_NAME_UPDATE = "updateTestUser4";

    public static int EMP_ALL_LIST_SIZE = 3;
    public static int EMP_LIST_BY_WRITER_SIZE = 2;
    public static int EMP_LIST_BY_SUBSCRIBER_SIZE = 2;

    public static List<String> EMP_ALL_LIST = new ArrayList<>(Arrays.asList(EMP_1_ID, EMP_2_ID, EMP_3_ID));



    /**
     *
     * STORY VARIABLES
     *
     */
    public static String ST_1_ID = "str000000000001";
    public static String ST_2_ID = "str000000000002";
    public static String ST_3_ID = "str000000000003";

    public static String ST_1_VALUE = "testStory1";
    public static String ST_2_VALUE = "testStory2";
    public static String ST_3_VALUE = "testStory3";
    public static String ST_VALUE_NEW = "story4";
    public static String ST_VALUE_UPDATE = "updateStory4";

    public static int ST_ALL_LIST_SIZE = 3;
    public static int ST_LIST_SIZE_BY_AUTHOR_ID = 2;
    public static int ST_LIST_SIZE_BY_SUBSCRIBER_ID = 2;


    /**
     *
     * SUBSCRIPTION VARIABLES
     *
     */
    public static String SUB_1_ID = "sub000000000001";
    public static String SUB_2_ID = "sub000000000002";
    public static String SUB_3_ID = "sub000000000003";

    public static int SUB_ALL_LIST_SIZE = 3;
    public static int SUB_LIST_BY_WRITER_SIZE = 2;
    public static int SUB_LIST_BY_SUBSCRIBER_SIZE = 2;

}
