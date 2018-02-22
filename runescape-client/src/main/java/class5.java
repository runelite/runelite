import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
final class class5 implements class0 {
   @ObfuscatedName("b")
   static boolean field30;
   @ObfuscatedName("cc")
   public static char field29;

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1077956065"
   )
   static void method12(int var0, int var1) {
      if(Client.field971 != 0 && var0 != -1) {
         class152.method3129(GrandExchangeOffer.indexTrack2, var0, 0, Client.field971, false);
         Client.field1039 = true;
      }

   }

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-569514110"
   )
   static final void method13(boolean var0) {
      for(int var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.npcIndices[var1]];
         int var3 = (Client.npcIndices[var1] << 14) + 536870912;
         if(var2 != null && var2.hasConfig() && var2.composition.isVisible == var0 && var2.composition.method5075()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field1098 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field1057[var4][var5] == Client.field868) {
                     continue;
                  }

                  Client.field1057[var4][var5] = Client.field868;
               }

               if(!var2.composition.field3660) {
                  var3 -= Integer.MIN_VALUE;
               }

               GameObject.region.method2930(class230.plane, var2.x, var2.y, WorldMapType1.getTileHeight(var2.field1098 * 64 - 64 + var2.x, var2.field1098 * 64 - 64 + var2.y, class230.plane), var2.field1098 * 64 - 64 + 60, var2, var2.angle, var3, var2.field1097);
            }
         }
      }

   }
}
