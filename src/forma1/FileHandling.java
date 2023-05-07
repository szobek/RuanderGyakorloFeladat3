package forma1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class FileHandling {
	public void readFile(String fileName, String delimiter, List<Pilota> pilotak) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"))) {
			br.readLine();
			while (br.ready()) {
				pilotak.add(new Pilota(br.readLine().split(delimiter)));
			}
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("Rossz fájl kódolás");
		} catch (FileNotFoundException e) {
			System.out.println("Nincs ilyen fájl!!");
		} catch (IOException e) {
			System.out.println("I/O hiba");
		}

	}
}
