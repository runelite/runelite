import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class38 {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("q")
   static int[] field489;
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "Lbn;"
   )
   @Export("mouseRecorder")
   static MouseRecorder mouseRecorder;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "2133478144"
   )
   static synchronized void method531(byte[] var0) {
      if(var0.length == 100 && class195.field2572 < 1000) {
         class195.field2575[++class195.field2572 - 1] = var0;
      } else if(var0.length == 5000 && class195.field2577 < 250) {
         class195.field2576[++class195.field2577 - 1] = var0;
      } else if(var0.length == 30000 && class195.field2574 < 50) {
         class195.field2573[++class195.field2574 - 1] = var0;
      } else {
         if(class195.field2578 != null) {
            for(int var1 = 0; var1 < PacketNode.field2491.length; ++var1) {
               if(var0.length == PacketNode.field2491[var1] && GrandExchangeEvents.field265[var1] < class195.field2578[var1].length) {
                  class195.field2578[var1][GrandExchangeEvents.field265[var1]++] = var0;
                  return;
               }
            }
         }

      }
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(Lkn;IIII)V",
      garbageValue = "-503372841"
   )
   @Export("queueAnimationSound")
   static void queueAnimationSound(Sequence var0, int var1, int var2, int var3) {
      if(Client.queuedSoundEffectCount < 50 && Client.field1034 != 0) {
         if(var0.field3759 != null && var1 < var0.field3759.length) {
            int var4 = var0.field3759[var1];
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

   @ObfuscatedName("ks")
   @ObfuscatedSignature(
      signature = "(Lib;IS)Ljava/lang/String;",
      garbageValue = "-1598"
   )
   static String method529(Widget var0, int var1) {
      int var3 = class45.getWidgetClickMask(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.onOpListener == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }
}
