import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("Buffer")
public class class119 extends class208 {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 780546663
   )
   @Export("offset")
   public int field1998;
   @ObfuscatedName("x")
   public static int[] field1999 = new int[256];
   @ObfuscatedName("f")
   @Export("payload")
   public byte[] field2000;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      longValue = 5546735391362462801L
   )
   static long field2001;
   @ObfuscatedName("l")
   static long[] field2002;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)B",
      garbageValue = "3115"
   )
   public byte method2538() {
      return this.field2000[++this.field1998 - 1];
   }

   public class119(byte[] var1) {
      this.field2000 = var1;
      this.field1998 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1705695059"
   )
   public void method2539(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 24);
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 16);
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field2000[++this.field1998 - 1] = (byte)var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "906450961"
   )
   public void method2540(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field2000[++this.field1998 - 1] = (byte)var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-795699487"
   )
   public void method2541(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 16);
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field2000[++this.field1998 - 1] = (byte)var1;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-1672734307"
   )
   public void method2543(int[] var1, int var2, int var3) {
      int var4 = this.field1998;
      this.field1998 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2696();
         int var8 = this.method2696();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3]) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.field1998 -= 8;
         this.method2539(var7);
         this.method2539(var8);
      }

      this.field1998 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "40"
   )
   public void method2545(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1998 += class139.method2974(var1, 0, var1.length(), this.field2000, this.field1998);
         this.field2000[++this.field1998 - 1] = 0;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-67"
   )
   public void method2546(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field2000[++this.field1998 - 1] = 0;
         this.field1998 += class139.method2974(var1, 0, var1.length(), this.field2000, this.field1998);
         this.field2000[++this.field1998 - 1] = 0;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "908366882"
   )
   public void method2549(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-129873482"
   )
   public void method2550(int var1) {
      this.field2000[this.field1998 - var1 - 2] = (byte)(var1 >> 8);
      this.field2000[this.field1998 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1976231305"
   )
   public void method2551(int var1) {
      this.field2000[this.field1998 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1765706944"
   )
   public void method2553(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2654(var1 >>> 28 | 128);
               }

               this.method2654(var1 >>> 21 | 128);
            }

            this.method2654(var1 >>> 14 | 128);
         }

         this.method2654(var1 >>> 7 | 128);
      }

      this.method2654(var1 & 127);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1591170757"
   )
   public int method2554() {
      return this.field2000[++this.field1998 - 1] & 255;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "76"
   )
   public int method2556() {
      this.field1998 += 2;
      return ((this.field2000[this.field1998 - 2] & 255) << 8) + (this.field2000[this.field1998 - 1] & 255);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2016778104"
   )
   public int method2557() {
      this.field1998 += 2;
      int var1 = (this.field2000[this.field1998 - 1] & 255) + ((this.field2000[this.field1998 - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1538970541"
   )
   public int method2558() {
      this.field1998 += 3;
      return (this.field2000[this.field1998 - 1] & 255) + ((this.field2000[this.field1998 - 3] & 255) << 16) + ((this.field2000[this.field1998 - 2] & 255) << 8);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1715551018"
   )
   public byte method2559() {
      return (byte)(0 - this.field2000[++this.field1998 - 1]);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)J",
      garbageValue = "5491"
   )
   public long method2560() {
      long var1 = (long)this.method2696() & 4294967295L;
      long var3 = (long)this.method2696() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-110"
   )
   public String method2561() {
      if(this.field2000[this.field1998] == 0) {
         ++this.field1998;
         return null;
      } else {
         return this.method2668();
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-77"
   )
   public String method2563() {
      byte var1 = this.field2000[++this.field1998 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field1998;

         while(this.field2000[++this.field1998 - 1] != 0) {
            ;
         }

         int var3 = this.field1998 - var2 - 1;
         return var3 == 0?"":class150.method3165(this.field2000, var2, var3);
      }
   }

   @ObfuscatedName("l")
   public void method2564(long var1) {
      this.field2000[++this.field1998 - 1] = (byte)((int)(var1 >> 40));
      this.field2000[++this.field1998 - 1] = (byte)((int)(var1 >> 32));
      this.field2000[++this.field1998 - 1] = (byte)((int)(var1 >> 24));
      this.field2000[++this.field1998 - 1] = (byte)((int)(var1 >> 16));
      this.field2000[++this.field1998 - 1] = (byte)((int)(var1 >> 8));
      this.field2000[++this.field1998 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1745694610"
   )
   public void method2565(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.field2000[++this.field1998 - 1];
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1875428227"
   )
   public int method2566() {
      int var1 = this.field2000[this.field1998] & 255;
      return var1 < 128?this.method2554() - 64:this.method2556() - '쀀';
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-125"
   )
   public int method2567() {
      int var1 = this.field2000[this.field1998] & 255;
      return var1 < 128?this.method2554():this.method2556() - '耀';
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-546136947"
   )
   public int method2569() {
      byte var1 = this.field2000[++this.field1998 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field2000[++this.field1998 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-2049843717"
   )
   public void method2570(int[] var1) {
      int var2 = this.field1998 / 8;
      this.field1998 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2696();
         int var5 = this.method2696();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.field1998 -= 8;
         this.method2539(var4);
         this.method2539(var5);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-445734187"
   )
   public void method2573(int[] var1, int var2, int var3) {
      int var4 = this.field1998;
      this.field1998 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2696();
         int var8 = this.method2696();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9) {
            var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.field1998 -= 8;
         this.method2539(var7);
         this.method2539(var8);
      }

      this.field1998 = var4;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "-1346987102"
   )
   public void method2574(BigInteger var1, BigInteger var2) {
      int var3 = this.field1998;
      this.field1998 = 0;
      byte[] var4 = new byte[var3];
      this.method2565(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field1998 = 0;
      this.method2540(var7.length);
      this.method2591(var7, 0, var7.length);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1581217091"
   )
   public boolean method2576() {
      this.field1998 -= 4;
      byte[] var2 = this.field2000;
      int var3 = this.field1998;
      int var4 = -1;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4 = var4 >>> 8 ^ field1999[(var4 ^ var2[var5]) & 255];
      }

      var4 = ~var4;
      var5 = this.method2696();
      return var4 == var5;
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

         field1999[var1] = var0;
      }

      field2002 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2002[var2] = var4;
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-25"
   )
   public void method2577(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-781363124"
   )
   public void method2578(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-5519"
   )
   public int method2579() {
      return this.field2000[++this.field1998 - 1] - 128 & 255;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "564017753"
   )
   public int method2580() {
      return 0 - this.field2000[++this.field1998 - 1] & 255;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "907249340"
   )
   public int method2581() {
      return 128 - this.field2000[++this.field1998 - 1] & 255;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-30696611"
   )
   public byte method2583() {
      return (byte)(128 - this.field2000[++this.field1998 - 1]);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-269598185"
   )
   public void method2584(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)var1;
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "686458347"
   )
   public void method2585(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field2000[++this.field1998 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "36"
   )
   public void method2586(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)(128 + var1);
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2067025148"
   )
   public int method2587() {
      this.field1998 += 2;
      int var1 = ((this.field2000[this.field1998 - 1] & 255) << 8) + (this.field2000[this.field1998 - 2] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1625981868"
   )
   public int method2588() {
      this.field1998 += 2;
      return (this.field2000[this.field1998 - 1] - 128 & 255) + ((this.field2000[this.field1998 - 2] & 255) << 8);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1533091658"
   )
   public void method2591(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.field2000[++this.field1998 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "7"
   )
   public void method2592(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 16);
      this.field2000[++this.field1998 - 1] = (byte)var1;
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "236103725"
   )
   public void method2593(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)var1;
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 16);
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1942253828"
   )
   public void method2594(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 8);
      this.field2000[++this.field1998 - 1] = (byte)var1;
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 24);
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1609275752"
   )
   public void method2595(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 16);
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 24);
      this.field2000[++this.field1998 - 1] = (byte)var1;
      this.field2000[++this.field1998 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-68851452"
   )
   public int method2596() {
      this.field1998 += 4;
      return (this.field2000[this.field1998 - 4] & 255) + ((this.field2000[this.field1998 - 2] & 255) << 16) + ((this.field2000[this.field1998 - 1] & 255) << 24) + ((this.field2000[this.field1998 - 3] & 255) << 8);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int method2597() {
      this.field1998 += 2;
      return (this.field2000[this.field1998 - 2] & 255) + ((this.field2000[this.field1998 - 1] & 255) << 8);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-176621058"
   )
   public int method2598() {
      this.field1998 += 4;
      return ((this.field2000[this.field1998 - 3] & 255) << 24) + ((this.field2000[this.field1998 - 4] & 255) << 16) + ((this.field2000[this.field1998 - 1] & 255) << 8) + (this.field2000[this.field1998 - 2] & 255);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "781927467"
   )
   public void method2600(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2654(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2540('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "888941754"
   )
   public void method2601(int[] var1) {
      int var2 = this.field1998 / 8;
      this.field1998 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2696();
         int var5 = this.method2696();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6) {
            var5 -= (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.field1998 -= 8;
         this.method2539(var4);
         this.method2539(var5);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "20"
   )
   public String method2608() {
      byte var1 = this.field2000[++this.field1998 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2569();
         if(var2 + this.field1998 > this.field2000.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = class162.method3219(this.field2000, this.field1998, var2);
            this.field1998 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "-1255773414"
   )
   public void method2615(CharSequence var1) {
      int var2 = class34.method769(var1);
      this.field2000[++this.field1998 - 1] = 0;
      this.method2553(var2);
      int var3 = this.field1998;
      byte[] var5 = this.field2000;
      int var6 = this.field1998;
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
      this.field1998 = var3 + var4;
   }

   @ObfuscatedName("d")
   public void method2626(long var1) {
      this.field2000[++this.field1998 - 1] = (byte)((int)(var1 >> 56));
      this.field2000[++this.field1998 - 1] = (byte)((int)(var1 >> 48));
      this.field2000[++this.field1998 - 1] = (byte)((int)(var1 >> 40));
      this.field2000[++this.field1998 - 1] = (byte)((int)(var1 >> 32));
      this.field2000[++this.field1998 - 1] = (byte)((int)(var1 >> 24));
      this.field2000[++this.field1998 - 1] = (byte)((int)(var1 >> 16));
      this.field2000[++this.field1998 - 1] = (byte)((int)(var1 >> 8));
      this.field2000[++this.field1998 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-36"
   )
   public void method2654(int var1) {
      this.field2000[++this.field1998 - 1] = (byte)var1;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "60"
   )
   public int method2662(int var1) {
      byte[] var3 = this.field2000;
      int var4 = this.field1998;
      int var5 = -1;

      for(int var6 = var1; var6 < var4; ++var6) {
         var5 = var5 >>> 8 ^ field1999[(var5 ^ var3[var6]) & 255];
      }

      var5 = ~var5;
      this.method2539(var5);
      return var5;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method2668() {
      int var1 = this.field1998;

      while(this.field2000[++this.field1998 - 1] != 0) {
         ;
      }

      int var2 = this.field1998 - var1 - 1;
      return var2 == 0?"":class150.method3165(this.field2000, var1, var2);
   }

   public class119(int var1) {
      this.field2000 = class121.method2765(var1);
      this.field1998 = 0;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1564049411"
   )
   public int method2689() {
      this.field1998 += 2;
      int var1 = ((this.field2000[this.field1998 - 1] & 255) << 8) + (this.field2000[this.field1998 - 2] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "82"
   )
   public void method2692(int var1) {
      this.field2000[this.field1998 - var1 - 4] = (byte)(var1 >> 24);
      this.field2000[this.field1998 - var1 - 3] = (byte)(var1 >> 16);
      this.field2000[this.field1998 - var1 - 2] = (byte)(var1 >> 8);
      this.field2000[this.field1998 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-509751246"
   )
   public int method2695() {
      this.field1998 += 2;
      return (this.field2000[this.field1998 - 2] - 128 & 255) + ((this.field2000[this.field1998 - 1] & 255) << 8);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1924592065"
   )
   public int method2696() {
      this.field1998 += 4;
      return (this.field2000[this.field1998 - 1] & 255) + ((this.field2000[this.field1998 - 3] & 255) << 16) + ((this.field2000[this.field1998 - 4] & 255) << 24) + ((this.field2000[this.field1998 - 2] & 255) << 8);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1500177841"
   )
   public int method2728() {
      return this.field2000[this.field1998] < 0?this.method2696() & Integer.MAX_VALUE:this.method2556();
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-198299797"
   )
   public int method2730() {
      this.field1998 += 4;
      return (this.field2000[this.field1998 - 3] & 255) + ((this.field2000[this.field1998 - 2] & 255) << 24) + ((this.field2000[this.field1998 - 1] & 255) << 16) + ((this.field2000[this.field1998 - 4] & 255) << 8);
   }
}
