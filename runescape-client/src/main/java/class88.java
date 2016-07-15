import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("Renderable")
public abstract class class88 extends class207 {
   @ObfuscatedName("cu")
   @ObfuscatedGetter(
      intValue = -393075685
   )
   @Export("modelHeight")
   public int field1529 = 1000;

   @ObfuscatedName("af")
   void vmethod2394(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class108 var10 = this.vmethod1999();
      if(null != var10) {
         this.field1529 = var10.field1529;
         var10.vmethod2394(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "-2017557153"
   )
   @Export("getModel")
   protected class108 vmethod1999() {
      return null;
   }

   @ObfuscatedName("cr")
   @ObfuscatedSignature(
      signature = "(Lclass176;IIIIIII)V",
      garbageValue = "620467155"
   )
   static final void method2006(class176 var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(client.field339) {
         client.field378 = 32;
      } else {
         client.field378 = 0;
      }

      client.field339 = false;
      int var7;
      if(class143.field2199 == 1 || !client.field469 && class143.field2199 == 4) {
         if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < 16 + var2) {
            var0.field2883 -= 4;
            class51.method1124(var0);
         } else if(var5 >= var1 && var5 < var1 + 16 && var6 >= var2 + var3 - 16 && var6 < var3 + var2) {
            var0.field2883 += 4;
            class51.method1124(var0);
         } else if(var5 >= var1 - client.field378 && var5 < 16 + var1 + client.field378 && var6 >= 16 + var2 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if(var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.field2883 = (var4 - var3) * var8 / var9;
            class51.method1124(var0);
            client.field339 = true;
         }
      }

      if(client.field573 != 0) {
         var7 = var0.field2866;
         if(var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.field2883 += client.field573 * 45;
            class51.method1124(var0);
         }
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(Lclass176;III)V",
      garbageValue = "-1971877621"
   )
   static void method2007(class176 var0, int var1, int var2) {
      if(var0.field2799 == 0) {
         var0.field2807 = var0.field2803;
      } else if(var0.field2799 == 1) {
         var0.field2807 = var0.field2803 + (var1 - var0.field2866) / 2;
      } else if(var0.field2799 == 2) {
         var0.field2807 = var1 - var0.field2866 - var0.field2803;
      } else if(var0.field2799 == 3) {
         var0.field2807 = var1 * var0.field2803 >> 14;
      } else if(var0.field2799 == 4) {
         var0.field2807 = (var0.field2803 * var1 >> 14) + (var1 - var0.field2866) / 2;
      } else {
         var0.field2807 = var1 - var0.field2866 - (var1 * var0.field2803 >> 14);
      }

      if(var0.field2800 == 0) {
         var0.field2808 = var0.field2804;
      } else if(var0.field2800 == 1) {
         var0.field2808 = (var2 - var0.field2810) / 2 + var0.field2804;
      } else if(var0.field2800 == 2) {
         var0.field2808 = var2 - var0.field2810 - var0.field2804;
      } else if(var0.field2800 == 3) {
         var0.field2808 = var0.field2804 * var2 >> 14;
      } else if(var0.field2800 == 4) {
         var0.field2808 = (var2 - var0.field2810) / 2 + (var2 * var0.field2804 >> 14);
      } else {
         var0.field2808 = var2 - var0.field2810 - (var0.field2804 * var2 >> 14);
      }

      if(client.field464 && var0.field2796 == 0) {
         if(var0.field2807 < 0) {
            var0.field2807 = 0;
         } else if(var0.field2866 + var0.field2807 > var1) {
            var0.field2807 = var1 - var0.field2866;
         }

         if(var0.field2808 < 0) {
            var0.field2808 = 0;
         } else if(var0.field2808 + var0.field2810 > var2) {
            var0.field2808 = var2 - var0.field2810;
         }
      }

   }
}
