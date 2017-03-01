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
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("n")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = 1279476305
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("dd")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("av")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("x")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);
   @ObfuscatedName("g")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;B)[LModIcon;",
      garbageValue = "36"
   )
   public static ModIcon[] method169(class182 var0, String var1, String var2) {
      int var3 = var0.method3426(var1);
      int var4 = var0.method3370(var3, var2);
      ModIcon[] var5;
      if(!class137.method2556(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class168.method3278();
      }

      return var5;
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "14931479"
   )
   static final void method172() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[1 + var1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[1 + var1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[1 + var1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[1 + var1];
               Client.menuActionParams1[1 + var1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[1 + var1];
               Client.menuIdentifiers[var1 + 1] = var4;
               if(Client.field436 != -1) {
                  if(var1 == Client.field436) {
                     Client.field436 = var1 + 1;
                  } else if(var1 + 1 == Client.field436) {
                     Client.field436 = var1;
                  }
               }

               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "-1957681179"
   )
   static final int method180(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2873(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2874(var3.nextInt());
      }

      var4.method2874(var6[0]);
      var4.method2874(var6[1]);
      var4.method3085(var0);
      var4.method3085(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2874(var3.nextInt());
      }

      var4.method2907(class36.field770, class36.field771);
      var5.method2873(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2874(var3.nextInt());
      }

      var5.method3085(var3.nextLong());
      var5.method2875(var3.nextLong());
      RSCanvas.method2171(var5);
      var5.method3085(var3.nextLong());
      var5.method2907(class36.field770, class36.field771);
      var7 = class165.method3233(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var8 = new Buffer(var7);
      var8.method2915(var2);
      var8.offset = var7;
      var8.method2903(var6);
      Buffer var9 = new Buffer(var8.offset + 5 + var4.offset + var5.offset);
      var9.method2873(2);
      var9.method2873(var4.offset);
      var9.method2880(var4.payload, 0, var4.offset);
      var9.method2873(var5.offset);
      var9.method2880(var5.payload, 0, var5.offset);
      var9.method2872(var8.offset);
      var9.method2880(var8.payload, 0, var8.offset);
      byte[] var11 = var9.payload;
      int var13 = var11.length;
      StringBuilder var14 = new StringBuilder();

      int var17;
      for(int var15 = 0; var15 < var13 + 0; var15 += 3) {
         int var16 = var11[var15] & 255;
         var14.append(class206.field3097[var16 >>> 2]);
         if(var15 < var13 - 1) {
            var17 = var11[var15 + 1] & 255;
            var14.append(class206.field3097[(var16 & 3) << 4 | var17 >>> 4]);
            if(var15 < var13 - 2) {
               int var18 = var11[2 + var15] & 255;
               var14.append(class206.field3097[(var17 & 15) << 2 | var18 >>> 6]).append(class206.field3097[var18 & 63]);
            } else {
               var14.append(class206.field3097[(var17 & 15) << 2]).append("=");
            }
         } else {
            var14.append(class206.field3097[(var16 & 3) << 4]).append("==");
         }
      }

      String var12 = var14.toString();
      var12 = var12;

      try {
         URL var20 = new URL(class0.method11("services", false) + "m=accountappeal/login.ws");
         URLConnection var27 = var20.openConnection();
         var27.setDoInput(true);
         var27.setDoOutput(true);
         var27.setConnectTimeout(5000);
         OutputStreamWriter var21 = new OutputStreamWriter(var27.getOutputStream());
         var21.write("data2=" + class188.method3522(var12) + "&dest=" + class188.method3522("passwordchoice.ws"));
         var21.flush();
         InputStream var22 = var27.getInputStream();
         var9 = new Buffer(new byte[1000]);

         do {
            var17 = var22.read(var9.payload, var9.offset, 1000 - var9.offset);
            if(var17 == -1) {
               var21.close();
               var22.close();
               String var23 = new String(var9.payload);
               if(var23.startsWith("OFFLINE")) {
                  return 4;
               } else if(var23.startsWith("WRONG")) {
                  return 7;
               } else if(var23.startsWith("RELOAD")) {
                  return 3;
               } else if(var23.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var9.method3046(var6);

                  while(var9.offset > 0 && var9.payload[var9.offset - 1] == 0) {
                     --var9.offset;
                  }

                  var23 = new String(var9.payload, 0, var9.offset);
                  boolean var28;
                  if(null == var23) {
                     var28 = false;
                  } else {
                     label122: {
                        try {
                           new URL(var23);
                        } catch (MalformedURLException var25) {
                           var28 = false;
                           break label122;
                        }

                        var28 = true;
                     }
                  }

                  if(!var28) {
                     return 5;
                  } else {
                     if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
                        try {
                           Desktop.getDesktop().browse(new URI(var23));
                           return 2;
                        } catch (Exception var24) {
                           ;
                        }
                     }

                     if(class114.field1786.startsWith("win")) {
                        class49.method976(var23, 0, "openjs");
                     } else if(class114.field1786.startsWith("mac")) {
                        class49.method976(var23, 1, "openjs");
                     } else {
                        class49.method976(var23, 2, "openjs");
                     }

                     return 2;
                  }
               }
            }

            var9.offset += var17;
         } while(var9.offset < 1000);

         return 5;
      } catch (Throwable var26) {
         var26.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-1995799781"
   )
   static final void method184(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field290 || (class10.tileSettings[0][var1][var2] & 2) != 0 || (class10.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class10.field82) {
            class10.field82 = var0;
         }

         ObjectComposition var8 = ChatMessages.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.sizeX;
            var10 = var8.sizeY;
         } else {
            var9 = var8.sizeY;
            var10 = var8.sizeX;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = var1 + (var9 + 1 >> 1);
         } else {
            var11 = var1;
            var12 = 1 + var1;
         }

         int var13;
         int var14;
         if(var2 + var10 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = (1 + var10 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class10.tileHeights[var0];
         int var16 = var15[var11][var13] + var15[var12][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + (var3 << 14) + (var2 << 7) + var1;
         if(var8.field2917 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field2938 == 1) {
            var20 += 256;
         }

         if(var8.method3674()) {
            class26.method619(var0, var1, var2, var8, var4);
         }

         Object var27;
         if(var5 == 22) {
            if(!Client.field290 || var8.field2917 != 0 || var8.field2915 == 1 || var8.field2943) {
               if(var8.animationId == -1 && null == var8.impostorIds) {
                  var27 = var8.method3663(22, var4, var15, var17, var16, var18);
               } else {
                  var27 = new class49(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var27, var19, var20);
               if(var8.field2915 == 1 && null != var7) {
                  var7.method2347(var1, var2);
               }

            }
         } else {
            int var26;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var27 = var8.method3663(var5, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1828(var0, var1, var2, var16, 1, 1, (Renderable)var27, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class159.field2122[var0][var1][var2] |= 2340;
                  }

                  if(var8.field2915 != 0 && null != var7) {
                     var7.method2358(var1, var2, var9, var10, var8.field2936);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var27 = var8.method3663(0, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new class49(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1899(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class10.field85[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field2905) {
                        class10.field83[var0][var1][var2] = 50;
                        class10.field83[var0][var1][1 + var2] = 50;
                     }

                     if(var8.field2914) {
                        class159.field2122[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field2905) {
                        class10.field83[var0][var1][var2 + 1] = 50;
                        class10.field83[var0][var1 + 1][1 + var2] = 50;
                     }

                     if(var8.field2914) {
                        class159.field2122[var0][var1][1 + var2] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field2905) {
                        class10.field83[var0][1 + var1][var2] = 50;
                        class10.field83[var0][1 + var1][var2 + 1] = 50;
                     }

                     if(var8.field2914) {
                        class159.field2122[var0][1 + var1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field2905) {
                        class10.field83[var0][var1][var2] = 50;
                        class10.field83[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field2914) {
                        class159.field2122[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field2915 != 0 && var7 != null) {
                     var7.method2344(var1, var2, var5, var4, var8.field2936);
                  }

                  if(var8.field2922 != 16) {
                     var6.method1806(var0, var1, var2, var8.field2922);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var27 = var8.method3663(1, var4, var15, var17, var16, var18);
                  } else {
                     var27 = new class49(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1899(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class10.field79[var4], 0, var19, var20);
                  if(var8.field2905) {
                     if(var4 == 0) {
                        class10.field83[var0][var1][1 + var2] = 50;
                     } else if(var4 == 1) {
                        class10.field83[var0][var1 + 1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class10.field83[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        class10.field83[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2915 != 0 && var7 != null) {
                     var7.method2344(var1, var2, var5, var4, var8.field2936);
                  }

               } else {
                  int var21;
                  Object var23;
                  if(var5 == 2) {
                     var21 = var4 + 1 & 3;
                     Object var22;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var22 = var8.method3663(2, 4 + var4, var15, var17, var16, var18);
                        var23 = var8.method3663(2, var21, var15, var17, var16, var18);
                     } else {
                        var22 = new class49(var3, 2, 4 + var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var23 = new class49(var3, 2, var21, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1899(var0, var1, var2, var16, (Renderable)var22, (Renderable)var23, class10.field85[var4], class10.field85[var21], var19, var20);
                     if(var8.field2914) {
                        if(var4 == 0) {
                           class159.field2122[var0][var1][var2] |= 585;
                           class159.field2122[var0][var1][1 + var2] |= 1170;
                        } else if(var4 == 1) {
                           class159.field2122[var0][var1][var2 + 1] |= 1170;
                           class159.field2122[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           class159.field2122[var0][1 + var1][var2] |= 585;
                           class159.field2122[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class159.field2122[var0][var1][var2] |= 1170;
                           class159.field2122[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field2915 != 0 && null != var7) {
                        var7.method2344(var1, var2, var5, var4, var8.field2936);
                     }

                     if(var8.field2922 != 16) {
                        var6.method1806(var0, var1, var2, var8.field2922);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var27 = var8.method3663(3, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1899(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class10.field79[var4], 0, var19, var20);
                     if(var8.field2905) {
                        if(var4 == 0) {
                           class10.field83[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class10.field83[var0][var1 + 1][1 + var2] = 50;
                        } else if(var4 == 2) {
                           class10.field83[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class10.field83[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field2915 != 0 && var7 != null) {
                        var7.method2344(var1, var2, var5, var4, var8.field2936);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var27 = var8.method3663(var5, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1828(var0, var1, var2, var16, 1, 1, (Renderable)var27, 0, var19, var20);
                     if(var8.field2915 != 0 && var7 != null) {
                        var7.method2358(var1, var2, var9, var10, var8.field2936);
                     }

                     if(var8.field2922 != 16) {
                        var6.method1806(var0, var1, var2, var8.field2922);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var27 = var8.method3663(4, var4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1799(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, class10.field85[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var21 = 16;
                     var26 = var6.method1815(var0, var1, var2);
                     if(var26 != 0) {
                        var21 = ChatMessages.getObjectDefinition(var26 >> 14 & 32767).field2922;
                     }

                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var23 = var8.method3663(4, var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1799(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, class10.field85[var4], 0, var21 * class10.field81[var4], var21 * class10.field88[var4], var19, var20);
                  } else if(var5 == 6) {
                     var21 = 8;
                     var26 = var6.method1815(var0, var1, var2);
                     if(var26 != 0) {
                        var21 = ChatMessages.getObjectDefinition(var26 >> 14 & 32767).field2922 / 2;
                     }

                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var23 = var8.method3663(4, 4 + var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class49(var3, 4, 4 + var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1799(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, 256, var4, var21 * class10.field93[var4], var21 * class10.field90[var4], var19, var20);
                  } else if(var5 == 7) {
                     var26 = 2 + var4 & 3;
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var27 = var8.method3663(4, var26 + 4, var15, var17, var16, var18);
                     } else {
                        var27 = new class49(var3, 4, 4 + var26, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1799(var0, var1, var2, var16, (Renderable)var27, (Renderable)null, 256, var26, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var21 = 8;
                     var26 = var6.method1815(var0, var1, var2);
                     if(var26 != 0) {
                        var21 = ChatMessages.getObjectDefinition(var26 >> 14 & 32767).field2922 / 2;
                     }

                     int var25 = 2 + var4 & 3;
                     Object var29;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var23 = var8.method3663(4, var4 + 4, var15, var17, var16, var18);
                        var29 = var8.method3663(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var23 = new class49(var3, 4, 4 + var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var29 = new class49(var3, 4, 4 + var25, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1799(var0, var1, var2, var16, (Renderable)var23, (Renderable)var29, 256, var4, class10.field93[var4] * var21, var21 * class10.field90[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var27 = var8.method3663(10, var4, var15, var17, var16, var18);
               } else {
                  var27 = new class49(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(null != var27 && var6.method1828(var0, var1, var2, var16, var9, var10, (Renderable)var27, var5 == 11?256:0, var19, var20) && var8.field2905) {
                  var26 = 15;
                  if(var27 instanceof Model) {
                     var26 = ((Model)var27).method1651() / 4;
                     if(var26 > 30) {
                        var26 = 30;
                     }
                  }

                  for(int var28 = 0; var28 <= var9; ++var28) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var26 > class10.field83[var0][var28 + var1][var2 + var24]) {
                           class10.field83[var0][var1 + var28][var2 + var24] = (byte)var26;
                        }
                     }
                  }
               }

               if(var8.field2915 != 0 && var7 != null) {
                  var7.method2358(var1, var2, var9, var10, var8.field2936);
               }

            }
         }
      }
   }
}
