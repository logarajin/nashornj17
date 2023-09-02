package com.example.demo;

import javax.script.*;
import java.io.*;
  
public class Test {
    public static void main(String[] args)
        throws Exception
    {
        ScriptEngineManager engineManager = 
        		new ScriptEngineManager();
        
        ScriptEngine engine = 
        		engineManager.getEngineByName("nashorn");
        engine.eval("function sum(a, b) { return a + b; }");
        System.out.println(engine.eval("sum(1, 5);"));
        engine.eval(new FileReader("geeks.js"));
    }
}