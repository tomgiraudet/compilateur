import java.io.*;

public class Ecriture {
    public static OutputStream ouvrir(String nomFichier) {
    	OutputStream f;
    	
    	try {
    		f = new DataOutputStream(new FileOutputStream(nomFichier));
    	} catch (IOException e) {
    		f = null;
    	}
    	
    	return f;
    }
    
    public static void fermer(OutputStream f) {                                     
    	try {
    		f.close();
    	} catch (IOException e) {
    		Ecriture.erreur(e);
    	}
    }
    
	private static void erreur(IOException e) {
        System.out.println(e.getMessage());
        System.out.println("Erreur fatale");
        System.exit(1);
    }
    
	
    public static void ecrireChar(OutputStream f, char c) {
    	try {
    		f.write(c);
    	} catch(IOException e) {
    		Ecriture.erreur(e);
        }
    }

    public static void ecrireChar(char c) {
    	Ecriture.ecrireChar(System.out, c);
    }
    
    public static void ecrireString(OutputStream f, String s) {
    	try {
    		for (int i = 0 ; i < s.length() ; i++) {
    			f.write(s.charAt(i));
    		}
    	} catch(IOException e) {
    		Ecriture.erreur(e);
        }
    }

    public static void ecrireString(String s) {
    	Ecriture.ecrireString(System.out, s);
    }

    public static void ecrireStringln(OutputStream f, String s) {
    	Ecriture.ecrireString(f, s + "\r\n");
    }

    public static void ecrireStringln(String s) {
    	Ecriture.ecrireStringln(System.out, s);
    }

    public static void ecrireInt(OutputStream f, int x) {
    	Ecriture.ecrireString(f, Integer.toString(x));
    }

    public static void ecrireInt(int x) {
    	Ecriture.ecrireInt(System.out, x);
    }
    
    public static void ecrireInt(OutputStream f, int x, int longueur) {
    	String s = Integer.toString(x);
    	int k = longueur - s.length();
    	
    	for (int i = 0 ; i < k ; i++) {
    		Ecriture.ecrireChar(f, ' ');
    	}
    	
    	Ecriture.ecrireString(f, s);
    }

    public static void ecrireInt(int x, int longueur) {
    	Ecriture.ecrireInt(System.out, x, longueur);
    }
    
    
    public static void ecrireDouble(OutputStream f, double d) {
    	Ecriture.ecrireString(f, Double.toString(d));
    }
    
    public static void ecrireDouble(double d) {
    	Ecriture.ecrireDouble(System.out, d);
    }
    
    public static void ecrireDouble(OutputStream f, double d, int longueur) {
    	String s = Double.toString(d);
    	int k = longueur - s.length();
    	
    	for (int i = 0 ; i < k ; i++) {
    		Ecriture.ecrireChar(f, ' ');
    	}
    	
    	Ecriture.ecrireString(f, s);
    }

    public static void ecrireDouble(double d, int longueur) {
    	Ecriture.ecrireDouble(System.out, d, longueur);
    }
}