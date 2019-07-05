import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
final class class2 implements class0 {
   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache14")
   static IndexCache indexCache14;
   @ObfuscatedName("ee")
   @ObfuscatedGetter(
      intValue = -753026759
   )
   @Export("port1")
   static int port1;
   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "Lkk;"
   )
   @Export("fontBold12")
   static Font fontBold12;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;Lgr;I)V",
      garbageValue = "-223205903"
   )
   public void vmethod44(Object var1, Buffer var2) {
      this.method21((Long)var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;I)Ljava/lang/Object;",
      garbageValue = "704451908"
   )
   public Object vmethod46(Buffer var1) {
      return var1.readLong();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Long;Lgr;I)V",
      garbageValue = "1518625016"
   )
   void method21(Long var1, Buffer var2) {
      var2.writeLong(var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;ZII)V",
      garbageValue = "-1535318699"
   )
   static void method27(AbstractIndexCache var0, AbstractIndexCache var1, boolean var2, int var3) {
      if (Login.field465) {
         if (var3 == 4) {
            Login.loginIndex = 4;
         }
      } else {
         Login.loginIndex = var3;
         Rasterizer2D.Rasterizer2D_clear();
         byte[] var4 = var0.takeRecordByNames("title.jpg", "");
         Login.leftTitleSprite = class27.convertJpgToSprite(var4);
         Fonts.rightTitleSprite = Login.leftTitleSprite.copy();
         if ((Client.worldProperties & 536870912) != 0) {
            WorldMapSectionType.logoSprite = MenuAction.loadIndexedSpriteByName(var1, "logo_deadman_mode", "");
         } else {
            WorldMapSectionType.logoSprite = MenuAction.loadIndexedSpriteByName(var1, "logo", "");
         }

         Login.titleboxSprite = MenuAction.loadIndexedSpriteByName(var1, "titlebox", "");
         IndexCacheLoader.titlebuttonSprite = MenuAction.loadIndexedSpriteByName(var1, "titlebutton", "");
         int var5 = var1.getArchiveId("runes");
         int var6 = var1.getRecordId(var5, "");
         IndexedSprite[] var7;
         if (!SpriteMask.loadSprite(var1, var5, var6)) {
            var7 = null;
         } else {
            var7 = WorldMapLabel.createIndexedSpriteArray();
         }

         WorldMapEvent.runesSprite = var7;
         var6 = var1.getArchiveId("title_mute");
         int var8 = var1.getRecordId(var6, "");
         IndexedSprite[] var9;
         if (!SpriteMask.loadSprite(var1, var6, var8)) {
            var9 = null;
         } else {
            var9 = WorldMapLabel.createIndexedSpriteArray();
         }

         KeyHandler.title_muteSprite = var9;
         Login.options_buttons_0Sprite = MenuAction.loadIndexedSpriteByName(var1, "options_radio_buttons,0", "");
         GraphicsObject.options_buttons_4Sprite = MenuAction.loadIndexedSpriteByName(var1, "options_radio_buttons,4", "");
         class308.options_buttons_2Sprite = MenuAction.loadIndexedSpriteByName(var1, "options_radio_buttons,2", "");
         KeyHandler.options_buttons_6Sprite = MenuAction.loadIndexedSpriteByName(var1, "options_radio_buttons,6", "");
         class168.optionButtonSpriteSubWidth = Login.options_buttons_0Sprite.subWidth;
         GroundItemPile.optionButtonSpriteSubHeight = Login.options_buttons_0Sprite.subHeight;
         class16.loginScreenRunesAnimation = new LoginScreenAnimation(WorldMapEvent.runesSprite);
         if (var2) {
            Login.Login_username = "";
            Login.Login_password = "";
         }

         class13.otpInt = 0;
         Login.otp = "";
         Login.field470 = true;
         Login.worldSelectOpen = false;
         if (!ReflectionCheck.clientPreferences.titleMusicDisabled) {
            Canvas.method858(2, UserComparator3.indexCache6, "scape main", "", 255, false);
         } else {
            AbstractSocket.method3488(2);
         }

         UserComparator9.method3343(false);
         Login.field465 = true;
         Login.xPadding = (SoundCache.canvasWidth - 765) / 2;
         Login.loginBoxX = Login.xPadding + 202;
         Varps.loginBoxCenter = Login.loginBoxX + 180;
         Login.leftTitleSprite.drawAt(Login.xPadding, 0);
         Fonts.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
         WorldMapSectionType.logoSprite.drawAt(Login.xPadding + 382 - WorldMapSectionType.logoSprite.subWidth / 2, 18);
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lir;Ljava/lang/String;Ljava/lang/String;B)[Lln;",
      garbageValue = "0"
   )
   public static Sprite[] method20(AbstractIndexCache var0, String var1, String var2) {
      int var3 = var0.getArchiveId(var1);
      int var4 = var0.getRecordId(var3, var2);
      Sprite[] var5;
      if (!SpriteMask.loadSprite(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = UserComparator9.createSpriteArray();
      }

      return var5;
   }
}
