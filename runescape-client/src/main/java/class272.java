import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
public class class272 {
   @ObfuscatedName("gr")
   public static final int[] field3703;

   static {
      field3703 = new int[]{-2, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, -1, 0, 0, 2, 0, -2, -1, 0, 5, 0, 0, 0, -1, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, -2, -2, 0, -2, 0, 0, 6, 0, 0, 0, 0, -2, 0, 0, 0, 3, 10, 0, -1, -2, 0, -1, 0, 0, 0, 0, 0, 0, 0, -2, 10, 1, 0, 0, 0, 0, 0, 8, 0, 2, -1, 0, 0, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 0, 4, 0, 6, 0, 0, 5, 0, 1, 0, 2, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 14, 1, 0, 0, 8, 4, -2, 2, 0, 0, 0, 0, 0, 0, 2, -2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, -2, 5, 0, 0, 0, 0, 0, 0, 6, 8, 0, 0, 0, 0, -2, 2, 12, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 4, 2, 0, 0, 3, 6, 0, 0, 0, 0, 0, 0, 0, 6, 0, 6, 0, 0, -2, 0, 0, 0, 0, 0, -2, 0, 0, 2, 0, 7, 8, 20, 6, 0, 0, 0, 15, 0, -2, 0, 0, 6, 6, 0, 0, 0, 0, 28, 0, 5, 0, 0, 0, 0, 6, 0, 0, 0, 0, -2, 0, 0, 0, 5, 0, 0, 0, 6, 0, 0, 0};
   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "883853763"
   )
   static final void method4829(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !class90.method1690(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && class90.method1690(var3) && var3 != XGrandExchangeOffer.field308) {
                  continue;
               }

               method4829(var0, var3.id);
               if(var3.children != null) {
                  method4829(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  var5 = var4.id;
                  if(class33.loadWidget(var5)) {
                     method4829(Widget.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2777 != -1 || var3.field2701 != -1) {
                  boolean var7 = AbstractSoundSystem.method2039(var3);
                  if(var7) {
                     var5 = var3.field2701;
                  } else {
                     var5 = var3.field2777;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class112.getAnimation(var5);

                     for(var3.field2776 += Client.field982; var3.field2776 > var6.frameLenghts[var3.field2772]; class48.method749(var3)) {
                        var3.field2776 -= var6.frameLenghts[var3.field2772];
                        ++var3.field2772;
                        if(var3.field2772 >= var6.frameIDs.length) {
                           var3.field2772 -= var6.frameStep;
                           if(var3.field2772 < 0 || var3.field2772 >= var6.frameIDs.length) {
                              var3.field2772 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2709 != 0 && !var3.hasScript) {
                  int var8 = var3.field2709 >> 16;
                  var5 = var3.field2709 << 16 >> 16;
                  var8 *= Client.field982;
                  var5 *= Client.field982;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class48.method749(var3);
               }
            }
         }
      }

   }
}
