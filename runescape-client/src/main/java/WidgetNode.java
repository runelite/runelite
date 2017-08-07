import java.applet.Applet;
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
import netscape.javascript.JSObject;

@ObfuscatedName("bb")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   static IndexData field824;
   @ObfuscatedName("fe")
   @ObfuscatedGetter(
      intValue = -1369369105
   )
   static int field826;
   @ObfuscatedName("qn")
   @ObfuscatedGetter(
      intValue = 1632787149
   )
   static int field827;
   @ObfuscatedName("g")
   boolean field822;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1548352807
   )
   @Export("id")
   int id;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 685792203
   )
   @Export("owner")
   int owner;

   WidgetNode() {
      this.field822 = false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "711686235"
   )
   static void method1094() {
      class93.username = class93.username.trim();
      if(class93.username.length() == 0) {
         class19.method154("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class89.method1733("services", false) + "m=accountappeal/login.ws");
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
                  long var20 = var7.readLong();
                  var1 = var20;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var28) {
            var1 = 0L;
         }

         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var29 = class93.username;
            Random var30 = new Random();
            Buffer var24 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var30.nextInt(), var30.nextInt(), (int)(var1 >> 32), (int)var1};
            var24.putByte(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var24.putInt(var30.nextInt());
            }

            var24.putInt(var10[0]);
            var24.putInt(var10[1]);
            var24.putLong(var1);
            var24.putLong(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var24.putInt(var30.nextInt());
            }

            var24.encryptRsa(class88.field1374, class88.field1369);
            var9.putByte(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.putInt(var30.nextInt());
            }

            var9.putLong(var30.nextLong());
            var9.method3164(var30.nextLong());
            MessageNode.method1130(var9);
            var9.putLong(var30.nextLong());
            var9.encryptRsa(class88.field1374, class88.field1369);
            var11 = class45.getLength(var29);
            if(var11 % 8 != 0) {
               var11 += 8 - var11 % 8;
            }

            Buffer var12 = new Buffer(var11);
            var12.putString(var29);
            var12.offset = var11;
            var12.encryptXtea2(var10);
            Buffer var13 = new Buffer(var9.offset + var24.offset + var12.offset + 5);
            var13.putByte(2);
            var13.putByte(var24.offset);
            var13.putBytes(var24.payload, 0, var24.offset);
            var13.putByte(var9.offset);
            var13.putBytes(var9.payload, 0, var9.offset);
            var13.putShort(var12.offset);
            var13.putBytes(var12.payload, 0, var12.offset);
            String var14 = class169.method3149(var13.payload);

            byte var26;
            try {
               URL var15 = new URL(class89.method1733("services", false) + "m=accountappeal/login.ws");
               URLConnection var16 = var15.openConnection();
               var16.setDoInput(true);
               var16.setDoOutput(true);
               var16.setConnectTimeout(5000);
               OutputStreamWriter var17 = new OutputStreamWriter(var16.getOutputStream());
               var17.write("data2=" + class176.method3388(var14) + "&dest=" + class176.method3388("passwordchoice.ws"));
               var17.flush();
               InputStream var18 = var16.getInputStream();
               var13 = new Buffer(new byte[1000]);

               while(true) {
                  int var19 = var18.read(var13.payload, var13.offset, 1000 - var13.offset);
                  if(var19 == -1) {
                     var17.close();
                     var18.close();
                     String var25 = new String(var13.payload);
                     if(var25.startsWith("OFFLINE")) {
                        var26 = 4;
                     } else if(var25.startsWith("WRONG")) {
                        var26 = 7;
                     } else if(var25.startsWith("RELOAD")) {
                        var26 = 3;
                     } else if(var25.startsWith("Not permitted for social network accounts.")) {
                        var26 = 6;
                     } else {
                        var13.decryptXtea(var10);

                        while(var13.offset > 0 && var13.payload[var13.offset - 1] == 0) {
                           --var13.offset;
                        }

                        var25 = new String(var13.payload, 0, var13.offset);
                        if(WorldMapData.method332(var25)) {
                           class9.method46(var25, true, false);
                           var26 = 2;
                        } else {
                           var26 = 5;
                        }
                     }
                     break;
                  }

                  var13.offset += var19;
                  if(var13.offset >= 1000) {
                     var26 = 5;
                     break;
                  }
               }
            } catch (Throwable var27) {
               var27.printStackTrace();
               var26 = 5;
            }

            var0 = var26;
         }

         switch(var0) {
         case 2:
            class19.method154("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class93.loginIndex = 6;
            break;
         case 3:
            class19.method154("", "Error connecting to server.", "");
            break;
         case 4:
            class19.method154("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class19.method154("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class19.method154("", "Error connecting to server.", "");
            break;
         case 7:
            class19.method154("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-1428277469"
   )
   static boolean method1092(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field661.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var14 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var14.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class56.field664;
            Object[] var5 = new Object[]{(new URL(class56.field664.getCodeBase(), var0)).toString()};
            Object var13 = JSObject.getWindow(var7).call(var2, var5);
            return var13 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field664.getAppletContext().showDocument(new URL(class56.field664.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class56.field664;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var12) {
            ;
         }

         try {
            class56.field664.getAppletContext().showDocument(new URL(class56.field664.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1784111364"
   )
   static final void method1093(int var0) {
      if(class10.loadWidget(var0)) {
         Widget[] var1 = Item.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2745 = 0;
               var3.field2746 = 0;
            }
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;IIIIIII)V",
      garbageValue = "1042781174"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class61.tileHeights[0][var2];
                  int var11 = var2 + var4 + 932731;
                  int var12 = var3 + var5 + 556238;
                  int var13 = Ignore.getSmoothNoise(var11 + '넵', var12 + 91923, 4) - 128 + (Ignore.getSmoothNoise(var11 + 10294, var12 + '鎽', 2) - 128 >> 1) + (Ignore.getSmoothNoise(var11, var12, 1) - 128 >> 2);
                  var13 = (int)((double)var13 * 0.3D) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class61.overlayIds[var1][var2][var3] = var0.readByte();
               class92.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class35.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class91.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }
}
