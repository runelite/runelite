import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class155 {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -7786645026770268451L
   )
   static long field2112;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = 2881022044787375465L
   )
   static long field2113;
   @ObfuscatedName("nw")
   @ObfuscatedGetter(
      intValue = 1035827413
   )
   static int field2116;

   class155() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lclass15;I)V",
      garbageValue = "442958309"
   )
   static final void method3041(class15 var0) {
      if(class36.localPlayer.x >> 7 == Client.flagX && class36.localPlayer.y >> 7 == Client.flagY) {
         Client.flagX = 0;
      }

      int var1 = class45.field921;
      int[] var2 = class45.field931;
      int var3 = var1;
      if(var0 == class15.field177 || var0 == class15.field169) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class15.field177 == var0) {
            var5 = class36.localPlayer;
            var6 = class36.localPlayer.field255 << 14;
         } else if(var0 == class15.field169) {
            var5 = Client.cachedPlayers[Client.field434];
            var6 = Client.field434 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class15.field171 == var0 && var2[var4] == Client.field434) {
               continue;
            }
         }

         if(null != var5 && var5.vmethod803() && !var5.field276) {
            var5.field274 = false;
            if((Client.field308 && var1 > 50 || var1 > 200) && class15.field177 != var0 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field274 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.model && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field265) {
                  var5.field274 = false;
                  var5.field263 = class2.method19(var5.x, var5.y, WallObject.plane);
                  Script.region.method1759(WallObject.plane, var5.x, var5.y, var5.field263, 60, var5, var5.angle, var6, var5.field270, var5.field282, var5.field271, var5.field273);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field408[var7][var8] == Client.field409) {
                        continue;
                     }

                     Client.field408[var7][var8] = Client.field409;
                  }

                  var5.field263 = class2.method19(var5.x, var5.y, WallObject.plane);
                  Script.region.method1758(WallObject.plane, var5.x, var5.y, var5.field263, 60, var5, var5.angle, var6, var5.field627);
               }
            }
         }
      }

   }
}
