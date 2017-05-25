import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
final class class15 implements Comparator {
   @ObfuscatedName("dm")
   static IndexData field294;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -523266581
   )
   static int field296;

   public int compare(Object var1, Object var2) {
      return this.method92((class14)var1, (class14)var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZLjava/lang/String;ZI)V",
      garbageValue = "-677978314"
   )
   static void method84(String var0, boolean var1, String var2, boolean var3) {
      if(var1) {
         if(!var3 && Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var5) {
               ;
            }
         }

         if(class56.field673.startsWith("win") && !var3) {
            class92.method1779(var0, 0, "openjs");
            return;
         }

         if(class56.field673.startsWith("mac")) {
            class92.method1779(var0, 1, var2);
            return;
         }

         class92.method1779(var0, 2, "openjs");
      } else {
         class92.method1779(var0, 3, "openjs");
      }

   }

   @ObfuscatedName("fs")
   @ObfuscatedSignature(
      signature = "(Lclass66;I)V",
      garbageValue = "-1959920098"
   )
   static final void method86(class66 var0) {
      if(XGrandExchangeOffer.localPlayer.x >> 7 == Client.flagX && Client.flagY == XGrandExchangeOffer.localPlayer.y >> 7) {
         Client.flagX = 0;
      }

      int var1 = class96.field1489;
      int[] var2 = class96.field1496;
      int var3 = var1;
      if(class66.field802 == var0 || var0 == class66.field799) {
         var3 = 1;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         Player var5;
         int var6;
         if(class66.field802 == var0) {
            var5 = XGrandExchangeOffer.localPlayer;
            var6 = XGrandExchangeOffer.localPlayer.field875 << 14;
         } else if(class66.field799 == var0) {
            var5 = Client.cachedPlayers[Client.field1106];
            var6 = Client.field1106 << 14;
         } else {
            var5 = Client.cachedPlayers[var2[var4]];
            var6 = var2[var4] << 14;
            if(class66.field801 == var0 && var2[var4] == Client.field1106) {
               continue;
            }
         }

         if(var5 != null && var5.vmethod1721() && !var5.field867) {
            var5.field871 = false;
            if((Client.field895 && var1 > 50 || var1 > 200) && var0 != class66.field802 && var5.poseAnimation == var5.idlePoseAnimation) {
               var5.field871 = true;
            }

            int var7 = var5.x >> 7;
            int var8 = var5.y >> 7;
            if(var7 >= 0 && var7 < 104 && var8 >= 0 && var8 < 104) {
               if(var5.model != null && Client.gameCycle >= var5.totalLevel && Client.gameCycle < var5.field873) {
                  var5.field871 = false;
                  var5.field862 = Ignore.method1119(var5.x, var5.y, Sequence.plane);
                  class46.region.method2720(Sequence.plane, var5.x, var5.y, var5.field862, 60, var5, var5.angle, var6, var5.field856, var5.field860, var5.field869, var5.field870);
               } else {
                  if((var5.x & 127) == 64 && (var5.y & 127) == 64) {
                     if(Client.field890[var7][var8] == Client.field1152) {
                        continue;
                     }

                     Client.field890[var7][var8] = Client.field1152;
                  }

                  var5.field862 = Ignore.method1119(var5.x, var5.y, Sequence.plane);
                  class46.region.method2771(Sequence.plane, var5.x, var5.y, var5.field862, 60, var5, var5.angle, var6, var5.field1207);
               }
            }
         }
      }

   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "-58099517"
   )
   int method92(class14 var1, class14 var2) {
      return var1.field286.totalQuantity < var2.field286.totalQuantity?-1:(var1.field286.totalQuantity == var2.field286.totalQuantity?0:1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1372403142"
   )
   static int method93(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class83.intStackSize -= 2;
         var3 = class83.intStack[class83.intStackSize];
         int var4 = class83.intStack[class83.intStackSize + 1];
         if(!Client.field929) {
            Client.field973 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class83.intStack[++class83.intStackSize - 1] = Client.field973;
         return 1;
      } else if(var0 == 5506) {
         class83.intStack[++class83.intStackSize - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class83.intStack[--class83.intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field979 = var3;
         return 1;
      } else if(var0 == 5531) {
         class83.intStack[++class83.intStackSize - 1] = Client.field979;
         return 1;
      } else {
         return 2;
      }
   }
}
