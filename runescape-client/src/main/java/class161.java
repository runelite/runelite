import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class161 {
   class161() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "([LWidget;IB)V",
      garbageValue = "-3"
   )
   static final void method3079(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var1 == var3.parentId && (!var3.hasScript || !class97.method1917(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && class97.method1917(var3) && class15.field167 != var3) {
                  continue;
               }

               method3079(var0, var3.id);
               if(var3.children != null) {
                  method3079(var3.children, var3.id);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.method2374((long)var3.id);
               if(null != var4) {
                  var5 = var4.id;
                  if(class103.method1973(var5)) {
                     method3079(Widget.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2243 != -1 || var3.field2299 != -1) {
                  boolean var7 = ChatMessages.method829(var3);
                  if(var7) {
                     var5 = var3.field2299;
                  } else {
                     var5 = var3.field2243;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class146.getAnimation(var5);

                     for(var3.field2319 += Client.field354; var3.field2319 > var6.frameLenghts[var3.field2221]; class33.method682(var3)) {
                        var3.field2319 -= var6.frameLenghts[var3.field2221];
                        ++var3.field2221;
                        if(var3.field2221 >= var6.frameIDs.length) {
                           var3.field2221 -= var6.frameStep;
                           if(var3.field2221 < 0 || var3.field2221 >= var6.frameIDs.length) {
                              var3.field2221 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2192 != 0 && !var3.hasScript) {
                  int var8 = var3.field2192 >> 16;
                  var5 = var3.field2192 << 16 >> 16;
                  var8 *= Client.field354;
                  var5 *= Client.field354;
                  var3.rotationX = var3.rotationX + var8 & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class33.method682(var3);
               }
            }
         }
      }

   }
}
