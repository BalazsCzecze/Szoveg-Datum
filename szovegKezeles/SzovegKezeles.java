package szovegKezeles;

public class SzovegKezeles {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Sz�veg - karakterekb�l �ll� t�mb
		char[] karakterTomb = {'j','a','v','a','I','s','C','o','o','l'};
		String javaStr = new String(karakterTomb);
		System.out.println(javaStr);

		//ugyanaz, mintha
		String javaStr2 = "javaIsCool";
		System.out.println(javaStr2);
		
		// String l�trehoz�sakor a JVM ellen�rzi a string constant poolt. 
		// Ha m�r van ilyen tartalommal l�v� sz�veg, akkor nem hozza �jra l�tre.
		// Ugyanarra a referenci�ra mutat.
		
		String name1 = "John";
		String name2 = "John";
		System.out.print("Name - John ellen�rz�s: ");
		System.out.println(name1 == name2); //true
		System.out.println("hashcode - name1: "+name1.hashCode());
		System.out.println("hashcode - name2: "+name2.hashCode());
		
		String gyumolcsnev = "alma";
		String gyumolcsnev2 = "alma";
		
		//hashk�dokat hasonl�tott �ssze, azonos tartalom miatt a string constant pool-ban nem
		// hozta l�tre �ja, hanem ugyanaz a referencia c�me
		if (gyumolcsnev == "alma") {
			System.out.println("A megadott gy�m�lcsn�v alma volt...");
		} else {
			System.out.println("A megadott gy�m�lcsn�v NEM az alma volt...");
		}
		
		gyumolcsnev2 = "k�rte";
		System.out.println(gyumolcsnev+ " hashk�d: "+gyumolcsnev.hashCode());
		System.out.println(gyumolcsnev2 + " hashk�d: "+gyumolcsnev2.hashCode());
		
		String kerNev1 = "John";
		String kerNev2 = "john";
		System.out.println("Kereszt n�v:"+(kerNev1.toLowerCase()==kerNev2)); //false, mert m�s a hashk�dja

		//Helyes ellen�rz�s, ami nem a hashk�dot hasonl�tja �ssze
		if (kerNev1.toLowerCase().equals(kerNev2)) {
			System.out.println("K�t keresztn�v megegyezik!!!");
		} else {
			System.out.println("K�t keresztn�v NEM egyezik meg!!!");
		}
		
		String firstName1 = new String("Jane"); //k�l�n referenciac�m
		String firstName2 = new String("Jane");
		System.out.println("firstName1 hashk�dja: "+firstName1.hashCode()); //2301262
		System.out.println("firstName1 hashk�dja: "+firstName2.hashCode()); //2301262
		System.out.println("firstName ellen�rz�s - hashCode: "+firstName1==firstName2); //false
		
		// == referencia c�m ellen�rz�s
		
		//Meghat�rozott indexen l�v� karakter lek�rdez�se
		String cityName = "New York";
		System.out.println("2. karakter a v�rosn�vben: "+cityName.charAt(1));
		//System.out.println(cityName[1]);
		
		//sz�veg hossz lek�rdez�s
		System.out.println("cityName hossza: "+cityName.length());
		
		//form�zott sz�veg l�trehoz�sa
		String piErteke = String.format("%.3f%n", Math.PI);
		System.out.println("Pi �rt�ke form�zottan: "+piErteke);
		
		//r�szstring k�pz�s
		String meal = "k�poszt�st�szta";
		String subMeal = meal.substring(9); 
		System.out.println(subMeal);//t�szta
		System.out.println(meal.substring(10, 13)); //�sz
		//System.out.println(meal.substring(3, 2)); //StringIndexOutOfBoundsException
		//System.out.println(meal.substring(3, 3)); Hib�t nem �r, csak nem �r ki semmit.
		
		
		//tartalmaz�s vizsg�lat - contains - logikai t�pussal t�r vissza
		System.out.println("Tartalmaz�s vizsg�lat - contains");
		String animal = "l�dar�zs";
		System.out.println(animal.contains("l�")); //true
		System.out.println(animal.contains("L�")); //false
		//caseSensitive - kisbet�/nagybet� �rz�keny
		
