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

import java.awt.Point;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.text.JTextComponent;
import jdk.jshell.JShell;
import jdk.jshell.SourceCodeAnalysis;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.Completion;
import org.fife.ui.autocomplete.CompletionProviderBase;
import org.fife.ui.autocomplete.ParameterizedCompletion;

@Slf4j
@RequiredArgsConstructor
public class JShellAutocompleteProvider extends CompletionProviderBase
{
	private final JShell shell;
	private String anchorText;
	private List<Completion> completions;

	@Override
	protected List<Completion> getCompletionsImpl(JTextComponent comp)
	{
		return completions;
	}

	@Override
	public String getAlreadyEnteredText(JTextComponent comp)
	{
		complete(comp);
		return anchorText;
	}

	private void complete(JTextComponent comp)
	{
		completions = Collections.emptyList();

		String src = comp.getText();
		int cursor = comp.getCaretPosition();

		for (int offset = 0; offset < src.length() && cursor >= offset; )
		{
			var snipSrc = src.substring(offset);
			int thisOffset = offset;
			var ci = shell.sourceCodeAnalysis().analyzeCompletion(snipSrc);
			offset = src.length() - ci.remaining().length();
			boolean mayHaveMore = ci.completeness() == SourceCodeAnalysis.Completeness.COMPLETE_WITH_SEMI
				|| ci.completeness() == SourceCodeAnalysis.Completeness.COMPLETE;

			if (cursor <= offset || !mayHaveMore)
			{
				var anchor = new int[1];

				completions = shell.sourceCodeAnalysis()
					.completionSuggestions(snipSrc, cursor - thisOffset, anchor)
					.stream()
					.filter(v -> !v.continuation().startsWith("$"))
					.map(s ->
					{
						return new BasicCompletion(this, s.continuation());
					})
					.collect(Collectors.toList());
				anchorText = snipSrc.substring(anchor[0], cursor - thisOffset);
				break;
			}
		}

		if (completions.isEmpty())
		{
			anchorText = null;
		}
	}

	@Override
	public List<Completion> getCompletionsAt(JTextComponent comp, Point p)
	{
		return Collections.emptyList();
	}

	@Override
	public boolean isAutoActivateOkay(JTextComponent comp)
	{
		// try not to start autocomplete when it has no useful context
		String text = comp.getText();
		for (int i = comp.getCaretPosition(); i >= 0; i--)
		{
			char c = text.charAt(i);
			if (Character.isJavaIdentifierPart(c) || c == '.' || c == '(')
			{
				return true;
			}
			if (Character.isWhitespace(c))
			{
				continue;
			}

			return false;
		}

		return false;
	}

	@Override
	public List<ParameterizedCompletion> getParameterizedCompletions(JTextComponent tc)
	{
		return Collections.emptyList();
	}
}

