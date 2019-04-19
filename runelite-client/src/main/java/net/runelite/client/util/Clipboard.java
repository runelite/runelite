package net.runelite.client.util;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class Clipboard {
	public static String retrieve()
	{
		Transferable contents = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

		if (contents == null || ! contents.isDataFlavorSupported(DataFlavor.stringFlavor))
		{
			return null;
		}

		try
		{
			return (String) contents.getTransferData(DataFlavor.stringFlavor);
		}
		catch (UnsupportedFlavorException | IOException ex)
		{
			return null;
		}
	}

	public static void store(String contents)
	{
		final StringSelection selection = new StringSelection(contents);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
	}
}