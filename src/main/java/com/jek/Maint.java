package com.jek;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.File;
import java.io.IOException;

public class Maint {
    public static void main(String args[])throws IOException,ResourceException,ScriptException{


        String groovyRelPath = "groovy";
        String groovyScriptName = "XmlParser.groovy";
        String fileName = "test.xml";

        String classpath = Maint.class.getClassLoader()
                .getResource("").getPath();
        String[] roots = new String[]{classpath+groovyRelPath+File.separator};
        GroovyScriptEngine groovyScriptEngine = new GroovyScriptEngine(roots);
        File xmlFile = new File(classpath+fileName);
        Binding binding = new Binding();
        binding.setVariable("xmlFile",xmlFile);
        Object output = groovyScriptEngine.run(classpath+groovyRelPath+File.separator+groovyScriptName,binding);
        System.out.println((String)output);

    }

}
