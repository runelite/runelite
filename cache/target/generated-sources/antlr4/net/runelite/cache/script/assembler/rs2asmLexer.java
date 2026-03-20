// Generated from net/runelite/cache/script/assembler/rs2asm.g4 by ANTLR 4.13.1
package net.runelite.cache.script.assembler;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class rs2asmLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NEWLINE=7, INT=8, QSTRING=9, 
		IDENTIFIER=10, SYMBOL=11, COMMENT=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "NEWLINE", "INT", "QSTRING", 
			"IDENTIFIER", "SYMBOL", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'.id '", "'.int_stack_count '", "'.string_stack_count '", "'.int_var_count '", 
			"'.string_var_count '", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "NEWLINE", "INT", "QSTRING", 
			"IDENTIFIER", "SYMBOL", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public rs2asmLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "rs2asm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\r\u009f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0001\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0004\u0006n\b\u0006\u000b\u0006\f\u0006o\u0001\u0007\u0003\u0007"+
		"s\b\u0007\u0001\u0007\u0004\u0007v\b\u0007\u000b\u0007\f\u0007w\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0005\b~\b\b\n\b\f\b\u0081\t\b\u0001\b\u0001"+
		"\b\u0001\t\u0004\t\u0086\b\t\u000b\t\f\t\u0087\u0001\n\u0001\n\u0004\n"+
		"\u008c\b\n\u000b\n\f\n\u008d\u0001\u000b\u0001\u000b\u0005\u000b\u0092"+
		"\b\u000b\n\u000b\f\u000b\u0095\t\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0004\f\u009a\b\f\u000b\f\f\f\u009b\u0001\f\u0001\f\u0000\u0000\r\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u0001\u0000\u0007"+
		"\u0002\u0000\n\n\r\r\u0001\u000009\u0004\u0000\n\n\r\r\"\"\\\\\u0002\u0000"+
		"\"\"\\\\\u0004\u000009AZ__az\u0004\u00000:AZ__az\u0002\u0000\t\t  \u00a7"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0001\u001b\u0001\u0000\u0000\u0000\u0003 \u0001"+
		"\u0000\u0000\u0000\u00052\u0001\u0000\u0000\u0000\u0007G\u0001\u0000\u0000"+
		"\u0000\tW\u0001\u0000\u0000\u0000\u000bj\u0001\u0000\u0000\u0000\rm\u0001"+
		"\u0000\u0000\u0000\u000fr\u0001\u0000\u0000\u0000\u0011y\u0001\u0000\u0000"+
		"\u0000\u0013\u0085\u0001\u0000\u0000\u0000\u0015\u0089\u0001\u0000\u0000"+
		"\u0000\u0017\u008f\u0001\u0000\u0000\u0000\u0019\u0099\u0001\u0000\u0000"+
		"\u0000\u001b\u001c\u0005.\u0000\u0000\u001c\u001d\u0005i\u0000\u0000\u001d"+
		"\u001e\u0005d\u0000\u0000\u001e\u001f\u0005 \u0000\u0000\u001f\u0002\u0001"+
		"\u0000\u0000\u0000 !\u0005.\u0000\u0000!\"\u0005i\u0000\u0000\"#\u0005"+
		"n\u0000\u0000#$\u0005t\u0000\u0000$%\u0005_\u0000\u0000%&\u0005s\u0000"+
		"\u0000&\'\u0005t\u0000\u0000\'(\u0005a\u0000\u0000()\u0005c\u0000\u0000"+
		")*\u0005k\u0000\u0000*+\u0005_\u0000\u0000+,\u0005c\u0000\u0000,-\u0005"+
		"o\u0000\u0000-.\u0005u\u0000\u0000./\u0005n\u0000\u0000/0\u0005t\u0000"+
		"\u000001\u0005 \u0000\u00001\u0004\u0001\u0000\u0000\u000023\u0005.\u0000"+
		"\u000034\u0005s\u0000\u000045\u0005t\u0000\u000056\u0005r\u0000\u0000"+
		"67\u0005i\u0000\u000078\u0005n\u0000\u000089\u0005g\u0000\u00009:\u0005"+
		"_\u0000\u0000:;\u0005s\u0000\u0000;<\u0005t\u0000\u0000<=\u0005a\u0000"+
		"\u0000=>\u0005c\u0000\u0000>?\u0005k\u0000\u0000?@\u0005_\u0000\u0000"+
		"@A\u0005c\u0000\u0000AB\u0005o\u0000\u0000BC\u0005u\u0000\u0000CD\u0005"+
		"n\u0000\u0000DE\u0005t\u0000\u0000EF\u0005 \u0000\u0000F\u0006\u0001\u0000"+
		"\u0000\u0000GH\u0005.\u0000\u0000HI\u0005i\u0000\u0000IJ\u0005n\u0000"+
		"\u0000JK\u0005t\u0000\u0000KL\u0005_\u0000\u0000LM\u0005v\u0000\u0000"+
		"MN\u0005a\u0000\u0000NO\u0005r\u0000\u0000OP\u0005_\u0000\u0000PQ\u0005"+
		"c\u0000\u0000QR\u0005o\u0000\u0000RS\u0005u\u0000\u0000ST\u0005n\u0000"+
		"\u0000TU\u0005t\u0000\u0000UV\u0005 \u0000\u0000V\b\u0001\u0000\u0000"+
		"\u0000WX\u0005.\u0000\u0000XY\u0005s\u0000\u0000YZ\u0005t\u0000\u0000"+
		"Z[\u0005r\u0000\u0000[\\\u0005i\u0000\u0000\\]\u0005n\u0000\u0000]^\u0005"+
		"g\u0000\u0000^_\u0005_\u0000\u0000_`\u0005v\u0000\u0000`a\u0005a\u0000"+
		"\u0000ab\u0005r\u0000\u0000bc\u0005_\u0000\u0000cd\u0005c\u0000\u0000"+
		"de\u0005o\u0000\u0000ef\u0005u\u0000\u0000fg\u0005n\u0000\u0000gh\u0005"+
		"t\u0000\u0000hi\u0005 \u0000\u0000i\n\u0001\u0000\u0000\u0000jk\u0005"+
		":\u0000\u0000k\f\u0001\u0000\u0000\u0000ln\u0007\u0000\u0000\u0000ml\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000p\u000e\u0001\u0000\u0000\u0000qs\u0005-\u0000"+
		"\u0000rq\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000su\u0001\u0000"+
		"\u0000\u0000tv\u0007\u0001\u0000\u0000ut\u0001\u0000\u0000\u0000vw\u0001"+
		"\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000"+
		"x\u0010\u0001\u0000\u0000\u0000y\u007f\u0005\"\u0000\u0000z~\b\u0002\u0000"+
		"\u0000{|\u0005\\\u0000\u0000|~\u0007\u0003\u0000\u0000}z\u0001\u0000\u0000"+
		"\u0000}{\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000\u007f"+
		"}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080\u0082"+
		"\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005\"\u0000\u0000\u0083\u0012\u0001\u0000\u0000\u0000\u0084\u0086\u0007"+
		"\u0004\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0087\u0001"+
		"\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001"+
		"\u0000\u0000\u0000\u0088\u0014\u0001\u0000\u0000\u0000\u0089\u008b\u0005"+
		":\u0000\u0000\u008a\u008c\u0007\u0005\u0000\u0000\u008b\u008a\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000"+
		"\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0016\u0001\u0000"+
		"\u0000\u0000\u008f\u0093\u0005;\u0000\u0000\u0090\u0092\b\u0000\u0000"+
		"\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000"+
		"\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000"+
		"\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000"+
		"\u0000\u0096\u0097\u0006\u000b\u0000\u0000\u0097\u0018\u0001\u0000\u0000"+
		"\u0000\u0098\u009a\u0007\u0006\u0000\u0000\u0099\u0098\u0001\u0000\u0000"+
		"\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000"+
		"\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000"+
		"\u0000\u009d\u009e\u0006\f\u0000\u0000\u009e\u001a\u0001\u0000\u0000\u0000"+
		"\n\u0000orw}\u007f\u0087\u008d\u0093\u009b\u0001\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}