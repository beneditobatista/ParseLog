import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ParseLog {

    public static void main(String[] args) {
    	
    	if (args.length>0){
    	
    	try {
            
    		String regex = "(request_to=\\\"(.*?)\\\")(?:.*?)(response_status=\\\"(.*?)\\\")";
    		Pattern pattern = Pattern.compile(regex);
            String linha;
            List<Result> resultUrls= new ArrayList<Result>();
            List<Result> resultStatusCodes= new ArrayList<Result>();
    		List<String> urls= new ArrayList<String>();
    		List<String> statuscodes= new ArrayList<String>();
    		
            
    		BufferedReader br = new BufferedReader (new FileReader (args[0].toString()));
            while ((linha = br.readLine()) != null) {

        		Matcher m = pattern.matcher(linha);
            	if (m.find( )) {
                    urls.add(m.group(2));
                    statuscodes.add(m.group(4));
            	}                
            }
            br.close();
        	
        	resultUrls = Calcula(urls);
        	resultStatusCodes=Calcula(statuscodes);
        	
        	ShowHigh(resultUrls);	
        	PrintList(resultStatusCodes);	
        	
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }else{
    	System.out.println("ParseLog");    	
    	System.out.println("");    	
    	System.out.println("Erro: Número de parametros invalidos!");    	
    	System.out.println("Uso: Java ParseLog <nomeArquivo.txt>");    	
    	System.out.println("");    	
   	
    }        
    }
    
    public static List<Result> Calcula(List<String> lista){

    	List<Result> result= new ArrayList<Result>();
    	result.add(new Result(lista.get(0)));
    	
    	for (int i=1; i<=lista.size()-1; i++){
   			//varre a lista de objs pra ver se ja existe
        	boolean existe=false;
        	for (int j=0;j<=result.size()-1;j++){
    			if (result.get(j).getName().equals(lista.get(i))){
    				result.get(j).inc();
    				existe=true;
    				break;
    			}
    		}
        	if (!existe){
    			result.add(new Result(lista.get(i)));
    		}
    	}
    	Collections.sort(result);
    	return result;
    }
    
    public static void PrintList(List<Result> result ){
    	System.out.println("Lista em ordem descrescente");    	
		for (int j=0;j<=result.size()-1;j++){
			System.out.println(result.get(j).getName()+ " - "+ result.get(j).getCount());
 		}    	
		System.out.println("");
    }
    
    public static void ShowHigh(List<Result> result){
		System.out.println("Lista com os 3 maiores");
    	for (int j=0;j<=2;j++){
			System.out.println(result.get(j).getName()+ " - "+ result.get(j).getCount());
 		}    	
		System.out.println("");
  	
    }
    
   
   
    	
  }


