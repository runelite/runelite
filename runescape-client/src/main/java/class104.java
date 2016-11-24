import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
public class class104 {
   @ObfuscatedName("w")
   static File field1676;
   @ObfuscatedName("h")
   static File field1679;
   @ObfuscatedName("l")
   public static class72 field1680 = null;
   @ObfuscatedName("f")
   static String[] field1685;
   @ObfuscatedName("y")
   public static class72 field1687 = null;
   @ObfuscatedName("e")
   public static class72[] field1688;
   @ObfuscatedName("q")
   public static class72 field1689 = null;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 251305295
   )
   @Export("cameraYaw")
   static int cameraYaw;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "71"
   )
   public static int method2034(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var2 * var0;
      } else {
         return var2;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;Lclass182;Lclass182;B)V",
      garbageValue = "108"
   )
   public static void method2041(class182 var0, class182 var1, class182 var2, class182 var3) {
      Widget.field2059 = var0;
      Widget.field2066 = var1;
      Widget.field2071 = var2;
      Widget.field2062 = var3;
      Widget.widgets = new Widget[Widget.field2059.method3360()][];
      Widget.validInterfaces = new boolean[Widget.field2059.method3360()];
   }

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "([LWidget;IB)V",
      garbageValue = "0"
   )
   static final void method2043(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(null != var3 && var3.parentId == var1 && (!var3.field2068 || !class33.method715(var3))) {
            if(var3.type == 0) {
               if(!var3.field2068 && class33.method715(var3) && class39.field802 != var3) {
                  continue;
               }

               method2043(var0, var3.id);
               if(var3.children != null) {
                  method2043(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.method2405((long)var3.id);
               if(null != var7) {
                  class107.method2085(var7.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2116 != -1 || var3.field2117 != -1) {
                  boolean var4 = class16.method198(var3);
                  if(var4) {
                     var5 = var3.field2117;
                  } else {
                     var5 = var3.field2116;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class9.getAnimation(var5);

                     for(var3.field2192 += Client.field517; var3.field2192 > var6.field3050[var3.field2057]; Tile.method1577(var3)) {
                        var3.field2192 -= var6.field3050[var3.field2057];
                        ++var3.field2057;
                        if(var3.field2057 >= var6.field3047.length) {
                           var3.field2057 -= var6.field3061;
                           if(var3.field2057 < 0 || var3.field2057 >= var6.field3047.length) {
                              var3.field2057 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2112 != 0 && !var3.field2068) {
                  int var8 = var3.field2112 >> 16;
                  var5 = var3.field2112 << 16 >> 16;
                  var8 *= Client.field517;
                  var5 *= Client.field517;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  Tile.method1577(var3);
               }
            }
         }
      }

   }
}
