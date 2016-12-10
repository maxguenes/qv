package com.techbeat.qv.client;

import com.techbeat.qv.models.Unit;

public class FillRemoteProducts {
	
	public static final String URL = "http://localhost:8080/qv-web/";
	

	public static void main(String[] args) throws Exception{
//		ProductClient client = new ProductClient(URL);
//		
//		Set<String> inserted = new TreeSet<>();
//		
//		File productsCsvFile = new File("C:/dev/qvo/verduras.csv");
//		
//		List<String> readLines = FileUtils.readLines(productsCsvFile, java.nio.charset.StandardCharsets.UTF_8);
//		
//		for(String line : readLines){
//			String[] split = line.split(";");
//			String name = split[0];
//			Unit unid = getUnit(split[2]);
//			double value = Double.parseDouble(split[4]);
//			
//			if(!inserted.contains(name)){
//				
//				System.out.println(name+" - "+unid+" - "+value);
//				inserted.add(name);
//				
//				Product product = new Product();
//
//		        product.setName(name);
//		        product.setValue(value);
//		        product.setUnit(unid);
//				
//		        Stock stock = new Stock();
//		        stock.setQuantitiy(10);
//				product.setStock(stock);
//		        
//				client.save(product);
//			}
//		}
	}



	static Unit getUnit(String str) {
		
		switch(str){
			case "KG":
			case "CB":
				return Unit.KG;
			case "PCT":
				return Unit.G;
			case "UND":
				return Unit.UNIT;
		}
		
		throw new RuntimeException("Fora do padrão");
	}
}
