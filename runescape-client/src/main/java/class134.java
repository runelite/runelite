import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class134 {
   @ObfuscatedName("d")
   public static boolean field1973;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -804609895
   )
   static int field1967;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -219695799
   )
   static int field1964;
   @ObfuscatedName("y")
   static boolean field1965;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 193794875
   )
   public static int field1970;
   @ObfuscatedName("u")
   public static int[] field1971;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1117684469
   )
   static int field1966;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 2087106583
   )
   static int field1968;
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("mapedge")
   static SpritePixels mapedge;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1884481097
   )
   static int field1972;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1684743551
   )
   static int field1969;

   static {
      field1973 = false;
      field1967 = 0;
      field1964 = 0;
      field1965 = false;
      field1970 = 0;
      field1971 = new int[1000];
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Lhn;III)V",
      garbageValue = "-1362267790"
   )
   static void method2600(Widget var0, int var1, int var2) {
      if(var0.field2634 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2634 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2634 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2634 == 3) {
         var0.relativeX = var0.originalX * var1 >> 14;
      } else if(var0.field2634 == 4) {
         var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2696 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2696 == 1) {
         var0.relativeY = var0.originalY + (var2 - var0.height) / 2;
      } else if(var0.field2696 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2696 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2696 == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field1120 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.relativeX + var0.width > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "20"
   )
   static final void method2601() {
      if(Renderable.soundSystem1 != null) {
         Renderable.soundSystem1.method2077();
      }

      if(class13.soundSystem0 != null) {
         class13.soundSystem0.method2077();
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "1336754469"
   )
   public static int method2598(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var0:(var2 == 1?var1:(var2 == 2?7 - var0 - (var3 - 1):7 - var1 - (var4 - 1)));
   }
}
