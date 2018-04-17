import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
final class class19 implements Comparator {
   @ObfuscatedName("rv")
   @ObfuscatedSignature(
      signature = "Lff;"
   )
   @Export("indexStore255")
   static IndexFile indexStore255;
   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "[Lld;"
   )
   @Export("mapMarkers")
   static SpritePixels[] mapMarkers;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "1982402309"
   )
   int method155(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      return var1.field292 < var2.field292?-1:(var1.field292 == var2.field292?0:1);
   }

   public int compare(Object var1, Object var2) {
      return this.method155((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)I",
      garbageValue = "24"
   )
   public static int method167(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(IIIZB)V",
      garbageValue = "-77"
   )
   public static void method166(int var0, int var1, int var2, boolean var3) {
      PacketNode var4 = WorldMapRectangle.method280(ClientPacket.field2457, Client.field957.field1484);
      var4.packetBuffer.method3559(var3?Client.field970:0);
      var4.packetBuffer.method3528(var0);
      var4.packetBuffer.method3543(var2);
      var4.packetBuffer.putShort(var1);
      Client.field957.method2052(var4);
   }
}
