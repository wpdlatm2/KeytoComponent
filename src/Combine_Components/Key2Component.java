package Combine_Components;
import java.util.Scanner;
import java.util.Random;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.IllegalBlockSizeException;



public class Key2Component {

	public String getRandomHexString(int numchars){
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		while(sb.length() < numchars){ 
			sb.append(Integer.toHexString(r.nextInt()));
		 }

		 return sb.toString().substring(0, numchars);
	 }

	public String getRandomString(int numchars){ 
		Random r = new Random(); 
		StringBuffer sb = new StringBuffer(); 
		while(sb.length() < numchars){ 
			sb.append(Integer.toUnsignedString(r.nextInt()));
		 } 
		return sb.toString().substring(0, numchars);
	 }


	public static void main(String[] args) throws 
	 InvalidKeyException, NoSuchAlgorithmException, 
	 NoSuchPaddingException, BadPaddingException, 
	 IllegalBlockSizeException {
	
	
		String masterKey;

		Key2Component KC = new Key2Component();

                System.out.println("--------------------------------------------------------");
                System.out.println("    Cipher key Component Tool for Kakaobank    ");
                System.out.println("--------------------------------------------------------");

		Scanner sc = new Scanner(System.in);
		System.out.println("Input Masterkey");
		masterKey = sc.next();
		int keysize = masterKey.length();

                String keypart1 = KC.getRandomHexString(keysize);
                String keypart2 = KC.getRandomHexString(keysize);


                if(keysize % 8 != 0) {
                        System.out.println("!!!!!! ERROR : Invalid Key. Check data and Re-run !!!!!!");
                        System.out.println("--------------------------------------------------------");
			System.exit(999);
		}


                System.out.println("");

                byte[] BmasterKey = SC.hexStringToByteArray(masterKey);
                byte[] Bkeypart1 = SC.hexStringToByteArray(keypart1);
                byte[] Bkeypart2 = SC.hexStringToByteArray(keypart2);

                byte[] Bkeypart3 = XOR.xor3key(Bkeypart1, Bkeypart2, BmasterKey);
                byte[] BkeyCombine3 = XOR.xor3key(Bkeypart1, Bkeypart2, Bkeypart3);
		
                System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println("MasterKey("+keypart1.length()+" Char): "+masterKey+"");
        System.out.println("----------------------------------------------------------------------------------------------------------------");
                System.out.println("");
                System.out.println("[3 Component]");
                System.out.println("----------------------------------------------------------------------------------------------------------------");

                String B2Skeypart1 = SC.byteArrayToHexString(Bkeypart1);
                String B2Skeypart2 = SC.byteArrayToHexString(Bkeypart2);
                String B2Skeypart3 = SC.byteArrayToHexString(Bkeypart3);
                String B2SkeyCombine3 = SC.byteArrayToHexString(BkeyCombine3);
                String KCV0= KCV.AES(masterKey);
                String KCV1= KCV.AES(B2Skeypart1);
                String KCV2= KCV.AES(B2Skeypart2);
                String KCV3= KCV.AES(B2Skeypart3);

		System.out.println("Component 1("+B2Skeypart1.length()+" Char): "+B2Skeypart1+"   KCV(AES)  " +KCV1.substring(0,6));
		System.out.println("Component 2("+B2Skeypart2.length()+" Char): "+B2Skeypart2+"   KCV(AES)  " +KCV2.substring(0,6));
		System.out.println("Component 3("+B2Skeypart3.length()+" Char): "+B2Skeypart3+"   KCV(AES)  " +KCV3.substring(0,6));
                System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println("Combined Key("+B2SkeyCombine3.length()+" Char): "+B2SkeyCombine3+"   KCV(AES)  " +KCV0.substring(0,6));
        System.out.println("----------------------------------------------------------------------------------------------------------------");


                Bkeypart2 = XOR.xor2key(Bkeypart1, BmasterKey);
                byte[] BkeyCombine2 = XOR.xor2key(Bkeypart1, Bkeypart2);

                B2Skeypart2 = SC.byteArrayToHexString(Bkeypart2);
                KCV2= KCV.AES(B2Skeypart2);
                String B2SkeyCombine2 = SC.byteArrayToHexString(BkeyCombine2);
                
                System.out.println("");
                System.out.println("");
                System.out.println("[2 Component]");
                System.out.println("----------------------------------------------------------------------------------------------------------------");
                System.out.println("Component 1("+B2Skeypart1.length()+" Char): "+B2Skeypart1+"   KCV(AES)  " +KCV1.substring(0,6));
                System.out.println("Component 2("+B2Skeypart2.length()+" Char): "+B2Skeypart2+"   KCV(AES)  " +KCV2.substring(0,6));
                System.out.println("----------------------------------------------------------------------------------------------------------------");
		System.out.println("Combined Key("+B2SkeyCombine3.length()+" Char): "+B2SkeyCombine2+"   KCV(AES)  " +KCV0.substring(0,6));
        System.out.println("----------------------------------------------------------------------------------------------------------------");

	}
}

