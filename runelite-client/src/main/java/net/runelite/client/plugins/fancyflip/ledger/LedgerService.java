/*
 * Copyright (c) 2025, Codex <codex@openai.com>
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
    private int flipsClosed = 0;

    // rolling wealth samples for simple average
    private final Deque<Long> wealthSamples = new ArrayDeque<>();
    private long wealthSampleSum = 0;

    public LedgerService(double taxRatePct) { this.taxRatePct = taxRatePct; }

    public void reset()
    {
        sessionStart = Instant.now();
        totalProfitGp = totalTaxGp = capitalDeployedGp = 0;
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
        totalProfitGp += net; // profit is net receipts (we assume buy cost already accounted via deployed)
        flipsClosed++;
    }

    public void sampleWealth(long totalWealthGp)
    {
        wealthSamples.addLast(totalWealthGp);
        wealthSampleSum += totalWealthGp;
        if (wealthSamples.size() > 300) { // ~5h at 60s cadence
            wealthSampleSum -= wealthSamples.removeFirst();
        }
    }

    public long getProfitGp() { return totalProfitGp; }
    public long getTaxGp() { return totalTaxGp; }
    public int  getFlipsClosed() { return flipsClosed; }

    public double getSessionRoiPct()
    {
        if (capitalDeployedGp <= 0) return 0;
        return (totalProfitGp / (double) capitalDeployedGp) * 100.0;
    }

    public long getHourlyProfitGp()
    {
        Duration d = Duration.between(sessionStart, Instant.now());
        double hours = Math.max(d.toMillis() / 3600000.0, 0.001);
        return (long) Math.floor(totalProfitGp / hours);
    }

    public long getAvgWealthGp()
    {
        if (wealthSamples.isEmpty()) return 0;
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
