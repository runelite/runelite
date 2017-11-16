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

@ObfuscatedName("aj")
public final class class41 {
   @ObfuscatedName("nw")
   static byte field517;
   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "Lbm;"
   )
   static class70 field519;
   @ObfuscatedName("ft")
   @Export("landRegionFileIds")
   static int[] landRegionFileIds;
   @ObfuscatedName("b")
   boolean field522;
   @ObfuscatedName("s")
   boolean field509;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Laf;"
   )
   class44 field510;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   SpritePixels field511;
   @ObfuscatedName("x")
   HashMap field512;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[[Lao;"
   )
   class34[][] field521;
   @ObfuscatedName("u")
   HashMap field514;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   IndexedSprite[] field515;
   @ObfuscatedName("k")
   final HashMap field516;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -906760621
   )
   int field513;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -607143637
   )
   int field518;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1461842397
   )
   int field508;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1440394333
   )
   int field520;

   @ObfuscatedSignature(
      signature = "([Lks;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field522 = false;
      this.field509 = false;
      this.field514 = new HashMap();
      this.field515 = var1;
      this.field516 = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lij;Ljava/lang/String;ZI)V",
      garbageValue = "1401211903"
   )
   public void method520(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field509) {
         this.field522 = false;
         this.field509 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field507.field504);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.method4141(class40.field507.field504, var2));
         Buffer var7 = new Buffer(var1.method4141(class40.field500.field504, var2));
         Buffer var8 = new Buffer(var1.method4141(var2, class40.field502.field504));
         System.nanoTime();
         System.nanoTime();
         this.field510 = new class44();

         try {
            this.field510.method591(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var24) {
            return;
         }

         this.field510.method277();
         this.field510.method267();
         this.field510.method268();
         this.field513 = this.field510.method255() * 64;
         this.field518 = this.field510.method264() * 64;
         this.field508 = (this.field510.method312() - this.field510.method255() + 1) * 64;
         this.field520 = (this.field510.method310() - this.field510.method264() + 1) * 64;
         int var9 = this.field510.method312() - this.field510.method255() + 1;
         int var10 = this.field510.method310() - this.field510.method264() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field521 = new class34[var9][var10];
         Iterator var11 = this.field510.field539.iterator();

         int var14;
         int var15;
         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field386;
            var14 = var12.field376;
            var15 = var13 - this.field510.method255();
            int var16 = var14 - this.field510.method264();
            this.field521[var15][var16] = new class34(var13, var14, this.field510.method251(), this.field516);
            this.field521[var15][var16].method327(var12, this.field510.field534);
         }

         for(int var18 = 0; var18 < var9; ++var18) {
            for(int var19 = 0; var19 < var10; ++var19) {
               if(this.field521[var18][var19] == null) {
                  this.field521[var18][var19] = new class34(this.field510.method255() + var18, this.field510.method264() + var19, this.field510.method251(), this.field516);
                  this.field521[var18][var19].method336(this.field510.field535, this.field510.field534);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4125(class40.field501.field504, var2)) {
            byte[] var27 = var1.method4141(class40.field501.field504, var2);
            BufferedImage var20 = null;

            SpritePixels var28;
            label44: {
               try {
                  var20 = ImageIO.read(new ByteArrayInputStream(var27));
                  var14 = var20.getWidth();
                  var15 = var20.getHeight();
                  int[] var21 = new int[var14 * var15];
                  PixelGrabber var17 = new PixelGrabber(var20, 0, 0, var14, var15, var21, 0, var14);
                  var17.grabPixels();
                  var28 = new SpritePixels(var21, var14, var15);
                  break label44;
               } catch (IOException var25) {
                  ;
               } catch (InterruptedException var26) {
                  ;
               }

               var28 = new SpritePixels(0, 0);
            }

            this.field511 = var28;
         }

         System.nanoTime();
         this.field522 = true;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public final void method534() {
      this.field512 = null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "-88"
   )
   public final void method543(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method527(var1, var2, var3, var4);
      float var14 = this.method531(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field514.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method641();
         this.field514.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field391; var17 < var13.field395 + var13.field391; ++var17) {
         for(var18 = var13.field390; var18 < var13.field390 + var13.field389; ++var18) {
            this.method522(var17, var18, var22);
            this.field521[var17][var18].method331(var15, (class46)this.field514.get(Integer.valueOf(var15)), var22, this.field515);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field513 + var1;
      int var19 = var2 + this.field518;

      for(int var20 = var13.field391; var20 < var13.field391 + var13.field395; ++var20) {
         for(int var21 = var13.field390; var21 < var13.field389 + var13.field390; ++var21) {
            this.field521[var20][var21].method441(var5 + var17 * (this.field521[var20][var21].field442 * 64 - var18) / 64, var8 - var17 * (this.field521[var20][var21].field443 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "572060495"
   )
   public final void method524(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method527(var1, var2, var3, var4);
      float var15 = this.method531(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field513 + var1;
      int var18 = var2 + this.field518;

      int var19;
      int var20;
      for(var19 = var14.field391; var19 < var14.field395 + var14.field391; ++var19) {
         for(var20 = var14.field390; var20 < var14.field390 + var14.field389; ++var20) {
            if(var13) {
               this.field521[var19][var20].method355();
            }

            this.field521[var19][var20].method332(var5 + var16 * (this.field521[var19][var20].field442 * 64 - var17) / 64, var8 - var16 * (this.field521[var19][var20].field443 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field391; var19 < var14.field395 + var14.field391; ++var19) {
            for(var20 = var14.field390; var20 < var14.field390 + var14.field389; ++var20) {
               this.field521[var19][var20].method333(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[Lao;I)V",
      garbageValue = "-1142482837"
   )
   void method522(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field521.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field521[0].length - 1;
      if(var7) {
         var3[class235.field3217.rsOrdinal()] = null;
      } else {
         var3[class235.field3217.rsOrdinal()] = this.field521[var1][var2 + 1];
      }

      var3[class235.field3214.rsOrdinal()] = !var7 && !var5?this.field521[var1 + 1][var2 + 1]:null;
      var3[class235.field3219.rsOrdinal()] = !var7 && !var4?this.field521[var1 - 1][var2 + 1]:null;
      var3[class235.field3216.rsOrdinal()] = var5?null:this.field521[var1 + 1][var2];
      var3[class235.field3218.rsOrdinal()] = var4?null:this.field521[var1 - 1][var2];
      var3[class235.field3215.rsOrdinal()] = var6?null:this.field521[var1][var2 - 1];
      var3[class235.field3213.rsOrdinal()] = !var6 && !var5?this.field521[var1 + 1][var2 - 1]:null;
      var3[class235.field3212.rsOrdinal()] = !var6 && !var4?this.field521[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;IIB)V",
      garbageValue = "85"
   )
   public void method525(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field511 != null) {
         this.field511.method5116(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field512 == null) {
               this.method530();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field512.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field492.worldX - this.field513) / this.field508;
                  int var14 = var4 - (var12.field492.worldY - this.field518) * var4 / this.field520;
                  Rasterizer2D.method4979(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "1486050733"
   )
   public List method526(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field522) {
         return var11;
      } else {
         class29 var12 = this.method527(var1, var2, var3, var4);
         float var13 = this.method531(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field513 + var1;
         int var16 = var2 + this.field518;

         for(int var17 = var12.field391; var17 < var12.field391 + var12.field395; ++var17) {
            for(int var18 = var12.field390; var18 < var12.field390 + var12.field389; ++var18) {
               List var19 = this.field521[var17][var18].method344(var5 + var14 * (this.field521[var17][var18].field442 * 64 - var15) / 64, var8 + var6 - var14 * (this.field521[var17][var18].field443 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIII)Lak;",
      garbageValue = "2085869518"
   )
   class29 method527(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field513 + var1;
      int var7 = var2 + this.field518;
      int var8 = var3 + this.field513;
      int var9 = var4 + this.field518;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field395 = var12 - var10 + 1;
      var5.field389 = var13 - var11 + 1;
      var5.field391 = var10 - this.field510.method255();
      var5.field390 = var11 - this.field510.method264();
      if(var5.field391 < 0) {
         var5.field395 += var5.field391;
         var5.field391 = 0;
      }

      if(var5.field391 > this.field521.length - var5.field395) {
         var5.field395 = this.field521.length - var5.field391;
      }

      if(var5.field390 < 0) {
         var5.field389 += var5.field390;
         var5.field390 = 0;
      }

      if(var5.field390 > this.field521[0].length - var5.field389) {
         var5.field389 = this.field521[0].length - var5.field390;
      }

      var5.field395 = Math.min(var5.field395, this.field521.length);
      var5.field389 = Math.min(var5.field389, this.field521[0].length);
      return var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-95835481"
   )
   public boolean method528() {
      return this.field522;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "-90905813"
   )
   public HashMap method529() {
      this.method530();
      return this.field512;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2000445816"
   )
   void method530() {
      if(this.field512 == null) {
         this.field512 = new HashMap();
      }

      this.field512.clear();

      for(int var1 = 0; var1 < this.field521.length; ++var1) {
         for(int var2 = 0; var2 < this.field521[var1].length; ++var2) {
            List var3 = this.field521[var1][var2].method470();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field512.containsKey(Integer.valueOf(var5.field498))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field512.put(Integer.valueOf(var5.field498), var6);
               } else {
                  List var7 = (List)this.field512.get(Integer.valueOf(var5.field498));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "-1856991122"
   )
   float method531(int var1, int var2) {
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "100"
   )
   static void method560(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = class54.worldList[var6];
         class54.worldList[var6] = class54.worldList[var1];
         class54.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            if(class217.method3959(class54.worldList[var9], var8, var2, var3, var4, var5) <= 0) {
               World var10 = class54.worldList[var9];
               class54.worldList[var9] = class54.worldList[var7];
               class54.worldList[var7++] = var10;
            }
         }

         class54.worldList[var1] = class54.worldList[var7];
         class54.worldList[var7] = var8;
         method560(var0, var7 - 1, var2, var3, var4, var5);
         method560(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1452495328"
   )
   static final void method559() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            class60.method967(var0);
         } else {
            var0.unlink();
         }
      }

   }
}
