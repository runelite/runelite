import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
public class class180 {
   @ObfuscatedName("fs")
   static byte[][] field2437;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "78"
   )
   static void method3377(int var0) {
      if(var0 != -1) {
         if(class213.loadWidget(var0)) {
            Widget[] var1 = FileRequest.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2819 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.objs = var3.field2819;
                  class213.method3942(var4, 2000000);
               }
            }

         }
      }
   }
}
