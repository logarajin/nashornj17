package com.example.demo;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;

public class Test2 {

  public static void main(String... args) throws Throwable {
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