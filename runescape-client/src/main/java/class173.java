import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class173 {
   @ObfuscatedName("ms")
   @ObfuscatedSignature(
      signature = "Lfp;"
   )
   @Export("mouseWheel")
   static MouseWheel mouseWheel;
   @ObfuscatedName("ql")
   @ObfuscatedSignature(
      signature = "Lm;"
   )
   @Export("grandExchangeEvents")
   static GrandExchangeEvents grandExchangeEvents;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 3382529256651238907L
   )
   static long field2288;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Laz;"
   )
   @Export("scriptMapIconReference")
   static MapIconReference scriptMapIconReference;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1532704803"
   )
   static void method3490() {
      class50.field446 = 99;
      class50.tileUnderlayIds = new byte[4][104][104];
      class139.tileOverlayIds = new byte[4][104][104];
      NPC.tileOverlayPath = new byte[4][104][104];
      class50.overlayRotations = new byte[4][104][104];
      MouseRecorder.field534 = new int[4][105][105];
      class50.field449 = new byte[4][105][105];
      WorldMapDecoration.field162 = new int[105][105];
      class50.floorHues = new int[104];
      Size.floorSaturations = new int[104];
      class50.field451 = new int[104];
      MapIconReference.floorMultiplier = new int[104];
      class50.field452 = new int[104];
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(Ljh;IIII)V",
      garbageValue = "390326939"
   )
   @Export("queueAnimationSound")
   static void queueAnimationSound(Sequence var0, int var1, int var2, int var3) {
      if(Client.queuedSoundEffectCount < 50 && Client.field827 != 0) {
         if(var0.field3556 != null && var1 < var0.field3556.length) {
            int var4 = var0.field3556[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.queuedSoundEffectIDs[Client.queuedSoundEffectCount] = var5;
               Client.unknownSoundValues1[Client.queuedSoundEffectCount] = var6;
               Client.unknownSoundValues2[Client.queuedSoundEffectCount] = 0;
               Client.audioEffects[Client.queuedSoundEffectCount] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.soundLocations[Client.queuedSoundEffectCount] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.queuedSoundEffectCount;
            }
         }
      }
   }
}
