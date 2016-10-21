import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fc")
public class class156 {
   @ObfuscatedName("f")
   static final class156 field2318 = new class156("LIVE", 0);
   @ObfuscatedName("e")
   static final class156 field2319 = new class156("BUILDLIVE", 3);
   @ObfuscatedName("n")
   static final class156 field2320 = new class156("RC", 1);
   @ObfuscatedName("t")
   static final class156 field2321 = new class156("WIP", 2);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1337065647
   )
   public final int field2323;
   @ObfuscatedName("v")
   public final String field2324;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class156(String var1, int var2) {
      this.field2324 = var1;
      this.field2323 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   static void method3183() {
      class33.username = class33.username.trim();
      if(class33.username.length() == 0) {
         class59.method1273("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class129.method2826("services", false) + "m=accountappeal/login.ws");
            URLConnection var4 = var3.openConnection();
            var4.setRequestProperty("connection", "close");
            var4.setDoInput(true);
            var4.setDoOutput(true);
            var4.setConnectTimeout(5000);
            OutputStreamWriter var5 = new OutputStreamWriter(var4.getOutputStream());
            var5.write("data1=req");
            var5.flush();
            InputStream var6 = var4.getInputStream();
            Buffer var7 = new Buffer(new byte[1000]);

            while(true) {
               int var8 = var6.read(var7.payload, var7.offset, 1000 - var7.offset);
               if(var8 == -1) {
                  var7.offset = 0;
                  long var35 = var7.method2539();
                  var1 = var35;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var32) {
            var1 = 0L;
         }

         byte var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            String var33 = class33.username;
            Random var34 = new Random();
            Buffer var23 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var34.nextInt(), var34.nextInt(), (int)(var1 >> 32), (int)var1};
            var23.method2518(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var23.method2521(var34.nextInt());
            }

            var23.method2521(var10[0]);
            var23.method2521(var10[1]);
            var23.method2523(var1);
            var23.method2523(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var23.method2521(var34.nextInt());
            }

            var23.method2554(class9.field154, class9.field161);
            var9.method2518(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.method2521(var34.nextInt());
            }

            var9.method2523(var34.nextLong());
            var9.method2522(var34.nextLong());
            byte[] var24 = new byte[24];

            try {
               class152.field2275.method4212(0L);
               class152.field2275.method4229(var24);

               int var12;
               for(var12 = 0; var12 < 24 && var24[var12] == 0; ++var12) {
                  ;
               }

               if(var12 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var31) {
               for(int var13 = 0; var13 < 24; ++var13) {
                  var24[var13] = -1;
               }
            }

            var9.method2527(var24, 0, 24);
            var9.method2523(var34.nextLong());
            var9.method2554(class9.field154, class9.field161);
            var11 = class75.method1624(var33);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var25 = new Buffer(var11);
            var25.method2524(var33);
            var25.offset = var11;
            var25.method2550(var10);
            Buffer var26 = new Buffer(var9.offset + var23.offset + 5 + var25.offset);
            var26.method2518(2);
            var26.method2518(var23.offset);
            var26.method2527(var23.payload, 0, var23.offset);
            var26.method2518(var9.offset);
            var26.method2527(var9.payload, 0, var9.offset);
            var26.method2519(var25.offset);
            var26.method2527(var25.payload, 0, var25.offset);
            String var14 = GameObject.method2232(var26.payload);

            byte var27;
            try {
               URL var15 = new URL(class129.method2826("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + class162.method3198(var14) + "&dest=" + class162.method3198("passwordchoice.ws"));
               var17.flush();
               InputStream var18 = var16.getInputStream();
               var26 = new Buffer(new byte[1000]);

               while(true) {
                  int var19 = var18.read(var26.payload, var26.offset, 1000 - var26.offset);
                  if(var19 == -1) {
                     var17.close();
                     var18.close();
                     String var28 = new String(var26.payload);
                     if(var28.startsWith("OFFLINE")) {
                        var27 = 4;
                     } else if(var28.startsWith("WRONG")) {
                        var27 = 7;
                     } else if(var28.startsWith("RELOAD")) {
                        var27 = 3;
                     } else if(var28.startsWith("Not permitted for social network accounts.")) {
                        var27 = 6;
                     } else {
                        var26.method2551(var10);

                        while(var26.offset > 0 && var26.payload[var26.offset - 1] == 0) {
                           --var26.offset;
                        }

                        var28 = new String(var26.payload, 0, var26.offset);
                        boolean var20;
                        if(var28 == null) {
                           var20 = false;
                        } else {
                           label130: {
                              try {
                                 new URL(var28);
                              } catch (MalformedURLException var29) {
                                 var20 = false;
                                 break label130;
                              }

                              var20 = true;
                           }
                        }

                        if(var20) {
                           class110.method2404(var28, true, false);
                           var27 = 2;
                        } else {
                           var27 = 5;
                        }
                     }
                     break;
                  }

                  var26.offset += var19;
                  if(var26.offset >= 1000) {
                     var27 = 5;
                     break;
                  }
               }
            } catch (Throwable var30) {
               var30.printStackTrace();
               var27 = 5;
            }

            var0 = var27;
         }

         switch(var0) {
         case 2:
            class59.method1273("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class33.loginIndex = 6;
            break;
         case 3:
            class59.method1273("", "Error connecting to server.", "");
            break;
         case 4:
            class59.method1273("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class59.method1273("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class59.method1273("", "Error connecting to server.", "");
            break;
         case 7:
            class59.method1273("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
