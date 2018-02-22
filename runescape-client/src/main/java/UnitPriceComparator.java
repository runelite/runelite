import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("UnitPriceComparator")
final class UnitPriceComparator implements Comparator {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("varbit_ref")
   public static IndexDataBase varbit_ref;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1143716735
   )
   static int field294;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 973582091
   )
   public static int field297;
   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "Llm;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static Widget field298;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ls;Ls;I)I",
      garbageValue = "271582275"
   )
   int method123(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.price < var2.grandExchangeOffer.price?-1:(var2.grandExchangeOffer.price == var1.grandExchangeOffer.price?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method123((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "768659427"
   )
   public static boolean method134(int var0) {
      return (var0 >> 20 & 1) != 0;
   }
}
