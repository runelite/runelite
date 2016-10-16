import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public class class93 {
   @ObfuscatedName("z")
   static class170 field1607;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method2079() {
      class33.username = class33.username.trim();
      if(class33.username.length() == 0) {
         class79.method1681("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(Sequence.method911("services", false) + "m=accountappeal/login.ws");
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
                  long var40 = var7.method2487();
                  var1 = var40;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var37) {
            var1 = 0L;
         }

         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var38 = class33.username;
            Random var39 = new Random();
            Buffer var25 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var39.nextInt(), var39.nextInt(), (int)(var1 >> 32), (int)var1};
            var25.method2467(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var25.method2642(var39.nextInt());
            }

            var25.method2642(var10[0]);
            var25.method2642(var10[1]);
            var25.method2607(var1);
            var25.method2607(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var25.method2642(var39.nextInt());
            }

            var25.method2525(class9.field139, class9.field140);
            var9.method2467(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.method2642(var39.nextInt());
            }

            var9.method2607(var39.nextLong());
            var9.method2589(var39.nextLong());
            byte[] var26 = new byte[24];

            try {
               class152.field2276.method4142(0L);
               class152.field2276.method4144(var26);

               int var12;
               for(var12 = 0; var12 < 24 && var26[var12] == 0; ++var12) {
                  ;
               }

               if(var12 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var36) {
               for(int var13 = 0; var13 < 24; ++var13) {
                  var26[var13] = -1;
               }
            }

            var9.method2475(var26, 0, 24);
            var9.method2607(var39.nextLong());
            var9.method2525(class9.field139, class9.field140);
            var11 = class113.method2395(var38);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var27 = new Buffer(var11);
            var27.method2472(var38);
            var27.offset = var11;
            var27.method2498(var10);
            Buffer var28 = new Buffer(var27.offset + 5 + var25.offset + var9.offset);
            var28.method2467(2);
            var28.method2467(var25.offset);
            var28.method2475(var25.payload, 0, var25.offset);
            var28.method2467(var9.offset);
            var28.method2475(var9.payload, 0, var9.offset);
            var28.method2468(var27.offset);
            var28.method2475(var27.payload, 0, var27.offset);
            byte[] var15 = var28.payload;
            int var17 = var15.length;
            StringBuilder var18 = new StringBuilder();

            int var21;
            for(int var19 = 0; var19 < 0 + var17; var19 += 3) {
               int var20 = var15[var19] & 255;
               var18.append(class164.field2692[var20 >>> 2]);
               if(var19 < var17 - 1) {
                  var21 = var15[1 + var19] & 255;
                  var18.append(class164.field2692[(var20 & 3) << 4 | var21 >>> 4]);
                  if(var19 < var17 - 2) {
                     int var22 = var15[2 + var19] & 255;
                     var18.append(class164.field2692[(var21 & 15) << 2 | var22 >>> 6]).append(class164.field2692[var22 & 63]);
                  } else {
                     var18.append(class164.field2692[(var21 & 15) << 2]).append("=");
                  }
               } else {
                  var18.append(class164.field2692[(var20 & 3) << 4]).append("==");
               }
            }

            String var16 = var18.toString();
            var16 = var16;

            byte var32;
            try {
               URL var29 = new URL(Sequence.method911("services", false) + "m=accountappeal/login.ws");
               URLConnection var41 = var29.openConnection();
               var41.setDoInput(true);
               var41.setDoOutput(true);
               var41.setConnectTimeout(5000);
               OutputStreamWriter var30 = new OutputStreamWriter(var41.getOutputStream());
               var30.write("data2=" + class154.method3144(var16) + "&dest=" + class154.method3144("passwordchoice.ws"));
               var30.flush();
               InputStream var31 = var41.getInputStream();
               var28 = new Buffer(new byte[1000]);

               while(true) {
                  var21 = var31.read(var28.payload, var28.offset, 1000 - var28.offset);
                  if(var21 == -1) {
                     var30.close();
                     var31.close();
                     String var33 = new String(var28.payload);
                     if(var33.startsWith("OFFLINE")) {
                        var32 = 4;
                     } else if(var33.startsWith("WRONG")) {
                        var32 = 7;
                     } else if(var33.startsWith("RELOAD")) {
                        var32 = 3;
                     } else if(var33.startsWith("Not permitted for social network accounts.")) {
                        var32 = 6;
                     } else {
                        var28.method2499(var10);

                        while(var28.offset > 0 && var28.payload[var28.offset - 1] == 0) {
                           --var28.offset;
                        }

                        var33 = new String(var28.payload, 0, var28.offset);
                        boolean var42;
                        if(var33 == null) {
                           var42 = false;
                        } else {
                           label148: {
                              try {
                                 new URL(var33);
                              } catch (MalformedURLException var34) {
                                 var42 = false;
                                 break label148;
                              }

                              var42 = true;
                           }
                        }

                        if(var42) {
                           class11.method152(var33, true, false);
                           var32 = 2;
                        } else {
                           var32 = 5;
                        }
                     }
                     break;
                  }

                  var28.offset += var21;
                  if(var28.offset >= 1000) {
                     var32 = 5;
                     break;
                  }
               }
            } catch (Throwable var35) {
               var35.printStackTrace();
               var32 = 5;
            }

            var0 = var32;
         }

         switch(var0) {
         case 2:
            class79.method1681("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class33.loginIndex = 6;
            break;
         case 3:
            class79.method1681("", "Error connecting to server.", "");
            break;
         case 4:
            class79.method1681("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class79.method1681("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class79.method1681("", "Error connecting to server.", "");
            break;
         case 7:
            class79.method1681("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
