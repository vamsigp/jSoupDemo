package jSoupDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parser {

	private static String url = "https://play.google.com/store/apps/details?id=com.halfbrick.R5";
	private static String url1 = "https://en.wikipedia.org/wiki/Main_Page";
	private static String openshutterurl = "https://play.google.com/store/apps/details?id=com.play.openshutter";
	private static String charsetVal = "&hl=en";

	private static String fb = "https://play.google.com/store/apps/details?id=com.facebook.katana";
	private static String instagram = "https://play.google.com/store/apps/details?id=com.instagram.android";
	private static String weatherlive = "https://play.google.com/store/apps/details?id=com.apalon.weatherlive";
	private static String heremaps = "https://play.google.com/store/apps/details?id=com.here.app.maps";
	private static String pushups = "https://play.google.com/store/apps/details?id=com.northpark.pushups";
	private static String absWorkout = "https://play.google.com/store/apps/details?id=com.caynax.a6w";
	private static String NA = "https://play.google.com/store/apps/details?id=com.halfbrick.R512";

	private static List<String> printVeryLargeString(String verylargetext,
			int reqChars) {

		List<String> chunks = new ArrayList<String>();

		for (int start = 0; start < verylargetext.length(); start += reqChars) {
			String subString = verylargetext.substring(start,
					Math.min(verylargetext.length(), start + reqChars));
			chunks.add(subString);
			System.out.println(subString);
		}
		return chunks;
	}

	private static void printElements(Elements e) {

		System.out.println("e.size() =" + e.size());

		if (e != null && e.size() > 0) {
			for (int i = 0; i < e.size(); i++) {
				printElement(e.get(i));
			}
		}
	}

	private static void printElement(Element e) {
		printVeryLargeString(e.toString(), 400);
	}

	private static String getGenrefromElement(Element first) {
		String category = "";

		first.getElementsByAttribute("document-subtitle category");

		first.attributes();

		first.tag();

		first.textNodes();

		first.hasClass("document-subtitle category");

		Element b = first.select("a").get(1);

		Elements c = b.getElementsByAttributeValue("class",
				"document-subtitle category");

		Element d = c.first();

		// printElement(d);
		// System.out.println(d.text());
		d.attr("href");
		d.attr("span");
		d.attr("itemprop");

		category = d.text();

		return category;
	}

	public static void main(String[] args) throws IOException {

		Document doc = null;
		try {

			doc = Jsoup.connect(NA + charsetVal).timeout(10000).get();
		} catch (HttpStatusException httpException) {
			httpException.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (doc != null) {
			Elements div = doc.select("div");

			boolean flag = div.hasClass("left-info");

			Elements a2 = doc.getElementsByAttributeValueStarting("class",
					"left-info");

			String category = getGenrefromElement(a2.first());

			System.out.println("category = " + category);
		}

	}

}