import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("au")
public class class34 {
   @ObfuscatedName("c")
   LinkedList field480;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -555945401
   )
   int field482;
   @ObfuscatedName("a")
   final HashMap field483;
   @ObfuscatedName("y")
   static final Coordinates field485;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1036569123
   )
   int field486;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1983200629
   )
   int field487;
   @ObfuscatedName("g")
   int[][] field488;
   @ObfuscatedName("e")
   SpritePixels field489;
   @ObfuscatedName("o")
   List field490;
   @ObfuscatedName("x")
   HashMap field492;
   @ObfuscatedName("m")
   class22 field493;
   @ObfuscatedName("er")
   static class262 field494;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1186635659
   )
   int field495;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "714995087"
   )
   void method358(int var1, int var2, int var3) {
      if(this.field489 != null) {
         if(var3 == this.field487 * 64) {
            this.field489.method5164(var1, var2);
         } else {
            this.field489.method5112(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;B)V",
      garbageValue = "34"
   )
   void method360(HashSet var1, List var2) {
      this.field492.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method238() == this.field482 && var4.method241() == this.field495) {
            this.field480.add(var4);
            this.method426(var4.method624() * 8, var4.method625() * 8, 8, 8, var4);
         }
      }

      this.method465(var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILclass46;[Lclass34;[LModIcon;B)Z",
      garbageValue = "47"
   )
   boolean method363(int var1, class46 var2, class34[] var3, ModIcon[] var4) {
      if(!this.method366(var1)) {
         return false;
      } else if(this.field493 == null && this.field480.isEmpty()) {
         return false;
      } else {
         this.method418(var3);
         this.field489.method5089();
         if(this.field493 != null) {
            this.method367(var2, var3, var4);
         } else {
            this.method368(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1975963640"
   )
   void method365(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field492.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field538))) {
            Area var6 = World.field1300[var5.field538];
            this.method382(var6, var5.field533, var5.field531, var2, var3);
         }
      }

      this.method477(var1, var2, var3);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-74"
   )
   boolean method366(int var1) {
      if(this.field489 != null && this.field487 == var1) {
         return false;
      } else {
         this.field487 = var1;
         this.field489 = new SpritePixels(this.field487 * 64, this.field487 * 64);
         return true;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lclass46;[Lclass34;[LModIcon;I)V",
      garbageValue = "1857123531"
   )
   void method367(class46 var1, class34[] var2, ModIcon[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method372(var4, var5, this.field493, var1);
            this.method469(var4, var5, this.field493, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method369(var4, var5, this.field493, var1, var3);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass46;[LModIcon;B)V",
      garbageValue = "9"
   )
   void method368(class46 var1, ModIcon[] var2) {
      Iterator var3 = this.field480.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method624() * 8; var5 < var4.method624() * 8 + 8; ++var5) {
            for(var6 = var4.method625() * 8; var6 < var4.method625() * 8 + 8; ++var6) {
               this.method372(var5, var6, var4, var1);
               this.method469(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field480.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method624() * 8; var5 < var4.method624() * 8 + 8; ++var5) {
            for(var6 = var4.method625() * 8; var6 < var4.method625() * 8 + 8; ++var6) {
               this.method369(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;[LModIcon;I)V",
      garbageValue = "67516080"
   )
   void method369(int var1, int var2, class28 var3, class46 var4, ModIcon[] var5) {
      this.method379(var1, var2, var3);
      this.method378(var1, var2, var3, var5);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;I)V",
      garbageValue = "-2129745880"
   )
   void method372(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field409[0][var1][var2] - 1;
      int var6 = var3.field416[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method5040(var1 * this.field487, this.field487 * (63 - var2), this.field487, this.field487, this.field486);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class77.method1485(var6, this.field486);
      }

      if(var6 > -1 && var3.field417[0][var1][var2] == 0) {
         Rasterizer2D.method5040(this.field487 * var1, this.field487 * (63 - var2), this.field487, this.field487, var7);
      } else {
         int var8 = this.method377(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method5040(this.field487 * var1, this.field487 * (63 - var2), this.field487, this.field487, var8);
         } else {
            var4.method671(var1 * this.field487, this.field487 * (63 - var2), var8, var7, this.field487, this.field487, var3.field417[0][var1][var2], var3.field420[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass43;I)V",
      garbageValue = "1534723600"
   )
   void method373(class43 var1) {
      this.field488 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field488[var2][var3] = var1.method603(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Lclass34;Lclass43;I)V",
      garbageValue = "488782790"
   )
   void method374(class34[] var1, class43 var2) {
      class228[] var3 = new class228[]{class228.field3153, class228.field3156, class228.field3152, class228.field3160, class228.field3157, class228.field3155, class228.field3151, class228.field3154};
      class228[] var5 = var3;

      for(int var6 = 0; var6 < var5.length; ++var6) {
         class228 var7 = var5[var6];
         if(var1[var7.vmethod5059()] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch(var7.field3158) {
            case 0:
               var13 = 59;
               var11 = 5;
               break;
            case 1:
               var8 = 59;
               var10 = 5;
               break;
            case 2:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 3:
               var12 = 59;
               var10 = 5;
               break;
            case 4:
               var9 = 59;
               var11 = 5;
               break;
            case 5:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
               break;
            case 6:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 7:
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
            }

            this.method376(var12, var13, var8, var9, var10, var11, var1[var7.vmethod5059()], var2);
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIIILclass28;Lclass43;I)V",
      garbageValue = "-1288141148"
   )
   void method375(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         for(int var8 = var2; var8 < var4 + var2; ++var8) {
            int var9 = var5.field409[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class162.method3053(var9);
               var6.method602(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass34;Lclass43;I)V",
      garbageValue = "-1640531527"
   )
   void method376(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method437(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class162.method3053(var11);
               var8.method602(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)I",
      garbageValue = "-863119336"
   )
   int method377(int var1, int var2, class28 var3) {
      return var3.field409[0][var1][var2] == 0?this.field486:this.field488[var1][var2];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IILclass28;[LModIcon;I)V",
      garbageValue = "-1464055523"
   )
   void method378(int var1, int var2, class28 var3, ModIcon[] var4) {
      for(int var5 = 0; var5 < var3.field414; ++var5) {
         class31[] var6 = var3.field419[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               int var11 = var9.field448;
               boolean var10 = var11 >= class221.field2831.field2834 && var11 <= class221.field2825.field2834;
               if(!var10) {
                  int var13 = var9.field448;
                  boolean var14 = var13 == class221.field2833.field2834;
                  if(!var14) {
                     continue;
                  }
               }

               ObjectComposition var12 = class61.getObjectDefinition(var9.field450);
               if(var12.mapSceneId != -1) {
                  if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                     var4[var12.mapSceneId].method5073(this.field487 * var1, this.field487 * (63 - var2), this.field487 * 2, this.field487 * 2);
                  } else {
                     var4[var12.mapSceneId].method5073(this.field487 * var1, (63 - var2) * this.field487, this.field487 * 2 + 1, this.field487 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILclass28;B)V",
      garbageValue = "-32"
   )
   void method379(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field414; ++var4) {
         class31[] var5 = var3.field419[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               int var10 = var8.field448;
               boolean var9 = var10 >= class221.field2816.field2834 && var10 <= class221.field2814.field2834 || class221.field2815.field2834 == var10;
               if(var9) {
                  ObjectComposition var11 = class61.getObjectDefinition(var8.field450);
                  int var12 = var11.field3464 != 0?-3407872:-3355444;
                  if(var8.field448 == class221.field2816.field2834) {
                     this.method396(var1, var2, var8.field447, var12);
                  }

                  if(var8.field448 == class221.field2813.field2834) {
                     this.method396(var1, var2, var8.field447, -3355444);
                     this.method396(var1, var2, var8.field447 + 1, var12);
                  }

                  if(class221.field2814.field2834 == var8.field448) {
                     if(var8.field447 == 0) {
                        Rasterizer2D.method4973(var1 * this.field487, (63 - var2) * this.field487, 1, var12);
                     }

                     if(var8.field447 == 1) {
                        Rasterizer2D.method4973(this.field487 + var1 * this.field487 - 1, (63 - var2) * this.field487, 1, var12);
                     }

                     if(var8.field447 == 2) {
                        Rasterizer2D.method4973(this.field487 + this.field487 * var1 - 1, this.field487 + (63 - var2) * this.field487 - 1, 1, var12);
                     }

                     if(var8.field447 == 3) {
                        Rasterizer2D.method4973(this.field487 * var1, (63 - var2) * this.field487 + this.field487 - 1, 1, var12);
                     }
                  }

                  if(class221.field2815.field2834 == var8.field448) {
                     int var13 = var8.field447 % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.field487; ++var14) {
                           Rasterizer2D.method4973(var14 + this.field487 * var1, this.field487 * (64 - var2) - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.field487; ++var14) {
                           Rasterizer2D.method4973(this.field487 * var1 + var14, var14 + this.field487 * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "2042955443"
   )
   void method380(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field492.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var9.worldX * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field533 = var10;
            var12.field531 = var11;
            Area var13 = World.field1300[var12.field538];
            if(!var3.contains(Integer.valueOf(var13.method4327()))) {
               this.method383(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(LArea;IIIII)V",
      garbageValue = "1647944551"
   )
   void method382(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4325(false);
      if(var6 != null) {
         var6.method5097(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method4967(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method4967(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIFI)V",
      garbageValue = "-928242662"
   )
   void method383(class39 var1, int var2, int var3, float var4) {
      Area var5 = World.field1300[var1.field538];
      this.method384(var5, var2, var3);
      this.method435(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(LArea;III)V",
      garbageValue = "-1436154201"
   )
   void method384(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4325(false);
      if(var4 != null) {
         int var5 = this.method448(var4, var1.field3309);
         int var6 = this.method390(var4, var1.field3310);
         var4.method5097(var2 + var5, var6 + var3);
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-2119949649"
   )
   void method386(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field490.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field527.worldX % 64;
         int var9 = var7.field527.worldY % 64;
         var7.field533 = (int)((float)var1 + var5 * (float)var8);
         var7.field531 = (int)(var5 * (float)(63 - var9) + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.field538))) {
            this.method383(var7, var7.field533, var7.field531, var5);
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-27724"
   )
   void method387() {
      if(this.field493 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var6 = 0; var6 < 64; ++var6) {
               this.method388(var1, var6, this.field493);
            }
         }
      } else {
         Iterator var5 = this.field480.iterator();

         while(var5.hasNext()) {
            class45 var2 = (class45)var5.next();

            for(int var3 = var2.method624() * 8; var3 < var2.method624() * 8 + 8; ++var3) {
               for(int var4 = var2.method625() * 8; var4 < var2.method625() * 8 + 8; ++var4) {
                  this.method388(var3, var4, var2);
               }
            }
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)V",
      garbageValue = "-527264203"
   )
   void method388(int var1, int var2, class28 var3) {
      field485.method3954(0, var1, var2);

      for(int var4 = 0; var4 < var3.field414; ++var4) {
         class31[] var5 = var3.field419[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method476(var8.field450);
               if(var9 != null) {
                  class39 var10 = (class39)this.field492.get(field485);
                  if(var10 != null) {
                     if(var9.field3307 != var10.field538) {
                        class39 var16 = new class39(var9.field3307, var10.field529, var10.field527, this.method393(var9));
                        this.field492.put(new Coordinates(field485), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field529.plane - var10.field527.plane;
                     var10.field527.plane = var4;
                     var10.field529.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field482 * 64 + var1, var2 + this.field495 * 64);
                  Coordinates var12 = null;
                  if(this.field493 != null) {
                     var12 = new Coordinates(var4 + this.field493.field413, var1 + this.field493.field411 * 64, var2 + this.field493.field410 * 64);
                  } else {
                     Iterator var13 = this.field480.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method626(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field413, var14.field411 * 64 + var1 + var14.method619() * 8, var2 + var14.field410 * 64 + var14.method623() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3307, var12, var11, this.method393(var9));
                     this.field492.put(new Coordinates(field485), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field492.remove(field485);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(LSpritePixels;Lclass239;I)I",
      garbageValue = "985197836"
   )
   int method390(SpritePixels var1, class239 var2) {
      switch(var2.field3273) {
      case 1:
         return -var1.height / 2;
      case 2:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(II)Lclass33;",
      garbageValue = "1206888945"
   )
   class33 method392(int var1) {
      Area var2 = World.field1300[var1];
      return this.method393(var2);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(LArea;I)Lclass33;",
      garbageValue = "-1997963692"
   )
   class33 method393(Area var1) {
      if(var1.name != null && this.field483 != null && this.field483.get(class24.field366) != null) {
         int var3 = var1.field3301;
         class24[] var4 = class24.method200();
         int var5 = 0;

         class24 var2;
         while(true) {
            if(var5 >= var4.length) {
               var2 = null;
               break;
            }

            class24 var6 = var4[var5];
            if(var3 == var6.field364) {
               var2 = var6;
               break;
            }

            ++var5;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field483.get(var2);
            if(var14 == null) {
               return null;
            } else {
               int var15 = var14.method4783(var1.name, 1000000);
               String[] var7 = new String[var15];
               var14.method4781(var1.name, (int[])null, var7);
               int var8 = var7.length * var14.field3652 / 2;
               int var9 = 0;
               String[] var10 = var7;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.method4780(var12);
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

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "259709633"
   )
   List method394(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var1 + var3 && var5 < var3 + var2) {
            Iterator var7 = this.field492.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method540(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field490.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method540(var4, var5)) {
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
      signature = "(B)Ljava/util/List;",
      garbageValue = "45"
   )
   List method395() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field490);
      var1.addAll(this.field492.values());
      return var1;
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1786021767"
   )
   void method396(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method4980(this.field487 * var1, this.field487 * (63 - var2), this.field487, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method4973(this.field487 * var1, (63 - var2) * this.field487, this.field487, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method4980(this.field487 + this.field487 * var1 - 1, this.field487 * (63 - var2), this.field487, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method4973(this.field487 * var1, (63 - var2) * this.field487 + this.field487 - 1, this.field487, var4);
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass22;Ljava/util/List;I)V",
      garbageValue = "1147725044"
   )
   void method403(class22 var1, List var2) {
      this.field492.clear();
      this.field493 = var1;
      this.method426(0, 0, 64, 64, this.field493);
      this.method465(var2);
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field482 = var1;
      this.field495 = var2;
      this.field480 = new LinkedList();
      this.field490 = new LinkedList();
      this.field492 = new HashMap();
      this.field486 = var3 | -16777216;
      this.field483 = var4;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([Lclass34;I)Z",
      garbageValue = "1178119911"
   )
   boolean method418(class34[] var1) {
      if(this.field488 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field493 != null) {
            this.method375(0, 0, 64, 64, this.field493, var2);
         } else {
            Iterator var3 = this.field480.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method375(var4.method624() * 8, var4.method625() * 8, 8, 8, var4, var2);
            }
         }

         this.method374(var1, var2);
         this.method373(var2);
         return true;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIILclass28;B)V",
      garbageValue = "-47"
   )
   void method426(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label66:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field414; ++var9) {
               class31[] var10 = var5.field419[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method476(var13.field450);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, var6 + this.field482 * 64, this.field495 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field493 != null) {
                           var16 = new Coordinates(this.field493.field413 + var9, var6 + this.field493.field411 * 64, var7 + this.field493.field410 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var17.field413 + var9, var17.field411 * 64 + var6 + var17.method619() * 8, var7 + var17.field410 * 64 + var17.method623() * 8);
                        }

                        class39 var18 = new class39(var14.field3307, var16, var15, this.method393(var14));
                        this.field492.put(var8, var18);
                        continue label66;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(Lclass39;LArea;IIFI)V",
      garbageValue = "292883998"
   )
   void method435(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field532 != null) {
         if(var1.field532.field475.method197(var5)) {
            Font var6 = (Font)this.field483.get(var1.field532.field475);
            var6.method4792(var1.field532.field477, var3 - var1.field532.field472 / 2, var4, var1.field532.field472, var1.field532.field473, -16777216 | var2.field3300, 0, 1, 0, var6.field3652 / 2);
         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2138837687"
   )
   int method437(int var1, int var2) {
      if(this.field493 != null) {
         return this.field493.method252(var1, var2);
      } else {
         if(!this.field480.isEmpty()) {
            Iterator var3 = this.field480.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method626(var1, var2)) {
                  return var4.method252(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(LSpritePixels;Lclass257;I)I",
      garbageValue = "-271831916"
   )
   int method448(SpritePixels var1, class257 var2) {
      switch(var2.field3554) {
      case 1:
         return -var1.width / 2;
      case 2:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "461483579"
   )
   void method450(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method380(var1, var2, var4, var3);
      this.method386(var1, var2, var4, var3);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "-763713942"
   )
   void method465(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(this.field482 == var3.field379.worldX >> 6 && var3.field379.worldY >> 6 == this.field495) {
            class39 var4 = new class39(var3.field374, var3.field379, var3.field379, this.method392(var3.field374));
            this.field490.add(var4);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;I)V",
      garbageValue = "-1540081011"
   )
   void method469(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field414; ++var5) {
         int var6 = var3.field416[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class77.method1485(var6, this.field486);
            if(var3.field417[var5][var1][var2] == 0) {
               Rasterizer2D.method5040(this.field487 * var1, this.field487 * (63 - var2), this.field487, this.field487, var7);
            } else {
               var4.method671(var1 * this.field487, (63 - var2) * this.field487, 0, var7, this.field487, this.field487, var3.field417[var5][var1][var2], var3.field420[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)LArea;",
      garbageValue = "1347821585"
   )
   Area method476(int var1) {
      ObjectComposition var2 = class61.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?World.field1300[var2.mapIconId]:null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "1208506380"
   )
   void method477(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field490.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = World.field1300[var5.field538];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4327()))) {
            this.method382(var6, var5.field533, var5.field531, var2, var3);
         }
      }

   }

   static {
      field485 = new Coordinates();
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method489() {
      int var1;
      int var2;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var10;
      int var11;
      int var12;
      if(Client.field960 == 31) {
         byte var0 = Client.secretPacketBuffer2.method3189();
         var1 = Client.secretPacketBuffer2.method3195();
         var2 = Client.secretPacketBuffer2.method3196();
         byte var3 = Client.secretPacketBuffer2.method3307();
         var4 = Client.secretPacketBuffer2.method3188();
         var5 = (var4 >> 4 & 7) + class66.field804;
         var6 = class166.field2338 + (var4 & 7);
         var7 = Client.secretPacketBuffer2.method3194();
         var8 = Client.secretPacketBuffer2.method3194();
         byte var9 = Client.secretPacketBuffer2.method3307();
         var10 = Client.secretPacketBuffer2.method3188();
         var11 = var10 >> 2;
         var12 = var10 & 3;
         int var13 = Client.field977[var11];
         byte var14 = Client.secretPacketBuffer2.readByte();
         Player var15;
         if(Client.localInteractingIndex == var8) {
            var15 = class168.localPlayer;
         } else {
            var15 = Client.cachedPlayers[var8];
         }

         if(var15 != null) {
            ObjectComposition var16 = class61.getObjectDefinition(var2);
            int var17;
            int var18;
            if(var12 != 1 && var12 != 3) {
               var17 = var16.sizeX;
               var18 = var16.sizeY;
            } else {
               var17 = var16.sizeY;
               var18 = var16.sizeX;
            }

            int var19 = (var17 >> 1) + var5;
            int var20 = (var17 + 1 >> 1) + var5;
            int var21 = (var18 >> 1) + var6;
            int var22 = (var18 + 1 >> 1) + var6;
            int[][] var23 = class61.tileHeights[class92.plane];
            int var24 = var23[var20][var22] + var23[var19][var22] + var23[var19][var21] + var23[var20][var21] >> 2;
            int var25 = (var5 << 7) + (var17 << 6);
            int var26 = (var18 << 6) + (var6 << 7);
            Model var27 = var16.method4560(var11, var12, var23, var25, var24, var26);
            if(var27 != null) {
               class67.method1064(class92.plane, var5, var6, var13, -1, 0, 0, var1 + 1, var7 + 1);
               var15.totalLevel2 = Client.gameCycle + var1;
               var15.field879 = var7 + Client.gameCycle;
               var15.model = var27;
               var15.field880 = var17 * 64 + var5 * 128;
               var15.field882 = var6 * 128 + var18 * 64;
               var15.field881 = var24;
               byte var28;
               if(var3 > var14) {
                  var28 = var3;
                  var3 = var14;
                  var14 = var28;
               }

               if(var9 > var0) {
                  var28 = var9;
                  var9 = var0;
                  var0 = var28;
               }

               var15.field888 = var3 + var5;
               var15.field886 = var5 + var14;
               var15.field889 = var9 + var6;
               var15.field870 = var6 + var0;
            }
         }
      }

      int var35;
      int var36;
      if(Client.field960 == 27) {
         var35 = Client.secretPacketBuffer2.readUnsignedByte();
         var1 = class66.field804 + (var35 >> 4 & 7);
         var2 = class166.field2338 + (var35 & 7);
         var36 = Client.secretPacketBuffer2.readUnsignedShort();
         var4 = Client.secretPacketBuffer2.readUnsignedShort();
         var5 = Client.secretPacketBuffer2.readUnsignedShort();
         if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
            Deque var38 = Client.groundItemDeque[class92.plane][var1][var2];
            if(var38 != null) {
               for(Item var32 = (Item)var38.method3622(); var32 != null; var32 = (Item)var38.method3608()) {
                  if(var32.id == (var36 & 32767) && var32.quantity == var4) {
                     var32.quantity = var5;
                     break;
                  }
               }

               class261.groundItemSpawned(var1, var2);
            }
         }

      } else {
         Item var31;
         if(Client.field960 == 77) {
            var35 = Client.secretPacketBuffer2.method3186();
            var1 = class66.field804 + (var35 >> 4 & 7);
            var2 = (var35 & 7) + class166.field2338;
            var36 = Client.secretPacketBuffer2.method3195();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               Deque var33 = Client.groundItemDeque[class92.plane][var1][var2];
               if(var33 != null) {
                  for(var31 = (Item)var33.method3622(); var31 != null; var31 = (Item)var33.method3608()) {
                     if(var31.id == (var36 & 32767)) {
                        var31.unlink();
                        break;
                     }
                  }

                  if(var33.method3622() == null) {
                     Client.groundItemDeque[class92.plane][var1][var2] = null;
                  }

                  class261.groundItemSpawned(var1, var2);
               }
            }

         } else if(Client.field960 == 173) {
            var35 = Client.secretPacketBuffer2.method3186();
            var1 = var35 >> 2;
            var2 = var35 & 3;
            var36 = Client.field977[var1];
            var4 = Client.secretPacketBuffer2.method3196();
            var5 = Client.secretPacketBuffer2.method3187();
            var6 = class66.field804 + (var5 >> 4 & 7);
            var7 = class166.field2338 + (var5 & 7);
            if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
               class67.method1064(class92.plane, var6, var7, var36, var4, var1, var2, 0, -1);
            }

         } else {
            if(Client.field960 == 5) {
               var35 = Client.secretPacketBuffer2.readUnsignedByte();
               var1 = (var35 >> 4 & 7) + class66.field804;
               var2 = (var35 & 7) + class166.field2338;
               var36 = Client.secretPacketBuffer2.readUnsignedShort();
               var4 = Client.secretPacketBuffer2.readUnsignedByte();
               var5 = var4 >> 4 & 15;
               var6 = var4 & 7;
               var7 = Client.secretPacketBuffer2.readUnsignedByte();
               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var8 = var5 + 1;
                  if(class168.localPlayer.pathX[0] >= var1 - var8 && class168.localPlayer.pathX[0] <= var1 + var8 && class168.localPlayer.pathY[0] >= var2 - var8 && class168.localPlayer.pathY[0] <= var2 + var8 && Client.field1005 != 0 && var6 > 0 && Client.field1077 < 50) {
                     Client.field1158[Client.field1077] = var36;
                     Client.field1159[Client.field1077] = var6;
                     Client.field1049[Client.field1077] = var7;
                     Client.field1162[Client.field1077] = null;
                     Client.field1101[Client.field1077] = var5 + (var2 << 8) + (var1 << 16);
                     ++Client.field1077;
                  }
               }
            }

            if(Client.field960 == 90) {
               var35 = Client.secretPacketBuffer2.method3186();
               var1 = var35 >> 2;
               var2 = var35 & 3;
               var36 = Client.field977[var1];
               var4 = Client.secretPacketBuffer2.method3186();
               var5 = class66.field804 + (var4 >> 4 & 7);
               var6 = class166.field2338 + (var4 & 7);
               if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                  class67.method1064(class92.plane, var5, var6, var36, -1, var1, var2, 0, -1);
               }

            } else {
               int var37;
               if(Client.field960 == 236) {
                  var35 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var35 >> 4 & 7) + class66.field804;
                  var2 = class166.field2338 + (var35 & 7);
                  var36 = var1 + Client.secretPacketBuffer2.readByte();
                  var4 = var2 + Client.secretPacketBuffer2.readByte();
                  var5 = Client.secretPacketBuffer2.readShort();
                  var6 = Client.secretPacketBuffer2.readUnsignedShort();
                  var7 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                  var8 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                  var37 = Client.secretPacketBuffer2.readUnsignedShort();
                  var10 = Client.secretPacketBuffer2.readUnsignedShort();
                  var11 = Client.secretPacketBuffer2.readUnsignedByte();
                  var12 = Client.secretPacketBuffer2.readUnsignedByte();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var36 >= 0 && var4 >= 0 && var36 < 104 && var4 < 104 && var6 != '\uffff') {
                     var1 = var1 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     var36 = var36 * 128 + 64;
                     var4 = var4 * 128 + 64;
                     Projectile var34 = new Projectile(var6, class92.plane, var1, var2, class181.method3424(var1, var2, class92.plane) - var7, var37 + Client.gameCycle, Client.gameCycle + var10, var11, var12, var5, var8);
                     var34.method1726(var36, var4, class181.method3424(var36, var4, class92.plane) - var8, var37 + Client.gameCycle);
                     Client.projectiles.method3634(var34);
                  }

               } else if(Client.field960 == 246) {
                  var35 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var35 >> 4 & 7) + class66.field804;
                  var2 = class166.field2338 + (var35 & 7);
                  var36 = Client.secretPacketBuffer2.readUnsignedShort();
                  var4 = Client.secretPacketBuffer2.readUnsignedByte();
                  var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = var2 * 128 + 64;
                     class84 var29 = new class84(var36, class92.plane, var1, var2, class181.method3424(var1, var2, class92.plane) - var4, var5, Client.gameCycle);
                     Client.field1048.method3634(var29);
                  }

               } else if(Client.field960 == 180) {
                  var35 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var35 >> 4 & 7) + class66.field804;
                  var2 = class166.field2338 + (var35 & 7);
                  var36 = Client.secretPacketBuffer2.method3195();
                  var4 = Client.secretPacketBuffer2.readUnsignedShort();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var31 = new Item();
                     var31.id = var4;
                     var31.quantity = var36;
                     if(Client.groundItemDeque[class92.plane][var1][var2] == null) {
                        Client.groundItemDeque[class92.plane][var1][var2] = new Deque();
                     }

                     Client.groundItemDeque[class92.plane][var1][var2].method3634(var31);
                     class261.groundItemSpawned(var1, var2);
                  }

               } else if(Client.field960 == 47) {
                  var35 = Client.secretPacketBuffer2.method3187();
                  var1 = var35 >> 2;
                  var2 = var35 & 3;
                  var36 = Client.field977[var1];
                  var4 = Client.secretPacketBuffer2.method3194();
                  var5 = Client.secretPacketBuffer2.readUnsignedByte();
                  var6 = class66.field804 + (var5 >> 4 & 7);
                  var7 = class166.field2338 + (var5 & 7);
                  if(var6 >= 0 && var7 >= 0 && var6 < 103 && var7 < 103) {
                     if(var36 == 0) {
                        WallObject var30 = class61.region.method2862(class92.plane, var6, var7);
                        if(var30 != null) {
                           var37 = var30.hash >> 14 & 32767;
                           if(var1 == 2) {
                              var30.renderable1 = new class100(var37, 2, var2 + 4, class92.plane, var6, var7, var4, false, var30.renderable1);
                              var30.renderable2 = new class100(var37, 2, var2 + 1 & 3, class92.plane, var6, var7, var4, false, var30.renderable2);
                           } else {
                              var30.renderable1 = new class100(var37, var1, var2, class92.plane, var6, var7, var4, false, var30.renderable1);
                           }
                        }
                     }

                     if(var36 == 1) {
                        DecorativeObject var39 = class61.region.method2748(class92.plane, var6, var7);
                        if(var39 != null) {
                           var37 = var39.hash >> 14 & 32767;
                           if(var1 != 4 && var1 != 5) {
                              if(var1 == 6) {
                                 var39.renderable1 = new class100(var37, 4, var2 + 4, class92.plane, var6, var7, var4, false, var39.renderable1);
                              } else if(var1 == 7) {
                                 var39.renderable1 = new class100(var37, 4, (var2 + 2 & 3) + 4, class92.plane, var6, var7, var4, false, var39.renderable1);
                              } else if(var1 == 8) {
                                 var39.renderable1 = new class100(var37, 4, var2 + 4, class92.plane, var6, var7, var4, false, var39.renderable1);
                                 var39.renderable2 = new class100(var37, 4, (var2 + 2 & 3) + 4, class92.plane, var6, var7, var4, false, var39.renderable2);
                              }
                           } else {
                              var39.renderable1 = new class100(var37, 4, var2, class92.plane, var6, var7, var4, false, var39.renderable1);
                           }
                        }
                     }

                     if(var36 == 2) {
                        GameObject var40 = class61.region.method2699(class92.plane, var6, var7);
                        if(var1 == 11) {
                           var1 = 10;
                        }

                        if(var40 != null) {
                           var40.renderable = new class100(var40.hash >> 14 & 32767, var1, var2, class92.plane, var6, var7, var4, false, var40.renderable);
                        }
                     }

                     if(var36 == 3) {
                        GroundObject var41 = class61.region.method2759(class92.plane, var6, var7);
                        if(var41 != null) {
                           var41.renderable = new class100(var41.hash >> 14 & 32767, 22, var2, class92.plane, var6, var7, var4, false, var41.renderable);
                        }
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "3"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Player var8;
      if(var2 == 48) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field1022 = var6;
            Client.field970 = var7;
            Client.field1195 = 2;
            Client.field1024 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(164);
            Client.secretPacketBuffer1.method3184(class50.field624[82]?1:0);
            Client.secretPacketBuffer1.method3192(var3);
         }
      }

      if(var2 == 51) {
         var8 = Client.cachedPlayers[var3];
         if(var8 != null) {
            Client.field1022 = var6;
            Client.field970 = var7;
            Client.field1195 = 2;
            Client.field1024 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(235);
            Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
            Client.secretPacketBuffer1.method3191(var3);
         }
      }

      Widget var15;
      if(var2 == 25) {
         var15 = class29.method254(var1, var0);
         if(var15 != null) {
            Varbit.method4453();
            class112.method2074(var1, var0, GameEngine.method844(class251.method4472(var15)), var15.itemId);
            Client.field1068 = 0;
            String var17;
            if(GameEngine.method844(class251.method4472(var15)) == 0) {
               var17 = null;
            } else if(var15.field2780 != null && var15.field2780.trim().length() != 0) {
               var17 = var15.field2780;
            } else {
               var17 = null;
            }

            Client.field1074 = var17;
            if(Client.field1074 == null) {
               Client.field1074 = "Null";
            }

            if(var15.hasScript) {
               Client.field1075 = var15.name + class60.method996(16777215);
            } else {
               Client.field1075 = class60.method996('\uff00') + var15.field2727 + class60.method996(16777215);
            }
         }

      } else {
         if(var2 == 1) {
            Client.field1022 = var6;
            Client.field970 = var7;
            Client.field1195 = 2;
            Client.field1024 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(216);
            Client.secretPacketBuffer1.putShort(Client.field1090);
            Client.secretPacketBuffer1.method3192(var0 + class61.baseX);
            Client.secretPacketBuffer1.method3192(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3201(Frames.field2152);
            Client.secretPacketBuffer1.method3184(class50.field624[82]?1:0);
            Client.secretPacketBuffer1.method3193(var1 + class23.baseY);
            Client.secretPacketBuffer1.method3191(class18.field324);
         }

         if(var2 == 19) {
            Client.field1022 = var6;
            Client.field970 = var7;
            Client.field1195 = 2;
            Client.field1024 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(149);
            Client.secretPacketBuffer1.method3191(var3);
            Client.secretPacketBuffer1.method3193(var0 + class61.baseX);
            Client.secretPacketBuffer1.method3185(class50.field624[82]?1:0);
            Client.secretPacketBuffer1.putShort(var1 + class23.baseY);
         }

         if(var2 == 31) {
            Client.secretPacketBuffer1.putOpcode(1);
            Client.secretPacketBuffer1.method3203(Frames.field2152);
            Client.secretPacketBuffer1.method3203(var1);
            Client.secretPacketBuffer1.putShort(var0);
            Client.secretPacketBuffer1.method3193(class18.field324);
            Client.secretPacketBuffer1.method3191(var3);
            Client.secretPacketBuffer1.method3192(Client.field1090);
            Client.field1026 = 0;
            class268.field3681 = class177.method3390(var1);
            Client.field1027 = var0;
         }

         if(var2 == 34) {
            Client.secretPacketBuffer1.putOpcode(131);
            Client.secretPacketBuffer1.method3342(var1);
            Client.secretPacketBuffer1.method3191(var3);
            Client.secretPacketBuffer1.putShort(var0);
            Client.field1026 = 0;
            class268.field3681 = class177.method3390(var1);
            Client.field1027 = var0;
         }

         NPC var14;
         if(var2 == 13) {
            var14 = Client.cachedNPCs[var3];
            if(var14 != null) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(78);
               Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.method3192(var3);
            }
         }

         if(var2 == 1005) {
            var15 = class177.method3390(var1);
            if(var15 != null && var15.itemQuantities[var0] >= 100000) {
               class98.sendGameMessage(27, "", var15.itemQuantities[var0] + " x " + ItemComposition.getItemDefinition(var3).name);
            } else {
               Client.secretPacketBuffer1.putOpcode(200);
               Client.secretPacketBuffer1.method3191(var3);
            }

            Client.field1026 = 0;
            class268.field3681 = class177.method3390(var1);
            Client.field1027 = var0;
         }

         if(var2 == 12) {
            var14 = Client.cachedNPCs[var3];
            if(var14 != null) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(134);
               Client.secretPacketBuffer1.method3184(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.method3192(var3);
            }
         }

         if(var2 == 45) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(225);
               Client.secretPacketBuffer1.method3193(var3);
               Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
            }
         }

         if(var2 == 4) {
            Client.field1022 = var6;
            Client.field970 = var7;
            Client.field1195 = 2;
            Client.field1024 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(138);
            Client.secretPacketBuffer1.putShort(class61.baseX + var0);
            Client.secretPacketBuffer1.method3185(class50.field624[82]?1:0);
            Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3192(class23.baseY + var1);
         }

         if(var2 == 35) {
            Client.secretPacketBuffer1.putOpcode(92);
            Client.secretPacketBuffer1.method3191(var3);
            Client.secretPacketBuffer1.method3203(var1);
            Client.secretPacketBuffer1.method3193(var0);
            Client.field1026 = 0;
            class268.field3681 = class177.method3390(var1);
            Client.field1027 = var0;
         }

         if(var2 == 6) {
            Client.field1022 = var6;
            Client.field970 = var7;
            Client.field1195 = 2;
            Client.field1024 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(2);
            Client.secretPacketBuffer1.method3192(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3192(var1 + class23.baseY);
            Client.secretPacketBuffer1.method3192(var0 + class61.baseX);
            Client.secretPacketBuffer1.method3185(class50.field624[82]?1:0);
         }

         if(var2 == 9) {
            var14 = Client.cachedNPCs[var3];
            if(var14 != null) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(39);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.method3185(class50.field624[82]?1:0);
            }
         }

         if(var2 == 39) {
            Client.secretPacketBuffer1.putOpcode(110);
            Client.secretPacketBuffer1.putShort(var0);
            Client.secretPacketBuffer1.method3191(var3);
            Client.secretPacketBuffer1.putInt(var1);
            Client.field1026 = 0;
            class268.field3681 = class177.method3390(var1);
            Client.field1027 = var0;
         }

         if(var2 == 1004) {
            Client.field1022 = var6;
            Client.field970 = var7;
            Client.field1195 = 2;
            Client.field1024 = 0;
            Client.secretPacketBuffer1.putOpcode(200);
            Client.secretPacketBuffer1.method3191(var3);
         }

         if(var2 == 33) {
            Client.secretPacketBuffer1.putOpcode(113);
            Client.secretPacketBuffer1.method3342(var1);
            Client.secretPacketBuffer1.method3192(var3);
            Client.secretPacketBuffer1.method3191(var0);
            Client.field1026 = 0;
            class268.field3681 = class177.method3390(var1);
            Client.field1027 = var0;
         }

         int var9;
         if(var2 == 57 || var2 == 1007) {
            var15 = class29.method254(var1, var0);
            if(var15 != null) {
               var9 = var15.itemId;
               Widget var10 = class29.method254(var1, var0);
               if(var10 != null) {
                  if(var10.field2752 != null) {
                     class69 var11 = new class69();
                     var11.field824 = var10;
                     var11.field827 = var3;
                     var11.field828 = var5;
                     var11.field833 = var10.field2752;
                     class227.method4101(var11);
                  }

                  boolean var13 = true;
                  if(var10.contentType > 0) {
                     var13 = class241.method4308(var10);
                  }

                  if(var13 && class286.method5182(class251.method4472(var10), var3 - 1)) {
                     if(var3 == 1) {
                        Client.secretPacketBuffer1.putOpcode(57);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.putShort(var9);
                     }

                     if(var3 == 2) {
                        Client.secretPacketBuffer1.putOpcode(54);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.putShort(var9);
                     }

                     if(var3 == 3) {
                        Client.secretPacketBuffer1.putOpcode(239);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.putShort(var9);
                     }

                     if(var3 == 4) {
                        Client.secretPacketBuffer1.putOpcode(193);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.putShort(var9);
                     }

                     if(var3 == 5) {
                        Client.secretPacketBuffer1.putOpcode(42);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.putShort(var9);
                     }

                     if(var3 == 6) {
                        Client.secretPacketBuffer1.putOpcode(229);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.putShort(var9);
                     }

                     if(var3 == 7) {
                        Client.secretPacketBuffer1.putOpcode(35);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.putShort(var9);
                     }

                     if(var3 == 8) {
                        Client.secretPacketBuffer1.putOpcode(166);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.putShort(var9);
                     }

                     if(var3 == 9) {
                        Client.secretPacketBuffer1.putOpcode(226);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.putShort(var9);
                     }

                     if(var3 == 10) {
                        Client.secretPacketBuffer1.putOpcode(214);
                        Client.secretPacketBuffer1.putInt(var1);
                        Client.secretPacketBuffer1.putShort(var0);
                        Client.secretPacketBuffer1.putShort(var9);
                     }
                  }
               }
            }
         }

         if(var2 == 8) {
            var14 = Client.cachedNPCs[var3];
            if(var14 != null) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(102);
               Client.secretPacketBuffer1.method3193(var3);
               Client.secretPacketBuffer1.method3192(Client.field1072);
               Client.secretPacketBuffer1.method3342(NPC.field1375);
               Client.secretPacketBuffer1.method3183(class50.field624[82]?1:0);
            }
         }

         if(var2 == 11) {
            var14 = Client.cachedNPCs[var3];
            if(var14 != null) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(191);
               Client.secretPacketBuffer1.method3193(var3);
               Client.secretPacketBuffer1.method3185(class50.field624[82]?1:0);
            }
         }

         if(var2 == 36) {
            Client.secretPacketBuffer1.putOpcode(67);
            Client.secretPacketBuffer1.method3201(var1);
            Client.secretPacketBuffer1.putShort(var0);
            Client.secretPacketBuffer1.method3193(var3);
            Client.field1026 = 0;
            class268.field3681 = class177.method3390(var1);
            Client.field1027 = var0;
         }

         if(var2 == 1002) {
            Client.field1022 = var6;
            Client.field970 = var7;
            Client.field1195 = 2;
            Client.field1024 = 0;
            Client.secretPacketBuffer1.putOpcode(32);
            Client.secretPacketBuffer1.method3192(var3 >> 14 & 32767);
         }

         if(var2 == 1008 || var2 == 1009 || var2 == 1010 || var2 == 1011 || var2 == 1012) {
            FaceNormal.field2146.method5244(var2, var3, new Coordinates(var0), new Coordinates(var1));
         }

         if(var2 == 5) {
            Client.field1022 = var6;
            Client.field970 = var7;
            Client.field1195 = 2;
            Client.field1024 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(87);
            Client.secretPacketBuffer1.method3193(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3191(var1 + class23.baseY);
            Client.secretPacketBuffer1.method3191(class61.baseX + var0);
            Client.secretPacketBuffer1.method3184(class50.field624[82]?1:0);
         }

         if(var2 == 40) {
            Client.secretPacketBuffer1.putOpcode(118);
            Client.secretPacketBuffer1.method3191(var3);
            Client.secretPacketBuffer1.method3203(var1);
            Client.secretPacketBuffer1.method3193(var0);
            Client.field1026 = 0;
            class268.field3681 = class177.method3390(var1);
            Client.field1027 = var0;
         }

         if(var2 == 43) {
            Client.secretPacketBuffer1.putOpcode(51);
            Client.secretPacketBuffer1.putInt(var1);
            Client.secretPacketBuffer1.putShort(var3);
            Client.secretPacketBuffer1.putShort(var0);
            Client.field1026 = 0;
            class268.field3681 = class177.method3390(var1);
            Client.field1027 = var0;
         }

         if(var2 == 30 && Client.field1147 == null) {
            class31.method286(var1, var0);
            Client.field1147 = class29.method254(var1, var0);
            CombatInfo1.method1515(Client.field1147);
         }

         if(var2 == 20) {
            Client.field1022 = var6;
            Client.field970 = var7;
            Client.field1195 = 2;
            Client.field1024 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(207);
            Client.secretPacketBuffer1.method3192(var0 + class61.baseX);
            Client.secretPacketBuffer1.method3191(class23.baseY + var1);
            Client.secretPacketBuffer1.method3193(var3);
            Client.secretPacketBuffer1.method3183(class50.field624[82]?1:0);
         }

         if(var2 == 44) {
            var8 = Client.cachedPlayers[var3];
            if(var8 != null) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(148);
               Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3);
            }
         }

         if(var2 == 58) {
            var15 = class29.method254(var1, var0);
            if(var15 != null) {
               Client.secretPacketBuffer1.putOpcode(29);
               Client.secretPacketBuffer1.method3192(Client.field1073);
               Client.secretPacketBuffer1.putShort(Client.field1072);
               Client.secretPacketBuffer1.method3191(var15.itemId);
               Client.secretPacketBuffer1.method3201(var1);
               Client.secretPacketBuffer1.method3193(var0);
               Client.secretPacketBuffer1.method3201(NPC.field1375);
            }
         }

         if(var2 == 3) {
            Client.field1022 = var6;
            Client.field970 = var7;
            Client.field1195 = 2;
            Client.field1024 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.secretPacketBuffer1.putOpcode(180);
            Client.secretPacketBuffer1.method3192(var1 + class23.baseY);
            Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
            Client.secretPacketBuffer1.method3192(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3192(class61.baseX + var0);
         }

         if(var2 == 38) {
            Varbit.method4453();
            var15 = class177.method3390(var1);
            Client.field1068 = 1;
            Client.field1090 = var0;
            Frames.field2152 = var1;
            class18.field324 = var3;
            CombatInfo1.method1515(var15);
            Client.field988 = class60.method996(16748608) + ItemComposition.getItemDefinition(var3).name + class60.method996(16777215);
            if(Client.field988 == null) {
               Client.field988 = "null";
            }

         } else {
            if(var2 == 37) {
               Client.secretPacketBuffer1.putOpcode(139);
               Client.secretPacketBuffer1.method3203(var1);
               Client.secretPacketBuffer1.method3191(var0);
               Client.secretPacketBuffer1.method3192(var3);
               Client.field1026 = 0;
               class268.field3681 = class177.method3390(var1);
               Client.field1027 = var0;
            }

            if(var2 == 24) {
               var15 = class177.method3390(var1);
               boolean var16 = true;
               if(var15.contentType > 0) {
                  var16 = class241.method4308(var15);
               }

               if(var16) {
                  Client.secretPacketBuffer1.putOpcode(253);
                  Client.secretPacketBuffer1.putInt(var1);
               }
            }

            if(var2 == 28) {
               Client.secretPacketBuffer1.putOpcode(253);
               Client.secretPacketBuffer1.putInt(var1);
               var15 = class177.method3390(var1);
               if(var15.dynamicValues != null && var15.dynamicValues[0][0] == 5) {
                  var9 = var15.dynamicValues[0][1];
                  class211.widgetSettings[var9] = 1 - class211.widgetSettings[var9];
                  class77.method1483(var9);
               }
            }

            if(var2 == 49) {
               var8 = Client.cachedPlayers[var3];
               if(var8 != null) {
                  Client.field1022 = var6;
                  Client.field970 = var7;
                  Client.field1195 = 2;
                  Client.field1024 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(161);
                  Client.secretPacketBuffer1.putShort(var3);
                  Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
               }
            }

            if(var2 == 10) {
               var14 = Client.cachedNPCs[var3];
               if(var14 != null) {
                  Client.field1022 = var6;
                  Client.field970 = var7;
                  Client.field1195 = 2;
                  Client.field1024 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(43);
                  Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
                  Client.secretPacketBuffer1.method3193(var3);
               }
            }

            if(var2 == 50) {
               var8 = Client.cachedPlayers[var3];
               if(var8 != null) {
                  Client.field1022 = var6;
                  Client.field970 = var7;
                  Client.field1195 = 2;
                  Client.field1024 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(28);
                  Client.secretPacketBuffer1.method3183(class50.field624[82]?1:0);
                  Client.secretPacketBuffer1.method3192(var3);
               }
            }

            if(var2 == 21) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(199);
               Client.secretPacketBuffer1.method3191(var3);
               Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.method3191(var1 + class23.baseY);
               Client.secretPacketBuffer1.method3191(var0 + class61.baseX);
            }

            if(var2 == 32) {
               Client.secretPacketBuffer1.putOpcode(83);
               Client.secretPacketBuffer1.method3342(var1);
               Client.secretPacketBuffer1.method3192(Client.field1072);
               Client.secretPacketBuffer1.method3201(NPC.field1375);
               Client.secretPacketBuffer1.method3191(var3);
               Client.secretPacketBuffer1.method3191(var0);
               Client.field1026 = 0;
               class268.field3681 = class177.method3390(var1);
               Client.field1027 = var0;
            }

            if(var2 == 47) {
               var8 = Client.cachedPlayers[var3];
               if(var8 != null) {
                  Client.field1022 = var6;
                  Client.field970 = var7;
                  Client.field1195 = 2;
                  Client.field1024 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(77);
                  Client.secretPacketBuffer1.method3183(class50.field624[82]?1:0);
                  Client.secretPacketBuffer1.putShort(var3);
               }
            }

            if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class61.region.method2713();
               } else {
                  class61.region.method2678(class92.plane, var0, var1, true);
               }
            }

            if(var2 == 41) {
               Client.secretPacketBuffer1.putOpcode(115);
               Client.secretPacketBuffer1.method3191(var3);
               Client.secretPacketBuffer1.method3193(var0);
               Client.secretPacketBuffer1.method3342(var1);
               Client.field1026 = 0;
               class268.field3681 = class177.method3390(var1);
               Client.field1027 = var0;
            }

            if(var2 == 29) {
               Client.secretPacketBuffer1.putOpcode(253);
               Client.secretPacketBuffer1.putInt(var1);
               var15 = class177.method3390(var1);
               if(var15.dynamicValues != null && var15.dynamicValues[0][0] == 5) {
                  var9 = var15.dynamicValues[0][1];
                  if(class211.widgetSettings[var9] != var15.field2766[0]) {
                     class211.widgetSettings[var9] = var15.field2766[0];
                     class77.method1483(var9);
                  }
               }
            }

            if(var2 == 16) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(34);
               Client.secretPacketBuffer1.method3193(Client.field1090);
               Client.secretPacketBuffer1.putInt(Frames.field2152);
               Client.secretPacketBuffer1.method3191(var1 + class23.baseY);
               Client.secretPacketBuffer1.method3191(var3);
               Client.secretPacketBuffer1.method3184(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.putShort(class18.field324);
               Client.secretPacketBuffer1.method3192(var0 + class61.baseX);
            }

            if(var2 == 46) {
               var8 = Client.cachedPlayers[var3];
               if(var8 != null) {
                  Client.field1022 = var6;
                  Client.field970 = var7;
                  Client.field1195 = 2;
                  Client.field1024 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(194);
                  Client.secretPacketBuffer1.method3183(class50.field624[82]?1:0);
                  Client.secretPacketBuffer1.method3192(var3);
               }
            }

            if(var2 == 1003) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               var14 = Client.cachedNPCs[var3];
               if(var14 != null) {
                  NPCComposition var12 = var14.composition;
                  if(var12.configs != null) {
                     var12 = var12.method4685();
                  }

                  if(var12 != null) {
                     Client.secretPacketBuffer1.putOpcode(89);
                     Client.secretPacketBuffer1.method3192(var12.id);
                  }
               }
            }

            if(var2 == 26) {
               Client.secretPacketBuffer1.putOpcode(169);

               for(WidgetNode var18 = (WidgetNode)Client.componentTable.method3548(); var18 != null; var18 = (WidgetNode)Client.componentTable.method3556()) {
                  if(var18.field816 == 0 || var18.field816 == 3) {
                     WorldMapType3.method231(var18, true);
                  }
               }

               if(Client.field1147 != null) {
                  CombatInfo1.method1515(Client.field1147);
                  Client.field1147 = null;
               }
            }

            if(var2 == 42) {
               Client.secretPacketBuffer1.putOpcode(222);
               Client.secretPacketBuffer1.method3342(var1);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.method3193(var0);
               Client.field1026 = 0;
               class268.field3681 = class177.method3390(var1);
               Client.field1027 = var0;
            }

            if(var2 == 17) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(117);
               Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.method3193(var0 + class61.baseX);
               Client.secretPacketBuffer1.putShort(Client.field1072);
               Client.secretPacketBuffer1.method3193(class23.baseY + var1);
               Client.secretPacketBuffer1.putShort(var3);
               Client.secretPacketBuffer1.method3201(NPC.field1375);
            }

            if(var2 == 7) {
               var14 = Client.cachedNPCs[var3];
               if(var14 != null) {
                  Client.field1022 = var6;
                  Client.field970 = var7;
                  Client.field1195 = 2;
                  Client.field1024 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(142);
                  Client.secretPacketBuffer1.method3191(var3);
                  Client.secretPacketBuffer1.method3203(Frames.field2152);
                  Client.secretPacketBuffer1.putShort(class18.field324);
                  Client.secretPacketBuffer1.method3193(Client.field1090);
                  Client.secretPacketBuffer1.method3185(class50.field624[82]?1:0);
               }
            }

            if(var2 == 22) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(56);
               Client.secretPacketBuffer1.method3192(var3);
               Client.secretPacketBuffer1.putByte(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.method3192(var1 + class23.baseY);
               Client.secretPacketBuffer1.method3191(class61.baseX + var0);
            }

            if(var2 == 14) {
               var8 = Client.cachedPlayers[var3];
               if(var8 != null) {
                  Client.field1022 = var6;
                  Client.field970 = var7;
                  Client.field1195 = 2;
                  Client.field1024 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(136);
                  Client.secretPacketBuffer1.method3342(Frames.field2152);
                  Client.secretPacketBuffer1.method3191(var3);
                  Client.secretPacketBuffer1.method3191(Client.field1090);
                  Client.secretPacketBuffer1.putShort(class18.field324);
                  Client.secretPacketBuffer1.method3184(class50.field624[82]?1:0);
               }
            }

            if(var2 == 1001) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(189);
               Client.secretPacketBuffer1.method3185(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.method3193(class23.baseY + var1);
               Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.method3192(class61.baseX + var0);
            }

            if(var2 == 15) {
               var8 = Client.cachedPlayers[var3];
               if(var8 != null) {
                  Client.field1022 = var6;
                  Client.field970 = var7;
                  Client.field1195 = 2;
                  Client.field1024 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.secretPacketBuffer1.putOpcode(81);
                  Client.secretPacketBuffer1.method3201(NPC.field1375);
                  Client.secretPacketBuffer1.putShort(var3);
                  Client.secretPacketBuffer1.method3185(class50.field624[82]?1:0);
                  Client.secretPacketBuffer1.putShort(Client.field1072);
               }
            }

            if(var2 == 18) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(218);
               Client.secretPacketBuffer1.method3183(class50.field624[82]?1:0);
               Client.secretPacketBuffer1.putShort(var0 + class61.baseX);
               Client.secretPacketBuffer1.putShort(class23.baseY + var1);
               Client.secretPacketBuffer1.method3191(var3);
            }

            if(var2 == 2) {
               Client.field1022 = var6;
               Client.field970 = var7;
               Client.field1195 = 2;
               Client.field1024 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.secretPacketBuffer1.putOpcode(175);
               Client.secretPacketBuffer1.method3192(Client.field1072);
               Client.secretPacketBuffer1.method3342(NPC.field1375);
               Client.secretPacketBuffer1.method3192(var1 + class23.baseY);
               Client.secretPacketBuffer1.method3193(var3 >> 14 & 32767);
               Client.secretPacketBuffer1.method3192(var0 + class61.baseX);
               Client.secretPacketBuffer1.method3183(class50.field624[82]?1:0);
            }

            if(Client.field1068 != 0) {
               Client.field1068 = 0;
               CombatInfo1.method1515(class177.method3390(Frames.field2152));
            }

            if(Client.field1071) {
               Varbit.method4453();
            }

            if(class268.field3681 != null && Client.field1026 == 0) {
               CombatInfo1.method1515(class268.field3681);
            }

         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/Class;",
      garbageValue = "92"
   )
   public static Class method491(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }
}
