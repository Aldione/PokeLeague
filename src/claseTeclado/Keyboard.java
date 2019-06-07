package claseTeclado;

import java.util.Scanner;
import java.util.InputMismatchException;
import static claseTeclado.Colores.*;

public class Keyboard {
	
	public static final String ERROR_NUMBER_INPUT=ROJO + "The number you have entered is not correct. Please, enter again:" + RESET;
	public static enum Comparation{
		BIGGEREQUAL, SMALLEREQUAL, BIGGER, SMALLER;
	}
	public static enum  Range{
		BOTHINCLUDED, BOTHEXCLUDED, MINIMUNINCLUDED_MAXIMUNEXCLUDED, MINIMUMEXCLUDED_MAXIMUMINCLUDED;
	}
	//Keyboard opening function
	static Scanner keyboard=new Scanner(System.in);
	
	//Keyboard closing function
	public static void keyboardClose (){
        keyboard.close();
    }
	
	//___________________________________________________________________________________________________________________
	//CHAR AND STRING READING (WITH MESSAGE)_____________________________________________________________________________
		
	/* Char reading function
	 * @author Juan Antonio Tejada
	 * 
	 * 1. We throw the predetermined message
	 * 2. We call the function readChar (Without message)
	 */
	public static char readChar(String msg){
		char character;
		//1. We throw the predetermined message
		System.out.printf("%s:\n", msg);
		//2. We call the function readChar (Without message)
		character=readChar();
		
		return character;
    }

	
	/* String reading function
	 * @author Juan Antonio Tejada
	 * 
	 * 1. We throw the predetermined message
	 * 2. We call the function readString (Without message)
	 */
	public static String readString (String msg){
        String c1;
        
        //1. We throw the predetermined message
        System.out.printf("%s:\n", msg);
        //2. We call the function readString (Without message)
        c1=readString();
        
        return c1;
    }
	
	//___________________________________________________________________________________________________________________
	//CHAR AND STRING READING (WITHOUT MESSAGE)__________________________________________________________________________
		
	/* Char reading function
	 * @author Juan Antonio Tejada
	 * 
	 * 1.We ask for a character
	 * 		1.1 If the user doesnt enters a character (he enters a string), we ask again till he does it correctly
	 * 		1.2 If the user enters a character, we continue
	 * 2.We return the character
	 */
	public static char readChar(){
		String s1;
		
		//1.1 If the user doesnt enters a character (he enters a string), we ask again till he does it correctly
		do {	
			//Here, we dont have a message because the programmer has put it out the function
			s1=keyboard.nextLine();
		//1.2 If the user enters a character, we continue
		}while(s1.length()>1);   
		
		//2.We return the character
		return s1.charAt(0);
    }

	
	/* String reading function
	 * @author Juan Antonio Tejada
	 * 
	 * 1. We ask for a String
	 * 2. We return the String
	 * 
	 */
	public static String readString (){
        String c1;
        
        //1. We ask for a String
		//Here, we dont have a message because the programmer has put it out the function
        do{ 
        	c1=keyboard.nextLine();
        }while(c1.length()==0);
        //2. We return the String
        return c1;
    }
	

	//___________________________________________________________________________________________________________________
	//BOOLEAN READING (WITH MESSAGE) ____________________________________________________________________________________
	
	/* Boleaan reading function (By menu)
	 * @author Juan Antonio Tejada
	 * 
	 * 1. We throw the predetermined message
	 * 2. We call the function readBooleanMenu (Without message)
	 */
	public static boolean readBooleanMenu(String question, String optiontrue, String optionfalse, String msg){
        boolean result=true;
        
        //1. We throw the predetermined message
        System.out.printf("%s\n", msg);
        
        //2. We call the function readBooleanMenu (Without message)
        result=readBooleanMenu(question, optiontrue, optionfalse);
        return result;
    }
	
	/* Boolean reading function (By Options)
	 * @author Juan Antonio Tejada
	 * 
	 * 1. We throw the predetermined message
	 * 2. We call the function readBooleanOptions
	 */
	public static boolean readBooleanOptions(String question, String msg) {
		boolean answer=true;
		
		//1. We throw the predetermined message
		System.out.printf("%s:", msg);
		//2. We call the function readBooleanOptions
		answer=readBooleanOptions(question);
		return answer;
	}

	//___________________________________________________________________________________________________________________
	//BOOLEAN READING (WITHOUT MESSAGE) _________________________________________________________________________________
	
	/* Boleaan reading function (By menu)
	 * @author Juan Antonio Tejada
	 * 
	 * 1. We ask and we show the options
	 * 2. We allow the user to choose
	 * 		2.1 If the user selects an option, we continue
	 * 		2.2 If not, we continue asking till the user chooses well
	 * 3. We return the result
	 */
	public static boolean readBooleanMenu(String question, String optiontrue, String optionfalse){
        int answer=0;
        boolean result=true;
        do{
        	//1. We ask and we show the options
            System.out.printf("%s:\n  1. %s\n  2. %s\n",question,optiontrue,optionfalse);
            //2. We allow the user to choose
            try {
            	answer=keyboard.nextInt();
            } catch(InputMismatchException e) {
            	//2.2 If not, we continue asking till the user chooses well
            	System.out.println("\nPlease, enter your selection:");
            } finally {
            	keyboard.nextLine();
            }
            //2.1 If the user selects an option, we continue
            if (answer==1){
            	result=true;
            } else {
            	result=false;
            } 
        }while (answer!=1 && answer!=2);
        //3. We return the result
        return result;
    }
	
