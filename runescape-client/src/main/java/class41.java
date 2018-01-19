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
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public final class class41 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 765519435
   )
   static int field541;
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "[Lkm;"
   )
   @Export("slStarSprites")
   static IndexedSprite[] slStarSprites;
   @ObfuscatedName("n")
   boolean field527;
   @ObfuscatedName("v")
   boolean field539;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Laq;"
   )
   class44 field528;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   SpritePixels field530;
   @ObfuscatedName("h")
   HashMap field531;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[[Lav;"
   )
   class34[][] field532;
   @ObfuscatedName("s")
   HashMap field533;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Lkm;"
   )
   IndexedSprite[] field536;
   @ObfuscatedName("e")
   final HashMap field535;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1491959217
   )
   int field529;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 262734487
   )
   int field537;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1497318195
   )
   int field534;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -356142943
   )
   int field538;

   @ObfuscatedSignature(
      signature = "([Lkm;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field527 = false;
      this.field539 = false;
      this.field533 = new HashMap();
      this.field536 = var1;
      this.field535 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lil;Ljava/lang/String;ZB)V",
      garbageValue = "16"
   )
   public void method569(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field539) {
         this.field527 = false;
         this.field539 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field522.field517);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.takeRecordByNames(class40.field522.field517, var2));
         Buffer var7 = new Buffer(var1.takeRecordByNames(class40.field518.field517, var2));
         Buffer var8 = new Buffer(var1.takeRecordByNames(var2, class40.field521.field517));
         System.nanoTime();
         System.nanoTime();
         this.field528 = new class44();

         try {
            this.field528.method616(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var24) {
            return;
         }

         this.field528.method274();
         this.field528.method292();
         this.field528.method293();
         this.field529 = this.field528.method297() * 64;
         this.field537 = this.field528.method289() * 64;
         this.field534 = (this.field528.method326() - this.field528.method297() + 1) * 64;
         this.field538 = (this.field528.method290() - this.field528.method289() + 1) * 64;
         int var18 = this.field528.method326() - this.field528.method297() + 1;
         int var10 = this.field528.method290() - this.field528.method289() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field532 = new class34[var18][var10];
         Iterator var11 = this.field528.field558.iterator();

         int var14;
         int var15;
         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field390;
            var14 = var12.field388;
            var15 = var13 - this.field528.method297();
            int var16 = var14 - this.field528.method289();
            this.field532[var15][var16] = new class34(var13, var14, this.field528.method320(), this.field535);
            this.field532[var15][var16].method349(var12, this.field528.field554);
         }

         for(int var19 = 0; var19 < var18; ++var19) {
            for(int var20 = 0; var20 < var10; ++var20) {
               if(this.field532[var19][var20] == null) {
                  this.field532[var19][var20] = new class34(this.field528.method297() + var19, this.field528.method289() + var20, this.field528.method320(), this.field535);
                  this.field532[var19][var20].method350(this.field528.field553, this.field528.field554);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4321(class40.field519.field517, var2)) {
            byte[] var27 = var1.takeRecordByNames(class40.field519.field517, var2);
            BufferedImage var21 = null;

            SpritePixels var28;
            label49: {
               try {
                  var21 = ImageIO.read(new ByteArrayInputStream(var27));
                  var14 = var21.getWidth();
                  var15 = var21.getHeight();
                  int[] var22 = new int[var14 * var15];
                  PixelGrabber var17 = new PixelGrabber(var21, 0, 0, var14, var15, var22, 0, var14);
                  var17.grabPixels();
                  var28 = new SpritePixels(var22, var14, var15);
                  break label49;
               } catch (IOException var25) {
                  ;
               } catch (InterruptedException var26) {
                  ;
               }

               var28 = new SpritePixels(0, 0);
            }

            this.field530 = var28;
         }

         System.nanoTime();
         this.field527 = true;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public final void method578() {
      this.field531 = null;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-2081724102"
   )
   public final void method544(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method549(var1, var2, var3, var4);
      float var14 = this.method553(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field533.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method662();
         this.field533.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field399; var17 < var13.field404 + var13.field399; ++var17) {
         for(var18 = var13.field402; var18 < var13.field400 + var13.field402; ++var18) {
            this.method546(var17, var18, var22);
            this.field532[var17][var18].method353(var15, (class46)this.field533.get(Integer.valueOf(var15)), var22, this.field536);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field529 + var1;
      int var19 = var2 + this.field537;

      for(int var20 = var13.field399; var20 < var13.field399 + var13.field404; ++var20) {
         for(int var21 = var13.field402; var21 < var13.field400 + var13.field402; ++var21) {
            this.field532[var20][var21].method453(var5 + var17 * (this.field532[var20][var21].field455 * 64 - var18) / 64, var8 - var17 * (this.field532[var20][var21].field453 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZB)V",
      garbageValue = "0"
   )
   public final void method542(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method549(var1, var2, var3, var4);
      float var15 = this.method553(var7 - var5, var3 - var1);
      int var16 = (int)(64.0F * var15);
      int var17 = this.field529 + var1;
      int var18 = var2 + this.field537;

      int var19;
      int var20;
      for(var19 = var14.field399; var19 < var14.field404 + var14.field399; ++var19) {
         for(var20 = var14.field402; var20 < var14.field400 + var14.field402; ++var20) {
            if(var13) {
               this.field532[var19][var20].method409();
            }

            this.field532[var19][var20].method369(var5 + var16 * (this.field532[var19][var20].field455 * 64 - var17) / 64, var8 - var16 * (this.field532[var19][var20].field453 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field399; var19 < var14.field399 + var14.field404; ++var19) {
            for(var20 = var14.field402; var20 < var14.field402 + var14.field400; ++var20) {
               this.field532[var19][var20].method355(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II[Lav;I)V",
      garbageValue = "1125054920"
   )
   void method546(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field532.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field532[0].length - 1;
      if(var7) {
         var3[class239.field3258.rsOrdinal()] = null;
      } else {
         var3[class239.field3258.rsOrdinal()] = this.field532[var1][var2 + 1];
      }

      var3[class239.field3255.rsOrdinal()] = !var7 && !var5?this.field532[var1 + 1][var2 + 1]:null;
      var3[class239.field3256.rsOrdinal()] = !var7 && !var4?this.field532[var1 - 1][var2 + 1]:null;
      var3[class239.field3262.rsOrdinal()] = var5?null:this.field532[var1 + 1][var2];
      var3[class239.field3260.rsOrdinal()] = var4?null:this.field532[var1 - 1][var2];
      var3[class239.field3257.rsOrdinal()] = var6?null:this.field532[var1][var2 - 1];
      var3[class239.field3261.rsOrdinal()] = !var6 && !var5?this.field532[var1 + 1][var2 - 1]:null;
      var3[class239.field3259.rsOrdinal()] = !var6 && !var4?this.field532[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "-1624030358"
   )
   public void method547(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field530 != null) {
         this.field530.method5284(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field531 == null) {
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
                  var10 = (List)this.field531.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field514.worldX - this.field529) / this.field534;
                  int var14 = var4 - (var12.field514.worldY - this.field537) * var4 / this.field538;
                  Rasterizer2D.method5158(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "239868136"
   )
   public List method571(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field527) {
         return var11;
      } else {
         class29 var12 = this.method549(var1, var2, var3, var4);
         float var13 = this.method553(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field529 + var1;
         int var16 = var2 + this.field537;

         for(int var17 = var12.field399; var17 < var12.field399 + var12.field404; ++var17) {
            for(int var18 = var12.field402; var18 < var12.field402 + var12.field400; ++var18) {
               List var19 = this.field532[var17][var18].method384(var5 + var14 * (this.field532[var17][var18].field455 * 64 - var15) / 64, var8 + var6 - var14 * (this.field532[var17][var18].field453 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIB)Lag;",
      garbageValue = "-29"
   )
   class29 method549(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field529 + var1;
      int var7 = var2 + this.field537;
      int var8 = var3 + this.field529;
      int var9 = var4 + this.field537;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field404 = var12 - var10 + 1;
      var5.field400 = var13 - var11 + 1;
      var5.field399 = var10 - this.field528.method297();
      var5.field402 = var11 - this.field528.method289();
      if(var5.field399 < 0) {
         var5.field404 += var5.field399;
         var5.field399 = 0;
      }

      if(var5.field399 > this.field532.length - var5.field404) {
         var5.field404 = this.field532.length - var5.field399;
      }

      if(var5.field402 < 0) {
         var5.field400 += var5.field402;
         var5.field402 = 0;
      }

      if(var5.field402 > this.field532[0].length - var5.field400) {
         var5.field400 = this.field532[0].length - var5.field402;
      }

      var5.field404 = Math.min(var5.field404, this.field532.length);
      var5.field400 = Math.min(var5.field400, this.field532[0].length);
      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "16036"
   )
   public boolean method550() {
      return this.field527;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "1326495696"
   )
   public HashMap method551() {
      this.method552();
      return this.field531;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "352340686"
   )
   void method552() {
      if(this.field531 == null) {
         this.field531 = new HashMap();
      }

      this.field531.clear();

      for(int var1 = 0; var1 < this.field532.length; ++var1) {
         for(int var2 = 0; var2 < this.field532[var1].length; ++var2) {
            List var3 = this.field532[var1][var2].method374();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field531.containsKey(Integer.valueOf(var5.field512))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field531.put(Integer.valueOf(var5.field512), var6);
               } else {
                  List var7 = (List)this.field531.get(Integer.valueOf(var5.field512));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "-178535856"
   )
   float method553(int var1, int var2) {
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "1942165188"
   )
   public static char method581(char var0) {
      return (char)(var0 == 198?69:(var0 == 230?101:(var0 == 223?115:(var0 == 338?69:(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "105"
   )
   static final void method580(String var0) {
      if(var0 != null) {
         String var1 = WorldMapData.cleanUsername(var0, GrandExchangeOffer.jagexLoginType);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = WorldMapData.cleanUsername(var4, GrandExchangeOffer.jagexLoginType);
               boolean var6;
               if(var0 != null && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.ignoreCount;

                  for(int var7 = var2; var7 < Client.ignoreCount; ++var7) {
                     Client.ignores[var7] = Client.ignores[var7 + 1];
                  }

                  Client.field880 = Client.cycleCntr;
                  PacketNode var8 = class235.method4272(ClientPacket.field2416, Client.field915.field1462);
                  var8.packetBuffer.putByte(Size.getLength(var0));
                  var8.packetBuffer.putString(var0);
                  Client.field915.method1898(var8);
                  break;
               }
            }

         }
      }
   }
}
