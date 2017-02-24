import java.awt.Graphics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2018227225
   )
   int field877;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1461022819
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1979661125
   )
   @Export("x1")
   int x1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -636961183
   )
   @Export("y1")
   int y1;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 761497605
   )
   int field881;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1650914999
   )
   int field882;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -563182409
   )
   @Export("startTime")
   int startTime;
   @ObfuscatedName("s")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1199936089
   )
   int field885 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -386149887
   )
   @Export("start")
   int start;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2033220551
   )
   @Export("interacting")
   int interacting;
   @ObfuscatedName("v")
   @Export("z")
   double z;
   @ObfuscatedName("u")
   @Export("x")
   double x;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1912695141
   )
   @Export("id")
   int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1522394515
   )
   @Export("z1")
   int z1;
   @ObfuscatedName("z")
   @Export("scalar")
   double scalar;
   @ObfuscatedName("t")
   @Export("velocityY")
   double velocityY;
   @ObfuscatedName("b")
   @Export("velocityZ")
   double velocityZ;
   @ObfuscatedName("w")
   @Export("az")
   double az;
   @ObfuscatedName("f")
   double field897;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1636740811
   )
   int field898;
   @ObfuscatedName("l")
   @Export("animationSequence")
   Sequence animationSequence;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1722015555
   )
   int field900 = 0;
   @ObfuscatedName("y")
   @Export("velocityX")
   double velocityX;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1868877133
   )
   int field902;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass159;II)Z",
      garbageValue = "-1708661185"
   )
   static boolean method866(class159 var0, int var1) {
      int var2 = var0.method3095(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3095(1) != 0) {
            method866(var0, var1);
         }

         var3 = var0.method3095(13);
         var4 = var0.method3095(13);
         boolean var12 = var0.method3095(1) == 1;
         if(var12) {
            class45.field916[++class45.field928 - 1] = var1;
         }

         if(null != Client.cachedPlayers[var1]) {
            throw new RuntimeException();
         } else {
            Player var11 = Client.cachedPlayers[var1] = new Player();
            var11.field255 = var1;
            if(class45.field920[var1] != null) {
               var11.method226(class45.field920[var1]);
            }

            var11.field674 = class45.field926[var1];
            var11.interacting = class45.field927[var1];
            var7 = class45.field925[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var11.field680[0] = class45.field923[var1];
            var11.field277 = (byte)var8;
            var11.method230(var3 + (var9 << 13) - class5.baseX, var4 + (var10 << 13) - class24.baseY);
            var11.field261 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3095(2);
         var4 = class45.field925[var1];
         class45.field925[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var6;
         if(var2 == 2) {
            var3 = var0.method3095(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var6 = class45.field925[var1];
            var7 = var4 + (var6 >> 28) & 3;
            var8 = var6 >> 14 & 255;
            var9 = var6 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class45.field925[var1] = var9 + (var7 << 28) + (var8 << 14);
            return false;
         } else {
            var3 = var0.method3095(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var6 = var3 & 255;
            var7 = class45.field925[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var6 + var7 & 255;
            class45.field925[var1] = var10 + (var8 << 28) + (var9 << 14);
            return false;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "2134165509"
   )
   final void method867(int var1, int var2, int var3, int var4) {
      double var5;
      if(!this.isMoving) {
         var5 = (double)(var1 - this.x1);
         double var7 = (double)(var2 - this.y1);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.start * var5 / var9 + (double)this.x1;
         this.velocityZ = (double)this.y1 + var7 * (double)this.start / var9;
         this.z = (double)this.z1;
      }

      var5 = (double)(this.field877 + 1 - var4);
      this.field897 = ((double)var1 - this.x) / var5;
      this.scalar = ((double)var2 - this.velocityZ) / var5;
      this.velocityY = Math.sqrt(this.field897 * this.field897 + this.scalar * this.scalar);
      if(!this.isMoving) {
         this.velocityX = -this.velocityY * Math.tan((double)this.field902 * 0.02454369D);
      }

      this.az = 2.0D * ((double)var3 - this.z - this.velocityX * var5) / (var5 * var5);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1486872393"
   )
   final void method868(int var1) {
      this.isMoving = true;
      this.x += this.field897 * (double)var1;
      this.velocityZ += (double)var1 * this.scalar;
      this.z += 0.5D * this.az * (double)var1 * (double)var1 + (double)var1 * this.velocityX;
      this.velocityX += (double)var1 * this.az;
      this.field882 = (int)(Math.atan2(this.field897, this.scalar) * 325.949D) + 1024 & 2047;
      this.field898 = (int)(Math.atan2(this.velocityX, this.velocityY) * 325.949D) & 2047;
      if(null != this.animationSequence) {
         this.field900 += var1;

         while(true) {
            do {
               do {
                  if(this.field900 <= this.animationSequence.frameLenghts[this.field885]) {
                     return;
                  }

                  this.field900 -= this.animationSequence.frameLenghts[this.field885];
                  ++this.field885;
               } while(this.field885 < this.animationSequence.frameIDs.length);

               this.field885 -= this.animationSequence.frameStep;
            } while(this.field885 >= 0 && this.field885 < this.animationSequence.frameIDs.length);

            this.field885 = 0;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "286397846"
   )
   protected final Model getModel() {
      Spotanim var1 = Renderable.method1953(this.id);
      Model var2 = var1.method3472(this.field885);
      if(var2 == null) {
         return null;
      } else {
         var2.method1611(this.field898);
         return var2;
      }
   }

   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "-96"
   )
   static void method872(int var0, int var1) {
      Client.field348.method3073(50);
      Client.field348.method2831(var1);
      Client.field348.method2876(var0);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LFont;LFont;LFont;ZI)V",
      garbageValue = "2133377235"
   )
   static void method874(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class41.field839 = (class32.field758 - Client.field563) / 2;
         class41.loginWindowX = 202 + class41.field839;
      }

      if(class41.worldSelectShown) {
         class18.method198(var0, var1);
      } else {
         if(var3) {
            class5.field60.method4171(class41.field839, 0);
            XGrandExchangeOffer.field57.method4171(382 + class41.field839, 0);
            XGrandExchangeOffer.field46.method4122(382 + class41.field839 - XGrandExchangeOffer.field46.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method3901("RuneScape is loading - please wait...", 180 + class41.loginWindowX, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.method4017(180 + class41.loginWindowX - 152, var5, 304, 34, 9179409);
            Rasterizer2D.method4017(class41.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.method4011(class41.loginWindowX + 180 - 150, var5 + 2, class41.field851 * 3, 30, 9179409);
            Rasterizer2D.method4011(180 + class41.loginWindowX - 150 + class41.field851 * 3, var5 + 2, 300 - class41.field851 * 3, 30, 0);
            var0.method3901(class41.field876, class41.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         String var8;
         String var9;
         String var10;
         short var23;
         int var24;
         short var25;
         if(Client.gameState == 20) {
            class41.field871.method4122(class41.loginWindowX + 180 - class41.field871.originalWidth / 2, 271 - class41.field871.height / 2);
            var23 = 211;
            var0.method3901(class41.loginMessage1, class41.loginWindowX + 180, var23, 16776960, 0);
            var24 = var23 + 15;
            var0.method3901(class41.loginMessage2, 180 + class41.loginWindowX, var24, 16776960, 0);
            var24 += 15;
            var0.method3901(class41.loginMessage3, class41.loginWindowX + 180, var24, 16776960, 0);
            var24 += 15;
            var24 += 10;
            if(class41.loginIndex != 4) {
               var0.method3898("Login: ", 180 + class41.loginWindowX - 110, var24, 16777215, 0);
               var25 = 200;

               for(var6 = class41.username; var0.method3921(var6) > var25; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method3898(FontTypeFace.method3958(var6), 180 + class41.loginWindowX - 70, var24, 16777215, 0);
               var24 += 15;
               var8 = "Password: ";
               var10 = class41.field864;
               var9 = class5.method70('*', var10.length());
               var0.method3898(var8 + var9, 180 + class41.loginWindowX - 108, var24, 16777215, 0);
               var24 += 15;
            }
         }

         int var11;
         int var16;
         int var17;
         int var19;
         int var26;
         if(Client.gameState == 10 || Client.gameState == 11) {
            class41.field871.method4122(class41.loginWindowX, 171);
            short var14;
            if(class41.loginIndex == 0) {
               var23 = 251;
               var0.method3901("Welcome to RuneScape", 180 + class41.loginWindowX, var23, 16776960, 0);
               var24 = var23 + 30;
               var5 = class41.loginWindowX + 180 - 80;
               var14 = 291;
               class203.field3076.method4122(var5 - 73, var14 - 20);
               var0.method3902("New User", var5 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = 80 + class41.loginWindowX + 180;
               class203.field3076.method4122(var5 - 73, var14 - 20);
               var0.method3902("Existing User", var5 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3901(class41.field859, class41.loginWindowX + 180, 211, 16776960, 0);
               var23 = 236;
               var0.method3901(class41.loginMessage1, class41.loginWindowX + 180, var23, 16777215, 0);
               var24 = var23 + 15;
               var0.method3901(class41.loginMessage2, 180 + class41.loginWindowX, var24, 16777215, 0);
               var24 += 15;
               var0.method3901(class41.loginMessage3, class41.loginWindowX + 180, var24, 16777215, 0);
               var24 += 15;
               var5 = class41.loginWindowX + 180 - 80;
               var14 = 321;
               class203.field3076.method4122(var5 - 73, var14 - 20);
               var0.method3901("Continue", var5, 5 + var14, 16777215, 0);
               var5 = 80 + class41.loginWindowX + 180;
               class203.field3076.method4122(var5 - 73, var14 - 20);
               var0.method3901("Cancel", var5, 5 + var14, 16777215, 0);
            } else if(class41.loginIndex == 2) {
               var23 = 211;
               var0.method3901(class41.loginMessage1, 180 + class41.loginWindowX, var23, 16776960, 0);
               var24 = var23 + 15;
               var0.method3901(class41.loginMessage2, 180 + class41.loginWindowX, var24, 16776960, 0);
               var24 += 15;
               var0.method3901(class41.loginMessage3, 180 + class41.loginWindowX, var24, 16776960, 0);
               var24 += 15;
               var24 += 10;
               var0.method3898("Login: ", class41.loginWindowX + 180 - 110, var24, 16777215, 0);
               var25 = 200;

               for(var6 = class41.username; var0.method3921(var6) > var25; var6 = var6.substring(1)) {
                  ;
               }

               var0.method3898(FontTypeFace.method3958(var6) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class18.method199(16776960) + "|":""), 180 + class41.loginWindowX - 70, var24, 16777215, 0);
               var24 += 15;
               var8 = "Password: ";
               var10 = class41.field864;
               var9 = class5.method70('*', var10.length());
               var0.method3898(var8 + var9 + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class18.method199(16776960) + "|":""), class41.loginWindowX + 180 - 108, var24, 16777215, 0);
               var24 += 15;
               var11 = class41.loginWindowX + 180 - 80;
               short var12 = 321;
               class203.field3076.method4122(var11 - 73, var12 - 20);
               var0.method3901("Login", var11, 5 + var12, 16777215, 0);
               var11 = 80 + 180 + class41.loginWindowX;
               class203.field3076.method4122(var11 - 73, var12 - 20);
               var0.method3901("Cancel", var11, 5 + var12, 16777215, 0);
               var23 = 357;
               var1.method3901("Forgotten your password? <col=ffffff>Click here.", 180 + class41.loginWindowX, var23, 16776960, 0);
            } else if(class41.loginIndex == 3) {
               var23 = 201;
               var0.method3901("Invalid username or password.", class41.loginWindowX + 180, var23, 16776960, 0);
               var24 = var23 + 20;
               var1.method3901("For accounts created after 24th November 2010, please use your", 180 + class41.loginWindowX, var24, 16776960, 0);
               var24 += 15;
               var1.method3901("email address to login. Otherwise please login with your username.", class41.loginWindowX + 180, var24, 16776960, 0);
               var24 += 15;
               var5 = class41.loginWindowX + 180;
               var14 = 276;
               class203.field3076.method4122(var5 - 73, var14 - 20);
               var2.method3901("Try again", var5, var14 + 5, 16777215, 0);
               var5 = 180 + class41.loginWindowX;
               var14 = 326;
               class203.field3076.method4122(var5 - 73, var14 - 20);
               var2.method3901("Forgotten password?", var5, var14 + 5, 16777215, 0);
            } else if(class41.loginIndex == 4) {
               var0.method3901("Authenticator", class41.loginWindowX + 180, 211, 16776960, 0);
               var23 = 236;
               var0.method3901(class41.loginMessage1, class41.loginWindowX + 180, var23, 16777215, 0);
               var24 = var23 + 15;
               var0.method3901(class41.loginMessage2, 180 + class41.loginWindowX, var24, 16777215, 0);
               var24 += 15;
               var0.method3901(class41.loginMessage3, 180 + class41.loginWindowX, var24, 16777215, 0);
               var24 += 15;
               var6 = "PIN: ";
               var8 = class30.authCode;
               String var7 = class5.method70('*', var8.length());
               var0.method3898(var6 + var7 + (Client.gameCycle % 40 < 20?class18.method199(16776960) + "|":""), 180 + class41.loginWindowX - 108, var24, 16777215, 0);
               var24 -= 8;
               var0.method3898("Trust this computer", class41.loginWindowX + 180 - 9, var24, 16776960, 0);
               var24 += 15;
               var0.method3898("for 30 days: ", class41.loginWindowX + 180 - 9, var24, 16776960, 0);
               var16 = class41.loginWindowX + 180 - 9 + var0.method3921("for 30 days: ") + 15;
               var17 = var24 - var0.field3105;
               ModIcon var18;
               if(class41.field866) {
                  var18 = class41.field842;
               } else {
                  var18 = class37.field813;
               }

               var18.method4122(var16, var17);
               var24 += 15;
               var26 = 180 + class41.loginWindowX - 80;
               short var13 = 321;
               class203.field3076.method4122(var26 - 73, var13 - 20);
               var0.method3901("Continue", var26, var13 + 5, 16777215, 0);
               var26 = 180 + class41.loginWindowX + 80;
               class203.field3076.method4122(var26 - 73, var13 - 20);
               var0.method3901("Cancel", var26, 5 + var13, 16777215, 0);
               var1.method3901("<u=ff>Can\'t Log In?</u>", class41.loginWindowX + 180, 36 + var13, 255, 0);
            } else if(class41.loginIndex == 5) {
               var0.method3901("Forgotten your password?", 180 + class41.loginWindowX, 201, 16776960, 0);
               var23 = 221;
               var2.method3901(class41.loginMessage1, class41.loginWindowX + 180, var23, 16776960, 0);
               var24 = var23 + 15;
               var2.method3901(class41.loginMessage2, class41.loginWindowX + 180, var24, 16776960, 0);
               var24 += 15;
               var2.method3901(class41.loginMessage3, 180 + class41.loginWindowX, var24, 16776960, 0);
               var24 += 15;
               var24 += 14;
               var0.method3898("Username/email: ", class41.loginWindowX + 180 - 145, var24, 16777215, 0);
               var25 = 174;

               for(var6 = class41.username; var0.method3921(var6) > var25; var6 = var6.substring(1)) {
                  ;
               }

               var0.method3898(FontTypeFace.method3958(var6) + (Client.gameCycle % 40 < 20?class18.method199(16776960) + "|":""), class41.loginWindowX + 180 - 34, var24, 16777215, 0);
               var24 += 15;
               var19 = 180 + class41.loginWindowX - 80;
               short var20 = 321;
               class203.field3076.method4122(var19 - 73, var20 - 20);
               var0.method3901("Recover", var19, 5 + var20, 16777215, 0);
               var19 = 80 + class41.loginWindowX + 180;
               class203.field3076.method4122(var19 - 73, var20 - 20);
               var0.method3901("Back", var19, 5 + var20, 16777215, 0);
            } else if(class41.loginIndex == 6) {
               var23 = 211;
               var0.method3901(class41.loginMessage1, 180 + class41.loginWindowX, var23, 16776960, 0);
               var24 = var23 + 15;
               var0.method3901(class41.loginMessage2, 180 + class41.loginWindowX, var24, 16776960, 0);
               var24 += 15;
               var0.method3901(class41.loginMessage3, 180 + class41.loginWindowX, var24, 16776960, 0);
               var24 += 15;
               var5 = class41.loginWindowX + 180;
               var14 = 321;
               class203.field3076.method4122(var5 - 73, var14 - 20);
               var0.method3901("Back", var5, 5 + var14, 16777215, 0);
            }
         }

         if(class41.field838 > 0) {
            var24 = class41.field838;
            var25 = 256;
            class41.field852 += 128 * var24;
            int var28;
            if(class41.field852 > class41.field854.length) {
               class41.field852 -= class41.field854.length;
               var28 = (int)(Math.random() * 12.0D);
               class8.method99(ChatLineBuffer.field989[var28]);
            }

            var28 = 0;
            var19 = 128 * var24;
            int var31 = 128 * (var25 - var24);

            for(var16 = 0; var16 < var31; ++var16) {
               var17 = class41.field872[var28 + var19] - class41.field854[var28 + class41.field852 & class41.field854.length - 1] * var24 / 6;
               if(var17 < 0) {
                  var17 = 0;
               }

               class41.field872[var28++] = var17;
            }

            for(var16 = var25 - var24; var16 < var25; ++var16) {
               var17 = var16 * 128;

               for(var11 = 0; var11 < 128; ++var11) {
                  var26 = (int)(Math.random() * 100.0D);
                  if(var26 < 50 && var11 > 10 && var11 < 118) {
                     class41.field872[var11 + var17] = 255;
                  } else {
                     class41.field872[var11 + var17] = 0;
                  }
               }
            }

            if(class41.field848 > 0) {
               class41.field848 -= var24 * 4;
            }

            if(class41.field849 > 0) {
               class41.field849 -= 4 * var24;
            }

            if(class41.field848 == 0 && class41.field849 == 0) {
               var16 = (int)(Math.random() * (double)(2000 / var24));
               if(var16 == 0) {
                  class41.field848 = 1024;
               }

               if(var16 == 1) {
                  class41.field849 = 1024;
               }
            }

            for(var16 = 0; var16 < var25 - var24; ++var16) {
               class41.field846[var16] = class41.field846[var24 + var16];
            }

            for(var16 = var25 - var24; var16 < var25; ++var16) {
               class41.field846[var16] = (int)(Math.sin((double)class41.field855 / 14.0D) * 16.0D + Math.sin((double)class41.field855 / 15.0D) * 14.0D + Math.sin((double)class41.field855 / 16.0D) * 12.0D);
               ++class41.field855;
            }

            class41.field853 += var24;
            var16 = ((Client.gameCycle & 1) + var24) / 2;
            if(var16 > 0) {
               for(var17 = 0; var17 < class41.field853 * 100; ++var17) {
                  var11 = (int)(Math.random() * 124.0D) + 2;
                  var26 = (int)(Math.random() * 128.0D) + 128;
                  class41.field872[(var26 << 7) + var11] = 192;
               }

               class41.field853 = 0;
               var17 = 0;

               label269:
               while(true) {
                  int var27;
                  if(var17 >= var25) {
                     var17 = 0;

                     while(true) {
                        if(var17 >= 128) {
                           break label269;
                        }

                        var11 = 0;

                        for(var26 = -var16; var26 < var25; ++var26) {
                           var27 = 128 * var26;
                           if(var16 + var26 < var25) {
                              var11 += VertexNormal.field1443[128 * var16 + var17 + var27];
                           }

                           if(var26 - (var16 + 1) >= 0) {
                              var11 -= VertexNormal.field1443[var17 + var27 - (var16 + 1) * 128];
                           }

                           if(var26 >= 0) {
                              class41.field872[var17 + var27] = var11 / (var16 * 2 + 1);
                           }
                        }

                        ++var17;
                     }
                  }

                  var11 = 0;
                  var26 = var17 * 128;

                  for(var27 = -var16; var27 < 128; ++var27) {
                     if(var16 + var27 < 128) {
                        var11 += class41.field872[var16 + var27 + var26];
                     }

                     if(var27 - (1 + var16) >= 0) {
                        var11 -= class41.field872[var27 + var26 - (var16 + 1)];
                     }

                     if(var27 >= 0) {
                        VertexNormal.field1443[var26 + var27] = var11 / (1 + var16 * 2);
                     }
                  }

                  ++var17;
               }
            }

            class41.field838 = 0;
         }

         class183.method3382();
         class41.field874[class184.field2735.field720?1:0].method4122(765 + class41.field839 - 40, 463);
         if(Client.gameState > 5 && Client.field309 == 0) {
            if(null != class8.field84) {
               var24 = class41.field839 + 5;
               var25 = 463;
               byte var29 = 100;
               byte var30 = 35;
               class8.field84.method4122(var24, var25);
               var0.method3901("World" + " " + Client.world, var24 + var29 / 2, var25 + var30 / 2 - 2, 16777215, 0);
               if(Ignore.worldServersDownload != null) {
                  var1.method3901("Loading...", var24 + var29 / 2, var30 / 2 + var25 + 12, 16777215, 0);
               } else {
                  var1.method3901("Click to switch", var24 + var29 / 2, var30 / 2 + var25 + 12, 16777215, 0);
               }
            } else {
               class8.field84 = class72.method1431(class165.field2167, "sl_button", "");
            }
         }

         try {
            Graphics var21 = GameObject.canvas.getGraphics();
            CombatInfo1.bufferProvider.draw(var21, 0, 0);
         } catch (Exception var22) {
            GameObject.canvas.repaint();
         }

      }
   }

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.floor = var2;
      this.x1 = var3;
      this.y1 = var4;
      this.z1 = var5;
      this.startTime = var6;
      this.field877 = var7;
      this.field902 = var8;
      this.start = var9;
      this.interacting = var10;
      this.field881 = var11;
      this.isMoving = false;
      int var12 = Renderable.method1953(this.id).field2807;
      if(var12 != -1) {
         this.animationSequence = class195.getAnimation(var12);
      } else {
         this.animationSequence = null;
      }

   }
}