	/* Boolean reading function (By Options)
	 * @author Juan Antonio Tejada
	 * 
	 * 1. We show the question and we ask to the user
	 * 2. We see if he entered an s/S or n/N (We are going to ask it by using the function readChar()
	 * 		2.1 If he did, we continue
	 * 		2.2 If not, we ask again till he does
	 * 3. If the user enters a s/S we set the boolean to TRUE, if the user enters a n/N we set the boolean to FALSE
	 * 4. We return the result
	 */
	public static boolean readBooleanOptions(String question) {
		boolean answer=true;
		char option;
		
		do {
			//1. We show the question and we ask to the user
			//In this case, the message is out of the function so there isnt
			//2. We see if he entered an s/S or n/N (We are going to ask it by using the function readChar()
			option=readChar();
			//3. If the user enters a s/S we set the boolean to TRUE, if the user enters a n/N we set the boolean to FALSE
			if(option=='s'||option=='S') {
				answer=true;
			} else if (option=='n'||option=='N') {
				answer=false;
			}
		}while(option!='s' && option!='S' && option!='n' && option!='N');	 //2.1 If he did, we continue
																			 //2.2 If not, we ask again till he does
		//4. We return the result
		return answer;
	}

		
	//___________________________________________________________________________________________________________________
	//NUMBERS READING (WITH MESSAGE)_____________________________________________________________________________________
		
	/* Int number reading function
	 * @author Juan Antonio Tejada Pérez
	 * 
	 * 1. We throw the predetermined message
	 * 2. We call the function readInt()
	 */
    public static int readInt (String msg){
        int number=0;
        //1. We throw the predetermined message
        System.out.printf("%s\n", msg);
        //2. We call the function readInt()
        number=readInt();
        
        return number;
    }
	
    /* Double number reading function
     * @author Juan Antonio Tejada
     * 
	 * 1. We throw the predetermined message
	 * 2. We call the function readDouble()
	 */
    public static double readDouble (String msg) {
    	double number=0;
    	//1. We throw the predetermined message
    	System.out.printf("%s\n", msg);
    	//2. We call the function readDouble()
    	number=readDouble();
    	
    	return number;
    }
    
    /* Float number reading function
     * @author Juan Antonio Tejada
     * 
	 * 1. We throw the predetermined message
	 * 2. We call the function readFloat()
	 */
    public static float readFloat (String msg) {
    	float number=0;
    	//1. We throw the predetermined message
    	System.out.printf("%s\n", msg);
    	//2. We call the function readFloat()
    	number=readFloat();
    	
    	return number;
    }
    
    /* Byte number reading function
     * @author Juan Antonio Tejada
     * 
	 * 1. We throw the predetermined message
	 * 2. We call the function readByte()
	 */
    public static byte readByte (String msg) {
    	byte number=0;
    	//1. We throw the predetermined message
    	System.out.printf("%s\n", msg);
    	//2. We call the function readByte()
    	number=readByte();
    	
    	return number;
    }
    
    /* Short number reading function
     * @author Juan Antonio Tejada
     * 
	 * 1. We throw the predetermined message
	 * 2. We call the function readShort()
	 */
    public static short readShort (String msg) {
    	short number=0;
    	//1. We throw the predetermined message
    	System.out.printf("%s\n", msg);
    	//2. We call the function readShort()
    	number=readShort();
    	
    	return number;
    }
    
    /* Long number reading function
     * @author Juan Antonio Tejada
     * 
	 * 1. We throw the predetermined message
	 * 2. We call the function readLong()
	 */
    public static long readLong (String msg) {
    	long number=0;
    	//1. We throw the predetermined message
    	System.out.printf("%s\n", msg);
    	//2. We call the function readLong()
    	number=readLong();
    	
    	return number;
    }
    
    //___________________________________________________________________________________________________________________
  	//NUMBERS READING (WITHOUT MESSAGE)__________________________________________________________________________________
  		
  	/* Int number reading function
  	 * @author Juan Antonio Tejada Pérez
  	 * 
  	 * 1. We ask for a number
  	 * 2. We certify that the user entered an integer number
  	 * 3. We return the number
  	 */
    public static int readInt (){
          int number=0;
          boolean error=false;
          
          do {
          	error=false;
          	try {
          		number=keyboard.nextInt();
          		error=false;
          		//2. We certify that the user entered an integer number
          	} catch (InputMismatchException e) {
          		System.out.println(ROJO + "Error. NO SUITABLE NUMBER" + RESET);
          		error=true;
          	} finally {
          		keyboard.nextLine();
          	}
          }while (error==true);
          //3. We return the number
          return number;
      }
  	
    /* Double number reading function
      * @author Juan Antonio Tejada
      * 
      * 1. We certify that the user entered an integer number
      * 2. We return the number
      */
    public static double readDouble () {
      	double number=0;
      	boolean error=false;
      	
      	do {
      		error=false;
      		try {
      			number=keyboard.nextDouble();
      			error=false;
      		//1. We certify that the user entered an integer number
      		} catch (InputMismatchException e) {
      			System.out.println(ROJO + "Error. NO SUITABLE NUMBER" + RESET);
      			error=true;
      		} finally {
      			keyboard.nextLine();
      		}
      	} while(error==true);
      	//2. We return the number
      	return number;
      }
     
