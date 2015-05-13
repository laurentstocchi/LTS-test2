import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class main {
	
	Random rand = new Random();
	static int firstPlateNumber, indiceLetter, secondPlateNumber, indiceSections, year, month, day, indiceType;
	static char firstLetter, secondLetter, thirdLetter;
	static String theType;
	static String theSection;
	static String [] carTypes = {"car","car","car","truck","motorcycle"};
	static String [] lesSections = {"A10","A11","A12","A13","A14","A15"};
	static char [] arrayLetter = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	
	//on créé les sections en premier
	static Section sectionA10 = new Section("A10","Esch","Luxembourg",3);
	static Section sectionA11 = new Section("A11","Esch","Rodange",2);
	static Section sectionA12 = new Section("A12","Wiltz","Luxembourg",2);
	static Section sectionA13 = new Section("A13","Luxembourg","Metz",6);
	static Section sectionA14 = new Section("A14","Luxembourg","Trier",4);
	static Section sectionA15 = new Section("A15","Luxembourg","Arlon",5);
	

	public static Collection<Enregistrement> enregistrements = new ArrayList<Enregistrement>();
	private static Collection<Car> vehicles = new ArrayList<Car>();
	
	private static <E, T> void process(Iterable<E> elements, Predicate<E> predicate, Function<E, T> mapper, Consumer<T> block) {
		for (E e : elements) {
			if (predicate.test(e)) {
				T value = mapper.apply(e);
				
				block.accept(value);
			}
		}
	}

	public static void main(String[] args) {
		//Enregistrement car1 = new Enregistrement("757 ASP 57","A12", new Date(101, 0, 1));
		//Car vehicle1 = new Car("757 ASP 57","car");
		
		int i = 0;
		
		for(i=0;i<100;i++){
			Random rand = new Random();
			firstPlateNumber = rand.nextInt(999 - 100 + 1) + 100;
			indiceLetter = rand.nextInt(arrayLetter.length);
			firstLetter = arrayLetter[indiceLetter];
			indiceLetter = rand.nextInt(arrayLetter.length);
			secondLetter = arrayLetter[indiceLetter];
			indiceLetter = rand.nextInt(arrayLetter.length);
			thirdLetter = arrayLetter[indiceLetter];
			secondPlateNumber = rand.nextInt(99 - 1 + 1) + 1;
			indiceSections = rand.nextInt(lesSections.length);
			theSection = lesSections[indiceSections];
			year = rand.nextInt(115 - 100 + 1) + 100;
			month = rand.nextInt(11 - 0 + 1) + 0;
			day = rand.nextInt(30 - 0 + 1) + 0;
			Enregistrement car = new Enregistrement(firstPlateNumber+" "+firstLetter+secondLetter+thirdLetter+" "+secondPlateNumber,theSection, new Date(year, month, day));
			
			indiceType = rand.nextInt(carTypes.length);
			theType = carTypes[indiceType];
			
			//si un vehicule avec cette plaque n'existe pas 
			Car vehicle = new Car(firstPlateNumber+" "+firstLetter+secondLetter+thirdLetter+" "+secondPlateNumber,theType);
			vehicles.add(vehicle);
			
			
			enregistrements.add(car);
		}
		
		System.out.println("Tout les enregistrements:");
		process(enregistrements, e -> true, e -> e, e -> System.out.println(e));
		
		System.out.println("Toutes les voitures:");
		process(vehicles, e -> true, e -> e, e -> System.out.println(e));
		
	}

}