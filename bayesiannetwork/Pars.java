package bayesiannetwork;

// Generated from bayesian.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Pars extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__1=1, T__0=2, P=3, OPEN_P=4, CLOSE_P=5, GIVEN=6, NOT=7, NUM=8, FLOAT_VAL=9, 
		ID=10;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "'='", "'P'", "'('", "')'", "'|'", "'!'", "NUM", "FLOAT_VAL", 
		"ID"
	};
	public static final int
		RULE_bayes = 0, RULE_factor = 1, RULE_queryVariable = 2, RULE_evidenceVariable = 3;
	public static final String[] ruleNames = {
		"bayes", "factor", "queryVariable", "evidenceVariable"
	};

	@Override
	public String getGrammarFileName() { return "bayesian.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Pars(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class BayesContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public BayesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bayes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bayesianListener ) ((bayesianListener)listener).enterBayes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bayesianListener ) ((bayesianListener)listener).exitBayes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bayesianVisitor ) return ((bayesianVisitor<? extends T>)visitor).visitBayes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BayesContext bayes() throws RecognitionException {
		BayesContext _localctx = new BayesContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_bayes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(9); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(8); factor();
				}
				}
				setState(11); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==P );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public QueryVariableContext queryVariable(int i) {
			return getRuleContext(QueryVariableContext.class,i);
		}
		public List<EvidenceVariableContext> evidenceVariable() {
			return getRuleContexts(EvidenceVariableContext.class);
		}
		public TerminalNode FLOAT_VAL() { return getToken(Pars.FLOAT_VAL, 0); }
		public TerminalNode NUM() { return getToken(Pars.NUM, 0); }
		public TerminalNode CLOSE_P() { return getToken(Pars.CLOSE_P, 0); }
		public TerminalNode GIVEN() { return getToken(Pars.GIVEN, 0); }
		public EvidenceVariableContext evidenceVariable(int i) {
			return getRuleContext(EvidenceVariableContext.class,i);
		}
		public TerminalNode OPEN_P() { return getToken(Pars.OPEN_P, 0); }
		public List<QueryVariableContext> queryVariable() {
			return getRuleContexts(QueryVariableContext.class);
		}
		public TerminalNode P() { return getToken(Pars.P, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bayesianListener ) ((bayesianListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bayesianListener ) ((bayesianListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bayesianVisitor ) return ((bayesianVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(13); match(P);
			setState(14); match(OPEN_P);
			{
			setState(15); queryVariable();
			setState(20);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(16); match(T__1);
				setState(17); queryVariable();
				}
				}
				setState(22);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
			setState(32);
			_la = _input.LA(1);
			if (_la==GIVEN) {
				{
				setState(23); match(GIVEN);
				setState(24); evidenceVariable();
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(25); match(T__1);
					setState(26); evidenceVariable();
					}
					}
					setState(31);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(34); match(CLOSE_P);
			setState(35); match(T__0);
			setState(36);
			_la = _input.LA(1);
			if ( !(_la==NUM || _la==FLOAT_VAL) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryVariableContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(Pars.NOT, 0); }
		public TerminalNode ID() { return getToken(Pars.ID, 0); }
		public QueryVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bayesianListener ) ((bayesianListener)listener).enterQueryVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bayesianListener ) ((bayesianListener)listener).exitQueryVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bayesianVisitor ) return ((bayesianVisitor<? extends T>)visitor).visitQueryVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QueryVariableContext queryVariable() throws RecognitionException {
		QueryVariableContext _localctx = new QueryVariableContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_queryVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(38); match(NOT);
				}
			}

			setState(41); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EvidenceVariableContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(Pars.NOT, 0); }
		public TerminalNode ID() { return getToken(Pars.ID, 0); }
		public EvidenceVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_evidenceVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof bayesianListener ) ((bayesianListener)listener).enterEvidenceVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof bayesianListener ) ((bayesianListener)listener).exitEvidenceVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof bayesianVisitor ) return ((bayesianVisitor<? extends T>)visitor).visitEvidenceVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EvidenceVariableContext evidenceVariable() throws RecognitionException {
		EvidenceVariableContext _localctx = new EvidenceVariableContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_evidenceVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(43); match(NOT);
				}
			}

			setState(46); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\f\63\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\3\2\6\2\f\n\2\r\2\16\2\r\3\3\3\3\3\3\3\3\3\3\7\3"+
		"\25\n\3\f\3\16\3\30\13\3\3\3\3\3\3\3\3\3\7\3\36\n\3\f\3\16\3!\13\3\5\3"+
		"#\n\3\3\3\3\3\3\3\3\3\3\4\5\4*\n\4\3\4\3\4\3\5\5\5/\n\5\3\5\3\5\3\5\2"+
		"\2\6\2\4\6\b\2\3\3\2\n\13\64\2\13\3\2\2\2\4\17\3\2\2\2\6)\3\2\2\2\b.\3"+
		"\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\f\r\3\2\2\2\r\13\3\2\2\2\r\16\3\2\2\2"+
		"\16\3\3\2\2\2\17\20\7\5\2\2\20\21\7\6\2\2\21\26\5\6\4\2\22\23\7\3\2\2"+
		"\23\25\5\6\4\2\24\22\3\2\2\2\25\30\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2"+
		"\27\"\3\2\2\2\30\26\3\2\2\2\31\32\7\b\2\2\32\37\5\b\5\2\33\34\7\3\2\2"+
		"\34\36\5\b\5\2\35\33\3\2\2\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 #\3"+
		"\2\2\2!\37\3\2\2\2\"\31\3\2\2\2\"#\3\2\2\2#$\3\2\2\2$%\7\7\2\2%&\7\4\2"+
		"\2&\'\t\2\2\2\'\5\3\2\2\2(*\7\t\2\2)(\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\7"+
		"\f\2\2,\7\3\2\2\2-/\7\t\2\2.-\3\2\2\2./\3\2\2\2/\60\3\2\2\2\60\61\7\f"+
		"\2\2\61\t\3\2\2\2\b\r\26\37\").";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}