import java.security.SecureRandom;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("WorldMapIcon1")
public class WorldMapIcon1 extends AbstractWorldMapIcon {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   static Widget field1030;
   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache3")
   static IndexCache indexCache3;
   @ObfuscatedName("ec")
   @Export("secureRandom")
   static SecureRandom secureRandom;
   @ObfuscatedName("hq")
   @ObfuscatedGetter(
      intValue = 490189491
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1722323621
   )
   final int field1031;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   @Export("label0")
   final WorldMapLabel label0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 364253793
   )
   final int field1032;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -362031241
   )
   final int field1033;

   @ObfuscatedSignature(
      signature = "(Lhu;Lhu;ILaj;)V"
   )
   WorldMapIcon1(TileLocation var1, TileLocation var2, int var3, WorldMapLabel var4) {
      super(var1, var2);
      this.field1031 = var3;
      this.label0 = var4;
      WorldMapElement var5 = ViewportMouse.getWorldMapElement(this.vmethod395());
      Sprite var6 = var5.getSprite(false);
      if (var6 != null) {
         this.field1032 = var6.subWidth;
         this.field1033 = var6.subHeight;
      } else {
         this.field1032 = 0;
         this.field1033 = 0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1990181988"
   )
   public int vmethod395() {
      return this.field1031;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Laj;",
      garbageValue = "1159446036"
   )
   WorldMapLabel vmethod396() {
      return this.label0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "75"
   )
   int vmethod397() {
      return this.field1032;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1558233611"
   )
   int vmethod398() {
      return this.field1033;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-460290173"
   )
   static void method219(int var0, String var1, String var2) {
      GrandExchangeEvents.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-252304353"
   )
   static final void method212() {
      for (int var0 = 0; var0 < Client.soundEffectCount; ++var0) {
         int var10002 = Client.queuedSoundEffectDelays[var0]--;
         if (Client.queuedSoundEffectDelays[var0] >= -10) {
            SoundEffect var10 = Client.soundEffects[var0];
            if (var10 == null) {
               Object var2 = null;
               var10 = SoundEffect.readSoundEffect(class25.indexCache4, Client.soundEffectIds[var0], 0);
               if (var10 == null) {
                  continue;
               }

               int[] var10000 = Client.queuedSoundEffectDelays;
               var10000[var0] += var10.method303();
               Client.soundEffects[var0] = var10;
            }

            if (Client.queuedSoundEffectDelays[var0] < 0) {
               int var11;
               if (Client.soundLocations[var0] != 0) {
                  int var3 = (Client.soundLocations[var0] & 255) * 128;
                  int var4 = Client.soundLocations[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - Canvas.localPlayer.x;
                  if (var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.soundLocations[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - Canvas.localPlayer.y;
                  if (var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var5 + var7 - 128;
                  if (var8 > var3) {
                     Client.queuedSoundEffectDelays[var0] = -100;
                     continue;
                  }

                  if (var8 < 0) {
                     var8 = 0;
                  }

                  var11 = (var3 - var8) * Client.field115 / var3;
               } else {
                  var11 = Client.soundEffectVolume;
               }

               if (var11 > 0) {
                  RawSound var12 = var10.toRawSound().resample(MilliClock.decimator);
                  RawPcmStream var13 = RawPcmStream.createRawPcmStream(var12, 100, var11);
                  var13.setNumLoops(Client.queuedSoundEffectLoops[var0] - 1);
                  TaskHandler.pcmStreamMixer.addSubStream(var13);
               }

               Client.queuedSoundEffectDelays[var0] = -100;
            }
         } else {
            --Client.soundEffectCount;

            for (int var1 = var0; var1 < Client.soundEffectCount; ++var1) {
               Client.soundEffectIds[var1] = Client.soundEffectIds[var1 + 1];
               Client.soundEffects[var1] = Client.soundEffects[var1 + 1];
               Client.queuedSoundEffectLoops[var1] = Client.queuedSoundEffectLoops[var1 + 1];
               Client.queuedSoundEffectDelays[var1] = Client.queuedSoundEffectDelays[var1 + 1];
               Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
            }

            --var0;
         }
      }

      if (Client.field107) {
         boolean var9;
         if (class214.field1129 != 0) {
            var9 = true;
         } else {
            var9 = class214.midiPcmStream.isReady();
         }

         if (!var9) {
            if (Client.field128 != 0 && Client.field112 != -1) {
               Login.method2076(UserComparator3.indexCache6, Client.field112, 0, Client.field128, false);
            }

            Client.field107 = false;
         }
      }

   }
}
