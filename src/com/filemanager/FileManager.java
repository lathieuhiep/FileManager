package com.filemanager;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FileManager {
    private File fileSrc;

    public FileManager(String pathSrc) {
        this.fileSrc = new File(pathSrc);
    }

    public ArrayList<File> findByExtension(String extension) {
        ArrayList<File> resultList = new ArrayList<>();

        try {
            if ( fileSrc.isDirectory() ) {
                File[] files = fileSrc.listFiles();

                if (files != null) {
                    for (int i = 0; i < files.length; i++) {
                        File file = files[i];
                        String fileName = file.getName();

                        if ( fileName.lastIndexOf(".") != -1 ) {
                            String extensionName = fileName.substring( fileName.lastIndexOf(".") + 1 );

                            if (extension.equals(extensionName)) {
                                resultList.add(file);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public void printListFileExtension(ArrayList<File> files) {
        try {
            System.out.println("Danh sách file có đuôi mở rộng cần tìm:");

            for (File file : files) {
                System.out.println(file.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sortByNameSize() {
        try {
            if ( fileSrc.isDirectory() ) {
                File[] files = fileSrc.listFiles();

                if (files != null) {
                    ArrayList<File> fileList = new ArrayList<>(Arrays.asList(files));

                    Collections.sort(fileList, new Comparator<File>() {
                        @Override
                        public int compare(File f1, File f2) {
                            int nameComparison = f1.getName().compareTo( f2.getName() );

                            if ( nameComparison < 0 ) {
                                return nameComparison;
                            } else {
                                return Long.compare( f1.length(), f2.length() );
                            }
                        }
                    });

                    // in ra danh sách file đã sắp xếp
                    System.out.println("Danh sách file sắp xếp theo tên và kích thước:");

                    for (File file : fileList) {
                        System.out.println(file.getName() + " - " + file.length() + " bytes");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
