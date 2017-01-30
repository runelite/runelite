import java.awt.Component;
import java.io.File;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class37 {
   @ObfuscatedName("jb")
   @ObfuscatedGetter(
      intValue = -1002653217
   )
   static int field785;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZB)LFileOnDisk;",
      garbageValue = "-2"
   )
   public static FileOnDisk method728(String var0, String var1, boolean var2) {
      File var3 = new File(Widget.field2332, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class104.field1691 == 33) {
         var4 = "_rc";
      } else if(class104.field1691 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(ChatLineBuffer.field971, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lclass40;",
      garbageValue = "2129958581"
   )
   static class40[] method731() {
      return new class40[]{class40.field812, class40.field815, class40.field808, class40.field807};
   }

   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-554719415"
   )
   static final void method732(int var0) {
      class13.method176();
      class110.method2056();
      class187 var2 = (class187)class187.field2772.get((long)var0);
      class187 var1;
      if(null != var2) {
         var1 = var2;
      } else {
         byte[] var5 = class187.field2775.getConfigData(16, var0);
         var2 = new class187();
         if(var5 != null) {
            var2.method3421(new Buffer(var5));
         }

         class187.field2772.put(var2, (long)var0);
         var1 = var2;
      }

      int var6 = var1.field2771;
      if(var6 != 0) {
         int var3 = class165.widgetSettings[var0];
         if(var6 == 1) {
            if(var3 == 1) {
               class84.method1684(0.9D);
               ((TextureProvider)class84.field1448).method1431(0.9D);
            }

            if(var3 == 2) {
               class84.method1684(0.8D);
               ((TextureProvider)class84.field1448).method1431(0.8D);
            }

            if(var3 == 3) {
               class84.method1684(0.7D);
               ((TextureProvider)class84.field1448).method1431(0.7D);
            }

            if(var3 == 4) {
               class84.method1684(0.6D);
               ((TextureProvider)class84.field1448).method1431(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var6 == 3) {
            short var4 = 0;
            if(var3 == 0) {
               var4 = 255;
            }

            if(var3 == 1) {
               var4 = 192;
            }

            if(var3 == 2) {
               var4 = 128;
            }

            if(var3 == 3) {
               var4 = 64;
            }

            if(var3 == 4) {
               var4 = 0;
            }

            if(Client.field536 != var4) {
               if(Client.field536 == 0 && Client.field515 != -1) {
                  class48.method875(class227.field3228, Client.field515, 0, var4, false);
                  Client.field516 = false;
               } else if(var4 == 0) {
                  class138.field1920.method2513();
                  class138.field1921 = 1;
                  Item.field887 = null;
                  Client.field516 = false;
               } else {
                  VertexNormal.method1627(var4);
               }

               Client.field536 = var4;
            }
         }

         if(var6 == 4) {
            if(var3 == 0) {
               Client.field517 = 127;
            }

            if(var3 == 1) {
               Client.field517 = 96;
            }

            if(var3 == 2) {
               Client.field517 = 64;
            }

            if(var3 == 3) {
               Client.field517 = 32;
            }

            if(var3 == 4) {
               Client.field517 = 0;
            }
         }

         if(var6 == 5) {
            Client.field384 = var3;
         }

         if(var6 == 6) {
            Client.field413 = var3;
         }

         if(var6 == 9) {
            Client.field440 = var3;
         }

         if(var6 == 10) {
            if(var3 == 0) {
               Client.field518 = 127;
            }

            if(var3 == 1) {
               Client.field518 = 96;
            }

            if(var3 == 2) {
               Client.field518 = 64;
            }

            if(var3 == 3) {
               Client.field518 = 32;
            }

            if(var3 == 4) {
               Client.field518 = 0;
            }
         }

         if(var6 == 17) {
            Client.field445 = var3 & '\uffff';
         }

         if(var6 == 18) {
            Client.field307 = (class40)TextureProvider.method1454(method731(), var3);
            if(null == Client.field307) {
               Client.field307 = class40.field815;
            }
         }

         if(var6 == 19) {
            if(var3 == -1) {
               Client.field336 = -1;
            } else {
               Client.field336 = var3 & 2047;
            }
         }

         if(var6 == 22) {
            Client.field305 = (class40)TextureProvider.method1454(method731(), var3);
            if(Client.field305 == null) {
               Client.field305 = class40.field815;
            }
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "71"
   )
   public static Class method733(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass182;Lclass182;ZII)V",
      garbageValue = "1156759383"
   )
   static void method734(Component var0, class182 var1, class182 var2, boolean var3, int var4) {
      if(class41.field826) {
         if(var4 == 4) {
            class41.loginIndex = 4;
         }

      } else {
         class41.loginIndex = var4;
         Rasterizer2D.method3989();
         byte[] var5 = var1.method3288("title.jpg", "");
         class41.field821 = new SpritePixels(var5, var0);
         CombatInfo1.field658 = class41.field821.method4131();
         if((Client.flags & 536870912) != 0) {
            class41.field819 = class164.method3118(var2, "logo_deadman_mode", "");
         } else {
            class41.field819 = class164.method3118(var2, "logo", "");
         }

         class41.field851 = class164.method3118(var2, "titlebox", "");
         class41.field820 = class164.method3118(var2, "titlebutton", "");
         class211.field3124 = class8.method116(var2, "runes", "");
         class41.field823 = class8.method116(var2, "title_mute", "");
         class41.field824 = class164.method3118(var2, "options_radio_buttons,0", "");
         class41.field825 = class164.method3118(var2, "options_radio_buttons,2", "");
         class0.field3 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class0.field3[var6] = 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class0.field3[64 + var6] = 1024 * var6 + 16711680;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class0.field3[128 + var6] = 4 * var6 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class0.field3[192 + var6] = 16777215;
         }

         class3.field31 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class3.field31[var6] = 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class3.field31[64 + var6] = 4 * var6 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class3.field31[var6 + 128] = '\uffff' + 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class3.field31[192 + var6] = 16777215;
         }

         class145.field2018 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class145.field2018[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class145.field2018[64 + var6] = 255 + var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class145.field2018[var6 + 128] = 1024 * var6 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class145.field2018[var6 + 192] = 16777215;
         }

         class41.field829 = new int[256];
         CollisionData.field1841 = new int['耀'];
         FileOnDisk.field1191 = new int['耀'];
         class8.method115((ModIcon)null);
         class40.field806 = new int['耀'];
         class10.field101 = new int['耀'];
         if(var3) {
            class41.username = "";
            class41.field844 = "";
         }

         class31.field713 = 0;
         ChatMessages.authCode = "";
         class41.field846 = true;
         class41.worldSelectShown = false;
         if(!class107.field1733.field693) {
            class85.method1693(2, class227.field3228, "scape main", "", 255, false);
         } else {
            class138.field1921 = 1;
            Item.field887 = null;
            class181.field2695 = -1;
            Frames.field1569 = -1;
            class105.field1721 = 0;
            class138.field1922 = false;
            class138.field1926 = 2;
         }

         class119.method2295(false);
         class41.field826 = true;
         class41.field818 = (class26.field577 - Client.field492) / 2;
         class41.loginWindowX = 202 + class41.field818;
         class41.field821.method4142(class41.field818, 0);
         CombatInfo1.field658.method4142(382 + class41.field818, 0);
         class41.field819.method4083(class41.field818 + 382 - class41.field819.originalWidth / 2, 18);
      }
   }

   class37() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IIIIZI)V",
      garbageValue = "1299395703"
   )
   static final void method735(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = var5 * (Client.field532 - Client.field355) / 100 + Client.field355;
      int var7 = var3 * var6 * 512 / (334 * var2);
      int var8;
      int var14;
      short var15;
      if(var7 < Client.field345) {
         var15 = Client.field345;
         var6 = 334 * var2 * var15 / (512 * var3);
         if(var6 > Client.field450) {
            var6 = Client.field450;
            var8 = var3 * var6 * 512 / (334 * var15);
            var14 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4037();
               Rasterizer2D.method4020(var0, var1, var14, var3, -16777216);
               Rasterizer2D.method4020(var0 + var2 - var14, var1, var14, var3, -16777216);
            }

            var0 += var14;
            var2 -= var14 * 2;
         }
      } else if(var7 > Client.field538) {
         var15 = Client.field538;
         var6 = var15 * var2 * 334 / (var3 * 512);
         if(var6 < Client.field535) {
            var6 = Client.field535;
            var8 = 334 * var2 * var15 / (var6 * 512);
            var14 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4037();
               Rasterizer2D.method4020(var0, var1, var2, var14, -16777216);
               Rasterizer2D.method4020(var0, var1 + var3 - var14, var2, var14, -16777216);
            }

            var1 += var14;
            var3 -= 2 * var14;
         }
      }

      var8 = Client.field533 + var5 * (Client.field534 - Client.field533) / 100;
      Client.scale = var6 * var3 * var8 / 85504 << 1;
      if(var2 != Client.camera2 || Client.camera3 != var3) {
         int[] var9 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + 128 + 32 * var10;
            int var12 = 600 + 3 * var11;
            int var13 = class84.field1438[var11];
            var9[var10] = var12 * var13 >> 16;
         }

         Region.method1756(var9, 500, 800, var2, var3);
      }

      Client.field539 = var0;
      Client.field540 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "1940962145"
   )
   public static Widget method736(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(Widget.widgets[var1] == null || null == Widget.widgets[var1][var2]) {
         boolean var3 = class103.method1973(var1);
         if(!var3) {
            return null;
         }
      }

      return Widget.widgets[var1][var2];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1440746654"
   )
   public static int method737(String var0) {
      return var0.length() + 1;
   }
}
