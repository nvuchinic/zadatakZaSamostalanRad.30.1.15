package ba.nermin.homework.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;

public class Crawler {
	private static final int BUFFER_SIZE = 4096;
	private static final String saveFilePath = "/tmp/crawled/";
	public static volatile int pagesCrawled = 0;
	public static volatile File fout;

	public Crawler(String url, String outputFileName) throws IOException {
		getUrlContents(url);
		writeToDiaries(url);
	}

	private static void getUrlContents(String url) throws MalformedURLException {
		int rand = (int) (Math.random() * 100000 + 1);
		String outputFileName = rand + "";
		URL urlObject = new URL(url);
		try {
			URLConnection connection = urlObject.openConnection();
			InputStream in = connection.getInputStream();
			FileOutputStream out = new FileOutputStream(saveFilePath
					+ outputFileName + ".txt");
			int bytesRead = -1;
			byte[] buffer = new byte[BUFFER_SIZE];
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}
			out.close();
			in.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

	private static synchronized void writeToDiaries(String url)
			throws IOException {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss")
				.format(Calendar.getInstance().getTime());
		timeStamp = "[" + timeStamp + "]";
		String visitedUrl = url + "-" + timeStamp;
		fout = new File(
				"D:\\AndroidDevelopment\\JAVA DEVELOPMENT\\zadatakZaSamostalanRad.30.1.15\\Files\\crawling_diaries.txt");
		FileWriter fileWriter = new FileWriter(fout, true);
		BufferedWriter bw = new BufferedWriter(fileWriter);
		try {
			// bw.newLine();
			bw.write(visitedUrl);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
