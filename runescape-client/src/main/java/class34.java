import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public class class34 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhl;"
   )
   static final Coordinates field502;
   @ObfuscatedName("t")
   int[][] field503;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkr;"
   )
   SpritePixels field495;
   @ObfuscatedName("o")
   List field505;
   @ObfuscatedName("r")
   LinkedList field509;
   @ObfuscatedName("i")
   HashMap field506;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ll;"
   )
   class22 field499;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 685083157
   )
   int field497;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 2123097703
   )
   int field500;
   @ObfuscatedName("u")
   final HashMap field507;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -105464995
   )
   int field498;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1395303517
   )
   int field501;

   static {
      field502 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field497 = var1;
      this.field498 = var2;
      this.field509 = new LinkedList();
      this.field505 = new LinkedList();
      this.field506 = new HashMap();
      this.field501 = var3 | -16777216;
      this.field507 = var4;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IS)Z",
      garbageValue = "-18012"
   )
   boolean method402(int var1) {
      if(this.field495 != null && this.field500 == var1) {
         return false;
      } else {
         this.field500 = var1;
         this.field495 = new SpritePixels(this.field500 * 64, this.field500 * 64);
         return true;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IILah;I)V",
      garbageValue = "-1643027605"
   )
   void method361(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field419; ++var4) {
         class31[] var5 = var3.field424[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               int var10 = var8.field454;
               boolean var9 = var10 >= class221.field2834.field2838 && var10 <= class221.field2818.field2838 || var10 == class221.field2819.field2838;
               if(var9) {
                  ObjectComposition var11 = Occluder.getObjectDefinition(var8.field455);
                  int var12 = var11.field3439 != 0?-3407872:-3355444;
                  if(var8.field454 == class221.field2834.field2838) {
                     this.method378(var1, var2, var8.field461, var12);
                  }

                  if(var8.field454 == class221.field2817.field2838) {
                     this.method378(var1, var2, var8.field461, -3355444);
                     this.method378(var1, var2, var8.field461 + 1, var12);
                  }

                  if(var8.field454 == class221.field2818.field2838) {
                     if(var8.field461 == 0) {
                        Rasterizer2D.method5063(this.field500 * var1, this.field500 * (63 - var2), 1, var12);
                     }

                     if(var8.field461 == 1) {
                        Rasterizer2D.method5063(this.field500 * var1 + this.field500 - 1, this.field500 * (63 - var2), 1, var12);
                     }

                     if(var8.field461 == 2) {
                        Rasterizer2D.method5063(this.field500 + this.field500 * var1 - 1, this.field500 * (63 - var2) + this.field500 - 1, 1, var12);
                     }

                     if(var8.field461 == 3) {
                        Rasterizer2D.method5063(this.field500 * var1, this.field500 * (63 - var2) + this.field500 - 1, 1, var12);
                     }
                  }

                  if(var8.field454 == class221.field2819.field2838) {
                     int var13 = var8.field461 % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.field500; ++var14) {
                           Rasterizer2D.method5063(var14 + this.field500 * var1, (64 - var2) * this.field500 - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.field500; ++var14) {
                           Rasterizer2D.method5063(var14 + this.field500 * var1, var14 + this.field500 * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-648839143"
   )
   void method362(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field506.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var9.worldX * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field555 = var10;
            var12.field553 = var11;
            Area var13 = class3.field24[var12.field552];
            if(!var3.contains(Integer.valueOf(var13.method4397()))) {
               this.method375(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILah;[Ljz;I)V",
      garbageValue = "-629736942"
   )
   void method440(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field419; ++var5) {
         class31[] var6 = var3.field424[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(class238.method4362(var9.field454) || ChatLineBuffer.method1945(var9.field454)) {
                  ObjectComposition var10 = Occluder.getObjectDefinition(var9.field455);
                  if(var10.mapSceneId != -1) {
                     if(var10.mapSceneId != 46 && var10.mapSceneId != 52) {
                        var4[var10.mapSceneId].method5149(this.field500 * var1, this.field500 * (63 - var2), this.field500 * 2, this.field500 * 2);
                     } else {
                        var4[var10.mapSceneId].method5149(this.field500 * var1, this.field500 * (63 - var2), this.field500 * 2 + 1, this.field500 * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(Lie;I)Laf;",
      garbageValue = "1711129725"
   )
   class33 method383(Area var1) {
      if(var1.name != null && this.field507 != null && this.field507.get(class24.field364) != null) {
         int var3 = var1.field3298;
         class24[] var4 = new class24[]{class24.field364, class24.field366, class24.field362};
         class24[] var5 = var4;
         int var6 = 0;

         class24 var2;
         while(true) {
            if(var6 >= var5.length) {
               var2 = null;
               break;
            }

            class24 var7 = var5[var6];
            if(var3 == var7.field361) {
               var2 = var7;
               break;
            }

            ++var6;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field507.get(var2);
            if(var14 == null) {
               return null;
            } else {
               var6 = var14.method4838(var1.name, 1000000);
               String[] var15 = new String[var6];
               var14.method4836(var1.name, (int[])null, var15);
               int var8 = var15.length * var14.verticalSpace / 2;
               int var9 = 0;
               String[] var10 = var15;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.method4918(var12);
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILah;Lax;B)V",
      garbageValue = "-6"
   )
   void method352(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field420[0][var1][var2] - 1;
      int var6 = var3.field421[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method5129(this.field500 * var1, this.field500 * (63 - var2), this.field500, this.field500, this.field501);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class15.method95(var6, this.field501);
      }

      if(var6 > -1 && var3.field422[0][var1][var2] == 0) {
         Rasterizer2D.method5129(this.field500 * var1, this.field500 * (63 - var2), this.field500, this.field500, var7);
      } else {
         int var8 = this.method359(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method5129(this.field500 * var1, this.field500 * (63 - var2), this.field500, this.field500, var8);
         } else {
            var4.method679(this.field500 * var1, this.field500 * (63 - var2), var8, var7, this.field500, this.field500, var3.field422[0][var1][var2], var3.field423[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-126706725"
   )
   void method368(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field505.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field547.worldX % 64;
         int var9 = var7.field547.worldY % 64;
         var7.field555 = (int)(var5 * (float)var8 + (float)var1);
         var7.field553 = (int)((float)var2 + (float)(63 - var9) * var5);
         if(!var3.contains(Integer.valueOf(var7.field552))) {
            this.method375(var7, var7.field555, var7.field553, var5);
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lie;III)V",
      garbageValue = "-151276037"
   )
   void method480(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4395(false);
      if(var4 != null) {
         int var5 = this.method371(var4, var1.field3289);
         int var6 = this.method372(var4, var1.field3305);
         var4.method5172(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lkr;Liy;I)I",
      garbageValue = "-1444719495"
   )
   int method371(SpritePixels var1, class257 var2) {
      switch(var2.field3547) {
      case 0:
         return 0;
      case 1:
         return -var1.width / 2;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-52"
   )
   int method379(int var1, int var2) {
      if(this.field499 != null) {
         return this.field499.method212(var1, var2);
      } else {
         if(!this.field509.isEmpty()) {
            Iterator var3 = this.field509.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method643(var1, var2)) {
                  return var4.method212(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILah;Lax;[Ljz;I)V",
      garbageValue = "1969017699"
   )
   void method394(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method361(var1, var2, var3);
      this.method440(var1, var2, var3, var5);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "1218083723"
   )
   void method363(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field505.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = class3.field24[var5.field552];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4397()))) {
            this.method364(var6, var5.field555, var5.field553, var2, var3);
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "1793146627"
   )
   void method344(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field377.worldX >> 6 == this.field497 && var3.field377.worldY >> 6 == this.field498) {
            class39 var4 = new class39(var3.field376, var3.field377, var3.field377, this.method374(var3.field376));
            this.field505.add(var4);
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(Lar;Lie;IIFB)V",
      garbageValue = "87"
   )
   void method367(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field556 != null) {
         if(var1.field556.field485.method165(var5)) {
            Font var6 = (Font)this.field507.get(var1.field556.field485);
            var6.method4844(var1.field556.field486, var3 - var1.field556.field487 / 2, var4, var1.field556.field487, var1.field556.field484, -16777216 | var2.field3296, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([Laq;I)Z",
      garbageValue = "-1085013498"
   )
   boolean method444(class34[] var1) {
      if(this.field503 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field499 != null) {
            this.method357(0, 0, 64, 64, this.field499, var2);
         } else {
            Iterator var3 = this.field509.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method357(var4.method647() * 8, var4.method648() * 8, 8, 8, var4, var2);
            }
         }

         this.method395(var1, var2);
         this.method355(var2);
         return true;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIIILah;I)V",
      garbageValue = "1803905461"
   )
   void method462(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label56:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field419; ++var9) {
               class31[] var10 = var5.field424[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method373(var13.field455);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, this.field497 * 64 + var6, this.field498 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field499 != null) {
                           var16 = new Coordinates(this.field499.field425 + var9, var6 + this.field499.field418 * 64, var7 + this.field499.field426 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field425, var17.field418 * 64 + var6 + var17.method657() * 8, var7 + var17.field426 * 64 + var17.method644() * 8);
                        }

                        class39 var18 = new class39(var14.field3292, var16, var15, this.method383(var14));
                        this.field506.put(var8, var18);
                        continue label56;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IILah;B)V",
      garbageValue = "0"
   )
   void method460(int var1, int var2, class28 var3) {
      field502.method4050(0, var1, var2);

      for(int var4 = 0; var4 < var3.field419; ++var4) {
         class31[] var5 = var3.field424[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method373(var8.field455);
               if(var9 != null) {
                  class39 var10 = (class39)this.field506.get(field502);
                  if(var10 != null) {
                     if(var10.field552 != var9.field3292) {
                        class39 var16 = new class39(var9.field3292, var10.field548, var10.field547, this.method383(var9));
                        this.field506.put(new Coordinates(field502), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field548.plane - var10.field547.plane;
                     var10.field547.plane = var4;
                     var10.field548.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field497 * 64 + var1, this.field498 * 64 + var2);
                  Coordinates var12 = null;
                  if(this.field499 != null) {
                     var12 = new Coordinates(this.field499.field425 + var4, this.field499.field418 * 64 + var1, var2 + this.field499.field426 * 64);
                  } else {
                     Iterator var13 = this.field509.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method643(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field425, var1 + var14.field418 * 64 + var14.method657() * 8, var2 + var14.field426 * 64 + var14.method644() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3292, var12, var11, this.method383(var9));
                     this.field506.put(new Coordinates(field502), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field506.remove(field502);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IILah;Lax;I)V",
      garbageValue = "-635622973"
   )
   void method353(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field419; ++var5) {
         int var6 = var3.field421[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class15.method95(var6, this.field501);
            if(var3.field422[var5][var1][var2] == 0) {
               Rasterizer2D.method5129(this.field500 * var1, this.field500 * (63 - var2), this.field500, this.field500, var7);
            } else {
               var4.method679(this.field500 * var1, this.field500 * (63 - var2), 0, var7, this.field500, this.field500, var3.field422[var5][var1][var2], var3.field423[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(Lkr;Lir;I)I",
      garbageValue = "1715100030"
   )
   int method372(SpritePixels var1, class239 var2) {
      switch(var2.field3275) {
      case 0:
         return -var1.height / 2;
      case 1:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIILah;Lao;I)V",
      garbageValue = "1769589349"
   )
   void method357(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field420[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class72.method1166(var9);
               var6.method619(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([Laq;Lao;B)V",
      garbageValue = "-50"
   )
   void method395(class34[] var1, class43 var2) {
      class228[] var3 = class132.method2675();
      class228[] var4 = var3;

      for(int var5 = 0; var5 < var4.length; ++var5) {
         class228 var6 = var4[var5];
         if(var1[var6.rsOrdinal()] != null) {
            byte var7 = 0;
            byte var8 = 0;
            byte var9 = 64;
            byte var10 = 64;
            byte var11 = 0;
            byte var12 = 0;
            switch(var6.field3161) {
            case 0:
               var12 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 1:
               var7 = 59;
               var9 = 5;
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
               var12 = 59;
               var9 = 5;
               var10 = 5;
               break;
            case 5:
               var8 = 59;
               var10 = 5;
               var7 = 59;
               var9 = 5;
               break;
            case 6:
               var8 = 59;
               var10 = 5;
               break;
            case 7:
               var11 = 59;
               var9 = 5;
            }

            this.method472(var11, var12, var7, var8, var9, var10, var1[var6.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lao;I)V",
      garbageValue = "1749737980"
   )
   void method355(class43 var1) {
      this.field503 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field503[var2][var3] = var1.method620(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lax;[Ljz;I)V",
      garbageValue = "-1339253434"
   )
   void method350(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field509.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method647() * 8; var5 < var4.method647() * 8 + 8; ++var5) {
            for(var6 = var4.method648() * 8; var6 < var4.method648() * 8 + 8; ++var6) {
               this.method352(var5, var6, var4, var1);
               this.method353(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field509.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method647() * 8; var5 < var4.method647() * 8 + 8; ++var5) {
            for(var6 = var4.method648() * 8; var6 < var4.method648() * 8 + 8; ++var6) {
               this.method394(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lax;[Laq;[Ljz;I)V",
      garbageValue = "-94542749"
   )
   void method354(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method352(var4, var5, this.field499, var1);
            this.method353(var4, var5, this.field499, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method394(var4, var5, this.field499, var1, var3);
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IILah;I)I",
      garbageValue = "434309201"
   )
   int method359(int var1, int var2, class28 var3) {
      return var3.field420[0][var1][var2] == 0?this.field501:this.field503[var1][var2];
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(II)Lie;",
      garbageValue = "-795308055"
   )
   Area method373(int var1) {
      ObjectComposition var2 = Occluder.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?class3.field24[var2.mapIconId]:null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lie;IIIII)V",
      garbageValue = "861506517"
   )
   void method364(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4395(false);
      if(var6 != null) {
         var6.method5172(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5054(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5054(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(B)Ljava/util/List;",
      garbageValue = "1"
   )
   List method377() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field505);
      var1.addAll(this.field506.values());
      return var1;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IB)Laf;",
      garbageValue = "-37"
   )
   class33 method374(int var1) {
      Area var2 = class3.field24[var1];
      return this.method383(var2);
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lar;IIFI)V",
      garbageValue = "-113364699"
   )
   void method375(class39 var1, int var2, int var3, float var4) {
      Area var5 = class3.field24[var1.field552];
      this.method480(var5, var2, var3);
      this.method367(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "51"
   )
   void method366() {
      if(this.field499 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method460(var1, var2, this.field499);
            }
         }
      } else {
         Iterator var5 = this.field509.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method647() * 8; var3 < var6.method647() * 8 + 8; ++var3) {
               for(int var4 = var6.method648() * 8; var4 < var6.method648() * 8 + 8; ++var4) {
                  this.method460(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;IIB)V",
      garbageValue = "-82"
   )
   void method410(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field506.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field552))) {
            Area var6 = class3.field24[var5.field552];
            this.method364(var6, var5.field555, var5.field553, var2, var3);
         }
      }

      this.method363(var1, var2, var3);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-1"
   )
   void method378(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5128(this.field500 * var1, this.field500 * (63 - var2), this.field500, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5063(this.field500 * var1, this.field500 * (63 - var2), this.field500, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5128(this.field500 * var1 + this.field500 - 1, this.field500 * (63 - var2), this.field500, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5063(this.field500 * var1, this.field500 * (63 - var2) + this.field500 - 1, this.field500, var4);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "969466689"
   )
   void method346(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method362(var1, var2, var4, var3);
      this.method368(var1, var2, var4, var3);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIIIIILaq;Lao;B)V",
      garbageValue = "-25"
   )
   void method472(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method379(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class72.method1166(var11);
               var8.method619(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIIIIB)Ljava/util/List;",
      garbageValue = "-1"
   )
   List method376(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field506.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method530(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field505.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method530(var4, var5)) {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILax;[Laq;[Ljz;S)Z",
      garbageValue = "-17697"
   )
   boolean method345(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method402(var1)) {
         return false;
      } else if(this.field499 == null && this.field509.isEmpty()) {
         return false;
      } else {
         this.method444(var3);
         this.field495.method5166();
         if(this.field499 != null) {
            this.method354(var2, var3, var4);
         } else {
            this.method350(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "-57"
   )
   void method340(int var1, int var2, int var3) {
      if(this.field495 != null) {
         if(var3 == this.field500 * 64) {
            this.field495.method5173(var1, var2);
         } else {
            this.field495.method5190(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ll;Ljava/util/List;B)V",
      garbageValue = "24"
   )
   void method341(class22 var1, List var2) {
      this.field506.clear();
      this.field499 = var1;
      this.method462(0, 0, 64, 64, this.field499);
      this.method344(var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "-418748146"
   )
   void method342(HashSet var1, List var2) {
      this.field506.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method215() == this.field497 && var4.method216() == this.field498) {
            this.field509.add(var4);
            this.method462(var4.method647() * 8, var4.method648() * 8, 8, 8, var4);
         }
      }

      this.method344(var2);
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(IIIIIS)V",
      garbageValue = "-21074"
   )
   static final void method482(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class8.region.method2848(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class8.region.method2801(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = BaseVarType.field33.image;
         var11 = var1 * 4 + (103 - var2) * 2048 + 24624;
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = Occluder.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            IndexedSprite var14 = class288.field3819[var13.mapSceneId];
            if(var14 != null) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method5147(var15 + var1 * 4 + 48, (104 - var2 - var13.sizeY) * 4 + var16 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 3) {
                  var10[var11 + 1536] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[var11 + 1] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[var11 + 512 + 3] = var9;
                  var10[var11 + 1024 + 3] = var9;
                  var10[var11 + 1536 + 3] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[var11 + 1536 + 1] = var9;
                  var10[var11 + 1536 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class8.region.method2907(var0, var1, var2);
      if(var5 != 0) {
         var6 = class8.region.method2801(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = Occluder.getObjectDefinition(var9);
         int var18;
         if(var23.mapSceneId != -1) {
            IndexedSprite var17 = class288.field3819[var23.mapSceneId];
            if(var17 != null) {
               var12 = (var23.sizeX * 4 - var17.originalWidth) / 2;
               var18 = (var23.sizeY * 4 - var17.height) / 2;
               var17.method5147(var1 * 4 + var12 + 48, (104 - var2 - var23.sizeY) * 4 + var18 + 48);
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var22 = BaseVarType.field33.image;
            var18 = var1 * 4 + (103 - var2) * 2048 + 24624;
            if(var7 != 0 && var7 != 2) {
               var22[var18] = var11;
               var22[var18 + 1 + 512] = var11;
               var22[var18 + 1024 + 2] = var11;
               var22[var18 + 1536 + 3] = var11;
            } else {
               var22[var18 + 1536] = var11;
               var22[var18 + 1 + 1024] = var11;
               var22[var18 + 512 + 2] = var11;
               var22[var18 + 3] = var11;
            }
         }
      }

      var5 = class8.region.method2841(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var19 = Occluder.getObjectDefinition(var6);
         if(var19.mapSceneId != -1) {
            IndexedSprite var20 = class288.field3819[var19.mapSceneId];
            if(var20 != null) {
               var9 = (var19.sizeX * 4 - var20.originalWidth) / 2;
               int var21 = (var19.sizeY * 4 - var20.height) / 2;
               var20.method5147(var1 * 4 + var9 + 48, var21 + (104 - var2 - var19.sizeY) * 4 + 48);
            }
         }
      }

   }

   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      signature = "(Lhj;I)Ljava/lang/String;",
      garbageValue = "1854229733"
   )
   static String method483(Widget var0) {
      int var2 = class244.getWidgetConfig(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }
}
