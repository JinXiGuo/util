package cn.kingbob.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public class IOUtil {

	public void readFile(File file) {
		BufferedReader bf = null;
		try {
			if (file.exists()) {
				bf = new BufferedReader(new FileReader(file));
				String temp = null;
				while ((temp = bf.readLine()) != null) {
					System.out.println(temp);
				}

			} else {
				System.out.println("file not found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (bf != null)
					bf.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean copyByStream(File from, File to) {
		InputStream fis = null;
		OutputStream fos = null;

		boolean result = false;
		try {
			fis = new FileInputStream(from);
			fos = new FileOutputStream(to);
			byte[] b = new byte[1024];
			int bytesRead;
			while ((bytesRead = fis.read(b)) > 0) {
				fos.write(b, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			result = false;
			e.printStackTrace();
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean copyByChannel(File from, File to) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel in = null;
		FileChannel out = null;

		boolean result = false;
		try {
			fis = new FileInputStream(from);
			fos = new FileOutputStream(to);
			in = fis.getChannel();
			out = fos.getChannel();
			in.transferTo(0, in.size(), out);

		} catch (FileNotFoundException e) {
			result = false;
			e.printStackTrace();
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
				in.close();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}

}
