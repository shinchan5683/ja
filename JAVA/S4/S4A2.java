import java.util.*;

public class S4A2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String,String> cityCodes = new HashMap<>();

        cityCodes.put("Mumbai","22");
        cityCodes.put("Pune","20");
        cityCodes.put("Delhi","11");
        cityCodes.put("Bangalore","80");
        cityCodes.put("Chennai","44");

        System.out.println("Enter the city name to add:");
        String newCity = sc.nextLine();
        System.out.println("Enter the STD code for "+newCity+":");
        String newCode = sc.nextLine();
        cityCodes.put(newCity,newCode);
        System.out.println("City Codes: "+cityCodes);

        System.out.println("Enter the city name to remove:");
        String removeCity = sc.nextLine();
        cityCodes.remove(removeCity);

        System.out.println("Enter the city name to search:");
        String searchCity = sc.nextLine();
        String code = cityCodes.get(searchCity);
        if(code != null){
            System.out.println("The STD code for "+searchCity+" is "+code);
        }
        else{
            System.out.println(searchCity+"City Not Found");
        }
        sc.close();
    }
}
