package net.runelite.client.plugins.grandexchange;

import com.sun.xml.internal.ws.util.StringUtils;
import java.awt.*;
import java.util.Arrays;
import javax.swing.*;

/**
 * @author Robbie, created on 30/10/2017 10:51 PM
 */
public class GrandExchangeOfferSlot
{

	private JLabel imageLabel;
	private ImageIcon offerImage;
	private JLabel itemNameLabel;
	private JLabel offerPriceLabel;
	private OfferState statusIndicator;
	private JLabel statusIndicatorLabel;
	private JProgressBar progressBar;

	public GrandExchangeOfferSlot()
	{
		this.imageLabel = new JLabel("");
		this.statusIndicatorLabel = new JLabel("");
		this.offerImage = new ImageIcon();
		this.itemNameLabel = new JLabel("");
		this.offerPriceLabel = new JLabel("");
		this.progressBar = new JProgressBar();
		this.progressBar.setStringPainted(true);
		this.progressBar.setForeground(Color.WHITE);
		this.statusIndicator = OfferState.EMPTY;

		imageLabel.setIcon(offerImage);
	}

	public JLabel getImageLabel()
	{
		imageLabel.setIcon(getOfferImage());
		return imageLabel;
	}

	public ImageIcon getOfferImage()
	{
		return offerImage;
	}

	public void setOfferImage(ImageIcon offerImage)
	{
		this.offerImage = offerImage;
		this.imageLabel.setIcon(offerImage);
	}

	public JLabel getItemNameLabel()
	{
		return itemNameLabel;
	}

	public void setItemNameLabel(String newItemName)
	{
		this.itemNameLabel.setText(newItemName);
	}

	public JLabel getOfferPriceLabel()
	{
		return offerPriceLabel;
	}

	public void setOfferPriceLabel(String newOfferPriceLabel)
	{
		this.offerPriceLabel.setText(newOfferPriceLabel);
	}

	public OfferState getStatusIndicator()
	{
		return statusIndicator;
	}

	public void setStatusIndicator(OfferState statusIndicator)
	{
		this.statusIndicator = statusIndicator;
	}

	public JLabel getStatusIndicatorLabel()
	{
		return statusIndicatorLabel;
	}

	public String getStatusIndicatorAsString()
	{
		return StringUtils.capitalize(this.statusIndicator.toString().toLowerCase());
	}

	public void setStatusIndicatorLabel(JLabel statusIndicatorLabel)
	{
		this.statusIndicatorLabel = statusIndicatorLabel;
	}

	public JProgressBar getProgressBar()
	{
		return progressBar;
	}

	public void setProgressBar(int newValue)
	{
		this.progressBar.setValue(newValue);
		this.progressBar.setBackground(getProgressBarColour());
	}

	public Color getProgressBarColour()
	{
		switch ((int) this.progressBar.getPercentComplete() * 100)
		{
			case 0:
				return Color.GRAY;

			case 100:
				return Color.GREEN;

			default:
				return Color.ORANGE;
		}
	}
}

/**
 * Describes the state of a
 * Grand Exchange offer
 */
enum OfferState
{
	/**
	 * An empty slot.
	 */
	EMPTY(-1),

	/**
	 * A buy offer that
	 * is currently in progress.
	 */
	BUYING(2),

	/**
	 * A buy offer that
	 * has completed.
	 */
	BOUGHT(5),

	/**
	 * A sell offer that
	 * is currently in progress.
	 */
	SELLING(10),

	/**
	 * A sell offer that
	 * has completed.
	 */
	SOLD(13);

	private int code;

	OfferState(int code)
	{
		this.code = code;
	}

	/**
	 * The offer code given
	 * by #getProgress();
	 */
	public int getCode()
	{
		return code;
	}

	/**
	 * Returns the OfferState instance
	 * associated with the given code.
	 *
	 * @param code The code to search for
	 * @return The respective OfferState instance
	 */
	public static OfferState codeToInstance(byte code)
	{
		return Arrays.stream(OfferState.values())
				.filter(offerState -> offerState.getCode() == code)
				.findFirst()
				.orElse(OfferState.EMPTY);
	}
}
