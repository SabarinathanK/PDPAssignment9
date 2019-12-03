package model;

import java.util.List;

import util.Image;
import util.Pixel;
import util.impl.SimpleImage;
import util.impl.SimplePixel;

/**
 * An abstract for {@code ColorTransformation} algorithms.
 */
public abstract class ColorTransformation implements ImageCommand {
  private final List<List<Double>> matrix;

  protected ColorTransformation(List<List<Double>> matrix) {
    this.matrix = matrix;
  }

  /**
   * Transform a {@code Pixel} into another {@code Pixel}.
   *
   * @param pixel pixel
   * @return the new pixel after transforming
   */
  public Pixel transform(Pixel pixel) {
    int[] arr = new int[3];
    for (int i = 0; i < 3; ++i) {
      List<Double> list = matrix.get(i);
      arr[i] = (int) (list.get(0) * pixel.getR() +
              list.get(1) * pixel.getG() + list.get(2) * pixel.getB());
    }
    return new SimplePixel(arr[0], arr[1], arr[2]);
  }

  /**
   * Transform image into another image by color transformation.
   *
   * @param image image
   * @return the new image after transformation
   */
  public Image execute(Image image) {
    Image result = new SimpleImage(image.getHeight(), image.getWidth());
    for (int x = 0; x < image.getWidth(); ++x) {
      for (int y = 0; y < image.getHeight(); ++y) {
        result.setPixel(x, y, transform(image.getPixel(x, y)));
      }
    }
    return result;
  }
}
