import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class145 extends class283 {
   @ObfuscatedName("w")
   final boolean field1924;

   public class145(boolean var1) {
      this.field1924 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkd;Lkd;I)I",
      garbageValue = "-295095521"
   )
   int method3195(ChatPlayer var1, ChatPlayer var2) {
      return var1.world != 0 && var2.world != 0?(this.field1924?var1.getRsName().compareCleanName(var2.getRsName()):var2.getRsName().compareCleanName(var1.getRsName())):this.method5320(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3195((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method3200() {
      if(Client.field711) {
         class32.method586(MilliTimer.localPlayer, false);
      }

   }

   @ObfuscatedName("km")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "-37627365"
   )
   public static void method3194(int var0, int var1, int var2, boolean var3) {
      PacketNode var4 = DecorativeObject.method3115(ClientPacket.field2161, Client.field739.field1250);
      var4.packetBuffer.method3595(var2);
      var4.packetBuffer.method3605(var0);
      var4.packetBuffer.method3605(var1);
      var4.packetBuffer.method3670(var3?Client.field674:0);
      Client.field739.method2019(var4);
   }
}
