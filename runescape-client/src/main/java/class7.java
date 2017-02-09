import java.awt.FontMetrics;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
final class class7 implements Comparator {
   @ObfuscatedName("a")
   static int[][][] field55;
   @ObfuscatedName("md")
   static SpritePixels field56;
   @ObfuscatedName("bf")
   static FontMetrics field60;
   @ObfuscatedName("i")
   static int[] field62;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "-55"
   )
   int method102(class2 var1, class2 var2) {
      return var1.field21 < var2.field21?-1:(var1.field21 == var2.field21?0:1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-1"
   )
   static int method103(int var0) {
      MessageNode var1 = (MessageNode)class47.field925.method2297((long)var0);
      return null == var1?-1:(class47.field926.field1892 == var1.next?-1:((MessageNode)var1.next).id);
   }

   public int compare(Object var1, Object var2) {
      return this.method102((class2)var1, (class2)var2);
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1768303381"
   )
   static void method109(Widget var0, int var1, int var2) {
      if(var0.field2111 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2111 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2111 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2111 == 3) {
         var0.relativeX = var1 * var0.originalX >> 14;
      } else if(var0.field2111 == 4) {
         var0.relativeX = (var1 * var0.originalX >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var1 * var0.originalX >> 14);
      }

      if(var0.field2179 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2179 == 1) {
         var0.relativeY = var0.originalY + (var2 - var0.height) / 2;
      } else if(var0.field2179 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2179 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2179 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var2 * var0.originalY >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var0.originalY * var2 >> 14);
      }

      if(Client.field486 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "115"
   )
   public static void method110() {
      if(null != class115.mouse) {
         class115 var0 = class115.mouse;
         synchronized(class115.mouse) {
            class115.mouse = null;
         }
      }

   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(IIIIIIIS)V",
      garbageValue = "4676"
   )
   static final void method112(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(class15.method193(var0)) {
         class15.method192(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
