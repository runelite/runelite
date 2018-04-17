import java.awt.Image;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("TotalQuantityComparator")
final class TotalQuantityComparator implements Comparator {
   @ObfuscatedName("pr")
   @ObfuscatedGetter(
      intValue = -1852153575
   )
   static int field302;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("overlay_ref")
   public static IndexDataBase overlay_ref;
   @ObfuscatedName("aq")
   static Image field304;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "363785000"
   )
   int method94(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.grandExchangeOffer.totalQuantity < var2.grandExchangeOffer.totalQuantity?-1:(var2.grandExchangeOffer.totalQuantity == var1.grandExchangeOffer.totalQuantity?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method94((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-32202545"
   )
   static void method98(int var0, int var1) {
      PacketNode var2 = WorldMapRectangle.method280(ClientPacket.field2405, Client.field957.field1484);
      var2.packetBuffer.putShort(var1);
      var2.packetBuffer.method3559(var0);
      Client.field957.method2052(var2);
   }
}
