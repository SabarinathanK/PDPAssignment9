package io.impl;

import java.util.ArrayList;
import java.util.List;

import io.ImageGenerator;
import util.Image;
import util.Pixel;
import util.impl.SimpleImage;
import util.impl.SimplePixel;

/**
 * A generator for checkerboard.
 */
public class CheckerboardGenerator extends ImageGenerator {
  private final int squareSize;
  private final Pixel[] pixels = {new SimplePixel(0, 0, 0), new SimplePixel(255, 255, 255)};
  private final List<Integer> indexWidth;
  private final List<Integer> indexHeight;

  /**
   * A constructor for 3 parameters.
   *
   * @param width      width
   * @param height     height
   * @param squareSize the size of square
   */
  public CheckerboardGenerator(int width, int height, int squareSize) {
    super(width, height);
    this.squareSize = squareSize;
    indexHeight = new ArrayList<>();
    indexWidth = new ArrayList<>();
    for (int i = height; i >= 0; i -= squareSize) {
      indexHeight.add(i);
    }
    indexHeight.add(0);
    for (int i = 0; i < width; i += squareSize) {
      indexWidth.add(i);
    }
    indexWidth.add(width);
  }

  @Override
  public Image getImage() {
    Image image = new SimpleImage(getHeight(), getWidth());
    for (int j = 0, colorY = 0; j < indexHeight.size() - 1; ++j, colorY ^= 1) {
      for (int i = 0, colorX = 0; i < indexWidth.size() - 1; ++i, colorX ^= 1) {
        for (int x = indexWidth.get(i); x < indexWidth.get(i + 1); ++x) {
          for (int y = indexHeight.get(j) - 1;
               y >= indexHeight.get(j) - squareSize && y >= 0; --y) {
            image.setPixel(x, y, pixels[(colorX + colorY) & 1]);
          }
        }
      }
    }
    return image;
  }
}
