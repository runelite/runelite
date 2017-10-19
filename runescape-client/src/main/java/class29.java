import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public final class class29 {
   @ObfuscatedName("jn")
   @ObfuscatedGetter(
      intValue = 1570994549
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   @Export("logoSprite")
   static IndexedSprite logoSprite;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   static IndexedSprite field430;
   // $FF: synthetic field
   @ObfuscatedSignature(
      signature = "Lac;"
   )
   final class41 this$0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1749118415
   )
   int field428;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 784638285
   )
   int field437;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1263190717
   )
   int field435;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 577821165
   )
   int field436;

   @ObfuscatedSignature(
      signature = "(Lac;)V"
   )
   class29(class41 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Lfl;II)Lfl;",
      garbageValue = "-2140920394"
   )
   @Export("forOrdinal")
   public static RSEnum forOrdinal(RSEnum[] var0, int var1) {
      RSEnum[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         RSEnum var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(Lbk;ZB)V",
      garbageValue = "96"
   )
   static void method249(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field913 << 14;
         var0.field905 = false;
         if((Client.lowMemory && class94.playerIndexesCount > 50 || class94.playerIndexesCount > 200) && var1 && var0.idlePoseAnimation == var0.poseAnimation) {
            var0.field905 = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.field895 && Client.gameCycle < var0.field903) {
               var0.field905 = false;
               var0.field894 = class41.getTileHeight(var0.x, var0.y, class46.plane);
               class3.region.method2729(class46.plane, var0.x, var0.y, var0.field894, 60, var0, var0.angle, var2, var0.field901, var0.field902, var0.field892, var0.field904);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field1017[var3][var4] == Client.field1018) {
                     return;
                  }

                  Client.field1017[var3][var4] = Client.field1018;
               }

               var0.field894 = class41.getTileHeight(var0.x, var0.y, class46.plane);
               class3.region.method2718(class46.plane, var0.x, var0.y, var0.field894, 60, var0, var0.angle, var2, var0.field1212);
            }
         }
      }

   }
}