		if (animal.contains("l�")) {
			System.out.println("Tartalmazza a megadott sz�t!!!");
		} else {
			System.out.println("Nem tartalmazza a megadott sz�t!!!");
		}
		
		Boolean vizsgalat = animal.contains("L�");
		System.out.println(vizsgalat);
		
		//egyenl�s�gvizsg�lat - equals -logikai t�pussal t�r vissza
		String auto = "BMW";
		if (auto.equals("bmw")) {
			System.out.println("A k�t sz� megegyezik!!!");
		} else {
			System.out.println("A k�t sz� nem egyezik meg!!!");
		}
		
		System.out.print("equalsIgnoreCase: ");
		String text = "JavaJob";
		System.out.println(text.equalsIgnoreCase("javaJob"));
		
		//Kisbet�ss� / nagybet�ss� alak�t�s
		
		String zoldsegNev = "karaL�b�";
		System.out.println(zoldsegNev.toLowerCase());
		System.out.println(zoldsegNev); //karaL�b�
		
		String zoldsegNevKisbetusen = zoldsegNev.toLowerCase();
		System.out.println(zoldsegNevKisbetusen); //karal�b�
		
		String gyumolcsNev = "szilva";
		gyumolcsNev = gyumolcsNev.toUpperCase();
		System.out.println(gyumolcsNev);
		
		//trim - felesleges sz�k�z �s tabul�tor elt�vol�t�sa v�g�r�l elej�r�l
		String cegNev = "   Apple     Co.    ";
		cegNev = cegNev.trim();
		System.out.println(cegNev);
		
		//replace - r�szstring param�terrel - minden el�fordul�s�t kicser�li
		String szoveg = "2020 - Copyright - 2020 year";
		szoveg = szoveg.replace("2020", "2021");
		System.out.println(szoveg);
		
		String teruletStr = "4,15";
		teruletStr = teruletStr.replace(',', '.');
		Double teruletDouble = Double.parseDouble(teruletStr);
		//Double teruletDouble = Double.parseDouble(teruletStr.replace(',', '.'));
		System.out.println(teruletDouble);
		
		//replaceFirst - els� elfordul�s�t cser�li csak ki
		String szoveg2 = "2020 - Copyright - 2020 year";
		szoveg2 = szoveg2.replaceFirst("2020", "2021");
		System.out.println(szoveg2);
		
		//replaceAll - minden el�fordul�s�t kicser�li, de regexet v�r els� param�ternek
		String szoveg3 = "2020 - Copyright - 2020 year";
		szoveg3 = szoveg3.replaceAll("2020","2021");
		System.out.println(szoveg3);
		
		System.out.print("isEmpty vizsg�lat: ");
		String uresStr = " ";
		System.out.println(uresStr.isEmpty()); //false
		
		System.out.println(uresStr.isBlank()); //true
		
		System.out.println("valueOf");
		System.out.println(String.valueOf(2)); //"2" �talak�tja ilyen stringg�
		
		//indexOf() - a param�ter el� el�fordul�s�t tal�lja
		System.out.print("indexOf(): ");
		String szovegTeszt = "Java is great, java is awesome...";
		System.out.println(szovegTeszt.indexOf("is")); //5
		
		//6-os indext�l kezdi el vizsg�lni
		System.out.println(szovegTeszt.indexOf("is",6));
		
		//split()-- sz�veg darabol�sra elv�laszt� karakter ment�n
		
		String szovegDarabol = "Java is the best!!!";
		String[] adatok = szovegDarabol.split(" ");
		System.out.println(adatok[1]); //is
		for (String item : adatok) {
			System.out.println(item + "");
		}
		
		String datum = "2021-09-01";
		String[] datumAdatok= datum.split("-");
		System.out.println("�v: "+datumAdatok[0]);
		System.out.println("H�nap: "+datumAdatok[1]);
		System.out.println("Nap: "+datumAdatok[2]);
		
		//join() - �sszf�z�s (split ellent�te) elv�laszt� karakterrel
		
		String etel1 = "alm�s";
		String etel2 = "r�tes";
		String etelEgyben = String.join("-", etel1, etel2);
		System.out.println(etelEgyben);
		
	}

}
