import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public final class class94 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1174468991
   )
   int field1569;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 413732145
   )
   int field1570;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1693535559
   )
   int field1571;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -809454027
   )
   int field1572;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1904451993
   )
   int field1573;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1925030517
   )
   int field1574;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1887337939
   )
   int field1575;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1025879761
   )
   int field1576;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1105495511
   )
   int field1577;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -378529853
   )
   int field1578;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1200100575
   )
   int field1579;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1586949495
   )
   int field1580;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1171635767
   )
   int field1581;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1522080259
   )
   int field1582;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -1460702447
   )
   protected static int field1583;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -119578295
   )
   int field1584;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -61248545
   )
   int field1585;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 703670743
   )
   int field1586;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1501034361
   )
   int field1587;
   @ObfuscatedName("ea")
   static SpritePixels field1588;
   @ObfuscatedName("kk")
   static Widget[] field1589;

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-246613085"
   )
   static void method1974(Widget var0, int var1, int var2) {
      if(var0.field2201 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2201 == 1) {
         var0.relativeX = (var1 - var0.width) / 2 + var0.originalX;
      } else if(var0.field2201 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2201 == 3) {
         var0.relativeX = var1 * var0.originalX >> 14;
      } else if(var0.field2201 == 4) {
         var0.relativeX = (var1 - var0.width) / 2 + (var0.originalX * var1 >> 14);
      } else {
         var0.relativeX = var1 - var0.width - (var0.originalX * var1 >> 14);
      }

      if(var0.field2202 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2202 == 1) {
         var0.relativeY = var0.originalY + (var2 - var0.height) / 2;
      } else if(var0.field2202 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2202 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2202 == 4) {
         var0.relativeY = (var0.originalY * var2 >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.originalY >> 14);
      }

      if(Client.field455 && var0.type == 0) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "15646417"
   )
   static final int method1975(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return (var2 * (var1 & 16711935) + (var0 & 16711935) * var3 & -16711936) + ((var1 & '\uff00') * var2 + (var0 & '\uff00') * var3 & 16711680) >> 8;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "96"
   )
   static boolean method1976(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }
}
