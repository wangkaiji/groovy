package com.jek;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.File;
import java.io.IOException;

public class Maint {
    public static void main(String args[])throws IOException,ResourceException,ScriptException{


        String groovyRelPath = "groovy";    //对应pom中定义的输出路径
        String groovyScriptName = "XmlParser.groovy";   //脚本文件名
        String fileName = "test.xml";
        String classpath = Maint.class.getClassLoader()
                .getResource("").getPath();

        String[] roots = new String[]{classpath+groovyRelPath+File.separator};
        GroovyScriptEngine groovyScriptEngine = new GroovyScriptEngine(roots);
        //groovy引擎会监视roots目录下的所有groovy脚本，一旦被修改，groovy就会被重新编译


        File xmlFile = new File(classpath+fileName);
        Binding binding = new Binding();
        binding.setVariable("xmlFile",xmlFile);
        //binding将参数注入groovy脚本

        Object output = groovyScriptEngine.run(classpath+groovyRelPath+File.separator+groovyScriptName,binding);
        System.out.println((String)output);

    }

}
