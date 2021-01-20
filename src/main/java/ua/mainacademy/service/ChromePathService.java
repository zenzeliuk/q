package ua.mainacademy.service;

import java.io.File;

public class ChromePathService {

    public String getChromePath() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("chromedriver.exe").getFile());
        return file.getAbsolutePath();
    }
}
