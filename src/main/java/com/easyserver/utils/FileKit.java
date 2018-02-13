package com.easyserver.utils;

import java.io.File;

/**
 * Created by Administrator on 2018/2/13 0013.
 */
public class FileKit {
    public static void delete(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
            }
            else if (file.isDirectory()) {
                File files[] = file.listFiles();
                if (files != null) {
                    for (int i=0; i<files.length; i++) {
                        delete(files[i]);
                    }
                }
                file.delete();
            }
        }
    }

    public static String getFileExtension(String fileFullName) {
        if (StrKit.isBlank(fileFullName)) {
            throw new RuntimeException("fileFullName is empty");
        }
        return  getFileExtension(new File(fileFullName));
    }

    public static String getFileExtension(File file) {
        if (null == file) {
            throw new NullPointerException();
        }
        String fileName = file.getName();
        int dotIdx = fileName.lastIndexOf('.');
        return (dotIdx == -1) ? "" : fileName.substring(dotIdx + 1);
    }

}
