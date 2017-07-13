import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hw")
public final class class229 {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;B)V",
      garbageValue = "-6"
   )
   public static void method4070(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.field3337 = var0;
      Spotanim.field3324 = var1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-71"
   )
   static void method4069(int var0) {
      if(var0 != -1) {
         if(class33.loadWidget(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2775 != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.field839 = var3.field2775;
                  IndexFile.method3018(var4, 2000000);
               }
            }

         }
      }
   }
}
