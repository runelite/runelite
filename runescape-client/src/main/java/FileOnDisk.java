import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.SyncFailedException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
@Implements("FileOnDisk")
public final class FileOnDisk {
   @ObfuscatedName("m")
   @Export("file")
   RandomAccessFile file;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      longValue = 288851731773182291L
   )
   @Export("length")
   long length;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 4949220105685412339L
   )
   @Export("position")
   long position;

   public FileOnDisk(File var1, String var2, long var3) throws IOException {
      if(var3 == -1L) {
         var3 = Long.MAX_VALUE;
      }

      if(var1.length() >= var3) {
         var1.delete();
      }

      this.file = new RandomAccessFile(var1, var2);
      this.length = var3;
      this.position = 0L;
      int var5 = this.file.read();
      if(var5 != -1 && !var2.equals("r")) {
         this.file.seek(0L);
         this.file.write(var5);
      }

      this.file.seek(0L);
   }

   @ObfuscatedName("m")
   @Export("seek")
   final void seek(long var1) throws IOException {
      this.file.seek(var1);
      this.position = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "354759125"
   )
   @Export("write")
   public final void write(byte[] var1, int var2, int var3) throws IOException {
      if((long)var3 + this.position > this.length) {
         this.file.seek(1L + this.length);
         this.file.write(1);
         throw new EOFException();
      } else {
         this.file.write(var1, var2, var3);
         this.position += (long)var3;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "12"
   )
   @Export("close")
   public final void close() throws IOException {
      this.method2475(false);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1721155992"
   )
   public final void method2475(boolean var1) throws IOException {
      if(this.file != null) {
         if(var1) {
            try {
               this.file.getFD().sync();
            } catch (SyncFailedException var3) {
               ;
            }
         }

         this.file.close();
         this.file = null;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)J",
      garbageValue = "-13031"
   )
   @Export("length")
   public final long length() throws IOException {
      return this.file.length();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-65"
   )
   @Export("read")
   public final int read(byte[] var1, int var2, int var3) throws IOException {
      int var4 = this.file.read(var1, var2, var3);
      if(var4 > 0) {
         this.position += (long)var4;
      }

      return var4;
   }

   protected void finalize() throws Throwable {
      if(this.file != null) {
         System.out.println("");
         this.close();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljt;Ljt;Ljt;ZI)V",
      garbageValue = "-720798737"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class91.field1332 = (Tile.canvasWidth - 765) / 2;
         class91.loginWindowX = class91.field1332 + 202;
         class233.field3209 = class91.loginWindowX + 180;
      }

      if(class91.worldSelectShown) {
         class35.method540(var0, var1);
      } else {
         if(var3) {
            class91.field1336.method5276(class91.field1332, 0);
            class91.field1368.method5276(class91.field1332 + 382, 0);
            class91.logoSprite.method5246(class91.field1332 + 382 - class91.logoSprite.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method4934("RuneScape is loading - please wait...", class91.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class91.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class91.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method5151(class91.loginWindowX + 180 - 150, var5 + 2, class91.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.method5151(class91.loadingBarPercentage * 3 + (class91.loginWindowX + 180 - 150), var5 + 2, 300 - class91.loadingBarPercentage * 3, 30, 0);
            var0.method4934(class91.loadingText, class91.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         String var7;
         short var17;
         int var18;
         short var19;
         if(Client.gameState == 20) {
            class91.field1333.method5246(class91.loginWindowX + 180 - class91.field1333.originalWidth / 2, 271 - class91.field1333.height / 2);
            var17 = 201;
            var0.method4934(class91.loginMessage1, class91.loginWindowX + 180, var17, 16776960, 0);
            var18 = var17 + 15;
            var0.method4934(class91.loginMessage2, class91.loginWindowX + 180, var18, 16776960, 0);
            var18 += 15;
            var0.method4934(class91.loginMessage3, class91.loginWindowX + 180, var18, 16776960, 0);
            var18 += 15;
            var18 += 7;
            if(class91.loginIndex != 4) {
               var0.method4931("Login: ", class91.loginWindowX + 180 - 110, var18, 16777215, 0);
               var19 = 200;
               var6 = Buffer.preferences.field1232?class209.method3839(class91.username):class91.username;

               for(var7 = var6; var0.method4926(var7) > var19; var7 = var7.substring(0, var7.length() - 1)) {
                  ;
               }

               var0.method4931(FontTypeFace.appendTags(var7), class91.loginWindowX + 180 - 70, var18, 16777215, 0);
               var18 += 15;
               var0.method4931("Password: " + class209.method3839(class91.password), class91.loginWindowX + 180 - 108, var18, 16777215, 0);
               var18 += 15;
            }
         }

         int var8;
         int var10;
         int var24;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class91.field1333.method5246(class91.loginWindowX, 171);
            short var14;
            if(class91.loginIndex == 0) {
               var17 = 251;
               var0.method4934("Welcome to RuneScape", class91.loginWindowX + 180, var17, 16776960, 0);
               var18 = var17 + 30;
               var5 = class91.loginWindowX + 180 - 80;
               var14 = 291;
               class91.field1334.method5246(var5 - 73, var14 - 20);
               var0.method4935("New User", var5 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class91.loginWindowX + 180 + 80;
               class91.field1334.method5246(var5 - 73, var14 - 20);
               var0.method4935("Existing User", var5 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class91.loginIndex == 1) {
               var0.method4934(class91.field1351, class91.loginWindowX + 180, 201, 16776960, 0);
               var17 = 236;
               var0.method4934(class91.loginMessage1, class91.loginWindowX + 180, var17, 16777215, 0);
               var18 = var17 + 15;
               var0.method4934(class91.loginMessage2, class91.loginWindowX + 180, var18, 16777215, 0);
               var18 += 15;
               var0.method4934(class91.loginMessage3, class91.loginWindowX + 180, var18, 16777215, 0);
               var18 += 15;
               var5 = class91.loginWindowX + 180 - 80;
               var14 = 321;
               class91.field1334.method5246(var5 - 73, var14 - 20);
               var0.method4934("Continue", var5, var14 + 5, 16777215, 0);
               var5 = class91.loginWindowX + 180 + 80;
               class91.field1334.method5246(var5 - 73, var14 - 20);
               var0.method4934("Cancel", var5, var14 + 5, 16777215, 0);
            } else if(class91.loginIndex == 2) {
               var17 = 201;
               var0.method4934(class91.loginMessage1, class233.field3209, var17, 16776960, 0);
               var18 = var17 + 15;
               var0.method4934(class91.loginMessage2, class233.field3209, var18, 16776960, 0);
               var18 += 15;
               var0.method4934(class91.loginMessage3, class233.field3209, var18, 16776960, 0);
               var18 += 15;
               var18 += 7;
               var0.method4931("Login: ", class233.field3209 - 110, var18, 16777215, 0);
               var19 = 200;
               var6 = Buffer.preferences.field1232?class209.method3839(class91.username):class91.username;

               for(var7 = var6; var0.method4926(var7) > var19; var7 = var7.substring(1)) {
                  ;
               }

               var0.method4931(FontTypeFace.appendTags(var7) + (class91.field1350 == 0 & Client.gameCycle % 40 < 20?WallObject.getColTags(16776960) + "|":""), class233.field3209 - 70, var18, 16777215, 0);
               var18 += 15;
               var0.method4931("Password: " + class209.method3839(class91.password) + (class91.field1350 == 1 & Client.gameCycle % 40 < 20?WallObject.getColTags(16776960) + "|":""), class233.field3209 - 108, var18, 16777215, 0);
               var18 += 15;
               var17 = 277;
               var8 = class233.field3209 + -117;
               IndexedSprite var16 = class17.method144(class91.field1357, class91.field1359);
               var16.method5246(var8, var17);
               var8 = var8 + var16.originalWidth + 5;
               var1.method4931("Remember username", var8, var17 + 13, 16776960, 0);
               var8 = class233.field3209 + 24;
               var16 = class17.method144(Buffer.preferences.field1232, class91.field1360);
               var16.method5246(var8, var17);
               var8 = var8 + var16.originalWidth + 5;
               var1.method4931("Hide username", var8, var17 + 13, 16776960, 0);
               var18 = var17 + 15;
               var10 = class233.field3209 - 80;
               short var11 = 321;
               class91.field1334.method5246(var10 - 73, var11 - 20);
               var0.method4934("Login", var10, var11 + 5, 16777215, 0);
               var10 = class233.field3209 + 80;
               class91.field1334.method5246(var10 - 73, var11 - 20);
               var0.method4934("Cancel", var10, var11 + 5, 16777215, 0);
               var17 = 357;
               var1.method4934("Forgotten your password? <col=ffffff>Click here.", class233.field3209, var17, 16776960, 0);
            } else if(class91.loginIndex == 3) {
               var17 = 201;
               var0.method4934("Invalid username or password.", class91.loginWindowX + 180, var17, 16776960, 0);
               var18 = var17 + 20;
               var1.method4934("For accounts created after 24th November 2010, please use your", class91.loginWindowX + 180, var18, 16776960, 0);
               var18 += 15;
               var1.method4934("email address to login. Otherwise please login with your username.", class91.loginWindowX + 180, var18, 16776960, 0);
               var18 += 15;
               var5 = class91.loginWindowX + 180;
               var14 = 276;
               class91.field1334.method5246(var5 - 73, var14 - 20);
               var2.method4934("Try again", var5, var14 + 5, 16777215, 0);
               var5 = class91.loginWindowX + 180;
               var14 = 326;
               class91.field1334.method5246(var5 - 73, var14 - 20);
               var2.method4934("Forgotten password?", var5, var14 + 5, 16777215, 0);
            } else {
               short var9;
               if(class91.loginIndex == 4) {
                  var0.method4934("Authenticator", class91.loginWindowX + 180, 201, 16776960, 0);
                  var17 = 236;
                  var0.method4934(class91.loginMessage1, class91.loginWindowX + 180, var17, 16777215, 0);
                  var18 = var17 + 15;
                  var0.method4934(class91.loginMessage2, class91.loginWindowX + 180, var18, 16777215, 0);
                  var18 += 15;
                  var0.method4934(class91.loginMessage3, class91.loginWindowX + 180, var18, 16777215, 0);
                  var18 += 15;
                  var0.method4931("PIN: " + class209.method3839(class268.field3685) + (Client.gameCycle % 40 < 20?WallObject.getColTags(16776960) + "|":""), class91.loginWindowX + 180 - 108, var18, 16777215, 0);
                  var18 -= 8;
                  var0.method4931("Trust this computer", class91.loginWindowX + 180 - 9, var18, 16776960, 0);
                  var18 += 15;
                  var0.method4931("for 30 days: ", class91.loginWindowX + 180 - 9, var18, 16776960, 0);
                  var5 = 180 + class91.loginWindowX - 9 + var0.method4926("for 30 days: ") + 15;
                  var24 = var18 - var0.verticalSpace;
                  IndexedSprite var20;
                  if(class91.field1338) {
                     var20 = class296.field3859;
                  } else {
                     var20 = WallObject.field2046;
                  }

                  var20.method5246(var5, var24);
                  var18 += 15;
                  var8 = class91.loginWindowX + 180 - 80;
                  var9 = 321;
                  class91.field1334.method5246(var8 - 73, var9 - 20);
                  var0.method4934("Continue", var8, var9 + 5, 16777215, 0);
                  var8 = class91.loginWindowX + 180 + 80;
                  class91.field1334.method5246(var8 - 73, var9 - 20);
                  var0.method4934("Cancel", var8, var9 + 5, 16777215, 0);
                  var1.method4934("<u=ff>Can\'t Log In?</u>", class91.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class91.loginIndex == 5) {
                  var0.method4934("Forgotten your password?", class91.loginWindowX + 180, 201, 16776960, 0);
                  var17 = 221;
                  var2.method4934(class91.loginMessage1, class91.loginWindowX + 180, var17, 16776960, 0);
                  var18 = var17 + 15;
                  var2.method4934(class91.loginMessage2, class91.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var2.method4934(class91.loginMessage3, class91.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var18 += 14;
                  var0.method4931("Username/email: ", class91.loginWindowX + 180 - 145, var18, 16777215, 0);
                  var19 = 174;
                  var6 = Buffer.preferences.field1232?class209.method3839(class91.username):class91.username;

                  for(var7 = var6; var0.method4926(var7) > var19; var7 = var7.substring(1)) {
                     ;
                  }

                  var0.method4931(FontTypeFace.appendTags(var7) + (Client.gameCycle % 40 < 20?WallObject.getColTags(16776960) + "|":""), class91.loginWindowX + 180 - 34, var18, 16777215, 0);
                  var18 += 15;
                  var8 = class91.loginWindowX + 180 - 80;
                  var9 = 321;
                  class91.field1334.method5246(var8 - 73, var9 - 20);
                  var0.method4934("Recover", var8, var9 + 5, 16777215, 0);
                  var8 = class91.loginWindowX + 180 + 80;
                  class91.field1334.method5246(var8 - 73, var9 - 20);
                  var0.method4934("Back", var8, var9 + 5, 16777215, 0);
               } else if(class91.loginIndex == 6) {
                  var17 = 201;
                  var0.method4934(class91.loginMessage1, class91.loginWindowX + 180, var17, 16776960, 0);
                  var18 = var17 + 15;
                  var0.method4934(class91.loginMessage2, class91.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var0.method4934(class91.loginMessage3, class91.loginWindowX + 180, var18, 16776960, 0);
                  var18 += 15;
                  var5 = class91.loginWindowX + 180;
                  var14 = 321;
                  class91.field1334.method5246(var5 - 73, var14 - 20);
                  var0.method4934("Back", var5, var14 + 5, 16777215, 0);
               }
            }
         }

         if(class91.field1366 > 0) {
            var18 = class91.field1366;
            var19 = 256;
            class91.field1344 += var18 * 128;
            if(class91.field1344 > Permission.field3243.length) {
               class91.field1344 -= Permission.field3243.length;
               var24 = (int)(Math.random() * 12.0D);
               class64.method1148(class91.field1335[var24]);
            }

            var24 = 0;
            int var15 = var18 * 128;
            var8 = (var19 - var18) * 128;

            int var21;
            for(var21 = 0; var21 < var8; ++var21) {
               var10 = CombatInfoListHolder.field1288[var15 + var24] - Permission.field3243[var24 + class91.field1344 & Permission.field3243.length - 1] * var18 / 6;
               if(var10 < 0) {
                  var10 = 0;
               }

               CombatInfoListHolder.field1288[var24++] = var10;
            }

            int var12;
            int var22;
            for(var21 = var19 - var18; var21 < var19; ++var21) {
               var10 = var21 * 128;

               for(var22 = 0; var22 < 128; ++var22) {
                  var12 = (int)(Math.random() * 100.0D);
                  if(var12 < 50 && var22 > 10 && var22 < 118) {
                     CombatInfoListHolder.field1288[var10 + var22] = 255;
                  } else {
                     CombatInfoListHolder.field1288[var10 + var22] = 0;
                  }
               }
            }

            if(class91.field1331 > 0) {
               class91.field1331 -= var18 * 4;
            }

            if(class91.field1343 > 0) {
               class91.field1343 -= var18 * 4;
            }

            if(class91.field1331 == 0 && class91.field1343 == 0) {
               var21 = (int)(Math.random() * (double)(2000 / var18));
               if(var21 == 0) {
                  class91.field1331 = 1024;
               }

               if(var21 == 1) {
                  class91.field1343 = 1024;
               }
            }

            for(var21 = 0; var21 < var19 - var18; ++var21) {
               class91.field1369[var21] = class91.field1369[var21 + var18];
            }

            for(var21 = var19 - var18; var21 < var19; ++var21) {
               class91.field1369[var21] = (int)(Math.sin((double)class91.field1347 / 14.0D) * 16.0D + Math.sin((double)class91.field1347 / 15.0D) * 14.0D + Math.sin((double)class91.field1347 / 16.0D) * 12.0D);
               ++class91.field1347;
            }

            class91.field1345 += var18;
            var21 = (var18 + (Client.gameCycle & 1)) / 2;
            if(var21 > 0) {
               for(var10 = 0; var10 < class91.field1345 * 100; ++var10) {
                  var22 = (int)(Math.random() * 124.0D) + 2;
                  var12 = (int)(Math.random() * 128.0D) + 128;
                  CombatInfoListHolder.field1288[var22 + (var12 << 7)] = 192;
               }

               class91.field1345 = 0;
               var10 = 0;

               label295:
               while(true) {
                  int var13;
                  if(var10 >= var19) {
                     var10 = 0;

                     while(true) {
                        if(var10 >= 128) {
                           break label295;
                        }

                        var22 = 0;

                        for(var12 = -var21; var12 < var19; ++var12) {
                           var13 = var12 * 128;
                           if(var21 + var12 < var19) {
                              var22 += class13.field281[var13 + var10 + var21 * 128];
                           }

                           if(var12 - (var21 + 1) >= 0) {
                              var22 -= class13.field281[var13 + var10 - (var21 + 1) * 128];
                           }

                           if(var12 >= 0) {
                              CombatInfoListHolder.field1288[var13 + var10] = var22 / (var21 * 2 + 1);
                           }
                        }

                        ++var10;
                     }
                  }

                  var22 = 0;
                  var12 = var10 * 128;

                  for(var13 = -var21; var13 < 128; ++var13) {
                     if(var13 + var21 < 128) {
                        var22 += CombatInfoListHolder.field1288[var12 + var13 + var21];
                     }

                     if(var13 - (var21 + 1) >= 0) {
                        var22 -= CombatInfoListHolder.field1288[var13 + var12 - (var21 + 1)];
                     }

                     if(var13 >= 0) {
                        class13.field281[var12 + var13] = var22 / (var21 * 2 + 1);
                     }
                  }

                  ++var10;
               }
            }

            class91.field1366 = 0;
         }

         class218.method4088();
         class91.titlemuteSprite[Buffer.preferences.muted?1:0].method5246(class91.field1332 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(ItemContainer.field750 != null) {
               var18 = class91.field1332 + 5;
               var19 = 463;
               byte var25 = 100;
               byte var23 = 35;
               ItemContainer.field750.method5246(var18, var19);
               var0.method4934("World" + " " + Client.world, var25 / 2 + var18, var23 / 2 + var19 - 2, 16777215, 0);
               if(class72.listFetcher != null) {
                  var1.method4934("Loading...", var25 / 2 + var18, var23 / 2 + var19 + 12, 16777215, 0);
               } else {
                  var1.method4934("Click to switch", var25 / 2 + var18, var23 / 2 + var19 + 12, 16777215, 0);
               }
            } else {
               ItemContainer.field750 = class250.getSprite(class96.indexSprites, "sl_button", "");
            }
         }

      }
   }
}
