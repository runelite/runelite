import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public final class class60 {
   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static class298 field718;

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1555857076"
   )
   static final void method1088() {
      for(int var0 = 0; var0 < Client.field1091; ++var0) {
         --Client.field1094[var0];
         if(Client.field1094[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(Tile.field1838, Client.field910[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.field1094[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.field1094[var0] < 0) {
               int var2;
               if(Client.field1033[var0] != 0) {
                  int var3 = (Client.field1033[var0] & 255) * 128;
                  int var4 = Client.field1033[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - class48.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field1033[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - class48.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var3) {
                     Client.field1094[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field1067 / var3;
               } else {
                  var2 = Client.field1089;
               }

               if(var2 > 0) {
                  class106 var10 = var9.method2038().method2080(class231.field2920);
                  class116 var11 = class116.method2235(var10, 100, var2);
                  var11.method2220(Client.field1093[var0] - 1);
                  class268.field3675.method1972(var11);
               }

               Client.field1094[var0] = -100;
            }
         } else {
            --Client.field1091;

            for(int var1 = var0; var1 < Client.field1091; ++var1) {
               Client.field910[var1] = Client.field910[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.field1093[var1] = Client.field1093[var1 + 1];
               Client.field1094[var1] = Client.field1094[var1 + 1];
               Client.field1033[var1] = Client.field1033[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field1088) {
         boolean var12;
         if(class210.field2594 != 0) {
            var12 = true;
         } else {
            var12 = class210.field2596.method3861();
         }

         if(!var12) {
            if(Client.field1059 != 0 && Client.field1026 != -1) {
               class182.method3518(class21.indexTrack1, Client.field1026, 0, Client.field1059, false);
            }

            Client.field1088 = false;
         }
      }

   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "1214040923"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class188.method3612(var0, var1, var2, var3, var4, var5, false);
   }
}
