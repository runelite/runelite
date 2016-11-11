import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
@Implements("WallObject")
public final class WallObject {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 679745615
   )
   @Export("y")
   int y;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 879769795
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2009917373
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1700911865
   )
   int field1577;
   @ObfuscatedName("u")
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -868258919
   )
   int field1580 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 595234049
   )
   int field1581;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2138696207
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("d")
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("em")
   static SpritePixels[] field1588;

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-966656809"
   )
   static final void method2134(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.field2862 || !FaceNormal.method1940(var3))) {
            if(var3.type == 0) {
               if(!var3.field2862 && FaceNormal.method1940(var3) && var3 != class53.field1153) {
                  continue;
               }

               method2134(var0, var3.id);
               if(var3.children != null) {
                  method2134(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3812((long)var3.id);
               if(var4 != null) {
                  Player.method35(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2828 != -1 || var3.field2850 != -1) {
                  boolean var7 = class172.method3401(var3);
                  if(var7) {
                     var5 = var3.field2850;
                  } else {
                     var5 = var3.field2828;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class192.getAnimation(var5);

                     for(var3.field2925 += Client.field420; var3.field2925 > var6.field1019[var3.field2934]; class32.method673(var3)) {
                        var3.field2925 -= var6.field1019[var3.field2934];
                        ++var3.field2934;
                        if(var3.field2934 >= var6.field1011.length) {
                           var3.field2934 -= var6.field1012;
                           if(var3.field2934 < 0 || var3.field2934 >= var6.field1011.length) {
                              var3.field2934 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2858 != 0 && !var3.field2862) {
                  int var8 = var3.field2858 >> 16;
                  var5 = var3.field2858 << 16 >> 16;
                  var8 *= Client.field420;
                  var5 *= Client.field420;
                  var3.rotationX = var3.rotationX + var8 & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class32.method673(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-315748910"
   )
   static void method2135(Widget var0, int var1, int var2) {
      if(var0.field2807 == 0) {
         var0.relativeX = var0.field2842;
      } else if(var0.field2807 == 1) {
         var0.relativeX = (var1 - var0.width) / 2 + var0.field2842;
      } else if(var0.field2807 == 2) {
         var0.relativeX = var1 - var0.width - var0.field2842;
      } else if(var0.field2807 == 3) {
         var0.relativeX = var1 * var0.field2842 >> 14;
      } else if(var0.field2807 == 4) {
         var0.relativeX = (var0.field2842 * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var1 * var0.field2842 >> 14);
      }

      if(var0.field2808 == 0) {
         var0.relativeY = var0.field2812;
      } else if(var0.field2808 == 1) {
         var0.relativeY = var0.field2812 + (var2 - var0.height) / 2;
      } else if(var0.field2808 == 2) {
         var0.relativeY = var2 - var0.height - var0.field2812;
      } else if(var0.field2808 == 3) {
         var0.relativeY = var2 * var0.field2812 >> 14;
      } else if(var0.field2808 == 4) {
         var0.relativeY = (var2 - var0.height) / 2 + (var0.field2812 * var2 >> 14);
      } else {
         var0.relativeY = var2 - var0.height - (var2 * var0.field2812 >> 14);
      }

      if(Client.field470 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }
}
