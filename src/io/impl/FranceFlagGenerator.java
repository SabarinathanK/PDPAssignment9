package io.impl;

import io.ImageGenerator;
import util.Image;
import util.Pixel;
import util.impl.SimpleImage;
import util.impl.SimplePixel;

/**
 * An implementation for generating a flag of France.
 */
public class FranceFlagGenerator extends ImageGenerator {
  private final static Pixel blue = new SimplePixel(0, 85, 164);
  private final static Pixel white = new SimplePixel(255, 255, 255);
  private final static Pixel red = new SimplePixel(239, 65, 53);

  public FranceFlagGenerator(int width, int height) {
    super(width, height);
  }

  /**
   * Return the image.
   *
   * @return a flag of France
   */
  @Override
  public Image getImage() {
    Image image = new SimpleImage(getHeight(), getWidth());
    for (int i = 0; i < getWidth() / 3; ++i) {
      for (int j = 0; j < getHeight(); ++j) {
        image.setPixel(i, j, blue);
      }
    }
    for (int i = getWidth() / 3 + 1; i < getWidth() / 3 * 2; ++i) {
      for (int j = 0; j < getHeight(); ++j) {
        image.setPixel(i, j, white);
      }
    }
    for (int i = getWidth() / 3 * 2 + 1; i < getWidth(); ++i) {
      for (int j = 0; j < getHeight(); ++j) {
        image.setPixel(i, j, red);
      }
    }
    return image;
  }
}
