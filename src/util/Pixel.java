package util;

/**
 * An interface for {@code Pixel}.
 */
public interface Pixel {
  Integer getR();

  void setR(int r);

  Integer getG();

  void setG(int g);

  Integer getB();

  void setB(int b);

  Integer getAlpha();

  void setAlpha(int alpha);

  int getARGB();
}
