import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
public class class242 {
   @ObfuscatedName("q")
   public static final boolean[] field2959;
   @ObfuscatedName("o")
   public static int[] field2961;

   static {
      field2959 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2961 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2961[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(Ljo;IIII)V",
      garbageValue = "-423622602"
   )
   @Export("queueAnimationSound")
   static void queueAnimationSound(Sequence var0, int var1, int var2, int var3) {
      if(Client.queuedSoundEffectCount < 50 && Client.field1041 != 0) {
         if(var0.field3686 != null && var1 < var0.field3686.length) {
            int var4 = var0.field3686[var1];
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
