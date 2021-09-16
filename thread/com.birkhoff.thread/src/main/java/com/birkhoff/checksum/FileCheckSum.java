package com.birkhoff.checksum;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.system.ApplicationHome;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileCheckSum {
    public static void main(String[] args) throws IOException {

        String checksumSHA256 = DigestUtils.sha256Hex(new FileInputStream("/Users/birkhoffliu/bench.log"));
        System.out.println("checksumSHA256 : " + checksumSHA256);

        String checksumMD5 = DigestUtils.md5Hex(new FileInputStream("/Users/birkhoffliu/bench.log"));
        System.out.println("checksumMD5 : " + checksumMD5);

        System.out.println(new FileCheckSum().getJarFilePath());

    }


    //linux和windows下通用
    private String getJarFilePath() {
        ApplicationHome home = new ApplicationHome(this.getClass());
        File jarFile = home.getSource();
        return jarFile.getParentFile().toString();
    }
}
