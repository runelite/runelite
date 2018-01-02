import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;

@ObfuscatedName("af")
public final class class41 {
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -2026282337
   )
   static int field523;
   @ObfuscatedName("a")
   boolean field526;
   @ObfuscatedName("w")
   boolean field518;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   WorldMapMappings field519;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lks;"
   )
   SpritePixels field531;
   @ObfuscatedName("u")
   HashMap field521;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "[[Lap;"
   )
   class34[][] field522;
   @ObfuscatedName("t")
   HashMap field530;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "[Lkg;"
   )
   IndexedSprite[] field524;
   @ObfuscatedName("g")
   final HashMap field525;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 317175453
   )
   int field517;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -171493247
   )
   int field527;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1813487891
   )
   int field528;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -407550977
   )
   int field529;

   @ObfuscatedSignature(
      signature = "([Lkg;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field526 = false;
      this.field518 = false;
      this.field530 = new HashMap();
      this.field524 = var1;
      this.field525 = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;Ljava/lang/String;ZI)V",
      garbageValue = "158931449"
   )
   public void method551(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field518) {
         this.field526 = false;
         this.field518 = true;
         System.nanoTime();
         int var4 = var1.getFile(NamedRecord.field510.field514);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.takeRecordByNames(NamedRecord.field510.field514, var2));
         Buffer var7 = new Buffer(var1.takeRecordByNames(NamedRecord.field508.field514, var2));
         Buffer var8 = new Buffer(var1.takeRecordByNames(var2, NamedRecord.field511.field514));
         System.nanoTime();
         System.nanoTime();
         this.field519 = new WorldMapMappings();

         try {
            this.field519.method618(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var24) {
            return;
         }

         this.field519.method288();
         this.field519.method335();
         this.field519.method294();
         this.field517 = this.field519.method340() * 64;
         this.field527 = this.field519.method286() * 64;
         this.field528 = (this.field519.method285() - this.field519.method340() + 1) * 64;
         this.field529 = (this.field519.method287() - this.field519.method286() + 1) * 64;
         int var18 = this.field519.method285() - this.field519.method340() + 1;
         int var10 = this.field519.method287() - this.field519.method286() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field522 = new class34[var18][var10];
         Iterator var11 = this.field519.field541.iterator();

         int var14;
         int var15;
         while(var11.hasNext()) {
            SceneComposition var12 = (SceneComposition)var11.next();
            int var13 = var12.field383;
            var14 = var12.field374;
            var15 = var13 - this.field519.method340();
            int var16 = var14 - this.field519.method286();
            this.field522[var15][var16] = new class34(var13, var14, this.field519.method270(), this.field525);
            this.field522[var15][var16].method348(var12, this.field519.field544);
         }

         for(int var19 = 0; var19 < var18; ++var19) {
            for(int var20 = 0; var20 < var10; ++var20) {
               if(this.field522[var19][var20] == null) {
                  this.field522[var19][var20] = new class34(this.field519.method340() + var19, this.field519.method286() + var20, this.field519.method270(), this.field525);
                  this.field522[var19][var20].method363(this.field519.field542, this.field519.field544);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4273(NamedRecord.field513.field514, var2)) {
            byte[] var27 = var1.takeRecordByNames(NamedRecord.field513.field514, var2);
            BufferedImage var21 = null;

            SpritePixels var28;
            label46: {
               try {
                  var21 = ImageIO.read(new ByteArrayInputStream(var27));
                  var14 = var21.getWidth();
                  var15 = var21.getHeight();
                  int[] var22 = new int[var14 * var15];
                  PixelGrabber var17 = new PixelGrabber(var21, 0, 0, var14, var15, var22, 0, var14);
                  var17.grabPixels();
                  var28 = new SpritePixels(var22, var14, var15);
                  break label46;
               } catch (IOException var25) {
                  ;
               } catch (InterruptedException var26) {
                  ;
               }

               var28 = new SpritePixels(0, 0);
            }

            this.field531 = var28;
         }

         System.nanoTime();
         this.field526 = true;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-83186469"
   )
   public final void method552() {
      this.field521 = null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "0"
   )
   public final void method553(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method558(var1, var2, var3, var4);
      float var14 = this.method565(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field530.containsKey(Integer.valueOf(var15))) {
         SceneChunkMetadata var16 = new SceneChunkMetadata(var15);
         var16.method663();
         this.field530.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field395; var17 < var13.field396 + var13.field395; ++var17) {
         for(var18 = var13.field388; var18 < var13.field388 + var13.field385; ++var18) {
            this.method555(var17, var18, var22);
            this.field522[var17][var18].method352(var15, (SceneChunkMetadata)this.field530.get(Integer.valueOf(var15)), var22, this.field524);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field517 + var1;
      int var19 = var2 + this.field527;

      for(int var20 = var13.field395; var20 < var13.field396 + var13.field395; ++var20) {
         for(int var21 = var13.field388; var21 < var13.field388 + var13.field385; ++var21) {
            this.field522[var20][var21].method377(var5 + var17 * (this.field522[var20][var21].field442 * 64 - var18) / 64, var8 - var17 * (this.field522[var20][var21].field445 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "1557095915"
   )
   public final void method554(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method558(var1, var2, var3, var4);
      float var15 = this.method565(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field517 + var1;
      int var18 = var2 + this.field527;

      int var19;
      int var20;
      for(var19 = var14.field395; var19 < var14.field396 + var14.field395; ++var19) {
         for(var20 = var14.field388; var20 < var14.field388 + var14.field385; ++var20) {
            if(var13) {
               this.field522[var19][var20].method416();
            }

            this.field522[var19][var20].method476(var5 + var16 * (this.field522[var19][var20].field442 * 64 - var17) / 64, var8 - var16 * (this.field522[var19][var20].field445 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field395; var19 < var14.field396 + var14.field395; ++var19) {
            for(var20 = var14.field388; var20 < var14.field388 + var14.field385; ++var20) {
               this.field522[var19][var20].method354(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II[Lap;B)V",
      garbageValue = "64"
   )
   void method555(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field522.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field522[0].length - 1;
      if(var7) {
         var3[class239.field3261.rsOrdinal()] = null;
      } else {
         var3[class239.field3261.rsOrdinal()] = this.field522[var1][var2 + 1];
      }

      var3[class239.field3256.rsOrdinal()] = !var7 && !var5?this.field522[var1 + 1][var2 + 1]:null;
      var3[class239.field3258.rsOrdinal()] = !var7 && !var4?this.field522[var1 - 1][var2 + 1]:null;
      var3[class239.field3257.rsOrdinal()] = var5?null:this.field522[var1 + 1][var2];
      var3[class239.field3262.rsOrdinal()] = var4?null:this.field522[var1 - 1][var2];
      var3[class239.field3259.rsOrdinal()] = var6?null:this.field522[var1][var2 - 1];
      var3[class239.field3263.rsOrdinal()] = !var6 && !var5?this.field522[var1 + 1][var2 - 1]:null;
      var3[class239.field3260.rsOrdinal()] = !var6 && !var4?this.field522[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "741428698"
   )
   public void method556(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field531 != null) {
         this.field531.method5207(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field521 == null) {
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
                  var10 = (List)this.field521.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  AreaMapIconMetadata var12 = (AreaMapIconMetadata)var11.next();
                  int var13 = var3 * (var12.field498.worldX - this.field517) / this.field528;
                  int var14 = var4 - (var12.field498.worldY - this.field527) * var4 / this.field529;
                  Rasterizer2D.method5087(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "-1560160215"
   )
   public List method557(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field526) {
         return var11;
      } else {
         class29 var12 = this.method558(var1, var2, var3, var4);
         float var13 = this.method565(var7, var3 - var1);
         int var14 = (int)(64.0F * var13);
         int var15 = this.field517 + var1;
         int var16 = var2 + this.field527;

         for(int var17 = var12.field395; var17 < var12.field395 + var12.field396; ++var17) {
            for(int var18 = var12.field388; var18 < var12.field385 + var12.field388; ++var18) {
               List var19 = this.field522[var17][var18].method346(var5 + var14 * (this.field522[var17][var18].field442 * 64 - var15) / 64, var8 + var6 - var14 * (this.field522[var17][var18].field445 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIII)Lak;",
      garbageValue = "-1694353681"
   )
   class29 method558(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field517 + var1;
      int var7 = var2 + this.field527;
      int var8 = var3 + this.field517;
      int var9 = var4 + this.field527;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field396 = var12 - var10 + 1;
      var5.field385 = var13 - var11 + 1;
      var5.field395 = var10 - this.field519.method340();
      var5.field388 = var11 - this.field519.method286();
      if(var5.field395 < 0) {
         var5.field396 += var5.field395;
         var5.field395 = 0;
      }

      if(var5.field395 > this.field522.length - var5.field396) {
         var5.field396 = this.field522.length - var5.field395;
      }

      if(var5.field388 < 0) {
         var5.field385 += var5.field388;
         var5.field388 = 0;
      }

      if(var5.field388 > this.field522[0].length - var5.field385) {
         var5.field385 = this.field522[0].length - var5.field388;
      }

      var5.field396 = Math.min(var5.field396, this.field522.length);
      var5.field385 = Math.min(var5.field385, this.field522[0].length);
      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-29"
   )
   public boolean method571() {
      return this.field526;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/HashMap;",
      garbageValue = "9"
   )
   public HashMap method560() {
      this.method561();
      return this.field521;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1979918252"
   )
   void method561() {
      if(this.field521 == null) {
         this.field521 = new HashMap();
      }

      this.field521.clear();

      for(int var1 = 0; var1 < this.field522.length; ++var1) {
         for(int var2 = 0; var2 < this.field522[var1].length; ++var2) {
            List var3 = this.field522[var1][var2].method383();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               AreaMapIconMetadata var5 = (AreaMapIconMetadata)var4.next();
               if(!this.field521.containsKey(Integer.valueOf(var5.field499))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field521.put(Integer.valueOf(var5.field499), var6);
               } else {
                  List var7 = (List)this.field521.get(Integer.valueOf(var5.field499));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "-899122235"
   )
   float method565(int var1, int var2) {
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IB)Lbv;",
      garbageValue = "1"
   )
   static MessageNode method576(int var0) {
      return (MessageNode)class96.messages.get((long)var0);
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static void method574() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
   }
}
