package io;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import util.Image;
import util.impl.SimpleImage;
import util.impl.SimplePixel;

/**
 * A simple implementation for reading a image file.
 */
public class ImageFileReader implements ImageReader {
  private String path;
boolean setImage=false;
BufferedImage image=null;
  /**
   * Constructed by a path name.
   *
   * @param path the path name
   */
  public ImageFileReader(String path) {
    this.path = path;
  }

   public static Image bufferedImageToImage(BufferedImage bufferedImage) {
    Image image = new SimpleImage(bufferedImage.getHeight(), bufferedImage.getWidth());
    for (int i = 0; i < bufferedImage.getWidth(); ++i) {
      for (int j = 0; j < bufferedImage.getHeight(); ++j) {
        image.setPixel(i, j, new SimplePixel(bufferedImage.getRGB(i, j)));
      }
    }
    return image;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public Image getImage() throws IOException {
    if(!setImage)
    return bufferedImageToImage(ImageIO.read(new File(path)));
    else
      return  bufferedImageToImage(image);
  }

  public void setImage(BufferedImage image)
  {
    setImage=true;
    this.image=image;
  }
}
