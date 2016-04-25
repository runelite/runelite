import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
final class class21 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("fq")
   @ObfuscatedGetter(
      intValue = -378928557
   )
   static int field568;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1602871713"
   )
   static void method565() {
      int var0 = class144.field2172;
      int var1 = class144.field2182;
      int var2 = class129.field2028 - class5.field102 - var0;
      int var3 = class37.field809 - class39.field901 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field272.method2999();
            int var5 = 0;
            int var6 = 0;
            if(class4.field82 == var4) {
               Insets var7 = class4.field82.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class37.field809);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class129.field2028, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class129.field2028 - var2, var6, var2, class37.field809);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class37.field809 + var6 - var3, class129.field2028, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   public int compare(Object var1, Object var2) {
      return this.method580((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIIZB)V",
      garbageValue = "0"
   )
   static final void method567(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = client.field527 + (client.field528 - client.field527) * var5 / 100;
      int var7 = 512 * var6 * var3 / (334 * var2);
      int var8;
      int var9;
      short var14;
      if(var7 < client.field533) {
         var14 = client.field533;
         var6 = 334 * var14 * var2 / (var3 * 512);
         if(var6 > client.field401) {
            var6 = client.field401;
            var8 = var3 * var6 * 512 / (334 * var14);
            var9 = (var2 - var8) / 2;
            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > client.field504) {
         var14 = client.field504;
         var6 = var2 * var14 * 334 / (var3 * 512);
         if(var6 < client.field324) {
            var6 = client.field324;
            var8 = var2 * var14 * 334 / (var6 * 512);
            var9 = (var3 - var8) / 2;
            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = (client.field530 - client.field426) * var5 / 100 + client.field426;
      client.field539 = var6 * var3 * var8 / 85504 << 1;
      if(var2 != client.field505 || var3 != client.field538) {
         int[] var15 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + 32 * var10 + 128;
            int var12 = 600 + 3 * var11;
            int var13 = class91.field1571[var11];
            var15[var10] = var12 * var13 >> 16;
         }

         class86.method1975(var15, 500, 800, var2, var3);
      }

      client.field535 = var0;
      client.field536 = var1;
      client.field505 = var2;
      client.field538 = var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass25;B)V",
      garbageValue = "-1"
   )
   static void method572(class25 var0) {
      if(var0.method599() != client.field279) {
         client.field279 = var0.method599();
         class140.method2949(var0.method599());
      }

      client.field312 = var0.field627;
      client.field274 = var0.field618;
      client.field492 = var0.field613;
      class39.field903 = client.field431 == 0?'ꩊ':'鱀' + var0.field618;
      class127.field2020 = 0 == client.field431?443:var0.field618 + '썐';
      class47.field1055 = class39.field903;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-524371370"
   )
   static final void method579() {
      if(class99.field1660 != null) {
         class99.field1660.method2964();
         class99.field1660 = null;
      }

      class11.method152();
      class35.field771.method1905();

      for(int var0 = 0; var0 < 4; ++var0) {
         client.field482[var0].method2378();
      }

      System.gc();
      class183.field2959 = 1;
      class76.field1370 = null;
      class183.field2960 = -1;
      class183.field2961 = -1;
      class183.field2957 = 0;
      class183.field2964 = false;
      class183.field2963 = 2;
      client.field532 = -1;
      client.field512 = false;
      class74.method1594();
      class13.method162(10);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "-1919245533"
   )
   int method580(class214 var1, class214 var2) {
      if(var2.field3162 == var1.field3162) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field3162 == client.field274) {
               return -1;
            }

            if(var2.field3162 == client.field274) {
               return 1;
            }
         }

         return var1.field3162 < var2.field3162?-1:1;
      }
   }

   class21(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "704769708"
   )
   public static int method581(int var0) {
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
}
