package com.qq986945193.javasetools.demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.qq986945193.javasetools.constant.Api;
import com.qq986945193.javasetools.utils.BufferedImageLuminanceSource;
import com.qq986945193.javasetools.utils.MatrixToImageWriter;

public class QRCode {
	public static void main(String[] args) {
//		encodeQrcode();
		decodeQrcode();

	}

	/**
	 * 将文字生成二维码
	 */
	private static void encodeQrcode() {
		int height = 300;
		int width = 300;
		String format = "png";
		String url = Api.CSDN_BLOG_DAVID;
		// 定义二维码的参数
		HashMap h = new HashMap();
		h.put(EncodeHintType.CHARACTER_SET, "utf-8");// 字符集
		h.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);// 纠错等级
		h.put(EncodeHintType.MARGIN, 2);// 图片的边距
		// 生成二维码
		try {
			/*
			 * BarcodeFormat.QR_CODE 二维码的的格式
			 */
			BitMatrix bitMatrix = new MultiFormatWriter().encode(url, BarcodeFormat.QR_CODE, width, height, h);
			// Path file = new File("E:/img.png").toPath();// 生成图片路径
			File file = new File("E:/IMG.PNG");
			MatrixToImageWriter.writeToFile(bitMatrix, format, file);
			System.out.println("生成成功");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("生成失败");
			
		}
	}

	/**
	 * 将二维码解析为文字
	 */
	private static void decodeQrcode() {
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File("E:/IMG.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();
		hints.put(DecodeHintType.CHARACTER_SET, "GBK");
		Result result = null;
		try {
			result = new MultiFormatReader().decode(bitmap, hints);
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(result.toString());
	}

}
