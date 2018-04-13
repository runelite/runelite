package net.runelite.client.plugins.grounditems;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class GroundItemsOverlayTest {

	@InjectMocks
	private GroundItemsOverlay groundItemsOverlay;

	@Test
	public void createGePrice()
	{
		Assert.assertEquals(" ( EX: 20 gp)",groundItemsOverlay.createGePrice(20l,true));
		Assert.assertEquals(" ( 20 gp)",groundItemsOverlay.createGePrice(20l,false));
	}
}