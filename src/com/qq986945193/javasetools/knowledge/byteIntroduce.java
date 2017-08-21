package com.qq986945193.javasetools.knowledge;

import java.io.UnsupportedEncodingException;

public class byteIntroduce {
	
	
	public static void main(String[] args) {
		/**
		 * 高位在前，低位在后
		 */
		byte[] datas = new byte[2];
		datas[0] = (byte)(17070/256)&0xff;
		datas[1] = (byte) ((17070%256)&0xff);
		byte[] b = new byte[2];
		b[0] = (byte) (17070 >> 8 & 0xff);
		b[1] = (byte) (17070 & 0xff);
		System.out.println(datas[0]);
		System.out.println(datas[1]);
		//66  -82
		System.out.println(b[0]);
		System.out.println(b[1]);
		//66  -82
		System.out.println(b[1]);
	}
	/*
	 * 将int转为低字节在前，高字节在后的byte数组
	 *  b[0] = 11111111(0xff) & 01100001 
	 *  b[1]=11111111(0xff) & (n >> 8)00000000 
	 *  b[2] = 11111111(0xff) & (n >>8)00000000 
	 *  b[3] = 11111111(0xff) & (n >> 8)00000000
	 */
	public byte[] IntToByteArray(int n) {
		byte[] b = new byte[4];
		b[0] = (byte) (n & 0xff);
		b[1] = (byte) (n >> 8 & 0xff);
		b[2] = (byte) (n >> 16 & 0xff);
		b[3] = (byte) (n >> 24 & 0xff);
		return b;
	}

	// 将低字节在前转为int，高字节在后的byte数组(与IntToByteArray1想对应)
	public int ByteArrayToInt(byte[] bArr) {
		if (bArr.length != 4) {
			return -1;
		}
		return (int) ((((bArr[3] & 0xff) << 24) | ((bArr[2] & 0xff) << 16) | ((bArr[1] & 0xff) << 8)
				| ((bArr[0] & 0xff) << 0)));
	}

	/*
	 * 将int转为低字节在后，高字节在前的byte数组 
	 * b[0] = 11111111(0xff) & 01100001 
	 * b[1] = 11111111(0xff) & 00000000 
	 * b[2] = 11111111(0xff) & 00000000 
	 * b[3] = 11111111(0xff) & 00000000
	 */
	public byte[] IntToByteArray2(int value) {
		byte[] src = new byte[4];
		src[0] = (byte) ((value >> 24) & 0xFF);
		src[1] = (byte) ((value >> 16) & 0xFF);
		src[2] = (byte) ((value >> 8) & 0xFF);
		src[3] = (byte) (value & 0xFF);
		return src;
	}

	// 将高字节在前转为int，低字节在后的byte数组(与IntToByteArray2想对应)
	public int ByteArrayToInt2(byte[] bArr) {
		if (bArr.length != 4) {
			return -1;
		}
		return (int) ((((bArr[0] & 0xff) << 24) | ((bArr[1] & 0xff) << 16) | ((bArr[2] & 0xff) << 8)
				| ((bArr[3] & 0xff) << 0)));
	}
	
	/**  
     * 将byte数组转化成String,为了支持中文，转化时用GBK编码方式  
     */    
    public String ByteArraytoString(byte[] valArr,int maxLen) {    
        String result=null;    
        int index = 0;    
        while(index < valArr.length && index < maxLen) {    
            if(valArr[index] == 0) {    
                break;    
            }    
            index++;    
        }    
        byte[] temp = new byte[index];    
        System.arraycopy(valArr, 0, temp, 0, index);    
        try {    
            result= new String(temp,"GBK");    
        } catch (UnsupportedEncodingException e) {    
            e.printStackTrace();    
        }    
        return result;    
    }    
    /**  
     * 将String转化为byte,为了支持中文，转化时用GBK编码方式  
     */    
    public byte[] StringToByteArray(String str){    
        byte[] temp = null;    
        try {    
            temp = str.getBytes("GBK");    
        } catch (UnsupportedEncodingException e) {    
            // TODO Auto-generated catch block    
            e.printStackTrace();    
        }    
        return temp;    
    }  
}
