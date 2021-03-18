package com.ruoyi.common.utils;

import java.util.Random;

/**
 * @Title: RandomUtils.java
 * @Description: 随机数工具类
 * @Author M.Mu
 * @Date 2020-12-11
 */
public class RandomUtils {

	private static final String ALL_CHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String LETTER_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String NUMBER_CHAR = "0123456789";

	/**
	 * @Title: RandomUtils.java
	 * @Description: 获取定长的随机数，包含大小写、数字
	 * @Author M.Mu
	 * @Date 2020-12-11
	 */
	public static String generateString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(ALL_CHAR.charAt(random.nextInt(ALL_CHAR.length())));
		}
		return sb.toString();
	}

	/**
	 * @Title: RandomUtils.java
	 * @Description: 获取定长的随机数,包含大小写字母
	 * @Author M.Mu
	 * @Date 2020-12-11
	 */
	public static String generateMixString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(LETTER_CHAR.charAt(random.nextInt(LETTER_CHAR.length())));
		}
		return sb.toString();
	}

	/**
	 * @Title: RandomUtils.java
	 * @Description: 获取定长的随机数，只包含小写字母
	 * @Author M.Mu
	 * @Date 2020-12-11
	 */
	public static String generateLowerString(int length) {
		return generateMixString(length).toLowerCase();
	}

	/**
	 * @Title: RandomUtils.java
	 * @Description: 获取定长的随机数,只包含大写字母
	 * @Author M.Mu
	 * @Date 2020-12-11
	 */
	public static String generateUpperString(int length) {
		return generateMixString(length).toUpperCase();
	}

	/**
	 * @Title: RandomUtils.java
	 * @Description: 获取定长的随机数,只包含数字
	 * @Author M.Mu
	 * @Date 2020-12-11
	 */
	public static String generateNumberString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(NUMBER_CHAR.charAt(random.nextInt(NUMBER_CHAR.length())));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println("***********Test******************");
		System.out.println("大小写数字:" + generateString(10));
		System.out.println("大小写字母:" + generateMixString(10));
		System.out.println("小写字母:" + generateLowerString(10));
		System.out.println("大写字母:" + generateUpperString(10));
		System.out.println("纯数字:" + generateNumberString(10));
		System.out.println("***********Test******************");
	}
}