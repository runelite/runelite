import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dc")
public class class127 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-625943528"
   )
   static void method2840() {
      class31.field729 = class31.field729.trim();
      if(class31.field729.length() == 0) {
         class111.method2477("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class189.method3780();
         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var4 = class31.field729;
            Random var5 = new Random();
            class119 var6 = new class119(128);
            class119 var7 = new class119(128);
            int[] var8 = new int[]{var5.nextInt(), var5.nextInt(), (int)(var1 >> 32), (int)var1};
            var6.method2654(10);

            int var9;
            for(var9 = 0; var9 < 4; ++var9) {
               var6.method2539(var5.nextInt());
            }

            var6.method2539(var8[0]);
            var6.method2539(var8[1]);
            var6.method2626(var1);
            var6.method2626(0L);

            for(var9 = 0; var9 < 4; ++var9) {
               var6.method2539(var5.nextInt());
            }

            var6.method2574(class9.field155, class9.field160);
            var7.method2654(10);

            for(var9 = 0; var9 < 3; ++var9) {
               var7.method2539(var5.nextInt());
            }

            var7.method2626(var5.nextLong());
            var7.method2564(var5.nextLong());
            byte[] var18 = new byte[24];

            try {
               class149.field2241.method4167(0L);
               class149.field2241.method4169(var18);

               int var10;
               for(var10 = 0; var10 < 24 && var18[var10] == 0; ++var10) {
                  ;
               }

               if(var10 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var23) {
               for(int var11 = 0; var11 < 24; ++var11) {
                  var18[var11] = -1;
               }
            }

            var7.method2591(var18, 0, 24);
            var7.method2626(var5.nextLong());
            var7.method2574(class9.field155, class9.field160);
            var9 = class23.method629(var4);
            if(var9 % 8 != 0) {
               var9 += 8 - var9 % 8;
            }

            class119 var19 = new class119(var9);
            var19.method2545(var4);
            var19.field1998 = var9;
            var19.method2570(var8);
            class119 var20 = new class119(var19.field1998 + var6.field1998 + 5 + var7.field1998);
            var20.method2654(2);
            var20.method2654(var6.field1998);
            var20.method2591(var6.field2000, 0, var6.field1998);
            var20.method2654(var7.field1998);
            var20.method2591(var7.field2000, 0, var7.field1998);
            var20.method2540(var19.field1998);
            var20.method2591(var19.field2000, 0, var19.field1998);
            String var12 = class82.method1948(var20.field2000);

            byte var3;
            try {
               URL var13 = new URL(class84.method1963("services", false) + "m=accountappeal/login.ws");
               URLConnection var14 = var13.openConnection();
               var14.setDoInput(true);
               var14.setDoOutput(true);
               var14.setConnectTimeout(5000);
               OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
               var15.write("data2=" + class126.method2839(var12) + "&dest=" + class126.method2839("passwordchoice.ws"));
               var15.flush();
               InputStream var16 = var14.getInputStream();
               var20 = new class119(new byte[1000]);

               while(true) {
                  int var17 = var16.read(var20.field2000, var20.field1998, 1000 - var20.field1998);
                  if(var17 == -1) {
                     var15.close();
                     var16.close();
                     String var21 = new String(var20.field2000);
                     if(var21.startsWith("OFFLINE")) {
                        var3 = 4;
                     } else if(var21.startsWith("WRONG")) {
                        var3 = 7;
                     } else if(var21.startsWith("RELOAD")) {
                        var3 = 3;
                     } else if(var21.startsWith("Not permitted for social network accounts.")) {
                        var3 = 6;
                     } else {
                        var20.method2601(var8);

                        while(var20.field1998 > 0 && var20.field2000[var20.field1998 - 1] == 0) {
                           --var20.field1998;
                        }

                        var21 = new String(var20.field2000, 0, var20.field1998);
                        if(class26.method673(var21)) {
                           class29.method707(var21, true, false);
                           var3 = 2;
                        } else {
                           var3 = 5;
                        }
                     }
                     break;
                  }

                  var20.field1998 += var17;
                  if(var20.field1998 >= 1000) {
                     var3 = 5;
                     break;
                  }
               }
            } catch (Throwable var22) {
               var22.printStackTrace();
               var3 = 5;
            }

            var0 = var3;
         }

         switch(var0) {
         case 2:
            class111.method2477("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class31.field724 = 6;
            break;
         case 3:
            class111.method2477("", "Error connecting to server.", "");
            break;
         case 4:
            class111.method2477("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class111.method2477("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class111.method2477("", "Error connecting to server.", "");
            break;
         case 7:
            class111.method2477("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1346752961"
   )
   public static boolean method2842(int var0) {
      return (var0 & 1) != 0;
   }
}
