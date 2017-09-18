package com.jek;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.File;
import java.io.IOException;

public class Demo {
    private void callScript()throws IOException,ResourceException,ScriptException{

        String groovyRelPath = "groovy";    //对应pom中定义的输出路径
        String groovyScriptName = "scriptParser.groovy";   //脚本文件名
        String fileName = "test.xml";
        String classpath = getClass().getClassLoader()
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

    private void callMethod()throws IOException,IllegalAccessException,InstantiationException{

        String groovyScriptName = "methodParser.groovy";   //脚本文件名
        String groovyRelPath = "groovy";    //对应pom中定义的输出路径
        String fileName = "test.xml";
        String classpath = getClass().getClassLoader()
                .getResource("").getPath();

        String path = classpath+groovyRelPath+File.separator+groovyScriptName;
        File xmlFile  = new File(classpath+fileName);


        GroovyClassLoader gcl = new GroovyClassLoader();
        Class<?> groovyClass = gcl.parseClass(new File(path));
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
        Object output = groovyObject.invokeMethod("parser",xmlFile);
        System.out.println((String)output);
    }


    public static void main(String args[])throws Exception{
        new Demo().callScript();
//          new Demo().callMethod();
    }

}
