package bayesiannetwork;

// Generated from bayesian.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class bayesianLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, P=3, OPEN_P=4, CLOSE_P=5, GIVEN=6, NOT=7, NUM=8, FLOAT_VAL=9, 
		ID=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'"
	};
	public static final String[] ruleNames = {
		"T__1", "T__0", "P", "OPEN_P", "CLOSE_P", "GIVEN", "NOT", "LETTER", "DIGIT", 
		"NUM", "FLOAT_VAL", "ID"
	};


	public bayesianLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "bayesian.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\fA\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3"+
		"\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\7\13\60\n\13\f\13\16\13\63\13\13\3\f"+
		"\3\f\3\f\3\f\3\r\3\r\3\r\3\r\7\r=\n\r\f\r\16\r@\13\r\2\2\16\3\3\5\4\7"+
		"\5\t\6\13\7\r\b\17\t\21\2\23\2\25\n\27\13\31\f\3\2\4\4\2C\\c|\4\2//aa"+
		"B\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2"+
		"\5\35\3\2\2\2\7\37\3\2\2\2\t!\3\2\2\2\13#\3\2\2\2\r%\3\2\2\2\17\'\3\2"+
		"\2\2\21)\3\2\2\2\23+\3\2\2\2\25-\3\2\2\2\27\64\3\2\2\2\318\3\2\2\2\33"+
		"\34\7.\2\2\34\4\3\2\2\2\35\36\7?\2\2\36\6\3\2\2\2\37 \7R\2\2 \b\3\2\2"+
		"\2!\"\7*\2\2\"\n\3\2\2\2#$\7+\2\2$\f\3\2\2\2%&\7~\2\2&\16\3\2\2\2\'(\7"+
		"#\2\2(\20\3\2\2\2)*\t\2\2\2*\22\3\2\2\2+,\4\62;\2,\24\3\2\2\2-\61\5\23"+
		"\n\2.\60\5\23\n\2/.\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62"+
		"\26\3\2\2\2\63\61\3\2\2\2\64\65\5\25\13\2\65\66\7\60\2\2\66\67\5\25\13"+
		"\2\67\30\3\2\2\28>\5\21\t\29=\5\21\t\2:=\5\23\n\2;=\t\3\2\2<9\3\2\2\2"+
		"<:\3\2\2\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?\32\3\2\2\2@>\3\2\2"+
		"\2\6\2\61<>\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}