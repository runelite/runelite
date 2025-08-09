package net.runelite.client.plugins.fancyflip.ledger;

import java.time.Duration;
import java.time.Instant;

/**
 * Tracks realized performance stats for the current session.
 * This class intentionally does NOT sample or average "wealth" anymore.
 */
public class LedgerService
{
    private final double taxRatePct;
    private Instant sessionStart = Instant.now();

    private long totalProfitGp = 0;
    private long totalTaxGp = 0;
    private long wealthSampleSum = 0;
    private int wealthSampleCount = 0;
    private long capitalDeployedGp = 0;
    private int  flipsClosed = 0;

    public LedgerService(double taxRatePct)
    {
        this.taxRatePct = taxRatePct;
    }

    /** Reset all session counters and start time. */
    public void reset()
    {
        sessionStart = Instant.now();
        totalProfitGp = 0L;
        totalTaxGp = 0L;
        capitalDeployedGp = 0L;
        flipsClosed = 0;
    }

    /**
     * Record a realized flip.
     * @param profitGp Net profit in gp (after tax).
     * @param taxGp    Tax paid in gp for the trade.
     * @param capitalUsedGp Capital deployed for the flip (e.g., buy cost).
     */
    public void recordFlip(long profitGp, long taxGp, long capitalUsedGp)
    {
        totalProfitGp += profitGp;
        totalTaxGp += Math.max(0L, taxGp);
        capitalDeployedGp += Math.max(0L, capitalUsedGp);
        flipsClosed++;
    }

    public double getTaxRatePct() { return taxRatePct; }
    public long getProfitGp()     { return totalProfitGp; }
    public long getTaxGp()        { return totalTaxGp; }
    public int  getFlipsClosed()  { return flipsClosed; }

    /** ROI% based on realized profit and capital deployed during this session. */
    public double getSessionRoiPct()
    {
        if (capitalDeployedGp <= 0L) return 0.0;
        return (totalProfitGp * 100.0) / capitalDeployedGp;
    }

    /** Profit per hour using session elapsed time. */
    public void sampleWealth(long assetTotalGp)
    {
        wealthSampleSum += Math.max(0L, assetTotalGp);
        wealthSampleCount++;
    }

    public long getAvgWealthGp()
    {
        if (wealthSampleCount == 0) return 0L;
        return wealthSampleSum / wealthSampleCount;
    }

    public long getHourlyProfitGp()
    {
        long seconds = Math.max(1L, Duration.between(sessionStart, Instant.now()).getSeconds());
        double perHour = (double) totalProfitGp * 3600.0 / (double) seconds;
        return Math.round(perHour);
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
