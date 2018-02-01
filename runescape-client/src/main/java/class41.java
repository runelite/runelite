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

@ObfuscatedName("aw")
public final class class41 {
   @ObfuscatedName("p")
   boolean field513;
   @ObfuscatedName("i")
   boolean field514;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   class44 field525;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   SpritePixels field526;
   @ObfuscatedName("j")
   HashMap field517;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[[Lai;"
   )
   class34[][] field518;
   @ObfuscatedName("t")
   HashMap field519;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   IndexedSprite[] field520;
   @ObfuscatedName("m")
   final HashMap field521;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1372941339
   )
   int field522;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -56062409
   )
   int field523;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1220812157
   )
   int field524;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2084391543
   )
   int field527;

   @ObfuscatedSignature(
      signature = "([Lkh;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field513 = false;
      this.field514 = false;
      this.field519 = new HashMap();
      this.field520 = var1;
      this.field521 = var2;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lik;Ljava/lang/String;ZB)V",
      garbageValue = "28"
   )
   public void method584(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field514) {
         this.field513 = false;
         this.field514 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field508.field509);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.takeRecordByNames(class40.field508.field509, var2));
         Buffer var7 = new Buffer(var1.takeRecordByNames(class40.field505.field509, var2));
         Buffer var8 = new Buffer(var1.takeRecordByNames(var2, class40.field512.field509));
         System.nanoTime();
         System.nanoTime();
         this.field525 = new class44();

         try {
            this.field525.method621(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var24) {
            return;
         }

         this.field525.method355();
         this.field525.method349();
         this.field525.method308();
         this.field522 = this.field525.method358() * 64;
         this.field523 = this.field525.method305() * 64;
         this.field524 = (this.field525.method304() - this.field525.method358() + 1) * 64;
         this.field527 = (this.field525.method307() - this.field525.method305() + 1) * 64;
         int var18 = this.field525.method304() - this.field525.method358() + 1;
         int var10 = this.field525.method307() - this.field525.method305() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field518 = new class34[var18][var10];
         Iterator var11 = this.field525.field537.iterator();

         int var14;
         int var15;
         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field384;
            var14 = var12.field376;
            var15 = var13 - this.field525.method358();
            int var16 = var14 - this.field525.method305();
            this.field518[var15][var16] = new class34(var13, var14, this.field525.method354(), this.field521);
            this.field518[var15][var16].method367(var12, this.field525.field539);
         }

         for(int var19 = 0; var19 < var18; ++var19) {
            for(int var20 = 0; var20 < var10; ++var20) {
               if(this.field518[var19][var20] == null) {
                  this.field518[var19][var20] = new class34(this.field525.method358() + var19, this.field525.method305() + var20, this.field525.method354(), this.field521);
                  this.field518[var19][var20].method368(this.field525.field538, this.field525.field539);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4434(class40.field506.field509, var2)) {
            byte[] var27 = var1.takeRecordByNames(class40.field506.field509, var2);
            BufferedImage var21 = null;

            SpritePixels var28;
            label48: {
               try {
                  var21 = ImageIO.read(new ByteArrayInputStream(var27));
                  var14 = var21.getWidth();
                  var15 = var21.getHeight();
                  int[] var22 = new int[var14 * var15];
                  PixelGrabber var17 = new PixelGrabber(var21, 0, 0, var14, var15, var22, 0, var14);
                  var17.grabPixels();
                  var28 = new SpritePixels(var22, var14, var15);
                  break label48;
               } catch (IOException var25) {
                  ;
               } catch (InterruptedException var26) {
                  ;
               }

               var28 = new SpritePixels(0, 0);
            }

            this.field526 = var28;
         }

         System.nanoTime();
         this.field513 = true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2089897475"
   )
   public final void method586() {
      this.field517 = null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "-36"
   )
   public final void method553(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method558(var1, var2, var3, var4);
      float var14 = this.method572(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field519.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method661();
         this.field519.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field394; var17 < var13.field394 + var13.field395; ++var17) {
         for(var18 = var13.field390; var18 < var13.field390 + var13.field391; ++var18) {
            this.method555(var17, var18, var22);
            this.field518[var17][var18].method371(var15, (class46)this.field519.get(Integer.valueOf(var15)), var22, this.field520);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field522 + var1;
      int var19 = var2 + this.field523;

      for(int var20 = var13.field394; var20 < var13.field394 + var13.field395; ++var20) {
         for(int var21 = var13.field390; var21 < var13.field391 + var13.field390; ++var21) {
            this.field518[var20][var21].method366(var5 + var17 * (this.field518[var20][var21].field445 * 64 - var18) / 64, var8 - var17 * (this.field518[var20][var21].field446 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "-201520290"
   )
   public final void method554(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method558(var1, var2, var3, var4);
      float var15 = this.method572(var7 - var5, var3 - var1);
      int var16 = (int)(64.0F * var15);
      int var17 = this.field522 + var1;
      int var18 = var2 + this.field523;

      int var19;
      int var20;
      for(var19 = var14.field394; var19 < var14.field395 + var14.field394; ++var19) {
         for(var20 = var14.field390; var20 < var14.field390 + var14.field391; ++var20) {
            if(var13) {
               this.field518[var19][var20].method418();
            }

            this.field518[var19][var20].method372(var5 + var16 * (this.field518[var19][var20].field445 * 64 - var17) / 64, var8 - var16 * (this.field518[var19][var20].field446 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field394; var19 < var14.field394 + var14.field395; ++var19) {
            for(var20 = var14.field390; var20 < var14.field390 + var14.field391; ++var20) {
               this.field518[var19][var20].method373(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II[Lai;I)V",
      garbageValue = "1451980680"
   )
   void method555(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field518.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field518[0].length - 1;
      if(var7) {
         var3[class239.field3232.rsOrdinal()] = null;
      } else {
         var3[class239.field3232.rsOrdinal()] = this.field518[var1][var2 + 1];
      }

      var3[class239.field3227.rsOrdinal()] = !var7 && !var5?this.field518[var1 + 1][var2 + 1]:null;
      var3[class239.field3233.rsOrdinal()] = !var7 && !var4?this.field518[var1 - 1][var2 + 1]:null;
      var3[class239.field3231.rsOrdinal()] = var5?null:this.field518[var1 + 1][var2];
      var3[class239.field3234.rsOrdinal()] = var4?null:this.field518[var1 - 1][var2];
      var3[class239.field3226.rsOrdinal()] = var6?null:this.field518[var1][var2 - 1];
      var3[class239.field3229.rsOrdinal()] = !var6 && !var5?this.field518[var1 + 1][var2 - 1]:null;
      var3[class239.field3228.rsOrdinal()] = !var6 && !var4?this.field518[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;IIB)V",
      garbageValue = "0"
   )
   public void method556(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field526 != null) {
         this.field526.method5538(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field517 == null) {
               this.method561();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field517.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field496.worldX - this.field522) / this.field524;
                  int var14 = var4 - (var12.field496.worldY - this.field523) * var4 / this.field527;
                  Rasterizer2D.method5399(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "-769727425"
   )
   public List method557(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field513) {
         return var11;
      } else {
         class29 var12 = this.method558(var1, var2, var3, var4);
         float var13 = this.method572(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field522 + var1;
         int var16 = var2 + this.field523;

         for(int var17 = var12.field394; var17 < var12.field394 + var12.field395; ++var17) {
            for(int var18 = var12.field390; var18 < var12.field390 + var12.field391; ++var18) {
               List var19 = this.field518[var17][var18].method401(var5 + var14 * (this.field518[var17][var18].field445 * 64 - var15) / 64, var8 + var6 - var14 * (this.field518[var17][var18].field446 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIII)Lar;",
      garbageValue = "-1923077023"
   )
   class29 method558(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field522 + var1;
      int var7 = var2 + this.field523;
      int var8 = var3 + this.field522;
      int var9 = var4 + this.field523;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field395 = var12 - var10 + 1;
      var5.field391 = var13 - var11 + 1;
      var5.field394 = var10 - this.field525.method358();
      var5.field390 = var11 - this.field525.method305();
      if(var5.field394 < 0) {
         var5.field395 += var5.field394;
         var5.field394 = 0;
      }

      if(var5.field394 > this.field518.length - var5.field395) {
         var5.field395 = this.field518.length - var5.field394;
      }

      if(var5.field390 < 0) {
         var5.field391 += var5.field390;
         var5.field390 = 0;
      }

      if(var5.field390 > this.field518[0].length - var5.field391) {
         var5.field391 = this.field518[0].length - var5.field390;
      }

      var5.field395 = Math.min(var5.field395, this.field518.length);
      var5.field391 = Math.min(var5.field391, this.field518[0].length);
      return var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1072361716"
   )
   public boolean method559() {
      return this.field513;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "1321107681"
   )
   public HashMap method560() {
      this.method561();
      return this.field517;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1951181196"
   )
   void method561() {
      if(this.field517 == null) {
         this.field517 = new HashMap();
      }

      this.field517.clear();

      for(int var1 = 0; var1 < this.field518.length; ++var1) {
         for(int var2 = 0; var2 < this.field518[var1].length; ++var2) {
            List var3 = this.field518[var1][var2].method484();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field517.containsKey(Integer.valueOf(var5.field495))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field517.put(Integer.valueOf(var5.field495), var6);
               } else {
                  List var7 = (List)this.field517.get(Integer.valueOf(var5.field495));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "-1932959384"
   )
   float method572(int var1, int var2) {
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-500404447"
   )
   static void method571() {
      if(class89.Login_isUsernameRemembered && class89.username != null && class89.username.length() > 0) {
         class89.field1300 = 1;
      } else {
         class89.field1300 = 0;
      }

   }

   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-413849524"
   )
   static void method587() {
      Client.mouseLastLastPressedTimeMillis = 1L;
      Client.field915 = -1;
      class3.mouseRecorder.index = 0;
      class18.field305 = true;
      Client.field845 = true;
      Client.field822 = -1L;
      class268.method4897();
      Client.field867.method2040();
      Client.field867.packetBuffer.offset = 0;
      Client.field867.serverPacket = null;
      Client.field867.field1446 = null;
      Client.field867.field1435 = null;
      Client.field867.field1448 = null;
      Client.field867.packetLength = 0;
      Client.field867.field1450 = 0;
      Client.field904 = 0;
      Client.field1043 = 0;
      Client.hintArrowTargetType = 0;
      class61.method1048();
      class45.method653(0);
      class85.method1841();
      Client.itemSelectionState = 0;
      Client.spellSelected = false;
      Client.queuedSoundEffectCount = 0;
      Client.mapAngle = 0;
      Client.field1050 = 0;
      Client.field952 = -1;
      Client.destinationX = 0;
      Client.destinationY = 0;
      Client.playerAttackOption = AttackOption.AttackOption_hidden;
      Client.npcAttackOption = AttackOption.AttackOption_hidden;
      Client.npcIndexesCount = 0;
      TotalQuantityComparator.method110();

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      for(var0 = 0; var0 < 32768; ++var0) {
         Client.cachedNPCs[var0] = null;
      }

      Client.field935 = -1;
      Client.projectiles.clear();
      Client.graphicsObjectDeque.clear();

      for(var0 = 0; var0 < 4; ++var0) {
         for(int var1 = 0; var1 < 104; ++var1) {
            for(int var2 = 0; var2 < 104; ++var2) {
               Client.groundItemDeque[var0][var1][var2] = null;
            }
         }
      }

      Client.pendingSpawns = new Deque();
      ServerPacket.friendManager.method1668();

      for(var0 = 0; var0 < VarPlayerType.field3351; ++var0) {
         VarPlayerType var4 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
         VarPlayerType var5;
         if(var4 != null) {
            var5 = var4;
         } else {
            byte[] var3 = class175.varplayer_ref.getConfigData(16, var0);
            var4 = new VarPlayerType();
            if(var3 != null) {
               var4.decode(new Buffer(var3));
            }

            VarPlayerType.varplayers.put(var4, (long)var0);
            var5 = var4;
         }

         if(var5 != null) {
            class222.settings[var0] = 0;
            class222.widgetSettings[var0] = 0;
         }
      }

      class61.chatMessages.reset();
      Client.field890 = -1;
      if(Client.widgetRoot != -1) {
         class3.method9(Client.widgetRoot);
      }

      for(WidgetNode var6 = (WidgetNode)Client.componentTable.first(); var6 != null; var6 = (WidgetNode)Client.componentTable.next()) {
         GraphicsObject.method1797(var6, true);
      }

      Client.widgetRoot = -1;
      Client.componentTable = new HashTable(8);
      Client.field971 = null;
      class61.method1048();
      Client.field1081.method4208((int[])null, new int[]{0, 0, 0, 0, 0}, false, -1);

      for(var0 = 0; var0 < 8; ++var0) {
         Client.playerOptions[var0] = null;
         Client.playerOptionsPriorities[var0] = false;
      }

      class1.method0();
      Client.field830 = true;

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1012[var0] = true;
      }

      class237.method4338();
      class234.clanMemberManager = null;

      for(var0 = 0; var0 < 8; ++var0) {
         Client.grandExchangeOffers[var0] = new GrandExchangeOffer();
      }

      Varcs.grandExchangeEvents = null;
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IIIIII)V",
      garbageValue = "1269877790"
   )
   static final void method550(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class48.region.method2895(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class48.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class29.minimapSprite.pixels;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = TextureProvider.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = class179.mapscene[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.width * 4 - var14.originalWidth) / 2;
               int var16 = (var13.length * 4 - var14.height) / 2;
               var14.method5504(var15 + var1 * 4 + 48, var16 + (104 - var2 - var13.length) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class48.region.method2839(var0, var1, var2);
      if(var5 != 0) {
         var6 = class48.region.getObjectFlags(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = TextureProvider.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = class179.mapscene[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.width * 4 - var17.originalWidth) / 2;
               var18 = (var23.length * 4 - var17.height) / 2;
               var17.method5504(var1 * 4 + var12 + 48, var18 + (104 - var2 - var23.length) * 4 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = class29.minimapSprite.pixels;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = class48.region.method2840(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = TextureProvider.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = class179.mapscene[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.width * 4 - var20.originalWidth) / 2;
               int var21 = (var19.length * 4 - var20.height) / 2;
               var20.method5504(var1 * 4 + var9 + 48, (104 - var2 - var19.length) * 4 + var21 + 48);
            }
         }
      }

   }

   @ObfuscatedName("ku")
   @ObfuscatedSignature(
      signature = "(Lho;I)Ljava/lang/String;",
      garbageValue = "-1792839356"
   )
   static String method589(Widget var0) {
      return CollisionData.method3282(class60.getWidgetConfig(var0)) == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }
}
