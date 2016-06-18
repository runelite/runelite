import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("Buffer")
public class class119 extends class208 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1880987721
   )
   @Export("offset")
   public int field1976;
   @ObfuscatedName("x")
   static long[] field1979;
   @ObfuscatedName("b")
   @Export("payload")
   public byte[] field1982;
   @ObfuscatedName("gs")
   static class173 field1983;
   @ObfuscatedName("j")
   static int[] field1984 = new int[256];
   @ObfuscatedName("q")
   static String field1985;
   @ObfuscatedName("mh")
   static byte field1986;

   public class119(byte[] var1) {
      this.field1982 = var1;
      this.field1976 = 0;
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1599856610"
   )
   public void method2499(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)var1;
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 16);
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1032940940"
   )
   public void method2501(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 16);
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1982[++this.field1976 - 1] = (byte)var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "108145675"
   )
   public void method2502(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 24);
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 16);
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1982[++this.field1976 - 1] = (byte)var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1933419349"
   )
   public void method2505(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1976 += class121.method2776(var1, 0, var1.length(), this.field1982, this.field1976);
         this.field1982[++this.field1976 - 1] = 0;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "130128532"
   )
   public void method2507(CharSequence var1) {
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

      this.field1982[++this.field1976 - 1] = 0;
      this.method2513(var4);
      this.field1976 += class183.method3597(this.field1982, this.field1976, var1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "807855895"
   )
   public void method2508(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.field1982[++this.field1976 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1876230554"
   )
   public void method2509(int var1) {
      this.field1982[this.field1976 - var1 - 4] = (byte)(var1 >> 24);
      this.field1982[this.field1976 - var1 - 3] = (byte)(var1 >> 16);
      this.field1982[this.field1976 - var1 - 2] = (byte)(var1 >> 8);
      this.field1982[this.field1976 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-104"
   )
   public void method2510(int var1) {
      this.field1982[this.field1976 - var1 - 2] = (byte)(var1 >> 8);
      this.field1982[this.field1976 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1731672538"
   )
   public void method2511(int var1) {
      this.field1982[this.field1976 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-84"
   )
   public void method2512(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2650(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2695(var1 + '耀');
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "71"
   )
   public void method2513(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2650(var1 >>> 28 | 128);
               }

               this.method2650(var1 >>> 21 | 128);
            }

            this.method2650(var1 >>> 14 | 128);
         }

         this.method2650(var1 >>> 7 | 128);
      }

      this.method2650(var1 & 127);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1909802558"
   )
   public int method2514() {
      return this.field1982[++this.field1976 - 1] & 255;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "28"
   )
   public byte method2515() {
      return this.field1982[++this.field1976 - 1];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1956484703"
   )
   public int method2516() {
      this.field1976 += 2;
      return (this.field1982[this.field1976 - 1] & 255) + ((this.field1982[this.field1976 - 2] & 255) << 8);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1505178542"
   )
   public int method2517() {
      this.field1976 += 2;
      int var1 = ((this.field1982[this.field1976 - 2] & 255) << 8) + (this.field1982[this.field1976 - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-6"
   )
   public int method2518() {
      this.field1976 += 3;
      return (this.field1982[this.field1976 - 1] & 255) + ((this.field1982[this.field1976 - 3] & 255) << 16) + ((this.field1982[this.field1976 - 2] & 255) << 8);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1841876013"
   )
   public int method2519() {
      this.field1976 += 4;
      return (this.field1982[this.field1976 - 1] & 255) + ((this.field1982[this.field1976 - 2] & 255) << 8) + ((this.field1982[this.field1976 - 3] & 255) << 16) + ((this.field1982[this.field1976 - 4] & 255) << 24);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2004129191"
   )
   public String method2521() {
      if(this.field1982[this.field1976] == 0) {
         ++this.field1976;
         return null;
      } else {
         return this.method2522();
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-920397708"
   )
   public String method2522() {
      int var1 = this.field1976;

      while(this.field1982[++this.field1976 - 1] != 0) {
         ;
      }

      int var2 = this.field1976 - var1 - 1;
      return var2 == 0?"":class113.method2444(this.field1982, var1, var2);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "438697735"
   )
   public void method2525(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.field1982[++this.field1976 - 1];
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1358239105"
   )
   public String method2527() {
      byte var1 = this.field1982[++this.field1976 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field1976;

         while(this.field1982[++this.field1976 - 1] != 0) {
            ;
         }

         int var3 = this.field1976 - var2 - 1;
         return var3 == 0?"":class113.method2444(this.field1982, var2, var3);
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1354229513"
   )
   public int method2529() {
      byte var1 = this.field1982[++this.field1976 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field1982[++this.field1976 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-223866843"
   )
   public void method2530(int[] var1) {
      int var2 = this.field1976 / 8;
      this.field1976 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2519();
         int var5 = this.method2519();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.field1976 -= 8;
         this.method2502(var4);
         this.method2502(var5);
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-87758175"
   )
   public void method2531(int[] var1) {
      int var2 = this.field1976 / 8;
      this.field1976 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2519();
         int var5 = this.method2519();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3]) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.field1976 -= 8;
         this.method2502(var4);
         this.method2502(var5);
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-2125523591"
   )
   public void method2532(int[] var1, int var2, int var3) {
      int var4 = this.field1976;
      this.field1976 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2519();
         int var8 = this.method2519();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.field1976 -= 8;
         this.method2502(var7);
         this.method2502(var8);
      }

      this.field1976 = var4;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "1750545092"
   )
   public void method2533(int[] var1, int var2, int var3) {
      int var4 = this.field1976;
      this.field1976 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2519();
         int var8 = this.method2519();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
            var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.field1976 -= 8;
         this.method2502(var7);
         this.method2502(var8);
      }

      this.field1976 = var4;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2147483647"
   )
   public int method2535(int var1) {
      byte[] var3 = this.field1982;
      int var4 = this.field1976;
      int var5 = -1;

      for(int var6 = var1; var6 < var4; ++var6) {
         var5 = var5 >>> 8 ^ field1984[(var5 ^ var3[var6]) & 255];
      }

      var5 = ~var5;
      this.method2502(var5);
      return var5;
   }

   @ObfuscatedName("da")
   @ObfuscatedSignature(
      signature = "(Lclass173;B)Lclass173;",
      garbageValue = "-51"
   )
   static class173 method2536(class173 var0) {
      int var2 = class34.method734(var0);
      int var1 = var2 >> 17 & 7;
      int var3 = var1;
      if(var1 == 0) {
         return null;
      } else {
         for(int var4 = 0; var4 < var3; ++var4) {
            var0 = class161.method3205(var0.field2777);
            if(var0 == null) {
               return null;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2027028894"
   )
   public void method2538(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1366797462"
   )
   public void method2539(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-93"
   )
   public int method2540() {
      return this.field1982[++this.field1976 - 1] - 128 & 255;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1895045573"
   )
   public int method2542() {
      return 128 - this.field1982[++this.field1976 - 1] & 255;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "-51"
   )
   public byte method2543() {
      return (byte)(this.field1982[++this.field1976 - 1] - 128);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1150079610"
   )
   public byte method2544() {
      return (byte)(128 - this.field1982[++this.field1976 - 1]);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "24321"
   )
   public void method2545(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)var1;
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   public void method2547(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)(128 + var1);
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method2548() {
      this.field1976 += 2;
      return (this.field1982[this.field1976 - 2] & 255) + ((this.field1982[this.field1976 - 1] & 255) << 8);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1918629476"
   )
   public int method2550() {
      this.field1976 += 2;
      return ((this.field1982[this.field1976 - 1] & 255) << 8) + (this.field1982[this.field1976 - 2] - 128 & 255);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-5"
   )
   public int method2551() {
      this.field1976 += 2;
      int var1 = ((this.field1982[this.field1976 - 2] & 255) << 8) + (this.field1982[this.field1976 - 1] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public int method2552() {
      this.field1976 += 2;
      int var1 = ((this.field1982[this.field1976 - 1] & 255) << 8) + (this.field1982[this.field1976 - 2] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1529648115"
   )
   public void method2553(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)var1;
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1023473355"
   )
   public void method2556(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1982[++this.field1976 - 1] = (byte)var1;
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 24);
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-4"
   )
   public void method2557(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 16);
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 24);
      this.field1982[++this.field1976 - 1] = (byte)var1;
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-418600449"
   )
   public int method2559() {
      this.field1976 += 4;
      return (this.field1982[this.field1976 - 3] & 255) + ((this.field1982[this.field1976 - 4] & 255) << 8) + ((this.field1982[this.field1976 - 2] & 255) << 24) + ((this.field1982[this.field1976 - 1] & 255) << 16);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1656897983"
   )
   public int method2560() {
      this.field1976 += 4;
      return (this.field1982[this.field1976 - 2] & 255) + ((this.field1982[this.field1976 - 3] & 255) << 24) + ((this.field1982[this.field1976 - 4] & 255) << 16) + ((this.field1982[this.field1976 - 1] & 255) << 8);
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

         field1984[var1] = var0;
      }

      field1979 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field1979[var2] = var4;
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1505002140"
   )
   public int method2574() {
      return 0 - this.field1982[++this.field1976 - 1] & 255;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2105122087"
   )
   public void method2596(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1982[++this.field1976 - 1] = 0;
         this.field1976 += class121.method2776(var1, 0, var1.length(), this.field1982, this.field1976);
         this.field1982[++this.field1976 - 1] = 0;
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "948334197"
   )
   public void method2597(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-4088097"
   )
   public String method2640() {
      byte var1 = this.field1982[++this.field1976 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2529();
         if(var2 + this.field1976 > this.field1982.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = class188.method3752(this.field1982, this.field1976, var2);
            this.field1976 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1810442831"
   )
   public int method2642() {
      int var1 = this.field1982[this.field1976] & 255;
      return var1 < 128?this.method2514():this.method2516() - '耀';
   }

   @ObfuscatedName("r")
   public void method2647(long var1) {
      this.field1982[++this.field1976 - 1] = (byte)((int)(var1 >> 56));
      this.field1982[++this.field1976 - 1] = (byte)((int)(var1 >> 48));
      this.field1982[++this.field1976 - 1] = (byte)((int)(var1 >> 40));
      this.field1982[++this.field1976 - 1] = (byte)((int)(var1 >> 32));
      this.field1982[++this.field1976 - 1] = (byte)((int)(var1 >> 24));
      this.field1982[++this.field1976 - 1] = (byte)((int)(var1 >> 16));
      this.field1982[++this.field1976 - 1] = (byte)((int)(var1 >> 8));
      this.field1982[++this.field1976 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-82"
   )
   public void method2650(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)var1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-348334855"
   )
   public int method2661() {
      this.field1976 += 2;
      return (this.field1982[this.field1976 - 1] - 128 & 255) + ((this.field1982[this.field1976 - 2] & 255) << 8);
   }

   @ObfuscatedName("y")
   public void method2666(long var1) {
      this.field1982[++this.field1976 - 1] = (byte)((int)(var1 >> 40));
      this.field1982[++this.field1976 - 1] = (byte)((int)(var1 >> 32));
      this.field1982[++this.field1976 - 1] = (byte)((int)(var1 >> 24));
      this.field1982[++this.field1976 - 1] = (byte)((int)(var1 >> 16));
      this.field1982[++this.field1976 - 1] = (byte)((int)(var1 >> 8));
      this.field1982[++this.field1976 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "619556335"
   )
   public void method2677(BigInteger var1, BigInteger var2) {
      int var3 = this.field1976;
      this.field1976 = 0;
      byte[] var4 = new byte[var3];
      this.method2525(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field1976 = 0;
      this.method2695(var7.length);
      this.method2508(var7, 0, var7.length);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1941212401"
   )
   public boolean method2678() {
      this.field1976 -= 4;
      int var1 = class8.method114(this.field1982, 0, this.field1976);
      int var2 = this.method2519();
      return var2 == var1;
   }

   public class119(int var1) {
      this.field1982 = class121.method2777(var1);
      this.field1976 = 0;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-178806536"
   )
   public int method2689() {
      int var1 = this.field1982[this.field1976] & 255;
      return var1 < 128?this.method2514() - 64:this.method2516() - '쀀';
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "640760155"
   )
   public void method2693(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1982[++this.field1976 - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "164044594"
   )
   public void method2695(int var1) {
      this.field1982[++this.field1976 - 1] = (byte)(var1 >> 8);
      this.field1982[++this.field1976 - 1] = (byte)var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "2122431339"
   )
   public long method2699() {
      long var1 = (long)this.method2519() & 4294967295L;
      long var3 = (long)this.method2519() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2004819751"
   )
   public int method2706() {
      this.field1976 += 3;
      return ((this.field1982[this.field1976 - 1] & 255) << 16) + ((this.field1982[this.field1976 - 2] & 255) << 8) + (this.field1982[this.field1976 - 3] & 255);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int method2731() {
      return this.field1982[this.field1976] < 0?this.method2519() & Integer.MAX_VALUE:this.method2516();
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "302330537"
   )
   public int method2738() {
      this.field1976 += 4;
      return ((this.field1982[this.field1976 - 3] & 255) << 8) + ((this.field1982[this.field1976 - 1] & 255) << 24) + ((this.field1982[this.field1976 - 2] & 255) << 16) + (this.field1982[this.field1976 - 4] & 255);
   }
}
