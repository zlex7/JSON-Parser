import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JSONMain {

	public static void main(String[] args) throws IOException {
		
		Map<String,TestJSON> jsons = new HashMap<>();
		
		File input = new File("input.txt");
		Scanner scan = new Scanner(input);
		scan.useDelimiter("-----");
		//scan.useDelimiter("(?<={\\s*)-----(?=\\s*})");
		
		while(scan.hasNext()){
			
			final String next=scan.next();
			System.out.println(next);
			
			jsons.put(next, new TestJSON() {
				
				public void run(JSONRunner runner) throws IOException {
					
					JSON json = runner.getParser().parseInput(next);
					
					System.out.println(json);
					
				}
				
			});
			
		}
		
		for(TestJSON test : jsons.values()){
			test.run(new JSONRunner() {
				
				public JSONParser getParser(){
					
					return new JSONParser();
					
				}
			});
		}
		
	}

}
