import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("k")
   @Export("payload")
   public byte[] payload;
   @ObfuscatedName("v")
   static long[] field2055;
   @ObfuscatedName("f")
   static int[] field2058 = new int[256];
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1277364705
   )
   @Export("offset")
   public int offset;
   @ObfuscatedName("bn")
   static class171 field2060;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method2554() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.method2571():this.method2691() - '耀';
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1277399370"
   )
   public void method2556(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "900579136"
   )
   public void method2558(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-466913900"
   )
   public void method2559(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1792051228"
   )
   public void method2562(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += class52.method1083(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-38"
   )
   public void method2563(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += class52.method1083(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "0"
   )
   public void method2564(CharSequence var1) {
      int var2 = class153.method3160(var1);
      this.payload[++this.offset - 1] = 0;
      this.method2570(var2);
      this.offset += class34.method720(this.payload, this.offset, var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1591802705"
   )
   public void method2565(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-43"
   )
   public String method2566() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2587();
         if(var2 + this.offset > this.payload.length) {
            throw new IllegalStateException("");
         } else {
            byte[] var4 = this.payload;
            int var5 = this.offset;
            char[] var6 = new char[var2];
            int var7 = 0;
            int var8 = var5;

            int var11;
            for(int var9 = var2 + var5; var8 < var9; var6[var7++] = (char)var11) {
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
                  if(1 + var8 < var9 && (var4[var8] & 192) == 128 && (var4[1 + var8] & 192) == 128) {
                     var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 < 2048) {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else if(var10 < 248) {
                  if(2 + var8 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128 && (var4[var8 + 2] & 192) == 128) {
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
            this.offset += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1963404492"
   )
   public int method2567() {
      if(this.payload[this.offset] < 0) {
         return this.method2576() & Integer.MAX_VALUE;
      } else {
         int var1 = this.method2691();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "6"
   )
   public void method2568(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1549291455"
   )
   public void method2569(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2556(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2638('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1412584499"
   )
   public void method2570(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2556(var1 >>> 28 | 128);
               }

               this.method2556(var1 >>> 21 | 128);
            }

            this.method2556(var1 >>> 14 | 128);
         }

         this.method2556(var1 >>> 7 | 128);
      }

      this.method2556(var1 & 127);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-537688256"
   )
   public int method2571() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "2079587085"
   )
   public byte method2572() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-49"
   )
   public void method2573(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-35"
   )
   public int method2574() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-24"
   )
   public int method2575() {
      this.offset += 3;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1054971589"
   )
   public int method2576() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 24) + ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "10669"
   )
   public String method2579() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":class144.method3011(this.payload, var1, var2);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "108"
   )
   public String method2580() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.payload[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":class144.method3011(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-602906101"
   )
   public void method2582(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2051649262"
   )
   public int method2583() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.method2571() - 64:this.method2691() - '쀀';
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2050815135"
   )
   public void method2584(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1374069475"
   )
   public int method2585() {
      return this.payload[this.offset] < 0?this.method2576() & Integer.MAX_VALUE:this.method2691();
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1789879964"
   )
   public int method2586() {
      this.offset += 2;
      return (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-30"
   )
   public int method2587() {
      byte var1 = this.payload[++this.offset - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.payload[++this.offset - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "1611341126"
   )
   public void method2588(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2576();
         int var5 = this.method2576();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3]) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.offset -= 8;
         this.method2559(var4);
         this.method2559(var5);
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "93"
   )
   public void method2589(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2576();
         int var5 = this.method2576();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var6 + var1[var6 & 3]) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.offset -= 8;
         this.method2559(var4);
         this.method2559(var5);
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "-50"
   )
   public void method2590(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2576();
         int var8 = this.method2576();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.offset -= 8;
         this.method2559(var7);
         this.method2559(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-2104231956"
   )
   public void method2591(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2576();
         int var8 = this.method2576();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var9 & 3] + var9) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.offset -= 8;
         this.method2559(var7);
         this.method2559(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "1597019014"
   )
   public void method2592(BigInteger var1, BigInteger var2) {
      int var3 = this.offset;
      this.offset = 0;
      byte[] var4 = new byte[var3];
      this.method2582(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.offset = 0;
      this.method2638(var7.length);
      this.method2565(var7, 0, var7.length);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "308617410"
   )
   public boolean method2594() {
      this.offset -= 4;
      int var1 = class125.method2833(this.payload, 0, this.offset);
      int var2 = this.method2576();
      return var2 == var1;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "367152347"
   )
   public int method2595() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "106"
   )
   public void method2596(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-64"
   )
   static final void method2597(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field483; ++var4) {
         if(Client.widgetPositionX[var4] + Client.widgetBoundsWidth[var4] > var0 && Client.widgetPositionX[var4] < var2 + var0 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field486[var4] = true;
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-794430459"
   )
   public int method2598() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-43"
   )
   public int method2599() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-513210329"
   )
   public byte method2602() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-63"
   )
   public void method2603(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "496061701"
   )
   public void method2605(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "758179326"
   )
   public int method2606() {
      this.offset += 2;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "5"
   )
   public int method2608() {
      this.offset += 2;
      return (this.payload[this.offset - 2] - 128 & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method2609() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1311566799"
   )
   public int method2611() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 2] - 128 & 255) + ((this.payload[this.offset - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1891654633"
   )
   public void method2613(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-436849944"
   )
   public void method2614(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "421517787"
   )
   public void method2615(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-790431195"
   )
   public int method2616() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 1] & 255) << 24) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 8);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-334794280"
   )
   public int method2617() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8) + (this.payload[this.offset - 3] & 255);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-46"
   )
   public int method2618() {
      this.offset += 4;
      return ((this.payload[this.offset - 4] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 24) + ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-26"
   )
   public int method2619() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("j")
   public void method2634(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2067636075"
   )
   public String method2637() {
      if(this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.method2579();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "227137311"
   )
   public void method2638(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
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

         field2058[var1] = var0;
      }

      field2055 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2055[var2] = var4;
      }

   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-115"
   )
   public int method2645() {
      this.offset += 3;
      return ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 8) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("m")
   public void method2667(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 56));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 48));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "20"
   )
   public int method2690(int var1) {
      int var2 = class125.method2833(this.payload, var1, this.offset);
      this.method2559(var2);
      return var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1995763109"
   )
   public int method2691() {
      this.offset += 2;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "78"
   )
   public void method2700(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1113493696"
   )
   public long method2704() {
      long var1 = (long)this.method2576() & 4294967295L;
      long var3 = (long)this.method2576() & 4294967295L;
      return var3 + (var1 << 32);
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1951344544"
   )
   public void method2754(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-7486814"
   )
   public void method2756(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "-18"
   )
   public byte method2762() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   public Buffer(int var1) {
      this.payload = class124.method2801(var1);
      this.offset = 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;B)[LSpritePixels;",
      garbageValue = "-54"
   )
   public static SpritePixels[] method2769(class170 var0, String var1, String var2) {
      int var3 = var0.method3327(var1);
      int var4 = var0.method3325(var3, var2);
      SpritePixels[] var5;
      if(!XClanMember.method604(var0, var3, var4)) {
         var5 = null;
      } else {
         SpritePixels[] var7 = new SpritePixels[class79.field1441];

         for(int var8 = 0; var8 < class79.field1441; ++var8) {
            SpritePixels var9 = var7[var8] = new SpritePixels();
            var9.field1460 = class79.field1436;
            var9.field1464 = class79.field1437;
            var9.field1455 = class134.field2117[var8];
            var9.field1459 = class79.field1438[var8];
            var9.width = class79.field1439[var8];
            var9.height = ChatLineBuffer.field693[var8];
            int var10 = var9.width * var9.height;
            byte[] var11 = class110.field1936[var8];
            var9.image = new int[var10];

            for(int var12 = 0; var12 < var10; ++var12) {
               var9.image[var12] = class26.field634[var11[var12] & 255];
            }
         }

         NPC.method745();
         var5 = var7;
      }

      return var5;
   }
}
