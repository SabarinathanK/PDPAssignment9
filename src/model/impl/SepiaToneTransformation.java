package model.impl;

import java.util.Arrays;

import model.ColorTransformation;

/**
 * An implementation for {@code SepiaToneTransformation}.
 */
public class SepiaToneTransformation extends ColorTransformation {
  /**
   * Constructor.
   */
  public SepiaToneTransformation() {
    super(Arrays.asList(
            Arrays.asList(0.393, 0.769, 0.189),
            Arrays.asList(0.349, 0.686, 0.168),
            Arrays.asList(0.272, 0.534, 0.131)));
  }
}
