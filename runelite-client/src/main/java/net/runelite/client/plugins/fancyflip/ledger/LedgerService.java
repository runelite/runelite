package net.runelite.client.plugins.fancyflip.ledger;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;

public class LedgerService
{
    private final double taxRatePct;
    private Instant sessionStart = Instant.now();
    private long totalProfitGp = 0;
    private long totalTaxGp = 0;
    private long capitalDeployedGp = 0;
    private int  flipsClosed = 0;

    // rolling wealth samples for simple average
    private final Deque<Long> wealthSamples = new ArrayDeque<>();
    private long wealthSampleSum = 0;

    public LedgerService(double taxRatePct) { this.taxRatePct = taxRatePct; }

    public void reset()
    {
        sessionStart = Instant.now();
        totalProfitGp = 0;
        totalTaxGp = 0;
        capitalDeployedGp = 0;
        flipsClosed = 0;
        wealthSamples.clear();
        wealthSampleSum = 0;
    }

    public void logBuy(long qty, long buyPriceEach)
    {
        capitalDeployedGp += qty * buyPriceEach;
    }

    public void logSale(long qty, long sellPriceEach)
    {
        long gross = qty * sellPriceEach;
        long tax = Math.round(gross * (taxRatePct / 100.0));
        long net = gross - tax;

        totalTaxGp += tax;
        totalProfitGp += net; // profit assumes buy cost tracked via deployed
        flipsClosed++;
    }

    public void sampleWealth(long totalWealthGp)
    {
        wealthSamples.addLast(totalWealthGp);
        wealthSampleSum += totalWealthGp;
        // cap to ~5h at 60s cadence (300 samples)
        if (wealthSamples.size() > 300)
        {
            wealthSampleSum -= wealthSamples.removeFirst();
        }
    }

    public long getProfitGp() { return totalProfitGp; }
    public long getTaxGp()    { return totalTaxGp; }
    public int  getFlipsClosed() { return flipsClosed; }

    public double getSessionRoiPct()
    {
        if (capitalDeployedGp <= 0) return 0.0;
        return (totalProfitGp / (double) capitalDeployedGp) * 100.0;
    }

    public long getHourlyProfitGp()
    {
        Duration d = Duration.between(sessionStart, Instant.now());
        double hours = Math.max(d.toMillis() / 3_600_000.0, 0.001);
        return (long) Math.floor(totalProfitGp / hours);
    }

    public long getAvgWealthGp()
    {
        if (wealthSamples.isEmpty()) return 0L;
        return wealthSampleSum / wealthSamples.size();
    }

    public String getSessionTimeHms()
    {
        Duration d = Duration.between(sessionStart, Instant.now());
        long h = d.toHours();
        long m = d.minusHours(h).toMinutes();
        long s = d.minusHours(h).minusMinutes(m).getSeconds();
        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
