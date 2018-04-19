package Utilities;

public class Environment_Config {

    protected static String Environment = "TEST";    //TEST OR DATABUILD OR PREPROD

    protected static String POISE_USER = "poise\\xxxxxxxxxx";
    protected static String POISE_USER_PWD = "xxxxxxxxxx";

    protected static String SNOW_USER = "xxxxxxxxxx";
    protected static String SNOW_USER_PWD = "xxxxxxxxxx";

    protected static String TEST_URL = "https://lssitest.service-now.com/welcome.do";
    protected static String TEST_URL1 = "https://lssitest.service-now.com/";
    protected static String TEST_URL2 = "https://lssitest.service-now.com/login.do";
    protected static String TEST_ESS = "https://lssitest.service-now.com/ess";

    protected static String DATABUILD_URL = "https://lssidatabuild.service-now.com/welcome.do";
    protected static String DATABUILD_URL1 = "https://lssidatabuild.service-now.com/";
    protected static String DATABUILD_URL2 = "https://lssidatabuild.service-now.com/login.do";
    protected static String DATABUILD_ESS = "https://lssidatabuild.service-now.com/ess";


    public static String getURL()
    {
        switch (Environment) {
            case "TEST":
                return TEST_URL;
            case "DATABUILD":
                return DATABUILD_URL;
            default:
                return TEST_URL;
        }
    }

    public static String getURL1()
    {
        switch (Environment) {
            case "TEST":
                return TEST_URL1;
            case "DATABUILD":
                return DATABUILD_URL1;
            default:
                return TEST_URL1;
        }
    }

    public static String getURL2()
    {
        switch (Environment) {
            case "TEST":
                return TEST_URL2;
            case "DATABUILD":
                return DATABUILD_URL2;
            default:
                return TEST_URL2;
        }
    }


    public static String getESSURL()
    {
        switch (Environment) {
            case "TEST":
                return TEST_ESS;
            case "DATABUILD":
                return DATABUILD_ESS;
            default:
                return TEST_ESS;
        }
    }


    public static String getPOISE_LOGIN_ID()
    {
        return POISE_USER;
    }


    public static String getPOISE_LOGIN_PASSWORD()
    {
        return POISE_USER_PWD;
    }

    public static String getSNOW_LOGIN_ID()
    {
        return SNOW_USER;
    }


    public static String getSNOW_LOGIN_PASSWORD()
    {
        return SNOW_USER_PWD;
    }
}
