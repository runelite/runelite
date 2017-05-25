import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
final class class18 implements Comparator {
   @ObfuscatedName("p")
   static byte[][][] field315;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "604650076"
   )
   int method128(class14 var1, class14 var2) {
      return var1.method70().compareTo(var2.method70());
   }

   public int compare(Object var1, Object var2) {
      return this.method128((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-2"
   )
   static void method132() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3606(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3607()) {
         int var1 = var0.id;
         if(class14.method75(var1)) {
            boolean var2 = true;
            Widget[] var3 = class90.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class261.method4792(var4);
               if(var5 != null) {
                  class219.method4130(var5);
               }
            }
         }
      }

   }
}
