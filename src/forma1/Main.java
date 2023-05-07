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
		
		new FileHandling().readFile("pilotak.csv ", ";", pilotak);
		System.out.print("3. feladat: ");
		System.out.println(pilotak.size() );
		System.out.print("4. feladat: ");
		System.out.println(pilotak.get(pilotak.size() - 1).getName());
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
			System.out.println("\t"+pilota.getName() + " ( " + pilota.getBirthDate()+" )");
		}
		System.out.print("6.. feladat");
		int min = 0;
		for (int i = 1; i < pilotak.size(); i++) {
			if (!String.valueOf(pilotak.get(i).getNum()).isEmpty() && pilotak.get(i).getNum() != 0
					&& pilotak.get(i).getNum() < pilotak.get(min).getNum()) {
				min = i;
			}
		}
		System.out.println(pilotak.get(min).getCountry() );
		System.out.print("7. feladat: ");
		Map<Integer,Integer> rajtszamokLista = new HashMap<Integer,Integer>();
		
		for (Pilota pilota : pilotak) {
			if(rajtszamokLista.containsKey(pilota.getNum())) {
				rajtszamokLista.replace(pilota.getNum(), rajtszamokLista.get(pilota.getNum())+1);
			} else {
				rajtszamokLista.put(pilota.getNum(), 1);
			}
		}
		String eredmeny = "";
		for(Map.Entry<Integer, Integer> rajtszam: rajtszamokLista.entrySet()) {
			if(rajtszam.getValue() >1 && rajtszam.getKey()!=0) { // a 0 kizárandó mert ahol nincs érték alapértelmezetten 0 a key
				eredmeny+=rajtszam.getKey()+", ";	
			}
			
		}
		System.out.println(eredmeny.substring(0, eredmeny.length()-2));
		
	}
}
