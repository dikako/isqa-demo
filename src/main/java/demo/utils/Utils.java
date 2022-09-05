package demo.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

/**
 * fransiskusandika 19/06/2022
 */
public class Utils {
    public static Properties ELEMENTS;

    public static void loadElementProperties(String directory) {
        File folder = new File(directory);
        File[] listOfFiles = folder.listFiles();
        ELEMENTS = new Properties();

        for (int i = 0; i < Objects.requireNonNull(listOfFiles).length; ++i) {
            if (listOfFiles[i].isFile() && listOfFiles[i].toString().contains(".properties")) {
                try {
                    ELEMENTS.load(Files.newInputStream(Paths.get(directory + listOfFiles[i].getName())));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static byte[] compressBytes(byte[] pngBytes) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(pngBytes);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(byteArrayInputStream);
            BufferedImage newBufferedImage = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = newBufferedImage.createGraphics();
            graphics2D.drawImage(bufferedImage, 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null);
            graphics2D.dispose();
            ImageIO.write(newBufferedImage, "jpeg", byteArrayOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toByteArray();
    }
}
