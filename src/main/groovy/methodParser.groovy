import  java.io.File
class Xml{
    def String parser(File file){
        new groovy.util.XmlParser().parse(file)
    }
}




