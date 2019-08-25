/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package net.runelite.client.ui.skin;

import javax.swing.AbstractButton;
import org.pushingpixels.substance.api.ComponentState;
import org.pushingpixels.substance.api.SubstanceColorSchemeBundle;
import org.pushingpixels.substance.api.SubstanceSkin;
import org.pushingpixels.substance.api.SubstanceSlices.ColorSchemeAssociationKind;
import org.pushingpixels.substance.api.SubstanceSlices.DecorationAreaType;
import org.pushingpixels.substance.api.colorscheme.ColorSchemeSingleColorQuery;
import org.pushingpixels.substance.api.colorscheme.SubstanceColorScheme;
import org.pushingpixels.substance.api.painter.border.ClassicBorderPainter;
import org.pushingpixels.substance.api.painter.border.CompositeBorderPainter;
import org.pushingpixels.substance.api.painter.border.DelegateBorderPainter;
import org.pushingpixels.substance.api.painter.decoration.MatteDecorationPainter;
import org.pushingpixels.substance.api.painter.fill.FractionBasedFillPainter;
import org.pushingpixels.substance.api.painter.highlight.ClassicHighlightPainter;
import org.pushingpixels.substance.api.painter.overlay.BottomLineOverlayPainter;
import org.pushingpixels.substance.api.painter.overlay.BottomShadowOverlayPainter;
import org.pushingpixels.substance.api.painter.overlay.TopBezelOverlayPainter;
import org.pushingpixels.substance.api.painter.overlay.TopLineOverlayPainter;
import org.pushingpixels.substance.api.shaper.ClassicButtonShaper;
import org.pushingpixels.substance.internal.utils.SubstanceColorUtilities;

class ObsidianSkin extends SubstanceSkin
{
	/**
	 * Display name for <code>this</code> skin.
	 */
	private static final String NAME = "RuneLite";

