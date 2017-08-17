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

@ObfuscatedName("am")
public final class class41 {
   @ObfuscatedName("ae")
   static Image field563;
   @ObfuscatedName("h")
   boolean field561;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   SpritePixels field573;
   @ObfuscatedName("j")
   boolean field572;
   @ObfuscatedName("x")
   HashMap field564;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "[[Lae;"
   )
   class34[][] field565;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 903350019
   )
   int field569;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -307951753
   )
   int field570;
   @ObfuscatedName("c")
   HashMap field566;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "[Ljr;"
   )
   IndexedSprite[] field567;
   @ObfuscatedName("w")
   final HashMap field568;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   class44 field562;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1149406237
   )
   int field560;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -38679845
   )
   int field571;

   @ObfuscatedSignature(
      signature = "([Ljr;Ljava/util/HashMap;)V"
   )
   public class41(IndexedSprite[] var1, HashMap var2) {
      this.field572 = false;
      this.field561 = false;
      this.field566 = new HashMap();
      this.field567 = var1;
      this.field568 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-29"
   )
   void method598() {
      if(this.field564 == null) {
         this.field564 = new HashMap();
      }

      this.field564.clear();

      for(int var1 = 0; var1 < this.field565.length; ++var1) {
         for(int var2 = 0; var2 < this.field565[var1].length; ++var2) {
            List var3 = this.field565[var1][var2].method414();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field564.containsKey(Integer.valueOf(var5.field544))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field564.put(Integer.valueOf(var5.field544), var6);
               } else {
                  List var7 = (List)this.field564.get(Integer.valueOf(var5.field544));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIB)Lar;",
      garbageValue = "1"
   )
   class29 method576(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field569 + var1;
      int var7 = var2 + this.field570;
      int var8 = var3 + this.field569;
      int var9 = var4 + this.field570;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field427 = var12 - var10 + 1;
      var5.field433 = var13 - var11 + 1;
      var5.field428 = var10 - this.field562.method310();
      var5.field432 = var11 - this.field562.method327();
      if(var5.field428 < 0) {
         var5.field427 += var5.field428;
         var5.field428 = 0;
      }

      if(var5.field428 > this.field565.length - var5.field427) {
         var5.field427 = this.field565.length - var5.field428;
      }

      if(var5.field432 < 0) {
         var5.field433 += var5.field432;
         var5.field432 = 0;
      }

      if(var5.field432 > this.field565[0].length - var5.field433) {
         var5.field433 = this.field565[0].length - var5.field432;
      }

      var5.field427 = Math.min(var5.field427, this.field565.length);
      var5.field433 = Math.min(var5.field433, this.field565[0].length);
      return var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "789302768"
   )
   float method595(int var1, int var2) {
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
      signature = "(B)Z",
      garbageValue = "0"
   )
   public boolean method577() {
      return this.field572;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/HashMap;",
      garbageValue = "-1224750918"
   )
   public HashMap method578() {
      this.method598();
      return this.field564;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;IIB)V",
      garbageValue = "-3"
   )
   public void method574(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field573 != null) {
         this.field573.method5119(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field564 == null) {
               this.method598();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field564.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field542.worldX - this.field569) / this.field560;
                  int var14 = var4 - (var12.field542.worldY - this.field570) * var4 / this.field571;
                  Rasterizer2D.method4966(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;Ljava/lang/String;ZI)V",
      garbageValue = "576584358"
   )
   public void method579(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field561) {
         this.field572 = false;
         this.field561 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field559.field551);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.method4206(class40.field559.field551, var2));
         Buffer var7 = new Buffer(var1.method4206(class40.field550.field551, var2));
         Buffer var8 = new Buffer(var1.method4206(var2, class40.field552.field551));
         System.nanoTime();
         System.nanoTime();
         this.field562 = new class44();

         try {
            this.field562.method659(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field562.method325();
         this.field562.method315();
         this.field562.method316();
         this.field569 = this.field562.method310() * 64;
         this.field570 = this.field562.method327() * 64;
         this.field560 = (this.field562.method354() - this.field562.method310() + 1) * 64;
         this.field571 = (this.field562.method356() - this.field562.method327() + 1) * 64;
         int var9 = this.field562.method354() - this.field562.method310() + 1;
         int var10 = this.field562.method356() - this.field562.method327() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field565 = new class34[var9][var10];
         Iterator var11 = this.field562.field588.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field416;
            int var14 = var12.field411;
            int var15 = var13 - this.field562.method310();
            int var16 = var14 - this.field562.method327();
            this.field565[var15][var16] = new class34(var13, var14, this.field562.method308(), this.field568);
            this.field565[var15][var16].method378(var12, this.field562.field585);
         }

         for(int var17 = 0; var17 < var9; ++var17) {
            for(int var18 = 0; var18 < var10; ++var18) {
               if(this.field565[var17][var18] == null) {
                  this.field565[var17][var18] = new class34(this.field562.method310() + var17, this.field562.method327() + var18, this.field562.method308(), this.field568);
                  this.field565[var17][var18].method379(this.field562.field587, this.field562.field585);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4191(class40.field554.field551, var2)) {
            byte[] var21 = var1.method4206(class40.field554.field551, var2);
            this.field573 = Varcs.method1851(var21);
         }

         System.nanoTime();
         this.field572 = true;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIIB)Ljava/util/List;",
      garbageValue = "39"
   )
   public List method575(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field572) {
         return var11;
      } else {
         class29 var12 = this.method576(var1, var2, var3, var4);
         float var13 = this.method595(var7, var3 - var1);
         int var14 = (int)(64.0F * var13);
         int var15 = this.field569 + var1;
         int var16 = var2 + this.field570;

         for(int var17 = var12.field428; var17 < var12.field427 + var12.field428; ++var17) {
            for(int var18 = var12.field432; var18 < var12.field433 + var12.field432; ++var18) {
               List var19 = this.field565[var17][var18].method413(var5 + var14 * (this.field565[var17][var18].field500 * 64 - var15) / 64, var8 + var6 - var14 * (64 + (this.field565[var17][var18].field486 * 64 - var16)) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1136557476"
   )
   public final void method603() {
      this.field564 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[Lae;I)V",
      garbageValue = "285441653"
   )
   void method573(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field565.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field565[0].length - 1;
      if(var7) {
         var3[class229.field3150.rsOrdinal()] = null;
      } else {
         var3[class229.field3150.rsOrdinal()] = this.field565[var1][var2 + 1];
      }

      var3[class229.field3143.rsOrdinal()] = !var7 && !var5?this.field565[var1 + 1][var2 + 1]:null;
      var3[class229.field3148.rsOrdinal()] = !var7 && !var4?this.field565[var1 - 1][var2 + 1]:null;
      var3[class229.field3144.rsOrdinal()] = var5?null:this.field565[var1 + 1][var2];
      var3[class229.field3153.rsOrdinal()] = var4?null:this.field565[var1 - 1][var2];
      var3[class229.field3146.rsOrdinal()] = var6?null:this.field565[var1][var2 - 1];
      var3[class229.field3145.rsOrdinal()] = !var6 && !var5?this.field565[var1 + 1][var2 - 1]:null;
      var3[class229.field3147.rsOrdinal()] = !var6 && !var4?this.field565[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "796695930"
   )
   public final void method591(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method576(var1, var2, var3, var4);
      float var14 = this.method595(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field566.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method706();
         this.field566.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field428; var17 < var13.field427 + var13.field428; ++var17) {
         for(var18 = var13.field432; var18 < var13.field433 + var13.field432; ++var18) {
            this.method573(var17, var18, var22);
            this.field565[var17][var18].method382(var15, (class46)this.field566.get(Integer.valueOf(var15)), var22, this.field567);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field569 + var1;
      int var19 = var2 + this.field570;

      for(int var20 = var13.field428; var20 < var13.field427 + var13.field428; ++var20) {
         for(int var21 = var13.field432; var21 < var13.field432 + var13.field433; ++var21) {
            this.field565[var20][var21].method377(var5 + var17 * (this.field565[var20][var21].field500 * 64 - var18) / 64, var8 - var17 * (64 + (this.field565[var20][var21].field486 * 64 - var19)) / 64, var17);
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "-1217714668"
   )
   public final void method572(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method576(var1, var2, var3, var4);
      float var15 = this.method595(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field569 + var1;
      int var18 = var2 + this.field570;

      int var19;
      int var20;
      for(var19 = var14.field428; var19 < var14.field427 + var14.field428; ++var19) {
         for(var20 = var14.field432; var20 < var14.field433 + var14.field432; ++var20) {
            if(var13) {
               this.field565[var19][var20].method406();
            }

            this.field565[var19][var20].method464(var5 + var16 * (this.field565[var19][var20].field500 * 64 - var17) / 64, var8 - (this.field565[var19][var20].field486 * 64 - var18 + 64) * var16 / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field428; var19 < var14.field428 + var14.field427; ++var19) {
            for(var20 = var14.field432; var20 < var14.field433 + var14.field432; ++var20) {
               this.field565[var19][var20].method384(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "-923719279"
   )
   public static final void method616(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= '뮀') {
         AbstractSoundSystem.sampleRate = var0;
         class135.highMemory = var1;
         AbstractSoundSystem.priority = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfb;IIIIIII)V",
      garbageValue = "376363781"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -GZipDecompressor.method3106(var2 + var4 + 932731, var3 + var5 + 556238) * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class61.overlayIds[var1][var2][var3] = var0.readByte();
               class61.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class61.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class61.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }
}
