import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
@Implements("Buffer")
public class Buffer extends Node {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -221102553
   )
   @Export("offset")
   public int offset;
   @ObfuscatedName("l")
   @Export("payload")
   public byte[] payload;
   @ObfuscatedName("h")
   static long[] field2053;
   @ObfuscatedName("r")
   static int[] field2057 = new int[256];

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "123056102"
   )
   public int method2617() {
      return 0 - this.payload[++this.offset - 1] & 255;
   }

   public Buffer(byte[] var1) {
      this.payload = var1;
      this.offset = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   public void method2619(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-163876040"
   )
   public int method2620() {
      this.offset += 4;
      return ((this.payload[this.offset - 2] & 255) << 8) + ((this.payload[this.offset - 4] & 255) << 24) + ((this.payload[this.offset - 3] & 255) << 16) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("k")
   public void method2622(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("u")
   public void method2623(long var1) {
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 56));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 48));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 40));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 32));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 24));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 16));
      this.payload[++this.offset - 1] = (byte)((int)(var1 >> 8));
      this.payload[++this.offset - 1] = (byte)((int)var1);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1206146253"
   )
   public void method2625(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.payload[++this.offset - 1] = 0;
         this.offset += class127.method2935(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)V",
      garbageValue = "14"
   )
   public void method2626(CharSequence var1) {
      int var2 = class144.method3127(var1);
      this.payload[++this.offset - 1] = 0;
      this.method2830(var2);
      this.offset += class9.method137(this.payload, this.offset, var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "1678549744"
   )
   public void method2627(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         this.payload[++this.offset - 1] = var1[var4];
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "96"
   )
   public void method2629(int var1) {
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)B",
      garbageValue = "1"
   )
   public byte method2632() {
      return (byte)(this.payload[++this.offset - 1] - 128);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1677396434"
   )
   public int method2633() {
      return this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1800561492"
   )
   public byte method2634() {
      return this.payload[++this.offset - 1];
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1473859186"
   )
   public int method2635() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-82932947"
   )
   public int method2636() {
      this.offset += 2;
      int var1 = ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] & 255);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "39"
   )
   public int method2637() {
      this.offset += 3;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 3] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 8);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "89"
   )
   public String method2640() {
      if(this.payload[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.method2663();
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "16711935"
   )
   public String method2642() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.offset;

         while(this.payload[++this.offset - 1] != 0) {
            ;
         }

         int var3 = this.offset - var2 - 1;
         return var3 == 0?"":NPC.method763(this.payload, var2, var3);
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "-87"
   )
   public String method2643() {
      byte var1 = this.payload[++this.offset - 1];
      if(var1 != 0) {
         throw new IllegalStateException("");
      } else {
         int var2 = this.method2832();
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
                  if(1 + var7 < var9 && (var3[var7] & 192) == 128 && (var3[var7 + 1] & 192) == 128) {
                     var8 = (var10 & 15) << 12 | (var3[var7++] & 63) << 6 | var3[var7++] & 63;
                     if(var8 < 2048) {
                        var8 = '�';
                     }
                  } else {
                     var8 = '�';
                  }
               } else if(var10 < 248) {
                  if(var7 + 2 < var9 && (var3[var7] & 192) == 128 && (var3[var7 + 1] & 192) == 128 && (var3[var7 + 2] & 192) == 128) {
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

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1896859340"
   )
   public int method2645() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.method2633() - 64:this.method2635() - '쀀';
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-18"
   )
   public int method2646() {
      int var1 = this.payload[this.offset] & 255;
      return var1 < 128?this.method2633():this.method2635() - '耀';
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "963392220"
   )
   public long method2649() {
      long var1 = (long)this.method2620() & 4294967295L;
      long var3 = (long)this.method2620() & 4294967295L;
      return var3 + (var1 << 32);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "271358164"
   )
   public void method2650(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2620();
         int var5 = this.method2620();
         int var6 = 0;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var5 += (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6) {
            var4 += (var5 << 4 ^ var5 >>> 5) + var5 ^ var6 + var1[var6 & 3];
            var6 += var7;
         }

         this.offset -= 8;
         this.method2728(var4);
         this.method2728(var5);
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "726257665"
   )
   public void method2651(int[] var1) {
      int var2 = this.offset / 8;
      this.offset = 0;

      for(int var3 = 0; var3 < var2; ++var3) {
         int var4 = this.method2620();
         int var5 = this.method2620();
         int var6 = -957401312;
         int var7 = -1640531527;

         for(int var8 = 32; var8-- > 0; var4 -= var5 + (var5 << 4 ^ var5 >>> 5) ^ var1[var6 & 3] + var6) {
            var5 -= (var4 << 4 ^ var4 >>> 5) + var4 ^ var1[var6 >>> 11 & 3] + var6;
            var6 -= var7;
         }

         this.offset -= 8;
         this.method2728(var4);
         this.method2728(var5);
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "([IIII)V",
      garbageValue = "-781025247"
   )
   public void method2653(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2620();
         int var8 = this.method2620();
         int var9 = -957401312;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var7 -= var8 + (var8 << 4 ^ var8 >>> 5) ^ var1[var9 & 3] + var9) {
            var8 -= var7 + (var7 << 4 ^ var7 >>> 5) ^ var9 + var1[var9 >>> 11 & 3];
            var9 -= var10;
         }

         this.offset -= 8;
         this.method2728(var7);
         this.method2728(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1010283759"
   )
   public void method2654(int var1) {
      this.payload[++this.offset - 1] = (byte)(128 - var1);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "195791009"
   )
   public boolean method2656() {
      this.offset -= 4;
      int var1 = MessageNode.method784(this.payload, 0, this.offset);
      int var2 = this.method2620();
      return var2 == var1;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "0"
   )
   public void method2657(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1564133321"
   )
   public void method2658(int var1) {
      this.payload[++this.offset - 1] = (byte)(0 - var1);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(S)B",
      garbageValue = "-26599"
   )
   public byte method2659() {
      return (byte)(128 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-856822592"
   )
   public int method2662() {
      return 128 - this.payload[++this.offset - 1] & 255;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1958019881"
   )
   public String method2663() {
      int var1 = this.offset;

      while(this.payload[++this.offset - 1] != 0) {
         ;
      }

      int var2 = this.offset - var1 - 1;
      return var2 == 0?"":NPC.method763(this.payload, var1, var2);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)B",
      garbageValue = "-1151567079"
   )
   public byte method2664() {
      return (byte)(0 - this.payload[++this.offset - 1]);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-904975599"
   )
   public void method2666(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "101"
   )
   public void method2667(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(128 + var1);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "2"
   )
   public void method2668(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 + 128);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "2"
   )
   public int method2670() {
      this.offset += 2;
      return ((this.payload[this.offset - 2] & 255) << 8) + (this.payload[this.offset - 1] - 128 & 255);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1620772156"
   )
   public void method2671(int var1) {
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "299215686"
   )
   public int method2674() {
      this.offset += 2;
      int var1 = (this.payload[this.offset - 2] - 128 & 255) + ((this.payload[this.offset - 1] & 255) << 8);
      if(var1 > 32767) {
         var1 -= 65536;
      }

      return var1;
   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1992152242"
   )
   public void method2675(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1261575040"
   )
   public void method2676(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
   }

   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1385425694"
   )
   public void method2677(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)var1;
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-4"
   )
   public int method2678() {
      this.offset += 4;
      return (this.payload[this.offset - 4] & 255) + ((this.payload[this.offset - 3] & 255) << 8) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 24);
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-36"
   )
   public int method2680() {
      this.offset += 4;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 3] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 16) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "([IIIB)V",
      garbageValue = "-42"
   )
   public void method2681(int[] var1, int var2, int var3) {
      int var4 = this.offset;
      this.offset = var2;
      int var5 = (var3 - var2) / 8;

      for(int var6 = 0; var6 < var5; ++var6) {
         int var7 = this.method2620();
         int var8 = this.method2620();
         int var9 = 0;
         int var10 = -1640531527;

         for(int var11 = 32; var11-- > 0; var8 += (var7 << 4 ^ var7 >>> 5) + var7 ^ var1[var9 >>> 11 & 3] + var9) {
            var7 += (var8 << 4 ^ var8 >>> 5) + var8 ^ var1[var9 & 3] + var9;
            var9 += var10;
         }

         this.offset -= 8;
         this.method2728(var7);
         this.method2728(var8);
      }

      this.offset = var4;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "526358156"
   )
   public void method2682(int var1) {
      this.payload[this.offset - var1 - 4] = (byte)(var1 >> 24);
      this.payload[this.offset - var1 - 3] = (byte)(var1 >> 16);
      this.payload[this.offset - var1 - 2] = (byte)(var1 >> 8);
      this.payload[this.offset - var1 - 1] = (byte)var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-34"
   )
   public int method2698() {
      if(this.payload[this.offset] < 0) {
         return this.method2620() & Integer.MAX_VALUE;
      } else {
         int var1 = this.method2635();
         return var1 == 32767?-1:var1;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1915852562"
   )
   public void method2703(String var1) {
      int var2 = var1.indexOf(0);
      if(var2 >= 0) {
         throw new IllegalArgumentException("");
      } else {
         this.offset += class127.method2935(var1, 0, var1.length(), this.payload, this.offset);
         this.payload[++this.offset - 1] = 0;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1416599475"
   )
   public void method2728(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 24);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1536066651"
   )
   public int method2749() {
      this.offset += 2;
      return (this.payload[this.offset - 2] & 255) + ((this.payload[this.offset - 1] & 255) << 8);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "-2137933922"
   )
   public void method2754(byte[] var1, int var2, int var3) {
      for(int var4 = var2; var4 < var3 + var2; ++var4) {
         var1[var4] = this.payload[++this.offset - 1];
      }

   }

   public Buffer(int var1) {
      this.payload = class124.method2894(var1);
      this.offset = 0;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1006815903"
   )
   public int method2773(int var1) {
      int var2 = MessageNode.method784(this.payload, var1, this.offset);
      this.method2728(var2);
      return var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-27"
   )
   public void method2779(int var1) {
      if(var1 >= 0 && var1 < 128) {
         this.method2783(var1);
      } else {
         if(var1 < 0 || var1 >= '耀') {
            throw new IllegalArgumentException();
         }

         this.method2619('耀' + var1);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-30"
   )
   public int method2780() {
      return this.payload[this.offset] < 0?this.method2620() & Integer.MAX_VALUE:this.method2635();
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ljava/math/BigInteger;Ljava/math/BigInteger;I)V",
      garbageValue = "-1308930338"
   )
   public void method2781(BigInteger var1, BigInteger var2) {
      int var3 = this.offset;
      this.offset = 0;
      byte[] var4 = new byte[var3];
      this.method2754(var4, 0, var3);
      BigInteger var5 = new BigInteger(var4);
      BigInteger var6 = var5.modPow(var1, var2);
      byte[] var7 = var6.toByteArray();
      this.offset = 0;
      this.method2619(var7.length);
      this.method2627(var7, 0, var7.length);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1632543771"
   )
   public void method2783(int var1) {
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "14"
   )
   public void method2796(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)var1;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1453542716"
   )
   public int method2799() {
      this.offset += 4;
      return ((this.payload[this.offset - 1] & 255) << 16) + ((this.payload[this.offset - 2] & 255) << 24) + ((this.payload[this.offset - 4] & 255) << 8) + (this.payload[this.offset - 3] & 255);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "63"
   )
   public int method2803() {
      this.offset += 2;
      return ((this.payload[this.offset - 1] & 255) << 8) + (this.payload[this.offset - 2] - 128 & 255);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "20"
   )
   public void method2830(int var1) {
      if((var1 & -128) != 0) {
         if((var1 & -16384) != 0) {
            if((var1 & -2097152) != 0) {
               if((var1 & -268435456) != 0) {
                  this.method2783(var1 >>> 28 | 128);
               }

               this.method2783(var1 >>> 21 | 128);
            }

            this.method2783(var1 >>> 14 | 128);
         }

         this.method2783(var1 >>> 7 | 128);
      }

      this.method2783(var1 & 127);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2137324323"
   )
   public int method2832() {
      byte var1 = this.payload[++this.offset - 1];

      int var2;
      for(var2 = 0; var1 < 0; var1 = this.payload[++this.offset - 1]) {
         var2 = (var2 | var1 & 127) << 7;
      }

      return var2 | var1;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "722767270"
   )
   public int method2834() {
      this.offset += 3;
      return (this.payload[this.offset - 1] & 255) + ((this.payload[this.offset - 2] & 255) << 16) + ((this.payload[this.offset - 3] & 255) << 8);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1619425570"
   )
   public int method2837() {
      return this.payload[++this.offset - 1] - 128 & 255;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "81"
   )
   public void method2849(int var1) {
      this.payload[++this.offset - 1] = (byte)(var1 >> 16);
      this.payload[++this.offset - 1] = (byte)(var1 >> 8);
      this.payload[++this.offset - 1] = (byte)var1;
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

         field2057[var1] = var2;
      }

      field2053 = new long[256];

      for(var0 = 0; var0 < 256; ++var0) {
         long var4 = (long)var0;

         for(int var3 = 0; var3 < 8; ++var3) {
            if(1L == (var4 & 1L)) {
               var4 = var4 >>> 1 ^ -3932672073523589310L;
            } else {
               var4 >>>= 1;
            }
         }

         field2053[var0] = var4;
      }

   }
}
