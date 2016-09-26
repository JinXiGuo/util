package cn.kingbob.test;

import java.io.File;

import cn.kingbob.util.IOUtil;

public class IOUtilTest {
	public static void main(String[] args) {
		IOUtil ioUtil=new IOUtil();
		ioUtil.copyByChannel(new File("d:/天行vpn/天行vpn.exe"), new File("e:/Buffered"));
	}
}
