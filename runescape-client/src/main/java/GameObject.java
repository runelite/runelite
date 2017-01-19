import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 217232823
   )
   @Export("height")
   int height;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -31644421
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 168314371
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("a")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -164324467
   )
   @Export("x")
   int x;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1881645919
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1239139043
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -354733505
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 528574097
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1858954709
   )
   int field1621;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1796983981
   )
   int field1622;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1121850527
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -995260585
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 488721921
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("nx")
   static class57 field1626;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1888023765"
   )
   public static final boolean method1863() {
      class105 var0 = class105.keyboard;
      synchronized(class105.keyboard) {
         if(class105.field1695 == class105.field1696) {
            return false;
         } else {
            class15.field175 = class105.field1714[class105.field1695];
            Item.field880 = class105.field1719[class105.field1695];
            class105.field1695 = class105.field1695 + 1 & 127;
            return true;
         }
      }
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-1877715460"
   )
   static final void method1864(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class13.method149(var3))) {
            if(var3.type == 0) {
               if(!var3.hasScript && class13.method149(var3) && var3 != class215.field3163) {
                  continue;
               }

               method1864(var0, var3.id);
               if(null != var3.children) {
                  method1864(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2274((long)var3.id);
               if(null != var4) {
                  MessageNode.method185(var4.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2256 != -1 || var3.field2200 != -1) {
                  boolean var7 = class6.method78(var3);
                  if(var7) {
                     var5 = var3.field2200;
                  } else {
                     var5 = var3.field2256;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class110.getAnimation(var5);

                     for(var3.field2332 += Client.field533; var3.field2332 > var6.frameLenghts[var3.field2331]; class204.method3671(var3)) {
                        var3.field2332 -= var6.frameLenghts[var3.field2331];
                        ++var3.field2331;
                        if(var3.field2331 >= var6.frameIDs.length) {
                           var3.field2331 -= var6.frameStep;
                           if(var3.field2331 < 0 || var3.field2331 >= var6.frameIDs.length) {
                              var3.field2331 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2312 != 0 && !var3.hasScript) {
                  int var8 = var3.field2312 >> 16;
                  var5 = var3.field2312 << 16 >> 16;
                  var8 *= Client.field533;
                  var5 *= Client.field533;
                  var3.rotationX = var3.rotationX + var8 & 2047;
                  var3.rotationZ = var3.rotationZ + var5 & 2047;
                  class204.method3671(var3);
               }
            }
         }
      }

   }
}
