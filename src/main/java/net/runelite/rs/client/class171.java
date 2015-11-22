package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("fl")
public class class171 extends class203 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1776863783
   )
   int field2718;
   @ObfuscatedName("j")
   class167 field2719;
   @ObfuscatedName("f")
   byte field2721;

   @ObfuscatedName("o")
   static final void method3457() {
      int[] var0 = class32.field730;

      int var1;
      for(var1 = 0; var1 < class32.field733; ++var1) {
         class2 var2 = client.field397[var0[var1]];
         if(null != var2 && var2.field814 > 0) {
            --var2.field814;
            if(var2.field814 == 0) {
               var2.field852 = null;
            }
         }
      }

      for(var1 = 0; var1 < client.field314; ++var1) {
         int var4 = client.field315[var1];
         class34 var3 = client.field313[var4];
         if(null != var3 && var3.field814 > 0) {
            --var3.field814;
            if(0 == var3.field814) {
               var3.field852 = null;
            }
         }
      }

   }

   @ObfuscatedName("j")
   static void method3458(class0 var0) {
      class149.method3182(var0, 200000);
   }

   @ObfuscatedName("c")
   static final void method3459() {
      int var0 = class32.field733;
      int[] var1 = class32.field730;

      for(int var2 = 0; var2 < var0; ++var2) {
         class2 var3 = client.field397[var1[var2]];
         if(var3 != null) {
            class21.method609(var3);
         }
      }

   }

   @ObfuscatedName("bk")
   static final void method3460() {
      for(int var0 = 0; var0 < client.field444; ++var0) {
         int var1 = client.field317[var0];
         class34 var2 = client.field313[var1];
         int var3 = client.field320.method2536();
         if(0 != (var3 & 2)) {
            var2.field761 = class22.method618(client.field320.method2572());
            var2.field802 = var2.field761.field871;
            var2.field850 = var2.field761.field894;
            var2.field806 = var2.field761.field877 * -1;
            var2.field807 = var2.field761.field904 * -1;
            var2.field822 = var2.field761.field896 * -1;
            var2.field818 = var2.field761.field880 * -1;
            var2.field803 = var2.field761.field872 * -1;
            var2.field804 = var2.field761.field866 * -1;
            var2.field849 = var2.field761.field867;
         }

         int var4;
         if((var3 & 8) != 0) {
            var2.field805 = client.field320.method2572();
            var4 = client.field320.method2541();
            var2.field838 = var4 >> 16;
            var2.field837 = client.field286 + (var4 & '\uffff');
            var2.field835 = 0;
            var2.field808 = 0;
            if(var2.field837 > client.field286) {
               var2.field835 = -1;
            }

            if('\uffff' == var2.field805) {
               var2.field805 = -1;
            }
         }

         if(0 != (var3 & 64)) {
            var2.field852 = client.field320.method2544();
            var2.field814 = 100;
         }

         int var5;
         int var6;
         if(0 != (var3 & 32)) {
            var4 = client.field320.method2572();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = client.field320.method2536();
            if(var4 == var2.field829 && -1 != var4) {
               var6 = client.method584(var4).field969;
               if(1 == var6) {
                  var2.field830 = 0;
                  var2.field841 = 0;
                  var2.field832 = var5;
                  var2.field854 = 0;
               }

               if(2 == var6) {
                  var2.field854 = 0;
               }
            } else if(var4 == -1 || var2.field829 == -1 || client.method584(var4).field970 >= client.method584(var2.field829).field970) {
               var2.field829 = var4;
               var2.field830 = 0;
               var2.field841 = 0;
               var2.field832 = var5;
               var2.field854 = 0;
               var2.field856 = var2.field851;
            }
         }

         if((var3 & 4) != 0) {
            var2.field823 = client.field320.method2570();
            if(var2.field823 == '\uffff') {
               var2.field823 = -1;
            }
         }

         if((var3 & 16) != 0) {
            var4 = client.field320.method2559();
            var5 = client.field320.method2559();
            var2.method792(var4, var5, client.field286);
            var2.field820 = 300 + client.field286;
            var2.field833 = client.field320.method2572();
            var2.field853 = client.field320.method2538();
         }

         if((var3 & 1) != 0) {
            var4 = client.field320.method2571();
            var5 = client.field320.method2571();
            var6 = var2.field846 - (var4 - class47.field1053 - class47.field1053) * 64;
            int var7 = var2.field834 - 64 * (var5 - class161.field2629 - class161.field2629);
            if(var6 != 0 || 0 != var7) {
               var2.field825 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if(0 != (var3 & 128)) {
            var4 = client.field320.method2559();
            var5 = client.field320.method2536();
            var2.method792(var4, var5, client.field286);
            var2.field820 = 300 + client.field286;
            var2.field833 = client.field320.method2538();
            var2.field853 = client.field320.method2571();
         }
      }

   }
}
