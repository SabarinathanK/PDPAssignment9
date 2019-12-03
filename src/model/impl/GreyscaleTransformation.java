package model.impl;

import java.util.Arrays;
import java.util.Collections;

import model.ColorTransformation;

/**
 * An implementation for {@code GreycaleTransformation}.
 */
public class GreyscaleTransformation extends ColorTransformation {
  public GreyscaleTransformation() {
    super(Collections.nCopies(3, Arrays.asList(0.2126, 0.7152, 0.0722)));
  }
}
