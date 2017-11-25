import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("an")
public final class class41 {
   @ObfuscatedName("d")
   boolean field531;
   @ObfuscatedName("x")
   boolean field523;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lar;"
   )
   class44 field537;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   SpritePixels field526;
   @ObfuscatedName("v")
   HashMap field525;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[[Laj;"
   )
   class34[][] field527;
   @ObfuscatedName("b")
   HashMap field528;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "[Lkl;"
   )
   IndexedSprite[] field529;
   @ObfuscatedName("p")
   final HashMap field530;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 664524629
   )
   int field524;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1220443009
   )
   int field532;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -905417219
   )
   int field533;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1805270337
   )
   int field522;

   @ObfuscatedSignature(
      signature = "([Lkl;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field531 = false;
      this.field523 = false;
      this.field528 = new HashMap();
      this.field529 = var1;
      this.field530 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;Ljava/lang/String;ZI)V",
      garbageValue = "984252178"
   )
   public void method558(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field523) {
         this.field531 = false;
         this.field523 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field514.field517);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.method4284(class40.field514.field517, var2));
         Buffer var7 = new Buffer(var1.method4284(class40.field515.field517, var2));
         Buffer var8 = new Buffer(var1.method4284(var2, class40.field519.field517));
         System.nanoTime();
         System.nanoTime();
         this.field537 = new class44();

         try {
            this.field537.method635(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field537.method328();
         this.field537.method292();
         this.field537.method293();
         this.field524 = this.field537.method287() * 64;
         this.field532 = this.field537.method289() * 64;
         this.field533 = (this.field537.method288() - this.field537.method287() + 1) * 64;
         this.field522 = (this.field537.method290() - this.field537.method289() + 1) * 64;
         int var9 = this.field537.method288() - this.field537.method287() + 1;
         int var10 = this.field537.method290() - this.field537.method289() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field527 = new class34[var9][var10];
         Iterator var11 = this.field537.field551.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field391;
            int var14 = var12.field379;
            int var15 = var13 - this.field537.method287();
            int var16 = var14 - this.field537.method289();
            this.field527[var15][var16] = new class34(var13, var14, this.field537.method285(), this.field530);
            this.field527[var15][var16].method363(var12, this.field537.field552);
         }

         for(int var17 = 0; var17 < var9; ++var17) {
            for(int var18 = 0; var18 < var10; ++var18) {
               if(this.field527[var17][var18] == null) {
                  this.field527[var17][var18] = new class34(this.field537.method287() + var17, this.field537.method289() + var18, this.field537.method285(), this.field530);
                  this.field527[var17][var18].method437(this.field537.field556, this.field537.field552);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4283(class40.field516.field517, var2)) {
            byte[] var21 = var1.method4284(class40.field516.field517, var2);
            this.field526 = FileOnDisk.method2479(var21);
         }

         System.nanoTime();
         this.field531 = true;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1584851774"
   )
   public final void method571() {
      this.field525 = null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1564627984"
   )
   public final void method560(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method565(var1, var2, var3, var4);
      float var14 = this.method569(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field528.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method707();
         this.field528.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field401; var17 < var13.field401 + var13.field395; ++var17) {
         for(var18 = var13.field398; var18 < var13.field398 + var13.field399; ++var18) {
            this.method562(var17, var18, var22);
            this.field527[var17][var18].method367(var15, (class46)this.field528.get(Integer.valueOf(var15)), var22, this.field529);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field524 + var1;
      int var19 = var2 + this.field532;

      for(int var20 = var13.field401; var20 < var13.field395 + var13.field401; ++var20) {
         for(int var21 = var13.field398; var21 < var13.field399 + var13.field398; ++var21) {
            this.field527[var20][var21].method368(var5 + var17 * (this.field527[var20][var21].field471 * 64 - var18) / 64, var8 - var17 * (this.field527[var20][var21].field452 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "2112782855"
   )
   public final void method561(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method565(var1, var2, var3, var4);
      float var15 = this.method569(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field524 + var1;
      int var18 = var2 + this.field532;

      int var19;
      int var20;
      for(var19 = var14.field401; var19 < var14.field401 + var14.field395; ++var19) {
         for(var20 = var14.field398; var20 < var14.field399 + var14.field398; ++var20) {
            if(var13) {
               this.field527[var19][var20].method390();
            }

            this.field527[var19][var20].method472(var5 + var16 * (this.field527[var19][var20].field471 * 64 - var17) / 64, var8 - var16 * (this.field527[var19][var20].field452 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field401; var19 < var14.field401 + var14.field395; ++var19) {
            for(var20 = var14.field398; var20 < var14.field399 + var14.field398; ++var20) {
               this.field527[var19][var20].method369(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II[Laj;I)V",
      garbageValue = "-1373427293"
   )
   void method562(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field527.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field527[0].length - 1;
      if(var7) {
         var3[class235.field3233.rsOrdinal()] = null;
      } else {
         var3[class235.field3233.rsOrdinal()] = this.field527[var1][var2 + 1];
      }

      var3[class235.field3230.rsOrdinal()] = !var7 && !var5?this.field527[var1 + 1][var2 + 1]:null;
      var3[class235.field3236.rsOrdinal()] = !var7 && !var4?this.field527[var1 - 1][var2 + 1]:null;
      var3[class235.field3234.rsOrdinal()] = var5?null:this.field527[var1 + 1][var2];
      var3[class235.field3235.rsOrdinal()] = var4?null:this.field527[var1 - 1][var2];
      var3[class235.field3231.rsOrdinal()] = var6?null:this.field527[var1][var2 - 1];
      var3[class235.field3232.rsOrdinal()] = !var6 && !var5?this.field527[var1 + 1][var2 - 1]:null;
      var3[class235.field3229.rsOrdinal()] = !var6 && !var4?this.field527[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "-1113682579"
   )
   public void method563(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field526 != null) {
         this.field526.method5270(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field525 == null) {
               this.method597();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field525.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field506.worldX - this.field524) / this.field533;
                  int var14 = var4 - (var12.field506.worldY - this.field532) * var4 / this.field522;
                  Rasterizer2D.method5136(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "-429170342"
   )
   public List method564(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field531) {
         return var11;
      } else {
         class29 var12 = this.method565(var1, var2, var3, var4);
         float var13 = this.method569(var7, var3 - var1);
         int var14 = (int)(64.0F * var13);
         int var15 = this.field524 + var1;
         int var16 = var2 + this.field532;

         for(int var17 = var12.field401; var17 < var12.field401 + var12.field395; ++var17) {
            for(int var18 = var12.field398; var18 < var12.field399 + var12.field398; ++var18) {
               List var19 = this.field527[var17][var18].method397(var5 + var14 * (this.field527[var17][var18].field471 * 64 - var15) / 64, var8 + var6 - var14 * (this.field527[var17][var18].field452 * 64 - var16 + 64) / 64, var14, var9, var10);
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
      signature = "(IIIII)Lax;",
      garbageValue = "34044409"
   )
   class29 method565(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field524 + var1;
      int var7 = var2 + this.field532;
      int var8 = var3 + this.field524;
      int var9 = var4 + this.field532;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field395 = var12 - var10 + 1;
      var5.field399 = var13 - var11 + 1;
      var5.field401 = var10 - this.field537.method287();
      var5.field398 = var11 - this.field537.method289();
      if(var5.field401 < 0) {
         var5.field395 += var5.field401;
         var5.field401 = 0;
      }

      if(var5.field401 > this.field527.length - var5.field395) {
         var5.field395 = this.field527.length - var5.field401;
      }

      if(var5.field398 < 0) {
         var5.field399 += var5.field398;
         var5.field398 = 0;
      }

      if(var5.field398 > this.field527[0].length - var5.field399) {
         var5.field399 = this.field527[0].length - var5.field398;
      }

      var5.field395 = Math.min(var5.field395, this.field527.length);
      var5.field399 = Math.min(var5.field399, this.field527[0].length);
      return var5;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "53"
   )
   public boolean method582() {
      return this.field531;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "1480551726"
   )
   public HashMap method600() {
      this.method597();
      return this.field525;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "5000"
   )
   void method597() {
      if(this.field525 == null) {
         this.field525 = new HashMap();
      }

      this.field525.clear();

      for(int var1 = 0; var1 < this.field527.length; ++var1) {
         for(int var2 = 0; var2 < this.field527[var1].length; ++var2) {
            List var3 = this.field527[var1][var2].method398();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field525.containsKey(Integer.valueOf(var5.field513))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field525.put(Integer.valueOf(var5.field513), var6);
               } else {
                  List var7 = (List)this.field525.get(Integer.valueOf(var5.field513));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIB)F",
      garbageValue = "50"
   )
   float method569(int var1, int var2) {
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Ljc;",
      garbageValue = "-1484943201"
   )
   public static Overlay method570(int var0) {
      Overlay var1 = (Overlay)Overlay.overlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.overlay_ref.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         Overlay.overlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("gp")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1982211730"
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
         int var8 = class61.tileHeights[var5][var3 + 1][var4] * var6 + (128 - var6) * class61.tileHeights[var5][var3][var4] >> 7;
         int var9 = class61.tileHeights[var5][var3][var4 + 1] * (128 - var6) + class61.tileHeights[var5][var3 + 1][var4 + 1] * var6 >> 7;
         return var9 * var7 + var8 * (128 - var7) >> 7;
      } else {
         return 0;
      }
   }
}
