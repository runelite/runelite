import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("b")
   static byte[][][] field2018;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 861799345
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1237027645
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1002998349
   )
   @Export("z")
   int z;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1480682103
   )
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      signature = "(Lea;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "320726178"
   )
   static void method2613(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      signature = "(Lhx;III)V",
      garbageValue = "-1661113368"
   )
   static final void method2614(Widget var0, int var1, int var2) {
      if(Client.field1111 == null && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var5 = var0;
            int var6 = Actor.method1537(Coordinates.getWidgetConfig(var0));
            Widget var4;
            int var7;
            if(var6 == 0) {
               var4 = null;
            } else {
               var7 = 0;

               while(true) {
                  if(var7 >= var6) {
                     var4 = var5;
                     break;
                  }

                  var5 = GZipDecompressor.method3177(var5.parentId);
                  if(var5 == null) {
                     var4 = null;
                     break;
                  }

                  ++var7;
               }
            }

            Widget var8 = var4;
            if(var4 == null) {
               var8 = var0.dragParent;
            }

            if(var8 != null) {
               Client.field1111 = var0;
               var5 = var0;
               var6 = Actor.method1537(Coordinates.getWidgetConfig(var0));
               if(var6 == 0) {
                  var4 = null;
               } else {
                  var7 = 0;

                  while(true) {
                     if(var7 >= var6) {
                        var4 = var5;
                        break;
                     }

                     var5 = GZipDecompressor.method3177(var5.parentId);
                     if(var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var7;
                  }
               }

               var8 = var4;
               if(var4 == null) {
                  var8 = var0.dragParent;
               }

               Client.field1045 = var8;
               Client.field1106 = var1;
               Client.field1107 = var2;
               class54.field682 = 0;
               Client.field1115 = false;
               int var9 = class51.method817();
               if(var9 != -1) {
                  class34.method514(var9);
               }

               return;
            }
         }

      }
   }
}
