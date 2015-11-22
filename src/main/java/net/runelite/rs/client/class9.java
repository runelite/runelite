package net.runelite.rs.client;

import java.lang.management.GarbageCollectorMXBean;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("k")
public class class9 {
   @ObfuscatedName("a")
   static final BigInteger field147 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("u")
   static final BigInteger field149 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("pn")
   static GarbageCollectorMXBean field153;
   @ObfuscatedName("h")
   public static short[] field154;

   @ObfuscatedName("h")
   static void method143(String var0, String var1, String var2) {
      class31.field710 = var0;
      class31.field714 = var1;
      class31.field712 = var2;
   }

   @ObfuscatedName("aw")
   static final void method150(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class34.method774(var0, var1, class8.field134) - var2;
         var0 -= class29.field672;
         var3 -= class132.field2053;
         var1 -= class76.field1374;
         int var4 = class90.field1571[class11.field169];
         int var5 = class90.field1573[class11.field169];
         int var6 = class90.field1571[class83.field1434];
         int var7 = class90.field1573[class83.field1434];
         int var8 = var0 * var7 + var6 * var1 >> 16;
         var1 = var7 * var1 - var6 * var0 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var1 * var4 >> 16;
         var1 = var1 * var5 + var3 * var4 >> 16;
         if(var1 >= 50) {
            client.field382 = (client.field538 / 2 + client.field540 * var0 / var1) * -1;
            client.field395 = (var8 * client.field540 / var1 + client.field539 / 2) * -1;
         } else {
            client.field382 = 1;
            client.field395 = 1;
         }

      } else {
         client.field382 = 1;
         client.field395 = 1;
      }
   }

   @ObfuscatedName("j")
   static int method151(class166 var0, class166 var1) {
      int var2 = 0;
      if(var0.method3330("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3330("logo", "")) {
         ++var2;
      }

      if(var1.method3330("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3330("titlebox", "")) {
         ++var2;
      }

      if(var1.method3330("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3330("runes", "")) {
         ++var2;
      }

      if(var1.method3330("title_mute", "")) {
         ++var2;
      }

      if(var1.method3331("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3331("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3330("sl_back", "");
      var1.method3330("sl_flags", "");
      var1.method3330("sl_arrows", "");
      var1.method3330("sl_stars", "");
      var1.method3330("sl_button", "");
      return var2;
   }

   @ObfuscatedName("dr")
   static final void method153(int var0, int var1, int var2, int var3, class78 var4, class174 var5) {
      if(var4 != null) {
         int var6 = client.field434 + client.field346 & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class90.field1571[var6];
            int var9 = class90.field1573[var6];
            var8 = 256 * var8 / (256 + client.field348);
            var9 = 256 * var9 / (client.field348 + 256);
            int var10 = var2 * var9 + var8 * var3 >> 16;
            int var11 = var9 * var3 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method1771(var10 + var5.field2882 / 2 - var4.field1388 / 2, var5.field2877 / 2 - var11 - var4.field1399 / 2, var0, var1, var5.field2882, var5.field2877, var5.field2879, var5.field2878);
            } else {
               var4.method1730(var5.field2882 / 2 + var0 + var10 - var4.field1388 / 2, var5.field2877 / 2 + var1 - var11 - var4.field1399 / 2);
            }

         }
      }
   }
}
