import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ar")
public class class41 {
   @ObfuscatedName("t")
   static ModIcon field816;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1468818985
   )
   static int field817 = 0;
   @ObfuscatedName("i")
   static ModIcon field818;
   @ObfuscatedName("b")
   static boolean field819;
   @ObfuscatedName("h")
   static SpritePixels field820;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 840713621
   )
   static int field821;
   @ObfuscatedName("r")
   static ModIcon field822;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1840310125
   )
   static int field823;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1826302879
   )
   static int field824;
   @ObfuscatedName("m")
   static int[] field825;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -826284515
   )
   static int field826;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1378342593
   )
   static int field827;
   @ObfuscatedName("ap")
   static int[] field828;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1760580423
   )
   static int field829;
   @ObfuscatedName("am")
   static String field830;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -652221381
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("ai")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ae")
   static String field834;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1227917421
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("x")
   static ModIcon field837;
   @ObfuscatedName("ay")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("at")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("as")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("aa")
   static String field841;
   @ObfuscatedName("ar")
   static class97 field842;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -92753569
   )
   static int field843;
   @ObfuscatedName("al")
   static boolean field844;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1094191981
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("n")
   static SpritePixels field846;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1833555103
   )
   static int field847;
   @ObfuscatedName("az")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1236314163
   )
   static int field849;
   @ObfuscatedName("pm")
   static class116 field852;

   static {
      loginWindowX = 202 + field817;
      field825 = new int[256];
      field826 = 0;
      field827 = 0;
      field821 = 0;
      field847 = 0;
      field823 = 0;
      field824 = 0;
      field829 = 10;
      field834 = "";
      loginIndex = 0;
      field830 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field841 = "";
      field842 = class97.field1624;
      field844 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field849 = -1;
   }

   @ObfuscatedName("ce")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2139941913"
   )
   static final boolean method833() {
      return Client.menuOptionCount <= 0?false:Client.field433 && class105.field1700[81] && Client.field432 != -1;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "183196499"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3061.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class40.method818(Sequence.field3065, Sequence.field3059, var0, false);
         if(null != var1) {
            Sequence.field3061.put(var1, (long)var0);
         }

         return var1;
      }
   }

   class41() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "881029577"
   )
   static int method851(int var0) {
      MessageNode var1 = (MessageNode)class47.field924.method2386((long)var0);
      return null == var1?-1:(class47.field923.field1896 == var1.previous?-1:((MessageNode)var1.previous).id);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "571033675"
   )
   public static boolean method852(char var0) {
      return var0 >= 48 && var0 <= 57 || var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "841165343"
   )
   public static ModIcon method854(class182 var0, String var1, String var2) {
      int var3 = var0.method3363(var1);
      int var4 = var0.method3407(var3, var2);
      ModIcon var5;
      if(!class185.method3467(var0, var3, var4)) {
         var5 = null;
      } else {
         ModIcon var7 = new ModIcon();
         var7.width = class225.field3228;
         var7.originalHeight = class225.field3227;
         var7.offsetX = class225.field3229[0];
         var7.offsetY = class155.field2105[0];
         var7.originalWidth = class172.field2351[0];
         var7.height = class225.field3230[0];
         var7.palette = class225.field3231;
         var7.pixels = class225.field3232[0];
         class0.method13();
         var5 = var7;
      }

      return var5;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1366216247"
   )
   static void method855() {
      username = username.trim();
      if(username.length() == 0) {
         class108.method2095("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class101.method2008("services", false) + "m=accountappeal/login.ws");
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
                  long var22 = var7.method2947();
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
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var33 = username;
            Random var34 = new Random();
            Buffer var26 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var34.nextInt(), var34.nextInt(), (int)(var1 >> 32), (int)var1};
            var26.method3010(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var26.method2844(var34.nextInt());
            }

            var26.method2844(var10[0]);
            var26.method2844(var10[1]);
            var26.method2845(var1);
            var26.method2845(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var26.method2844(var34.nextInt());
            }

            var26.method2877(class36.field763, class36.field764);
            var9.method3010(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.method2844(var34.nextInt());
            }

            var9.method2845(var34.nextLong());
            var9.method3063(var34.nextLong());
            class33.method764(var9);
            var9.method2845(var34.nextLong());
            var9.method2877(class36.field763, class36.field764);
            var11 = class25.method615(var33);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var12 = new Buffer(var11);
            var12.method2893(var33);
            var12.offset = var11;
            var12.method2873(var10);
            Buffer var13 = new Buffer(var12.offset + var9.offset + var26.offset + 5);
            var13.method3010(2);
            var13.method3010(var26.offset);
            var13.method2850(var26.payload, 0, var26.offset);
            var13.method3010(var9.offset);
            var13.method2850(var9.payload, 0, var9.offset);
            var13.method2842(var12.offset);
            var13.method2850(var12.payload, 0, var12.offset);
            String var14 = class139.method2678(var13.payload);

            byte var27;
            try {
               URL var15 = new URL(class101.method2008("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + class3.method36(var14) + "&dest=" + class3.method36("passwordchoice.ws"));
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
                        var13.method2874(var10);

                        while(var13.offset > 0 && var13.payload[var13.offset - 1] == 0) {
                           --var13.offset;
                        }

                        var28 = new String(var13.payload, 0, var13.offset);
                        boolean var20;
                        if(null == var28) {
                           var20 = false;
                        } else {
                           label141: {
                              try {
                                 new URL(var28);
                              } catch (MalformedURLException var30) {
                                 var20 = false;
                                 break label141;
                              }

                              var20 = true;
                           }
                        }

                        if(!var20) {
                           var27 = 5;
                        } else {
                           label136: {
                              if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                 try {
                                    Desktop.getDesktop().browse(new URI(var28));
                                    break label136;
                                 } catch (Exception var29) {
                                    ;
                                 }
                              }

                              if(class114.field1787.startsWith("win")) {
                                 class5.method84(var28, 0);
                              } else if(class114.field1787.startsWith("mac")) {
                                 ChatMessages.method934(var28, 1, "openjs");
                              } else {
                                 class5.method84(var28, 2);
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
            class108.method2095("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            loginIndex = 6;
            break;
         case 3:
            class108.method2095("", "Error connecting to server.", "");
            break;
         case 4:
            class108.method2095("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class108.method2095("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class108.method2095("", "Error connecting to server.", "");
            break;
         case 7:
            class108.method2095("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
