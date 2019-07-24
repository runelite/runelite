// Generated from net\runelite\cache\script\assembler\rs2asm.g4 by ANTLR 4.6
package net.runelite.cache.script.assembler;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class rs2asmLexer extends Lexer
{
	public static final int
		T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, NEWLINE = 7, INT = 8, QSTRING = 9,
		IDENTIFIER = 10, COMMENT = 11, WS = 12;
	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "NEWLINE", "INT", "QSTRING",
		"IDENTIFIER", "COMMENT", "WS"
	};
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\16\u0099\b\1\4\2" +
			"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4" +
			"\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3" +
			"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4" +
			"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3" +
			"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6" +
			"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3" +
			"\b\6\bn\n\b\r\b\16\bo\3\t\5\ts\n\t\3\t\6\tv\n\t\r\t\16\tw\3\n\3\n\3\n" +
			"\3\n\7\n~\n\n\f\n\16\n\u0081\13\n\3\n\3\n\3\13\6\13\u0086\n\13\r\13\16" +
			"\13\u0087\3\f\3\f\7\f\u008c\n\f\f\f\16\f\u008f\13\f\3\f\3\f\3\r\6\r\u0094" +
			"\n\r\r\r\16\r\u0095\3\r\3\r\2\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n" +
			"\23\13\25\f\27\r\31\16\3\2\b\4\2\f\f\17\17\3\2\62;\6\2\f\f\17\17$$^^\4" +
			"\2$$^^\6\2\62;C\\aac|\4\2\13\13\"\"\u00a0\2\3\3\2\2\2\2\5\3\2\2\2\2\7" +
			"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2" +
			"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5" +
			" \3\2\2\2\7\62\3\2\2\2\tG\3\2\2\2\13W\3\2\2\2\rj\3\2\2\2\17m\3\2\2\2\21" +
			"r\3\2\2\2\23y\3\2\2\2\25\u0085\3\2\2\2\27\u0089\3\2\2\2\31\u0093\3\2\2" +
			"\2\33\34\7\60\2\2\34\35\7k\2\2\35\36\7f\2\2\36\37\7\"\2\2\37\4\3\2\2\2" +
			" !\7\60\2\2!\"\7k\2\2\"#\7p\2\2#$\7v\2\2$%\7a\2\2%&\7u\2\2&\'\7v\2\2\'" +
			"(\7c\2\2()\7e\2\2)*\7m\2\2*+\7a\2\2+,\7e\2\2,-\7q\2\2-.\7w\2\2./\7p\2" +
			"\2/\60\7v\2\2\60\61\7\"\2\2\61\6\3\2\2\2\62\63\7\60\2\2\63\64\7u\2\2\64" +
			"\65\7v\2\2\65\66\7t\2\2\66\67\7k\2\2\678\7p\2\289\7i\2\29:\7a\2\2:;\7" +
			"u\2\2;<\7v\2\2<=\7c\2\2=>\7e\2\2>?\7m\2\2?@\7a\2\2@A\7e\2\2AB\7q\2\2B" +
			"C\7w\2\2CD\7p\2\2DE\7v\2\2EF\7\"\2\2F\b\3\2\2\2GH\7\60\2\2HI\7k\2\2IJ" +
			"\7p\2\2JK\7v\2\2KL\7a\2\2LM\7x\2\2MN\7c\2\2NO\7t\2\2OP\7a\2\2PQ\7e\2\2" +
			"QR\7q\2\2RS\7w\2\2ST\7p\2\2TU\7v\2\2UV\7\"\2\2V\n\3\2\2\2WX\7\60\2\2X" +
			"Y\7u\2\2YZ\7v\2\2Z[\7t\2\2[\\\7k\2\2\\]\7p\2\2]^\7i\2\2^_\7a\2\2_`\7x" +
			"\2\2`a\7c\2\2ab\7t\2\2bc\7a\2\2cd\7e\2\2de\7q\2\2ef\7w\2\2fg\7p\2\2gh" +
			"\7v\2\2hi\7\"\2\2i\f\3\2\2\2jk\7<\2\2k\16\3\2\2\2ln\t\2\2\2ml\3\2\2\2" +
			"no\3\2\2\2om\3\2\2\2op\3\2\2\2p\20\3\2\2\2qs\7/\2\2rq\3\2\2\2rs\3\2\2" +
			"\2su\3\2\2\2tv\t\3\2\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\22\3\2" +
			"\2\2y\177\7$\2\2z~\n\4\2\2{|\7^\2\2|~\t\5\2\2}z\3\2\2\2}{\3\2\2\2~\u0081" +
			"\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0082\3\2\2\2\u0081\177" +
			"\3\2\2\2\u0082\u0083\7$\2\2\u0083\24\3\2\2\2\u0084\u0086\t\6\2\2\u0085" +
			"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2" +
			"\2\2\u0088\26\3\2\2\2\u0089\u008d\7=\2\2\u008a\u008c\n\2\2\2\u008b\u008a" +
			"\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e" +
			"\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\b\f\2\2\u0091\30\3\2\2" +
			"\2\u0092\u0094\t\7\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093" +
			"\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u0098\b\r\2\2\u0098" +
			"\32\3\2\2\2\13\2orw}\177\u0087\u008d\u0095\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	private static final String[] _LITERAL_NAMES = {
		null, "'.id '", "'.int_stack_count '", "'.string_stack_count '", "'.int_var_count '",
		"'.string_var_count '", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, "NEWLINE", "INT", "QSTRING",
		"IDENTIFIER", "COMMENT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	static
	{
		RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION);
	}

	static
	{
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++)
		{
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null)
			{
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null)
			{
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	static
	{
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++)
		{
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}

	public rs2asmLexer(CharStream input)
	{
		super(input);
		_interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	@Override
	public String[] getRuleNames()
	{
		return ruleNames;
	}

	@Override

	public Vocabulary getVocabulary()
	{
		return VOCABULARY;
	}

	@Override
	public String getSerializedATN()
	{
		return _serializedATN;
	}

	@Override
	public String getGrammarFileName()
	{
		return "rs2asm.g4";
	}

	@Override
	public ATN getATN()
	{
		return _ATN;
	}

	@Override
	public String[] getModeNames()
	{
		return modeNames;
	}

	@Override
	@Deprecated
	public String[] getTokenNames()
	{
		return tokenNames;
	}
}