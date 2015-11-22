package net.runelite.rs.client;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("n")
public class class17 {
   @ObfuscatedName("t")
   static byte[][] field236;
   @ObfuscatedName("j")
   String field237;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 284396947
   )
   int field238;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1824080249
   )
   int field239;
   @ObfuscatedName("a")
   boolean field240;
   @ObfuscatedName("m")
   String field241;
   @ObfuscatedName("u")
   boolean field243;
   @ObfuscatedName("qd")
   public static Canvas field244;

   @ObfuscatedName("bd")
   static void method212(int var0, int var1, int var2, int var3) {
      class172 var4 = class214.method4009(var0, var1);
      if(null != var4 && var4.field2858 != null) {
         class0 var5 = new class0();
         var5.field2 = var4;
         var5.field10 = var4.field2858;
         class171.method3458(var5);
      }

      client.field379 = var3;
      client.field546 = true;
      class77.field1386 = var0;
      client.field355 = var1;
      class138.field2124 = var2;
      class42.method942(var4);
   }

   @ObfuscatedName("ax")
   static void method213() {
      int var0 = class143.field2188;
      int var1 = class143.field2185;
      int var2 = class18.field252 - class129.field2048 - var0;
      int var3 = class22.field585 - class136.field2101 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field274.method3059();
            int var5 = 0;
            int var6 = 0;
            if(var4 == class39.field902) {
               Insets var7 = class39.field902.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class22.field585);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class18.field252, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class18.field252 - var2, var6, var2, class22.field585);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class22.field585 + var6 - var3, class18.field252, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("i")
   static class25 method214() {
      return class25.field623 < class25.field616?class25.field615[++class25.field623 - 1]:null;
   }

   @ObfuscatedName("n")
   static final int method215(int var0, int var1) {
      if(-2 == var0) {
         return 12345678;
      } else if(-1 == var0) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("u")
   public static boolean method216(int var0) {
      return 0 != (var0 >> 28 & 1);
   }
}
