package com.jek;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Maint {
    public static void main(String args[])throws IOException,ResourceException,ScriptException{
        String[] roots = new String[]{"/home/kaiji/idea-workspace/groovy/src/main/groovy"};
        GroovyScriptEngine groovyScriptEngine = new GroovyScriptEngine(roots);

        URL url = Maint.class.getClassLoader().getResource("test.xml");
        File xmlFile = new File(url.getPath());

        Binding binding = new Binding();
        binding.setVariable("xmlFile",xmlFile);
        Object output = groovyScriptEngine.run("/home/kaiji/idea-workspace/groovy/src/main/groovy/com/jek/XmlParser.groovy",binding);
        System.out.println((String)output);

    }

}
