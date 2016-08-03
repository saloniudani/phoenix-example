import groovy.lang.GroovyShell;

import java.io.File;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        new GroovyShell().parse(new File("phoenix-example.groovy")).invokeMethod("main", args);
    }
}
