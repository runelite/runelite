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

@ObfuscatedName("ad")
public class class34 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1377954715
   )
   int field472;
   @ObfuscatedName("ci")
   @Export("indexMaps")
   static IndexData indexMaps;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -2083239989
   )
   int field475;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 943453187
   )
   int field476;
   @ObfuscatedName("v")
   class22 field477;
   @ObfuscatedName("t")
   LinkedList field478;
   @ObfuscatedName("k")
   SpritePixels field479;
   @ObfuscatedName("a")
   int[][] field480;
   @ObfuscatedName("x")
   final HashMap field481;
   @ObfuscatedName("r")
   List field483;
   @ObfuscatedName("b")
   HashMap field484;
   @ObfuscatedName("o")
   static final class212 field486;
   @ObfuscatedName("hx")
   @ObfuscatedGetter(
      intValue = -856073755
   )
   static int field487;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1386906631
   )
   int field488;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "-1479086723"
   )
   void method356(int var1, int var2, int var3) {
      if(this.field479 != null) {
         if(var3 == this.field488 * 64) {
            this.field479.method5130(var1, var2);
         } else {
            this.field479.method5147(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;I)V",
      garbageValue = "402931948"
   )
   void method358(HashSet var1, List var2) {
      this.field484.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method220() == this.field475 && var4.method221() == this.field476) {
            this.field478.add(var4);
            this.method412(var4.method656() * 8, var4.method657() * 8, 8, 8, var4);
         }
      }

      this.method465(var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "-593281962"
   )
   void method362(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method378(var1, var2, var4, var3);
      this.method398(var1, var2, var4, var3);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass46;[Lclass34;[LModIcon;I)V",
      garbageValue = "-1644558984"
   )
   void method365(class46 var1, class34[] var2, ModIcon[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method368(var4, var5, this.field477, var1);
            this.method369(var4, var5, this.field477, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method367(var4, var5, this.field477, var1, var3);
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass46;[LModIcon;I)V",
      garbageValue = "2063304615"
   )
   void method366(class46 var1, ModIcon[] var2) {
      Iterator var3 = this.field478.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method656() * 8; var5 < var4.method656() * 8 + 8; ++var5) {
            for(var6 = var4.method657() * 8; var6 < var4.method657() * 8 + 8; ++var6) {
               this.method368(var5, var6, var4, var1);
               this.method369(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field478.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method656() * 8; var5 < var4.method656() * 8 + 8; ++var5) {
            for(var6 = var4.method657() * 8; var6 < var4.method657() * 8 + 8; ++var6) {
               this.method367(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;[LModIcon;I)V",
      garbageValue = "1825090315"
   )
   void method367(int var1, int var2, class28 var3, class46 var4, ModIcon[] var5) {
      this.method449(var1, var2, var3);
      this.method376(var1, var2, var3, var5);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;I)V",
      garbageValue = "-915632904"
   )
   void method368(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field405[0][var1][var2] - 1;
      int var6 = var3.field403[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method5042(this.field488 * var1, (63 - var2) * this.field488, this.field488, this.field488, this.field472);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class157.method3020(var6, this.field472);
      }

      if(var6 > -1 && var3.field411[0][var1][var2] == 0) {
         Rasterizer2D.method5042(var1 * this.field488, this.field488 * (63 - var2), this.field488, this.field488, var7);
      } else {
         int var8 = this.method375(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method5042(this.field488 * var1, (63 - var2) * this.field488, this.field488, this.field488, var8);
         } else {
            var4.method686(var1 * this.field488, this.field488 * (63 - var2), var8, var7, this.field488, this.field488, var3.field411[0][var1][var2], var3.field412[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;I)V",
      garbageValue = "667507803"
   )
   void method369(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field408; ++var5) {
         int var6 = var3.field403[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class157.method3020(var6, this.field472);
            if(var3.field411[var5][var1][var2] == 0) {
               Rasterizer2D.method5042(this.field488 * var1, (63 - var2) * this.field488, this.field488, this.field488, var7);
            } else {
               var4.method686(var1 * this.field488, (63 - var2) * this.field488, 0, var7, this.field488, this.field488, var3.field411[var5][var1][var2], var3.field412[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "1"
   )
   int method370(int var1, int var2) {
      if(this.field477 != null) {
         return this.field477.method222(var1, var2);
      } else {
         if(!this.field478.isEmpty()) {
            Iterator var3 = this.field478.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method673(var1, var2)) {
                  return var4.method222(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Lclass34;I)Z",
      garbageValue = "568480176"
   )
   boolean method371(class34[] var1) {
      if(this.field480 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field477 != null) {
            this.method373(0, 0, 64, 64, this.field477, var2);
         } else {
            Iterator var3 = this.field478.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method373(var4.method656() * 8, var4.method657() * 8, 8, 8, var4, var2);
            }
         }

         this.method372(var1, var2);
         this.method402(var2);
         return true;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Lclass34;Lclass43;S)V",
      garbageValue = "15669"
   )
   void method372(class34[] var1, class43 var2) {
      class228[] var3 = new class228[]{class228.field3145, class228.field3139, class228.field3141, class228.field3142, class228.field3140, class228.field3138, class228.field3143, class228.field3137};
      class228[] var5 = var3;

      for(int var6 = 0; var6 < var5.length; ++var6) {
         class228 var7 = var5[var6];
         if(var1[var7.vmethod5090()] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch(var7.field3144) {
            case 0:
               var13 = 59;
               var11 = 5;
               break;
            case 1:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 2:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
               break;
            case 3:
               var12 = 59;
               var10 = 5;
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

            this.method374(var12, var13, var8, var9, var10, var11, var1[var7.vmethod5090()], var2);
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIILclass28;Lclass43;I)V",
      garbageValue = "686194415"
   )
   void method373(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field405[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class238.method4335(var9);
               var6.method627(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass34;Lclass43;I)V",
      garbageValue = "583969356"
   )
   void method374(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method370(var1 + var9, var2 + var10);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class238.method4335(var11);
               var8.method627(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)I",
      garbageValue = "-1951609200"
   )
   int method375(int var1, int var2, class28 var3) {
      return var3.field405[0][var1][var2] == 0?this.field472:this.field480[var1][var2];
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILclass28;[LModIcon;I)V",
      garbageValue = "1099440635"
   )
   void method376(int var1, int var2, class28 var3, ModIcon[] var4) {
      for(int var5 = 0; var5 < var3.field408; ++var5) {
         class31[] var6 = var3.field413[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               if(class155.method2996(var9.field440) || class61.method1070(var9.field440)) {
                  ObjectComposition var10 = class43.getObjectDefinition(var9.field445);
                  if(var10.mapSceneId != -1) {
                     if(var10.mapSceneId != 46 && var10.mapSceneId != 52) {
                        var4[var10.mapSceneId].method5103(var1 * this.field488, (63 - var2) * this.field488, this.field488 * 2, this.field488 * 2);
                     } else {
                        var4[var10.mapSceneId].method5103(this.field488 * var1, this.field488 * (63 - var2), this.field488 * 2 + 1, this.field488 * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "2139215534"
   )
   void method378(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field484.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         class212 var9 = (class212)var8.getKey();
         int var10 = (int)((float)var1 + var5 * (float)var9.field2600 - var6);
         int var11 = (int)((float)(var4 + var2) - var5 * (float)var9.field2601 - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field521 = var10;
            var12.field528 = var11;
            class242 var13 = class242.field3276[var12.field526];
            if(!var3.contains(Integer.valueOf(var13.method4374()))) {
               this.method381(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "1504751938"
   )
   void method379(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field483.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         class242 var6 = class242.field3276[var5.field526];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4374()))) {
            this.method479(var6, var5.field521, var5.field528, var2, var3);
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIFI)V",
      garbageValue = "-855578501"
   )
   void method381(class39 var1, int var2, int var3, float var4) {
      class242 var5 = class242.field3276[var1.field526];
      this.method382(var5, var2, var3);
      this.method440(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass242;III)V",
      garbageValue = "-52179943"
   )
   void method382(class242 var1, int var2, int var3) {
      SpritePixels var4 = var1.method4370(false);
      if(var4 != null) {
         int var5 = this.method490(var4, var1.field3292);
         int var6 = this.method387(var4, var1.field3287);
         var4.method5207(var2 + var5, var3 + var6);
      }

   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field475 = var1;
      this.field476 = var2;
      this.field478 = new LinkedList();
      this.field483 = new LinkedList();
      this.field484 = new HashMap();
      this.field472 = var3 | -16777216;
      this.field481 = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1647326209"
   )
   void method384() {
      if(this.field477 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var5 = 0; var5 < 64; ++var5) {
               this.method385(var1, var5, this.field477);
            }
         }
      } else {
         Iterator var6 = this.field478.iterator();

         while(var6.hasNext()) {
            class45 var2 = (class45)var6.next();

            for(int var3 = var2.method656() * 8; var3 < var2.method656() * 8 + 8; ++var3) {
               for(int var4 = var2.method657() * 8; var4 < var2.method657() * 8 + 8; ++var4) {
                  this.method385(var3, var4, var2);
               }
            }
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)V",
      garbageValue = "-1342894792"
   )
   void method385(int var1, int var2, class28 var3) {
      field486.method3992(0, var1, var2);

      for(int var4 = 0; var4 < var3.field408; ++var4) {
         class31[] var5 = var3.field413[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               class242 var9 = this.method413(var8.field445);
               if(var9 != null) {
                  class39 var10 = (class39)this.field484.get(field486);
                  if(var10 != null) {
                     if(var10.field526 != var9.field3279) {
                        class39 var16 = new class39(var9.field3279, var10.field523, var10.field527, this.method390(var9));
                        this.field484.put(new class212(field486), var16);
                        var10 = var16;
                     }

                     int var11 = var10.field523.field2603 - var10.field527.field2603;
                     var10.field527.field2603 = var4;
                     var10.field523.field2603 = var4 + var11;
                     return;
                  }

                  class212 var15 = new class212(var4, var1 + this.field475 * 64, var2 + this.field476 * 64);
                  class212 var12 = null;
                  if(this.field477 != null) {
                     var12 = new class212(this.field477.field410 + var4, this.field477.field409 * 64 + var1, var2 + this.field477.field404 * 64);
                  } else {
                     Iterator var13 = this.field478.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method673(var1, var2)) {
                           var12 = new class212(var14.field410 + var4, var1 + var14.field409 * 64 + var14.method654() * 8, var2 + var14.field404 * 64 + var14.method655() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3279, var12, var15, this.method390(var9));
                     this.field484.put(new class212(field486), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field484.remove(field486);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IIIIIB)Ljava/util/List;",
      garbageValue = "1"
   )
   List method386(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var1 + var3 && var5 < var3 + var2) {
            Iterator var7 = this.field484.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method550(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field483.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method550(var4, var5)) {
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

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(LSpritePixels;Lclass239;B)I",
      garbageValue = "2"
   )
   int method387(SpritePixels var1, class239 var2) {
      switch(var2.field3263) {
      case 0:
         return 0;
      case 1:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(II)Lclass33;",
      garbageValue = "604655462"
   )
   class33 method389(int var1) {
      class242 var2 = class242.field3276[var1];
      return this.method390(var2);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lclass242;B)Lclass33;",
      garbageValue = "-1"
   )
   class33 method390(class242 var1) {
      if(var1.field3282 != null && this.field481 != null && this.field481.get(class24.field367) != null) {
         int var3 = var1.field3284;
         class24[] var4 = class24.method166();
         int var5 = 0;

         class24 var2;
         while(true) {
            if(var5 >= var4.length) {
               var2 = null;
               break;
            }

            class24 var6 = var4[var5];
            if(var6.field361 == var3) {
               var2 = var6;
               break;
            }

            ++var5;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.field481.get(var2);
            if(var14 == null) {
               return null;
            } else {
               int var15 = var14.method4841(var1.field3282, 1000000);
               String[] var7 = new String[var15];
               var14.method4887(var1.field3282, (int[])null, var7);
               int var8 = var14.field3638 * var7.length / 2;
               int var9 = 0;
               String[] var10 = var7;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.method4809(var12);
                  if(var13 > var9) {
                     var9 = var13;
                  }
               }

               return new class33(var1.field3282, var9, var8, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "1379318627"
   )
   List method392() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field483);
      var1.addAll(this.field484.values());
      return var1;
   }

   static {
      field486 = new class212();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass22;Ljava/util/List;I)V",
      garbageValue = "-642057113"
   )
   void method397(class22 var1, List var2) {
      this.field484.clear();
      this.field477 = var1;
      this.method412(0, 0, 64, 64, this.field477);
      this.method465(var2);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "677185693"
   )
   void method398(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field483.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field527.field2600 % 64;
         int var9 = var7.field527.field2601 % 64;
         var7.field521 = (int)((float)var1 + (float)var8 * var5);
         var7.field528 = (int)((float)var2 + var5 * (float)(63 - var9));
         if(!var3.contains(Integer.valueOf(var7.field526))) {
            this.method381(var7, var7.field521, var7.field528, var5);
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lclass43;B)V",
      garbageValue = "-48"
   )
   void method402(class43 var1) {
      this.field480 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field480[var2][var3] = var1.method628(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIILclass28;I)V",
      garbageValue = "-912820740"
   )
   void method412(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var1 + var3; ++var6) {
         label64:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            class212 var8 = new class212(0, var6, var7);

            for(int var9 = 0; var9 < var5.field408; ++var9) {
               class31[] var10 = var5.field413[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     class242 var14 = this.method413(var13.field445);
                     if(var14 != null) {
                        class212 var15 = new class212(var9, var6 + this.field475 * 64, var7 + this.field476 * 64);
                        class212 var16 = null;
                        if(this.field477 != null) {
                           var16 = new class212(var9 + this.field477.field410, var6 + this.field477.field409 * 64, this.field477.field404 * 64 + var7);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new class212(var17.field410 + var9, var6 + var17.field409 * 64 + var17.method654() * 8, var7 + var17.field404 * 64 + var17.method655() * 8);
                        }

                        class39 var18 = new class39(var14.field3279, var16, var15, this.method390(var14));
                        this.field484.put(var8, var18);
                        continue label64;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(II)Lclass242;",
      garbageValue = "840931631"
   )
   class242 method413(int var1) {
      ObjectComposition var2 = class43.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?class242.field3276[var2.mapIconId]:null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1634539930"
   )
   void method422(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field484.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field526))) {
            class242 var6 = class242.field3276[var5.field526];
            this.method479(var6, var5.field521, var5.field528, var2, var3);
         }
      }

      this.method379(var1, var2, var3);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ILclass46;[Lclass34;[LModIcon;I)Z",
      garbageValue = "-849972608"
   )
   boolean method436(int var1, class46 var2, class34[] var3, ModIcon[] var4) {
      if(!this.method466(var1)) {
         return false;
      } else if(this.field477 == null && this.field478.isEmpty()) {
         return false;
      } else {
         this.method371(var3);
         this.field479.method5199();
         if(this.field477 != null) {
            this.method365(var2, var3, var4);
         } else {
            this.method366(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(Lclass39;Lclass242;IIFB)V",
      garbageValue = "-122"
   )
   void method440(class39 var1, class242 var2, int var3, int var4, float var5) {
      if(var1.field522 != null) {
         if(var1.field522.field467.method168(var5)) {
            Font var6 = (Font)this.field481.get(var1.field522.field467);
            var6.method4818(var1.field522.field468, var3 - var1.field522.field465 / 2, var4, var1.field522.field465, var1.field522.field464, -16777216 | var2.field3275, 0, 1, 0, var6.field3638 / 2);
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)V",
      garbageValue = "-658962894"
   )
   void method449(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field408; ++var4) {
         class31[] var5 = var3.field413[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               int var10 = var8.field440;
               boolean var9 = var10 >= class221.field2808.field2826 && var10 <= class221.field2813.field2826 || var10 == class221.field2803.field2826;
               if(var9) {
                  ObjectComposition var11 = class43.getObjectDefinition(var8.field445);
                  int var12 = var11.field3456 != 0?-3407872:-3355444;
                  if(class221.field2808.field2826 == var8.field440) {
                     this.method453(var1, var2, var8.field441, var12);
                  }

                  if(var8.field440 == class221.field2805.field2826) {
                     this.method453(var1, var2, var8.field441, -3355444);
                     this.method453(var1, var2, var8.field441 + 1, var12);
                  }

                  if(var8.field440 == class221.field2813.field2826) {
                     if(var8.field441 == 0) {
                        Rasterizer2D.method5014(var1 * this.field488, (63 - var2) * this.field488, 1, var12);
                     }

                     if(var8.field441 == 1) {
                        Rasterizer2D.method5014(this.field488 * var1 + this.field488 - 1, this.field488 * (63 - var2), 1, var12);
                     }

                     if(var8.field441 == 2) {
                        Rasterizer2D.method5014(this.field488 * var1 + this.field488 - 1, this.field488 + this.field488 * (63 - var2) - 1, 1, var12);
                     }

                     if(var8.field441 == 3) {
                        Rasterizer2D.method5014(this.field488 * var1, (63 - var2) * this.field488 + this.field488 - 1, 1, var12);
                     }
                  }

                  if(var8.field440 == class221.field2803.field2826) {
                     int var13 = var8.field441 % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.field488; ++var14) {
                           Rasterizer2D.method5014(var1 * this.field488 + var14, (64 - var2) * this.field488 - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.field488; ++var14) {
                           Rasterizer2D.method5014(this.field488 * var1 + var14, var14 + (63 - var2) * this.field488, 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-44"
   )
   void method453(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method5076(this.field488 * var1, (63 - var2) * this.field488, this.field488, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5014(this.field488 * var1, this.field488 * (63 - var2), this.field488, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method5076(this.field488 + this.field488 * var1 - 1, (63 - var2) * this.field488, this.field488, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5014(this.field488 * var1, (63 - var2) * this.field488 + this.field488 - 1, this.field488, var4);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;B)V",
      garbageValue = "6"
   )
   void method465(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(this.field475 == var3.field371.field2600 >> 6 && this.field476 == var3.field371.field2601 >> 6) {
            class39 var4 = new class39(var3.field375, var3.field371, var3.field371, this.method389(var3.field375));
            this.field483.add(var4);
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "53"
   )
   boolean method466(int var1) {
      if(this.field479 != null && this.field488 == var1) {
         return false;
      } else {
         this.field488 = var1;
         this.field479 = new SpritePixels(this.field488 * 64, this.field488 * 64);
         return true;
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lclass242;IIIII)V",
      garbageValue = "-2138548532"
   )
   void method479(class242 var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4370(false);
      if(var6 != null) {
         var6.method5207(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method5004(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method5004(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(LSpritePixels;Lclass257;B)I",
      garbageValue = "2"
   )
   int method490(SpritePixels var1, class257 var2) {
      switch(var2.field3539) {
      case 1:
         return 0;
      case 2:
         return -var1.width / 2;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1431770549"
   )
   static void method492(int var0) {
      XItemContainer var1 = (XItemContainer)XItemContainer.itemContainers.method3615((long)var0);
      if(var1 != null) {
         for(int var2 = 0; var2 < var1.itemIds.length; ++var2) {
            var1.itemIds[var2] = -1;
            var1.stackSizes[var2] = 0;
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)I",
      garbageValue = "36458268"
   )
   static final int method493(int var0, int var1, int var2, int var3) {
      int var4 = 65536 - class136.COSINE[var2 * 1024 / var3] >> 1;
      return (var0 * (65536 - var4) >> 16) + (var4 * var1 >> 16);
   }
}
