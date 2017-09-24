import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class21 {
   @ObfuscatedName("ag")
   static java.awt.Font field354;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = -1052010395
   )
   static int field353;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "115"
   )
   static int method179(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "481478635"
   )
   public static void method178(boolean var0) {
      if(var0 != class2.isMembersWorld) {
         class5.method13();
         class2.isMembersWorld = var0;
      }

   }

   @ObfuscatedName("fh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2092600312"
   )
   static final void method181() {
      for(int var0 = 0; var0 < Client.field1172; ++var0) {
         --Client.field1001[var0];
         if(Client.field1001[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(class178.field2419, Client.field1173[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.field1001[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.field1001[var0] < 0) {
               int var2;
               if(Client.field1176[var0] != 0) {
                  int var3 = (Client.field1176[var0] & 255) * 128;
                  int var4 = Client.field1176[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - Player.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field1176[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - Player.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.field1001[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field1171 / var3;
               } else {
                  var2 = Client.field1185;
               }

               if(var2 > 0) {
                  class106 var10 = var9.method1943().method1984(class209.field2592);
                  class116 var11 = class116.method2130(var10, 100, var2);
                  var11.method2133(Client.field1174[var0] - 1);
                  class33.field479.method1915(var11);
               }

               Client.field1001[var0] = -100;
            }
         } else {
            --Client.field1172;

            for(int var1 = var0; var1 < Client.field1172; ++var1) {
               Client.field1173[var1] = Client.field1173[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.field1174[var1] = Client.field1174[var1 + 1];
               Client.field1001[var1] = Client.field1001[var1 + 1];
               Client.field1176[var1] = Client.field1176[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field1169) {
         boolean var12;
         if(class204.field2507 != 0) {
            var12 = true;
         } else {
            var12 = class225.field2856.method3827();
         }

         if(!var12) {
            if(Client.field1167 != 0 && Client.field1168 != -1) {
               CacheFile.method2339(class45.indexTrack1, Client.field1168, 0, Client.field1167, false);
            }

            Client.field1169 = false;
         }
      }

   }
}
