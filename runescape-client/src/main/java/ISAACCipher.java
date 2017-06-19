import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
@Implements("ISAACCipher")
public final class ISAACCipher {
   @ObfuscatedName("z")
   @Export("mm")
   int[] mm;
   @ObfuscatedName("w")
   @Export("randResult")
   int[] randResult;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -155453877
   )
   @Export("valuesRemaining")
   int valuesRemaining;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 103971167
   )
   int field2444;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1878262623
   )
   int field2445;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1147154151
   )
   int field2446;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "5"
   )
   @Export("nextInt")
   final int nextInt() {
      if(--this.valuesRemaining + 1 == 0) {
         this.generateMoreResults();
         this.valuesRemaining = 255;
      }

      return this.randResult[this.valuesRemaining];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("generateMoreResults")
   final void generateMoreResults() {
      this.field2445 += ++this.field2446;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.mm[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2444 ^= this.field2444 << 13;
            } else {
               this.field2444 ^= this.field2444 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2444 ^= this.field2444 << 2;
         } else {
            this.field2444 ^= this.field2444 >>> 16;
         }

         this.field2444 += this.mm[var1 + 128 & 255];
         int var3;
         this.mm[var1] = var3 = this.mm[(var2 & 1020) >> 2] + this.field2444 + this.field2445;
         this.randResult[var1] = this.field2445 = this.mm[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   ISAACCipher(int[] var1) {
      this.mm = new int[256];
      this.randResult = new int[256];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.randResult[var2] = var1[var2];
      }

      this.method3319();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "795937045"
   )
   final void method3319() {
      int var1 = -1640531527;
      int var2 = -1640531527;
      int var3 = -1640531527;
      int var4 = -1640531527;
      int var5 = -1640531527;
      int var6 = -1640531527;
      int var7 = -1640531527;
      int var8 = -1640531527;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         var8 ^= var7 << 11;
         var5 += var8;
         var7 += var6;
         var7 ^= var6 >>> 2;
         var4 += var7;
         var6 += var5;
         var6 ^= var5 << 8;
         var3 += var6;
         var5 += var4;
         var5 ^= var4 >>> 16;
         var2 += var5;
         var4 += var3;
         var4 ^= var3 << 10;
         var1 += var4;
         var3 += var2;
         var3 ^= var2 >>> 4;
         var8 += var3;
         var2 += var1;
         var2 ^= var1 << 8;
         var7 += var2;
         var1 += var8;
         var1 ^= var8 >>> 9;
         var6 += var1;
         var8 += var7;
      }

      for(var9 = 0; var9 < 256; var9 += 8) {
         var8 += this.randResult[var9];
         var7 += this.randResult[var9 + 1];
         var6 += this.randResult[var9 + 2];
         var5 += this.randResult[var9 + 3];
         var4 += this.randResult[var9 + 4];
         var3 += this.randResult[var9 + 5];
         var2 += this.randResult[var9 + 6];
         var1 += this.randResult[var9 + 7];
         var8 ^= var7 << 11;
         var5 += var8;
         var7 += var6;
         var7 ^= var6 >>> 2;
         var4 += var7;
         var6 += var5;
         var6 ^= var5 << 8;
         var3 += var6;
         var5 += var4;
         var5 ^= var4 >>> 16;
         var2 += var5;
         var4 += var3;
         var4 ^= var3 << 10;
         var1 += var4;
         var3 += var2;
         var3 ^= var2 >>> 4;
         var8 += var3;
         var2 += var1;
         var2 ^= var1 << 8;
         var7 += var2;
         var1 += var8;
         var1 ^= var8 >>> 9;
         var6 += var1;
         var8 += var7;
         this.mm[var9] = var8;
         this.mm[var9 + 1] = var7;
         this.mm[var9 + 2] = var6;
         this.mm[var9 + 3] = var5;
         this.mm[var9 + 4] = var4;
         this.mm[var9 + 5] = var3;
         this.mm[var9 + 6] = var2;
         this.mm[var9 + 7] = var1;
      }

      for(var9 = 0; var9 < 256; var9 += 8) {
         var8 += this.mm[var9];
         var7 += this.mm[var9 + 1];
         var6 += this.mm[var9 + 2];
         var5 += this.mm[var9 + 3];
         var4 += this.mm[var9 + 4];
         var3 += this.mm[var9 + 5];
         var2 += this.mm[var9 + 6];
         var1 += this.mm[var9 + 7];
         var8 ^= var7 << 11;
         var5 += var8;
         var7 += var6;
         var7 ^= var6 >>> 2;
         var4 += var7;
         var6 += var5;
         var6 ^= var5 << 8;
         var3 += var6;
         var5 += var4;
         var5 ^= var4 >>> 16;
         var2 += var5;
         var4 += var3;
         var4 ^= var3 << 10;
         var1 += var4;
         var3 += var2;
         var3 ^= var2 >>> 4;
         var8 += var3;
         var2 += var1;
         var2 ^= var1 << 8;
         var7 += var2;
         var1 += var8;
         var1 ^= var8 >>> 9;
         var6 += var1;
         var8 += var7;
         this.mm[var9] = var8;
         this.mm[var9 + 1] = var7;
         this.mm[var9 + 2] = var6;
         this.mm[var9 + 3] = var5;
         this.mm[var9 + 4] = var4;
         this.mm[var9 + 5] = var3;
         this.mm[var9 + 6] = var2;
         this.mm[var9 + 7] = var1;
      }

      this.generateMoreResults();
      this.valuesRemaining = 256;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1886600904"
   )
   public static boolean method3320(int var0) {
      return var0 >= class221.field2825.field2834 && var0 <= class221.field2841.field2834 || var0 == class221.field2823.field2834;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "([BS)V",
      garbageValue = "-23300"
   )
   static void method3321(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class286.field3796 = var1.readUnsignedShort();
      class286.field3793 = new int[class286.field3796];
      class286.field3794 = new int[class286.field3796];
      class286.field3791 = new int[class286.field3796];
      class149.field2211 = new int[class286.field3796];
      class286.field3797 = new byte[class286.field3796][];
      var1.offset = var0.length - 7 - class286.field3796 * 8;
      class220.field2818 = var1.readUnsignedShort();
      class286.field3792 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class286.field3796; ++var3) {
         class286.field3793[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3796; ++var3) {
         class286.field3794[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3796; ++var3) {
         class286.field3791[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3796; ++var3) {
         class149.field2211[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class286.field3796 * 8 - (var2 - 1) * 3;
      class116.field1686 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class116.field1686[var3] = var1.read24BitInt();
         if(class116.field1686[var3] == 0) {
            class116.field1686[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class286.field3796; ++var3) {
         int var4 = class286.field3791[var3];
         int var5 = class149.field2211[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class286.field3797[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var10 * var4 + var9] = var1.readByte();
               }
            }
         }
      }

   }
}
