import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class34 {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static final Coordinates field482;
   @ObfuscatedName("ez")
   @ObfuscatedSignature(
      signature = "Ley;"
   )
   static Task field496;
   @ObfuscatedName("o")
   List field481;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkn;"
   )
   SpritePixels field491;
   @ObfuscatedName("u")
   int[][] field490;
   @ObfuscatedName("v")
   LinkedList field487;
   @ObfuscatedName("l")
   HashMap field485;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lx;"
   )
   class22 field486;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1031326915
   )
   int field484;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -947220285
   )
   int field489;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1302299117
   )
   int field493;
   @ObfuscatedName("h")
   final HashMap field488;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2079020345
   )
   int field492;

   static {
      field482 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field484 = var1;
      this.field492 = var2;
      this.field487 = new LinkedList();
      this.field481 = new LinkedList();
      this.field485 = new HashMap();
      this.field493 = var3 | -16777216;
      this.field488 = var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "42"
   )
   boolean method362(int var1) {
      if(this.field491 != null && this.field489 == var1) {
         return false;
      } else {
         this.field489 = var1;
         this.field491 = new SpritePixels(this.field489 * 64, this.field489 * 64);
         return true;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IILau;S)V",
      garbageValue = "255"
   )
   void method375(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field407; ++var4) {
         class31[] var5 = var3.field412[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               if(Preferences.method1607(var8.field445)) {
                  ObjectComposition var9 = WorldMapType1.getObjectDefinition(var8.field448);
                  int var10 = var9.field3435 != 0?-3407872:-3355444;
                  if(var8.field445 == class222.field2801.field2804) {
                     this.method392(var1, var2, var8.field446, var10);
                  }

                  if(var8.field445 == class222.field2783.field2804) {
                     this.method392(var1, var2, var8.field446, -3355444);
                     this.method392(var1, var2, var8.field446 + 1, var10);
                  }

                  if(var8.field445 == class222.field2792.field2804) {
                     if(var8.field446 == 0) {
                        Rasterizer2D.method4982(this.field489 * var1, this.field489 * (63 - var2), 1, var10);
                     }

                     if(var8.field446 == 1) {
                        Rasterizer2D.method4982(this.field489 * var1 + this.field489 - 1, this.field489 * (63 - var2), 1, var10);
                     }

                     if(var8.field446 == 2) {
                        Rasterizer2D.method4982(this.field489 + this.field489 * var1 - 1, this.field489 * (63 - var2) + this.field489 - 1, 1, var10);
                     }

                     if(var8.field446 == 3) {
                        Rasterizer2D.method4982(this.field489 * var1, this.field489 * (63 - var2) + this.field489 - 1, 1, var10);
                     }
                  }

                  if(var8.field445 == class222.field2785.field2804) {
                     int var11 = var8.field446 % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field489; ++var12) {
                           Rasterizer2D.method4982(this.field489 * var1 + var12, (64 - var2) * this.field489 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field489; ++var12) {
                           Rasterizer2D.method4982(var12 + this.field489 * var1, var12 + this.field489 * (63 - var2), 1, var10);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-2102627657"
   )
   void method465(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field485.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var9.worldX * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field532 = var10;
            var12.field533 = var11;
            Area var13 = Area.field3276[var12.field534];
            if(!var3.contains(Integer.valueOf(var13.method4293()))) {
               this.method379(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lio;I)Lax;",
      garbageValue = "1819856518"
   )
   class33 method389(Area var1) {
      if(var1.name != null && this.field488 != null && this.field488.get(class24.field358) != null) {
         class24 var2 = class24.method177(var1.field3284);
         if(var2 == null) {
            return null;
         } else {
            Font var3 = (Font)this.field488.get(var2);
            if(var3 == null) {
               return null;
            } else {
               int var4 = var3.method4774(var1.name, 1000000);
               String[] var5 = new String[var4];
               var3.method4777(var1.name, (int[])null, var5);
               int var6 = var5.length * var3.verticalSpace / 2;
               int var7 = 0;
               String[] var8 = var5;

               for(int var9 = 0; var9 < var8.length; ++var9) {
                  String var10 = var8[var9];
                  int var11 = var3.method4771(var10);
                  if(var11 > var7) {
                     var7 = var11;
                  }
               }

               return new class33(var1.name, var7, var6, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILau;[Ljp;I)V",
      garbageValue = "-2024422738"
   )
   void method356(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field407; ++var5) {
         class31[] var6 = var3.field412[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(!DecorativeObject.method2934(var9.field445)) {
                  int var11 = var9.field445;
                  boolean var10 = var11 == class222.field2788.field2804;
                  if(!var10) {
                     continue;
                  }
               }

               ObjectComposition var12 = WorldMapType1.getObjectDefinition(var9.field448);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method5070(this.field489 * var1, this.field489 * (63 - var2), this.field489 * 2, this.field489 * 2);
                  } else {
                     var4[var12.mapSceneId].method5070(this.field489 * var1, this.field489 * (63 - var2), this.field489 * 2 + 1, this.field489 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lio;IIB)V",
      garbageValue = "-51"
   )
   void method380(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4294(false);
      if(var4 != null) {
         int var5 = this.method385(var4, var1.field3291);
         int var6 = this.method490(var4, var1.field3293);
         var4.method5143(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "1"
   )
   void method397(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field481.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field530.worldX % 64;
         int var9 = var7.field530.worldY % 64;
         var7.field532 = (int)((float)var1 + (float)var8 * var5);
         var7.field533 = (int)(var5 * (float)(63 - var9) + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.field534))) {
            this.method379(var7, var7.field532, var7.field533, var5);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILau;Lap;I)V",
      garbageValue = "1655399523"
   )
   void method422(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field408[0][var1][var2] - 1;
      int var6 = var3.field403[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method4973(this.field489 * var1, this.field489 * (63 - var2), this.field489, this.field489, this.field493);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class266.method4861(var6, this.field493);
      }

      if(var6 > -1 && var3.field410[0][var1][var2] == 0) {
         Rasterizer2D.method4973(this.field489 * var1, this.field489 * (63 - var2), this.field489, this.field489, var7);
      } else {
         int var8 = this.method488(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method4973(this.field489 * var1, this.field489 * (63 - var2), this.field489, this.field489, var8);
         } else {
            var4.method658(this.field489 * var1, this.field489 * (63 - var2), var8, var7, this.field489, this.field489, var3.field410[0][var1][var2], var3.field413[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lkn;Lij;I)I",
      garbageValue = "-1193011897"
   )
   int method385(SpritePixels var1, class258 var2) {
      switch(var2.field3538) {
      case 1:
         return -var1.width / 2;
      case 2:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-94"
   )
   int method393(int var1, int var2) {
      if(this.field486 != null) {
         return this.field486.method228(var1, var2);
      } else {
         if(!this.field487.isEmpty()) {
            Iterator var3 = this.field487.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method626(var1, var2)) {
                  return var4.method228(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILau;Lap;[Ljp;B)V",
      garbageValue = "1"
   )
   void method365(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method375(var1, var2, var3);
      this.method356(var1, var2, var3, var5);
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(Lad;Lio;IIFI)V",
      garbageValue = "2001589627"
   )
   void method381(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field531 != null) {
         if(var1.field531.field477.method180(var5)) {
            Font var6 = (Font)this.field488.get(var1.field531.field477);
            var6.method4780(var1.field531.field471, var3 - var1.field531.field470 / 2, var4, var1.field531.field470, var1.field531.field478, -16777216 | var2.field3283, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "1705628388"
   )
   void method377(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field481.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.field3276[var5.field534];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4293()))) {
            this.method448(var6, var5.field532, var5.field533, var2, var3);
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIILau;I)V",
      garbageValue = "-187944078"
   )
   void method357(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label57:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field407; ++var9) {
               class31[] var10 = var5.field412[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method480(var13.field448);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field484 * 64 + var6, this.field492 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field486 != null) {
                           var16 = new Coordinates(this.field486.field402 + var9, this.field486.field411 * 64 + var6, var7 + this.field486.field409 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field402, var17.field411 * 64 + var6 + var17.method653() * 8, var7 + var17.field409 * 64 + var17.method628() * 8);
                        }

                        class39 var18 = new class39(var14.field3297, var16, var15, this.method389(var14));
                        this.field485.put(var8, var18);
                        continue label57;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "-971806700"
   )
   void method358(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field369.worldX >> 6 == this.field484 && var3.field369.worldY >> 6 == this.field492) {
            class39 var4 = new class39(var3.field368, var3.field369, var3.field369, this.method382(var3.field368));
            this.field481.add(var4);
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Laz;I)Z",
      garbageValue = "-1127047539"
   )
   boolean method368(class34[] var1) {
      if(this.field490 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field486 != null) {
            this.method432(0, 0, 64, 64, this.field486, var2);
         } else {
            Iterator var3 = this.field487.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method432(var4.method644() * 8, var4.method630() * 8, 8, 8, var4, var2);
            }
         }

         this.method370(var1, var2);
         this.method369(var2);
         return true;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IILau;I)V",
      garbageValue = "990230250"
   )
   void method384(int var1, int var2, class28 var3) {
      field482.method3934(0, var1, var2);

      for(int var4 = 0; var4 < var3.field407; ++var4) {
         class31[] var5 = var3.field412[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method480(var8.field448);
               if(var9 != null) {
                  class39 var10 = (class39)this.field485.get(field482);
                  if(var10 != null) {
                     if(var9.field3297 != var10.field534) {
                        class39 var16 = new class39(var9.field3297, var10.field528, var10.field530, this.method389(var9));
                        this.field485.put(new Coordinates(field482), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field528.plane - var10.field530.plane;
                     var10.field530.plane = var4;
                     var10.field528.plane = var4 + var15;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field484 * 64 + var1, this.field492 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field486 != null) {
                     var12 = new Coordinates(this.field486.field402 + var4, this.field486.field411 * 64 + var1, var2 + this.field486.field409 * 64);
                  } else {
                     Iterator var13 = this.field487.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method626(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field402, var14.field411 * 64 + var1 + var14.method653() * 8, var14.field409 * 64 + var2 + var14.method628() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3297, var12, var11, this.method389(var9));
                     this.field485.put(new Coordinates(field482), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field485.remove(field482);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IILau;Lap;I)V",
      garbageValue = "-1126683851"
   )
   void method415(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field407; ++var5) {
         int var6 = var3.field403[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class266.method4861(var6, this.field493);
            if(var3.field410[var5][var1][var2] == 0) {
               Rasterizer2D.method4973(this.field489 * var1, this.field489 * (63 - var2), this.field489, this.field489, var7);
            } else {
               var4.method658(this.field489 * var1, this.field489 * (63 - var2), 0, var7, this.field489, this.field489, var3.field410[var5][var1][var2], var3.field413[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lkn;Liy;I)I",
      garbageValue = "1986836074"
   )
   int method490(SpritePixels var1, class240 var2) {
      switch(var2.field3257) {
      case 1:
         return 0;
      case 2:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIILau;Laq;S)V",
      garbageValue = "-30430"
   )
   void method432(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field408[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = method493(var9);
               var6.method611(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILau;I)I",
      garbageValue = "-2063579609"
   )
   int method488(int var1, int var2, class28 var3) {
      return var3.field408[0][var1][var2] == 0?this.field493:this.field490[var1][var2];
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([Laz;Laq;B)V",
      garbageValue = "-33"
   )
   void method370(class34[] var1, class43 var2) {
      class229[] var3 = new class229[]{class229.field3130, class229.field3132, class229.field3124, class229.field3126, class229.field3131, class229.field3125, class229.field3127, class229.field3129};
      class229[] var5 = var3;

      for(int var6 = 0; var6 < var5.length; ++var6) {
         class229 var7 = var5[var6];
         if(var1[var7.rsOrdinal()] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch(var7.field3128) {
            case 0:
               var12 = 59;
               var10 = 5;
               break;
            case 1:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
               break;
            case 2:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 3:
               var13 = 59;
               var11 = 5;
               break;
            case 4:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 5:
               var9 = 59;
               var11 = 5;
               break;
            case 6:
               var8 = 59;
               var10 = 5;
               break;
            case 7:
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
            }

            this.method372(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(II)Lio;",
      garbageValue = "-917339696"
   )
   Area method480(int var1) {
      ObjectComposition var2 = WorldMapType1.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.field3276[var2.mapIconId]:null;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Laq;B)V",
      garbageValue = "-93"
   )
   void method369(class43 var1) {
      this.field490 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field490[var2][var3] = var1.method609(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lap;[Laz;[Ljp;I)V",
      garbageValue = "-1465495626"
   )
   void method363(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method422(var4, var5, this.field486, var1);
            this.method415(var4, var5, this.field486, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method365(var4, var5, this.field486, var1, var3);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lap;[Ljp;I)V",
      garbageValue = "1186480797"
   )
   void method364(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field487.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method644() * 8; var5 < var4.method644() * 8 + 8; ++var5) {
            for(var6 = var4.method630() * 8; var6 < var4.method630() * 8 + 8; ++var6) {
               this.method422(var5, var6, var4, var1);
               this.method415(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field487.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method644() * 8; var5 < var4.method644() * 8 + 8; ++var5) {
            for(var6 = var4.method630() * 8; var6 < var4.method630() * 8 + 8; ++var6) {
               this.method365(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "655986001"
   )
   List method391() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field481);
      var1.addAll(this.field485.values());
      return var1;
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lio;IIIII)V",
      garbageValue = "402364225"
   )
   void method448(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4294(false);
      if(var6 != null) {
         var6.method5143(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method4971(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method4971(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(II)Lax;",
      garbageValue = "-975611193"
   )
   class33 method382(int var1) {
      Area var2 = Area.field3276[var1];
      return this.method389(var2);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1567805995"
   )
   void method383() {
      if(this.field486 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method384(var1, var2, this.field486);
            }
         }
      } else {
         Iterator var5 = this.field487.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method644() * 8; var3 < var6.method644() * 8 + 8; ++var3) {
               for(int var4 = var6.method630() * 8; var4 < var6.method630() * 8 + 8; ++var4) {
                  this.method384(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lad;IIFI)V",
      garbageValue = "-1337050906"
   )
   void method379(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.field3276[var1.field534];
      this.method380(var5, var2, var3);
      this.method381(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "-99"
   )
   void method361(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field485.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field534))) {
            Area var6 = Area.field3276[var5.field534];
            this.method448(var6, var5.field532, var5.field533, var2, var3);
         }
      }

      this.method377(var1, var2, var3);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "146054281"
   )
   void method392(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method4984(this.field489 * var1, this.field489 * (63 - var2), this.field489, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method4982(this.field489 * var1, this.field489 * (63 - var2), this.field489, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method4984(this.field489 * var1 + this.field489 - 1, this.field489 * (63 - var2), this.field489, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method4982(this.field489 * var1, this.field489 + this.field489 * (63 - var2) - 1, this.field489, var4);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "-1468058596"
   )
   void method360(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method465(var1, var2, var4, var3);
      this.method397(var1, var2, var4, var3);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "64993158"
   )
   List method390(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field485.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method529(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field481.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method529(var4, var5)) {
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILap;[Laz;[Ljp;B)Z",
      garbageValue = "40"
   )
   boolean method359(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method362(var1)) {
         return false;
      } else if(this.field486 == null && this.field487.isEmpty()) {
         return false;
      } else {
         this.method368(var3);
         this.field491.method5091();
         if(this.field486 != null) {
            this.method363(var2, var3, var4);
         } else {
            this.method364(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIIIILaz;Laq;B)V",
      garbageValue = "103"
   )
   void method372(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method393(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = method493(var11);
               var8.method611(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1655920059"
   )
   void method354(int var1, int var2, int var3) {
      if(this.field491 != null) {
         if(var3 == this.field489 * 64) {
            this.field491.method5098(var1, var2);
         } else {
            this.field491.method5147(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lx;Ljava/util/List;I)V",
      garbageValue = "-819541955"
   )
   void method425(class22 var1, List var2) {
      this.field485.clear();
      this.field486 = var1;
      this.method357(0, 0, 64, 64, this.field486);
      this.method358(var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;B)V",
      garbageValue = "-59"
   )
   void method374(HashSet var1, List var2) {
      this.field485.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method237() == this.field484 && var4.method229() == this.field492) {
            this.field487.add(var4);
            this.method357(var4.method644() * 8, var4.method630() * 8, 8, 8, var4);
         }
      }

      this.method358(var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgw;III)I",
      garbageValue = "19136824"
   )
   static int method494(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lif;",
      garbageValue = "1450334518"
   )
   public static FloorUnderlayDefinition method493(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2139296136"
   )
   static final int method491(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + var2 * (var2 * var2 * 15731 + 789221) & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1253996028"
   )
   static final void method462() {
      Client.secretPacketBuffer1.putOpcode(183);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3549(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3556()) {
         if(var0.owner == 0 || var0.owner == 3) {
            class18.method141(var0, true);
         }
      }

      if(Client.field1066 != null) {
         class255.method4531(Client.field1066);
         Client.field1066 = null;
      }

   }
}
