import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Test {
    static int metodo2 ( ) throws IOException   {
        BufferedReader fich= new BufferedReader(new FileReader("fich.txt") );
        String s="20";
        int r=0,c=0, n=0;
        s=fich.readLine();
        while (fich.ready()){
            s=fich.readLine();
            n=Integer.parseInt(s);
            r=r+n;
            if (n%2==0)
                s=fich.readLine();
            c++;
        }
        fich.close();
        return r;
    }

    static int metodo () throws IOException {
        String vs[]={"dos","3" ,"cinco","6"};
        int res=0;
        for (int i=0; i<4; i++) {
            try {
                res=res+Integer.parseInt(vs[i]);
            } catch (Exception e) {
                res+=1;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        System.out.println (new String ("1234").concat(" ").
                replace("2", "5").charAt(2) );
        StringBuffer sb=new StringBuffer ("Jose Manuel");
        sb.setLength(4);
        System.out.println (sb.charAt(sb.length()-1));
       // new String("Hola").setCharAt(2,’b’);
        System.out.println (new StringBuffer("hola").capacity());

        System.out.println("metodo "+metodo());
        System.out.println("metodo2 "+metodo2());
    }
}
