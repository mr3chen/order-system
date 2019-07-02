package com.order.system.common.utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.*;

import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 该AES加解密类主要是为了解密营养家微信返回的加密token，不建议做其他使用。
 * 
 * @author huangym3
 * @time 2017年3月20日 下午3:33:00
 */
public class AES {

	/**
	 * 将二进制转换成16进值制 ，防止byte[]数字转换成string类型时造成的数据损失
	 * 
	 * @param buf
	 * @return 返回16进制转换成的string
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 *            16进制的数组转换成String类型再传过来的参数
	 * @return 转换回来的二进制数组
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}

	public static byte[] encrypt2(String content, String password) {
		try {
			byte[] arrBtmp = null;
			arrBtmp = password.getBytes();

			byte[] arrB = new byte[16];

			for (int i = 0; i < arrBtmp.length && i < arrB.length; i++) {
				arrB[i] = arrBtmp[i];
			}

			SecretKeySpec key = new SecretKeySpec(arrB, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
			byte[] byteContent = content.getBytes("utf-8");
			System.out.println(byteContent.length);

			int n = byteContent.length / 16;
			if (n == 0) {
				n = 1;
			} else {
				if ((byteContent.length % 16) != 0) {
					n = n + 1;
				}
			}

			System.out.println(n * 16);

			/* 加密的内容要保持 16 字节对齐, 因此这里要进行相应的调整 */
			byte[] con = new byte[n * 16];
			for (int i = 0; i < byteContent.length && i < con.length; i++) {
				con[i] = byteContent[i];
			}

			cipher.init(Cipher.ENCRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(con);
			return result; // 加密

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static byte[] decrypt(byte[] content, String password) {
		try {
			byte[] arrBtmp = null;
			arrBtmp = password.getBytes();

			byte[] arrB = new byte[16];

			for (int i = 0; i < arrBtmp.length && i < arrB.length; i++) {
				arrB[i] = arrBtmp[i];
			}

			SecretKeySpec key = new SecretKeySpec(arrB, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
			System.out.println(content.length);

			int n = content.length / 16;
			if (n == 0) {
				n = 1;
			} else {
				if ((content.length % 16) != 0) {
					n = n + 1;
				}
			}

			System.out.println(n * 16);

			/* 加密的内容要保持 16 字节对齐, 因此这里要进行相应的调整 */
			byte[] con = new byte[n * 16];
			for (int i = 0; i < content.length && i < con.length; i++) {
				con[i] = content[i];
			}

			cipher.init(Cipher.DECRYPT_MODE, key);// 初始化
			byte[] result = cipher.doFinal(con);
			return result; // 加密

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将字节数组转成String，过滤掉解密后得到的原文后面多余的0
	 * 
	 * @param content
	 * @return
	 */
	public static String parseByte2String(byte[] content) {
		return parseByte2String(content, "utf-8");
	}

	/**
	 * 过滤掉解密后得到的原文后面多余的0
	 * 
	 * @param content
	 * @param charsetName
	 * @return
	 */
	public static String parseByte2String(byte[] content, String charsetName) {
		int i = 0;
		for (byte b : content) {
			if (b == 0) {
				break;
			}
			i++;
		}
		try {
			return new String(content, 0, i, charsetName);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		// String content = "n=nick&u=openid&t=2014-05-22-15-58-30";
		String content = "12323522352352352352352352352352352352352352352352352352352352352352352352352352352";
		String password = "sangforsdfsfsfsdfsdfsdfsdfsdfsdfsfsdfsfsdfwewerwrwerwerwerewsdfsdf";
		// 加密
		System.out.println("加密前：" + content);
		byte[] encryptResult = encrypt2(content, password);
		String encryptResultStr = parseByte2HexStr(encryptResult);
		System.out.println("加密后：" + encryptResultStr);
		System.out.println("解密后：" + new String(decrypt(encryptResult, password), "utf-8"));
		System.out.println(parseByte2String(decrypt(encryptResult, password), "utf-8"));
	}
}
