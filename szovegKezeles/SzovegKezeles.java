package szovegKezeles;

public class SzovegKezeles {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Szöveg - karakterekbõl álló tömb
		char[] karakterTomb = {'j','a','v','a','I','s','C','o','o','l'};
		String javaStr = new String(karakterTomb);
		System.out.println(javaStr);

		//ugyanaz, mintha
		String javaStr2 = "javaIsCool";
		System.out.println(javaStr2);
		
		// String létrehozásakor a JVM ellenõrzi a string constant poolt. 
		// Ha már van ilyen tartalommal lévõ szöveg, akkor nem hozza újra létre.
		// Ugyanarra a referenciára mutat.
		
		String name1 = "John";
		String name2 = "John";
		System.out.print("Name - John ellenõrzés: ");
		System.out.println(name1 == name2); //true
		System.out.println("hashcode - name1: "+name1.hashCode());
		System.out.println("hashcode - name2: "+name2.hashCode());
		
		String gyumolcsnev = "alma";
		String gyumolcsnev2 = "alma";
		
		//hashkódokat hasonlított össze, azonos tartalom miatt a string constant pool-ban nem
		// hozta létre úja, hanem ugyanaz a referencia címe
		if (gyumolcsnev == "alma") {
			System.out.println("A megadott gyümölcsnév alma volt...");
		} else {
			System.out.println("A megadott gyümölcsnév NEM az alma volt...");
		}
		
		gyumolcsnev2 = "körte";
		System.out.println(gyumolcsnev+ " hashkód: "+gyumolcsnev.hashCode());
		System.out.println(gyumolcsnev2 + " hashkód: "+gyumolcsnev2.hashCode());
		
		String kerNev1 = "John";
		String kerNev2 = "john";
		System.out.println("Kereszt név:"+(kerNev1.toLowerCase()==kerNev2)); //false, mert más a hashkódja

		//Helyes ellenõrzés, ami nem a hashkódot hasonlítja össze
		if (kerNev1.toLowerCase().equals(kerNev2)) {
			System.out.println("Két keresztnév megegyezik!!!");
		} else {
			System.out.println("Két keresztnév NEM egyezik meg!!!");
		}
		
		String firstName1 = new String("Jane"); //külön referenciacím
		String firstName2 = new String("Jane");
		System.out.println("firstName1 hashkódja: "+firstName1.hashCode()); //2301262
		System.out.println("firstName1 hashkódja: "+firstName2.hashCode()); //2301262
		System.out.println("firstName ellenõrzés - hashCode: "+firstName1==firstName2); //false
		
		// == referencia cím ellenõrzés
		
		//Meghatározott indexen lévõ karakter lekérdezése
		String cityName = "New York";
		System.out.println("2. karakter a városnévben: "+cityName.charAt(1));
		//System.out.println(cityName[1]);
		
		//szöveg hossz lekérdezés
		System.out.println("cityName hossza: "+cityName.length());
		
		//formázott szöveg létrehozása
		String piErteke = String.format("%.3f%n", Math.PI);
		System.out.println("Pi értéke formázottan: "+piErteke);
		
		//részstring képzés
		String meal = "káposztástészta";
		String subMeal = meal.substring(9); 
		System.out.println(subMeal);//tészta
		System.out.println(meal.substring(10, 13)); //ész
		//System.out.println(meal.substring(3, 2)); //StringIndexOutOfBoundsException
		//System.out.println(meal.substring(3, 3)); Hibát nem ír, csak nem ír ki semmit.
		
		
		//tartalmazás vizsgálat - contains - logikai típussal tér vissza
		System.out.println("Tartalmazás vizsgálat - contains");
		String animal = "lódarázs";
		System.out.println(animal.contains("ló")); //true
		System.out.println(animal.contains("Ló")); //false
		//caseSensitive - kisbetû/nagybetû érzékeny
		
