import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChronalCalibrationRepetitionDetector {
	public static void main(String[] args) {
		try {
			List<Integer> frequencies = new ArrayList<>();

			// Initialise frequency at zero
			frequencies.add(0);

			while (true) {
				List<Integer> lineValues = getLineValues();
				
				for (int i = 0; i < lineValues.size(); i++) {
					int nextFrequency = lineValues.get(i) + frequencies.get(frequencies.size() - 1);
					
					if (frequencies.contains(nextFrequency)) {
						System.out.println(String.format("Reached frequency of %d twice", nextFrequency));
						System.exit(0);
					} else {
						frequencies.add(nextFrequency);
					}
				}
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to find/open file:");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Error reading file file");
			ex.printStackTrace();
		} catch (NumberFormatException ex) {
			System.out.println("Error parsing line to integer");
			ex.printStackTrace();
		}
	}

	public static List<Integer> getLineValues () throws FileNotFoundException, IOException, NumberFormatException {
		String line = null;
		List<Integer> frequencies = new ArrayList<>();
		FileReader fileReader = new FileReader("../input.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		while ((line = bufferedReader.readLine()) != null) {
			frequencies.add(Integer.parseInt(line));
		}

		bufferedReader.close();
		
		return frequencies;
	}
}