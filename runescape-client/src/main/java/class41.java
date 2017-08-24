import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
public final class class41 {
   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   static SpritePixels[] field572;
   @ObfuscatedName("j")
   boolean field567;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   SpritePixels field568;
   @ObfuscatedName("i")
   boolean field562;
   @ObfuscatedName("o")
   HashMap field565;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[[Lat;"
   )
   class34[][] field576;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 683823945
   )
   int field570;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1250048671
   )
   int field571;
   @ObfuscatedName("q")
   HashMap field564;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   IndexedSprite[] field566;
   @ObfuscatedName("k")
   final HashMap field569;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lan;"
   )
   class44 field563;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 208769869
   )
   int field561;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 607205075
   )
   int field573;

   @ObfuscatedSignature(
      signature = "([Ljx;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field562 = false;
      this.field567 = false;
      this.field564 = new HashMap();
      this.field566 = var1;
      this.field569 = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "77"
   )
   void method587() {
      if(this.field565 == null) {
         this.field565 = new HashMap();
      }

      this.field565.clear();

      for(int var1 = 0; var1 < this.field576.length; ++var1) {
         for(int var2 = 0; var2 < this.field576[var1].length; ++var2) {
            List var3 = this.field576[var1][var2].method422();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field565.containsKey(Integer.valueOf(var5.field543))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field565.put(Integer.valueOf(var5.field543), var6);
               } else {
                  List var7 = (List)this.field565.get(Integer.valueOf(var5.field543));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIB)Lag;",
      garbageValue = "-73"
   )
   class29 method584(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field570 + var1;
      int var7 = var2 + this.field571;
      int var8 = var3 + this.field570;
      int var9 = var4 + this.field571;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field431 = var12 - var10 + 1;
      var5.field427 = var13 - var11 + 1;
      var5.field430 = var10 - this.field563.method360();
      var5.field429 = var11 - this.field563.method373();
      if(var5.field430 < 0) {
         var5.field431 += var5.field430;
         var5.field430 = 0;
      }

      if(var5.field430 > this.field576.length - var5.field431) {
         var5.field431 = this.field576.length - var5.field430;
      }

      if(var5.field429 < 0) {
         var5.field427 += var5.field429;
         var5.field429 = 0;
      }

      if(var5.field429 > this.field576[0].length - var5.field427) {
         var5.field427 = this.field576[0].length - var5.field429;
      }

      var5.field431 = Math.min(var5.field431, this.field576.length);
      var5.field427 = Math.min(var5.field427, this.field576[0].length);
      return var5;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "36254351"
   )
   float method588(int var1, int var2) {
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
      signature = "(I)Z",
      garbageValue = "-1320841415"
   )
   public boolean method604() {
      return this.field562;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "-630806878"
   )
   public HashMap method586() {
      this.method587();
      return this.field565;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "-1009754648"
   )
   public void method582(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field568 != null) {
         this.field568.method5021(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field565 == null) {
               this.method587();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field565.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field552.worldX - this.field570) / this.field561;
                  int var14 = var4 - (var12.field552.worldY - this.field571) * var4 / this.field573;
                  Rasterizer2D.method4888(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lii;Ljava/lang/String;ZI)V",
      garbageValue = "-834409457"
   )
   public void method578(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field567) {
         this.field562 = false;
         this.field567 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field560.field556);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.method4154(class40.field560.field556, var2));
         Buffer var7 = new Buffer(var1.method4154(class40.field559.field556, var2));
         Buffer var8 = new Buffer(var1.method4154(var2, class40.field558.field556));
         System.nanoTime();
         System.nanoTime();
         this.field563 = new class44();

         try {
            this.field563.method656(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field563.method374();
         this.field563.method324();
         this.field563.method325();
         this.field570 = this.field563.method360() * 64;
         this.field571 = this.field563.method373() * 64;
         this.field561 = (this.field563.method320() - this.field563.method360() + 1) * 64;
         this.field573 = (this.field563.method322() - this.field563.method373() + 1) * 64;
         int var9 = this.field563.method320() - this.field563.method360() + 1;
         int var10 = this.field563.method322() - this.field563.method373() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field576 = new class34[var9][var10];
         Iterator var11 = this.field563.field589.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field415;
            int var14 = var12.field416;
            int var15 = var13 - this.field563.method360();
            int var16 = var14 - this.field563.method373();
            this.field576[var15][var16] = new class34(var13, var14, this.field563.method362(), this.field569);
            this.field576[var15][var16].method386(var12, this.field563.field590);
         }

         for(int var17 = 0; var17 < var9; ++var17) {
            for(int var18 = 0; var18 < var10; ++var18) {
               if(this.field576[var17][var18] == null) {
                  this.field576[var17][var18] = new class34(this.field563.method360() + var17, this.field563.method373() + var18, this.field563.method362(), this.field569);
                  this.field576[var17][var18].method412(this.field563.field594, this.field563.field590);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4198(class40.field557.field556, var2)) {
            byte[] var21 = var1.method4154(class40.field557.field556, var2);
            this.field568 = class22.method186(var21);
         }

         System.nanoTime();
         this.field562 = true;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "-1911874997"
   )
   public List method583(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field562) {
         return var11;
      } else {
         class29 var12 = this.method584(var1, var2, var3, var4);
         float var13 = this.method588(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field570 + var1;
         int var16 = var2 + this.field571;

         for(int var17 = var12.field430; var17 < var12.field430 + var12.field431; ++var17) {
            for(int var18 = var12.field429; var18 < var12.field429 + var12.field427; ++var18) {
               List var19 = this.field576[var17][var18].method421(var5 + (this.field576[var17][var18].field485 * 64 - var15) * var14 / 64, var8 + var6 - var14 * (this.field576[var17][var18].field500 * 64 - var16 + 64) / 64, var14, var9, var10);
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
      signature = "(B)V",
      garbageValue = "1"
   )
   public final void method579() {
      this.field565 = null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II[Lat;I)V",
      garbageValue = "855732071"
   )
   void method581(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field576.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field576[0].length - 1;
      if(var7) {
         var3[class229.field3158.rsOrdinal()] = null;
      } else {
         var3[class229.field3158.rsOrdinal()] = this.field576[var1][var2 + 1];
      }

      var3[class229.field3154.rsOrdinal()] = !var7 && !var5?this.field576[var1 + 1][var2 + 1]:null;
      var3[class229.field3160.rsOrdinal()] = !var7 && !var4?this.field576[var1 - 1][var2 + 1]:null;
      var3[class229.field3162.rsOrdinal()] = var5?null:this.field576[var1 + 1][var2];
      var3[class229.field3159.rsOrdinal()] = var4?null:this.field576[var1 - 1][var2];
      var3[class229.field3153.rsOrdinal()] = var6?null:this.field576[var1][var2 - 1];
      var3[class229.field3156.rsOrdinal()] = !var6 && !var5?this.field576[var1 + 1][var2 - 1]:null;
      var3[class229.field3155.rsOrdinal()] = !var6 && !var4?this.field576[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "258504185"
   )
   public final void method606(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method584(var1, var2, var3, var4);
      float var14 = this.method588(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field564.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method707();
         this.field564.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field430; var17 < var13.field431 + var13.field430; ++var17) {
         for(var18 = var13.field429; var18 < var13.field427 + var13.field429; ++var18) {
            this.method581(var17, var18, var22);
            this.field576[var17][var18].method454(var15, (class46)this.field564.get(Integer.valueOf(var15)), var22, this.field566);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field570 + var1;
      int var19 = var2 + this.field571;

      for(int var20 = var13.field430; var20 < var13.field430 + var13.field431; ++var20) {
         for(int var21 = var13.field429; var21 < var13.field429 + var13.field427; ++var21) {
            this.field576[var20][var21].method415(var17 * (this.field576[var20][var21].field485 * 64 - var18) / 64 + var5, var8 - var17 * (this.field576[var20][var21].field500 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "412099368"
   )
   public final void method580(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method584(var1, var2, var3, var4);
      float var15 = this.method588(var7 - var5, var3 - var1);
      int var16 = (int)(64.0F * var15);
      int var17 = this.field570 + var1;
      int var18 = var2 + this.field571;

      int var19;
      int var20;
      for(var19 = var14.field430; var19 < var14.field430 + var14.field431; ++var19) {
         for(var20 = var14.field429; var20 < var14.field429 + var14.field427; ++var20) {
            if(var13) {
               this.field576[var19][var20].method414();
            }

            this.field576[var19][var20].method391(var16 * (this.field576[var19][var20].field485 * 64 - var17) / 64 + var5, var8 - var16 * (this.field576[var19][var20].field500 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field430; var19 < var14.field430 + var14.field431; ++var19) {
            for(var20 = var14.field429; var20 < var14.field427 + var14.field429; ++var20) {
               this.field576[var19][var20].method439(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "148965197"
   )
   static int method595() {
      return Client.isResized?2:1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)[Ljx;",
      garbageValue = "-2099254780"
   )
   static IndexedSprite[] method592() {
      IndexedSprite[] var0 = new IndexedSprite[class171.field2347];

      for(int var1 = 0; var1 < class171.field2347; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.width = class287.field3797;
         var2.originalHeight = class287.field3798;
         var2.offsetX = class271.field3679[var1];
         var2.offsetY = class18.offsetsY[var1];
         var2.originalWidth = class287.field3796[var1];
         var2.height = class245.field3324[var1];
         var2.palette = Varbit.field3387;
         var2.pixels = class274.spritePixels[var1];
      }

      Buffer.method3330();
      return var0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "265774750"
   )
   static void method615() {
      class97.chatLineMap.clear();
      class97.field1532.clear();
      class97.field1536.method3744();
      class97.field1534 = 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIII[Lfh;B)V",
      garbageValue = "14"
   )
   static final void method616(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var7 + var1][var2 + var8] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class9.loadTerrain(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "113"
   )
   public static boolean method617(char var0) {
      return var0 >= 32 && var0 <= 126?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }
}
