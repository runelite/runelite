import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("a")
public class class22 extends class28 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfw;Lfw;I)V",
      garbageValue = "-2111199948"
   )
   void method151(Buffer var1, Buffer var2) {
      int var3 = var2.readUnsignedByte();
      if(var3 != class36.field476.field478) {
         throw new IllegalStateException("");
      } else {
         super.field383 = var2.readUnsignedByte();
         super.field382 = var2.readUnsignedByte();
         super.field384 = var2.readUnsignedShort();
         super.field380 = var2.readUnsignedShort();
         super.field381 = var2.readUnsignedShort();
         super.field390 = var2.readUnsignedShort();
         super.field382 = Math.min(super.field382, 4);
         super.field385 = new short[1][64][64];
         super.field386 = new short[super.field382][64][64];
         super.field388 = new byte[super.field382][64][64];
         super.field387 = new byte[super.field382][64][64];
         super.field389 = new class31[super.field382][64][64][];
         var3 = var1.readUnsignedByte();
         if(var3 != class35.field472.field470) {
            throw new IllegalStateException("");
         } else {
            int var4 = var1.readUnsignedByte();
            int var5 = var1.readUnsignedByte();
            if(var4 == super.field381 && var5 == super.field390) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  for(int var7 = 0; var7 < 64; ++var7) {
                     this.method212(var6, var7, var1);
                  }
               }

            } else {
               throw new IllegalStateException("");
            }
         }
      }
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof class22)) {
         return false;
      } else {
         class22 var2 = (class22)var1;
         return var2.field381 == super.field381 && super.field390 == var2.field390;
      }
   }

   public int hashCode() {
      return super.field381 | super.field390 << 8;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "760992189"
   )
   static void method160() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.field594[186] = 57;
         KeyFocusListener.field594[187] = 27;
         KeyFocusListener.field594[188] = 71;
         KeyFocusListener.field594[189] = 26;
         KeyFocusListener.field594[190] = 72;
         KeyFocusListener.field594[191] = 73;
         KeyFocusListener.field594[192] = 58;
         KeyFocusListener.field594[219] = 42;
         KeyFocusListener.field594[220] = 74;
         KeyFocusListener.field594[221] = 43;
         KeyFocusListener.field594[222] = 59;
         KeyFocusListener.field594[223] = 28;
      } else {
         KeyFocusListener.field594[44] = 71;
         KeyFocusListener.field594[45] = 26;
         KeyFocusListener.field594[46] = 72;
         KeyFocusListener.field594[47] = 73;
         KeyFocusListener.field594[59] = 57;
         KeyFocusListener.field594[61] = 27;
         KeyFocusListener.field594[91] = 42;
         KeyFocusListener.field594[92] = 74;
         KeyFocusListener.field594[93] = 43;
         KeyFocusListener.field594[192] = 28;
         KeyFocusListener.field594[222] = 58;
         KeyFocusListener.field594[520] = 59;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-619525247"
   )
   public static void method162() {
      try {
         if(class203.field2475 == 1) {
            int var0 = class203.field2473.method3792();
            if(var0 > 0 && class203.field2473.method3716()) {
               var0 -= RSCanvas.field633;
               if(var0 < 0) {
                  var0 = 0;
               }

               class203.field2473.method3709(var0);
               return;
            }

            class203.field2473.method3819();
            class203.field2473.method3728();
            if(class262.field3614 != null) {
               class203.field2475 = 2;
            } else {
               class203.field2475 = 0;
            }

            class203.field2477 = null;
            Buffer.field2368 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class203.field2473.method3819();
         class203.field2475 = 0;
         class203.field2477 = null;
         Buffer.field2368 = null;
         class262.field3614 = null;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljt;Ljt;Ljt;ZI)V",
      garbageValue = "-1664328667"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class92.field1416 = (class31.canvasWidth - 765) / 2;
         class92.loginWindowX = class92.field1416 + 202;
      }

      if(class92.worldSelectShown) {
         class23.method163(var0, var1);
      } else {
         if(var3) {
            class92.field1411.method5067(class92.field1416, 0);
            class92.field1399.method5067(class92.field1416 + 382, 0);
            class11.logoSprite.method5034(class92.field1416 + 382 - class11.logoSprite.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method4742("RuneScape is loading - please wait...", class92.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class92.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class92.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4937(class92.loginWindowX + 180 - 150, var5 + 2, class92.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.method4937(class92.loadingBarPercentage * 3 + (class92.loginWindowX + 180 - 150), var5 + 2, 300 - class92.loadingBarPercentage * 3, 30, 0);
            var0.method4742(class92.loadingText, class92.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         short var12;
         int var13;
         short var14;
         if(Client.gameState == 20) {
            class92.field1396.method5034(class92.loginWindowX + 180 - class92.field1396.originalWidth / 2, 271 - class92.field1396.height / 2);
            var12 = 211;
            var0.method4742(class92.loginMessage1, class92.loginWindowX + 180, var12, 16776960, 0);
            var13 = var12 + 15;
            var0.method4742(class92.loginMessage2, class92.loginWindowX + 180, var13, 16776960, 0);
            var13 += 15;
            var0.method4742(class92.loginMessage3, class92.loginWindowX + 180, var13, 16776960, 0);
            var13 += 15;
            var13 += 10;
            if(class92.loginIndex != 4) {
               var0.method4751("Login: ", class92.loginWindowX + 180 - 110, var13, 16777215, 0);
               var14 = 200;

               for(var6 = class92.username; var0.method4820(var6) > var14; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method4751(FontTypeFace.appendTags(var6), class92.loginWindowX + 180 - 70, var13, 16777215, 0);
               var13 += 15;
               var0.method4751("Password: " + Coordinates.method3955(class92.password), class92.loginWindowX + 180 - 108, var13, 16777215, 0);
               var13 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class92.field1396.method5034(class92.loginWindowX, 171);
            short var10;
            if(class92.loginIndex == 0) {
               var12 = 251;
               var0.method4742("Welcome to RuneScape", class92.loginWindowX + 180, var12, 16776960, 0);
               var13 = var12 + 30;
               var5 = class92.loginWindowX + 180 - 80;
               var10 = 291;
               class92.field1397.method5034(var5 - 73, var10 - 20);
               var0.method4833("New User", var5 - 73, var10 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class92.field1397.method5034(var5 - 73, var10 - 20);
               var0.method4833("Existing User", var5 - 73, var10 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class92.loginIndex == 1) {
               var0.method4742(class92.field1412, class92.loginWindowX + 180, 211, 16776960, 0);
               var12 = 236;
               var0.method4742(class92.loginMessage1, class92.loginWindowX + 180, var12, 16777215, 0);
               var13 = var12 + 15;
               var0.method4742(class92.loginMessage2, class92.loginWindowX + 180, var13, 16777215, 0);
               var13 += 15;
               var0.method4742(class92.loginMessage3, class92.loginWindowX + 180, var13, 16777215, 0);
               var13 += 15;
               var5 = class92.loginWindowX + 180 - 80;
               var10 = 321;
               class92.field1397.method5034(var5 - 73, var10 - 20);
               var0.method4742("Continue", var5, var10 + 5, 16777215, 0);
               var5 = class92.loginWindowX + 180 + 80;
               class92.field1397.method5034(var5 - 73, var10 - 20);
               var0.method4742("Cancel", var5, var10 + 5, 16777215, 0);
            } else {
               int var7;
               short var8;
               if(class92.loginIndex == 2) {
                  var12 = 211;
                  var0.method4742(class92.loginMessage1, class92.loginWindowX + 180, var12, 16776960, 0);
                  var13 = var12 + 15;
                  var0.method4742(class92.loginMessage2, class92.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var0.method4742(class92.loginMessage3, class92.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var13 += 10;
                  var0.method4751("Login: ", class92.loginWindowX + 180 - 110, var13, 16777215, 0);
                  var14 = 200;

                  for(var6 = class92.username; var0.method4820(var6) > var14; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4751(FontTypeFace.appendTags(var6) + (class92.loginIndex2 == 0 & Client.gameCycle % 40 < 20?CacheFile.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 70, var13, 16777215, 0);
                  var13 += 15;
                  var0.method4751("Password: " + Coordinates.method3955(class92.password) + (class92.loginIndex2 == 1 & Client.gameCycle % 40 < 20?CacheFile.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 108, var13, 16777215, 0);
                  var13 += 15;
                  var7 = class92.loginWindowX + 180 - 80;
                  var8 = 321;
                  class92.field1397.method5034(var7 - 73, var8 - 20);
                  var0.method4742("Login", var7, var8 + 5, 16777215, 0);
                  var7 = class92.loginWindowX + 180 + 80;
                  class92.field1397.method5034(var7 - 73, var8 - 20);
                  var0.method4742("Cancel", var7, var8 + 5, 16777215, 0);
                  var12 = 357;
                  var1.method4742("Forgotten your password? <col=ffffff>Click here.", class92.loginWindowX + 180, var12, 16776960, 0);
               } else if(class92.loginIndex == 3) {
                  var12 = 201;
                  var0.method4742("Invalid username or password.", class92.loginWindowX + 180, var12, 16776960, 0);
                  var13 = var12 + 20;
                  var1.method4742("For accounts created after 24th November 2010, please use your", class92.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var1.method4742("email address to login. Otherwise please login with your username.", class92.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var5 = class92.loginWindowX + 180;
                  var10 = 276;
                  class92.field1397.method5034(var5 - 73, var10 - 20);
                  var2.method4742("Try again", var5, var10 + 5, 16777215, 0);
                  var5 = class92.loginWindowX + 180;
                  var10 = 326;
                  class92.field1397.method5034(var5 - 73, var10 - 20);
                  var2.method4742("Forgotten password?", var5, var10 + 5, 16777215, 0);
               } else if(class92.loginIndex == 4) {
                  var0.method4742("Authenticator", class92.loginWindowX + 180, 211, 16776960, 0);
                  var12 = 236;
                  var0.method4742(class92.loginMessage1, class92.loginWindowX + 180, var12, 16777215, 0);
                  var13 = var12 + 15;
                  var0.method4742(class92.loginMessage2, class92.loginWindowX + 180, var13, 16777215, 0);
                  var13 += 15;
                  var0.method4742(class92.loginMessage3, class92.loginWindowX + 180, var13, 16777215, 0);
                  var13 += 15;
                  var0.method4751("PIN: " + Coordinates.method3955(class17.authCode) + (Client.gameCycle % 40 < 20?CacheFile.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 108, var13, 16777215, 0);
                  var13 -= 8;
                  var0.method4751("Trust this computer", class92.loginWindowX + 180 - 9, var13, 16776960, 0);
                  var13 += 15;
                  var0.method4751("for 30 days: ", class92.loginWindowX + 180 - 9, var13, 16776960, 0);
                  var5 = class92.loginWindowX + 180 - 9 + var0.method4820("for 30 days: ") + 15;
                  int var17 = var13 - var0.verticalSpace;
                  IndexedSprite var11;
                  if(class92.field1419) {
                     var11 = class149.field2178;
                  } else {
                     var11 = class90.field1378;
                  }

                  var11.method5034(var5, var17);
                  var13 += 15;
                  int var16 = class92.loginWindowX + 180 - 80;
                  short var9 = 321;
                  class92.field1397.method5034(var16 - 73, var9 - 20);
                  var0.method4742("Continue", var16, var9 + 5, 16777215, 0);
                  var16 = class92.loginWindowX + 180 + 80;
                  class92.field1397.method5034(var16 - 73, var9 - 20);
                  var0.method4742("Cancel", var16, var9 + 5, 16777215, 0);
                  var1.method4742("<u=ff>Can\'t Log In?</u>", class92.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class92.loginIndex == 5) {
                  var0.method4742("Forgotten your password?", class92.loginWindowX + 180, 201, 16776960, 0);
                  var12 = 221;
                  var2.method4742(class92.loginMessage1, class92.loginWindowX + 180, var12, 16776960, 0);
                  var13 = var12 + 15;
                  var2.method4742(class92.loginMessage2, class92.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var2.method4742(class92.loginMessage3, class92.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var13 += 14;
                  var0.method4751("Username/email: ", class92.loginWindowX + 180 - 145, var13, 16777215, 0);
                  var14 = 174;

                  for(var6 = class92.username; var0.method4820(var6) > var14; var6 = var6.substring(1)) {
                     ;
                  }

                  var0.method4751(FontTypeFace.appendTags(var6) + (Client.gameCycle % 40 < 20?CacheFile.getColTags(16776960) + "|":""), class92.loginWindowX + 180 - 34, var13, 16777215, 0);
                  var13 += 15;
                  var7 = class92.loginWindowX + 180 - 80;
                  var8 = 321;
                  class92.field1397.method5034(var7 - 73, var8 - 20);
                  var0.method4742("Recover", var7, var8 + 5, 16777215, 0);
                  var7 = class92.loginWindowX + 180 + 80;
                  class92.field1397.method5034(var7 - 73, var8 - 20);
                  var0.method4742("Back", var7, var8 + 5, 16777215, 0);
               } else if(class92.loginIndex == 6) {
                  var12 = 211;
                  var0.method4742(class92.loginMessage1, class92.loginWindowX + 180, var12, 16776960, 0);
                  var13 = var12 + 15;
                  var0.method4742(class92.loginMessage2, class92.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var0.method4742(class92.loginMessage3, class92.loginWindowX + 180, var13, 16776960, 0);
                  var13 += 15;
                  var5 = class92.loginWindowX + 180;
                  var10 = 321;
                  class92.field1397.method5034(var5 - 73, var10 - 20);
                  var0.method4742("Back", var5, var10 + 5, 16777215, 0);
               }
            }
         }

         if(class92.field1413 > 0) {
            GroundObject.method2491(class92.field1413);
            class92.field1413 = 0;
         }

         class90.method1718();
         class36.titlemuteSprite[class170.preferences.muted?1:0].method5034(class92.field1416 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(class66.field788 != null) {
               var13 = class92.field1416 + 5;
               var14 = 463;
               byte var18 = 100;
               byte var15 = 35;
               class66.field788.method5034(var13, var14);
               var0.method4742("World" + " " + Client.world, var13 + var18 / 2, var14 + var15 / 2 - 2, 16777215, 0);
               if(World.listFetcher != null) {
                  var1.method4742("Loading...", var13 + var18 / 2, var14 + var15 / 2 + 12, 16777215, 0);
               } else {
                  var1.method4742("Click to switch", var13 + var18 / 2, var14 + var15 / 2 + 12, 16777215, 0);
               }
            } else {
               class66.field788 = class162.getSprite(CombatInfo1.indexSprites, "sl_button", "");
            }
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-93"
   )
   static final int method161() {
      return class134.field1964;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "82"
   )
   public static void method156(boolean var0) {
      if(var0 != class37.isMembersWorld) {
         class228.method4089();
         class37.isMembersWorld = var0;
      }

   }
}
