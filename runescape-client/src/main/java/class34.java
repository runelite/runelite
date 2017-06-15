import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
public class class34 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -981818241
   )
   int field483;
   @ObfuscatedName("c")
   int[][] field484;
   @ObfuscatedName("j")
   LinkedList field486;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 777804899
   )
   int field487;
   @ObfuscatedName("z")
   class22 field488;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -753253671
   )
   int field490;
   @ObfuscatedName("n")
   HashMap field491;
   @ObfuscatedName("o")
   SpritePixels field493;
   @ObfuscatedName("q")
   List field494;
   @ObfuscatedName("a")
   final HashMap field496;
   @ObfuscatedName("g")
   static final Coordinates field497;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1866809129
   )
   int field498;
   @ObfuscatedName("en")
   @ObfuscatedGetter(
      intValue = -1181414759
   )
   static int field501;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1516715328"
   )
   void method354(int var1, int var2, int var3) {
      if(this.field493 != null) {
         if(this.field498 * 64 == var3) {
            this.field493.method4949(var1, var2);
         } else {
            this.field493.method4972(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIILclass28;B)V",
      garbageValue = "7"
   )
   void method357(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label55:
         for(int var7 = var2; var7 < var4 + var2; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field430; ++var9) {
               class31[] var10 = var5.field429[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method386(var13.field455);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, var6 + this.field483 * 64, this.field487 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field488 != null) {
                           var16 = new Coordinates(var9 + this.field488.field423, this.field488.field424 * 64 + var6, this.field488.field420 * 64 + var7);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var17.field423 + var9, var17.field424 * 64 + var6 + var17.method611() * 8, var7 + var17.field420 * 64 + var17.method612() * 8);
                        }

                        class39 var18 = new class39(var14.field3301, var16, var15, this.method378(var14));
                        this.field491.put(var8, var18);
                        continue label55;
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
      garbageValue = "1003373705"
   )
   void method358(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(this.field483 == var3.field385.worldX >> 6 && var3.field385.worldY >> 6 == this.field487) {
            class39 var4 = new class39(var3.field384, var3.field385, var3.field385, this.method387(var3.field384));
            this.field494.add(var4);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILclass46;[Lclass34;[LModIcon;I)Z",
      garbageValue = "1150421511"
   )
   boolean method359(int var1, class46 var2, class34[] var3, ModIcon[] var4) {
      if(!this.method412(var1)) {
         return false;
      } else if(this.field488 == null && this.field486.isEmpty()) {
         return false;
      } else {
         this.method368(var3);
         this.field493.method4932();
         if(this.field488 != null) {
            this.method363(var2, var3, var4);
         } else {
            this.method466(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "-694525425"
   )
   void method360(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method376(var1, var2, var4, var3);
      this.method472(var1, var2, var4, var3);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "1148668964"
   )
   void method361(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field491.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field541))) {
            Area var6 = Area.field3304[var5.field541];
            this.method389(var6, var5.field539, var5.field544, var2, var3);
         }
      }

      this.method364(var1, var2, var3);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IILclass28;[LModIcon;I)V",
      garbageValue = "-930276626"
   )
   void method362(int var1, int var2, class28 var3, ModIcon[] var4) {
      for(int var5 = 0; var5 < var3.field430; ++var5) {
         class31[] var6 = var3.field429[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               int var11 = var9.field453;
               boolean var10 = var11 >= class221.field2839.field2834 && var11 <= class221.field2840.field2834;
               if(!var10) {
                  int var13 = var9.field453;
                  boolean var12 = var13 == class221.field2822.field2834;
                  if(!var12) {
                     continue;
                  }
               }

               ObjectComposition var14 = class29.getObjectDefinition(var9.field455);
               if(var14.mapSceneId != -1) {
                  if(var14.mapSceneId != 46 && var14.mapSceneId != 52) {
                     var4[var14.mapSceneId].method4916(this.field498 * var1, this.field498 * (63 - var2), this.field498 * 2, this.field498 * 2);
                  } else {
                     var4[var14.mapSceneId].method4916(var1 * this.field498, this.field498 * (63 - var2), this.field498 * 2 + 1, this.field498 * 2 + 1);
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass46;[Lclass34;[LModIcon;I)V",
      garbageValue = "-771392617"
   )
   void method363(class46 var1, class34[] var2, ModIcon[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method467(var4, var5, this.field488, var1);
            this.method367(var4, var5, this.field488, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method434(var4, var5, this.field488, var1, var3);
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "68841199"
   )
   void method364(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field494.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.field3304[var5.field541];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4175()))) {
            this.method389(var6, var5.field539, var5.field544, var2, var3);
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;I)V",
      garbageValue = "1705148958"
   )
   void method367(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field430; ++var5) {
         int var6 = var3.field419[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class17.method131(var6, this.field490);
            if(var3.field427[var5][var1][var2] == 0) {
               Rasterizer2D.method4826(var1 * this.field498, (63 - var2) * this.field498, this.field498, this.field498, var7);
            } else {
               var4.method634(var1 * this.field498, this.field498 * (63 - var2), 0, var7, this.field498, this.field498, var3.field427[var5][var1][var2], var3.field428[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Lclass34;I)Z",
      garbageValue = "-1544922601"
   )
   boolean method368(class34[] var1) {
      if(this.field484 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field488 != null) {
            this.method371(0, 0, 64, 64, this.field488, var2);
         } else {
            Iterator var3 = this.field486.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method371(var4.method615() * 8, var4.method613() * 8, 8, 8, var4, var2);
            }
         }

         this.method370(var1, var2);
         this.method374(var2);
         return true;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([Lclass34;Lclass43;I)V",
      garbageValue = "-483415344"
   )
   void method370(class34[] var1, class43 var2) {
      class228[] var3 = new class228[]{class228.field3156, class228.field3155, class228.field3165, class228.field3160, class228.field3162, class228.field3157, class228.field3161, class228.field3159};
      class228[] var5 = var3;

      for(int var6 = 0; var6 < var5.length; ++var6) {
         class228 var7 = var5[var6];
         if(var1[var7.vmethod4906()] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch(var7.field3163) {
            case 0:
               var13 = 59;
               var11 = 5;
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
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 4:
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 5:
               var12 = 59;
               var10 = 5;
               break;
            case 6:
               var8 = 59;
               var10 = 5;
               break;
            case 7:
               var9 = 59;
               var11 = 5;
            }

            this.method423(var12, var13, var8, var9, var10, var11, var1[var7.vmethod4906()], var2);
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IIIILclass28;Lclass43;I)V",
      garbageValue = "-132789688"
   )
   void method371(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var1 + var3; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field425[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = Preferences.method1512(var9);
               var6.method589(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILclass28;B)I",
      garbageValue = "69"
   )
   int method373(int var1, int var2, class28 var3) {
      return var3.field425[0][var1][var2] == 0?this.field490:this.field484[var1][var2];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass43;I)V",
      garbageValue = "4622490"
   )
   void method374(class43 var1) {
      this.field484 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field484[var2][var3] = var1.method591(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)V",
      garbageValue = "-1431381541"
   )
   void method375(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field430; ++var4) {
         class31[] var5 = var3.field429[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               if(ISAACCipher.method3320(var8.field453)) {
                  ObjectComposition var9 = class29.getObjectDefinition(var8.field455);
                  int var10 = var9.field3445 != 0?-3407872:-3355444;
                  if(class221.field2825.field2834 == var8.field453) {
                     this.method396(var1, var2, var8.field454, var10);
                  }

                  if(var8.field453 == class221.field2819.field2834) {
                     this.method396(var1, var2, var8.field454, -3355444);
                     this.method396(var1, var2, var8.field454 + 1, var10);
                  }

                  if(class221.field2841.field2834 == var8.field453) {
                     if(var8.field454 == 0) {
                        Rasterizer2D.method4834(var1 * this.field498, this.field498 * (63 - var2), 1, var10);
                     }

                     if(var8.field454 == 1) {
                        Rasterizer2D.method4834(this.field498 + this.field498 * var1 - 1, (63 - var2) * this.field498, 1, var10);
                     }

                     if(var8.field454 == 2) {
                        Rasterizer2D.method4834(this.field498 * var1 + this.field498 - 1, this.field498 * (63 - var2) + this.field498 - 1, 1, var10);
                     }

                     if(var8.field454 == 3) {
                        Rasterizer2D.method4834(this.field498 * var1, this.field498 + (63 - var2) * this.field498 - 1, 1, var10);
                     }
                  }

                  if(var8.field453 == class221.field2823.field2834) {
                     int var11 = var8.field454 % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field498; ++var12) {
                           Rasterizer2D.method4834(var1 * this.field498 + var12, (64 - var2) * this.field498 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field498; ++var12) {
                           Rasterizer2D.method4834(var1 * this.field498 + var12, var12 + (63 - var2) * this.field498, 1, var10);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-2005686871"
   )
   void method376(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field491.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)(var5 * (float)var9.worldX + (float)var1 - var6);
         int var11 = (int)((float)(var4 + var2) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field539 = var10;
            var12.field544 = var11;
            Area var13 = Area.field3304[var12.field541];
            if(!var3.contains(Integer.valueOf(var13.method4175()))) {
               this.method379(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "1933805961"
   )
   void method377(HashSet var1, List var2) {
      this.field491.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method234() == this.field483 && var4.method235() == this.field487) {
            this.field486.add(var4);
            this.method357(var4.method615() * 8, var4.method613() * 8, 8, 8, var4);
         }
      }

      this.method358(var2);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(LArea;I)Lclass33;",
      garbageValue = "-700516202"
   )
   class33 method378(Area var1) {
      if(var1.name != null && this.field496 != null && this.field496.get(class24.field381) != null) {
         class24 var2 = class24.method193(var1.field3315);
         if(var2 == null) {
            return null;
         } else {
            Font var3 = (Font)this.field496.get(var2);
            if(var3 == null) {
               return null;
            } else {
               int var4 = var3.method4630(var1.name, 1000000);
               String[] var5 = new String[var4];
               var3.method4628(var1.name, (int[])null, var5);
               int var6 = var5.length * var3.field3643 / 2;
               int var7 = 0;
               String[] var8 = var5;

               for(int var9 = 0; var9 < var8.length; ++var9) {
                  String var10 = var8[var9];
                  int var11 = var3.method4696(var10);
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

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIFI)V",
      garbageValue = "2036538684"
   )
   void method379(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.field3304[var1.field541];
      this.method458(var5, var2, var3);
      this.method441(var1, var5, var2, var3, var4);
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field483 = var1;
      this.field487 = var2;
      this.field486 = new LinkedList();
      this.field494 = new LinkedList();
      this.field491 = new HashMap();
      this.field490 = var3 | -16777216;
      this.field496 = var4;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(LSpritePixels;Lclass257;I)I",
      garbageValue = "2125312960"
   )
   int method384(SpritePixels var1, class257 var2) {
      switch(var2.field3551) {
      case 0:
         return -var1.width / 2;
      case 2:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(LSpritePixels;Lclass239;B)I",
      garbageValue = "94"
   )
   int method385(SpritePixels var1, class239 var2) {
      switch(var2.field3282) {
      case 0:
         return -var1.height / 2;
      case 2:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IB)LArea;",
      garbageValue = "-62"
   )
   Area method386(int var1) {
      ObjectComposition var2 = class29.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.field3304[var2.mapIconId]:null;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(II)Lclass33;",
      garbageValue = "-1252364019"
   )
   class33 method387(int var1) {
      Area var2 = Area.field3304[var1];
      return this.method378(var2);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(LArea;IIIIS)V",
      garbageValue = "3758"
   )
   void method389(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4189(false);
      if(var6 != null) {
         var6.method4950(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method4824(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method4824(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "-529263722"
   )
   List method390() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field494);
      var1.addAll(this.field491.values());
      return var1;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(IIIIII)Ljava/util/List;",
      garbageValue = "-1609190135"
   )
   List method391(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var1 + var3 && var5 < var2 + var3) {
            Iterator var7 = this.field491.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method516(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field494.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method516(var4, var5)) {
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

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "120"
   )
   int method392(int var1, int var2) {
      if(this.field488 != null) {
         return this.field488.method233(var1, var2);
      } else {
         if(!this.field486.isEmpty()) {
            Iterator var3 = this.field486.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method610(var1, var2)) {
                  return var4.method233(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1110980674"
   )
   void method396(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method4836(this.field498 * var1, (63 - var2) * this.field498, this.field498, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method4834(var1 * this.field498, (63 - var2) * this.field498, this.field498, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method4836(this.field498 + this.field498 * var1 - 1, this.field498 * (63 - var2), this.field498, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method4834(this.field498 * var1, (63 - var2) * this.field498 + this.field498 - 1, this.field498, var4);
      }

   }

   static {
      field497 = new Coordinates();
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(IILclass28;B)V",
      garbageValue = "-1"
   )
   void method409(int var1, int var2, class28 var3) {
      field497.method3824(0, var1, var2);

      for(int var4 = 0; var4 < var3.field430; ++var4) {
         class31[] var5 = var3.field429[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method386(var8.field455);
               if(var9 != null) {
                  class39 var10 = (class39)this.field491.get(field497);
                  if(var10 != null) {
                     if(var10.field541 != var9.field3301) {
                        class39 var16 = new class39(var9.field3301, var10.field545, var10.field538, this.method378(var9));
                        this.field491.put(new Coordinates(field497), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field545.plane - var10.field538.plane;
                     var10.field538.plane = var4;
                     var10.field545.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field483 * 64 + var1, var2 + this.field487 * 64);
                  Coordinates var12 = null;
                  if(this.field488 != null) {
                     var12 = new Coordinates(this.field488.field423 + var4, this.field488.field424 * 64 + var1, var2 + this.field488.field420 * 64);
                  } else {
                     Iterator var13 = this.field486.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method610(var1, var2)) {
                           var12 = new Coordinates(var14.field423 + var4, var1 + var14.field424 * 64 + var14.method611() * 8, var14.field420 * 64 + var2 + var14.method612() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3301, var12, var11, this.method378(var9));
                     this.field491.put(new Coordinates(field497), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field491.remove(field497);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1989471559"
   )
   boolean method412(int var1) {
      if(this.field493 != null && var1 == this.field498) {
         return false;
      } else {
         this.field498 = var1;
         this.field493 = new SpritePixels(this.field498 * 64, this.field498 * 64);
         return true;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass34;Lclass43;I)V",
      garbageValue = "-1600933772"
   )
   void method423(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method392(var1 + var9, var2 + var10);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = Preferences.method1512(var11);
               var8.method589(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;[LModIcon;B)V",
      garbageValue = "65"
   )
   void method434(int var1, int var2, class28 var3, class46 var4, ModIcon[] var5) {
      this.method375(var1, var2, var3);
      this.method362(var1, var2, var3, var5);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass22;Ljava/util/List;I)V",
      garbageValue = "-1512395254"
   )
   void method436(class22 var1, List var2) {
      this.field491.clear();
      this.field488 = var1;
      this.method357(0, 0, 64, 64, this.field488);
      this.method358(var2);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(Lclass39;LArea;IIFI)V",
      garbageValue = "1489123066"
   )
   void method441(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field542 != null) {
         if(var1.field542.field479.method191(var5)) {
            Font var6 = (Font)this.field496.get(var1.field542.field479);
            var6.method4636(var1.field542.field473, var3 - var1.field542.field474 / 2, var4, var1.field542.field474, var1.field542.field475, -16777216 | var2.field3305, 0, 1, 0, var6.field3643 / 2);
         }
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(LArea;III)V",
      garbageValue = "1402203214"
   )
   void method458(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4189(false);
      if(var4 != null) {
         int var5 = this.method384(var4, var1.field3314);
         int var6 = this.method385(var4, var1.field3310);
         var4.method4950(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2118409006"
   )
   void method460() {
      if(this.field488 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method409(var1, var2, this.field488);
            }
         }
      } else {
         Iterator var5 = this.field486.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method615() * 8; var3 < var6.method615() * 8 + 8; ++var3) {
               for(int var4 = var6.method613() * 8; var4 < var6.method613() * 8 + 8; ++var4) {
                  this.method409(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass46;[LModIcon;I)V",
      garbageValue = "647364388"
   )
   void method466(class46 var1, ModIcon[] var2) {
      Iterator var3 = this.field486.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method615() * 8; var5 < var4.method615() * 8 + 8; ++var5) {
            for(var6 = var4.method613() * 8; var6 < var4.method613() * 8 + 8; ++var6) {
               this.method467(var5, var6, var4, var1);
               this.method367(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field486.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method615() * 8; var5 < var4.method615() * 8 + 8; ++var5) {
            for(var6 = var4.method613() * 8; var6 < var4.method613() * 8 + 8; ++var6) {
               this.method434(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;I)V",
      garbageValue = "21019832"
   )
   void method467(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field425[0][var1][var2] - 1;
      int var6 = var3.field419[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method4826(this.field498 * var1, (63 - var2) * this.field498, this.field498, this.field498, this.field490);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class17.method131(var6, this.field490);
      }

      if(var6 > -1 && var3.field427[0][var1][var2] == 0) {
         Rasterizer2D.method4826(this.field498 * var1, (63 - var2) * this.field498, this.field498, this.field498, var7);
      } else {
         int var8 = this.method373(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method4826(var1 * this.field498, (63 - var2) * this.field498, this.field498, this.field498, var8);
         } else {
            var4.method634(var1 * this.field498, (63 - var2) * this.field498, var8, var7, this.field498, this.field498, var3.field427[0][var1][var2], var3.field428[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;IB)V",
      garbageValue = "81"
   )
   void method472(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field494.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field538.worldX % 64;
         int var9 = var7.field538.worldY % 64;
         var7.field539 = (int)(var5 * (float)var8 + (float)var1);
         var7.field544 = (int)((float)var2 + var5 * (float)(63 - var9));
         if(!var3.contains(Integer.valueOf(var7.field541))) {
            this.method379(var7, var7.field539, var7.field544, var5);
         }
      }

   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1188083702"
   )
   static final void method479() {
      int var0;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var35;
      if(Client.field951 == 37) {
         var0 = Client.secretPacketBuffer2.readUnsignedByte();
         var35 = class27.field414 + (var0 >> 4 & 7);
         var2 = class29.field437 + (var0 & 7);
         var3 = Client.secretPacketBuffer2.readUnsignedByte();
         var4 = var3 >> 2;
         var5 = var3 & 3;
         var6 = Client.field968[var4];
         if(var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
            class174.method3253(Player.plane, var35, var2, var6, -1, var4, var5, 0, -1);
         }

      } else {
         int var7;
         int var8;
         int var9;
         int var12;
         if(Client.field951 == 173) {
            var0 = Client.secretPacketBuffer2.method3070();
            byte var1 = Client.secretPacketBuffer2.method3063();
            var2 = Client.secretPacketBuffer2.method3070();
            var3 = Client.secretPacketBuffer2.method3060();
            var4 = class27.field414 + (var3 >> 4 & 7);
            var5 = class29.field437 + (var3 & 7);
            var6 = Client.secretPacketBuffer2.method3201();
            var7 = var6 >> 2;
            var8 = var6 & 3;
            var9 = Client.field968[var7];
            byte var10 = Client.secretPacketBuffer2.method3165();
            byte var11 = Client.secretPacketBuffer2.method3165();
            var12 = Client.secretPacketBuffer2.method3070();
            int var13 = Client.secretPacketBuffer2.method3068();
            byte var14 = Client.secretPacketBuffer2.readByte();
            Player var15;
            if(var0 == Client.localInteractingIndex) {
               var15 = class20.localPlayer;
            } else {
               var15 = Client.cachedPlayers[var0];
            }

            if(var15 != null) {
               ObjectComposition var16 = class29.getObjectDefinition(var13);
               int var17;
               int var18;
               if(var8 != 1 && var8 != 3) {
                  var17 = var16.sizeX;
                  var18 = var16.sizeY;
               } else {
                  var17 = var16.sizeY;
                  var18 = var16.sizeX;
               }

               int var19 = (var17 >> 1) + var4;
               int var20 = var4 + (var17 + 1 >> 1);
               int var21 = var5 + (var18 >> 1);
               int var22 = (var18 + 1 >> 1) + var5;
               int[][] var23 = class61.tileHeights[Player.plane];
               int var24 = var23[var19][var21] + var23[var20][var21] + var23[var19][var22] + var23[var20][var22] >> 2;
               int var25 = (var17 << 6) + (var4 << 7);
               int var26 = (var5 << 7) + (var18 << 6);
               Model var27 = var16.method4394(var7, var8, var23, var25, var24, var26);
               if(var27 != null) {
                  class174.method3253(Player.plane, var4, var5, var9, -1, 0, 0, var12 + 1, var2 + 1);
                  var15.field871 = var12 + Client.gameCycle;
                  var15.field882 = var2 + Client.gameCycle;
                  var15.model = var27;
                  var15.field873 = var4 * 128 + var17 * 64;
                  var15.field875 = var5 * 128 + var18 * 64;
                  var15.field874 = var24;
                  byte var28;
                  if(var10 > var11) {
                     var28 = var10;
                     var10 = var11;
                     var11 = var28;
                  }

                  if(var1 > var14) {
                     var28 = var1;
                     var1 = var14;
                     var14 = var28;
                  }

                  var15.field870 = var10 + var4;
                  var15.field885 = var11 + var4;
                  var15.field878 = var1 + var5;
                  var15.field880 = var14 + var5;
               }
            }
         }

         if(Client.field951 == 190) {
            var0 = Client.secretPacketBuffer2.method3023();
            var35 = Client.secretPacketBuffer2.method3062();
            var2 = (var35 >> 4 & 7) + class27.field414;
            var3 = class29.field437 + (var35 & 7);
            var4 = Client.secretPacketBuffer2.method3201();
            var5 = var4 >> 2;
            var6 = var4 & 3;
            var7 = Client.field968[var5];
            if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
               class174.method3253(Player.plane, var2, var3, var7, var0, var5, var6, 0, -1);
            }

         } else if(Client.field951 == 66) {
            var0 = Client.secretPacketBuffer2.readUnsignedByte();
            var35 = class27.field414 + (var0 >> 4 & 7);
            var2 = (var0 & 7) + class29.field437;
            var3 = Client.secretPacketBuffer2.readUnsignedShort();
            var4 = Client.secretPacketBuffer2.readUnsignedShort();
            var5 = Client.secretPacketBuffer2.readUnsignedShort();
            if(var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
               Deque var38 = Client.groundItemDeque[Player.plane][var35][var2];
               if(var38 != null) {
                  for(Item var30 = (Item)var38.method3487(); var30 != null; var30 = (Item)var38.method3512()) {
                     if(var30.id == (var3 & 32767) && var4 == var30.quantity) {
                        var30.quantity = var5;
                        break;
                     }
                  }

                  class47.groundItemSpawned(var35, var2);
               }
            }

         } else if(Client.field951 == 137) {
            var0 = Client.secretPacketBuffer2.readUnsignedByte();
            var35 = (var0 >> 4 & 7) + class27.field414;
            var2 = class29.field437 + (var0 & 7);
            var3 = Client.secretPacketBuffer2.readUnsignedShort();
            var4 = Client.secretPacketBuffer2.readUnsignedByte();
            var5 = Client.secretPacketBuffer2.readUnsignedShort();
            if(var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
               var35 = var35 * 128 + 64;
               var2 = var2 * 128 + 64;
               GraphicsObject var29 = new GraphicsObject(var3, Player.plane, var35, var2, class77.method1438(var35, var2, Player.plane) - var4, var5, Client.gameCycle);
               Client.field1033.method3505(var29);
            }

         } else {
            if(Client.field951 == 98) {
               var0 = Client.secretPacketBuffer2.readUnsignedByte();
               var35 = class27.field414 + (var0 >> 4 & 7);
               var2 = class29.field437 + (var0 & 7);
               var3 = Client.secretPacketBuffer2.readUnsignedShort();
               var4 = Client.secretPacketBuffer2.readUnsignedByte();
               var5 = var4 >> 4 & 15;
               var6 = var4 & 7;
               var7 = Client.secretPacketBuffer2.readUnsignedByte();
               if(var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
                  var8 = var5 + 1;
                  if(class20.localPlayer.pathX[0] >= var35 - var8 && class20.localPlayer.pathX[0] <= var35 + var8 && class20.localPlayer.pathY[0] >= var2 - var8 && class20.localPlayer.pathY[0] <= var8 + var2 && Client.field1041 != 0 && var6 > 0 && Client.field931 < 50) {
                     Client.field1036[Client.field931] = var3;
                     Client.field1155[Client.field931] = var6;
                     Client.field1150[Client.field931] = var7;
                     Client.audioEffects[Client.field931] = null;
                     Client.field1170[Client.field931] = (var2 << 8) + (var35 << 16) + var5;
                     ++Client.field931;
                  }
               }
            }

            if(Client.field951 == 209) {
               var0 = Client.secretPacketBuffer2.method3023();
               var35 = Client.secretPacketBuffer2.readUnsignedByte();
               var2 = var35 >> 2;
               var3 = var35 & 3;
               var4 = Client.field968[var2];
               var5 = Client.secretPacketBuffer2.method3201();
               var6 = class27.field414 + (var5 >> 4 & 7);
               var7 = (var5 & 7) + class29.field437;
               if(var6 >= 0 && var7 >= 0 && var6 < 103 && var7 < 103) {
                  if(var4 == 0) {
                     WallObject var31 = class17.region.method2600(Player.plane, var6, var7);
                     if(var31 != null) {
                        var9 = var31.hash >> 14 & 32767;
                        if(var2 == 2) {
                           var31.renderable1 = new DynamicObject(var9, 2, var3 + 4, Player.plane, var6, var7, var0, false, var31.renderable1);
                           var31.renderable2 = new DynamicObject(var9, 2, var3 + 1 & 3, Player.plane, var6, var7, var0, false, var31.renderable2);
                        } else {
                           var31.renderable1 = new DynamicObject(var9, var2, var3, Player.plane, var6, var7, var0, false, var31.renderable1);
                        }
                     }
                  }

                  if(var4 == 1) {
                     DecorativeObject var39 = class17.region.method2601(Player.plane, var6, var7);
                     if(var39 != null) {
                        var9 = var39.hash >> 14 & 32767;
                        if(var2 != 4 && var2 != 5) {
                           if(var2 == 6) {
                              var39.renderable1 = new DynamicObject(var9, 4, var3 + 4, Player.plane, var6, var7, var0, false, var39.renderable1);
                           } else if(var2 == 7) {
                              var39.renderable1 = new DynamicObject(var9, 4, (var3 + 2 & 3) + 4, Player.plane, var6, var7, var0, false, var39.renderable1);
                           } else if(var2 == 8) {
                              var39.renderable1 = new DynamicObject(var9, 4, var3 + 4, Player.plane, var6, var7, var0, false, var39.renderable1);
                              var39.renderable2 = new DynamicObject(var9, 4, (var3 + 2 & 3) + 4, Player.plane, var6, var7, var0, false, var39.renderable2);
                           }
                        } else {
                           var39.renderable1 = new DynamicObject(var9, 4, var3, Player.plane, var6, var7, var0, false, var39.renderable1);
                        }
                     }
                  }

                  if(var4 == 2) {
                     GameObject var40 = class17.region.method2590(Player.plane, var6, var7);
                     if(var2 == 11) {
                        var2 = 10;
                     }

                     if(var40 != null) {
                        var40.renderable = new DynamicObject(var40.hash >> 14 & 32767, var2, var3, Player.plane, var6, var7, var0, false, var40.renderable);
                     }
                  }

                  if(var4 == 3) {
                     GroundObject var41 = class17.region.method2603(Player.plane, var6, var7);
                     if(var41 != null) {
                        var41.renderable = new DynamicObject(var41.hash >> 14 & 32767, 22, var3, Player.plane, var6, var7, var0, false, var41.renderable);
                     }
                  }
               }

            } else {
               Item var32;
               if(Client.field951 == 4) {
                  var0 = Client.secretPacketBuffer2.method3068();
                  var35 = Client.secretPacketBuffer2.readUnsignedByte();
                  var2 = class27.field414 + (var35 >> 4 & 7);
                  var3 = (var35 & 7) + class29.field437;
                  var4 = Client.secretPacketBuffer2.method3070();
                  if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                     var32 = new Item();
                     var32.id = var4;
                     var32.quantity = var0;
                     if(Client.groundItemDeque[Player.plane][var2][var3] == null) {
                        Client.groundItemDeque[Player.plane][var2][var3] = new Deque();
                     }

                     Client.groundItemDeque[Player.plane][var2][var3].method3505(var32);
                     class47.groundItemSpawned(var2, var3);
                  }

               } else if(Client.field951 != 111) {
                  if(Client.field951 == 165) {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var35 = class27.field414 + (var0 >> 4 & 7);
                     var2 = (var0 & 7) + class29.field437;
                     var3 = var35 + Client.secretPacketBuffer2.readByte();
                     var4 = var2 + Client.secretPacketBuffer2.readByte();
                     var5 = Client.secretPacketBuffer2.readShort();
                     var6 = Client.secretPacketBuffer2.readUnsignedShort();
                     var7 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var8 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var9 = Client.secretPacketBuffer2.readUnsignedShort();
                     int var36 = Client.secretPacketBuffer2.readUnsignedShort();
                     int var37 = Client.secretPacketBuffer2.readUnsignedByte();
                     var12 = Client.secretPacketBuffer2.readUnsignedByte();
                     if(var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                        var35 = var35 * 128 + 64;
                        var2 = var2 * 128 + 64;
                        var3 = var3 * 128 + 64;
                        var4 = var4 * 128 + 64;
                        Projectile var34 = new Projectile(var6, Player.plane, var35, var2, class77.method1438(var35, var2, Player.plane) - var7, Client.gameCycle + var9, var36 + Client.gameCycle, var37, var12, var5, var8);
                        var34.method1653(var3, var4, class77.method1438(var3, var4, Player.plane) - var8, Client.gameCycle + var9);
                        Client.projectiles.method3505(var34);
                     }

                  }
               } else {
                  var0 = Client.secretPacketBuffer2.method3062();
                  var35 = (var0 >> 4 & 7) + class27.field414;
                  var2 = class29.field437 + (var0 & 7);
                  var3 = Client.secretPacketBuffer2.method3070();
                  if(var35 >= 0 && var2 >= 0 && var35 < 104 && var2 < 104) {
                     Deque var33 = Client.groundItemDeque[Player.plane][var35][var2];
                     if(var33 != null) {
                        for(var32 = (Item)var33.method3487(); var32 != null; var32 = (Item)var33.method3512()) {
                           if((var3 & 32767) == var32.id) {
                              var32.unlink();
                              break;
                           }
                        }

                        if(var33.method3487() == null) {
                           Client.groundItemDeque[Player.plane][var35][var2] = null;
                        }

                        class47.groundItemSpawned(var35, var2);
                     }
                  }

               }
            }
         }
      }
   }
}
