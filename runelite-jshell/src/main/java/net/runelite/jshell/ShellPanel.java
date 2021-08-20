/*
 * Copyright (c) 2021 Abex
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.jshell;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableSet;
import com.google.inject.Injector;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.Segment;
import jdk.jshell.Diag;
import jdk.jshell.JShell;
import jdk.jshell.Snippet;
import jdk.jshell.SnippetEvent;
import jdk.jshell.SourceCodeAnalysis;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.fife.ui.autocomplete.AutoCompletion;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rsyntaxtextarea.Theme;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public abstract class ShellPanel extends JPanel
{
	private final ScheduledExecutorService executor;

	private final RSyntaxTextArea textArea;
	private final JTextArea console = new JTextArea();

	@Getter
	private final Logger shellLogger;

	private final List<Runnable> cleanup = new ArrayList<>();

	private RLShellExecutionControl exec;
	private JShell shell;
	private Set<Snippet> prelude;
	private Injector injector;
	private AutoCompletion autoCompletion;

	public static ShellPanel INSTANCE;

	public ShellPanel(ScheduledExecutorService executor)
	{
		this.executor = executor;

		Font codeFont = Stream.of(
			"Source code pro",
			"DejaVu Sans Code",
			"Consolas",
			Font.MONOSPACED)
			.map(name -> new Font(name, Font.PLAIN, 12))
			.filter(f -> !"Dialog.plain".equals(f.getFontName()))
			.findFirst()
			.get();

		setLayout(new BorderLayout());

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JButton run = new JButton("⯈");
		run.setToolTipText("Run");
		run.addActionListener(ev -> run());
		topPanel.add(run);

		JButton clear = new JButton("🗑");
		run.setToolTipText("Clear console");
		clear.addActionListener(ev -> console.setText(""));
		topPanel.add(clear);

		add(topPanel, BorderLayout.NORTH);

		textArea = new RSyntaxTextArea();

		try
		{
			// RSyntaxTextArea::setAntiAliasingEnabled actually forces it to match the platform's
			// default, which is pointless
			var map = new HashMap<RenderingHints.Key, Object>();
			map.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

			var f = RSyntaxTextArea.class.getDeclaredField("aaHints");
			f.setAccessible(true);
			f.set(textArea, map);
		}
		catch (ReflectiveOperationException e)
		{
			throw new RuntimeException(e);
		}

		textArea.setFont(codeFont);
		textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		textArea.setAutoIndentEnabled(true);
		textArea.setPaintTabLines(true);
		textArea.setShowMatchedBracketPopup(true);
		textArea.setCloseCurlyBraces(false);
		textArea.setTabSize(2);
		textArea.setMarkOccurrences(true);
		textArea.setMarkOccurrencesDelay(200);
		textArea.addKeyListener(new KeyAdapter()
		{
			@Override
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_R && (e.getModifiersEx() & KeyEvent.CTRL_DOWN_MASK) != 0)
				{
					run();
					e.consume();
				}
				if (e.getKeyCode() == KeyEvent.VK_F10)
				{
					run();
					e.consume();
				}
			}
		});

		var textScrollArea = new RTextScrollPane(textArea);

		try
		{
			Theme.load(ShellPanel.class.getResourceAsStream("darcula.xml"), codeFont)
				.apply(textArea);

			try (var is = ShellPanel.class.getResourceAsStream("default.jsh"))
			{
				textArea.setText(new String(is.readAllBytes(), StandardCharsets.UTF_8));
			}
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}

		console.setFont(codeFont);
		console.setFocusable(false);
		console.setEditable(false);
		console.setOpaque(false); // this turns off the hover effect for some reason

		var split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, textScrollArea, new JScrollPane(console));
		split.setResizeWeight(.8);
		split.setPreferredSize(new Dimension(800, 800));
		add(split, BorderLayout.CENTER);

		shellLogger = new TeeLogger(LoggerFactory.getLogger("Shell"), this::logToConsole);
		INSTANCE = this;

		// make sure jshell is on the classpath
		JShell.builder();
	}

	public void switchContext(Injector injector)
	{
		freeContext();

		this.injector = injector;

		exec = new RLShellExecutionControl()
		{
			@Override
			protected String invoke(Method doitMethod) throws Exception
			{
				var result = new AtomicReference<>();
				var sema = new Semaphore(0);
				invokeOnClientThread(() ->
				{
					try
					{
						result.set(super.invoke(doitMethod));
					}
					catch (Exception e)
					{
						result.set(e);
					}
					finally
					{
						sema.release();
					}
				});
				sema.acquire();
				if (result.get() instanceof String)
				{
					return (String) result.get();
				}
				throw (Exception) result.get();
			}
		};

		shell = JShell.builder()
			.executionEngine(exec, null)
			.build();

		String preludeStr;
		try (var is = ShellPanel.class.getResourceAsStream("prelude.jsh"))
		{
			preludeStr = new String(is.readAllBytes(), StandardCharsets.UTF_8);
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		prelude = ImmutableSet.copyOf(eval(preludeStr, false));

		var cp = new JShellAutocompleteProvider(shell);
		autoCompletion = new AutoCompletion(cp);
		autoCompletion.setAutoActivationDelay(200);
		autoCompletion.setAutoActivationEnabled(true);
		autoCompletion.setAutoCompleteSingleChoices(false);
		autoCompletion.install(this.textArea);
	}

	public void logToConsole(String message)
	{
		SwingUtilities.invokeLater(() ->
		{
			try
			{
				var doc = console.getDocument();
				if (doc.getLength() > 100_000)
				{
					Segment seg = new Segment();
					int i = doc.getLength() - 75_000;
					for (; i < doc.getLength(); i++)
					{
						doc.getText(i, 1, seg);
						if (seg.array[0] == '\n')
						{
							break;
						}
					}
					doc.remove(0, i);
				}
				doc.insertString(doc.getLength(), message + "\n", null);
				console.setCaretPosition(doc.getLength());
			}
			catch (BadLocationException e)
			{
				throw new RuntimeException(e);
			}
		});
	}

	private List<Snippet> eval(String src, boolean isUserCode)
	{
		var out = new ArrayList<Snippet>();
		var offsets = new HashMap<String, Integer>();
		String output = null;
		evaluation:
		for (int offset = 0; offset < src.length(); )
		{
			// Workaround a jdk bug
			for (; src.charAt(offset) == '\n'; offset++);

			var ci = shell.sourceCodeAnalysis().analyzeCompletion(src.substring(offset));
			int thisOffset = offset;
			offset = src.length() - ci.remaining().length();
			if (ci.completeness() == SourceCodeAnalysis.Completeness.EMPTY)
			{
				break;
			}

			List<SnippetEvent> evs = shell.eval(ci.source());
			for (var ev : evs)
			{
				Snippet snip = ev.snippet();
				offsets.put("#" + snip.id(), thisOffset);
				if (ev.status() != Snippet.Status.VALID && ev.status() != Snippet.Status.RECOVERABLE_DEFINED)
				{
					var diags = shell.diagnostics(snip).collect(Collectors.toList());
					for (var diag : diags)
					{
						String msg = toStringDiagnostic(src, thisOffset, diag);
						if (isUserCode)
						{
							logToConsole(msg);
							// It might be nice to highlight stuff here
						}
						else
						{
							throw new RuntimeException("prelude error: " + msg);
						}
					}
					if (diags.isEmpty())
					{
						logToConsole("bad snippet" + ev.status());
					}
					break evaluation;
				}
				if (ev.exception() != null)
				{
					if (isUserCode)
					{
						shellLogger.error("", new RemappingThrowable(src, offsets, ev.exception()));
					}
					else
					{
						throw new RuntimeException("prelude error", ev.exception());
					}
				}
				output = ev.value();

				out.add(snip);
			}
		}

		if (isUserCode && !Strings.isNullOrEmpty(output))
		{
			logToConsole("[OUTPUT] " + output);
		}

		return out;
	}

	private String toStringDiagnostic(String source, int offset, Diag diag)
	{
		int line = 1;
		int column = 1;
		offset += (int) diag.getPosition();
		for (int i = 0; i < offset && i < source.length(); i++)
		{
			if (source.charAt(i) == '\n')
			{
				line++;
				column = 1;
			}
			else
			{
				column++;
			}
		}

		return line + ":" + column + ": " + diag.getMessage(Locale.getDefault());
	}

	protected void run()
	{
		String text = textArea.getText();
		executor.submit(() ->
		{
			shell.snippets()
				.filter(v -> !prelude.contains(v))
				.forEach(shell::drop);

			cleanup();

			eval(text, true);
		});
	}

	public void freeContext()
	{
		cleanup();

		exec = null;
		shell = null;
		prelude = null;
		injector = null;

		if (autoCompletion != null)
		{
			autoCompletion.uninstall();
		}
		autoCompletion = null;

		console.setText("");
	}

	private void cleanup()
	{
		for (var c : cleanup)
		{
			try
			{
				c.run();
			}
			catch (Exception e)
			{
				shellLogger.error("Cleanup threw:", e);
			}
		}
		cleanup.clear();
	}

	protected abstract void invokeOnClientThread(Runnable r);

	public <T> T inject(Class<T> clazz)
	{
		return injector.getInstance(clazz);
	}

	public void cleanup(Runnable r)
	{
		cleanup.add(r);
	}
}
