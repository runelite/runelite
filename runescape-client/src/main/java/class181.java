import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class181 {
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lclass35;I)V",
      garbageValue = "1218254348"
   )
   static final void method3507(class35 var0) {
      if(class138.localPlayer.x >> 7 == Client.flagX && class138.localPlayer.y >> 7 == Client.flagY) {
         Client.flagX = 0;
      }

      int var1 = class34.field779;
      int[] var2 = class34.field786;
      int var3 = var1;
      if(class35.field799 == var0 || var0 == class35.field796) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(var0 == class35.field799) {
            var5 = class138.localPlayer;
            var6 = class138.localPlayer.field54 << 14;
         } else if(class35.field796 == var0) {
            var5 = Client.cachedPlayers[Client.field432];
            var6 = Client.field432 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class35.field793 == var0 && var2[var4] == Client.field432) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod783() && !var5.field45) {
            var5.field50 = false;
            if((Client.field304 && var1 > 50 || var1 > 200) && var0 != class35.field799 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field50 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.model && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field41) {
                  var5.field50 = false;
                  var5.field39 = class16.method191(var5.x, var5.y, class173.plane);
                  class128.region.method2058(class173.plane, var5.x, var5.y, var5.field39, 60, var5, var5.angle, var6, var5.field46, var5.field47, var5.field57, var5.field49);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field407 == Client.field406[var7][var8]) {
                        continue;
                     }

                     Client.field406[var7][var8] = Client.field407;
                  }

                  var5.field39 = class16.method191(var5.x, var5.y, class173.plane);
                  class128.region.method1963(class173.plane, var5.x, var5.y, var5.field39, 60, var5, var5.angle, var6, var5.field838);
               }
            }
         }
      }

   }
}
