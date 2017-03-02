import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
@Implements("Script")
public class Script extends CacheableNode {
   @ObfuscatedName("i")
   @Export("intOperands")
   int[] intOperands;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1406492177
   )
   @Export("localStringCount")
   int localStringCount;
   @ObfuscatedName("t")
   @Export("stringOperands")
   String[] stringOperands;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1050563551
   )
   @Export("localIntCount")
   int localIntCount;
   @ObfuscatedName("b")
   static NodeCache field934 = new NodeCache(128);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1861854515
   )
   @Export("intStackCount")
   int intStackCount;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 324971251
   )
   @Export("stringStackCount")
   int stringStackCount;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -1530880899
   )
   static int field937;
   @ObfuscatedName("l")
   @Export("instructions")
   int[] instructions;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Lclass30;",
      garbageValue = "-29"
   )
   static class30 method956() {
      FileOnDisk var0 = null;
      class30 var1 = new class30();

      try {
         var0 = class60.method1204("", Client.field413.field2683, false);
         byte[] var2 = new byte[(int)var0.method1470()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var0.method1469(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new IOException();
            }
         }

         var1 = new class30(new Buffer(var2));
      } catch (Exception var6) {
         ;
      }

      try {
         if(null != var0) {
            var0.method1471();
         }
      } catch (Exception var5) {
         ;
      }

      return var1;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-169327227"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class156.plane][var0][var1];
      if(null == var2) {
         Varbit.region.method1777(class156.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2472(); var6 != null; var6 = (Item)var2.method2479()) {
            ItemComposition var7 = class168.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            Varbit.region.method1777(class156.plane, var0, var1);
         } else {
            var2.method2470(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method2472(); null != var6; var6 = (Item)var2.method2479()) {
               if(var5.id != var6.id) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && null == var10) {
                     var10 = var6;
                  }
               }
            }

            int var9 = (var1 << 7) + var0 + 1610612736;
            Varbit.region.method1931(class156.plane, var0, var1, class65.method1224(var0 * 128 + 64, 64 + var1 * 128, class156.plane), var5, var9, var11, var10);
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;B)V",
      garbageValue = "64"
   )
   public static void method960(class182 var0) {
      class195.field2870 = var0;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1225837098"
   )
   public static String method962(CharSequence var0) {
      long var3 = 0L;
      int var5 = var0.length();

      for(int var6 = 0; var6 < var5; ++var6) {
         var3 *= 37L;
         char var7 = var0.charAt(var6);
         if(var7 >= 65 && var7 <= 90) {
            var3 += (long)(1 + var7 - 65);
         } else if(var7 >= 97 && var7 <= 122) {
            var3 += (long)(1 + var7 - 97);
         } else if(var7 >= 48 && var7 <= 57) {
            var3 += (long)(27 + var7 - 48);
         }

         if(var3 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var3 % 37L && 0L != var3) {
         var3 /= 37L;
      }

      String var8 = class162.method3174(var3);
      if(null == var8) {
         var8 = "";
      }

      return var8;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "652091985"
   )
   static final void method963(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field467.method2472(); var10 != null; var10 = (class25)Client.field467.method2479()) {
         if(var0 == var10.field587 && var10.field573 == var1 && var2 == var10.field583 && var3 == var10.field571) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class25();
         var9.field587 = var0;
         var9.field571 = var3;
         var9.field573 = var1;
         var9.field583 = var2;
         class162.method3169(var9);
         Client.field467.method2468(var9);
      }

      var9.field570 = var4;
      var9.field577 = var5;
      var9.field578 = var6;
      var9.field582 = var7;
      var9.field581 = var8;
   }
}