		if (animal.contains("ló")) {
			System.out.println("Tartalmazza a megadott szót!!!");
		} else {
			System.out.println("Nem tartalmazza a megadott szót!!!");
		}
		
		Boolean vizsgalat = animal.contains("Ló");
		System.out.println(vizsgalat);
		
		//egyenlõségvizsgálat - equals -logikai típussal tér vissza
		String auto = "BMW";
		if (auto.equals("bmw")) {
			System.out.println("A két szó megegyezik!!!");
		} else {
			System.out.println("A két szó nem egyezik meg!!!");
		}
		
		System.out.print("equalsIgnoreCase: ");
		String text = "JavaJob";
		System.out.println(text.equalsIgnoreCase("javaJob"));
		
		//Kisbetûssé / nagybetûssé alakítás
		
		String zoldsegNev = "karaLábÉ";
		System.out.println(zoldsegNev.toLowerCase());
		System.out.println(zoldsegNev); //karaLábÉ
		
		String zoldsegNevKisbetusen = zoldsegNev.toLowerCase();
		System.out.println(zoldsegNevKisbetusen); //karalábé
		
		String gyumolcsNev = "szilva";
		gyumolcsNev = gyumolcsNev.toUpperCase();
		System.out.println(gyumolcsNev);
		
		//trim - felesleges szóköz és tabulátor eltávolítása végérõl elejérõl
		String cegNev = "   Apple     Co.    ";
		cegNev = cegNev.trim();
		System.out.println(cegNev);
		
		//replace - részstring paraméterrel - minden elõfordulását kicseréli
		String szoveg = "2020 - Copyright - 2020 year";
		szoveg = szoveg.replace("2020", "2021");
		System.out.println(szoveg);
		
		String teruletStr = "4,15";
		teruletStr = teruletStr.replace(',', '.');
		Double teruletDouble = Double.parseDouble(teruletStr);
		//Double teruletDouble = Double.parseDouble(teruletStr.replace(',', '.'));
		System.out.println(teruletDouble);
		
		//replaceFirst - elsõ elfordulását cseréli csak ki
		String szoveg2 = "2020 - Copyright - 2020 year";
		szoveg2 = szoveg2.replaceFirst("2020", "2021");
		System.out.println(szoveg2);
		
		//replaceAll - minden elõfordulását kicseréli, de regexet vár elsõ paraméternek
		String szoveg3 = "2020 - Copyright - 2020 year";
		szoveg3 = szoveg3.replaceAll("2020","2021");
		System.out.println(szoveg3);
		
		System.out.print("isEmpty vizsgálat: ");
		String uresStr = " ";
		System.out.println(uresStr.isEmpty()); //false
		
		System.out.println(uresStr.isBlank()); //true
		
		System.out.println("valueOf");
		System.out.println(String.valueOf(2)); //"2" átalakítja ilyen stringgé
		
		//indexOf() - a paraméter elõ elõfordulását találja
		System.out.print("indexOf(): ");
		String szovegTeszt = "Java is great, java is awesome...";
		System.out.println(szovegTeszt.indexOf("is")); //5
		
		//6-os indextõl kezdi el vizsgálni
		System.out.println(szovegTeszt.indexOf("is",6));
		
		//split()-- szöveg darabolásra elválasztó karakter mentén
		
		String szovegDarabol = "Java is the best!!!";
		String[] adatok = szovegDarabol.split(" ");
		System.out.println(adatok[1]); //is
		for (String item : adatok) {
			System.out.println(item + "");
		}
		
		String datum = "2021-09-01";
		String[] datumAdatok= datum.split("-");
		System.out.println("Év: "+datumAdatok[0]);
		System.out.println("Hónap: "+datumAdatok[1]);
		System.out.println("Nap: "+datumAdatok[2]);
		
		//join() - összfûzés (split ellentéte) elválasztó karakterrel
		
		String etel1 = "almás";
		String etel2 = "rétes";
		String etelEgyben = String.join("-", etel1, etel2);
		System.out.println(etelEgyben);
		
	}

}
