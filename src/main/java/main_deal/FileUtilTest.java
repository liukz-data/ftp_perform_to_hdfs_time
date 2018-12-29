package main_deal;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileUtilTest {
    public static void main(String[] args) throws IOException {
        FileUtils.deleteDirectory(new File("HH:\\out\\test1"));
    }
}
