import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dx")
@Implements("Buffer")
public class class119 extends class208 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -267635635
   )
   @Export("offset")
   public int field1971;
   @ObfuscatedName("m")
   static int[] field1972 = new int[256];
   @ObfuscatedName("j")
   @Export("payload")
   public byte[] field1973;
   @ObfuscatedName("x")
   static long[] field1978;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1413448922"
   )
   public void method2486(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 8);
      this.field1973[++this.field1971 - 1] = (byte)var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1933093391"
   )
   public void method2487(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 16);
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 8);
      this.field1973[++this.field1971 - 1] = (byte)var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-45"
   )
   public void method2488(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 24);
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 16);
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 8);
      this.field1973[++this.field1971 - 1] = (byte)var1;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "102"
   )
   public void method2489(int[] var1) {
      int var2 = this.field1971 / 8;
      this.field1971 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2505();
         int var5 = this.method2505();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6) {
            var5 -= (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.field1971 -= 8;
         this.method2488(var4);
         this.method2488(var5);
      }

   }

   @ObfuscatedName("i")
   public void method2490(long var1) {
      this.field1973[++this.field1971 - 1] = (byte)((int)(var1 >> 56));
      this.field1973[++this.field1971 - 1] = (byte)((int)(var1 >> 48));
      this.field1973[++this.field1971 - 1] = (byte)((int)(var1 >> 40));
      this.field1973[++this.field1971 - 1] = (byte)((int)(var1 >> 32));
      this.field1973[++this.field1971 - 1] = (byte)((int)(var1 >> 24));
      this.field1973[++this.field1971 - 1] = (byte)((int)(var1 >> 16));
      this.field1973[++this.field1971 - 1] = (byte)((int)(var1 >> 8));
      this.field1973[++this.field1971 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "409805705"
   )
   public void method2491(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1971 += class6.method103(var1, 0, var1.length(), this.field1973, this.field1971);
         this.field1973[++this.field1971 - 1] = 0;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-2085774799"
   )
   public void method2492(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field1973[++this.field1971 - 1] = 0;
         this.field1971 += class6.method103(var1, 0, var1.length(), this.field1973, this.field1971);
         this.field1973[++this.field1971 - 1] = 0;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "0"
   )
   public void method2494(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.field1973[++this.field1971 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-18"
   )
   public void method2495(int var1) {
      this.field1973[this.field1971 - var1 - 4] = (byte)(var1 >> 24);
      this.field1973[this.field1971 - var1 - 3] = (byte)(var1 >> 16);
      this.field1973[this.field1971 - var1 - 2] = (byte)(var1 >> 8);
      this.field1973[this.field1971 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2127698605"
   )
   public void method2496(int var1) {
      this.field1973[this.field1971 - var1 - 2] = (byte)(var1 >> 8);
      this.field1973[this.field1971 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "116482907"
   )
   public void method2497(int var1) {
      this.field1973[this.field1971 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1530212581"
   )
   public void method2499(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if(0 != (var1 & -2097152)) {
               if(0 != (var1 & -268435456)) {
                  this.method2503(var1 >>> 28 | 128);
               }

               this.method2503(var1 >>> 21 | 128);
            }

            this.method2503(var1 >>> 14 | 128);
         }

         this.method2503(var1 >>> 7 | 128);
      }

      this.method2503(var1 & 127);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "18142916"
   )
   public int method2500() {
      return this.field1973[++this.field1971 - 1] & 255;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-590406923"
   )
   public int method2501() {
      this.field1971 += 2;
      int var1 = ((this.field1973[this.field1971 - 2] & 255) << 8) + (this.field1973[this.field1971 - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-105704569"
   )
   public int method2502() {
      this.field1971 += 2;
      return ((this.field1973[this.field1971 - 2] & 255) << 8) + (this.field1973[this.field1971 - 1] & 255);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2031499509"
   )
   public void method2503(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2132701967"
   )
   public int method2505() {
      this.field1971 += 4;
      return (this.field1973[this.field1971 - 1] & 255) + ((this.field1973[this.field1971 - 2] & 255) << 8) + ((this.field1973[this.field1971 - 4] & 255) << 24) + ((this.field1973[this.field1971 - 3] & 255) << 16);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1554642293"
   )
   public long method2506() {
      long var1 = (long)this.method2505() & 4294967295L;
      long var3 = (long)this.method2505() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1533545754"
   )
   public String method2507() {
      if(this.field1973[this.field1971] == 0) {
         ++this.field1971;
         return null;
      } else {
         return this.method2508();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "38"
   )
   public String method2508() {
      int var1 = this.field1971;

      while(this.field1973[++this.field1971 - 1] != 0) {
         ;
      }

      int var2 = this.field1971 - var1 - 1;
      return var2 == 0?"":class139.method2912(this.field1973, var1, var2);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "11"
   )
   public String method2509() {
      byte var1 = this.field1973[++this.field1971 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field1971;

         while(this.field1973[++this.field1971 - 1] != 0) {
            ;
         }

         int var3 = this.field1971 - var2 - 1;
         return 0 == var3?"":class139.method2912(this.field1973, var2, var3);
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1274432044"
   )
   public String method2510() {
      byte var1 = this.field1973[++this.field1971 - 1];
      if(0 != var1) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2602();
         if(var2 + this.field1971 > this.field1973.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = class87.method2079(this.field1973, this.field1971, var2);
            this.field1971 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "([BIIS)V",
      garbageValue = "0"
   )
   public void method2511(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.field1973[++this.field1971 - 1];
      }

   }

   public class119(byte[] var1) {
      this.field1973 = var1;
      this.field1971 = 0;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-8"
   )
   public int method2512() {
      int var1 = this.field1973[this.field1971] & 255;
      return var1 < 128?this.method2500():this.method2502() - '耀';
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-107865718"
   )
   public int method2513() {
      return this.field1973[this.field1971] < 0?this.method2505() & Integer.MAX_VALUE:this.method2502();
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-2098416151"
   )
   public void method2515(int[] var1) {
      int var2 = this.field1971 / 8;
      this.field1971 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2505();
         int var5 = this.method2505();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3]) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.field1971 -= 8;
         this.method2488(var4);
         this.method2488(var5);
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-2083507722"
   )
   public void method2517(int[] var1, int var2, int var3) {
      int var4 = this.field1971;
      this.field1971 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2505();
         int var8 = this.method2505();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3]) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.field1971 -= 8;
         this.method2488(var7);
         this.method2488(var8);
      }

      this.field1971 = var4;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;S)V",
      garbageValue = "10773"
   )
   public void method2519(BigInteger var1, BigInteger var2) {
      int var3 = this.field1971;
      this.field1971 = 0;
      byte[] var4 = new byte[var3];
      this.method2511(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field1971 = 0;
      this.method2486(var7.length);
      this.method2494(var7, 0, var7.length);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1011079241"
   )
   public int method2520(int var1) {
      byte[] var3 = this.field1973;
      int var4 = this.field1971;
      int var5 = -1;

      for(int var6 = var1; var6 < var4; ++var6) {
         var5 = var5 >>> 8 ^ field1972[(var5 ^ var3[var6]) & 255];
      }

      var5 = ~var5;
      this.method2488(var5);
      return var5;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "109"
   )
   public byte method2521() {
      return (byte)(128 - this.field1973[++this.field1971 - 1]);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   public void method2523(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1446901245"
   )
   public int method2526() {
      return 0 - this.field1973[++this.field1971 - 1] & 255;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-555531329"
   )
   public int method2527() {
      return 128 - this.field1973[++this.field1971 - 1] & 255;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1096039460"
   )
   public byte method2528() {
      return (byte)(this.field1973[++this.field1971 - 1] - 128);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "16"
   )
   public byte method2529() {
      return (byte)(0 - this.field1973[++this.field1971 - 1]);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-570901074"
   )
   public boolean method2531() {
      this.field1971 -= 4;
      byte[] var2 = this.field1973;
      int var3 = this.field1971;
      int var4 = -1;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         var4 = var4 >>> 8 ^ field1972[(var4 ^ var2[var5]) & 255];
      }

      var4 = ~var4;
      var5 = this.method2505();
      return var4 == var5;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2034867637"
   )
   public void method2533(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)(128 + var1);
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1828888619"
   )
   public int method2534() {
      this.field1971 += 2;
      return ((this.field1973[this.field1971 - 1] & 255) << 8) + (this.field1973[this.field1971 - 2] & 255);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "538945627"
   )
   public int method2535() {
      this.field1971 += 2;
      return ((this.field1973[this.field1971 - 2] & 255) << 8) + (this.field1973[this.field1971 - 1] - 128 & 255);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1259266166"
   )
   public int method2536() {
      this.field1971 += 2;
      return (this.field1973[this.field1971 - 2] - 128 & 255) + ((this.field1973[this.field1971 - 1] & 255) << 8);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-5518"
   )
   public int method2538() {
      this.field1971 += 2;
      int var1 = ((this.field1973[this.field1971 - 2] & 255) << 8) + (this.field1973[this.field1971 - 1] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-83"
   )
   public void method2539(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 16);
      this.field1973[++this.field1971 - 1] = (byte)var1;
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1412009548"
   )
   public void method2540(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)var1;
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 8);
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 16);
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1407066398"
   )
   public void method2541(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 8);
      this.field1973[++this.field1971 - 1] = (byte)var1;
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 24);
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "339363181"
   )
   public void method2542(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 16);
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 24);
      this.field1973[++this.field1971 - 1] = (byte)var1;
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1173633270"
   )
   public int method2543() {
      this.field1971 += 4;
      return ((this.field1973[this.field1971 - 2] & 255) << 16) + ((this.field1973[this.field1971 - 1] & 255) << 24) + ((this.field1973[this.field1971 - 3] & 255) << 8) + (this.field1973[this.field1971 - 4] & 255);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1746048095"
   )
   public int method2544() {
      this.field1971 += 4;
      return ((this.field1973[this.field1971 - 1] & 255) << 16) + ((this.field1973[this.field1971 - 2] & 255) << 24) + ((this.field1973[this.field1971 - 4] & 255) << 8) + (this.field1973[this.field1971 - 3] & 255);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "64"
   )
   public int method2545() {
      this.field1971 += 4;
      return ((this.field1973[this.field1971 - 4] & 255) << 16) + ((this.field1973[this.field1971 - 3] & 255) << 24) + ((this.field1973[this.field1971 - 1] & 255) << 8) + (this.field1973[this.field1971 - 2] & 255);
   }

   public class119(int var1) {
      this.field1973 = class121.method2730(var1);
      this.field1971 = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "1546102078"
   )
   public void method2569(CharSequence var1) {
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

      this.field1973[++this.field1971 - 1] = 0;
      this.method2499(var4);
      var4 = this.field1971;
      byte[] var12 = this.field1973;
      int var7 = this.field1971;
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
      this.field1971 = var4 + var5;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-554737560"
   )
   public int method2581() {
      this.field1971 += 2;
      int var1 = (this.field1973[this.field1971 - 2] & 255) + ((this.field1973[this.field1971 - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "809914909"
   )
   public static boolean method2589(int var0) {
      return (var0 >> 30 & 1) != 0;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-179241038"
   )
   public void method2597(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "47369313"
   )
   public void method2601(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-734482196"
   )
   public int method2602() {
      byte var1 = this.field1973[++this.field1971 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field1973[++this.field1971 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1690930294"
   )
   public void method2603(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)var1;
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1020132834"
   )
   public int method2610() {
      int var1 = this.field1973[this.field1971] & 255;
      return var1 < 128?this.method2500() - 64:this.method2502() - '쀀';
   }

   @ObfuscatedName("e")
   public void method2619(long var1) {
      this.field1973[++this.field1971 - 1] = (byte)((int)(var1 >> 40));
      this.field1973[++this.field1971 - 1] = (byte)((int)(var1 >> 32));
      this.field1973[++this.field1971 - 1] = (byte)((int)(var1 >> 24));
      this.field1973[++this.field1971 - 1] = (byte)((int)(var1 >> 16));
      this.field1973[++this.field1971 - 1] = (byte)((int)(var1 >> 8));
      this.field1973[++this.field1971 - 1] = (byte)((int)var1);
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

         field1972[var1] = var0;
      }

      field1978 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field1978[var2] = var4;
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2129940106"
   )
   public void method2642(int var1) {
      this.field1973[++this.field1971 - 1] = (byte)(var1 >> 8);
      this.field1973[++this.field1971 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "45"
   )
   public int method2662() {
      this.field1971 += 3;
      return ((this.field1973[this.field1971 - 2] & 255) << 8) + ((this.field1973[this.field1971 - 3] & 255) << 16) + (this.field1973[this.field1971 - 1] & 255);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "490110495"
   )
   public int method2663() {
      return this.field1973[++this.field1971 - 1] - 128 & 255;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-19"
   )
   public void method2666(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2503(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2486('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-2038268747"
   )
   public byte method2670() {
      return this.field1973[++this.field1971 - 1];
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "5"
   )
   public void method2672(int[] var1, int var2, int var3) {
      int var4 = this.field1971;
      this.field1971 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2505();
         int var8 = this.method2505();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
            var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.field1971 -= 8;
         this.method2488(var7);
         this.method2488(var8);
      }

      this.field1971 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)Lclass131;",
      garbageValue = "0"
   )
   public static class131 method2700() {
      try {
         return new class145();
      } catch (Throwable var1) {
         return null;
      }
   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(Lclass173;III)V",
      garbageValue = "-1652090525"
   )
   static final void method2701(class173 var0, int var1, int var2) {
      if(client.field446 == null && !client.field453) {
         if(null != var0) {
            class173 var5 = var0;
            int var6 = class172.method3358(class144.method3075(var0));
            class173 var4;
            int var7;
            if(0 == var6) {
               var4 = null;
            } else {
               var7 = 0;

               while(true) {
                  if(var7 >= var6) {
                     var4 = var5;
                     break;
                  }

                  var5 = class141.method2959(var5.field2763);
                  if(var5 == null) {
                     var4 = null;
                     break;
                  }

                  ++var7;
               }
            }

            class173 var8 = var4;
            if(var4 == null) {
               var8 = var0.field2819;
            }

            if(null != var8) {
               client.field446 = var0;
               var5 = var0;
               var6 = class172.method3358(class144.method3075(var0));
               if(0 == var6) {
                  var4 = null;
               } else {
                  var7 = 0;

                  while(true) {
                     if(var7 >= var6) {
                        var4 = var5;
                        break;
                     }

                     var5 = class141.method2959(var5.field2763);
                     if(var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var7;
                  }
               }

               var8 = var4;
               if(null == var4) {
                  var8 = var0.field2819;
               }

               client.field447 = var8;
               client.field448 = var1;
               client.field449 = var2;
               class99.field1659 = 0;
               client.field457 = false;
               if(client.field415 > 0) {
                  int var9 = client.field415 - 1;
                  class179.field2925 = new class30();
                  class179.field2925.field684 = client.field385[var9];
                  class179.field2925.field689 = client.field417[var9];
                  class179.field2925.field691 = client.field418[var9];
                  class179.field2925.field686 = client.field502[var9];
                  class179.field2925.field687 = client.field420[var9];
               }

               return;
            }
         }

      }
   }
}
