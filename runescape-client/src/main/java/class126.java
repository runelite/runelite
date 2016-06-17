import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class126 {
   @ObfuscatedName("dw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZS)V",
      garbageValue = "0"
   )
   static final void method2844(String var0, boolean var1) {
      if(var0 != null) {
         if((client.field513 < 100 || client.field412 == 1) && client.field513 < 400) {
            String var2 = class39.method796(var0, client.field289);
            if(var2 != null) {
               int var3;
               String var5;
               String var6;
               for(var3 = 0; var3 < client.field513; ++var3) {
                  class7 var4 = client.field559[var3];
                  var5 = class39.method796(var4.field124, client.field289);
                  if(null != var5 && var5.equals(var2)) {
                     class45.method955(31, "", var0 + " is already on your ignore list");
                     return;
                  }

                  if(null != var4.field122) {
                     var6 = class39.method796(var4.field122, client.field289);
                     if(null != var6 && var6.equals(var2)) {
                        class45.method955(31, "", var0 + " is already on your ignore list");
                        return;
                     }
                  }
               }

               for(var3 = 0; var3 < client.field340; ++var3) {
                  class17 var7 = client.field556[var3];
                  var5 = class39.method796(var7.field243, client.field289);
                  if(var5 != null && var5.equals(var2)) {
                     class45.method955(31, "", "Please remove " + var0 + " from your friend list first");
                     return;
                  }

                  if(var7.field246 != null) {
                     var6 = class39.method796(var7.field246, client.field289);
                     if(var6 != null && var6.equals(var2)) {
                        class45.method955(31, "", "Please remove " + var0 + " from your friend list first");
                        return;
                     }
                  }
               }

               if(class39.method796(class153.field2262.field26, client.field289).equals(var2)) {
                  class45.method955(31, "", "You can\'t add yourself to your own ignore list");
               } else {
                  client.field331.method2781(168);
                  client.field331.method2650(class4.method41(var0));
                  client.field331.method2505(var0);
               }
            }
         } else {
            class45.method955(31, "", "Your ignore list is full. Max of 100 for free users, and 400 for members");
         }
      }
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(IIIILclass78;Lclass175;I)V",
      garbageValue = "-884870166"
   )
   static final void method2848(int var0, int var1, int var2, int var3, class78 var4, class175 var5) {
      if(var4 != null) {
         int var6 = client.field360 + client.field322 & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class91.field1563[var6];
            int var9 = class91.field1564[var6];
            var8 = var8 * 256 / (256 + client.field558);
            var9 = 256 * var9 / (client.field558 + 256);
            int var10 = var3 * var8 + var2 * var9 >> 16;
            int var11 = var9 * var3 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method1724(var5.field2888 / 2 + var10 - var4.field1370 / 2, var5.field2889 / 2 - var11 - var4.field1372 / 2, var0, var1, var5.field2888, var5.field2889, var5.field2891, var5.field2892);
            } else {
               var4.method1767(var10 + var0 + var5.field2888 / 2 - var4.field1370 / 2, var1 + var5.field2889 / 2 - var11 - var4.field1372 / 2);
            }

         }
      }
   }
}
