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

@ObfuscatedName("ax")
public final class class41 {
   @ObfuscatedName("i")
   class44 field549;
   @ObfuscatedName("p")
   boolean field550;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1196832181
   )
   int field551;
   @ObfuscatedName("j")
   SpritePixels field552;
   @ObfuscatedName("f")
   HashMap field553;
   @ObfuscatedName("m")
   class34[][] field554;
   @ObfuscatedName("z")
   ModIcon[] field555;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -839065455
   )
   int field556;
   @ObfuscatedName("h")
   final HashMap field557;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -840577409
   )
   int field558;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 376535359
   )
   int field560;
   @ObfuscatedName("c")
   HashMap field561;
   @ObfuscatedName("l")
   static int[] field563;
   @ObfuscatedName("n")
   boolean field564;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public boolean method547() {
      return this.field564;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;ZI)V",
      garbageValue = "-752119611"
   )
   public void method548(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field550) {
         this.field564 = false;
         this.field550 = true;
         System.nanoTime();
         int var4 = var1.method4141(class40.field540.field543);
         int var5 = var1.method4209(var4, var2);
         Buffer var6 = new Buffer(var1.method4144(class40.field540.field543, var2));
         Buffer var7 = new Buffer(var1.method4144(class40.field544.field543, var2));
         Buffer var8 = new Buffer(var1.method4144(var2, class40.field542.field543));
         System.nanoTime();
         System.nanoTime();
         this.field549 = new class44();

         try {
            this.field549.method609(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var24) {
            return;
         }

         this.field549.method321();
         this.field549.method307();
         this.field549.method308();
         this.field558 = this.field549.method302() * 64;
         this.field551 = this.field549.method330() * 64;
         this.field560 = (this.field549.method322() - this.field549.method302() + 1) * 64;
         this.field556 = (this.field549.method305() - this.field549.method330() + 1) * 64;
         int var18 = this.field549.method322() - this.field549.method302() + 1;
         int var10 = this.field549.method305() - this.field549.method330() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field554 = new class34[var18][var10];
         Iterator var11 = this.field549.field576.iterator();

         int var14;
         int var15;
         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field411;
            var14 = var12.field410;
            var15 = var13 - this.field549.method302();
            int var16 = var14 - this.field549.method330();
            this.field554[var15][var16] = new class34(var13, var14, this.field549.method300(), this.field557);
            this.field554[var15][var16].method403(var12, this.field549.field575);
         }

         for(int var19 = 0; var19 < var18; ++var19) {
            for(int var20 = 0; var20 < var10; ++var20) {
               if(this.field554[var19][var20] == null) {
                  this.field554[var19][var20] = new class34(this.field549.method302() + var19, this.field549.method330() + var20, this.field549.method300(), this.field557);
                  this.field554[var19][var20].method360(this.field549.field574, this.field549.field575);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4193(class40.field541.field543, var2)) {
            byte[] var27 = var1.method4144(class40.field541.field543, var2);
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

            this.field552 = var28;
         }

         System.nanoTime();
         this.field564 = true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "80"
   )
   public final void method550(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.method4963(var12);
      class29 var13 = this.method554(var1, var2, var3, var4);
      float var14 = this.method558(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field561.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method651();
         this.field561.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field423; var17 < var13.field423 + var13.field425; ++var17) {
         for(var18 = var13.field424; var18 < var13.field424 + var13.field428; ++var18) {
            this.method552(var17, var18, var22);
            this.field554[var17][var18].method363(var15, (class46)this.field561.get(Integer.valueOf(var15)), var22, this.field555);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.method5048(var12);
      var17 = (int)(64.0F * var14);
      var18 = this.field558 + var1;
      int var19 = this.field551 + var2;

      for(int var20 = var13.field423; var20 < var13.field425 + var13.field423; ++var20) {
         for(int var21 = var13.field424; var21 < var13.field424 + var13.field428; ++var21) {
            this.field554[var20][var21].method358((this.field554[var20][var21].field482 * 64 - var18) * var17 / 64 + var5, var8 - var17 * (this.field554[var20][var21].field495 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "1501157473"
   )
   public final void method551(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method554(var1, var2, var3, var4);
      float var15 = this.method558(var7 - var5, var3 - var1);
      int var16 = (int)(64.0F * var15);
      int var17 = var1 + this.field558;
      int var18 = this.field551 + var2;

      int var19;
      int var20;
      for(var19 = var14.field423; var19 < var14.field425 + var14.field423; ++var19) {
         for(var20 = var14.field424; var20 < var14.field428 + var14.field424; ++var20) {
            if(var13) {
               this.field554[var19][var20].method387();
            }

            this.field554[var19][var20].method450(var5 + var16 * (this.field554[var19][var20].field482 * 64 - var17) / 64, var8 - var16 * (this.field554[var19][var20].field495 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field423; var19 < var14.field425 + var14.field423; ++var19) {
            for(var20 = var14.field424; var20 < var14.field428 + var14.field424; ++var20) {
               this.field554[var19][var20].method365(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II[Lclass34;I)V",
      garbageValue = "-2120001755"
   )
   void method552(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field554.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field554[0].length - 1;
      if(var7) {
         var3[class228.field3152.vmethod5059()] = null;
      } else {
         var3[class228.field3152.vmethod5059()] = this.field554[var1][var2 + 1];
      }

      var3[class228.field3160.vmethod5059()] = !var7 && !var5?this.field554[var1 + 1][var2 + 1]:null;
      var3[class228.field3156.vmethod5059()] = !var7 && !var4?this.field554[var1 - 1][var2 + 1]:null;
      var3[class228.field3157.vmethod5059()] = var5?null:this.field554[var1 + 1][var2];
      var3[class228.field3155.vmethod5059()] = var4?null:this.field554[var1 - 1][var2];
      var3[class228.field3153.vmethod5059()] = var6?null:this.field554[var1][var2 - 1];
      var3[class228.field3151.vmethod5059()] = !var6 && !var5?this.field554[var1 + 1][var2 - 1]:null;
      var3[class228.field3154.vmethod5059()] = !var6 && !var4?this.field554[var1 - 1][var2 - 1]:null;
   }

   public class41(ModIcon[] var1, HashMap var2) {
      this.field564 = false;
      this.field550 = false;
      this.field561 = new HashMap();
      this.field555 = var1;
      this.field557 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIIB)Ljava/util/List;",
      garbageValue = "87"
   )
   public List method553(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field564) {
         return var11;
      } else {
         class29 var12 = this.method554(var1, var2, var3, var4);
         float var13 = this.method558(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field558 + var1;
         int var16 = this.field551 + var2;

         for(int var17 = var12.field423; var17 < var12.field423 + var12.field425; ++var17) {
            for(int var18 = var12.field424; var18 < var12.field424 + var12.field428; ++var18) {
               List var19 = this.field554[var17][var18].method394(var5 + (this.field554[var17][var18].field482 * 64 - var15) * var14 / 64, var8 + var6 - (this.field554[var17][var18].field495 * 64 - var16 + 64) * var14 / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIII)Lclass29;",
      garbageValue = "1972585342"
   )
   class29 method554(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = var1 + this.field558;
      int var7 = this.field551 + var2;
      int var8 = this.field558 + var3;
      int var9 = this.field551 + var4;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field425 = var12 - var10 + 1;
      var5.field428 = var13 - var11 + 1;
      var5.field423 = var10 - this.field549.method302();
      var5.field424 = var11 - this.field549.method330();
      if(var5.field423 < 0) {
         var5.field425 += var5.field423;
         var5.field423 = 0;
      }

      if(var5.field423 > this.field554.length - var5.field425) {
         var5.field425 = this.field554.length - var5.field423;
      }

      if(var5.field424 < 0) {
         var5.field428 += var5.field424;
         var5.field424 = 0;
      }

      if(var5.field424 > this.field554[0].length - var5.field428) {
         var5.field428 = this.field554[0].length - var5.field424;
      }

      var5.field425 = Math.min(var5.field425, this.field554.length);
      var5.field428 = Math.min(var5.field428, this.field554[0].length);
      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "-1463357235"
   )
   public HashMap method555() {
      this.method557();
      return this.field553;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1980572608"
   )
   void method557() {
      if(this.field553 == null) {
         this.field553 = new HashMap();
      }

      this.field553.clear();

      for(int var1 = 0; var1 < this.field554.length; ++var1) {
         for(int var2 = 0; var2 < this.field554[var1].length; ++var2) {
            List var3 = this.field554[var1][var2].method395();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field553.containsKey(Integer.valueOf(var5.field538))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field553.put(Integer.valueOf(var5.field538), var6);
               } else {
                  List var7 = (List)this.field553.get(Integer.valueOf(var5.field538));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "1170839204"
   )
   float method558(int var1, int var2) {
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "-1542651409"
   )
   public void method563(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field552 != null) {
         this.field552.method5099(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field553 == null) {
               this.method557();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field553.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field527.worldX - this.field558) / this.field560;
                  int var14 = var4 - (var12.field527.worldY - this.field551) * var4 / this.field556;
                  Rasterizer2D.method4967(var13 + var1, var2 + var14, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "73"
   )
   public final void method565() {
      this.field553 = null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "-404325165"
   )
   public static ModIcon[] method582(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method4141(var1);
      int var4 = var0.method4209(var3, var2);
      return class204.method3809(var0, var3, var4);
   }
}
