package io.impl;

import java.util.ArrayList;
import java.util.List;

import io.ImageGenerator;
import util.Image;
import util.Pixel;
import util.impl.SimpleImage;
import util.impl.SimplePixel;

/**
 * Generate a vertical rainbow stripes.
 */
public class VerticalRainbowStripesGenerator extends ImageGenerator {
  private final static Pixel[] stripes =
  {new SimplePixel(255, 0, 0)
    , new SimplePixel(255, 127, 0), new SimplePixel(255, 255, 0),
    new SimplePixel(0, 255, 0), new SimplePixel(0, 0, 255),
    new SimplePixel(75, 0, 130), new SimplePixel(148, 0, 211)};
  private final int stripeWidth;
  private List<Integer> index;

  /**
   * Constructor of 3 parameters.
   *
   * @param width       the width of the image
   * @param height      the height of the image
   * @param stripeWidth the width of stripes
   */
  public VerticalRainbowStripesGenerator(int width, int height, int stripeWidth) {
    super(width, height);
    this.stripeWidth = stripeWidth;
    index = new ArrayList<>();
    for (int i = 0; i < width; i += stripeWidth) {
      index.add(i);
    }
    index.add(width);
  }

  @Override
  public Image getImage() {
    Image image = new SimpleImage(getHeight(), getWidth());
    for (int i = 0, curColor = 0; i < index.size() - 1;
         ++i, curColor = (curColor + 1) % stripes.length) {
      for (int k = index.get(i); k < index.get(i) + stripeWidth; ++k) {
        for (int j = 0; j < getHeight(); ++j) {
          image.setPixel(k, j, stripes[curColor]);
        }
      }
    }
    return image;
  }
}
