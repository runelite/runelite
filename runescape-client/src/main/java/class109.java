import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public class class109 {
   @ObfuscatedName("u")
   static int[] field1935 = new int[4096];
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -395746163
   )
   static int field1937;
   @ObfuscatedName("e")
   static int[][] field1938 = new int[128][128];
   @ObfuscatedName("r")
   static int[][] field1941 = new int[128][128];
   @ObfuscatedName("n")
   static int[] field1942 = new int[4096];
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1584941351
   )
   static int field1943;
   @ObfuscatedName("dh")
   static byte[][] field1944;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1399125549"
   )
   static void method2475() {
      class33.field764 = class33.field764.trim();
      if(class33.field764.length() == 0) {
         class37.method781("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class141.method3077();
         byte var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            String var4 = class33.field764;
            Random var5 = new Random();
            class122 var6 = new class122(128);
            class122 var7 = new class122(128);
            int[] var8 = new int[]{var5.nextInt(), var5.nextInt(), (int)(var1 >> 32), (int)var1};
            var6.method2783(10);

            int var9;
            for(var9 = 0; var9 < 4; ++var9) {
               var6.method2728(var5.nextInt());
            }

            var6.method2728(var8[0]);
            var6.method2728(var8[1]);
            var6.method2623(var1);
            var6.method2623(0L);

            for(var9 = 0; var9 < 4; ++var9) {
               var6.method2728(var5.nextInt());
            }

            var6.method2781(class9.field157, class9.field163);
            var7.method2783(10);

            for(var9 = 0; var9 < 3; ++var9) {
               var7.method2728(var5.nextInt());
            }

            var7.method2623(var5.nextLong());
            var7.method2622(var5.nextLong());
            byte[] var18 = new byte[24];

            try {
               class152.field2301.method4293(0L);
               class152.field2301.method4297(var18);

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

            var7.method2627(var18, 0, 24);
            var7.method2623(var5.nextLong());
            var7.method2781(class9.field157, class9.field163);
            var9 = class54.method1165(var4);
            if(var9 % 8 != 0) {
               var9 += 8 - var9 % 8;
            }

            class122 var19 = new class122(var9);
            var19.method2703(var4);
            var19.field2050 = var9;
            var19.method2650(var8);
            class122 var20 = new class122(var7.field2050 + 5 + var6.field2050 + var19.field2050);
            var20.method2783(2);
            var20.method2783(var6.field2050);
            var20.method2627(var6.field2051, 0, var6.field2050);
            var20.method2783(var7.field2050);
            var20.method2627(var7.field2051, 0, var7.field2050);
            var20.method2619(var19.field2050);
            var20.method2627(var19.field2051, 0, var19.field2050);
            String var12 = class18.method218(var20.field2051);

            byte var3;
            try {
               URL var13 = new URL(class138.method3023("services", false) + "m=accountappeal/login.ws");
               URLConnection var14 = var13.openConnection();
               var14.setDoInput(true);
               var14.setDoOutput(true);
               var14.setConnectTimeout(5000);
               OutputStreamWriter var15 = new OutputStreamWriter(var14.getOutputStream());
               var15.write("data2=" + class130.method2971(var12) + "&dest=" + class130.method2971("passwordchoice.ws"));
               var15.flush();
               InputStream var16 = var14.getInputStream();
               var20 = new class122(new byte[1000]);

               while(true) {
                  int var17 = var16.read(var20.field2051, var20.field2050, 1000 - var20.field2050);
                  if(var17 == -1) {
                     var15.close();
                     var16.close();
                     String var21 = new String(var20.field2051);
                     if(var21.startsWith("OFFLINE")) {
                        var3 = 4;
                     } else if(var21.startsWith("WRONG")) {
                        var3 = 7;
                     } else if(var21.startsWith("RELOAD")) {
                        var3 = 3;
                     } else if(var21.startsWith("Not permitted for social network accounts.")) {
                        var3 = 6;
                     } else {
                        var20.method2651(var8);

                        while(var20.field2050 > 0 && var20.field2051[var20.field2050 - 1] == 0) {
                           --var20.field2050;
                        }

                        var21 = new String(var20.field2051, 0, var20.field2050);
                        if(class175.method3546(var21)) {
                           class105.method2384(var21, true, false);
                           var3 = 2;
                        } else {
                           var3 = 5;
                        }
                     }
                     break;
                  }

                  var20.field2050 += var17;
                  if(var20.field2050 >= 1000) {
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
            class37.method781("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class33.field761 = 6;
            break;
         case 3:
            class37.method781("", "Error connecting to server.", "");
            break;
         case 4:
            class37.method781("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class37.method781("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class37.method781("", "Error connecting to server.", "");
            break;
         case 7:
            class37.method781("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "108"
   )
   public static void method2483() {
      if(null != class174.field2790) {
         class174.field2790.method3131();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "907128109"
   )
   public static void method2484() {
      class51.field1128.method3910();
      class51.field1129.method3910();
      class51.field1138.method3910();
   }
}
