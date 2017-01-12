import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class175 {
   @ObfuscatedName("cb")
   public static char field2631;

   @ObfuscatedName("cz")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "1915850302"
   )
   static String method3241(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var6 = var0.indexOf("%" + var2);
               if(var6 == -1) {
                  break;
               }

               var0 = var0.substring(0, var6) + class150.method2745(class22.method210(var1, var2 - 1)) + var0.substring(var6 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var3 = "";
            if(null != class72.field1175) {
               int var5 = class72.field1175.field1650;
               String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var3 = var4;
               if(null != class72.field1175.field1652) {
                  var3 = (String)class72.field1175.field1652;
               }
            }

            var0 = var0.substring(0, var2) + var3 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }
}
