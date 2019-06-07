package claseTeclado;

import static claseTeclado.Keyboard.*;
import static claseTeclado.Colores.*;

//import static claseTeclado.ClaseTeclado.Range;

public class KeyboardTest {

	public static enum  Range{
		BOTHINCLUDED, BOTHEXCLUDED, MINIMUNINCLUDED_MAXIMUNEXCLUDED, MINIMUMEXCLUDED_MAXIMUMINCLUDED;
	}
	
	public static void main(String[] args) {
		
		int option;
		
		do {
			readInt("Choose the option you want:\n 1. Char reading test\n 2. String reading test\n 3. Boolean reading test\n 4. Numbers reading test\n 5. Numbers reading with comparations test \n 6. Numbers reading with range test\n 7. Quit\n");
			option=readInt();
			
			switch(option) {
			case 1:
				charReadingTest();
				break;
			case 2:
				stringReadingTest();
				break;
			case 3:
				booleanReadingTest();
				break;
			case 4:
				numbersReadingTest();
				break;
			case 5:
				numbersCompareTest();
				break;
			case 6:
				numbersRangeTest();
				break;
			case 7:
				keyboard.close();
				System.out.printf(AZUL + "You've finished testing, the program is closing\n ... CLOSED ..." + RESET);
				break;
			}
				
		}while(option!=7);
	}

	//__________________________________________________________________________________________________
	//READ NUMBERS WITH RANGE TEST______________________________________________________________________
	
	private static void numbersRangeTest() {
	}

	//__________________________________________________________________________________________________
	//READ NUMBERS WITH COMPARING TEST__________________________________________________________________
	
	private static void numbersCompareTest() {
		
	}

	//__________________________________________________________________________________________________
	//READ NUMBERS TEST_________________________________________________________________________________
	
	private static void numbersReadingTest() {
		int option;
		
		System.out.println(AZUL + "YOU ARE NOW IN READ NUMBERS TEST" + RESET);
		do {
			option=readInt("Please, select what you want to prove:\n 1. readInt test\n 2. readDouble test\n 3. readFloat test\n 4. readShort test\n 5. readLong test\n 6. readByte test\n 7. Return to main menu\n");
			switch(option) {
			case 1:
				readIntTEST();
				break;
			case 2:
				readDoubleTEST();
				break;
			case 3:
				readFloatTEST();
				break;
			case 4:
				readShortTEST();
				break;
			case 5:
				readLongTEST();
				break;
			case 6:
				readByteTEST();
				break;
			case 7:
				System.out.println(AZUL + "READ NUMBERS TEST FINISHED\n ... Returning to main menu ...\n\n" + RESET + "\n");
			}
		}while(option!=7);
	}

	private static void readByteTEST() {
		byte number;
		
		System.out.println(AZUL + "YOU ARE NOW IN readByte TEST" + RESET);
		number=readByte("Introduce a byte number");
			System.out.printf("%s\n", number);
		number=readByte("Introduce a character");
			System.out.printf("%s\n", number);
		number=readByte("Introduce a string");
			System.out.printf("%s\n", number);	
		number=readByte("Dont introduce anything");
			System.out.printf("%s\n", number);	
		System.out.println(AZUL + "readByte TEST FINISHED" + RESET + "\n");
	}

	private static void readLongTEST() {
		long number;
		
		System.out.println(AZUL + "YOU ARE NOW IN readLong TEST" + RESET);
		number=readLong("Introduce a long number");
			System.out.printf("%s\n", number);
		number=readLong("Introduce a character");
			System.out.printf("%s\n", number);
		number=readLong("Introduce a string");
			System.out.printf("%s\n", number);	
		number=readLong("Dont introduce anything");
			System.out.printf("%s\n", number);	
		System.out.println(AZUL + "readLong TEST FINISHED" + RESET + "\n");
	}

	private static void readShortTEST() {
		short number;
		
		System.out.println(AZUL + "YOU ARE NOW IN readLong TEST" + RESET);
		number=readShort("Introduce a short number");
			System.out.printf("%s\n", number);
		number=readShort("Introduce a character");
			System.out.printf("%s\n", number);
		number=readShort("Introduce a string");
			System.out.printf("%s\n", number);	
		number=readShort("Dont introduce anything");
			System.out.printf("%s\n", number);	
		System.out.println(AZUL + "readLong TEST FINISHED" + RESET + "\n");
	}

	private static void readFloatTEST() {
		float number;
		
		System.out.println(AZUL + "YOU ARE NOW IN readFloat TEST" + RESET);
		number=readFloat("Introduce a float number");
			System.out.printf("%s\n", number);
		number=readFloat("Introduce a character");
			System.out.printf("%s\n", number);
		number=readFloat("Introduce a string");
			System.out.printf("%s\n", number);	
		number=readFloat("Dont introduce anything");
			System.out.printf("%s\n", number);	
		System.out.println(AZUL + "readFloat TEST FINISHED" + RESET + "\n");
	}

