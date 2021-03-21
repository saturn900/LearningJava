package jdev.services;

import org.springframework.stereotype.Service;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Егор on 25.11.2017.
 */

@Service
public class FileService {
    private File file = new File("server-core//src//main//resources//points.txt");

    public void writeInFile(String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, false))) {
            bw.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

