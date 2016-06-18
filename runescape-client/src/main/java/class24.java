import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("i")
@Implements("XClanMember")
public class class24 extends class208 {
   @ObfuscatedName("b")
   @Export("username")
   String field617;
   @ObfuscatedName("g")
   String field618;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -139955179
   )
   @Export("world")
   int field619;
   @ObfuscatedName("z")
   public static class228[] field621;
   @ObfuscatedName("d")
   @Export("rank")
   byte field622;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZS)Z",
      garbageValue = "-11813"
   )
   static boolean method591(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  return false;
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var1 * var5 + var10;
            if(var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IS)Lclass22;",
      garbageValue = "16755"
   )
   static class22 method592(int var0) {
      class22 var1 = (class22)class22.field594.method3764((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class172.field2735.method3266(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new class22();
            class119 var3 = new class119(var2);
            var3.field1976 = var3.field1982.length - 12;
            int var4 = var3.method2519();
            var1.field592 = var3.method2516();
            var1.field593 = var3.method2516();
            var1.field588 = var3.method2516();
            var1.field595 = var3.method2516();
            var3.field1976 = 0;
            var3.method2521();
            var1.field597 = new int[var4];
            var1.field590 = new int[var4];
            var1.field591 = new String[var4];

            int var6;
            for(int var5 = 0; var3.field1976 < var3.field1982.length - 12; var1.field597[var5++] = var6) {
               var6 = var3.method2516();
               if(var6 == 3) {
                  var1.field591[var5] = var3.method2522();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field590[var5] = var3.method2519();
               } else {
                  var1.field590[var5] = var3.method2514();
               }
            }

            class22.field594.method3759(var1, (long)var0);
            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-109"
   )
   static void method593() {
      class31.field726 = class31.field726.trim();
      if(class31.field726.length() == 0) {
         class12.method152("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class174.method3451("services", false) + "m=accountappeal/login.ws");
            URLConnection var4 = var3.openConnection();
            var4.setRequestProperty("connection", "close");
            var4.setDoInput(true);
            var4.setDoOutput(true);
            var4.setConnectTimeout(5000);
            OutputStreamWriter var5 = new OutputStreamWriter(var4.getOutputStream());
            var5.write("data1=req");
            var5.flush();
            InputStream var6 = var4.getInputStream();
            class119 var7 = new class119(new byte[1000]);

            while(true) {
               int var8 = var6.read(var7.field1982, var7.field1976, 1000 - var7.field1976);
               if(var8 == -1) {
                  var7.field1976 = 0;
                  long var28 = var7.method2699();
                  var1 = var28;
                  break;
               }

               var7.field1976 += var8;
               if(var7.field1976 >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var25) {
            var1 = 0L;
         }

         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var26 = class31.field726;
            Random var27 = new Random();
            class119 var21 = new class119(128);
            class119 var9 = new class119(128);
            int[] var10 = new int[]{var27.nextInt(), var27.nextInt(), (int)(var1 >> 32), (int)var1};
            var21.method2650(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var21.method2502(var27.nextInt());
            }

            var21.method2502(var10[0]);
            var21.method2502(var10[1]);
            var21.method2647(var1);
            var21.method2647(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var21.method2502(var27.nextInt());
            }

            var21.method2677(class9.field146, class9.field147);
            var9.method2650(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.method2502(var27.nextInt());
            }

            var9.method2647(var27.nextLong());
            var9.method2666(var27.nextLong());
            class173.method3449(var9);
            var9.method2647(var27.nextLong());
            var9.method2677(class9.field146, class9.field147);
            var11 = class4.method41(var26);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            class119 var12 = new class119(var11);
            var12.method2505(var26);
            var12.field1976 = var11;
            var12.method2530(var10);
            class119 var13 = new class119(var9.field1976 + var21.field1976 + 5 + var12.field1976);
            var13.method2650(2);
            var13.method2650(var21.field1976);
            var13.method2508(var21.field1982, 0, var21.field1976);
            var13.method2650(var9.field1976);
            var13.method2508(var9.field1982, 0, var9.field1976);
            var13.method2695(var12.field1976);
            var13.method2508(var12.field1982, 0, var12.field1976);
            String var14 = class108.method2414(var13.field1982);

            byte var22;
            try {
               URL var15 = new URL(class174.method3451("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + class150.method3151(var14) + "&dest=" + class150.method3151("passwordchoice.ws"));
               var17.flush();
               InputStream var18 = var16.getInputStream();
               var13 = new class119(new byte[1000]);

               while(true) {
                  int var19 = var18.read(var13.field1982, var13.field1976, 1000 - var13.field1976);
                  if(var19 == -1) {
                     var17.close();
                     var18.close();
                     String var23 = new String(var13.field1982);
                     if(var23.startsWith("OFFLINE")) {
                        var22 = 4;
                     } else if(var23.startsWith("WRONG")) {
                        var22 = 7;
                     } else if(var23.startsWith("RELOAD")) {
                        var22 = 3;
                     } else if(var23.startsWith("Not permitted for social network accounts.")) {
                        var22 = 6;
                     } else {
                        var13.method2531(var10);

                        while(var13.field1976 > 0 && var13.field1982[var13.field1976 - 1] == 0) {
                           --var13.field1976;
                        }

                        var23 = new String(var13.field1982, 0, var13.field1976);
                        if(class74.method1619(var23)) {
                           class8.method111(var23, true, "openjs", false);
                           var22 = 2;
                        } else {
                           var22 = 5;
                        }
                     }
                     break;
                  }

                  var13.field1976 += var19;
                  if(var13.field1976 >= 1000) {
                     var22 = 5;
                     break;
                  }
               }
            } catch (Throwable var24) {
               var24.printStackTrace();
               var22 = 5;
            }

            var0 = var22;
         }

         switch(var0) {
         case 2:
            class12.method152("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class31.field715 = 6;
            break;
         case 3:
            class12.method152("", "Error connecting to server.", "");
            break;
         case 4:
            class12.method152("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class12.method152("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class12.method152("", "Error connecting to server.", "");
            break;
         case 7:
            class12.method152("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
