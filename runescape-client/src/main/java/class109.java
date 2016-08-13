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
      class33.username = class33.username.trim();
      if(class33.username.length() == 0) {
         MessageNode.method781("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var0 = class141.method3077();
         byte var2;
         if(0L == var0) {
            var2 = 5;
         } else {
            String var3 = class33.username;
            Random var4 = new Random();
            Buffer var5 = new Buffer(128);
            Buffer var6 = new Buffer(128);
            int[] var7 = new int[]{var4.nextInt(), var4.nextInt(), (int)(var0 >> 32), (int)var0};
            var5.method2783(10);

            int var8;
            for(var8 = 0; var8 < 4; ++var8) {
               var5.method2728(var4.nextInt());
            }

            var5.method2728(var7[0]);
            var5.method2728(var7[1]);
            var5.method2623(var0);
            var5.method2623(0L);

            for(var8 = 0; var8 < 4; ++var8) {
               var5.method2728(var4.nextInt());
            }

            var5.method2781(class9.field157, class9.field163);
            var6.method2783(10);

            for(var8 = 0; var8 < 3; ++var8) {
               var6.method2728(var4.nextInt());
            }

            var6.method2623(var4.nextLong());
            var6.method2622(var4.nextLong());
            byte[] var9 = new byte[24];

            try {
               class152.field2301.method4293(0L);
               class152.field2301.method4297(var9);

               int var10;
               for(var10 = 0; var10 < 24 && var9[var10] == 0; ++var10) {
                  ;
               }

               if(var10 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var21) {
               for(int var11 = 0; var11 < 24; ++var11) {
                  var9[var11] = -1;
               }
            }

            var6.method2627(var9, 0, 24);
            var6.method2623(var4.nextLong());
            var6.method2781(class9.field157, class9.field163);
            var8 = class54.method1165(var3);
            if(var8 % 8 != 0) {
               var8 += 8 - var8 % 8;
            }

            Buffer var22 = new Buffer(var8);
            var22.method2703(var3);
            var22.offset = var8;
            var22.method2650(var7);
            Buffer var23 = new Buffer(var6.offset + 5 + var5.offset + var22.offset);
            var23.method2783(2);
            var23.method2783(var5.offset);
            var23.method2627(var5.payload, 0, var5.offset);
            var23.method2783(var6.offset);
            var23.method2627(var6.payload, 0, var6.offset);
            var23.method2619(var22.offset);
            var23.method2627(var22.payload, 0, var22.offset);
            String var12 = class18.method218(var23.payload);

            byte var13;
            try {
               URL var14 = new URL(class138.method3023("services", false) + "m=accountappeal/login.ws");
               URLConnection var15 = var14.openConnection();
               var15.setDoInput(true);
               var15.setDoOutput(true);
               var15.setConnectTimeout(5000);
               OutputStreamWriter var16 = new OutputStreamWriter(var15.getOutputStream());
               var16.write("data2=" + class130.method2971(var12) + "&dest=" + class130.method2971("passwordchoice.ws"));
               var16.flush();
               InputStream var17 = var15.getInputStream();
               var23 = new Buffer(new byte[1000]);

               while(true) {
                  int var18 = var17.read(var23.payload, var23.offset, 1000 - var23.offset);
                  if(var18 == -1) {
                     var16.close();
                     var17.close();
                     String var19 = new String(var23.payload);
                     if(var19.startsWith("OFFLINE")) {
                        var13 = 4;
                     } else if(var19.startsWith("WRONG")) {
                        var13 = 7;
                     } else if(var19.startsWith("RELOAD")) {
                        var13 = 3;
                     } else if(var19.startsWith("Not permitted for social network accounts.")) {
                        var13 = 6;
                     } else {
                        var23.method2651(var7);

                        while(var23.offset > 0 && var23.payload[var23.offset - 1] == 0) {
                           --var23.offset;
                        }

                        var19 = new String(var23.payload, 0, var23.offset);
                        if(class175.method3546(var19)) {
                           FrameMap.method2384(var19, true, false);
                           var13 = 2;
                        } else {
                           var13 = 5;
                        }
                     }
                     break;
                  }

                  var23.offset += var18;
                  if(var23.offset >= 1000) {
                     var13 = 5;
                     break;
                  }
               }
            } catch (Throwable var20) {
               var20.printStackTrace();
               var13 = 5;
            }

            var2 = var13;
         }

         switch(var2) {
         case 2:
            MessageNode.method781("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class33.loginIndex = 6;
            break;
         case 3:
            MessageNode.method781("", "Error connecting to server.", "");
            break;
         case 4:
            MessageNode.method781("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            MessageNode.method781("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            MessageNode.method781("", "Error connecting to server.", "");
            break;
         case 7:
            MessageNode.method781("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
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
      class51.field1128.reset();
      class51.spriteCache.reset();
      class51.field1138.reset();
   }
}
