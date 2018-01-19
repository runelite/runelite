import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class167 {
   @ObfuscatedName("y")
   public static int[][] field2236;
   @ObfuscatedName("r")
   public static int[][] field2238;
   @ObfuscatedName("b")
   public static int[] field2241;
   @ObfuscatedName("e")
   public static int[] field2240;

   static {
      field2236 = new int[128][128];
      field2238 = new int[128][128];
      field2241 = new int[4096];
      field2240 = new int[4096];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;I)V",
      garbageValue = "878734503"
   )
   public static void method3235(IndexDataBase var0) {
      class228.EnumDefinition_indexCache = var0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1064240801"
   )
   public static boolean method3234(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      signature = "(Ljs;IIII)V",
      garbageValue = "-819383232"
   )
   @Export("queueAnimationSound")
   static void queueAnimationSound(Sequence var0, int var1, int var2, int var3) {
      if(Client.queuedSoundEffectCount < 50 && Client.field1094 != 0) {
         if(var0.field3690 != null && var1 < var0.field3690.length) {
            int var4 = var0.field3690[var1];
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
