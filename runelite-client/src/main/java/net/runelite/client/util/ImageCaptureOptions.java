/*
 * Copyright (c) 2020, Jordan <nightfirecat@protonmail.com>
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
package net.runelite.client.util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;

/**
 * Options class for providing settings to {@link ImageCapture#takeScreenshot(ImageCaptureOptions)}. Allows for
 * configuring whether to capture an image from the game and client frame, what the resulting screenshot file should be
 * named, whether to store the captured screenshot in a subdirectory, etc.
 */
@Builder
@Getter
public class ImageCaptureOptions
{
	/**
	 * A screenshot to be written to a png in RuneLite's screenshot directory. When {@code null} is passed, a screenshot
	 * will instead be constructed from the game and client frame.
	 */
	@Nullable
	private BufferedImage screenshot;

	/**
	 * The name to give to the resulting png file. The current date will be appended to the given filename.
	 */
	@Nullable
	@Builder.Default
	private String fileName = "";

	/**
	 * Subdirectory or subdirectories to store the captured screenshot into, under the default screenshot directory.
	 */
	@Nullable
	private String subDir;

	/**
	 * Whether a notification should be fired upon screenshot capture.
	 *
	 * @see net.runelite.client.Notifier
	 */
	private boolean notify;

	/**
	 * If and how the captured image should be uploaded or copied to clipboard.
	 */
	@Nullable
	@Builder.Default
	private ImageUploadStyle imageUploadStyle = ImageUploadStyle.NEITHER;

	/**
	 * Whether to capture the client UI along with the game when taking a screenshot of the game.
	 * <p>
	 * Note: This option has no effect when {@link ImageCaptureOptions#getScreenshot()} is not {@code null}, as the
	 * passed screenshot will be used in favor of capturing an image of the game.
	 */
	@Builder.Default
	private boolean includeFrame = true;

	/**
	 * Overlays to be drawn to the captured screenshot prior to writing the output png file. The structure of the
	 * provided overlay consumers should mirror that of {@link net.runelite.client.ui.overlay.Overlay} render functions,
	 * except they are not expected to return the dimension of the rendered overlay.
	 * <p>
	 * For example, an overlay method can be defined and passed to an {@link ImageCaptureOptions} object as shown below.
	 *
	 * <pre>
	 * {@code
	 * private void playerHullOverlay(final Graphics2D graphics)
	 * {
	 *     if (client.getLocalPlayer() == null)
	 *     {
	 *         return;
	 *     }
	 *
	 *     final Shape playerHull = client.getLocalPlayer().getConvexHull();
	 *
	 *     if (playerHull == null)
	 *     {
	 *         return;
	 *     }
	 *
	 *     final Color color = Color.RED;
	 *     graphics.setColor(color);
	 *     graphics.setStroke(new BasicStroke(2));
	 *     graphics.draw(playerHull);
	 *     graphics.setColor(new Color(color.getRed(), color.getGreen(), color.getBlue(), 20));
	 *     graphics.fill(playerHull);
	 * }
	 *
	 * ImageCaptureOptions playerHullOptions = ImageCaptureOptions.builder()
	 *     .fileName(fileName)
	 *     .subDir(subDir)
	 *     .overlays(ImmutableList.of(this::playerHullOverlay))
	 *     .build();
	 * }
	 * </pre>
	 *
	 * @see net.runelite.client.ui.overlay.Overlay#render(Graphics2D)
	 */
	@Nonnull
	@Builder.Default
	private List<Consumer<Graphics2D>> overlays = new ArrayList<>();
}
