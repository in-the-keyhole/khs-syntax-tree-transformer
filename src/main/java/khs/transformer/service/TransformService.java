package khs.transformer.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.logging.Logger;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import khs.transformer.model.Function;
import khs.transformer.model.Program;

@Service
public class TransformService {

	private final static Logger LOG = Logger.getLogger(TransformService.class.getName());

	Gson gson = new Gson();

	public void transform(String jsonFile, String pckg) {

		LOG.info("Parsing :" + jsonFile);
		Program program = parse(readJson(jsonFile));
		program.setPckge(pckg);
		LOG.info("Transforming");
		createTemplate(program);
		LOG.info("Transformed");

	}

	public Program parse(String json) {

		StringReader stringReader = new StringReader(json);
		BufferedReader reader = new BufferedReader(stringReader);

		Type listType = new TypeToken<ArrayList<Function>>() {
		}.getType();

		return gson.fromJson(reader, Program.class);

	}

	private String readJson(String file) {

		FileReader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String json = "";
		int i;
		try {
			while ((i = reader.read()) >= 0) {

				json += (char) i;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return json;

	}

	public void createTemplate(Program program) {

		Velocity.init();

		VelocityContext context = new VelocityContext();

		context.put("program", program);

		Template template = null;

		try {
			template = Velocity.getTemplate("java-template.vm");
		} catch (ResourceNotFoundException rnfe) {
			// couldn't find the template
		} catch (ParseErrorException pee) {
			// syntax error: problem parsing the template
		} catch (MethodInvocationException mie) {
			// something invoked in the template
			// threw an exception
		} catch (Exception e) {
		}

		StringWriter sw = new StringWriter();

		template.merge(context, sw);

		this.writeFile(program.getName(),sw.toString());
		System.out.println(sw.toString());

	}

	public void writeFile(String filePath,String contents) {

		 FileWriter writer = null;
		 
		 String dir = System.getProperty("user.dir");
		 try {
		    writer = new FileWriter(dir+"/"+filePath+".java");
			writer.write(contents);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
		
	}

}
