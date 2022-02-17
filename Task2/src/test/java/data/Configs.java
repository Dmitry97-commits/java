package data;

import utils.ResourcesUtils;

import java.io.IOException;

import static utils.ResourcesUtils.getResources;

public class Configs {
    public static String mainUrl;

    static {
        try {
            mainUrl = getResources("mainUrl");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
