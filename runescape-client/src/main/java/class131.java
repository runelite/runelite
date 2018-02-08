import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public class class131 {
   @ObfuscatedName("s")
   @Export("Viewport_containsMouse")
   public static boolean Viewport_containsMouse;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1284971533
   )
   @Export("Viewport_mouseX")
   public static int Viewport_mouseX;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 108900277
   )
   @Export("Viewport_mouseY")
   public static int Viewport_mouseY;
   @ObfuscatedName("h")
   @Export("Viewport_false0")
   public static boolean Viewport_false0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 414922731
   )
   static int field1881;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 918593961
   )
   @Export("Viewport_entityCountAtMouse")
   public static int Viewport_entityCountAtMouse;
   @ObfuscatedName("q")
   @Export("Viewport_entityIdsAtMouse")
   public static int[] Viewport_entityIdsAtMouse;

   static {
      Viewport_containsMouse = false;
      Viewport_mouseX = 0;
      Viewport_mouseY = 0;
      Viewport_false0 = false;
      Viewport_entityCountAtMouse = 0;
      Viewport_entityIdsAtMouse = new int[1000];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)[Lik;",
      garbageValue = "-1236851461"
   )
   public static Permission[] method2805() {
      return new Permission[]{Permission.field3265, Permission.field3267, Permission.field3266, Permission.field3268, Permission.field3271, Permission.field3264};
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIIII[Lfb;I)V",
      garbageValue = "-895637786"
   )
   static final void method2810(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var7 + var1][var8 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               SceneTilePaint.loadTerrain(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "-1516419834"
   )
   public static int method2812(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class249.NetCache_pendingPriorityResponsesCount + class249.NetCache_pendingPriorityWritesCount;
      return var3;
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1384650102"
   )
   static final void method2811() {
      for(int var0 = 0; var0 < Client.queuedSoundEffectCount; ++var0) {
         --Client.unknownSoundValues2[var0];
         if(Client.unknownSoundValues2[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(class62.indexCache4, Client.queuedSoundEffectIDs[var0], 0);
               if(var9 == null) {
                  continue;
               }

               Client.unknownSoundValues2[var0] += var9.calculateDelay();
               Client.audioEffects[var0] = var9;
            }

            if(Client.unknownSoundValues2[var0] < 0) {
               int var2;
               if(Client.soundLocations[var0] != 0) {
                  int var3 = (Client.soundLocations[var0] & 255) * 128;
                  int var4 = Client.soundLocations[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - GroundObject.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.soundLocations[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - GroundObject.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if(var8 > var3) {
                     Client.unknownSoundValues2[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field878 / var3;
               } else {
                  var2 = Client.field1058;
               }

               if(var2 > 0) {
                  RawAudioNode var10 = var9.method2181().applyResampler(VarPlayerType.field3370);
                  class116 var11 = class116.method2526(var10, 100, var2);
                  var11.method2387(Client.unknownSoundValues1[var0] - 1);
                  class33.field450.method2129(var11);
               }

               Client.unknownSoundValues2[var0] = -100;
            }
         } else {
            --Client.queuedSoundEffectCount;

            for(int var1 = var0; var1 < Client.queuedSoundEffectCount; ++var1) {
               Client.queuedSoundEffectIDs[var1] = Client.queuedSoundEffectIDs[var1 + 1];
               Client.audioEffects[var1] = Client.audioEffects[var1 + 1];
               Client.unknownSoundValues1[var1] = Client.unknownSoundValues1[var1 + 1];
               Client.unknownSoundValues2[var1] = Client.unknownSoundValues2[var1 + 1];
               Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
            }

            --var0;
         }
      }

      if(Client.field1059) {
         boolean var12;
         if(class214.field2617 != 0) {
            var12 = true;
         } else {
            var12 = class25.field356.method4221();
         }

         if(!var12) {
            if(Client.field1057 != 0 && Client.field902 != -1) {
               class3.method7(class231.indexTrack1, Client.field902, 0, Client.field1057, false);
            }

            Client.field1059 = false;
         }
      }

   }
}
