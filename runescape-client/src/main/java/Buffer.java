import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("e")
   static int[] field2044 = new int[256];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1529111311
   )
   @Export("offset")
   public int offset;
   @ObfuscatedName("n")
   static long[] field2046;
   @ObfuscatedName("i")
   @Export("payload")
   public byte[] payload;

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method2528() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1030108207"
   )
   public void method2529(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1060884241"
   )
   public void method2531(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method2532() {
      if(this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.method2552();
      }
   }

   @ObfuscatedName("u")
   public void method2533(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "16"
   )
   public void method2535(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += KitDefinition.method966(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2143267253"
   )
   public void method2536(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += KitDefinition.method966(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "912477186"
   )
   public void method2537(CharSequence var1) {
      int var3 = var1.length();
      int var4 = 0;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         char var6 = var1.charAt(var5);
         if(var6 <= 127) {
            ++var4;
         } else if(var6 <= 2047) {
            var4 += 2;
         } else {
            var4 += 3;
         }
      }

      this.payload[++this.offset - 1] = 0;
      this.method2543(var4);
      var4 = this.offset;
      byte[] var12 = this.payload;
      int var7 = this.offset;
      int var8 = var1.length();
      int var9 = var7;

      for(int var10 = 0; var10 < var8; ++var10) {
         char var11 = var1.charAt(var10);
         if(var11 <= 127) {
            var12[var9++] = (byte)var11;
         } else if(var11 <= 2047) {
            var12[var9++] = (byte)(192 | var11 >> 6);
            var12[var9++] = (byte)(128 | var11 & 63);
         } else {
            var12[var9++] = (byte)(224 | var11 >> 12);
            var12[var9++] = (byte)(128 | var11 >> 6 & 63);
            var12[var9++] = (byte)(128 | var11 & 63);
         }
      }

      var5 = var9 - var7;
      this.offset = var4 + var5;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-238909120"
   )
   public void method2542(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2529(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2701('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "866580208"
   )
   public void method2543(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2529(var1 >>> 28 | 128);
               }

               this.method2529(var1 >>> 21 | 128);
            }

            this.method2529(var1 >>> 14 | 128);
         }

         this.method2529(var1 >>> 7 | 128);
      }

      this.method2529(var1 & 127);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-54"
   )
   public int method2544() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1965812035"
   )
   public byte method2545() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "31893"
   )
   public int method2546() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-22371"
   )
   public int method2547() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1258933614"
   )
   public int method2548() {
      this.offset += 3;
      return ((this.payload[this.offset - 3] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method2549() {
      this.offset += 4;
      return ((this.payload[this.offset - 3] & 255) << 16) + ((this.payload[this.offset - 4] & 255) << 24) + ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1757043432"
   )
   public String method2552() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":RSCanvas.method2975(this.payload, var1, var2);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1188277355"
   )
   public String method2553() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.payload[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":RSCanvas.method2975(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "99"
   )
   public String method2554() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2616();
         if(this.offset + var2 > this.payload.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = ChatMessages.method212(this.payload, this.offset, var2);
            this.offset += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-570051956"
   )
   public void method2555(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1726723647"
   )
   public int method2556() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.method2544() - 64:this.method2546() - '쀀';
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-101"
   )
   public int method2558() {
      return this.payload[this.offset] < 0?this.method2549() & Integer.MAX_VALUE:this.method2546();
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "([IS)V",
      garbageValue = "-9500"
   )
   public void method2562(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2549();
         int var5 = this.method2549();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6) {
            var5 -= (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.offset -= 8;
         this.method2709(var4);
         this.method2709(var5);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "162038429"
   )
   public void method2563(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "2080871736"
   )
   public void method2564(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2549();
         int var8 = this.method2549();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.offset -= 8;
         this.method2709(var7);
         this.method2709(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "478028863"
   )
   public void method2565(BigInteger var1, BigInteger var2) {
      int var3 = this.offset;
      this.offset = 0;
      byte[] var4 = new byte[var3];
      this.method2555(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.offset = 0;
      this.method2701(var7.length);
      this.method2581(var7, 0, var7.length);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1340036642"
   )
   public long method2566() {
      long var1 = (long)this.method2549() & 4294967295L;
      long var3 = (long)this.method2549() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "28"
   )
   public boolean method2567() {
      this.offset -= 4;
      int var1 = class75.method1613(this.payload, 0, this.offset);
      int var2 = this.method2549();
      return var1 == var2;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "8697"
   )
   public void method2568(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-180308044"
   )
   public void method2569(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1496051571"
   )
   public int method2570() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 2] - 128 & 255) + ((this.payload[this.offset - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-406337420"
   )
   public int method2571() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method2572() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] - 128 & 255);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1296328336"
   )
   public int method2573() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.method2544():this.method2546() - '耀';
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1762224872"
   )
   public byte method2574() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1722039509"
   )
   public void method2577(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IS)I",
      garbageValue = "-8089"
   )
   public int method2578(int var1) {
      int var2 = class75.method1613(this.payload, var1, this.offset);
      this.method2709(var2);
      return var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-62519839"
   )
   public void method2581(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-2473"
   )
   public int method2582() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-676255312"
   )
   public void method2584(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1046942221"
   )
   public int method2589() {
      this.offset += 4;
      return (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 4] & 255) << 8);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1680623962"
   )
   public int method2590() {
      this.offset += 4;
      return ((this.payload[this.offset - 4] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 24) + ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] & 255);
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

         field2044[var1] = var0;
      }

      field2046 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2046[var2] = var4;
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1373073905"
   )
   public void method2610(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-57"
   )
   public int method2616() {
      byte var1 = this.payload[++this.offset - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.payload[++this.offset - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-22"
   )
   public int method2617() {
      if(this.payload[this.offset] < 0) {
         return this.method2549() & Integer.MAX_VALUE;
      } else {
         int var1 = this.method2546();
         return var1 == 32767?-1:var1;
      }
   }

   public Buffer(int var1) {
      this.payload = class124.method2780(var1);
      this.offset = 0;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "376449059"
   )
   public int method2620() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "2064358027"
   )
   public void method2629(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2549();
         int var8 = this.method2549();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ var9 + var1[var9 >>> 11 & 3]) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.offset -= 8;
         this.method2709(var7);
         this.method2709(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2145826519"
   )
   public void method2636(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2065602069"
   )
   public int method2653() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1933938993"
   )
   public void method2656(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "1024"
   )
   public void method2666(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "404781724"
   )
   public void method2672(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("d")
   public void method2678(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 56));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 48));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "75"
   )
   public void method2694(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-8"
   )
   public void method2700(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1135818583"
   )
   public void method2701(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-419173536"
   )
   public void method2709(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1707567775"
   )
   public int method2715() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 255) << 24) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 8) + (this.payload[this.offset - 4] & 255);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "466864581"
   )
   public void method2718(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2549();
         int var5 = this.method2549();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.offset -= 8;
         this.method2709(var4);
         this.method2709(var5);
      }

   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "443258560"
   )
   public int method2725() {
      this.offset += 2;
      return (this.payload[this.offset - 2] - 128 & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "31"
   )
   public void method2731(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1379954422"
   )
   public byte method2739() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1543309321"
   )
   static void method2743() {
      int var0 = GameEngine.field2241;
      int var1 = GameEngine.field2252;
      int var2 = class116.field2012 - class62.field1267 - var0;
      int var3 = class18.field276 - class77.field1428 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = class168.field2706.method3081();
            int var5 = 0;
            int var6 = 0;
            if(var4 == class0.field15) {
               Insets var7 = class0.field15.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class18.field276);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class116.field2012, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class116.field2012 - var2, var6, var2, class18.field276);
            }

            if(var3 > 0) {
               var9.fillRect(var5, var6 + class18.field276 - var3, class116.field2012, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method2744() {
      for(class16 var0 = (class16)Client.field571.method3845(); null != var0; var0 = (class16)Client.field571.method3847()) {
         if(var0.field242 == -1) {
            var0.field244 = 0;
            class14.method171(var0);
         } else {
            var0.unlink();
         }
      }

   }
}
