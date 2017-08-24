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

@ObfuscatedName("at")
public class class34 {
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lhs;"
   )
   static final Coordinates field496;
   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("s")
   int[][] field491;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkd;"
   )
   SpritePixels field492;
   @ObfuscatedName("l")
   List field493;
   @ObfuscatedName("q")
   LinkedList field488;
   @ObfuscatedName("t")
   HashMap field494;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lh;"
   )
   class22 field487;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -513484547
   )
   int field485;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1174764905
   )
   int field490;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1991409247
   )
   int field489;
   @ObfuscatedName("y")
   final HashMap field495;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -217518915
   )
   int field500;

   static {
      field496 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field485 = var1;
      this.field500 = var2;
      this.field488 = new LinkedList();
      this.field493 = new LinkedList();
      this.field494 = new HashMap();
      this.field489 = var3 | -16777216;
      this.field495 = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "534806465"
   )
   boolean method393(int var1) {
      if(this.field492 != null && this.field490 == var1) {
         return false;
      } else {
         this.field490 = var1;
         this.field492 = new SpritePixels(this.field490 * 64, this.field490 * 64);
         return true;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IILal;I)V",
      garbageValue = "-1618146054"
   )
   void method515(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field419; ++var4) {
         class31[] var5 = var3.field424[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               if(RSSocket.method3080(var8.field448)) {
                  ObjectComposition var9 = GameObject.getObjectDefinition(var8.field450);
                  int var10 = var9.field3454 != 0?-3407872:-3355444;
                  if(var8.field448 == class222.field2819.field2842) {
                     this.method423(var1, var2, var8.field449, var10);
                  }

                  if(var8.field448 == class222.field2821.field2842) {
                     this.method423(var1, var2, var8.field449, -3355444);
                     this.method423(var1, var2, var8.field449 + 1, var10);
                  }

                  if(var8.field448 == class222.field2830.field2842) {
                     if(var8.field449 == 0) {
                        Rasterizer2D.method4884(this.field490 * var1, this.field490 * (63 - var2), 1, var10);
                     }

                     if(var8.field449 == 1) {
                        Rasterizer2D.method4884(this.field490 * var1 + this.field490 - 1, this.field490 * (63 - var2), 1, var10);
                     }

                     if(var8.field449 == 2) {
                        Rasterizer2D.method4884(this.field490 * var1 + this.field490 - 1, this.field490 * (63 - var2) + this.field490 - 1, 1, var10);
                     }

                     if(var8.field449 == 3) {
                        Rasterizer2D.method4884(this.field490 * var1, this.field490 * (63 - var2) + this.field490 - 1, 1, var10);
                     }
                  }

                  if(var8.field448 == class222.field2837.field2842) {
                     int var11 = var8.field449 % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field490; ++var12) {
                           Rasterizer2D.method4884(this.field490 * var1 + var12, (64 - var2) * this.field490 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field490; ++var12) {
                           Rasterizer2D.method4884(var12 + this.field490 * var1, var12 + this.field490 * (63 - var2), 1, var10);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "-117"
   )
   void method407(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field494.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var1 + var5 * (float)var9.worldX - var6);
         int var11 = (int)((float)(var2 + var4) - (float)var9.worldY * var5 - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field541 = var10;
            var12.field548 = var11;
            Area var13 = Area.field3294[var12.field543];
            if(!var3.contains(Integer.valueOf(var13.method4295()))) {
               this.method513(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(Lig;I)Laq;",
      garbageValue = "-229497126"
   )
   class33 method460(Area var1) {
      if(var1.name != null && this.field495 != null && this.field495.get(class24.field370) != null) {
         int var3 = var1.field3301;
         class24[] var4 = class24.method203();
         int var5 = 0;

         class24 var2;
         while(true) {
            if(var5 >= var4.length) {
               var2 = null;
               break;
            }

            class24 var6 = var4[var5];
            if(var3 == var6.field368) {
               var2 = var6;
               break;
            }

            ++var5;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field495.get(var2);
            if(var14 == null) {
               return null;
            } else {
               int var15 = var14.method4794(var1.name, 1000000);
               String[] var7 = new String[var15];
               var14.method4768(var1.name, (int[])null, var7);
               int var8 = var7.length * var14.verticalSpace / 2;
               int var9 = 0;
               String[] var10 = var7;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.method4775(var12);
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

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(Lig;III)V",
      garbageValue = "1420654"
   )
   void method411(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4302(false);
      if(var4 != null) {
         int var5 = this.method416(var4, var1.field3309);
         int var6 = this.method417(var4, var1.field3312);
         var4.method5019(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IILal;[Ljx;I)V",
      garbageValue = "2024221161"
   )
   void method440(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field419; ++var5) {
         class31[] var6 = var3.field424[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(!class22.method195(var9.field448)) {
                  int var11 = var9.field448;
                  boolean var10 = var11 == class222.field2841.field2842;
                  if(!var10) {
                     continue;
                  }
               }

               ObjectComposition var12 = GameObject.getObjectDefinition(var9.field450);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method4997(this.field490 * var1, this.field490 * (63 - var2), this.field490 * 2, this.field490 * 2);
                  } else {
                     var4[var12.mapSceneId].method4997(this.field490 * var1, this.field490 * (63 - var2), this.field490 * 2 + 1, 1 + this.field490 * 2);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-866383008"
   )
   void method413(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field493.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field552.worldX % 64;
         int var9 = var7.field552.worldY % 64;
         var7.field541 = (int)((float)var1 + (float)var8 * var5);
         var7.field548 = (int)(var5 * (float)(63 - var9) + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.field543))) {
            this.method513(var7, var7.field541, var7.field548, var5);
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IILal;Lak;I)V",
      garbageValue = "2017415241"
   )
   void method488(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field420[0][var1][var2] - 1;
      int var6 = var3.field418[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method4890(this.field490 * var1, this.field490 * (63 - var2), this.field490, this.field490, this.field489);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class31.method303(var6, this.field489);
      }

      if(var6 > -1 && var3.field421[0][var1][var2] == 0) {
         Rasterizer2D.method4890(this.field490 * var1, this.field490 * (63 - var2), this.field490, this.field490, var7);
      } else {
         int var8 = this.method404(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method4890(this.field490 * var1, this.field490 * (63 - var2), this.field490, this.field490, var8);
         } else {
            var4.method699(this.field490 * var1, this.field490 * (63 - var2), var8, var7, this.field490, this.field490, var3.field421[0][var1][var2], var3.field423[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lkd;Lia;S)I",
      garbageValue = "-13442"
   )
   int method416(SpritePixels var1, class258 var2) {
      switch(var2.field3542) {
      case 1:
         return 0;
      case 2:
         return -var1.width / 2;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1719671181"
   )
   int method424(int var1, int var2) {
      if(this.field487 != null) {
         return this.field487.method254(var1, var2);
      } else {
         if(!this.field488.isEmpty()) {
            Iterator var3 = this.field488.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method672(var1, var2)) {
                  return var4.method254(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lay;Lig;IIFB)V",
      garbageValue = "-33"
   )
   void method465(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field546 != null) {
         if(var1.field546.field474.method198(var5)) {
            Font var6 = (Font)this.field495.get(var1.field546.field474);
            var6.method4789(var1.field546.field475, var3 - var1.field546.field478 / 2, var4, var1.field546.field478, var1.field546.field476, -16777216 | var2.field3300, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IILal;Lak;[Ljx;B)V",
      garbageValue = "-76"
   )
   void method428(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method515(var1, var2, var3);
      this.method440(var1, var2, var3, var5);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-2146875151"
   )
   void method425(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field493.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.field3294[var5.field543];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4295()))) {
            this.method409(var6, var5.field541, var5.field548, var2, var3);
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIILal;S)V",
      garbageValue = "-9214"
   )
   void method388(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label55:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field419; ++var9) {
               class31[] var10 = var5.field424[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method390(var13.field450);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field485 * 64 + var6, this.field500 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field487 != null) {
                           var16 = new Coordinates(this.field487.field422 + var9, var6 + this.field487.field415 * 64, this.field487.field416 * 64 + var7);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field422, var17.field415 * 64 + var6 + var17.method674() * 8, var17.field416 * 64 + var7 + var17.method686() * 8);
                        }

                        class39 var18 = new class39(var14.field3296, var16, var15, this.method460(var14));
                        this.field494.put(var8, var18);
                        continue label55;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;B)V",
      garbageValue = "7"
   )
   void method450(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field378.worldX >> 6 == this.field485 && var3.field378.worldY >> 6 == this.field500) {
            class39 var4 = new class39(var3.field381, var3.field378, var3.field378, this.method427(var3.field381));
            this.field493.add(var4);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([Lat;I)Z",
      garbageValue = "-534691507"
   )
   boolean method472(class34[] var1) {
      if(this.field491 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field487 != null) {
            this.method402(0, 0, 64, 64, this.field487, var2);
         } else {
            Iterator var3 = this.field488.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method402(var4.method680() * 8, var4.method677() * 8, 8, 8, var4, var2);
            }
         }

         this.method384(var1, var2);
         this.method400(var2);
         return true;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(IILal;I)V",
      garbageValue = "2138074746"
   )
   void method507(int var1, int var2, class28 var3) {
      field496.method3972(0, var1, var2);

      for(int var4 = 0; var4 < var3.field419; ++var4) {
         class31[] var5 = var3.field424[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method390(var8.field450);
               if(var9 != null) {
                  class39 var10 = (class39)this.field494.get(field496);
                  if(var10 != null) {
                     if(var10.field543 != var9.field3296) {
                        class39 var16 = new class39(var9.field3296, var10.field542, var10.field552, this.method460(var9));
                        this.field494.put(new Coordinates(field496), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field542.plane - var10.field552.plane;
                     var10.field552.plane = var4;
                     var10.field542.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, var1 + this.field485 * 64, this.field500 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field487 != null) {
                     var12 = new Coordinates(this.field487.field422 + var4, this.field487.field415 * 64 + var1, var2 + this.field487.field416 * 64);
                  } else {
                     Iterator var13 = this.field488.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method672(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field422, var1 + var14.field415 * 64 + var14.method674() * 8, var14.field416 * 64 + var2 + var14.method686() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3296, var12, var11, this.method460(var9));
                     this.field494.put(new Coordinates(field496), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field494.remove(field496);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILal;Lak;I)V",
      garbageValue = "1313113216"
   )
   void method457(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field419; ++var5) {
         int var6 = var3.field418[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class31.method303(var6, this.field489);
            if(var3.field421[var5][var1][var2] == 0) {
               Rasterizer2D.method4890(this.field490 * var1, this.field490 * (63 - var2), this.field490, this.field490, var7);
            } else {
               var4.method699(this.field490 * var1, this.field490 * (63 - var2), 0, var7, this.field490, this.field490, var3.field421[var5][var1][var2], var3.field423[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(Lkd;Lio;I)I",
      garbageValue = "-1023330346"
   )
   int method417(SpritePixels var1, class240 var2) {
      switch(var2.field3276) {
      case 0:
         return 0;
      case 2:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIILal;Lah;I)V",
      garbageValue = "-1350163016"
   )
   void method402(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field420[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class94.method1790(var9);
               var6.method654(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([Lat;Lah;I)V",
      garbageValue = "87274387"
   )
   void method384(class34[] var1, class43 var2) {
      class229[] var3 = new class229[]{class229.field3154, class229.field3158, class229.field3153, class229.field3159, class229.field3155, class229.field3160, class229.field3162, class229.field3156};
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
            switch(var7.field3161) {
            case 0:
               var8 = 59;
               var10 = 5;
               break;
            case 1:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
               break;
            case 2:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 3:
               var13 = 59;
               var11 = 5;
               break;
            case 4:
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 5:
               var9 = 59;
               var11 = 5;
               break;
            case 6:
               var12 = 59;
               var10 = 5;
               break;
            case 7:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
            }

            this.method403(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IILal;S)I",
      garbageValue = "512"
   )
   int method404(int var1, int var2, class28 var3) {
      return var3.field420[0][var1][var2] == 0?this.field489:this.field491[var1][var2];
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(II)Lig;",
      garbageValue = "2027996877"
   )
   Area method390(int var1) {
      ObjectComposition var2 = GameObject.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.field3294[var2.mapIconId]:null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lah;I)V",
      garbageValue = "-2032446895"
   )
   void method400(class43 var1) {
      this.field491 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field491[var2][var3] = var1.method645(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lak;[Lat;[Ljx;I)V",
      garbageValue = "-1239005985"
   )
   void method394(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method488(var4, var5, this.field487, var1);
            this.method457(var4, var5, this.field487, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method428(var4, var5, this.field487, var1, var3);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lak;[Ljx;I)V",
      garbageValue = "-294697466"
   )
   void method395(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field488.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method680() * 8; var5 < var4.method680() * 8 + 8; ++var5) {
            for(var6 = var4.method677() * 8; var6 < var4.method677() * 8 + 8; ++var6) {
               this.method488(var5, var6, var4, var1);
               this.method457(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field488.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method680() * 8; var5 < var4.method680() * 8 + 8; ++var5) {
            for(var6 = var4.method677() * 8; var6 < var4.method677() * 8 + 8; ++var6) {
               this.method428(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "528671966"
   )
   List method422() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field493);
      var1.addAll(this.field494.values());
      return var1;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lig;IIIIB)V",
      garbageValue = "83"
   )
   void method409(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4302(false);
      if(var6 != null) {
         var6.method5019(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method4888(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method4888(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)Laq;",
      garbageValue = "1318601078"
   )
   class33 method427(int var1) {
      Area var2 = Area.field3294[var1];
      return this.method460(var2);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "388356825"
   )
   void method414() {
      if(this.field487 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method507(var1, var2, this.field487);
            }
         }
      } else {
         Iterator var5 = this.field488.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method680() * 8; var3 < var6.method680() * 8 + 8; ++var3) {
               for(int var4 = var6.method677() * 8; var4 < var6.method677() * 8 + 8; ++var4) {
                  this.method507(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lay;IIFB)V",
      garbageValue = "0"
   )
   void method513(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.field3294[var1.field543];
      this.method411(var5, var2, var3);
      this.method465(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "43794405"
   )
   void method439(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field494.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field543))) {
            Area var6 = Area.field3294[var5.field543];
            this.method409(var6, var5.field541, var5.field548, var2, var3);
         }
      }

      this.method425(var1, var2, var3);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "342165990"
   )
   void method423(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method4904(this.field490 * var1, this.field490 * (63 - var2), this.field490, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method4884(this.field490 * var1, this.field490 * (63 - var2), this.field490, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method4904(this.field490 + this.field490 * var1 - 1, this.field490 * (63 - var2), this.field490, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method4884(this.field490 * var1, this.field490 * (63 - var2) + this.field490 - 1, this.field490, var4);
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "1018206095"
   )
   void method391(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method407(var1, var2, var4, var3);
      this.method413(var1, var2, var4, var3);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(IIIIIB)Ljava/util/List;",
      garbageValue = "82"
   )
   List method421(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field494.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method559(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field493.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method559(var4, var5)) {
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILak;[Lat;[Ljx;I)Z",
      garbageValue = "-2086469099"
   )
   boolean method454(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method393(var1)) {
         return false;
      } else if(this.field487 == null && this.field488.isEmpty()) {
         return false;
      } else {
         this.method472(var3);
         this.field492.method5010();
         if(this.field487 != null) {
            this.method394(var2, var3, var4);
         } else {
            this.method395(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIIIILat;Lah;I)V",
      garbageValue = "-479570448"
   )
   void method403(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method424(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class94.method1790(var11);
               var8.method654(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1248294983"
   )
   void method415(int var1, int var2, int var3) {
      if(this.field492 != null) {
         if(this.field490 * 64 == var3) {
            this.field492.method5017(var1, var2);
         } else {
            this.field492.method5029(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lh;Ljava/util/List;I)V",
      garbageValue = "-51278815"
   )
   void method386(class22 var1, List var2) {
      this.field494.clear();
      this.field487 = var1;
      this.method388(0, 0, 64, 64, this.field487);
      this.method450(var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "-499667092"
   )
   void method412(HashSet var1, List var2) {
      this.field494.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method250() == this.field485 && var4.method256() == this.field500) {
            this.field488.add(var4);
            this.method388(var4.method680() * 8, var4.method677() * 8, 8, 8, var4);
         }
      }

      this.method450(var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;Lgi;B)Lgi;",
      garbageValue = "-86"
   )
   static final IterableHashTable method516(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class165.method3159(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "([Lhx;II)V",
      garbageValue = "16711935"
   )
   static final void method399(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1 && (!var3.hasScript || !WorldMapType2.method548(var3))) {
            int var5;
            if(var3.type == 0) {
               if(!var3.hasScript && WorldMapType2.method548(var3) && var3 != class56.field696) {
                  continue;
               }

               method399(var0, var3.id);
               if(var3.children != null) {
                  method399(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var7 != null) {
                  var5 = var7.id;
                  if(class13.loadWidget(var5)) {
                     method399(class268.widgets[var5], -1);
                  }
               }
            }

            if(var3.type == 6) {
               if(var3.field2783 != -1 || var3.field2706 != -1) {
                  boolean var4 = class37.method528(var3);
                  if(var4) {
                     var5 = var3.field2706;
                  } else {
                     var5 = var3.field2783;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class216.getAnimation(var5);

                     for(var3.field2734 += Client.field1007; var3.field2734 > var6.frameLenghts[var3.field2780]; class7.method34(var3)) {
                        var3.field2734 -= var6.frameLenghts[var3.field2780];
                        ++var3.field2780;
                        if(var3.field2780 >= var6.frameIDs.length) {
                           var3.field2780 -= var6.frameStep;
                           if(var3.field2780 < 0 || var3.field2780 >= var6.frameIDs.length) {
                              var3.field2780 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2714 != 0 && !var3.hasScript) {
                  int var8 = var3.field2714 >> 16;
                  var5 = var3.field2714 << 16 >> 16;
                  var8 *= Client.field1007;
                  var5 *= Client.field1007;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  class7.method34(var3);
               }
            }
         }
      }

   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1460820093"
   )
   static void method514(int var0) {
      ScriptVarType.field178 = new class88();
      ScriptVarType.field178.field1404 = Client.menuActionParams0[var0];
      ScriptVarType.field178.field1409 = Client.menuActionParams1[var0];
      ScriptVarType.field178.field1406 = Client.menuTypes[var0];
      ScriptVarType.field178.field1407 = Client.menuIdentifiers[var0];
      ScriptVarType.field178.field1408 = Client.menuOptions[var0];
   }
}
