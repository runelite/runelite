import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
@Implements("TotalQuantityComparator")
final class TotalQuantityComparator implements Comparator {
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "Lic;"
   )
   @Export("indexCache13")
   static IndexData indexCache13;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lq;Lq;I)I",
      garbageValue = "1722719770"
   )
   int method26(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity?-1:(var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method26((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
