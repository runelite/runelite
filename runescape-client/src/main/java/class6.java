import java.awt.Graphics;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
final class class6 implements Comparator {
   @ObfuscatedName("qv")
   @ObfuscatedGetter(
      intValue = 1305439195
   )
   static int field61;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "-39"
   )
   int method82(class2 var1, class2 var2) {
      return var1.method29().compareTo(var2.method29());
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method82((class2)var1, (class2)var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "54"
   )
   static void method88(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field671[var5]) {
            var2[var4] = World.field671[var5];
            var3[var4] = World.field670[var5];
            ++var4;
         }
      }

      World.field671 = var2;
      World.field670 = var3;
      method94(class5.worldList, 0, class5.worldList.length - 1, World.field671, World.field670);
   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-87"
   )
   static final void method91() {
      Client.field397 = 0;
      int var0 = Projectile.baseX + (class16.localPlayer.x >> 7);
      int var1 = (class16.localPlayer.y >> 7) + class3.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field397 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field397 = 1;
      }

      if(Client.field397 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field397 = 0;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZI)V",
      garbageValue = "-1862568040"
   )
   static void method92(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class41.field818 = (class26.field577 - Client.field492) / 2;
         class41.loginWindowX = 202 + class41.field818;
      }

      byte var4;
      int var5;
      int var7;
      int var9;
      int var10;
      int var11;
      Graphics var23;
      int var34;
      int var36;
      int var38;
      int var41;
      int var42;
      if(class41.worldSelectShown) {
         if(null == class202.field3066) {
            class202.field3066 = class41.method771(class184.field2739, "sl_back", "");
         }

         if(class41.field839 == null) {
            class41.field839 = class8.method116(class184.field2739, "sl_flags", "");
         }

         if(null == class118.field1851) {
            class118.field1851 = class8.method116(class184.field2739, "sl_arrows", "");
         }

         if(null == class31.field710) {
            class31.field710 = class8.method116(class184.field2739, "sl_stars", "");
         }

         Rasterizer2D.method4020(class41.field818, 23, 765, 480, 0);
         Rasterizer2D.method3996(class41.field818, 0, 125, 23, 12425273, 9135624);
         Rasterizer2D.method3996(125 + class41.field818, 0, 640, 23, 5197647, 2697513);
         var0.method3910("Select a world", 62 + class41.field818, 15, 0, -1);
         if(null != class31.field710) {
            class31.field710[1].method4083(140 + class41.field818, 1);
            var1.method3875("Members only world", class41.field818 + 152, 10, 16777215, -1);
            class31.field710[0].method4083(class41.field818 + 140, 12);
            var1.method3875("Free world", 152 + class41.field818, 21, 16777215, -1);
         }

         if(class118.field1851 != null) {
            var34 = class41.field818 + 280;
            if(World.field671[0] == 0 && World.field670[0] == 0) {
               class118.field1851[2].method4083(var34, 4);
            } else {
               class118.field1851[0].method4083(var34, 4);
            }

            if(World.field671[0] == 0 && World.field670[0] == 1) {
               class118.field1851[3].method4083(var34 + 15, 4);
            } else {
               class118.field1851[1].method4083(var34 + 15, 4);
            }

            var0.method3875("World", 32 + var34, 17, 16777215, -1);
            var5 = 390 + class41.field818;
            if(World.field671[0] == 1 && World.field670[0] == 0) {
               class118.field1851[2].method4083(var5, 4);
            } else {
               class118.field1851[0].method4083(var5, 4);
            }

            if(World.field671[0] == 1 && World.field670[0] == 1) {
               class118.field1851[3].method4083(15 + var5, 4);
            } else {
               class118.field1851[1].method4083(var5 + 15, 4);
            }

            var0.method3875("Players", 32 + var5, 17, 16777215, -1);
            var36 = 500 + class41.field818;
            if(World.field671[0] == 2 && World.field670[0] == 0) {
               class118.field1851[2].method4083(var36, 4);
            } else {
               class118.field1851[0].method4083(var36, 4);
            }

            if(World.field671[0] == 2 && World.field670[0] == 1) {
               class118.field1851[3].method4083(15 + var36, 4);
            } else {
               class118.field1851[1].method4083(var36 + 15, 4);
            }

            var0.method3875("Location", var36 + 32, 17, 16777215, -1);
            var7 = 610 + class41.field818;
            if(World.field671[0] == 3 && World.field670[0] == 0) {
               class118.field1851[2].method4083(var7, 4);
            } else {
               class118.field1851[0].method4083(var7, 4);
            }

            if(World.field671[0] == 3 && World.field670[0] == 1) {
               class118.field1851[3].method4083(15 + var7, 4);
            } else {
               class118.field1851[1].method4083(var7 + 15, 4);
            }

            var0.method3875("Type", var7 + 32, 17, 16777215, -1);
         }

         Rasterizer2D.method4020(708 + class41.field818, 4, 50, 16, 0);
         var1.method3910("Cancel", 25 + 708 + class41.field818, 16, 16777215, -1);
         class41.field852 = -1;
         if(class202.field3066 != null) {
            var4 = 88;
            byte var40 = 19;
            var36 = 765 / (1 + var4);
            var7 = 480 / (var40 + 1);

            do {
               var38 = var7;
               var9 = var36;
               if((var36 - 1) * var7 >= World.field668) {
                  --var36;
               }

               if(var36 * (var7 - 1) >= World.field668) {
                  --var7;
               }

               if(var36 * (var7 - 1) >= World.field668) {
                  --var7;
               }
            } while(var38 != var7 || var36 != var9);

            var38 = (765 - var4 * var36) / (var36 + 1);
            if(var38 > 5) {
               var38 = 5;
            }

            var9 = (480 - var7 * var40) / (var7 + 1);
            if(var9 > 5) {
               var9 = 5;
            }

            var10 = (765 - var36 * var4 - (var36 - 1) * var38) / 2;
            var11 = (480 - var7 * var40 - var9 * (var7 - 1)) / 2;
            var41 = var11 + 23;
            var42 = var10 + class41.field818;
            int var14 = 0;
            boolean var15 = false;

            int var16;
            for(var16 = 0; var16 < World.field668; ++var16) {
               World var17 = class5.worldList[var16];
               boolean var18 = true;
               String var19 = Integer.toString(var17.playerCount);
               if(var17.playerCount == -1) {
                  var19 = "OFF";
                  var18 = false;
               } else if(var17.playerCount > 1980) {
                  var19 = "FULL";
                  var18 = false;
               }

               int var21 = 0;
               byte var20;
               if(var17.method613()) {
                  if(var17.method651()) {
                     var20 = 7;
                  } else {
                     var20 = 6;
                  }
               } else if(var17.method612()) {
                  var21 = 16711680;
                  if(var17.method651()) {
                     var20 = 5;
                  } else {
                     var20 = 4;
                  }
               } else if(var17.method627()) {
                  if(var17.method651()) {
                     var20 = 3;
                  } else {
                     var20 = 2;
                  }
               } else if(var17.method651()) {
                  var20 = 1;
               } else {
                  var20 = 0;
               }

               if(class115.field1805 >= var42 && class115.field1814 >= var41 && class115.field1805 < var4 + var42 && class115.field1814 < var40 + var41 && var18) {
                  class41.field852 = var16;
                  class202.field3066[var20].method4213(var42, var41, 128, 16777215);
                  var15 = true;
               } else {
                  class202.field3066[var20].method4142(var42, var41);
               }

               if(class41.field839 != null) {
                  class41.field839[(var17.method651()?8:0) + var17.location].method4083(var42 + 29, var41);
               }

               var0.method3910(Integer.toString(var17.id), var42 + 15, 5 + var40 / 2 + var41, var21, -1);
               var1.method3910(var19, 60 + var42, 5 + var40 / 2 + var41, 268435455, -1);
               var41 += var9 + var40;
               ++var14;
               if(var14 >= var7) {
                  var41 = var11 + 23;
                  var42 += var38 + var4;
                  var14 = 0;
               }
            }

            if(var15) {
               var16 = var1.method3870(class5.worldList[class41.field852].activity) + 6;
               int var22 = 8 + var1.field3100;
               Rasterizer2D.method4020(class115.field1805 - var16 / 2, class115.field1814 + 20 + 5, var16, var22, 16777120);
               Rasterizer2D.method3997(class115.field1805 - var16 / 2, 5 + 20 + class115.field1814, var16, var22, 0);
               var1.method3910(class5.worldList[class41.field852].activity, class115.field1805, 4 + 20 + class115.field1814 + 5 + var1.field3100, 0, -1);
            }
         }

         try {
            var23 = class157.canvas.getGraphics();
            class57.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var31) {
            class157.canvas.repaint();
         }

      } else {
         if(var3) {
            class41.field821.method4142(class41.field818, 0);
            CombatInfo1.field658.method4142(382 + class41.field818, 0);
            class41.field819.method4083(382 + class41.field818 - class41.field819.originalWidth / 2, 18);
         }

         if(Client.gameState == 0 || Client.gameState == 5) {
            var4 = 20;
            var0.method3910("RuneScape is loading - please wait...", 180 + class41.loginWindowX, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method3997(class41.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method3997(180 + class41.loginWindowX - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4020(180 + class41.loginWindowX - 150, 2 + var5, class41.field836 * 3, 30, 9179409);
            Rasterizer2D.method4020(180 + class41.loginWindowX - 150 + class41.field836 * 3, 2 + var5, 300 - class41.field836 * 3, 30, 0);
            var0.method3910(class41.field837, 180 + class41.loginWindowX, 276 - var4, 16777215, -1);
         }

         String var24;
         String var26;
         String var27;
         String var28;
         short var33;
         short var35;
         if(Client.gameState == 20) {
            class41.field851.method4083(180 + class41.loginWindowX - class41.field851.originalWidth / 2, 271 - class41.field851.height / 2);
            var33 = 211;
            var0.method3910(class41.loginMessage1, class41.loginWindowX + 180, var33, 16776960, 0);
            var34 = var33 + 15;
            var0.method3910(class41.loginMessage2, 180 + class41.loginWindowX, var34, 16776960, 0);
            var34 += 15;
            var0.method3910(class41.loginMessage3, class41.loginWindowX + 180, var34, 16776960, 0);
            var34 += 15;
            var34 += 10;
            if(class41.loginIndex != 4) {
               var0.method3875("Login: ", class41.loginWindowX + 180 - 110, var34, 16777215, 0);
               var35 = 200;

               for(var24 = class41.username; var0.method3870(var24) > var35; var24 = var24.substring(0, var24.length() - 1)) {
                  ;
               }

               var0.method3875(FontTypeFace.method3919(var24), class41.loginWindowX + 180 - 70, var34, 16777215, 0);
               var34 += 15;
               var26 = "Password: ";
               var27 = class41.field844;
               var28 = PlayerComposition.method3120('*', var27.length());
               var0.method3875(var26 + var28, 180 + class41.loginWindowX - 108, var34, 16777215, 0);
               var34 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field851.method4083(class41.loginWindowX, 171);
            short var6;
            if(class41.loginIndex == 0) {
               var33 = 251;
               var0.method3910("Welcome to RuneScape", 180 + class41.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 30;
               var5 = class41.loginWindowX + 180 - 80;
               var6 = 291;
               class41.field820.method4083(var5 - 73, var6 - 20);
               var0.method3866("New User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 180 + class41.loginWindowX + 80;
               class41.field820.method4083(var5 - 73, var6 - 20);
               var0.method3866("Existing User", var5 - 73, var6 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3910(class41.field822, class41.loginWindowX + 180, 211, 16776960, 0);
               var33 = 236;
               var0.method3910(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method3910(class41.loginMessage2, 180 + class41.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var0.method3910(class41.loginMessage3, 180 + class41.loginWindowX, var34, 16777215, 0);
               var34 += 15;
               var5 = 180 + class41.loginWindowX - 80;
               var6 = 321;
               class41.field820.method4083(var5 - 73, var6 - 20);
               var0.method3910("Continue", var5, var6 + 5, 16777215, 0);
               var5 = 80 + 180 + class41.loginWindowX;
               class41.field820.method4083(var5 - 73, var6 - 20);
               var0.method3910("Cancel", var5, 5 + var6, 16777215, 0);
            } else if(class41.loginIndex == 2) {
               var33 = 211;
               var0.method3910(class41.loginMessage1, class41.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 15;
               var0.method3910(class41.loginMessage2, 180 + class41.loginWindowX, var34, 16776960, 0);
               var34 += 15;
               var0.method3910(class41.loginMessage3, class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var34 += 10;
               var0.method3875("Login: ", class41.loginWindowX + 180 - 110, var34, 16777215, 0);
               var35 = 200;

               for(var24 = class41.username; var0.method3870(var24) > var35; var24 = var24.substring(1)) {
                  ;
               }

               var0.method3875(FontTypeFace.method3919(var24) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?Client.method568(16776960) + "|":""), class41.loginWindowX + 180 - 70, var34, 16777215, 0);
               var34 += 15;
               var26 = "Password: ";
               var27 = class41.field844;
               var28 = PlayerComposition.method3120('*', var27.length());
               var0.method3875(var26 + var28 + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?Client.method568(16776960) + "|":""), 180 + class41.loginWindowX - 108, var34, 16777215, 0);
               var34 += 15;
               var11 = class41.loginWindowX + 180 - 80;
               short var12 = 321;
               class41.field820.method4083(var11 - 73, var12 - 20);
               var0.method3910("Login", var11, 5 + var12, 16777215, 0);
               var11 = 80 + class41.loginWindowX + 180;
               class41.field820.method4083(var11 - 73, var12 - 20);
               var0.method3910("Cancel", var11, 5 + var12, 16777215, 0);
               var33 = 357;
               var1.method3910("Forgotten your password? <col=ffffff>Click here.", class41.loginWindowX + 180, var33, 16776960, 0);
            } else if(class41.loginIndex == 3) {
               var33 = 201;
               var0.method3910("Invalid username or password.", 180 + class41.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 20;
               var1.method3910("For accounts created after 24th November 2010, please use your", class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var1.method3910("email address to login. Otherwise please login with your username.", class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var5 = class41.loginWindowX + 180;
               var6 = 276;
               class41.field820.method4083(var5 - 73, var6 - 20);
               var2.method3910("Try again", var5, var6 + 5, 16777215, 0);
               var5 = 180 + class41.loginWindowX;
               var6 = 326;
               class41.field820.method4083(var5 - 73, var6 - 20);
               var2.method3910("Forgotten password?", var5, var6 + 5, 16777215, 0);
            } else if(class41.loginIndex == 4) {
               var0.method3910("Authenticator", class41.loginWindowX + 180, 211, 16776960, 0);
               var33 = 236;
               var0.method3910(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16777215, 0);
               var34 = var33 + 15;
               var0.method3910(class41.loginMessage2, class41.loginWindowX + 180, var34, 16777215, 0);
               var34 += 15;
               var0.method3910(class41.loginMessage3, class41.loginWindowX + 180, var34, 16777215, 0);
               var34 += 15;
               var24 = "PIN: ";
               var26 = ChatMessages.authCode;
               String var25 = PlayerComposition.method3120('*', var26.length());
               var0.method3875(var24 + var25 + (Client.gameCycle % 40 < 20?Client.method568(16776960) + "|":""), 180 + class41.loginWindowX - 108, var34, 16777215, 0);
               var34 -= 8;
               var0.method3875("Trust this computer", class41.loginWindowX + 180 - 9, var34, 16776960, 0);
               var34 += 15;
               var0.method3875("for 30 days: ", class41.loginWindowX + 180 - 9, var34, 16776960, 0);
               var9 = class41.loginWindowX + 180 - 9 + var0.method3870("for 30 days: ") + 15;
               var10 = var34 - var0.field3100;
               ModIcon var30;
               if(class41.field846) {
                  var30 = class41.field825;
               } else {
                  var30 = class41.field824;
               }

               var30.method4083(var9, var10);
               var34 += 15;
               var41 = 180 + class41.loginWindowX - 80;
               short var13 = 321;
               class41.field820.method4083(var41 - 73, var13 - 20);
               var0.method3910("Continue", var41, var13 + 5, 16777215, 0);
               var41 = class41.loginWindowX + 180 + 80;
               class41.field820.method4083(var41 - 73, var13 - 20);
               var0.method3910("Cancel", var41, var13 + 5, 16777215, 0);
               var1.method3910("<u=ff>Can\'t Log In?</u>", class41.loginWindowX + 180, var13 + 36, 255, 0);
            } else if(class41.loginIndex == 5) {
               var0.method3910("Forgotten your password?", 180 + class41.loginWindowX, 201, 16776960, 0);
               var33 = 221;
               var2.method3910(class41.loginMessage1, 180 + class41.loginWindowX, var33, 16776960, 0);
               var34 = var33 + 15;
               var2.method3910(class41.loginMessage2, class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var2.method3910(class41.loginMessage3, class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var34 += 14;
               var0.method3875("Username/email: ", class41.loginWindowX + 180 - 145, var34, 16777215, 0);
               var35 = 174;

               for(var24 = class41.username; var0.method3870(var24) > var35; var24 = var24.substring(1)) {
                  ;
               }

               var0.method3875(FontTypeFace.method3919(var24) + (Client.gameCycle % 40 < 20?Client.method568(16776960) + "|":""), 180 + class41.loginWindowX - 34, var34, 16777215, 0);
               var34 += 15;
               var7 = 180 + class41.loginWindowX - 80;
               short var8 = 321;
               class41.field820.method4083(var7 - 73, var8 - 20);
               var0.method3910("Recover", var7, var8 + 5, 16777215, 0);
               var7 = 80 + 180 + class41.loginWindowX;
               class41.field820.method4083(var7 - 73, var8 - 20);
               var0.method3910("Back", var7, 5 + var8, 16777215, 0);
            } else if(class41.loginIndex == 6) {
               var33 = 211;
               var0.method3910(class41.loginMessage1, class41.loginWindowX + 180, var33, 16776960, 0);
               var34 = var33 + 15;
               var0.method3910(class41.loginMessage2, class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var0.method3910(class41.loginMessage3, class41.loginWindowX + 180, var34, 16776960, 0);
               var34 += 15;
               var5 = class41.loginWindowX + 180;
               var6 = 321;
               class41.field820.method4083(var5 - 73, var6 - 20);
               var0.method3910("Back", var5, var6 + 5, 16777215, 0);
            }
         }

         if(class41.field834 > 0) {
            var34 = class41.field834;
            var35 = 256;
            class41.field817 += 128 * var34;
            if(class41.field817 > CollisionData.field1841.length) {
               class41.field817 -= CollisionData.field1841.length;
               var36 = (int)(Math.random() * 12.0D);
               class8.method115(class211.field3124[var36]);
            }

            var36 = 0;
            var7 = var34 * 128;
            var38 = 128 * (var35 - var34);

            for(var9 = 0; var9 < var38; ++var9) {
               var10 = class40.field806[var36 + var7] - var34 * CollisionData.field1841[var36 + class41.field817 & CollisionData.field1841.length - 1] / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               class40.field806[var36++] = var10;
            }

            for(var9 = var35 - var34; var9 < var35; ++var9) {
               var10 = var9 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var41 = (int)(Math.random() * 100.0D);
                  if(var41 < 50 && var11 > 10 && var11 < 118) {
                     class40.field806[var11 + var10] = 255;
                  } else {
                     class40.field806[var10 + var11] = 0;
                  }
               }
            }

            if(class41.field827 > 0) {
               class41.field827 -= var34 * 4;
            }

            if(class41.field831 > 0) {
               class41.field831 -= 4 * var34;
            }

            if(class41.field827 == 0 && class41.field831 == 0) {
               var9 = (int)(Math.random() * (double)(2000 / var34));
               if(var9 == 0) {
                  class41.field827 = 1024;
               }

               if(var9 == 1) {
                  class41.field831 = 1024;
               }
            }

            for(var9 = 0; var9 < var35 - var34; ++var9) {
               class41.field830[var9] = class41.field830[var34 + var9];
            }

            for(var9 = var35 - var34; var9 < var35; ++var9) {
               class41.field830[var9] = (int)(Math.sin((double)class41.field835 / 14.0D) * 16.0D + Math.sin((double)class41.field835 / 15.0D) * 14.0D + Math.sin((double)class41.field835 / 16.0D) * 12.0D);
               ++class41.field835;
            }

            class41.field832 += var34;
            var9 = ((Client.gameCycle & 1) + var34) / 2;
            if(var9 > 0) {
               for(var10 = 0; var10 < class41.field832 * 100; ++var10) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var41 = (int)(Math.random() * 128.0D) + 128;
                  class40.field806[var11 + (var41 << 7)] = 192;
               }

               class41.field832 = 0;
               var10 = 0;

               label523:
               while(true) {
                  if(var10 >= var35) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label523;
                        }

                        var11 = 0;

                        for(var41 = -var9; var41 < var35; ++var41) {
                           var42 = 128 * var41;
                           if(var9 + var41 < var35) {
                              var11 += class10.field101[var10 + var42 + var9 * 128];
                           }

                           if(var41 - (var9 + 1) >= 0) {
                              var11 -= class10.field101[var42 + var10 - 128 * (var9 + 1)];
                           }

                           if(var41 >= 0) {
                              class40.field806[var10 + var42] = var11 / (1 + var9 * 2);
                           }
                        }

                        ++var10;
                     }
                  }

                  var11 = 0;
                  var41 = var10 * 128;

                  for(var42 = -var9; var42 < 128; ++var42) {
                     if(var42 + var9 < 128) {
                        var11 += class40.field806[var9 + var41 + var42];
                     }

                     if(var42 - (1 + var9) >= 0) {
                        var11 -= class40.field806[var42 + var41 - (1 + var9)];
                     }

                     if(var42 >= 0) {
                        class10.field101[var41 + var42] = var11 / (1 + 2 * var9);
                     }
                  }

                  ++var10;
               }
            }

            class41.field834 = 0;
         }

         XGrandExchangeOffer.method60();
         class41.field823[class107.field1733.field693?1:0].method4083(class41.field818 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.field353 == 0) {
            if(class49.field959 != null) {
               var34 = 5 + class41.field818;
               var35 = 463;
               byte var39 = 100;
               byte var37 = 35;
               class49.field959.method4083(var34, var35);
               var0.method3910("World" + " " + Client.world, var39 / 2 + var34, var37 / 2 + var35 - 2, 16777215, 0);
               if(null != class13.worldServersDownload) {
                  var1.method3910("Loading...", var39 / 2 + var34, 12 + var37 / 2 + var35, 16777215, 0);
               } else {
                  var1.method3910("Click to switch", var34 + var39 / 2, 12 + var37 / 2 + var35, 16777215, 0);
               }
            } else {
               class49.field959 = class164.method3118(class184.field2739, "sl_button", "");
            }
         }

         try {
            var23 = class157.canvas.getGraphics();
            class57.bufferProvider.draw(var23, 0, 0);
         } catch (Exception var32) {
            class157.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1540122797"
   )
   @Export("calculateHeight")
   public static int calculateHeight(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var2 + var0) / var1 - var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "-685581358"
   )
   static void method94(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = 1 + var2;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method651()?1:0;
                     var12 = var8.method651()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method651()?1:0;
                     var12 = var8.method651()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method94(var0, var1, var6, var3, var4);
         method94(var0, 1 + var6, var2, var3, var4);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "352702486"
   )
   public static void method95() {
      if(null != class105.keyboard) {
         class105 var0 = class105.keyboard;
         synchronized(class105.keyboard) {
            class105.keyboard = null;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lclass179;",
      garbageValue = "805644880"
   )
   public static class179[] method96() {
      return new class179[]{class179.field2684, class179.field2682, class179.field2685, class179.field2683, class179.field2686, class179.field2681};
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2025715451"
   )
   public static boolean method97() {
      try {
         if(class138.field1921 == 2) {
            if(null == class114.field1791) {
               class114.field1791 = class144.method2738(Item.field887, class181.field2695, Frames.field1569);
               if(class114.field1791 == null) {
                  return false;
               }
            }

            if(class26.field587 == null) {
               class26.field587 = new class60(class138.field1918, Frames.field1571);
            }

            if(class138.field1920.method2585(class114.field1791, class138.field1919, class26.field587, 22050)) {
               class138.field1920.method2610();
               class138.field1920.method2507(class105.field1721);
               class138.field1920.method2512(class114.field1791, class138.field1922);
               class138.field1921 = 0;
               class114.field1791 = null;
               class26.field587 = null;
               Item.field887 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class138.field1920.method2513();
         class138.field1921 = 0;
         class114.field1791 = null;
         class26.field587 = null;
         Item.field887 = null;
      }

      return false;
   }
}
