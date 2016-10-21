import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1802292467
   )
   @Export("offset")
   public int offset;
   @ObfuscatedName("f")
   @Export("payload")
   public byte[] payload;
   @ObfuscatedName("v")
   static long[] field2053;
   @ObfuscatedName("n")
   public static int[] field2055 = new int[256];

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-530895743"
   )
   public void method2516(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1664656145"
   )
   public String method2517() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.payload[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":class14.method164(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-946259064"
   )
   public void method2518(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1014484335"
   )
   public void method2519(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "27"
   )
   public void method2520(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1207691922"
   )
   public void method2521(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("v")
   public void method2522(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("b")
   public void method2523(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 56));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 48));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-89"
   )
   public void method2524(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += class5.method78(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "69"
   )
   public void method2525(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += class5.method78(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIIS)V",
      garbageValue = "2047"
   )
   public void method2527(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-47"
   )
   public void method2529(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-789828720"
   )
   public void method2530(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1620126909"
   )
   public void method2532(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2518(var1 >>> 28 | 128);
               }

               this.method2518(var1 >>> 21 | 128);
            }

            this.method2518(var1 >>> 14 | 128);
         }

         this.method2518(var1 >>> 7 | 128);
      }

      this.method2518(var1 & 127);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1144341900"
   )
   public byte method2534() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "821546999"
   )
   public int method2535() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public int method2537() {
      this.offset += 3;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 3] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1720340705"
   )
   public int method2538() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 16) + ((this.payload[this.offset - 4] & 255) << 24) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-3"
   )
   public long method2539() {
      long var1 = (long)this.method2538() & 4294967295L;
      long var3 = (long)this.method2538() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1607488535"
   )
   public String method2540() {
      if(this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.method2541();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-2018027714"
   )
   public String method2541() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":class14.method164(this.payload, var1, var2);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "2051106737"
   )
   public void method2545(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2538();
         int var8 = this.method2538();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.offset -= 8;
         this.method2521(var7);
         this.method2521(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-12"
   )
   public int method2546() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.method2656():this.method2535() - '耀';
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-638208745"
   )
   public int method2547() {
      return this.payload[this.offset] < 0?this.method2538() & Integer.MAX_VALUE:this.method2535();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-119669955"
   )
   public int method2549() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.method2656() - 64:this.method2535() - '쀀';
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1851507953"
   )
   public void method2550(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2538();
         int var5 = this.method2538();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.offset -= 8;
         this.method2521(var4);
         this.method2521(var5);
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1566917720"
   )
   public void method2551(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2538();
         int var5 = this.method2538();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var6 + var1[var6 & 3]) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.offset -= 8;
         this.method2521(var4);
         this.method2521(var5);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "8"
   )
   public void method2552(CharSequence var1) {
      int var2 = class0.method3(var1);
      this.payload[++this.offset - 1] = 0;
      this.method2532(var2);
      int var3 = this.offset;
      byte[] var5 = this.payload;
      int var6 = this.offset;
      int var7 = var1.length();
      int var8 = var6;

      for(int var9 = 0; var9 < var7; ++var9) {
         char var10 = var1.charAt(var9);
         if(var10 <= 127) {
            var5[var8++] = (byte)var10;
         } else if(var10 <= 2047) {
            var5[var8++] = (byte)(192 | var10 >> 6);
            var5[var8++] = (byte)(128 | var10 & 63);
         } else {
            var5[var8++] = (byte)(224 | var10 >> 12);
            var5[var8++] = (byte)(128 | var10 >> 6 & 63);
            var5[var8++] = (byte)(128 | var10 & 63);
         }
      }

      int var4 = var8 - var6;
      this.offset = var4 + var3;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "58"
   )
   public void method2553(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2538();
         int var8 = this.method2538();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.offset -= 8;
         this.method2521(var7);
         this.method2521(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;B)V",
      garbageValue = "67"
   )
   public void method2554(BigInteger var1, BigInteger var2) {
      int var3 = this.offset;
      this.offset = 0;
      byte[] var4 = new byte[var3];
      this.method2698(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.offset = 0;
      this.method2519(var7.length);
      this.method2527(var7, 0, var7.length);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-918896071"
   )
   public int method2555(int var1) {
      byte[] var3 = this.payload;
      int var4 = this.offset;
      int var5 = -1;

      for(int var6 = var1; var6 < var4; ++var6) {
         var5 = var5 >>> 8 ^ field2055[(var5 ^ var3[var6]) & 255];
      }

      var5 = ~var5;
      this.method2521(var5);
      return var5;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-218735677"
   )
   public boolean method2556() {
      this.offset -= 4;
      byte[] var2 = this.payload;
      int var3 = this.offset;
      int var4 = -1;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4 = var4 >>> 8 ^ field2055[(var4 ^ var2[var5]) & 255];
      }

      var4 = ~var4;
      var5 = this.method2538();
      return var5 == var4;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2071690164"
   )
   public void method2557(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-61"
   )
   public void method2558(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1872279464"
   )
   public void method2559(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-189089936"
   )
   public int method2561() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1887212525"
   )
   public int method2562() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-2147038821"
   )
   public byte method2564() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "16777215"
   )
   public int method2565() {
      this.offset += 4;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 3] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "72"
   )
   public void method2567(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1357715039"
   )
   public int method2568() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "3"
   )
   public int method2569() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] - 128 & 255);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-807667263"
   )
   public int method2570() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "15"
   )
   public void method2572(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "482147835"
   )
   public void method2574(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "39"
   )
   public void method2575(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2065386234"
   )
   public void method2576(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "770258967"
   )
   public int method2577() {
      this.offset += 4;
      return ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 1] & 255) << 24) + ((this.payload[this.offset - 2] & 255) << 16) + (this.payload[this.offset - 4] & 255);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "718675308"
   )
   public int method2578() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 4] & 255) << 8) + (this.payload[this.offset - 3] & 255);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-699468165"
   )
   public int method2579() {
      this.offset += 3;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 8);
   }

   static {
      int var2;
      for(int var1 = 0; var1 < 256; ++var1) {
         int var0 = var1;

         for(var2 = 0; var2 < 8; ++var2) {
            if((var0 & 1) == 1) {
               var0 = var0 >>> 1 ^ -306674912;
            } else {
               var0 >>>= 1;
            }
         }

         field2055[var1] = var0;
      }

      field2053 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2053[var2] = var4;
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-36"
   )
   public String method2612() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2696();
         if(this.offset + var2 > this.payload.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = class169.method3274(this.payload, this.offset, var2);
            this.offset += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-77"
   )
   public void method2627(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "43"
   )
   public int method2633() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-195086724"
   )
   public int method2636() {
      if(this.payload[this.offset] < 0) {
         return this.method2538() & Integer.MAX_VALUE;
      } else {
         int var1 = this.method2535();
         return var1 == 32767?-1:var1;
      }
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "461211091"
   )
   public void method2646(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1898217638"
   )
   public int method2650() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1786270629"
   )
   public int method2656() {
      return this.payload[++this.offset - 1] & 255;
   }

   public Buffer(int var1) {
      this.payload = class124.method2763(var1);
      this.offset = 0;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "75"
   )
   public int method2677() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public int method2696() {
      byte var1 = this.payload[++this.offset - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.payload[++this.offset - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-11"
   )
   public void method2698(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "12385"
   )
   public void method2712(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2518(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2519('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-265018058"
   )
   public byte method2726() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }
}
