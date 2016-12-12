import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cw")
   @ObfuscatedGetter(
      intValue = -232120891
   )
   @Export("modelHeight")
   public int modelHeight = 1000;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "7"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("cz")
   void vmethod1859(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod1859(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-16711936"
   )
   public static void method1861(int var0) {
      if(var0 != -1) {
         if(Widget.validInterfaces[var0]) {
            Widget.field2199.method3222(var0);
            if(Widget.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Widget.widgets[var0].length; ++var2) {
                  if(Widget.widgets[var0][var2] != null) {
                     if(Widget.widgets[var0][var2].type != 2) {
                        Widget.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Widget.widgets[var0] = null;
               }

               Widget.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "1877080156"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2828.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class231.field3280.method3211(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method3438(new Buffer(var2));
         }

         KitDefinition.field2828.put(var1, (long)var0);
         return var1;
      }
   }
}
