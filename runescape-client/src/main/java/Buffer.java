import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("k")
   @Export("payload")
   public byte[] payload;
   @ObfuscatedName("w")
   static long[] field2258;
   @ObfuscatedName("o")
   static int[] field2259 = new int[256];
   @ObfuscatedName("mi")
   static byte field2265;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1538316953
   )
   @Export("offset")
   public int offset;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2038508127"
   )
   public void method2912(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1319864657"
   )
   public void method2914(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("c")
   public void method2916(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("g")
   public void method2917(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 56));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 48));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-100"
   )
   public String method2918() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.payload[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":class72.method1414(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "32"
   )
   public void method2919(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += class171.method3246(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1382500138"
   )
   public void method2921(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "21"
   )
   public void method2922(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1471324548"
   )
   public void method2924(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1797946299"
   )
   public void method2925(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2912(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method3094('耀' + var1);
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-19336"
   )
   @Export("readUnsignedByte")
   public int readUnsignedByte() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "-110"
   )
   @Export("readByte")
   public byte readByte() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   @Export("readUnsignedShort")
   public int readUnsignedShort() {
      this.offset += 2;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-339621873"
   )
   @Export("readShort")
   public int readShort() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   public Buffer(int var1) {
      this.payload = class161.method3136(var1);
      this.offset = 0;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-28"
   )
   public long method2932() {
      long var1 = (long)this.method3062() & 4294967295L;
      long var3 = (long)this.method3062() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1026174912"
   )
   public String method2934() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":class72.method1414(this.payload, var1, var2);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1627768173"
   )
   public String method2936() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2942();
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
                  if(var8 + 1 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128) {
                     var11 = (var10 & 15) << 12 | (var4[var8++] & 63) << 6 | var4[var8++] & 63;
                     if(var11 < 2048) {
                        var11 = '�';
                     }
                  } else {
                     var11 = '�';
                  }
               } else if(var10 < 248) {
                  if(2 + var8 < var9 && (var4[var8] & 192) == 128 && (var4[var8 + 1] & 192) == 128 && (var4[2 + var8] & 192) == 128) {
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

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1215352163"
   )
   public int method2939() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte():this.readUnsignedShort() - '耀';
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-6"
   )
   public int method2940() {
      return this.payload[this.offset] < 0?this.method3062() & Integer.MAX_VALUE:this.readUnsignedShort();
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1619754550"
   )
   public int method2942() {
      byte var1 = this.payload[++this.offset - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.payload[++this.offset - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "29630928"
   )
   public void method2944(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method3062();
         int var5 = this.method3062();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6) {
            var5 -= (var4 << 4 ^ var4 >>> 5) + var4 ^ var6 + var1[var6 >>> 11 & 3];
            var6 -= var7;
         }

         this.offset -= 8;
         this.method3057(var4);
         this.method3057(var5);
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "([IIIS)V",
      garbageValue = "31024"
   )
   public void method2945(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method3062();
         int var8 = this.method3062();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3]) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.offset -= 8;
         this.method3057(var7);
         this.method3057(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1276275344"
   )
   public int method2948(int var1) {
      int var2 = class119.method2279(this.payload, var1, this.offset);
      this.method3057(var2);
      return var2;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "255"
   )
   public boolean method2949() {
      this.offset -= 4;
      int var1 = class119.method2279(this.payload, 0, this.offset);
      int var2 = this.method3062();
      return var1 == var2;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1337592632"
   )
   public void method2951(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1693931453"
   )
   public void method2952(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int method2953() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2106934968"
   )
   public int method2954() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "1565750944"
   )
   public byte method2956() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-584649982"
   )
   public byte method2957() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1781399093"
   )
   public byte method2958() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "13544"
   )
   public void method2959(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-273822724"
   )
   public void method2960(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1997010749"
   )
   public void method2961(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 + var1);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-197076076"
   )
   public int method2962() {
      this.offset += 2;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "128"
   )
   public int method2963() {
      this.offset += 2;
      return (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-323745373"
   )
   public int method2965() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 1] - 128 & 255) + ((this.payload[this.offset - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1781585461"
   )
   public int method2966() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 2] - 128 & 255) + ((this.payload[this.offset - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   public void method2967(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "15498354"
   )
   public int method2968() {
      this.offset += 3;
      return ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 8) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1583203207"
   )
   public void method2969(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-544002263"
   )
   public void method2970(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "35"
   )
   public void method2971(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1926225344"
   )
   public int method2972() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 1] & 255) << 24) + ((this.payload[this.offset - 2] & 255) << 16);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1313994917"
   )
   public int method2974() {
      this.offset += 4;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 24);
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

         field2259[var1] = var0;
      }

      field2258 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2258[var2] = var4;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1169038507"
   )
   public void method3032(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "-1801012971"
   )
   public void method3033(CharSequence var1) {
      int var3 = var1.length();
      int var4 = 0;

      int var5;
      for(var5 = 0; var5 < var3; ++var5) {
         char var12 = var1.charAt(var5);
         if(var12 <= 127) {
            ++var4;
         } else if(var12 <= 2047) {
            var4 += 2;
         } else {
            var4 += 3;
         }
      }

      this.payload[++this.offset - 1] = 0;
      this.method3077(var4);
      var4 = this.offset;
      byte[] var6 = this.payload;
      int var7 = this.offset;
      int var8 = var1.length();
      int var9 = var7;

      for(int var10 = 0; var10 < var8; ++var10) {
         char var11 = var1.charAt(var10);
         if(var11 <= 127) {
            var6[var9++] = (byte)var11;
         } else if(var11 <= 2047) {
            var6[var9++] = (byte)(192 | var11 >> 6);
            var6[var9++] = (byte)(128 | var11 & 63);
         } else {
            var6[var9++] = (byte)(224 | var11 >> 12);
            var6[var9++] = (byte)(128 | var11 >> 6 & 63);
            var6[var9++] = (byte)(128 | var11 & 63);
         }
      }

      var5 = var9 - var7;
      this.offset = var4 + var5;
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1358565301"
   )
   public int method3037() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1607049510"
   )
   public void method3040(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method3062();
         int var5 = this.method3062();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.offset -= 8;
         this.method3057(var4);
         this.method3057(var5);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "487734381"
   )
   @Export("readShortSmart")
   public int readShortSmart() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.readUnsignedByte() - 64:this.readUnsignedShort() - '쀀';
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "29"
   )
   public void method3056(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2089172360"
   )
   public void method3057(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-456027248"
   )
   public int method3062() {
      this.offset += 4;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 24) + ((this.payload[this.offset - 3] & 255) << 16);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-989131061"
   )
   @Export("read24BitInt")
   public int read24BitInt() {
      this.offset += 3;
      return ((this.payload[this.offset - 3] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "936612537"
   )
   public void method3077(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2912(var1 >>> 28 | 128);
               }

               this.method2912(var1 >>> 21 | 128);
            }

            this.method2912(var1 >>> 14 | 128);
         }

         this.method2912(var1 >>> 7 | 128);
      }

      this.method2912(var1 & 127);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1875329090"
   )
   public int method3092() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-13"
   )
   public void method3094(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-1631660567"
   )
   public void method3095(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public int method3096() {
      if(this.payload[this.offset] < 0) {
         return this.method3062() & Integer.MAX_VALUE;
      } else {
         int var1 = this.readUnsignedShort();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "58"
   )
   public void method3097(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += class171.method3246(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "-431225118"
   )
   public void method3104(BigInteger var1, BigInteger var2) {
      int var3 = this.offset;
      this.offset = 0;
      byte[] var4 = new byte[var3];
      this.method3095(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.offset = 0;
      this.method3094(var7.length);
      this.method2921(var7, 0, var7.length);
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "120"
   )
   public String method3113() {
      if(this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.method2934();
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "1517647880"
   )
   public void method3124(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method3062();
         int var8 = this.method3062();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var9 & 3] + var9) {
            var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ var1[var9 >>> 11 & 3] + var9;
            var9 -= var10;
         }

         this.offset -= 8;
         this.method3057(var7);
         this.method3057(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1663196733"
   )
   public int method3132() {
      this.offset += 4;
      return (this.payload[this.offset - 3] & 255) + ((this.payload[this.offset - 4] & 255) << 8) + ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 24);
   }
}
