package net.runelite.rs.client;

import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cl")
public final class class93 {
   @ObfuscatedName("t")
   public class84 field1586;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -782089011
   )
   int field1587;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 432936943
   )
   int field1588;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 944788183
   )
   int field1589;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1698275417
   )
   int field1590;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1901578287
   )
   int field1591;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 586141899
   )
   int field1592;
   @ObfuscatedName("i")
   public class84 field1593;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 292353991
   )
   public int field1595 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -45410173
   )
   int field1596 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1873238745
   )
   int field1599;

   @ObfuscatedName("m")
   public static void method2181() {
      if(class136.field2100 != null) {
         class136 var0 = class136.field2100;
         synchronized(class136.field2100) {
            class136.field2100 = null;
         }
      }

   }

   @ObfuscatedName("f")
   static void method2182(int var0) {
      if(-1 != var0) {
         if(class167.method3400(var0)) {
            class172[] var1 = class172.field2857[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class172 var3 = var1[var2];
               if(var3.field2828 != null) {
                  class0 var4 = new class0();
                  var4.field2 = var3;
                  var4.field10 = var3.field2828;
                  class149.method3182(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("cm")
   static void method2183(class172[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         class172 var6 = var0[var5];
         if(null != var6 && var6.field2742 == var1) {
            class49.method1044(var6, var2, var3, var4);
            class13.method192(var6, var2, var3);
            if(var6.field2755 > var6.field2856 - var6.field2749) {
               var6.field2755 = var6.field2856 - var6.field2749;
            }

            if(var6.field2755 < 0) {
               var6.field2755 = 0;
            }

            if(var6.field2762 > var6.field2765 - var6.field2750) {
               var6.field2762 = var6.field2765 - var6.field2750;
            }

            if(var6.field2762 < 0) {
               var6.field2762 = 0;
            }

            if(var6.field2736 == 0) {
               class33.method754(var0, var6, var4);
            }
         }
      }

   }
}
