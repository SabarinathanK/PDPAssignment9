package util.impl;

import java.util.ArrayList;
import java.util.List;

import util.Image;
import util.Pixel;

/**
 * An simple implementation for a ARGB image.
 */
public class SimpleImage implements Image {
  private final int height;
  private final int width;
  private List<List<Pixel>> raster;

  /**
   * Constructor.
   *
   * @param height the height of the image
   * @param width  the width of the image
   * @throws IllegalArgumentException if width or height less than or equals to 0
   */
  public SimpleImage(int height, int width) {
    if (height <= 0 || width <= 0) {
      throw new IllegalArgumentException();
    }
    this.height = height;
    this.width = width;
    raster = new ArrayList<>();
    for (int i = 0; i < height; ++i) {
      List<Pixel> tmp = new ArrayList<>();
      while (tmp.size() < width) {
        tmp.add(new SimplePixel(0, 0, 0, 0));
      }
      raster.add(tmp);
    }
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public void setPixel(int x, int y, Pixel pixel) {
    raster.get(y).set(x, pixel);
  }

  public Pixel getPixel(int x, int y) {
    return raster.get(y).get(x);
  }
}
