import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public enum class15 implements Enumerated {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ly;"
   )
   field128(3, (byte)0),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ly;"
   )
   field123(2, (byte)1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ly;"
   )
   field124(1, (byte)2),
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ly;"
   )
   field125(0, (byte)3);

   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1306249167
   )
   @Export("worldMapType")
   final int worldMapType;
   @ObfuscatedName("n")
   final byte field127;

   class15(int worldMapType, byte var4) {
      this.worldMapType = worldMapType;
      this.field127 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "60"
   )
   public int rsOrdinal() {
      return this.field127;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)[Ly;",
      garbageValue = "-1135514295"
   )
   @Export("getWorldMapTypes")
   static class15[] getWorldMapTypes() {
      return new class15[]{field125, field128, field123, field124};
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1438118573"
   )
   static int method157(int var0) {
      MessageNode var1 = (MessageNode)class83.messages.get((long)var0);
      return var1 == null?-1:(var1.previous == class83.field1205.sentinel?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      signature = "(Lhl;B)Z",
      garbageValue = "-75"
   )
   static final boolean method163(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field688 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field853.method4486(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field853.method4487(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field853.method4488(false);
         }

         if(var1 == 325) {
            Client.field853.method4488(true);
         }

         if(var1 == 326) {
            PacketNode var4 = DecorativeObject.method3115(ClientPacket.field2247, Client.field739.field1250);
            Client.field853.method4501(var4.packetBuffer);
            Client.field739.method2019(var4);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1833717485"
   )
   static final void method161() {
      for(int var0 = 0; var0 < class81.playerIndexesCount; ++var0) {
         Player var1 = Client.cachedPlayers[class81.playerIndices[var0]];
         var1.method1166();
      }

   }
}
