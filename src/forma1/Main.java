package forma1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static List<Pilota> pilotak = new ArrayList<Pilota>();

	public static void main(String[] args) {
		System.out.println("2. feladat");
		new FileHandling().readFile("pilotak.csv ", ";", pilotak);
		System.out.println();
		System.out.println("3. feladat:");
		System.out.println(pilotak.size() + " adat van");
		System.out.println();
		System.out.println("4. feladat:");
		System.out.println(pilotak.get(pilotak.size() - 1).getName());
		System.out.println();
		System.out.println("5. feladat:");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.mm.dd");
		List<Pilota> oregek = new ArrayList<Pilota>();
		for (int i = 0; i < pilotak.size(); i++) {

			try {
				if (sdf.parse(pilotak.get(i).getBirthDate()).before(sdf.parse("1901.01.01"))) {
					oregek.add(pilotak.get(i));
				}

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		for (Pilota pilota : oregek) {
			System.out.println(pilota.getName() + " " + pilota.getBirthDate());
		}
		System.out.println();
		System.out.println("6.. feladat");
		int min = 0;
		for (int i = 1; i < pilotak.size(); i++) {
			if (!String.valueOf(pilotak.get(i).getNum()).isEmpty() && pilotak.get(i).getNum() != 0
					&& pilotak.get(i).getNum() < pilotak.get(min).getNum()) {
				min = i;
			}
		}
		System.out.println(pilotak.get(min).getCountry() + " " + pilotak.get(min).getName());
		System.out.println();
		System.out.println("7. feladat");
		Map<Integer,Integer> rajtszamokLista = new HashMap<Integer,Integer>();
		for (Pilota pilota : pilotak) {
			if(rajtszamokLista.containsKey(pilota.getNum())) {
				rajtszamokLista.replace(pilota.getNum(), rajtszamokLista.get(pilota.getNum())+1);
			} else {
				rajtszamokLista.put(pilota.getNum(), 1);
			}
		}
		for(Map.Entry<Integer, Integer> rajtszam: rajtszamokLista.entrySet()) {
			if(rajtszam.getValue() >1) {
				System.out.print(rajtszam.getKey()+" ");	
			}
			
		}
	}
}
