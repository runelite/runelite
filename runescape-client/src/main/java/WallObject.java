import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 409156829
   )
   int field1534 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -791195365
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -384633473
   )
   @Export("y")
   int y;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 741701463
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 711648863
   )
   int field1538;
   @ObfuscatedName("v")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("l")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("q")
   static String field1541;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1070583935
   )
   int field1543;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1174521379
   )
   @Export("x")
   int x;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)Z",
      garbageValue = "-217859984"
   )
   public static boolean method1838(class182 var0, int var1) {
      byte[] var2 = var0.method3208(var1);
      if(var2 == null) {
         return false;
      } else {
         class2.method29(var2);
         return true;
      }
   }

   @ObfuscatedName("cv")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1465296074"
   )
   static void method1839(Widget var0, int var1, int var2) {
      if(var0.field2212 == 0) {
         var0.relativeX = var0.field2216;
      } else if(var0.field2212 == 1) {
         var0.relativeX = var0.field2216 + (var1 - var0.width) / 2;
      } else if(var0.field2212 == 2) {
         var0.relativeX = var1 - var0.width - var0.field2216;
      } else if(var0.field2212 == 3) {
         var0.relativeX = var1 * var0.field2216 >> 14;
      } else if(var0.field2212 == 4) {
         var0.relativeX = (var0.field2216 * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var0.field2216 * var1 >> 14);
      }

      if(var0.field2236 == 0) {
         var0.relativeY = var0.field2217;
      } else if(var0.field2236 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.field2217;
      } else if(var0.field2236 == 2) {
         var0.relativeY = var2 - var0.height - var0.field2217;
      } else if(var0.field2236 == 3) {
         var0.relativeY = var2 * var0.field2217 >> 14;
      } else if(var0.field2236 == 4) {
         var0.relativeY = (var0.field2217 * var2 >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.field2217 >> 14);
      }

      if(Client.field454 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.relativeY + var0.height > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "117"
   )
   public static int method1840(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;I)V",
      garbageValue = "-528939545"
   )
   public static void method1841(class182 var0, class182 var1, class182 var2) {
      Sequence.field3051 = var0;
      Sequence.field3057 = var1;
      Sequence.field3061 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1442280058"
   )
   static final void method1842() {
      if(Client.field340 > 0) {
         class174.method3179();
      } else {
         class20.setGameState(40);
         class13.field143 = class6.field46;
         class6.field46 = null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIIZB)V",
      garbageValue = "2"
   )
   public static void method1843(class182 var0, int var1, int var2, int var3, boolean var4) {
      class138.field1929 = 1;
      class138.field1930 = var0;
      class138.field1931 = var1;
      class181.field2711 = var2;
      class138.field1932 = var3;
      CombatInfo1.field665 = var4;
      WidgetNode.field186 = 10000;
   }
}