    /* Float number reading function
      * @author Juan Antonio Tejada
      * 
      * 1. We certify that the user entered an integer number
      * 2. We return the number
      */
    public static float readFloat () {
      	float number=0;
      	boolean error=false;
      	
      	do {
      		error=false;
      		try {
      			number=keyboard.nextFloat();
      			error=false;
      		//1. We certify that the user entered an integer number
      		} catch (InputMismatchException e) {
      			System.out.println(ROJO + "Error. NO SUITABLE NUMBER" + RESET);
      			error=true;
      		} finally {
      			keyboard.nextLine();
      		}
      	} while(error==true);
      	//2. We return the number
      	return number;
      }
      
    /* Byte number reading function
      * @author Juan Antonio Tejada
      * 
      * 1. We certify that the user entered an integer number
      * 2. We return the number       */
    public static byte readByte () {
      	byte number=0;
      	boolean error=false;
      	
      	do {
      		error=false;		
      		try {
      			number=keyboard.nextByte();
      			error=false;
      		//1. We certify that the user entered an integer number
      		}catch(InputMismatchException e) {
      			System.out.println(ROJO + "Error. NO SUITABLE NUMBER" + RESET);
      			error=true;
      		} finally {
      			keyboard.nextLine();
      		}
      	} while(error==true);
      	//2. We return the number
      	return number;
      }
      
    /* Short number reading function
      * @author Juan Antonio Tejada
      * 
      * 1. We certify that the user entered an integer number
      * 2. We return the number
      */
    public static short readShort () {
      	short number=0;
      	boolean error=false;
      	
      	do {
      		error=false;
      		System.out.printf("Write a short number:\n");
      		try {
      			number=keyboard.nextShort();
      			error=false;
      		//1. We certify that the user entered an integer number
      		} catch(InputMismatchException e) {
      			System.out.println( ROJO + "Error. NO SUITABLE NUMBER" + RESET);
      			error=true;
      		} finally {
      			keyboard.nextLine();
      		}
      	}while (error==true);
      	//2. We return the number
      	return number;
      }
      
    /* Long number reading function
      * @author Juan Antonio Tejada
      * 
      * 1. We certify that the user entered an integer number
      * 2. We return the number
      */
    public static long readLong () {
      	long number=0;
      	boolean error=false;
      	
      	do {
      		error=false;
      		try {
      			number=keyboard.nextShort();
      			error=false;
      		//1. We certify that the user entered an integer number
      		} catch(InputMismatchException e) {
      			System.out.println( ROJO + "Error. NO SUITABLE NUMBER" + RESET);
      			error=true;
      		} finally {
      			keyboard.nextLine();
      		}
      	}while (error==true);
      	//2. We return the number
      	return number;
      }
      
    //___________________________________________________________________________________________________________________
    //READ COMPARATION WITH OVERCHARGE___________________________________________________________________________________
      
