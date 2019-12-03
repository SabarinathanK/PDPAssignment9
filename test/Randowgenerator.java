import io.ImageFileWriter;
import java.io.IOException;
import util.Image;
import util.Pixel;
import util.impl.SimpleImage;
import util.impl.SimplePixel;

public class Randowgenerator {

  public static void main(String[] args) throws IOException {
    int width = 400;
    int height = 350;
    int squares = 64;
    int rows = 0;
    int userstripheight=50;
    Image image = new SimpleImage(height, width);

    for (int k = 0; k < 7; k++) {
      int y = 0;
      int rowcondtion = userstripheight;
      for (int l = 0; l < k; l++) {
        y += userstripheight;
        rowcondtion += userstripheight;
      }
      int x = 0;

      if (k  == 0) {

        for (; x < width; x++) {

          int y1 = y;
          for (; y1 < rowcondtion; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(255, 0, 0);
            image.setPixel(x, y1, pixel);
            // }
          }

        }


      }
      if (k == 1) {

        for (; x < width; x++) {

          int y1 = y;
          for (; y1 < rowcondtion; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(255, 127, 0);
            image.setPixel(x, y1, pixel);
            // }
          }

        }


      }
      if (k  == 2) {

        for (; x < width; x++) {

          int y1 = y;
          for (; y1 < rowcondtion; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(255, 255, 0);
            image.setPixel(x, y1, pixel);
            // }
          }

        }


      }
      if (k == 3) {

        for (; x < width; x++) {

          int y1 = y;
          for (; y1 < rowcondtion; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(0, 255, 0);
            image.setPixel(x, y1, pixel);
            // }
          }

        }


      }
      if (k == 4) {

        for (; x < width; x++) {

          int y1 = y;
          for (; y1 < rowcondtion; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(0, 0, 255);
            image.setPixel(x, y1, pixel);
            // }
          }

        }


      }
      if (k == 5) {

        for (; x < width; x++) {

          int y1 = y;
          for (; y1 < rowcondtion; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(46, 43, 95);
            image.setPixel(x, y1, pixel);
            // }
          }

        }


      }
      if (k == 6) {

        for (; x < width; x++) {

          int y1 = y;
          for (; y1 < rowcondtion; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(139, 0, 255);
            image.setPixel(x, y1, pixel);
            // }
          }

        }


      }

      x = 0;

    }
    ImageFileWriter imageFileWriter = new ImageFileWriter("rainbownormal.png");
    imageFileWriter.writeImage(image);
     width = 350;
     height = 400;
     squares = 64;
     rows = 0;
     int userdefinedwidth=50;
     image = new SimpleImage(height, width);
    for (int k = 0; k < 7; k++) {
      int y = 0;
      int rowcondtion = userdefinedwidth;
      for (int l = 0; l < k; l++) {
        y += userdefinedwidth;
        rowcondtion += userdefinedwidth;
      }
      int x = 0;

      if (k  == 0) {

        for (; y < rowcondtion; y++) {

          int y1 = 0;
          for (; y1 < height; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(255, 0, 0);
            image.setPixel(y, y1, pixel);
            // }
          }

        }


      }
      if (k == 1) {

        for (; y < rowcondtion; y++) {

          int y1 = 0;
          for (; y1 < height; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(255, 127, 0);
            image.setPixel(y, y1, pixel);
            // }
          }

        }


      }
      if (k  == 2) {

        for (; y < rowcondtion; y++) {

          int y1 = 0;
          for (; y1 < height; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(255, 255, 0);
            image.setPixel(y, y1, pixel);
            // }
          }

        }


      }
      if (k == 3) {

        for (; y < rowcondtion; y++) {

          int y1 = 0;
          for (; y1 < height; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(0, 255, 0);
            image.setPixel(y, y1, pixel);
            // }
          }

        }


      }
      if (k == 4) {

        for (; y < rowcondtion; y++) {

          int y1 = 0;
          for (; y1 < height; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(0, 0, 255);
            image.setPixel(y, y1, pixel);
            // }
          }

        }


      }
      if (k == 5) {

        for (; y < rowcondtion; y++) {

          int y1 = 0;
          for (; y1 < height; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(46, 43, 95);
            image.setPixel(y, y1, pixel);
            // }
          }

        }


      }
      if (k == 6) {

        for (; y < rowcondtion; y++) {

          int y1 = 0;
          for (; y1 < height; y1++) {
            //if (i % 2 == 0) {
            System.out.println(k + " " + x + " " + y1);
            Pixel pixel = new SimplePixel(139, 0, 255);
            image.setPixel(y, y1, pixel);
            // }
          }

        }


      }

      x = 0;

    }
     imageFileWriter = new ImageFileWriter("rainbownormalvertical.png");
    imageFileWriter.writeImage(image);
  }

}
