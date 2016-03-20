import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("Buffer")
public class class118 extends class207 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1446645023
   )
   @Export("offset")
   public int field1979;
   @ObfuscatedName("a")
   @Export("payload")
   public byte[] field1980;
   @ObfuscatedName("f")
   static int[] field1981 = new int[256];
   @ObfuscatedName("y")
   static long[] field1982;
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = 444401945
   )
   static int field1984;
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -495652143
   )
   protected static int field1985;
   @ObfuscatedName("x")
   public static String field1986;
   @ObfuscatedName("hv")
   @ObfuscatedGetter(
      intValue = 1435262831
   )
   static int field1987;

   @ObfuscatedName("f")
   public void method2497(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)var1;
   }

   @ObfuscatedName("s")
   public void method2498(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1979 - 1] = (byte)var1;
   }

   @ObfuscatedName("y")
   public void method2499(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1979 - 1] = (byte)var1;
   }

   @ObfuscatedName("g")
   public void method2501(long var1) {
      this.field1980[++this.field1979 - 1] = (byte)((int)(var1 >> 40));
      this.field1980[++this.field1979 - 1] = (byte)((int)(var1 >> 32));
      this.field1980[++this.field1979 - 1] = (byte)((int)(var1 >> 24));
      this.field1980[++this.field1979 - 1] = (byte)((int)(var1 >> 16));
      this.field1980[++this.field1979 - 1] = (byte)((int)(var1 >> 8));
      this.field1980[++this.field1979 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("n")
   public void method2503(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1979 += class18.method215(var1, 0, var1.length(), this.field1980, this.field1979);
         this.field1980[++this.field1979 - 1] = 0;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-58853681"
   )
   public void method2504(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1980[++this.field1979 - 1] = 0;
         this.field1979 += class18.method215(var1, 0, var1.length(), this.field1980, this.field1979);
         this.field1980[++this.field1979 - 1] = 0;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "5993437"
   )
   public void method2505(CharSequence var1) {
      int var2 = class8.method130(var1);
      this.field1980[++this.field1979 - 1] = 0;
      this.method2550(var2);
      int var3 = this.field1979;
      byte[] var5 = this.field1980;
      int var6 = this.field1979;
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
      this.field1979 = var3 + var4;
   }

   @ObfuscatedName("ax")
   public void method2506(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.field1980[++this.field1979 - 1];
      }

   }

   @ObfuscatedName("v")
   public void method2507(int var1) {
      this.field1980[this.field1979 - var1 - 4] = (byte)(var1 >> 24);
      this.field1980[this.field1979 - var1 - 3] = (byte)(var1 >> 16);
      this.field1980[this.field1979 - var1 - 2] = (byte)(var1 >> 8);
      this.field1980[this.field1979 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("z")
   public void method2508(int var1) {
      this.field1980[this.field1979 - var1 - 2] = (byte)(var1 >> 8);
      this.field1980[this.field1979 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("u")
   public void method2509(int var1) {
      this.field1980[this.field1979 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "25"
   )
   public void method2510(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2497(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2498(var1 + '耀');
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("d")
   public int method2514() {
      this.field1979 += 2;
      return (this.field1980[this.field1979 - 1] & 255) + ((this.field1980[this.field1979 - 2] & 255) << 8);
   }

   @ObfuscatedName("p")
   public int method2515() {
      this.field1979 += 2;
      int var1 = ((this.field1980[this.field1979 - 2] & 255) << 8) + (this.field1980[this.field1979 - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("q")
   public int method2516() {
      this.field1979 += 3;
      return (this.field1980[this.field1979 - 1] & 255) + ((this.field1980[this.field1979 - 2] & 255) << 8) + ((this.field1980[this.field1979 - 3] & 255) << 16);
   }

   @ObfuscatedName("w")
   public int method2517() {
      this.field1979 += 4;
      return (this.field1980[this.field1979 - 1] & 255) + ((this.field1980[this.field1979 - 2] & 255) << 8) + ((this.field1980[this.field1979 - 4] & 255) << 24) + ((this.field1980[this.field1979 - 3] & 255) << 16);
   }

   @ObfuscatedName("k")
   public long method2518() {
      long var1 = (long)this.method2517() & 4294967295L;
      long var3 = (long)this.method2517() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("o")
   public String method2519() {
      if(0 == this.field1980[this.field1979]) {
         ++this.field1979;
         return null;
      } else {
         return this.method2520();
      }
   }

   @ObfuscatedName("ad")
   public String method2520() {
      int var1 = this.field1979;

      while(this.field1980[++this.field1979 - 1] != 0) {
         ;
      }

      int var2 = this.field1979 - var1 - 1;
      return 0 == var2?"":class47.method1009(this.field1980, var1, var2);
   }

   @ObfuscatedName("aw")
   public String method2522() {
      byte var1 = this.field1980[++this.field1979 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2617();
         if(this.field1979 + var2 > this.field1980.length) {
            throw new IllegalStateException("");
         } else {
            byte[] var4 = this.field1980;
            int var5 = this.field1979;
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
                  if(var8 + 1 < var9 && (var4[var8] & 192) == 128 && 128 == (var4[1 + var8] & 192)) {
                     var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 < 2048) {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else if(var10 < 248) {
                  if(var8 + 2 < var9 && (var4[var8] & 192) == 128 && 128 == (var4[var8 + 1] & 192) && 128 == (var4[2 + var8] & 192)) {
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
            this.field1979 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("ak")
   public int method2524() {
      int var1 = this.field1980[this.field1979] & 255;
      return var1 < 128?this.method2579() - 64:this.method2514() - '쀀';
   }

   @ObfuscatedName("ac")
   public int method2526() {
      return this.field1980[this.field1979] < 0?this.method2517() & Integer.MAX_VALUE:this.method2514();
   }

   @ObfuscatedName("ao")
   public void method2528(int[] var1) {
      int var2 = this.field1979 / 8;
      this.field1979 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2517();
         int var5 = this.method2517();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3]) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.field1979 -= 8;
         this.method2663(var4);
         this.method2663(var5);
      }

   }

   @ObfuscatedName("am")
   public void method2529(int[] var1) {
      int var2 = this.field1979 / 8;
      this.field1979 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2517();
         int var5 = this.method2517();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6) {
            var5 -= (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.field1979 -= 8;
         this.method2663(var4);
         this.method2663(var5);
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "566509657"
   )
   public void method2530(int[] var1, int var2, int var3) {
      int var4 = this.field1979;
      this.field1979 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2517();
         int var8 = this.method2517();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3]) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.field1979 -= 8;
         this.method2663(var7);
         this.method2663(var8);
      }

      this.field1979 = var4;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "1525613166"
   )
   public void method2531(int[] var1, int var2, int var3) {
      int var4 = this.field1979;
      this.field1979 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2517();
         int var8 = this.method2517();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.field1979 -= 8;
         this.method2663(var7);
         this.method2663(var8);
      }

      this.field1979 = var4;
   }

   @ObfuscatedName("aa")
   public boolean method2534() {
      this.field1979 -= 4;
      int var1 = class52.method1093(this.field1980, 0, this.field1979);
      int var2 = this.method2517();
      return var1 == var2;
   }

   @ObfuscatedName("ag")
   public void method2535(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("an")
   public void method2536(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("aj")
   public int method2538() {
      return this.field1980[++this.field1979 - 1] - 128 & 255;
   }

   @ObfuscatedName("af")
   public byte method2539() {
      return (byte)(0 - this.field1980[++this.field1979 - 1]);
   }

   @ObfuscatedName("aq")
   public int method2540() {
      return 128 - this.field1980[++this.field1979 - 1] & 255;
   }

   @ObfuscatedName("ay")
   public byte method2542() {
      return (byte)(128 - this.field1980[++this.field1979 - 1]);
   }

   @ObfuscatedName("az")
   public void method2544(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1979 - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("ae")
   public void method2545(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)(128 + var1);
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bd")
   public int method2546() {
      this.field1979 += 2;
      return (this.field1980[this.field1979 - 2] & 255) + ((this.field1980[this.field1979 - 1] & 255) << 8);
   }

   @ObfuscatedName("br")
   public int method2547() {
      this.field1979 += 2;
      return (this.field1980[this.field1979 - 1] - 128 & 255) + ((this.field1980[this.field1979 - 2] & 255) << 8);
   }

   @ObfuscatedName("bp")
   public int method2549() {
      this.field1979 += 2;
      int var1 = ((this.field1980[this.field1979 - 2] & 255) << 8) + (this.field1980[this.field1979 - 1] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1505473906"
   )
   public void method2550(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if(0 != (var1 & -268435456)) {
                  this.method2497(var1 >>> 28 | 128);
               }

               this.method2497(var1 >>> 21 | 128);
            }

            this.method2497(var1 >>> 14 | 128);
         }

         this.method2497(var1 >>> 7 | 128);
      }

      this.method2497(var1 & 127);
   }

   @ObfuscatedName("al")
   public void method2551(BigInteger var1, BigInteger var2) {
      int var3 = this.field1979;
      this.field1979 = 0;
      byte[] var4 = new byte[var3];
      this.method2506(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field1979 = 0;
      this.method2498(var7.length);
      this.method2699(var7, 0, var7.length);
   }

   @ObfuscatedName("by")
   public void method2552(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)var1;
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 24);
   }

   public class118(int var1) {
      this.field1980 = class120.method2745(var1);
      this.field1979 = 0;
   }

   @ObfuscatedName("bl")
   public int method2555() {
      this.field1979 += 4;
      return (this.field1980[this.field1979 - 3] & 255) + ((this.field1980[this.field1979 - 4] & 255) << 8) + ((this.field1980[this.field1979 - 2] & 255) << 24) + ((this.field1980[this.field1979 - 1] & 255) << 16);
   }

   @ObfuscatedName("bn")
   public int method2556() {
      this.field1979 += 4;
      return ((this.field1980[this.field1979 - 4] & 255) << 16) + ((this.field1980[this.field1979 - 3] & 255) << 24) + ((this.field1980[this.field1979 - 1] & 255) << 8) + (this.field1980[this.field1979 - 2] & 255);
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

         field1981[var1] = var0;
      }

      field1982 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field1982[var2] = var4;
      }

   }

   @ObfuscatedName("c")
   public int method2579() {
      return this.field1980[++this.field1979 - 1] & 255;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "101"
   )
   static void method2582(int var0, int var1, int var2, int var3) {
      class15 var4 = (class15)class15.field225.method3824((long)var0);
      if(null == var4) {
         var4 = new class15();
         class15.field225.method3831(var4, (long)var0);
      }

      if(var4.field215.length <= var1) {
         int[] var5 = new int[1 + var1];
         int[] var6 = new int[1 + var1];

         int var7;
         for(var7 = 0; var7 < var4.field215.length; ++var7) {
            var5[var7] = var4.field215[var7];
            var6[var7] = var4.field221[var7];
         }

         for(var7 = var4.field215.length; var7 < var1; ++var7) {
            var5[var7] = -1;
            var6[var7] = 0;
         }

         var4.field215 = var5;
         var4.field221 = var6;
      }

      var4.field215[var1] = var2;
      var4.field221[var1] = var3;
   }

   @ObfuscatedName("ar")
   public int method2600(int var1) {
      int var2 = class52.method1093(this.field1980, var1, this.field1979);
      this.method2663(var2);
      return var2;
   }

   @ObfuscatedName("at")
   public String method2609() {
      byte var1 = this.field1980[++this.field1979 - 1];
      if(0 != var1) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field1979;

         while(this.field1980[++this.field1979 - 1] != 0) {
            ;
         }

         int var3 = this.field1979 - var2 - 1;
         return var3 == 0?"":class47.method1009(this.field1980, var2, var3);
      }
   }

   @ObfuscatedName("as")
   public int method2617() {
      byte var1 = this.field1980[++this.field1979 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field1980[++this.field1979 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("ap")
   public int method2642() {
      return 0 - this.field1980[++this.field1979 - 1] & 255;
   }

   @ObfuscatedName("bs")
   public int method2645() {
      this.field1979 += 4;
      return ((this.field1980[this.field1979 - 1] & 255) << 24) + ((this.field1980[this.field1979 - 2] & 255) << 16) + ((this.field1980[this.field1979 - 3] & 255) << 8) + (this.field1980[this.field1979 - 4] & 255);
   }

   @ObfuscatedName("av")
   public void method2648(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("bu")
   public void method2652(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1979 - 1] = (byte)var1;
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 24);
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bq")
   public void method2657(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1979 - 1] = (byte)var1;
   }

   @ObfuscatedName("ah")
   public int method2659() {
      int var1 = this.field1980[this.field1979] & 255;
      return var1 < 128?this.method2579():this.method2514() - '耀';
   }

   @ObfuscatedName("e")
   public void method2663(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 24);
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1979 - 1] = (byte)var1;
   }

   @ObfuscatedName("au")
   public void method2666(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)var1;
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("m")
   public void method2670(long var1) {
      this.field1980[++this.field1979 - 1] = (byte)((int)(var1 >> 56));
      this.field1980[++this.field1979 - 1] = (byte)((int)(var1 >> 48));
      this.field1980[++this.field1979 - 1] = (byte)((int)(var1 >> 40));
      this.field1980[++this.field1979 - 1] = (byte)((int)(var1 >> 32));
      this.field1980[++this.field1979 - 1] = (byte)((int)(var1 >> 24));
      this.field1980[++this.field1979 - 1] = (byte)((int)(var1 >> 16));
      this.field1980[++this.field1979 - 1] = (byte)((int)(var1 >> 8));
      this.field1980[++this.field1979 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("bo")
   public void method2673(int var1) {
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 24);
      this.field1980[++this.field1979 - 1] = (byte)var1;
      this.field1980[++this.field1979 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bv")
   public int method2678() {
      this.field1979 += 3;
      return ((this.field1980[this.field1979 - 1] & 255) << 8) + ((this.field1980[this.field1979 - 3] & 255) << 16) + (this.field1980[this.field1979 - 2] & 255);
   }

   public class118(byte[] var1) {
      this.field1980 = var1;
      this.field1979 = 0;
   }

   @ObfuscatedName("bt")
   public int method2690() {
      this.field1979 += 2;
      return ((this.field1980[this.field1979 - 1] & 255) << 8) + (this.field1980[this.field1979 - 2] - 128 & 255);
   }

   @ObfuscatedName("i")
   public void method2699(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.field1980[++this.field1979 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("x")
   public byte method2707() {
      return this.field1980[++this.field1979 - 1];
   }
}
