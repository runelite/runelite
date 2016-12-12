import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class49 extends Renderable {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1812603039
   )
   int field958;
   @ObfuscatedName("a")
   Sequence field959;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1718459827
   )
   int field960;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -127398273
   )
   int field961;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 292198385
   )
   int field962;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1370481031
   )
   int field963;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 408444373
   )
   int field964;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 37294633
   )
   int field965;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 373239233
   )
   int field966;

   class49(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, Renderable var9) {
      this.field958 = var1;
      this.field962 = var2;
      this.field960 = var3;
      this.field961 = var4;
      this.field965 = var5;
      this.field963 = var6;
      if(var7 != -1) {
         this.field959 = GameEngine.getAnimation(var7);
         this.field964 = 0;
         this.field966 = Client.gameCycle - 1;
         if(this.field959.replyMode == 0 && var9 != null && var9 instanceof class49) {
            class49 var10 = (class49)var9;
            if(var10.field959 == this.field959) {
               this.field964 = var10.field964;
               this.field966 = var10.field966;
               return;
            }
         }

         if(var8 && this.field959.frameStep != -1) {
            this.field964 = (int)(Math.random() * (double)this.field959.frameIDs.length);
            this.field966 -= (int)(Math.random() * (double)this.field959.frameLenghts[this.field964]);
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "7"
   )
   protected final Model getModel() {
      if(this.field959 != null) {
         int var12 = Client.gameCycle - this.field966;
         if(var12 > 100 && this.field959.frameStep > 0) {
            var12 = 100;
         }

         label64: {
            do {
               do {
                  if(var12 <= this.field959.frameLenghts[this.field964]) {
                     break label64;
                  }

                  var12 -= this.field959.frameLenghts[this.field964];
                  ++this.field964;
               } while(this.field964 < this.field959.frameIDs.length);

               this.field964 -= this.field959.frameStep;
            } while(this.field964 >= 0 && this.field964 < this.field959.frameIDs.length);

            this.field959 = null;
         }

         this.field966 = Client.gameCycle - var12;
      }

      ObjectComposition var1 = ItemLayer.getObjectDefinition(this.field958);
      if(var1.impostorIds != null) {
         var1 = var1.getImpostor();
      }

      if(null == var1) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field960 != 1 && this.field960 != 3) {
            var2 = var1.field2907;
            var3 = var1.field2908;
         } else {
            var2 = var1.field2908;
            var3 = var1.field2907;
         }

         int var4 = this.field965 + (var2 >> 1);
         int var5 = (var2 + 1 >> 1) + this.field965;
         int var6 = (var3 >> 1) + this.field963;
         int var7 = this.field963 + (1 + var3 >> 1);
         int[][] var8 = class10.tileHeights[this.field961];
         int var9 = var8[var4][var7] + var8[var4][var6] + var8[var5][var6] + var8[var5][var7] >> 2;
         int var10 = (this.field965 << 7) + (var2 << 6);
         int var11 = (this.field963 << 7) + (var3 << 6);
         return var1.method3546(this.field962, this.field960, var8, var10, var9, var11, this.field959, this.field964);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass208;Lclass208;Lclass208;ZI)V",
      garbageValue = "1500126555"
   )
   static void method863(class208 var0, class208 var1, class208 var2, boolean var3) {
      if(var3) {
         class41.field824 = (ItemLayer.field1223 - Client.field501) / 2;
         class41.loginWindowX = class41.field824 + 202;
      }

      if(class41.worldSelectShown) {
         Item.method778(var0, var1);
      } else {
         if(var3) {
            class16.field172.method4071(class41.field824, 0);
            class41.field861.method4071(382 + class41.field824, 0);
            class101.field1639.method3979(class41.field824 + 382 - class101.field1639.originalWidth / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.method3782("RuneScape is loading - please wait...", 180 + class41.loginWindowX, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            class219.method3932(180 + class41.loginWindowX - 152, var5, 304, 34, 9179409);
            class219.method3932(class41.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            class219.method3910(180 + class41.loginWindowX - 150, var5 + 2, class41.field842 * 3, 30, 9179409);
            class219.method3910(180 + class41.loginWindowX - 150 + class41.field842 * 3, var5 + 2, 300 - class41.field842 * 3, 30, 0);
            var0.method3782(class41.field843, 180 + class41.loginWindowX, 276 - var4, 16777215, -1);
         }

         String var6;
         String var8;
         String var9;
         String var10;
         short var23;
         int var24;
         short var25;
         if(Client.gameState == 20) {
            class156.field2120.method3979(class41.loginWindowX + 180 - class156.field2120.originalWidth / 2, 271 - class156.field2120.height / 2);
            var23 = 211;
            var0.method3782(class41.loginMessage1, class41.loginWindowX + 180, var23, 16776960, 0);
            var24 = var23 + 15;
            var0.method3782(class41.loginMessage2, class41.loginWindowX + 180, var24, 16776960, 0);
            var24 += 15;
            var0.method3782(class41.loginMessage3, class41.loginWindowX + 180, var24, 16776960, 0);
            var24 += 15;
            var24 += 10;
            if(class41.loginIndex != 4) {
               var0.method3779("Login: ", 180 + class41.loginWindowX - 110, var24, 16777215, 0);
               var25 = 200;

               for(var6 = class41.username; var0.method3774(var6) > var25; var6 = var6.substring(0, var6.length() - 1)) {
                  ;
               }

               var0.method3779(class209.method3778(var6), 180 + class41.loginWindowX - 70, var24, 16777215, 0);
               var24 += 15;
               var8 = "Password: ";
               var10 = class41.field850;
               var9 = class189.method3395('*', var10.length());
               var0.method3779(var8 + var9, 180 + class41.loginWindowX - 108, var24, 16777215, 0);
               var24 += 15;
            }
         }

         if(Client.gameState == 10 || Client.gameState == 11) {
            class156.field2120.method3979(class41.loginWindowX, 171);
            short var14;
            if(class41.loginIndex == 0) {
               var23 = 251;
               var0.method3782("Welcome to RuneScape", class41.loginWindowX + 180, var23, 16776960, 0);
               var24 = var23 + 30;
               var5 = class41.loginWindowX + 180 - 80;
               var14 = 291;
               class41.field826.method3979(var5 - 73, var14 - 20);
               var0.method3773("New User", var5 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class41.loginWindowX + 180 + 80;
               class41.field826.method3979(var5 - 73, var14 - 20);
               var0.method3773("Existing User", var5 - 73, var14 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class41.loginIndex == 1) {
               var0.method3782(class41.field841, class41.loginWindowX + 180, 211, 16776960, 0);
               var23 = 236;
               var0.method3782(class41.loginMessage1, class41.loginWindowX + 180, var23, 16777215, 0);
               var24 = var23 + 15;
               var0.method3782(class41.loginMessage2, class41.loginWindowX + 180, var24, 16777215, 0);
               var24 += 15;
               var0.method3782(class41.loginMessage3, 180 + class41.loginWindowX, var24, 16777215, 0);
               var24 += 15;
               var5 = class41.loginWindowX + 180 - 80;
               var14 = 321;
               class41.field826.method3979(var5 - 73, var14 - 20);
               var0.method3782("Continue", var5, 5 + var14, 16777215, 0);
               var5 = 80 + 180 + class41.loginWindowX;
               class41.field826.method3979(var5 - 73, var14 - 20);
               var0.method3782("Cancel", var5, var14 + 5, 16777215, 0);
            } else if(class41.loginIndex == 2) {
               var23 = 211;
               var0.method3782(class41.loginMessage1, class41.loginWindowX + 180, var23, 16776960, 0);
               var24 = var23 + 15;
               var0.method3782(class41.loginMessage2, class41.loginWindowX + 180, var24, 16776960, 0);
               var24 += 15;
               var0.method3782(class41.loginMessage3, 180 + class41.loginWindowX, var24, 16776960, 0);
               var24 += 15;
               var24 += 10;
               var0.method3779("Login: ", class41.loginWindowX + 180 - 110, var24, 16777215, 0);
               var25 = 200;

               for(var6 = class41.username; var0.method3774(var6) > var25; var6 = var6.substring(1)) {
                  ;
               }

               var0.method3779(class209.method3778(var6) + (class41.loginIndex2 == 0 & Client.gameCycle % 40 < 20?class155.method2949(16776960) + "|":""), 180 + class41.loginWindowX - 70, var24, 16777215, 0);
               var24 += 15;
               var8 = "Password: ";
               var10 = class41.field850;
               var9 = class189.method3395('*', var10.length());
               var0.method3779(var8 + var9 + (class41.loginIndex2 == 1 & Client.gameCycle % 40 < 20?class155.method2949(16776960) + "|":""), 180 + class41.loginWindowX - 108, var24, 16777215, 0);
               var24 += 15;
               int var11 = class41.loginWindowX + 180 - 80;
               short var12 = 321;
               class41.field826.method3979(var11 - 73, var12 - 20);
               var0.method3782("Login", var11, var12 + 5, 16777215, 0);
               var11 = 80 + 180 + class41.loginWindowX;
               class41.field826.method3979(var11 - 73, var12 - 20);
               var0.method3782("Cancel", var11, var12 + 5, 16777215, 0);
               var23 = 357;
               var1.method3782("Forgotten your password? <col=ffffff>Click here.", 180 + class41.loginWindowX, var23, 16776960, 0);
            } else if(class41.loginIndex == 3) {
               var23 = 201;
               var0.method3782("Invalid username or password.", 180 + class41.loginWindowX, var23, 16776960, 0);
               var24 = var23 + 20;
               var1.method3782("For accounts created after 24th November 2010, please use your", 180 + class41.loginWindowX, var24, 16776960, 0);
               var24 += 15;
               var1.method3782("email address to login. Otherwise please login with your username.", 180 + class41.loginWindowX, var24, 16776960, 0);
               var24 += 15;
               var5 = class41.loginWindowX + 180;
               var14 = 276;
               class41.field826.method3979(var5 - 73, var14 - 20);
               var2.method3782("Try again", var5, 5 + var14, 16777215, 0);
               var5 = class41.loginWindowX + 180;
               var14 = 326;
               class41.field826.method3979(var5 - 73, var14 - 20);
               var2.method3782("Forgotten password?", var5, var14 + 5, 16777215, 0);
            } else if(class41.loginIndex == 4) {
               var0.method3782("Authenticator", class41.loginWindowX + 180, 211, 16776960, 0);
               var23 = 236;
               var0.method3782(class41.loginMessage1, 180 + class41.loginWindowX, var23, 16777215, 0);
               var24 = var23 + 15;
               var0.method3782(class41.loginMessage2, class41.loginWindowX + 180, var24, 16777215, 0);
               var24 += 15;
               var0.method3782(class41.loginMessage3, class41.loginWindowX + 180, var24, 16777215, 0);
               var24 += 15;
               var6 = "PIN: ";
               var8 = VertexNormal.authCode;
               String var7 = class189.method3395('*', var8.length());
               var0.method3779(var6 + var7 + (Client.gameCycle % 40 < 20?class155.method2949(16776960) + "|":""), 180 + class41.loginWindowX - 108, var24, 16777215, 0);
               var24 -= 8;
               var0.method3779("Trust this computer", 180 + class41.loginWindowX - 9, var24, 16776960, 0);
               var24 += 15;
               var0.method3779("for 30 days: ", class41.loginWindowX + 180 - 9, var24, 16776960, 0);
               int var16 = 180 + class41.loginWindowX - 9 + var0.method3774("for 30 days: ") + 15;
               int var17 = var24 - var0.field3097;
               ModIcon var18;
               if(class41.field828) {
                  var18 = Friend.field148;
               } else {
                  var18 = class142.field1996;
               }

               var18.method3979(var16, var17);
               var24 += 15;
               int var26 = 180 + class41.loginWindowX - 80;
               short var13 = 321;
               class41.field826.method3979(var26 - 73, var13 - 20);
               var0.method3782("Continue", var26, var13 + 5, 16777215, 0);
               var26 = 80 + class41.loginWindowX + 180;
               class41.field826.method3979(var26 - 73, var13 - 20);
               var0.method3782("Cancel", var26, var13 + 5, 16777215, 0);
               var1.method3782("<u=ff>Can\'t Log In?</u>", 180 + class41.loginWindowX, 36 + var13, 255, 0);
            } else if(class41.loginIndex == 5) {
               var0.method3782("Forgotten your password?", class41.loginWindowX + 180, 201, 16776960, 0);
               var23 = 221;
               var2.method3782(class41.loginMessage1, 180 + class41.loginWindowX, var23, 16776960, 0);
               var24 = var23 + 15;
               var2.method3782(class41.loginMessage2, class41.loginWindowX + 180, var24, 16776960, 0);
               var24 += 15;
               var2.method3782(class41.loginMessage3, 180 + class41.loginWindowX, var24, 16776960, 0);
               var24 += 15;
               var24 += 14;
               var0.method3779("Username/email: ", 180 + class41.loginWindowX - 145, var24, 16777215, 0);
               var25 = 174;

               for(var6 = class41.username; var0.method3774(var6) > var25; var6 = var6.substring(1)) {
                  ;
               }

               var0.method3779(class209.method3778(var6) + (Client.gameCycle % 40 < 20?class155.method2949(16776960) + "|":""), class41.loginWindowX + 180 - 34, var24, 16777215, 0);
               var24 += 15;
               int var19 = class41.loginWindowX + 180 - 80;
               short var20 = 321;
               class41.field826.method3979(var19 - 73, var20 - 20);
               var0.method3782("Recover", var19, 5 + var20, 16777215, 0);
               var19 = 180 + class41.loginWindowX + 80;
               class41.field826.method3979(var19 - 73, var20 - 20);
               var0.method3782("Back", var19, var20 + 5, 16777215, 0);
            } else if(class41.loginIndex == 6) {
               var23 = 211;
               var0.method3782(class41.loginMessage1, 180 + class41.loginWindowX, var23, 16776960, 0);
               var24 = var23 + 15;
               var0.method3782(class41.loginMessage2, 180 + class41.loginWindowX, var24, 16776960, 0);
               var24 += 15;
               var0.method3782(class41.loginMessage3, class41.loginWindowX + 180, var24, 16776960, 0);
               var24 += 15;
               var5 = 180 + class41.loginWindowX;
               var14 = 321;
               class41.field826.method3979(var5 - 73, var14 - 20);
               var0.method3782("Back", var5, 5 + var14, 16777215, 0);
            }
         }

         if(class41.field845 > 0) {
            class176.method3184(class41.field845);
            class41.field845 = 0;
         }

         class139.method2589();
         class210.field3113[class149.field2044.field692?1:0].method3979(765 + class41.field824 - 40, 463);
         if(Client.gameState > 5 && Client.field290 == 0) {
            if(null != class37.field789) {
               var24 = class41.field824 + 5;
               var25 = 463;
               byte var27 = 100;
               byte var28 = 35;
               class37.field789.method3979(var24, var25);
               var0.method3782("World" + " " + Client.world, var24 + var27 / 2, var25 + var28 / 2 - 2, 16777215, 0);
               if(null != class6.worldServersDownload) {
                  var1.method3782("Loading...", var24 + var27 / 2, var25 + var28 / 2 + 12, 16777215, 0);
               } else {
                  var1.method3782("Click to switch", var24 + var27 / 2, 12 + var25 + var28 / 2, 16777215, 0);
               }
            } else {
               class37.field789 = class110.method2048(Client.field314, "sl_button", "");
            }
         }

         try {
            Graphics var21 = class110.canvas.getGraphics();
            ChatMessages.bufferProvider.draw(var21, 0, 0);
         } catch (Exception var22) {
            class110.canvas.repaint();
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "16"
   )
   public static void method864(Component var0) {
      var0.addMouseListener(class115.mouse);
      var0.addMouseMotionListener(class115.mouse);
      var0.addFocusListener(class115.mouse);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIILclass119;LCollisionData;Z[I[II)I",
      garbageValue = "-1761344845"
   )
   public static int method865(int var0, int var1, int var2, class119 var3, CollisionData var4, boolean var5, int[] var6, int[] var7) {
      int var9;
      for(int var8 = 0; var8 < 128; ++var8) {
         for(var9 = 0; var9 < 128; ++var9) {
            class118.field1840[var8][var9] = 0;
            class118.field1841[var8][var9] = 99999999;
         }
      }

      int var10;
      int var11;
      byte var12;
      byte var13;
      int var14;
      int var15;
      byte var16;
      int var17;
      int[][] var18;
      int var19;
      int var20;
      int var21;
      int var22;
      boolean var28;
      boolean var29;
      int var30;
      int var31;
      int var33;
      if(var2 == 1) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class118.field1840[var12][var13] = 99;
         class118.field1841[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class118.field1848[var16] = var0;
         var33 = var16 + 1;
         class118.field1845[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var33 == var17) {
               class118.field1839 = var10;
               class118.field1843 = var11;
               var29 = false;
               break;
            }

            var10 = class118.field1848[var17];
            var11 = class118.field1845[var17];
            var17 = 1 + var17 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod2255(1, var10, var11, var4)) {
               class118.field1839 = var10;
               class118.field1843 = var11;
               var29 = true;
               break;
            }

            var21 = 1 + class118.field1841[var30][var31];
            if(var30 > 0 && class118.field1840[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136776) == 0) {
               class118.field1848[var33] = var10 - 1;
               class118.field1845[var33] = var11;
               var33 = var33 + 1 & 4095;
               class118.field1840[var30 - 1][var31] = 2;
               class118.field1841[var30 - 1][var31] = var21;
            }

            if(var30 < 127 && class118.field1840[1 + var30][var31] == 0 && (var18[var19 + 1][var20] & 19136896) == 0) {
               class118.field1848[var33] = 1 + var10;
               class118.field1845[var33] = var11;
               var33 = 1 + var33 & 4095;
               class118.field1840[1 + var30][var31] = 8;
               class118.field1841[1 + var30][var31] = var21;
            }

            if(var31 > 0 && class118.field1840[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class118.field1848[var33] = var10;
               class118.field1845[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1840[var30][var31 - 1] = 1;
               class118.field1841[var30][var31 - 1] = var21;
            }

            if(var31 < 127 && class118.field1840[var30][1 + var31] == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class118.field1848[var33] = var10;
               class118.field1845[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class118.field1840[var30][1 + var31] = 4;
               class118.field1841[var30][1 + var31] = var21;
            }

            if(var30 > 0 && var31 > 0 && class118.field1840[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class118.field1848[var33] = var10 - 1;
               class118.field1845[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class118.field1840[var30 - 1][var31 - 1] = 3;
               class118.field1841[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 127 && var31 > 0 && class118.field1840[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136899) == 0 && (var18[1 + var19][var20] & 19136896) == 0 && (var18[var19][var20 - 1] & 19136770) == 0) {
               class118.field1848[var33] = 1 + var10;
               class118.field1845[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1840[var30 + 1][var31 - 1] = 9;
               class118.field1841[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 127 && class118.field1840[var30 - 1][1 + var31] == 0 && (var18[var19 - 1][1 + var20] & 19136824) == 0 && (var18[var19 - 1][var20] & 19136776) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class118.field1848[var33] = var10 - 1;
               class118.field1845[var33] = 1 + var11;
               var33 = 1 + var33 & 4095;
               class118.field1840[var30 - 1][var31 + 1] = 6;
               class118.field1841[var30 - 1][1 + var31] = var21;
            }

            if(var30 < 127 && var31 < 127 && class118.field1840[1 + var30][var31 + 1] == 0 && (var18[var19 + 1][1 + var20] & 19136992) == 0 && (var18[var19 + 1][var20] & 19136896) == 0 && (var18[var19][var20 + 1] & 19136800) == 0) {
               class118.field1848[var33] = var10 + 1;
               class118.field1845[var33] = 1 + var11;
               var33 = var33 + 1 & 4095;
               class118.field1840[var30 + 1][1 + var31] = 12;
               class118.field1841[1 + var30][1 + var31] = var21;
            }
         }

         var28 = var29;
      } else if(var2 == 2) {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class118.field1840[var12][var13] = 99;
         class118.field1841[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class118.field1848[var16] = var0;
         var33 = var16 + 1;
         class118.field1845[var16] = var1;
         var18 = var4.flags;

         while(true) {
            if(var33 == var17) {
               class118.field1839 = var10;
               class118.field1843 = var11;
               var29 = false;
               break;
            }

            var10 = class118.field1848[var17];
            var11 = class118.field1845[var17];
            var17 = 1 + var17 & 4095;
            var30 = var10 - var14;
            var31 = var11 - var15;
            var19 = var10 - var4.x;
            var20 = var11 - var4.y;
            if(var3.vmethod2255(2, var10, var11, var4)) {
               class118.field1839 = var10;
               class118.field1843 = var11;
               var29 = true;
               break;
            }

            var21 = 1 + class118.field1841[var30][var31];
            if(var30 > 0 && class118.field1840[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var20 + 1] & 19136824) == 0) {
               class118.field1848[var33] = var10 - 1;
               class118.field1845[var33] = var11;
               var33 = 1 + var33 & 4095;
               class118.field1840[var30 - 1][var31] = 2;
               class118.field1841[var30 - 1][var31] = var21;
            }

            if(var30 < 126 && class118.field1840[1 + var30][var31] == 0 && (var18[var19 + 2][var20] & 19136899) == 0 && (var18[2 + var19][var20 + 1] & 19136992) == 0) {
               class118.field1848[var33] = 1 + var10;
               class118.field1845[var33] = var11;
               var33 = var33 + 1 & 4095;
               class118.field1840[var30 + 1][var31] = 8;
               class118.field1841[1 + var30][var31] = var21;
            }

            if(var31 > 0 && class118.field1840[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[1 + var19][var20 - 1] & 19136899) == 0) {
               class118.field1848[var33] = var10;
               class118.field1845[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1840[var30][var31 - 1] = 1;
               class118.field1841[var30][var31 - 1] = var21;
            }

            if(var31 < 126 && class118.field1840[var30][1 + var31] == 0 && (var18[var19][var20 + 2] & 19136824) == 0 && (var18[1 + var19][2 + var20] & 19136992) == 0) {
               class118.field1848[var33] = var10;
               class118.field1845[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class118.field1840[var30][var31 + 1] = 4;
               class118.field1841[var30][var31 + 1] = var21;
            }

            if(var30 > 0 && var31 > 0 && class118.field1840[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20] & 19136830) == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0 && (var18[var19][var20 - 1] & 19136911) == 0) {
               class118.field1848[var33] = var10 - 1;
               class118.field1845[var33] = var11 - 1;
               var33 = 1 + var33 & 4095;
               class118.field1840[var30 - 1][var31 - 1] = 3;
               class118.field1841[var30 - 1][var31 - 1] = var21;
            }

            if(var30 < 126 && var31 > 0 && class118.field1840[var30 + 1][var31 - 1] == 0 && (var18[var19 + 1][var20 - 1] & 19136911) == 0 && (var18[var19 + 2][var20 - 1] & 19136899) == 0 && (var18[2 + var19][var20] & 19136995) == 0) {
               class118.field1848[var33] = 1 + var10;
               class118.field1845[var33] = var11 - 1;
               var33 = var33 + 1 & 4095;
               class118.field1840[var30 + 1][var31 - 1] = 9;
               class118.field1841[var30 + 1][var31 - 1] = var21;
            }

            if(var30 > 0 && var31 < 126 && class118.field1840[var30 - 1][1 + var31] == 0 && (var18[var19 - 1][var20 + 1] & 19136830) == 0 && (var18[var19 - 1][2 + var20] & 19136824) == 0 && (var18[var19][2 + var20] & 19137016) == 0) {
               class118.field1848[var33] = var10 - 1;
               class118.field1845[var33] = var11 + 1;
               var33 = var33 + 1 & 4095;
               class118.field1840[var30 - 1][var31 + 1] = 6;
               class118.field1841[var30 - 1][1 + var31] = var21;
            }

            if(var30 < 126 && var31 < 126 && class118.field1840[1 + var30][var31 + 1] == 0 && (var18[1 + var19][2 + var20] & 19137016) == 0 && (var18[2 + var19][2 + var20] & 19136992) == 0 && (var18[2 + var19][var20 + 1] & 19136995) == 0) {
               class118.field1848[var33] = 1 + var10;
               class118.field1845[var33] = var11 + 1;
               var33 = 1 + var33 & 4095;
               class118.field1840[1 + var30][1 + var31] = 12;
               class118.field1841[1 + var30][var31 + 1] = var21;
            }
         }

         var28 = var29;
      } else {
         var10 = var0;
         var11 = var1;
         var12 = 64;
         var13 = 64;
         var14 = var0 - var12;
         var15 = var1 - var13;
         class118.field1840[var12][var13] = 99;
         class118.field1841[var12][var13] = 0;
         var16 = 0;
         var17 = 0;
         class118.field1848[var16] = var0;
         var33 = var16 + 1;
         class118.field1845[var16] = var1;
         var18 = var4.flags;

         label904:
         while(true) {
            label902:
            while(true) {
               do {
                  do {
                     do {
                        label879:
                        do {
                           if(var33 == var17) {
                              class118.field1839 = var10;
                              class118.field1843 = var11;
                              var29 = false;
                              break label904;
                           }

                           var10 = class118.field1848[var17];
                           var11 = class118.field1845[var17];
                           var17 = 1 + var17 & 4095;
                           var30 = var10 - var14;
                           var31 = var11 - var15;
                           var19 = var10 - var4.x;
                           var20 = var11 - var4.y;
                           if(var3.vmethod2255(var2, var10, var11, var4)) {
                              class118.field1839 = var10;
                              class118.field1843 = var11;
                              var29 = true;
                              break label904;
                           }

                           var21 = 1 + class118.field1841[var30][var31];
                           if(var30 > 0 && class118.field1840[var30 - 1][var31] == 0 && (var18[var19 - 1][var20] & 19136782) == 0 && (var18[var19 - 1][var2 + var20 - 1] & 19136824) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1848[var33] = var10 - 1;
                                    class118.field1845[var33] = var11;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1840[var30 - 1][var31] = 2;
                                    class118.field1841[var30 - 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var22 + var20] & 19136830) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && class118.field1840[1 + var30][var31] == 0 && (var18[var19 + var2][var20] & 19136899) == 0 && (var18[var19 + var2][var2 + var20 - 1] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1848[var33] = var10 + 1;
                                    class118.field1845[var33] = var11;
                                    var33 = var33 + 1 & 4095;
                                    class118.field1840[var30 + 1][var31] = 8;
                                    class118.field1841[var30 + 1][var31] = var21;
                                    break;
                                 }

                                 if((var18[var2 + var19][var20 + var22] & 19136995) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 > 0 && class118.field1840[var30][var31 - 1] == 0 && (var18[var19][var20 - 1] & 19136782) == 0 && (var18[var2 + var19 - 1][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1848[var33] = var10;
                                    class118.field1845[var33] = var11 - 1;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1840[var30][var31 - 1] = 1;
                                    class118.field1841[var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var31 < 128 - var2 && class118.field1840[var30][var31 + 1] == 0 && (var18[var19][var20 + var2] & 19136824) == 0 && (var18[var2 + var19 - 1][var20 + var2] & 19136992) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2 - 1) {
                                    class118.field1848[var33] = var10;
                                    class118.field1845[var33] = var11 + 1;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1840[var30][var31 + 1] = 4;
                                    class118.field1841[var30][1 + var31] = var21;
                                    break;
                                 }

                                 if((var18[var22 + var19][var2 + var20] & 19137016) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 > 0 && class118.field1840[var30 - 1][var31 - 1] == 0 && (var18[var19 - 1][var20 - 1] & 19136782) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class118.field1848[var33] = var10 - 1;
                                    class118.field1845[var33] = var11 - 1;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1840[var30 - 1][var31 - 1] = 3;
                                    class118.field1841[var30 - 1][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 - 1][var20 - 1 + var22] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 < 128 - var2 && var31 > 0 && class118.field1840[var30 + 1][var31 - 1] == 0 && (var18[var2 + var19][var20 - 1] & 19136899) == 0) {
                              var22 = 1;

                              while(true) {
                                 if(var22 >= var2) {
                                    class118.field1848[var33] = var10 + 1;
                                    class118.field1845[var33] = var11 - 1;
                                    var33 = 1 + var33 & 4095;
                                    class118.field1840[var30 + 1][var31 - 1] = 9;
                                    class118.field1841[1 + var30][var31 - 1] = var21;
                                    break;
                                 }

                                 if((var18[var19 + var2][var20 - 1 + var22] & 19136995) != 0 || (var18[var19 + var22][var20 - 1] & 19136911) != 0) {
                                    break;
                                 }

                                 ++var22;
                              }
                           }

                           if(var30 > 0 && var31 < 128 - var2 && class118.field1840[var30 - 1][1 + var31] == 0 && (var18[var19 - 1][var2 + var20] & 19136824) == 0) {
                              for(var22 = 1; var22 < var2; ++var22) {
                                 if((var18[var19 - 1][var20 + var22] & 19136830) != 0 || (var18[var22 + (var19 - 1)][var20 + var2] & 19137016) != 0) {
                                    continue label879;
                                 }
                              }

                              class118.field1848[var33] = var10 - 1;
                              class118.field1845[var33] = var11 + 1;
                              var33 = var33 + 1 & 4095;
                              class118.field1840[var30 - 1][var31 + 1] = 6;
                              class118.field1841[var30 - 1][1 + var31] = var21;
                           }
                        } while(var30 >= 128 - var2);
                     } while(var31 >= 128 - var2);
                  } while(class118.field1840[1 + var30][var31 + 1] != 0);
               } while((var18[var2 + var19][var2 + var20] & 19136992) != 0);

               for(var22 = 1; var22 < var2; ++var22) {
                  if((var18[var19 + var22][var20 + var2] & 19137016) != 0 || (var18[var19 + var2][var20 + var22] & 19136995) != 0) {
                     continue label902;
                  }
               }

               class118.field1848[var33] = var10 + 1;
               class118.field1845[var33] = 1 + var11;
               var33 = 1 + var33 & 4095;
               class118.field1840[1 + var30][1 + var31] = 12;
               class118.field1841[1 + var30][var31 + 1] = var21;
            }
         }

         var28 = var29;
      }

      var9 = var0 - 64;
      var10 = var1 - 64;
      var11 = class118.field1839;
      var30 = class118.field1843;
      if(!var28) {
         var31 = Integer.MAX_VALUE;
         var14 = Integer.MAX_VALUE;
         byte var32 = 10;
         var33 = var3.field1851;
         var17 = var3.field1855;
         int var27 = var3.field1852;
         var19 = var3.field1853;

         for(var20 = var33 - var32; var20 <= var33 + var32; ++var20) {
            for(var21 = var17 - var32; var21 <= var17 + var32; ++var21) {
               var22 = var20 - var9;
               int var23 = var21 - var10;
               if(var22 >= 0 && var23 >= 0 && var22 < 128 && var23 < 128 && class118.field1841[var22][var23] < 100) {
                  int var24 = 0;
                  if(var20 < var33) {
                     var24 = var33 - var20;
                  } else if(var20 > var33 + var27 - 1) {
                     var24 = var20 - (var33 + var27 - 1);
                  }

                  int var25 = 0;
                  if(var21 < var17) {
                     var25 = var17 - var21;
                  } else if(var21 > var19 + var17 - 1) {
                     var25 = var21 - (var17 + var19 - 1);
                  }

                  int var26 = var25 * var25 + var24 * var24;
                  if(var26 < var31 || var26 == var31 && class118.field1841[var22][var23] < var14) {
                     var31 = var26;
                     var14 = class118.field1841[var22][var23];
                     var11 = var20;
                     var30 = var21;
                  }
               }
            }
         }

         if(var31 == Integer.MAX_VALUE) {
            return -1;
         }
      }

      if(var0 == var11 && var1 == var30) {
         return 0;
      } else {
         var13 = 0;
         class118.field1848[var13] = var11;
         var31 = var13 + 1;
         class118.field1845[var13] = var30;

         for(var14 = var15 = class118.field1840[var11 - var9][var30 - var10]; var11 != var0 || var1 != var30; var14 = class118.field1840[var11 - var9][var30 - var10]) {
            if(var15 != var14) {
               var15 = var14;
               class118.field1848[var31] = var11;
               class118.field1845[var31++] = var30;
            }

            if((var14 & 2) != 0) {
               ++var11;
            } else if((var14 & 8) != 0) {
               --var11;
            }

            if((var14 & 1) != 0) {
               ++var30;
            } else if((var14 & 4) != 0) {
               --var30;
            }
         }

         var33 = 0;

         while(var31-- > 0) {
            var6[var33] = class118.field1848[var31];
            var7[var33++] = class118.field1845[var31];
            if(var33 >= var6.length) {
               break;
            }
         }

         return var33;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1224291019"
   )
   static void method866() {
      class41.username = class41.username.trim();
      if(class41.username.length() == 0) {
         class22.method204("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class115.method2169();
         int var0;
         if(var1 == 0L) {
            var0 = 5;
         } else {
            var0 = WidgetNode.method185(var1, class41.username);
         }

         switch(var0) {
         case 2:
            class22.method204("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class41.loginIndex = 6;
            break;
         case 3:
            class22.method204("", "Error connecting to server.", "");
            break;
         case 4:
            class22.method204("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class22.method204("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class22.method204("", "Error connecting to server.", "");
            break;
         case 7:
            class22.method204("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }
}
