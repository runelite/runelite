import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
public class class59 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("pq")
   static class116 field724;
   @ObfuscatedName("cn")
   static class153 field726;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1144971539
   )
   @Export("mouseX")
   public static volatile int mouseX;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 5417723123205470883L
   )
   public static volatile long field728;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1785806087
   )
   public static int field729;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1546371953
   )
   public static int field730;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -575508591
   )
   public static int field731;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 133035487
   )
   public static int field732;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1134258355
   )
   public static volatile int field733;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1346580193
   )
   public static volatile int field734;
   @ObfuscatedName("iw")
   static Widget field735;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1377715235
   )
   public static int field736;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 66212403
   )
   public static int field737;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 422713407
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = 319077498839253265L
   )
   public static long field739;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1090689827
   )
   @Export("mouseY")
   public static volatile int mouseY;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -2128926375
   )
   public static volatile int field743;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1072323249
   )
   public static volatile int field744;
   @ObfuscatedName("p")
   @Export("mouse")
   public static class59 mouse;

   public final synchronized void mousePressed(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field733 = var1.getX();
         field734 = var1.getY();
         field728 = class166.method2970();
         if(var1.isAltDown()) {
            field744 = 4;
            field743 = 4;
         } else if(var1.isMetaDown()) {
            field744 = 2;
            field743 = 2;
         } else {
            field744 = 1;
            field743 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field743 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = -1;
         mouseY = -1;
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field743 = 0;
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final void focusGained(FocusEvent var1) {
   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         mouseX = var1.getX();
         mouseY = var1.getY();
      }

   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;I)Ljava/lang/String;",
      garbageValue = "725702684"
   )
   static String method959(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if(var3 == -1) {
                  break;
               }

               var0 = var0.substring(0, var3) + class6.method26(Player.method1087(var1, var2 - 1)) + var0.substring(var3 + 2);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var4 = "";
            if(class69.field834 != null) {
               var4 = class158.method2867(class69.field834.field2238);
               if(class69.field834.field2241 != null) {
                  var4 = (String)class69.field834.field2241;
               }
            }

            var0 = var0.substring(0, var2) + var4 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "2123123229"
   )
   public static void method960(String var0, String var1, int var2, int var3) throws IOException {
      XItemContainer.field771 = var3;
      class140.field2123 = var2;

      try {
         class155.field2257 = System.getProperty("os.name");
      } catch (Exception var22) {
         class155.field2257 = "Unknown";
      }

      WidgetNode.field812 = class155.field2257.toLowerCase();

      try {
         class40.field555 = System.getProperty("user.home");
         if(class40.field555 != null) {
            class40.field555 = class40.field555 + "/";
         }
      } catch (Exception var21) {
         ;
      }

      try {
         if(WidgetNode.field812.startsWith("win")) {
            if(class40.field555 == null) {
               class40.field555 = System.getenv("USERPROFILE");
            }
         } else if(class40.field555 == null) {
            class40.field555 = System.getenv("HOME");
         }

         if(class40.field555 != null) {
            class40.field555 = class40.field555 + "/";
         }
      } catch (Exception var20) {
         ;
      }

      if(class40.field555 == null) {
         class40.field555 = "~/";
      }

      class112.field1664 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class40.field555, "/tmp/", ""};
      Preferences.field1304 = new String[]{".jagex_cache_" + class140.field2123, ".file_store_" + class140.field2123};
      int var4 = 0;

      File var5;
      label260:
      while(var4 < 4) {
         String var6 = var4 == 0?"":"" + var4;
         class155.field2259 = new File(class40.field555, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         Buffer var10;
         File var11;
         int var13;
         if(class155.field2259.exists()) {
            try {
               FileOnDisk var12 = new FileOnDisk(class155.field2259, "rw", 10000L);

               for(var10 = new Buffer((int)var12.method2266()); var10.offset < var10.payload.length; var10.offset += var13) {
                  var13 = var12.method2267(var10.payload, var10.offset, var10.payload.length - var10.offset);
                  if(var13 == -1) {
                     throw new IOException();
                  }
               }

               var10.offset = 0;
               var13 = var10.readUnsignedByte();
               if(var13 < 1 || var13 > 3) {
                  throw new IOException("" + var13);
               }

               int var14 = 0;
               if(var13 > 1) {
                  var14 = var10.readUnsignedByte();
               }

               if(var13 <= 2) {
                  var7 = var10.method3042();
                  if(var14 == 1) {
                     var8 = var10.method3042();
                  }
               } else {
                  var7 = var10.method3104();
                  if(var14 == 1) {
                     var8 = var10.method3104();
                  }
               }

               var12.method2274();
            } catch (IOException var25) {
               var25.printStackTrace();
            }

            if(var7 != null) {
               var11 = new File(var7);
               if(!var11.exists()) {
                  var7 = null;
               }
            }

            if(var7 != null) {
               var11 = new File(var7, "test.dat");
               if(!Player.method1093(var11, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var4 == 0) {
            label234:
            for(int var31 = 0; var31 < Preferences.field1304.length; ++var31) {
               for(var13 = 0; var13 < class112.field1664.length; ++var13) {
                  File var35 = new File(class112.field1664[var13] + Preferences.field1304[var31] + File.separatorChar + var0 + File.separatorChar);
                  if(var35.exists() && Player.method1093(new File(var35, "test.dat"), true)) {
                     var7 = var35.toString();
                     var9 = true;
                     break label234;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = class40.field555 + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         int var15;
         File var16;
         File var32;
         File[] var33;
         File[] var36;
         if(var8 != null) {
            var32 = new File(var8);
            var11 = new File(var7);

            try {
               var33 = var32.listFiles();
               var36 = var33;

               for(var15 = 0; var15 < var36.length; ++var15) {
                  var16 = var36[var15];
                  File var17 = new File(var11, var16.getName());
                  boolean var18 = var16.renameTo(var17);
                  if(!var18) {
                     throw new IOException();
                  }
               }
            } catch (Exception var24) {
               var24.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            var32 = new File(var7);
            var10 = null;

            try {
               FileOnDisk var34 = new FileOnDisk(class155.field2259, "rw", 10000L);
               Buffer var37 = new Buffer(500);
               var37.putByte(3);
               var37.putByte(var10 != null?1:0);
               var37.method3153(var32.getPath());
               if(var10 != null) {
                  var37.method3153("");
               }

               var34.method2264(var37.payload, 0, var37.offset);
               var34.method2274();
            } catch (IOException var19) {
               var19.printStackTrace();
            }
         }

         var5 = new File(var7);
         CombatInfoListHolder.field1357 = var5;
         if(!CombatInfoListHolder.field1357.exists()) {
            CombatInfoListHolder.field1357.mkdirs();
         }

         var33 = CombatInfoListHolder.field1357.listFiles();
         if(var33 != null) {
            var36 = var33;

            for(var15 = 0; var15 < var36.length; ++var15) {
               var16 = var36[var15];
               if(!Player.method1093(var16, false)) {
                  ++var4;
                  continue label260;
               }
            }
         }
         break;
      }

      File var26 = CombatInfoListHolder.field1357;
      class5.field40 = var26;
      if(!class5.field40.exists()) {
         throw new RuntimeException("");
      } else {
         class157.field2270 = true;

         int var30;
         try {
            var5 = new File(class40.field555, "random.dat");
            if(var5.exists()) {
               class155.field2256 = new class123(new FileOnDisk(var5, "rw", 25L), 24, 0);
            } else {
               label185:
               for(int var27 = 0; var27 < Preferences.field1304.length; ++var27) {
                  for(var30 = 0; var30 < class112.field1664.length; ++var30) {
                     File var29 = new File(class112.field1664[var30] + Preferences.field1304[var27] + File.separatorChar + "random.dat");
                     if(var29.exists()) {
                        class155.field2256 = new class123(new FileOnDisk(var29, "rw", 25L), 24, 0);
                        break label185;
                     }
                  }
               }
            }

            if(class155.field2256 == null) {
               RandomAccessFile var28 = new RandomAccessFile(var5, "rw");
               var30 = var28.read();
               var28.seek(0L);
               var28.write(var30);
               var28.seek(0L);
               var28.close();
               class155.field2256 = new class123(new FileOnDisk(var5, "rw", 25L), 24, 0);
            }
         } catch (IOException var23) {
            ;
         }

         class155.field2262 = new class123(new FileOnDisk(class71.method1049("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
         class155.field2263 = new class123(new FileOnDisk(class71.method1049("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
         WorldMapType3.field404 = new class123[XItemContainer.field771];

         for(var30 = 0; var30 < XItemContainer.field771; ++var30) {
            WorldMapType3.field404[var30] = new class123(new FileOnDisk(class71.method1049("main_file_cache.idx" + var30), "rw", 1048576L), 6000, 0);
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-1"
   )
   public static boolean method961(int var0) {
      if(class18.validInterfaces[var0]) {
         return true;
      } else if(!class2.field15.method3998(var0)) {
         return false;
      } else {
         int var1 = class2.field15.method4075(var0);
         if(var1 == 0) {
            class18.validInterfaces[var0] = true;
            return true;
         } else {
            if(Widget.widgets[var0] == null) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(Widget.widgets[var0][var2] == null) {
                  byte[] var3 = class2.field15.getConfigData(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3881(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3926(new Buffer(var3));
                     }
                  }
               }
            }

            class18.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1569348220"
   )
   static final void method962(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field1055 && Player.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class17.region.method2584(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class17.region.method2605(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class17.region.method2606(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class17.region.method2659(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class17.region.method2727(var0, var2, var3, var7);
            int var12 = var7 >> 14 & 32767;
            int var13 = var11 & 31;
            int var14 = var11 >> 6 & 3;
            ObjectComposition var15;
            if(var1 == 0) {
               class17.region.method2750(var0, var2, var3);
               var15 = class29.getObjectDefinition(var12);
               if(var15.field3476 != 0) {
                  Client.collisionMaps[var0].method2931(var2, var3, var13, var14, var15.field3468);
               }
            }

            if(var1 == 1) {
               class17.region.method2596(var0, var2, var3);
            }

            if(var1 == 2) {
               class17.region.method2597(var0, var2, var3);
               var15 = class29.getObjectDefinition(var12);
               if(var15.sizeX + var2 > 103 || var3 + var15.sizeX > 103 || var15.sizeY + var2 > 103 || var3 + var15.sizeY > 103) {
                  return;
               }

               if(var15.field3476 != 0) {
                  Client.collisionMaps[var0].method2919(var2, var3, var15.sizeX, var15.sizeY, var14, var15.field3468);
               }
            }

            if(var1 == 3) {
               class17.region.method2646(var0, var2, var3);
               var15 = class29.getObjectDefinition(var12);
               if(var15.field3476 == 1) {
                  Client.collisionMaps[var0].method2921(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var33 = class17.region;
            CollisionData var34 = Client.collisionMaps[var0];
            ObjectComposition var35 = class29.getObjectDefinition(var4);
            int var16;
            int var36;
            if(var5 != 1 && var5 != 3) {
               var36 = var35.sizeX;
               var16 = var35.sizeY;
            } else {
               var36 = var35.sizeY;
               var16 = var35.sizeX;
            }

            int var17;
            int var18;
            if(var2 + var36 <= 104) {
               var17 = (var36 >> 1) + var2;
               var18 = var2 + (var36 + 1 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var3 + var16 <= 104) {
               var19 = (var16 >> 1) + var3;
               var20 = var3 + (var16 + 1 >> 1);
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class61.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var17][var20] + var21[var18][var19] + var21[var17][var19] >> 2;
            int var23 = (var36 << 6) + (var2 << 7);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = var2 + (var3 << 7) + (var4 << 14) + 1073741824;
            if(var35.field3445 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var35.field3482 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var35.animationId == -1 && var35.impostorIds == null) {
                  var27 = var35.method4394(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 22, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
               }

               var33.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var35.field3476 == 1) {
                  var34.method2916(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var35.animationId == -1 && var35.impostorIds == null) {
                     var27 = var35.method4394(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                  }

                  var33.method2588(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var35.field3476 != 0) {
                     var34.method2914(var2, var3, var36, var16, var35.field3468);
                  }
               } else if(var6 == 0) {
                  if(var35.animationId == -1 && var35.impostorIds == null) {
                     var27 = var35.method4394(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 0, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                  }

                  var33.method2586(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field748[var5], 0, var25, var26);
                  if(var35.field3476 != 0) {
                     var34.method2922(var2, var3, var6, var5, var35.field3468);
                  }
               } else if(var6 == 1) {
                  if(var35.animationId == -1 && var35.impostorIds == null) {
                     var27 = var35.method4394(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 1, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                  }

                  var33.method2586(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field756[var5], 0, var25, var26);
                  if(var35.field3476 != 0) {
                     var34.method2922(var2, var3, var6, var5, var35.field3468);
                  }
               } else {
                  Object var28;
                  int var29;
                  if(var6 == 2) {
                     var29 = var5 + 1 & 3;
                     Object var30;
                     if(var35.animationId == -1 && var35.impostorIds == null) {
                        var30 = var35.method4394(2, var5 + 4, var21, var23, var22, var24);
                        var28 = var35.method4394(2, var29, var21, var23, var22, var24);
                     } else {
                        var30 = new DynamicObject(var4, 2, var5 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        var28 = new DynamicObject(var4, 2, var29, var11, var2, var3, var35.animationId, true, (Renderable)null);
                     }

                     var33.method2586(var0, var2, var3, var22, (Renderable)var30, (Renderable)var28, class61.field748[var5], class61.field748[var29], var25, var26);
                     if(var35.field3476 != 0) {
                        var34.method2922(var2, var3, var6, var5, var35.field3468);
                     }
                  } else if(var6 == 3) {
                     if(var35.animationId == -1 && var35.impostorIds == null) {
                        var27 = var35.method4394(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 3, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                     }

                     var33.method2586(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field756[var5], 0, var25, var26);
                     if(var35.field3476 != 0) {
                        var34.method2922(var2, var3, var6, var5, var35.field3468);
                     }
                  } else if(var6 == 9) {
                     if(var35.animationId == -1 && var35.impostorIds == null) {
                        var27 = var35.method4394(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                     }

                     var33.method2588(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var35.field3476 != 0) {
                        var34.method2914(var2, var3, var36, var16, var35.field3468);
                     }
                  } else if(var6 == 4) {
                     if(var35.animationId == -1 && var35.impostorIds == null) {
                        var27 = var35.method4394(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 4, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                     }

                     var33.method2700(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field748[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var37;
                     if(var6 == 5) {
                        var29 = 16;
                        var37 = var33.method2584(var0, var2, var3);
                        if(var37 != 0) {
                           var29 = class29.getObjectDefinition(var37 >> 14 & 32767).field3475;
                        }

                        if(var35.animationId == -1 && var35.impostorIds == null) {
                           var28 = var35.method4394(4, var5, var21, var23, var22, var24);
                        } else {
                           var28 = new DynamicObject(var4, 4, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        }

                        var33.method2700(var0, var2, var3, var22, (Renderable)var28, (Renderable)null, class61.field748[var5], 0, var29 * class61.field757[var5], var29 * class61.field758[var5], var25, var26);
                     } else if(var6 == 6) {
                        var29 = 8;
                        var37 = var33.method2584(var0, var2, var3);
                        if(var37 != 0) {
                           var29 = class29.getObjectDefinition(var37 >> 14 & 32767).field3475 / 2;
                        }

                        if(var35.animationId == -1 && var35.impostorIds == null) {
                           var28 = var35.method4394(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var28 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        }

                        var33.method2700(var0, var2, var3, var22, (Renderable)var28, (Renderable)null, 256, var5, var29 * class61.field752[var5], var29 * class61.field760[var5], var25, var26);
                     } else if(var6 == 7) {
                        var37 = var5 + 2 & 3;
                        if(var35.animationId == -1 && var35.impostorIds == null) {
                           var27 = var35.method4394(4, var37 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new DynamicObject(var4, 4, var37 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        }

                        var33.method2700(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var37, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var29 = 8;
                        var37 = var33.method2584(var0, var2, var3);
                        if(var37 != 0) {
                           var29 = class29.getObjectDefinition(var37 >> 14 & 32767).field3475 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var32;
                        if(var35.animationId == -1 && var35.impostorIds == null) {
                           var28 = var35.method4394(4, var5 + 4, var21, var23, var22, var24);
                           var32 = var35.method4394(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var28 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                           var32 = new DynamicObject(var4, 4, var31 + 4, var11, var2, var3, var35.animationId, true, (Renderable)null);
                        }

                        var33.method2700(var0, var2, var3, var22, (Renderable)var28, (Renderable)var32, 256, var5, class61.field752[var5] * var29, class61.field760[var5] * var29, var25, var26);
                     }
                  }
               }
            } else {
               if(var35.animationId == -1 && var35.impostorIds == null) {
                  var27 = var35.method4394(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 10, var5, var11, var2, var3, var35.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var33.method2588(var0, var2, var3, var22, var36, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var35.field3476 != 0) {
                  var34.method2914(var2, var3, var36, var16, var35.field3468);
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)[Lclass283;",
      garbageValue = "2"
   )
   public static class283[] method963() {
      return new class283[]{class283.field3767, class283.field3765, class283.field3766, class283.field3763, class283.field3764};
   }

   static {
      mouse = new class59();
      mouseIdleTicks = 0;
      field743 = 0;
      mouseX = -1;
      mouseY = -1;
      field729 = 0;
      field730 = 0;
      field731 = 0;
      field744 = 0;
      field733 = 0;
      field734 = 0;
      field728 = 0L;
      field736 = 0;
      field737 = 0;
      field732 = 0;
      field739 = 0L;
   }
}
