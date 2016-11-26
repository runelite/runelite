import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fa")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1528452943
   )
   @Export("offset")
   public int offset;
   @ObfuscatedName("m")
   public static int[] field2285 = new int[256];
   @ObfuscatedName("w")
   static long[] field2286;
   @ObfuscatedName("l")
   public static class144 field2288;
   @ObfuscatedName("n")
   @Export("payload")
   public byte[] payload;

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method2975(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1723808055"
   )
   public void method2976(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-45"
   )
   public void method2977(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1855384452"
   )
   public void method2978(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "-118"
   )
   public void method2979(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2995();
         int var8 = this.method2995();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.offset -= 8;
         this.method2978(var7);
         this.method2978(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("r")
   public void method2980(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 56));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 48));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1494969454"
   )
   public void method2981(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += class34.method723(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "971836713"
   )
   public void method2982(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += class34.method723(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "1"
   )
   public void method2983(CharSequence var1) {
      int var2 = class39.method771(var1);
      this.payload[++this.offset - 1] = 0;
      this.method2989(var2);
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "10"
   )
   public void method2984(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1821310518"
   )
   public void method2985(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "444178426"
   )
   public void method2986(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "86"
   )
   public void method2988(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2975(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2976('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1450973791"
   )
   public void method2989(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2975(var1 >>> 28 | 128);
               }

               this.method2975(var1 >>> 21 | 128);
            }

            this.method2975(var1 >>> 14 | 128);
         }

         this.method2975(var1 >>> 7 | 128);
      }

      this.method2975(var1 & 127);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1100917009"
   )
   public void method2990(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-871299774"
   )
   public int method2993() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-113737427"
   )
   @Export("read24BitInt")
   public int read24BitInt() {
      this.offset += 3;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 3] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "3"
   )
   public int method2995() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 16) + ((this.payload[this.offset - 4] & 255) << 24) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-1"
   )
   public String method2999() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.payload[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":VertexNormal.method1664(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1922239996"
   )
   public String method3000() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method3142();
         if(this.offset + var2 > this.payload.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = class94.method1949(this.payload, this.offset, var2);
            this.offset += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1544129294"
   )
   public int method3002() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - '쀀';
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1069402072"
   )
   public int method3003() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte():this.readUnsignedShort() - '耀';
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1275163599"
   )
   public int method3004() {
      return this.payload[this.offset] < 0?this.method2995() & Integer.MAX_VALUE:this.readUnsignedShort();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "738669790"
   )
   public int method3005() {
      if(this.payload[this.offset] < 0) {
         return this.method2995() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1294631884"
   )
   public void method3007(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2995();
         int var5 = this.method2995();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.offset -= 8;
         this.method2978(var4);
         this.method2978(var5);
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-167970669"
   )
   public void method3008(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2995();
         int var5 = this.method2995();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.offset -= 8;
         this.method2978(var4);
         this.method2978(var5);
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "468161851"
   )
   public void method3009(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2995();
         int var8 = this.method2995();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.offset -= 8;
         this.method2978(var7);
         this.method2978(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1091488724"
   )
   public void method3011(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-845606526"
   )
   public int method3012(int var1) {
      byte[] var3 = this.payload;
      int var4 = this.offset;
      int var5 = -1;

      for(int var6 = var1; var6 < var4; ++var6) {
         var5 = var5 >>> 8 ^ field2285[(var5 ^ var3[var6]) & 255];
      }

      var5 = ~var5;
      this.method2978(var5);
      return var5;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1044148972"
   )
   public boolean method3013() {
      this.offset -= 4;
      byte[] var2 = this.payload;
      int var3 = this.offset;
      int var4 = -1;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4 = var4 >>> 8 ^ field2285[(var4 ^ var2[var5]) & 255];
      }

      var4 = ~var4;
      var5 = this.method2995();
      return var5 == var4;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "21"
   )
   public int method3017() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "382328640"
   )
   public int method3018() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-35787607"
   )
   public int method3019() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-421384490"
   )
   public byte method3020() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   public void method3022(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2120647195"
   )
   public void method3023(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2126001378"
   )
   public int method3025() {
      this.offset += 2;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "924421159"
   )
   public int method3026() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] - 128 & 255);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "33103520"
   )
   public int method3028() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1316705998"
   )
   public int method3029() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-13"
   )
   public void method3030(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public int method3031() {
      this.offset += 3;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "46"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1892450412"
   )
   public void method3034(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "325"
   )
   public int method3036() {
      this.offset += 4;
      return (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-144261659"
   )
   public int method3037() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 16) + (this.payload[this.offset - 2] & 255);
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

         field2285[var1] = var0;
      }

      field2286 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2286[var2] = var4;
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-98"
   )
   public void method3043(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1819338116"
   )
   public byte method3047() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "1498042150"
   )
   public void method3056(BigInteger var1, BigInteger var2) {
      int var3 = this.offset;
      this.offset = 0;
      byte[] var4 = new byte[var3];
      this.method3043(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.offset = 0;
      this.method2976(var7.length);
      this.method2984(var7, 0, var7.length);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "57"
   )
   public String method3057() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":VertexNormal.method1664(this.payload, var1, var2);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "677648473"
   )
   public int method3067() {
      this.offset += 4;
      return ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24) + (this.payload[this.offset - 4] & 255);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1898458943"
   )
   public String method3094() {
      if(this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.method3057();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "117"
   )
   @Export("readUnsignedShort")
   public int readUnsignedShort() {
      this.offset += 2;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-64"
   )
   public void method3098(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "14"
   )
   public byte method3106() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1612136132"
   )
   public long method3118() {
      long var1 = (long)this.method2995() & 4294967295L;
      long var3 = (long)this.method2995() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-382649925"
   )
   public void method3124(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method3127(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "866170801"
   )
   public int method3142() {
      byte var1 = this.payload[++this.offset - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.payload[++this.offset - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   public Buffer(int var1) {
      this.payload = class161.method3187(var1);
      this.offset = 0;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1013227856"
   )
   public int method3153() {
      this.offset += 2;
      return (this.payload[this.offset - 2] - 128 & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("w")
   public void method3164(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-61"
   )
   public void method3173(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2098490071"
   )
   public void method3183(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 + var1);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }
}
