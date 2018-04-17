import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
public class class234 extends TaskDataNode {
   @ObfuscatedName("kp")
   @ObfuscatedGetter(
      intValue = -788221477
   )
   static int field2768;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhw;"
   )
   class230 field2764;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhr;"
   )
   Deque field2765;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lcn;"
   )
   class100 field2766;

   @ObfuscatedSignature(
      signature = "(Lhw;)V"
   )
   class234(class230 var1) {
      this.field2765 = new Deque();
      this.field2766 = new class100();
      this.field2764 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lhn;[IIIII)V",
      garbageValue = "2054813536"
   )
   void method4320(class231 var1, int[] var2, int var3, int var4, int var5) {
      if((this.field2764.field2716[var1.field2734] & 4) != 0 && var1.field2740 < 0) {
         int var6 = this.field2764.field2711[var1.field2734] / AbstractSoundSystem.sampleRate;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2741) / var6;
            if(var7 > var4) {
               var1.field2741 += var6 * var4;
               break;
            }

            var1.field2739.vmethod4317(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2741 += var6 * var7 - 1048576;
            int var8 = AbstractSoundSystem.sampleRate / 100;
            int var9 = 262144 / var6;
            if(var9 < var8) {
               var8 = var9;
            }

            class115 var10 = var1.field2739;
            if(this.field2764.field2709[var1.field2734] == 0) {
               var1.field2739 = class115.method2318(var1.field2729, var10.method2374(), var10.method2392(), var10.method2336());
            } else {
               var1.field2739 = class115.method2318(var1.field2729, var10.method2374(), 0, var10.method2336());
               this.field2764.method4145(var1, var1.field2722.field2759[var1.field2726] < 0);
               var1.field2739.method2352(var8, var10.method2392());
            }

            if(var1.field2722.field2759[var1.field2726] < 0) {
               var1.field2739.method2320(-1);
            }

            var10.method2363(var8);
            var10.vmethod4317(var2, var3, var5 - var3);
            if(var10.method2335()) {
               this.field2766.method2059(var10);
            }
         }
      }

      var1.field2739.vmethod4317(var2, var3, var4);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lhn;II)V",
      garbageValue = "619282758"
   )
   void method4315(class231 var1, int var2) {
      if((this.field2764.field2716[var1.field2734] & 4) != 0 && var1.field2740 < 0) {
         int var3 = this.field2764.field2711[var1.field2734] / AbstractSoundSystem.sampleRate;
         int var4 = (var3 + 1048575 - var1.field2741) / var3;
         var1.field2741 = var3 * var2 + var1.field2741 & 1048575;
         if(var4 <= var2) {
            if(this.field2764.field2709[var1.field2734] == 0) {
               var1.field2739 = class115.method2318(var1.field2729, var1.field2739.method2374(), var1.field2739.method2392(), var1.field2739.method2336());
            } else {
               var1.field2739 = class115.method2318(var1.field2729, var1.field2739.method2374(), 0, var1.field2739.method2336());
               this.field2764.method4145(var1, var1.field2722.field2759[var1.field2726] < 0);
            }

            if(var1.field2722.field2759[var1.field2726] < 0) {
               var1.field2739.method2320(-1);
            }

            var2 = var1.field2741 / var3;
         }
      }

      var1.field2739.vmethod4319(var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected TaskDataNode vmethod4330() {
      class231 var1 = (class231)this.field2765.getFront();
      return (TaskDataNode)(var1 == null?null:(var1.field2739 != null?var1.field2739:this.vmethod4321()));
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "()Ldd;"
   )
   protected TaskDataNode vmethod4321() {
      class231 var1;
      do {
         var1 = (class231)this.field2765.getNext();
         if(var1 == null) {
            return null;
         }
      } while(var1.field2739 == null);

      return var1.field2739;
   }

   @ObfuscatedName("i")
   protected int vmethod4314() {
      return 0;
   }

   @ObfuscatedName("u")
   protected void vmethod4317(int[] var1, int var2, int var3) {
      this.field2766.vmethod4317(var1, var2, var3);

      for(class231 var6 = (class231)this.field2765.getFront(); var6 != null; var6 = (class231)this.field2765.getNext()) {
         if(!this.field2764.method4167(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if(var5 <= var6.field2723) {
                  this.method4320(var6, var1, var4, var5, var4 + var5);
                  var6.field2723 -= var5;
                  break;
               }

               this.method4320(var6, var1, var4, var6.field2723, var5 + var4);
               var4 += var6.field2723;
               var5 -= var6.field2723;
            } while(!this.field2764.method4146(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("y")
   protected void vmethod4319(int var1) {
      this.field2766.vmethod4319(var1);

      for(class231 var3 = (class231)this.field2765.getFront(); var3 != null; var3 = (class231)this.field2765.getNext()) {
         if(!this.field2764.method4167(var3)) {
            int var2 = var1;

            do {
               if(var2 <= var3.field2723) {
                  this.method4315(var3, var2);
                  var3.field2723 -= var2;
                  break;
               }

               this.method4315(var3, var3.field2723);
               var2 -= var3.field2723;
            } while(!this.field2764.method4146(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Ljr;",
      garbageValue = "1051571653"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.NpcDefinition_indexCache.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lki;Lki;Lki;ZI)V",
      garbageValue = "-1532478673"
   )
   @Export("drawLoginScreen")
   static void drawLoginScreen(Font var0, Font var1, Font var2, boolean var3) {
      if(var3) {
         class90.field1359 = (MapLabel.canvasWidth - 765) / 2;
         class90.loginWindowX = class90.field1359 + 202;
         WorldComparator.field279 = class90.loginWindowX + 180;
      }

      if(class90.worldSelectShown) {
         class37.method542(var0, var1);
      } else {
         if(var3) {
            class321.field3938.method5856(class90.field1359, 0);
            class90.field1381.method5856(class90.field1359 + 382, 0);
            class33.logoSprite.method5825(class90.field1359 + 382 - class33.logoSprite.width / 2, 18);
         }

         int var5;
         if(Client.gameState == 0 || Client.gameState == 5) {
            byte var4 = 20;
            var0.drawTextCentered("RuneScape is loading - please wait...", class90.loginWindowX + 180, 245 - var4, 16777215, -1);
            var5 = 253 - var4;
            Rasterizer2D.drawRectangle(class90.loginWindowX + 180 - 152, var5, 304, 34, 9179409);
            Rasterizer2D.drawRectangle(class90.loginWindowX + 180 - 151, var5 + 1, 302, 32, 0);
            Rasterizer2D.Rasterizer2D_fillRectangle(class90.loginWindowX + 180 - 150, var5 + 2, class90.loadingBarPercentage * 3, 30, 9179409);
            Rasterizer2D.Rasterizer2D_fillRectangle(class90.loginWindowX + 180 - 150 + class90.loadingBarPercentage * 3, var5 + 2, 300 - class90.loadingBarPercentage * 3, 30, 0);
            var0.drawTextCentered(class90.loadingText, class90.loginWindowX + 180, 276 - var4, 16777215, -1);
         }

         String var6;
         String var7;
         short var18;
         int var19;
         short var20;
         if(Client.gameState == 20) {
            IndexStoreActionHandler.field3398.method5825(class90.loginWindowX + 180 - IndexStoreActionHandler.field3398.width / 2, 271 - IndexStoreActionHandler.field3398.height / 2);
            var18 = 201;
            var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var18, 16776960, 0);
            var19 = var18 + 15;
            var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var19, 16776960, 0);
            var19 += 15;
            var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var19, 16776960, 0);
            var19 += 15;
            var19 += 7;
            if(class90.loginIndex != 4) {
               var0.method5510("Login: ", class90.loginWindowX + 180 - 110, var19, 16777215, 0);
               var20 = 200;
               var6 = Client.preferences.hideUsername?Enum.method4958(class90.username):class90.username;

               for(var7 = var6; var0.getTextWidth(var7) > var20; var7 = var7.substring(0, var7.length() - 1)) {
                  ;
               }

               var0.method5510(FontTypeFace.appendTags(var7), class90.loginWindowX + 180 - 70, var19, 16777215, 0);
               var19 += 15;
               var0.method5510("Password: " + Enum.method4958(class90.password), class90.loginWindowX + 180 - 108, var19, 16777215, 0);
               var19 += 15;
            }
         }

         int var8;
         int var10;
         int var24;
         if(Client.gameState == 10 || Client.gameState == 11) {
            IndexStoreActionHandler.field3398.method5825(class90.loginWindowX, 171);
            short var15;
            if(class90.loginIndex == 0) {
               var18 = 251;
               var0.drawTextCentered("Welcome to RuneScape", class90.loginWindowX + 180, var18, 16776960, 0);
               var19 = var18 + 30;
               var5 = class90.loginWindowX + 180 - 80;
               var15 = 291;
               class90.field1388.method5825(var5 - 73, var15 - 20);
               var0.method5514("New User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
               var5 = class90.loginWindowX + 180 + 80;
               class90.field1388.method5825(var5 - 73, var15 - 20);
               var0.method5514("Existing User", var5 - 73, var15 - 20, 144, 40, 16777215, 0, 1, 1, 0);
            } else if(class90.loginIndex == 1) {
               var0.drawTextCentered(class90.Login_response0, class90.loginWindowX + 180, 201, 16776960, 0);
               var18 = 236;
               var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var18, 16777215, 0);
               var19 = var18 + 15;
               var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var19, 16777215, 0);
               var19 += 15;
               var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var19, 16777215, 0);
               var19 += 15;
               var5 = class90.loginWindowX + 180 - 80;
               var15 = 321;
               class90.field1388.method5825(var5 - 73, var15 - 20);
               var0.drawTextCentered("Continue", var5, var15 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180 + 80;
               class90.field1388.method5825(var5 - 73, var15 - 20);
               var0.drawTextCentered("Cancel", var5, var15 + 5, 16777215, 0);
            } else if(class90.loginIndex == 2) {
               var18 = 201;
               var0.drawTextCentered(class90.loginMessage1, WorldComparator.field279, var18, 16776960, 0);
               var19 = var18 + 15;
               var0.drawTextCentered(class90.loginMessage2, WorldComparator.field279, var19, 16776960, 0);
               var19 += 15;
               var0.drawTextCentered(class90.loginMessage3, WorldComparator.field279, var19, 16776960, 0);
               var19 += 15;
               var19 += 7;
               var0.method5510("Login: ", WorldComparator.field279 - 110, var19, 16777215, 0);
               var20 = 200;
               var6 = Client.preferences.hideUsername?Enum.method4958(class90.username):class90.username;

               for(var7 = var6; var0.getTextWidth(var7) > var20; var7 = var7.substring(1)) {
                  ;
               }

               var0.method5510(FontTypeFace.appendTags(var7) + (class90.field1386 == 0 & Client.gameCycle % 40 < 20?class45.getColTags(16776960) + "|":""), WorldComparator.field279 - 70, var19, 16777215, 0);
               var19 += 15;
               var0.method5510("Password: " + Enum.method4958(class90.password) + (class90.field1386 == 1 & Client.gameCycle % 40 < 20?class45.getColTags(16776960) + "|":""), WorldComparator.field279 - 108, var19, 16777215, 0);
               var19 += 15;
               var18 = 277;
               var8 = WorldComparator.field279 + -117;
               IndexedSprite var17 = VertexNormal.method2778(class90.Login_isUsernameRemembered, class90.field1374);
               var17.method5825(var8, var18);
               var8 = var8 + var17.width + 5;
               var1.method5510("Remember username", var8, var18 + 13, 16776960, 0);
               var8 = WorldComparator.field279 + 24;
               var17 = VertexNormal.method2778(Client.preferences.hideUsername, class90.field1384);
               var17.method5825(var8, var18);
               var8 = var8 + var17.width + 5;
               var1.method5510("Hide username", var8, var18 + 13, 16776960, 0);
               var19 = var18 + 15;
               var10 = WorldComparator.field279 - 80;
               short var11 = 321;
               class90.field1388.method5825(var10 - 73, var11 - 20);
               var0.drawTextCentered("Login", var10, var11 + 5, 16777215, 0);
               var10 = WorldComparator.field279 + 80;
               class90.field1388.method5825(var10 - 73, var11 - 20);
               var0.drawTextCentered("Cancel", var10, var11 + 5, 16777215, 0);
               var18 = 357;
               var1.drawTextCentered("Forgotten your password? <col=ffffff>Click here.", WorldComparator.field279, var18, 16776960, 0);
            } else if(class90.loginIndex == 3) {
               var18 = 201;
               var0.drawTextCentered("Invalid username or password.", class90.loginWindowX + 180, var18, 16776960, 0);
               var19 = var18 + 20;
               var1.drawTextCentered("For accounts created after 24th November 2010, please use your", class90.loginWindowX + 180, var19, 16776960, 0);
               var19 += 15;
               var1.drawTextCentered("email address to login. Otherwise please login with your username.", class90.loginWindowX + 180, var19, 16776960, 0);
               var19 += 15;
               var5 = class90.loginWindowX + 180;
               var15 = 276;
               class90.field1388.method5825(var5 - 73, var15 - 20);
               var2.drawTextCentered("Try again", var5, var15 + 5, 16777215, 0);
               var5 = class90.loginWindowX + 180;
               var15 = 326;
               class90.field1388.method5825(var5 - 73, var15 - 20);
               var2.drawTextCentered("Forgotten password?", var5, var15 + 5, 16777215, 0);
            } else {
               short var9;
               if(class90.loginIndex == 4) {
                  var0.drawTextCentered("Authenticator", class90.loginWindowX + 180, 201, 16776960, 0);
                  var18 = 236;
                  var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var18, 16777215, 0);
                  var19 = var18 + 15;
                  var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var19, 16777215, 0);
                  var19 += 15;
                  var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var19, 16777215, 0);
                  var19 += 15;
                  var0.method5510("PIN: " + Enum.method4958(class37.field501) + (Client.gameCycle % 40 < 20?class45.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 108, var19, 16777215, 0);
                  var19 -= 8;
                  var0.method5510("Trust this computer", class90.loginWindowX + 180 - 9, var19, 16776960, 0);
                  var19 += 15;
                  var0.method5510("for 30 days: ", class90.loginWindowX + 180 - 9, var19, 16776960, 0);
                  var5 = 180 + class90.loginWindowX - 9 + var0.getTextWidth("for 30 days: ") + 15;
                  var24 = var19 - var0.verticalSpace;
                  IndexedSprite var21;
                  if(class90.field1385) {
                     var21 = class90.field1393;
                  } else {
                     var21 = class90.field1363;
                  }

                  var21.method5825(var5, var24);
                  var19 += 15;
                  var8 = class90.loginWindowX + 180 - 80;
                  var9 = 321;
                  class90.field1388.method5825(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Continue", var8, var9 + 5, 16777215, 0);
                  var8 = class90.loginWindowX + 180 + 80;
                  class90.field1388.method5825(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Cancel", var8, var9 + 5, 16777215, 0);
                  var1.drawTextCentered("<u=ff>Can\'t Log In?</u>", class90.loginWindowX + 180, var9 + 36, 255, 0);
               } else if(class90.loginIndex == 5) {
                  var0.drawTextCentered("Forgotten your password?", class90.loginWindowX + 180, 201, 16776960, 0);
                  var18 = 221;
                  var2.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var18, 16776960, 0);
                  var19 = var18 + 15;
                  var2.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var19, 16776960, 0);
                  var19 += 15;
                  var2.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var19, 16776960, 0);
                  var19 += 15;
                  var19 += 14;
                  var0.method5510("Username/email: ", class90.loginWindowX + 180 - 145, var19, 16777215, 0);
                  var20 = 174;
                  var6 = Client.preferences.hideUsername?Enum.method4958(class90.username):class90.username;

                  for(var7 = var6; var0.getTextWidth(var7) > var20; var7 = var7.substring(1)) {
                     ;
                  }

                  var0.method5510(FontTypeFace.appendTags(var7) + (Client.gameCycle % 40 < 20?class45.getColTags(16776960) + "|":""), class90.loginWindowX + 180 - 34, var19, 16777215, 0);
                  var19 += 15;
                  var8 = class90.loginWindowX + 180 - 80;
                  var9 = 321;
                  class90.field1388.method5825(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Recover", var8, var9 + 5, 16777215, 0);
                  var8 = class90.loginWindowX + 180 + 80;
                  class90.field1388.method5825(var8 - 73, var9 - 20);
                  var0.drawTextCentered("Back", var8, var9 + 5, 16777215, 0);
               } else if(class90.loginIndex == 6) {
                  var18 = 201;
                  var0.drawTextCentered(class90.loginMessage1, class90.loginWindowX + 180, var18, 16776960, 0);
                  var19 = var18 + 15;
                  var0.drawTextCentered(class90.loginMessage2, class90.loginWindowX + 180, var19, 16776960, 0);
                  var19 += 15;
                  var0.drawTextCentered(class90.loginMessage3, class90.loginWindowX + 180, var19, 16776960, 0);
                  var19 += 15;
                  var5 = class90.loginWindowX + 180;
                  var15 = 321;
                  class90.field1388.method5825(var5 - 73, var15 - 20);
                  var0.drawTextCentered("Back", var5, var15 + 5, 16777215, 0);
               }
            }
         }

         if(class90.field1371 > 0) {
            class71.method1184(class90.field1371);
            class90.field1371 = 0;
         }

         var18 = 256;
         if(class90.field1367 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class90.field1367 > 768) {
                  class21.field344[var5] = class37.method543(class21.field347[var5], ScriptState.field762[var5], 1024 - class90.field1367);
               } else if(class90.field1367 > 256) {
                  class21.field344[var5] = ScriptState.field762[var5];
               } else {
                  class21.field344[var5] = class37.method543(ScriptState.field762[var5], class21.field347[var5], 256 - class90.field1367);
               }
            }
         } else if(class90.field1358 > 0) {
            for(var5 = 0; var5 < 256; ++var5) {
               if(class90.field1358 > 768) {
                  class21.field344[var5] = class37.method543(class21.field347[var5], GrandExchangeEvent.field298[var5], 1024 - class90.field1358);
               } else if(class90.field1358 > 256) {
                  class21.field344[var5] = GrandExchangeEvent.field298[var5];
               } else {
                  class21.field344[var5] = class37.method543(GrandExchangeEvent.field298[var5], class21.field347[var5], 256 - class90.field1358);
               }
            }
         } else {
            for(var5 = 0; var5 < 256; ++var5) {
               class21.field344[var5] = class21.field347[var5];
            }
         }

         Rasterizer2D.setDrawRegion(class90.field1359, 9, class90.field1359 + 128, var18 + 7);
         class321.field3938.method5856(class90.field1359, 0);
         Rasterizer2D.noClip();
         var5 = 0;
         var24 = MapCacheArchiveNames.rasterProvider.width * 9 + class90.field1359;

         int var12;
         int var13;
         int var14;
         int var16;
         int var22;
         int var23;
         for(var16 = 1; var16 < var18 - 1; ++var16) {
            var8 = class90.field1366[var16] * (var18 - var16) / var18;
            var22 = var8 + 22;
            if(var22 < 0) {
               var22 = 0;
            }

            var5 += var22;

            for(var10 = var22; var10 < 128; ++var10) {
               var23 = Huffman.field2513[var5++];
               if(var23 != 0) {
                  var12 = var23;
                  var13 = 256 - var23;
                  var23 = class21.field344[var23];
                  var14 = MapCacheArchiveNames.rasterProvider.pixels[var24];
                  MapCacheArchiveNames.rasterProvider.pixels[var24++] = (var12 * (var23 & 65280) + var13 * (var14 & 65280) & 16711680) + ((var23 & 16711935) * var12 + (var14 & 16711935) * var13 & -16711936) >> 8;
               } else {
                  ++var24;
               }
            }

            var24 += var22 + MapCacheArchiveNames.rasterProvider.width - 128;
         }

         Rasterizer2D.setDrawRegion(class90.field1359 + 765 - 128, 9, class90.field1359 + 765, var18 + 7);
         class90.field1381.method5856(class90.field1359 + 382, 0);
         Rasterizer2D.noClip();
         var5 = 0;
         var24 = MapCacheArchiveNames.rasterProvider.width * 9 + class90.field1359 + 637 + 24;

         for(var16 = 1; var16 < var18 - 1; ++var16) {
            var8 = class90.field1366[var16] * (var18 - var16) / var18;
            var22 = 103 - var8;
            var24 += var8;

            for(var10 = 0; var10 < var22; ++var10) {
               var23 = Huffman.field2513[var5++];
               if(var23 != 0) {
                  var12 = var23;
                  var13 = 256 - var23;
                  var23 = class21.field344[var23];
                  var14 = MapCacheArchiveNames.rasterProvider.pixels[var24];
                  MapCacheArchiveNames.rasterProvider.pixels[var24++] = ((var14 & 16711935) * var13 + (var23 & 16711935) * var12 & -16711936) + (var12 * (var23 & 65280) + var13 * (var14 & 65280) & 16711680) >> 8;
               } else {
                  ++var24;
               }
            }

            var5 += 128 - var22;
            var24 += MapCacheArchiveNames.rasterProvider.width - var22 - var8;
         }

         class57.titlemuteSprite[Client.preferences.muted?1:0].method5825(class90.field1359 + 765 - 40, 463);
         if(Client.gameState > 5 && Client.languageId == 0) {
            if(class167.field2223 != null) {
               var19 = class90.field1359 + 5;
               var20 = 463;
               byte var26 = 100;
               byte var25 = 35;
               class167.field2223.method5825(var19, var20);
               var0.drawTextCentered("World" + " " + Client.world, var26 / 2 + var19, var25 / 2 + var20 - 2, 16777215, 0);
               if(FaceNormal.listFetcher != null) {
                  var1.drawTextCentered("Loading...", var26 / 2 + var19, var25 / 2 + var20 + 12, 16777215, 0);
               } else {
                  var1.drawTextCentered("Click to switch", var26 / 2 + var19, var25 / 2 + var20 + 12, 16777215, 0);
               }
            } else {
               class167.field2223 = FriendManager.getSprite(class151.indexSprites, "sl_button", "");
            }
         }

      }
   }
}
