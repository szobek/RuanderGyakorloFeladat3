package forma1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

public class FileHandling {
public void readFile(String fileName, String delimiter,List<Pilota> pilotak) {
	try(BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"UTF-8"))){
		br.readLine();
		while(br.ready()) {
			pilotak.add(new Pilota(br.readLine().split(delimiter)));
		}
	} catch (Exception e) {
		System.out.println("HIBA!");
	}
	
}
}
