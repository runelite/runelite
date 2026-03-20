// Generated from net/runelite/cache/script/assembler/rs2asm.g4 by ANTLR 4.13.1
package net.runelite.cache.script.assembler;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class rs2asmParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, NEWLINE=7, INT=8, QSTRING=9, 
		IDENTIFIER=10, SYMBOL=11, COMMENT=12, WS=13;
	public static final int
		RULE_prog = 0, RULE_header = 1, RULE_id = 2, RULE_int_stack_count = 3, 
		RULE_string_stack_count = 4, RULE_int_var_count = 5, RULE_string_var_count = 6, 
		RULE_id_value = 7, RULE_int_stack_value = 8, RULE_string_stack_value = 9, 
		RULE_int_var_value = 10, RULE_string_var_value = 11, RULE_line = 12, RULE_instruction = 13, 
		RULE_label = 14, RULE_instruction_name = 15, RULE_name_string = 16, RULE_name_opcode = 17, 
		RULE_instruction_operand = 18, RULE_operand_int = 19, RULE_operand_qstring = 20, 
		RULE_operand_label = 21, RULE_operand_symbol = 22, RULE_switch_lookup = 23, 
		RULE_switch_key = 24, RULE_switch_value = 25;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "header", "id", "int_stack_count", "string_stack_count", "int_var_count", 
			"string_var_count", "id_value", "int_stack_value", "string_stack_value", 
			"int_var_value", "string_var_value", "line", "instruction", "label", 
			"instruction_name", "name_string", "name_opcode", "instruction_operand", 
			"operand_int", "operand_qstring", "operand_label", "operand_symbol", 
			"switch_lookup", "switch_key", "switch_value"
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

	@Override
	public String getGrammarFileName() { return "rs2asm.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public rs2asmParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(rs2asmParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(rs2asmParser.NEWLINE, i);
		}
		public List<HeaderContext> header() {
			return getRuleContexts(HeaderContext.class);
		}
		public HeaderContext header(int i) {
			return getRuleContext(HeaderContext.class,i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(52);
				match(NEWLINE);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0)) {
				{
				{
				setState(58);
				header();
				setState(60); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(59);
					match(NEWLINE);
					}
					}
					setState(62); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				line();
				setState(71); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(70);
					match(NEWLINE);
					}
					}
					setState(73); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==NEWLINE );
				}
				}
				setState(77); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==INT || _la==IDENTIFIER );
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

	@SuppressWarnings("CheckReturnValue")
	public static class HeaderContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Int_stack_countContext int_stack_count() {
			return getRuleContext(Int_stack_countContext.class,0);
		}
		public String_stack_countContext string_stack_count() {
			return getRuleContext(String_stack_countContext.class,0);
		}
		public Int_var_countContext int_var_count() {
			return getRuleContext(Int_var_countContext.class,0);
		}
		public String_var_countContext string_var_count() {
			return getRuleContext(String_var_countContext.class,0);
		}
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try {
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(79);
				id();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				int_stack_count();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
				string_stack_count();
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 4);
				{
				setState(82);
				int_var_count();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				string_var_count();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdContext extends ParserRuleContext {
		public Id_valueContext id_value() {
			return getRuleContext(Id_valueContext.class,0);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			match(T__0);
			setState(87);
			id_value();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Int_stack_countContext extends ParserRuleContext {
		public Int_stack_valueContext int_stack_value() {
			return getRuleContext(Int_stack_valueContext.class,0);
		}
		public Int_stack_countContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_stack_count; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterInt_stack_count(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitInt_stack_count(this);
		}
	}

	public final Int_stack_countContext int_stack_count() throws RecognitionException {
		Int_stack_countContext _localctx = new Int_stack_countContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_int_stack_count);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(T__1);
			setState(90);
			int_stack_value();
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

	@SuppressWarnings("CheckReturnValue")
	public static class String_stack_countContext extends ParserRuleContext {
		public String_stack_valueContext string_stack_value() {
			return getRuleContext(String_stack_valueContext.class,0);
		}
		public String_stack_countContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_stack_count; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterString_stack_count(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitString_stack_count(this);
		}
	}

	public final String_stack_countContext string_stack_count() throws RecognitionException {
		String_stack_countContext _localctx = new String_stack_countContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_string_stack_count);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__2);
			setState(93);
			string_stack_value();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Int_var_countContext extends ParserRuleContext {
		public Int_var_valueContext int_var_value() {
			return getRuleContext(Int_var_valueContext.class,0);
		}
		public Int_var_countContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_var_count; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterInt_var_count(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitInt_var_count(this);
		}
	}

	public final Int_var_countContext int_var_count() throws RecognitionException {
		Int_var_countContext _localctx = new Int_var_countContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_int_var_count);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__3);
			setState(96);
			int_var_value();
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

	@SuppressWarnings("CheckReturnValue")
	public static class String_var_countContext extends ParserRuleContext {
		public String_var_valueContext string_var_value() {
			return getRuleContext(String_var_valueContext.class,0);
		}
		public String_var_countContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_var_count; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterString_var_count(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitString_var_count(this);
		}
	}

	public final String_var_countContext string_var_count() throws RecognitionException {
		String_var_countContext _localctx = new String_var_countContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_string_var_count);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(T__4);
			setState(99);
			string_var_value();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Id_valueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(rs2asmParser.INT, 0); }
		public Id_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterId_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitId_value(this);
		}
	}

	public final Id_valueContext id_value() throws RecognitionException {
		Id_valueContext _localctx = new Id_valueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_id_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(INT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Int_stack_valueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(rs2asmParser.INT, 0); }
		public Int_stack_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_stack_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterInt_stack_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitInt_stack_value(this);
		}
	}

	public final Int_stack_valueContext int_stack_value() throws RecognitionException {
		Int_stack_valueContext _localctx = new Int_stack_valueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_int_stack_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(INT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class String_stack_valueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(rs2asmParser.INT, 0); }
		public String_stack_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_stack_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterString_stack_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitString_stack_value(this);
		}
	}

	public final String_stack_valueContext string_stack_value() throws RecognitionException {
		String_stack_valueContext _localctx = new String_stack_valueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_string_stack_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(INT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Int_var_valueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(rs2asmParser.INT, 0); }
		public Int_var_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_var_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterInt_var_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitInt_var_value(this);
		}
	}

	public final Int_var_valueContext int_var_value() throws RecognitionException {
		Int_var_valueContext _localctx = new Int_var_valueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_int_var_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(INT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class String_var_valueContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(rs2asmParser.INT, 0); }
		public String_var_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string_var_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterString_var_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitString_var_value(this);
		}
	}

	public final String_var_valueContext string_var_value() throws RecognitionException {
		String_var_valueContext _localctx = new String_var_valueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_string_var_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(INT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class LineContext extends ParserRuleContext {
		public InstructionContext instruction() {
			return getRuleContext(InstructionContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public Switch_lookupContext switch_lookup() {
			return getRuleContext(Switch_lookupContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitLine(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_line);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				instruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				label();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				switch_lookup();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class InstructionContext extends ParserRuleContext {
		public Instruction_nameContext instruction_name() {
			return getRuleContext(Instruction_nameContext.class,0);
		}
		public Instruction_operandContext instruction_operand() {
			return getRuleContext(Instruction_operandContext.class,0);
		}
		public InstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterInstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitInstruction(this);
		}
	}

	public final InstructionContext instruction() throws RecognitionException {
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_instruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			instruction_name();
			setState(117);
			instruction_operand();
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

	@SuppressWarnings("CheckReturnValue")
	public static class LabelContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(rs2asmParser.IDENTIFIER, 0); }
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitLabel(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(IDENTIFIER);
			setState(120);
			match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Instruction_nameContext extends ParserRuleContext {
		public Name_stringContext name_string() {
			return getRuleContext(Name_stringContext.class,0);
		}
		public Name_opcodeContext name_opcode() {
			return getRuleContext(Name_opcodeContext.class,0);
		}
		public Instruction_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterInstruction_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitInstruction_name(this);
		}
	}

	public final Instruction_nameContext instruction_name() throws RecognitionException {
		Instruction_nameContext _localctx = new Instruction_nameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_instruction_name);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				name_string();
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(123);
				name_opcode();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Name_stringContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(rs2asmParser.IDENTIFIER, 0); }
		public Name_stringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterName_string(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitName_string(this);
		}
	}

	public final Name_stringContext name_string() throws RecognitionException {
		Name_stringContext _localctx = new Name_stringContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_name_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Name_opcodeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(rs2asmParser.INT, 0); }
		public Name_opcodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_opcode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterName_opcode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitName_opcode(this);
		}
	}

	public final Name_opcodeContext name_opcode() throws RecognitionException {
		Name_opcodeContext _localctx = new Name_opcodeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_name_opcode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(INT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Instruction_operandContext extends ParserRuleContext {
		public Operand_intContext operand_int() {
			return getRuleContext(Operand_intContext.class,0);
		}
		public Operand_qstringContext operand_qstring() {
			return getRuleContext(Operand_qstringContext.class,0);
		}
		public Operand_labelContext operand_label() {
			return getRuleContext(Operand_labelContext.class,0);
		}
		public Operand_symbolContext operand_symbol() {
			return getRuleContext(Operand_symbolContext.class,0);
		}
		public Instruction_operandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instruction_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterInstruction_operand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitInstruction_operand(this);
		}
	}

	public final Instruction_operandContext instruction_operand() throws RecognitionException {
		Instruction_operandContext _localctx = new Instruction_operandContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_instruction_operand);
		try {
			setState(135);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				operand_int();
				}
				break;
			case QSTRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				operand_qstring();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				operand_label();
				}
				break;
			case SYMBOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(133);
				operand_symbol();
				}
				break;
			case NEWLINE:
				enterOuterAlt(_localctx, 5);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Operand_intContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(rs2asmParser.INT, 0); }
		public Operand_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand_int; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterOperand_int(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitOperand_int(this);
		}
	}

	public final Operand_intContext operand_int() throws RecognitionException {
		Operand_intContext _localctx = new Operand_intContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_operand_int);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(INT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Operand_qstringContext extends ParserRuleContext {
		public TerminalNode QSTRING() { return getToken(rs2asmParser.QSTRING, 0); }
		public Operand_qstringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand_qstring; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterOperand_qstring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitOperand_qstring(this);
		}
	}

	public final Operand_qstringContext operand_qstring() throws RecognitionException {
		Operand_qstringContext _localctx = new Operand_qstringContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_operand_qstring);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(QSTRING);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Operand_labelContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(rs2asmParser.IDENTIFIER, 0); }
		public Operand_labelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterOperand_label(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitOperand_label(this);
		}
	}

	public final Operand_labelContext operand_label() throws RecognitionException {
		Operand_labelContext _localctx = new Operand_labelContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_operand_label);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Operand_symbolContext extends ParserRuleContext {
		public TerminalNode SYMBOL() { return getToken(rs2asmParser.SYMBOL, 0); }
		public Operand_symbolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand_symbol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterOperand_symbol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitOperand_symbol(this);
		}
	}

	public final Operand_symbolContext operand_symbol() throws RecognitionException {
		Operand_symbolContext _localctx = new Operand_symbolContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_operand_symbol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(SYMBOL);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Switch_lookupContext extends ParserRuleContext {
		public Switch_keyContext switch_key() {
			return getRuleContext(Switch_keyContext.class,0);
		}
		public Switch_valueContext switch_value() {
			return getRuleContext(Switch_valueContext.class,0);
		}
		public Switch_lookupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_lookup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterSwitch_lookup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitSwitch_lookup(this);
		}
	}

	public final Switch_lookupContext switch_lookup() throws RecognitionException {
		Switch_lookupContext _localctx = new Switch_lookupContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_switch_lookup);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			switch_key();
			setState(146);
			match(T__5);
			setState(147);
			switch_value();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Switch_keyContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(rs2asmParser.INT, 0); }
		public Switch_keyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterSwitch_key(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitSwitch_key(this);
		}
	}

	public final Switch_keyContext switch_key() throws RecognitionException {
		Switch_keyContext _localctx = new Switch_keyContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_switch_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(INT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Switch_valueContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(rs2asmParser.IDENTIFIER, 0); }
		public Switch_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).enterSwitch_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof rs2asmListener ) ((rs2asmListener)listener).exitSwitch_value(this);
		}
	}

	public final Switch_valueContext switch_value() throws RecognitionException {
		Switch_valueContext _localctx = new Switch_valueContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_switch_value);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(IDENTIFIER);
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
		"\u0004\u0001\r\u009a\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0001\u0000\u0005\u00006\b\u0000\n\u0000\f\u0000"+
		"9\t\u0000\u0001\u0000\u0001\u0000\u0004\u0000=\b\u0000\u000b\u0000\f\u0000"+
		">\u0005\u0000A\b\u0000\n\u0000\f\u0000D\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0004\u0000H\b\u0000\u000b\u0000\f\u0000I\u0004\u0000L\b\u0000\u000b"+
		"\u0000\f\u0000M\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0003\u0001U\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0003\fs\b\f\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0003\u000f}\b\u000f\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012"+
		"\u0088\b\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0000\u0000\u001a\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*,.02\u0000\u0000\u008f\u00007\u0001"+
		"\u0000\u0000\u0000\u0002T\u0001\u0000\u0000\u0000\u0004V\u0001\u0000\u0000"+
		"\u0000\u0006Y\u0001\u0000\u0000\u0000\b\\\u0001\u0000\u0000\u0000\n_\u0001"+
		"\u0000\u0000\u0000\fb\u0001\u0000\u0000\u0000\u000ee\u0001\u0000\u0000"+
		"\u0000\u0010g\u0001\u0000\u0000\u0000\u0012i\u0001\u0000\u0000\u0000\u0014"+
		"k\u0001\u0000\u0000\u0000\u0016m\u0001\u0000\u0000\u0000\u0018r\u0001"+
		"\u0000\u0000\u0000\u001at\u0001\u0000\u0000\u0000\u001cw\u0001\u0000\u0000"+
		"\u0000\u001e|\u0001\u0000\u0000\u0000 ~\u0001\u0000\u0000\u0000\"\u0080"+
		"\u0001\u0000\u0000\u0000$\u0087\u0001\u0000\u0000\u0000&\u0089\u0001\u0000"+
		"\u0000\u0000(\u008b\u0001\u0000\u0000\u0000*\u008d\u0001\u0000\u0000\u0000"+
		",\u008f\u0001\u0000\u0000\u0000.\u0091\u0001\u0000\u0000\u00000\u0095"+
		"\u0001\u0000\u0000\u00002\u0097\u0001\u0000\u0000\u000046\u0005\u0007"+
		"\u0000\u000054\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001"+
		"\u0000\u0000\u000078\u0001\u0000\u0000\u00008B\u0001\u0000\u0000\u0000"+
		"97\u0001\u0000\u0000\u0000:<\u0003\u0002\u0001\u0000;=\u0005\u0007\u0000"+
		"\u0000<;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000><\u0001\u0000"+
		"\u0000\u0000>?\u0001\u0000\u0000\u0000?A\u0001\u0000\u0000\u0000@:\u0001"+
		"\u0000\u0000\u0000AD\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000"+
		"BC\u0001\u0000\u0000\u0000CK\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000"+
		"\u0000EG\u0003\u0018\f\u0000FH\u0005\u0007\u0000\u0000GF\u0001\u0000\u0000"+
		"\u0000HI\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000\u0000IJ\u0001\u0000"+
		"\u0000\u0000JL\u0001\u0000\u0000\u0000KE\u0001\u0000\u0000\u0000LM\u0001"+
		"\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000\u0000"+
		"N\u0001\u0001\u0000\u0000\u0000OU\u0003\u0004\u0002\u0000PU\u0003\u0006"+
		"\u0003\u0000QU\u0003\b\u0004\u0000RU\u0003\n\u0005\u0000SU\u0003\f\u0006"+
		"\u0000TO\u0001\u0000\u0000\u0000TP\u0001\u0000\u0000\u0000TQ\u0001\u0000"+
		"\u0000\u0000TR\u0001\u0000\u0000\u0000TS\u0001\u0000\u0000\u0000U\u0003"+
		"\u0001\u0000\u0000\u0000VW\u0005\u0001\u0000\u0000WX\u0003\u000e\u0007"+
		"\u0000X\u0005\u0001\u0000\u0000\u0000YZ\u0005\u0002\u0000\u0000Z[\u0003"+
		"\u0010\b\u0000[\u0007\u0001\u0000\u0000\u0000\\]\u0005\u0003\u0000\u0000"+
		"]^\u0003\u0012\t\u0000^\t\u0001\u0000\u0000\u0000_`\u0005\u0004\u0000"+
		"\u0000`a\u0003\u0014\n\u0000a\u000b\u0001\u0000\u0000\u0000bc\u0005\u0005"+
		"\u0000\u0000cd\u0003\u0016\u000b\u0000d\r\u0001\u0000\u0000\u0000ef\u0005"+
		"\b\u0000\u0000f\u000f\u0001\u0000\u0000\u0000gh\u0005\b\u0000\u0000h\u0011"+
		"\u0001\u0000\u0000\u0000ij\u0005\b\u0000\u0000j\u0013\u0001\u0000\u0000"+
		"\u0000kl\u0005\b\u0000\u0000l\u0015\u0001\u0000\u0000\u0000mn\u0005\b"+
		"\u0000\u0000n\u0017\u0001\u0000\u0000\u0000os\u0003\u001a\r\u0000ps\u0003"+
		"\u001c\u000e\u0000qs\u0003.\u0017\u0000ro\u0001\u0000\u0000\u0000rp\u0001"+
		"\u0000\u0000\u0000rq\u0001\u0000\u0000\u0000s\u0019\u0001\u0000\u0000"+
		"\u0000tu\u0003\u001e\u000f\u0000uv\u0003$\u0012\u0000v\u001b\u0001\u0000"+
		"\u0000\u0000wx\u0005\n\u0000\u0000xy\u0005\u0006\u0000\u0000y\u001d\u0001"+
		"\u0000\u0000\u0000z}\u0003 \u0010\u0000{}\u0003\"\u0011\u0000|z\u0001"+
		"\u0000\u0000\u0000|{\u0001\u0000\u0000\u0000}\u001f\u0001\u0000\u0000"+
		"\u0000~\u007f\u0005\n\u0000\u0000\u007f!\u0001\u0000\u0000\u0000\u0080"+
		"\u0081\u0005\b\u0000\u0000\u0081#\u0001\u0000\u0000\u0000\u0082\u0088"+
		"\u0003&\u0013\u0000\u0083\u0088\u0003(\u0014\u0000\u0084\u0088\u0003*"+
		"\u0015\u0000\u0085\u0088\u0003,\u0016\u0000\u0086\u0088\u0001\u0000\u0000"+
		"\u0000\u0087\u0082\u0001\u0000\u0000\u0000\u0087\u0083\u0001\u0000\u0000"+
		"\u0000\u0087\u0084\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000"+
		"\u0000\u0087\u0086\u0001\u0000\u0000\u0000\u0088%\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0005\b\u0000\u0000\u008a\'\u0001\u0000\u0000\u0000\u008b"+
		"\u008c\u0005\t\u0000\u0000\u008c)\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0005\n\u0000\u0000\u008e+\u0001\u0000\u0000\u0000\u008f\u0090\u0005"+
		"\u000b\u0000\u0000\u0090-\u0001\u0000\u0000\u0000\u0091\u0092\u00030\u0018"+
		"\u0000\u0092\u0093\u0005\u0006\u0000\u0000\u0093\u0094\u00032\u0019\u0000"+
		"\u0094/\u0001\u0000\u0000\u0000\u0095\u0096\u0005\b\u0000\u0000\u0096"+
		"1\u0001\u0000\u0000\u0000\u0097\u0098\u0005\n\u0000\u0000\u00983\u0001"+
		"\u0000\u0000\u0000\t7>BIMTr|\u0087";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}