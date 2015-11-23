package net.runelite.rs.client;

import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("l")
@Implements("WidgetNode")
public class class3 extends class207 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1118259427
   )
   int field61;
   @ObfuscatedName("f")
   boolean field62 = false;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 16913577
   )
   @Export("id")
   int field63;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1119882635
   )
   static int field64;
   @ObfuscatedName("iu")
   static class172 field65;

   @ObfuscatedName("aa")
   static final void method43(class37 var0) {
      if(0 != var0.field850) {
         if(var0.field823 != -1) {
            Object var1 = null;
            if(var0.field823 < '耀') {
               var1 = client.field313[var0.field823];
            } else if(var0.field823 >= '耀') {
               var1 = client.field397[var0.field823 - '耀'];
            }

            if(null != var1) {
               int var2 = var0.field846 - ((class37)var1).field846;
               int var3 = var0.field834 - ((class37)var1).field834;
               if(0 != var2 || var3 != 0) {
                  var0.field848 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field824) {
               var0.field823 = -1;
               var0.field824 = false;
            }
         }

         if(-1 != var0.field825 && (var0.field851 == 0 || var0.field831 > 0)) {
            var0.field848 = var0.field825;
            var0.field825 = -1;
         }

         int var4 = var0.field848 - var0.field800 & 2047;
         if(0 == var4 && var0.field824) {
            var0.field823 = -1;
            var0.field824 = false;
         }

         if(0 != var4) {
            ++var0.field857;
            boolean var5;
            if(var4 > 1024) {
               var0.field800 -= var0.field850;
               var5 = true;
               if(var4 < var0.field850 || var4 > 2048 - var0.field850) {
                  var0.field800 = var0.field848;
                  var5 = false;
               }

               if(var0.field803 == var0.field826 && (var0.field857 > 25 || var5)) {
                  if(-1 != var0.field804) {
                     var0.field826 = var0.field804;
                  } else {
                     var0.field826 = var0.field806;
                  }
               }
            } else {
               var0.field800 += var0.field850;
               var5 = true;
               if(var4 < var0.field850 || var4 > 2048 - var0.field850) {
                  var0.field800 = var0.field848;
                  var5 = false;
               }

               if(var0.field803 == var0.field826 && (var0.field857 > 25 || var5)) {
                  if(var0.field849 * -1 != -1) {
                     var0.field826 = var0.field849 * -1;
                  } else {
                     var0.field826 = var0.field806;
                  }
               }
            }

            var0.field800 &= 2047;
         } else {
            var0.field857 = 0;
         }

      }
   }

   @ObfuscatedName("u")
   public static void method44() {
      class52.field1144.method3806();
   }

   @ObfuscatedName("ar")
   static final void method45(int var0, int var1) {
      if(client.field429 == 2) {
         class9.method150(client.field300 + (client.field502 - class47.field1053 << 7), client.field349 + (client.field437 - class161.field2629 << 7), client.field299 * 2);
         if(client.field382 * -1 > -1 && client.field286 % 20 < 10) {
            client.field342[0].method1730(var0 + client.field382 * -1 - 12, var1 + client.field395 * -1 - 28);
         }

      }
   }

   @ObfuscatedName("s")
   public static boolean method46(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
