import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
final class class22 implements Comparator {
   @ObfuscatedName("an")
   static class171 field589;
   @ObfuscatedName("r")
   public static String field590;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "-405945289"
   )
   int method580(class217 var1, class217 var2) {
      if(var2.field3196 == var1.field3196) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field3196) {
               return -1;
            }

            if(var2.field3196 == Client.world) {
               return 1;
            }
         }

         return var1.field3196 < var2.field3196?-1:1;
      }
   }

   class22(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lclass35;I)V",
      garbageValue = "275340996"
   )
   static final void method584(class35 var0) {
      if(class34.localPlayer.x >> 7 == Client.flagX && Client.flagY == class34.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = class34.field763;
      int[] var2 = class34.field758;
      int var3 = var1;
      if(var0 == class35.field779 || var0 == class35.field785) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class35.field779 == var0) {
            var5 = class34.localPlayer;
            var6 = class34.localPlayer.field57 << 14;
         } else if(var0 == class35.field785) {
            var5 = Client.cachedPlayers[Client.field471];
            var6 = Client.field471 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class35.field777 == var0 && Client.field471 == var2[var4]) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod787() && !var5.field52) {
            var5.field49 = false;
            if((Client.field286 && var1 > 50 || var1 > 200) && var0 != class35.field779 && var5.idlePoseAnimation == var5.poseAnimation) {
               var5.field49 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(null != var5.model && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field40) {
                  var5.field49 = false;
                  var5.field38 = Renderable.method1960(var5.x, var5.y, XItemContainer.plane);
                  class9.region.method1976(XItemContainer.plane, var5.x, var5.y, var5.field38, 60, var5, var5.angle, var6, var5.field45, var5.field46, var5.field47, var5.field30);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field385[var7][var8] == Client.field386) {
                        continue;
                     }

                     Client.field385[var7][var8] = Client.field386;
                  }

                  var5.field38 = Renderable.method1960(var5.x, var5.y, XItemContainer.plane);
                  class9.region.method2020(XItemContainer.plane, var5.x, var5.y, var5.field38, 60, var5, var5.angle, var6, var5.field819);
               }
            }
         }
      }

   }

   public int compare(Object var1, Object var2) {
      return this.method580((class217)var1, (class217)var2);
   }
}
