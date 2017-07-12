import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public final class class41 {
   @ObfuscatedName("w")
   boolean field574;
   @ObfuscatedName("a")
   class44 field575;
   @ObfuscatedName("t")
   SpritePixels field576;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 666743715
   )
   int field577;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1307582177
   )
   int field578;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -644687293
   )
   int field579;
   @ObfuscatedName("y")
   ModIcon[] field580;
   @ObfuscatedName("j")
   final HashMap field581;
   @ObfuscatedName("s")
   HashMap field582;
   @ObfuscatedName("i")
   boolean field583;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1749407005
   )
   int field584;
   @ObfuscatedName("v")
   HashMap field585;
   @ObfuscatedName("u")
   static int[] field586;
   @ObfuscatedName("r")
   class34[][] field587;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;Ljava/lang/String;ZI)V",
      garbageValue = "-1266646515"
   )
   public void method566(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field574) {
         this.field583 = false;
         this.field574 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field564.field566);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.method4145(class40.field564.field566, var2));
         Buffer var7 = new Buffer(var1.method4145(class40.field562.field566, var2));
         Buffer var8 = new Buffer(var1.method4145(var2, class40.field561.field566));
         System.nanoTime();
         System.nanoTime();
         this.field575 = new class44();

         try {
            this.field575.method645(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var17) {
            return;
         }

         this.field575.method336();
         this.field575.method333();
         this.field575.method292();
         this.field578 = this.field575.method305() * 64;
         this.field579 = this.field575.method288() * 64;
         this.field584 = (this.field575.method287() - this.field575.method305() + 1) * 64;
         this.field577 = (this.field575.method289() - this.field575.method288() + 1) * 64;
         int var9 = this.field575.method287() - this.field575.method305() + 1;
         int var10 = this.field575.method289() - this.field575.method288() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field587 = new class34[var9][var10];
         Iterator var11 = this.field575.field607.iterator();

         int var13;
         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            var13 = var12.field420;
            int var14 = var12.field409;
            int var15 = var13 - this.field575.method305();
            int var16 = var14 - this.field575.method288();
            this.field587[var15][var16] = new class34(var13, var14, this.field575.method294(), this.field581);
            this.field587[var15][var16].method503(var12, this.field575.field606);
         }

         for(int var18 = 0; var18 < var9; ++var18) {
            for(var13 = 0; var13 < var10; ++var13) {
               if(this.field587[var18][var13] == null) {
                  this.field587[var18][var13] = new class34(this.field575.method305() + var18, this.field575.method288() + var13, this.field575.method294(), this.field581);
                  this.field587[var18][var13].method352(this.field575.field608, this.field575.field606);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4190(class40.field567.field566, var2)) {
            byte[] var19 = var1.method4145(class40.field567.field566, var2);
            this.field576 = Coordinates.method3928(var19);
         }

         System.nanoTime();
         this.field583 = true;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "414029223"
   )
   public final void method567() {
      this.field582 = null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIB)V",
      garbageValue = "41"
   )
   public final void method568(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method573(var1, var2, var3, var4);
      float var14 = this.method594(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field585.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method710();
         this.field585.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field430; var17 < var13.field432 + var13.field430; ++var17) {
         for(var18 = var13.field431; var18 < var13.field429 + var13.field431; ++var18) {
            this.method605(var17, var18, var22);
            this.field587[var17][var18].method357(var15, (class46)this.field585.get(Integer.valueOf(var15)), var22, this.field580);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(var14 * 64.0F);
      var18 = this.field578 + var1;
      int var19 = var2 + this.field579;

      for(int var20 = var13.field430; var20 < var13.field432 + var13.field430; ++var20) {
         for(int var21 = var13.field431; var21 < var13.field429 + var13.field431; ++var21) {
            this.field587[var20][var21].method381((this.field587[var20][var21].field485 * 64 - var18) * var17 / 64 + var5, var8 - var17 * (this.field587[var20][var21].field486 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "1022453157"
   )
   public void method571(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field576 != null) {
         this.field576.method5080(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field582 == null) {
               this.method576();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var9;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var10 = ((Integer)var8.next()).intValue();
                  var9 = (List)this.field582.get(Integer.valueOf(var10));
               } while(var9 == null);

               Iterator var14 = var9.iterator();

               while(var14.hasNext()) {
                  class39 var11 = (class39)var14.next();
                  int var12 = var3 * (var11.field550.worldX - this.field578) / this.field584;
                  int var13 = var4 - (var11.field550.worldY - this.field579) * var4 / this.field577;
                  Rasterizer2D.method4930(var12 + var1, var2 + var13, 2, 16776960, 256);
               }
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "-160311589"
   )
   public List method572(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field583) {
         return var11;
      } else {
         class29 var12 = this.method573(var1, var2, var3, var4);
         float var13 = this.method594(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field578 + var1;
         int var16 = var2 + this.field579;

         for(int var17 = var12.field430; var17 < var12.field430 + var12.field432; ++var17) {
            for(int var18 = var12.field431; var18 < var12.field429 + var12.field431; ++var18) {
               List var19 = this.field587[var17][var18].method386(var5 + var14 * (this.field587[var17][var18].field485 * 64 - var15) / 64, var8 + var6 - (this.field587[var17][var18].field486 * 64 - var16 + 64) * var14 / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIII)Lclass29;",
      garbageValue = "1514441179"
   )
   class29 method573(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field578 + var1;
      int var7 = var2 + this.field579;
      int var8 = var3 + this.field578;
      int var9 = this.field579 + var4;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field432 = var12 - var10 + 1;
      var5.field429 = var13 - var11 + 1;
      var5.field430 = var10 - this.field575.method305();
      var5.field431 = var11 - this.field575.method288();
      if(var5.field430 < 0) {
         var5.field432 += var5.field430;
         var5.field430 = 0;
      }

      if(var5.field430 > this.field587.length - var5.field432) {
         var5.field432 = this.field587.length - var5.field430;
      }

      if(var5.field431 < 0) {
         var5.field429 += var5.field431;
         var5.field431 = 0;
      }

      if(var5.field431 > this.field587[0].length - var5.field429) {
         var5.field429 = this.field587[0].length - var5.field431;
      }

      var5.field432 = Math.min(var5.field432, this.field587.length);
      var5.field429 = Math.min(var5.field429, this.field587[0].length);
      return var5;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-31921398"
   )
   void method576() {
      if(this.field582 == null) {
         this.field582 = new HashMap();
      }

      this.field582.clear();

      for(int var1 = 0; var1 < this.field587.length; ++var1) {
         for(int var2 = 0; var2 < this.field587[var1].length; ++var2) {
            List var3 = this.field587[var1][var2].method387();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field582.containsKey(Integer.valueOf(var5.field548))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field582.put(Integer.valueOf(var5.field548), var6);
               } else {
                  List var7 = (List)this.field582.get(Integer.valueOf(var5.field548));
                  var7.add(var5);
               }
            }
         }
      }

   }

   public class41(ModIcon[] var1, HashMap var2) {
      this.field583 = false;
      this.field574 = false;
      this.field585 = new HashMap();
      this.field580 = var1;
      this.field581 = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "-1527028819"
   )
   public static int method590(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "-1228584521"
   )
   float method594(int var1, int var2) {
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "-1527026220"
   )
   public final void method600(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method573(var1, var2, var3, var4);
      float var15 = this.method594(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field578 + var1;
      int var18 = var2 + this.field579;

      int var19;
      int var20;
      for(var19 = var14.field430; var19 < var14.field430 + var14.field432; ++var19) {
         for(var20 = var14.field431; var20 < var14.field431 + var14.field429; ++var20) {
            if(var13) {
               this.field587[var19][var20].method379();
            }

            this.field587[var19][var20].method362(var5 + (this.field587[var19][var20].field485 * 64 - var17) * var16 / 64, var8 - var16 * (64 + (this.field587[var19][var20].field486 * 64 - var18)) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field430; var19 < var14.field432 + var14.field430; ++var19) {
            for(var20 = var14.field431; var20 < var14.field429 + var14.field431; ++var20) {
               this.field587[var19][var20].method463(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/HashMap;",
      garbageValue = "9"
   )
   public HashMap method601() {
      this.method576();
      return this.field582;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II[Lclass34;I)V",
      garbageValue = "-585163079"
   )
   void method605(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field587.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field587[0].length - 1;
      if(var7) {
         var3[class228.field3165.rsOrdinal()] = null;
      } else {
         var3[class228.field3165.rsOrdinal()] = this.field587[var1][var2 + 1];
      }

      var3[class228.field3157.rsOrdinal()] = !var7 && !var5?this.field587[var1 + 1][var2 + 1]:null;
      var3[class228.field3163.rsOrdinal()] = !var7 && !var4?this.field587[var1 - 1][var2 + 1]:null;
      var3[class228.field3158.rsOrdinal()] = var5?null:this.field587[var1 + 1][var2];
      var3[class228.field3164.rsOrdinal()] = var4?null:this.field587[var1 - 1][var2];
      var3[class228.field3160.rsOrdinal()] = var6?null:this.field587[var1][var2 - 1];
      var3[class228.field3162.rsOrdinal()] = !var6 && !var5?this.field587[var1 + 1][var2 - 1]:null;
      var3[class228.field3161.rsOrdinal()] = !var6 && !var4?this.field587[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1814527678"
   )
   public boolean method608() {
      return this.field583;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "749932241"
   )
   static String method609(int var0) {
      return "<img=" + var0 + ">";
   }
}
