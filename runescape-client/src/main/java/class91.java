import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class91 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1725622375
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 819546193
   )
   static int field1435;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1900117637
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("m")
   static int[] field1434;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1612640467
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 66431987
   )
   static int field1442;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1899692103
   )
   static int field1448;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -2081998777
   )
   static int field1441;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1444721367
   )
   static int field1458;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1889412075
   )
   static int field1446;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 541534899
   )
   static int field1450;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -56752163
   )
   @Export("loadingBarPercentage")
   static int loadingBarPercentage;
   @ObfuscatedName("ac")
   @Export("loadingText")
   static String loadingText;
   @ObfuscatedName("by")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("aj")
   static String field1451;
   @ObfuscatedName("ay")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("av")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("ao")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("aw")
   @Export(
      value = "username",
      setter = true
   )
   static String username;
   @ObfuscatedName("ah")
   @Export("password")
   static String password;
   @ObfuscatedName("an")
   static boolean field1457;
   @ObfuscatedName("au")
   static boolean field1438;
   @ObfuscatedName("bp")
   static boolean field1459;
   @ObfuscatedName("bc")
   static boolean field1447;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1111728549
   )
   static int field1461;
   @ObfuscatedName("i")
   static boolean field1443;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 404098227
   )
   static int field1465;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static IndexedSprite field1464;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   static IndexedSprite[] field1437;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   @Export("titlemuteSprite")
   static IndexedSprite[] titlemuteSprite;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljx;"
   )
   static IndexedSprite field1439;

   static {
      field1435 = 0;
      loginWindowX = field1435 + 202;
      field1434 = new int[256];
      field1442 = 0;
      field1448 = 0;
      field1441 = 0;
      field1458 = 0;
      field1446 = 0;
      field1450 = 0;
      loadingBarPercentage = 10;
      loadingText = "";
      loginIndex = 0;
      field1451 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      password = "";
      field1457 = false;
      field1438 = false;
      field1459 = false;
      field1447 = true;
      field1461 = 0;
      worldSelectShown = false;
      field1465 = -1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lii;Lii;ZII)V",
      garbageValue = "1558678652"
   )
   static void method1757(IndexDataBase var0, IndexDataBase var1, boolean var2, int var3) {
      if(field1443) {
         if(var3 == 4) {
            loginIndex = 4;
         }

      } else {
         loginIndex = var3;
         Rasterizer2D.reset();
         byte[] var4 = var0.method4154("title.jpg", "");
         class19.field336 = class22.method186(var4);
         class88.field1405 = class19.field336.method5070();
         if((Client.flags & 536870912) != 0) {
            class43.logoSprite = Client.getSprite(var1, "logo_deadman_mode", "");
         } else {
            class43.logoSprite = Client.getSprite(var1, "logo", "");
         }

         field1464 = Client.getSprite(var1, "titlebox", "");
         class17.field317 = Client.getSprite(var1, "titlebutton", "");
         field1437 = class139.method2909(var1, "runes", "");
         titlemuteSprite = class139.method2909(var1, "title_mute", "");
         class262.field3624 = Client.getSprite(var1, "options_radio_buttons,0", "");
         class27.field409 = Client.getSprite(var1, "options_radio_buttons,4", "");
         TextureProvider.field1790 = Client.getSprite(var1, "options_radio_buttons,2", "");
         field1439 = Client.getSprite(var1, "options_radio_buttons,6", "");
         class86.field1391 = class262.field3624.originalWidth;
         class29.field433 = class262.field3624.height;
         NPC.field1379 = new int[256];

         int var5;
         for(var5 = 0; var5 < 64; ++var5) {
            NPC.field1379[var5] = var5 * 262144;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            NPC.field1379[var5 + 64] = var5 * 1024 + 16711680;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            NPC.field1379[var5 + 128] = var5 * 4 + 16776960;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            NPC.field1379[var5 + 192] = 16777215;
         }

         class223.field2846 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            class223.field2846[var5] = var5 * 1024;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class223.field2846[var5 + 64] = var5 * 4 + '\uff00';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class223.field2846[var5 + 128] = var5 * 262144 + '\uffff';
         }

         for(var5 = 0; var5 < 64; ++var5) {
            class223.field2846[var5 + 192] = 16777215;
         }

         WorldMapType2.field532 = new int[256];

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapType2.field532[var5] = var5 * 4;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapType2.field532[var5 + 64] = var5 * 262144 + 255;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapType2.field532[var5 + 128] = var5 * 1024 + 16711935;
         }

         for(var5 = 0; var5 < 64; ++var5) {
            WorldMapType2.field532[var5 + 192] = 16777215;
         }

         class81.field1340 = new int[256];
         class81.field1341 = new int['耀'];
         class19.field335 = new int['耀'];
         SoundTask.method2080((IndexedSprite)null);
         Coordinates.field2615 = new int['耀'];
         class5.field37 = new int['耀'];
         if(var2) {
            username = "";
            password = "";
         }

         GroundObject.field1875 = 0;
         class13.field282 = "";
         field1447 = true;
         worldSelectShown = false;
         if(!Buffer.preferences.muted) {
            IndexData var8 = class45.indexTrack1;
            int var6 = var8.getFile("scape main");
            int var7 = var8.getChild(var6, "");
            class46.method736(2, var8, var6, var7, 255, false);
         } else {
            class170.method3216(2);
         }

         class18.sendConInfo(false);
         field1443 = true;
         field1435 = (canvasWidth - 765) / 2;
         loginWindowX = field1435 + 202;
         Ignore.field874 = loginWindowX + 180;
         class19.field336.method5017(field1435, 0);
         class88.field1405.method5017(field1435 + 382, 0);
         class43.logoSprite.method4983(field1435 + 382 - class43.logoSprite.originalWidth / 2, 18);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1227846994"
   )
   public static void method1761(int var0) {
      MouseInput.mouseIdleTicks = var0;
   }
}
