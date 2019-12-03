package model.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.ImageCommand;
import util.Image;
import util.Pixel;
import util.impl.SimplePixel;

/**
 * An implementation for Floyd-Steinberg Dithering.
 */
public class FloydSteinbergDithering implements ImageCommand {
  private static final List<List<Double>> matrix =
      Arrays.asList(Collections.nCopies(3, 0.),
          Arrays.asList(0., 0., 7. / 16),
          Arrays.asList(3. / 16, 5. / 16, 1. / 16));

  /**
   * Dithering the image.
   *
   * @param image the image that needs to be dithered.
   * @return itself after dithering
   */
  public Image execute(Image image) {
    image = new GreyscaleTransformation().execute(image);
    for (int j = 0, tmp, error; j < image.getHeight(); ++j) {
      for (int i = 0; i < image.getWidth(); ++i) {
        tmp = (255 - image.getPixel(i, j).getR() > image.getPixel(i, j).getR() ? 0 : 255);
        error = image.getPixel(i, j).getR() - tmp;
        image.setPixel(i, j, new SimplePixel(tmp, tmp, tmp));

        for (int y = -1; y <= 1; ++y) {
          if (y + j >= 0 && y + j < image.getHeight()) {
            for (int x = -1; x <= 1; ++x) {
              if (x + i >= 0 && x + i < image.getWidth()) {
                image.getPixel(i + x, j + y).setR(image.getPixel(i + x, j + y).getR()
                    + (int) (error * matrix.get(y + 1).get(x + 1)));
              }
            }
          }
        }
      }
    }

    for (int i = 0; i < image.getWidth(); ++i) {
      for (int j = 0; j < image.getHeight(); ++j) {
        Pixel tmp = image.getPixel(i, j);
        tmp.setG(tmp.getR());
        tmp.setB(tmp.getR());
      }
    }
    return image;
  }
}
