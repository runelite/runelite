import java.awt.Image;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public final class class41 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1534406829
   )
   int field547;
   @ObfuscatedName("c")
   boolean field548;
   @ObfuscatedName("e")
   class44 field549;
   @ObfuscatedName("v")
   SpritePixels field550;
   @ObfuscatedName("b")
   HashMap field551;
   @ObfuscatedName("y")
   class34[][] field552;
   @ObfuscatedName("h")
   HashMap field553;
   @ObfuscatedName("x")
   ModIcon[] field554;
   @ObfuscatedName("f")
   final HashMap field555;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2104222333
   )
   int field556;
   @ObfuscatedName("al")
   static Image field558;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1960565361
   )
   int field559;
   @ObfuscatedName("i")
   boolean field560;
   @ObfuscatedName("ev")
   @ObfuscatedGetter(
      intValue = -427729959
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1969690787
   )
   int field563;
   @ObfuscatedName("om")
   static SpritePixels field564;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[Lclass34;B)V",
      garbageValue = "15"
   )
   void method536(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field552.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field552[0].length - 1;
      if(var7) {
         var3[class228.field3155.vmethod5009()] = null;
      } else {
         var3[class228.field3155.vmethod5009()] = this.field552[var1][var2 + 1];
      }

      var3[class228.field3147.vmethod5009()] = !var7 && !var5?this.field552[var1 + 1][var2 + 1]:null;
      var3[class228.field3146.vmethod5009()] = !var7 && !var4?this.field552[var1 - 1][var2 + 1]:null;
      var3[class228.field3153.vmethod5009()] = var5?null:this.field552[var1 + 1][var2];
      var3[class228.field3148.vmethod5009()] = var4?null:this.field552[var1 - 1][var2];
      var3[class228.field3150.vmethod5009()] = var6?null:this.field552[var1][var2 - 1];
      var3[class228.field3149.vmethod5009()] = !var6 && !var5?this.field552[var1 + 1][var2 - 1]:null;
      var3[class228.field3151.vmethod5009()] = !var6 && !var4?this.field552[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;ZI)V",
      garbageValue = "-416758320"
   )
   public void method537(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field548) {
         this.field560 = false;
         this.field548 = true;
         System.nanoTime();
         int var4 = var1.method4125(class40.field540.field542);
         int var5 = var1.method4126(var4, var2);
         Buffer var6 = new Buffer(var1.method4170(class40.field540.field542, var2));
         Buffer var7 = new Buffer(var1.method4170(class40.field545.field542, var2));
         Buffer var8 = new Buffer(var1.method4170(var2, class40.field544.field542));
         System.nanoTime();
         System.nanoTime();
         this.field549 = new class44();

         try {
            this.field549.method605(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field549.method282();
         this.field549.method278();
         this.field549.method284();
         this.field556 = this.field549.method303() * 64;
         this.field563 = this.field549.method280() * 64;
         this.field547 = (this.field549.method279() - this.field549.method303() + 1) * 64;
         this.field559 = (this.field549.method281() - this.field549.method280() + 1) * 64;
         int var17 = this.field549.method279() - this.field549.method303() + 1;
         int var10 = this.field549.method281() - this.field549.method280() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field552 = new class34[var17][var10];
         Iterator var11 = this.field549.field581.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field409;
            int var14 = var12.field417;
            int var15 = var13 - this.field549.method303();
            int var16 = var14 - this.field549.method280();
            this.field552[var15][var16] = new class34(var13, var14, this.field549.method297(), this.field555);
            this.field552[var15][var16].method343(var12, this.field549.field579);
         }

         for(int var18 = 0; var18 < var17; ++var18) {
            for(int var19 = 0; var19 < var10; ++var19) {
               if(this.field552[var18][var19] == null) {
                  this.field552[var18][var19] = new class34(this.field549.method303() + var18, this.field549.method280() + var19, this.field549.method297(), this.field555);
                  this.field552[var18][var19].method344(this.field549.field583, this.field549.field579);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4176(class40.field539.field542, var2)) {
            byte[] var21 = var1.method4170(class40.field539.field542, var2);
            this.field550 = class34.method441(var21);
         }

         System.nanoTime();
         this.field560 = true;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1565138561"
   )
   public final void method539(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.method4957(var12);
      class29 var13 = this.method570(var1, var2, var3, var4);
      float var14 = this.method546(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field553.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method686();
         this.field553.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field423; var17 < var13.field423 + var13.field428; ++var17) {
         for(var18 = var13.field426; var18 < var13.field424 + var13.field426; ++var18) {
            this.method536(var17, var18, var22);
            this.field552[var17][var18].method356(var15, (class46)this.field553.get(Integer.valueOf(var15)), var22, this.field554);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.method4928(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field556 + var1;
      int var19 = var2 + this.field563;

      for(int var20 = var13.field423; var20 < var13.field423 + var13.field428; ++var20) {
         for(int var21 = var13.field426; var21 < var13.field424 + var13.field426; ++var21) {
            this.field552[var20][var21].method428((this.field552[var20][var21].field479 * 64 - var18) * var17 / 64 + var5, var8 - (this.field552[var20][var21].field481 * 64 - var19 + 64) * var17 / 64, var17);
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;IIB)V",
      garbageValue = "-45"
   )
   public void method542(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field550 != null) {
         this.field550.method5048(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field551 == null) {
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
                  var10 = (List)this.field551.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = (var12.field525.worldX - this.field556) * var3 / this.field547;
                  int var14 = var4 - (var12.field525.worldY - this.field563) * var4 / this.field559;
                  Rasterizer2D.method4921(var13 + var1, var2 + var14, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "147832710"
   )
   public List method543(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field560) {
         return var11;
      } else {
         class29 var12 = this.method570(var1, var2, var3, var4);
         float var13 = this.method546(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field556 + var1;
         int var16 = this.field563 + var2;

         for(int var17 = var12.field423; var17 < var12.field428 + var12.field423; ++var17) {
            for(int var18 = var12.field426; var18 < var12.field426 + var12.field424; ++var18) {
               List var19 = this.field552[var17][var18].method377(var5 + (this.field552[var17][var18].field479 * 64 - var15) * var14 / 64, var6 + var8 - var14 * (this.field552[var17][var18].field481 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1339460591"
   )
   public final void method544() {
      this.field551 = null;
   }

   public class41(ModIcon[] var1, HashMap var2) {
      this.field560 = false;
      this.field548 = false;
      this.field553 = new HashMap();
      this.field554 = var1;
      this.field555 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIB)F",
      garbageValue = "127"
   )
   float method546(int var1, int var2) {
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)Ljava/util/HashMap;",
      garbageValue = "11079"
   )
   public HashMap method547() {
      this.method561();
      return this.field551;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1956563961"
   )
   public boolean method548() {
      return this.field560;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "2045162684"
   )
   public final void method554(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method570(var1, var2, var3, var4);
      float var15 = this.method546(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field556 + var1;
      int var18 = this.field563 + var2;

      int var19;
      int var20;
      for(var19 = var14.field423; var19 < var14.field428 + var14.field423; ++var19) {
         for(var20 = var14.field426; var20 < var14.field426 + var14.field424; ++var20) {
            if(var13) {
               this.field552[var19][var20].method370();
            }

            this.field552[var19][var20].method348(var16 * (this.field552[var19][var20].field479 * 64 - var17) / 64 + var5, var8 - var16 * (this.field552[var19][var20].field481 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field423; var19 < var14.field423 + var14.field428; ++var19) {
            for(var20 = var14.field426; var20 < var14.field424 + var14.field426; ++var20) {
               this.field552[var19][var20].method349(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-111"
   )
   void method561() {
      if(this.field551 == null) {
         this.field551 = new HashMap();
      }

      this.field551.clear();

      for(int var1 = 0; var1 < this.field552.length; ++var1) {
         for(int var2 = 0; var2 < this.field552[var1].length; ++var2) {
            List var3 = this.field552[var1][var2].method378();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field551.containsKey(Integer.valueOf(var5.field536))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field551.put(Integer.valueOf(var5.field536), var6);
               } else {
                  List var7 = (List)this.field551.get(Integer.valueOf(var5.field536));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIB)Lclass29;",
      garbageValue = "86"
   )
   class29 method570(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = var1 + this.field556;
      int var7 = var2 + this.field563;
      int var8 = this.field556 + var3;
      int var9 = var4 + this.field563;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field428 = var12 - var10 + 1;
      var5.field424 = var13 - var11 + 1;
      var5.field423 = var10 - this.field549.method303();
      var5.field426 = var11 - this.field549.method280();
      if(var5.field423 < 0) {
         var5.field428 += var5.field423;
         var5.field423 = 0;
      }

      if(var5.field423 > this.field552.length - var5.field428) {
         var5.field428 = this.field552.length - var5.field423;
      }

      if(var5.field426 < 0) {
         var5.field424 += var5.field426;
         var5.field426 = 0;
      }

      if(var5.field426 > this.field552[0].length - var5.field424) {
         var5.field424 = this.field552[0].length - var5.field426;
      }

      var5.field428 = Math.min(var5.field428, this.field552.length);
      var5.field424 = Math.min(var5.field424, this.field552[0].length);
      return var5;
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "(IIII)LWidgetNode;",
      garbageValue = "394056390"
   )
   static final WidgetNode method572(int var0, int var1, int var2) {
      WidgetNode var3 = new WidgetNode();
      var3.id = var1;
      var3.field840 = var2;
      Client.componentTable.method3516(var3, (long)var0);
      IndexDataBase.method4203(var1);
      Widget var4 = WorldMapType3.method199(var0);
      class25.method169(var4);
      if(Client.field963 != null) {
         class25.method169(Client.field963);
         Client.field963 = null;
      }

      MessageNode.method1108();
      class236.method4216(CombatInfo1.widgets[var0 >> 16], var4, false);
      class91.method1711(var1);
      if(Client.widgetRoot != -1) {
         class158.method2978(Client.widgetRoot, 1);
      }

      return var3;
   }
}
