package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("z")
public class class13 implements Runnable {
   @ObfuscatedName("l")
   int[] field187 = new int[500];
   @ObfuscatedName("m")
   Object field188 = new Object();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2110328759
   )
   int field190 = 0;
   @ObfuscatedName("u")
   int[] field191 = new int[500];
   @ObfuscatedName("ey")
   static class78[] field192;
   @ObfuscatedName("eq")
   static class78[] field193;
   @ObfuscatedName("ds")
   static int[][] field197;
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -1134122303
   )
   static int field198;
   @ObfuscatedName("q")
   public static String field199;
   @ObfuscatedName("j")
   boolean field200 = true;

   public void run() {
      for(; this.field200; class29.method711(50L)) {
         Object var1 = this.field188;
         synchronized(this.field188) {
            if(this.field190 < 500) {
               this.field187[this.field190] = class139.field2134;
               this.field191[this.field190] = class139.field2135;
               ++this.field190;
            }
         }
      }

   }

   @ObfuscatedName("cx")
   static void method192(class172 var0, int var1, int var2) {
      if(var0.field2739 == 0) {
         var0.field2846 = var0.field2743;
      } else if(1 == var0.field2739) {
         var0.field2846 = (var1 - var0.field2749) / 2 + var0.field2743;
      } else if(2 == var0.field2739) {
         var0.field2846 = var1 - var0.field2749 - var0.field2743;
      } else if(3 == var0.field2739) {
         var0.field2846 = var1 * var0.field2743 >> 14;
      } else if(4 == var0.field2739) {
         var0.field2846 = (var0.field2743 * var1 >> 14) + (var1 - var0.field2749) / 2;
      } else {
         var0.field2846 = var1 - var0.field2749 - (var0.field2743 * var1 >> 14);
      }

      if(var0.field2740 == 0) {
         var0.field2748 = var0.field2792;
      } else if(var0.field2740 == 1) {
         var0.field2748 = var0.field2792 + (var2 - var0.field2750) / 2;
      } else if(2 == var0.field2740) {
         var0.field2748 = var2 - var0.field2750 - var0.field2792;
      } else if(3 == var0.field2740) {
         var0.field2748 = var2 * var0.field2792 >> 14;
      } else if(var0.field2740 == 4) {
         var0.field2748 = (var2 - var0.field2750) / 2 + (var2 * var0.field2792 >> 14);
      } else {
         var0.field2748 = var2 - var0.field2750 - (var0.field2792 * var2 >> 14);
      }

      if(client.field442 && var0.field2736 == 0) {
         if(var0.field2846 < 0) {
            var0.field2846 = 0;
         } else if(var0.field2749 + var0.field2846 > var1) {
            var0.field2846 = var1 - var0.field2749;
         }

         if(var0.field2748 < 0) {
            var0.field2748 = 0;
         } else if(var0.field2750 + var0.field2748 > var2) {
            var0.field2748 = var2 - var0.field2750;
         }
      }

   }
}
