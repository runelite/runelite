import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("Buffer")
public class class119 extends class208 {
   @ObfuscatedName("d")
   static int[] field1991 = new int[256];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 451685423
   )
   @Export("offset")
   public int field1992;
   @ObfuscatedName("a")
   @Export("payload")
   public byte[] field1993;
   @ObfuscatedName("y")
   static long[] field1997;

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-62"
   )
   public int method2597() {
      this.field1992 += 2;
      return ((this.field1993[this.field1992 - 2] & 255) << 8) + (this.field1993[this.field1992 - 1] - 128 & 255);
   }

   public class119(byte[] var1) {
      this.field1993 = var1;
      this.field1992 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1856256707"
   )
   public void method2599(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 8);
      this.field1993[++this.field1992 - 1] = (byte)var1;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-1868950842"
   )
   public void method2602(int[] var1, int var2, int var3) {
      int var4 = this.field1992;
      this.field1992 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2618();
         int var8 = this.method2618();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ var9 + var1[var9 >>> 11 & 3]) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.field1992 -= 8;
         this.method2786(var7);
         this.method2786(var8);
      }

      this.field1992 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "491130799"
   )
   public void method2603(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1419290571"
   )
   public int method2604(int var1) {
      int var2 = class6.method119(this.field1993, var1, this.field1992);
      this.method2786(var2);
      return var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "16777215"
   )
   public void method2605(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1993[++this.field1992 - 1] = 0;
         this.field1992 += class176.method3533(var1, 0, var1.length(), this.field1993, this.field1992);
         this.field1993[++this.field1992 - 1] = 0;
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-109845518"
   )
   public void method2606(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 8);
      this.field1993[++this.field1992 - 1] = (byte)var1;
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 24);
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "0"
   )
   public void method2607(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.field1993[++this.field1992 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1928938127"
   )
   public void method2609(int var1) {
      if(0 != (var1 & -128)) {
         if((var1 & -16384) != 0) {
            if(0 != (var1 & -2097152)) {
               if(0 != (var1 & -268435456)) {
                  this.method2603(var1 >>> 28 | 128);
               }

               this.method2603(var1 >>> 21 | 128);
            }

            this.method2603(var1 >>> 14 | 128);
         }

         this.method2603(var1 >>> 7 | 128);
      }

      this.method2603(var1 & 127);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-109"
   )
   public void method2610(int var1) {
      this.field1993[this.field1992 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "23"
   )
   public int method2613() {
      return this.field1993[++this.field1992 - 1] & 255;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-30"
   )
   public int method2615() {
      this.field1992 += 2;
      return ((this.field1993[this.field1992 - 2] & 255) << 8) + (this.field1993[this.field1992 - 1] & 255);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1379375878"
   )
   public int method2617() {
      this.field1992 += 3;
      return (this.field1993[this.field1992 - 1] & 255) + ((this.field1993[this.field1992 - 2] & 255) << 8) + ((this.field1993[this.field1992 - 3] & 255) << 16);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-680229014"
   )
   public int method2618() {
      this.field1992 += 4;
      return (this.field1993[this.field1992 - 1] & 255) + ((this.field1993[this.field1992 - 3] & 255) << 16) + ((this.field1993[this.field1992 - 4] & 255) << 24) + ((this.field1993[this.field1992 - 2] & 255) << 8);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2042312111"
   )
   public long method2619() {
      long var1 = (long)this.method2618() & 4294967295L;
      long var3 = (long)this.method2618() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1394082917"
   )
   public String method2621() {
      int var1 = this.field1992;

      while(this.field1993[++this.field1992 - 1] != 0) {
         ;
      }

      int var2 = this.field1992 - var1 - 1;
      return 0 == var2?"":class47.method1084(this.field1993, var1, var2);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "128"
   )
   public String method2622() {
      byte var1 = this.field1993[++this.field1992 - 1];
      if(0 != var1) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field1992;

         while(this.field1993[++this.field1992 - 1] != 0) {
            ;
         }

         int var3 = this.field1992 - var2 - 1;
         return 0 == var3?"":class47.method1084(this.field1993, var2, var3);
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "82"
   )
   public String method2623() {
      byte var1 = this.field1993[++this.field1992 - 1];
      if(0 != var1) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2628();
         if(var2 + this.field1992 > this.field1993.length) {
            throw new IllegalStateException("");
         } else {
            byte[] var4 = this.field1993;
            int var5 = this.field1992;
            char[] var6 = new char[var2];
            int var7 = 0;
            int var8 = var5;

            int var11;
            for(int var9 = var5 + var2; var8 < var9; var6[var7++] = (char)var11) {
               int var10 = var4[var8++] & 255;
               if(var10 < 128) {
                  if(0 == var10) {
                     var11 = '�';
                  } else {
                     var11 = var10;
                  }
               } else if(var10 < 192) {
                  var11 = '�';
               } else if(var10 < 224) {
                  if(var8 < var9 && 128 == (var4[var8] & 192)) {
                     var11 = (var10 & 31) << 6 | var4[var8++] & 63;
                     if(var11 < 128) {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else if(var10 < 240) {
                  if(1 + var8 < var9 && 128 == (var4[var8] & 192) && (var4[1 + var8] & 192) == 128) {
                     var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 < 2048) {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else if(var10 < 248) {
                  if(2 + var8 < var9 && 128 == (var4[var8] & 192) && 128 == (var4[1 + var8] & 192) && (var4[var8 + 2] & 192) == 128) {
                     var11 = (var10 & 7) << 18 | (var4[var8++] & 63) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 >= 65536 && var11 <= 1114111) {
                        var11 = '�';
                     } else {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else {
                  var11 = '�';
               }
            }

            String var3 = new String(var6, 0, var7);
            this.field1992 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1698131780"
   )
   public int method2628() {
      byte var1 = this.field1993[++this.field1992 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field1993[++this.field1992 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "346783773"
   )
   public int method2631() {
      this.field1992 += 2;
      return ((this.field1993[this.field1992 - 1] & 255) << 8) + (this.field1993[this.field1992 - 2] & 255);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "1005636687"
   )
   public void method2633(BigInteger var1, BigInteger var2) {
      int var3 = this.field1992;
      this.field1992 = 0;
      byte[] var4 = new byte[var3];
      this.method2740(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field1992 = 0;
      this.method2599(var7.length);
      this.method2607(var7, 0, var7.length);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "74"
   )
   public void method2634(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)var1;
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-686603399"
   )
   public boolean method2635() {
      this.field1992 -= 4;
      byte[] var2 = this.field1993;
      int var3 = this.field1992;
      int var4 = -1;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4 = var4 >>> 8 ^ field1991[(var4 ^ var2[var5]) & 255];
      }

      var4 = ~var4;
      var5 = this.method2618();
      return var5 == var4;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   public void method2637(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "32"
   )
   public void method2638(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1817416057"
   )
   public int method2639() {
      return this.field1993[++this.field1992 - 1] - 128 & 255;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-22"
   )
   public int method2640() {
      return 0 - this.field1993[++this.field1992 - 1] & 255;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-225716682"
   )
   public int method2641() {
      return 128 - this.field1993[++this.field1992 - 1] & 255;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "876067924"
   )
   public int method2642() {
      int var1 = this.field1993[this.field1992] & 255;
      return var1 < 128?this.method2613() - 64:this.method2615() - '쀀';
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "14"
   )
   public byte method2643() {
      return (byte)(128 - this.field1993[++this.field1992 - 1]);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "5"
   )
   public void method2644(int[] var1, int var2, int var3) {
      int var4 = this.field1992;
      this.field1992 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2618();
         int var8 = this.method2618();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.field1992 -= 8;
         this.method2786(var7);
         this.method2786(var8);
      }

      this.field1992 = var4;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-907598548"
   )
   public void method2645(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 8);
      this.field1993[++this.field1992 - 1] = (byte)(128 + var1);
   }

   public class119(int var1) {
      this.field1993 = class121.method2857(var1);
      this.field1992 = 0;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-48"
   )
   public int method2648() {
      this.field1992 += 2;
      return ((this.field1993[this.field1992 - 1] & 255) << 8) + (this.field1993[this.field1992 - 2] - 128 & 255);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1783292152"
   )
   public int method2649() {
      this.field1992 += 2;
      int var1 = (this.field1993[this.field1992 - 2] & 255) + ((this.field1993[this.field1992 - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1561335474"
   )
   public int method2650() {
      this.field1992 += 2;
      int var1 = ((this.field1993[this.field1992 - 2] & 255) << 8) + (this.field1993[this.field1992 - 1] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1271957951"
   )
   public void method2651(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 16);
      this.field1993[++this.field1992 - 1] = (byte)var1;
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1228900646"
   )
   public void method2653(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)var1;
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 8);
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 16);
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "5"
   )
   public void method2654(int[] var1) {
      int var2 = this.field1992 / 8;
      this.field1992 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2618();
         int var5 = this.method2618();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) {
            var5 -= (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.field1992 -= 8;
         this.method2786(var4);
         this.method2786(var5);
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2145383212"
   )
   public void method2655(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 16);
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 24);
      this.field1993[++this.field1992 - 1] = (byte)var1;
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "104"
   )
   public int method2656() {
      this.field1992 += 4;
      return ((this.field1993[this.field1992 - 3] & 255) << 8) + ((this.field1993[this.field1992 - 1] & 255) << 24) + ((this.field1993[this.field1992 - 2] & 255) << 16) + (this.field1993[this.field1992 - 4] & 255);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1498971315"
   )
   public int method2657() {
      this.field1992 += 4;
      return ((this.field1993[this.field1992 - 2] & 255) << 24) + ((this.field1993[this.field1992 - 1] & 255) << 16) + ((this.field1993[this.field1992 - 4] & 255) << 8) + (this.field1993[this.field1992 - 3] & 255);
   }

   static {
      int var2;
      for(int var1 = 0; var1 < 256; ++var1) {
         int var0 = var1;

         for(var2 = 0; var2 < 8; ++var2) {
            if(1 == (var0 & 1)) {
               var0 = var0 >>> 1 ^ -306674912;
            } else {
               var0 >>>= 1;
            }
         }

         field1991[var1] = var0;
      }

      field1997 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field1997[var2] = var4;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1434824168"
   )
   public int method2664() {
      this.field1992 += 2;
      int var1 = ((this.field1993[this.field1992 - 2] & 255) << 8) + (this.field1993[this.field1992 - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "13"
   )
   public void method2675(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 16);
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 8);
      this.field1993[++this.field1992 - 1] = (byte)var1;
   }

   @ObfuscatedName("r")
   public void method2685(long var1) {
      this.field1993[++this.field1992 - 1] = (byte)((int)(var1 >> 40));
      this.field1993[++this.field1992 - 1] = (byte)((int)(var1 >> 32));
      this.field1993[++this.field1992 - 1] = (byte)((int)(var1 >> 24));
      this.field1993[++this.field1992 - 1] = (byte)((int)(var1 >> 16));
      this.field1993[++this.field1992 - 1] = (byte)((int)(var1 >> 8));
      this.field1993[++this.field1992 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-15"
   )
   public void method2694(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1992 += class176.method3533(var1, 0, var1.length(), this.field1993, this.field1992);
         this.field1993[++this.field1992 - 1] = 0;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "997092394"
   )
   public byte method2699() {
      return this.field1993[++this.field1992 - 1];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "26"
   )
   public String method2701() {
      if(0 == this.field1993[this.field1992]) {
         ++this.field1992;
         return null;
      } else {
         return this.method2621();
      }
   }

   @ObfuscatedName("p")
   public void method2716(long var1) {
      this.field1993[++this.field1992 - 1] = (byte)((int)(var1 >> 56));
      this.field1993[++this.field1992 - 1] = (byte)((int)(var1 >> 48));
      this.field1993[++this.field1992 - 1] = (byte)((int)(var1 >> 40));
      this.field1993[++this.field1992 - 1] = (byte)((int)(var1 >> 32));
      this.field1993[++this.field1992 - 1] = (byte)((int)(var1 >> 24));
      this.field1993[++this.field1992 - 1] = (byte)((int)(var1 >> 16));
      this.field1993[++this.field1992 - 1] = (byte)((int)(var1 >> 8));
      this.field1993[++this.field1992 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "969960142"
   )
   public void method2717(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2603(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2599('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1586563238"
   )
   public int method2734() {
      return this.field1993[this.field1992] < 0?this.method2618() & Integer.MAX_VALUE:this.method2615();
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "0"
   )
   public void method2740(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.field1993[++this.field1992 - 1];
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-28"
   )
   public void method2743(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1706496327"
   )
   public void method2745(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)(128 + var1);
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "86"
   )
   public int method2746() {
      this.field1992 += 4;
      return ((this.field1993[this.field1992 - 1] & 255) << 8) + ((this.field1993[this.field1992 - 4] & 255) << 16) + ((this.field1993[this.field1992 - 3] & 255) << 24) + (this.field1993[this.field1992 - 2] & 255);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-742064097"
   )
   public int method2752() {
      this.field1992 += 3;
      return ((this.field1993[this.field1992 - 3] & 255) << 8) + ((this.field1993[this.field1992 - 2] & 255) << 16) + (this.field1993[this.field1992 - 1] & 255);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-47"
   )
   public void method2786(int var1) {
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 24);
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 16);
      this.field1993[++this.field1992 - 1] = (byte)(var1 >> 8);
      this.field1993[++this.field1992 - 1] = (byte)var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1422035883"
   )
   public byte method2791() {
      return (byte)(this.field1993[++this.field1992 - 1] - 128);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "399905200"
   )
   public void method2793(CharSequence var1) {
      int var2 = class163.method3321(var1);
      this.field1993[++this.field1992 - 1] = 0;
      this.method2609(var2);
      this.field1992 += class28.method730(this.field1993, this.field1992, var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1082371478"
   )
   public void method2805(int var1) {
      this.field1993[this.field1992 - var1 - 4] = (byte)(var1 >> 24);
      this.field1993[this.field1992 - var1 - 3] = (byte)(var1 >> 16);
      this.field1993[this.field1992 - var1 - 2] = (byte)(var1 >> 8);
      this.field1993[this.field1992 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-586303342"
   )
   public void method2806(int[] var1) {
      int var2 = this.field1992 / 8;
      this.field1992 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2618();
         int var5 = this.method2618();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.field1992 -= 8;
         this.method2786(var4);
         this.method2786(var5);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-629855749"
   )
   public void method2811(int var1) {
      this.field1993[this.field1992 - var1 - 2] = (byte)(var1 >> 8);
      this.field1993[this.field1992 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-22"
   )
   public int method2812() {
      int var1 = this.field1993[this.field1992] & 255;
      return var1 < 128?this.method2613():this.method2615() - '耀';
   }
}
