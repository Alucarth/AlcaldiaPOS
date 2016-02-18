/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipx.util;

import com.sagereal.utils.BMPGenerator;
import com.sagereal.utils.DateUtil;
import com.sagereal.utils.ImageUtil;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Image;

/**
 *
 * @author David
 */
public class BmpArray {
  
    private final static int IMAGE_NORMAL = 0;
	private final static int IMAGE_STRING_ADD = 1;
    int size;

	int BMPDataOffset;
	int BMPHeaderSize;
	int height;
	int width;

	int DataSize;

	int[] RGBQUAD = null;
	byte[] image;
        byte[] image_bytes;
    
    public int ChangeInt(byte[] bi, int start) {
		return ((bi[start] & 0xff) << 24) | ((bi[start - 1] & 0xff) << 16)
				| ((bi[start - 2] & 0xff) << 8) | bi[start - 3] & 0xff;
	}

	/**
	 * a method used to read image from BMP format and return a byte array
	 * 
	 * @param imagePath
	 *            image path
	 * @param typeNum
	 *            (IMAGE_NORMAL for normal/IMAGE_STRING_ADD for adding string)
	 * @return byte[] of image
	 */
       /**
	 * a method used to read image from BMP format and return a byte array
	 * 
	 * @param imagePath
	 *            image path
	 * @param typeNum
	 *            (IMAGE_NORMAL for normal/IMAGE_STRING_ADD for adding string)
	 * @return byte[] of image
	 */
	
        
       public byte[] readImage(byte[] array )
       {
           try{
                        DataInputStream dis = null;
			InputStream aais = null;
			aais = new ByteArrayInputStream(array);
                        dis = new DataInputStream(aais);
                        int bflen = 14;
			byte bf[] = new byte[bflen];
			dis.read(bf, 0, bflen); // ??14??BMP???

			BMPDataOffset = ChangeInt(bf, 13); // BMP??????

			int bilen = 40;
			byte bi[] = new byte[bilen];
			dis.read(bi, 0, bilen);// ??40??BMP???

			// get width and height
			width = ChangeInt(bi, 7); // width of image

			height = ChangeInt(bi, 11); // height of image
			if (width > 384) 
                        {
				throw new Exception("width is beyond the range (<=384)");
			}
			/*
			 * height can be beyond 255 , but if beyond 255 such as 600 the
			 * speed of readImage will be very slow. it is suggested to cut
			 * image in pieces (height<=255)
			 */
			// if (height > 255) {
			// throw new Exception("height is beyond the range(<=255)");

			// }
			/*
			 * bytes array of image "4" for the width(2 bit) and height(2 bit)
			 * to API
			 */
			image_bytes = new byte[4 + width * height / 8];

			// bit depth
			int nbitcount = ((bi[15] & 0xff) << 8) | bi[14] & 0xff;

			// ****begin
			image = new byte[width * height];
			int plate = 0;
			switch (nbitcount) {
			case 1:
				return null;
			case 8:
				// this.mForm.append("1:" +
				// String.valueOf(System.currentTimeMillis()));
				plate = (BMPDataOffset - 54) / 4;
				// System.out.println("BMP plate size is:" + plate);
				DataSize = (size - BMPDataOffset);
				if (plate == 0) {
					// for (int i = height - 1; i >= 0; i--) {
					// for (int j = 0; j < width; j++) {
					// image[i * width + j] = RGBQUAD[(dis.readByte() & 0xff)];
					// }
					// }
				} else {
					RGBQUAD = new int[plate];
					// this.mForm.append("2x:" +
					// String.valueOf(System.currentTimeMillis()));
					for (int i = 0; i < plate; i++)
						RGBQUAD[i] = ((dis.readByte() & 0xff)
								| (dis.readByte() & 0xff) << 8
								| (dis.readByte() & 0xff) << 16 | (dis
								.readByte() & 0xff) << 24);

					int dataArrayLen = width * height;
					byte[] imageData = new byte[dataArrayLen];
					dis.read(imageData, 0, dataArrayLen);
					int nArray = 0;
					// this.mForm.append("2y:" +
					// String.valueOf(System.currentTimeMillis()));
					for (int i = height - 1; i >= 0; i--) {
						for (int j = 0; j < width; j++) {
							/*
							 * because of black and white BMP, "==0" is easy to
							 * judge
							 */
							if (RGBQUAD[imageData[nArray++] & 0xff] == 0) {
								image[i * width + j] = 1; // 1 for print black
															// dot

							} else {
								image[i * width + j] = 0; // 0 for print white
															// dot
							}
						}
					}
					// this.mForm.append("2z:" +
					// String.valueOf(System.currentTimeMillis()));

					/*
					 * image_bytes[0] width low (value = width / 8)( 0 < value
					 * <255) image_bytes[1] width high image_bytes[2] height low
					 * (value = height ) ( 0 < value <255) image_bytes[3] height
					 * high
					 */
					image_bytes[0] = (byte) (width / 8);
					image_bytes[1] = 0;
					if (height > 255) {
						image_bytes[2] = (byte) (height - 255);// (byte) height;
																// // high
						image_bytes[3] = 1; // high
					} else {
						image_bytes[2] = (byte) (height);// (byte) height; //
															// high
						image_bytes[3] = 0; // high
					}
					// this.mForm.append("2:"+
					// String.valueOf(System.currentTimeMillis()));
					/*
					 * 8 bit for one byte to print
					 */
					for (int n = 0; n < width * height / 8; n++) {
						image_bytes[4 + n] = (byte) ((byte) (image[8 * n + 0] & 0x1) << 7
								| (byte) (image[8 * n + 1] & 0x1) << 6
								| (byte) (image[8 * n + 2] & 0x1) << 5
								| (byte) (image[8 * n + 3] & 0x1) << 4
								| (byte) (image[8 * n + 4] & 0x1) << 3
								| (byte) (image[8 * n + 5] & 0x1) << 2
								| (byte) (image[8 * n + 6] & 0x1) << 1 | (byte) (image[8 * n + 7] & 0x1) << 0);
						// System.out.print(image_bytes[8+n]+",");
					}
					return image_bytes;
				}
				break;
			case 24:
				// this.mForm.append("24X:" +
				// String.valueOf(System.currentTimeMillis()));
				int dataArrayLen = width * height * 3;
				byte[] imageData = new byte[dataArrayLen];
				dis.read(imageData, 0, dataArrayLen);
				int nArray = 0;

				for (int i = height - 1; i >= 0; i--) {
					for (int j = 0; j < width; j++) {
						if ((imageData[nArray++] + imageData[nArray++] + imageData[nArray++]) / 3 == 0) 
                                                {
							image[i * width + j] = 1;
						} else {
							image[i * width + j] = 0;
						}
					}
				}
				// this.mForm.append("24Y:" +
				// String.valueOf(System.currentTimeMillis()));
				/*
				 * image_bytes[0] width low (value = width / 8)( 0 < value <255)
				 * image_bytes[1] width high image_bytes[2] height low (value =
				 * height ) ( 0 < value <255) image_bytes[3] height high
				 */
				image_bytes[0] = (byte) (width / 8);
				image_bytes[1] = 0;
				image_bytes[2] = (byte) (height);// (byte) height; // low
				image_bytes[3] = 0; // high
				for (int n = 0; n < width * height / 8; n++) {
					image_bytes[4 + n] = (byte) ((byte) (image[8 * n] & 0x1) << 7
							| (byte) (image[8 * n + 1] & 0x1) << 6
							| (byte) (image[8 * n + 2] & 0x1) << 5
							| (byte) (image[8 * n + 3] & 0x1) << 4
							| (byte) (image[8 * n + 4] & 0x1) << 3
							| (byte) (image[8 * n + 5] & 0x1) << 2
							| (byte) (image[8 * n + 6] & 0x1) << 1 | (byte) (image[8 * n + 7] & 0x1) << 0);
				}
				// this.mForm.append("24Z:"+
				// String.valueOf(System.currentTimeMillis()));
				return image_bytes;
			}
                        } catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
		
       }
}
