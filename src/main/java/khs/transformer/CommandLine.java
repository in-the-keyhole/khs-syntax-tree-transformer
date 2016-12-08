package khs.transformer;

import khs.transformer.service.TransformService;

public class CommandLine {

	public static void main(String[] args) {
		
		if (args.length == 0) {
			
			System.out.println("Usage Example:");
			System.out.println("$ java khs.transformer.CommandLine <your.json> <package name>");
			System.exit(-1);
		
		}
		
		 System.out.println("Working Directory = " +
	              System.getProperty("user.dir"));
		
		if (args.length < 2) {
			System.out.println("Package Name Required...");
			System.exit(-1);
		}
		
		String pckg = args[1];
		
		TransformService service = new TransformService();
		service.transform(args[0],pckg);
		
	}
	

}
