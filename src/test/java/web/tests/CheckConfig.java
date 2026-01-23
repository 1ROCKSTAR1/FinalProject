package web.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class CheckConfig {

    public static void main(String[] args) throws Exception {
        System.out.println("=== CHECKING CONFIG FILES ===");

        // Проверяем разные пути
        String[] paths = {
                "src/test/resources/config/remote.properties",
                "build/resources/test/config/remote.properties",
                "config/remote.properties"
        };

        for (String path : paths) {
            File file = new File(path);
            System.out.println("\nChecking: " + path);
            System.out.println("Exists: " + file.exists());

            if (file.exists()) {
                Properties prop = new Properties();
                try (FileInputStream input = new FileInputStream(file)) {
                    prop.load(input);
                    System.out.println("is.remote: " + prop.getProperty("is.remote"));
                    System.out.println("remote.url: " + prop.getProperty("remote.url"));
                }
            }
        }
    }
}
