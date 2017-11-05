import java.awt.FontMetrics;
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

@ObfuscatedName("ac")
public final class class41 {
   @ObfuscatedName("aw")
   static FontMetrics field570;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 259129379
   )
   static int field586;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 480813023
   )
   static int field585;
   @ObfuscatedName("w")
   boolean field571;
   @ObfuscatedName("s")
   boolean field582;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lah;"
   )
   class44 field572;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   SpritePixels field573;
   @ObfuscatedName("g")
   HashMap field581;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "[[Laq;"
   )
   class34[][] field575;
   @ObfuscatedName("p")
   HashMap field584;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Ljo;"
   )
   IndexedSprite[] field577;
   @ObfuscatedName("d")
   final HashMap field578;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -13892549
   )
   int field579;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -684946451
   )
   int field580;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1029202719
   )
   int field574;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -730339719
   )
   int field583;

   @ObfuscatedSignature(
      signature = "([Ljo;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field571 = false;
      this.field582 = false;
      this.field584 = new HashMap();
      this.field577 = var1;
      this.field578 = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lip;Ljava/lang/String;ZI)V",
      garbageValue = "-621164331"
   )
   public void method541(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field582) {
         this.field571 = false;
         this.field582 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field567.field563);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.method4265(class40.field567.field563, var2));
         Buffer var7 = new Buffer(var1.method4265(class40.field564.field563, var2));
         Buffer var8 = new Buffer(var1.method4265(var2, class40.field566.field563));
         System.nanoTime();
         System.nanoTime();
         this.field572 = new class44();

         try {
            this.field572.method616(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var24) {
            return;
         }

         this.field572.method295();
         this.field572.method346();
         this.field572.method279();
         this.field579 = this.field572.method291() * 64;
         this.field580 = this.field572.method293() * 64;
         this.field574 = (this.field572.method292() - this.field572.method291() + 1) * 64;
         this.field583 = (this.field572.method294() - this.field572.method293() + 1) * 64;
         int var9 = this.field572.method292() - this.field572.method291() + 1;
         int var10 = this.field572.method294() - this.field572.method293() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field575 = new class34[var9][var10];
         Iterator var11 = this.field572.field600.iterator();

         int var14;
         int var15;
         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field423;
            var14 = var12.field416;
            var15 = var13 - this.field572.method291();
            int var16 = var14 - this.field572.method293();
            this.field575[var15][var16] = new class34(var13, var14, this.field572.method289(), this.field578);
            this.field575[var15][var16].method352(var12, this.field572.field598);
         }

         for(int var18 = 0; var18 < var9; ++var18) {
            for(int var19 = 0; var19 < var10; ++var19) {
               if(this.field575[var18][var19] == null) {
                  this.field575[var18][var19] = new class34(this.field572.method291() + var18, this.field572.method293() + var19, this.field572.method289(), this.field578);
                  this.field575[var18][var19].method353(this.field572.field599, this.field572.field598);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4208(class40.field565.field563, var2)) {
            byte[] var27 = var1.method4265(class40.field565.field563, var2);
            BufferedImage var20 = null;

            SpritePixels var28;
            label46: {
               try {
                  var20 = ImageIO.read(new ByteArrayInputStream(var27));
                  var14 = var20.getWidth();
                  var15 = var20.getHeight();
                  int[] var21 = new int[var15 * var14];
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

            this.field573 = var28;
         }

         System.nanoTime();
         this.field571 = true;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-558855995"
   )
   public final void method567() {
      this.field581 = null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "-25"
   )
   public final void method584(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method543(var1, var2, var3, var4);
      float var14 = this.method552(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field584.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method658();
         this.field584.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field428; var17 < var13.field428 + var13.field437; ++var17) {
         for(var18 = var13.field435; var18 < var13.field436 + var13.field435; ++var18) {
            this.method563(var17, var18, var22);
            this.field575[var17][var18].method469(var15, (class46)this.field584.get(Integer.valueOf(var15)), var22, this.field577);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field579 + var1;
      int var19 = var2 + this.field580;

      for(int var20 = var13.field428; var20 < var13.field428 + var13.field437; ++var20) {
         for(int var21 = var13.field435; var21 < var13.field436 + var13.field435; ++var21) {
            this.field575[var20][var21].method351(var5 + var17 * (this.field575[var20][var21].field487 * 64 - var18) / 64, var8 - var17 * (this.field575[var20][var21].field488 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "-265399753"
   )
   public final void method544(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method543(var1, var2, var3, var4);
      float var15 = this.method552(var7 - var5, var3 - var1);
      int var16 = (int)(64.0F * var15);
      int var17 = this.field579 + var1;
      int var18 = var2 + this.field580;

      int var19;
      int var20;
      for(var19 = var14.field428; var19 < var14.field428 + var14.field437; ++var19) {
         for(var20 = var14.field435; var20 < var14.field435 + var14.field436; ++var20) {
            if(var13) {
               this.field575[var19][var20].method380();
            }

            this.field575[var19][var20].method357(var5 + var16 * (this.field575[var19][var20].field487 * 64 - var17) / 64, var8 - var16 * (this.field575[var19][var20].field488 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field428; var19 < var14.field437 + var14.field428; ++var19) {
            for(var20 = var14.field435; var20 < var14.field436 + var14.field435; ++var20) {
               this.field575[var19][var20].method358(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[Laq;S)V",
      garbageValue = "128"
   )
   void method563(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field575.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field575[0].length - 1;
      if(var7) {
         var3[class228.field3150.rsOrdinal()] = null;
      } else {
         var3[class228.field3150.rsOrdinal()] = this.field575[var1][var2 + 1];
      }

      var3[class228.field3153.rsOrdinal()] = !var7 && !var5?this.field575[var1 + 1][var2 + 1]:null;
      var3[class228.field3157.rsOrdinal()] = !var7 && !var4?this.field575[var1 - 1][var2 + 1]:null;
      var3[class228.field3155.rsOrdinal()] = var5?null:this.field575[var1 + 1][var2];
      var3[class228.field3163.rsOrdinal()] = var4?null:this.field575[var1 - 1][var2];
      var3[class228.field3152.rsOrdinal()] = var6?null:this.field575[var1][var2 - 1];
      var3[class228.field3151.rsOrdinal()] = !var6 && !var5?this.field575[var1 + 1][var2 - 1]:null;
      var3[class228.field3154.rsOrdinal()] = !var6 && !var4?this.field575[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;IIB)V",
      garbageValue = "64"
   )
   public void method546(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field573 != null) {
         this.field573.method5231(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field581 == null) {
               this.method551();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field581.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field548.worldX - this.field579) / this.field574;
                  int var14 = var4 - (var12.field548.worldY - this.field580) * var4 / this.field583;
                  Rasterizer2D.method5039(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "-277958282"
   )
   public List method579(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field571) {
         return var11;
      } else {
         class29 var12 = this.method543(var1, var2, var3, var4);
         float var13 = this.method552(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field579 + var1;
         int var16 = var2 + this.field580;

         for(int var17 = var12.field428; var17 < var12.field437 + var12.field428; ++var17) {
            for(int var18 = var12.field435; var18 < var12.field435 + var12.field436; ++var18) {
               List var19 = this.field575[var17][var18].method387(var5 + var14 * (this.field575[var17][var18].field487 * 64 - var15) / 64, var8 + var6 - var14 * (this.field575[var17][var18].field488 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIII)Lay;",
      garbageValue = "-161479448"
   )
   class29 method543(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field579 + var1;
      int var7 = var2 + this.field580;
      int var8 = var3 + this.field579;
      int var9 = var4 + this.field580;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field437 = var12 - var10 + 1;
      var5.field436 = var13 - var11 + 1;
      var5.field428 = var10 - this.field572.method291();
      var5.field435 = var11 - this.field572.method293();
      if(var5.field428 < 0) {
         var5.field437 += var5.field428;
         var5.field428 = 0;
      }

      if(var5.field428 > this.field575.length - var5.field437) {
         var5.field437 = this.field575.length - var5.field428;
      }

      if(var5.field435 < 0) {
         var5.field436 += var5.field435;
         var5.field435 = 0;
      }

      if(var5.field435 > this.field575[0].length - var5.field436) {
         var5.field436 = this.field575[0].length - var5.field435;
      }

      var5.field437 = Math.min(var5.field437, this.field575.length);
      var5.field436 = Math.min(var5.field436, this.field575[0].length);
      return var5;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-32258870"
   )
   public boolean method549() {
      return this.field571;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)Ljava/util/HashMap;",
      garbageValue = "128"
   )
   public HashMap method550() {
      this.method551();
      return this.field581;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "310522743"
   )
   void method551() {
      if(this.field581 == null) {
         this.field581 = new HashMap();
      }

      this.field581.clear();

      for(int var1 = 0; var1 < this.field575.length; ++var1) {
         for(int var2 = 0; var2 < this.field575[var1].length; ++var2) {
            List var3 = this.field575[var1][var2].method415();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field581.containsKey(Integer.valueOf(var5.field556))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field581.put(Integer.valueOf(var5.field556), var6);
               } else {
                  List var7 = (List)this.field581.get(Integer.valueOf(var5.field556));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "-2009723712"
   )
   float method552(int var1, int var2) {
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

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "0"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if(var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if(var2 < 3 && (class61.tileSettings[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * class61.tileHeights[var5][var3][var4] + class61.tileHeights[var5][var3 + 1][var4] * var6 >> 7;
         int var9 = class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) + class61.tileHeights[var5][var3 + 1][var4 + 1] * var6 >> 7;
         return var8 * (128 - var7) + var7 * var9 >> 7;
      } else {
         return 0;
      }
   }
}
