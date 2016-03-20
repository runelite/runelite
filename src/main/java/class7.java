import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("m")
@Implements("Ignore")
public class class7 {
   @ObfuscatedName("r")
   @Export("previousName")
   String field125;
   @ObfuscatedName("lr")
   static class129 field126;
   @ObfuscatedName("bv")
   static class167 field127;
   @ObfuscatedName("a")
   @Export("name")
   String field129;

   @ObfuscatedName("cr")
   static String method115(String var0, class172 var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         String var4;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var4 = var0.substring(0, var3);
               int var6 = class89.method2100(var1, var2 - 1);
               String var5;
               if(var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(2 + var3);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(-1 == var2) {
               break;
            }

            String var7 = "";
            if(null != class72.field1356) {
               int var8 = class72.field1356.field2203;
               var4 = (var8 >> 24 & 255) + "." + (var8 >> 16 & 255) + "." + (var8 >> 8 & 255) + "." + (var8 & 255);
               var7 = var4;
               if(class72.field1356.field2206 != null) {
                  var7 = (String)class72.field1356.field2206;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("a")
   public static void method116(class166 var0, class166 var1) {
      class39.field908 = var0;
      class39.field906 = var1;
   }
}
