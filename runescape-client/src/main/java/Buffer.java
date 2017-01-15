import java.awt.Canvas;
import java.awt.Color;
import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -33150655
   )
   @Export("offset")
   public int offset;
   @ObfuscatedName("i")
   public static int[] field2073 = new int[256];
   @ObfuscatedName("c")
   @Export("isMembersWorld")
   static boolean isMembersWorld;
   @ObfuscatedName("f")
   static long[] field2075;
   @ObfuscatedName("u")
   @Export("payload")
   public byte[] payload;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 1429981449
   )
   @Export("menuY")
   static int menuY;

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1244026865"
   )
   public int method2758() {
      return this.payload[this.offset] < 0?this.method2780() & Integer.MAX_VALUE:this.readUnsignedShort();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1476152818"
   )
   public void method2760(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "87"
   )
   public String method2761() {
      if(this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.method2965();
      }
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1888723054"
   )
   public int method2762() {
      this.offset += 2;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1896340477"
   )
   public void method2763(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("g")
   public void method2764(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-412500627"
   )
   public void method2767(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += class115.method2182(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "102607152"
   )
   @Export("readUnsignedShort")
   public int readUnsignedShort() {
      this.offset += 2;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-127719246"
   )
   public void method2769(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "39"
   )
   public void method2770(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1005521485"
   )
   public void method2771(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1995410750"
   )
   public void method2772(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-981708195"
   )
   public void method2774(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2760(var1 >>> 28 | 128);
               }

               this.method2760(var1 >>> 21 | 128);
            }

            this.method2760(var1 >>> 14 | 128);
         }

         this.method2760(var1 >>> 7 | 128);
      }

      this.method2760(var1 & 127);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "73590244"
   )
   public int method2779() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] - 128 & 255);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-398520522"
   )
   public int method2780() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 16) + ((this.payload[this.offset - 4] & 255) << 24) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-1"
   )
   public String method2784() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.payload[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":class183.method3346(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "184"
   )
   @Export("read24BitInt")
   public int read24BitInt() {
      this.offset += 3;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "256"
   )
   @Export("readShortSmart")
   public int readShortSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - '쀀';
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "238039898"
   )
   public int method2790() {
      if(this.payload[this.offset] < 0) {
         return this.method2780() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "99975268"
   )
   public void method2793(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2780();
         int var5 = this.method2780();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var6 + var1[var6 & 3]) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.offset -= 8;
         this.method2763(var4);
         this.method2763(var5);
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-1968193483"
   )
   public void method2794(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2780();
         int var8 = this.method2780();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ var9 + var1[var9 >>> 11 & 3]) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var9 + var1[var9 & 3];
            var9 += var10;
         }

         this.offset -= 8;
         this.method2763(var7);
         this.method2763(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-1132264105"
   )
   public void method2795(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2780();
         int var8 = this.method2780();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var9 + var1[var9 & 3]) {
            var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.offset -= 8;
         this.method2763(var7);
         this.method2763(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "1371368795"
   )
   public void method2796(BigInteger var1, BigInteger var2) {
      int var3 = this.offset;
      this.offset = 0;
      byte[] var4 = new byte[var3];
      this.method2974(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.offset = 0;
      this.method2918(var7.length);
      this.method2769(var7, 0, var7.length);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "1"
   )
   public int method2797(int var1) {
      byte[] var2 = this.payload;
      int var3 = this.offset;
      int var4 = -1;

      for(int var5 = var1; var5 < var3; ++var5) {
         var4 = var4 >>> 8 ^ field2073[(var4 ^ var2[var5]) & 255];
      }

      var4 = ~var4;
      this.method2763(var4);
      return var4;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "-31"
   )
   public void method2798(CharSequence var1) {
      int var2 = class16.method181(var1);
      this.payload[++this.offset - 1] = 0;
      this.method2774(var2);
      this.offset += class161.method3071(this.payload, this.offset, var1);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-959507258"
   )
   public void method2799(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1280554898"
   )
   public void method2800(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   public void method2801(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1634049028"
   )
   public int method2802() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "529612515"
   )
   public int method2803() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-39"
   )
   public int method2804() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "912091815"
   )
   public void method2807(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1093302811"
   )
   public void method2809(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-760185129"
   )
   public void method2811(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += class115.method2182(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(S)B",
      garbageValue = "5160"
   )
   public byte method2814() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1364445987"
   )
   public int method2815() {
      this.offset += 3;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 1] & 255) << 16) + (this.payload[this.offset - 3] & 255);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "18"
   )
   public void method2816(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "809980626"
   )
   public void method2817(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "886008070"
   )
   public void method2818(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1102151490"
   )
   public int method2819() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-201684553"
   )
   public int method2820() {
      this.offset += 4;
      return (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8);
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-915728768"
   )
   public void method2848(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "29747"
   )
   public boolean method2855() {
      this.offset -= 4;
      byte[] var1 = this.payload;
      int var2 = this.offset;
      int var3 = -1;

      int var4;
      for(var4 = 0; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ field2073[(var3 ^ var1[var4]) & 255];
      }

      var3 = ~var3;
      var4 = this.method2780();
      return var4 == var3;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "2"
   )
   public int method2862() {
      byte var1 = this.payload[++this.offset - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.payload[++this.offset - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   public Buffer(int var1) {
      this.payload = class154.method2992(var1);
      this.offset = 0;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "2005690179"
   )
   public void method2886(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2780();
         int var5 = this.method2780();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3]) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6;
            var6 += var7;
         }

         this.offset -= 8;
         this.method2763(var4);
         this.method2763(var5);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-832965981"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "124"
   )
   public void method2900(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2760(var1);
      } else {
         if(var1 < 0 || var1 >= '耀') {
            throw new IllegalArgumentException();
         }

         this.method2918(var1 + '耀');
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "263556411"
   )
   public long method2908() {
      long var1 = (long)this.method2780() & 4294967295L;
      long var3 = (long)this.method2780() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "100"
   )
   public void method2914(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1320076254"
   )
   public void method2918(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-8812"
   )
   public int method2922() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("z")
   public void method2933(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 56));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 48));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1992846445"
   )
   public int method2936() {
      this.offset += 4;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8) + ((this.payload[this.offset - 3] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 16);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "16"
   )
   @Export("readByte")
   public byte readByte() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1616826744"
   )
   public void method2942(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-364982455"
   )
   public String method2949() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2862();
         if(this.offset + var2 > this.payload.length) {
            throw new IllegalStateException("");
         } else {
            byte[] var3 = this.payload;
            int var4 = this.offset;
            char[] var5 = new char[var2];
            int var6 = 0;
            int var7 = var4;

            int var8;
            for(int var9 = var2 + var4; var7 < var9; var5[var6++] = (char)var8) {
               int var10 = var3[var7++] & 255;
               if(var10 < 128) {
                  if(var10 == 0) {
                     var8 = '�';
                  } else {
                     var8 = var10;
                  }
               } else if(var10 < 192) {
                  var8 = '�';
               } else if(var10 < 224) {
                  if(var7 < var9 && (var3[var7] & 192) == 128) {
                     var8 = (var10 & 31) << 6 | var3[var7++] & 63;
                     if(var8 < 128) {
                        var8 = '�';
                     }
                  } else {
                     var8 = '�';
                  }
               } else if(var10 < 240) {
                  if(var7 + 1 < var9 && (var3[var7] & 192) == 128 && (var3[var7 + 1] & 192) == 128) {
                     var8 = (var10 & 15) << 12 | (var3[var7++] & 63) << 6 | var3[var7++] & 63;
                     if(var8 < 2048) {
                        var8 = '�';
                     }
                  } else {
                     var8 = '�';
                  }
               } else if(var10 < 248) {
                  if(2 + var7 < var9 && (var3[var7] & 192) == 128 && (var3[var7 + 1] & 192) == 128 && (var3[var7 + 2] & 192) == 128) {
                     var8 = (var10 & 7) << 18 | (var3[var7++] & 63) << 12 | (var3[var7++] & 63) << 6 | var3[var7++] & 63;
                     if(var8 >= 65536 && var8 <= 1114111) {
                        var8 = '�';
                     } else {
                        var8 = '�';
                     }
                  } else {
                     var8 = '�';
                  }
               } else {
                  var8 = '�';
               }
            }

            String var11 = new String(var5, 0, var6);
            this.offset += var2;
            return var11;
         }
      }
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-83216077"
   )
   public int method2953() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 2] - 128 & 255) + ((this.payload[this.offset - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1407578827"
   )
   public int method2963() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte():this.readUnsignedShort() - '耀';
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method2965() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":class183.method3346(this.payload, var1, var2);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "969051764"
   )
   public byte method2966() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1958457299"
   )
   public int method2968() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1532115093"
   )
   public void method2974(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1339346417"
   )
   static void method2987() {
      Canvas var0 = class165.canvas;
      var0.removeKeyListener(class105.keyboard);
      var0.removeFocusListener(class105.keyboard);
      class105.field1703 = -1;
      class40.method740(class165.canvas);
      if(null != class179.field2663) {
         class179.field2663.vmethod2043(class165.canvas);
      }

      Client.field279.method2058();
      class165.canvas.setBackground(Color.black);
      class145.method2707(class165.canvas);
      Canvas var1 = class165.canvas;
      var1.addMouseListener(class115.mouse);
      var1.addMouseMotionListener(class115.mouse);
      var1.addFocusListener(class115.mouse);
      if(null != class179.field2663) {
         class179.field2663.vmethod2053(class165.canvas);
      }

      if(Client.widgetRoot != -1) {
         XGrandExchangeOffer.method64(Client.widgetRoot, class0.field1, class65.field1099, false);
      }

      GameEngine.field1770 = true;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "-1619613466"
   )
   public static ModIcon[] method2988(class182 var0, String var1, String var2) {
      int var3 = var0.method3277(var1);
      int var4 = var0.method3278(var3, var2);
      ModIcon[] var5;
      if(!XGrandExchangeOffer.method60(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon[] var6 = new ModIcon[class225.field3215];

         for(int var7 = 0; var7 < class225.field3215; ++var7) {
            ModIcon var8 = var6[var7] = new ModIcon();
            var8.width = class225.field3214;
            var8.originalHeight = class202.field3060;
            var8.offsetX = class225.field3213[var7];
            var8.offsetY = class225.field3216[var7];
            var8.originalWidth = class225.field3217[var7];
            var8.height = class178.field2653[var7];
            var8.palette = class225.field3218;
            var8.pixels = class119.field1845[var7];
         }

         class225.field3213 = null;
         class225.field3216 = null;
         class225.field3217 = null;
         class178.field2653 = null;
         class225.field3218 = null;
         class119.field1845 = (byte[][])null;
         var5 = var6;
      }

      return var5;
   }

   static {
      int var0;
      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = var1;

         for(var0 = 0; var0 < 8; ++var0) {
            if((var2 & 1) == 1) {
               var2 = var2 >>> 1 ^ -306674912;
            } else {
               var2 >>>= 1;
            }
         }

         field2073[var1] = var2;
      }

      field2075 = new long[256];

      for(var0 = 0; var0 < 256; ++var0) {
         long var4 = (long)var0;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2075[var0] = var4;
      }

   }
}
