import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class90 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 135317335
   )
   int field1392;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -101466435
   )
   int field1390;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 107557497
   )
   int field1394;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 23640301
   )
   int field1393;
   @ObfuscatedName("w")
   String field1397;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "43"
   )
   public static void method1736() {
      if(class239.field3237 != null) {
         class239.field3237.close();
      }

   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(Lbm;I)V",
      garbageValue = "534034941"
   )
   static final void method1735(class66 var0) {
      if(class54.localPlayer.x >> 7 == Client.destinationX && class54.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      int var1 = class97.field1493;
      int[] var2 = class97.field1494;
      int var3 = var1;
      if(class66.field811 == var0 || class66.field806 == var0) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class66.field811 == var0) {
            var5 = class54.localPlayer;
            var6 = class54.localPlayer.field901 << 14;
         } else if(class66.field806 == var0) {
            var5 = Client.cachedPlayers[Client.field1031];
            var6 = Client.field1031 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class66.field810 == var0 && var2[var4] == Client.field1031) {
               continue;
            }
         }

         if(var5 != null && var5.hasConfig() && !var5.hidden) {
            var5.field898 = false;
            if((Client.lowMemory && var1 > 50 || var1 > 200) && class66.field811 != var0 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field898 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.field883 && Client.gameCycle < var5.field881) {
                  var5.field898 = false;
                  var5.field886 = Friend.getTileHeight(var5.x, var5.y, class29.plane);
                  class84.region.method2837(class29.plane, var5.x, var5.y, var5.field886, 60, var5, var5.angle, var6, var5.field903, var5.field894, var5.field879, var5.field887);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field1005[var7][var8] == Client.field1006) {
                        continue;
                     }

                     Client.field1005[var7][var8] = Client.field1006;
                  }

                  var5.field886 = Friend.getTileHeight(var5.x, var5.y, class29.plane);
                  class84.region.method2722(class29.plane, var5.x, var5.y, var5.field886, 60, var5, var5.angle, var6, var5.field1208);
               }
            }
         }
      }

   }
}
