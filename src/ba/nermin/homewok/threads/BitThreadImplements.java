package ba.nermin.homewok.threads;
import java.io.IOException;
import java.net.MalformedURLException;

import ba.nermin.homework.utils.Crawler;

//import com.bitcamp.threads.utils.Crawler;
public class BitThreadImplements implements Runnable {
	private String name;
	private String url;

	public BitThreadImplements(String name, String url) {
		this.name = name;
		this.url = url;
	}

	public void run() {
		try {
			@SuppressWarnings("unused")
			Crawler crawler = new Crawler(url, name);
			Crawler.pagesCrawled++;
			System.out.println("NUM_OF_CRAWLS_DONE: "
					+ new Integer(Crawler.pagesCrawled).toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Hello from a thread that implements Runnable: "
				+ name);
		System.out
				.println("------------------------------------------------------------");
	}
}