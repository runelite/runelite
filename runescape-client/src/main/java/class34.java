import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Map.Entry;

@ObfuscatedName("ap")
public class class34 {
   @ObfuscatedName("ou")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   static class115 field457;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lhc;"
   )
   static final Coordinates field444;
   @ObfuscatedName("ap")
   static Image field461;
   @ObfuscatedName("cq")
   static boolean field455;
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "[Lks;"
   )
   @Export("mapMarkers")
   static SpritePixels[] mapMarkers;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 966328813
   )
   int field442;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 598814345
   )
   int field445;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   SceneComposition field446;
   @ObfuscatedName("t")
   LinkedList field447;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1385677737
   )
   int field448;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1156204753
   )
   int field449;
   @ObfuscatedName("j")
   int[][] field450;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lks;"
   )
   SpritePixels field451;
   @ObfuscatedName("c")
   List field452;
   @ObfuscatedName("s")
   HashMap field453;
   @ObfuscatedName("n")
   final HashMap field460;

   static {
      field444 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field442 = var1;
      this.field445 = var2;
      this.field447 = new LinkedList();
      this.field452 = new LinkedList();
      this.field453 = new HashMap();
      this.field448 = var3 | -16777216;
      this.field460 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "337638075"
   )
   void method377(int var1, int var2, int var3) {
      if(this.field451 != null) {
         if(var3 == this.field449 * 64) {
            this.field451.method5203(var1, var2);
         } else {
            this.field451.method5220(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lh;Ljava/util/List;I)V",
      garbageValue = "840275908"
   )
   void method348(SceneComposition var1, List var2) {
      this.field453.clear();
      this.field446 = var1;
      this.method419(0, 0, 64, 64, this.field446);
      this.method351(var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;B)V",
      garbageValue = "1"
   )
   void method363(HashSet var1, List var2) {
      this.field453.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         SceneMetadata var4 = (SceneMetadata)var3.next();
         if(var4.method227() == this.field442 && var4.method228() == this.field445) {
            this.field447.add(var4);
            this.method419(var4.method634() * 8, var4.method635() * 8, 8, 8, var4);
         }
      }

      this.method351(var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIILag;I)V",
      garbageValue = "-1585101609"
   )
   void method419(int var1, int var2, int var3, int var4, AbstractScene var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label56:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field378; ++var9) {
               SceneMapObj[] var10 = var5.field384[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  SceneMapObj[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     SceneMapObj var13 = var11[var12];
                     Area var14 = this.method379(var13.objectId);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field442 * 64 + var6, this.field445 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field446 != null) {
                           var16 = new Coordinates(this.field446.field377 + var9, var6 + this.field446.field383 * 64, var7 + this.field446.field374 * 64);
                        } else {
                           SceneMetadata var17 = (SceneMetadata)var5;
                           var16 = new Coordinates(var9 + var17.field377, var6 + var17.field383 * 64 + var17.method629() * 8, var7 + var17.field374 * 64 + var17.method653() * 8);
                        }

                        AreaMapIconMetadata var18 = new AreaMapIconMetadata(var14.field3395, var16, var15, this.method398(var14));
                        this.field453.put(var8, var18);
                        continue label56;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "-183430216"
   )
   void method351(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field345.worldX >> 6 == this.field442 && var3.field345.worldY >> 6 == this.field445) {
            AreaMapIconMetadata var4 = new AreaMapIconMetadata(var3.field346, var3.field345, var3.field345, this.method380(var3.field346));
            this.field452.add(var4);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILam;[Lap;[Lkg;I)Z",
      garbageValue = "-1517233173"
   )
   boolean method352(int var1, SceneChunkMetadata var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method355(var1)) {
         return false;
      } else if(this.field446 == null && this.field447.isEmpty()) {
         return false;
      } else {
         this.method361(var3);
         this.field451.method5196();
         if(this.field446 != null) {
            this.method356(var2, var3, var4);
         } else {
            this.method471(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "176655033"
   )
   void method476(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method369(var1, var2, var4, var3);
      this.method424(var1, var2, var4, var3);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "1153273062"
   )
   void method354(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field453.values().iterator();

      while(var4.hasNext()) {
         AreaMapIconMetadata var5 = (AreaMapIconMetadata)var4.next();
         if(var1.contains(Integer.valueOf(var5.field499))) {
            Area var6 = Area.mapAreaType[var5.field499];
            this.method371(var6, var5.field503, var5.field497, var2, var3);
         }
      }

      this.method441(var1, var2, var3);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "126"
   )
   boolean method355(int var1) {
      if(this.field451 != null && this.field449 == var1) {
         return false;
      } else {
         this.field449 = var1;
         this.field451 = new SpritePixels(this.field449 * 64, this.field449 * 64);
         return true;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lam;[Lap;[Lkg;I)V",
      garbageValue = "-1794658498"
   )
   void method356(SceneChunkMetadata var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method359(var4, var5, this.field446, var1);
            this.method360(var4, var5, this.field446, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method358(var4, var5, this.field446, var1, var3);
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lam;[Lkg;B)V",
      garbageValue = "-32"
   )
   void method471(SceneChunkMetadata var1, IndexedSprite[] var2) {
      Iterator var3 = this.field447.iterator();

      SceneMetadata var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (SceneMetadata)var3.next();

         for(var5 = var4.method634() * 8; var5 < var4.method634() * 8 + 8; ++var5) {
            for(var6 = var4.method635() * 8; var6 < var4.method635() * 8 + 8; ++var6) {
               this.method359(var5, var6, var4, var1);
               this.method360(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field447.iterator();

      while(var3.hasNext()) {
         var4 = (SceneMetadata)var3.next();

         for(var5 = var4.method634() * 8; var5 < var4.method634() * 8 + 8; ++var5) {
            for(var6 = var4.method635() * 8; var6 < var4.method635() * 8 + 8; ++var6) {
               this.method358(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IILag;Lam;[Lkg;I)V",
      garbageValue = "-430039813"
   )
   void method358(int var1, int var2, AbstractScene var3, SceneChunkMetadata var4, IndexedSprite[] var5) {
      this.method472(var1, var2, var3);
      this.method367(var1, var2, var3, var5);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IILag;Lam;I)V",
      garbageValue = "1884661279"
   )
   void method359(int var1, int var2, AbstractScene var3, SceneChunkMetadata var4) {
      int var5 = var3.field379[0][var1][var2] - 1;
      int var6 = var3.field375[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field449 * var1, this.field449 * (63 - var2), this.field449, this.field449, this.field448);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class2.method4(var6, this.field448);
      }

      if(var6 > -1 && var3.field381[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.field449 * var1, this.field449 * (63 - var2), this.field449, this.field449, var7);
      } else {
         int var8 = this.method366(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.field449 * var1, this.field449 * (63 - var2), this.field449, this.field449, var8);
         } else {
            var4.method660(this.field449 * var1, this.field449 * (63 - var2), var8, var7, this.field449, this.field449, var3.field381[0][var1][var2], var3.field382[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILag;Lam;I)V",
      garbageValue = "-742305206"
   )
   void method360(int var1, int var2, AbstractScene var3, SceneChunkMetadata var4) {
      for(int var5 = 1; var5 < var3.field378; ++var5) {
         int var6 = var3.field375[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class2.method4(var6, this.field448);
            if(var3.field381[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.field449 * var1, this.field449 * (63 - var2), this.field449, this.field449, var7);
            } else {
               var4.method660(this.field449 * var1, this.field449 * (63 - var2), 0, var7, this.field449, this.field449, var3.field381[var5][var1][var2], var3.field382[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([Lap;B)Z",
      garbageValue = "-39"
   )
   boolean method361(class34[] var1) {
      if(this.field450 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field446 != null) {
            this.method364(0, 0, 64, 64, this.field446, var2);
         } else {
            Iterator var3 = this.field447.iterator();

            while(var3.hasNext()) {
               SceneMetadata var4 = (SceneMetadata)var3.next();
               this.method364(var4.method634() * 8, var4.method635() * 8, 8, 8, var4, var2);
            }
         }

         this.method481(var1, var2);
         this.method403(var2);
         return true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Laz;I)V",
      garbageValue = "1471305325"
   )
   void method403(class43 var1) {
      this.field450 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field450[var2][var3] = var1.method612(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([Lap;Laz;I)V",
      garbageValue = "-1221401578"
   )
   void method481(class34[] var1, class43 var2) {
      class239[] var3 = RSInputSocket.method2967();
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
            switch(var6.field3255) {
            case 0:
               var11 = 59;
               var12 = 59;
               var9 = 5;
               var10 = 5;
               break;
            case 1:
               var12 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 2:
               var8 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 3:
               var7 = 59;
               var9 = 5;
               break;
            case 4:
               var8 = 59;
               var10 = 5;
               break;
            case 5:
               var12 = 59;
               var10 = 5;
               break;
            case 6:
               var11 = 59;
               var9 = 5;
               break;
            case 7:
               var8 = 59;
               var10 = 5;
               var11 = 59;
               var9 = 5;
            }

            this.method474(var11, var12, var7, var8, var9, var10, var1[var6.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIILag;Laz;B)V",
      garbageValue = "60"
   )
   void method364(int var1, int var2, int var3, int var4, AbstractScene var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field379[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class225.getUnderlayDefinition(var9);
               var6.method610(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIILap;Laz;B)V",
      garbageValue = "-41"
   )
   void method474(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method385(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class225.getUnderlayDefinition(var11);
               var8.method610(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IILag;I)I",
      garbageValue = "2052494500"
   )
   int method366(int var1, int var2, AbstractScene var3) {
      return var3.field379[0][var1][var2] == 0?this.field448:this.field450[var1][var2];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILag;[Lkg;B)V",
      garbageValue = "-5"
   )
   void method367(int var1, int var2, AbstractScene var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field378; ++var5) {
         SceneMapObj[] var6 = var3.field384[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            SceneMapObj[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               SceneMapObj var9 = var7[var8];
               int var11 = var9.field412;
               boolean var10 = var11 >= class232.field2938.field2941 && var11 <= class232.field2939.field2941;
               if(var10 || GrandExchangeEvents.method69(var9.field412)) {
                  ObjectComposition var12 = CacheFile.getObjectDefinition(var9.objectId);
                  if(var12.mapSceneId != -1) {
                     if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                        var4[var12.mapSceneId].method5189(this.field449 * var1, this.field449 * (63 - var2), this.field449 * 2, this.field449 * 2);
                     } else {
                        var4[var12.mapSceneId].method5189(this.field449 * var1, this.field449 * (63 - var2), this.field449 * 2 + 1, this.field449 * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IILag;I)V",
      garbageValue = "793640165"
   )
   void method472(int var1, int var2, AbstractScene var3) {
      for(int var4 = 0; var4 < var3.field378; ++var4) {
         SceneMapObj[] var5 = var3.field384[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            SceneMapObj[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               SceneMapObj var8 = var6[var7];
               int var10 = var8.field412;
               boolean var9 = var10 >= class232.field2923.field2941 && var10 <= class232.field2918.field2941 || var10 == class232.field2929.field2941;
               if(var9) {
                  ObjectComposition var11 = CacheFile.getObjectDefinition(var8.objectId);
                  int var12 = var11.int1 != 0?-3407872:-3355444;
                  if(var8.field412 == class232.field2923.field2941) {
                     this.method350(var1, var2, var8.field414, var12);
                  }

                  if(var8.field412 == class232.field2920.field2941) {
                     this.method350(var1, var2, var8.field414, -3355444);
                     this.method350(var1, var2, var8.field414 + 1, var12);
                  }

                  if(var8.field412 == class232.field2918.field2941) {
                     if(var8.field414 == 0) {
                        Rasterizer2D.method5098(this.field449 * var1, this.field449 * (63 - var2), 1, var12);
                     }

                     if(var8.field414 == 1) {
                        Rasterizer2D.method5098(this.field449 + this.field449 * var1 - 1, this.field449 * (63 - var2), 1, var12);
                     }

                     if(var8.field414 == 2) {
                        Rasterizer2D.method5098(this.field449 * var1 + this.field449 - 1, this.field449 * (63 - var2) + this.field449 - 1, 1, var12);
                     }

                     if(var8.field414 == 3) {
                        Rasterizer2D.method5098(this.field449 * var1, this.field449 * (63 - var2) + this.field449 - 1, 1, var12);
                     }
                  }

                  if(var8.field412 == class232.field2929.field2941) {
                     int var13 = var8.field414 % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.field449; ++var14) {
                           Rasterizer2D.method5098(var14 + this.field449 * var1, (64 - var2) * this.field449 - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.field449; ++var14) {
                           Rasterizer2D.method5098(var14 + this.field449 * var1, var14 + this.field449 * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-577797974"
   )
   void method369(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field453.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)(var5 * (float)var9.worldX + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         AreaMapIconMetadata var12 = (AreaMapIconMetadata)var8.getValue();
         if(var12 != null) {
            var12.field503 = var10;
            var12.field497 = var11;
            Area var13 = Area.mapAreaType[var12.field499];
            if(!var3.contains(Integer.valueOf(var13.method4443()))) {
               this.method372(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "1"
   )
   void method441(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field452.iterator();

      while(var4.hasNext()) {
         AreaMapIconMetadata var5 = (AreaMapIconMetadata)var4.next();
         Area var6 = Area.mapAreaType[var5.field499];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4443()))) {
            this.method371(var6, var5.field503, var5.field497, var2, var3);
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lif;IIIII)V",
      garbageValue = "-2029994135"
   )
   void method371(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.getMapIcon(false);
      if(var6 != null) {
         var6.drawAt(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5087(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5087(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lay;IIFI)V",
      garbageValue = "-1831412463"
   )
   void method372(AreaMapIconMetadata var1, int var2, int var3, float var4) {
      Area var5 = Area.mapAreaType[var1.field499];
      this.method373(var5, var2, var3);
      this.method374(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lif;III)V",
      garbageValue = "128920924"
   )
   void method373(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.getMapIcon(false);
      if(var4 != null) {
         int var5 = this.method445(var4, var1.field3394);
         int var6 = this.method382(var4, var1.field3388);
         var4.drawAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lay;Lif;IIFB)V",
      garbageValue = "-48"
   )
   void method374(AreaMapIconMetadata var1, Area var2, int var3, int var4, float var5) {
      if(var1.field502 != null) {
         if(var1.field502.field433.method177(var5)) {
            Font var6 = (Font)this.field460.get(var1.field502.field433);
            var6.method4895(var1.field502.field432, var3 - var1.field502.field436 / 2, var4, var1.field502.field436, var1.field502.field434, -16777216 | var2.field3385, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-862812458"
   )
   void method424(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field452.iterator();

      while(var6.hasNext()) {
         AreaMapIconMetadata var7 = (AreaMapIconMetadata)var6.next();
         int var8 = var7.field498.worldX % 64;
         int var9 = var7.field498.worldY % 64;
         var7.field503 = (int)((float)var1 + var5 * (float)var8);
         var7.field497 = (int)((float)(63 - var9) * var5 + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.field499))) {
            this.method372(var7, var7.field503, var7.field497, var5);
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1400564860"
   )
   void method416() {
      if(this.field446 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method376(var1, var2, this.field446);
            }
         }
      } else {
         Iterator var5 = this.field447.iterator();

         while(var5.hasNext()) {
            SceneMetadata var6 = (SceneMetadata)var5.next();

            for(int var3 = var6.method634() * 8; var3 < var6.method634() * 8 + 8; ++var3) {
               for(int var4 = var6.method635() * 8; var4 < var6.method635() * 8 + 8; ++var4) {
                  this.method376(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(IILag;I)V",
      garbageValue = "-171167958"
   )
   void method376(int var1, int var2, AbstractScene var3) {
      field444.set(0, var1, var2);

      for(int var4 = 0; var4 < var3.field378; ++var4) {
         SceneMapObj[] var5 = var3.field384[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            SceneMapObj[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               SceneMapObj var8 = var6[var7];
               Area var9 = this.method379(var8.objectId);
               if(var9 != null) {
                  AreaMapIconMetadata var10 = (AreaMapIconMetadata)this.field453.get(field444);
                  if(var10 != null) {
                     if(var9.field3395 != var10.field499) {
                        AreaMapIconMetadata var16 = new AreaMapIconMetadata(var9.field3395, var10.field504, var10.field498, this.method398(var9));
                        this.field453.put(new Coordinates(field444), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field504.plane - var10.field498.plane;
                     var10.field498.plane = var4;
                     var10.field504.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field442 * 64 + var1, this.field445 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field446 != null) {
                     var12 = new Coordinates(this.field446.field377 + var4, this.field446.field383 * 64 + var1, var2 + this.field446.field374 * 64);
                  } else {
                     Iterator var13 = this.field447.iterator();

                     while(var13.hasNext()) {
                        SceneMetadata var14 = (SceneMetadata)var13.next();
                        if(var14.method631(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field377, var14.field383 * 64 + var1 + var14.method629() * 8, var14.field374 * 64 + var2 + var14.method653() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new AreaMapIconMetadata(var9.field3395, var12, var11, this.method398(var9));
                     this.field453.put(new Coordinates(field444), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field453.remove(field444);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(Lks;Ljr;I)I",
      garbageValue = "84864880"
   )
   int method445(SpritePixels var1, class268 var2) {
      switch(var2.field3616) {
      case 0:
         return 0;
      case 2:
         return -var1.width / 2;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lks;Lik;I)I",
      garbageValue = "-2043045149"
   )
   int method382(SpritePixels var1, class250 var2) {
      switch(var2.field3365) {
      case 1:
         return 0;
      case 2:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(II)Lif;",
      garbageValue = "-688017102"
   )
   Area method379(int var1) {
      ObjectComposition var2 = CacheFile.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.mapAreaType[var2.mapIconId]:null;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(II)Lat;",
      garbageValue = "-1006276580"
   )
   class33 method380(int var1) {
      Area var2 = Area.mapAreaType[var1];
      return this.method398(var2);
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Lif;I)Lat;",
      garbageValue = "939713809"
   )
   class33 method398(Area var1) {
      if(var1.name != null && this.field460 != null && this.field460.get(Size.field335) != null) {
         int var3 = var1.field3386;
         Size[] var4 = new Size[]{Size.field334, Size.field333, Size.field335};
         Size[] var5 = var4;
         int var6 = 0;

         Size var2;
         while(true) {
            if(var6 >= var5.length) {
               var2 = null;
               break;
            }

            Size var7 = var5[var6];
            if(var3 == var7.field337) {
               var2 = var7;
               break;
            }

            ++var6;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field460.get(var2);
            if(var14 == null) {
               return null;
            } else {
               var6 = var14.method4889(var1.name, 1000000);
               String[] var15 = new String[var6];
               var14.method4965(var1.name, (int[])null, var15);
               int var8 = var15.length * var14.verticalSpace / 2;
               int var9 = 0;
               String[] var10 = var15;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.method4886(var12);
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

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "610596748"
   )
   List method346(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field453.values().iterator();

            AreaMapIconMetadata var8;
            while(var7.hasNext()) {
               var8 = (AreaMapIconMetadata)var7.next();
               if(var8.method538(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field452.iterator();

            while(var7.hasNext()) {
               var8 = (AreaMapIconMetadata)var7.next();
               if(var8.method538(var4, var5)) {
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

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "1872711547"
   )
   List method383() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field452);
      var1.addAll(this.field453.values());
      return var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "324303748"
   )
   void method350(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5100(this.field449 * var1, this.field449 * (63 - var2), this.field449, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5098(this.field449 * var1, this.field449 * (63 - var2), this.field449, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5100(this.field449 * var1 + this.field449 - 1, this.field449 * (63 - var2), this.field449, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5098(this.field449 * var1, this.field449 * (63 - var2) + this.field449 - 1, this.field449, var4);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1230797235"
   )
   int method385(int var1, int var2) {
      if(this.field446 != null) {
         return this.field446.method222(var1, var2);
      } else {
         if(!this.field447.isEmpty()) {
            Iterator var3 = this.field447.iterator();

            while(var3.hasNext()) {
               SceneMetadata var4 = (SceneMetadata)var3.next();
               if(var4.method631(var1, var2)) {
                  return var4.method222(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-1691147509"
   )
   @Export("charToByteCp1252")
   public static byte charToByteCp1252(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
         var1 = -128;
      } else if(var0 == 8218) {
         var1 = -126;
      } else if(var0 == 402) {
         var1 = -125;
      } else if(var0 == 8222) {
         var1 = -124;
      } else if(var0 == 8230) {
         var1 = -123;
      } else if(var0 == 8224) {
         var1 = -122;
      } else if(var0 == 8225) {
         var1 = -121;
      } else if(var0 == 710) {
         var1 = -120;
      } else if(var0 == 8240) {
         var1 = -119;
      } else if(var0 == 352) {
         var1 = -118;
      } else if(var0 == 8249) {
         var1 = -117;
      } else if(var0 == 338) {
         var1 = -116;
      } else if(var0 == 381) {
         var1 = -114;
      } else if(var0 == 8216) {
         var1 = -111;
      } else if(var0 == 8217) {
         var1 = -110;
      } else if(var0 == 8220) {
         var1 = -109;
      } else if(var0 == 8221) {
         var1 = -108;
      } else if(var0 == 8226) {
         var1 = -107;
      } else if(var0 == 8211) {
         var1 = -106;
      } else if(var0 == 8212) {
         var1 = -105;
      } else if(var0 == 732) {
         var1 = -104;
      } else if(var0 == 8482) {
         var1 = -103;
      } else if(var0 == 353) {
         var1 = -102;
      } else if(var0 == 8250) {
         var1 = -101;
      } else if(var0 == 339) {
         var1 = -100;
      } else if(var0 == 382) {
         var1 = -98;
      } else if(var0 == 376) {
         var1 = -97;
      } else {
         var1 = 63;
      }

      return var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Lil;",
      garbageValue = "-1886242935"
   )
   public static BuildType method470(int var0) {
      BuildType[] var1 = WorldComparator.method55();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         BuildType var3 = var1[var2];
         if(var0 == var3.ordinal) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1693051046"
   )
   public static void method436() {
      try {
         class157.dat2File.close();

         for(int var0 = 0; var0 < class157.idxCount; ++var0) {
            class157.idxFiles[var0].close();
         }

         class157.idx255File.close();
         class157.randomDat.close();
      } catch (Exception var2) {
         ;
      }

   }
}
