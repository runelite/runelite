import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hr")
public class class223 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "-1062239128"
   )
   public static Widget method3959(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = class59.method961(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }
}
