package bayesiannetwork;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

// Clase compilador para implementacion del visitor y envio de info hacia este.
public class Compiler {
    ANTLRInputStream ingreso;
    bayesianLexer lexer;
    CommonTokenStream tokens;
    Pars parser;

    public Compiler(){  
    }
    // aqui se compila el texto que luego se enviara para procesarlos.
    public String compilar(String texto) {
        
        ingreso= new ANTLRInputStream(texto);
        lexer= new bayesianLexer(ingreso);
        tokens = new CommonTokenStream(lexer);
        parser= new Pars(tokens);
        parser.removeErrorListeners();
        ListenerError error= new ListenerError();	
        parser.addErrorListener(error);               
        ParseTree arbol =parser.bayes();
        Visitor visitor= new Visitor();
        visitor.visit(arbol);
        String t= visitor.getTexto();               
        return t;
    }
}