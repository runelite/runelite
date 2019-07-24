// Generated from net\runelite\cache\script\assembler\rs2asm.g4 by ANTLR 4.6
package net.runelite.cache.script.assembler;

import java.util.List;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class rs2asmParser extends Parser
{
	public static final int
		T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, NEWLINE = 7, INT = 8, QSTRING = 9,
		IDENTIFIER = 10, COMMENT = 11, WS = 12;
	public static final int
		RULE_prog = 0, RULE_header = 1, RULE_id = 2, RULE_int_stack_count = 3,
		RULE_string_stack_count = 4, RULE_int_var_count = 5, RULE_string_var_count = 6,
		RULE_id_value = 7, RULE_int_stack_value = 8, RULE_string_stack_value = 9,
		RULE_int_var_value = 10, RULE_string_var_value = 11, RULE_line = 12, RULE_instruction = 13,
		RULE_label = 14, RULE_instruction_name = 15, RULE_name_string = 16, RULE_name_opcode = 17,
		RULE_instruction_operand = 18, RULE_operand_int = 19, RULE_operand_qstring = 20,
		RULE_operand_label = 21, RULE_switch_lookup = 22, RULE_switch_key = 23,
		RULE_switch_value = 24;
	public static final String[] ruleNames = {
		"prog", "header", "id", "int_stack_count", "string_stack_count", "int_var_count",
		"string_var_count", "id_value", "int_stack_value", "string_stack_value",
		"int_var_value", "string_var_value", "line", "instruction", "label", "instruction_name",
		"name_string", "name_opcode", "instruction_operand", "operand_int", "operand_qstring",
		"operand_label", "switch_lookup", "switch_key", "switch_value"
	};
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\16\u0097\4\2\t\2" +
			"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13" +
			"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
			"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
			"\4\32\t\32\3\2\7\2\66\n\2\f\2\16\29\13\2\3\2\3\2\6\2=\n\2\r\2\16\2>\7" +
			"\2A\n\2\f\2\16\2D\13\2\3\2\3\2\6\2H\n\2\r\2\16\2I\6\2L\n\2\r\2\16\2M\3" +
			"\3\3\3\3\3\3\3\3\3\5\3U\n\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\7\3" +
			"\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16" +
			"\3\16\5\16s\n\16\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\5\21}\n\21\3" +
			"\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\5\24\u0087\n\24\3\25\3\25\3\26" +
			"\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\2\2\33\2" +
			"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\2\u008c\2\67\3" +
			"\2\2\2\4T\3\2\2\2\6V\3\2\2\2\bY\3\2\2\2\n\\\3\2\2\2\f_\3\2\2\2\16b\3\2" +
			"\2\2\20e\3\2\2\2\22g\3\2\2\2\24i\3\2\2\2\26k\3\2\2\2\30m\3\2\2\2\32r\3" +
			"\2\2\2\34t\3\2\2\2\36w\3\2\2\2 |\3\2\2\2\"~\3\2\2\2$\u0080\3\2\2\2&\u0086" +
			"\3\2\2\2(\u0088\3\2\2\2*\u008a\3\2\2\2,\u008c\3\2\2\2.\u008e\3\2\2\2\60" +
			"\u0092\3\2\2\2\62\u0094\3\2\2\2\64\66\7\t\2\2\65\64\3\2\2\2\669\3\2\2" +
			"\2\67\65\3\2\2\2\678\3\2\2\28B\3\2\2\29\67\3\2\2\2:<\5\4\3\2;=\7\t\2\2" +
			"<;\3\2\2\2=>\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@:\3\2\2\2AD\3\2\2\2" +
			"B@\3\2\2\2BC\3\2\2\2CK\3\2\2\2DB\3\2\2\2EG\5\32\16\2FH\7\t\2\2GF\3\2\2" +
			"\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KE\3\2\2\2LM\3\2\2\2MK\3\2\2" +
			"\2MN\3\2\2\2N\3\3\2\2\2OU\5\6\4\2PU\5\b\5\2QU\5\n\6\2RU\5\f\7\2SU\5\16" +
			"\b\2TO\3\2\2\2TP\3\2\2\2TQ\3\2\2\2TR\3\2\2\2TS\3\2\2\2U\5\3\2\2\2VW\7" +
			"\3\2\2WX\5\20\t\2X\7\3\2\2\2YZ\7\4\2\2Z[\5\22\n\2[\t\3\2\2\2\\]\7\5\2" +
			"\2]^\5\24\13\2^\13\3\2\2\2_`\7\6\2\2`a\5\26\f\2a\r\3\2\2\2bc\7\7\2\2c" +
			"d\5\30\r\2d\17\3\2\2\2ef\7\n\2\2f\21\3\2\2\2gh\7\n\2\2h\23\3\2\2\2ij\7" +
			"\n\2\2j\25\3\2\2\2kl\7\n\2\2l\27\3\2\2\2mn\7\n\2\2n\31\3\2\2\2os\5\34" +
			"\17\2ps\5\36\20\2qs\5.\30\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2\2s\33\3\2\2\2" +
			"tu\5 \21\2uv\5&\24\2v\35\3\2\2\2wx\7\f\2\2xy\7\b\2\2y\37\3\2\2\2z}\5\"" +
			"\22\2{}\5$\23\2|z\3\2\2\2|{\3\2\2\2}!\3\2\2\2~\177\7\f\2\2\177#\3\2\2" +
			"\2\u0080\u0081\7\n\2\2\u0081%\3\2\2\2\u0082\u0087\5(\25\2\u0083\u0087" +
			"\5*\26\2\u0084\u0087\5,\27\2\u0085\u0087\3\2\2\2\u0086\u0082\3\2\2\2\u0086" +
			"\u0083\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0085\3\2\2\2\u0087\'\3\2\2\2" +
			"\u0088\u0089\7\n\2\2\u0089)\3\2\2\2\u008a\u008b\7\13\2\2\u008b+\3\2\2" +
			"\2\u008c\u008d\7\f\2\2\u008d-\3\2\2\2\u008e\u008f\5\60\31\2\u008f\u0090" +
			"\7\b\2\2\u0090\u0091\5\62\32\2\u0091/\3\2\2\2\u0092\u0093\7\n\2\2\u0093" +
			"\61\3\2\2\2\u0094\u0095\7\f\2\2\u0095\63\3\2\2\2\13\67>BIMTr|\u0086";
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

	public rs2asmParser(TokenStream input)
	{
		super(input);
		_interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
	}

	@Override
	@Deprecated
	public String[] getTokenNames()
	{
		return tokenNames;
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

	public final ProgContext prog() throws RecognitionException
	{
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == NEWLINE)
				{
					{
						{
							setState(50);
							match(NEWLINE);
						}
					}
					setState(55);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(64);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4))) != 0))
				{
					{
						{
							setState(56);
							header();
							setState(58);
							_errHandler.sync(this);
							_la = _input.LA(1);
							do
							{
								{
									{
										setState(57);
										match(NEWLINE);
									}
								}
								setState(60);
								_errHandler.sync(this);
								_la = _input.LA(1);
							} while (_la == NEWLINE);
						}
					}
					setState(66);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
				do
				{
					{
						{
							setState(67);
							line();
							setState(69);
							_errHandler.sync(this);
							_la = _input.LA(1);
							do
							{
								{
									{
										setState(68);
										match(NEWLINE);
									}
								}
								setState(71);
								_errHandler.sync(this);
								_la = _input.LA(1);
							} while (_la == NEWLINE);
						}
					}
					setState(75);
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while (_la == INT || _la == IDENTIFIER);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final HeaderContext header() throws RecognitionException
	{
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_header);
		try
		{
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1))
			{
				case T__0:
					enterOuterAlt(_localctx, 1);
				{
					setState(77);
					id();
				}
				break;
				case T__1:
					enterOuterAlt(_localctx, 2);
				{
					setState(78);
					int_stack_count();
				}
				break;
				case T__2:
					enterOuterAlt(_localctx, 3);
				{
					setState(79);
					string_stack_count();
				}
				break;
				case T__3:
					enterOuterAlt(_localctx, 4);
				{
					setState(80);
					int_var_count();
				}
				break;
				case T__4:
					enterOuterAlt(_localctx, 5);
				{
					setState(81);
					string_var_count();
				}
				break;
				default:
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final IdContext id() throws RecognitionException
	{
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_id);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(84);
				match(T__0);
				setState(85);
				id_value();
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Int_stack_countContext int_stack_count() throws RecognitionException
	{
		Int_stack_countContext _localctx = new Int_stack_countContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_int_stack_count);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(87);
				match(T__1);
				setState(88);
				int_stack_value();
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final String_stack_countContext string_stack_count() throws RecognitionException
	{
		String_stack_countContext _localctx = new String_stack_countContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_string_stack_count);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(90);
				match(T__2);
				setState(91);
				string_stack_value();
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Int_var_countContext int_var_count() throws RecognitionException
	{
		Int_var_countContext _localctx = new Int_var_countContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_int_var_count);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(93);
				match(T__3);
				setState(94);
				int_var_value();
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final String_var_countContext string_var_count() throws RecognitionException
	{
		String_var_countContext _localctx = new String_var_countContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_string_var_count);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(96);
				match(T__4);
				setState(97);
				string_var_value();
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Id_valueContext id_value() throws RecognitionException
	{
		Id_valueContext _localctx = new Id_valueContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_id_value);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(99);
				match(INT);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Int_stack_valueContext int_stack_value() throws RecognitionException
	{
		Int_stack_valueContext _localctx = new Int_stack_valueContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_int_stack_value);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(101);
				match(INT);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final String_stack_valueContext string_stack_value() throws RecognitionException
	{
		String_stack_valueContext _localctx = new String_stack_valueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_string_stack_value);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(103);
				match(INT);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Int_var_valueContext int_var_value() throws RecognitionException
	{
		Int_var_valueContext _localctx = new Int_var_valueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_int_var_value);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(105);
				match(INT);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final String_var_valueContext string_var_value() throws RecognitionException
	{
		String_var_valueContext _localctx = new String_var_valueContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_string_var_value);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(107);
				match(INT);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final LineContext line() throws RecognitionException
	{
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_line);
		try
		{
			setState(112);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 6, _ctx))
			{
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(109);
					instruction();
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(110);
					label();
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(111);
					switch_lookup();
				}
				break;
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final InstructionContext instruction() throws RecognitionException
	{
		InstructionContext _localctx = new InstructionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_instruction);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(114);
				instruction_name();
				setState(115);
				instruction_operand();
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final LabelContext label() throws RecognitionException
	{
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_label);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(117);
				match(IDENTIFIER);
				setState(118);
				match(T__5);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Instruction_nameContext instruction_name() throws RecognitionException
	{
		Instruction_nameContext _localctx = new Instruction_nameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_instruction_name);
		try
		{
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1))
			{
				case IDENTIFIER:
					enterOuterAlt(_localctx, 1);
				{
					setState(120);
					name_string();
				}
				break;
				case INT:
					enterOuterAlt(_localctx, 2);
				{
					setState(121);
					name_opcode();
				}
				break;
				default:
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Name_stringContext name_string() throws RecognitionException
	{
		Name_stringContext _localctx = new Name_stringContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_name_string);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(124);
				match(IDENTIFIER);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Name_opcodeContext name_opcode() throws RecognitionException
	{
		Name_opcodeContext _localctx = new Name_opcodeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_name_opcode);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(126);
				match(INT);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Instruction_operandContext instruction_operand() throws RecognitionException
	{
		Instruction_operandContext _localctx = new Instruction_operandContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_instruction_operand);
		try
		{
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1))
			{
				case INT:
					enterOuterAlt(_localctx, 1);
				{
					setState(128);
					operand_int();
				}
				break;
				case QSTRING:
					enterOuterAlt(_localctx, 2);
				{
					setState(129);
					operand_qstring();
				}
				break;
				case IDENTIFIER:
					enterOuterAlt(_localctx, 3);
				{
					setState(130);
					operand_label();
				}
				break;
				case NEWLINE:
					enterOuterAlt(_localctx, 4);
				{
				}
				break;
				default:
					throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Operand_intContext operand_int() throws RecognitionException
	{
		Operand_intContext _localctx = new Operand_intContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_operand_int);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(134);
				match(INT);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Operand_qstringContext operand_qstring() throws RecognitionException
	{
		Operand_qstringContext _localctx = new Operand_qstringContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_operand_qstring);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(136);
				match(QSTRING);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Operand_labelContext operand_label() throws RecognitionException
	{
		Operand_labelContext _localctx = new Operand_labelContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_operand_label);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(138);
				match(IDENTIFIER);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Switch_lookupContext switch_lookup() throws RecognitionException
	{
		Switch_lookupContext _localctx = new Switch_lookupContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_switch_lookup);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(140);
				switch_key();
				setState(141);
				match(T__5);
				setState(142);
				switch_value();
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Switch_keyContext switch_key() throws RecognitionException
	{
		Switch_keyContext _localctx = new Switch_keyContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_switch_key);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(144);
				match(INT);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public final Switch_valueContext switch_value() throws RecognitionException
	{
		Switch_valueContext _localctx = new Switch_valueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_switch_value);
		try
		{
			enterOuterAlt(_localctx, 1);
			{
				setState(146);
				match(IDENTIFIER);
			}
		}
		catch (RecognitionException re)
		{
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally
		{
			exitRule();
		}
		return _localctx;
	}

	public static class ProgContext extends ParserRuleContext
	{
		public ProgContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public List<TerminalNode> NEWLINE()
		{
			return getTokens(rs2asmParser.NEWLINE);
		}

		public TerminalNode NEWLINE(int i)
		{
			return getToken(rs2asmParser.NEWLINE, i);
		}

		public List<HeaderContext> header()
		{
			return getRuleContexts(HeaderContext.class);
		}

		public HeaderContext header(int i)
		{
			return getRuleContext(HeaderContext.class, i);
		}

		public List<LineContext> line()
		{
			return getRuleContexts(LineContext.class);
		}

		public LineContext line(int i)
		{
			return getRuleContext(LineContext.class, i);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_prog;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterProg(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitProg(this);
			}
		}
	}

	public static class HeaderContext extends ParserRuleContext
	{
		public HeaderContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public IdContext id()
		{
			return getRuleContext(IdContext.class, 0);
		}

		public Int_stack_countContext int_stack_count()
		{
			return getRuleContext(Int_stack_countContext.class, 0);
		}

		public String_stack_countContext string_stack_count()
		{
			return getRuleContext(String_stack_countContext.class, 0);
		}

		public Int_var_countContext int_var_count()
		{
			return getRuleContext(Int_var_countContext.class, 0);
		}

		public String_var_countContext string_var_count()
		{
			return getRuleContext(String_var_countContext.class, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_header;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterHeader(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitHeader(this);
			}
		}
	}

	public static class IdContext extends ParserRuleContext
	{
		public IdContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public Id_valueContext id_value()
		{
			return getRuleContext(Id_valueContext.class, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_id;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterId(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitId(this);
			}
		}
	}

	public static class Int_stack_countContext extends ParserRuleContext
	{
		public Int_stack_countContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public Int_stack_valueContext int_stack_value()
		{
			return getRuleContext(Int_stack_valueContext.class, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_int_stack_count;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterInt_stack_count(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitInt_stack_count(this);
			}
		}
	}

	public static class String_stack_countContext extends ParserRuleContext
	{
		public String_stack_countContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public String_stack_valueContext string_stack_value()
		{
			return getRuleContext(String_stack_valueContext.class, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_string_stack_count;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterString_stack_count(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitString_stack_count(this);
			}
		}
	}

	public static class Int_var_countContext extends ParserRuleContext
	{
		public Int_var_countContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public Int_var_valueContext int_var_value()
		{
			return getRuleContext(Int_var_valueContext.class, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_int_var_count;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterInt_var_count(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitInt_var_count(this);
			}
		}
	}

	public static class String_var_countContext extends ParserRuleContext
	{
		public String_var_countContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public String_var_valueContext string_var_value()
		{
			return getRuleContext(String_var_valueContext.class, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_string_var_count;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterString_var_count(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitString_var_count(this);
			}
		}
	}

	public static class Id_valueContext extends ParserRuleContext
	{
		public Id_valueContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode INT()
		{
			return getToken(rs2asmParser.INT, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_id_value;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterId_value(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitId_value(this);
			}
		}
	}

	public static class Int_stack_valueContext extends ParserRuleContext
	{
		public Int_stack_valueContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode INT()
		{
			return getToken(rs2asmParser.INT, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_int_stack_value;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterInt_stack_value(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitInt_stack_value(this);
			}
		}
	}

	public static class String_stack_valueContext extends ParserRuleContext
	{
		public String_stack_valueContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode INT()
		{
			return getToken(rs2asmParser.INT, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_string_stack_value;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterString_stack_value(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitString_stack_value(this);
			}
		}
	}

	public static class Int_var_valueContext extends ParserRuleContext
	{
		public Int_var_valueContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode INT()
		{
			return getToken(rs2asmParser.INT, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_int_var_value;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterInt_var_value(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitInt_var_value(this);
			}
		}
	}

	public static class String_var_valueContext extends ParserRuleContext
	{
		public String_var_valueContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode INT()
		{
			return getToken(rs2asmParser.INT, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_string_var_value;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterString_var_value(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitString_var_value(this);
			}
		}
	}

	public static class LineContext extends ParserRuleContext
	{
		public LineContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public InstructionContext instruction()
		{
			return getRuleContext(InstructionContext.class, 0);
		}

		public LabelContext label()
		{
			return getRuleContext(LabelContext.class, 0);
		}

		public Switch_lookupContext switch_lookup()
		{
			return getRuleContext(Switch_lookupContext.class, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_line;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterLine(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitLine(this);
			}
		}
	}

	public static class InstructionContext extends ParserRuleContext
	{
		public InstructionContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public Instruction_nameContext instruction_name()
		{
			return getRuleContext(Instruction_nameContext.class, 0);
		}

		public Instruction_operandContext instruction_operand()
		{
			return getRuleContext(Instruction_operandContext.class, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_instruction;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterInstruction(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitInstruction(this);
			}
		}
	}

	public static class LabelContext extends ParserRuleContext
	{
		public LabelContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode IDENTIFIER()
		{
			return getToken(rs2asmParser.IDENTIFIER, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_label;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterLabel(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitLabel(this);
			}
		}
	}

	public static class Instruction_nameContext extends ParserRuleContext
	{
		public Instruction_nameContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public Name_stringContext name_string()
		{
			return getRuleContext(Name_stringContext.class, 0);
		}

		public Name_opcodeContext name_opcode()
		{
			return getRuleContext(Name_opcodeContext.class, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_instruction_name;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterInstruction_name(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitInstruction_name(this);
			}
		}
	}

	public static class Name_stringContext extends ParserRuleContext
	{
		public Name_stringContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode IDENTIFIER()
		{
			return getToken(rs2asmParser.IDENTIFIER, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_name_string;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterName_string(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitName_string(this);
			}
		}
	}

	public static class Name_opcodeContext extends ParserRuleContext
	{
		public Name_opcodeContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode INT()
		{
			return getToken(rs2asmParser.INT, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_name_opcode;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterName_opcode(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitName_opcode(this);
			}
		}
	}

	public static class Instruction_operandContext extends ParserRuleContext
	{
		public Instruction_operandContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public Operand_intContext operand_int()
		{
			return getRuleContext(Operand_intContext.class, 0);
		}

		public Operand_qstringContext operand_qstring()
		{
			return getRuleContext(Operand_qstringContext.class, 0);
		}

		public Operand_labelContext operand_label()
		{
			return getRuleContext(Operand_labelContext.class, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_instruction_operand;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterInstruction_operand(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitInstruction_operand(this);
			}
		}
	}

	public static class Operand_intContext extends ParserRuleContext
	{
		public Operand_intContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode INT()
		{
			return getToken(rs2asmParser.INT, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_operand_int;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterOperand_int(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitOperand_int(this);
			}
		}
	}

	public static class Operand_qstringContext extends ParserRuleContext
	{
		public Operand_qstringContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode QSTRING()
		{
			return getToken(rs2asmParser.QSTRING, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_operand_qstring;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterOperand_qstring(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitOperand_qstring(this);
			}
		}
	}

	public static class Operand_labelContext extends ParserRuleContext
	{
		public Operand_labelContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode IDENTIFIER()
		{
			return getToken(rs2asmParser.IDENTIFIER, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_operand_label;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterOperand_label(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitOperand_label(this);
			}
		}
	}

	public static class Switch_lookupContext extends ParserRuleContext
	{
		public Switch_lookupContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public Switch_keyContext switch_key()
		{
			return getRuleContext(Switch_keyContext.class, 0);
		}

		public Switch_valueContext switch_value()
		{
			return getRuleContext(Switch_valueContext.class, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_switch_lookup;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterSwitch_lookup(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitSwitch_lookup(this);
			}
		}
	}

	public static class Switch_keyContext extends ParserRuleContext
	{
		public Switch_keyContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode INT()
		{
			return getToken(rs2asmParser.INT, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_switch_key;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterSwitch_key(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitSwitch_key(this);
			}
		}
	}

	public static class Switch_valueContext extends ParserRuleContext
	{
		public Switch_valueContext(ParserRuleContext parent, int invokingState)
		{
			super(parent, invokingState);
		}

		public TerminalNode IDENTIFIER()
		{
			return getToken(rs2asmParser.IDENTIFIER, 0);
		}

		@Override
		public int getRuleIndex()
		{
			return RULE_switch_value;
		}

		@Override
		public void enterRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).enterSwitch_value(this);
			}
		}

		@Override
		public void exitRule(ParseTreeListener listener)
		{
			if (listener instanceof rs2asmListener)
			{
				((rs2asmListener) listener).exitSwitch_value(this);
			}
		}
	}
}