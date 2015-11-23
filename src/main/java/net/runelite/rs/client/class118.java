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
   static int[] field1978 = new int[256];
   @ObfuscatedName("i")
   public static short[][] field1979;
   @ObfuscatedName("j")
   @Export("payload")
   public byte[] field1980;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2014740975
   )
   @Export("offset")
   public int field1981;
   @ObfuscatedName("u")
   static long[] field1982;
   @ObfuscatedName("bk")
   static class167 field1985;
   @ObfuscatedName("ej")
   static class80[] field1986;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = 1392493091
   )
   static int field1988;

   @ObfuscatedName("m")
   public void method2521(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)var1;
   }

   @ObfuscatedName("f")
   public void method2522(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1981 - 1] = (byte)var1;
   }

   @ObfuscatedName("l")
   public void method2523(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1981 - 1] = (byte)var1;
   }

   @ObfuscatedName("u")
   public void method2524(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 24);
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1981 - 1] = (byte)var1;
   }

   @ObfuscatedName("t")
   public void method2527(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1981 += class31.method734(var1, 0, var1.length(), this.field1980, this.field1981);
         this.field1980[++this.field1981 - 1] = 0;
      }
   }

   @ObfuscatedName("k")
   public void method2528(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1980[++this.field1981 - 1] = 0;
         this.field1981 += class31.method734(var1, 0, var1.length(), this.field1980, this.field1981);
         this.field1980[++this.field1981 - 1] = 0;
      }
   }

   @ObfuscatedName("s")
   public void method2529(CharSequence var1) {
      int var2 = class8.method129(var1);
      this.field1980[++this.field1981 - 1] = 0;
      this.method2535(var2);
      this.field1981 += class152.method3193(this.field1980, this.field1981, var1);
   }

   @ObfuscatedName("w")
   public void method2530(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.field1980[++this.field1981 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("p")
   public void method2533(int var1) {
      this.field1980[this.field1981 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("r")
   public void method2534(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2521(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2522(var1 + '耀');
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("g")
   public void method2535(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if(0 != (var1 & -268435456)) {
                  this.method2521(var1 >>> 28 | 128);
               }

               this.method2521(var1 >>> 21 | 128);
            }

            this.method2521(var1 >>> 14 | 128);
         }

         this.method2521(var1 >>> 7 | 128);
      }

      this.method2521(var1 & 127);
   }

   @ObfuscatedName("n")
   public int method2536() {
      return this.field1980[++this.field1981 - 1] & 255;
   }

   @ObfuscatedName("y")
   public byte method2537() {
      return this.field1980[++this.field1981 - 1];
   }

   @ObfuscatedName("v")
   public int method2538() {
      this.field1981 += 2;
      return ((this.field1980[this.field1981 - 2] & 255) << 8) + (this.field1980[this.field1981 - 1] & 255);
   }

   @ObfuscatedName("q")
   public int method2539() {
      this.field1981 += 2;
      int var1 = ((this.field1980[this.field1981 - 2] & 255) << 8) + (this.field1980[this.field1981 - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("x")
   public int method2540() {
      this.field1981 += 3;
      return (this.field1980[this.field1981 - 1] & 255) + ((this.field1980[this.field1981 - 2] & 255) << 8) + ((this.field1980[this.field1981 - 3] & 255) << 16);
   }

   @ObfuscatedName("d")
   public int method2541() {
      this.field1981 += 4;
      return ((this.field1980[this.field1981 - 3] & 255) << 16) + ((this.field1980[this.field1981 - 4] & 255) << 24) + ((this.field1980[this.field1981 - 2] & 255) << 8) + (this.field1980[this.field1981 - 1] & 255);
   }

   @ObfuscatedName("c")
   public String method2543() {
      if(this.field1980[this.field1981] == 0) {
         ++this.field1981;
         return null;
      } else {
         return this.method2544();
      }
   }

   @ObfuscatedName("b")
   public String method2544() {
      int var1 = this.field1981;

      while(this.field1980[++this.field1981 - 1] != 0) {
         ;
      }

      int var2 = this.field1981 - var1 - 1;
      return 0 == var2?"":class162.method3270(this.field1980, var1, var2);
   }

   public class118(byte[] var1) {
      this.field1980 = var1;
      this.field1981 = 0;
   }

   @ObfuscatedName("as")
   public void method2546(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = this.field1980[++this.field1981 - 1];
      }

   }

   @ObfuscatedName("ab")
   public void method2547(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1981 - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("ai")
   public int method2548() {
      int var1 = this.field1980[this.field1981] & 255;
      return var1 < 128?this.method2536():this.method2538() - '耀';
   }

   @ObfuscatedName("ay")
   public void method2551(int[] var1) {
      int var2 = this.field1981 / 8;
      this.field1981 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2541();
         int var5 = this.method2541();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3]) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.field1981 -= 8;
         this.method2524(var4);
         this.method2524(var5);
      }

   }

   @ObfuscatedName("ap")
   public void method2554(int[] var1, int var2, int var3) {
      int var4 = this.field1981;
      this.field1981 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2541();
         int var8 = this.method2541();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var9 & 3] + var9) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.field1981 -= 8;
         this.method2524(var7);
         this.method2524(var8);
      }

      this.field1981 = var4;
   }

   @ObfuscatedName("at")
   public void method2555(BigInteger var1, BigInteger var2) {
      int var3 = this.field1981;
      this.field1981 = 0;
      byte[] var4 = new byte[var3];
      this.method2546(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field1981 = 0;
      this.method2522(var7.length);
      this.method2530(var7, 0, var7.length);
   }

   @ObfuscatedName("al")
   public int method2556(int var1) {
      int var2 = class8.method139(this.field1980, var1, this.field1981);
      this.method2524(var2);
      return var2;
   }

   @ObfuscatedName("ac")
   public boolean method2557() {
      this.field1981 -= 4;
      int var1 = class8.method139(this.field1980, 0, this.field1981);
      int var2 = this.method2541();
      return var2 == var1;
   }

   @ObfuscatedName("ar")
   public void method2558(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("aq")
   public int method2559() {
      return 0 - this.field1980[++this.field1981 - 1] & 255;
   }

   @ObfuscatedName("ag")
   public int method2561() {
      return this.field1980[++this.field1981 - 1] - 128 & 255;
   }

   @ObfuscatedName("aa")
   public String method2562() {
      byte var1 = this.field1980[++this.field1981 - 1];
      if(0 != var1) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field1981;

         while(this.field1980[++this.field1981 - 1] != 0) {
            ;
         }

         int var3 = this.field1981 - var2 - 1;
         return var3 == 0?"":class162.method3270(this.field1980, var2, var3);
      }
   }

   @ObfuscatedName("au")
   public int method2563() {
      return 128 - this.field1980[++this.field1981 - 1] & 255;
   }

   @ObfuscatedName("aw")
   public byte method2564() {
      return (byte)(this.field1980[++this.field1981 - 1] - 128);
   }

   @ObfuscatedName("af")
   public byte method2566() {
      return (byte)(128 - this.field1980[++this.field1981 - 1]);
   }

   @ObfuscatedName("aj")
   public void method2567(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)var1;
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bj")
   public int method2570() {
      this.field1981 += 2;
      return (this.field1980[this.field1981 - 2] & 255) + ((this.field1980[this.field1981 - 1] & 255) << 8);
   }

   @ObfuscatedName("bn")
   public int method2571() {
      this.field1981 += 2;
      return (this.field1980[this.field1981 - 1] - 128 & 255) + ((this.field1980[this.field1981 - 2] & 255) << 8);
   }

   @ObfuscatedName("bf")
   public int method2572() {
      this.field1981 += 2;
      return (this.field1980[this.field1981 - 2] - 128 & 255) + ((this.field1980[this.field1981 - 1] & 255) << 8);
   }

   @ObfuscatedName("bm")
   public int method2573() {
      this.field1981 += 2;
      int var1 = ((this.field1980[this.field1981 - 2] & 255) << 8) + (this.field1980[this.field1981 - 1] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bc")
   public int method2574() {
      this.field1981 += 2;
      int var1 = (this.field1980[this.field1981 - 2] - 128 & 255) + ((this.field1980[this.field1981 - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bu")
   public void method2575(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1981 - 1] = (byte)var1;
   }

   @ObfuscatedName("ba")
   public int method2576() {
      this.field1981 += 3;
      return ((this.field1980[this.field1981 - 2] & 255) << 8) + ((this.field1980[this.field1981 - 1] & 255) << 16) + (this.field1980[this.field1981 - 3] & 255);
   }

   @ObfuscatedName("bi")
   public void method2577(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)var1;
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bq")
   public void method2578(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 8);
      this.field1980[++this.field1981 - 1] = (byte)var1;
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 24);
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("be")
   public int method2580() {
      this.field1981 += 4;
      return ((this.field1980[this.field1981 - 3] & 255) << 8) + ((this.field1980[this.field1981 - 1] & 255) << 24) + ((this.field1980[this.field1981 - 2] & 255) << 16) + (this.field1980[this.field1981 - 4] & 255);
   }

   @ObfuscatedName("bl")
   public int method2581() {
      this.field1981 += 4;
      return ((this.field1980[this.field1981 - 1] & 255) << 16) + ((this.field1980[this.field1981 - 2] & 255) << 24) + ((this.field1980[this.field1981 - 4] & 255) << 8) + (this.field1980[this.field1981 - 3] & 255);
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

         field1978[var1] = var0;
      }

      field1982 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field1982[var2] = var4;
      }

   }

   @ObfuscatedName("az")
   public void method2592(int[] var1) {
      int var2 = this.field1981 / 8;
      this.field1981 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2541();
         int var5 = this.method2541();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.field1981 -= 8;
         this.method2524(var4);
         this.method2524(var5);
      }

   }

   @ObfuscatedName("am")
   public int method2593() {
      return this.field1980[this.field1981] < 0?this.method2541() & Integer.MAX_VALUE:this.method2538();
   }

   @ObfuscatedName("bk")
   public void method2629(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 16);
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 24);
      this.field1980[++this.field1981 - 1] = (byte)var1;
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("ak")
   public void method2632(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("ax")
   public int method2656() {
      byte var1 = this.field1980[++this.field1981 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field1980[++this.field1981 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("a")
   public void method2659(long var1) {
      this.field1980[++this.field1981 - 1] = (byte)((int)(var1 >> 40));
      this.field1980[++this.field1981 - 1] = (byte)((int)(var1 >> 32));
      this.field1980[++this.field1981 - 1] = (byte)((int)(var1 >> 24));
      this.field1980[++this.field1981 - 1] = (byte)((int)(var1 >> 16));
      this.field1980[++this.field1981 - 1] = (byte)((int)(var1 >> 8));
      this.field1980[++this.field1981 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("bg")
   public int method2663() {
      this.field1981 += 4;
      return (this.field1980[this.field1981 - 2] & 255) + ((this.field1980[this.field1981 - 3] & 255) << 24) + ((this.field1980[this.field1981 - 4] & 255) << 16) + ((this.field1980[this.field1981 - 1] & 255) << 8);
   }

   @ObfuscatedName("ae")
   public int method2666() {
      int var1 = this.field1980[this.field1981] & 255;
      return var1 < 128?this.method2536() - 64:this.method2538() - '쀀';
   }

   @ObfuscatedName("ah")
   public void method2667(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("e")
   public void method2688(int var1) {
      this.field1980[this.field1981 - var1 - 4] = (byte)(var1 >> 24);
      this.field1980[this.field1981 - var1 - 3] = (byte)(var1 >> 16);
      this.field1980[this.field1981 - var1 - 2] = (byte)(var1 >> 8);
      this.field1980[this.field1981 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("av")
   public void method2689(int[] var1, int var2, int var3) {
      int var4 = this.field1981;
      this.field1981 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2541();
         int var8 = this.method2541();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.field1981 -= 8;
         this.method2524(var7);
         this.method2524(var8);
      }

      this.field1981 = var4;
   }

   @ObfuscatedName("h")
   public void method2690(long var1) {
      this.field1980[++this.field1981 - 1] = (byte)((int)(var1 >> 56));
      this.field1980[++this.field1981 - 1] = (byte)((int)(var1 >> 48));
      this.field1980[++this.field1981 - 1] = (byte)((int)(var1 >> 40));
      this.field1980[++this.field1981 - 1] = (byte)((int)(var1 >> 32));
      this.field1980[++this.field1981 - 1] = (byte)((int)(var1 >> 24));
      this.field1980[++this.field1981 - 1] = (byte)((int)(var1 >> 16));
      this.field1980[++this.field1981 - 1] = (byte)((int)(var1 >> 8));
      this.field1980[++this.field1981 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("ao")
   public String method2715() {
      byte var1 = this.field1980[++this.field1981 - 1];
      if(0 != var1) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2656();
         if(var2 + this.field1981 > this.field1980.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = class49.method1038(this.field1980, this.field1981, var2);
            this.field1981 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("z")
   public void method2719(int var1) {
      this.field1980[this.field1981 - var1 - 2] = (byte)(var1 >> 8);
      this.field1980[this.field1981 - var1 - 1] = (byte)var1;
   }

   public class118(int var1) {
      this.field1980 = class120.method2778(var1);
      this.field1981 = 0;
   }

   @ObfuscatedName("an")
   public void method2730(int var1) {
      this.field1980[++this.field1981 - 1] = (byte)(var1 + 128);
      this.field1980[++this.field1981 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("o")
   public long method2734() {
      long var1 = (long)this.method2541() & 4294967295L;
      long var3 = (long)this.method2541() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("ad")
   public byte method2737() {
      return (byte)(0 - this.field1980[++this.field1981 - 1]);
   }

   @ObfuscatedName("j")
   public static String method2738(int var0) {
      return (var0 >> 24 & 255) + "." + (var0 >> 16 & 255) + "." + (var0 >> 8 & 255) + "." + (var0 & 255);
   }
}
