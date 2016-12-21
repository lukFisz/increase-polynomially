import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = "";
        String s2 = "";

        while(true){
            s1 = in.nextLine();
            if (!Pattern.matches("\\[[-0-9. ]+]", s1)) {
                System.out.println("error");
                continue;
            }
            s2 = in.nextLine();
            if (!Pattern.matches("\\[[-0-9. ]+]", s2)) {
                System.out.println("error");
                continue;
            }
            break;
        }

        s1 = s1.substring(1, s1.length()-1);
        s2 = s2.substring(1, s2.length()-1);

        String[] a = s1.split(" ");
        String[] b = s2.split(" ");

        double[] g = new double[a.length];
        double[] f = new double[b.length];

        for(int i=0; i<a.length; i++){
            g[i] = Double.parseDouble(a[i]);
        }
        for(int i=0; i<b.length; i++){
            f[i] = Double.parseDouble(b[i]);
        }

        multiplyPolynomials(g, f);
    }

    public static void multiplyPolynomials(double[] polynom1, double[] polynom2){
        int z = polynom1.length + polynom2.length - 1;
        double[] polynom = new double[z];

        for(int i=0; i<polynom1.length; i++){

            for(int j=0; j<polynom2.length; j++){
                polynom[i+j] += polynom1[i]*polynom2[j];
            }
        }

        StringJoiner joiner = new StringJoiner("");
        for(int i=0; i<polynom.length; i++){
            if( polynom[i]!=0 ){
                if ( joiner.length()==0 ){
                    joiner.add(""+polynom[i]);
                }
                else if (polynom[i]<0){
                    joiner.add(" - "+polynom[i]*-1);
                }
                else{
                    joiner.add(" + "+polynom[i]);
                }
                if(polynom.length-i-1!=1 && polynom.length-i-1!=0)
                    joiner.add("*x^"+(polynom.length-i-1));
                else if(polynom.length-i-1==1)
                    joiner.add("*x");
            }
        }
        System.out.println(joiner);
    }
}
