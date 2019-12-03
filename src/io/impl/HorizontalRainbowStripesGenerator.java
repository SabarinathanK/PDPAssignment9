package io.impl;

import java.util.ArrayList;
import java.util.List;

import io.ImageGenerator;
import util.Image;
import util.Pixel;
import util.impl.SimpleImage;
import util.impl.SimplePixel;

/**
 * Generating a horizontal rainbow stripes.
 */
public class HorizontalRainbowStripesGenerator extends ImageGenerator {
  private final static Pixel[] stripes =
  {new SimplePixel(255, 0, 0), new SimplePixel(255, 127, 0),
    new SimplePixel(255, 255, 0), new SimplePixel(0, 255, 0),
    new SimplePixel(0, 0, 255), new SimplePixel(75, 0, 130),
    new SimplePixel(148, 0, 211)};
  private final int stripeWidth;
  private List<Integer> index;

  /**
   * Constructor of 3 parameters.
   *
   * @param width       width of the image
   * @param height      height of the image
   * @param stripeWidth width of a stripe
   */
  public HorizontalRainbowStripesGenerator(int width, int height, int stripeWidth) {
    super(width, height);
    this.stripeWidth = stripeWidth;
    index = new ArrayList<>();
    for (int i = 0; i < height; i += stripeWidth) {
      index.add(i);
    }
    index.add(height);
  }

  @Override
  public Image getImage() {
    Image image = new SimpleImage(getHeight(), getWidth());
    for (int j = 0, curColor = 0;
         j < index.size() - 1; ++j, curColor = (1 + curColor) % stripes.length) {
      for (int k = index.get(j); k < index.get(j) + stripeWidth; ++k) {
        for (int i = 0; i < getWidth(); ++i) {
          image.setPixel(i, k, stripes[curColor]);
        }
      }
    }
    return image;
  }
}
