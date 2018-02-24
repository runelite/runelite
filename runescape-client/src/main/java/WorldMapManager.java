import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
@Implements("WorldMapManager")
public final class WorldMapManager
{
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1273795509
   )
   static int field512;
   @ObfuscatedName("cy")
   @ObfuscatedSignature(
      signature = "Lfk;"
   )
   @Export("socket")
   static Task socket;
   @ObfuscatedName("b")
   @Export("loaded")
   boolean loaded;
   @ObfuscatedName("q")
   @Export("loading")
   boolean loading;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lay;"
   )
   class44 field509;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Llm;"
   )
   SpritePixels field510;
   @ObfuscatedName("a")
   HashMap field511;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "[[Lak;"
   )
   class34[][] field514;
   @ObfuscatedName("l")
   HashMap field513;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "[Llv;"
   )
   IndexedSprite[] field523;
   @ObfuscatedName("g")
   final HashMap field515;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1050454945
   )
   int field516;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1872707121
   )
   int field517;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -698860005
   )
   int field518;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 483048981
   )
   int field507;

   @ObfuscatedSignature(
      signature = "([Llv;Ljava/util/HashMap;)V"
   )
   public WorldMapManager(IndexedSprite[] var1, HashMap var2) {
      this.loaded = false;
      this.loading = false;
      this.field513 = new HashMap();
      this.field523 = var1;
      this.field515 = var2;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;Ljava/lang/String;ZI)V",
      garbageValue = "-1036709306"
   )
   @Export("load")
   public void load(IndexDataBase var1, String var2, boolean var3) {
      if(!this.loading) {
         this.loaded = false;
         this.loading = true;
         System.nanoTime();
         int var4 = var1.getFile(class40.field497.field502);
         int var5 = var1.getChild(var4, var2);
         Buffer var6 = new Buffer(var1.takeRecordByNames(class40.field497.field502, var2));
         Buffer var7 = new Buffer(var1.takeRecordByNames(class40.field503.field502, var2));
         Buffer var8 = new Buffer(var1.takeRecordByNames(var2, class40.field500.field502));
         System.nanoTime();
         System.nanoTime();
         this.field509 = new class44();

         try {
            this.field509.method646(var6, var8, var7, var5, var3);
         } catch (IllegalStateException var20) {
            return;
         }

         this.field509.method322();
         this.field509.method323();
         this.field509.method368();
         this.field516 = this.field509.method318() * 64;
         this.field517 = this.field509.method355() * 64;
         this.field518 = (this.field509.method319() - this.field509.method318() + 1) * 64;
         this.field507 = (this.field509.method321() - this.field509.method355() + 1) * 64;
         int var17 = this.field509.method319() - this.field509.method318() + 1;
         int var10 = this.field509.method321() - this.field509.method355() + 1;
         System.nanoTime();
         System.nanoTime();
         this.field514 = new class34[var17][var10];
         Iterator var11 = this.field509.field538.iterator();

         while(var11.hasNext()) {
            class22 var12 = (class22)var11.next();
            int var13 = var12.field383;
            int var14 = var12.field373;
            int var15 = var13 - this.field509.method318();
            int var16 = var14 - this.field509.method355();
            this.field514[var15][var16] = new class34(var13, var14, this.field509.method309(), this.field515);
            this.field514[var15][var16].method379(var12, this.field509.field534);
         }

         for(int var18 = 0; var18 < var17; ++var18) {
            for(int var19 = 0; var19 < var10; ++var19) {
               if(this.field514[var18][var19] == null) {
                  this.field514[var18][var19] = new class34(this.field509.method318() + var18, this.field509.method355() + var19, this.field509.method309(), this.field515);
                  this.field514[var18][var19].method494(this.field509.field535, this.field509.field534);
               }
            }
         }

         System.nanoTime();
         System.nanoTime();
         if(var1.method4539(class40.field506.field502, var2)) {
            byte[] var21 = var1.takeRecordByNames(class40.field506.field502, var2);
            this.field510 = Signlink.method3249(var21);
         }

         System.nanoTime();
         this.loaded = true;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-433078574"
   )
   public final void method566() {
      this.field511 = null;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIIIII)V",
      garbageValue = "1565216278"
   )
   public final void method564(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int[] var9 = Rasterizer2D.graphicsPixels;
      int var10 = Rasterizer2D.graphicsPixelsWidth;
      int var11 = Rasterizer2D.graphicsPixelsHeight;
      int[] var12 = new int[4];
      Rasterizer2D.copyDrawRegion(var12);
      class29 var13 = this.method571(var1, var2, var3, var4);
      float var14 = this.method575(var7 - var5, var3 - var1);
      int var15 = (int)Math.ceil((double)var14);
      if(!this.field513.containsKey(Integer.valueOf(var15))) {
         class46 var16 = new class46(var15);
         var16.method687();
         this.field513.put(Integer.valueOf(var15), var16);
      }

      class34[] var22 = new class34[8];

      int var17;
      int var18;
      for(var17 = var13.field389; var17 < var13.field391 + var13.field389; ++var17) {
         for(var18 = var13.field388; var18 < var13.field388 + var13.field390; ++var18) {
            this.method578(var17, var18, var22);
            this.field514[var17][var18].method383(var15, (class46)this.field513.get(Integer.valueOf(var15)), var22, this.field523);
         }
      }

      Rasterizer2D.setRasterBuffer(var9, var10, var11);
      Rasterizer2D.setDrawRegion(var12);
      var17 = (int)(64.0F * var14);
      var18 = this.field516 + var1;
      int var19 = var2 + this.field517;

      for(int var20 = var13.field389; var20 < var13.field389 + var13.field391; ++var20) {
         for(int var21 = var13.field388; var21 < var13.field388 + var13.field390; ++var21) {
            this.field514[var20][var21].method378(var5 + var17 * (this.field514[var20][var21].field447 * 64 - var18) / 64, var8 - var17 * (this.field514[var20][var21].field437 * 64 - var19 + 64) / 64, var17);
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
      garbageValue = "706420435"
   )
   public final void method565(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
      class29 var14 = this.method571(var1, var2, var3, var4);
      float var15 = this.method575(var7 - var5, var3 - var1);
      int var16 = (int)(var15 * 64.0F);
      int var17 = this.field516 + var1;
      int var18 = var2 + this.field517;

      int var19;
      int var20;
      for(var19 = var14.field389; var19 < var14.field389 + var14.field391; ++var19) {
         for(var20 = var14.field388; var20 < var14.field390 + var14.field388; ++var20) {
            if(var13) {
               this.field514[var19][var20].method407();
            }

            this.field514[var19][var20].method384(var5 + var16 * (this.field514[var19][var20].field447 * 64 - var17) / 64, var8 - var16 * (this.field514[var19][var20].field437 * 64 - var18 + 64) / 64, var16, var9);
         }
      }

      if(var10 != null && var11 > 0) {
         for(var19 = var14.field389; var19 < var14.field389 + var14.field391; ++var19) {
            for(var20 = var14.field388; var20 < var14.field390 + var14.field388; ++var20) {
               this.field514[var19][var20].method385(var10, var11, var12);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II[Lak;I)V",
      garbageValue = "2020818530"
   )
   void method578(int var1, int var2, class34[] var3) {
      boolean var4 = var1 <= 0;
      boolean var5 = var1 >= this.field514.length - 1;
      boolean var6 = var2 <= 0;
      boolean var7 = var2 >= this.field514[0].length - 1;
      if(var7) {
         var3[class248.field3272.rsOrdinal()] = null;
      } else {
         var3[class248.field3272.rsOrdinal()] = this.field514[var1][var2 + 1];
      }

      var3[class248.field3270.rsOrdinal()] = !var7 && !var5?this.field514[var1 + 1][var2 + 1]:null;
      var3[class248.field3273.rsOrdinal()] = !var7 && !var4?this.field514[var1 - 1][var2 + 1]:null;
      var3[class248.field3268.rsOrdinal()] = var5?null:this.field514[var1 + 1][var2];
      var3[class248.field3275.rsOrdinal()] = var4?null:this.field514[var1 - 1][var2];
      var3[class248.field3266.rsOrdinal()] = var6?null:this.field514[var1][var2 - 1];
      var3[class248.field3269.rsOrdinal()] = !var6 && !var5?this.field514[var1 + 1][var2 - 1]:null;
      var3[class248.field3271.rsOrdinal()] = !var6 && !var4?this.field514[var1 - 1][var2 - 1]:null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIILjava/util/HashSet;III)V",
      garbageValue = "-830327519"
   )
   public void method588(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
      if(this.field510 != null) {
         this.field510.method5863(var1, var2, var3, var4);
         if(var6 > 0 && var6 % var7 < var7 / 2) {
            if(this.field511 == null) {
               this.method584();
            }

            Iterator var8 = var5.iterator();

            while(true) {
               List var10;
               do {
                  if(!var8.hasNext()) {
                     return;
                  }

                  int var9 = ((Integer)var8.next()).intValue();
                  var10 = (List)this.field511.get(Integer.valueOf(var9));
               } while(var10 == null);

               Iterator var11 = var10.iterator();

               while(var11.hasNext()) {
                  class39 var12 = (class39)var11.next();
                  int var13 = var3 * (var12.field490.worldX - this.field516) / this.field518;
                  int var14 = var4 - (var12.field490.worldY - this.field517) * var4 / this.field507;
                  Rasterizer2D.method5672(var13 + var1, var14 + var2, 2, 16776960, 256);
               }
            }
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIIB)Ljava/util/List;",
      garbageValue = "-43"
   )
   public List method583(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      LinkedList var11 = new LinkedList();
      if(!this.loaded) {
         return var11;
      } else {
         class29 var12 = this.method571(var1, var2, var3, var4);
         float var13 = this.method575(var7, var3 - var1);
         int var14 = (int)(var13 * 64.0F);
         int var15 = this.field516 + var1;
         int var16 = var2 + this.field517;

         for(int var17 = var12.field389; var17 < var12.field389 + var12.field391; ++var17) {
            for(int var18 = var12.field388; var18 < var12.field390 + var12.field388; ++var18) {
               List var19 = this.field514[var17][var18].method414(var5 + var14 * (this.field514[var17][var18].field447 * 64 - var15) / 64, var8 + var6 - var14 * (this.field514[var17][var18].field437 * 64 - var16 + 64) / 64, var14, var9, var10);
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
      signature = "(IIIIB)Laj;",
      garbageValue = "60"
   )
   class29 method571(int var1, int var2, int var3, int var4) {
      class29 var5 = new class29(this);
      int var6 = this.field516 + var1;
      int var7 = var2 + this.field517;
      int var8 = var3 + this.field516;
      int var9 = var4 + this.field517;
      int var10 = var6 / 64;
      int var11 = var7 / 64;
      int var12 = var8 / 64;
      int var13 = var9 / 64;
      var5.field391 = var12 - var10 + 1;
      var5.field390 = var13 - var11 + 1;
      var5.field389 = var10 - this.field509.method318();
      var5.field388 = var11 - this.field509.method355();
      if(var5.field389 < 0) {
         var5.field391 += var5.field389;
         var5.field389 = 0;
      }

      if(var5.field389 > this.field514.length - var5.field391) {
         var5.field391 = this.field514.length - var5.field389;
      }

      if(var5.field388 < 0) {
         var5.field390 += var5.field388;
         var5.field388 = 0;
      }

      if(var5.field388 > this.field514[0].length - var5.field390) {
         var5.field390 = this.field514[0].length - var5.field388;
      }

      var5.field391 = Math.min(var5.field391, this.field514.length);
      var5.field390 = Math.min(var5.field390, this.field514[0].length);
      return var5;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-967937484"
   )
   public boolean method572() {
      return this.loaded;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/HashMap;",
      garbageValue = "-6"
   )
   public HashMap method579() {
      this.method584();
      return this.field511;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1907030197"
   )
   void method584() {
      if(this.field511 == null) {
         this.field511 = new HashMap();
      }

      this.field511.clear();

      for(int var1 = 0; var1 < this.field514.length; ++var1) {
         for(int var2 = 0; var2 < this.field514[var1].length; ++var2) {
            List var3 = this.field514[var1][var2].method415();
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               class39 var5 = (class39)var4.next();
               if(!this.field511.containsKey(Integer.valueOf(var5.field488))) {
                  LinkedList var6 = new LinkedList();
                  var6.add(var5);
                  this.field511.put(Integer.valueOf(var5.field488), var6);
               } else {
                  List var7 = (List)this.field511.get(Integer.valueOf(var5.field488));
                  var7.add(var5);
               }
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)F",
      garbageValue = "60"
   )
   float method575(int var1, int var2) {
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgu;I)V",
      garbageValue = "1076251254"
   )
   @Export("initializeGPI")
   static final void initializeGPI(PacketBuffer var0) {
      var0.bitAccess();
      int var1 = Client.localInteractingIndex;
      Player var2 = OwnWorldComparator.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field808 = var1;
      int var3 = var0.getBits(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - ScriptState.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.getSize() << 6);
      var2.pathY[0] = var6 - WorldMapType1.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.getSize() << 6);
      class230.plane = var2.field802 = var4;
      if(class92.field1374[var1] != null) {
         var2.decodeApperance(class92.field1374[var1]);
      }

      class92.playerIndexesCount = 0;
      class92.playerIndices[++class92.playerIndexesCount - 1] = var1;
      class92.field1372[var1] = 0;
      class92.field1377 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.getBits(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 597;
            int var11 = var8 & 597;
            class92.Players_regions[var7] = (var10 << 14) + var11 + (var9 << 28);
            class92.Players_orientations[var7] = 0;
            class92.Players_targetIndices[var7] = -1;
            class92.field1383[++class92.field1377 - 1] = var7;
            class92.field1372[var7] = 0;
         }
      }

      var0.byteAccess();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BIII)Z",
      garbageValue = "-604806052"
   )
   static final boolean method610(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label67:
      while(true) {
         int var6 = var4.getUSmart();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.getUSmart();
               if(var9 == 0) {
                  continue label67;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = Preferences.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.lowMemory || var15.int1 != 0 || var15.clipType == 1 || var15.obstructsGround) {
                     if(!var15.method4955()) {
                        ++Client.field844;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.getUSmart();
            if(var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lev;[Lfq;I)V",
      garbageValue = "53607001"
   )
   static final void method611(Region var0, CollisionData[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if((class61.tileSettings[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if((class61.tileSettings[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if(var5 >= 0) {
                     var1[var5].method3391(var3, var4);
                  }
               }
            }
         }
      }

      class61.field696 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field696 < -8) {
         class61.field696 = -8;
      }

      if(class61.field696 > 8) {
         class61.field696 = 8;
      }

      class61.field685 += (int)(Math.random() * 5.0D) - 2;
      if(class61.field685 < -16) {
         class61.field685 = -16;
      }

      if(class61.field685 > 16) {
         class61.field685 = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var42 = class188.field2488[var2];
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = class61.tileHeights[var2][var12 + 1][var11] - class61.tileHeights[var2][var12 - 1][var11];
               var14 = class61.tileHeights[var2][var12][var11 + 1] - class61.tileHeights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var13 * var13 + var14 * var14 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var18 * -50 + var16 * -50 + var17 * -10) / var10 + 96;
               var20 = (var42[var12 - 1][var11] >> 2) + (var42[var12][var11 - 1] >> 2) + (var42[var12 + 1][var11] >> 3) + (var42[var12][var11 + 1] >> 3) + (var42[var12][var11] >> 1);
               PacketNode.field2469[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            class231.field2738[var11] = 0;
            Size.field334[var11] = 0;
            class61.field684[var11] = 0;
            class61.field692[var11] = 0;
            ScriptState.field700[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if(var13 >= 0 && var13 < 104) {
                  var14 = class61.field687[var2][var13][var12] & 255;
                  if(var14 > 0) {
                     FloorUnderlayDefinition var43 = Item.getUnderlayDefinition(var14 - 1);
                     class231.field2738[var12] += var43.hue;
                     Size.field334[var12] += var43.saturation;
                     class61.field684[var12] += var43.lightness;
                     class61.field692[var12] += var43.hueMultiplier;
                     ++ScriptState.field700[var12];
                  }
               }

               var14 = var11 - 5;
               if(var14 >= 0 && var14 < 104) {
                  var15 = class61.field687[var2][var14][var12] & 255;
                  if(var15 > 0) {
                     FloorUnderlayDefinition var44 = Item.getUnderlayDefinition(var15 - 1);
                     class231.field2738[var12] -= var44.hue;
                     Size.field334[var12] -= var44.saturation;
                     class61.field684[var12] -= var44.lightness;
                     class61.field692[var12] -= var44.hueMultiplier;
                     --ScriptState.field700[var12];
                  }
               }
            }

            if(var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if(var18 >= 0 && var18 < 104) {
                     var12 += class231.field2738[var18];
                     var13 += Size.field334[var18];
                     var14 += class61.field684[var18];
                     var15 += class61.field692[var18];
                     var16 += ScriptState.field700[var18];
                  }

                  var19 = var17 - 5;
                  if(var19 >= 0 && var19 < 104) {
                     var12 -= class231.field2738[var19];
                     var13 -= Size.field334[var19];
                     var14 -= class61.field684[var19];
                     var15 -= class61.field692[var19];
                     var16 -= ScriptState.field700[var19];
                  }

                  if(var17 >= 1 && var17 < 103 && (!Client.lowMemory || (class61.tileSettings[0][var11][var17] & 2) != 0 || (class61.tileSettings[var2][var11][var17] & 16) == 0)) {
                     if(var2 < class61.field686) {
                        class61.field686 = var2;
                     }

                     var20 = class61.field687[var2][var11][var17] & 255;
                     int var21 = class235.field2764[var2][var11][var17] & 255;
                     if(var20 > 0 || var21 > 0) {
                        int var22 = class61.tileHeights[var2][var11][var17];
                        int var23 = class61.tileHeights[var2][var11 + 1][var17];
                        int var24 = class61.tileHeights[var2][var11 + 1][var17 + 1];
                        int var25 = class61.tileHeights[var2][var11][var17 + 1];
                        int var26 = PacketNode.field2469[var11][var17];
                        int var27 = PacketNode.field2469[var11 + 1][var17];
                        int var28 = PacketNode.field2469[var11 + 1][var17 + 1];
                        int var29 = PacketNode.field2469[var11][var17 + 1];
                        int var30 = -1;
                        int var31 = -1;
                        int var32;
                        int var33;
                        if(var20 > 0) {
                           var32 = var12 * 256 / var15;
                           var33 = var13 / var16;
                           int var34 = var14 / var16;
                           var30 = class7.method29(var32, var33, var34);
                           var32 = var32 + class61.field696 & 255;
                           var34 += class61.field685;
                           if(var34 < 0) {
                              var34 = 0;
                           } else if(var34 > 255) {
                              var34 = 255;
                           }

                           var31 = class7.method29(var32, var33, var34);
                        }

                        if(var2 > 0) {
                           boolean var46 = true;
                           if(var20 == 0 && ContextMenuRow.field1282[var2][var11][var17] != 0) {
                              var46 = false;
                           }

                           if(var21 > 0 && !class21.getOverlayDefinition(var21 - 1).isHidden) {
                              var46 = false;
                           }

                           if(var46 && var23 == var22 && var24 == var22 && var25 == var22) {
                              class56.field619[var2][var11][var17] |= 2340;
                           }
                        }

                        var32 = 0;
                        if(var31 != -1) {
                           var32 = Graphics3D.colorPalette[Size.method200(var31, 96)];
                        }

                        if(var21 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, Size.method200(var30, var26), Size.method200(var30, var27), Size.method200(var30, var28), Size.method200(var30, var29), 0, 0, 0, 0, var32, 0);
                        } else {
                           var33 = ContextMenuRow.field1282[var2][var11][var17] + 1;
                           byte var47 = BaseVarType.field27[var2][var11][var17];
                           Overlay var35 = class21.getOverlayDefinition(var21 - 1);
                           int var36 = var35.texture;
                           int var37;
                           int var38;
                           int var39;
                           int var40;
                           if(var36 >= 0) {
                              var38 = Graphics3D.textureLoader.getAverageTextureRGB(var36);
                              var37 = -1;
                           } else if(var35.color == 16711935) {
                              var37 = -2;
                              var36 = -1;
                              var38 = -2;
                           } else {
                              var37 = class7.method29(var35.hue, var35.saturation, var35.lightness);
                              var39 = var35.hue + class61.field696 & 255;
                              var40 = var35.lightness + class61.field685;
                              if(var40 < 0) {
                                 var40 = 0;
                              } else if(var40 > 255) {
                                 var40 = 255;
                              }

                              var38 = class7.method29(var39, var35.saturation, var40);
                           }

                           var39 = 0;
                           if(var38 != -2) {
                              var39 = Graphics3D.colorPalette[class19.adjustHSLListness0(var38, 96)];
                           }

                           if(var35.otherRgbColor != -1) {
                              var40 = var35.otherHue + class61.field696 & 255;
                              int var41 = var35.otherLightness + class61.field685;
                              if(var41 < 0) {
                                 var41 = 0;
                              } else if(var41 > 255) {
                                 var41 = 255;
                              }

                              var38 = class7.method29(var40, var35.otherSaturation, var41);
                              var39 = Graphics3D.colorPalette[class19.adjustHSLListness0(var38, 96)];
                           }

                           var0.addTile(var2, var11, var17, var33, var47, var36, var22, var23, var24, var25, Size.method200(var30, var26), Size.method200(var30, var27), Size.method200(var30, var28), Size.method200(var30, var29), class19.adjustHSLListness0(var37, var26), class19.adjustHSLListness0(var37, var27), class19.adjustHSLListness0(var37, var28), class19.adjustHSLListness0(var37, var29), var32, var39);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.setPhysicalLevel(var2, var12, var11, class21.method170(var2, var12, var11));
            }
         }

         class61.field687[var2] = null;
         class235.field2764[var2] = null;
         ContextMenuRow.field1282[var2] = null;
         BaseVarType.field27[var2] = null;
         class188.field2488[var2] = null;
      }

      var0.applyLighting(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if((class61.tileSettings[1][var2][var3] & 2) == 2) {
               var0.setBridge(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if(var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var6 = 0; var6 <= var5; ++var6) {
            for(int var7 = 0; var7 <= 104; ++var7) {
               for(int var8 = 0; var8 <= 104; ++var8) {
                  short var45;
                  if((class56.field619[var6][var8][var7] & var2) != 0) {
                     var9 = var7;
                     var10 = var7;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class56.field619[var6][var8][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class56.field619[var6][var8][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label471:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class56.field619[var11 - 1][var8][var13] & var2) == 0) {
                              break label471;
                           }
                        }

                        --var11;
                     }

                     label460:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class56.field619[var12 + 1][var8][var13] & var2) == 0) {
                              break label460;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var8][var9] - var45;
                        var16 = class61.tileHeights[var11][var8][var9];
                        Region.addOcclude(var5, 1, var8 * 128, var8 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class56.field619[var17][var8][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if((class56.field619[var6][var8][var7] & var3) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var6;

                     for(var12 = var6; var9 > 0 && (class56.field619[var6][var9 - 1][var7] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class56.field619[var6][var10 + 1][var7] & var3) != 0) {
                        ++var10;
                     }

                     label524:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class56.field619[var11 - 1][var13][var7] & var3) == 0) {
                              break label524;
                           }
                        }

                        --var11;
                     }

                     label513:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if((class56.field619[var12 + 1][var13][var7] & var3) == 0) {
                              break label513;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
                     if(var13 >= 8) {
                        var45 = 240;
                        var15 = class61.tileHeights[var12][var9][var7] - var45;
                        var16 = class61.tileHeights[var11][var9][var7];
                        Region.addOcclude(var5, 2, var9 * 128, var10 * 128 + 128, var7 * 128, var7 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class56.field619[var17][var18][var7] &= ~var3;
                           }
                        }
                     }
                  }

                  if((class56.field619[var6][var8][var7] & var4) != 0) {
                     var9 = var8;
                     var10 = var8;
                     var11 = var7;

                     for(var12 = var7; var11 > 0 && (class56.field619[var6][var8][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class56.field619[var6][var8][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label577:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class56.field619[var6][var9 - 1][var13] & var4) == 0) {
                              break label577;
                           }
                        }

                        --var9;
                     }

                     label566:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if((class56.field619[var6][var10 + 1][var13] & var4) == 0) {
                              break label566;
                           }
                        }

                        ++var10;
                     }

                     if((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = class61.tileHeights[var6][var9][var11];
                        Region.addOcclude(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class56.field619[var6][var14][var15] &= ~var4;
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
