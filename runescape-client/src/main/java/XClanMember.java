import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("o")
   String field906;
   @ObfuscatedName("c")
   @Export("username")
   String username;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -765425651
   )
   @Export("world")
   int world;
   @ObfuscatedName("u")
   @Export("rank")
   byte rank;

   @ObfuscatedName("ep")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2098869602"
   )
   static final void method1094() {
      for(int var0 = 0; var0 < Client.field935; ++var0) {
         --Client.field1010[var0];
         if(Client.field1010[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(class25.field353, Client.field1081[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.field1010[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.field1010[var0] < 0) {
               int var2;
               if(Client.field1148[var0] != 0) {
                  int var3 = (Client.field1148[var0] & 255) * 128;
                  int var4 = Client.field1148[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - class226.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field1148[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - class226.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.field1010[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field1035 / var3;
               } else {
                  var2 = Client.field1136;
               }

               if(var2 > 0) {
                  class107 var10 = var9.method1867().method1913(class9.field237);
                  class117 var11 = class117.method2054(var10, 100, var2);
                  var11.method2057(Client.field1151[var0] - 1);
                  class1.field4.method1808(var11);
               }

               Client.field1010[var0] = -100;
            }
         } else {
            --Client.field935;

            for(int var1 = var0; var1 < Client.field935; ++var1) {
               Client.field1081[var1] = Client.field1081[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.field1151[var1] = Client.field1151[var1 + 1];
               Client.field1010[var1] = Client.field1010[var1 + 1];
               Client.field1148[var1] = Client.field1148[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field1141 && !Coordinates.method3860()) {
         if(Client.field1139 != 0 && Client.field1140 != -1) {
            class18.method136(class8.indexTrack1, Client.field1140, 0, Client.field1139, false);
         }

         Client.field1141 = false;
      }

   }
}
