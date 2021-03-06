package bayesiannetwork;

import java.util.Collections;
import java.util.List;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

// Aqui se detectan los errores hay en el VISITOR
public class ListenerError extends BaseErrorListener {
    private String error;
	
    @Override
    public void syntaxError(Recognizer<?,?> recognizer,
        Object offendingSymbol,
	int line,int charPositionInLine,
	String msg,
	RecognitionException e) {			
            List<String> stack=((Parser)recognizer).getRuleInvocationStack();
            Collections.reverse(stack);
            System.err.println("rulestack:"+stack);
            error+="line"+line+":"+charPositionInLine+"at"+
            offendingSymbol+":"+msg;	
	}

	public String getError() {
            return error;
	}

	public void setError(String error) {
            this.error = error;
	}

}
