import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class11 {
   @ObfuscatedName("po")
   static short[] field162;
   @ObfuscatedName("k")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();
   @ObfuscatedName("f")
   static final class203 field164 = new class203();
   @ObfuscatedName("ab")
   static ModIcon[] field165;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 976913429
   )
   static int field166 = 0;
   @ObfuscatedName("q")
   static final class201 field167 = new class201(1024);
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = 170087685
   )
   protected static int field169;
   @ObfuscatedName("l")
   static class227 field170;

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(LWidget;I)V",
      garbageValue = "-1630689015"
   )
   static void method127(Widget var0) {
      Widget var1 = var0.parentId == -1?null:class144.method3012(var0.parentId);
      int var2;
      int var3;
      if(null == var1) {
         var2 = GroundObject.field1652;
         var3 = VertexNormal.field1689;
      } else {
         var2 = var1.width;
         var3 = var1.height;
      }

      class13.method149(var0, var2, var3, false);
      class116.method2496(var0, var2, var3);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "123915888"
   )
   static void method134() {
      class33.username = class33.username.trim();
      if(class33.username.length() == 0) {
         class51.method1075("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class10.method118("services", false) + "m=accountappeal/login.ws");
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
                  long var30 = var7.method2704();
                  var1 = var30;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var27) {
            var1 = 0L;
         }

         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var28 = class33.username;
            Random var29 = new Random();
            Buffer var22 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var29.nextInt(), var29.nextInt(), (int)(var1 >> 32), (int)var1};
            var22.method2556(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var22.method2559(var29.nextInt());
            }

            var22.method2559(var10[0]);
            var22.method2559(var10[1]);
            var22.method2667(var1);
            var22.method2667(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var22.method2559(var29.nextInt());
            }

            var22.method2592(class9.field146, class9.field147);
            var9.method2556(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.method2559(var29.nextInt());
            }

            var9.method2667(var29.nextLong());
            var9.method2634(var29.nextLong());
            class114.method2489(var9);
            var9.method2667(var29.nextLong());
            var9.method2592(class9.field146, class9.field147);
            var11 = class31.method685(var28);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var12 = new Buffer(var11);
            var12.method2562(var28);
            var12.offset = var11;
            var12.method2588(var10);
            Buffer var13 = new Buffer(5 + var22.offset + var9.offset + var12.offset);
            var13.method2556(2);
            var13.method2556(var22.offset);
            var13.method2565(var22.payload, 0, var22.offset);
            var13.method2556(var9.offset);
            var13.method2565(var9.payload, 0, var9.offset);
            var13.method2638(var12.offset);
            var13.method2565(var12.payload, 0, var12.offset);
            String var14 = class140.method2960(var13.payload);

            byte var23;
            try {
               URL var15 = new URL(class10.method118("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + class50.method1030(var14) + "&dest=" + class50.method1030("passwordchoice.ws"));
               var17.flush();
               InputStream var18 = var16.getInputStream();
               var13 = new Buffer(new byte[1000]);

               while(true) {
                  int var19 = var18.read(var13.payload, var13.offset, 1000 - var13.offset);
                  if(var19 == -1) {
                     var17.close();
                     var18.close();
                     String var24 = new String(var13.payload);
                     if(var24.startsWith("OFFLINE")) {
                        var23 = 4;
                     } else if(var24.startsWith("WRONG")) {
                        var23 = 7;
                     } else if(var24.startsWith("RELOAD")) {
                        var23 = 3;
                     } else if(var24.startsWith("Not permitted for social network accounts.")) {
                        var23 = 6;
                     } else {
                        var13.method2589(var10);

                        while(var13.offset > 0 && var13.payload[var13.offset - 1] == 0) {
                           --var13.offset;
                        }

                        var24 = new String(var13.payload, 0, var13.offset);
                        if(!BufferProvider.method1734(var24)) {
                           var23 = 5;
                        } else {
                           label125: {
                              if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                                 try {
                                    Desktop.getDesktop().browse(new URI(var24));
                                    break label125;
                                 } catch (Exception var25) {
                                    ;
                                 }
                              }

                              if(class141.field2182.startsWith("win")) {
                                 class154.method3163(var24, 0, "openjs");
                              } else if(class141.field2182.startsWith("mac")) {
                                 class154.method3163(var24, 1, "openjs");
                              } else {
                                 class154.method3163(var24, 2, "openjs");
                              }
                           }

                           var23 = 2;
                        }
                     }
                     break;
                  }

                  var13.offset += var19;
                  if(var13.offset >= 1000) {
                     var23 = 5;
                     break;
                  }
               }
            } catch (Throwable var26) {
               var26.printStackTrace();
               var23 = 5;
            }

            var0 = var23;
         }

         switch(var0) {
         case 2:
            class51.method1075("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class33.loginIndex = 6;
            break;
         case 3:
            class51.method1075("", "Error connecting to server.", "");
            break;
         case 4:
            class51.method1075("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class51.method1075("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class51.method1075("", "Error connecting to server.", "");
            break;
         case 7:
            class51.method1075("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/io/File;",
      garbageValue = "-111"
   )
   static File method135(String var0) {
      if(!class138.field2141) {
         throw new RuntimeException("");
      } else {
         File var1 = (File)class138.field2140.get(var0);
         if(null != var1) {
            return var1;
         } else {
            File var2 = new File(class222.field3217, var0);
            RandomAccessFile var3 = null;

            try {
               File var4 = new File(var2.getParent());
               if(!var4.exists()) {
                  throw new RuntimeException("");
               } else {
                  var3 = new RandomAccessFile(var2, "rw");
                  int var5 = var3.read();
                  var3.seek(0L);
                  var3.write(var5);
                  var3.seek(0L);
                  var3.close();
                  class138.field2140.put(var0, var2);
                  return var2;
               }
            } catch (Exception var8) {
               try {
                  if(var3 != null) {
                     var3.close();
                     var3 = null;
                  }
               } catch (Exception var7) {
                  ;
               }

               throw new RuntimeException();
            }
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "719491772"
   )
   public static int method138(int var0, int var1) {
      int var2;
      for(var2 = 1; var1 > 1; var1 >>= 1) {
         if((var1 & 1) != 0) {
            var2 *= var0;
         }

         var0 *= var0;
      }

      if(var1 == 1) {
         return var2 * var0;
      } else {
         return var2;
      }
   }
}
