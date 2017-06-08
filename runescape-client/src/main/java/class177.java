import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class177 {
   @ObfuscatedName("da")
   @ObfuscatedGetter(
      intValue = 208258209
   )
   static int field2423;
   @ObfuscatedName("h")
   static ModIcon[] field2426;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-1090804178"
   )
   static boolean method3381(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "571116524"
   )
   public static Widget method3390(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || Widget.widgets[var1][var2] == null) {
         boolean var3 = class73.method1095(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }
}
