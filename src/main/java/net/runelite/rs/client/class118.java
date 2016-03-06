package net.runelite.rs.client;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dc")
@Implements("Buffer")
public class class118 extends class207 {
   @ObfuscatedName("f")
   static long[] field1991;
   @ObfuscatedName("a")
   static int[] field1993 = new int[256];
   @ObfuscatedName("j")
   @Export("payload")
   public byte[] field1995;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1800101407
   )
   @Export("offset")
   public int field1998;

   @ObfuscatedName("l")
   public void method2438(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)var1;
   }

   @ObfuscatedName("aj")
   public void method2440(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)(var1 + 128);
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("f")
   public void method2441(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 24);
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 16);
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field1995[++this.field1998 - 1] = (byte)var1;
   }

   @ObfuscatedName("m")
   public void method2442(long var1) {
      this.field1995[++this.field1998 - 1] = (byte)((int)(var1 >> 40));
      this.field1995[++this.field1998 - 1] = (byte)((int)(var1 >> 32));
      this.field1995[++this.field1998 - 1] = (byte)((int)(var1 >> 24));
      this.field1995[++this.field1998 - 1] = (byte)((int)(var1 >> 16));
      this.field1995[++this.field1998 - 1] = (byte)((int)(var1 >> 8));
      this.field1995[++this.field1998 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("ak")
   public String method2443() {
      byte var1 = this.field1995[++this.field1998 - 1];
      if(0 != var1) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field1998;

         while(this.field1995[++this.field1998 - 1] != 0) {
            ;
         }

         int var3 = this.field1998 - var2 - 1;
         return 0 == var3?"":class40.method798(this.field1995, var2, var3);
      }
   }

   @ObfuscatedName("n")
   public void method2444(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1998 += class155.method3117(var1, 0, var1.length(), this.field1995, this.field1998);
         this.field1995[++this.field1998 - 1] = 0;
      }
   }

   @ObfuscatedName("as")
   public void method2445(int[] var1, int var2, int var3) {
      int var4 = this.field1998;
      this.field1998 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2458();
         int var8 = this.method2458();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.field1998 -= 8;
         this.method2441(var7);
         this.method2441(var8);
      }

      this.field1998 = var4;
   }

   @ObfuscatedName("b")
   public void method2446(CharSequence var1) {
      int var3 = var1.length();
      int var4 = 0;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var1.charAt(var5);
         if(var6 <= 127) {
            ++var4;
         } else if(var6 <= 2047) {
            var4 += 2;
         } else {
            var4 += 3;
         }
      }

      this.field1995[++this.field1998 - 1] = 0;
      this.method2452(var4);
      this.field1998 += class157.method3119(this.field1995, this.field1998, var1);
   }

   @ObfuscatedName("q")
   public void method2447(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.field1995[++this.field1998 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("u")
   public void method2448(int var1) {
      this.field1995[this.field1998 - var1 - 4] = (byte)(var1 >> 24);
      this.field1995[this.field1998 - var1 - 3] = (byte)(var1 >> 16);
      this.field1995[this.field1998 - var1 - 2] = (byte)(var1 >> 8);
      this.field1995[this.field1998 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("y")
   public void method2450(int var1) {
      this.field1995[this.field1998 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("d")
   public void method2452(int var1) {
      if(0 != (var1 & -128)) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if(0 != (var1 & -268435456)) {
                  this.method2438(var1 >>> 28 | 128);
               }

               this.method2438(var1 >>> 21 | 128);
            }

            this.method2438(var1 >>> 14 | 128);
         }

         this.method2438(var1 >>> 7 | 128);
      }

      this.method2438(var1 & 127);
   }

   @ObfuscatedName("z")
   public int method2453() {
      return this.field1995[++this.field1998 - 1] & 255;
   }

   @ObfuscatedName("p")
   public byte method2454() {
      return this.field1995[++this.field1998 - 1];
   }

   @ObfuscatedName("w")
   public int method2455() {
      this.field1998 += 2;
      return ((this.field1995[this.field1998 - 2] & 255) << 8) + (this.field1995[this.field1998 - 1] & 255);
   }

   @ObfuscatedName("i")
   public void method2457(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 16);
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field1995[++this.field1998 - 1] = (byte)var1;
   }

   @ObfuscatedName("x")
   public int method2458() {
      this.field1998 += 4;
      return (this.field1995[this.field1998 - 1] & 255) + ((this.field1995[this.field1998 - 2] & 255) << 8) + ((this.field1995[this.field1998 - 4] & 255) << 24) + ((this.field1995[this.field1998 - 3] & 255) << 16);
   }

   @ObfuscatedName("v")
   public String method2460() {
      if(0 == this.field1995[this.field1998]) {
         ++this.field1998;
         return null;
      } else {
         return this.method2461();
      }
   }

   @ObfuscatedName("ab")
   public String method2461() {
      int var1 = this.field1998;

      while(this.field1995[++this.field1998 - 1] != 0) {
         ;
      }

      int var2 = this.field1998 - var1 - 1;
      return 0 == var2?"":class40.method798(this.field1995, var1, var2);
   }

   @ObfuscatedName("am")
   public String method2463() {
      byte var1 = this.field1995[++this.field1998 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2468();
         if(var2 + this.field1998 > this.field1995.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = class182.method3542(this.field1995, this.field1998, var2);
            this.field1998 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("az")
   public int method2465() {
      int var1 = this.field1995[this.field1998] & 255;
      return var1 < 128?this.method2453() - 64:this.method2455() - '쀀';
   }

   @ObfuscatedName("ac")
   public int method2466() {
      int var1 = this.field1995[this.field1998] & 255;
      return var1 < 128?this.method2453():this.method2455() - '耀';
   }

   @ObfuscatedName("ax")
   public int method2467() {
      return this.field1995[this.field1998] < 0?this.method2458() & Integer.MAX_VALUE:this.method2455();
   }

   @ObfuscatedName("ai")
   public int method2468() {
      byte var1 = this.field1995[++this.field1998 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field1995[++this.field1998 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("ar")
   public void method2469(int[] var1) {
      int var2 = this.field1998 / 8;
      this.field1998 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2458();
         int var5 = this.method2458();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.field1998 -= 8;
         this.method2441(var4);
         this.method2441(var5);
      }

   }

   @ObfuscatedName("aa")
   public void method2470(int[] var1) {
      int var2 = this.field1998 / 8;
      this.field1998 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2458();
         int var5 = this.method2458();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.field1998 -= 8;
         this.method2441(var4);
         this.method2441(var5);
      }

   }

   @ObfuscatedName("ag")
   public void method2472(int[] var1, int var2, int var3) {
      int var4 = this.field1998;
      this.field1998 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2458();
         int var8 = this.method2458();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var9 & 3] + var9) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.field1998 -= 8;
         this.method2441(var7);
         this.method2441(var8);
      }

      this.field1998 = var4;
   }

   @ObfuscatedName("ao")
   public int method2474(int var1) {
      byte[] var3 = this.field1995;
      int var4 = this.field1998;
      int var5 = -1;

      for(int var6 = var1; var6 < var4; ++var6) {
         var5 = var5 >>> 8 ^ field1993[(var5 ^ var3[var6]) & 255];
      }

      var5 = ~var5;
      this.method2441(var5);
      return var5;
   }

   @ObfuscatedName("an")
   public boolean method2475() {
      this.field1998 -= 4;
      byte[] var2 = this.field1995;
      int var3 = this.field1998;
      int var4 = -1;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4 = var4 >>> 8 ^ field1993[(var4 ^ var2[var5]) & 255];
      }

      var4 = ~var4;
      var5 = this.method2458();
      return var5 == var4;
   }

   @ObfuscatedName("at")
   public void method2476(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("al")
   public void method2477(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("bl")
   public void method2478(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 16);
      this.field1995[++this.field1998 - 1] = (byte)var1;
   }

   @ObfuscatedName("ad")
   public int method2481() {
      return 128 - this.field1995[++this.field1998 - 1] & 255;
   }

   @ObfuscatedName("au")
   public byte method2482() {
      return (byte)(this.field1995[++this.field1998 - 1] - 128);
   }

   @ObfuscatedName("av")
   public void method2484(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)var1;
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("ap")
   public int method2486() {
      return 0 - this.field1995[++this.field1998 - 1] & 255;
   }

   @ObfuscatedName("bs")
   public int method2487() {
      this.field1998 += 2;
      return ((this.field1995[this.field1998 - 1] & 255) << 8) + (this.field1995[this.field1998 - 2] & 255);
   }

   @ObfuscatedName("bv")
   public int method2488() {
      this.field1998 += 2;
      return ((this.field1995[this.field1998 - 2] & 255) << 8) + (this.field1995[this.field1998 - 1] - 128 & 255);
   }

   @ObfuscatedName("bw")
   public int method2489() {
      this.field1998 += 2;
      return ((this.field1995[this.field1998 - 1] & 255) << 8) + (this.field1995[this.field1998 - 2] - 128 & 255);
   }

   @ObfuscatedName("bg")
   public int method2490() {
      this.field1998 += 2;
      int var1 = ((this.field1995[this.field1998 - 2] & 255) << 8) + (this.field1995[this.field1998 - 1] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("br")
   public int method2493() {
      this.field1998 += 3;
      return ((this.field1995[this.field1998 - 2] & 255) << 8) + ((this.field1995[this.field1998 - 1] & 255) << 16) + (this.field1995[this.field1998 - 3] & 255);
   }

   @ObfuscatedName("bk")
   public void method2494(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)var1;
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 16);
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bj")
   public int method2497() {
      this.field1998 += 4;
      return (this.field1995[this.field1998 - 4] & 255) + ((this.field1995[this.field1998 - 3] & 255) << 8) + ((this.field1995[this.field1998 - 1] & 255) << 24) + ((this.field1995[this.field1998 - 2] & 255) << 16);
   }

   @ObfuscatedName("r")
   public void method2498(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1995[++this.field1998 - 1] = 0;
         this.field1998 += class155.method3117(var1, 0, var1.length(), this.field1995, this.field1998);
         this.field1995[++this.field1998 - 1] = 0;
      }
   }

   @ObfuscatedName("bq")
   public int method2499() {
      this.field1998 += 2;
      int var1 = ((this.field1995[this.field1998 - 1] & 255) << 8) + (this.field1995[this.field1998 - 2] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
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

         field1993[var1] = var0;
      }

      field1991 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field1991[var2] = var4;
      }

   }

   @ObfuscatedName("bi")
   public int method2509() {
      this.field1998 += 4;
      return (this.field1995[this.field1998 - 3] & 255) + ((this.field1995[this.field1998 - 4] & 255) << 8) + ((this.field1995[this.field1998 - 1] & 255) << 16) + ((this.field1995[this.field1998 - 2] & 255) << 24);
   }

   @ObfuscatedName("bn")
   static final void method2510(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field308) {
         if(client.field430 < 500) {
            client.field437[client.field430] = var0;
            client.field365[client.field430] = var1;
            client.field433[client.field430] = var2;
            client.field523[client.field430] = var3;
            client.field431[client.field430] = var4;
            client.field432[client.field430] = var5;
            ++client.field430;
         }

      }
   }

   @ObfuscatedName("g")
   public void method2514(int var1) {
      this.field1995[this.field1998 - var1 - 2] = (byte)(var1 >> 8);
      this.field1995[this.field1998 - var1 - 1] = (byte)var1;
   }

   public class118(int var1) {
      this.field1995 = class120.method2678(var1);
      this.field1998 = 0;
   }

   public class118(byte[] var1) {
      this.field1995 = var1;
      this.field1998 = 0;
   }

   @ObfuscatedName("aw")
   public void method2534(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.field1995[++this.field1998 - 1];
      }

   }

   @ObfuscatedName("bd")
   public int method2539() {
      this.field1998 += 4;
      return (this.field1995[this.field1998 - 2] & 255) + ((this.field1995[this.field1998 - 4] & 255) << 16) + ((this.field1995[this.field1998 - 3] & 255) << 24) + ((this.field1995[this.field1998 - 1] & 255) << 8);
   }

   @ObfuscatedName("a")
   public void method2541(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field1995[++this.field1998 - 1] = (byte)var1;
   }

   @ObfuscatedName("c")
   public int method2553() {
      this.field1998 += 3;
      return (this.field1995[this.field1998 - 1] & 255) + ((this.field1995[this.field1998 - 3] & 255) << 16) + ((this.field1995[this.field1998 - 2] & 255) << 8);
   }

   @ObfuscatedName("t")
   public int method2558() {
      this.field1998 += 2;
      int var1 = ((this.field1995[this.field1998 - 2] & 255) << 8) + (this.field1995[this.field1998 - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("ah")
   public void method2564(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field1995[++this.field1998 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("o")
   public void method2570(long var1) {
      this.field1995[++this.field1998 - 1] = (byte)((int)(var1 >> 56));
      this.field1995[++this.field1998 - 1] = (byte)((int)(var1 >> 48));
      this.field1995[++this.field1998 - 1] = (byte)((int)(var1 >> 40));
      this.field1995[++this.field1998 - 1] = (byte)((int)(var1 >> 32));
      this.field1995[++this.field1998 - 1] = (byte)((int)(var1 >> 24));
      this.field1995[++this.field1998 - 1] = (byte)((int)(var1 >> 16));
      this.field1995[++this.field1998 - 1] = (byte)((int)(var1 >> 8));
      this.field1995[++this.field1998 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("ae")
   public int method2571() {
      return this.field1995[++this.field1998 - 1] - 128 & 255;
   }

   @ObfuscatedName("ay")
   public byte method2576() {
      return (byte)(0 - this.field1995[++this.field1998 - 1]);
   }

   @ObfuscatedName("s")
   public void method2590(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2438(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2541('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("be")
   public void method2607(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field1995[++this.field1998 - 1] = (byte)var1;
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 24);
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("aq")
   public void method2622(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("af")
   public void method2624(BigInteger var1, BigInteger var2) {
      int var3 = this.field1998;
      this.field1998 = 0;
      byte[] var4 = new byte[var3];
      this.method2534(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field1998 = 0;
      this.method2541(var7.length);
      this.method2447(var7, 0, var7.length);
   }

   @ObfuscatedName("e")
   public long method2632() {
      long var1 = (long)this.method2458() & 4294967295L;
      long var3 = (long)this.method2458() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("bc")
   public void method2636(int var1) {
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 16);
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 24);
      this.field1995[++this.field1998 - 1] = (byte)var1;
      this.field1995[++this.field1998 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("a")
   static final void method2646(byte[] var0, int var1, int var2, int var3, int var4, class107[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var1 + var7 > 0 && var7 + var1 < 103 && var2 + var8 > 0 && var8 + var2 < 103) {
                  var5[var6].field1904[var1 + var7][var2 + var8] &= -16777217;
               }
            }
         }
      }

      class118 var10 = new class118(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class40.method807(var10, var7, var8 + var1, var2 + var9, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("f")
   public static void method2647() {
      class46.field1054.method3720();
   }
}