	/**
	 * Creates a new <code>RuneLite</code> skin.
	 */
	ObsidianSkin()
	{
		final SubstanceSkin.ColorSchemes schemes = SubstanceSkin
			.getColorSchemes(getClass().getResource(NAME + ".colorschemes"));
		final SubstanceColorScheme activeScheme = schemes.get("RuneLite Active");
		final SubstanceColorScheme enabledScheme = schemes.get("RuneLite Enabled");

		final SubstanceColorSchemeBundle defaultSchemeBundle = new SubstanceColorSchemeBundle(
			activeScheme, enabledScheme, enabledScheme);
		defaultSchemeBundle.registerColorScheme(enabledScheme, 0.6f,
			ComponentState.DISABLED_UNSELECTED);
		defaultSchemeBundle.registerColorScheme(activeScheme, 0.6f,
			ComponentState.DISABLED_SELECTED);

		// borders
		final SubstanceColorScheme borderDisabledSelectedScheme = schemes
			.get("RuneLite Selected Disabled Border");
		final SubstanceColorScheme borderScheme = schemes.get("RuneLite Border");
		defaultSchemeBundle.registerColorScheme(borderDisabledSelectedScheme,
			ColorSchemeAssociationKind.BORDER, ComponentState.DISABLED_SELECTED);
		defaultSchemeBundle.registerColorScheme(borderScheme, ColorSchemeAssociationKind.BORDER);

		// marks
		final SubstanceColorScheme markActiveScheme = schemes.get("RuneLite Mark Active");
		defaultSchemeBundle.registerColorScheme(markActiveScheme, ColorSchemeAssociationKind.MARK,
			ComponentState.getActiveStates());
		defaultSchemeBundle.registerColorScheme(markActiveScheme, 0.6f,
			ColorSchemeAssociationKind.MARK, ComponentState.DISABLED_SELECTED,
			ComponentState.DISABLED_UNSELECTED);

		// separators
		final SubstanceColorScheme separatorScheme = schemes.get("RuneLite Separator");
		defaultSchemeBundle.registerColorScheme(separatorScheme,
			ColorSchemeAssociationKind.SEPARATOR);

		// tab borders
		defaultSchemeBundle.registerColorScheme(schemes.get("RuneLite Tab Border"),
			ColorSchemeAssociationKind.TAB_BORDER, ComponentState.getActiveStates());

		final SubstanceColorScheme watermarkScheme = schemes.get("RuneLite Watermark");

		this.registerDecorationAreaSchemeBundle(defaultSchemeBundle, watermarkScheme,
			DecorationAreaType.NONE);

		final SubstanceColorSchemeBundle decorationsSchemeBundle = new SubstanceColorSchemeBundle(
			activeScheme, enabledScheme, enabledScheme);
		decorationsSchemeBundle.registerColorScheme(enabledScheme, 0.5f,
			ComponentState.DISABLED_UNSELECTED);

		// borders
		decorationsSchemeBundle.registerColorScheme(borderDisabledSelectedScheme,
			ColorSchemeAssociationKind.BORDER, ComponentState.DISABLED_SELECTED);
		decorationsSchemeBundle.registerColorScheme(borderScheme,
			ColorSchemeAssociationKind.BORDER);

		// marks
		decorationsSchemeBundle.registerColorScheme(markActiveScheme,
			ColorSchemeAssociationKind.MARK, ComponentState.getActiveStates());

		// separators
		final SubstanceColorScheme separatorDecorationsScheme = schemes
			.get("RuneLite Decorations Separator");
		decorationsSchemeBundle.registerColorScheme(separatorDecorationsScheme,
			ColorSchemeAssociationKind.SEPARATOR);

		final SubstanceColorScheme decorationsWatermarkScheme = schemes
			.get("RuneLite Decorations Watermark");

		this.registerDecorationAreaSchemeBundle(decorationsSchemeBundle, decorationsWatermarkScheme,
			DecorationAreaType.TOOLBAR, DecorationAreaType.GENERAL, DecorationAreaType.FOOTER);

		final SubstanceColorSchemeBundle headerSchemeBundle = new SubstanceColorSchemeBundle(activeScheme,
			enabledScheme, enabledScheme);
		headerSchemeBundle.registerColorScheme(enabledScheme, 0.5f,
			ComponentState.DISABLED_UNSELECTED);

		// borders
		final SubstanceColorScheme headerBorderScheme = schemes.get("RuneLite Header Border");
		headerSchemeBundle.registerColorScheme(borderDisabledSelectedScheme,
			ColorSchemeAssociationKind.BORDER, ComponentState.DISABLED_SELECTED);
		headerSchemeBundle.registerColorScheme(headerBorderScheme,
			ColorSchemeAssociationKind.BORDER);
		// marks
		headerSchemeBundle.registerColorScheme(markActiveScheme, ColorSchemeAssociationKind.MARK,
			ComponentState.getActiveStates());

		headerSchemeBundle.registerHighlightColorScheme(activeScheme, 0.7f,
			ComponentState.ROLLOVER_UNSELECTED, ComponentState.ROLLOVER_ARMED,
			ComponentState.ARMED);
		headerSchemeBundle.registerHighlightColorScheme(activeScheme, 0.8f,
			ComponentState.SELECTED);
		headerSchemeBundle.registerHighlightColorScheme(activeScheme, 1.0f,
			ComponentState.ROLLOVER_SELECTED);

		final SubstanceColorScheme headerWatermarkScheme = schemes.get("RuneLite Header Watermark");

		this.registerDecorationAreaSchemeBundle(headerSchemeBundle, headerWatermarkScheme,
			DecorationAreaType.PRIMARY_TITLE_PANE, DecorationAreaType.SECONDARY_TITLE_PANE,
			DecorationAreaType.HEADER);

		setTabFadeStart(0.2);
		setTabFadeEnd(0.9);

		// Add overlay painters to paint drop shadows along the bottom
		// edges of toolbars and footers
		this.addOverlayPainter(BottomShadowOverlayPainter.getInstance(),
			DecorationAreaType.TOOLBAR);
		this.addOverlayPainter(BottomShadowOverlayPainter.getInstance(), DecorationAreaType.FOOTER);

		// add an overlay painter to paint a dark line along the bottom
		// edge of toolbars
		final BottomLineOverlayPainter toolbarBottomLineOverlayPainter = new BottomLineOverlayPainter(
			(SubstanceColorScheme scheme) -> scheme.getUltraDarkColor().darker());
		this.addOverlayPainter(toolbarBottomLineOverlayPainter, DecorationAreaType.TOOLBAR);

		// add an overlay painter to paint a dark line along the bottom
		// edge of toolbars
		final TopLineOverlayPainter toolbarTopLineOverlayPainter = new TopLineOverlayPainter(
			(SubstanceColorScheme scheme) -> SubstanceColorUtilities
				.getAlphaColor(scheme.getForegroundColor(), 32));
		this.addOverlayPainter(toolbarTopLineOverlayPainter, DecorationAreaType.TOOLBAR);

		// add an overlay painter to paint a bezel line along the top
		// edge of footer
		final TopBezelOverlayPainter footerTopBezelOverlayPainter = new TopBezelOverlayPainter(
			(SubstanceColorScheme scheme) -> scheme.getUltraDarkColor().darker(),
			(SubstanceColorScheme scheme) -> SubstanceColorUtilities
				.getAlphaColor(scheme.getForegroundColor(), 32));
		this.addOverlayPainter(footerTopBezelOverlayPainter, DecorationAreaType.FOOTER);

		this.setTabFadeStart(0.18);
		this.setTabFadeEnd(0.18);

		// Set button shaper to use "flat" design
		this.buttonShaper = new ClassicButtonShaper()
		{
			@Override
			public float getCornerRadius(AbstractButton button, float insets)
			{
				return 0;
			}
		};

		this.watermark = null;
		this.fillPainter = new FractionBasedFillPainter("RuneLite",
			new float[]{0.0f, 0.5f, 1.0f},
			new ColorSchemeSingleColorQuery[]{ColorSchemeSingleColorQuery.ULTRALIGHT,
				ColorSchemeSingleColorQuery.LIGHT, ColorSchemeSingleColorQuery.LIGHT});
		this.decorationPainter = new MatteDecorationPainter();
		this.highlightPainter = new ClassicHighlightPainter();
		this.borderPainter = new CompositeBorderPainter("RuneLite", new ClassicBorderPainter(),
			new DelegateBorderPainter("RuneLite Inner", new ClassicBorderPainter(), 0x40FFFFFF,
				0x20FFFFFF, 0x00FFFFFF,
				(SubstanceColorScheme scheme) -> scheme.tint(0.2f)));
	}

	@Override
	public String getDisplayName()
	{
		return NAME;
	}
}