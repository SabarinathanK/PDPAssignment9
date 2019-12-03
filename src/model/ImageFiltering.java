package model;

import java.util.List;

import util.Image;
import util.Pixel;
import util.impl.SimpleImage;
import util.impl.SimplePixel;

/**
 * An abstract class for {@code ImageFiltering} algorithms.
 */
public abstract class ImageFiltering implements ImageCommand {
  private final List<List<Double>> filter;

  protected ImageFiltering(List<List<Double>> filter) {
    if (((filter.get(0).size() & 1) == 1) && ((filter.size() & 1) == 1)) {
      final int size = filter.get(0).size();
      for (int i = 1; i < filter.size(); ++i) {
        if (size != filter.get(i).size()) {
          throw new IllegalArgumentException();
        }
      }
      this.filter = filter;
    } else {
      throw new IllegalArgumentException();
    }
  }

  /**
   * Transform a {@code Pixel} into another {@code Pixel} by filtering.
   *
   * @param x     x
   * @param y     y
   * @param image the image
   * @return the Pixel in (x,y) after filtering.
   */
  public Pixel transform(int x, int y, Image image) {
    double r = 0;
    double g = 0;
    double b = 0;
    for (int i = 0, curX = x - (filter.get(0).size() - 1) / 2;
         i < filter.get(0).size(); ++i, ++curX) {
      for (int j = 0, curY = y - (filter.size() - 1) / 2; j < filter.size(); ++j, ++curY) {
        if (curY >= 0 && curY < image.getHeight() && curX >= 0 && curX < image.getWidth()) {
          r += image.getPixel(curX, curY).getR() * filter.get(j).get(i);
          g += image.getPixel(curX, curY).getG() * filter.get(j).get(i);
          b += image.getPixel(curX, curY).getB() * filter.get(j).get(i);
        }
      }
    }
    return new SimplePixel((int) r, (int) g, (int) b);
  }

  /**
   * Filtering the image.
   *
   * @param image image
   * @return the new image after filtering
   */
  public Image execute(Image image) {
    Image result = new SimpleImage(image.getHeight(), image.getWidth());
    for (int x = 0; x < image.getWidth(); ++x) {
      for (int y = 0; y < image.getHeight(); ++y) {
        result.setPixel(x, y, transform(x, y, image));
      }
    }
    return result;
  }
}
