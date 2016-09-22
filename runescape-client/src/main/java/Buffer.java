import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("z")
   static long[] field2069;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -14041083
   )
   @Export("offset")
   public int offset;
   @ObfuscatedName("v")
   static int[] field2071 = new int[256];
   @ObfuscatedName("qv")
   @Export("bufferProvider")
   public static BufferProvider bufferProvider;
   @ObfuscatedName("a")
   @Export("payload")
   public byte[] payload;

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "388474539"
   )
   public void method2513(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-406798568"
   )
   public void method2514(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "564789631"
   )
   public void method2516(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2533();
         int var5 = this.method2533();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var6 + var1[var6 & 3]) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.offset -= 8;
         this.method2600(var4);
         this.method2600(var5);
      }

   }

   @ObfuscatedName("t")
   public void method2517(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "2093565163"
   )
   public void method2519(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += CollisionData.method2410(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1265582099"
   )
   public void method2520(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += CollisionData.method2410(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "11"
   )
   public void method2521(CharSequence var1) {
      int var2 = class18.method198(var1);
      this.payload[++this.offset - 1] = 0;
      this.method2623(var2);
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1670709906"
   )
   public void method2523(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "638245360"
   )
   public int method2526() {
      this.offset += 4;
      return ((this.payload[this.offset - 4] & 255) << 8) + ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 24) + (this.payload[this.offset - 3] & 255);
   }

   @ObfuscatedName("n")
   public void method2527(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 56));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 48));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1332154147"
   )
   public int method2528() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "-17"
   )
   public byte method2529() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1390722094"
   )
   public String method2530() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":class166.method3283(this.payload, var1, var2);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1274883530"
   )
   public String method2531() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.payload[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":class166.method3283(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-32"
   )
   public int method2532() {
      this.offset += 3;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "41"
   )
   public int method2533() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 24) + ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "71"
   )
   public long method2534() {
      long var1 = (long)this.method2533() & 4294967295L;
      long var3 = (long)this.method2533() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "18297"
   )
   public String method2535() {
      if(this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.method2530();
      }
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "86"
   )
   public void method2536(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-264958474"
   )
   public int method2540() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.method2528() - 64:this.method2717() - '쀀';
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1733260441"
   )
   public void method2541(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method2542() {
      return this.payload[this.offset] < 0?this.method2533() & Integer.MAX_VALUE:this.method2717();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-5"
   )
   public int method2543() {
      if(this.payload[this.offset] < 0) {
         return this.method2533() & Integer.MAX_VALUE;
      } else {
         int var1 = this.method2717();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "-19"
   )
   public void method2545(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2533();
         int var5 = this.method2533();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3]) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.offset -= 8;
         this.method2600(var4);
         this.method2600(var5);
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-659206303"
   )
   public void method2547(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2533();
         int var8 = this.method2533();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3]) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.offset -= 8;
         this.method2600(var7);
         this.method2600(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-2029103591"
   )
   public void method2548(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2533();
         int var8 = this.method2533();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var9 + var1[var9 & 3]) {
            var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.offset -= 8;
         this.method2600(var7);
         this.method2600(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-674301404"
   )
   public int method2550(int var1) {
      int var2 = class109.method2403(this.payload, var1, this.offset);
      this.method2600(var2);
      return var2;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "465949025"
   )
   public void method2552(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-38"
   )
   public void method2554(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "126"
   )
   public int method2555() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1380869353"
   )
   public int method2556() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-97"
   )
   public int method2557() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-66"
   )
   public void method2558(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-78"
   )
   public String method2559() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2689();
         if(this.offset + var2 > this.payload.length) {
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
                  if(var8 + 2 < var9 && (var4[var8] & 192) == 128 && (var4[1 + var8] & 192) == 128 && (var4[2 + var8] & 192) == 128) {
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

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1919975747"
   )
   public void method2562(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1804024088"
   )
   public void method2563(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "619731442"
   )
   public void method2564(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "999950830"
   )
   public int method2565() {
      this.offset += 2;
      return (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2058743059"
   )
   public int method2566() {
      this.offset += 2;
      return (this.payload[this.offset - 2] - 128 & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2113649963"
   )
   public int method2567() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "198095564"
   )
   public int method2568() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 2] - 128 & 255) + ((this.payload[this.offset - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-107733628"
   )
   public int method2570() {
      this.offset += 3;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 1] & 255) << 16) + (this.payload[this.offset - 3] & 255);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2100997618"
   )
   public void method2572(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1063783668"
   )
   public int method2574() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 255) << 24) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 8) + (this.payload[this.offset - 4] & 255);
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "69"
   )
   public int method2576() {
      this.offset += 4;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 4] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 24) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1811745870"
   )
   public void method2578(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
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

         field2071[var1] = var0;
      }

      field2069 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2069[var2] = var4;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-43"
   )
   public void method2591(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "1815694931"
   )
   static final byte[] method2594(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.method2528();
      int var3 = var1.method2533();
      if(var3 >= 0 && (class170.field2747 == 0 || var3 <= class170.field2747)) {
         if(var2 == 0) {
            byte[] var6 = new byte[var3];
            var1.method2726(var6, 0, var3);
            return var6;
         } else {
            int var4 = var1.method2533();
            if(var4 < 0 || class170.field2747 != 0 && var4 > class170.field2747) {
               throw new RuntimeException();
            } else {
               byte[] var5 = new byte[var4];
               if(var2 == 1) {
                  class120.method2494(var5, var4, var0, var3, 9);
               } else {
                  class170.field2734.method2475(var1, var5);
               }

               return var5;
            }
         }
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-665724721"
   )
   public void method2600(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1294753728"
   )
   public void method2603(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2513(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2514('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "-1109880068"
   )
   public void method2612(BigInteger var1, BigInteger var2) {
      int var3 = this.offset;
      this.offset = 0;
      byte[] var4 = new byte[var3];
      this.method2726(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.offset = 0;
      this.method2514(var7.length);
      this.method2667(var7, 0, var7.length);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "27666"
   )
   public int method2618() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-796804012"
   )
   public void method2623(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2513(var1 >>> 28 | 128);
               }

               this.method2513(var1 >>> 21 | 128);
            }

            this.method2513(var1 >>> 14 | 128);
         }

         this.method2513(var1 >>> 7 | 128);
      }

      this.method2513(var1 & 127);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "231151958"
   )
   public byte method2624() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "480721008"
   )
   public boolean method2625() {
      this.offset -= 4;
      int var1 = class109.method2403(this.payload, 0, this.offset);
      int var2 = this.method2533();
      return var2 == var1;
   }

   public Buffer(int var1) {
      this.payload = class124.method2778(var1);
      this.offset = 0;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "-55"
   )
   public byte method2650() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "-11"
   )
   public void method2667(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-763936426"
   )
   public byte method2685() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-119"
   )
   public int method2689() {
      byte var1 = this.payload[++this.offset - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.payload[++this.offset - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1391011159"
   )
   public int method2710() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.method2528():this.method2717() - '耀';
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1966685100"
   )
   public void method2711(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1191185044"
   )
   public int method2717() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2118324488"
   )
   public void method2726(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "32819773"
   )
   public int method2731() {
      this.offset += 2;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-540324013"
   )
   public static void method2742() {
      class140 var0 = class140.keyboard;
      synchronized(class140.keyboard) {
         ++class140.keyboardIdleTicks;
         class140.field2185 = class140.field2197;
         class140.field2174 = 0;
         int var1;
         if(class140.field2193 < 0) {
            for(var1 = 0; var1 < 112; ++var1) {
               class140.field2190[var1] = false;
            }

            class140.field2193 = class140.field2192;
         } else {
            while(class140.field2193 != class140.field2192) {
               var1 = class140.field2191[class140.field2192];
               class140.field2192 = 1 + class140.field2192 & 127;
               if(var1 < 0) {
                  class140.field2190[~var1] = false;
               } else {
                  if(!class140.field2190[var1] && class140.field2174 < class140.field2196.length - 1) {
                     class140.field2196[++class140.field2174 - 1] = var1;
                  }

                  class140.field2190[var1] = true;
               }
            }
         }

         class140.field2197 = class140.field2202;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "15"
   )
   public void method2743(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }
}
