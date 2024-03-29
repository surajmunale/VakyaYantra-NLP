package transliteration;

public class i_to_scharfe
{
String transformed;

public i_to_scharfe()
	{
		transformed = "";
	}

public String transform(String s1)
	{
		
	transformed = s1;
	transformed = transformed.replaceAll("\\.a","'");   // avagraha
										
	transformed = transformed.replaceAll("RRi","f");	
	
	transformed = transformed.replaceAll("RRI","F");
	transformed = transformed.replaceAll("LLi","x");
	transformed = transformed.replaceAll("LLI","X");

	transformed = transformed.replaceAll("ai","E");
	transformed = transformed.replaceAll("au","O");
	transformed = transformed.replaceAll("kh","K");

	transformed = transformed.replaceAll("gh","G");

        transformed = transformed.replaceAll("OM","9");
	transformed = transformed.replaceAll("~N","5"); // itrans N is fifth of T-vargas, hence 5
	// SKT LIB 'N' = 5, later 5 back again to 'N' at the end

	/***Note 1 ***/
	transformed = transformed.replaceAll("\\.N","~"); // chandra-bindu...// must be below .replaceAll("~N","5")
													
	transformed = transformed.replaceAll("Dh","Q"); // must be before .replaceAll("dh","D");
	transformed = transformed.replaceAll("Th","W"); // must be before .replaceAll("th","T");
	transformed = transformed.replaceAll("Ch","C");
	transformed = transformed.replaceAll("jh","J"); 
	transformed = transformed.replaceAll("~n","Y");
	transformed = transformed.replaceAll("T","w");
	
	transformed = transformed.replaceAll("D","q");
	
	transformed = transformed.replaceAll("N","R");// confusion with .replaceAll("~N","N")
																	
	transformed = transformed.replaceAll("th","T"); 
	transformed = transformed.replaceAll("dh","D");
	transformed = transformed.replaceAll("ph","P"); 
	transformed = transformed.replaceAll("bh","B");
	transformed = transformed.replaceAll("S","z");// must be above .replaceAll("sh","S")
																	// to avoid confusion

	transformed = transformed.replaceAll("sh","S");
	
	transformed = transformed.replaceAll("5","N"); 
        System.out.println(transformed+" transformed");
	return transformed;
	}
}
