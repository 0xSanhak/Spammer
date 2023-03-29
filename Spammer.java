
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Spammer {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Virus Squad - Spammer beta 0.1");
			System.err.println(
					"Please try to use command right this java Spammer.java <LoopTime> \n and please create \"contents.txt\" file and add messages in this");
			System.exit(0);
			return;
		}
		File file = new File("contents.txt");
		if (!file.exists()) {
			System.err.println(
					"The file not exists ! please create file with this name \"contents.txt\" and drop messages in it");
			return;
		}

		if (readFile(file) == null || readFile(file) == "") {
			System.err.println("Please drop messages in contents.txt");
			return;
		}

		int loopTime = Integer.parseInt(args[0]);
		String spamMessage = readFile(file);
		System.out.println("The Spammer will started after 3 seconds !");
		for (int x = 0; x < loopTime; x++) {
			try {
				write(spamMessage);
			} catch (IllegalArgumentException e) {
				System.out.println("this letters not supported");
			}
		}

	}

	public static String readFile(File file) {
		String result = "";

		FileReader fr;
		try {
			fr = new FileReader(file);
			int x ;
			while ((x= fr.read()) != -1) {
				result += (char) x;
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static void write(String text) {
		try {
			Robot robot = new Robot();
			robot.delay(3024);
			int[] keys = new int[text.length()];
			for (int x = 0; x < text.length(); x++)
				keys[x] = KeyEvent.getExtendedKeyCodeForChar(text.charAt(x));
			for (int i = 0; i < keys.length; i++) {
				robot.keyPress(keys[i]);
				robot.keyRelease(keys[i]);
			}
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(700);
		} catch (AWTException e) {
			e.printStackTrace();
		}

	}

}