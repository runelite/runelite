import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
public class class64 {
   @ObfuscatedName("ee")
   static Font field788;
   @ObfuscatedName("ly")
   static Widget[] field790;

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "2117970685"
   )
   static final void method1021(class119 var0) {
      var0.field1716 = false;
      if(var0.field1717 != null) {
         var0.field1717.field1749 = 0;
      }

      for(class119 var1 = var0.vmethod3771(); var1 != null; var1 = var0.vmethod3780()) {
         method1021(var1);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1988550244"
   )
   static void method1022(int var0) {
      if(var0 != -1) {
         if(class59.method961(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2735 != null) {
                  class69 var4 = new class69();
                  var4.field822 = var3;
                  var4.field821 = var3.field2735;
                  class46.method671(var4, 2000000);
               }
            }

         }
      }
   }
}
