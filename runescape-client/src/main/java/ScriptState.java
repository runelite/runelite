import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("ScriptState")
public class ScriptState {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2119476419
   )
   @Export("invokedFromPc")
   int invokedFromPc;
   @ObfuscatedName("t")
   @Export("savedLocalStrings")
   String[] savedLocalStrings;
   @ObfuscatedName("e")
   @Export("savedLocalInts")
   int[] savedLocalInts;
   @ObfuscatedName("p")
   @Export("invokedFromScript")
   Script invokedFromScript;

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "1656032233"
   )
   static final void method1009(Widget var0, int var1, int var2) {
      if(Client.field1079 == null && !Client.isMenuOpen) {
         if(var0 != null && class47.method675(var0) != null) {
            Client.field1079 = var0;
            Client.field1080 = class47.method675(var0);
            Client.field1081 = var1;
            Client.field1082 = var2;
            class33.field478 = 0;
            Client.field1090 = false;
            int var3 = class230.method3976();
            if(var3 != -1) {
               class10.method58(var3);
            }

         }
      }
   }

   ScriptState() {
      this.invokedFromPc = -1;
   }
}
