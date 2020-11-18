package com.birkhoff.bytebuffer;

import java.io.File;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MappedByteBufferTest {
    private static final Logger logger = Logger.getLogger("App");

    private static final String FILE_READ = "rafRead.txt";
    //= Change this according to your needs =========================
    private static final String FILE_WRITE = "C:\\tmp\\rafWrite.txt";

    // ========================================================================
    // = Utility function to get a file located in the classpath ==============
    // ========================================================================
    private static Path getFileURIFromClasspath(String fileName) throws Exception {
        Path result = null;

//        String classpath = System.getProperty("java.class.path");
        String filePath = "E:\\workspace_my\\springboot\\thread\\com.birkhoff.thread\\src\\main\\resources";
        result = FileSystems.getDefault().getPath(filePath + File.separator + fileName);

        return result;
    }

    public static void main(String[] args) {
        CharBuffer charBuffer = null;
        String charEncoding = null;
        MappedByteBuffer mappedByteBuffer = null;

        try {
            charEncoding = System.getProperty("file.encoding");
            if(charEncoding == null){
                charEncoding = StandardCharsets.UTF_8.name();
            }

            // Read a file
            Path pathRead = getFileURIFromClasspath(MappedByteBufferTest.FILE_READ);
            if (Files.exists(pathRead, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
                try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(pathRead, EnumSet.of(StandardOpenOption.READ))) {
                    mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

                    if (mappedByteBuffer != null) {
                        logger.info("Reading file...");
                        charBuffer = Charset.forName(charEncoding).decode(mappedByteBuffer);
                        logger.info("File content: " + charBuffer.toString());
                    }
                } catch (IOException ioe) {
                    logger.log(Level.SEVERE, ioe.getMessage());
                    ioe.printStackTrace();
                }
            }

            // Write a file
            Path pathWrite = FileSystems.getDefault().getPath(MappedByteBufferTest.FILE_WRITE);
            if (Files.notExists(pathWrite, new LinkOption[]{LinkOption.NOFOLLOW_LINKS})) {
                Files.createFile(pathWrite);

                try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(pathWrite, EnumSet.of(StandardOpenOption.READ, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING))) {
                    mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, charBuffer.length());

                    if (mappedByteBuffer != null) {
                        logger.info("Writing to file...");
                        mappedByteBuffer.put(Charset.forName(charEncoding).encode(charBuffer));
                        logger.info("Done!");
                    }
                } catch (IOException ioe) {
                    logger.log(Level.SEVERE, ioe.getMessage());
                    ioe.printStackTrace();
                }
            }

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            e.printStackTrace(System.err);
        }
    }
}
