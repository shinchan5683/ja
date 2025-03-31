import java.util.*;

class VowelThread extends Thread{
    String str;
    VowelThread(String str){
        this.str = str;
    }

    public void run(){
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' ||
                ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                        System.out.println(ch);
                        try{
                            Thread.sleep(3000);
                        }catch(InterruptedException e){
                            System.out.println(e);
                        }
            }
        }
    }
}

class S23A1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.println("Enter a String:");
        str = sc.next();
        VowelThread vt = new VowelThread(str);
        vt.start();
    }
}
