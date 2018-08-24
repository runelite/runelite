package net.runelite.client.plugins.farmingprofit;

import lombok.Getter;
import net.runelite.api.coords.WorldPoint;

public class FarmingProfitRun {

    @Getter
    private int productId;
    @Getter
    private int seedId;
    @Getter
    private int amount;

    @Getter
    private WorldPoint latestHarvestWorldPoint;

    FarmingProfitRun(int productId, int seedId, int amount, WorldPoint latestHarvest)
    {
        this.productId = productId;
        this.seedId = seedId;
        updateAmount(amount, latestHarvest);
    }

    public void updateAmount(int amount, WorldPoint harvestWorldPoint)
    {
        this.amount = amount;
        latestHarvestWorldPoint = harvestWorldPoint;
    }

    public void addAmount(int toAdd, WorldPoint harvestWorldPoint)
    {
        updateAmount(amount + toAdd, harvestWorldPoint);
    }

}
