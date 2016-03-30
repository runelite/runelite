import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("Buffer")
public class class119 extends class208 {
   @ObfuscatedName("e")
   static long[] field2006;
   @ObfuscatedName("t")
   static int[] field2007 = new int[256];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1198952199
   )
   @Export("offset")
   public int field2011;
   @ObfuscatedName("w")
   @Export("payload")
   public byte[] field2012;

   @ObfuscatedName("bi")
   public void method2491(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)var1;
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 8);
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("p")
   public void method2492(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 8);
      this.field2012[++this.field2011 - 1] = (byte)var1;
   }

   @ObfuscatedName("y")
   public void method2494(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 24);
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 16);
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 8);
      this.field2012[++this.field2011 - 1] = (byte)var1;
   }

   @ObfuscatedName("m")
   public void method2495(long var1) {
      this.field2012[++this.field2011 - 1] = (byte)((int)(var1 >> 40));
      this.field2012[++this.field2011 - 1] = (byte)((int)(var1 >> 32));
      this.field2012[++this.field2011 - 1] = (byte)((int)(var1 >> 24));
      this.field2012[++this.field2011 - 1] = (byte)((int)(var1 >> 16));
      this.field2012[++this.field2011 - 1] = (byte)((int)(var1 >> 8));
      this.field2012[++this.field2011 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("c")
   public void method2496(long var1) {
      this.field2012[++this.field2011 - 1] = (byte)((int)(var1 >> 56));
      this.field2012[++this.field2011 - 1] = (byte)((int)(var1 >> 48));
      this.field2012[++this.field2011 - 1] = (byte)((int)(var1 >> 40));
      this.field2012[++this.field2011 - 1] = (byte)((int)(var1 >> 32));
      this.field2012[++this.field2011 - 1] = (byte)((int)(var1 >> 24));
      this.field2012[++this.field2011 - 1] = (byte)((int)(var1 >> 16));
      this.field2012[++this.field2011 - 1] = (byte)((int)(var1 >> 8));
      this.field2012[++this.field2011 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("a")
   public void method2501(int var1) {
      this.field2012[this.field2011 - var1 - 4] = (byte)(var1 >> 24);
      this.field2012[this.field2011 - var1 - 3] = (byte)(var1 >> 16);
      this.field2012[this.field2011 - var1 - 2] = (byte)(var1 >> 8);
      this.field2012[this.field2011 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("i")
   public void method2504(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2573(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2492('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-680892685"
   )
   public void method2505(int var1) {
      if((var1 & -128) != 0) {
         if(0 != (var1 & -16384)) {
            if(0 != (var1 & -2097152)) {
               if(0 != (var1 & -268435456)) {
                  this.method2573(var1 >>> 28 | 128);
               }

               this.method2573(var1 >>> 21 | 128);
            }

            this.method2573(var1 >>> 14 | 128);
         }

         this.method2573(var1 >>> 7 | 128);
      }

      this.method2573(var1 & 127);
   }

   @ObfuscatedName("h")
   public int method2506() {
      return this.field2012[++this.field2011 - 1] & 255;
   }

   @ObfuscatedName("f")
   public int method2508() {
      this.field2011 += 2;
      return (this.field2012[this.field2011 - 1] & 255) + ((this.field2012[this.field2011 - 2] & 255) << 8);
   }

   @ObfuscatedName("r")
   public int method2509() {
      this.field2011 += 2;
      int var1 = ((this.field2012[this.field2011 - 2] & 255) << 8) + (this.field2012[this.field2011 - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("n")
   public int method2510() {
      this.field2011 += 3;
      return ((this.field2012[this.field2011 - 2] & 255) << 8) + ((this.field2012[this.field2011 - 3] & 255) << 16) + (this.field2012[this.field2011 - 1] & 255);
   }

   @ObfuscatedName("g")
   public int method2511() {
      this.field2011 += 4;
      return ((this.field2012[this.field2011 - 2] & 255) << 8) + ((this.field2012[this.field2011 - 4] & 255) << 24) + ((this.field2012[this.field2011 - 3] & 255) << 16) + (this.field2012[this.field2011 - 1] & 255);
   }

   @ObfuscatedName("b")
   public long method2512() {
      long var1 = (long)this.method2511() & 4294967295L;
      long var3 = (long)this.method2511() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("af")
   public String method2513() {
      if(0 == this.field2012[this.field2011]) {
         ++this.field2011;
         return null;
      } else {
         return this.method2683();
      }
   }

   @ObfuscatedName("ar")
   public String method2515() {
      byte var1 = this.field2012[++this.field2011 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field2011;

         while(this.field2012[++this.field2011 - 1] != 0) {
            ;
         }

         int var3 = this.field2011 - var2 - 1;
         return var3 == 0?"":class38.method783(this.field2012, var2, var3);
      }
   }

   @ObfuscatedName("ay")
   public String method2516() {
      byte var1 = this.field2012[++this.field2011 - 1];
      if(0 != var1) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2521();
         if(var2 + this.field2011 > this.field2012.length) {
            throw new IllegalStateException("");
         } else {
            byte[] var4 = this.field2012;
            int var5 = this.field2011;
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
                  if(1 + var8 < var9 && (var4[var8] & 192) == 128 && 128 == (var4[var8 + 1] & 192)) {
                     var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 < 2048) {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else if(var10 < 248) {
                  if(var8 + 2 < var9 && 128 == (var4[var8] & 192) && 128 == (var4[1 + var8] & 192) && 128 == (var4[2 + var8] & 192)) {
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
            this.field2011 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("ab")
   public int method2518() {
      int var1 = this.field2012[this.field2011] & 255;
      return var1 < 128?this.method2506() - 64:this.method2508() - '쀀';
   }

   @ObfuscatedName("ac")
   public int method2520() {
      return this.field2012[this.field2011] < 0?this.method2511() & Integer.MAX_VALUE:this.method2508();
   }

   @ObfuscatedName("ah")
   public int method2521() {
      byte var1 = this.field2012[++this.field2011 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field2012[++this.field2011 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("ae")
   public void method2522(int[] var1) {
      int var2 = this.field2011 / 8;
      this.field2011 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2511();
         int var5 = this.method2511();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3]) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.field2011 -= 8;
         this.method2494(var4);
         this.method2494(var5);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "18645011"
   )
   public void method2523(int[] var1) {
      int var2 = this.field2011 / 8;
      this.field2011 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2511();
         int var5 = this.method2511();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.field2011 -= 8;
         this.method2494(var4);
         this.method2494(var5);
      }

   }

   @ObfuscatedName("k")
   public byte method2524() {
      return this.field2012[++this.field2011 - 1];
   }

   @ObfuscatedName("al")
   public void method2525(int[] var1, int var2, int var3) {
      int var4 = this.field2011;
      this.field2011 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2511();
         int var8 = this.method2511();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var9 + var1[var9 & 3]) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.field2011 -= 8;
         this.method2494(var7);
         this.method2494(var8);
      }

      this.field2011 = var4;
   }

   @ObfuscatedName("ag")
   public void method2526(BigInteger var1, BigInteger var2) {
      int var3 = this.field2011;
      this.field2011 = 0;
      byte[] var4 = new byte[var3];
      this.method2531(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field2011 = 0;
      this.method2492(var7.length);
      this.method2606(var7, 0, var7.length);
   }

   @ObfuscatedName("ad")
   public int method2527(int var1) {
      int var2 = class82.method1877(this.field2012, var1, this.field2011);
      this.method2494(var2);
      return var2;
   }

   @ObfuscatedName("au")
   public boolean method2528() {
      this.field2011 -= 4;
      int var1 = class82.method1877(this.field2012, 0, this.field2011);
      int var2 = this.method2511();
      return var1 == var2;
   }

   @ObfuscatedName("ao")
   public void method2529(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("ak")
   public void method2530(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("ai")
   public void method2531(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = this.field2012[++this.field2011 - 1];
      }

   }

   @ObfuscatedName("aw")
   public int method2532() {
      return this.field2012[++this.field2011 - 1] - 128 & 255;
   }

   @ObfuscatedName("as")
   public int method2533() {
      return 0 - this.field2012[++this.field2011 - 1] & 255;
   }

   @ObfuscatedName("an")
   public byte method2536() {
      return (byte)(0 - this.field2012[++this.field2011 - 1]);
   }

   @ObfuscatedName("aa")
   public byte method2537() {
      return (byte)(128 - this.field2012[++this.field2011 - 1]);
   }

   @ObfuscatedName("ap")
   public void method2538(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)var1;
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bd")
   public void method2539(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 8);
      this.field2012[++this.field2011 - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("bb")
   public void method2540(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)(var1 + 128);
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bo")
   public int method2541() {
      this.field2011 += 2;
      return (this.field2012[this.field2011 - 2] & 255) + ((this.field2012[this.field2011 - 1] & 255) << 8);
   }

   @ObfuscatedName("bf")
   public int method2542() {
      this.field2011 += 2;
      return ((this.field2012[this.field2011 - 2] & 255) << 8) + (this.field2012[this.field2011 - 1] - 128 & 255);
   }

   @ObfuscatedName("bn")
   public int method2544() {
      this.field2011 += 2;
      int var1 = (this.field2012[this.field2011 - 1] - 128 & 255) + ((this.field2012[this.field2011 - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bg")
   public int method2545() {
      this.field2011 += 2;
      int var1 = (this.field2012[this.field2011 - 2] - 128 & 255) + ((this.field2012[this.field2011 - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bm")
   public void method2549(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 16);
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 24);
      this.field2012[++this.field2011 - 1] = (byte)var1;
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bu")
   public int method2551() {
      this.field2011 += 4;
      return (this.field2012[this.field2011 - 3] & 255) + ((this.field2012[this.field2011 - 4] & 255) << 8) + ((this.field2012[this.field2011 - 1] & 255) << 16) + ((this.field2012[this.field2011 - 2] & 255) << 24);
   }

   @ObfuscatedName("s")
   public void method2569(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field2012[++this.field2011 - 1] = 0;
         this.field2011 += class85.method1900(var1, 0, var1.length(), this.field2012, this.field2011);
         this.field2012[++this.field2011 - 1] = 0;
      }
   }

   @ObfuscatedName("av")
   public int method2571() {
      int var1 = this.field2012[this.field2011] & 255;
      return var1 < 128?this.method2506():this.method2508() - '耀';
   }

   @ObfuscatedName("j")
   public void method2572(CharSequence var1) {
      int var2 = class33.method729(var1);
      this.field2012[++this.field2011 - 1] = 0;
      this.method2505(var2);
      this.field2011 += class144.method3121(this.field2012, this.field2011, var1);
   }

   @ObfuscatedName("t")
   public void method2573(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)var1;
   }

   @ObfuscatedName("d")
   public void method2589(int var1) {
      this.field2012[this.field2011 - var1 - 2] = (byte)(var1 >> 8);
      this.field2012[this.field2011 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("aq")
   public int method2597() {
      return 128 - this.field2012[++this.field2011 - 1] & 255;
   }

   @ObfuscatedName("bp")
   public int method2600() {
      this.field2011 += 2;
      return (this.field2012[this.field2011 - 2] - 128 & 255) + ((this.field2012[this.field2011 - 1] & 255) << 8);
   }

   @ObfuscatedName("q")
   public void method2606(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.field2012[++this.field2011 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("x")
   static String method2609(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var1 + var2; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class161.field2666[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class161.field2666[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[2 + var4] & 255;
               var3.append(class161.field2666[(var6 & 15) << 2 | var7 >>> 6]).append(class161.field2666[var7 & 63]);
            } else {
               var3.append(class161.field2666[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class161.field2666[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("bz")
   public void method2610(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)var1;
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 8);
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 16);
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("at")
   public void method2618(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("bw")
   public void method2620(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 8);
      this.field2012[++this.field2011 - 1] = (byte)var1;
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 24);
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("u")
   public void method2635(int var1) {
      this.field2012[this.field2011 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("ax")
   public byte method2639() {
      return (byte)(this.field2012[++this.field2011 - 1] - 128);
   }

   @ObfuscatedName("az")
   public void method2644(int[] var1, int var2, int var3) {
      int var4 = this.field2011;
      this.field2011 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2511();
         int var8 = this.method2511();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.field2011 -= 8;
         this.method2494(var7);
         this.method2494(var8);
      }

      this.field2011 = var4;
   }

   @ObfuscatedName("e")
   public void method2653(int var1) {
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 16);
      this.field2012[++this.field2011 - 1] = (byte)(var1 >> 8);
      this.field2012[++this.field2011 - 1] = (byte)var1;
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

         field2007[var1] = var0;
      }

      field2006 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2006[var2] = var4;
      }

   }

   public class119(int var1) {
      this.field2012 = class121.method2744(var1);
      this.field2011 = 0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-260786023"
   )
   public void method2661(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field2011 += class85.method1900(var1, 0, var1.length(), this.field2012, this.field2011);
         this.field2012[++this.field2011 - 1] = 0;
      }
   }

   @ObfuscatedName("bh")
   public int method2663() {
      this.field2011 += 4;
      return ((this.field2012[this.field2011 - 3] & 255) << 8) + ((this.field2012[this.field2011 - 1] & 255) << 24) + ((this.field2012[this.field2011 - 2] & 255) << 16) + (this.field2012[this.field2011 - 4] & 255);
   }

   @ObfuscatedName("am")
   public String method2683() {
      int var1 = this.field2011;

      while(this.field2012[++this.field2011 - 1] != 0) {
         ;
      }

      int var2 = this.field2011 - var1 - 1;
      return var2 == 0?"":class38.method783(this.field2012, var1, var2);
   }

   @ObfuscatedName("bx")
   public int method2689() {
      this.field2011 += 4;
      return ((this.field2012[this.field2011 - 1] & 255) << 8) + ((this.field2012[this.field2011 - 4] & 255) << 16) + ((this.field2012[this.field2011 - 3] & 255) << 24) + (this.field2012[this.field2011 - 2] & 255);
   }

   public class119(byte[] var1) {
      this.field2012 = var1;
      this.field2011 = 0;
   }

   @ObfuscatedName("p")
   public static int method2703(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("cu")
   static class173 method2704(class173 var0) {
      class173 var1 = class90.method2079(var0);
      if(var1 == null) {
         var1 = var0.field2768;
      }

      return var1;
   }

   @ObfuscatedName("l")
   static final int method2705(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & '\uff00') * var3 + var2 * (var1 & '\uff00') & 16711680) + ((var1 & 16711935) * var2 + (var0 & 16711935) * var3 & -16711936) >> 8;
   }
}
