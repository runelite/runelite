import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("ISAACCipher")
public final class ISAACCipher {
   @ObfuscatedName("ej")
   @ObfuscatedSignature(
      signature = "Lfb;"
   )
   static Task field2598;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 665359607
   )
   @Export("valuesRemaining")
   int valuesRemaining;
   @ObfuscatedName("l")
   @Export("randResult")
   int[] randResult;
   @ObfuscatedName("b")
   @Export("mm")
   int[] mm;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 509424107
   )
   int field2594;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1020470179
   )
   int field2595;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 813973081
   )
   int field2596;

   public ISAACCipher(int[] var1) {
      this.mm = new int[256];
      this.randResult = new int[256];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.randResult[var2] = var1[var2];
      }

      this.method3838();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-19098397"
   )
   @Export("nextInt")
   final int nextInt() {
      if(0 == --this.valuesRemaining + 1) {
         this.generateMoreResults();
         this.valuesRemaining = 255;
      }

      return this.randResult[this.valuesRemaining];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2117124923"
   )
   final int method3842() {
      if(this.valuesRemaining == 0) {
         this.generateMoreResults();
         this.valuesRemaining = 256;
      }

      return this.randResult[this.valuesRemaining - 1];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1638257629"
   )
   @Export("generateMoreResults")
   final void generateMoreResults() {
      this.field2595 += ++this.field2596;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.mm[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2594 ^= this.field2594 << 13;
            } else {
               this.field2594 ^= this.field2594 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2594 ^= this.field2594 << 2;
         } else {
            this.field2594 ^= this.field2594 >>> 16;
         }

         this.field2594 += this.mm[var1 + 128 & 255];
         int var3;
         this.mm[var1] = var3 = this.mm[(var2 & 1020) >> 2] + this.field2594 + this.field2595;
         this.randResult[var1] = this.field2595 = this.mm[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-55"
   )
   final void method3838() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.randResult[var1];
         var3 += this.randResult[var1 + 1];
         var4 += this.randResult[var1 + 2];
         var5 += this.randResult[var1 + 3];
         var6 += this.randResult[var1 + 4];
         var7 += this.randResult[var1 + 5];
         var8 += this.randResult[var1 + 6];
         var9 += this.randResult[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.mm[var1];
         var3 += this.mm[var1 + 1];
         var4 += this.mm[var1 + 2];
         var5 += this.mm[var1 + 3];
         var6 += this.mm[var1 + 4];
         var7 += this.mm[var1 + 5];
         var8 += this.mm[var1 + 6];
         var9 += this.mm[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[var1 + 7] = var9;
      }

      this.generateMoreResults();
      this.valuesRemaining = 256;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(DDIB)[D",
      garbageValue = "65"
   )
   public static double[] method3851(double var0, double var2, int var4) {
      int var5 = var4 * 2 + 1;
      double[] var6 = new double[var5];
      int var7 = -var4;

      for(int var8 = 0; var7 <= var4; ++var8) {
         var6[var8] = Resampler.method2307((double)var7, var0, var2);
         ++var7;
      }

      return var6;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2134534774"
   )
   public static void method3847(int var0) {
      if(class229.field2674 != 0) {
         class229.field2677 = var0;
      } else {
         class229.field2673.method4220(var0);
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Let;",
      garbageValue = "-771288832"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.skeletons.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = MapLabel.method383(Sequence.skel_ref, Sequence.skin_ref, var0, false);
         if(var1 != null) {
            Sequence.skeletons.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
