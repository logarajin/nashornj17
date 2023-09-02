package com.example.demo;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		  ScriptEngineManager engineManager = 
				  new ScriptEngineManager();
				      ScriptEngine engine = 
				  engineManager.getEngineByName("nashorn");
				      engine.eval(new FileReader("geeks.js"));
				      

				     
				      Invocable invocable = (Invocable)engine;
				      
				      // Here we are calling func1
				      invocable.invokeFunction("gfg2");
				      
		
	}

}
