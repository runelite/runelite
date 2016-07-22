import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("Buffer")
public class class122 extends class211 {
   @ObfuscatedName("g")
   static long[] field2044;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 539924975
   )
   @Export("offset")
   public int field2045;
   @ObfuscatedName("e")
   static int[] field2046 = new int[256];
   @ObfuscatedName("m")
   @Export("payload")
   public byte[] field2047;
   @ObfuscatedName("cr")
   static class149 field2050;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2061600448"
   )
   public int method2556() {
      return this.field2047[++this.field2045 - 1] & 255;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1621000383"
   )
   public void method2557(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-15843"
   )
   public void method2558(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 8);
      this.field2047[++this.field2045 - 1] = (byte)var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-310750500"
   )
   public void method2559(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 16);
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 8);
      this.field2047[++this.field2045 - 1] = (byte)var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "5566"
   )
   public void method2560(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 24);
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 16);
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 8);
      this.field2047[++this.field2045 - 1] = (byte)var1;
   }

   @ObfuscatedName("j")
   public void method2561(long var1) {
      this.field2047[++this.field2045 - 1] = (byte)((int)(var1 >> 40));
      this.field2047[++this.field2045 - 1] = (byte)((int)(var1 >> 32));
      this.field2047[++this.field2045 - 1] = (byte)((int)(var1 >> 24));
      this.field2047[++this.field2045 - 1] = (byte)((int)(var1 >> 16));
      this.field2047[++this.field2045 - 1] = (byte)((int)(var1 >> 8));
      this.field2047[++this.field2045 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("r")
   public void method2562(long var1) {
      this.field2047[++this.field2045 - 1] = (byte)((int)(var1 >> 56));
      this.field2047[++this.field2045 - 1] = (byte)((int)(var1 >> 48));
      this.field2047[++this.field2045 - 1] = (byte)((int)(var1 >> 40));
      this.field2047[++this.field2045 - 1] = (byte)((int)(var1 >> 32));
      this.field2047[++this.field2045 - 1] = (byte)((int)(var1 >> 24));
      this.field2047[++this.field2045 - 1] = (byte)((int)(var1 >> 16));
      this.field2047[++this.field2045 - 1] = (byte)((int)(var1 >> 8));
      this.field2047[++this.field2045 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-909861322"
   )
   public void method2563(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field2045 += class40.method789(var1, 0, var1.length(), this.field2047, this.field2045);
         this.field2047[++this.field2045 - 1] = 0;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "23"
   )
   public void method2565(CharSequence var1) {
      int var2 = class136.method2911(var1);
      this.field2047[++this.field2045 - 1] = 0;
      this.method2571(var2);
      this.field2045 += class142.method2998(this.field2047, this.field2045, var1);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-107"
   )
   public void method2567(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 8);
      this.field2047[++this.field2045 - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1332624125"
   )
   public void method2568(int var1) {
      this.field2047[this.field2045 - var1 - 2] = (byte)(var1 >> 8);
      this.field2047[this.field2045 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "426933879"
   )
   public void method2570(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2557(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2558(var1 + '耀');
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-1"
   )
   public void method2571(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2557(var1 >>> 28 | 128);
               }

               this.method2557(var1 >>> 21 | 128);
            }

            this.method2557(var1 >>> 14 | 128);
         }

         this.method2557(var1 >>> 7 | 128);
      }

      this.method2557(var1 & 127);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1189167010"
   )
   public byte method2573() {
      return this.field2047[++this.field2045 - 1];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1594398885"
   )
   public int method2575() {
      this.field2045 += 2;
      int var1 = ((this.field2047[this.field2045 - 2] & 255) << 8) + (this.field2047[this.field2045 - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "78"
   )
   public int method2576() {
      this.field2045 += 3;
      return ((this.field2047[this.field2045 - 2] & 255) << 8) + ((this.field2047[this.field2045 - 3] & 255) << 16) + (this.field2047[this.field2045 - 1] & 255);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1892881218"
   )
   public int method2577() {
      this.field2045 += 4;
      return (this.field2047[this.field2045 - 1] & 255) + ((this.field2047[this.field2045 - 2] & 255) << 8) + ((this.field2047[this.field2045 - 4] & 255) << 24) + ((this.field2047[this.field2045 - 3] & 255) << 16);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1274243428"
   )
   public long method2578() {
      long var1 = (long)this.method2577() & 4294967295L;
      long var3 = (long)this.method2577() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "23"
   )
   public String method2580() {
      int var1 = this.field2045;

      while(this.field2047[++this.field2045 - 1] != 0) {
         ;
      }

      int var2 = this.field2045 - var1 - 1;
      return var2 == 0?"":class7.method106(this.field2047, var1, var2);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1241553903"
   )
   public String method2581() {
      byte var1 = this.field2047[++this.field2045 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field2045;

         while(this.field2047[++this.field2045 - 1] != 0) {
            ;
         }

         int var3 = this.field2045 - var2 - 1;
         return var3 == 0?"":class7.method106(this.field2047, var2, var3);
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "691859898"
   )
   public String method2582() {
      byte var1 = this.field2047[++this.field2045 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2687();
         if(var2 + this.field2045 > this.field2047.length) {
            throw new IllegalStateException("");
         } else {
            byte[] var4 = this.field2047;
            int var5 = this.field2045;
            char[] var6 = new char[var2];
            int var7 = 0;
            int var8 = var5;

            int var11;
            for(int var9 = var5 + var2; var8 < var9; var6[var7++] = (char)var11) {
               int var10 = var4[var8++] & 255;
               if(var10 < 128) {
                  if(var10 == 0) {
                     var11 = '�';
                  } else {
                     var11 = var10;
                  }
               } else if(var10 < 192) {
                  var11 = '�';
               } else if(var10 < 224) {
                  if(var8 < var9 && (var4[var8] & 192) == 128) {
                     var11 = (var10 & 31) << 6 | var4[var8++] & 63;
                     if(var11 < 128) {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else if(var10 < 240) {
                  if(var8 + 1 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128) {
                     var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 < 2048) {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else if(var10 < 248) {
                  if(var8 + 2 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128 && (var4[var8 + 2] & 192) == 128) {
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
            this.field2045 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "159265548"
   )
   public void method2583(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.field2047[++this.field2045 - 1];
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1439568541"
   )
   public int method2584() {
      int var1 = this.field2047[this.field2045] & 255;
      return var1 < 128?this.method2556() - 64:this.method2706() - '쀀';
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2060308628"
   )
   public int method2585() {
      int var1 = this.field2047[this.field2045] & 255;
      return var1 < 128?this.method2556():this.method2706() - '耀';
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1522549518"
   )
   public int method2586() {
      if(this.field2047[this.field2045] < 0) {
         return this.method2577() & Integer.MAX_VALUE;
      } else {
         int var1 = this.method2706();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-590387909"
   )
   public void method2587(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)var1;
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 8);
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 16);
   }

   public class122(int var1) {
      this.field2047 = class124.method2793(var1);
      this.field2045 = 0;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "353042789"
   )
   public void method2588(int[] var1) {
      int var2 = this.field2045 / 8;
      this.field2045 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2577();
         int var5 = this.method2577();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.field2045 -= 8;
         this.method2560(var4);
         this.method2560(var5);
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "([IIIS)V",
      garbageValue = "20459"
   )
   public void method2590(int[] var1, int var2, int var3) {
      int var4 = this.field2045;
      this.field2045 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2577();
         int var8 = this.method2577();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.field2045 -= 8;
         this.method2560(var7);
         this.method2560(var8);
      }

      this.field2045 = var4;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "197593958"
   )
   public void method2591(int[] var1, int var2, int var3) {
      int var4 = this.field2045;
      this.field2045 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2577();
         int var8 = this.method2577();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.field2045 -= 8;
         this.method2560(var7);
         this.method2560(var8);
      }

      this.field2045 = var4;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "8192"
   )
   public boolean method2594() {
      this.field2045 -= 4;
      int var1 = class129.method2868(this.field2047, 0, this.field2045);
      int var2 = this.method2577();
      return var2 == var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1989737300"
   )
   public void method2595(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "118"
   )
   public void method2596(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "4"
   )
   public void method2597(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "318898370"
   )
   public int method2598() {
      return this.field2047[++this.field2045 - 1] - 128 & 255;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "124"
   )
   public byte method2601() {
      return (byte)(this.field2047[++this.field2045 - 1] - 128);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1675231062"
   )
   public byte method2602() {
      return (byte)(0 - this.field2047[++this.field2045 - 1]);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1003230499"
   )
   public void method2603(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)var1;
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "8"
   )
   public void method2605(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)(var1 + 128);
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1049759012"
   )
   public int method2606() {
      this.field2045 += 2;
      return (this.field2047[this.field2045 - 2] & 255) + ((this.field2047[this.field2045 - 1] & 255) << 8);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-218594067"
   )
   public int method2608() {
      this.field2045 += 2;
      return (this.field2047[this.field2045 - 2] - 128 & 255) + ((this.field2047[this.field2045 - 1] & 255) << 8);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1045294905"
   )
   public int method2610() {
      this.field2045 += 3;
      return (this.field2047[this.field2045 - 2] & 255) + ((this.field2047[this.field2045 - 3] & 255) << 16) + ((this.field2047[this.field2045 - 1] & 255) << 8);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-446216800"
   )
   public int method2616() {
      this.field2045 += 4;
      return ((this.field2047[this.field2045 - 1] & 255) << 8) + ((this.field2047[this.field2045 - 3] & 255) << 24) + ((this.field2047[this.field2045 - 4] & 255) << 16) + (this.field2047[this.field2045 - 2] & 255);
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

         field2046[var1] = var0;
      }

      field2044 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2044[var2] = var4;
      }

   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2124443849"
   )
   public void method2619(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 16);
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 24);
      this.field2047[++this.field2045 - 1] = (byte)var1;
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "230079329"
   )
   public String method2627() {
      if(this.field2047[this.field2045] == 0) {
         ++this.field2045;
         return null;
      } else {
         return this.method2580();
      }
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1288702815"
   )
   public int method2646() {
      this.field2045 += 4;
      return (this.field2047[this.field2045 - 4] & 255) + ((this.field2047[this.field2045 - 3] & 255) << 8) + ((this.field2047[this.field2045 - 2] & 255) << 16) + ((this.field2047[this.field2045 - 1] & 255) << 24);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1427612085"
   )
   public int method2655() {
      this.field2045 += 2;
      return (this.field2047[this.field2045 - 1] - 128 & 255) + ((this.field2047[this.field2045 - 2] & 255) << 8);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "125"
   )
   public void method2659(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field2047[++this.field2045 - 1] = 0;
         this.field2045 += class40.method789(var1, 0, var1.length(), this.field2047, this.field2045);
         this.field2047[++this.field2045 - 1] = 0;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1269580986"
   )
   public void method2670(int[] var1) {
      int var2 = this.field2045 / 8;
      this.field2045 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2577();
         int var5 = this.method2577();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.field2045 -= 8;
         this.method2560(var4);
         this.method2560(var5);
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "1931592936"
   )
   public void method2673(BigInteger var1, BigInteger var2) {
      int var3 = this.field2045;
      this.field2045 = 0;
      byte[] var4 = new byte[var3];
      this.method2583(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field2045 = 0;
      this.method2558(var7.length);
      this.method2742(var7, 0, var7.length);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1245313915"
   )
   public int method2687() {
      byte var1 = this.field2047[++this.field2045 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field2047[++this.field2045 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "5"
   )
   public void method2701(int var1) {
      this.field2047[this.field2045 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2121828963"
   )
   public int method2702() {
      this.field2045 += 4;
      return ((this.field2047[this.field2045 - 4] & 255) << 8) + ((this.field2047[this.field2045 - 2] & 255) << 24) + ((this.field2047[this.field2045 - 1] & 255) << 16) + (this.field2047[this.field2045 - 3] & 255);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "105"
   )
   public int method2706() {
      this.field2045 += 2;
      return ((this.field2047[this.field2045 - 2] & 255) << 8) + (this.field2047[this.field2045 - 1] & 255);
   }

   public class122(byte[] var1) {
      this.field2047 = var1;
      this.field2045 = 0;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1415733740"
   )
   public int method2718() {
      return 128 - this.field2047[++this.field2045 - 1] & 255;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "83"
   )
   public void method2723(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 8);
      this.field2047[++this.field2045 - 1] = (byte)var1;
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 24);
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1845065747"
   )
   public void method2729(int var1) {
      this.field2047[++this.field2045 - 1] = (byte)var1;
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 8);
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 16);
      this.field2047[++this.field2045 - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-224810137"
   )
   public int method2736(int var1) {
      int var2 = class129.method2868(this.field2047, var1, this.field2045);
      this.method2560(var2);
      return var2;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "257229674"
   )
   public int method2737() {
      return this.field2047[this.field2045] < 0?this.method2577() & Integer.MAX_VALUE:this.method2706();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1908306083"
   )
   public static boolean method2739(int var0) {
      if(class219.field3209[var0]) {
         return true;
      } else if(!class176.field2889.method3307(var0)) {
         return false;
      } else {
         int var1 = class176.field2889.method3317(var0);
         if(var1 == 0) {
            class219.field3209[var0] = true;
            return true;
         } else {
            if(null == class176.field2814[var0]) {
               class176.field2814[var0] = new class176[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class176.field2814[var0][var2] == null) {
                  byte[] var3 = class176.field2889.method3304(var0, var2);
                  if(var3 != null) {
                     class176.field2814[var0][var2] = new class176();
                     class176.field2814[var0][var2].field2795 = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class176.field2814[var0][var2].method3445(new class122(var3));
                     } else {
                        class176.field2814[var0][var2].method3469(new class122(var3));
                     }
                  }
               }
            }

            class219.field3209[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1000799897"
   )
   public void method2742(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.field2047[++this.field2045 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2113082100"
   )
   public void method2745(int var1) {
      this.field2047[this.field2045 - var1 - 4] = (byte)(var1 >> 24);
      this.field2047[this.field2045 - var1 - 3] = (byte)(var1 >> 16);
      this.field2047[this.field2045 - var1 - 2] = (byte)(var1 >> 8);
      this.field2047[this.field2045 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-27639"
   )
   public int method2754() {
      return 0 - this.field2047[++this.field2045 - 1] & 255;
   }
}
