import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public class class118 {
   @ObfuscatedName("o")
   public static int[][] field1838 = new int[128][128];
   @ObfuscatedName("r")
   public static int[][] field1840 = new int[128][128];
   @ObfuscatedName("d")
   public static int[] field1842 = new int[4096];
   @ObfuscatedName("n")
   public static int[] field1843 = new int[4096];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1966442621
   )
   public static int field1844;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "65"
   )
   static void method2271() {
      class41.username = class41.username.trim();
      if(class41.username.length() == 0) {
         PlayerComposition.method2762("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class6.method96("services", false) + "m=accountappeal/login.ws");
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
                  long var22 = var7.method2932();
                  var1 = var22;
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
            String var33 = class41.username;
            Random var34 = new Random();
            Buffer var26 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var34.nextInt(), var34.nextInt(), (int)(var1 >> 32), (int)var1};
            var26.method2912(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var26.method3057(var34.nextInt());
            }

            var26.method3057(var10[0]);
            var26.method3057(var10[1]);
            var26.method2917(var1);
            var26.method2917(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var26.method3057(var34.nextInt());
            }

            var26.method3104(class36.field770, class36.field767);
            var9.method2912(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.method3057(var34.nextInt());
            }

            var9.method2917(var34.nextLong());
            var9.method2916(var34.nextLong());
            class49.method901(var9);
            var9.method2917(var34.nextLong());
            var9.method3104(class36.field770, class36.field767);
            var11 = class105.method1999(var33);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var12 = new Buffer(var11);
            var12.method3097(var33);
            var12.offset = var11;
            var12.method3040(var10);
            Buffer var13 = new Buffer(var12.offset + var9.offset + 5 + var26.offset);
            var13.method2912(2);
            var13.method2912(var26.offset);
            var13.method2921(var26.payload, 0, var26.offset);
            var13.method2912(var9.offset);
            var13.method2921(var9.payload, 0, var9.offset);
            var13.method3094(var12.offset);
            var13.method2921(var12.payload, 0, var12.offset);
            String var14 = class15.method196(var13.payload);

            byte var27;
            try {
               URL var15 = new URL(class6.method96("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + XClanMember.method262(var14) + "&dest=" + XClanMember.method262("passwordchoice.ws"));
               var17.flush();
               InputStream var18 = var16.getInputStream();
               var13 = new Buffer(new byte[1000]);

               while(true) {
                  int var19 = var18.read(var13.payload, var13.offset, 1000 - var13.offset);
                  if(var19 == -1) {
                     var17.close();
                     var18.close();
                     String var28 = new String(var13.payload);
                     if(var28.startsWith("OFFLINE")) {
                        var27 = 4;
                     } else if(var28.startsWith("WRONG")) {
                        var27 = 7;
                     } else if(var28.startsWith("RELOAD")) {
                        var27 = 3;
                     } else if(var28.startsWith("Not permitted for social network accounts.")) {
                        var27 = 6;
                     } else {
                        var13.method2944(var10);

                        while(var13.offset > 0 && var13.payload[var13.offset - 1] == 0) {
                           --var13.offset;
                        }

                        var28 = new String(var13.payload, 0, var13.offset);
                        boolean var20;
                        if(null == var28) {
                           var20 = false;
                        } else {
                           label136: {
                              try {
                                 new URL(var28);
                              } catch (MalformedURLException var30) {
                                 var20 = false;
                                 break label136;
                              }

                              var20 = true;
                           }
                        }

                        if(!var20) {
                           var27 = 5;
                        } else {
                           label131: {
                              if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                 try {
                                    Desktop.getDesktop().browse(new URI(var28));
                                    break label131;
                                 } catch (Exception var29) {
                                    ;
                                 }
                              }

                              if(class114.field1785.startsWith("win")) {
                                 class11.method169(var28, 0, "openjs");
                              } else if(class114.field1785.startsWith("mac")) {
                                 class11.method169(var28, 1, "openjs");
                              } else {
                                 class11.method169(var28, 2, "openjs");
                              }
                           }

                           var27 = 2;
                        }
                     }
                     break;
                  }

                  var13.offset += var19;
                  if(var13.offset >= 1000) {
                     var27 = 5;
                     break;
                  }
               }
            } catch (Throwable var31) {
               var31.printStackTrace();
               var27 = 5;
            }

            var0 = var27;
         }

         switch(var0) {
         case 2:
            PlayerComposition.method2762("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class41.loginIndex = 6;
            break;
         case 3:
            PlayerComposition.method2762("", "Error connecting to server.", "");
            break;
         case 4:
            PlayerComposition.method2762("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            PlayerComposition.method2762("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            PlayerComposition.method2762("", "Error connecting to server.", "");
            break;
         case 7:
            PlayerComposition.method2762("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   class118() throws Throwable {
      throw new Error();
   }
}
