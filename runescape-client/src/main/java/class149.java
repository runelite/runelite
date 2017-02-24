import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public class class149 {
   @ObfuscatedName("du")
   @ObfuscatedGetter(
      intValue = -1988940067
   )
   static int field2035;
   @ObfuscatedName("ch")
   static class110 field2036;

   class149() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "-1992895132"
   )
   static String method2800(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + Item.method880(class159.method3096(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var4 = "";
            if(null != ChatMessages.field934) {
               var4 = class137.method2528(ChatMessages.field934.field1667);
               if(ChatMessages.field934.field1672 != null) {
                  var4 = (String)ChatMessages.field934.field1672;
               }
            }

            var0 = var0.substring(0, var2) + var4 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1802939812"
   )
   static final boolean method2801(int var0) {
      if(var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuTypes[var0];
         if(var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }
}
