package model.impl;

import java.util.Arrays;
import java.util.Collections;

import model.ImageFiltering;

/**
 * An implementation for {@code ImageSharpen}.
 */
public class ImageSharpen extends ImageFiltering {
  /**
   * Constructor.
   */
  public ImageSharpen() {
    super(Arrays.asList(
            Collections.nCopies(5, -1.0 / 8),
            Arrays.asList(-1. / 8, 1. / 4, 1. / 4, 1. / 4, -1. / 8),
            Arrays.asList(-1. / 8, 1. / 4, 1., 1. / 4, -1. / 8),
            Arrays.asList(-1. / 8, 1. / 4, 1. / 4, 1. / 4, -1. / 8),
            Collections.nCopies(5, -1.0 / 8)));
  }
}
