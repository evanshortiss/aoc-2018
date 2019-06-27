import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ChronalCalibration {
	public static void main(String[] args) {
		try {
			int resultingFrequency = 0;
			String line = null;
			FileReader fileReader = new FileReader("../input.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			while ((line = bufferedReader.readLine()) != null) {
				int lineValue = Integer.parseInt(line);
				resultingFrequency += lineValue;
			}

			bufferedReader.close();
			System.out.println("Resulting Frequency: " + Integer.toString(resultingFrequency));
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
}