import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
@Implements("TotalQuantityComparator")
final class TotalQuantityComparator implements Comparator {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -635563425
   )
   static int field282;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;B)I",
      garbageValue = "-31"
   )
   int method93(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity?-1:(var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method93((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1248824827"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class64.addChatMessage(var0, var1, var2, (String)null);
   }
}
