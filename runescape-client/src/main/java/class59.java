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
      } catch (Exception var31) {
         class155.field2257 = "Unknown";
      }

      WidgetNode.field812 = class155.field2257.toLowerCase();

      try {
         class40.field555 = System.getProperty("user.home");
         if(class40.field555 != null) {
            class40.field555 = class40.field555 + "/";
         }
      } catch (Exception var30) {
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
      } catch (Exception var29) {
         ;
      }

      if(class40.field555 == null) {
         class40.field555 = "~/";
      }

      class112.field1664 = new String[]{"c:/rscache/", "/rscache/", "c:/windows/", "c:/winnt/", "c:/", class40.field555, "/tmp/", ""};
      Preferences.field1304 = new String[]{".jagex_cache_" + class140.field2123, ".file_store_" + class140.field2123};
      int var4 = 0;

      File var5;
      label295:
      while(var4 < 4) {
         String var6 = var4 == 0?"":"" + var4;
         class155.field2259 = new File(class40.field555, "jagex_cl_" + var0 + "_" + var1 + var6 + ".dat");
         String var7 = null;
         String var8 = null;
         boolean var9 = false;
         Buffer var11;
         File var39;
         if(class155.field2259.exists()) {
            try {
               FileOnDisk var10 = new FileOnDisk(class155.field2259, "rw", 10000L);

               int var12;
               for(var11 = new Buffer((int)var10.method2266()); var11.offset < var11.payload.length; var11.offset += var12) {
                  var12 = var10.method2267(var11.payload, var11.offset, var11.payload.length - var11.offset);
                  if(var12 == -1) {
                     throw new IOException();
                  }
               }

               var11.offset = 0;
               var12 = var11.readUnsignedByte();
               if(var12 < 1 || var12 > 3) {
                  throw new IOException("" + var12);
               }

               int var13 = 0;
               if(var12 > 1) {
                  var13 = var11.readUnsignedByte();
               }

               if(var12 <= 2) {
                  var7 = var11.method3042();
                  if(var13 == 1) {
                     var8 = var11.method3042();
                  }
               } else {
                  var7 = var11.method3104();
                  if(var13 == 1) {
                     var8 = var11.method3104();
                  }
               }

               var10.method2274();
            } catch (IOException var34) {
               var34.printStackTrace();
            }

            if(var7 != null) {
               var39 = new File(var7);
               if(!var39.exists()) {
                  var7 = null;
               }
            }

            if(var7 != null) {
               var39 = new File(var7, "test.dat");
               if(!Player.method1093(var39, true)) {
                  var7 = null;
               }
            }
         }

         if(var7 == null && var4 == 0) {
            label269:
            for(int var18 = 0; var18 < Preferences.field1304.length; ++var18) {
               for(int var19 = 0; var19 < class112.field1664.length; ++var19) {
                  File var20 = new File(class112.field1664[var19] + Preferences.field1304[var18] + File.separatorChar + var0 + File.separatorChar);
                  if(var20.exists() && Player.method1093(new File(var20, "test.dat"), true)) {
                     var7 = var20.toString();
                     var9 = true;
                     break label269;
                  }
               }
            }
         }

         if(var7 == null) {
            var7 = class40.field555 + File.separatorChar + "jagexcache" + var6 + File.separatorChar + var0 + File.separatorChar + var1 + File.separatorChar;
            var9 = true;
         }

         File var38;
         if(var8 != null) {
            var38 = new File(var8);
            var39 = new File(var7);

            try {
               File[] var41 = var38.listFiles();
               File[] var21 = var41;

               for(int var14 = 0; var14 < var21.length; ++var14) {
                  File var15 = var21[var14];
                  File var16 = new File(var39, var15.getName());
                  boolean var17 = var15.renameTo(var16);
                  if(!var17) {
                     throw new IOException();
                  }
               }
            } catch (Exception var33) {
               var33.printStackTrace();
            }

            var9 = true;
         }

         if(var9) {
            var38 = new File(var7);
            var11 = null;

            try {
               FileOnDisk var42 = new FileOnDisk(class155.field2259, "rw", 10000L);
               Buffer var43 = new Buffer(500);
               var43.putByte(3);
               var43.putByte(var11 != null?1:0);
               var43.method3153(var38.getPath());
               if(var11 != null) {
                  var43.method3153("");
               }

               var42.method2264(var43.payload, 0, var43.offset);
               var42.method2274();
            } catch (IOException var28) {
               var28.printStackTrace();
            }
         }

         var5 = new File(var7);
         CombatInfoListHolder.field1357 = var5;
         if(!CombatInfoListHolder.field1357.exists()) {
            CombatInfoListHolder.field1357.mkdirs();
         }

         File[] var35 = CombatInfoListHolder.field1357.listFiles();
         if(var35 != null) {
            File[] var40 = var35;

            for(int var22 = 0; var22 < var40.length; ++var22) {
               File var23 = var40[var22];
               if(!Player.method1093(var23, false)) {
                  ++var4;
                  continue label295;
               }
            }
         }
         break;
      }

      File var24 = CombatInfoListHolder.field1357;
      class5.field40 = var24;
      if(!class5.field40.exists()) {
         throw new RuntimeException("");
      } else {
         class157.field2270 = true;

         try {
            var5 = new File(class40.field555, "random.dat");
            int var25;
            if(var5.exists()) {
               class155.field2256 = new class123(new FileOnDisk(var5, "rw", 25L), 24, 0);
            } else {
               label220:
               for(int var26 = 0; var26 < Preferences.field1304.length; ++var26) {
                  for(var25 = 0; var25 < class112.field1664.length; ++var25) {
                     File var37 = new File(class112.field1664[var25] + Preferences.field1304[var26] + File.separatorChar + "random.dat");
                     if(var37.exists()) {
                        class155.field2256 = new class123(new FileOnDisk(var37, "rw", 25L), 24, 0);
                        break label220;
                     }
                  }
               }
            }

            if(class155.field2256 == null) {
               RandomAccessFile var36 = new RandomAccessFile(var5, "rw");
               var25 = var36.read();
               var36.seek(0L);
               var36.write(var25);
               var36.seek(0L);
               var36.close();
               class155.field2256 = new class123(new FileOnDisk(var5, "rw", 25L), 24, 0);
            }
         } catch (IOException var32) {
            ;
         }

         class155.field2262 = new class123(new FileOnDisk(class71.method1049("main_file_cache.dat2"), "rw", 1048576000L), 5200, 0);
         class155.field2263 = new class123(new FileOnDisk(class71.method1049("main_file_cache.idx255"), "rw", 1048576L), 6000, 0);
         WorldMapType3.field404 = new class123[XItemContainer.field771];

         for(int var27 = 0; var27 < XItemContainer.field771; ++var27) {
            WorldMapType3.field404[var27] = new class123(new FileOnDisk(class71.method1049("main_file_cache.idx" + var27), "rw", 1048576L), 6000, 0);
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
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class17.region.method2750(var0, var2, var3);
               var12 = class29.getObjectDefinition(var34);
               if(var12.field3476 != 0) {
                  Client.collisionMaps[var0].method2931(var2, var3, var35, var36, var12.field3468);
               }
            }

            if(var1 == 1) {
               class17.region.method2596(var0, var2, var3);
            }

            if(var1 == 2) {
               class17.region.method2597(var0, var2, var3);
               var12 = class29.getObjectDefinition(var34);
               if(var12.sizeX + var2 > 103 || var3 + var12.sizeX > 103 || var12.sizeY + var2 > 103 || var3 + var12.sizeY > 103) {
                  return;
               }

               if(var12.field3476 != 0) {
                  Client.collisionMaps[var0].method2919(var2, var3, var12.sizeX, var12.sizeY, var36, var12.field3468);
               }
            }

            if(var1 == 3) {
               class17.region.method2646(var0, var2, var3);
               var12 = class29.getObjectDefinition(var34);
               if(var12.field3476 == 1) {
                  Client.collisionMaps[var0].method2921(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class17.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class29.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.sizeX;
               var16 = var14.sizeY;
            } else {
               var15 = var14.sizeY;
               var16 = var14.sizeX;
            }

            int var17;
            int var18;
            if(var2 + var15 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = var2 + (var15 + 1 >> 1);
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
            int var23 = (var15 << 6) + (var2 << 7);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = var2 + (var3 << 7) + (var4 << 14) + 1073741824;
            if(var14.field3445 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.field3482 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4394(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.field3476 == 1) {
                  var13.method2916(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4394(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2588(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.field3476 != 0) {
                     var13.method2914(var2, var3, var15, var16, var14.field3468);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4394(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2586(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field748[var5], 0, var25, var26);
                  if(var14.field3476 != 0) {
                     var13.method2922(var2, var3, var6, var5, var14.field3468);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4394(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new DynamicObject(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2586(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field756[var5], 0, var25, var26);
                  if(var14.field3476 != 0) {
                     var13.method2922(var2, var3, var6, var5, var14.field3468);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = var5 + 1 & 3;
                     Object var28;
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var28 = var14.method4394(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method4394(2, var32, var21, var23, var22, var24);
                     } else {
                        var28 = new DynamicObject(var4, 2, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new DynamicObject(var4, 2, var32, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2586(var0, var2, var3, var22, (Renderable)var28, (Renderable)var29, class61.field748[var5], class61.field748[var32], var25, var26);
                     if(var14.field3476 != 0) {
                        var13.method2922(var2, var3, var6, var5, var14.field3468);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4394(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2586(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field756[var5], 0, var25, var26);
                     if(var14.field3476 != 0) {
                        var13.method2922(var2, var3, var6, var5, var14.field3468);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4394(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2588(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.field3476 != 0) {
                        var13.method2914(var2, var3, var15, var16, var14.field3468);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4394(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2700(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field748[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var33;
                     if(var6 == 5) {
                        var32 = 16;
                        var33 = var37.method2584(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class29.getObjectDefinition(var33 >> 14 & 32767).field3475;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4394(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method2700(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class61.field748[var5], 0, var32 * class61.field757[var5], var32 * class61.field758[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var33 = var37.method2584(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class29.getObjectDefinition(var33 >> 14 & 32767).field3475 / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4394(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method2700(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class61.field752[var5], var32 * class61.field760[var5], var25, var26);
                     } else if(var6 == 7) {
                        var33 = var5 + 2 & 3;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var27 = var14.method4394(4, var33 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new DynamicObject(var4, 4, var33 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method2700(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var33, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var33 = var37.method2584(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class29.getObjectDefinition(var33 >> 14 & 32767).field3475 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4394(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method4394(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new DynamicObject(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new DynamicObject(var4, 4, var31 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method2700(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, class61.field752[var5] * var32, class61.field760[var5] * var32, var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4394(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new DynamicObject(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var37.method2588(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field3476 != 0) {
                  var13.method2914(var2, var3, var15, var16, var14.field3468);
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
}
