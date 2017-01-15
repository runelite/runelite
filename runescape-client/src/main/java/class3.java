import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
final class class3 implements Comparator {
   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZB)V",
      garbageValue = "-19"
   )
   static final void method31(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      int var4;
      if(var1 && var2 != -1 && class6.validInterfaces[var2]) {
         Widget.field2245.method3274(var2);
         if(Widget.widgets[var2] != null) {
            boolean var5 = true;

            for(var4 = 0; var4 < Widget.widgets[var2].length; ++var4) {
               if(null != Widget.widgets[var2][var4]) {
                  if(Widget.widgets[var2][var4].type != 2) {
                     Widget.widgets[var2][var4] = null;
                  } else {
                     var5 = false;
                  }
               }
            }

            if(var5) {
               Widget.widgets[var2] = null;
            }

            class6.validInterfaces[var2] = false;
         }
      }

      class16.method180(var2);
      Widget var6 = class44.method799(var3);
      if(null != var6) {
         class6.method87(var6);
      }

      class101.method1909();
      if(Client.widgetRoot != -1) {
         var4 = Client.widgetRoot;
         if(class94.method1870(var4)) {
            class140.method2607(Widget.widgets[var4], 1);
         }
      }

   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method37((class2)var1, (class2)var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1876922061"
   )
   int method37(class2 var1, class2 var2) {
      return var1.field15.totalQuantity < var2.field15.totalQuantity?-1:(var1.field15.totalQuantity == var2.field15.totalQuantity?0:1);
   }
}
