import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public class class229 {
   @ObfuscatedName("l")
   static class170 field3258;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "960721105"
   )
   @Export("loadWorlds")
   static boolean method4209() {
      try {
         if(class27.field672 == null) {
            class27.field672 = new class18(class107.field1869, new URL(class25.field650));
         } else {
            byte[] var0 = class27.field672.method170();
            if(null != var0) {
               class122 var1 = new class122(var0);
               class27.field673 = var1.method2612();
               class118.field2032 = new class27[class27.field673];

               class27 var3;
               for(int var2 = 0; var2 < class27.field673; var3.field684 = var2++) {
                  var3 = class118.field2032[var2] = new class27();
                  var3.field674 = var1.method2612();
                  var3.field676 = var1.method2614();
                  var3.field685 = var1.method2617();
                  var3.field682 = var1.method2617();
                  var3.field683 = var1.method2610();
                  var3.field677 = var1.method2613();
               }

               class78.method1732(class118.field2032, 0, class118.field2032.length - 1, class27.field681, class27.field675);
               class27.field672 = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class27.field672 = null;
      }

      return false;
   }
}
