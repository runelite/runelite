import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
public class class91 {
   @ObfuscatedName("e")
   @Export("rsaKeyExponent")
   static final BigInteger rsaKeyExponent;
   @ObfuscatedName("n")
   @Export("rsaKeyModulus")
   static final BigInteger rsaKeyModulus;
   @ObfuscatedName("lu")
   @ObfuscatedGetter(
      intValue = -1641675405
   )
   static int field1399;
   @ObfuscatedName("y")
   @Export("underlayIds")
   static byte[][][] underlayIds;

   static {
      rsaKeyExponent = new BigInteger("10001", 16);
      rsaKeyModulus = new BigInteger("977009d609de66b360e938bb4274256cdac53d2fe3150a87bf581bbdcc9cc23062ea373f0c35af123c40b90c2a51e7d45b8239b7d3dfb71b957449d3a93deda11c384cd53141403478542b185690960a0a72ee91bb25f99be3d2dd00b9778089a901c4229a9cb5043633ea8affffebd2087cb01cb8db72ff2c59f41866b3dda5", 16);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1601987672"
   )
   static void method1739() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.field639[186] = 57;
         KeyFocusListener.field639[187] = 27;
         KeyFocusListener.field639[188] = 71;
         KeyFocusListener.field639[189] = 26;
         KeyFocusListener.field639[190] = 72;
         KeyFocusListener.field639[191] = 73;
         KeyFocusListener.field639[192] = 58;
         KeyFocusListener.field639[219] = 42;
         KeyFocusListener.field639[220] = 74;
         KeyFocusListener.field639[221] = 43;
         KeyFocusListener.field639[222] = 59;
         KeyFocusListener.field639[223] = 28;
      } else {
         KeyFocusListener.field639[44] = 71;
         KeyFocusListener.field639[45] = 26;
         KeyFocusListener.field639[46] = 72;
         KeyFocusListener.field639[47] = 73;
         KeyFocusListener.field639[59] = 57;
         KeyFocusListener.field639[61] = 27;
         KeyFocusListener.field639[91] = 42;
         KeyFocusListener.field639[92] = 74;
         KeyFocusListener.field639[93] = 43;
         KeyFocusListener.field639[192] = 28;
         KeyFocusListener.field639[222] = 58;
         KeyFocusListener.field639[520] = 59;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-1675011964"
   )
   public static byte method1737(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;ZIB)V",
      garbageValue = "108"
   )
   static void method1738(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(class93.field1451) {
         if(var3 == 4) {
            class93.loginIndex = 4;
         }

      } else {
         class93.loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.method4143("title.jpg", "");
         BufferedImage var6 = null;

         SpritePixels var5;
         int var7;
         int var8;
         label160: {
            try {
               var6 = ImageIO.read(new ByteArrayInputStream(var4));
               var7 = var6.getWidth();
               var8 = var6.getHeight();
               int[] var9 = new int[var7 * var8];
               PixelGrabber var10 = new PixelGrabber(var6, 0, 0, var7, var8, var9, 0, var7);
               var10.grabPixels();
               var5 = new SpritePixels(var9, var7, var8);
               break label160;
            } catch (IOException var13) {
               ;
            } catch (InterruptedException var14) {
               ;
            }

            var5 = new SpritePixels(0, 0);
         }

         class93.field1419 = var5;
         class83.field1322 = class93.field1419.method5168();
         if((Client.flags & 536870912) != 0) {
            Ignore.logoSprite = class117.getSprite(var1, "logo_deadman_mode", "");
         } else {
            Ignore.logoSprite = class117.getSprite(var1, "logo", "");
         }

         class93.field1420 = class117.getSprite(var1, "titlebox", "");
         class93.field1421 = class117.getSprite(var1, "titlebutton", "");
         class46.field589 = class10.method55(var1, "runes", "");
         class93.titlemuteSprite = class10.method55(var1, "title_mute", "");
         class203.field2476 = class117.getSprite(var1, "options_radio_buttons,0", "");
         class83.field1324 = class117.getSprite(var1, "options_radio_buttons,2", "");
         class13.field276 = new int[256];

         int var11;
         for(var11 = 0; var11 < 64; ++var11) {
            class13.field276[var11] = var11 * 262144;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class13.field276[var11 + 64] = 16711680 + var11 * 1024;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class13.field276[var11 + 128] = var11 * 4 + 16776960;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class13.field276[var11 + 192] = 16777215;
         }

         class93.field1441 = new int[256];

         for(var11 = 0; var11 < 64; ++var11) {
            class93.field1441[var11] = var11 * 1024;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class93.field1441[var11 + 64] = var11 * 4 + '\uff00';
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class93.field1441[var11 + 128] = '\uffff' + var11 * 262144;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class93.field1441[var11 + 192] = 16777215;
         }

         class46.field590 = new int[256];

         for(var11 = 0; var11 < 64; ++var11) {
            class46.field590[var11] = var11 * 4;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class46.field590[var11 + 64] = var11 * 262144 + 255;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class46.field590[var11 + 128] = var11 * 1024 + 16711935;
         }

         for(var11 = 0; var11 < 64; ++var11) {
            class46.field590[var11 + 192] = 16777215;
         }

         class88.field1365 = new int[256];
         class18.field316 = new int['耀'];
         class97.field1503 = new int['耀'];
         Script.method1891((IndexedSprite)null);
         ScriptEvent.field847 = new int['耀'];
         class88.field1368 = new int['耀'];
         if(var2) {
            class93.username = "";
            class93.password = "";
         }

         class47.authCodeForLogin = 0;
         class47.authCode = "";
         class93.field1443 = true;
         class93.worldSelectShown = false;
         if(!MilliTimer.preferences.muted) {
            IndexData var15 = class244.indexTrack1;
            var7 = var15.getFile("scape main");
            var8 = var15.getChild(var7, "");
            class204.field2487 = 1;
            class204.field2488 = var15;
            class12.field273 = var7;
            class204.field2489 = var8;
            class204.field2490 = 255;
            class33.field472 = false;
            class204.field2491 = 2;
         } else {
            class204.field2487 = 1;
            class204.field2488 = null;
            class12.field273 = -1;
            class204.field2489 = -1;
            class204.field2490 = 0;
            class33.field472 = false;
            class204.field2491 = 2;
         }

         class269.sendConInfo(false);
         class93.field1451 = true;
         class93.field1424 = (NPC.canvasWidth - 765) / 2;
         class93.loginWindowX = class93.field1424 + 202;
         class93.field1419.method5098(class93.field1424, 0);
         class83.field1322.method5098(class93.field1424 + 382, 0);
         Ignore.logoSprite.method5068(class93.field1424 + 382 - Ignore.logoSprite.originalWidth / 2, 18);
      }
   }
}
