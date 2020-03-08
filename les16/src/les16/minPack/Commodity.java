package les16.minPack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Commodity implements Comparable<Commodity> {
	private String title;
	private int length;
	private int width;
	private int weight;
	
	public Commodity() {}

	public Commodity(String title, int length, int width, int weight) {
		this.title = title;
		this.setLength(length);
		this.setWidth(width);
		this.setWeight(weight);
	}
	
	private void test() {
		System.out.println("For reflection");
	}
	
	public static void addCommodity(Collection<Commodity> coll, Commodity com) {
		coll.add(com);
	}
	
	public static void removeCommodity(Collection<Commodity> coll, String title) {
		Iterator<Commodity> it = coll.iterator();
		Commodity com = null;
		while (it.hasNext()) {
			com = it.next();
			if (title.equalsIgnoreCase(com.title)) {
				it.remove();
				break;
			}
		}
	}
	
	public static Collection<Commodity> replaceCommodity(Collection<Commodity> coll, String title, Commodity newCom) {
		ArrayList<Commodity> arrList = new ArrayList<Commodity>();
		arrList.addAll(coll);
		ListIterator<Commodity> it = arrList.listIterator();
		while (it.hasNext()) {
			Commodity temp = it.next();
			if (temp.title.equalsIgnoreCase(title))
				it.set(newCom);
		}
		coll = arrList;
		return coll;
	}
	
	public static void sortByTitle(Collection<Commodity> coll) {
		Collections.sort((List<Commodity>) coll);
	}
	
	public static void showElement(Collection<Commodity> coll, int i) {
		ArrayList<Commodity> arr = new ArrayList<Commodity>();
		arr.addAll(coll);
		System.out.println(arr.get(i));
	}
	
	public static void exit() {
		System.exit(0);
	}

	@Override
	public int compareTo(Commodity o) {
		return title.compareToIgnoreCase(o.title);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Commodity [title=" + title + ", length=" + length + ", width=" + width + ", weight=" + weight + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
