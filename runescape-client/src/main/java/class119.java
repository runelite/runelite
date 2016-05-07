import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("Buffer")
public class class119 extends class208 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -431058323
   )
   @Export("offset")
   public int field2005;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = -909767373
   )
   static int field2006;
   @ObfuscatedName("s")
   @Export("payload")
   public byte[] field2007;
   @ObfuscatedName("d")
   static long[] field2008;
   @ObfuscatedName("p")
   static int[] field2010 = new int[256];

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-30078"
   )
   public void method2477(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)var1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1935049392"
   )
   public void method2480(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 24);
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 16);
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 8);
      this.field2007[++this.field2005 - 1] = (byte)var1;
   }

   @ObfuscatedName("o")
   public void method2482(long var1) {
      this.field2007[++this.field2005 - 1] = (byte)((int)(var1 >> 56));
      this.field2007[++this.field2005 - 1] = (byte)((int)(var1 >> 48));
      this.field2007[++this.field2005 - 1] = (byte)((int)(var1 >> 40));
      this.field2007[++this.field2005 - 1] = (byte)((int)(var1 >> 32));
      this.field2007[++this.field2005 - 1] = (byte)((int)(var1 >> 24));
      this.field2007[++this.field2005 - 1] = (byte)((int)(var1 >> 16));
      this.field2007[++this.field2005 - 1] = (byte)((int)(var1 >> 8));
      this.field2007[++this.field2005 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1809579595"
   )
   public void method2483(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field2005 += class22.method569(var1, 0, var1.length(), this.field2007, this.field2005);
         this.field2007[++this.field2005 - 1] = 0;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "-7"
   )
   public void method2485(CharSequence var1) {
      int var2 = class125.method2797(var1);
      this.field2007[++this.field2005 - 1] = 0;
      this.method2622(var2);
      this.field2005 += class51.method1045(this.field2007, this.field2005, var1);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "0"
   )
   public void method2486(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.field2007[++this.field2005 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1151793311"
   )
   public void method2487(int var1) {
      this.field2007[this.field2005 - var1 - 4] = (byte)(var1 >> 24);
      this.field2007[this.field2005 - var1 - 3] = (byte)(var1 >> 16);
      this.field2007[this.field2005 - var1 - 2] = (byte)(var1 >> 8);
      this.field2007[this.field2005 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-537135616"
   )
   public void method2489(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field2007[++this.field2005 - 1] = 0;
         this.field2005 += class22.method569(var1, 0, var1.length(), this.field2007, this.field2005);
         this.field2007[++this.field2005 - 1] = 0;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1161494271"
   )
   public void method2490(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2477(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2661('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1190689390"
   )
   public int method2492() {
      return this.field2007[++this.field2005 - 1] & 255;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "-91"
   )
   public byte method2493() {
      return this.field2007[++this.field2005 - 1];
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1135213794"
   )
   public void method2494(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 8);
      this.field2007[++this.field2005 - 1] = (byte)var1;
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 24);
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-82"
   )
   public int method2495() {
      this.field2005 += 2;
      int var1 = ((this.field2007[this.field2005 - 2] & 255) << 8) + (this.field2007[this.field2005 - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1865340488"
   )
   public int method2497() {
      this.field2005 += 4;
      return ((this.field2007[this.field2005 - 4] & 255) << 24) + ((this.field2007[this.field2005 - 3] & 255) << 16) + ((this.field2007[this.field2005 - 2] & 255) << 8) + (this.field2007[this.field2005 - 1] & 255);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "1747885348"
   )
   public long method2498() {
      long var1 = (long)this.method2497() & 4294967295L;
      long var3 = (long)this.method2497() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-108"
   )
   public String method2500() {
      int var1 = this.field2005;

      while(this.field2007[++this.field2005 - 1] != 0) {
         ;
      }

      int var2 = this.field2005 - var1 - 1;
      return 0 == var2?"":class21.method567(this.field2007, var1, var2);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(S)Ljava/lang/String;",
      garbageValue = "18309"
   )
   public String method2501() {
      byte var1 = this.field2007[++this.field2005 - 1];
      if(0 != var1) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field2005;

         while(this.field2007[++this.field2005 - 1] != 0) {
            ;
         }

         int var3 = this.field2005 - var2 - 1;
         return var3 == 0?"":class21.method567(this.field2007, var2, var3);
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "401224884"
   )
   public String method2502() {
      byte var1 = this.field2007[++this.field2005 - 1];
      if(0 != var1) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2507();
         if(this.field2005 + var2 > this.field2007.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = class52.method1061(this.field2007, this.field2005, var2);
            this.field2005 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "0"
   )
   public void method2503(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = this.field2007[++this.field2005 - 1];
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "837059700"
   )
   public int method2505() {
      int var1 = this.field2007[this.field2005] & 255;
      return var1 < 128?this.method2492():this.method2584() - '耀';
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "32546"
   )
   public int method2506() {
      return this.field2007[this.field2005] < 0?this.method2497() & Integer.MAX_VALUE:this.method2584();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "116"
   )
   public int method2507() {
      byte var1 = this.field2007[++this.field2005 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field2007[++this.field2005 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-628971320"
   )
   public void method2508(int[] var1) {
      int var2 = this.field2005 / 8;
      this.field2005 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2497();
         int var5 = this.method2497();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3]) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.field2005 -= 8;
         this.method2480(var4);
         this.method2480(var5);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "-1231394442"
   )
   public void method2512(BigInteger var1, BigInteger var2) {
      int var3 = this.field2005;
      this.field2005 = 0;
      byte[] var4 = new byte[var3];
      this.method2503(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field2005 = 0;
      this.method2661(var7.length);
      this.method2486(var7, 0, var7.length);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "10"
   )
   public int method2513() {
      this.field2005 += 3;
      return ((this.field2007[this.field2005 - 2] & 255) << 8) + ((this.field2007[this.field2005 - 3] & 255) << 16) + (this.field2007[this.field2005 - 1] & 255);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "622889475"
   )
   public boolean method2514() {
      this.field2005 -= 4;
      int var1 = class14.method176(this.field2007, 0, this.field2005);
      int var2 = this.method2497();
      return var2 == var1;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "983538500"
   )
   public void method2515(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 16);
      this.field2007[++this.field2005 - 1] = (byte)var1;
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2135891259"
   )
   public void method2516(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1312336086"
   )
   public int method2518() {
      return this.field2007[++this.field2005 - 1] - 128 & 255;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method2520() {
      return 128 - this.field2007[++this.field2005 - 1] & 255;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1939503322"
   )
   public byte method2521() {
      return (byte)(this.field2007[++this.field2005 - 1] - 128);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1133939523"
   )
   public byte method2522() {
      return (byte)(0 - this.field2007[++this.field2005 - 1]);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-18119"
   )
   public void method2524(int var1) {
      this.field2007[this.field2005 - var1 - 2] = (byte)(var1 >> 8);
      this.field2007[this.field2005 - var1 - 1] = (byte)var1;
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

         field2010[var1] = var0;
      }

      field2008 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2008[var2] = var4;
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "24"
   )
   public void method2525(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)(128 + var1);
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 8);
   }

   public class119(byte[] var1) {
      this.field2007 = var1;
      this.field2005 = 0;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1249240630"
   )
   public int method2526() {
      this.field2005 += 2;
      return (this.field2007[this.field2005 - 1] - 128 & 255) + ((this.field2007[this.field2005 - 2] & 255) << 8);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1012443155"
   )
   public int method2527() {
      this.field2005 += 2;
      return ((this.field2007[this.field2005 - 1] & 255) << 8) + (this.field2007[this.field2005 - 2] - 128 & 255);
   }

   @ObfuscatedName("u")
   public void method2528(long var1) {
      this.field2007[++this.field2005 - 1] = (byte)((int)(var1 >> 40));
      this.field2007[++this.field2005 - 1] = (byte)((int)(var1 >> 32));
      this.field2007[++this.field2005 - 1] = (byte)((int)(var1 >> 24));
      this.field2007[++this.field2005 - 1] = (byte)((int)(var1 >> 16));
      this.field2007[++this.field2005 - 1] = (byte)((int)(var1 >> 8));
      this.field2007[++this.field2005 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1346795046"
   )
   public int method2529() {
      this.field2005 += 2;
      int var1 = ((this.field2007[this.field2005 - 1] & 255) << 8) + (this.field2007[this.field2005 - 2] - 128 & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1777946019"
   )
   public int method2530() {
      this.field2005 += 3;
      return ((this.field2007[this.field2005 - 2] & 255) << 8) + ((this.field2007[this.field2005 - 1] & 255) << 16) + (this.field2007[this.field2005 - 3] & 255);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1743800239"
   )
   public void method2531(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)var1;
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 8);
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 16);
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "125"
   )
   public int method2533() {
      this.field2005 += 2;
      return (this.field2007[this.field2005 - 2] & 255) + ((this.field2007[this.field2005 - 1] & 255) << 8);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "11"
   )
   public int method2534() {
      this.field2005 += 4;
      return (this.field2007[this.field2005 - 4] & 255) + ((this.field2007[this.field2005 - 3] & 255) << 8) + ((this.field2007[this.field2005 - 2] & 255) << 16) + ((this.field2007[this.field2005 - 1] & 255) << 24);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "58"
   )
   public int method2535() {
      this.field2005 += 4;
      return (this.field2007[this.field2005 - 3] & 255) + ((this.field2007[this.field2005 - 2] & 255) << 24) + ((this.field2007[this.field2005 - 1] & 255) << 16) + ((this.field2007[this.field2005 - 4] & 255) << 8);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "55"
   )
   public int method2536() {
      this.field2005 += 4;
      return (this.field2007[this.field2005 - 2] & 255) + ((this.field2007[this.field2005 - 1] & 255) << 8) + ((this.field2007[this.field2005 - 3] & 255) << 24) + ((this.field2007[this.field2005 - 4] & 255) << 16);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1511180369"
   )
   public String method2539() {
      if(this.field2007[this.field2005] == 0) {
         ++this.field2005;
         return null;
      } else {
         return this.method2500();
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "([IS)V",
      garbageValue = "15899"
   )
   public void method2543(int[] var1) {
      int var2 = this.field2005 / 8;
      this.field2005 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2497();
         int var5 = this.method2497();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.field2005 -= 8;
         this.method2480(var4);
         this.method2480(var5);
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "447496554"
   )
   public void method2557(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 8);
      this.field2007[++this.field2005 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2050872712"
   )
   public void method2562(int var1) {
      this.field2007[this.field2005 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "5"
   )
   public void method2581(int[] var1, int var2, int var3) {
      int var4 = this.field2005;
      this.field2005 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2497();
         int var8 = this.method2497();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.field2005 -= 8;
         this.method2480(var7);
         this.method2480(var8);
      }

      this.field2005 = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-74576439"
   )
   public int method2584() {
      this.field2005 += 2;
      return (this.field2007[this.field2005 - 1] & 255) + ((this.field2007[this.field2005 - 2] & 255) << 8);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-589452998"
   )
   public int method2585() {
      int var1 = this.field2007[this.field2005] & 255;
      return var1 < 128?this.method2492() - 64:this.method2584() - '쀀';
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "15"
   )
   public void method2587(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 16);
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 24);
      this.field2007[++this.field2005 - 1] = (byte)var1;
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "97751864"
   )
   public void method2590(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1517189121"
   )
   public void method2606(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 16);
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 8);
      this.field2007[++this.field2005 - 1] = (byte)var1;
   }

   public class119(int var1) {
      this.field2007 = class121.method2730(var1);
      this.field2005 = 0;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-465386436"
   )
   public int method2613() {
      return 0 - this.field2007[++this.field2005 - 1] & 255;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-249317256"
   )
   public void method2622(int var1) {
      if(0 != (var1 & -128)) {
         if(0 != (var1 & -16384)) {
            if(0 != (var1 & -2097152)) {
               if((var1 & -268435456) != 0) {
                  this.method2477(var1 >>> 28 | 128);
               }

               this.method2477(var1 >>> 21 | 128);
            }

            this.method2477(var1 >>> 14 | 128);
         }

         this.method2477(var1 >>> 7 | 128);
      }

      this.method2477(var1 & 127);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1931618279"
   )
   public void method2624(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)var1;
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)Z",
      garbageValue = "-1772326423"
   )
   static boolean method2638(class122 var0, int var1) {
      int var2 = var0.method2750(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(0 == var2) {
         if(var0.method2750(1) != 0) {
            method2638(var0, var1);
         }

         var3 = var0.method2750(6);
         var4 = var0.method2750(6);
         boolean var11 = var0.method2750(1) == 1;
         if(var11) {
            class32.field764[++class32.field762 - 1] = var1;
         }

         if(client.field491[var1] != null) {
            throw new RuntimeException();
         } else {
            class2 var12 = client.field491[var1] = new class2();
            var12.field42 = var1;
            if(class32.field768[var1] != null) {
               var12.method11(class32.field768[var1]);
            }

            var12.field862 = class32.field760[var1];
            var12.field837 = class32.field761[var1];
            var7 = class32.field759[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var12.field868[0] = class32.field753[var1];
            var12.field55 = (byte)var8;
            var12.method15(var3 + (var9 << 6) - class22.field594, var4 + (var10 << 6) - class114.field1981);
            var12.field36 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method2750(2);
         var4 = class32.field759[var1];
         class32.field759[var1] = ((var3 + (var4 >> 28) & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method2750(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class32.field759[var1];
            var7 = (var6 >> 28) + var4 & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(0 == var5) {
               --var8;
               --var9;
            }

            if(1 == var5) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(7 == var5) {
               ++var8;
               ++var9;
            }

            class32.field759[var1] = var9 + (var7 << 28) + (var8 << 14);
            return false;
         } else {
            var3 = var0.method2750(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class32.field759[var1];
            var8 = var4 + (var7 >> 28) & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var6 & 255;
            class32.field759[var1] = var10 + (var9 << 14) + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "48"
   )
   public int method2651(int var1) {
      int var2 = class14.method176(this.field2007, var1, this.field2005);
      this.method2480(var2);
      return var2;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "887297863"
   )
   public void method2653(int[] var1, int var2, int var3) {
      int var4 = this.field2005;
      this.field2005 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2497();
         int var8 = this.method2497();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3]) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.field2005 -= 8;
         this.method2480(var7);
         this.method2480(var8);
      }

      this.field2005 = var4;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "157821004"
   )
   public void method2661(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)(var1 >> 8);
      this.field2007[++this.field2005 - 1] = (byte)var1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1370787243"
   )
   public void method2681(int var1) {
      this.field2007[++this.field2005 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-139392124"
   )
   public byte method2684() {
      return (byte)(128 - this.field2007[++this.field2005 - 1]);
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1751549879"
   )
   static final void method2694() {
      client.field322.method2737(21);
      client.field322.method2477(0);
   }
}
