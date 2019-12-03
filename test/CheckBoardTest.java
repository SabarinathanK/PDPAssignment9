import io.ImageFileWriter;
import java.io.IOException;
import java.util.Map;
import util.Image;
import util.Pixel;
import util.impl.SimpleImage;
import util.impl.SimplePixel;

public class CheckBoardTest {

  public static void main(String[] args) throws IOException {
    int width = 10;
    int height = 10;
    int squaresize = 4;

    if (Math.sqrt(squaresize) - Math.floor(Math.sqrt(squaresize)) == 0) {
      int squares = (width * height) / squaresize;


      int rows = 0;
      Image image = new SimpleImage(width, height);
/*
   if (squares % 8 == 0) {
      rows =  (int) Math.sqrt(squares);;

      for (int k = 0; k < rows; k++) {
        int y = 0;
        int rowcondtion = height / rows;
        for (int l = 0; l < k; l++) {
          y += height / rows;
          rowcondtion += height / rows;
        }
        int x = 0;
        int condition = (int) Math.sqrt(squares);
        if (k % 2 == 0) {
          for (int i = 0; i < (int) Math.sqrt(squares); i++) {

            for (; x < condition; x++) {

              int y1 = y;
              for (; y1 < rowcondtion; y1++) {
                if (i % 2 == 0) {
                  System.out.println(k + " " + x + " " + y1);
                  Pixel pixel = new SimplePixel(255, 255, 255);
                  image.setPixel(x, y1, pixel);
                }
              }

            }

            condition += width / 8;
          }
        } else {
          for (int i = 0; i < 3; i++) {

            for (; x < condition; x++) {

              int y1 = y;
              for (; y1 < rowcondtion; y1++) {
                if (i % 2 != 0) {
                  System.out.println(k + " " + x + " " + y1);
                  Pixel pixel = new SimplePixel(255, 255, 255);
                  image.setPixel(x, y1, pixel);
                }
              }

            }

            condition += width / 8;
          }
        }
        x = 0;
        condition = width / 8;

      }

    }*/

      rows = (int) Math.sqrt(squares);
      int columns = (int) Math.sqrt(squares);

      int x = (int) Math.sqrt(squaresize);
      int y = (int) Math.sqrt(squaresize);
      int condition = x;

      int x1 = 0;

      for (int j = 0; j <=columns; j++) {
        int y1 = 0;
        int rowcondition = x;
        int b=0;
        for (int k = 0; k < j; k++) {
          y1 += x;
          rowcondition += x;
        }
        if (j % 2 == 0) {
          for (int i = 0; i < rows; i++) {

            for (; x1 < condition; x1++) {
              int y2 = y1;
if(j<columns){
              for (; y2 < rowcondition; y2++) {
                if (i % 2 == 0) {
                  System.out.println(j + " " + x1 + " " + y2);
                  Pixel pixel = new SimplePixel(255, 255, 255);
                  image.setPixel(x1, y2, pixel);

                }


              }
            }
else if(j==columns)
{
  for (; y2 <height; y2++) {
    if (i % 2 != 0) {
      System.out.println(j + "filling y " + x1 + " " + y2);
      Pixel pixel = new SimplePixel(255, 255, 255);
      image.setPixel(x1, y2, pixel);
    }
  }
  y2=0;
}
              y2 = 0;
            }


            condition += x;
            b=i;
          }
          while(x1<width) {
            int y2 = y1;
            if (j <columns){
              for (; y2 < rowcondition; y2++) {

                if (b % 2 == 0) {
                  System.out.println(j + "filling up extra space " + x1 + " " + y2);
                  Pixel pixel = new SimplePixel(255, 255, 255);
                  image.setPixel(x1, y2, pixel);

                }


              }
          }
            else if(j==columns)
            {
              for (; y2 <height; y2++) {
                if (b % 2 != 0) {
                  System.out.println(j + "filling y " + x1 + " " + y2);
                  Pixel pixel = new SimplePixel(255, 255, 255);
                  image.setPixel(x1, y2, pixel);
                }
              }
              y2=0;
            }
            x1++;
          }
          x1 = 0;
          condition = x;
        } else {
          for (int i = 0; i < rows; i++) {

            for (; x1 < condition; x1++) {
              int y2 = y1;
              if(j<columns){
              for (; y2 < rowcondition; y2++) {
                if (i % 2 != 0) {
                  System.out.println(j + " " + x1 + " " + y2);
                  Pixel pixel = new SimplePixel(255, 255, 255);
                  image.setPixel(x1, y2, pixel);
                }
              }
              }
              else if(j==columns)
              {
                for (; y2 <height; y2++) {
                  if (i % 2 != 0) {
                    System.out.println(j + "filling y " + x1 + " " + y2);
                    Pixel pixel = new SimplePixel(255, 255, 255);
                    image.setPixel(x1, y2, pixel);
                  }
                }
                y2=0;
              }

              y2 = 0;
            }
            b=i;
            condition += x;
          }
          while(x1<width) {
            int y2 = y1;
            if (j <columns){
              for (; y2 < rowcondition; y2++) {
                if (b % 2 != 0) {
                  System.out.println(j + "filling up extra space " + x1 + " " + y2);
                  Pixel pixel = new SimplePixel(255, 255, 255);
                  image.setPixel(x1, y2, pixel);

                }


              }
          }
            else if(j==columns)
            {
              for (; y2 <height; y2++) {
                if (b % 2 != 0) {
                  System.out.println(j + "filling y " + x1 + " " + y2);
                  Pixel pixel = new SimplePixel(255, 255, 255);
                  image.setPixel(x1, y2, pixel);
                }
              }
              y2=0;
            }
            x1++;
          }
          x1 = 0;
          condition = x;
        }
      }

      ImageFileWriter imageFileWriter = new ImageFileWriter("test.png");
      imageFileWriter.writeImage(image);
    }
    else
    {
      System.out.println("Sqaure size is not valid");
    }
  }
  }

