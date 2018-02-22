import java.io.File;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class166 {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public static IndexDataBase field2167;
   @ObfuscatedName("p")
   @Export("jagexClDat")
   public static File jagexClDat;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -758978073
   )
   @Export("idxCount")
   public static int idxCount;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("randomDat")
   public static CacheFile randomDat;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("dat2File")
   public static CacheFile dat2File;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lde;"
   )
   @Export("idx255File")
   public static CacheFile idx255File;
   @ObfuscatedName("at")
   protected static boolean field2176;
   @ObfuscatedName("ji")
   @ObfuscatedGetter(
      intValue = -1917364025
   )
   static int field2172;

   static {
      randomDat = null;
      dat2File = null;
      idx255File = null;
   }

   @ObfuscatedName("b")
   public static String method3258(long var0) {
      class202.field2584.setTime(new Date(var0));
      int var2 = class202.field2584.get(7);
      int var3 = class202.field2584.get(5);
      int var4 = class202.field2584.get(2);
      int var5 = class202.field2584.get(1);
      int var6 = class202.field2584.get(11);
      int var7 = class202.field2584.get(12);
      int var8 = class202.field2584.get(13);
      return class202.field2585[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class202.field2583[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-928277611"
   )
   static final void method3260() {
      for(int var0 = 0; var0 < Client.queuedSoundEffectCount; ++var0) {
         --Client.unknownSoundValues2[var0];
         if(Client.unknownSoundValues2[var0] >= -10) {
            SoundEffect var9 = Client.audioEffects[var0];
            if(var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.getTrack(class54.indexCache4, Client.queuedSoundEffectIDs[var0], 0);
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
                  int var5 = var4 * 128 + 64 - OwnWorldComparator.localPlayer.x;
                  if(var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.soundLocations[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - OwnWorldComparator.localPlayer.y;
                  if(var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if(var8 > var3) {
                     Client.unknownSoundValues2[var0] = -100;
                     continue;
                  }

                  if(var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * Client.field1041 / var3;
               } else {
                  var2 = Client.field1040;
               }

               if(var2 > 0) {
                  RawAudioNode var10 = var9.method2124().applyResampler(class197.field2565);
                  class114 var11 = class114.method2315(var10, 100, var2);
                  var11.method2318(Client.unknownSoundValues1[var0] - 1);
                  KeyFocusListener.field583.method2064(var11);
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

      if(Client.field1039) {
         boolean var12;
         if(class223.field2646 != 0) {
            var12 = true;
         } else {
            var12 = class155.field2105.method4180();
         }

         if(!var12) {
            if(Client.field971 != 0 && Client.field1015 != -1) {
               class152.method3129(class155.indexTrack1, Client.field1015, 0, Client.field971, false);
            }

            Client.field1039 = false;
         }
      }

   }
}
