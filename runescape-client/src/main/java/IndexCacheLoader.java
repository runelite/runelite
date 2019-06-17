import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
@Implements("IndexCacheLoader")
public class IndexCacheLoader {
   @ObfuscatedName("pf")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   static class310 field512;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   @Export("__bd_u")
   static IndexedSprite __bd_u;
   @ObfuscatedName("x")
   @Export("__bd_x")
   public static short[][] __bd_x;
   @ObfuscatedName("er")
   @ObfuscatedGetter(
      intValue = 636454135
   )
   @Export("__bd_er")
   static int __bd_er;
   @ObfuscatedName("gw")
   @Export("regionMapArchiveIds")
   static int[] regionMapArchiveIds;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache")
   final IndexCache indexCache;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1459455501
   )
   @Export("__q")
   final int __q;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 782003089
   )
   @Export("__w")
   int __w;

   @ObfuscatedSignature(
      signature = "(Lit;Ljava/lang/String;)V"
   )
   IndexCacheLoader(IndexCache var1, String var2) {
      this.__w = 0;
      this.indexCache = var1;
      this.__q = var1.__t_397();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1352221725"
   )
   @Export("__m_122")
   boolean __m_122() {
      this.__w = 0;

      for(int var1 = 0; var1 < this.__q; ++var1) {
         if(!this.indexCache.__df_408(var1) || this.indexCache.__dn_407(var1)) {
            ++this.__w;
         }
      }

      return this.__w >= this.__q;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lkk;Lkk;Lkk;I)V",
      garbageValue = "839403460"
   )
   @Export("drawTitle")
   static void drawTitle(Font var0, Font var1, Font var2) {
      Login.__cu_q = (SoundCache.canvasWidth - 765) / 2;
      Login.__cu_y = Login.__cu_q + 202;
      Varps.__hv_h = Login.__cu_y + 180;
      int var3;
      int var4;
      int var5;
      byte var6;
      int var7;
      int var8;
      int var9;
      int var10;
      boolean var20;
      if(Login.__cu_bk) {
         if(class30.__ar_bd == null) {
            class30.__ar_bd = class2.method20(WorldMapSection3.indexCache8, "sl_back", "");
         }

         IndexCache var11;
         int var12;
         int var13;
         IndexedSprite[] var14;
         if(Frames.__en_bc == null) {
            var11 = WorldMapSection3.indexCache8;
            var13 = var11.getArchiveId("sl_flags");
            var12 = var11.getRecordId(var13, "");
            if(!SpriteMask.method4392(var11, var13, var12)) {
               var14 = null;
            } else {
               var14 = WorldMapLabel.method444();
            }

            Frames.__en_bc = var14;
         }

         if(AttackOption.__cj_bo == null) {
            var11 = WorldMapSection3.indexCache8;
            var13 = var11.getArchiveId("sl_arrows");
            var12 = var11.getRecordId(var13, "");
            if(!SpriteMask.method4392(var11, var13, var12)) {
               var14 = null;
            } else {
               var14 = WorldMapLabel.method444();
            }

            AttackOption.__cj_bo = var14;
         }

         if(UrlRequest.__ey_bx == null) {
            var11 = WorldMapSection3.indexCache8;
            var13 = var11.getArchiveId("sl_stars");
            var12 = var11.getRecordId(var13, "");
            if(!SpriteMask.method4392(var11, var13, var12)) {
               var14 = null;
            } else {
               var14 = WorldMapLabel.method444();
            }

            UrlRequest.__ey_bx = var14;
         }

         if(SecureRandomFuture.__cn_bu == null) {
            SecureRandomFuture.__cn_bu = MenuAction.method2025(WorldMapSection3.indexCache8, "leftarrow", "");
         }

         if(NetSocket.__fb_bm == null) {
            NetSocket.__fb_bm = MenuAction.method2025(WorldMapSection3.indexCache8, "rightarrow", "");
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(Login.__cu_q, 23, 765, 480, 0);
         Rasterizer2D.drawGradient(Login.__cu_q, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.drawGradient(Login.__cu_q + 125, 0, 640, 23, 5197647, 2697513);
         var0.drawCentered("Select a world", Login.__cu_q + 62, 15, 0, -1);
         if(UrlRequest.__ey_bx != null) {
            UrlRequest.__ey_bx[1].__q_496(Login.__cu_q + 140, 1);
            var1.draw("Members only world", Login.__cu_q + 152, 10, 16777215, -1);
            UrlRequest.__ey_bx[0].__q_496(Login.__cu_q + 140, 12);
            var1.draw("Free world", Login.__cu_q + 152, 21, 16777215, -1);
         }

         if(AttackOption.__cj_bo != null) {
            var10 = Login.__cu_q + 280;
            if(World.__bt_e[0] == 0 && World.__bt_l[0] == 0) {
               AttackOption.__cj_bo[2].__q_496(var10, 4);
            } else {
               AttackOption.__cj_bo[0].__q_496(var10, 4);
            }

            if(World.__bt_e[0] == 0 && World.__bt_l[0] == 1) {
               AttackOption.__cj_bo[3].__q_496(var10 + 15, 4);
            } else {
               AttackOption.__cj_bo[1].__q_496(var10 + 15, 4);
            }

            var0.draw("World", var10 + 32, 17, 16777215, -1);
            var7 = Login.__cu_q + 390;
            if(World.__bt_e[0] == 1 && World.__bt_l[0] == 0) {
               AttackOption.__cj_bo[2].__q_496(var7, 4);
            } else {
               AttackOption.__cj_bo[0].__q_496(var7, 4);
            }

            if(World.__bt_e[0] == 1 && World.__bt_l[0] == 1) {
               AttackOption.__cj_bo[3].__q_496(var7 + 15, 4);
            } else {
               AttackOption.__cj_bo[1].__q_496(var7 + 15, 4);
            }

            var0.draw("Players", var7 + 32, 17, 16777215, -1);
            var13 = Login.__cu_q + 500;
            if(World.__bt_e[0] == 2 && World.__bt_l[0] == 0) {
               AttackOption.__cj_bo[2].__q_496(var13, 4);
            } else {
               AttackOption.__cj_bo[0].__q_496(var13, 4);
            }

            if(World.__bt_e[0] == 2 && World.__bt_l[0] == 1) {
               AttackOption.__cj_bo[3].__q_496(var13 + 15, 4);
            } else {
               AttackOption.__cj_bo[1].__q_496(var13 + 15, 4);
            }

            var0.draw("Location", var13 + 32, 17, 16777215, -1);
            var12 = Login.__cu_q + 610;
            if(World.__bt_e[0] == 3 && World.__bt_l[0] == 0) {
               AttackOption.__cj_bo[2].__q_496(var12, 4);
            } else {
               AttackOption.__cj_bo[0].__q_496(var12, 4);
            }

            if(World.__bt_e[0] == 3 && World.__bt_l[0] == 1) {
               AttackOption.__cj_bo[3].__q_496(var12 + 15, 4);
            } else {
               AttackOption.__cj_bo[1].__q_496(var12 + 15, 4);
            }

            var0.draw("Type", var12 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.Rasterizer2D_fillRectangle(Login.__cu_q + 708, 4, 50, 16, 0);
         var1.drawCentered("Cancel", Login.__cu_q + 708 + 25, 16, 16777215, -1);
         Login.__cu_bl = -1;
         if(class30.__ar_bd != null) {
            var6 = 88;
            byte var15 = 19;
            var13 = 765 / (var6 + 1) - 1;
            var12 = 480 / (var15 + 1);

            while(true) {
               var8 = var12;
               var9 = var13;
               if(var12 * (var13 - 1) >= World.worldsCount) {
                  --var13;
               }

               if(var13 * (var12 - 1) >= World.worldsCount) {
                  --var12;
               }

               if(var13 * (var12 - 1) >= World.worldsCount) {
                  --var12;
               }

               if(var12 == var8 && var13 == var9) {
                  var8 = (765 - var6 * var13) / (var13 + 1);
                  if(var8 > 5) {
                     var8 = 5;
                  }

                  var9 = (480 - var15 * var12) / (var12 + 1);
                  if(var9 > 5) {
                     var9 = 5;
                  }

                  var3 = (765 - var13 * var6 - var8 * (var13 - 1)) / 2;
                  int var16 = (480 - var12 * var15 - var9 * (var12 - 1)) / 2;
                  var4 = (var12 + World.worldsCount - 1) / var12;
                  Login.__cu_bj = var4 - var13;
                  if(SecureRandomFuture.__cn_bu != null && Login.__cu_br > 0) {
                     SecureRandomFuture.__cn_bu.__q_496(8, Huffman.canvasHeight / 2 - SecureRandomFuture.__cn_bu.subHeight / 2);
                  }

                  if(NetSocket.__fb_bm != null && Login.__cu_br < Login.__cu_bj) {
                     NetSocket.__fb_bm.__q_496(SoundCache.canvasWidth - NetSocket.__fb_bm.subWidth - 8, Huffman.canvasHeight / 2 - NetSocket.__fb_bm.subHeight / 2);
                  }

                  int var17 = var16 + 23;
                  int var18 = var3 + Login.__cu_q;
                  int var19 = 0;
                  var20 = false;
                  int var21 = Login.__cu_br;

                  int var22;
                  for(var22 = var12 * var21; var22 < World.worldsCount && var21 - Login.__cu_br < var13; ++var22) {
                     World var23 = ItemContainer.worlds[var22];
                     boolean var24 = true;
                     String var25 = Integer.toString(var23.population);
                     if(var23.population == -1) {
                        var25 = "OFF";
                        var24 = false;
                     } else if(var23.population > 1980) {
                        var25 = "FULL";
                        var24 = false;
                     }

                     int var26 = 0;
                     byte var27;
                     if(var23.__j_149()) {
                        if(var23.__e_144()) {
                           var27 = 7;
                        } else {
                           var27 = 6;
                        }
                     } else if(var23.__z_148()) {
                        var26 = 16711680;
                        if(var23.__e_144()) {
                           var27 = 5;
                        } else {
                           var27 = 4;
                        }
                     } else if(var23.__d_146()) {
                        if(var23.__e_144()) {
                           var27 = 3;
                        } else {
                           var27 = 2;
                        }
                     } else if(var23.__e_144()) {
                        var27 = 1;
                     } else {
                        var27 = 0;
                     }

                     if(MouseHandler.MouseHandler_x >= var18 && MouseHandler.MouseHandler_y >= var17 && MouseHandler.MouseHandler_x < var18 + var6 && MouseHandler.MouseHandler_y < var15 + var17 && var24) {
                        Login.__cu_bl = var22;
                        class30.__ar_bd[var27].__t_507(var18, var17, 128, 16777215);
                        var20 = true;
                     } else {
                        class30.__ar_bd[var27].drawAt(var18, var17);
                     }

                     if(Frames.__en_bc != null) {
                        Frames.__en_bc[(var23.__e_144()?8:0) + var23.location].__q_496(var18 + 29, var17);
                     }

                     var0.drawCentered(Integer.toString(var23.id), var18 + 15, var15 / 2 + var17 + 5, var26, -1);
                     var1.drawCentered(var25, var18 + 60, var15 / 2 + var17 + 5, 268435455, -1);
                     var17 = var17 + var9 + var15;
                     ++var19;
                     if(var19 >= var12) {
                        var17 = var16 + 23;
                        var18 = var18 + var6 + var8;
                        var19 = 0;
                        ++var21;
                     }
                  }

                  if(var20) {
                     var22 = var1.stringWidth(ItemContainer.worlds[Login.__cu_bl].activity) + 6;
                     int var47 = var1.ascent + 8;
                     var5 = MouseHandler.MouseHandler_y + 25;
                     if(var47 + var5 > 480) {
                        var5 = MouseHandler.MouseHandler_y - 25 - var47;
                     }

                     Rasterizer2D.Rasterizer2D_fillRectangle(MouseHandler.MouseHandler_x - var22 / 2, var5, var22, var47, 16777120);
                     Rasterizer2D.Rasterizer2D_drawRectangle(MouseHandler.MouseHandler_x - var22 / 2, var5, var22, var47, 0);
                     var1.drawCentered(ItemContainer.worlds[Login.__cu_bl].activity, MouseHandler.MouseHandler_x, var5 + var1.ascent + 4, 0, -1);
                  }
                  break;
               }
            }
         }

         class197.rasterProvider.drawFull(0, 0);
      } else {
         Login.__cu_g.drawAt(Login.__cu_q, 0);
         Fonts.__kz_l.drawAt(Login.__cu_q + 382, 0);
         WorldMapSectionType.__h_e.__q_496(Login.__cu_q + 382 - WorldMapSectionType.__h_e.subWidth / 2, 18);
         if(Client.gameState == 0 || Client.gameState == 5) {
            var6 = 20;
            var0.drawCentered("RuneScape is loading - please wait...", Login.__cu_y + 180, 245 - var6, 16777215, -1);
            var7 = 253 - var6;
            Rasterizer2D.Rasterizer2D_drawRectangle(Login.__cu_y + 180 - 152, var7, 304, 34, 9179409);
            Rasterizer2D.Rasterizer2D_drawRectangle(Login.__cu_y + 180 - 151, var7 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(Login.__cu_y + 180 - 150, var7 + 2, Login.Login_loadingPercent * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(Login.__cu_y + 180 - 150 + Login.Login_loadingPercent * 3, var7 + 2, 300 - Login.Login_loadingPercent * 3, 30, 0);
            var0.drawCentered(Login.Login_loadingText, Login.__cu_y + 180, 276 - var6, 16777215, -1);
         }

         String var28;
         String var29;
         String var30;
         String var31;
         short var32;
         String var33;
         short var34;
         if(Client.gameState == 20) {
            Login.__cu_o.__q_496(Login.__cu_y + 180 - Login.__cu_o.subWidth / 2, 271 - Login.__cu_o.subHeight / 2);
            var32 = 201;
            var0.drawCentered(Login.Login_response1, Login.__cu_y + 180, var32, 16776960, 0);
            var10 = var32 + 15;
            var0.drawCentered(Login.Login_response2, Login.__cu_y + 180, var10, 16776960, 0);
            var10 += 15;
            var0.drawCentered(Login.Login_response3, Login.__cu_y + 180, var10, 16776960, 0);
            var10 += 15;
            var10 += 7;
            if(Login.loginIndex != 4) {
               var0.draw("Login: ", Login.__cu_y + 180 - 110, var10, 16777215, 0);
               var34 = 200;
               if(ReflectionCheck.clientPreferences.hideUsername) {
                  var29 = Login.Login_username;
                  var28 = class168.method3450('*', var29.length());
                  var30 = var28;
               } else {
                  var30 = Login.Login_username;
               }

               for(var30 = var30; var0.stringWidth(var30) > var34; var30 = var30.substring(0, var30.length() - 1)) {
                  ;
               }

               var0.draw(AbstractFont.escapeBrackets(var30), Login.__cu_y + 180 - 70, var10, 16777215, 0);
               var10 += 15;
               var29 = "Password: ";
               var33 = Login.Login_password;
               var31 = class168.method3450('*', var33.length());
               var0.draw(var29 + var31, Login.__cu_y + 180 - 108, var10, 16777215, 0);
               var10 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            Login.__cu_o.__q_496(Login.__cu_y, 171);
            short var35;
            if(Login.loginIndex == 0) {
               var32 = 251;
               var0.drawCentered("Welcome to RuneScape", Login.__cu_y + 180, var32, 16776960, 0);
               var10 = var32 + 30;
               var7 = Login.__cu_y + 180 - 80;
               var35 = 291;
               __bd_u.__q_496(var7 - 73, var35 - 20);
               var0.drawLines("New User", var7 - 73, var35 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var7 = Login.__cu_y + 180 + 80;
               __bd_u.__q_496(var7 - 73, var35 - 20);
               var0.drawLines("Existing User", var7 - 73, var35 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(Login.loginIndex == 1) {
               var0.drawCentered(Login.Login_response0, Login.__cu_y + 180, 201, 16776960, 0);
               var32 = 236;
               var0.drawCentered(Login.Login_response1, Login.__cu_y + 180, var32, 16777215, 0);
               var10 = var32 + 15;
               var0.drawCentered(Login.Login_response2, Login.__cu_y + 180, var10, 16777215, 0);
               var10 += 15;
               var0.drawCentered(Login.Login_response3, Login.__cu_y + 180, var10, 16777215, 0);
               var10 += 15;
               var7 = Login.__cu_y + 180 - 80;
               var35 = 321;
               __bd_u.__q_496(var7 - 73, var35 - 20);
               var0.drawCentered("Continue", var7, var35 + 5, 16777215, 0);
               var7 = Login.__cu_y + 180 + 80;
               __bd_u.__q_496(var7 - 73, var35 - 20);
               var0.drawCentered("Cancel", var7, var35 + 5, 16777215, 0);
            } else if(Login.loginIndex == 2) {
               var32 = 201;
               var0.drawCentered(Login.Login_response1, Varps.__hv_h, var32, 16776960, 0);
               var10 = var32 + 15;
               var0.drawCentered(Login.Login_response2, Varps.__hv_h, var10, 16776960, 0);
               var10 += 15;
               var0.drawCentered(Login.Login_response3, Varps.__hv_h, var10, 16776960, 0);
               var10 += 15;
               var10 += 7;
               var0.draw("Login: ", Varps.__hv_h - 110, var10, 16777215, 0);
               var34 = 200;
               if(ReflectionCheck.clientPreferences.hideUsername) {
                  var29 = Login.Login_username;
                  var28 = class168.method3450('*', var29.length());
                  var30 = var28;
               } else {
                  var30 = Login.Login_username;
               }

               for(var30 = var30; var0.stringWidth(var30) > var34; var30 = var30.substring(1)) {
                  ;
               }

               var0.draw(AbstractFont.escapeBrackets(var30) + (Login.currentLoginField == 0 & Client.cycle % 40 < 20?BufferedFile.colorStartTag(16776960) + "|":""), Varps.__hv_h - 70, var10, 16777215, 0);
               var10 += 15;
               var29 = "Password: ";
               var33 = Login.Login_password;
               var31 = class168.method3450('*', var33.length());
               var0.draw(var29 + var31 + (Login.currentLoginField == 1 & Client.cycle % 40 < 20?BufferedFile.colorStartTag(16776960) + "|":""), Varps.__hv_h - 108, var10, 16777215, 0);
               var10 += 15;
               var32 = 277;
               var4 = Varps.__hv_h + -117;
               boolean var40 = Client.Login_isUsernameRemembered;
               var20 = Login.__cu_aa;
               IndexedSprite var46 = var40?(var20?KeyHandler.__an_i:class308.__kw_n):(var20?GraphicsObject.__bw_k:Login.__cu_d);
               var46.__q_496(var4, var32);
               var4 = var4 + var46.subWidth + 5;
               var1.draw("Remember username", var4, var32 + 13, 16776960, 0);
               var4 = Varps.__hv_h + 24;
               boolean var44 = ReflectionCheck.clientPreferences.hideUsername;
               boolean var48 = Login.__cu_ax;
               IndexedSprite var49 = var44?(var48?KeyHandler.__an_i:class308.__kw_n):(var48?GraphicsObject.__bw_k:Login.__cu_d);
               var49.__q_496(var4, var32);
               var4 = var4 + var49.subWidth + 5;
               var1.draw("Hide username", var4, var32 + 13, 16776960, 0);
               var10 = var32 + 15;
               var5 = Varps.__hv_h - 80;
               short var50 = 321;
               __bd_u.__q_496(var5 - 73, var50 - 20);
               var0.drawCentered("Login", var5, var50 + 5, 16777215, 0);
               var5 = Varps.__hv_h + 80;
               __bd_u.__q_496(var5 - 73, var50 - 20);
               var0.drawCentered("Cancel", var5, var50 + 5, 16777215, 0);
               var32 = 357;
               switch(Login.__cu_ac) {
               case 2:
                  AttackOption.__cj_ay = "Having trouble logging in?";
                  break;
               default:
                  AttackOption.__cj_ay = "Can\'t login? Click here.";
               }

               TilePaint.__eb_ah = new Bounds(Varps.__hv_h, var32, var1.stringWidth(AttackOption.__cj_ay), 11);
               UrlRequester.__eo_ak = new Bounds(Varps.__hv_h, var32, var1.stringWidth("Still having trouble logging in?"), 11);
               var1.drawCentered(AttackOption.__cj_ay, Varps.__hv_h, var32, 16777215, 0);
            } else if(Login.loginIndex == 3) {
               var32 = 201;
               var0.drawCentered("Invalid credentials.", Login.__cu_y + 180, var32, 16776960, 0);
               var10 = var32 + 20;
               var1.drawCentered("For accounts created after 24th November 2010, please use your", Login.__cu_y + 180, var10, 16776960, 0);
               var10 += 15;
               var1.drawCentered("email address to login. Otherwise please login with your username.", Login.__cu_y + 180, var10, 16776960, 0);
               var10 += 15;
               var7 = Login.__cu_y + 180;
               var35 = 276;
               __bd_u.__q_496(var7 - 73, var35 - 20);
               var2.drawCentered("Try again", var7, var35 + 5, 16777215, 0);
               var7 = Login.__cu_y + 180;
               var35 = 326;
               __bd_u.__q_496(var7 - 73, var35 - 20);
               var2.drawCentered("Forgotten password?", var7, var35 + 5, 16777215, 0);
            } else {
               String var36;
               if(Login.loginIndex == 4) {
                  var0.drawCentered("Authenticator", Login.__cu_y + 180, 201, 16776960, 0);
                  var32 = 236;
                  var0.drawCentered(Login.Login_response1, Login.__cu_y + 180, var32, 16777215, 0);
                  var10 = var32 + 15;
                  var0.drawCentered(Login.Login_response2, Login.__cu_y + 180, var10, 16777215, 0);
                  var10 += 15;
                  var0.drawCentered(Login.Login_response3, Login.__cu_y + 180, var10, 16777215, 0);
                  var10 += 15;
                  var36 = "PIN: ";
                  var28 = Login.otp;
                  var30 = class168.method3450('*', var28.length());
                  var0.draw(var36 + var30 + (Client.cycle % 40 < 20?BufferedFile.colorStartTag(16776960) + "|":""), Login.__cu_y + 180 - 108, var10, 16777215, 0);
                  var10 -= 8;
                  var0.draw("Trust this computer", Login.__cu_y + 180 - 9, var10, 16776960, 0);
                  var10 += 15;
                  var0.draw("for 30 days: ", Login.__cu_y + 180 - 9, var10, 16776960, 0);
                  var9 = Login.__cu_y + 180 - 9 + var0.stringWidth("for 30 days: ") + 15;
                  var3 = var10 - var0.ascent;
                  IndexedSprite var43;
                  if(Login.__cu_ba) {
                     var43 = class308.__kw_n;
                  } else {
                     var43 = Login.__cu_d;
                  }

                  var43.__q_496(var9, var3);
                  var10 += 15;
                  var4 = Login.__cu_y + 180 - 80;
                  short var45 = 321;
                  __bd_u.__q_496(var4 - 73, var45 - 20);
                  var0.drawCentered("Continue", var4, var45 + 5, 16777215, 0);
                  var4 = Login.__cu_y + 180 + 80;
                  __bd_u.__q_496(var4 - 73, var45 - 20);
                  var0.drawCentered("Cancel", var4, var45 + 5, 16777215, 0);
                  var1.drawCentered("<u=ff>Can\'t Log In?</u>", Login.__cu_y + 180, var45 + 36, 255, 0);
               } else {
                  short var37;
                  if(Login.loginIndex != 5) {
                     if(Login.loginIndex == 6) {
                        var32 = 201;
                        var0.drawCentered(Login.Login_response1, Login.__cu_y + 180, var32, 16776960, 0);
                        var10 = var32 + 15;
                        var0.drawCentered(Login.Login_response2, Login.__cu_y + 180, var10, 16776960, 0);
                        var10 += 15;
                        var0.drawCentered(Login.Login_response3, Login.__cu_y + 180, var10, 16776960, 0);
                        var10 += 15;
                        var7 = Login.__cu_y + 180;
                        var35 = 321;
                        __bd_u.__q_496(var7 - 73, var35 - 20);
                        var0.drawCentered("Back", var7, var35 + 5, 16777215, 0);
                     } else if(Login.loginIndex == 7) {
                        var32 = 216;
                        var0.drawCentered("Your date of birth isn\'t set.", Login.__cu_y + 180, var32, 16776960, 0);
                        var10 = var32 + 15;
                        var2.drawCentered("Please verify your account status by", Login.__cu_y + 180, var10, 16776960, 0);
                        var10 += 15;
                        var2.drawCentered("setting your date of birth.", Login.__cu_y + 180, var10, 16776960, 0);
                        var10 += 15;
                        var7 = Login.__cu_y + 180 - 80;
                        var35 = 321;
                        __bd_u.__q_496(var7 - 73, var35 - 20);
                        var0.drawCentered("Set Date of Birth", var7, var35 + 5, 16777215, 0);
                        var7 = Login.__cu_y + 180 + 80;
                        __bd_u.__q_496(var7 - 73, var35 - 20);
                        var0.drawCentered("Back", var7, var35 + 5, 16777215, 0);
                     } else if(Login.loginIndex == 8) {
                        var32 = 216;
                        var0.drawCentered("Sorry, but your account is not eligible to play.", Login.__cu_y + 180, var32, 16776960, 0);
                        var10 = var32 + 15;
                        var2.drawCentered("For more information, please take a look at", Login.__cu_y + 180, var10, 16776960, 0);
                        var10 += 15;
                        var2.drawCentered("our privacy policy.", Login.__cu_y + 180, var10, 16776960, 0);
                        var10 += 15;
                        var7 = Login.__cu_y + 180 - 80;
                        var35 = 321;
                        __bd_u.__q_496(var7 - 73, var35 - 20);
                        var0.drawCentered("Privacy Policy", var7, var35 + 5, 16777215, 0);
                        var7 = Login.__cu_y + 180 + 80;
                        __bd_u.__q_496(var7 - 73, var35 - 20);
                        var0.drawCentered("Back", var7, var35 + 5, 16777215, 0);
                     } else if(Login.loginIndex == 12) {
                        var32 = 201;
                        String var41 = "";
                        var36 = "";
                        var30 = "";
                        switch(Login.__cu_aj) {
                        case 0:
                           var41 = "Your account has been disabled.";
                           var36 = Strings.__id_bq;
                           var30 = "";
                           break;
                        case 1:
                           var41 = "Account locked as we suspect it has been stolen.";
                           var36 = Strings.__id_cp;
                           var30 = "";
                           break;
                        default:
                           MouseHandler.method1084(false);
                        }

                        var0.drawCentered(var41, Login.__cu_y + 180, var32, 16776960, 0);
                        var10 = var32 + 15;
                        var2.drawCentered(var36, Login.__cu_y + 180, var10, 16776960, 0);
                        var10 += 15;
                        var2.drawCentered(var30, Login.__cu_y + 180, var10, 16776960, 0);
                        var10 += 15;
                        var8 = Login.__cu_y + 180;
                        var37 = 276;
                        __bd_u.__q_496(var8 - 73, var37 - 20);
                        var0.drawCentered("Support Page", var8, var37 + 5, 16777215, 0);
                        var8 = Login.__cu_y + 180;
                        var37 = 326;
                        __bd_u.__q_496(var8 - 73, var37 - 20);
                        var0.drawCentered("Back", var8, var37 + 5, 16777215, 0);
                     }
                  } else {
                     var0.drawCentered("Forgotten your password?", Login.__cu_y + 180, 201, 16776960, 0);
                     var32 = 221;
                     var2.drawCentered(Login.Login_response1, Login.__cu_y + 180, var32, 16776960, 0);
                     var10 = var32 + 15;
                     var2.drawCentered(Login.Login_response2, Login.__cu_y + 180, var10, 16776960, 0);
                     var10 += 15;
                     var2.drawCentered(Login.Login_response3, Login.__cu_y + 180, var10, 16776960, 0);
                     var10 += 15;
                     var10 += 14;
                     var0.draw("Username/email: ", Login.__cu_y + 180 - 145, var10, 16777215, 0);
                     var34 = 174;
                     if(ReflectionCheck.clientPreferences.hideUsername) {
                        var29 = Login.Login_username;
                        var28 = class168.method3450('*', var29.length());
                        var30 = var28;
                     } else {
                        var30 = Login.Login_username;
                     }

                     for(var30 = var30; var0.stringWidth(var30) > var34; var30 = var30.substring(1)) {
                        ;
                     }

                     var0.draw(AbstractFont.escapeBrackets(var30) + (Client.cycle % 40 < 20?BufferedFile.colorStartTag(16776960) + "|":""), Login.__cu_y + 180 - 34, var10, 16777215, 0);
                     var10 += 15;
                     var8 = Login.__cu_y + 180 - 80;
                     var37 = 321;
                     __bd_u.__q_496(var8 - 73, var37 - 20);
                     var0.drawCentered("Recover", var8, var37 + 5, 16777215, 0);
                     var8 = Login.__cu_y + 180 + 80;
                     __bd_u.__q_496(var8 - 73, var37 - 20);
                     var0.drawCentered("Back", var8, var37 + 5, 16777215, 0);
                     var37 = 356;
                     var1.drawCentered("Still having trouble logging in?", Varps.__hv_h, var37, 268435455, 0);
                  }
               }
            }
         }

         if(Client.gameState >= 10) {
            int[] var38 = new int[4];
            Rasterizer2D.Rasterizer2D_getClipArray(var38);
            Rasterizer2D.Rasterizer2D_setClip(Login.__cu_q, 0, Login.__cu_q + 765, Huffman.canvasHeight);
            class16.field85.method1782(Login.__cu_q - 22, Client.cycle);
            class16.field85.method1782(Login.__cu_q + 22 + 765 - 128, Client.cycle);
            Rasterizer2D.Rasterizer2D_setClipArray(var38);
         }

         KeyHandler.__an_x[ReflectionCheck.clientPreferences.titleMusicDisabled?1:0].__q_496(Login.__cu_q + 765 - 40, 463);
         if(Client.gameState > 5 && Client.language == 0) {
            if(class277.__jn_by != null) {
               var10 = Login.__cu_q + 5;
               var34 = 463;
               byte var39 = 100;
               byte var42 = 35;
               class277.__jn_by.__q_496(var10, var34);
               var0.drawCentered("World " + Client.worldId, var39 / 2 + var10, var42 / 2 + var34 - 2, 16777215, 0);
               if(FriendLoginUpdate.__kn_x != null) {
                  var1.drawCentered("Loading...", var39 / 2 + var10, var42 / 2 + var34 + 12, 16777215, 0);
               } else {
                  var1.drawCentered("Click to switch", var39 / 2 + var10, var42 / 2 + var34 + 12, 16777215, 0);
               }
            } else {
               class277.__jn_by = MenuAction.method2025(WorldMapSection3.indexCache8, "sl_button", "");
            }
         }
      }

   }
}
