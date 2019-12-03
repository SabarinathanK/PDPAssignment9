package io.impl;

import io.ImageGenerator;
import util.Image;
import util.Pixel;
import util.impl.SimpleImage;
import util.impl.SimplePixel;

/**
 * An implementation for generating a flag of Switzerland.
 */
public class SwitzerlandFlagGenerator extends ImageGenerator {
  private final static Pixel red = new SimplePixel(255, 0, 0);
  private final static Pixel white = new SimplePixel(255, 255, 255);
  private final static int[] proportion = {0, 6, 13, 19, 26, 32};

  public SwitzerlandFlagGenerator(int width, int height) {
    super(width, height);
  }

  /**
   * Return the image.
   *
   * @return a flag of Switzerland.
   */
  public Image getImage() {
    Image image = new SimpleImage(getHeight(), getWidth());
    for (int i = 0; i < getWidth(); ++i) {
      for (int j = 0; j < getHeight(); ++j) {
        image.setPixel(i, j, red);
      }
    }
    for (int i = getWidth() / 32 * proportion[2]; i < getWidth() / 32 * proportion[3]; ++i) {
      for (int j = getHeight() / 32 * proportion[1]; j < getHeight() / 32 * proportion[4]; ++j) {
        image.setPixel(i, j, white);
      }
    }
    for (int i = getWidth() / 32 * proportion[1]; i < getWidth() / 32 * proportion[4]; ++i) {
      for (int j = getHeight() / 32 * proportion[2]; j < getHeight() / 32 * proportion[3]; ++j) {
        image.setPixel(i, j, white);
      }
    }
    return image;
  }
}
