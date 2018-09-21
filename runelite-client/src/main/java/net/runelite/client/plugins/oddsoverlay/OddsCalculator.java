package net.runelite.client.plugins.oddsoverlay;

import java.util.concurrent.ThreadLocalRandom;

public class OddsCalculator {

    private static int getMaxMeleeHit(OddsPlayer p) {
        final int a = p.getStr() + 3 + 8;
        final int b = 86;
        return (int) Math.floor((0.5 + a * (b + 64) / 640));
    }

    private static int getMaxRangeHit(OddsPlayer p) {
        final float a = p.getRange() + 0 + 8;
        final float b = 24;
        return (int) Math.floor((0.5 + a * (b + 64) / 640));
    }

    private static double getAttackAccuracy(OddsPlayer p, boolean accurate) {
        final int a = p.getAtt() + ((accurate) ? 3 : 1) + 8;
        final int b = 90;
        return (int) Math.floor(a * (b + 64));
    }

    private static int getRangeAccuracy(OddsPlayer p) {
        final int a = p.getRange() + 0 + 8;
        final int b = 25;
        return (int) Math.floor(a * (b + 64));
    }

    private static int getDefence(OddsPlayer p, boolean defensive) {
        final int a = p.getDef() + ((defensive) ? 3 : 0) + 8;
        return (int) Math.floor(a * (64));
    }

    private static double getMeleeHitChance(OddsPlayer p1, OddsPlayer p2, boolean accurate) {
        double accuracy = getAttackAccuracy(p1, accurate);
        double defence = getDefence(p2, false);

        if (accuracy >= defence) {
            return 1 - ((getDefence(p2, false) + 2) / (2 * (accuracy + 1)));
        }

        return accuracy / (2 * (defence + 1));
    }

    private static double getRangeHitChance(OddsPlayer p1, OddsPlayer p2) {
        double accuracy = getRangeAccuracy(p1);
        double defence = getDefence(p2, false);

        if (accuracy >= defence) {
            return 1 - ((getDefence(p2, false) + 2) / (2 * (accuracy + 1)));
        }

        return accuracy / (2 * (defence + 1));
    }

    public static double calculateMeleeOdds(OddsPlayer me, OddsPlayer opp) {
        double maxHitMe = getMaxMeleeHit(me);
        double maxHitOpp = getMaxMeleeHit(opp);

        boolean accurateMe = (maxHitMe < maxHitOpp) ? true : false;
        boolean accurateOpp = (maxHitOpp < maxHitMe) ? true : false;

        double hitChanceMe = getMeleeHitChance(me, opp, accurateMe);
        double hitChanceOpp = getMeleeHitChance(opp, me, accurateOpp);

        // double oddsMe = (accuracyMe * maxHitMe) /(double) opp.getHp();
        // double oddsOpp = (accuracyOpp * maxHitOpp) / (double) me.getHp();

        int myWins = 0;
        int trials = 10000;

        int hpMe = me.getHp();
        int hpOpp = opp.getHp();

        for (int i = 0; i < trials; i++) {

            if (ThreadLocalRandom.current().nextBoolean()) {
                while (hpMe > 0 || hpOpp > 0) {
                    if (ThreadLocalRandom.current().nextDouble(0, 1.0) <= hitChanceOpp) {
                        hpMe -= ThreadLocalRandom.current().nextInt(1, (int) maxHitOpp + 1);
                        if (hpMe <= 0) {
                            break;
                        }
                    }
                    if (ThreadLocalRandom.current().nextDouble(0, 1.0) <= hitChanceMe) {
                        hpOpp -= ThreadLocalRandom.current().nextInt(1, (int) maxHitMe + 1);
                        if (hpOpp <= 0) {
                            myWins++;
                            break;
                        }
                    }
                }
            } else {
                while (hpMe > 0 || hpOpp > 0) {
                    if (ThreadLocalRandom.current().nextDouble(0, 1.0) <= hitChanceMe) {
                        hpOpp -= ThreadLocalRandom.current().nextInt(1, (int) maxHitMe + 1);
                        if (hpOpp <= 0) {
                            myWins++;
                            break;
                        }
                    }
                    if (ThreadLocalRandom.current().nextDouble(0, 1.0) <= hitChanceOpp) {
                        hpMe -= ThreadLocalRandom.current().nextInt(1, (int) maxHitOpp + 1);
                        if (hpMe <= 0) {
                            break;
                        }
                    }
                }
            }


            hpMe = me.getHp();
            hpOpp = opp.getHp();
        }


        return 100 * (double) myWins / (double) trials;
    }

    public static double calculateRangedOdds(OddsPlayer me, OddsPlayer opp) {
        double maxHitMe = getMaxRangeHit(me);
        double maxHitOpp = getMaxRangeHit(opp);

        boolean accurateMe = (maxHitMe < maxHitOpp) ? true : false;
        boolean accurateOpp = (maxHitOpp < maxHitMe) ? true : false;

        double hitChanceMe = getRangeHitChance(me, opp);
        double hitChanceOpp = getRangeHitChance(opp, me);

        // double oddsMe = (accuracyMe * maxHitMe) /(double) opp.getHp();
        // double oddsOpp = (accuracyOpp * maxHitOpp) / (double) me.getHp();

        int myWins = 0;
        int trials = 10000;

        int hpMe = me.getHp();
        int hpOpp = opp.getHp();

        for (int i = 0; i < trials; i++) {

            if (ThreadLocalRandom.current().nextBoolean()) {
                while (hpMe > 0 || hpOpp > 0) {
                    if (ThreadLocalRandom.current().nextDouble(0, 1.0) <= hitChanceOpp) {
                        hpMe -= ThreadLocalRandom.current().nextInt(1, (int) maxHitOpp + 1);
                        if (hpMe <= 0) {
                            break;
                        }
                    }
                    if (ThreadLocalRandom.current().nextDouble(0, 1.0) <= hitChanceMe) {
                        hpOpp -= ThreadLocalRandom.current().nextInt(1, (int) maxHitMe + 1);
                        if (hpOpp <= 0) {
                            myWins++;
                            break;
                        }
                    }
                }
            } else {
                while (hpMe > 0 || hpOpp > 0) {
                    if (ThreadLocalRandom.current().nextDouble(0, 1.0) <= hitChanceMe) {
                        hpOpp -= ThreadLocalRandom.current().nextInt(1, (int) maxHitMe + 1);
                        if (hpOpp <= 0) {
                            myWins++;
                            break;
                        }
                    }
                    if (ThreadLocalRandom.current().nextDouble(0, 1.0) <= hitChanceOpp) {
                        hpMe -= ThreadLocalRandom.current().nextInt(1, (int) maxHitOpp + 1);
                        if (hpMe <= 0) {
                            break;
                        }
                    }
                }
            }


            hpMe = me.getHp();
            hpOpp = opp.getHp();
        }


        return 100 * (double) myWins / (double) trials;
    }


}
