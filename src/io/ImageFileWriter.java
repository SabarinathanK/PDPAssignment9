package io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import util.Image;

/**
 * A simple implementation for writing a {@code Image} to a file.
 */
public class ImageFileWriter implements ImageWriter {
  private String path;

  /**
   * Constructor for a path.
   *
   * @param path the path of the image
   */
  public ImageFileWriter(String path) {
    this.path = path;
  }

  public static BufferedImage imageToBufferedImage(Image image) {
    BufferedImage bufferedImage = new BufferedImage(image.getWidth(),
            image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
    for (int i = 0; i < image.getWidth(); ++i) {
      for (int j = 0; j < image.getHeight(); ++j) {
        bufferedImage.setRGB(i, j, image.getPixel(i, j).getARGB());
      }
    }
    return bufferedImage;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  /**
   * Write the image into the path specified.
   *
   * @param image image
   * @throws IOException if normal path errors happens.
   */
  public void writeImage(Image image) throws IOException {
    File file = new File(path);
    String[] strings = file.getName().split("\\.");
    System.out.println(ImageIO.
            write(imageToBufferedImage(image), strings[strings.length - 1], file));
  }
}
