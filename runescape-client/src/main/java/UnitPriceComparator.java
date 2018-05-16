import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
@Implements("UnitPriceComparator")
final class UnitPriceComparator implements Comparator {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 208381007
   )
   static int field35;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lq;Lq;B)I",
      garbageValue = "79"
   )
   int method67(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.price < var2.grandExchangeOffer.price?-1:(var2.grandExchangeOffer.price == var1.grandExchangeOffer.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method67((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("x")
   public static int method59(long var0) {
      return (int)(var0 >>> 7 & 127L);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "-34"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = JagexGame.getSmoothNoise2D(var3, var5);
      int var8 = JagexGame.getSmoothNoise2D(var3 + 1, var5);
      int var9 = JagexGame.getSmoothNoise2D(var3, var5 + 1);
      int var10 = JagexGame.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var11 = class158.method3316(var7, var8, var4, var2);
      int var12 = class158.method3316(var9, var10, var4, var2);
      return class158.method3316(var11, var12, var6, var2);
   }
}
