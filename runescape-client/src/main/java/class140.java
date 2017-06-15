import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class140 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 714151919
   )
   static int field2123;

   @ObfuscatedName("iz")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-1880981419"
   )
   static final void method2751(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var1 == var3.parentId && (!var3.hasScript || !WorldMapType2.method510(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && WorldMapType2.method510(var3) && var3 != Item.field1476) {
                  continue;
               }

               method2751(var0, var3.id);
               if(var3.children != null) {
                  method2751(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method3425((long)var3.id);
               if(var4 != null) {
                  var5 = var4.id;
                  if(class59.method961(var5)) {
                     method2751(Widget.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2777 != -1 || var3.field2702 != -1) {
                  boolean var7 = class54.method746(var3);
                  if(var7) {
                     var5 = var3.field2702;
                  } else {
                     var5 = var3.field2777;
                  }

                  if(var5 != -1) {
                     Sequence var6 = GameEngine.getAnimation(var5);

                     for(var3.field2758 += Client.field1125; var3.field2758 > var6.frameLenghts[var3.field2776]; XItemContainer.method1020(var3)) {
                        var3.field2758 -= var6.frameLenghts[var3.field2776];
                        ++var3.field2776;
                        if(var3.field2776 >= var6.frameIDs.length) {
                           var3.field2776 -= var6.frameStep;
                           if(var3.field2776 < 0 || var3.field2776 >= var6.frameIDs.length) {
                              var3.field2776 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2710 != 0 && !var3.hasScript) {
                  int var8 = var3.field2710 >> 16;
                  var5 = var3.field2710 << 16 >> 16;
                  var8 *= Client.field1125;
                  var5 *= Client.field1125;
                  var3.rotationX = var3.rotationX + var8 & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  XItemContainer.method1020(var3);
               }
            }
         }
      }

   }
}
