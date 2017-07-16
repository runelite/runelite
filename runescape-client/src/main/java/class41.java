import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("as")
public final class class41 {
   @ObfuscatedName("gv")
   @ObfuscatedGetter(
      intValue = 569311249
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("kv")
   @ObfuscatedGetter(
      intValue = 587899089
   )
   static int field550;
   @ObfuscatedName("j")
   boolean field537;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   SpritePixels field539;
   @ObfuscatedName("a")
   boolean field549;
   @ObfuscatedName("v")
   HashMap field544;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[[Laq;"
   )
   class34[][] field540;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1504460433
   )
   int field545;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -386823317
   )
   int field546;
   @ObfuscatedName("l")
   HashMap field542;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Ljf;"
   )
   ModIcon[] field543;
   @ObfuscatedName("w")
   final HashMap field536;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lat;"
   )
   class44 field538;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 55184195
   )
   int field547;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 946748035
   )
   int field548;

   @ObfuscatedSignature(
      signature = "([Ljf;Ljava/util/HashMap;)V"
   )
   public class41(ModIcon[] var1, HashMap var2) {
      this.field549 = false;
      this.field537 = false;
      this.field542 = new HashMap();
      this.field543 = var1;
      this.field536 = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1859992010"
   )
   void method564() {
      if(this.field544 == null) {
         this.field544 = new HashMap();
      }

      this.field544.clear();

      for(int var1 = 0; var1 < this.field540.length; ++var1) {
         for(int var2 = 0; var2 < this.field540[var1].length; ++var2) {
            List var3 = this.field540[var1][var2].method396();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field544.containsKey(Integer.valueOf(var5.field523))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field544.put(Integer.valueOf(var5.field523), var6);
               } else {
                  List var7 = (List)this.field544.get(Integer.valueOf(var5.field523));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIII)Lak;",
      garbageValue = "-626746864"
   )
   class29 method561(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field545 + var1;
      int var7 = var2 + this.field546;
      int var8 = var3 + this.field545;
      int var9 = var4 + this.field546;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field412 = var12 - var10 + 1;
      var5.field413 = var13 - var11 + 1;
      var5.field417 = var10 - this.field538.method291();
      var5.field414 = var11 - this.field538.method292();
      if(var5.field417 < 0) {
         var5.field412 += var5.field417;
         var5.field417 = 0;
      }

      if(var5.field417 > this.field540.length - var5.field412) {
         var5.field412 = this.field540.length - var5.field417;
      }

      if(var5.field414 < 0) {
         var5.field413 += var5.field414;
         var5.field414 = 0;
      }

      if(var5.field414 > this.field540[0].length - var5.field413) {
         var5.field413 = this.field540[0].length - var5.field414;
      }

      var5.field412 = Math.min(var5.field412, this.field540.length);
      var5.field413 = Math.min(var5.field413, this.field540[0].length);
      return var5;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "-751093638"
   )
   float method592(int var1, int var2) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-143781249"
   )
   public boolean method562() {
      return this.field549;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "1728120274"
   )
   public HashMap method579() {
      this.method564();
      return this.field544;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "1142967504"
   )
   public void method591(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field539 != null) {
         this.field539.method5030(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field544 == null) {
               this.method564();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field544.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field516.worldX - this.field545) / this.field547;
                  int var14 = var4 - (var12.field516.worldY - this.field546) * var4 / this.field548;
                  Rasterizer2D.method4852(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lif;Ljava/lang/String;ZS)V",
      garbageValue = "-1527"
   )
   public void method565(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field537) {
         this.field549 = false;
         this.field537 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field535.field532);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.method4116(class40.field535.field532, var2));
         Buffer var7 = new Buffer(var1.method4116(class40.field528.field532, var2));
         Buffer var8 = new Buffer(var1.method4116(var2, class40.field533.field532));
         System.nanoTime();
         System.nanoTime();
         this.field538 = new class44();

         try {
            this.field538.method633(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field538.method295();
         this.field538.method342();
         this.field538.method297();
         this.field545 = this.field538.method291() * 64;
         this.field546 = this.field538.method292() * 64;
         this.field547 = (this.field538.method277() - this.field538.method291() + 1) * 64;
         this.field548 = (this.field538.method279() - this.field538.method292() + 1) * 64;
         int var9 = this.field538.method277() - this.field538.method291() + 1;
         int var10 = this.field538.method279() - this.field538.method292() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field540 = new class34[var9][var10];
         Iterator var11 = this.field538.field566.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field403;
            int var14 = var12.field400;
            int var15 = var13 - this.field538.method291();
            int var16 = var14 - this.field538.method292();
            this.field540[var15][var16] = new class34(var13, var14, this.field538.method335(), this.field536);
            this.field540[var15][var16].method357(var12, this.field538.field567);
         }

         for(int var17 = 0; var17 < var9; ++var17) {
            for(int var18 = 0; var18 < var10; ++var18) {
               if(this.field540[var17][var18] == null) {
                  this.field540[var17][var18] = new class34(this.field538.method291() + var17, this.field538.method292() + var18, this.field538.method335(), this.field536);
                  this.field540[var17][var18].method431(this.field538.field565, this.field538.field567);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4084(class40.field529.field532, var2)) {
            byte[] var21 = var1.method4116(class40.field529.field532, var2);
            this.field539 = class43.method622(var21);
         }

         System.nanoTime();
         this.field549 = true;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIIB)Ljava/util/List;",
      garbageValue = "-1"
   )
   public List method563(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field549) {
         return var11;
      } else {
         class29 var12 = this.method561(var1, var2, var3, var4);
         float var13 = this.method592(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field545 + var1;
         int var16 = var2 + this.field546;

         for(int var17 = var12.field417; var17 < var12.field412 + var12.field417; ++var17) {
            for(int var18 = var12.field414; var18 < var12.field413 + var12.field414; ++var18) {
               List var19 = this.field540[var17][var18].method457(var5 + (this.field540[var17][var18].field470 * 64 - var15) * var14 / 64, var8 + var6 - var14 * (this.field540[var17][var18].field466 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2121992926"
   )
   public final void method570() {
      this.field544 = null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II[Laq;I)V",
      garbageValue = "683892967"
   )
   void method587(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field540.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field540[0].length - 1;
      if(var7) {
         var3[class228.field3155.rsOrdinal()] = null;
      } else {
         var3[class228.field3155.rsOrdinal()] = this.field540[var1][var2 + 1];
      }

      var3[class228.field3159.rsOrdinal()] = !var7 && !var5?this.field540[var1 + 1][var2 + 1]:null;
      var3[class228.field3158.rsOrdinal()] = !var7 && !var4?this.field540[var1 - 1][var2 + 1]:null;
      var3[class228.field3153.rsOrdinal()] = var5?null:this.field540[var1 + 1][var2];
      var3[class228.field3157.rsOrdinal()] = var4?null:this.field540[var1 - 1][var2];
      var3[class228.field3161.rsOrdinal()] = var6?null:this.field540[var1][var2 - 1];
      var3[class228.field3154.rsOrdinal()] = !var6 && !var5?this.field540[var1 + 1][var2 - 1]:null;
      var3[class228.field3156.rsOrdinal()] = !var6 && !var4?this.field540[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1146025128"
   )
   public final void method556(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method561(var1, var2, var3, var4);
      float var14 = this.method592(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field542.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method678();
         this.field542.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field417; var17 < var13.field417 + var13.field412; ++var17) {
         for(var18 = var13.field414; var18 < var13.field414 + var13.field413; ++var18) {
            this.method587(var17, var18, var22);
            this.field540[var17][var18].method361(var15, (class46)this.field542.get(Integer.valueOf(var15)), var22, this.field543);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field545 + var1;
      int var19 = var2 + this.field546;

      for(int var20 = var13.field417; var20 < var13.field412 + var13.field417; ++var20) {
         for(int var21 = var13.field414; var21 < var13.field413 + var13.field414; ++var21) {
            this.field540[var20][var21].method458(var5 + (this.field540[var20][var21].field470 * 64 - var18) * var17 / 64, var8 - (this.field540[var20][var21].field466 * 64 - var19 + 64) * var17 / 64, var17);
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZB)V",
      garbageValue = "0"
   )
   public final void method581(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method561(var1, var2, var3, var4);
      float var15 = this.method592(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field545 + var1;
      int var18 = var2 + this.field546;

      int var19;
      int var20;
      for(var19 = var14.field417; var19 < var14.field412 + var14.field417; ++var19) {
         for(var20 = var14.field414; var20 < var14.field414 + var14.field413; ++var20) {
            if(var13) {
               this.field540[var19][var20].method384();
            }

            this.field540[var19][var20].method362(var5 + (this.field540[var19][var20].field470 * 64 - var17) * var16 / 64, var8 - var16 * (this.field540[var19][var20].field466 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field417; var19 < var14.field412 + var14.field417; ++var19) {
            for(var20 = var14.field414; var20 < var14.field413 + var14.field414; ++var20) {
               this.field540[var19][var20].method363(var10, var11, var12);
            }
         }
      }

   }
}
