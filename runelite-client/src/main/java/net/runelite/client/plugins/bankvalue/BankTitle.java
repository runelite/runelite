/*
 * Copyright (c) 2018, Jeremy Plsek <https://github.com/jplsek>
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
package net.runelite.client.plugins.bankvalue;

import com.google.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.util.StackFormatter;

@Slf4j
class BankTitle
{
	private final Client client;
	private final BankValueConfig config;

	private String bankTitle;

	@Inject
	BankTitle(Client client, BankValueConfig config)
	{
		this.client = client;
		this.config = config;
	}

	void reset()
	{
		Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);

		if (widgetBankTitleBar == null || widgetBankTitleBar.isHidden())
		{
			return;
		}

		widgetBankTitleBar.setText(bankTitle);
	}

	void save()
	{
		Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);

		// Only save if the title hasn't been modified
		// Don't update on a search because rs seems to constantly update the title
		if (widgetBankTitleBar == null ||
				widgetBankTitleBar.isHidden() ||
				widgetBankTitleBar.getText().contains("(") ||
				widgetBankTitleBar.getText().contains("Showing"))
		{
			return;
		}

		bankTitle = widgetBankTitleBar.getText();
	}

	void update(long gePrice, long haPrice)
	{
		Widget widgetBankTitleBar = client.getWidget(WidgetInfo.BANK_TITLE_BAR);

		// Don't update on a search because rs seems to constantly update the title
		if (widgetBankTitleBar == null ||
				widgetBankTitleBar.isHidden() ||
				widgetBankTitleBar.getText().contains("Showing") ||
				widgetBankTitleBar.getText().contains("("))
		{
			return;
		}

		String strCurrentTab = "";

		if (config.showGE() && gePrice != 0)
		{
			strCurrentTab += " (EX: ";

			if (config.showExact())
			{
				strCurrentTab += StackFormatter.formatNumber(gePrice) + ")";
			}
			else
			{
				strCurrentTab += StackFormatter.quantityToStackSize(gePrice) + ")";
			}
		}

		if (config.showHA() && haPrice != 0)
		{
			strCurrentTab += " (HA: ";

			if (config.showExact())
			{
				strCurrentTab += StackFormatter.formatNumber(haPrice) + ")";
			}
			else
			{
				strCurrentTab += StackFormatter.quantityToStackSize(haPrice) + ")";
			}
		}

		log.debug("Setting bank title: {}", bankTitle + strCurrentTab);
		widgetBankTitleBar.setText(bankTitle + strCurrentTab);
	}
}
