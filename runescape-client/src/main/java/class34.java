import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("av")
public class class34 {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lht;"
   )
   static final Coordinates field466;
   @ObfuscatedName("jq")
   @ObfuscatedGetter(
      intValue = -1803688325
   )
   @Export("menuHeight")
   static int menuHeight;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -13336801
   )
   int field455;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1068917855
   )
   int field453;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   class22 field457;
   @ObfuscatedName("s")
   LinkedList field458;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1000309879
   )
   int field459;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1288865717
   )
   int field460;
   @ObfuscatedName("f")
   int[][] field468;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   SpritePixels field461;
   @ObfuscatedName("u")
   List field467;
   @ObfuscatedName("p")
   HashMap field456;
   @ObfuscatedName("w")
   final HashMap field462;

   static {
      field466 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field455 = var1;
      this.field453 = var2;
      this.field458 = new LinkedList();
      this.field467 = new LinkedList();
      this.field456 = new HashMap();
      this.field459 = var3 | -16777216;
      this.field462 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1420236991"
   )
   void method453(int var1, int var2, int var3) {
      if(this.field461 != null) {
         if(var3 == this.field460 * 64) {
            this.field461.method5287(var1, var2);
         } else {
            this.field461.method5297(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lg;Ljava/util/List;I)V",
      garbageValue = "-1428465268"
   )
   void method349(class22 var1, List var2) {
      this.field456.clear();
      this.field457 = var1;
      this.method351(0, 0, 64, 64, this.field457);
      this.method352(var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;B)V",
      garbageValue = "62"
   )
   void method350(HashSet var1, List var2) {
      this.field456.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method231() == this.field455 && var4.method214() == this.field453) {
            this.field458.add(var4);
            this.method351(var4.method630() * 8, var4.method640() * 8, 8, 8, var4);
         }
      }

      this.method352(var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIILat;I)V",
      garbageValue = "273971825"
   )
   void method351(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label57:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field393; ++var9) {
               class31[] var10 = var5.field398[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method387(var13.field422);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field455 * 64 + var6, this.field453 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field457 != null) {
                           var16 = new Coordinates(this.field457.field389 + var9, var6 + this.field457.field390 * 64, var7 + this.field457.field388 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field389, var6 + var17.field390 * 64 + var17.method644() * 8, var17.field388 * 64 + var7 + var17.method631() * 8);
                        }

                        class39 var18 = new class39(var14.field3384, var16, var15, this.method383(var14));
                        this.field456.put(var8, var18);
                        continue label57;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "-2110167718"
   )
   void method352(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field358.worldX >> 6 == this.field455 && var3.field358.worldY >> 6 == this.field453) {
            class39 var4 = new class39(var3.field356, var3.field358, var3.field358, this.method446(var3.field356));
            this.field467.add(var4);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILas;[Lav;[Lkm;I)Z",
      garbageValue = "-941681466"
   )
   boolean method353(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method442(var1)) {
         return false;
      } else if(this.field457 == null && this.field458.isEmpty()) {
         return false;
      } else {
         this.method362(var3);
         this.field461.method5273();
         if(this.field457 != null) {
            this.method392(var2, var3, var4);
         } else {
            this.method469(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;B)V",
      garbageValue = "0"
   )
   void method369(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method348(var1, var2, var4, var3);
      this.method376(var1, var2, var4, var3);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1098550783"
   )
   void method355(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field456.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field512))) {
            Area var6 = Area.mapAreaType[var5.field512];
            this.method372(var6, var5.field508, var5.field510, var2, var3);
         }
      }

      this.method417(var1, var2, var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1178670921"
   )
   boolean method442(int var1) {
      if(this.field461 != null && this.field460 == var1) {
         return false;
      } else {
         this.field460 = var1;
         this.field461 = new SpritePixels(this.field460 * 64, this.field460 * 64);
         return true;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Las;[Lav;[Lkm;I)V",
      garbageValue = "-1519876663"
   )
   void method392(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method401(var4, var5, this.field457, var1);
            this.method425(var4, var5, this.field457, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method381(var4, var5, this.field457, var1, var3);
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Las;[Lkm;I)V",
      garbageValue = "1658667857"
   )
   void method469(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field458.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method630() * 8; var5 < var4.method630() * 8 + 8; ++var5) {
            for(var6 = var4.method640() * 8; var6 < var4.method640() * 8 + 8; ++var6) {
               this.method401(var5, var6, var4, var1);
               this.method425(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field458.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method630() * 8; var5 < var4.method630() * 8 + 8; ++var5) {
            for(var6 = var4.method640() * 8; var6 < var4.method640() * 8 + 8; ++var6) {
               this.method381(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IILat;Las;[Lkm;I)V",
      garbageValue = "-2083568280"
   )
   void method381(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method379(var1, var2, var3);
      this.method368(var1, var2, var3, var5);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILat;Las;B)V",
      garbageValue = "-34"
   )
   void method401(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field394[0][var1][var2] - 1;
      int var6 = var3.field395[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field460 * var1, this.field460 * (63 - var2), this.field460, this.field460, this.field459);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class21.method153(var6, this.field459);
      }

      if(var6 > -1 && var3.field396[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field460 * var1, this.field460 * (63 - var2), this.field460, this.field460, var7);
      } else {
         int var8 = this.method367(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.field460 * var1, this.field460 * (63 - var2), this.field460, this.field460, var8);
         } else {
            var4.method657(this.field460 * var1, this.field460 * (63 - var2), var8, var7, this.field460, this.field460, var3.field396[0][var1][var2], var3.field397[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILat;Las;I)V",
      garbageValue = "-1894000986"
   )
   void method425(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field393; ++var5) {
         int var6 = var3.field395[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class21.method153(var6, this.field459);
            if(var3.field396[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.field460 * var1, this.field460 * (63 - var2), this.field460, this.field460, var7);
            } else {
               var4.method657(this.field460 * var1, this.field460 * (63 - var2), 0, var7, this.field460, this.field460, var3.field396[var5][var1][var2], var3.field397[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([Lav;B)Z",
      garbageValue = "13"
   )
   boolean method362(class34[] var1) {
      if(this.field468 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field457 != null) {
            this.method435(0, 0, 64, 64, this.field457, var2);
         } else {
            Iterator var3 = this.field458.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method435(var4.method630() * 8, var4.method640() * 8, 8, 8, var4, var2);
            }
         }

         this.method364(var1, var2);
         this.method377(var2);
         return true;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lay;I)V",
      garbageValue = "691548213"
   )
   void method377(class43 var1) {
      this.field468 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field468[var2][var3] = var1.method604(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Lav;Lay;I)V",
      garbageValue = "-1911378649"
   )
   void method364(class34[] var1, class43 var2) {
      class239[] var3 = Huffman.method3274();
      class239[] var4 = var3;

      for(int var5 = 0; var5 < var4.length; ++var5) {
         class239 var6 = var4[var5];
         if(var1[var6.rsOrdinal()] != null) {
            byte var7 = 0;
            byte var8 = 0;
            byte var9 = 64;
            byte var10 = 64;
            byte var11 = 0;
            byte var12 = 0;
            switch(var6.field3254) {
            case 0:
               var12 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 1:
               var11 = 59;
               var12 = 59;
               var9 = 5;
               var10 = 5;
               break;
            case 2:
               var12 = 59;
               var10 = 5;
               break;
            case 3:
               var8 = 59;
               var10 = 5;
               var11 = 59;
               var9 = 5;
               break;
            case 4:
               var11 = 59;
               var9 = 5;
               break;
            case 5:
               var7 = 59;
               var9 = 5;
               break;
            case 6:
               var8 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 7:
               var8 = 59;
               var10 = 5;
            }

            this.method366(var11, var12, var7, var8, var9, var10, var1[var6.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIILat;Lay;S)V",
      garbageValue = "11801"
   )
   void method435(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field394[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class72.getUnderlayDefinition(var9);
               var6.method610(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIILav;Lay;I)V",
      garbageValue = "-1776665210"
   )
   void method366(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method418(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class72.getUnderlayDefinition(var11);
               var8.method610(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IILat;I)I",
      garbageValue = "804913637"
   )
   int method367(int var1, int var2, class28 var3) {
      return var3.field394[0][var1][var2] == 0?this.field459:this.field468[var1][var2];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IILat;[Lkm;I)V",
      garbageValue = "-1793484695"
   )
   void method368(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field393; ++var5) {
         class31[] var6 = var3.field398[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(!LoginPacket.method3246(var9.field420)) {
                  int var11 = var9.field420;
                  boolean var10 = var11 == class232.field2942.field2943;
                  if(!var10) {
                     continue;
                  }
               }

               ObjectComposition var12 = NPC.getObjectDefinition(var9.field422);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method5255(this.field460 * var1, this.field460 * (63 - var2), this.field460 * 2, this.field460 * 2);
                  } else {
                     var4[var12.mapSceneId].method5255(this.field460 * var1, this.field460 * (63 - var2), this.field460 * 2 + 1, this.field460 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILat;I)V",
      garbageValue = "-828257076"
   )
   void method379(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field393; ++var4) {
         class31[] var5 = var3.field398[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               if(Spotanim.method4535(var8.field420)) {
                  ObjectComposition var9 = NPC.getObjectDefinition(var8.field422);
                  int var10 = var9.int1 != 0?-3407872:-3355444;
                  if(var8.field420 == class232.field2945.field2943) {
                     this.method386(var1, var2, var8.field421, var10);
                  }

                  if(var8.field420 == class232.field2929.field2943) {
                     this.method386(var1, var2, var8.field421, -3355444);
                     this.method386(var1, var2, var8.field421 + 1, var10);
                  }

                  if(var8.field420 == class232.field2938.field2943) {
                     if(var8.field421 == 0) {
                        Rasterizer2D.method5186(this.field460 * var1, this.field460 * (63 - var2), 1, var10);
                     }

                     if(var8.field421 == 1) {
                        Rasterizer2D.method5186(this.field460 + this.field460 * var1 - 1, this.field460 * (63 - var2), 1, var10);
                     }

                     if(var8.field421 == 2) {
                        Rasterizer2D.method5186(this.field460 * var1 + this.field460 - 1, this.field460 * (63 - var2) + this.field460 - 1, 1, var10);
                     }

                     if(var8.field421 == 3) {
                        Rasterizer2D.method5186(this.field460 * var1, this.field460 * (63 - var2) + this.field460 - 1, 1, var10);
                     }
                  }

                  if(var8.field420 == class232.field2936.field2943) {
                     int var11 = var8.field421 % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field460; ++var12) {
                           Rasterizer2D.method5186(var12 + this.field460 * var1, (64 - var2) * this.field460 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field460; ++var12) {
                           Rasterizer2D.method5186(var12 + this.field460 * var1, var12 + this.field460 * (63 - var2), 1, var10);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "-59"
   )
   void method348(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field456.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var1 + (float)var9.worldX * var5 - var6);
         int var11 = (int)((float)(var2 + var4) - (float)var9.worldY * var5 - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field508 = var10;
            var12.field510 = var11;
            Area var13 = Area.mapAreaType[var12.field512];
            if(!var3.contains(Integer.valueOf(var13.method4495()))) {
               this.method373(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-684116028"
   )
   void method417(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field467.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.mapAreaType[var5.field512];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4495()))) {
            this.method372(var6, var5.field508, var5.field510, var2, var3);
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lie;IIIII)V",
      garbageValue = "1631551856"
   )
   void method372(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.getMapIcon(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5158(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5158(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Laj;IIFB)V",
      garbageValue = "-72"
   )
   void method373(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.mapAreaType[var1.field512];
      this.method461(var5, var2, var3);
      this.method375(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lie;III)V",
      garbageValue = "462819465"
   )
   void method461(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.getMapIcon(false);
      if(var4 != null) {
         int var5 = this.method385(var4, var1.field3397);
         int var6 = this.method380(var4, var1.field3380);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Laj;Lie;IIFS)V",
      garbageValue = "-20610"
   )
   void method375(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field513 != null) {
         if(var1.field513.field449.method170(var5)) {
            Font var6 = (Font)this.field462.get(var1.field513.field449);
            var6.method4954(var1.field513.field446, var3 - var1.field513.field447 / 2, var4, var1.field513.field447, var1.field513.field450, -16777216 | var2.field3394, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IS)V",
      garbageValue = "31210"
   )
   void method376(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field467.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field514.worldX % 64;
         int var9 = var7.field514.worldY % 64;
         var7.field508 = (int)((float)var8 * var5 + (float)var1);
         var7.field510 = (int)(var5 * (float)(63 - var9) + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.field512))) {
            this.method373(var7, var7.field508, var7.field510, var5);
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1783321801"
   )
   void method409() {
      if(this.field457 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method378(var1, var2, this.field457);
            }
         }
      } else {
         Iterator var5 = this.field458.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method630() * 8; var3 < var6.method630() * 8 + 8; ++var3) {
               for(int var4 = var6.method640() * 8; var4 < var6.method640() * 8 + 8; ++var4) {
                  this.method378(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IILat;I)V",
      garbageValue = "-1122162081"
   )
   void method378(int var1, int var2, class28 var3) {
      field466.set(0, var1, var2);

      for(int var4 = 0; var4 < var3.field393; ++var4) {
         class31[] var5 = var3.field398[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method387(var8.field422);
               if(var9 != null) {
                  class39 var10 = (class39)this.field456.get(field466);
                  if(var10 != null) {
                     if(var9.field3384 != var10.field512) {
                        class39 var16 = new class39(var9.field3384, var10.field509, var10.field514, this.method383(var9));
                        this.field456.put(new Coordinates(field466), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field509.plane - var10.field514.plane;
                     var10.field514.plane = var4;
                     var10.field509.plane = var4 + var15;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field455 * 64 + var1, this.field453 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field457 != null) {
                     var12 = new Coordinates(this.field457.field389 + var4, this.field457.field390 * 64 + var1, var2 + this.field457.field388 * 64);
                  } else {
                     Iterator var13 = this.field458.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method629(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field389, var1 + var14.field390 * 64 + var14.method644() * 8, var14.field388 * 64 + var2 + var14.method631() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3384, var12, var11, this.method383(var9));
                     this.field456.put(new Coordinates(field466), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field456.remove(field466);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lkg;Ljt;B)I",
      garbageValue = "-113"
   )
   int method385(SpritePixels var1, class268 var2) {
      switch(var2.field3627) {
      case 0:
         return -var1.width / 2;
      case 2:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lkg;Liv;I)I",
      garbageValue = "504635152"
   )
   int method380(SpritePixels var1, class250 var2) {
      switch(var2.field3368) {
      case 1:
         return 0;
      case 2:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IB)Lie;",
      garbageValue = "1"
   )
   Area method387(int var1) {
      ObjectComposition var2 = NPC.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.mapAreaType[var2.mapIconId]:null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(II)Lae;",
      garbageValue = "-1886498268"
   )
   class33 method446(int var1) {
      Area var2 = Area.mapAreaType[var1];
      return this.method383(var2);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lie;B)Lae;",
      garbageValue = "15"
   )
   class33 method383(Area var1) {
      if(var1.name != null && this.field462 != null && this.field462.get(Size.field351) != null) {
         int var3 = var1.field3389;
         Size[] var4 = new Size[]{Size.field349, Size.field351, Size.field348};
         Size[] var5 = var4;
         int var6 = 0;

         Size var2;
         while(true) {
            if(var6 >= var5.length) {
               var2 = null;
               break;
            }

            Size var7 = var5[var6];
            if(var3 == var7.field352) {
               var2 = var7;
               break;
            }

            ++var6;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field462.get(var2);
            if(var14 == null) {
               return null;
            } else {
               var6 = var14.method5038(var1.name, 1000000);
               String[] var15 = new String[var6];
               var14.method4946(var1.name, (int[])null, var15);
               int var8 = var15.length * var14.verticalSpace / 2;
               int var9 = 0;
               String[] var10 = var15;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.getTextWidth(var12);
                  if(var13 > var9) {
                     var9 = var13;
                  }
               }

               return new class33(var1.name, var9, var8, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "-1087023153"
   )
   List method384(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field456.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method532(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field467.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method532(var4, var5)) {
                  var6.add(var8);
               }
            }

            return var6;
         } else {
            return var6;
         }
      } else {
         return var6;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/List;",
      garbageValue = "91"
   )
   List method374() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field467);
      var1.addAll(this.field456.values());
      return var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-93"
   )
   void method386(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5168(this.field460 * var1, this.field460 * (63 - var2), this.field460, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5186(this.field460 * var1, this.field460 * (63 - var2), this.field460, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5168(this.field460 + this.field460 * var1 - 1, this.field460 * (63 - var2), this.field460, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5186(this.field460 * var1, this.field460 * (63 - var2) + this.field460 - 1, this.field460, var4);
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "52"
   )
   int method418(int var1, int var2) {
      if(this.field457 != null) {
         return this.field457.method218(var1, var2);
      } else {
         if(!this.field458.isEmpty()) {
            Iterator var3 = this.field458.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method629(var1, var2)) {
                  return var4.method218(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Lgm;IB)Lgm;",
      garbageValue = "-81"
   )
   @Export("forOrdinal")
   public static Enumerated forOrdinal(Enumerated[] var0, int var1) {
      Enumerated[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Enumerated var4 = var2[var3];
         if(var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-1"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class37.listFetcher == null) {
            class37.listFetcher = Signlink.urlRequester.request(new URL(UnitPriceComparator.field303));
         } else if(class37.listFetcher.isDone()) {
            byte[] var0 = class37.listFetcher.getResponse();
            Buffer var1 = new Buffer(var0);
            var1.readInt();
            World.worldCount = var1.readUnsignedShort();
            World.worldList = new World[World.worldCount];

            World var3;
            for(int var2 = 0; var2 < World.worldCount; var3.index = var2++) {
               var3 = World.worldList[var2] = new World();
               var3.id = var1.readUnsignedShort();
               var3.mask = var1.readInt();
               var3.address = var1.readString();
               var3.activity = var1.readString();
               var3.location = var1.readUnsignedByte();
               var3.playerCount = var1.readShort();
            }

            GroundObject.method2558(World.worldList, 0, World.worldList.length - 1, World.field1224, World.field1223);
            class37.listFetcher = null;
            return true;
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class37.listFetcher = null;
      }

      return false;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Ljn;",
      garbageValue = "81"
   )
   public static Enum method487(int var0) {
      Enum var1 = (Enum)Enum.EnumDefinition_cached.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class228.EnumDefinition_indexCache.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Enum.EnumDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }
}
