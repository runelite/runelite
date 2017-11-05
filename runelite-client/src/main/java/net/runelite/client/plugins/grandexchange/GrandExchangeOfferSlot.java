package net.runelite.client.plugins.grandexchange;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import net.runelite.api.GrandExchangeOffer;
import net.runelite.api.GrandExchangeOfferState;

/**
 * @author Robbie, created on 30/10/2017 10:51 PM
 */
public class GrandExchangeOfferSlot
{
	GrandExchangeOffer offer;
	private JLabel imageLabel = new JLabel("");
	private ImageIcon offerImage = new ImageIcon();
	private JLabel itemNameLabel = new JLabel("");
	private JLabel offerPriceLabel = new JLabel("");
	private GrandExchangeOfferState statusIndicator = GrandExchangeOfferState.EMPTY;
	private JLabel statusIndicatorLabel = new JLabel("");
	private JProgressBar progressBar = new JProgressBar();

	public GrandExchangeOfferSlot()
	{
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

	public GrandExchangeOfferState getStatusIndicator()
	{
		return statusIndicator;
	}

	public void setStatusIndicator(GrandExchangeOfferState statusIndicator)
	{
		this.statusIndicator = statusIndicator;
	}

	public JLabel getStatusIndicatorLabel()
	{
		return statusIndicatorLabel;
	}

	public String getStatusIndicatorAsString()
	{
		return this.statusIndicator.toString();
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


