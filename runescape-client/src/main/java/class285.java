import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
public class class285 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljw;"
   )
   static final class285 field3786;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljw;"
   )
   public static final class285 field3793;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljw;"
   )
   static final class285 field3787;
   @ObfuscatedName("v")
   static byte[][][] field3790;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static Widget field3789;
   @ObfuscatedName("cj")
   public static char field3792;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 215236115
   )
   public final int field3785;

   static {
      field3786 = new class285(0);
      field3793 = new class285(1);
      field3787 = new class285(2);
   }

   class285(int var1) {
      this.field3785 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Liv;",
      garbageValue = "-1164672428"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class18.field312.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }
}
