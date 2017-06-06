import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
public class class225 {
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -1473473571
   )
   static int field3134;

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "1333009312"
   )
   static String method4075(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         String var4;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var7 = var0.indexOf("%" + var2);
               if(var7 == -1) {
                  break;
               }

               var4 = var0.substring(0, var7);
               int var6 = IndexFile.method3012(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var7 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var3 = "";
            if(Projectile.field1472 != null) {
               int var8 = Projectile.field1472.field2246;
               var4 = (var8 >> 24 & 255) + "." + (var8 >> 16 & 255) + "." + (var8 >> 8 & 255) + "." + (var8 & 255);
               var3 = var4;
               if(Projectile.field1472.field2248 != null) {
                  var3 = (String)Projectile.field1472.field2248;
               }
            }

            var0 = var0.substring(0, var2) + var3 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }
}
