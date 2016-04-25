import java.util.Set;
import java.util.TreeSet;

public class PrintSortedPlanets {
	
	public void printPlanets() {
		Set<Planet> planets = new TreeSet<>(new PlanetComparator()); 
		
		planets.add(new Planet("Mercury", 57910000, 4880));
		planets.add(new Planet("Venus", 108200000, 12103));
		planets.add(new Planet("Earth", 149600000, 12756));
		
		for(Planet planet : planets) {
			System.out.println(planet);
		}
	}
	
	private class PlanetComparator implements Comparator<planet> {
		public int compare(Planet a, Planet b) {
			if (a.getDiameter() < b.getDiameter())
				return -1;
			else if (a.getDiameter() > b.getDiameter())
				return 1;
			else
				return a.getName().compareTo(b.getName());
		}
	}
	
	public static void main(String[] args) {
		PrintSortedPlanets p = new PrintSortedPlanets();
		p.printPlanets();
	}
}
