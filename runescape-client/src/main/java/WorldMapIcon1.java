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
   @Export("archive3")
   static Archive archive3;
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
   @Export("element")
   final int element;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Laj;"
   )
   @Export("label")
   final WorldMapLabel label;
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
   WorldMapIcon1(Coord var1, Coord var2, int var3, WorldMapLabel var4) {
      super(var1, var2);
      this.element = var3;
      this.label = var4;
      WorldMapElement var5 = ViewportMouse.getWorldMapElement(this.getElement());
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
   @Export("getElement")
   public int getElement() {
      return this.element;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Laj;",
      garbageValue = "1159446036"
   )
   @Export("getLabel")
   WorldMapLabel getLabel() {
      return this.label;
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
   @Export("addGameMessage")
   static void addGameMessage(int var0, String var1, String var2) {
      GrandExchangeEvents.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-252304353"
   )
   static final void method212() {
      for (int var0 = 0; var0 < Client.soundEffectCount; ++var0) {
         int var10003 = Client.queuedSoundEffectDelays[var0]--;
         if (Client.queuedSoundEffectDelays[var0] >= -10) {
            SoundEffect var11 = Client.soundEffects[var0];
            if (var11 == null) {
               Object var3 = null;
               var11 = SoundEffect.readSoundEffect(WorldMapDecoration.archive4, Client.soundEffectIds[var0], 0);
               if (var11 == null) {
                  continue;
               }

               int[] var4 = Client.queuedSoundEffectDelays;
               var4[var0] += var11.calculateDelay();
               Client.soundEffects[var0] = var11;
            }

            if (Client.queuedSoundEffectDelays[var0] < 0) {
               int var12;
               if (Client.soundLocations[var0] != 0) {
                  int var13 = (Client.soundLocations[var0] & 255) * 128;
                  int var5 = Client.soundLocations[var0] >> 16 & 255;
                  int var6 = var5 * 128 + 64 - Canvas.localPlayer.x;
                  if (var6 < 0) {
                     var6 = -var6;
                  }

                  int var7 = Client.soundLocations[var0] >> 8 & 255;
                  int var8 = var7 * 128 + 64 - Canvas.localPlayer.y;
                  if (var8 < 0) {
                     var8 = -var8;
                  }

                  int var9 = var6 + var8 - 128;
                  if (var9 > var13) {
                     Client.queuedSoundEffectDelays[var0] = -100;
                     continue;
                  }

                  if (var9 < 0) {
                     var9 = 0;
                  }

                  var12 = (var13 - var9) * Client.field115 / var13;
               } else {
                  var12 = Client.soundEffectVolume;
               }

               if (var12 > 0) {
                  RawSound var14 = var11.toRawSound().resample(MilliClock.decimator);
                  RawPcmStream var15 = RawPcmStream.createRawPcmStream(var14, 100, var12);
                  var15.setNumLoops(Client.queuedSoundEffectLoops[var0] - 1);
                  TaskHandler.pcmStreamMixer.addSubStream(var15);
               }

               Client.queuedSoundEffectDelays[var0] = -100;
            }
         } else {
            --Client.soundEffectCount;

            for (int var2 = var0; var2 < Client.soundEffectCount; ++var2) {
               Client.soundEffectIds[var2] = Client.soundEffectIds[var2 + 1];
               Client.soundEffects[var2] = Client.soundEffects[var2 + 1];
               Client.queuedSoundEffectLoops[var2] = Client.queuedSoundEffectLoops[var2 + 1];
               Client.queuedSoundEffectDelays[var2] = Client.queuedSoundEffectDelays[var2 + 1];
               Client.soundLocations[var2] = Client.soundLocations[var2 + 1];
            }

            --var0;
         }
      }

      if (Client.field107) {
         boolean var10;
         if (class214.field1129 != 0) {
            var10 = true;
         } else {
            var10 = class214.midiPcmStream.isReady();
         }

         if (!var10) {
            if (Client.field128 != 0 && Client.field112 != -1) {
               Login.method2076(UserComparator3.archive6, Client.field112, 0, Client.field128, false);
            }

            Client.field107 = false;
         }
      }

   }
}
