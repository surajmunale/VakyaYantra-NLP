import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
@WebServlet("/TextToUnicode")
public class TextToUnicode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static String[][] UnicodeStore = new String[56][2];
	BufferedReader br = null;
	static int ctr = 0;
	static int inputFileLength1 = 0;
	static int inputFileLength2 = 0;
	static String path = "E:/iiitb/3rd sem2013/workspace/NLP_web/src/";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		//request.setCharacterEncoding("UTF-8");
		if (request.getCharacterEncoding() == null)
			request.setCharacterEncoding("UTF-8");
		String sound = request.getParameter("data");
		System.out.println(sound);
		//System.out.println(sandhiViched + " sandhi request");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		UnicodeStore = storeUnicode();

		// FIND LENGTH OF INPUT FILE
		inputFileLength1 = inputFileLength(sound);
		//System.out.println("Length of Input 1 = " + inputFileLength1);
		Character[] inputArray1 = new Character[inputFileLength1];

		// READ INPUT FILE AND STORE IN AN ARRAY
		storeInput(inputArray1, sound);

		// PRINT INPUT
		for (int i = 0; i < inputArray1.length; i++) {
			System.out.println(i+" "+inputArray1[i]);
		}

		// MAP and STORE IN A FILE
		String ans1[] = mapAndStore(inputArray1);

		// append the alphabets with vowels
		ArrayList<String> soundMap = new ArrayList<String>();
		soundMap = soundDB(ans1);

		// map the sound units with the corresponding wav file
		soundUnitMap(soundMap);
		//sandhiViched = new String(sandhiViched.getBytes(), "UTF-8");
		//String[] arrayOfWords = sandhiViched.split(" ");
		//String result = "";
		//for (int i = 0; i < arrayOfWords.length; i++)
		//	result = result + getSandhiViched(arrayOfWords[i]);

		//System.out.println("sending" + result);
		//out.print(result);

	}


	public TextToUnicode() {
		super();
		// TODO Auto-generated constructor stub
	}

	private static void soundUnitMap(ArrayList<String> soundMap) {
		
		System.out.println("\n");

		File sample1 = new File(path + "DB/"+soundMap.get(0) + ".wav");
		if(!sample1.exists())
			sample1=new File(path + "/DB/notFound.wav");
		File sample2 = new File(path + "DB/"+soundMap.get(1) + ".wav");
		if(!sample2.exists())
			sample2=new File(path + "DB/notFound.wav");

		File fileOut = new File(path + "DB/"+"combined.wav");
		try {
			AudioInputStream audio1 = AudioSystem.getAudioInputStream(sample1);
			AudioInputStream audio2;

			audio2 = AudioSystem.getAudioInputStream(sample2);

			AudioInputStream audioBuild = new AudioInputStream(
					new SequenceInputStream(audio1, audio2),
					audio1.getFormat(), audio1.getFrameLength()
							+ audio2.getFrameLength());

			for (int i = 2; i < soundMap.size(); i++) {
				sample2 = new File(path + "DB/"+soundMap.get(i) + ".wav");
				if(!sample2.exists())
					sample2=new File(path +"DB/notFound.wav");

				

				audioBuild = new AudioInputStream(new SequenceInputStream(
						audioBuild, /* keep creating new input streams */
						AudioSystem.getAudioInputStream(sample2)),
						audioBuild.getFormat(), audioBuild.getFrameLength()
								+ audio2.getFrameLength());

			}

			AudioSystem.write(audioBuild, AudioFileFormat.Type.WAVE, fileOut);
			AudioPlayer p = AudioPlayer.player;

			AudioStream as = new AudioStream(
					new FileInputStream(path +"DB/combined.wav"));
			p.start(as);
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> soundDB(String[] inputArray1) {

		ArrayList<String> soundUnits = new ArrayList<String>();
		String unit;
		for (int i = 0; i < inputArray1.length; i++) {
			unit = inputArray1[i];

			if (i + 1 < inputArray1.length && isIntNumber(inputArray1[i + 1])) {
				unit = unit.concat(inputArray1[i + 1]);
				i++;
			}
			soundUnits.add(unit);
		}

		return soundUnits;
	}

	public static boolean isIntNumber(String num) {
		try {
			Integer.parseInt(num);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	static String[] mapAndStore(Character[] inputArray) {

		String mapping[] = new String[inputArray.length];
		// int mapctr = 0;
		ctr = 0;

		FileWriter fstream = null;
		try {
			fstream = new FileWriter(path + "output.txt", false);
			System.out.println("written");
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(fstream);

		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < 56; j++) {
				if (inputArray[i].toString().compareTo(" ") == 0) {
					try {
						out.write("space");
						out.write(" ");
						mapping[ctr++] = "space";
						break;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (inputArray[i].toString().compareTo(UnicodeStore[j][0]) == 0) {
					try {
						out.write(UnicodeStore[j][1]);
						out.write(" ");
						mapping[ctr++] = UnicodeStore[j][1];
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
				}
			}
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return mapping;
	}

	static String[][] storeUnicode() {
		String[][] UnicodeStore = new String[56][2];
		BufferedReader br = null;
		int ctr = 0;

		try {

			//br = new BufferedReader(new FileReader("Book1.txt"));
			String s = new java.util.Scanner( new java.io.File(path +"Book1.txt"), "UTF-16" ).useDelimiter("\\A").next();

			//while ((sCurrentLine = br.readLine()) != null) {
				//System.out.println(s);
				int num=0;
				StringTokenizer st = new StringTokenizer(s, "\n ");
				while (st.hasMoreTokens()) {
					//System.out.println("Enter");
					String tok = st.nextToken().trim();
					//System.out.println(tok);
					UnicodeStore[ctr][num] = tok;
					num=1-num;
					if(num==0)
						ctr++;
					//System.out.println("ctr = "+ctr);
				}
			//}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return UnicodeStore;

	}

	static int inputFileLength(String string) {
		int inputFileLength = 0;
		//BufferedReader br = null;
		try {

			//String s = string.useDelimiter("\\A").next();
			//br = new BufferedReader(new FileReader(string));

			//while ((sCurrentLine = br.readLine()) != null) {
				char[] array = string.toCharArray();
				inputFileLength += array.length;
			//}

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return inputFileLength;
	}

	static void storeInput(Character[] inputArray, String string) {
		//BufferedReader br = null;
		try {

			//String s = new java.util.Scanner( new java.io.File(string), "UTF-16" ).useDelimiter("\\A").next();
			ctr = 0;
			//br = new BufferedReader(new FileReader(string));

			//while ((sCurrentLine = br.readLine()) != null) {
				char[] array = string.toCharArray();
				for (int i = 0; i < array.length; i++) {
					inputArray[ctr] = array[i];
					ctr++;
				}
			//}

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}