import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
@Implements("ISAACCipher")
public final class ISAACCipher {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -971642805
   )
   @Export("valuesRemaining")
   int valuesRemaining;
   @ObfuscatedName("x")
   @Export("randResult")
   int[] randResult;
   @ObfuscatedName("f")
   @Export("mm")
   int[] mm;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -945229833
   )
   int field2522;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 57900857
   )
   int field2523;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -690481905
   )
   int field2519;

   public ISAACCipher(int[] var1) {
      this.mm = new int[256];
      this.randResult = new int[256];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.randResult[var2] = var1[var2];
      }

      this.method3485();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-836488324"
   )
   @Export("nextInt")
   final int nextInt() {
      if(0 == --this.valuesRemaining + 1) {
         this.generateMoreResults();
         this.valuesRemaining = 255;
      }

      return this.randResult[this.valuesRemaining];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   final int method3496() {
      if(this.valuesRemaining == 0) {
         this.generateMoreResults();
         this.valuesRemaining = 256;
      }

      return this.randResult[this.valuesRemaining - 1];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   @Export("generateMoreResults")
   final void generateMoreResults() {
      this.field2523 += ++this.field2519;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.mm[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2522 ^= this.field2522 << 13;
            } else {
               this.field2522 ^= this.field2522 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2522 ^= this.field2522 << 2;
         } else {
            this.field2522 ^= this.field2522 >>> 16;
         }

         this.field2522 += this.mm[128 + var1 & 255];
         int var3;
         this.mm[var1] = var3 = this.mm[(var2 & 1020) >> 2] + this.field2522 + this.field2523;
         this.randResult[var1] = this.field2523 = this.mm[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "72"
   )
   final void method3485() {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;Ljava/lang/String;B)I",
      garbageValue = "-26"
   )
   public static int method3499(Buffer var0, String var1) {
      int var2 = var0.offset;
      int var4 = var1.length();
      byte[] var5 = new byte[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
               var5[var6] = -128;
            } else if(var7 == 8218) {
               var5[var6] = -126;
            } else if(var7 == 402) {
               var5[var6] = -125;
            } else if(var7 == 8222) {
               var5[var6] = -124;
            } else if(var7 == 8230) {
               var5[var6] = -123;
            } else if(var7 == 8224) {
               var5[var6] = -122;
            } else if(var7 == 8225) {
               var5[var6] = -121;
            } else if(var7 == 710) {
               var5[var6] = -120;
            } else if(var7 == 8240) {
               var5[var6] = -119;
            } else if(var7 == 352) {
               var5[var6] = -118;
            } else if(var7 == 8249) {
               var5[var6] = -117;
            } else if(var7 == 338) {
               var5[var6] = -116;
            } else if(var7 == 381) {
               var5[var6] = -114;
            } else if(var7 == 8216) {
               var5[var6] = -111;
            } else if(var7 == 8217) {
               var5[var6] = -110;
            } else if(var7 == 8220) {
               var5[var6] = -109;
            } else if(var7 == 8221) {
               var5[var6] = -108;
            } else if(var7 == 8226) {
               var5[var6] = -107;
            } else if(var7 == 8211) {
               var5[var6] = -106;
            } else if(var7 == 8212) {
               var5[var6] = -105;
            } else if(var7 == 732) {
               var5[var6] = -104;
            } else if(var7 == 8482) {
               var5[var6] = -103;
            } else if(var7 == 353) {
               var5[var6] = -102;
            } else if(var7 == 8250) {
               var5[var6] = -101;
            } else if(var7 == 339) {
               var5[var6] = -100;
            } else if(var7 == 382) {
               var5[var6] = -98;
            } else if(var7 == 376) {
               var5[var6] = -97;
            } else {
               var5[var6] = 63;
            }
         } else {
            var5[var6] = (byte)var7;
         }
      }

      var0.putShortSmart(var5.length);
      var0.offset += class272.field3707.compress(var5, 0, var5.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }
}
