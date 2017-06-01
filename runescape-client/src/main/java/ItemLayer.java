import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1361297231
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 888982089
   )
   @Export("y")
   int y;
   @ObfuscatedName("y")
   @Export("top")
   Renderable top;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1376401029
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -453985679
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -2065740901
   )
   @Export("height")
   int height;
   @ObfuscatedName("b")
   @Export("middle")
   Renderable middle;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "868695555"
   )
   public static void method2392() {
      try {
         if(class203.field2514 == 1) {
            int var0 = class203.field2511.method3669();
            if(var0 > 0 && class203.field2511.method3689()) {
               var0 -= ChatMessages.field1527;
               if(var0 < 0) {
                  var0 = 0;
               }

               class203.field2511.method3668(var0);
               return;
            }

            class203.field2511.method3674();
            class203.field2511.method3672();
            if(class203.field2513 != null) {
               class203.field2514 = 2;
            } else {
               class203.field2514 = 0;
            }

            ChatLineBuffer.field1565 = null;
            class203.field2509 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class203.field2511.method3674();
         class203.field2514 = 0;
         ChatLineBuffer.field1565 = null;
         class203.field2509 = null;
         class203.field2513 = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-90"
   )
   public static boolean method2393(int var0) {
      return class221.field2831.field2832 == var0;
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "98"
   )
   static final void method2394() {
      for(class84 var0 = (class84)Client.field1172.method3576(); var0 != null; var0 = (class84)Client.field1172.method3578()) {
         if(FaceNormal.plane == var0.field1374 && !var0.field1386) {
            if(Client.gameCycle >= var0.field1382) {
               var0.method1662(Client.field1119);
               if(var0.field1386) {
                  var0.unlink();
               } else {
                  class1.region.method2685(var0.field1374, var0.field1376, var0.field1378, var0.field1379, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "14"
   )
   static final boolean method2395(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }
}
