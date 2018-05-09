package unit16;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  
  
  public void blur()
  {
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    Pixel downPixel = null;
	    Pixel upPixel = null;
	    Pixel pixelObj = null;
	    Pixel[][] pixels = this.getPixels2D();

	    int avgR = 0;
	    int avgB = 0;
	    int avgG = 0;
	    for (int row = 1; row < pixels.length-1; row++)
	    {
	      for (int col = 1; 
	           col < pixels[0].length-1; col++)
	      {  
    	  pixelObj = pixels[row][col];
    	  
          leftPixel = pixels[row][col-1];
          rightPixel = pixels[row][col+1];
    	  upPixel = pixels[row-1][col];
          downPixel = pixels[row+1][col];
          
          
    	  avgR = leftPixel.getRed() + rightPixel.getRed() + upPixel.getRed() + downPixel.getRed();
    	  avgR = avgR/4;
    	  
    	  avgB = leftPixel.getBlue() + rightPixel.getBlue() + upPixel.getBlue() + downPixel.getBlue();
    	  avgB = avgB/4;
    	  
    	  avgG = leftPixel.getGreen() + rightPixel.getGreen() + upPixel.getGreen() + downPixel.getGreen();
    	  avgG = avgG/4;
    	  
    	  pixelObj.setRed(avgR);
    	  pixelObj.setBlue(avgB);
    	  pixelObj.setGreen(avgG);


      }
    }
  }
  
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void zeroRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
      }
    }
  }
  
  public void zeroGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setGreen(0);
      }
    }
  }
  
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);

      }
    }
  }
  
  public void keepOnlyRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
        pixelObj.setGreen(0);

      }
    }
  }
  
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setGreen(255-pixelObj.getGreen());
        pixelObj.setBlue(255-pixelObj.getBlue());

      }
    }
  }
  
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
    	int avg = pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue();
    	avg = avg/3;
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);

      }
    }
  }
  
  
  
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
    	  if(pixelObj.getBlue() > 175) {
    		  pixelObj.setBlue(255);
    		  pixelObj.setGreen(0);
    		  pixelObj.setRed(150);
    	  }
    	  if(pixelObj.getBlue() < 175) {
    		  pixelObj.setBlue(150);
    		  pixelObj.setGreen(255);
    		  pixelObj.setRed(150);
    	  }
      }
    }
  }
  
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length/2; row++)
    {
      for (int col = 0; col < width; col++)
      {
    	  topPixel = pixels[row][col];
    	bottomPixel = pixels[pixels.length-1-row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length/2; row++)
    {
      for (int col = 0; col < width; col++)
      {
    	  topPixel = pixels[row][col];
    	bottomPixel = pixels[pixels.length-1-row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    } 
  }
  
  public void mirrorDiagonal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels.length; col++)
      {
    	  topPixel = pixels[row][col];
    	bottomPixel = pixels[col][row];
        topPixel.setColor(bottomPixel.getColor());
      }
    } 
  }
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorArms()
  {
    int mirrorPoint = 195;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 155; row < 200; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 104; col < mirrorPoint; col++)
      {
        
    	  topPixel = pixels[row][col];
    	bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        bottomPixel.setColor(topPixel.getColor());
      }

    }
    mirrorPoint = 200;
    int mirrorPoint2 = 296;
    for (int row = 156; row < 205; row++)
    {  
    for (int col = 234; col < mirrorPoint2; col++)
    {
      
  	  topPixel = pixels[row][col];
  	bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
      bottomPixel.setColor(topPixel.getColor());
    }
  }
  }
  
  public void mirrorGull()
  {
    int mirrorPoint = 354;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 221; row < 327; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 210; col < mirrorPoint; col++)
      {
        
          leftPixel = pixels[row][col];      
          rightPixel = pixels[row]                       
                           [mirrorPoint - col + mirrorPoint];
          rightPixel.setColor(leftPixel.getColor());
      }

    }

  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }
  
  public void copy2(Picture fromPic, int startRow, int startCol, int fr, int er, int fc, int ec)
	{
	Pixel fromPixel = null;
	Pixel toPixel = null;
	Pixel[][] toPixels = this.getPixels2D();
	Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = fr, toRow = startRow; fromRow < er && toRow < toPixels.length; fromRow++, toRow++)
		{
			for (int fromCol = fc, toCol = startCol; fromCol < ec &&toCol < toPixels[0].length;   fromCol++, toCol++)
			{
			 fromPixel = fromPixels[fromRow][fromCol];
			 toPixel = toPixels[toRow][toCol];
			 toPixel.setColor(fromPixel.getColor());
			}
		}   
	}

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  public void myCollage()
  {
    Picture pic1 = new Picture("jenny-red.jpg");
    Picture pic2 = new Picture("blue-mark.jpg");
    Picture pic3 = new Picture("barbaraS.jpg");
    this.copy(pic1,0,0);
    this.copy(pic2,100,0);
    this.copy(pic3,200,0);
    Picture flowerNoBlue = new Picture(pic1);
    flowerNoBlue.negate();
    this.copy(flowerNoBlue,300,0);
    this.copy(pic1,400,0);
    this.copy(pic2,500,0);
    this.copy(pic3,600,0);

    Picture picE = new Picture(pic2);
    picE.mirrorDiagonal();
    this.copy(pic1, 200, 200);
    this.copy(pic2, 400, 200);

    this.copy(pic3, 300, 200);

    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel downPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color downColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        downPixel = pixels[row+1][col];
        rightColor = rightPixel.getColor();
        downColor = downPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else if (leftPixel.colorDistance(downColor) > 
        edgeDist)
        leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void edgeDetection2(int edgeDist)
  {
    Pixel midPixel = null;
    Pixel upPixel = null;
    Pixel downPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color upColor = null;
    Color downColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
    	  midPixel = pixels[row][col];
        upPixel = pixels[row-1][col];
        downPixel = pixels[row+1][col];
        upColor = upPixel.getColor();
        downColor = downPixel.getColor();
        if (midPixel.colorDistance(upColor) > 
            edgeDist)
        	midPixel.setColor(Color.BLACK);
        else if (midPixel.colorDistance(downColor) > 
        edgeDist)
        	midPixel.setColor(Color.BLACK);
        else
        	midPixel.setColor(Color.WHITE);
      }
    }
  }
  

  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this