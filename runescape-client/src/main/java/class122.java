import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
@Implements("Buffer")
public class class122 extends class211 {
   @ObfuscatedName("e")
   @Export("payload")
   public byte[] field2054;
   @ObfuscatedName("c")
   static int[] field2055 = new int[256];
   @ObfuscatedName("r")
   static long[] field2056;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 581526183
   )
   @Export("offset")
   public int field2061;

   public class122(byte[] var1) {
      this.field2054 = var1;
      this.field2061 = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-180317735"
   )
   public void method2598(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 24);
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 16);
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 8);
      this.field2054[++this.field2061 - 1] = (byte)var1;
   }

   @ObfuscatedName("a")
   public void method2599(long var1) {
      this.field2054[++this.field2061 - 1] = (byte)((int)(var1 >> 40));
      this.field2054[++this.field2061 - 1] = (byte)((int)(var1 >> 32));
      this.field2054[++this.field2061 - 1] = (byte)((int)(var1 >> 24));
      this.field2054[++this.field2061 - 1] = (byte)((int)(var1 >> 16));
      this.field2054[++this.field2061 - 1] = (byte)((int)(var1 >> 8));
      this.field2054[++this.field2061 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "115"
   )
   public int method2600() {
      this.field2061 += 3;
      return ((this.field2054[this.field2061 - 1] & 255) << 8) + ((this.field2054[this.field2061 - 3] & 255) << 16) + (this.field2054[this.field2061 - 2] & 255);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "290888134"
   )
   public void method2601(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field2061 += class20.method541(var1, 0, var1.length(), this.field2054, this.field2061);
         this.field2054[++this.field2061 - 1] = 0;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-113"
   )
   public void method2602(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.field2054[++this.field2061 - 1] = 0;
         this.field2061 += class20.method541(var1, 0, var1.length(), this.field2054, this.field2061);
         this.field2054[++this.field2061 - 1] = 0;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1155038321"
   )
   public void method2604(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.field2054[++this.field2061 - 1] = var1[var4];
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1933181557"
   )
   public void method2606(int var1) {
      this.field2054[this.field2061 - var1 - 2] = (byte)(var1 >> 8);
      this.field2054[this.field2061 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "82"
   )
   public void method2607(int var1) {
      this.field2054[this.field2061 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-65"
   )
   public void method2608(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2795(var1);
      } else if(var1 >= 0 && var1 < '耀') {
         this.method2781(var1 + '耀');
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   public void method2609(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2795(var1 >>> 28 | 128);
               }

               this.method2795(var1 >>> 21 | 128);
            }

            this.method2795(var1 >>> 14 | 128);
         }

         this.method2795(var1 >>> 7 | 128);
      }

      this.method2795(var1 & 127);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "61"
   )
   public int method2610() {
      return this.field2054[++this.field2061 - 1] & 255;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1466117511"
   )
   public byte method2611() {
      return this.field2054[++this.field2061 - 1];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "58"
   )
   public int method2612() {
      this.field2061 += 2;
      return ((this.field2054[this.field2061 - 2] & 255) << 8) + (this.field2054[this.field2061 - 1] & 255);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-7047"
   )
   public int method2613() {
      this.field2061 += 2;
      int var1 = (this.field2054[this.field2061 - 1] & 255) + ((this.field2054[this.field2061 - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   public class122(int var1) {
      this.field2054 = class124.method2848(var1);
      this.field2061 = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1037879653"
   )
   public int method2614() {
      this.field2061 += 4;
      return (this.field2054[this.field2061 - 1] & 255) + ((this.field2054[this.field2061 - 2] & 255) << 8) + ((this.field2054[this.field2061 - 4] & 255) << 24) + ((this.field2054[this.field2061 - 3] & 255) << 16);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-1521719909"
   )
   public long method2615() {
      long var1 = (long)this.method2614() & 4294967295L;
      long var3 = (long)this.method2614() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1795903975"
   )
   public void method2616(int var1) {
      this.field2054[this.field2061 - var1 - 4] = (byte)(var1 >> 24);
      this.field2054[this.field2061 - var1 - 3] = (byte)(var1 >> 16);
      this.field2054[this.field2061 - var1 - 2] = (byte)(var1 >> 8);
      this.field2054[this.field2061 - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-447418836"
   )
   public String method2617() {
      int var1 = this.field2061;

      while(this.field2054[++this.field2061 - 1] != 0) {
         ;
      }

      int var2 = this.field2061 - var1 - 1;
      return var2 == 0?"":class35.method747(this.field2054, var1, var2);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1959794756"
   )
   public String method2618() {
      byte var1 = this.field2054[++this.field2061 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.field2061;

         while(this.field2054[++this.field2061 - 1] != 0) {
            ;
         }

         int var3 = this.field2061 - var2 - 1;
         return var3 == 0?"":class35.method747(this.field2054, var2, var3);
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1140602678"
   )
   public String method2619() {
      byte var1 = this.field2054[++this.field2061 - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2625();
         if(var2 + this.field2061 > this.field2054.length) {
            throw new IllegalStateException("");
         } else {
            byte[] var4 = this.field2054;
            int var5 = this.field2061;
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
            this.field2061 += var2;
            return var3;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1691921101"
   )
   public String method2620() {
      if(this.field2054[this.field2061] == 0) {
         ++this.field2061;
         return null;
      } else {
         return this.method2617();
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2089168881"
   )
   public int method2623() {
      return this.field2054[this.field2061] < 0?this.method2614() & Integer.MAX_VALUE:this.method2612();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-6"
   )
   public int method2624() {
      if(this.field2054[this.field2061] < 0) {
         return this.method2614() & Integer.MAX_VALUE;
      } else {
         int var1 = this.method2612();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int method2625() {
      byte var1 = this.field2054[++this.field2061 - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.field2054[++this.field2061 - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1605761173"
   )
   public void method2626(int[] var1) {
      int var2 = this.field2061 / 8;
      this.field2061 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2614();
         int var5 = this.method2614();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += var5 + (var5 << 4 ^ var5 >>> 5) ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.field2061 -= 8;
         this.method2598(var4);
         this.method2598(var5);
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-1295360019"
   )
   public void method2627(int[] var1) {
      int var2 = this.field2061 / 8;
      this.field2061 = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2614();
         int var5 = this.method2614();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= (var5 << 4 ^ var5 >>> 5) + var5 ^ var1[var6 & 3] + var6) {
            var5 -= var4 + (var4 << 4 ^ var4 >>> 5) ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.field2061 -= 8;
         this.method2598(var4);
         this.method2598(var5);
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-591776518"
   )
   public void method2628(int[] var1, int var2, int var3) {
      int var4 = this.field2061;
      this.field2061 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2614();
         int var8 = this.method2614();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += var7 + (var7 << 4 ^ var7 >>> 5) ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.field2061 -= 8;
         this.method2598(var7);
         this.method2598(var8);
      }

      this.field2061 = var4;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "-69"
   )
   public void method2629(int[] var1, int var2, int var3) {
      int var4 = this.field2061;
      this.field2061 = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2614();
         int var8 = this.method2614();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= (var8 << 4 ^ var8 >>> 5) + var8 ^ var9 + var1[var9 & 3]) {
            var8 -= (var7 << 4 ^ var7 >>> 5) + var7 ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.field2061 -= 8;
         this.method2598(var7);
         this.method2598(var8);
      }

      this.field2061 = var4;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1606058255"
   )
   public int method2631(int var1) {
      int var2 = class21.method554(this.field2054, var1, this.field2061);
      this.method2598(var2);
      return var2;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-790202884"
   )
   public int method2633() {
      return this.field2054[++this.field2061 - 1] - 128 & 255;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1274636358"
   )
   public void method2635(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)V",
      garbageValue = "-1623119087"
   )
   static void method2636(class176 var0) {
      class176 var1 = var0.field2813 == -1?null:class19.method212(var0.field2813);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class142.field2191;
         var3 = class132.field2109;
      } else {
         var2 = var1.field2866;
         var3 = var1.field2810;
      }

      class144.method3078(var0, var2, var3, false);
      class88.method2007(var0, var2, var3);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-70"
   )
   public void method2637(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 8);
      this.field2054[++this.field2061 - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "879469305"
   )
   public byte method2639() {
      return (byte)(this.field2054[++this.field2061 - 1] - 128);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "985695415"
   )
   public byte method2641() {
      return (byte)(128 - this.field2054[++this.field2061 - 1]);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1773178233"
   )
   public void method2642(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)var1;
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "457019931"
   )
   public int method2645() {
      this.field2061 += 2;
      return (this.field2054[this.field2061 - 2] & 255) + ((this.field2054[this.field2061 - 1] & 255) << 8);
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1783548441"
   )
   public int method2646() {
      this.field2061 += 2;
      return (this.field2054[this.field2061 - 1] - 128 & 255) + ((this.field2054[this.field2061 - 2] & 255) << 8);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-21470435"
   )
   public int method2647() {
      this.field2061 += 2;
      return ((this.field2054[this.field2061 - 1] & 255) << 8) + (this.field2054[this.field2061 - 2] - 128 & 255);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "82"
   )
   public int method2649() {
      this.field2061 += 2;
      int var1 = (this.field2054[this.field2061 - 2] - 128 & 255) + ((this.field2054[this.field2061 - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1257226433"
   )
   public void method2652(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 8);
      this.field2054[++this.field2061 - 1] = (byte)var1;
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 24);
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "204325438"
   )
   public void method2653(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 16);
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 24);
      this.field2054[++this.field2061 - 1] = (byte)var1;
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1449092361"
   )
   public int method2654() {
      this.field2061 += 4;
      return ((this.field2054[this.field2061 - 3] & 255) << 8) + ((this.field2054[this.field2061 - 2] & 255) << 16) + ((this.field2054[this.field2061 - 1] & 255) << 24) + (this.field2054[this.field2061 - 4] & 255);
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-88"
   )
   public int method2655() {
      this.field2061 += 4;
      return (this.field2054[this.field2061 - 3] & 255) + ((this.field2054[this.field2061 - 4] & 255) << 8) + ((this.field2054[this.field2061 - 2] & 255) << 24) + ((this.field2054[this.field2061 - 1] & 255) << 16);
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1948642814"
   )
   public int method2656() {
      this.field2061 += 4;
      return (this.field2054[this.field2061 - 2] & 255) + ((this.field2054[this.field2061 - 3] & 255) << 24) + ((this.field2054[this.field2061 - 4] & 255) << 16) + ((this.field2054[this.field2061 - 1] & 255) << 8);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1568540949"
   )
   public int method2662() {
      return 128 - this.field2054[++this.field2061 - 1] & 255;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "90251299"
   )
   static void method2668() {
      class33.field784 = class33.field784.trim();
      if(class33.field784.length() == 0) {
         class117.method2529("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class36.method768();
         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var4 = class33.field784;
            Random var5 = new Random();
            class122 var6 = new class122(128);
            class122 var7 = new class122(128);
            int[] var8 = new int[]{var5.nextInt(), var5.nextInt(), (int)(var1 >> 32), (int)var1};
            var6.method2795(10);

            int var9;
            for(var9 = 0; var9 < 4; ++var9) {
               var6.method2598(var5.nextInt());
            }

            var6.method2598(var8[0]);
            var6.method2598(var8[1]);
            var6.method2709(var1);
            var6.method2709(0L);

            for(var9 = 0; var9 < 4; ++var9) {
               var6.method2598(var5.nextInt());
            }

            var6.method2746(class9.field164, class9.field170);
            var7.method2795(10);

            for(var9 = 0; var9 < 3; ++var9) {
               var7.method2598(var5.nextInt());
            }

            var7.method2709(var5.nextLong());
            var7.method2599(var5.nextLong());
            byte[] var20 = new byte[24];

            try {
               class152.field2283.method4252(0L);
               class152.field2283.method4234(var20);

               int var10;
               for(var10 = 0; var10 < 24 && var20[var10] == 0; ++var10) {
                  ;
               }

               if(var10 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var25) {
               for(int var11 = 0; var11 < 24; ++var11) {
                  var20[var11] = -1;
               }
            }

            var7.method2604(var20, 0, 24);
            var7.method2709(var5.nextLong());
            var7.method2746(class9.field164, class9.field170);
            var9 = class29.method650(var4);
            if(var9 % 8 != 0) {
               var9 += 8 - var9 % 8;
            }

            class122 var21 = new class122(var9);
            var21.method2601(var4);
            var21.field2061 = var9;
            var21.method2626(var8);
            class122 var22 = new class122(var21.field2061 + var7.field2061 + 5 + var6.field2061);
            var22.method2795(2);
            var22.method2795(var6.field2061);
            var22.method2604(var6.field2054, 0, var6.field2061);
            var22.method2795(var7.field2061);
            var22.method2604(var7.field2054, 0, var7.field2061);
            var22.method2781(var21.field2061);
            var22.method2604(var21.field2054, 0, var21.field2061);
            byte[] var13 = var22.field2054;
            String var12 = class45.method961(var13, 0, var13.length);
            String var14 = var12;

            byte var3;
            try {
               URL var15 = new URL(class49.method1060("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + class10.method117(var14) + "&dest=" + class10.method117("passwordchoice.ws"));
               var17.flush();
               InputStream var18 = var16.getInputStream();
               var22 = new class122(new byte[1000]);

               while(true) {
                  int var19 = var18.read(var22.field2054, var22.field2061, 1000 - var22.field2061);
                  if(var19 == -1) {
                     var17.close();
                     var18.close();
                     String var23 = new String(var22.field2054);
                     if(var23.startsWith("OFFLINE")) {
                        var3 = 4;
                     } else if(var23.startsWith("WRONG")) {
                        var3 = 7;
                     } else if(var23.startsWith("RELOAD")) {
                        var3 = 3;
                     } else if(var23.startsWith("Not permitted for social network accounts.")) {
                        var3 = 6;
                     } else {
                        var22.method2627(var8);

                        while(var22.field2061 > 0 && var22.field2054[var22.field2061 - 1] == 0) {
                           --var22.field2061;
                        }

                        var23 = new String(var22.field2054, 0, var22.field2061);
                        if(class129.method2918(var23)) {
                           class124.method2853(var23, true, "openjs", false);
                           var3 = 2;
                        } else {
                           var3 = 5;
                        }
                     }
                     break;
                  }

                  var22.field2061 += var19;
                  if(var22.field2061 >= 1000) {
                     var3 = 5;
                     break;
                  }
               }
            } catch (Throwable var24) {
               var24.printStackTrace();
               var3 = 5;
            }

            var0 = var3;
         }

         switch(var0) {
         case 2:
            class117.method2529("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class33.field778 = 6;
            break;
         case 3:
            class117.method2529("", "Error connecting to server.", "");
            break;
         case 4:
            class117.method2529("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class117.method2529("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class117.method2529("", "Error connecting to server.", "");
            break;
         case 7:
            class117.method2529("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1833171523"
   )
   public int method2672() {
      int var1 = this.field2054[this.field2061] & 255;
      return var1 < 128?this.method2610():this.method2612() - '耀';
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-107"
   )
   public void method2675(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 16);
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 8);
      this.field2054[++this.field2061 - 1] = (byte)var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)V",
      garbageValue = "423176393"
   )
   public void method2683(CharSequence var1) {
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

      this.field2054[++this.field2061 - 1] = 0;
      this.method2609(var4);
      this.field2061 += class147.method3194(this.field2054, this.field2061, var1);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "44"
   )
   public static boolean method2686() {
      return class186.field2993 != 0?true:class186.field2996.method3690();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2043961797"
   )
   public int method2702() {
      int var1 = this.field2054[this.field2061] & 255;
      return var1 < 128?this.method2610() - 64:this.method2612() - '쀀';
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1129693254"
   )
   public int method2703() {
      this.field2061 += 3;
      return ((this.field2054[this.field2061 - 2] & 255) << 8) + ((this.field2054[this.field2061 - 3] & 255) << 16) + (this.field2054[this.field2061 - 1] & 255);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "-52"
   )
   public byte method2707() {
      return (byte)(0 - this.field2054[++this.field2061 - 1]);
   }

   @ObfuscatedName("b")
   public void method2709(long var1) {
      this.field2054[++this.field2061 - 1] = (byte)((int)(var1 >> 56));
      this.field2054[++this.field2061 - 1] = (byte)((int)(var1 >> 48));
      this.field2054[++this.field2061 - 1] = (byte)((int)(var1 >> 40));
      this.field2054[++this.field2061 - 1] = (byte)((int)(var1 >> 32));
      this.field2054[++this.field2061 - 1] = (byte)((int)(var1 >> 24));
      this.field2054[++this.field2061 - 1] = (byte)((int)(var1 >> 16));
      this.field2054[++this.field2061 - 1] = (byte)((int)(var1 >> 8));
      this.field2054[++this.field2061 - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1881589770"
   )
   public void method2732(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)(128 + var1);
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1054252325"
   )
   public void method2737(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var2 + var3; ++var4) {
         var1[var4] = this.field2054[++this.field2061 - 1];
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "14"
   )
   public int method2738() {
      this.field2061 += 2;
      int var1 = (this.field2054[this.field2061 - 1] - 128 & 255) + ((this.field2054[this.field2061 - 2] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-102"
   )
   public void method2742(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)var1;
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 8);
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 16);
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "-295181154"
   )
   public void method2746(BigInteger var1, BigInteger var2) {
      int var3 = this.field2061;
      this.field2061 = 0;
      byte[] var4 = new byte[var3];
      this.method2737(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.field2061 = 0;
      this.method2781(var7.length);
      this.method2604(var7, 0, var7.length);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "836371743"
   )
   public boolean method2755() {
      this.field2061 -= 4;
      int var1 = class21.method554(this.field2054, 0, this.field2061);
      int var2 = this.method2614();
      return var1 == var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-236311371"
   )
   public void method2781(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)(var1 >> 8);
      this.field2054[++this.field2061 - 1] = (byte)var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-8"
   )
   public int method2789() {
      return 0 - this.field2054[++this.field2061 - 1] & 255;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-2"
   )
   public void method2795(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)var1;
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

         field2055[var1] = var0;
      }

      field2056 = new long[256];

      for(var2 = 0; var2 < 256; ++var2) {
         long var4 = (long)var2;

         for(int var3 = 0; var3 < 8; ++var3) {
            if((var4 & 1L) == 1L) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2056[var2] = var4;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-50"
   )
   public void method2805(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "924225711"
   )
   public void method2807(int var1) {
      this.field2054[++this.field2061 - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1482245959"
   )
   public static final boolean method2812() {
      class140 var0 = class140.field2155;
      synchronized(class140.field2155) {
         if(class140.field2173 == class140.field2175) {
            return false;
         } else {
            class53.field1162 = class140.field2170[class140.field2173];
            class107.field1868 = class140.field2169[class140.field2173];
            class140.field2173 = 1 + class140.field2173 & 127;
            return true;
         }
      }
   }
}
