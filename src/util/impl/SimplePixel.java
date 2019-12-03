package util.impl;

import util.Pixel;

/**
 * A simple implementation for a ARGB pixel.
 */
public class SimplePixel implements Pixel {
  private static final int MAXIMUM = 255;
  private static final int MINIMUM = 0;
  private int pixel;


  /**
   * Constructor.
   *
   * @param r     r
   * @param g     g
   * @param b     b
   * @param alpha alpha
   */
  public SimplePixel(int r, int g, int b, int alpha) {
    r = clamp(r);
    g = clamp(g);
    b = clamp(b);
    alpha = clamp(alpha);
    pixel = (alpha << 24) | (r << 16) | (g << 8) | b;
  }

  /**
   * Constructor.
   *
   * @param argb argb
   */
  public SimplePixel(int argb) {
    pixel = argb;
  }

  /**
   * Constructor.
   *
   * @param r r
   * @param g g
   * @param b b
   */
  public SimplePixel(int r, int g, int b) {
    this(r, g, b, 0);
  }

  private static int clamp(int value) {
    return Math.min(MAXIMUM, Math.max(MINIMUM, value));
  }

  public int getARGB() {
    return pixel;
  }

  public Integer getR() {
    return (pixel >> 16) & 0x00ff;
  }

  /**
   * Set r.
   *
   * @param r r
   */
  public void setR(int r) {
    r = clamp(r);
    pixel &= 0xff00ffff;
    pixel |= (r << 16);
  }

  public Integer getG() {
    return (pixel >> 8) & 0xff;
  }

  /**
   * Set g.
   *
   * @param g g
   */
  public void setG(int g) {
    g = clamp(g);
    pixel &= 0xffff00ff;
    pixel |= (g << 8);
  }

  public Integer getB() {
    return pixel & 0xff;
  }

  /**
   * Set b.
   *
   * @param b b
   */
  public void setB(int b) {
    b = clamp(b);
    pixel &= 0xffffff00;
    pixel |= b;
  }

  public Integer getAlpha() {
    return (pixel >> 24) & 0xff;
  }

  /**
   * Set alpha.
   *
   * @param alpha alpha
   */
  public void setAlpha(int alpha) {
    alpha = clamp(alpha);
    pixel &= 0x00ffffff;
    pixel |= (alpha << 24);
  }
}
