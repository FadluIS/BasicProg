package ch5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MailAddresses {
    Properties loadedAddresses;

    public MailAddresses(String filename) throws IOException {
        FileInputStream file = new FileInputStream(filename);
        loadedAddresses.load(file);
        file.close();
    }

    public String getEmail(String name) {
        return loadedAddresses.getProperty(name);
    }
}
