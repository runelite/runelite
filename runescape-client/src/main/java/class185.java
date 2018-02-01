import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class185 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1574695187
   )
   static int field2494;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1968498795
   )
   static int field2498;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -929380837
   )
   static int field2495;
   @ObfuscatedName("s")
   static byte[][] field2493;
   @ObfuscatedName("j")
   static byte[][] field2497;
   @ObfuscatedName("a")
   static byte[][] field2499;
   @ObfuscatedName("t")
   static int[] field2496;
   @ObfuscatedName("r")
   static int[] field2500;

   static {
      field2494 = 0;
      field2498 = 0;
      field2495 = 0;
      field2493 = new byte[1000][];
      field2497 = new byte[250][];
      field2499 = new byte[50][];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;I)V",
      garbageValue = "976892119"
   )
   public static void method3615(IndexDataBase var0) {
      class262.field3448 = var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IZI)[B",
      garbageValue = "341882131"
   )
   static synchronized byte[] method3612(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2494 > 0) {
         var2 = field2493[--field2494];
         field2493[field2494] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2498 > 0) {
         var2 = field2497[--field2498];
         field2497[field2498] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(field2495 > 0) {
         var2 = field2499[--field2495];
         field2499[field2495] = null;
         return var2;
      }

      if(class219.field2675 != null) {
         for(int var4 = 0; var4 < field2496.length; ++var4) {
            if(field2496[var4] != var0) {
               if(var0 < field2496[var4]) {
                  ;
               }
            } else if(field2500[var4] > 0) {
               byte[] var3 = class219.field2675[var4][--field2500[var4]];
               class219.field2675[var4][field2500[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lik;Lik;ZII)V",
      garbageValue = "-2070912848"
   )
   static void method3624(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class89.field1320) {
         if(var3 == 4) {
            class89.loginIndex = 4;
         }

      } else {
         class89.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.takeRecordByNames("title.jpg", "");
         BufferedImage var6 = null;

         SpritePixels var5;
         int var7;
         int var8;
         label156: {
            try {
               var6 = ImageIO.read(new ByteArrayInputStream(var4));
               var7 = var6.getWidth();
               var8 = var6.getHeight();
               int[] var9 = new int[var7 * var8];
               PixelGrabber var10 = new PixelGrabber(var6, 0, 0, var7, var8, var9, 0, var7);
               var10.grabPixels();
               var5 = new SpritePixels(var9, var7, var8);
               break label156;
            } catch (IOException var13) {
               ;
            } catch (InterruptedException var14) {
               ;
            }

            var5 = new SpritePixels(0, 0);
         }

         class89.field1316 = var5;
         class295.field3780 = class89.field1316.method5525();
         if((Client.flags & 536870912) != 0) {
            class7.logoSprite = class221.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class7.logoSprite = class221.getSprite(var1, "logo", "");
         }

         class89.field1302 = class221.getSprite(var1, "titlebox", "");
         class89.field1303 = class221.getSprite(var1, "titlebutton", "");
         ScriptState.runeSprites = class228.getIndexedSprites(var1, "runes", "");
         class18.titlemuteSprite = class228.getIndexedSprites(var1, "title_mute", "");
         class89.field1305 = class221.getSprite(var1, "options_radio_buttons,0", "");
         class89.field1309 = class221.getSprite(var1, "options_radio_buttons,4", "");
         TextureProvider.field1658 = class221.getSprite(var1, "options_radio_buttons,2", "");
         MouseRecorder.field761 = class221.getSprite(var1, "options_radio_buttons,6", "");
         class219.field2680 = class89.field1305.originalWidth;
         BoundingBox3DDrawMode.field253 = class89.field1305.height;
         UnitPriceComparator.field300 = new int[256];

         int var12;
         for(var12 = 0; var12 < 64; ++var12) {
            UnitPriceComparator.field300[var12] = var12 * 262144;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            UnitPriceComparator.field300[var12 + 64] = var12 * 1024 + 16711680;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            UnitPriceComparator.field300[var12 + 128] = var12 * 4 + 16776960;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            UnitPriceComparator.field300[var12 + 192] = 16777215;
         }

         class238.field3223 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            class238.field3223[var12] = var12 * 1024;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class238.field3223[var12 + 64] = var12 * 4 + 65280;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class238.field3223[var12 + 128] = var12 * 262144 + 65535;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class238.field3223[var12 + 192] = 16777215;
         }

         class239.field3236 = new int[256];

         for(var12 = 0; var12 < 64; ++var12) {
            class239.field3236[var12] = var12 * 4;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class239.field3236[var12 + 64] = var12 * 262144 + 255;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class239.field3236[var12 + 128] = var12 * 1024 + 16711935;
         }

         for(var12 = 0; var12 < 64; ++var12) {
            class239.field3236[var12 + 192] = 16777215;
         }

         TotalQuantityComparator.field284 = new int[256];
         ScriptState.field708 = new int['耀'];
         class94.field1404 = new int['耀'];
         class33.method360((IndexedSprite)null);
         NetWriter.field1440 = new int['耀'];
         Client.field1080 = new int['耀'];
         if(var2) {
            class89.username = "";
            class89.password = "";
         }

         Ignore.field3689 = 0;
         Client.field1032 = "";
         class89.field1329 = true;
         class89.worldSelectShown = false;
         if(!class221.preferences.muted) {
            IndexData var15 = class148.indexTrack1;
            var7 = var15.getFile("scape main");
            var8 = var15.getChild(var7, "");
            class214.field2596 = 1;
            Item.field1369 = var15;
            GZipDecompressor.field2420 = var7;
            class186.field2505 = var8;
            class214.field2597 = 255;
            class214.field2594 = false;
            class85.field1268 = 2;
         } else {
            class214.field2596 = 1;
            Item.field1369 = null;
            GZipDecompressor.field2420 = -1;
            class186.field2505 = -1;
            class214.field2597 = 0;
            class214.field2594 = false;
            class85.field1268 = 2;
         }

         class31.sendConInfo(false);
         class89.field1320 = true;
         class89.field1301 = (WorldMapType1.canvasWidth - 765) / 2;
         class89.loginWindowX = class89.field1301 + 202;
         class89.field1307 = class89.loginWindowX + 180;
         class89.field1316.method5534(class89.field1301, 0);
         class295.field3780.method5534(class89.field1301 + 382, 0);
         class7.logoSprite.method5504(class89.field1301 + 382 - class7.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "-215233545"
   )
   public static String method3622(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var0 < 0) {
            return Integer.toString(var0, var1);
         } else {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = '+';

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(var8 + 87);
               } else {
                  var5[var6] = (char)(var8 + 48);
               }
            }

            return new String(var5);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "2094194181"
   )
   public static int method3623(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
