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
      return Long.valueOf(var1.readLong());
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Long;Lgr;I)V",
      garbageValue = "1518625016"
   )
   void method21(Long var1, Buffer var2) {
      var2.writeLong(var1.longValue());
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lir;Lir;ZII)V",
      garbageValue = "-1535318699"
   )
   static void method27(AbstractIndexCache var0, AbstractIndexCache var1, boolean var2, int var3) {
      if(Login.__cu_f) {
         if(var3 == 4) {
            Login.loginIndex = 4;
         }

      } else {
         Login.loginIndex = var3;
         Rasterizer2D.Rasterizer2D_clear();
         byte[] var4 = var0.takeRecordByNames("title.jpg", "");
         Login.__cu_g = class27.method438(var4);
         Fonts.__kz_l = Login.__cu_g.copy();
         if((Client.worldProperties & 536870912) != 0) {
            WorldMapSectionType.__h_e = MenuAction.method2025(var1, "logo_deadman_mode", "");
         } else {
            WorldMapSectionType.__h_e = MenuAction.method2025(var1, "logo", "");
         }

         Login.__cu_o = MenuAction.method2025(var1, "titlebox", "");
         IndexCacheLoader.__bd_u = MenuAction.method2025(var1, "titlebutton", "");
         int var6 = var1.getArchiveId("runes");
         int var7 = var1.getRecordId(var6, "");
         IndexedSprite[] var8;
         if(!SpriteMask.method4392(var1, var6, var7)) {
            var8 = null;
         } else {
            var8 = WorldMapLabel.method444();
         }

         WorldMapEvent.__ap_w = var8;
         var7 = var1.getArchiveId("title_mute");
         int var10 = var1.getRecordId(var7, "");
         IndexedSprite[] var9;
         if(!SpriteMask.method4392(var1, var7, var10)) {
            var9 = null;
         } else {
            var9 = WorldMapLabel.method444();
         }

         KeyHandler.__an_x = var9;
         Login.__cu_d = MenuAction.method2025(var1, "options_radio_buttons,0", "");
         GraphicsObject.__bw_k = MenuAction.method2025(var1, "options_radio_buttons,4", "");
         class308.__kw_n = MenuAction.method2025(var1, "options_radio_buttons,2", "");
         KeyHandler.__an_i = MenuAction.method2025(var1, "options_radio_buttons,6", "");
         class168.__fs_au = Login.__cu_d.subWidth;
         GroundItemPile.__dr_ao = Login.__cu_d.subHeight;
         class16.field85 = new class72(WorldMapEvent.__ap_w);
         if(var2) {
            Login.Login_username = "";
            Login.Login_password = "";
         }

         class13.__i_af = 0;
         Login.otp = "";
         Login.__cu_ba = true;
         Login.__cu_bk = false;
         if(!ReflectionCheck.clientPreferences.titleMusicDisabled) {
            Canvas.method858(2, UserComparator3.indexCache6, "scape main", "", 255, false);
         } else {
            AbstractSocket.method3488(2);
         }

         UserComparator9.method3343(false);
         Login.__cu_f = true;
         Login.__cu_q = (SoundCache.canvasWidth - 765) / 2;
         Login.__cu_y = Login.__cu_q + 202;
         Varps.__hv_h = Login.__cu_y + 180;
         Login.__cu_g.drawAt(Login.__cu_q, 0);
         Fonts.__kz_l.drawAt(Login.__cu_q + 382, 0);
         WorldMapSectionType.__h_e.__q_496(Login.__cu_q + 382 - WorldMapSectionType.__h_e.subWidth / 2, 18);
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
      if(!SpriteMask.method4392(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = UserComparator9.method3344();
      }

      return var5;
   }
}
