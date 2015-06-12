package rest.util;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class ZipUtil {

	/**
	 * ���ѹ������
	 * 
	 * @return ����ѹ���������
	 * @throws IOException
	 */
	public static byte[] compress(byte[] rawData) throws IOException {
		ByteArrayInputStream bis = new ByteArrayInputStream(rawData);
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		if (bis != null) {
			byte[] buff = new byte[500]; // ����һ��500�ֽڵĻ�����
			DeflaterOutputStream gzout = new DeflaterOutputStream(
					arrayOutputStream); // ���ѹ������
			int len = 0;
			while ((len = bis.read(buff)) != -1) {
				gzout.write(buff, 0, len);
			}
			gzout.finish();
			gzout.close();
		}
		return arrayOutputStream.toByteArray();
	}

	/**
	 * ��ݽ�ѹ������
	 * 
	 * @return ���ؽ�ѹ���������
	 * @throws IOException
	 */
	public static byte[] decompress(byte[] ripeData) throws IOException {
		if (ripeData != null) {
			int len = 0;
			byte[] buff = new byte[500];
			ByteArrayInputStream bin = new ByteArrayInputStream(ripeData);
			ripeData = null;
			InflaterInputStream gzipInput = new InflaterInputStream(bin);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			while ((len = gzipInput.read(buff)) != -1) {
				out.write(buff, 0, len);
			}
			out.flush();
			out.close();
			gzipInput.close();
			return out.toByteArray();
		}
		return ripeData;

	}

	/**
	 * ��ݽ�ѹ������
	 * 
	 * @return ���ؽ�ѹ���������
	 * @throws IOException
	 */
	public static final byte[] decompress(InputStream is, int streamLength) throws IOException {
		byte[] bufOut=new byte[streamLength];
		int offset = 0, readed = 0;
		while ((readed = is.read(bufOut, offset,streamLength - offset)) != -1) {
			offset += readed;
		}

		return decompress(bufOut);
	}

	/**
	 * �ļ���ѹ��(δʵ��)
	 * 
	 * @param strRipeFile
	 * @param strRawFile
	 * @param nFlag
	 * @param strPwd
	 * @return
	 */
	public boolean decompressFile(String strRipeFile, String strRawFile,
			int nFlag, String strPwd) {
		return false;
	}

	/**
	 * �ļ�ѹ��(δʵ��)
	 * 
	 * @param strRawFile
	 * @param strRipeFile
	 * @param nFlag
	 * @param strPwd
	 * @return
	 */
	public boolean compressFile(String strRawFile, String strRipeFile,
			int nFlag, String strPwd) {
		return false;
	}

	public static void main(String[] args) {
		byte[] buffer;
		try {
			buffer = compress("�й��ˣ�".getBytes());
			// System.out.println("Server: " + buffer);
			System.out.println("after decompress = " + new String(decompress(buffer)));
		} catch (Exception e) {

			System.out.println(e);

		}
	}

}
