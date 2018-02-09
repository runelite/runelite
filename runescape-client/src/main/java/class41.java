import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public final class class41 {
   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      signature = "Lbz;"
   )
   @Export("mouseRecorder")
   static MouseRecorder mouseRecorder;
   @ObfuscatedName("s")
   boolean field537;
   @ObfuscatedName("g")
   boolean field535;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lav;"
   )
   class44 field526;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lki;"
   )
   SpritePixels field527;
   @ObfuscatedName("i")
   HashMap field530;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "[[Lak;"
   )
   class34[][] field525;
   @ObfuscatedName("t")
   HashMap field532;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Lkh;"
   )
   IndexedSprite[] field528;
   @ObfuscatedName("z")
   final HashMap field524;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1684818637
   )
   int field533;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -669280859
   )
   int field534;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1710548015
   )
   int field529;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1750012221
   )
   int field536;

   @ObfuscatedSignature(
      signature = "([Lkh;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field537 = false;
      this.field535 = false;
      this.field532 = new HashMap();
      this.field528 = var1;
      this.field524 = var2;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lir;Ljava/lang/String;ZI)V",
      garbageValue = "219638012"
   )
   public void method531(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field535) {
         this.field537 = false;
         this.field535 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field521.field515);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.takeRecordByNames(class40.field521.field515, var2));
         Buffer var7 = new Buffer(var1.takeRecordByNames(class40.field516.field515, var2));
         Buffer var8 = new Buffer(var1.takeRecordByNames(var2, class40.field518.field515));
         System.nanoTime();
         System.nanoTime();
         this.field526 = new class44();

         try {
            this.field526.method603(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field526.method308();
         this.field526.method276();
         this.field526.method315();
         this.field533 = this.field526.method284() * 64;
         this.field534 = this.field526.method305() * 64;
         this.field529 = (this.field526.method320() - this.field526.method284() + 1) * 64;
         this.field536 = (this.field526.method287() - this.field526.method305() + 1) * 64;
         int var17 = this.field526.method320() - this.field526.method284() + 1;
         int var10 = this.field526.method287() - this.field526.method305() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field525 = new class34[var17][var10];
         Iterator var11 = this.field526.field554.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field398;
            int var14 = var12.field389;
            int var15 = var13 - this.field526.method284();
            int var16 = var14 - this.field526.method305();
            this.field525[var15][var16] = new class34(var13, var14, this.field526.method272(), this.field524);
            this.field525[var15][var16].method344(var12, this.field526.field553);
         }

         for(int var18 = 0; var18 < var17; ++var18) {
            for(int var19 = 0; var19 < var10; ++var19) {
               if(this.field525[var18][var19] == null) {
                  this.field525[var18][var19] = new class34(this.field526.method284() + var18, this.field526.method305() + var19, this.field526.method272(), this.field524);
                  this.field525[var18][var19].method345(this.field526.field551, this.field526.field553);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4502(class40.field517.field515, var2)) {
            byte[] var21 = var1.takeRecordByNames(class40.field517.field515, var2);
            this.field527 = SoundTask.method2330(var21);
         }

         System.nanoTime();
         this.field537 = true;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1502236691"
   )
   public final void method532() {
      this.field530 = null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "-104"
   )
   public final void method533(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method538(var1, var2, var3, var4);
      float var14 = this.method558(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field532.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method660();
         this.field532.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field402; var17 < var13.field401 + var13.field402; ++var17) {
         for(var18 = var13.field400; var18 < var13.field400 + var13.field404; ++var18) {
            this.method535(var17, var18, var22);
            this.field525[var17][var18].method418(var15, (class46)this.field532.get(Integer.valueOf(var15)), var22, this.field528);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field533 + var1;
      int var19 = var2 + this.field534;

      for(int var20 = var13.field402; var20 < var13.field402 + var13.field401; ++var20) {
         for(int var21 = var13.field400; var21 < var13.field404 + var13.field400; ++var21) {
            this.field525[var20][var21].method394(var5 + var17 * (this.field525[var20][var21].field462 * 64 - var18) / 64, var8 - var17 * (this.field525[var20][var21].field468 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "2006571912"
   )
   public final void method534(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method538(var1, var2, var3, var4);
      float var15 = this.method558(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field533 + var1;
      int var18 = var2 + this.field534;

      int var19;
      int var20;
      for(var19 = var14.field402; var19 < var14.field402 + var14.field401; ++var19) {
         for(var20 = var14.field400; var20 < var14.field404 + var14.field400; ++var20) {
            if(var13) {
               this.field525[var19][var20].method365();
            }

            this.field525[var19][var20].method343(var5 + var16 * (this.field525[var19][var20].field462 * 64 - var17) / 64, var8 - var16 * (this.field525[var19][var20].field468 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field402; var19 < var14.field402 + var14.field401; ++var19) {
            for(var20 = var14.field400; var20 < var14.field404 + var14.field400; ++var20) {
               this.field525[var19][var20].method437(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[Lak;I)V",
      garbageValue = "-1370709641"
   )
   void method535(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field525.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field525[0].length - 1;
      if(var7) {
         var3[class239.field3251.rsOrdinal()] = null;
      } else {
         var3[class239.field3251.rsOrdinal()] = this.field525[var1][var2 + 1];
      }

      var3[class239.field3245.rsOrdinal()] = !var7 && !var5?this.field525[var1 + 1][var2 + 1]:null;
      var3[class239.field3247.rsOrdinal()] = !var7 && !var4?this.field525[var1 - 1][var2 + 1]:null;
      var3[class239.field3246.rsOrdinal()] = var5?null:this.field525[var1 + 1][var2];
      var3[class239.field3250.rsOrdinal()] = var4?null:this.field525[var1 - 1][var2];
      var3[class239.field3255.rsOrdinal()] = var6?null:this.field525[var1][var2 - 1];
      var3[class239.field3249.rsOrdinal()] = !var6 && !var5?this.field525[var1 + 1][var2 - 1]:null;
      var3[class239.field3244.rsOrdinal()] = !var6 && !var4?this.field525[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "875599983"
   )
   public void method536(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field527 != null) {
         this.field527.method5731(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field530 == null) {
               this.method553();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field530.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field509.worldX - this.field533) / this.field529;
                  int var14 = var4 - (var12.field509.worldY - this.field534) * var4 / this.field536;
                  Rasterizer2D.method5562(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIIB)Ljava/util/List;",
      garbageValue = "111"
   )
   public List method537(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field537) {
         return var11;
      } else {
         class29 var12 = this.method538(var1, var2, var3, var4);
         float var13 = this.method558(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field533 + var1;
         int var16 = var2 + this.field534;

         for(int var17 = var12.field402; var17 < var12.field401 + var12.field402; ++var17) {
            for(int var18 = var12.field400; var18 < var12.field400 + var12.field404; ++var18) {
               List var19 = this.field525[var17][var18].method378(var5 + var14 * (this.field525[var17][var18].field462 * 64 - var15) / 64, var8 + var6 - var14 * (this.field525[var17][var18].field468 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIB)Lar;",
      garbageValue = "22"
   )
   class29 method538(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field533 + var1;
      int var7 = var2 + this.field534;
      int var8 = var3 + this.field533;
      int var9 = var4 + this.field534;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field401 = var12 - var10 + 1;
      var5.field404 = var13 - var11 + 1;
      var5.field402 = var10 - this.field526.method284();
      var5.field400 = var11 - this.field526.method305();
      if(var5.field402 < 0) {
         var5.field401 += var5.field402;
         var5.field402 = 0;
      }

      if(var5.field402 > this.field525.length - var5.field401) {
         var5.field401 = this.field525.length - var5.field402;
      }

      if(var5.field400 < 0) {
         var5.field404 += var5.field400;
         var5.field400 = 0;
      }

      if(var5.field400 > this.field525[0].length - var5.field404) {
         var5.field404 = this.field525[0].length - var5.field400;
      }

      var5.field401 = Math.min(var5.field401, this.field525.length);
      var5.field404 = Math.min(var5.field404, this.field525[0].length);
      return var5;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1749219122"
   )
   public boolean method539() {
      return this.field537;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "-2119222011"
   )
   public HashMap method540() {
      this.method553();
      return this.field530;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-775913001"
   )
   void method553() {
      if(this.field530 == null) {
         this.field530 = new HashMap();
      }

      this.field530.clear();

      for(int var1 = 0; var1 < this.field525.length; ++var1) {
         for(int var2 = 0; var2 < this.field525[var1].length; ++var2) {
            List var3 = this.field525[var1][var2].method379();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field530.containsKey(Integer.valueOf(var5.field514))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field530.put(Integer.valueOf(var5.field514), var6);
               } else {
                  List var7 = (List)this.field530.get(Integer.valueOf(var5.field514));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)F",
      garbageValue = "58"
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
}
