import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public class class108 {
   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-1507403001"
   )
   static final void method1999(Widget var0, int var1, int var2) {
      if(Client.field455 == null && !Client.isMenuOpen) {
         if(var0 != null && class15.method178(var0) != null) {
            Client.field455 = var0;
            Client.field435 = class15.method178(var0);
            Client.field459 = var1;
            Client.field460 = var2;
            class36.field774 = 0;
            Client.field468 = false;
            if(Client.menuOptionCount > 0) {
               int var3 = Client.menuOptionCount - 1;
               class154.field2120 = new class38();
               class154.field2120.field807 = Client.menuActionParams0[var3];
               class154.field2120.field803 = Client.menuActionParams1[var3];
               class154.field2120.field804 = Client.menuTypes[var3];
               class154.field2120.field802 = Client.menuIdentifiers[var3];
               class154.field2120.field805 = Client.menuOptions[var3];
            }

         }
      }
   }
}
