import net.runelite.mapping.*;

import java.util.Comparator;

@ObfuscatedName("l")
@Implements("GEItemNameComparator")
final class GEItemNameComparator implements Comparator {
   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   @Export("headIconsPk")
   static SpritePixels[] headIconsPk;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -755091831
   )
   static int field304;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ly;Ly;I)I",
      garbageValue = "1698235005"
   )
   int method131(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.method72().compareTo(var2.method72());
   }

   public int compare(Object var1, Object var2) {
      return this.method131((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
