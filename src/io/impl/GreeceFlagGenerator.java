package io.impl;

import java.io.IOException;

import io.ImageGenerator;
import util.Image;
import util.Pixel;
import util.impl.SimpleImage;
import util.impl.SimplePixel;

/**
 * A generator for a Flag of Greece.
 */
public class GreeceFlagGenerator extends ImageGenerator {
  private static final Pixel white = new SimplePixel(255, 255, 255);
  private static final Pixel blue = new SimplePixel(0, 20, 137);

  /**
   * A constructor of 2 parameters.
   *
   * @param width  width of image
   * @param height height of image
   */
  public GreeceFlagGenerator(int width, int height) {
    super(width, height);
  }

  @Override
  public Image getImage() throws IOException {
    Image image = new SimpleImage(getHeight(), getWidth());
    int tmp = getHeight() / 9;
    for (int j = 0, color = 1; j < getHeight(); j += tmp, color = 1 - color) {
      for (int i = 0; i < getWidth(); ++i) {
        for (int k = j; k < getHeight() && k < j + tmp; ++k) {
          image.setPixel(i, k, color == 1 ? blue : white);
        }
      }
    }
    tmp = getHeight() / 18;
    for (int i = 0; i < getWidth() / 27 * 10; ++i) {
      for (int j = 0; j < tmp * 10; ++j) {
        image.setPixel(i, j, blue);
      }
    }
    for (int i = getWidth() / 27 * 4; i < getWidth() / 27 * 6; ++i) {
      for (int j = 0; j < tmp * 10; ++j) {
        image.setPixel(i, j, white);
      }
    }
    for (int i = 0; i < getWidth() / 27 * 10; ++i) {
      for (int j = tmp * 4; j < tmp * 6; ++j) {
        image.setPixel(i, j, white);
      }
    }
    return image;
  }
}
