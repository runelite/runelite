import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("af")
public final class class41 {
   @ObfuscatedName("n")
   boolean field544;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   SpritePixels field560;
   @ObfuscatedName("e")
   boolean field555;
   @ObfuscatedName("w")
   HashMap field548;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "[[Laz;"
   )
   class34[][] field547;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -311787963
   )
   int field549;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 464812899
   )
   int field554;
   @ObfuscatedName("v")
   HashMap field550;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[Ljp;"
   )
   IndexedSprite[] field551;
   @ObfuscatedName("r")
   final HashMap field552;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Las;"
   )
   class44 field546;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1486441723
   )
   int field553;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1245025857
   )
   int field556;

   @ObfuscatedSignature(
      signature = "([Ljp;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field555 = false;
      this.field544 = false;
      this.field550 = new HashMap();
      this.field551 = var1;
      this.field552 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   void method552() {
      if(this.field548 == null) {
         this.field548 = new HashMap();
      }

      this.field548.clear();

      for(int var1 = 0; var1 < this.field547.length; ++var1) {
         for(int var2 = 0; var2 < this.field547[var1].length; ++var2) {
            List var3 = this.field547[var1][var2].method391();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field548.containsKey(Integer.valueOf(var5.field534))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field548.put(Integer.valueOf(var5.field534), var6);
               } else {
                  List var7 = (List)this.field548.get(Integer.valueOf(var5.field534));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIII)Lah;",
      garbageValue = "168411775"
   )
   class29 method549(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field549 + var1;
      int var7 = var2 + this.field554;
      int var8 = var3 + this.field549;
      int var9 = var4 + this.field554;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field420 = var12 - var10 + 1;
      var5.field417 = var13 - var11 + 1;
      var5.field418 = var10 - this.field546.method297();
      var5.field428 = var11 - this.field546.method299();
      if(var5.field418 < 0) {
         var5.field420 += var5.field418;
         var5.field418 = 0;
      }

      if(var5.field418 > this.field547.length - var5.field420) {
         var5.field420 = this.field547.length - var5.field418;
      }

      if(var5.field428 < 0) {
         var5.field417 += var5.field428;
         var5.field428 = 0;
      }

      if(var5.field428 > this.field547[0].length - var5.field417) {
         var5.field417 = this.field547[0].length - var5.field428;
      }

      var5.field420 = Math.min(var5.field420, this.field547.length);
      var5.field417 = Math.min(var5.field417, this.field547[0].length);
      return var5;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "-1185478696"
   )
   float method542(int var1, int var2) {
      float var3 = (float)var1 / (float)var2;
      if(var3 > 8.0F) {
         return 8.0F;
      } else if(var3 < 1.0F) {
         return 1.0F;
      } else {
         int var4 = Math.round(var3);
         return Math.abs((float)var4 - var3) < 0.05F?(float)var4:var3;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-13"
   )
   public boolean method550() {
      return this.field555;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "-2147387137"
   )
   public HashMap method551() {
      this.method552();
      return this.field548;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;IIB)V",
      garbageValue = "16"
   )
   public void method547(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field560 != null) {
         this.field560.method5102(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field548 == null) {
               this.method552();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field548.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field530.worldX - this.field549) / this.field553;
                  int var14 = var4 - (var12.field530.worldY - this.field554) * var4 / this.field556;
                  Rasterizer2D.method4971(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;Ljava/lang/String;ZI)V",
      garbageValue = "952495964"
   )
   public void method556(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field544) {
         this.field555 = false;
         this.field544 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field542.field540);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.method4143(class40.field542.field540, var2));
         Buffer var7 = new Buffer(var1.method4143(class40.field535.field540, var2));
         Buffer var8 = new Buffer(var1.method4143(var2, class40.field538.field540));
         System.nanoTime();
         System.nanoTime();
         this.field546 = new class44();

         try {
            this.field546.method616(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var24) {
            return;
         }

         this.field546.method301();
         this.field546.method302();
         this.field546.method346();
         this.field549 = this.field546.method297() * 64;
         this.field554 = this.field546.method299() * 64;
         this.field553 = (this.field546.method298() - this.field546.method297() + 1) * 64;
         this.field556 = (this.field546.method345() - this.field546.method299() + 1) * 64;
         int var9 = this.field546.method298() - this.field546.method297() + 1;
         int var10 = this.field546.method345() - this.field546.method299() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field547 = new class34[var9][var10];
         Iterator var11 = this.field546.field580.iterator();

         int var14;
         int var15;
         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field411;
            var14 = var12.field409;
            var15 = var13 - this.field546.method297();
            int var16 = var14 - this.field546.method299();
            this.field547[var15][var16] = new class34(var13, var14, this.field546.method295(), this.field552);
            this.field547[var15][var16].method425(var12, this.field546.field578);
         }

         for(int var18 = 0; var18 < var9; ++var18) {
            for(int var19 = 0; var19 < var10; ++var19) {
               if(this.field547[var18][var19] == null) {
                  this.field547[var18][var19] = new class34(this.field546.method297() + var18, this.field546.method299() + var19, this.field546.method295(), this.field552);
                  this.field547[var18][var19].method374(this.field546.field577, this.field546.field578);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4132(class40.field536.field540, var2)) {
            byte[] var27 = var1.method4143(class40.field536.field540, var2);
            BufferedImage var20 = null;

            SpritePixels var28;
            label46: {
               try {
                  var20 = ImageIO.read(new ByteArrayInputStream(var27));
                  var14 = var20.getWidth();
                  var15 = var20.getHeight();
                  int[] var21 = new int[var14 * var15];
                  PixelGrabber var17 = new PixelGrabber(var20, 0, 0, var14, var15, var21, 0, var14);
                  var17.grabPixels();
                  var28 = new SpritePixels(var21, var14, var15);
                  break label46;
               } catch (IOException var25) {
                  ;
               } catch (InterruptedException var26) {
                  ;
               }

               var28 = new SpritePixels(0, 0);
            }

            this.field560 = var28;
         }

         System.nanoTime();
         this.field555 = true;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIIB)Ljava/util/List;",
      garbageValue = "-37"
   )
   public List method548(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field555) {
         return var11;
      } else {
         class29 var12 = this.method549(var1, var2, var3, var4);
         float var13 = this.method542(var7, var3 - var1);
         int var14 = (int)(64.0F * var13);
         int var15 = this.field549 + var1;
         int var16 = var2 + this.field554;

         for(int var17 = var12.field418; var17 < var12.field418 + var12.field420; ++var17) {
            for(int var18 = var12.field428; var18 < var12.field428 + var12.field417; ++var18) {
               List var19 = this.field547[var17][var18].method390(var14 * (this.field547[var17][var18].field484 * 64 - var15) / 64 + var5, var8 + var6 - var14 * (this.field547[var17][var18].field492 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1073741824"
   )
   public final void method562() {
      this.field548 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[Laz;B)V",
      garbageValue = "-14"
   )
   void method546(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field547.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field547[0].length - 1;
      if(var7) {
         var3[class229.field3129.rsOrdinal()] = null;
      } else {
         var3[class229.field3129.rsOrdinal()] = this.field547[var1][var2 + 1];
      }

      var3[class229.field3131.rsOrdinal()] = !var7 && !var5?this.field547[var1 + 1][var2 + 1]:null;
      var3[class229.field3124.rsOrdinal()] = !var7 && !var4?this.field547[var1 - 1][var2 + 1]:null;
      var3[class229.field3130.rsOrdinal()] = var5?null:this.field547[var1 + 1][var2];
      var3[class229.field3125.rsOrdinal()] = var4?null:this.field547[var1 - 1][var2];
      var3[class229.field3127.rsOrdinal()] = var6?null:this.field547[var1][var2 - 1];
      var3[class229.field3126.rsOrdinal()] = !var6 && !var5?this.field547[var1 + 1][var2 - 1]:null;
      var3[class229.field3132.rsOrdinal()] = !var6 && !var4?this.field547[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-242920628"
   )
   public final void method572(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method549(var1, var2, var3, var4);
      float var14 = this.method542(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field550.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method661();
         this.field550.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field418; var17 < var13.field420 + var13.field418; ++var17) {
         for(var18 = var13.field428; var18 < var13.field417 + var13.field428; ++var18) {
            this.method546(var17, var18, var22);
            this.field547[var17][var18].method359(var15, (class46)this.field550.get(Integer.valueOf(var15)), var22, this.field551);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field549 + var1;
      int var19 = var2 + this.field554;

      for(int var20 = var13.field418; var20 < var13.field420 + var13.field418; ++var20) {
         for(int var21 = var13.field428; var21 < var13.field428 + var13.field417; ++var21) {
            this.field547[var20][var21].method354(var17 * (this.field547[var20][var21].field484 * 64 - var18) / 64 + var5, var8 - var17 * (this.field547[var20][var21].field492 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "105699893"
   )
   public final void method545(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method549(var1, var2, var3, var4);
      float var15 = this.method542(var7 - var5, var3 - var1);
      int var16 = (int)(64.0F * var15);
      int var17 = this.field549 + var1;
      int var18 = var2 + this.field554;

      int var19;
      int var20;
      for(var19 = var14.field418; var19 < var14.field418 + var14.field420; ++var19) {
         for(var20 = var14.field428; var20 < var14.field417 + var14.field428; ++var20) {
            if(var13) {
               this.field547[var19][var20].method383();
            }

            this.field547[var19][var20].method360(var5 + (this.field547[var19][var20].field484 * 64 - var17) * var16 / 64, var8 - var16 * (this.field547[var19][var20].field492 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field418; var19 < var14.field420 + var14.field418; ++var19) {
            for(var20 = var14.field428; var20 < var14.field417 + var14.field428; ++var20) {
               this.field547[var19][var20].method361(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("fo")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1371319786"
   )
   static void method580(int var0) {
      if(var0 == -3) {
         class19.method154("Connection timed out.", "Please try using a different world.", "");
      } else if(var0 == -2) {
         class19.method154("", "Error connecting to server.", "");
      } else if(var0 == -1) {
         class19.method154("No response from server.", "Please try using a different world.", "");
      } else if(var0 == 3) {
         class93.loginIndex = 3;
      } else if(var0 == 4) {
         class19.method154("Your account has been disabled.", "Please check your message-centre for details.", "");
      } else if(var0 == 5) {
         class19.method154("Your account has not logged out from its last", "session or the server is too busy right now.", "Please try again in a few minutes.");
      } else if(var0 == 6) {
         class19.method154("RuneScape has been updated!", "Please reload this page.", "");
      } else if(var0 == 7) {
         class19.method154("This world is full.", "Please use a different world.", "");
      } else if(var0 == 8) {
         class19.method154("Unable to connect.", "Login server offline.", "");
      } else if(var0 == 9) {
         class19.method154("Login limit exceeded.", "Too many connections from your address.", "");
      } else if(var0 == 10) {
         class19.method154("Unable to connect.", "Bad session id.", "");
      } else if(var0 == 11) {
         class19.method154("We suspect someone knows your password.", "Press \'change your password\' on front page.", "");
      } else if(var0 == 12) {
         class19.method154("You need a members account to login to this world.", "Please subscribe, or use a different world.", "");
      } else if(var0 == 13) {
         class19.method154("Could not complete login.", "Please try using a different world.", "");
      } else if(var0 == 14) {
         class19.method154("The server is being updated.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 16) {
         class19.method154("Too many login attempts.", "Please wait a few minutes before trying again.", "");
      } else if(var0 == 17) {
         class19.method154("You are standing in a members-only area.", "To play on this world move to a free area first", "");
      } else if(var0 == 18) {
         class19.method154("Account locked as we suspect it has been stolen.", "Press \'recover a locked account\' on front page.", "");
      } else if(var0 == 19) {
         class19.method154("This world is running a closed Beta.", "Sorry invited players only.", "Please use a different world.");
      } else if(var0 == 20) {
         class19.method154("Invalid loginserver requested.", "Please try using a different world.", "");
      } else if(var0 == 22) {
         class19.method154("Malformed login packet.", "Please try again.", "");
      } else if(var0 == 23) {
         class19.method154("No reply from loginserver.", "Please wait 1 minute and try again.", "");
      } else if(var0 == 24) {
         class19.method154("Error loading your profile.", "Please contact customer support.", "");
      } else if(var0 == 25) {
         class19.method154("Unexpected loginserver response.", "Please try using a different world.", "");
      } else if(var0 == 26) {
         class19.method154("This computers address has been blocked", "as it was used to break our rules.", "");
      } else if(var0 == 27) {
         class19.method154("", "Service unavailable.", "");
      } else if(var0 == 31) {
         class19.method154("Your account must have a displayname set", "in order to play the game.  Please set it", "via the website, or the main game.");
      } else if(var0 == 32) {
         class19.method154("Your attempt to log into your account was", "unsuccessful.  Don\'t worry, you can sort", "this out by visiting the billing system.");
      } else if(var0 == 37) {
         class19.method154("Your account is currently inaccessible.", "Please try again in a few minutes.", "");
      } else if(var0 == 38) {
         class19.method154("You need to vote to play!", "Visit runescape.com and vote,", "and then come back here!");
      } else if(var0 == 55) {
         class19.method154("Sorry, but your account is not eligible to", "play this version of the game.  Please try", "playing the main game instead!");
      } else {
         if(var0 == 56) {
            class19.method154("Enter the 6-digit code generated by your", "authenticator app.", "");
            WorldMapType1.setGameState(11);
            return;
         }

         if(var0 == 57) {
            class19.method154("The code you entered was incorrect.", "Please try again.", "");
            WorldMapType1.setGameState(11);
            return;
         }

         class19.method154("Unexpected server response", "Please try using a different world.", "");
      }

      WorldMapType1.setGameState(10);
   }

   @ObfuscatedName("e")
   public static final void method585(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            class9.method41(var0 - 1L);
            class9.method41(1L);
         } else {
            class9.method41(var0);
         }

      }
   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Lhg;I)Z",
      garbageValue = "-631301596"
   )
   static boolean method543(Widget var0) {
      if(Client.field1072) {
         if(class15.getWidgetConfig(var0) != 0) {
            return false;
         }

         if(var0.type == 0) {
            return false;
         }
      }

      return var0.isHidden;
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1558532831"
   )
   static final void method564() {
      class47.flush(false);
      Client.field1123 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < GameEngine.field709.length; ++var1) {
         if(BaseVarType.field27[var1] != -1 && GameEngine.field709[var1] == null) {
            GameEngine.field709[var1] = class158.indexMaps.getConfigData(BaseVarType.field27[var1], 0);
            if(GameEngine.field709[var1] == null) {
               var0 = false;
               ++Client.field1123;
            }
         }

         if(class5.landRegionFielIds[var1] != -1 && VarPlayerType.field3269[var1] == null) {
            VarPlayerType.field3269[var1] = class158.indexMaps.getConfigData(class5.landRegionFielIds[var1], 0, GameEngine.xteaKeys[var1]);
            if(VarPlayerType.field3269[var1] == null) {
               var0 = false;
               ++Client.field1123;
            }
         }
      }

      if(!var0) {
         Client.field973 = 1;
      } else {
         Client.field971 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < GameEngine.field709.length; ++var1) {
            byte[] var2 = VarPlayerType.field3269[var1];
            if(var2 != null) {
               var3 = (class56.mapRegions[var1] >> 8) * 64 - class25.baseX;
               var4 = (class56.mapRegions[var1] & 255) * 64 - ScriptEvent.baseY;
               if(Client.isDynamicRegion) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= class17.method126(var2, var3, var4);
            }
         }

         if(!var0) {
            Client.field973 = 2;
         } else {
            if(Client.field973 != 0) {
               class23.drawStatusBox("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class35.method495();
            PendingSpawn.method1523();
            class35.method495();
            class84.region.reset();
            class35.method495();
            System.gc();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].reset();
            }

            int var38;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var38 = 0; var38 < 104; ++var38) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     class61.tileSettings[var1][var38][var3] = 0;
                  }
               }
            }

            class35.method495();
            class61.field753 = 99;
            class91.underlayIds = new byte[4][104][104];
            class61.overlayIds = new byte[4][104][104];
            class92.overlayPaths = new byte[4][104][104];
            class35.overlayRotations = new byte[4][104][104];
            class61.field748 = new int[4][105][105];
            ChatLineBuffer.field1546 = new byte[4][105][105];
            class61.field756 = new int[105][105];
            class20.blendedHue = new int[104];
            GroundObject.blendedSaturation = new int[104];
            class33.field473 = new int[104];
            class61.field746 = new int[104];
            class61.field742 = new int[104];
            var1 = GameEngine.field709.length;
            class23.method170();
            class47.flush(true);
            int var6;
            int var7;
            int var9;
            int var10;
            int var11;
            int var12;
            int var14;
            int var15;
            int var16;
            int var17;
            int var19;
            int var20;
            int var21;
            int var40;
            if(!Client.isDynamicRegion) {
               byte[] var5;
               for(var38 = 0; var38 < var1; ++var38) {
                  var3 = (class56.mapRegions[var38] >> 8) * 64 - class25.baseX;
                  var4 = (class56.mapRegions[var38] & 255) * 64 - ScriptEvent.baseY;
                  var5 = GameEngine.field709[var38];
                  if(var5 != null) {
                     class35.method495();
                     var6 = class48.field605 * 8 - 48;
                     var7 = WidgetNode.field826 * 8 - 48;
                     CollisionData[] var8 = Client.collisionMaps;

                     for(var9 = 0; var9 < 4; ++var9) {
                        for(var10 = 0; var10 < 64; ++var10) {
                           for(var11 = 0; var11 < 64; ++var11) {
                              if(var10 + var3 > 0 && var3 + var10 < 103 && var4 + var11 > 0 && var11 + var4 < 103) {
                                 var8[var9].flags[var3 + var10][var11 + var4] &= -16777217;
                              }
                           }
                        }
                     }

                     Buffer var39 = new Buffer(var5);

                     for(var10 = 0; var10 < 4; ++var10) {
                        for(var11 = 0; var11 < 64; ++var11) {
                           for(var12 = 0; var12 < 64; ++var12) {
                              WidgetNode.loadTerrain(var39, var10, var11 + var3, var4 + var12, var6, var7, 0);
                           }
                        }
                     }
                  }
               }

               for(var38 = 0; var38 < var1; ++var38) {
                  var3 = (class56.mapRegions[var38] >> 8) * 64 - class25.baseX;
                  var4 = (class56.mapRegions[var38] & 255) * 64 - ScriptEvent.baseY;
                  var5 = GameEngine.field709[var38];
                  if(var5 == null && WidgetNode.field826 < 800) {
                     class35.method495();
                     class93.method1780(var3, var4, 64, 64);
                  }
               }

               class47.flush(true);

               for(var38 = 0; var38 < var1; ++var38) {
                  byte[] var42 = VarPlayerType.field3269[var38];
                  if(var42 != null) {
                     var4 = (class56.mapRegions[var38] >> 8) * 64 - class25.baseX;
                     var40 = (class56.mapRegions[var38] & 255) * 64 - ScriptEvent.baseY;
                     class35.method495();
                     Region var43 = class84.region;
                     CollisionData[] var44 = Client.collisionMaps;
                     Buffer var49 = new Buffer(var42);
                     var9 = -1;

                     while(true) {
                        var10 = var49.getUSmart();
                        if(var10 == 0) {
                           break;
                        }

                        var9 += var10;
                        var11 = 0;

                        while(true) {
                           var12 = var49.getUSmart();
                           if(var12 == 0) {
                              break;
                           }

                           var11 += var12 - 1;
                           int var45 = var11 & 63;
                           var14 = var11 >> 6 & 63;
                           var15 = var11 >> 12;
                           var16 = var49.readUnsignedByte();
                           var17 = var16 >> 2;
                           int var46 = var16 & 3;
                           var19 = var4 + var14;
                           var20 = var40 + var45;
                           if(var19 > 0 && var20 > 0 && var19 < 103 && var20 < 103) {
                              var21 = var15;
                              if((class61.tileSettings[1][var19][var20] & 2) == 2) {
                                 var21 = var15 - 1;
                              }

                              CollisionData var22 = null;
                              if(var21 >= 0) {
                                 var22 = var44[var21];
                              }

                              GroundObject.addObject(var15, var19, var20, var9, var46, var17, var43, var22);
                           }
                        }
                     }
                  }
               }
            }

            int var41;
            if(Client.isDynamicRegion) {
               for(var38 = 0; var38 < 4; ++var38) {
                  class35.method495();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var50 = false;
                        var6 = Client.field976[var38][var3][var4];
                        if(var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var41 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(var12 = 0; var12 < class56.mapRegions.length; ++var12) {
                              if(class56.mapRegions[var12] == var11 && GameEngine.field709[var12] != null) {
                                 byte[] var13 = GameEngine.field709[var12];
                                 var14 = var3 * 8;
                                 var15 = var4 * 8;
                                 var16 = (var9 & 7) * 8;
                                 var17 = (var10 & 7) * 8;
                                 CollisionData[] var18 = Client.collisionMaps;

                                 for(var19 = 0; var19 < 8; ++var19) {
                                    for(var20 = 0; var20 < 8; ++var20) {
                                       if(var19 + var14 > 0 && var14 + var19 < 103 && var15 + var20 > 0 && var20 + var15 < 103) {
                                          var18[var38].flags[var19 + var14][var15 + var20] &= -16777217;
                                       }
                                    }
                                 }

                                 Buffer var47 = new Buffer(var13);

                                 for(var20 = 0; var20 < 4; ++var20) {
                                    for(var21 = 0; var21 < 64; ++var21) {
                                       for(int var48 = 0; var48 < 64; ++var48) {
                                          if(var7 == var20 && var21 >= var16 && var21 < var16 + 8 && var48 >= var17 && var48 < var17 + 8) {
                                             int var27 = var21 & 7;
                                             int var28 = var48 & 7;
                                             int var29 = var41 & 3;
                                             int var26;
                                             if(var29 == 0) {
                                                var26 = var27;
                                             } else if(var29 == 1) {
                                                var26 = var28;
                                             } else if(var29 == 2) {
                                                var26 = 7 - var27;
                                             } else {
                                                var26 = 7 - var28;
                                             }

                                             int var32 = var14 + var26;
                                             int var35 = var21 & 7;
                                             int var36 = var48 & 7;
                                             int var37 = var41 & 3;
                                             int var34;
                                             if(var37 == 0) {
                                                var34 = var36;
                                             } else if(var37 == 1) {
                                                var34 = 7 - var35;
                                             } else if(var37 == 2) {
                                                var34 = 7 - var36;
                                             } else {
                                                var34 = var35;
                                             }

                                             WidgetNode.loadTerrain(var47, var38, var32, var15 + var34, 0, 0, var41);
                                          } else {
                                             WidgetNode.loadTerrain(var47, 0, -1, -1, 0, 0, 0);
                                          }
                                       }
                                    }
                                 }

                                 var50 = true;
                                 break;
                              }
                           }
                        }

                        if(!var50) {
                           var7 = var38;
                           var41 = var3 * 8;
                           var9 = var4 * 8;

                           for(var10 = 0; var10 < 8; ++var10) {
                              for(var11 = 0; var11 < 8; ++var11) {
                                 class61.tileHeights[var7][var41 + var10][var9 + var11] = 0;
                              }
                           }

                           if(var41 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class61.tileHeights[var7][var41][var10 + var9] = class61.tileHeights[var7][var41 - 1][var9 + var10];
                              }
                           }

                           if(var9 > 0) {
                              for(var10 = 1; var10 < 8; ++var10) {
                                 class61.tileHeights[var7][var10 + var41][var9] = class61.tileHeights[var7][var41 + var10][var9 - 1];
                              }
                           }

                           if(var41 > 0 && class61.tileHeights[var7][var41 - 1][var9] != 0) {
                              class61.tileHeights[var7][var41][var9] = class61.tileHeights[var7][var41 - 1][var9];
                           } else if(var9 > 0 && class61.tileHeights[var7][var41][var9 - 1] != 0) {
                              class61.tileHeights[var7][var41][var9] = class61.tileHeights[var7][var41][var9 - 1];
                           } else if(var41 > 0 && var9 > 0 && class61.tileHeights[var7][var41 - 1][var9 - 1] != 0) {
                              class61.tileHeights[var7][var41][var9] = class61.tileHeights[var7][var41 - 1][var9 - 1];
                           }
                        }
                     }
                  }
               }

               for(var38 = 0; var38 < 13; ++var38) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.field976[0][var38][var3];
                     if(var4 == -1) {
                        class93.method1780(var38 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               class47.flush(true);

               for(var38 = 0; var38 < 4; ++var38) {
                  class35.method495();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var40 = Client.field976[var38][var3][var4];
                        if(var40 != -1) {
                           var6 = var40 >> 24 & 3;
                           var7 = var40 >> 1 & 3;
                           var41 = var40 >> 14 & 1023;
                           var9 = var40 >> 3 & 2047;
                           var10 = (var41 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class56.mapRegions.length; ++var11) {
                              if(class56.mapRegions[var11] == var10 && VarPlayerType.field3269[var11] != null) {
                                 class8.method37(VarPlayerType.field3269[var11], var38, var3 * 8, var4 * 8, var6, (var41 & 7) * 8, (var9 & 7) * 8, var7, class84.region, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            class47.flush(true);
            PendingSpawn.method1523();
            class35.method495();
            WorldMapType1.method260(class84.region, Client.collisionMaps);
            class47.flush(true);
            var38 = class61.field753;
            if(var38 > class29.plane) {
               var38 = class29.plane;
            }

            if(var38 < class29.plane - 1) {
               var38 = class29.plane - 1;
            }

            if(Client.lowMemory) {
               class84.region.setup(class61.field753);
            } else {
               class84.region.setup(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class35.groundItemSpawned(var3, var4);
               }
            }

            class35.method495();
            ScriptState.method1073();
            ObjectComposition.field3437.reset();
            if(class5.clientInstance.method871()) {
               Client.secretPacketBuffer1.putOpcode(81);
               Client.secretPacketBuffer1.putInt(1057001181);
            }

            if(!Client.isDynamicRegion) {
               var3 = (class48.field605 - 6) / 8;
               var4 = (class48.field605 + 6) / 8;
               var40 = (WidgetNode.field826 - 6) / 8;
               var6 = (WidgetNode.field826 + 6) / 8;

               for(var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
                  for(var41 = var40 - 1; var41 <= var6 + 1; ++var41) {
                     if(var7 < var3 || var7 > var4 || var41 < var40 || var41 > var6) {
                        class158.indexMaps.method4136("m" + var7 + "_" + var41);
                        class158.indexMaps.method4136("l" + var7 + "_" + var41);
                     }
                  }
               }
            }

            WorldMapType1.setGameState(30);
            class35.method495();
            class51.method775();
            Client.secretPacketBuffer1.putOpcode(247);
            class233.timer.vmethod3017();

            for(var3 = 0; var3 < 32; ++var3) {
               GameEngine.field679[var3] = 0L;
            }

            for(var3 = 0; var3 < 32; ++var3) {
               GameEngine.field708[var3] = 0L;
            }

            class211.field2580 = 0;
         }
      }
   }
}
