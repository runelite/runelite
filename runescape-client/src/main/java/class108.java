import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public class class108 {
   @ObfuscatedName("bp")
   static class184 field1736;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "-1793790115"
   )
   public static Widget method1988(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || null == Widget.widgets[var1][var2]) {
         boolean var3 = class109.method1999(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;ZLFont;B)V",
      garbageValue = "-55"
   )
   public static void method1989(class182 var0, class182 var1, boolean var2, Font var3) {
      Ignore.field224 = var0;
      Frames.field1570 = var1;
      ItemComposition.isMembersWorld = var2;
      ItemComposition.field2962 = Ignore.field224.method3192(10);
      ItemComposition.field2957 = var3;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1344833688"
   )
   public static int method1990(int var0) {
      return var0 > 0?1:(var0 < 0?-1:0);
   }
}
