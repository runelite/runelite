import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dr")
@Implements("Buffer")
public class class119 extends class208 {
   @ObfuscatedName("g")
   static int[] field1999 = new int[256];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -516453963
   )
   @Export("offset")
   public int field2000;
   @ObfuscatedName("t")
   @Export("payload")
   public byte[] field2001;
   @ObfuscatedName("z")
   static long[] field2003;
   @ObfuscatedName("n")
   static int[] field2005;

   public class119(int var1) {
      this.field2001 = class121.method2703(var1);
      this.field2000 = 0;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1144929751"
   )
   public int method2452() {
      byte var1 = this.field2001[++this.field2000 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field2001[++this.field2000 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "704335335"
   )
   public void method2453(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-624930457"
   )
   public void method2454(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 8);
      this.field2001[++this.field2000 - 1] = (byte)var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1670959379"
   )
   public void method2455(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 16);
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 8);
      this.field2001[++this.field2000 - 1] = (byte)var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method2456(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 24);
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 16);
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 8);
      this.field2001[++this.field2000 - 1] = (byte)var1;
   }

   @ObfuscatedName("r")
   public void method2457(long var1) {
      this.field2001[++this.field2000 - 1] = (byte)((int)(var1 >> 40));
      this.field2001[++this.field2000 - 1] = (byte)((int)(var1 >> 32));
      this.field2001[++this.field2000 - 1] = (byte)((int)(var1 >> 24));
      this.field2001[++this.field2000 - 1] = (byte)((int)(var1 >> 16));
      this.field2001[++this.field2000 - 1] = (byte)((int)(var1 >> 8));
      this.field2001[++this.field2000 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "1087108841"
   )
   public void method2461(CharSequence var1) {
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

      this.field2001[++this.field2000 - 1] = 0;
      this.method2467(var4);
      this.field2000 += class12.method139(this.field2001, this.field2000, var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "0"
   )
   public void method2462(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.field2001[++this.field2000 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("f")
   public void method2463(long var1) {
      this.field2001[++this.field2000 - 1] = (byte)((int)(var1 >> 56));
      this.field2001[++this.field2000 - 1] = (byte)((int)(var1 >> 48));
      this.field2001[++this.field2000 - 1] = (byte)((int)(var1 >> 40));
      this.field2001[++this.field2000 - 1] = (byte)((int)(var1 >> 32));
      this.field2001[++this.field2000 - 1] = (byte)((int)(var1 >> 24));
      this.field2001[++this.field2000 - 1] = (byte)((int)(var1 >> 16));
      this.field2001[++this.field2000 - 1] = (byte)((int)(var1 >> 8));
      this.field2001[++this.field2000 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1814747791"
   )
   public int method2464() {
      this.field2000 += 3;
      return ((this.field2001[this.field2000 - 1] & 255) << 8) + ((this.field2001[this.field2000 - 3] & 255) << 16) + (this.field2001[this.field2000 - 2] & 255);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-898535725"
   )
   public void method2465(int var1) {
      this.field2001[this.field2000 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-784748577"
   )
   public void method2467(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2453(var1 >>> 28 | 128);
               }

               this.method2453(var1 >>> 21 | 128);
            }

            this.method2453(var1 >>> 14 | 128);
         }

         this.method2453(var1 >>> 7 | 128);
      }

      this.method2453(var1 & 127);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-2035347508"
   )
   public byte method2469() {
      return this.field2001[++this.field2000 - 1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "601309731"
   )
   public int method2470() {
      this.field2000 += 2;
      return (this.field2001[this.field2000 - 1] & 255) + ((this.field2001[this.field2000 - 2] & 255) << 8);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method2471(int var1) {
      this.field2001[this.field2000 - var1 - 2] = (byte)(var1 >> 8);
      this.field2001[this.field2000 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1629333345"
   )
   public int method2472() {
      this.field2000 += 3;
      return ((this.field2001[this.field2000 - 3] & 255) << 16) + ((this.field2001[this.field2000 - 2] & 255) << 8) + (this.field2001[this.field2000 - 1] & 255);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "743509642"
   )
   public long method2474() {
      long var1 = (long)this.method2505() & 4294967295L;
      long var3 = (long)this.method2505() & 4294967295L;
      return (var1 << 32) + var3;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "2029140431"
   )
   public String method2476() {
      int var1 = this.field2000;

      while(this.field2001[++this.field2000 - 1] != 0) {
         ;
      }

      int var2 = this.field2000 - var1 - 1;
      return var2 == 0?"":class141.method2946(this.field2001, var1, var2);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "1"
   )
   public String method2477() {
      byte var1 = this.field2001[++this.field2000 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field2000;

         while(this.field2001[++this.field2000 - 1] != 0) {
            ;
         }

         int var3 = this.field2000 - var2 - 1;
         return var3 == 0?"":class141.method2946(this.field2001, var2, var3);
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "637505676"
   )
   public String method2478() {
      byte var1 = this.field2001[++this.field2000 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2452();
         if(var2 + this.field2000 > this.field2001.length) {
            throw new IllegalStateException("");
         } else {
            String var3 = class102.method2239(this.field2001, this.field2000, var2);
            this.field2000 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "0"
   )
   public void method2479(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = this.field2001[++this.field2000 - 1];
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "14634"
   )
   public int method2481() {
      int var1 = this.field2001[this.field2000] & 255;
      return var1 < 128?this.method2494():this.method2470() - '耀';
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1779337025"
   )
   public int method2482() {
      return this.field2001[this.field2000] < 0?this.method2505() & Integer.MAX_VALUE:this.method2470();
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "108"
   )
   public void method2483(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 16);
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 24);
      this.field2001[++this.field2000 - 1] = (byte)var1;
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1318505086"
   )
   public void method2485(int[] var1) {
      int var2 = this.field2000 / 8;
      this.field2000 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2505();
         int var5 = this.method2505();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.field2000 -= 8;
         this.method2456(var4);
         this.method2456(var5);
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "1886891873"
   )
   public void method2486(int[] var1, int var2, int var3) {
      int var4 = this.field2000;
      this.field2000 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2505();
         int var8 = this.method2505();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.field2000 -= 8;
         this.method2456(var7);
         this.method2456(var8);
      }

      this.field2000 = var4;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "5"
   )
   public void method2487(int[] var1, int var2, int var3) {
      int var4 = this.field2000;
      this.field2000 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2505();
         int var8 = this.method2505();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var9 + var1[var9 & 3]) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.field2000 -= 8;
         this.method2456(var7);
         this.method2456(var8);
      }

      this.field2000 = var4;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2121740947"
   )
   public void method2488(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "376839997"
   )
   public int method2489(int var1) {
      int var2 = class155.method3131(this.field2001, var1, this.field2000);
      this.method2456(var2);
      return var2;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1316135230"
   )
   public boolean method2490() {
      this.field2000 -= 4;
      int var1 = class155.method3131(this.field2001, 0, this.field2000);
      int var2 = this.method2505();
      return var2 == var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   public void method2492(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1359961004"
   )
   public int method2494() {
      return this.field2001[++this.field2000 - 1] & 255;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "486674232"
   )
   public int method2495() {
      return 0 - this.field2001[++this.field2000 - 1] & 255;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1497851666"
   )
   public byte method2497() {
      return (byte)(this.field2001[++this.field2000 - 1] - 128);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "425927101"
   )
   public void method2500(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)var1;
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1676714364"
   )
   public void method2501(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 8);
      this.field2001[++this.field2000 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-249640358"
   )
   public void method2502(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)(128 + var1);
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-68"
   )
   public int method2504() {
      this.field2000 += 2;
      return (this.field2001[this.field2000 - 1] - 128 & 255) + ((this.field2001[this.field2000 - 2] & 255) << 8);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1913369820"
   )
   public int method2505() {
      this.field2000 += 4;
      return ((this.field2001[this.field2000 - 2] & 255) << 8) + ((this.field2001[this.field2000 - 4] & 255) << 24) + ((this.field2001[this.field2000 - 3] & 255) << 16) + (this.field2001[this.field2000 - 1] & 255);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "920569878"
   )
   public void method2507(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 16);
      this.field2001[++this.field2000 - 1] = (byte)var1;
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "55"
   )
   public void method2509(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)var1;
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 8);
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 16);
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1590439513"
   )
   public void method2510(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 8);
      this.field2001[++this.field2000 - 1] = (byte)var1;
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 24);
      this.field2001[++this.field2000 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1917877199"
   )
   public int method2512() {
      this.field2000 += 4;
      return ((this.field2001[this.field2000 - 3] & 255) << 8) + ((this.field2001[this.field2000 - 2] & 255) << 16) + ((this.field2001[this.field2000 - 1] & 255) << 24) + (this.field2001[this.field2000 - 4] & 255);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2145708252"
   )
   public int method2513() {
      this.field2000 += 4;
      return ((this.field2001[this.field2000 - 4] & 255) << 8) + ((this.field2001[this.field2000 - 1] & 255) << 16) + ((this.field2001[this.field2000 - 2] & 255) << 24) + (this.field2001[this.field2000 - 3] & 255);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-119"
   )
   public int method2514() {
      this.field2000 += 4;
      return (this.field2001[this.field2000 - 2] & 255) + ((this.field2001[this.field2000 - 1] & 255) << 8) + ((this.field2001[this.field2000 - 4] & 255) << 16) + ((this.field2001[this.field2000 - 3] & 255) << 24);
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

      field2003 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2003[var2] = var4;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1088501391"
   )
   public void method2535(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field2001[++this.field2000 - 1] = 0;
         this.field2000 += class103.method2248(var1, 0, var1.length(), this.field2001, this.field2000);
         this.field2001[++this.field2000 - 1] = 0;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1249333067"
   )
   public void method2537(int var1) {
      this.field2001[this.field2000 - var1 - 4] = (byte)(var1 >> 24);
      this.field2001[this.field2000 - var1 - 3] = (byte)(var1 >> 16);
      this.field2001[this.field2000 - var1 - 2] = (byte)(var1 >> 8);
      this.field2001[this.field2000 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1510380427"
   )
   public int method2545() {
      this.field2000 += 2;
      return (this.field2001[this.field2000 - 2] & 255) + ((this.field2001[this.field2000 - 1] & 255) << 8);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2114758451"
   )
   public void method2546(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2453(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2454('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-39"
   )
   public int method2547() {
      this.field2000 += 2;
      int var1 = (this.field2001[this.field2000 - 2] & 255) + ((this.field2001[this.field2000 - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-6735"
   )
   public int method2565() {
      int var1 = this.field2001[this.field2000] & 255;
      return var1 < 128?this.method2494() - 64:this.method2470() - '쀀';
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-104"
   )
   public String method2566() {
      if(this.field2001[this.field2000] == 0) {
         ++this.field2000;
         return null;
      } else {
         return this.method2476();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "22"
   )
   public void method2586(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field2000 += class103.method2248(var1, 0, var1.length(), this.field2001, this.field2000);
         this.field2001[++this.field2000 - 1] = 0;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1369586997"
   )
   public void method2594(int var1) {
      this.field2001[++this.field2000 - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-69046514"
   )
   public byte method2601() {
      return (byte)(128 - this.field2001[++this.field2000 - 1]);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-513092357"
   )
   public int method2613() {
      return 128 - this.field2001[++this.field2000 - 1] & 255;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-774632992"
   )
   public int method2623() {
      return this.field2001[++this.field2000 - 1] - 128 & 255;
   }

   public class119(byte[] var1) {
      this.field2001 = var1;
      this.field2000 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1369555393"
   )
   public int method2638() {
      this.field2000 += 2;
      int var1 = (this.field2001[this.field2000 - 1] & 255) + ((this.field2001[this.field2000 - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;B)V",
      garbageValue = "1"
   )
   public void method2640(BigInteger var1, BigInteger var2) {
      int var3 = this.field2000;
      this.field2000 = 0;
      byte[] var4 = new byte[var3];
      this.method2479(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field2000 = 0;
      this.method2454(var7.length);
      this.method2462(var7, 0, var7.length);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1331781148"
   )
   public int method2646() {
      this.field2000 += 2;
      return ((this.field2001[this.field2000 - 1] & 255) << 8) + (this.field2001[this.field2000 - 2] - 128 & 255);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "0"
   )
   public byte method2659() {
      return (byte)(0 - this.field2001[++this.field2000 - 1]);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1448733797"
   )
   public void method2660(int[] var1) {
      int var2 = this.field2000 / 8;
      this.field2000 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2505();
         int var5 = this.method2505();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += var4 + (var4 << 4 ^ var4 >>> 5) ^ var6 + var1[var6 >>> 11 & 3]) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.field2000 -= 8;
         this.method2456(var4);
         this.method2456(var5);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-968693317"
   )
   public static int method2666(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "-2088518975"
   )
   public static int method2667(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + class13.method143(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "747785516"
   )
   public static boolean method2668() {
      try {
         if(class183.field2981 == 2) {
            if(null == class183.field2974) {
               class183.field2974 = class180.method3464(class24.field614, class142.field2204, class183.field2977);
               if(null == class183.field2974) {
                  return false;
               }
            }

            if(class22.field590 == null) {
               class22.field590 = new class59(class183.field2975, class90.field1572);
            }

            if(class183.field2976.method3549(class183.field2974, class183.field2978, class22.field590, 22050)) {
               class183.field2976.method3656();
               class183.field2976.method3613(class151.field2286);
               class183.field2976.method3599(class183.field2974, class29.field694);
               class183.field2981 = 0;
               class183.field2974 = null;
               class22.field590 = null;
               class24.field614 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class183.field2976.method3574();
         class183.field2981 = 0;
         class183.field2974 = null;
         class22.field590 = null;
         class24.field614 = null;
      }

      return false;
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(Lclass2;IIII)V",
      garbageValue = "-2023800031"
   )
   @Export("generateMenuActionsForPlayer")
   static final void method2669(class2 var0, int var1, int var2, int var3) {
      if(class152.field2301 != var0) {
         if(client.field294 < 400) {
            String var4;
            int var7;
            if(var0.field54 == 0) {
               String var5 = var0.field40[0] + var0.field39 + var0.field40[1];
               var7 = var0.field41;
               int var8 = class152.field2301.field41;
               int var9 = var8 - var7;
               String var6;
               if(var9 < -9) {
                  var6 = class155.method3132(16711680);
               } else if(var9 < -6) {
                  var6 = class155.method3132(16723968);
               } else if(var9 < -3) {
                  var6 = class155.method3132(16740352);
               } else if(var9 < 0) {
                  var6 = class155.method3132(16756736);
               } else if(var9 > 9) {
                  var6 = class155.method3132('\uff00');
               } else if(var9 > 6) {
                  var6 = class155.method3132(4259584);
               } else if(var9 > 3) {
                  var6 = class155.method3132(8453888);
               } else if(var9 > 0) {
                  var6 = class155.method3132(12648192);
               } else {
                  var6 = class155.method3132(16776960);
               }

               var4 = var5 + var6 + " " + " (" + "level-" + var0.field41 + ")" + var0.field40[2];
            } else {
               var4 = var0.field40[0] + var0.field39 + var0.field40[1] + " " + " (" + "skill-" + var0.field54 + ")" + var0.field40[2];
            }

            int var11;
            if(client.field379 == 1) {
               class2.method33("Use", client.field463 + " " + "->" + " " + class155.method3132(16777215) + var4, 14, var1, var2, var3);
            } else if(client.field437) {
               if((class3.field69 & 8) == 8) {
                  class2.method33(client.field432, client.field441 + " " + "->" + " " + class155.method3132(16777215) + var4, 15, var1, var2, var3);
               }
            } else {
               for(var11 = 7; var11 >= 0; --var11) {
                  if(null != client.field461[var11]) {
                     short var10 = 0;
                     if(client.field461[var11].equalsIgnoreCase("Attack")) {
                        if(class20.field570 == client.field309) {
                           continue;
                        }

                        if(client.field309 == class20.field571 || client.field309 == class20.field569 && var0.field41 > class152.field2301.field41) {
                           var10 = 2000;
                        }

                        if(class152.field2301.field55 != 0 && var0.field55 != 0) {
                           if(class152.field2301.field55 == var0.field55) {
                              var10 = 2000;
                           } else {
                              var10 = 0;
                           }
                        }
                     } else if(client.field412[var11]) {
                        var10 = 2000;
                     }

                     boolean var12 = false;
                     var7 = client.field410[var11] + var10;
                     class2.method33(client.field461[var11], class155.method3132(16777215) + var4, var7, var1, var2, var3);
                  }
               }
            }

            for(var11 = 0; var11 < client.field294; ++var11) {
               if(client.field392[var11] == 23) {
                  client.field337[var11] = class155.method3132(16777215) + var4;
                  break;
               }
            }

         }
      }
   }
}
