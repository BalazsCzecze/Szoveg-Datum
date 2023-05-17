package szovegKezeles;



import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;



public class HF_Szoveg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Kérjünk be egy szöveget, majd amennyiben szerepel az elején vagy a végén felesleges szóköz
		//töröljük és írjuk ki, az így kapott szöveget!
		Scanner sc=new Scanner(System.in);
		System.out.println("Kérem adja meg a szöveget!");
		String szoveg=sc.nextLine();
		szoveg=szoveg.trim();
		System.out.println(szoveg);
		System.out.println();
		//Családtagunk meglepett egy kiskutyával, a nevét azonban nem tudjuk eldönteni a következő
		//lehetőségek közül: Borzas, Morzsi, Kefir. Véletlengenerátor segítségével határozzuk meg 
		//az új kiskedvencünk nevét!
		
		String [] kutyaNevek= {"Borzas", "Morzsi", "Kefir"};
		System.out.println("Mi legyen a kutyus neve?");
		Random r=new Random();
		int velszam=r.nextInt((3-1)+1)+1;
		if (velszam==1) {
			System.out.println(kutyaNevek[0]);
		}else if (velszam==2){
			System.out.println(kutyaNevek[2]);
		}else if(velszam==3) {
			System.out.println(kutyaNevek[1]);
		
		}
		//Kérjük be a felhasználótól gyümölcsneveket, majd tároljuk le egy tömbbe. Fűzzük össze az egyes
		//elemeket pontosvessző karakterrel egy darab string típusú változóba, majd írjuk ki!
		System.out.println("Kérjük adja meg az első gyümölcsnevet!");
		String gyumolcsnev1=sc.nextLine();
		System.out.println("Kérjük adja meg a második gyümölcsnevet!");
		String gyumolcsnev2=sc.nextLine();
		System.out.println("Kérjük adja meg a harmadik gyümölcsnevet!");
	    String gyumolcsnev3=sc.nextLine();
	    String gyumolcsokEgyben=String.join("; ", gyumolcsnev1,gyumolcsnev2,gyumolcsnev3);
	    System.out.println(gyumolcsokEgyben);
	    System.out.println();
	    
	    //Írjuk ki a 10 nappal ezelőtti dátumot!
	    Calendar maiDatum=Calendar.getInstance();
	    maiDatum.add(Calendar.DATE, -10);
	    System.out.println("A 10 nappal ezelőtti dátum "+maiDatum.getTime());
	    System.out.println();
	    
	    //Kérjünk be egy emailcímet, majd döntsük el, hogy tartalmazza –e a @ jelet és megfelelő –e a
	    //formátum  pld. tesztemail@domain.hu (szoveg@szoveg.szoveg)!
	    System.out.println("Kérjük adja meg az email címet!");
	    String megadottemailcim=sc.nextLine();
	    int kukacindex=megadottemailcim.indexOf("@");
	    int pontindex=megadottemailcim.indexOf(".");
	    if (Character.isLetter(megadottemailcim.charAt(kukacindex - 1)) && Character.isLetter(megadottemailcim.charAt(kukacindex + 1))&&
	    		Character.isLetter(megadottemailcim.charAt(pontindex-1)) && Character.isLetter(megadottemailcim.charAt(pontindex+1))&&
	    		megadottemailcim.contains("@")&&megadottemailcim.contains(".")){
	    	System.out.println("A megadott email cím megfelelő!");
	    }else {
	    	System.out.println("A megadott email cím nem megfelelő!");
	    }
	   
	    System.out.println();
	    //Készítsünk jelszógeneráló alkalmazást! Kérjük be, hogy milyen hosszú jelszót szeretnénk! Csak az 
	    //angol ABC betűit és számokat tartalmazhat! Speciális karakterek közül csak alulvonás szerepelhet 
	    //benne! Kötelezően min. 2 szám, legalább 1 nagybetű és 1 speciális karakter legyen benne!

	    System.out.println("Kérem adja meg a jelszó hosszát");
	    int jelszohossz=Integer.parseInt(sc.nextLine());
	    char [] karakterek={'q','r','t','z','u','i','o','p','a','s'};
	   // String [] karakterek={"q","r","t","z","u","i","o","p","a","s"};

	    char [] szamok={'0','1','2','3','4','5','6','7','8','9'};
	    char [] jelszo=new char[jelszohossz];
	    
	    for (int i = 0; i < jelszo.length; i++) {
	    	int randomNr=new Random().nextInt(karakterek.length);
			jelszo[i]=karakterek[randomNr];
	    }
	    
	    boolean speckarbe = true;
	    boolean szam1NemLetezik = true;
	    boolean szam2NemLetezik = true;
	    boolean speckarakterNemLetezik = true;
        boolean nagybetuNemLetezik = true;
	    
	    do {
	    	int randomNr=new Random().nextInt(jelszo.length);
	    	int randomNr2=new Random().nextInt(10);
	    	if(szam1NemLetezik) {
		    	if (Character.isLetter(jelszo[randomNr])) {
		    		jelszo[randomNr] = szamok[randomNr2];
		    		szam1NemLetezik = false;
		    	}
	    	} else if (szam2NemLetezik) {
		    	if (Character.isLetter(jelszo[randomNr])) {
		    		jelszo[randomNr] = szamok[randomNr2];
		    		szam2NemLetezik = false;
		    	}
	    	} else if (speckarakterNemLetezik) {
		    	if (Character.isLetter(jelszo[randomNr])) {
		    		jelszo[randomNr] = '-';
		    		speckarakterNemLetezik = false;
		    	}
	    	}else if (nagybetuNemLetezik) {
		    	if (Character.isLetter(jelszo[randomNr])) {
		    	   jelszo[randomNr] = Character.toUpperCase(jelszo[randomNr]);
		    	   nagybetuNemLetezik = false;
		    	}
	    	}else {
	    		speckarbe=false;
	    	}
	    } while (speckarbe);
	    
	    for (int i = 0; i < jelszo.length; i++) {
			System.out.print(jelszo[i]+" ");
		}
	    System.out.println();
	    String jelszoegyben=new String(jelszo);
	    System.out.println("A generált jelszó: "+jelszoegyben);
	    
	    
	    //Kérjünk be 2 szót és egy határolót, majd fűzzük össze a megadott határoló mentén: pld. a két megadott 
	    //szó  mákos és tészta, határoló #  eredmény mákos#tészta
	    
	    System.out.println("Kérem adja meg az első szót!");
	    String szo1=sc.nextLine();
	    System.out.println("Kérem adja meg a második szót!");
	    String szo2=sc.nextLine();
	    System.out.println("Kérem adja meg a határolót!");
	    String hatarolo=sc.nextLine();
	    String szavakegyben=String.join("",szo1,hatarolo,szo2);
	    System.out.println();
	    System.out.println(szavakegyben);
	    
	    // Tömbkezelő metódussal rendezzünk növekvő sorrendbe egy 15 elemszámú véletlen számokat (1-
	    //50 között) tartalmazó tömböt!
	    int[] tomb= new int[15];
	    Random rr=new Random();
	    for (int i = 0; i < tomb.length; i++) {
	    	tomb[i]=rr.nextInt((50-1)+1)+1;
	    }
	    System.out.println("A tömbe elemei rendezetlenül: ");
	    tombKiir(tomb);
	    System.out.println();
	    minKivalasztRendez(tomb);
	    
	    
	    /*Kérjünk be a felhasználótól egy számot, majd állítsunk elő egy ilyen hosszú véletlen karakterekből álló
	     * szöveget. A lehetséges karakterek között angol betűk (kis/nagy), számok és a következő speciális 
	    karakterek is szerepelhetnek: * / - ! ?. 
	    1. Írjuk ki a generált szöveget!
	    2. Hány darab speciális karakter van a generált szövegben?
	    3. Döntsük el, hogy szerepel –e benne a ? karakter!
	    4. Alakítsuk a teljes szöveget nagybetűssé!
	    5. Alakítsuk a teljes szöveget kisbetűssé!
	    6. Melyik indexen szerepel benne az ’e’ betű? Amennyiben nincs a generált karakterek 
	    között, akkor erről is tájékoztassuk a felhasználót!
	    7. Cseréljünk ki minden speciális karaktert ’#’ –re!
	     */
	    System.out.println("Kérem adja meg a szöveg hosszát");
	    int szoveghossz=Integer.parseInt(sc.nextLine());
	    char [] karakterek1={'q','r','t','z','u','i','o','p','a','s','A','B','C','D','*','/','-','!','?','1','2','3','4'};
	    char[]szoveg1=new char[szoveghossz];
	    
	    for (int i = 0; i < szoveg1.length; i++) {
			int rrr=new Random().nextInt(karakterek1.length);
			szoveg1[i]=karakterek1[rrr];
		}
	    String szovegegyben=new String(szoveg1);
	    System.out.println(szovegegyben);
	 
	     
	     
	    

	    
	    
	    
	
	    
		}
	    public static void tombKiir(int[] tomb) {
			for (int item : tomb) {
				System.out.print(item + " ");
			}
	    }
	    

			public static void minKivalasztRendez(int[] tomb) {
				int csere;
				int minIndex;
				for (int i = 0; i < tomb.length-1; i++) {
					minIndex = i;
					for (int j = i+1; j < tomb.length; j++) {
						if (tomb[j]<tomb[minIndex]) {
							minIndex = j;
						}
					}
					if (i!=minIndex) {
						csere = tomb[i];
						tomb[i] = tomb[minIndex];
						tomb[minIndex] = csere;
					}
	    }System.out.println("A tömb elemei rendezve: ");
	    tombKiir(tomb);
	
    	
			
			}

}