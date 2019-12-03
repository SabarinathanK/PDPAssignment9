package model.impl;

import java.util.Arrays;

import model.ImageFiltering;

/**
 * An implementation for {@code ImageBlur}.
 */
public class ImageBlur extends ImageFiltering {
  /**
   * Constructor.
   */
  public ImageBlur() {
    super(Arrays.asList(
            Arrays.asList(1.0 / 16, 1.0 / 8, 1.0 / 16),
            Arrays.asList(1.0 / 8, 1.0 / 4, 1.0 / 8),
            Arrays.asList(1.0 / 16, 1.0 / 8, 1.0 / 16)));
  }
}
