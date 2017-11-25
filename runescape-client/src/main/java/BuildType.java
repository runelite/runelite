import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("BuildType")
public class BuildType {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("RC")
   static final BuildType RC;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("WIP")
   static final BuildType WIP;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("LIVE")
   static final BuildType LIVE;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   @Export("BUILD_LIVE")
   static final BuildType BUILD_LIVE;
   @ObfuscatedName("aa")
   static int[] field3261;
   @ObfuscatedName("v")
   @Export("identifier")
   public final String identifier;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1945228291
   )
   @Export("ordinal")
   final int ordinal;

   static {
      RC = new BuildType("LIVE", 0);
      WIP = new BuildType("BUILDLIVE", 3);
      LIVE = new BuildType("RC", 1);
      BUILD_LIVE = new BuildType("WIP", 2);
   }

   BuildType(String var1, int var2) {
      this.identifier = var1;
      this.ordinal = var2;
   }

   @ObfuscatedName("fe")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1523150476"
   )
   static final void method4254() {
      for(int var0 = 0; var0 < Client.field985; ++var0) {
         --Client.field930[var0];
         if(Client.field930[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(class47.field576, Client.field970[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.field930[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.field930[var0] < 0) {
               int var2;
               if(Client.field1098[var0] != 0) {
                  int var3 = (Client.field1098[var0] & 255) * 128;
                  int var4 = Client.field1098[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - class181.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.field1098[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - class181.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.field930[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field1093 / var3;
               } else {
                  var2 = Client.field1009;
               }

               if(var2 > 0) {
                  class106 var10 = var9.method2013().method2066(SoundTask.field1583);
                  class116 var11 = class116.method2227(var10, 100, var2);
                  var11.method2230(Client.field1096[var0] - 1);
                  class70.field821.method1953(var11);
               }

               Client.field930[var0] = -100;
            }
         } else {
            --Client.field985;

            for(int var1 = var0; var1 < Client.field985; ++var1) {
               Client.field970[var1] = Client.field970[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.field1096[var1] = Client.field1096[var1 + 1];
               Client.field930[var1] = Client.field930[var1 + 1];
               Client.field1098[var1] = Client.field1098[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field1095 && !GrandExchangeOffer.method116()) {
         if(Client.field1113 != 0 && Client.field1090 != -1) {
            Buffer.method3318(RSCanvas.indexTrack1, Client.field1090, 0, Client.field1113, false);
         }

         Client.field1095 = false;
      }

   }
}
