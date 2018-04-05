import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
@Implements("Ignore")
public class Ignore extends Nameable {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 761155819
   )
   int field3844;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lkl;I)I",
      garbageValue = "-2086506629"
   )
   int method5380(Ignore var1) {
      return this.field3844 - var1.field3844;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lku;I)I",
      garbageValue = "-1796643174"
   )
   public int vmethod5448(Nameable var1) {
      return this.method5380((Ignore)var1);
   }

   public int compareTo(Object var1) {
      return this.method5380((Ignore)var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[Lln;",
      garbageValue = "1495350576"
   )
   public static class320[] method5386() {
      return new class320[]{class320.field3933, class320.field3935, class320.field3934};
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)[Ljx;",
      garbageValue = "111"
   )
   static VerticalAlignment[] method5387() {
      return new VerticalAlignment[]{VerticalAlignment.field3442, VerticalAlignment.field3440, VerticalAlignment.field3439};
   }

   @ObfuscatedName("fi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "384075612"
   )
   static final void method5385() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      if(Client.field960 == 0) {
         var0 = SoundTaskDataProvider.localPlayer.x;
         var1 = SoundTaskDataProvider.localPlayer.y;
         if(class169.field2228 - var0 < -500 || class169.field2228 - var0 > 500 || class46.field578 - var1 < -500 || class46.field578 - var1 > 500) {
            class169.field2228 = var0;
            class46.field578 = var1;
         }

         if(var0 != class169.field2228) {
            class169.field2228 += (var0 - class169.field2228) / 16;
         }

         if(var1 != class46.field578) {
            class46.field578 += (var1 - class46.field578) / 16;
         }

         var2 = class169.field2228 >> 7;
         var3 = class46.field578 >> 7;
         var4 = class265.getTileHeight(class169.field2228, class46.field578, BoundingBox3DDrawMode.plane);
         var5 = 0;
         int var6;
         if(var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
            for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
               for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
                  int var8 = BoundingBox3DDrawMode.plane;
                  if(var8 < 3 && (class62.tileSettings[1][var6][var7] & 2) == 2) {
                     ++var8;
                  }

                  int var9 = var4 - class62.tileHeights[var8][var6][var7];
                  if(var9 > var5) {
                     var5 = var9;
                  }
               }
            }
         }

         var6 = var5 * 192;
         if(var6 > 98048) {
            var6 = 98048;
         }

         if(var6 < 32768) {
            var6 = 32768;
         }

         if(var6 > Client.field884) {
            Client.field884 += (var6 - Client.field884) / 24;
         } else if(var6 < Client.field884) {
            Client.field884 += (var6 - Client.field884) / 80;
         }

         ObjectComposition.field3640 = class265.getTileHeight(SoundTaskDataProvider.localPlayer.x, SoundTaskDataProvider.localPlayer.y, BoundingBox3DDrawMode.plane) - Client.field945;
      } else if(Client.field960 == 1) {
         if(Client.field1061 && SoundTaskDataProvider.localPlayer != null) {
            var0 = SoundTaskDataProvider.localPlayer.pathX[0];
            var1 = SoundTaskDataProvider.localPlayer.pathY[0];
            if(var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
               class169.field2228 = SoundTaskDataProvider.localPlayer.x;
               var2 = class265.getTileHeight(SoundTaskDataProvider.localPlayer.x, SoundTaskDataProvider.localPlayer.y, BoundingBox3DDrawMode.plane) - Client.field945;
               if(var2 < ObjectComposition.field3640) {
                  ObjectComposition.field3640 = var2;
               }

               class46.field578 = SoundTaskDataProvider.localPlayer.y;
               Client.field1061 = false;
            }
         }

         short var10 = -1;
         if(KeyFocusListener.keyPressed[33]) {
            var10 = 0;
         } else if(KeyFocusListener.keyPressed[49]) {
            var10 = 1024;
         }

         if(KeyFocusListener.keyPressed[48]) {
            if(var10 == 0) {
               var10 = 1792;
            } else if(var10 == 1024) {
               var10 = 1280;
            } else {
               var10 = 1536;
            }
         } else if(KeyFocusListener.keyPressed[50]) {
            if(var10 == 0) {
               var10 = 256;
            } else if(var10 == 1024) {
               var10 = 768;
            } else {
               var10 = 512;
            }
         }

         byte var11 = 0;
         if(KeyFocusListener.keyPressed[35]) {
            var11 = -1;
         } else if(KeyFocusListener.keyPressed[51]) {
            var11 = 1;
         }

         var2 = 0;
         if(var10 >= 0 || var11 != 0) {
            var2 = KeyFocusListener.keyPressed[81]?Client.field950:Client.field1059;
            var2 *= 16;
            Client.field947 = var10;
            Client.field948 = var11;
         }

         if(Client.field946 < var2) {
            Client.field946 += var2 / 8;
            if(Client.field946 > var2) {
               Client.field946 = var2;
            }
         } else if(Client.field946 > var2) {
            Client.field946 = Client.field946 * 9 / 10;
         }

         if(Client.field946 > 0) {
            var3 = Client.field946 / 16;
            if(Client.field947 >= 0) {
               var0 = Client.field947 - class28.cameraYaw & 2047;
               var4 = Graphics3D.SINE[var0];
               var5 = Graphics3D.COSINE[var0];
               class169.field2228 += var4 * var3 / 65536;
               class46.field578 += var3 * var5 / 65536;
            }

            if(Client.field948 != 0) {
               ObjectComposition.field3640 += var3 * Client.field948;
               if(ObjectComposition.field3640 > 0) {
                  ObjectComposition.field3640 = 0;
               }
            }
         } else {
            Client.field947 = -1;
            Client.field948 = -1;
         }

         if(KeyFocusListener.keyPressed[13]) {
            GrandExchangeEvent.method88();
         }
      }

      if(MouseInput.mouseCurrentButton == 4 && MapIconReference.middleMouseMovesCamera) {
         var0 = MouseInput.mouseLastY - Client.field943;
         Client.field941 = var0 * 2;
         Client.field943 = var0 != -1 && var0 != 1?(Client.field943 + MouseInput.mouseLastY) / 2:MouseInput.mouseLastY;
         var1 = Client.field897 - MouseInput.mouseLastX;
         Client.field940 = var1 * 2;
         Client.field897 = var1 != -1 && var1 != 1?(MouseInput.mouseLastX + Client.field897) / 2:MouseInput.mouseLastX;
      } else {
         if(KeyFocusListener.keyPressed[96]) {
            Client.field940 += (-24 - Client.field940) / 2;
         } else if(KeyFocusListener.keyPressed[97]) {
            Client.field940 += (24 - Client.field940) / 2;
         } else {
            Client.field940 /= 2;
         }

         if(KeyFocusListener.keyPressed[98]) {
            Client.field941 += (12 - Client.field941) / 2;
         } else if(KeyFocusListener.keyPressed[99]) {
            Client.field941 += (-12 - Client.field941) / 2;
         } else {
            Client.field941 /= 2;
         }

         Client.field943 = MouseInput.mouseLastY;
         Client.field897 = MouseInput.mouseLastX;
      }

      Client.mapAngle = Client.field940 / 2 + Client.mapAngle & 2047;
      Client.cameraPitchTarget += Client.field941 / 2;
      if(Client.cameraPitchTarget < 128) {
         Client.cameraPitchTarget = 128;
      }

      if(Client.cameraPitchTarget > 383) {
         Client.cameraPitchTarget = 383;
      }

   }
}