    /*	Read comparation with overcharge for BYTES
      * @author Juan Antonio Tejada
      * 
      * 1. We ask for the number to the user
      * 2. We analyze the comparation the user wants
      * 3. We analyze if the number fits the comparation required by the user
      * 4. We return the result
      */
    public static byte readComparation(byte number, Comparation comp) {
    	boolean error=false;
    	byte numberUser;
    	
    	do {
    		//1. We ask for the number to the user
    		numberUser=readByte();
    		//2. We analyze the comparation the user wants
	    	switch(comp) {
	    	//3. We analyze if the number fits the comparation required by the user
	    	case BIGGEREQUAL:
	    		if(numberUser<number) {
	    			System.out.println(ROJO + "Error. Introduce a number bigger or equal than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case SMALLEREQUAL:
	    		if(numberUser>number) {
	    			System.out.println(ROJO + "Error. Introduce a number smaller or equal than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case BIGGER:
	    		if(numberUser<=number) {
	    			System.out.println(ROJO + "Error. Introduce a number bigger than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case SMALLER:
	    		if(numberUser<=number) {
	    			System.out.println(ROJO + "Error. Introduce a number smaller than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    	}
    	}while(error==true);
    	//4. We return the result
		return numberUser;
     }
     
    /*	Read comparation with overcharge for SHORT
      * @author Juan Antonio Tejada
      * 
      * 1. We ask for the number to the user
      * 2. We analyze the comparation the user wants
      * 3. We analyze if the number fits the comparation required by the user
      * 4. We return the result
      */
    public static short readComparation(short number, Comparation comp) {
    	boolean error=false;
    	short numberUser;
    	
    	do {
    		//1. We ask for the number to the user
    		numberUser=readShort();
    		//2. We analyze the comparation the user wants
	    	switch(comp) {
	    	//3. We analyze if the number fits the comparation required by the user
	    	case BIGGEREQUAL:
	    		if(numberUser<number) {
	    			System.out.println(ROJO + "Error. Introduce a number bigger or equal than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case SMALLEREQUAL:
	    		if(numberUser>number) {
	    			System.out.println(ROJO + "Error. Introduce a number smaller or equal than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case BIGGER:
	    		if(numberUser<=number) {
	    			System.out.println(ROJO + "Error. Introduce a number bigger than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case SMALLER:
	    		if(numberUser<=number) {
	    			System.out.println(ROJO + "Error. Introduce a number smaller than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    	}
    	}while(error==true);
    	//4. We return the result
		return numberUser;
     }

    /*	Read comparation with overcharge for LONG
      * @author Juan Antonio Tejada
      * 
      * 1. We ask for the number to the user
      * 2. We analyze the comparation the user wants
      * 3. We analyze if the number fits the comparation required by the user
      * 4. We return the result
      */
    public static long readComparation(long number, Comparation comp) {
    	boolean error=false;
    	long numberUser;
    	
    	do {
    		//1. We ask for the number to the user
    		numberUser=readLong();
    		//2. We analyze the comparation the user wants
	    	switch(comp) {
	    	//3. We analyze if the number fits the comparation required by the user
	    	case BIGGEREQUAL:
	    		if(numberUser<number) {
	    			System.out.println(ROJO + "Error. Introduce a number bigger or equal than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case SMALLEREQUAL:
	    		if(numberUser>number) {
	    			System.out.println(ROJO + "Error. Introduce a number smaller or equal than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case BIGGER:
	    		if(numberUser<=number) {
	    			System.out.println(ROJO + "Error. Introduce a number bigger than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case SMALLER:
	    		if(numberUser<=number) {
	    			System.out.println(ROJO + "Error. Introduce a number smaller than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    	}
    	}while(error==true);
    	//4. We return the result
		return numberUser;
     }

    /*	Read comparation with overcharge for INT
      * @author Juan Antonio Tejada
      * 
      * 1. We ask for the number to the user
      * 2. We analyze the comparation the user wants
      * 3. We analyze if the number fits the comparation required by the user
      * 4. We return the result
      */
    public static int readComparation(int number, Comparation comp) {
    	boolean error=false;
    	int numberUser;
    	
    	do {
    		//1. We ask for the number to the user
    		numberUser=readInt();
    		//2. We analyze the comparation the user wants
	    	switch(comp) {
	    	//3. We analyze if the number fits the comparation required by the user
	    	case BIGGEREQUAL:
	    		if(numberUser<number) {
	    			System.out.println(ROJO + "Error. Introduce a number bigger or equal than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case SMALLEREQUAL:
	    		if(numberUser>number) {
	    			System.out.println(ROJO + "Error. Introduce a number smaller or equal than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case BIGGER:
	    		if(numberUser<=number) {
	    			System.out.println(ROJO + "Error. Introduce a number bigger than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case SMALLER:
	    		if(numberUser<=number) {
	    			System.out.println(ROJO + "Error. Introduce a number smaller than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    	}
    	}while(error==true);
    	//4. We return the result
		return numberUser;
     }

     /*	Read comparation with overcharge for DOUBLE
      * @author Juan Antonio Tejada
      * 
      * 1. We ask for the number to the user
      * 2. We analyze the comparation the user wants
      * 3. We analyze if the number fits the comparation required by the user
      * 4. We return the result
      */
     public static double readComparation(double number, Comparation comp) {
    	boolean error=false;
    	double numberUser;
    	
    	do {
    		//1. We ask for the number to the user
    		numberUser=readDouble();
    		//2. We analyze the comparation the user wants
	    	switch(comp) {
	    	//3. We analyze if the number fits the comparation required by the user
	    	case BIGGEREQUAL:
	    		if(numberUser<number) {
	    			System.out.println(ROJO + "Error. Introduce a number bigger or equal than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case SMALLEREQUAL:
	    		if(numberUser>number) {
	    			System.out.println(ROJO + "Error. Introduce a number smaller or equal than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case BIGGER:
	    		if(numberUser<=number) {
	    			System.out.println(ROJO + "Error. Introduce a number bigger than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case SMALLER:
	    		if(numberUser<=number) {
	    			System.out.println(ROJO + "Error. Introduce a number smaller than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    	}
    	}while(error==true);
    	//4. We return the result
		return numberUser;
     }

     /*	Read comparation with overcharge for FLOAT
      * @author Juan Antonio Tejada
      * 
      * 1. We ask for the number to the user
      * 2. We analyze the comparation the user wants
      * 3. We analyze if the number fits the comparation required by the user
      * 4. We return the result
      */
     public static float readComparation(float number, Comparation comp) {
    	boolean error=false;
    	float numberUser;
    	
    	do {
    		//1. We ask for the number to the user
    		numberUser=readFloat();
    		//2. We analyze the comparation the user wants
	    	switch(comp) {
	    	//3. We analyze if the number fits the comparation required by the user
	    	case BIGGEREQUAL:
	    		if(numberUser<number) {
	    			System.out.println(ROJO + "Error. Introduce a number bigger or equal than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case SMALLEREQUAL:
	    		if(numberUser>number) {
	    			System.out.println(ROJO + "Error. Introduce a number smaller or equal than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case BIGGER:
	    		if(numberUser<=number) {
	    			System.out.println(ROJO + "Error. Introduce a number bigger than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    		
	    	case SMALLER:
	    		if(numberUser<=number) {
	    			System.out.println(ROJO + "Error. Introduce a number smaller than" + RESET + AZUL + number + RESET);
	    			error=true;
	    		}
	    		else {
	    			error=false;
	    		}
	    		break;
	    	}
    	}while(error==true);
    	//4. We return the result
		return numberUser;
     }
     
     //___________________________________________________________________________________________________________________
     //READ COMPARATION WITH OVERCHARGE (WITH CUSTOM MESSAGES)__________________________________________________________
      
     /*	Read comparation with overcharge for BYTES
      * @author Juan Antonio Tejada
      * 
      * 1. We throw the predetermined message
      * 2. We call the function
      */
     public static byte readComparation(byte number, Comparation comp, String msg) {
    	byte numberUser;
    	//1. We throw the predetermined message
    	System.out.printf("%s\n", msg);
    	//2. We call the function
    	numberUser=readComparation(number,comp);
    	
		return numberUser;
     }
     
     /*	Read comparation with overcharge for SHORT
      * @author Juan Antonio Tejada
      * 
      * 1. We throw the predetermined message
      * 2. We call the function
      */
     public static short readComparation(short number, Comparation comp, String msg) {
    	short numberUser;
    	//1. We throw the predetermined message
    	System.out.printf("%s\n", msg);
    	//2. We call the function
    	numberUser=readComparation(number,comp);
    	
		return numberUser;
     }

     /*	Read comparation with overcharge for LONG
      * @author Juan Antonio Tejada
      * 
      * 1. We throw the predetermined message
      * 2. We call the function
      */
     public static long readComparation(long number, Comparation comp, String msg) {
    	long numberUser;
    	
    	//1. We throw the predetermined message
    	System.out.printf("%s\n", msg);
    	//2. We call the function
    	numberUser=readComparation(number,comp);
    	
		return numberUser;
     }

     /*	Read comparation with overcharge for INT
      * @author Juan Antonio Tejada
      * 
      * 1. We throw the predetermined message
      * 2. We call the function
      */
     public static int readComparation(int number, Comparation comp, String msg) {
    	int numberUser;
    	
    	//1. We throw the predetermined message
    	System.out.printf("%s\n", msg);
    	//2. We call the function
    	numberUser=readComparation(number,comp);
    	
		return numberUser;
     }

     /*	Read comparation with overcharge for DOUBLE
      * @author Juan Antonio Tejada
      * 
      * 1. We throw the predetermined message
      * 2. We call the function
      */
     public static double readComparation(double number, Comparation comp, String msg) {
    	double numberUser;
    	
    	//1. We throw the predetermined message
    	System.out.printf("%s\n", msg);
    	//2. We call the function
    	numberUser=readComparation(number,comp);
    	
		return numberUser;
     }

     /*	Read comparation with overcharge for FLOAT
      * @author Juan Antonio Tejada
      * 
      * 1. We throw the predetermined message
      * 2. We call the function
      */
     public static float readComparation(float number, Comparation comp, String msg) {
    	float numberUser;
    	
    	//1. We throw the predetermined message
    	System.out.printf("%s\n", msg);
    	//2. We call the function
    	numberUser=readComparation(number,comp);
    	
		return numberUser;
     }

     //___________________________________________________________________________________________________________________
     //READ A NUMBER IN A RANGE___________________________________________________________________________________________
     
     /* Read a number between a range with overcharge for BYTES
      * @author Juan Antonio Tejada
      * 
      * 1. We report to the user if the minimum number is bigger than the maximum
      * 2. We ask for the number we want to study
      * 	2.1 If the number is not between the range (both included), we report
      * 	2.2 If the number is not between the range (both excluded), we report
      * 	2.3 If the number is not between the range (minimun included, maximun excluded), we report
      * 	2.4 If the number is not between the range (minimum excluded, maximun included), we report
      * 3. We return the number if it pass all the tests
      */
     public static byte readRange(byte min, byte max, Range range) {
    	 //1. We report to the user if the minimum number is bigger than the maximum
    	 if(min>max) {
    		 throw new IllegalArgumentException(ROJO+ "Error. Maximum number cannot be smaller than minimun number" + RESET);
    	 }
    	 
    	 byte numberUser;
    	 boolean error=false;
    	 
    	 do {
    		 error=false;
    		 
    		 //1. We ask for the number we want to study
    		 numberUser=readByte();
    		 
    		 switch(range) {
    		 	
    		 //1.1 If the number is not between the range (both included), we report
    		 case BOTHINCLUDED:
    			 if(numberUser<min || numberUser>max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " and " + RESET + AZUL + max + RESET + ROJO + ", both included");
    				 error=true;
    			 }
    			 break;
    			 
    		 //1.2 If the number is not between the range (both excluded), we report
    		 case BOTHEXCLUDED:
    			 if(numberUser<=min || numberUser>=max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " and " + RESET + AZUL + max + RESET + ROJO + ", both excluded");
    				 error=true;
    			 }
    			 break;
    		
    		 //1.3 If the number is not between the range (minimun included, maximun excluded), we report
    		 case MINIMUNINCLUDED_MAXIMUNEXCLUDED:
    			 if(numberUser<min || numberUser>=max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " included and " + RESET + AZUL + max + RESET + ROJO + " excluded");
    			 }
    			 break;
    			 
    		 //1.4 If the number is not between the range (minimum excluded, maximun included), we report
    		 case MINIMUMEXCLUDED_MAXIMUMINCLUDED:
    			 if(numberUser<=min || numberUser>max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " excluded and " + RESET + AZUL + max + RESET + ROJO + " included");
    			 }
    			 break;
    		 }
    	 }while(error==true);
    	 
    	 //2. We return the number if it pass all the tests
    	 return numberUser;
     }
     
     /* Read a number between a range with overcharge for SHORT
      * @author Juan Antonio Tejada
      * 
      * 1. We report to the user if the minimum number is bigger than the maximum
      * 2. We ask for the number we want to study
      * 	2.1 If the number is not between the range (both included), we report
      * 	2.2 If the number is not between the range (both excluded), we report
      * 	2.3 If the number is not between the range (minimun included, maximun excluded), we report
      * 	2.4 If the number is not between the range (minimum excluded, maximun included), we report
      * 3. We return the number if it pass all the tests
      */
     public static short readRange(short min, short max, Range range) {
    	 //1. We report to the user if the minimum number is bigger than the maximum
    	 if(min>max) {
    		 throw new IllegalArgumentException(ROJO+ "Error. Maximum number cannot be smaller than minimun number" + RESET);
    	 }
    	 
    	 short numberUser;
    	 boolean error=false;
    	 
    	 do {
    		 error=false;
    		 
    		 //2. We ask for the number we want to study
    		 numberUser=readShort();
    		 
    		 switch(range) {
    		 	
    		 //2.1 If the number is not between the range (both included), we report
    		 case BOTHINCLUDED:
    			 if(numberUser<min || numberUser>max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " and " + RESET + AZUL + max + RESET + ROJO + ", both included");
    				 error=true;
    			 }
    			 break;
    			 
    		 //2.2 If the number is not between the range (both excluded), we report
    		 case BOTHEXCLUDED:
    			 if(numberUser<=min || numberUser>=max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " and " + RESET + AZUL + max + RESET + ROJO + ", both excluded");
    				 error=true;
    			 }
    			 break;
    		
    		 //2.3 If the number is not between the range (minimun included, maximun excluded), we report
    		 case MINIMUNINCLUDED_MAXIMUNEXCLUDED:
    			 if(numberUser<min || numberUser>=max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " included and " + RESET + AZUL + max + RESET + ROJO + " excluded");
    			 }
    			 break;
    			 
    		 //2.4 If the number is not between the range (minimum excluded, maximun included), we report
    		 case MINIMUMEXCLUDED_MAXIMUMINCLUDED:
    			 if(numberUser<=min || numberUser>max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " excluded and " + RESET + AZUL + max + RESET + ROJO + " included");
    			 }
    			 break;
    		 }
    	 }while(error==true);
    	 
    	 //3. We return the number if it pass all the tests
    	 return numberUser;
     }
     
     /* Read a number between a range with overcharge for LONG
      * @author Juan Antonio Tejada
      * 
      * 1. We report to the user if the minimum number is bigger than the maximum
      * 2. We ask for the number we want to study
      * 	2.1 If the number is not between the range (both included), we report
      * 	2.2 If the number is not between the range (both excluded), we report
      * 	2.3 If the number is not between the range (minimun included, maximun excluded), we report
      * 	2.4 If the number is not between the range (minimum excluded, maximun included), we report
      * 3. We return the number if it pass all the tests
      */
     public static long readRange(long min, long max, Range range) {
    	 //1. We report to the user if the minimum number is bigger than the maximum
    	 if(min>max) {
    		 throw new IllegalArgumentException(ROJO+ "Error. Maximum number cannot be smaller than minimun number" + RESET);
    	 }
    	 
    	 long numberUser;
    	 boolean error=false;
    	 
    	 do {
    		 error=false;
    		 
    		 //2. We ask for the number we want to study
    		 numberUser=readByte();
    		 
    		 switch(range) {
    		 	
    		 //2.1 If the number is not between the range (both included), we report
    		 case BOTHINCLUDED:
    			 if(numberUser<min || numberUser>max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " and " + RESET + AZUL + max + RESET + ROJO + ", both included");
    				 error=true;
    			 }
    			 break;
    			 
    		 //2.2 If the number is not between the range (both excluded), we report
    		 case BOTHEXCLUDED:
    			 if(numberUser<=min || numberUser>=max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " and " + RESET + AZUL + max + RESET + ROJO + ", both excluded");
    				 error=true;
    			 }
    			 break;
    		
    		 //2.3 If the number is not between the range (minimun included, maximun excluded), we report
    		 case MINIMUNINCLUDED_MAXIMUNEXCLUDED:
    			 if(numberUser<min || numberUser>=max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " included and " + RESET + AZUL + max + RESET + ROJO + " excluded");
    			 }
    			 break;
    			 
    		 //2.4 If the number is not between the range (minimum excluded, maximun included), we report
    		 case MINIMUMEXCLUDED_MAXIMUMINCLUDED:
    			 if(numberUser<=min || numberUser>max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " excluded and " + RESET + AZUL + max + RESET + ROJO + " included");
    			 }
    			 break;
    		 }
    	 }while(error==true);
    	 
    	 //3. We return the number if it pass all the tests
    	 return numberUser;
     }

     /* Read a number between a range with overcharge for INT
      * @author Juan Antonio Tejada
      * 
      * 1. We report to the user if the minimum number is bigger than the maximum
      * 2. We ask for the number we want to study
      * 	2.1 If the number is not between the range (both included), we report
      * 	2.2 If the number is not between the range (both excluded), we report
      * 	2.3 If the number is not between the range (minimun included, maximun excluded), we report
      * 	2.4 If the number is not between the range (minimum excluded, maximun included), we report
      * 3. We return the number if it pass all the tests
      */
     public static int readRange(int min, int max, Range range) {
    	 //1. We report to the user if the minimum number is bigger than the maximum
    	 if(min>max) {
    		 throw new IllegalArgumentException(ROJO+ "Error. Maximum number cannot be smaller than minimun number" + RESET);
    	 }
    	 
    	 int numberUser;
    	 boolean error=false;
    	 
    	 do {
    		 error=false;
    		 
    		 //2. We ask for the number we want to study
    		 numberUser=readInt();
    		 
    		 switch(range) {
    		 	
    		 //2.1 If the number is not between the range (both included), we report
    		 case BOTHINCLUDED:
    			 if(numberUser<min || numberUser>max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " and " + RESET + AZUL + max + RESET + ROJO + ", both included");
    				 error=true;
    			 }
    			 break;
    			 
    		 //2.2 If the number is not between the range (both excluded), we report
    		 case BOTHEXCLUDED:
    			 if(numberUser<=min || numberUser>=max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " and " + RESET + AZUL + max + RESET + ROJO + ", both excluded");
    				 error=true;
    			 }
    			 break;
    		
    		 //2.3 If the number is not between the range (minimun included, maximun excluded), we report
    		 case MINIMUNINCLUDED_MAXIMUNEXCLUDED:
    			 if(numberUser<min || numberUser>=max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " included and " + RESET + AZUL + max + RESET + ROJO + " excluded");
    			 }
    			 break;
    			 
    		 //2.4 If the number is not between the range (minimum excluded, maximun included), we report
    		 case MINIMUMEXCLUDED_MAXIMUMINCLUDED:
    			 if(numberUser<=min || numberUser>max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " excluded and " + RESET + AZUL + max + RESET + ROJO + " included");
    			 }
    			 break;
    		 }
    	 }while(error==true);
    	 
    	 //3. We return the number if it pass all the tests
    	 return numberUser;
     }

     /* Read a number between a range with overcharge for DOUBLE
      * @author Juan Antonio Tejada
      * 
      * 1. We report to the user if the minimum number is bigger than the maximum
      * 2. We ask for the number we want to study
      * 	2.1 If the number is not between the range (both included), we report
      * 	2.2 If the number is not between the range (both excluded), we report
      * 	2.3 If the number is not between the range (minimun included, maximun excluded), we report
      * 	2.4 If the number is not between the range (minimum excluded, maximun included), we report
      * 3. We return the number if it pass all the tests
      */
     public static double readRange(double min, double max, Range range) {
    	 //1. We report to the user if the minimum number is bigger than the maximum
    	 if(min>max) {
    		 throw new IllegalArgumentException(ROJO+ "Error. Maximum number cannot be smaller than minimun number" + RESET);
    	 }
    	 
    	 double numberUser;
    	 boolean error=false;
    	 
    	 do {
    		 error=false;
    		 
    		 //2. We ask for the number we want to study
    		 numberUser=readDouble();
    		 
    		 switch(range) {
    		 	
    		 //2.1 If the number is not between the range (both included), we report
    		 case BOTHINCLUDED:
    			 if(numberUser<min || numberUser>max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " and " + RESET + AZUL + max + RESET + ROJO + ", both included");
    				 error=true;
    			 }
    			 break;
    			 
    		 //2.2 If the number is not between the range (both excluded), we report
    		 case BOTHEXCLUDED:
    			 if(numberUser<=min || numberUser>=max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " and " + RESET + AZUL + max + RESET + ROJO + ", both excluded");
    				 error=true;
    			 }
    			 break;
    		
    		 //2.3 If the number is not between the range (minimun included, maximun excluded), we report
    		 case MINIMUNINCLUDED_MAXIMUNEXCLUDED:
    			 if(numberUser<min || numberUser>=max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " included and " + RESET + AZUL + max + RESET + ROJO + " excluded");
    			 }
    			 break;
    			 
    		 //2.4 If the number is not between the range (minimum excluded, maximun included), we report
    		 case MINIMUMEXCLUDED_MAXIMUMINCLUDED:
    			 if(numberUser<=min || numberUser>max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " excluded and " + RESET + AZUL + max + RESET + ROJO + " included");
    			 }
    			 break;
    		 }
    	 }while(error==true);
    	 
    	 //3. We return the number if it pass all the tests
    	 return numberUser;
     }
     
     /* Read a number between a range with overcharge for FLOAT
      * @author Juan Antonio Tejada
      * 
      * 1. We report to the user if the minimum number is bigger than the maximum
      * 2. We ask for the number we want to study
      * 	2.1 If the number is not between the range (both included), we report
      * 	2.2 If the number is not between the range (both excluded), we report
      * 	2.3 If the number is not between the range (minimun included, maximun excluded), we report
      * 	2.4 If the number is not between the range (minimum excluded, maximun included), we report
      * 3. We return the number if it pass all the tests
      */
     public static float readRange(float min, float max, Range range) {
    	 //1. We report to the user if the minimum number is bigger than the maximum
    	 if(min>max) {
    		 throw new IllegalArgumentException(ROJO+ "Error. Maximum number cannot be smaller than minimun number" + RESET);
    	 }
    	 
    	 float numberUser;
    	 boolean error=false;
    	 
    	 do {
    		 error=false;
    		 
    		 //2. We ask for the number we want to study
    		 numberUser=readFloat();
    		 
    		 switch(range) {
    		 	
    		 //2.1 If the number is not between the range (both included), we report
    		 case BOTHINCLUDED:
    			 if(numberUser<min || numberUser>max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " and " + RESET + AZUL + max + RESET + ROJO + ", both included");
    				 error=true;
    			 }
    			 break;
    			 
    		 //2.2 If the number is not between the range (both excluded), we report
    		 case BOTHEXCLUDED:
    			 if(numberUser<=min || numberUser>=max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " and " + RESET + AZUL + max + RESET + ROJO + ", both excluded");
    				 error=true;
    			 }
    			 break;
    		
    		 //2.3 If the number is not between the range (minimun included, maximun excluded), we report
    		 case MINIMUNINCLUDED_MAXIMUNEXCLUDED:
    			 if(numberUser<min || numberUser>=max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " included and " + RESET + AZUL + max + RESET + ROJO + " excluded");
    			 }
    			 break;
    			 
    		 //2.4 If the number is not between the range (minimum excluded, maximun included), we report
    		 case MINIMUMEXCLUDED_MAXIMUMINCLUDED:
    			 if(numberUser<=min || numberUser>max) {
    				 System.out.println(ROJO + "Error. The number must be between " + RESET + AZUL + min + RESET + ROJO + " excluded and " + RESET + AZUL + max + RESET + ROJO + " included");
    			 }
    			 break;
    		 }
    	 }while(error==true);
    	 
    	 //3. We return the number if it pass all the tests
    	 return numberUser;
     }

     //___________________________________________________________________________________________________________________
     //READ A NUMBER IN A RANGE (WITH CUSTOM MESSAGES)____________________________________________________________________
     
     /* Read a number between a range with overcharge for BYTES
      * @author Juan Antonio Tejada
      * 
      * 1. We report to the user if the minimum number is bigger than the maximum
      * 2. We throw the predetermined message
      * 3. We call the function
      */
     public static byte readRange(byte min, byte max, Range range, String msg) {
    	 //1. We report to the user if the minimum number is bigger than the maximum
    	 if(min>max) {
    		 throw new IllegalArgumentException(ROJO+ "Error. Maximum number cannot be smaller than minimun number" + RESET);
    	 }
    	 
    	 byte numberUser;
    	 //2. We throw the predetermined message
    	 System.out.printf("%s\n", msg);
    	 //3. We call the function
    	 numberUser=readRange(min,max,range);
    	 
    	 return numberUser;
     }
     
     /* Read a number between a range with overcharge for SHORT
      * @author Juan Antonio Tejada
      * 
      * 1. We report to the user if the minimum number is bigger than the maximum
      * 2. We throw the predetermined message
      * 3. We call the function
      */
     public static short readRange(short min, short max, Range range, String msg) {
    	//1. We report to the user if the minimum number is bigger than the maximum
    	 if(min>max) {
    		 throw new IllegalArgumentException(ROJO+ "Error. Maximum number cannot be smaller than minimun number" + RESET);
    	 }
    	 
    	 short numberUser;
    	 //2. We throw the predetermined message
    	 System.out.printf("%s\n", msg);
    	 //3. We call the function
    	 numberUser=readRange(min,max,range);
    	 
    	 return numberUser;
     }
     
     /* Read a number between a range with overcharge for LONG
      * @author Juan Antonio Tejada
      * 
      * 1. We report to the user if the minimum number is bigger than the maximum
      * 2. We throw the predetermined message
      * 3. We call the function
      */
     public static long readRange(long min, long max, Range range, String msg) {
    	//1. We report to the user if the minimum number is bigger than the maximum
    	 if(min>max) {
    		 throw new IllegalArgumentException(ROJO+ "Error. Maximum number cannot be smaller than minimun number" + RESET);
    	 }
    	 
    	 long numberUser;
    	 //2. We throw the predetermined message
    	 System.out.printf("%s\n", msg);
    	 //3. We call the function
    	 numberUser=readRange(min,max,range);
    	 
    	 return numberUser;
     }

     /* Read a number between a range with overcharge for INT
      * @author Juan Antonio Tejada
      * 
      * 1. We report to the user if the minimum number is bigger than the maximum
      * 2. We throw the predetermined message
      * 3. We call the function
      */
     public static int readRange(int min, int max, Range range, String msg) {
    	//1. We report to the user if the minimum number is bigger than the maximum
    	 if(min>max) {
    		 throw new IllegalArgumentException(ROJO+ "Error. Maximum number cannot be smaller than minimun number" + RESET);
    	 }
    	 
    	 int numberUser;
    	 //2. We throw the predetermined message
    	 System.out.printf("%s\n", msg);
    	 //3. We call the function
    	 numberUser=readRange(min,max,range);
    	 
    	 return numberUser;
     }

     /* Read a number between a range with overcharge for DOUBLE
      * @author Juan Antonio Tejada
      * 
      * 1. We report to the user if the minimum number is bigger than the maximum
      * 2. We throw the predetermined message
      * 3. We call the function
      */
     public static double readRange(double min, double max, Range range, String msg) {
    	//1. We report to the user if the minimum number is bigger than the maximum
    	 if(min>max) {
    		 throw new IllegalArgumentException(ROJO+ "Error. Maximum number cannot be smaller than minimun number" + RESET);
    	 }
    	 
    	 double numberUser;
    	 //2. We throw the predetermined message
    	 System.out.printf("%s\n", msg);
    	 //3. We call the function
    	 numberUser=readRange(min,max,range);
    	 
    	 return numberUser;
     }
     
     /* Read a number between a range with overcharge for FLOAT
      * @author Juan Antonio Tejada
      * 
      * 1. We report to the user if the minimum number is bigger than the maximum
      * 2. We throw the predetermined message
      * 3. We call the function
      */
     public static float readRange(float min, float max, Range range, String msg) {
    	//1. We report to the user if the minimum number is bigger than the maximum
    	 if(min>max) {
    		 throw new IllegalArgumentException(ROJO+ "Error. Maximum number cannot be smaller than minimun number" + RESET);
    	 }
    	 
    	 float numberUser;
    	 //2. We throw the predetermined message
    	 System.out.printf("%s\n", msg);
    	 //3. We call the function
    	 numberUser=readRange(min,max,range);
    	 
    	 return numberUser;
     }


}

