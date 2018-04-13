package net.runelite.client.plugins.bankvalue;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BankTitleTest {

	@InjectMocks
	private BankTitle bankTitle;

	@Test
	public void addGePriceToCurrentTab()
	{

		Assert.assertEquals(" (EX: 20)",bankTitle.addGePriceToCurrentTab(20l,true));
		Assert.assertEquals(" (20)",bankTitle.addGePriceToCurrentTab(20l,false));
		Assert.assertEquals(" (10M)",bankTitle.addGePriceToCurrentTab(10000000l,false));
		Assert.assertEquals(" (10B)",bankTitle.addGePriceToCurrentTab(10000000000l,false));
	}
}