import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLineRunner {
	public static void main(String[] args) throws IOException {
		String osName = System.getProperty("os.name");
		if (osName != null) {
			if (osName.toLowerCase().contains("windows")) {
				ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\\" && dir");
				builder.redirectErrorStream(true);
				Process p = builder.start();
				BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line;
				while (true) {
					line = r.readLine();
					if (line == null) {
						break;
					}
				}
				System.out.println(line);
			}
		}
	}
}
