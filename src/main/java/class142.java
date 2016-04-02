import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ev")
public class class142 {
   @ObfuscatedName("j")
   static String field2165;
   @ObfuscatedName("kw")
   static class131 field2166;
   @ObfuscatedName("ga")
   static class173 field2170;

   @ObfuscatedName("e")
   public static int method2979(int var0) {
      class47 var2 = (class47)class47.field1049.method3754((long)var0);
      class47 var1;
      if(var2 != null) {
         var1 = var2;
      } else {
         byte[] var3 = class47.field1045.method3280(14, var0);
         var2 = new class47();
         if(null != var3) {
            var2.method976(new class119(var3));
         }

         class47.field1049.method3756(var2, (long)var0);
         var1 = var2;
      }

      int var7 = var1.field1043;
      int var4 = var1.field1044;
      int var5 = var1.field1046;
      int var6 = class176.field2907[var5 - var4];
      return class176.field2903[var7] >> var4 & var6;
   }

   @ObfuscatedName("ck")
   static String method2980(String var0, class173 var1) {
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
               int var6 = class115.method2468(var1, var2 - 1);
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
            if(client.field305 != null) {
               int var8 = client.field305.field2214;
               var4 = (var8 >> 24 & 255) + "." + (var8 >> 16 & 255) + "." + (var8 >> 8 & 255) + "." + (var8 & 255);
               var7 = var4;
               if(client.field305.field2216 != null) {
                  var7 = (String)client.field305.field2216;
               }
            }

            var0 = var0.substring(0, var2) + var7 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }
}
