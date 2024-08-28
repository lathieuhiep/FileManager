package com.main;

import com.filemanager.FileManager;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager("D:/java-exercises/bai-tap-buoi-19/test-folder-file");

        // tìm file có đuôi mở rộng
        String fileExtension = "txt";
        ArrayList<File> listFileExtension = fileManager.findByExtension( fileExtension );
        fileManager.printListFileExtension( listFileExtension );

        System.out.println();

        // sắp xếp
        fileManager.sortByNameSize();
    }
}