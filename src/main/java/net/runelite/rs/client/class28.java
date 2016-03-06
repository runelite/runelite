package net.runelite.rs.client;
import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("am")
@Implements("Item")
public final class class28 extends class84 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1680491553
   )
   @Export("quantity")
   int field672;
   @ObfuscatedName("w")
   static int[] field674;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1553248223
   )
   @Export("id")
   int field677;

   @ObfuscatedName("k")
   static String method652(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("a")
   protected final class104 vmethod1870() {
      return class22.method581(this.field677).method1032(this.field672);
   }

   @ObfuscatedName("l")
   static void method655(Component var0, class166 var1, class166 var2, boolean var3, int var4) {
      if(class31.field715) {
         if(4 == var4) {
            class31.field722 = 4;
         }

      } else {
         class31.field722 = var4;
         class79.method1774();
         byte[] var5 = var1.method3261("title.jpg", "");
         class24.field625 = new class78(var5, var0);
         class31.field712 = class24.field625.method1692();
         if((client.field287 & 536870912) != 0) {
            class31.field713 = class51.method1049(var2, "logo_deadman_mode", "");
         } else {
            class31.field713 = class51.method1049(var2, "logo", "");
         }

         class31.field709 = class51.method1049(var2, "titlebox", "");
         class31.field710 = class51.method1049(var2, "titlebutton", "");
         class31.field736 = class160.method3138(var2, "runes", "");
         class128.field2054 = class160.method3138(var2, "title_mute", "");
         class150.field2269 = class51.method1049(var2, "options_radio_buttons,0", "");
         class3.field64 = class51.method1049(var2, "options_radio_buttons,2", "");
         class4.field75 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class4.field75[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class4.field75[64 + var6] = var6 * 1024 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class4.field75[var6 + 128] = 16776960 + var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class4.field75[var6 + 192] = 16777215;
         }

         field674 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            field674[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            field674[64 + var6] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            field674[128 + var6] = '\uffff' + var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            field674[var6 + 192] = 16777215;
         }

         class23.field617 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class23.field617[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class23.field617[var6 + 64] = 255 + 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class23.field617[var6 + 128] = 16711935 + var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class23.field617[var6 + 192] = 16777215;
         }

         class134.field2085 = new int[256];
         class10.field165 = new int['耀'];
         class126.field2045 = new int['耀'];
         class138.method2885((class80)null);
         class31.field719 = new int['耀'];
         class124.field2037 = new int['耀'];
         if(var3) {
            class31.field731 = "";
            class31.field718 = "";
         }

         class1.field21 = 0;
         class150.field2268 = "";
         class31.field734 = true;
         class31.field721 = false;
         if(!class10.field169.field143) {
            class4.method41(2, class137.field2139, "scape main", "", 255, false);
         } else {
            class182.field2957 = 1;
            class182.field2955 = null;
            class125.field2043 = -1;
            class7.field138 = -1;
            class75.field1388 = 0;
            class11.field182 = false;
            class3.field62 = 2;
         }

         class164.method3192(false);
         class31.field715 = true;
         class31.field732 = (class142.field2190 - client.field503 * 765) / 2;
         class31.field738 = class31.field732 + 202;
         class24.field625.method1744(class31.field732, 0);
         class31.field712.method1744(382 + class31.field732, 0);
         class31.field713.method1838(class31.field732 + 382 - class31.field713.field1431 / 2, 18);
      }
   }

   @ObfuscatedName("a")
   static void method656() {
      if(class31.field715) {
         class31.field709 = null;
         class31.field710 = null;
         class31.field736 = null;
         class24.field625 = null;
         class31.field712 = null;
         class31.field713 = null;
         class128.field2054 = null;
         class150.field2269 = null;
         class3.field64 = null;
         class29.field688 = null;
         class3.field60 = null;
         class22.field598 = null;
         class1.field29 = null;
         class12.field193 = null;
         class4.field75 = null;
         field674 = null;
         class23.field617 = null;
         class134.field2085 = null;
         class10.field165 = null;
         class126.field2045 = null;
         class31.field719 = null;
         class124.field2037 = null;
         class182.field2957 = 1;
         class182.field2955 = null;
         class125.field2043 = -1;
         class7.field138 = -1;
         class75.field1388 = 0;
         class11.field182 = false;
         class3.field62 = 2;
         class164.method3192(true);
         class31.field715 = false;
      }
   }
}
