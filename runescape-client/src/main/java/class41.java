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

@ObfuscatedName("ae")
public final class class41 {
   @ObfuscatedName("o")
   boolean field553;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ljj;"
   )
   SpritePixels field567;
   @ObfuscatedName("c")
   boolean field568;
   @ObfuscatedName("g")
   HashMap field555;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[[Lak;"
   )
   class34[][] field557;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1419426819
   )
   int field561;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 55333391
   )
   int field556;
   @ObfuscatedName("s")
   HashMap field558;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   ModIcon[] field562;
   @ObfuscatedName("p")
   final HashMap field560;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lai;"
   )
   class44 field554;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1628704293
   )
   int field563;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 943167241
   )
   int field559;

   @ObfuscatedSignature(
      signature = "([Ljx;Ljava/util/HashMap;)V"
   )
   public class41(ModIcon[] var1, HashMap var2) {
      this.field568 = false;
      this.field553 = false;
      this.field558 = new HashMap();
      this.field562 = var1;
      this.field560 = var2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1802107382"
   )
   void method560() {
      if(this.field555 == null) {
         this.field555 = new HashMap();
      }

      this.field555.clear();

      for(int var1 = 0; var1 < this.field557.length; ++var1) {
         for(int var2 = 0; var2 < this.field557[var1].length; ++var2) {
            List var3 = this.field557[var1][var2].method386();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field555.containsKey(Integer.valueOf(var5.field531))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field555.put(Integer.valueOf(var5.field531), var6);
               } else {
                  List var7 = (List)this.field555.get(Integer.valueOf(var5.field531));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIB)Lag;",
      garbageValue = "-32"
   )
   class29 method545(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field561 + var1;
      int var7 = var2 + this.field556;
      int var8 = var3 + this.field561;
      int var9 = var4 + this.field556;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field407 = var12 - var10 + 1;
      var5.field409 = var13 - var11 + 1;
      var5.field408 = var10 - this.field554.method286();
      var5.field406 = var11 - this.field554.method289();
      if(var5.field408 < 0) {
         var5.field407 += var5.field408;
         var5.field408 = 0;
      }

      if(var5.field408 > this.field557.length - var5.field407) {
         var5.field407 = this.field557.length - var5.field408;
      }

      if(var5.field406 < 0) {
         var5.field409 += var5.field406;
         var5.field406 = 0;
      }

      if(var5.field406 > this.field557[0].length - var5.field409) {
         var5.field409 = this.field557[0].length - var5.field406;
      }

      var5.field407 = Math.min(var5.field407, this.field557.length);
      var5.field409 = Math.min(var5.field409, this.field557[0].length);
      return var5;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)F",
      garbageValue = "169208241"
   )
   float method538(int var1, int var2) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1381724160"
   )
   public boolean method539() {
      return this.field568;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(S)Ljava/util/HashMap;",
      garbageValue = "580"
   )
   public HashMap method540() {
      this.method560();
      return this.field555;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "691597024"
   )
   public void method557(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field567 != null) {
         this.field567.method4960(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field555 == null) {
               this.method560();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field555.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field537.worldX - this.field561) / this.field563;
                  int var14 = var4 - (var12.field537.worldY - this.field556) * var4 / this.field559;
                  Rasterizer2D.method4826(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lip;Ljava/lang/String;ZI)V",
      garbageValue = "868375342"
   )
   public void method531(IndexDataBase var1, String var2, boolean var3) {
      if(!this.field553) {
         this.field568 = false;
         this.field553 = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field540.field549);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.method4027(class40.field540.field549, var2));
         Buffer var7 = new Buffer(var1.method4027(class40.field541.field549, var2));
         Buffer var8 = new Buffer(var1.method4027(var2, class40.field545.field549));
         System.nanoTime();
         System.nanoTime();
         this.field554 = new class44();

         try {
            this.field554.method596(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var24) {
            return;
         }

         this.field554.method290();
         this.field554.method291();
         this.field554.method273();
         this.field561 = this.field554.method286() * 64;
         this.field556 = this.field554.method289() * 64;
         this.field563 = (this.field554.method272() - this.field554.method286() + 1) * 64;
         this.field559 = (this.field554.method305() - this.field554.method289() + 1) * 64;
         int var9 = this.field554.method272() - this.field554.method286() + 1;
         int var10 = this.field554.method305() - this.field554.method289() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field557 = new class34[var9][var10];
         Iterator var11 = this.field554.field577.iterator();

         int var14;
         int var15;
         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field403;
            var14 = var12.field393;
            var15 = var13 - this.field554.method286();
            int var16 = var14 - this.field554.method289();
            this.field557[var15][var16] = new class34(var13, var14, this.field554.method337(), this.field560);
            this.field557[var15][var16].method350(var12, this.field554.field578);
         }

         for(int var18 = 0; var18 < var9; ++var18) {
            for(int var19 = 0; var19 < var10; ++var19) {
               if(this.field557[var18][var19] == null) {
                  this.field557[var18][var19] = new class34(this.field554.method286() + var18, this.field554.method289() + var19, this.field554.method337(), this.field560);
                  this.field557[var18][var19].method376(this.field554.field580, this.field554.field578);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4026(class40.field542.field549, var2)) {
            byte[] var27 = var1.method4027(class40.field542.field549, var2);
            BufferedImage var20 = null;

            SpritePixels var28;
            label44: {
               try {
                  var20 = ImageIO.read(new ByteArrayInputStream(var27));
                  var14 = var20.getWidth();
                  var15 = var20.getHeight();
                  int[] var21 = new int[var15 * var14];
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

            this.field567 = var28;
         }

         System.nanoTime();
         this.field568 = true;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIII)Ljava/util/List;",
      garbageValue = "-165157447"
   )
   public List method537(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.field568) {
         return var11;
      } else {
         class29 var12 = this.method545(var1, var2, var3, var4);
         float var13 = this.method538(var7, var3 - var1);
         int var14 = (int)(64.0F * var13);
         int var15 = this.field561 + var1;
         int var16 = var2 + this.field556;

         for(int var17 = var12.field408; var17 < var12.field407 + var12.field408; ++var17) {
            for(int var18 = var12.field406; var18 < var12.field409 + var12.field406; ++var18) {
               List var19 = this.field557[var17][var18].method437(var5 + (this.field557[var17][var18].field464 * 64 - var15) * var14 / 64, var8 + var6 - var14 * (this.field557[var17][var18].field465 * 64 - var16 + 64) / 64, var14, var9, var10);
               if(!var19.isEmpty()) {
                  var11.addAll(var19);
               }
            }
         }

         return var11;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2136289575"
   )
   public final void method532() {
      this.field555 = null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[Lak;S)V",
      garbageValue = "30821"
   )
   void method535(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field557.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field557[0].length - 1;
      if(var7) {
         var3[class228.field3131.rsOrdinal()] = null;
      } else {
         var3[class228.field3131.rsOrdinal()] = this.field557[var1][var2 + 1];
      }

      var3[class228.field3121.rsOrdinal()] = !var7 && !var5?this.field557[var1 + 1][var2 + 1]:null;
      var3[class228.field3126.rsOrdinal()] = !var7 && !var4?this.field557[var1 - 1][var2 + 1]:null;
      var3[class228.field3122.rsOrdinal()] = var5?null:this.field557[var1 + 1][var2];
      var3[class228.field3128.rsOrdinal()] = var4?null:this.field557[var1 - 1][var2];
      var3[class228.field3120.rsOrdinal()] = var6?null:this.field557[var1][var2 - 1];
      var3[class228.field3124.rsOrdinal()] = !var6 && !var5?this.field557[var1 + 1][var2 - 1]:null;
      var3[class228.field3125.rsOrdinal()] = !var6 && !var4?this.field557[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "-1275255934"
   )
   public final void method533(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method545(var1, var2, var3, var4);
      float var14 = this.method538(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field558.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method648();
         this.field558.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field408; var17 < var13.field407 + var13.field408; ++var17) {
         for(var18 = var13.field406; var18 < var13.field406 + var13.field409; ++var18) {
            this.method535(var17, var18, var22);
            this.field557[var17][var18].method354(var15, (class46)this.field558.get(Integer.valueOf(var15)), var22, this.field562);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(64.0F * var14);
      var18 = this.field561 + var1;
      int var19 = var2 + this.field556;

      for(int var20 = var13.field408; var20 < var13.field407 + var13.field408; ++var20) {
         for(int var21 = var13.field406; var21 < var13.field409 + var13.field406; ++var21) {
            this.field557[var20][var21].method417(var5 + (this.field557[var20][var21].field464 * 64 - var18) * var17 / 64, var8 - var17 * (this.field557[var20][var21].field465 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "374561433"
   )
   public final void method554(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method545(var1, var2, var3, var4);
      float var15 = this.method538(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field561 + var1;
      int var18 = var2 + this.field556;

      int var19;
      int var20;
      for(var19 = var14.field408; var19 < var14.field408 + var14.field407; ++var19) {
         for(var20 = var14.field406; var20 < var14.field406 + var14.field409; ++var20) {
            if(var13) {
               this.field557[var19][var20].method378();
            }

            this.field557[var19][var20].method355(var5 + (this.field557[var19][var20].field464 * 64 - var17) * var16 / 64, var8 - (this.field557[var19][var20].field465 * 64 - var18 + 64) * var16 / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field408; var19 < var14.field407 + var14.field408; ++var19) {
            for(var20 = var14.field406; var20 < var14.field406 + var14.field409; ++var20) {
               this.field557[var19][var20].method403(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "([Lho;IIIZB)V",
      garbageValue = "68"
   )
   static void method555(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class134.method2520(var6, var2, var3, var4);
            class134.method2521(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class77.method1465(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "357389726"
   )
   static int method565(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 6600) {
         var3 = class10.plane;
         int var13 = (class226.localPlayer.x >> 7) + class21.baseX;
         int var5 = (class226.localPlayer.y >> 7) + class164.baseY;
         class73.method1070().method5240(var3, var13, var5, true);
         return 1;
      } else {
         WorldMapData var15;
         if(var0 == 6601) {
            var3 = class83.intStack[--BufferProvider.intStackSize];
            String var20 = "";
            var15 = class73.method1070().method5112(var3);
            if(var15 != null) {
               var20 = var15.method283();
            }

            class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var20;
            return 1;
         } else if(var0 == 6602) {
            var3 = class83.intStack[--BufferProvider.intStackSize];
            class73.method1070().method5097(var3);
            return 1;
         } else if(var0 == 6603) {
            class83.intStack[++BufferProvider.intStackSize - 1] = class73.method1070().method5109();
            return 1;
         } else if(var0 == 6604) {
            var3 = class83.intStack[--BufferProvider.intStackSize];
            class73.method1070().method5106(var3);
            return 1;
         } else if(var0 == 6605) {
            class83.intStack[++BufferProvider.intStackSize - 1] = class73.method1070().method5107()?1:0;
            return 1;
         } else {
            Coordinates var19;
            if(var0 == 6606) {
               var19 = new Coordinates(class83.intStack[--BufferProvider.intStackSize]);
               class73.method1070().method5113(var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6607) {
               var19 = new Coordinates(class83.intStack[--BufferProvider.intStackSize]);
               class73.method1070().method5208(var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6608) {
               var19 = new Coordinates(class83.intStack[--BufferProvider.intStackSize]);
               class73.method1070().method5115(var19.plane, var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6609) {
               var19 = new Coordinates(class83.intStack[--BufferProvider.intStackSize]);
               class73.method1070().method5116(var19.plane, var19.worldX, var19.worldY);
               return 1;
            } else if(var0 == 6610) {
               class83.intStack[++BufferProvider.intStackSize - 1] = class73.method1070().method5117();
               class83.intStack[++BufferProvider.intStackSize - 1] = class73.method1070().method5179();
               return 1;
            } else {
               WorldMapData var17;
               if(var0 == 6611) {
                  var3 = class83.intStack[--BufferProvider.intStackSize];
                  var17 = class73.method1070().method5112(var3);
                  if(var17 == null) {
                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                  } else {
                     class83.intStack[++BufferProvider.intStackSize - 1] = var17.method293().method3866();
                  }

                  return 1;
               } else if(var0 == 6612) {
                  var3 = class83.intStack[--BufferProvider.intStackSize];
                  var17 = class73.method1070().method5112(var3);
                  if(var17 == null) {
                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                  } else {
                     class83.intStack[++BufferProvider.intStackSize - 1] = (var17.method272() - var17.method286() + 1) * 64;
                     class83.intStack[++BufferProvider.intStackSize - 1] = (var17.method305() - var17.method289() + 1) * 64;
                  }

                  return 1;
               } else if(var0 == 6613) {
                  var3 = class83.intStack[--BufferProvider.intStackSize];
                  var17 = class73.method1070().method5112(var3);
                  if(var17 == null) {
                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                     class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                  } else {
                     class83.intStack[++BufferProvider.intStackSize - 1] = var17.method286() * 64;
                     class83.intStack[++BufferProvider.intStackSize - 1] = var17.method289() * 64;
                     class83.intStack[++BufferProvider.intStackSize - 1] = var17.method272() * 64 + 64 - 1;
                     class83.intStack[++BufferProvider.intStackSize - 1] = var17.method305() * 64 + 64 - 1;
                  }

                  return 1;
               } else if(var0 == 6614) {
                  var3 = class83.intStack[--BufferProvider.intStackSize];
                  var17 = class73.method1070().method5112(var3);
                  if(var17 == null) {
                     class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                  } else {
                     class83.intStack[++BufferProvider.intStackSize - 1] = var17.method285();
                  }

                  return 1;
               } else if(var0 == 6615) {
                  var19 = class73.method1070().method5110();
                  if(var19 == null) {
                     class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                     class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                  } else {
                     class83.intStack[++BufferProvider.intStackSize - 1] = var19.worldX;
                     class83.intStack[++BufferProvider.intStackSize - 1] = var19.worldY;
                  }

                  return 1;
               } else if(var0 == 6616) {
                  class83.intStack[++BufferProvider.intStackSize - 1] = class73.method1070().method5098();
                  return 1;
               } else if(var0 == 6617) {
                  var19 = new Coordinates(class83.intStack[--BufferProvider.intStackSize]);
                  var17 = class73.method1070().method5099();
                  if(var17 == null) {
                     class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                     class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var18 = var17.method277(var19.plane, var19.worldX, var19.worldY);
                     if(var18 == null) {
                        class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                        class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                     } else {
                        class83.intStack[++BufferProvider.intStackSize - 1] = var18[0];
                        class83.intStack[++BufferProvider.intStackSize - 1] = var18[1];
                     }

                     return 1;
                  }
               } else {
                  Coordinates var11;
                  if(var0 == 6618) {
                     var19 = new Coordinates(class83.intStack[--BufferProvider.intStackSize]);
                     var17 = class73.method1070().method5099();
                     if(var17 == null) {
                        class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                        class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var11 = var17.method278(var19.worldX, var19.worldY);
                        if(var11 == null) {
                           class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                        } else {
                           class83.intStack[++BufferProvider.intStackSize - 1] = var11.method3866();
                        }

                        return 1;
                     }
                  } else {
                     Coordinates var16;
                     if(var0 == 6619) {
                        BufferProvider.intStackSize -= 2;
                        var3 = class83.intStack[BufferProvider.intStackSize];
                        var16 = new Coordinates(class83.intStack[BufferProvider.intStackSize + 1]);
                        var15 = class73.method1070().method5112(var3);
                        int var6 = class226.localPlayer.field896;
                        int var7 = (class226.localPlayer.x >> 7) + class21.baseX;
                        int var8 = (class226.localPlayer.y >> 7) + class164.baseY;
                        Coordinates var9 = new Coordinates(var6, var7, var8);
                        class73.method1070().method5102(var15, var9, var16, false);
                        return 1;
                     } else if(var0 == 6620) {
                        BufferProvider.intStackSize -= 2;
                        var3 = class83.intStack[BufferProvider.intStackSize];
                        var16 = new Coordinates(class83.intStack[BufferProvider.intStackSize + 1]);
                        ScriptVarType.method20(var3, var16, true);
                        return 1;
                     } else if(var0 == 6621) {
                        BufferProvider.intStackSize -= 2;
                        var3 = class83.intStack[BufferProvider.intStackSize];
                        var16 = new Coordinates(class83.intStack[BufferProvider.intStackSize + 1]);
                        var15 = class73.method1070().method5112(var3);
                        if(var15 == null) {
                           class83.intStack[++BufferProvider.intStackSize - 1] = 0;
                           return 1;
                        } else {
                           class83.intStack[++BufferProvider.intStackSize - 1] = var15.method304(var16.plane, var16.worldX, var16.worldY)?1:0;
                           return 1;
                        }
                     } else if(var0 == 6622) {
                        class83.intStack[++BufferProvider.intStackSize - 1] = class73.method1070().method5120();
                        class83.intStack[++BufferProvider.intStackSize - 1] = class73.method1070().method5121();
                        return 1;
                     } else if(var0 == 6623) {
                        var19 = new Coordinates(class83.intStack[--BufferProvider.intStackSize]);
                        var17 = class73.method1070().method5154(var19.plane, var19.worldX, var19.worldY);
                        if(var17 == null) {
                           class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                        } else {
                           class83.intStack[++BufferProvider.intStackSize - 1] = var17.method284();
                        }

                        return 1;
                     } else if(var0 == 6624) {
                        class73.method1070().method5114(class83.intStack[--BufferProvider.intStackSize]);
                        return 1;
                     } else if(var0 == 6625) {
                        class73.method1070().method5221();
                        return 1;
                     } else if(var0 == 6626) {
                        class73.method1070().method5124(class83.intStack[--BufferProvider.intStackSize]);
                        return 1;
                     } else if(var0 == 6627) {
                        class73.method1070().method5125();
                        return 1;
                     } else {
                        boolean var14;
                        if(var0 == 6628) {
                           var14 = class83.intStack[--BufferProvider.intStackSize] == 1;
                           class73.method1070().method5126(var14);
                           return 1;
                        } else if(var0 == 6629) {
                           var3 = class83.intStack[--BufferProvider.intStackSize];
                           class73.method1070().method5184(var3);
                           return 1;
                        } else if(var0 == 6630) {
                           var3 = class83.intStack[--BufferProvider.intStackSize];
                           class73.method1070().method5128(var3);
                           return 1;
                        } else if(var0 == 6631) {
                           class73.method1070().method5142();
                           return 1;
                        } else if(var0 == 6632) {
                           var14 = class83.intStack[--BufferProvider.intStackSize] == 1;
                           class73.method1070().method5130(var14);
                           return 1;
                        } else {
                           boolean var4;
                           if(var0 == 6633) {
                              BufferProvider.intStackSize -= 2;
                              var3 = class83.intStack[BufferProvider.intStackSize];
                              var4 = class83.intStack[BufferProvider.intStackSize + 1] == 1;
                              class73.method1070().method5131(var3, var4);
                              return 1;
                           } else if(var0 == 6634) {
                              BufferProvider.intStackSize -= 2;
                              var3 = class83.intStack[BufferProvider.intStackSize];
                              var4 = class83.intStack[BufferProvider.intStackSize + 1] == 1;
                              class73.method1070().method5132(var3, var4);
                              return 1;
                           } else if(var0 == 6635) {
                              class83.intStack[++BufferProvider.intStackSize - 1] = class73.method1070().method5095()?1:0;
                              return 1;
                           } else if(var0 == 6636) {
                              var3 = class83.intStack[--BufferProvider.intStackSize];
                              class83.intStack[++BufferProvider.intStackSize - 1] = class73.method1070().method5149(var3)?1:0;
                              return 1;
                           } else if(var0 == 6637) {
                              var3 = class83.intStack[--BufferProvider.intStackSize];
                              class83.intStack[++BufferProvider.intStackSize - 1] = class73.method1070().method5135(var3)?1:0;
                              return 1;
                           } else if(var0 == 6638) {
                              BufferProvider.intStackSize -= 2;
                              var3 = class83.intStack[BufferProvider.intStackSize];
                              var16 = new Coordinates(class83.intStack[BufferProvider.intStackSize + 1]);
                              var11 = class73.method1070().method5233(var3, var16);
                              if(var11 == null) {
                                 class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                              } else {
                                 class83.intStack[++BufferProvider.intStackSize - 1] = var11.method3866();
                              }

                              return 1;
                           } else {
                              class39 var12;
                              if(var0 == 6639) {
                                 var12 = class73.method1070().method5140();
                                 if(var12 == null) {
                                    class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                    class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                 } else {
                                    class83.intStack[++BufferProvider.intStackSize - 1] = var12.field531;
                                    class83.intStack[++BufferProvider.intStackSize - 1] = var12.field537.method3866();
                                 }

                                 return 1;
                              } else if(var0 == 6640) {
                                 var12 = class73.method1070().method5141();
                                 if(var12 == null) {
                                    class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                    class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                 } else {
                                    class83.intStack[++BufferProvider.intStackSize - 1] = var12.field531;
                                    class83.intStack[++BufferProvider.intStackSize - 1] = var12.field537.method3866();
                                 }

                                 return 1;
                              } else {
                                 Area var10;
                                 if(var0 == 6693) {
                                    var3 = class83.intStack[--BufferProvider.intStackSize];
                                    var10 = Area.field3265[var3];
                                    if(var10.name == null) {
                                       class83.scriptStringStack[++class83.scriptStringStackSize - 1] = "";
                                    } else {
                                       class83.scriptStringStack[++class83.scriptStringStackSize - 1] = var10.name;
                                    }

                                    return 1;
                                 } else if(var0 == 6694) {
                                    var3 = class83.intStack[--BufferProvider.intStackSize];
                                    var10 = Area.field3265[var3];
                                    class83.intStack[++BufferProvider.intStackSize - 1] = var10.field3269;
                                    return 1;
                                 } else if(var0 == 6695) {
                                    var3 = class83.intStack[--BufferProvider.intStackSize];
                                    var10 = Area.field3265[var3];
                                    if(var10 == null) {
                                       class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                    } else {
                                       class83.intStack[++BufferProvider.intStackSize - 1] = var10.field3281;
                                    }

                                    return 1;
                                 } else if(var0 == 6696) {
                                    var3 = class83.intStack[--BufferProvider.intStackSize];
                                    var10 = Area.field3265[var3];
                                    if(var10 == null) {
                                       class83.intStack[++BufferProvider.intStackSize - 1] = -1;
                                    } else {
                                       class83.intStack[++BufferProvider.intStackSize - 1] = var10.spriteId;
                                    }

                                    return 1;
                                 } else if(var0 == 6697) {
                                    class83.intStack[++BufferProvider.intStackSize - 1] = class47.field598.field606;
                                    return 1;
                                 } else if(var0 == 6698) {
                                    class83.intStack[++BufferProvider.intStackSize - 1] = class47.field598.field601.method3866();
                                    return 1;
                                 } else if(var0 == 6699) {
                                    class83.intStack[++BufferProvider.intStackSize - 1] = class47.field598.field603.method3866();
                                    return 1;
                                 } else {
                                    return 2;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "250092807"
   )
   static final void method530() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints == -1) {
            var0.delay = 0;
            class3.method8(var0);
         } else {
            var0.unlink();
         }
      }

   }
}
