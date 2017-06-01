import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
public class class34 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1445717823
   )
   int field479;
   @ObfuscatedName("q")
   final HashMap field480;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1332324441
   )
   int field481;
   @ObfuscatedName("a")
   SpritePixels field483;
   @ObfuscatedName("y")
   class22 field484;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 512821723
   )
   int field486;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1436665689
   )
   int field487;
   @ObfuscatedName("n")
   int[][] field488;
   @ObfuscatedName("o")
   List field490;
   @ObfuscatedName("z")
   HashMap field491;
   @ObfuscatedName("h")
   LinkedList field492;
   @ObfuscatedName("j")
   static final Coordinates field493;

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)V",
      garbageValue = "414394271"
   )
   void method341(int var1, int var2, class28 var3) {
      field493.method3915(0, var1, var2);

      for(int var4 = 0; var4 < var3.field411; ++var4) {
         class31[] var5 = var3.field416[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               class242 var9 = this.method374(var8.field445);
               if(var9 != null) {
                  class39 var10 = (class39)this.field491.get(field493);
                  if(var10 != null) {
                     if(var10.field536 != var9.field3289) {
                        class39 var16 = new class39(var9.field3289, var10.field526, var10.field525, this.method469(var9));
                        this.field491.put(new Coordinates(field493), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field526.plane - var10.field525.plane;
                     var10.field525.plane = var4;
                     var10.field526.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, var1 + this.field479 * 64, var2 + this.field481 * 64);
                  Coordinates var12 = null;
                  if(this.field484 != null) {
                     var12 = new Coordinates(var4 + this.field484.field410, this.field484.field409 * 64 + var1, this.field484.field417 * 64 + var2);
                  } else {
                     Iterator var13 = this.field492.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method628(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field410, var1 + var14.field409 * 64 + var14.method639() * 8, var14.field417 * 64 + var2 + var14.method617() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3289, var12, var11, this.method469(var9));
                     this.field491.put(new Coordinates(field493), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field491.remove(field493);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass22;Ljava/util/List;I)V",
      garbageValue = "-741070300"
   )
   void method343(class22 var1, List var2) {
      this.field491.clear();
      this.field484 = var1;
      this.method435(0, 0, 64, 64, this.field484);
      this.method376(var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;B)V",
      garbageValue = "28"
   )
   void method344(HashSet var1, List var2) {
      this.field491.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method209() == this.field479 && var4.method210() == this.field481) {
            this.field492.add(var4);
            this.method435(var4.method618() * 8, var4.method619() * 8, 8, 8, var4);
         }
      }

      this.method376(var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "-2084305092"
   )
   void method348(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method402(var1, var2, var4, var3);
      this.method361(var1, var2, var4, var3);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1668851496"
   )
   void method349(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field491.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field536))) {
            class242 var6 = class223.field2839[var5.field536];
            this.method365(var6, var5.field530, var5.field531, var2, var3);
         }
      }

      this.method371(var1, var2, var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass46;[Lclass34;[LModIcon;S)V",
      garbageValue = "31606"
   )
   void method351(class46 var1, class34[] var2, ModIcon[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method354(var4, var5, this.field484, var1);
            this.method355(var4, var5, this.field484, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method405(var4, var5, this.field484, var1, var3);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass46;[LModIcon;I)V",
      garbageValue = "-788025537"
   )
   void method352(class46 var1, ModIcon[] var2) {
      Iterator var3 = this.field492.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method618() * 8; var5 < var4.method618() * 8 + 8; ++var5) {
            for(var6 = var4.method619() * 8; var6 < var4.method619() * 8 + 8; ++var6) {
               this.method354(var5, var6, var4, var1);
               this.method355(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field492.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method618() * 8; var5 < var4.method618() * 8 + 8; ++var5) {
            for(var6 = var4.method619() * 8; var6 < var4.method619() * 8 + 8; ++var6) {
               this.method405(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([Lclass34;I)Z",
      garbageValue = "-1671666509"
   )
   boolean method353(class34[] var1) {
      if(this.field488 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field484 != null) {
            this.method359(0, 0, 64, 64, this.field484, var2);
         } else {
            Iterator var3 = this.field492.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method359(var4.method618() * 8, var4.method619() * 8, 8, 8, var4, var2);
            }
         }

         this.method358(var1, var2);
         this.method364(var2);
         return true;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;I)V",
      garbageValue = "703550504"
   )
   void method354(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field412[0][var1][var2] - 1;
      int var6 = var3.field413[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method4923(this.field487 * var1, (63 - var2) * this.field487, this.field487, this.field487, this.field486);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = Player.method1138(var6, this.field486);
      }

      if(var6 > -1 && var3.field407[0][var1][var2] == 0) {
         Rasterizer2D.method4923(this.field487 * var1, (63 - var2) * this.field487, this.field487, this.field487, var7);
      } else {
         int var8 = this.method424(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method4923(this.field487 * var1, this.field487 * (63 - var2), this.field487, this.field487, var8);
         } else {
            var4.method645(var1 * this.field487, this.field487 * (63 - var2), var8, var7, this.field487, this.field487, var3.field407[0][var1][var2], var3.field406[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;B)V",
      garbageValue = "107"
   )
   void method355(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field411; ++var5) {
         int var6 = var3.field413[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = Player.method1138(var6, this.field486);
            if(var3.field407[var5][var1][var2] == 0) {
               Rasterizer2D.method4923(var1 * this.field487, this.field487 * (63 - var2), this.field487, this.field487, var7);
            } else {
               var4.method645(var1 * this.field487, this.field487 * (63 - var2), 0, var7, this.field487, this.field487, var3.field407[var5][var1][var2], var3.field406[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILclass46;[Lclass34;[LModIcon;B)Z",
      garbageValue = "67"
   )
   boolean method356(int var1, class46 var2, class34[] var3, ModIcon[] var4) {
      if(!this.method468(var1)) {
         return false;
      } else if(this.field484 == null && this.field492.isEmpty()) {
         return false;
      } else {
         this.method353(var3);
         this.field483.method5096();
         if(this.field484 != null) {
            this.method351(var2, var3, var4);
         } else {
            this.method352(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(IIIIIILclass34;Lclass43;I)V",
      garbageValue = "-1804169585"
   )
   void method357(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method380(var9 + var1, var2 + var10);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class37.method488(var11);
               var8.method599(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([Lclass34;Lclass43;B)V",
      garbageValue = "-102"
   )
   void method358(class34[] var1, class43 var2) {
      class228[] var3 = new class228[]{class228.field3153, class228.field3149, class228.field3146, class228.field3147, class228.field3150, class228.field3155, class228.field3148, class228.field3151};
      class228[] var5 = var3;

      for(int var6 = 0; var6 < var5.length; ++var6) {
         class228 var7 = var5[var6];
         if(var1[var7.vmethod5009()] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch(var7.field3154) {
            case 0:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 1:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 2:
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 3:
               var8 = 59;
               var10 = 5;
               break;
            case 4:
               var13 = 59;
               var11 = 5;
               break;
            case 5:
               var12 = 59;
               var10 = 5;
               break;
            case 6:
               var9 = 59;
               var11 = 5;
               break;
            case 7:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
            }

            this.method357(var12, var13, var8, var9, var10, var11, var1[var7.vmethod5009()], var2);
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIILclass28;Lclass43;I)V",
      garbageValue = "-1157304891"
   )
   void method359(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field412[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class37.method488(var9);
               var6.method599(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-120210172"
   )
   void method361(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field490.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field525.worldX % 64;
         int var9 = var7.field525.worldY % 64;
         var7.field530 = (int)((float)var1 + (float)var8 * var5);
         var7.field531 = (int)((float)(63 - var9) * var5 + (float)var2);
         if(!var3.contains(Integer.valueOf(var7.field536))) {
            this.method366(var7, var7.field530, var7.field531, var5);
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-28"
   )
   public static boolean method362(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)V",
      garbageValue = "-2613364"
   )
   void method363(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field411; ++var4) {
         class31[] var5 = var3.field416[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               if(class205.method3789(var8.field446)) {
                  ObjectComposition var9 = class226.getObjectDefinition(var8.field445);
                  int var10 = var9.field3451 != 0?-3407872:-3355444;
                  if(var8.field446 == class221.field2827.field2832) {
                     this.method452(var1, var2, var8.field447, var10);
                  }

                  if(class221.field2811.field2832 == var8.field446) {
                     this.method452(var1, var2, var8.field447, -3355444);
                     this.method452(var1, var2, var8.field447 + 1, var10);
                  }

                  if(var8.field446 == class221.field2812.field2832) {
                     if(var8.field447 == 0) {
                        Rasterizer2D.method4982(this.field487 * var1, this.field487 * (63 - var2), 1, var10);
                     }

                     if(var8.field447 == 1) {
                        Rasterizer2D.method4982(this.field487 * var1 + this.field487 - 1, this.field487 * (63 - var2), 1, var10);
                     }

                     if(var8.field447 == 2) {
                        Rasterizer2D.method4982(this.field487 * var1 + this.field487 - 1, this.field487 + this.field487 * (63 - var2) - 1, 1, var10);
                     }

                     if(var8.field447 == 3) {
                        Rasterizer2D.method4982(var1 * this.field487, this.field487 * (63 - var2) + this.field487 - 1, 1, var10);
                     }
                  }

                  if(var8.field446 == class221.field2813.field2832) {
                     int var11 = var8.field447 % 2;
                     int var12;
                     if(var11 == 0) {
                        for(var12 = 0; var12 < this.field487; ++var12) {
                           Rasterizer2D.method4982(var12 + var1 * this.field487, (64 - var2) * this.field487 - 1 - var12, 1, var10);
                        }
                     } else {
                        for(var12 = 0; var12 < this.field487; ++var12) {
                           Rasterizer2D.method4982(var12 + this.field487 * var1, this.field487 * (63 - var2) + var12, 1, var10);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field479 = var1;
      this.field481 = var2;
      this.field492 = new LinkedList();
      this.field490 = new LinkedList();
      this.field491 = new HashMap();
      this.field486 = var3 | -16777216;
      this.field480 = var4;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lclass43;S)V",
      garbageValue = "10236"
   )
   void method364(class43 var1) {
      this.field488 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field488[var2][var3] = var1.method603(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(Lclass242;IIIII)V",
      garbageValue = "1434145207"
   )
   void method365(class242 var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4313(false);
      if(var6 != null) {
         var6.method5047(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method4921(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method4921(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIFI)V",
      garbageValue = "-1549563531"
   )
   void method366(class39 var1, int var2, int var3, float var4) {
      class242 var5 = class223.field2839[var1.field536];
      this.method367(var5, var2, var3);
      this.method403(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass242;III)V",
      garbageValue = "587254451"
   )
   void method367(class242 var1, int var2, int var3) {
      SpritePixels var4 = var1.method4313(false);
      if(var4 != null) {
         int var5 = this.method372(var4, var1.field3299);
         int var6 = this.method373(var4, var1.field3306);
         var4.method5047(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "845970813"
   )
   void method370() {
      if(this.field484 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var5 = 0; var5 < 64; ++var5) {
               this.method341(var1, var5, this.field484);
            }
         }
      } else {
         Iterator var6 = this.field492.iterator();

         while(var6.hasNext()) {
            class45 var2 = (class45)var6.next();

            for(int var3 = var2.method618() * 8; var3 < var2.method618() * 8 + 8; ++var3) {
               for(int var4 = var2.method619() * 8; var4 < var2.method619() * 8 + 8; ++var4) {
                  this.method341(var3, var4, var2);
               }
            }
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "744892046"
   )
   void method371(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field490.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         class242 var6 = class223.field2839[var5.field536];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4300()))) {
            this.method365(var6, var5.field530, var5.field531, var2, var3);
         }
      }

   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(LSpritePixels;Lclass257;I)I",
      garbageValue = "1789695954"
   )
   int method372(SpritePixels var1, class257 var2) {
      switch(var2.field3541) {
      case 0:
         return -var1.width / 2;
      case 1:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(LSpritePixels;Lclass239;I)I",
      garbageValue = "1275166748"
   )
   int method373(SpritePixels var1, class239 var2) {
      switch(var2.field3274) {
      case 0:
         return 0;
      case 2:
         return -var1.height / 2;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(II)Lclass242;",
      garbageValue = "-998622637"
   )
   class242 method374(int var1) {
      ObjectComposition var2 = class226.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?class223.field2839[var2.mapIconId]:null;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(II)Lclass33;",
      garbageValue = "116053675"
   )
   class33 method375(int var1) {
      class242 var2 = class223.field2839[var1];
      return this.method469(var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;I)V",
      garbageValue = "-208048516"
   )
   void method376(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field363.worldX >> 6 == this.field479 && this.field481 == var3.field363.worldY >> 6) {
            class39 var4 = new class39(var3.field364, var3.field363, var3.field363, this.method375(var3.field364));
            this.field490.add(var4);
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(IIIIIB)Ljava/util/List;",
      garbageValue = "0"
   )
   List method377(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var1 + var3 && var5 < var2 + var3) {
            Iterator var7 = this.field491.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method522(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field490.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method522(var4, var5)) {
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

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "-439115734"
   )
   List method378() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field490);
      var1.addAll(this.field491.values());
      return var1;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1542598972"
   )
   int method380(int var1, int var2) {
      if(this.field484 != null) {
         return this.field484.method208(var1, var2);
      } else {
         if(!this.field492.isEmpty()) {
            Iterator var3 = this.field492.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method628(var1, var2)) {
                  return var4.method208(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   static {
      field493 = new Coordinates();
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-1568554354"
   )
   void method402(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field491.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)((float)var9.worldX * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.worldY - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field530 = var10;
            var12.field531 = var11;
            class242 var13 = class223.field2839[var12.field536];
            if(!var3.contains(Integer.valueOf(var13.method4300()))) {
               this.method366(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(Lclass39;Lclass242;IIFI)V",
      garbageValue = "1672560077"
   )
   void method403(class39 var1, class242 var2, int var3, int var4, float var5) {
      if(var1.field529 != null) {
         if(var1.field529.field471.method166(var5)) {
            Font var6 = (Font)this.field480.get(var1.field529.field471);
            var6.method4745(var1.field529.field470, var3 - var1.field529.field469 / 2, var4, var1.field529.field469, var1.field529.field468, -16777216 | var2.field3296, 0, 1, 0, var6.field3652 / 2);
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILclass28;Lclass46;[LModIcon;I)V",
      garbageValue = "-1999816366"
   )
   void method405(int var1, int var2, class28 var3, class46 var4, ModIcon[] var5) {
      this.method363(var1, var2, var3);
      this.method461(var1, var2, var3, var5);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(IILclass28;I)I",
      garbageValue = "-502630372"
   )
   int method424(int var1, int var2, class28 var3) {
      return var3.field412[0][var1][var2] == 0?this.field486:this.field488[var1][var2];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "43110400"
   )
   void method428(int var1, int var2, int var3) {
      if(this.field483 != null) {
         if(var3 == this.field487 * 64) {
            this.field483.method5045(var1, var2);
         } else {
            this.field483.method5064(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIILclass28;B)V",
      garbageValue = "112"
   )
   void method435(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label66:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field411; ++var9) {
               class31[] var10 = var5.field416[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     class242 var14 = this.method374(var13.field445);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, var6 + this.field479 * 64, this.field481 * 64 + var7);
                        Coordinates var16 = null;
                        if(this.field484 != null) {
                           var16 = new Coordinates(this.field484.field410 + var9, var6 + this.field484.field409 * 64, this.field484.field417 * 64 + var7);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var17.field410 + var9, var6 + var17.field409 * 64 + var17.method639() * 8, var17.field417 * 64 + var7 + var17.method617() * 8);
                        }

                        class39 var18 = new class39(var14.field3289, var16, var15, this.method469(var14));
                        this.field491.put(var8, var18);
                        continue label66;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BB)LSpritePixels;",
      garbageValue = "-27"
   )
   public static final SpritePixels method441(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var2 * var3];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         return new SpritePixels(var4, var2, var3);
      } catch (IOException var7) {
         ;
      } catch (InterruptedException var8) {
         ;
      }

      return new SpritePixels(0, 0);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "470144569"
   )
   void method452(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method4944(this.field487 * var1, (63 - var2) * this.field487, this.field487, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method4982(this.field487 * var1, this.field487 * (63 - var2), this.field487, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method4944(this.field487 + var1 * this.field487 - 1, (63 - var2) * this.field487, this.field487, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method4982(var1 * this.field487, (63 - var2) * this.field487 + this.field487 - 1, this.field487, var4);
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IILclass28;[LModIcon;I)V",
      garbageValue = "1123026683"
   )
   void method461(int var1, int var2, class28 var3, ModIcon[] var4) {
      for(int var5 = 0; var5 < var3.field411; ++var5) {
         class31[] var6 = var3.field416[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               int var11 = var9.field446;
               boolean var10 = var11 >= class221.field2823.field2832 && var11 <= class221.field2809.field2832;
               if(var10 || ItemLayer.method2393(var9.field446)) {
                  ObjectComposition var12 = class226.getObjectDefinition(var9.field445);
                  if(var12.mapSceneId != -1) {
                     if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                        var4[var12.mapSceneId].method5019(this.field487 * var1, this.field487 * (63 - var2), this.field487 * 2, this.field487 * 2);
                     } else {
                        var4[var12.mapSceneId].method5019(this.field487 * var1, (63 - var2) * this.field487, this.field487 * 2 + 1, this.field487 * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1489338983"
   )
   boolean method468(int var1) {
      if(this.field483 != null && this.field487 == var1) {
         return false;
      } else {
         this.field487 = var1;
         this.field483 = new SpritePixels(this.field487 * 64, this.field487 * 64);
         return true;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Lclass242;I)Lclass33;",
      garbageValue = "473676084"
   )
   class33 method469(class242 var1) {
      if(var1.field3295 != null && this.field480 != null && this.field480.get(class24.field357) != null) {
         int var3 = var1.field3310;
         class24[] var4 = class24.method164();
         int var14 = 0;

         class24 var2;
         while(true) {
            if(var14 >= var4.length) {
               var2 = null;
               break;
            }

            class24 var6 = var4[var14];
            if(var3 == var6.field355) {
               var2 = var6;
               break;
            }

            ++var14;
         }

         if(var2 == null) {
            return null;
         } else {
            Font var5 = (Font)this.field480.get(var2);
            if(var5 == null) {
               return null;
            } else {
               int var15 = var5.method4765(var1.field3295, 1000000);
               String[] var7 = new String[var15];
               var5.method4729(var1.field3295, (int[])null, var7);
               int var8 = var5.field3652 * var7.length / 2;
               int var9 = 0;
               String[] var10 = var7;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var5.method4728(var12);
                  if(var13 > var9) {
                     var9 = var13;
                  }
               }

               return new class33(var1.field3295, var9, var8, var2);
            }
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "28"
   )
   static void method471() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "38"
   )
   static final void method472(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class21.method139(var0, var1, FaceNormal.plane) - var2;
         var0 -= TextureProvider.cameraX;
         var3 -= class19.cameraZ;
         var1 -= class67.cameraY;
         int var4 = class136.SINE[Preferences.cameraPitch];
         int var5 = class136.COSINE[Preferences.cameraPitch];
         int var6 = class136.SINE[class13.cameraYaw];
         int var7 = class136.COSINE[class13.cameraYaw];
         int var8 = var6 * var1 + var7 * var0 >> 16;
         var1 = var1 * var7 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var3 * var5 - var1 * var4 >> 16;
         var1 = var4 * var3 + var5 * var1 >> 16;
         if(var1 >= 50) {
            Client.field1124 = Client.camera2 / 2 + Client.scale * var0 / var1;
            Client.field1093 = var8 * Client.scale / var1 + Client.camera3 / 2;
         } else {
            Client.field1124 = -1;
            Client.field1093 = -1;
         }

      } else {
         Client.field1124 = -1;
         Client.field1093 = -1;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(ILCoordinates;ZB)V",
      garbageValue = "-11"
   )
   static void method474(int var0, Coordinates var1, boolean var2) {
      WorldMapData var3 = Tile.method2489().method5196(var0);
      int var4 = World.localPlayer.field911;
      int var5 = (World.localPlayer.x >> 7) + class41.baseX;
      int var6 = WorldMapType3.baseY + (World.localPlayer.y >> 7);
      Coordinates var7 = new Coordinates(var4, var5, var6);
      Tile.method2489().method5186(var3, var7, var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILclass219;I)LScript;",
      garbageValue = "-1792773230"
   )
   static Script method476(int var0, class219 var1) {
      Script var2 = (Script)Script.field1552.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class23.indexScripts.method4125(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = class23.indexScripts.method4115(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = CombatInfo1.method1543(var5);
               if(var2 != null) {
                  Script.field1552.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }
}
