import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
public final class class10 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1974350789
   )
   static int field91 = 99;
   @ObfuscatedName("s")
   @Export("tileHeights")
   static int[][][] tileHeights = new int[4][105][105];
   @ObfuscatedName("b")
   static int[][] field93;
   @ObfuscatedName("a")
   @Export("overlayIds")
   static byte[][][] overlayIds;
   @ObfuscatedName("k")
   @Export("overlayRotations")
   static byte[][][] overlayRotations;
   @ObfuscatedName("m")
   static int[] field97;
   @ObfuscatedName("y")
   static final int[] field98 = new int[]{-1, -1, 1, 1};
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 73282351
   )
   static int field99 = (int)(Math.random() * 17.0D) - 8;
   @ObfuscatedName("z")
   static final int[] field100 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("e")
   static final int[] field101 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("d")
   static final int[] field102 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("t")
   static final int[] field103 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("q")
   static final int[] field104 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1270921349
   )
   static int field107 = (int)(Math.random() * 33.0D) - 16;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1020438711
   )
   static int field108;
   @ObfuscatedName("md")
   static byte field109;
   @ObfuscatedName("as")
   static boolean field110;
   @ObfuscatedName("c")
   @Export("tileSettings")
   static byte[][][] tileSettings = new byte[4][104][104];

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "81"
   )
   static void method99(Widget var0, int var1, int var2) {
      if(var0.field2214 == 0) {
         var0.relativeX = var0.originalX;
      } else if(var0.field2214 == 1) {
         var0.relativeX = var0.originalX + (var1 - var0.width) / 2;
      } else if(var0.field2214 == 2) {
         var0.relativeX = var1 - var0.width - var0.originalX;
      } else if(var0.field2214 == 3) {
         var0.relativeX = var1 * var0.originalX >> 14;
      } else if(var0.field2214 == 4) {
         var0.relativeX = (var0.originalX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.relativeX = var1 - var0.width - (var1 * var0.originalX >> 14);
      }

      if(var0.field2215 == 0) {
         var0.relativeY = var0.originalY;
      } else if(var0.field2215 == 1) {
         var0.relativeY = (var2 - var0.height) / 2 + var0.originalY;
      } else if(var0.field2215 == 2) {
         var0.relativeY = var2 - var0.height - var0.originalY;
      } else if(var0.field2215 == 3) {
         var0.relativeY = var2 * var0.originalY >> 14;
      } else if(var0.field2215 == 4) {
         var0.relativeY = (var2 * var0.originalY >> 14) + (var2 - var0.height) / 2;
      } else {
         var0.relativeY = var2 - var0.height - (var0.originalY * var2 >> 14);
      }

      if(Client.field461 && var0.type == 0) {
         if(var0.relativeX < 0) {
            var0.relativeX = 0;
         } else if(var0.width + var0.relativeX > var1) {
            var0.relativeX = var1 - var0.width;
         }

         if(var0.relativeY < 0) {
            var0.relativeY = 0;
         } else if(var0.height + var0.relativeY > var2) {
            var0.relativeY = var2 - var0.height;
         }
      }

   }

   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1391509926"
   )
   static final void method102() {
      Client.field336.method2963(144);
      Client.field336.method2708(0);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2135323747"
   )
   static void method120() {
      class41.username = class41.username.trim();
      if(class41.username.length() == 0) {
         class1.method8("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1;
         try {
            URL var3 = new URL(class146.method2660("services", false) + "m=accountappeal/login.ws");
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
                  long var38 = var7.method2728();
                  var1 = var38;
                  break;
               }

               var7.offset += var8;
               if(var7.offset >= 1000) {
                  var1 = 0L;
                  break;
               }
            }
         } catch (Exception var35) {
            var1 = 0L;
         }

         byte var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            String var36 = class41.username;
            Random var37 = new Random();
            Buffer var26 = new Buffer(128);
            Buffer var9 = new Buffer(128);
            int[] var10 = new int[]{var37.nextInt(), var37.nextInt(), (int)(var1 >> 32), (int)var1};
            var26.method2708(10);

            int var11;
            for(var11 = 0; var11 < 4; ++var11) {
               var26.method2711(var37.nextInt());
            }

            var26.method2711(var10[0]);
            var26.method2711(var10[1]);
            var26.method2713(var1);
            var26.method2713(0L);

            for(var11 = 0; var11 < 4; ++var11) {
               var26.method2711(var37.nextInt());
            }

            var26.method2743(class36.field766, class36.field767);
            var9.method2708(10);

            for(var11 = 0; var11 < 3; ++var11) {
               var9.method2711(var37.nextInt());
            }

            var9.method2713(var37.nextLong());
            var9.method2712(var37.nextLong());
            byte[] var27 = new byte[24];

            int var12;
            try {
               class104.field1684.method1348(0L);
               class104.field1684.method1347(var27);

               for(var12 = 0; var12 < 24 && var27[var12] == 0; ++var12) {
                  ;
               }

               if(var12 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var34) {
               for(int var13 = 0; var13 < 24; ++var13) {
                  var27[var13] = -1;
               }
            }

            var9.method2747(var27, 0, 24);
            var9.method2713(var37.nextLong());
            var9.method2743(class36.field766, class36.field767);
            var11 = var36.length() + 1;
            var12 = var11;
            if(var11 % 8 != 0) {
               var12 = var11 + (8 - var11 % 8);
            }

            Buffer var29 = new Buffer(var12);
            var29.method2714(var36);
            var29.offset = var12;
            var29.method2739(var10);
            Buffer var14 = new Buffer(var9.offset + var26.offset + 5 + var29.offset);
            var14.method2708(2);
            var14.method2708(var26.offset);
            var14.method2747(var26.payload, 0, var26.offset);
            var14.method2708(var9.offset);
            var14.method2747(var9.payload, 0, var9.offset);
            var14.method2709(var29.offset);
            var14.method2747(var29.payload, 0, var29.offset);
            byte[] var16 = var14.payload;
            String var15 = class173.method3149(var16, 0, var16.length);
            String var17 = var15;

            byte var30;
            try {
               URL var18 = new URL(class146.method2660("services", false) + "m=accountappeal/login.ws");
               URLConnection var19 = var18.openConnection();
               var19.setDoInput(true);
               var19.setDoOutput(true);
               var19.setConnectTimeout(5000);
               OutputStreamWriter var20 = new OutputStreamWriter(var19.getOutputStream());
               var20.write("data2=" + class118.method2215(var17) + "&dest=" + class118.method2215("passwordchoice.ws"));
               var20.flush();
               InputStream var21 = var19.getInputStream();
               var14 = new Buffer(new byte[1000]);

               while(true) {
                  int var22 = var21.read(var14.payload, var14.offset, 1000 - var14.offset);
                  if(var22 == -1) {
                     var20.close();
                     var21.close();
                     String var31 = new String(var14.payload);
                     if(var31.startsWith("OFFLINE")) {
                        var30 = 4;
                     } else if(var31.startsWith("WRONG")) {
                        var30 = 7;
                     } else if(var31.startsWith("RELOAD")) {
                        var30 = 3;
                     } else if(var31.startsWith("Not permitted for social network accounts.")) {
                        var30 = 6;
                     } else {
                        var14.method2746(var10);

                        while(var14.offset > 0 && var14.payload[var14.offset - 1] == 0) {
                           --var14.offset;
                        }

                        var31 = new String(var14.payload, 0, var14.offset);
                        boolean var23;
                        if(null == var31) {
                           var23 = false;
                        } else {
                           label133: {
                              try {
                                 new URL(var31);
                              } catch (MalformedURLException var32) {
                                 var23 = false;
                                 break label133;
                              }

                              var23 = true;
                           }
                        }

                        if(var23) {
                           class48.method850(var31, true, false);
                           var30 = 2;
                        } else {
                           var30 = 5;
                        }
                     }
                     break;
                  }

                  var14.offset += var22;
                  if(var14.offset >= 1000) {
                     var30 = 5;
                     break;
                  }
               }
            } catch (Throwable var33) {
               var33.printStackTrace();
               var30 = 5;
            }

            var0 = var30;
         }

         switch(var0) {
         case 2:
            class1.method8("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class41.loginIndex = 6;
            break;
         case 3:
            class1.method8("", "Error connecting to server.", "");
            break;
         case 4:
            class1.method8("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class1.method8("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class1.method8("", "Error connecting to server.", "");
            break;
         case 7:
            class1.method8("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1721278188"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(World.worldServersDownload == null) {
            World.worldServersDownload = new class26(class22.field252, new URL(class5.field54));
         } else {
            byte[] var0 = World.worldServersDownload.method569();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field682 = var1.readUnsignedShort();
               World.worldList = new World[World.field682];

               World var3;
               for(int var2 = 0; var2 < World.field682; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.method2727();
                  var3.address = var1.method2911();
                  var3.activity = var1.method2911();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class47.method833(World.worldList, 0, World.worldList.length - 1, World.field680, World.field673);
               World.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         World.worldServersDownload = null;
      }

      return false;
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "-1832889290"
   )
   static final void method130(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      int var6 = var2 * var2 + var3 * var3;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle + Client.mapScale & 2047;
         int var8 = class84.field1444[var7];
         int var9 = class84.field1453[var7];
         var8 = 256 * var8 / (256 + Client.mapScaleDelta);
         var9 = var9 * 256 / (256 + Client.mapScaleDelta);
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var2 * var8 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = (int)(Math.sin(var12) * 63.0D);
         int var15 = (int)(Math.cos(var12) * 57.0D);
         class104.field1694.method3965(4 + 94 + var0 + var14 - 10, var1 + 83 - var15 - 20, 20, 20, 15, 15, var12, 256);
      } else {
         NPC.method706(var0, var1, var2, var3, var4, var5);
      }

   }
}