	private static void readDoubleTEST() {
		double number;
		
		System.out.println(AZUL + "YOU ARE NOW IN readDouble TEST" + RESET);
		number=readDouble("Introduce a double number");
			System.out.printf("%s\n", number);
		number=readDouble("Introduce a character");
			System.out.printf("%s\n", number);
		number=readDouble("Introduce a string");
			System.out.printf("%s\n", number);	
		number=readDouble("Dont introduce anything");
			System.out.printf("%s\n", number);	
		System.out.println(AZUL + "readDouble TEST FINISHED" + RESET + "\n");
	}

	private static void readIntTEST() {
		int number;
		
		System.out.println(AZUL + "YOU ARE NOW IN readLong TEST" + RESET);
		number=readInt("Introduce a int number");
			System.out.printf("%s\n", number);
		number=readInt("Introduce a float number");
			System.out.printf("%s\n", number);
		number=readInt("Introduce a character");
			System.out.printf("%s\n", number);
		number=readInt("Introduce a string");
			System.out.printf("%s\n", number);	
		number=readInt("Dont introduce anything");
			System.out.printf("%s\n", number);	
		System.out.println(AZUL + "readLong TEST FINISHED" + RESET + "\n");
	}
	
	//__________________________________________________________________________________________________
	//READ BOOLEAN TEST_________________________________________________________________________________

	private static void booleanReadingTest() {
		int option;
		
		System.out.println(AZUL + "YOU ARE NOW IN readBoolean TEST" + RESET);
		do {
			option=readInt("Please, select what you want to prove:\n 1. Boolean reading with menu\n 2. Boolean reading with YES/NO options\n 3. Return to main menu\n");
			switch(option) {
			case 1:
				readBooleanMenuTEST();
				break;
			case 2:
				readBooleanOptionsTEST();
				break;
			case 3:
				System.out.println(AZUL + "readBoolean TEST FINISHED\n ... Returning to main menu ...\n\n" + RESET + "\n");
			}
		}while(option!=3);
	}

	private static void readBooleanOptionsTEST() {
		@SuppressWarnings("unused")
		boolean b1;
		System.out.println(AZUL + "YOU ARE NOW IN readBooleanOptions TEST" + RESET);
		b1=readBooleanOptions("Write S");
		b1=readBooleanOptions("Write s");
		b1=readBooleanOptions("Write N");
		b1=readBooleanOptions("Write n");
		b1=readBooleanOptions("Dont write anything");
		b1=readBooleanOptions("Write a number");
		b1=readBooleanOptions("Write another character excepts S/N");
		System.out.println(AZUL + "readBooleanOptions TEST FINISHED" + RESET + "\n");
	}

	private static void readBooleanMenuTEST() {
		@SuppressWarnings("unused")
		boolean b1;
		System.out.println(AZUL + "YOU ARE NOW IN readBooleanMenu TEST" + RESET);
		b1=readBooleanMenu("Choose option 1", "Option 1", "Option 2", "Write 1");
		b1=readBooleanMenu("Choose option 2", "Option 1", "Option 2", "Write 2");
		b1=readBooleanMenu("Write 3", "Option 1", "Option 2", "Write 3");
		b1=readBooleanMenu("Write a character", "Option 1", "Option 2", "Write 1");
		b1=readBooleanMenu("Dont write anything", "Option 1", "Option 2", "Write when test finishes");
		System.out.println(AZUL + "readBooleanMenu TEST FINISHED" + RESET + "\n");
	}
	
	//__________________________________________________________________________________________________
	//READ CHAR AND STRING TEST_________________________________________________________________________

	private static void stringReadingTest() {
		String s;
		
		System.out.println(AZUL + "YOU ARE NOW IN readString TEST" + RESET);
		s=readString("Introduce one character");
			System.out.printf("%s\n", s);
		s=readString("Dont introduce anything");
			System.out.printf("%s\n", s);
		s=readString("Introduce a number");
			System.out.printf("%s\n", s);
		s=readString("Introduce two characters");
			System.out.printf("%s\n", s);
		s=readString("Introduce more than two characters");
			System.out.printf("%s\n", s);
		System.out.println(AZUL + "readString TEST FINISHED" + RESET + "\n");
	}

	private static void charReadingTest() {
		char c;
		
		System.out.println(AZUL + "YOU ARE NOW IN readChar TEST" + RESET);
		c=readChar("Introduce one character");
			System.out.printf("%s\n", c);
		c=readChar("Dont introduce anything");
			System.out.printf("%s\n", c);
		c=readChar("Introduce a number");
			System.out.printf("%s\n", c);
		c=readChar("Introduce two characters (Introduce only one to continue when you finish testing)");
			System.out.printf("%s\n", c);
		c=readChar("Introduce more than two characters (Introduce only one to continue when you finish testing)");
			System.out.printf("%s\n", c);
		System.out.println(AZUL + "readChar TEST FINISHED" + RESET + "\n");
	}
}
