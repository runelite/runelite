import java.awt.Component;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class26 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 128441226321662949L
   )
   long field590;
   @ObfuscatedName("b")
   DataInputStream field591;
   @ObfuscatedName("g")
   byte[] field592 = new byte[4];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 3260437
   )
   int field593;
   @ObfuscatedName("v")
   byte[] field594;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2126281545
   )
   int field595;
   @ObfuscatedName("m")
   class102 field597;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2066144311
   )
   int field599;

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-329535393"
   )
   static final void method560() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[1 + var1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[1 + var1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[1 + var1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[1 + var1];
               Client.menuActionParams0[1 + var1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[1 + var1];
               Client.menuActionParams1[1 + var1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[1 + var1];
               Client.menuIdentifiers[var1 + 1] = var4;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "-183180866"
   )
   static final int method565(long var0, String var2) {
      Random var3 = new Random();
      Buffer var4 = new Buffer(128);
      Buffer var5 = new Buffer(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2815(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2714(var3.nextInt());
      }

      var4.method2714(var6[0]);
      var4.method2714(var6[1]);
      var4.method2716(var0);
      var4.method2716(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2714(var3.nextInt());
      }

      var4.method2747(class36.field775, class36.field778);
      var5.method2815(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2714(var3.nextInt());
      }

      var5.method2716(var3.nextLong());
      var5.method2715(var3.nextLong());
      byte[] var19 = new byte[24];

      try {
         class104.field1687.method1353(0L);
         class104.field1687.method1381(var19);

         int var8;
         for(var8 = 0; var8 < 24 && var19[var8] == 0; ++var8) {
            ;
         }

         if(var8 >= 24) {
            throw new IOException();
         }
      } catch (Exception var27) {
         for(int var9 = 0; var9 < 24; ++var9) {
            var19[var9] = -1;
         }
      }

      var5.method2813(var19, 0, 24);
      var5.method2716(var3.nextLong());
      var5.method2747(class36.field775, class36.field778);
      var7 = class112.method2050(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      Buffer var20 = new Buffer(var7);
      var20.method2717(var2);
      var20.offset = var7;
      var20.method2743(var6);
      Buffer var21 = new Buffer(var5.offset + 5 + var4.offset + var20.offset);
      var21.method2815(2);
      var21.method2815(var4.offset);
      var21.method2813(var4.payload, 0, var4.offset);
      var21.method2815(var5.offset);
      var21.method2813(var5.payload, 0, var5.offset);
      var21.method2712(var20.offset);
      var21.method2813(var20.payload, 0, var20.offset);
      byte[] var11 = var21.payload;
      int var13 = var11.length;
      StringBuilder var14 = new StringBuilder();

      int var17;
      for(int var15 = 0; var15 < 0 + var13; var15 += 3) {
         int var16 = var11[var15] & 255;
         var14.append(class206.field3089[var16 >>> 2]);
         if(var15 < var13 - 1) {
            var17 = var11[1 + var15] & 255;
            var14.append(class206.field3089[(var16 & 3) << 4 | var17 >>> 4]);
            if(var15 < var13 - 2) {
               int var18 = var11[2 + var15] & 255;
               var14.append(class206.field3089[(var17 & 15) << 2 | var18 >>> 6]).append(class206.field3089[var18 & 63]);
            } else {
               var14.append(class206.field3089[(var17 & 15) << 2]).append("=");
            }
         } else {
            var14.append(class206.field3089[(var16 & 3) << 4]).append("==");
         }
      }

      String var12 = var14.toString();
      var12 = var12;

      try {
         URL var22 = new URL(class65.method1162("services", false) + "m=accountappeal/login.ws");
         URLConnection var28 = var22.openConnection();
         var28.setDoInput(true);
         var28.setDoOutput(true);
         var28.setConnectTimeout(5000);
         OutputStreamWriter var23 = new OutputStreamWriter(var28.getOutputStream());
         var23.write("data2=" + Actor.method589(var12) + "&dest=" + Actor.method589("passwordchoice.ws"));
         var23.flush();
         InputStream var24 = var28.getInputStream();
         var21 = new Buffer(new byte[1000]);

         do {
            var17 = var24.read(var21.payload, var21.offset, 1000 - var21.offset);
            if(var17 == -1) {
               var23.close();
               var24.close();
               String var25 = new String(var21.payload);
               if(var25.startsWith("OFFLINE")) {
                  return 4;
               } else if(var25.startsWith("WRONG")) {
                  return 7;
               } else if(var25.startsWith("RELOAD")) {
                  return 3;
               } else if(var25.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var21.method2744(var6);

                  while(var21.offset > 0 && var21.payload[var21.offset - 1] == 0) {
                     --var21.offset;
                  }

                  var25 = new String(var21.payload, 0, var21.offset);
                  if(class107.method1996(var25)) {
                     Tile.method1518(var25, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var21.offset += var17;
         } while(var21.offset < 1000);

         return 5;
      } catch (Throwable var26) {
         var26.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("cb")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "78"
   )
   static final void method566(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(class2.method25(var0)) {
         class38.field806 = null;
         class3.gameDraw(Widget.widgets[var0], -1, var1, var2, var3, var4, var5, var6, var7);
         if(class38.field806 != null) {
            class3.gameDraw(class38.field806, -1412584499, var1, var2, var3, var4, class164.field2163, class10.field101, var7);
            class38.field806 = null;
         }

      } else {
         if(var7 != -1) {
            Client.field308[var7] = true;
         } else {
            for(int var8 = 0; var8 < 100; ++var8) {
               Client.field308[var8] = true;
            }
         }

      }
   }

   class26(class103 var1, URL var2) {
      this.field597 = var1.method1921(var2);
      this.field599 = 0;
      this.field590 = class114.method2154() + 30000L;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-916084882"
   )
   byte[] method567() throws IOException {
      if(class114.method2154() > this.field590) {
         throw new IOException();
      } else {
         if(this.field599 == 0) {
            if(this.field597.field1664 == 2) {
               throw new IOException();
            }

            if(this.field597.field1664 == 1) {
               this.field591 = (DataInputStream)this.field597.field1662;
               this.field599 = 1;
            }
         }

         int var1;
         if(this.field599 == 1) {
            var1 = this.field591.available();
            if(var1 > 0) {
               if(var1 + this.field593 > 4) {
                  var1 = 4 - this.field593;
               }

               this.field593 += this.field591.read(this.field592, this.field593, var1);
               if(this.field593 == 4) {
                  int var2 = (new Buffer(this.field592)).method2731();
                  this.field594 = new byte[var2];
                  this.field599 = 2;
               }
            }
         }

         if(this.field599 == 2) {
            var1 = this.field591.available();
            if(var1 > 0) {
               if(var1 + this.field595 > this.field594.length) {
                  var1 = this.field594.length - this.field595;
               }

               this.field595 += this.field591.read(this.field594, this.field595, var1);
               if(this.field594.length == this.field595) {
                  return this.field594;
               }
            }
         }

         return null;
      }
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "65535"
   )
   static final void method568(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field314 && class63.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class159.region.method1823(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class159.region.method1693(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class159.region.method1691(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class159.region.method1803(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class159.region.method1696(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class159.region.method1683(var0, var2, var3);
               var12 = class143.getObjectDefinition(var13);
               if(var12.field2907 != 0) {
                  Client.collisionMaps[var0].method2205(var2, var3, var14, var15, var12.field2918);
               }
            }

            if(var1 == 1) {
               class159.region.method1684(var0, var2, var3);
            }

            if(var1 == 2) {
               class159.region.method1685(var0, var2, var3);
               var12 = class143.getObjectDefinition(var13);
               if(var2 + var12.field2905 > 103 || var12.field2905 + var3 > 103 || var12.field2938 + var2 > 103 || var3 + var12.field2938 > 103) {
                  return;
               }

               if(var12.field2907 != 0) {
                  Client.collisionMaps[var0].method2206(var2, var3, var12.field2905, var12.field2938, var15, var12.field2918);
               }
            }

            if(var1 == 3) {
               class159.region.method1806(var0, var2, var3);
               var12 = class143.getObjectDefinition(var13);
               if(var12.field2907 == 1) {
                  Client.collisionMaps[var0].method2208(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class10.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class20.method195(var0, var11, var2, var3, var4, var5, var6, class159.region, Client.collisionMaps[var0]);
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;Lclass182;Lclass182;ZII)V",
      garbageValue = "2130465699"
   )
   static void method569(Component var0, class182 var1, class182 var2, boolean var3, int var4) {
      if(class148.field2045) {
         if(var4 == 4) {
            class41.loginIndex = 4;
         }

      } else {
         class41.loginIndex = var4;
         class219.method3901();
         byte[] var5 = var1.method3220("title.jpg", "");
         class41.field830 = new SpritePixels(var5, var0);
         RSCanvas.field1766 = class41.field830.method4037();
         if((Client.flags & 536870912) != 0) {
            class41.field840 = class211.method3870(var2, "logo_deadman_mode", "");
         } else {
            class41.field840 = class211.method3870(var2, "logo", "");
         }

         class41.field828 = class211.method3870(var2, "titlebox", "");
         ChatLineBuffer.field972 = class211.method3870(var2, "titlebutton", "");
         class41.field829 = class116.method2197(var2, "runes", "");
         class63.field1094 = class116.method2197(var2, "title_mute", "");
         NPC.field769 = class211.method3870(var2, "options_radio_buttons,0", "");
         class231.field3280 = class211.method3870(var2, "options_radio_buttons,2", "");
         class45.field912 = new int[256];

         int var6;
         for(var6 = 0; var6 < 64; ++var6) {
            class45.field912[var6] = var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class45.field912[var6 + 64] = 16711680 + 1024 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class45.field912[var6 + 128] = 4 * var6 + 16776960;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class45.field912[192 + var6] = 16777215;
         }

         class214.field3159 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class214.field3159[var6] = var6 * 1024;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class214.field3159[var6 + 64] = var6 * 4 + '\uff00';
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class214.field3159[var6 + 128] = '\uffff' + 262144 * var6;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class214.field3159[192 + var6] = 16777215;
         }

         class15.field163 = new int[256];

         for(var6 = 0; var6 < 64; ++var6) {
            class15.field163[var6] = var6 * 4;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class15.field163[var6 + 64] = 255 + var6 * 262144;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class15.field163[128 + var6] = var6 * 1024 + 16711935;
         }

         for(var6 = 0; var6 < 64; ++var6) {
            class15.field163[var6 + 192] = 16777215;
         }

         ChatMessages.field918 = new int[256];
         class2.field21 = new int['耀'];
         class47.field943 = new int['耀'];
         class207.method3764((ModIcon)null);
         MessageNode.field230 = new int['耀'];
         ChatMessages.field931 = new int['耀'];
         if(var3) {
            class41.username = "";
            class41.field850 = "";
         }

         class206.field3091 = 0;
         ChatMessages.authCode = "";
         class41.field852 = true;
         class41.worldSelectShown = false;
         if(!XGrandExchangeOffer.field35.field700) {
            class184 var9 = class119.field1864;
            int var7 = var9.method3218("scape main");
            int var8 = var9.method3219(var7, "");
            class138.field1929 = 1;
            class138.field1930 = var9;
            class138.field1931 = var7;
            class181.field2711 = var8;
            class138.field1932 = 255;
            CombatInfo1.field665 = false;
            WidgetNode.field186 = 2;
         } else {
            class119.method2238(2);
         }

         MessageNode.method201(false);
         class148.field2045 = true;
         class41.field860 = (TextureProvider.field1200 - Client.field499) / 2;
         class41.loginWindowX = 202 + class41.field860;
         class41.field830.method4092(class41.field860, 0);
         RSCanvas.field1766.method4092(class41.field860 + 382, 0);
         class41.field840.method3995(class41.field860 + 382 - class41.field840.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1160827679"
   )
   public static void method570() {
      class196.field2869.reset();
      class196.spriteCache.reset();
      class196.field2871.reset();
   }
}
