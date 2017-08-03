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

@ObfuscatedName("au")
public class class34 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhy;"
   )
   static final Coordinates field463;
   @ObfuscatedName("iz")
   @ObfuscatedGetter(
      intValue = 773214525
   )
   static int field450;
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = -1184353143
   )
   static int field466;
   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   static MachineInfo field467;
   @ObfuscatedName("r")
   int[][] field458;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   SpritePixels field459;
   @ObfuscatedName("s")
   List field464;
   @ObfuscatedName("v")
   LinkedList field453;
   @ObfuscatedName("o")
   HashMap field460;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "La;"
   )
   class22 field461;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1515407595
   )
   int field455;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1755060415
   )
   int field457;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 773673049
   )
   int field456;
   @ObfuscatedName("p")
   final HashMap field462;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1770943433
   )
   int field465;

   static {
      field463 = new Coordinates();
   }

   class34(int var1, int var2, int var3, HashMap var4) {
      this.field455 = var1;
      this.field465 = var2;
      this.field453 = new LinkedList();
      this.field464 = new LinkedList();
      this.field460 = new HashMap();
      this.field456 = var3 | -16777216;
      this.field462 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "40"
   )
   boolean method467(int var1) {
      if(this.field459 != null && this.field457 == var1) {
         return false;
      } else {
         this.field457 = var1;
         this.field459 = new SpritePixels(this.field457 * 64, this.field457 * 64);
         return true;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILax;B)V",
      garbageValue = "122"
   )
   void method416(int var1, int var2, class28 var3) {
      for(int var4 = 0; var4 < var3.field382; ++var4) {
         class31[] var5 = var3.field389[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               int var10 = var8.field417;
               boolean var9 = var10 >= class221.field2811.field2813 && var10 <= class221.field2792.field2813 || var10 == class221.field2804.field2813;
               if(var9) {
                  ObjectComposition var11 = WidgetNode.getObjectDefinition(var8.field422);
                  int var12 = var11.field3463 != 0?-3407872:-3355444;
                  if(var8.field417 == class221.field2811.field2813) {
                     this.method396(var1, var2, var8.field416, var12);
                  }

                  if(var8.field417 == class221.field2805.field2813) {
                     this.method396(var1, var2, var8.field416, -3355444);
                     this.method396(var1, var2, var8.field416 + 1, var12);
                  }

                  if(var8.field417 == class221.field2792.field2813) {
                     if(var8.field416 == 0) {
                        Rasterizer2D.method5003(this.field457 * var1, this.field457 * (63 - var2), 1, var12);
                     }

                     if(var8.field416 == 1) {
                        Rasterizer2D.method5003(this.field457 * var1 + this.field457 - 1, this.field457 * (63 - var2), 1, var12);
                     }

                     if(var8.field416 == 2) {
                        Rasterizer2D.method5003(this.field457 * var1 + this.field457 - 1, this.field457 * (63 - var2) + this.field457 - 1, 1, var12);
                     }

                     if(var8.field416 == 3) {
                        Rasterizer2D.method5003(this.field457 * var1, this.field457 + this.field457 * (63 - var2) - 1, 1, var12);
                     }
                  }

                  if(var8.field417 == class221.field2804.field2813) {
                     int var13 = var8.field416 % 2;
                     int var14;
                     if(var13 == 0) {
                        for(var14 = 0; var14 < this.field457; ++var14) {
                           Rasterizer2D.method5003(var14 + this.field457 * var1, (64 - var2) * this.field457 - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.field457; ++var14) {
                           Rasterizer2D.method5003(var14 + this.field457 * var1, this.field457 * (63 - var2) + var14, 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-2065970529"
   )
   void method380(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.field460.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coordinates var9 = (Coordinates)var8.getKey();
         int var10 = (int)(var5 * (float)var9.worldX + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - (float)var9.worldY * var5 - var6);
         class39 var12 = (class39)var8.getValue();
         if(var12 != null) {
            var12.field498 = var10;
            var12.field499 = var11;
            Area var13 = Area.field3286[var12.field505];
            if(!var3.contains(Integer.valueOf(var13.method4273()))) {
               this.method369(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(Lij;I)Lai;",
      garbageValue = "-1054885944"
   )
   class33 method379(Area var1) {
      if(var1.name != null && this.field462 != null && this.field462.get(class24.field338) != null) {
         int var3 = var1.field3283;
         class24[] var4 = new class24[]{class24.field338, class24.field336, class24.field337};
         class24[] var5 = var4;
         int var6 = 0;

         class24 var2;
         while(true) {
            if(var6 >= var5.length) {
               var2 = null;
               break;
            }

            class24 var7 = var5[var6];
            if(var3 == var7.field335) {
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
               var6 = var14.method4791(var1.name, 1000000);
               String[] var15 = new String[var6];
               var14.method4827(var1.name, (int[])null, var15);
               int var8 = var15.length * var14.verticalSpace / 2;
               int var9 = 0;
               String[] var10 = var15;

               for(int var11 = 0; var11 < var10.length; ++var11) {
                  String var12 = var10[var11];
                  int var13 = var14.method4820(var12);
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IILax;[Ljw;S)V",
      garbageValue = "6559"
   )
   void method378(int var1, int var2, class28 var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.field382; ++var5) {
         class31[] var6 = var3.field389[var5][var1][var2];
         if(var6 != null && var6.length != 0) {
            class31[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               class31 var9 = var7[var8];
               int var11 = var9.field417;
               boolean var10 = var11 >= class221.field2809.field2813 && var11 <= class221.field2810.field2813;
               if(var10 || class60.method1048(var9.field417)) {
                  ObjectComposition var12 = WidgetNode.getObjectDefinition(var9.field422);
                  if(var12.mapSceneId != -1) {
                     if(var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                        var4[var12.mapSceneId].method5056(this.field457 * var1, this.field457 * (63 - var2), this.field457 * 2, this.field457 * 2);
                     } else {
                        var4[var12.mapSceneId].method5056(this.field457 * var1, this.field457 * (63 - var2), this.field457 * 2 + 1, this.field457 * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lij;III)V",
      garbageValue = "-215809061"
   )
   void method384(Area var1, int var2, int var3) {
      SpritePixels var4 = var1.method4271(false);
      if(var4 != null) {
         int var5 = this.method389(var4, var1.field3291);
         int var6 = this.method390(var4, var1.field3293);
         var4.method5069(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(IILjava/util/HashSet;II)V",
      garbageValue = "-1222565443"
   )
   void method386(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.field464.iterator();

      while(var6.hasNext()) {
         class39 var7 = (class39)var6.next();
         int var8 = var7.field504.worldX % 64;
         int var9 = var7.field504.worldY % 64;
         var7.field498 = (int)(var5 * (float)var8 + (float)var1);
         var7.field499 = (int)((float)var2 + (float)(63 - var9) * var5);
         if(!var3.contains(Integer.valueOf(var7.field505))) {
            this.method369(var7, var7.field498, var7.field499, var5);
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILax;Las;I)V",
      garbageValue = "134030085"
   )
   void method370(int var1, int var2, class28 var3, class46 var4) {
      int var5 = var3.field385[0][var1][var2] - 1;
      int var6 = var3.field386[0][var1][var2] - 1;
      if(var5 == -1 && var6 == -1) {
         Rasterizer2D.method4937(this.field457 * var1, this.field457 * (63 - var2), this.field457, this.field457, this.field456);
      }

      int var7 = 16711935;
      if(var6 != -1) {
         var7 = class140.method2891(var6, this.field456);
      }

      if(var6 > -1 && var3.field388[0][var1][var2] == 0) {
         Rasterizer2D.method4937(this.field457 * var1, this.field457 * (63 - var2), this.field457, this.field457, var7);
      } else {
         int var8 = this.method491(var1, var2, var3);
         if(var6 == -1) {
            Rasterizer2D.method4937(this.field457 * var1, this.field457 * (63 - var2), this.field457, this.field457, var8);
         } else {
            var4.method666(this.field457 * var1, this.field457 * (63 - var2), var8, var7, this.field457, this.field457, var3.field388[0][var1][var2], var3.field387[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lji;Lid;I)I",
      garbageValue = "752234481"
   )
   int method389(SpritePixels var1, class257 var2) {
      switch(var2.field3524) {
      case 1:
         return -var1.width / 2;
      case 2:
         return 0;
      default:
         return -var1.width;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "660353113"
   )
   int method397(int var1, int var2) {
      if(this.field461 != null) {
         return this.field461.method215(var1, var2);
      } else {
         if(!this.field453.isEmpty()) {
            Iterator var3 = this.field453.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               if(var4.method645(var1, var2)) {
                  return var4.method215(var1, var2);
               }
            }
         }

         return -1;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      signature = "(Laz;Lij;IIFI)V",
      garbageValue = "-1393489176"
   )
   void method472(class39 var1, Area var2, int var3, int var4, float var5) {
      if(var1.field507 != null) {
         if(var1.field507.field443.method166(var5)) {
            Font var6 = (Font)this.field462.get(var1.field507.field443);
            var6.method4833(var1.field507.field444, var3 - var1.field507.field441 / 2, var4, var1.field507.field441, var1.field507.field442, -16777216 | var2.field3282, 0, 1, 0, var6.verticalSpace / 2);
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILax;Las;[Ljw;B)V",
      garbageValue = "1"
   )
   void method493(int var1, int var2, class28 var3, class46 var4, IndexedSprite[] var5) {
      this.method416(var1, var2, var3);
      this.method378(var1, var2, var3, var5);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "1159996837"
   )
   void method385(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field464.iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         Area var6 = Area.field3286[var5.field505];
         if(var6 != null && var1.contains(Integer.valueOf(var6.method4273()))) {
            this.method382(var6, var5.field498, var5.field499, var2, var3);
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIIILax;I)V",
      garbageValue = "-946889055"
   )
   void method361(int var1, int var2, int var3, int var4, class28 var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label56:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            Coordinates var8 = new Coordinates(0, var6, var7);

            for(int var9 = 0; var9 < var5.field382; ++var9) {
               class31[] var10 = var5.field389[var9][var6][var7];
               if(var10 != null && var10.length != 0) {
                  class31[] var11 = var10;

                  for(int var12 = 0; var12 < var11.length; ++var12) {
                     class31 var13 = var11[var12];
                     Area var14 = this.method391(var13.field422);
                     if(var14 != null) {
                        Coordinates var15 = new Coordinates(var9, var6 + this.field455 * 64, var7 + this.field465 * 64);
                        Coordinates var16 = null;
                        if(this.field461 != null) {
                           var16 = new Coordinates(this.field461.field383 + var9, var6 + this.field461.field384 * 64, var7 + this.field461.field380 * 64);
                        } else {
                           class45 var17 = (class45)var5;
                           var16 = new Coordinates(var9 + var17.field383, var6 + var17.field384 * 64 + var17.method648() * 8, var17.field380 * 64 + var7 + var17.method649() * 8);
                        }

                        class39 var18 = new class39(var14.field3278, var16, var15, this.method379(var14));
                        this.field460.put(var8, var18);
                        continue label56;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/util/List;B)V",
      garbageValue = "-4"
   )
   void method362(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         class25 var3 = (class25)var2.next();
         if(var3.field348.worldX >> 6 == this.field455 && var3.field348.worldY >> 6 == this.field465) {
            class39 var4 = new class39(var3.field346, var3.field348, var3.field348, this.method411(var3.field346));
            this.field464.add(var4);
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([Lau;I)Z",
      garbageValue = "2018012984"
   )
   boolean method439(class34[] var1) {
      if(this.field458 != null) {
         return false;
      } else {
         class43 var2 = new class43(64, 64);
         if(this.field461 != null) {
            this.method375(0, 0, 64, 64, this.field461, var2);
         } else {
            Iterator var3 = this.field453.iterator();

            while(var3.hasNext()) {
               class45 var4 = (class45)var3.next();
               this.method375(var4.method650() * 8, var4.method643() * 8, 8, 8, var4, var2);
            }
         }

         this.method374(var1, var2);
         this.method373(var2);
         return true;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(IILax;I)V",
      garbageValue = "-1178513638"
   )
   void method446(int var1, int var2, class28 var3) {
      field463.method3940(0, var1, var2);

      for(int var4 = 0; var4 < var3.field382; ++var4) {
         class31[] var5 = var3.field389[var4][var1][var2];
         if(var5 != null && var5.length != 0) {
            class31[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               class31 var8 = var6[var7];
               Area var9 = this.method391(var8.field422);
               if(var9 != null) {
                  class39 var10 = (class39)this.field460.get(field463);
                  if(var10 != null) {
                     if(var9.field3278 != var10.field505) {
                        class39 var16 = new class39(var9.field3278, var10.field500, var10.field504, this.method379(var9));
                        this.field460.put(new Coordinates(field463), var16);
                        var10 = var16;
                     }

                     int var15 = var10.field500.plane - var10.field504.plane;
                     var10.field504.plane = var4;
                     var10.field500.plane = var15 + var4;
                     return;
                  }

                  Coordinates var11 = new Coordinates(var4, this.field455 * 64 + var1, var2 + this.field465 * 64);
                  Coordinates var12 = null;
                  if(this.field461 != null) {
                     var12 = new Coordinates(this.field461.field383 + var4, this.field461.field384 * 64 + var1, this.field461.field380 * 64 + var2);
                  } else {
                     Iterator var13 = this.field453.iterator();

                     while(var13.hasNext()) {
                        class45 var14 = (class45)var13.next();
                        if(var14.method645(var1, var2)) {
                           var12 = new Coordinates(var4 + var14.field383, var1 + var14.field384 * 64 + var14.method648() * 8, var2 + var14.field380 * 64 + var14.method649() * 8);
                           break;
                        }
                     }
                  }

                  if(var12 != null) {
                     var10 = new class39(var9.field3278, var12, var11, this.method379(var9));
                     this.field460.put(new Coordinates(field463), var10);
                     return;
                  }
               }
            }
         }
      }

      this.field460.remove(field463);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IILax;Las;I)V",
      garbageValue = "1928548872"
   )
   void method371(int var1, int var2, class28 var3, class46 var4) {
      for(int var5 = 1; var5 < var3.field382; ++var5) {
         int var6 = var3.field386[var5][var1][var2] - 1;
         if(var6 > -1) {
            int var7 = class140.method2891(var6, this.field456);
            if(var3.field388[var5][var1][var2] == 0) {
               Rasterizer2D.method4937(this.field457 * var1, this.field457 * (63 - var2), this.field457, this.field457, var7);
            } else {
               var4.method666(this.field457 * var1, this.field457 * (63 - var2), 0, var7, this.field457, this.field457, var3.field388[var5][var1][var2], var3.field387[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(Lji;Lis;B)I",
      garbageValue = "46"
   )
   int method390(SpritePixels var1, class239 var2) {
      switch(var2.field3256) {
      case 0:
         return -var1.height / 2;
      case 1:
         return 0;
      default:
         return -var1.height;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIILax;Laf;I)V",
      garbageValue = "300917861"
   )
   void method375(int var1, int var2, int var3, int var4, class28 var5, class43 var6) {
      for(int var7 = var1; var7 < var3 + var1; ++var7) {
         for(int var8 = var2; var8 < var2 + var4; ++var8) {
            int var9 = var5.field385[0][var7][var8] - 1;
            if(var9 != -1) {
               FloorUnderlayDefinition var10 = class169.method3168(var9);
               var6.method635(var7, var8, 5, var10);
            }
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IILax;I)I",
      garbageValue = "-1509796023"
   )
   int method491(int var1, int var2, class28 var3) {
      return var3.field385[0][var1][var2] == 0?this.field456:this.field458[var1][var2];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([Lau;Laf;I)V",
      garbageValue = "1965977487"
   )
   void method374(class34[] var1, class43 var2) {
      class228[] var3 = new class228[]{class228.field3134, class228.field3133, class228.field3132, class228.field3139, class228.field3131, class228.field3137, class228.field3128, class228.field3130};
      class228[] var5 = var3;

      for(int var6 = 0; var6 < var5.length; ++var6) {
         class228 var7 = var5[var6];
         if(var1[var7.rsOrdinal()] != null) {
            byte var8 = 0;
            byte var9 = 0;
            byte var10 = 64;
            byte var11 = 64;
            byte var12 = 0;
            byte var13 = 0;
            switch(var7.field3135) {
            case 0:
               var13 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 1:
               var9 = 59;
               var11 = 5;
               var12 = 59;
               var10 = 5;
               break;
            case 2:
               var9 = 59;
               var11 = 5;
               break;
            case 3:
               var12 = 59;
               var13 = 59;
               var10 = 5;
               var11 = 5;
               break;
            case 4:
               var12 = 59;
               var10 = 5;
               break;
            case 5:
               var13 = 59;
               var11 = 5;
               break;
            case 6:
               var9 = 59;
               var11 = 5;
               var8 = 59;
               var10 = 5;
               break;
            case 7:
               var8 = 59;
               var10 = 5;
            }

            this.method376(var12, var13, var8, var9, var10, var11, var1[var7.rsOrdinal()], var2);
         }
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(II)Lij;",
      garbageValue = "-1014924228"
   )
   Area method391(int var1) {
      ObjectComposition var2 = WidgetNode.getObjectDefinition(var1);
      if(var2.impostorIds != null) {
         var2 = var2.getImpostor();
         if(var2 == null) {
            return null;
         }
      }

      return var2.mapIconId != -1?Area.field3286[var2.mapIconId]:null;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Laf;B)V",
      garbageValue = "0"
   )
   void method373(class43 var1) {
      this.field458 = new int[64][64];

      for(int var2 = 0; var2 < 64; ++var2) {
         for(int var3 = 0; var3 < 64; ++var3) {
            this.field458[var2][var3] = var1.method626(var2, var3) | -16777216;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Las;[Ljw;B)V",
      garbageValue = "1"
   )
   void method368(class46 var1, IndexedSprite[] var2) {
      Iterator var3 = this.field453.iterator();

      class45 var4;
      int var5;
      int var6;
      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method650() * 8; var5 < var4.method650() * 8 + 8; ++var5) {
            for(var6 = var4.method643() * 8; var6 < var4.method643() * 8 + 8; ++var6) {
               this.method370(var5, var6, var4, var1);
               this.method371(var5, var6, var4, var1);
            }
         }
      }

      var3 = this.field453.iterator();

      while(var3.hasNext()) {
         var4 = (class45)var3.next();

         for(var5 = var4.method650() * 8; var5 < var4.method650() * 8 + 8; ++var5) {
            for(var6 = var4.method643() * 8; var6 < var4.method643() * 8 + 8; ++var6) {
               this.method493(var5, var6, var4, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Las;[Lau;[Ljw;I)V",
      garbageValue = "12930080"
   )
   void method377(class46 var1, class34[] var2, IndexedSprite[] var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method370(var4, var5, this.field461, var1);
            this.method371(var4, var5, this.field461, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method493(var4, var5, this.field461, var1, var3);
         }
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(I)Ljava/util/List;",
      garbageValue = "-1205545245"
   )
   List method395() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.field464);
      var1.addAll(this.field460.values());
      return var1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(Lij;IIIIB)V",
      garbageValue = "-1"
   )
   void method382(Area var1, int var2, int var3, int var4, int var5) {
      SpritePixels var6 = var1.method4271(false);
      if(var6 != null) {
         var6.method5069(var2 - var6.width / 2, var3 - var6.height / 2);
         if(var4 % var5 < var5 / 2) {
            Rasterizer2D.method4935(var2, var3, 15, 16776960, 128);
            Rasterizer2D.method4935(var2, var3, 7, 16777215, 256);
         }

      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(II)Lai;",
      garbageValue = "674662896"
   )
   class33 method411(int var1) {
      Area var2 = Area.field3286[var1];
      return this.method379(var2);
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "19"
   )
   void method445() {
      if(this.field461 != null) {
         for(int var1 = 0; var1 < 64; ++var1) {
            for(int var2 = 0; var2 < 64; ++var2) {
               this.method446(var1, var2, this.field461);
            }
         }
      } else {
         Iterator var5 = this.field453.iterator();

         while(var5.hasNext()) {
            class45 var6 = (class45)var5.next();

            for(int var3 = var6.method650() * 8; var3 < var6.method650() * 8 + 8; ++var3) {
               for(int var4 = var6.method643() * 8; var4 < var6.method643() * 8 + 8; ++var4) {
                  this.method446(var3, var4, var6);
               }
            }
         }
      }

   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Laz;IIFI)V",
      garbageValue = "2034557008"
   )
   void method369(class39 var1, int var2, int var3, float var4) {
      Area var5 = Area.field3286[var1.field505];
      this.method384(var5, var2, var3);
      this.method472(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;III)V",
      garbageValue = "-1625164901"
   )
   void method365(HashSet var1, int var2, int var3) {
      Iterator var4 = this.field460.values().iterator();

      while(var4.hasNext()) {
         class39 var5 = (class39)var4.next();
         if(var1.contains(Integer.valueOf(var5.field505))) {
            Area var6 = Area.field3286[var5.field505];
            this.method382(var6, var5.field498, var5.field499, var2, var3);
         }
      }

      this.method385(var1, var2, var3);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "108"
   )
   void method396(int var1, int var2, int var3, int var4) {
      var3 %= 4;
      if(var3 == 0) {
         Rasterizer2D.method4948(this.field457 * var1, this.field457 * (63 - var2), this.field457, var4);
      }

      if(var3 == 1) {
         Rasterizer2D.method5003(this.field457 * var1, this.field457 * (63 - var2), this.field457, var4);
      }

      if(var3 == 2) {
         Rasterizer2D.method4948(this.field457 * var1 + this.field457 - 1, this.field457 * (63 - var2), this.field457, var4);
      }

      if(var3 == 3) {
         Rasterizer2D.method5003(this.field457 * var1, this.field457 * (63 - var2) + this.field457 - 1, this.field457, var4);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIILjava/util/HashSet;I)V",
      garbageValue = "-1823481678"
   )
   void method364(int var1, int var2, int var3, HashSet var4) {
      if(var4 == null) {
         var4 = new HashSet();
      }

      this.method380(var1, var2, var4, var3);
      this.method386(var1, var2, var4, var3);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(IIIIIB)Ljava/util/List;",
      garbageValue = "114"
   )
   List method394(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if(var4 >= var1 && var5 >= var2) {
         if(var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.field460.values().iterator();

            class39 var8;
            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method545(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.field464.iterator();

            while(var7.hasNext()) {
               var8 = (class39)var7.next();
               if(var8.method545(var4, var5)) {
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILas;[Lau;[Ljw;B)Z",
      garbageValue = "97"
   )
   boolean method433(int var1, class46 var2, class34[] var3, IndexedSprite[] var4) {
      if(!this.method467(var1)) {
         return false;
      } else if(this.field461 == null && this.field453.isEmpty()) {
         return false;
      } else {
         this.method439(var3);
         this.field459.method5060();
         if(this.field461 != null) {
            this.method377(var2, var3, var4);
         } else {
            this.method368(var2, var4);
         }

         return true;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIIIILau;Laf;I)V",
      garbageValue = "196917932"
   )
   void method376(int var1, int var2, int var3, int var4, int var5, int var6, class34 var7, class43 var8) {
      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var6; ++var10) {
            int var11 = var7.method397(var9 + var1, var10 + var2);
            if(var11 != -1) {
               FloorUnderlayDefinition var12 = class169.method3168(var11);
               var8.method635(var3 + var9, var10 + var4, 5, var12);
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2060488641"
   )
   void method358(int var1, int var2, int var3) {
      if(this.field459 != null) {
         if(this.field457 * 64 == var3) {
            this.field459.method5067(var1, var2);
         } else {
            this.field459.method5084(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(La;Ljava/util/List;I)V",
      garbageValue = "-1319388347"
   )
   void method359(class22 var1, List var2) {
      this.field460.clear();
      this.field461 = var1;
      this.method361(0, 0, 64, 64, this.field461);
      this.method362(var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/util/HashSet;Ljava/util/List;B)V",
      garbageValue = "1"
   )
   void method421(HashSet var1, List var2) {
      this.field460.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         class45 var4 = (class45)var3.next();
         if(var4.method216() == this.field455 && var4.method226() == this.field465) {
            this.field453.add(var4);
            this.method361(var4.method650() * 8, var4.method643() * 8, 8, 8, var4);
         }
      }

      this.method362(var2);
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-233053540"
   )
   static final void method449() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      if(Client.packetType == (Client.RUNELITE_PACKET?38:132)) {
         if(Client.RUNELITE_PACKET) {
            var0 = Client.secretPacketBuffer2.runeliteReadInt();
            var4 = Client.secretPacketBuffer2.runeliteReadInt();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = Client.field957[var1];
         } else {
            var0 = Client.secretPacketBuffer2.readUnsignedByte();
            var1 = var0 >> 2;
            var2 = var0 & 3;
            var3 = Client.field957[var1];
            var4 = Client.secretPacketBuffer2.readUnsignedByte();
         }

         var5 = (var4 >> 4 & 7) + DecorativeObject.field2152;
         var6 = (var4 & 7) + class24.field343;
         if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
            WorldListFetcher.method1532(class8.plane, var5, var6, var3, -1, var1, var2, 0, -1);
         }

      } else {
         Item var30;
         if(Client.packetType == (Client.RUNELITE_PACKET?39:170)) {
            if(Client.RUNELITE_PACKET) {
               var0 = Client.secretPacketBuffer2.runeliteReadInt();
               var3 = Client.secretPacketBuffer2.runeliteReadInt();
               var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
               var2 = (var0 & 7) + class24.field343;
            } else {
               var0 = Client.secretPacketBuffer2.method3295();
               var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
               var2 = (var0 & 7) + class24.field343;
               var3 = Client.secretPacketBuffer2.readUnsignedShortOb1();
            }

            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               Deque var29 = Client.groundItemDeque[class8.plane][var1][var2];
               if(var29 != null) {
                  for(var30 = (Item)var29.getFront(); var30 != null; var30 = (Item)var29.getNext()) {
                     if((var3 & 32767) == var30.id) {
                        var30.unlink();
                        break;
                     }
                  }

                  if(var29.getFront() == null) {
                     Client.groundItemDeque[class8.plane][var1][var2] = null;
                  }

                  groundItemSpawned(var1, var2);
               }
            }

         } else {
            int var7;
            int var9;
            if(Client.packetType == (Client.RUNELITE_PACKET?46:172)) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var4 = Client.secretPacketBuffer2.runeliteReadInt();
                  var7 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = Client.field957[var1];
                  var5 = (var4 >> 4 & 7) + DecorativeObject.field2152;
                  var6 = (var4 & 7) + class24.field343;
               } else {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = Client.field957[var1];
                  var4 = Client.secretPacketBuffer2.method3228();
                  var5 = (var4 >> 4 & 7) + DecorativeObject.field2152;
                  var6 = (var4 & 7) + class24.field343;
                  var7 = Client.secretPacketBuffer2.readUnsignedShort();
               }

               if(var5 >= 0 && var6 >= 0 && var5 < 103 && var6 < 103) {
                  if(var3 == 0) {
                     WallObject var8 = class51.region.method2722(class8.plane, var5, var6);
                     if(var8 != null) {
                        var9 = var8.hash >> 14 & 32767;
                        if(var1 == 2) {
                           var8.renderable1 = new DynamicObject(var9, 2, var2 + 4, class8.plane, var5, var6, var7, false, var8.renderable1);
                           var8.renderable2 = new DynamicObject(var9, 2, var2 + 1 & 3, class8.plane, var5, var6, var7, false, var8.renderable2);
                        } else {
                           var8.renderable1 = new DynamicObject(var9, var1, var2, class8.plane, var5, var6, var7, false, var8.renderable1);
                        }
                     }
                  }

                  if(var3 == 1) {
                     DecorativeObject var38 = class51.region.method2821(class8.plane, var5, var6);
                     if(var38 != null) {
                        var9 = var38.hash >> 14 & 32767;
                        if(var1 != 4 && var1 != 5) {
                           if(var1 == 6) {
                              var38.renderable1 = new DynamicObject(var9, 4, var2 + 4, class8.plane, var5, var6, var7, false, var38.renderable1);
                           } else if(var1 == 7) {
                              var38.renderable1 = new DynamicObject(var9, 4, (var2 + 2 & 3) + 4, class8.plane, var5, var6, var7, false, var38.renderable1);
                           } else if(var1 == 8) {
                              var38.renderable1 = new DynamicObject(var9, 4, var2 + 4, class8.plane, var5, var6, var7, false, var38.renderable1);
                              var38.renderable2 = new DynamicObject(var9, 4, (var2 + 2 & 3) + 4, class8.plane, var5, var6, var7, false, var38.renderable2);
                           }
                        } else {
                           var38.renderable1 = new DynamicObject(var9, 4, var2, class8.plane, var5, var6, var7, false, var38.renderable1);
                        }
                     }
                  }

                  if(var3 == 2) {
                     GameObject var39 = class51.region.method2724(class8.plane, var5, var6);
                     if(var1 == 11) {
                        var1 = 10;
                     }

                     if(var39 != null) {
                        var39.renderable = new DynamicObject(var39.hash >> 14 & 32767, var1, var2, class8.plane, var5, var6, var7, false, var39.renderable);
                     }
                  }

                  if(var3 == 3) {
                     GroundObject var40 = class51.region.method2725(class8.plane, var5, var6);
                     if(var40 != null) {
                        var40.renderable = new DynamicObject(var40.hash >> 14 & 32767, 22, var2, class8.plane, var5, var6, var7, false, var40.renderable);
                     }
                  }
               }

            } else if(Client.packetType == (Client.RUNELITE_PACKET?48:214)) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var5 = Client.secretPacketBuffer2.runeliteReadInt();
                  var4 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = Client.field957[var1];
               } else {
                  var0 = Client.secretPacketBuffer2.method3228();
                  var1 = var0 >> 2;
                  var2 = var0 & 3;
                  var3 = Client.field957[var1];
                  var4 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                  var5 = Client.secretPacketBuffer2.method3230();
               }

               var6 = (var5 >> 4 & 7) + DecorativeObject.field2152;
               var7 = (var5 & 7) + class24.field343;
               if(var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                  WorldListFetcher.method1532(class8.plane, var6, var7, var3, var4, var1, var2, 0, -1);
               }

            } else if(Client.packetType == (Client.RUNELITE_PACKET?52:31)) {
               if(Client.RUNELITE_PACKET) {
                  var0 = Client.secretPacketBuffer2.runeliteReadInt();
                  var4 = Client.secretPacketBuffer2.runeliteReadInt();
                  var3 = Client.secretPacketBuffer2.runeliteReadInt();
                  var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
                  var2 = (var0 & 7) + class24.field343;
               } else {
                  var0 = Client.secretPacketBuffer2.readUnsignedByte();
                  var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
                  var2 = (var0 & 7) + class24.field343;
                  var3 = Client.secretPacketBuffer2.method3236();
                  var4 = Client.secretPacketBuffer2.readUnsignedShort();
               }

               if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                  var30 = new Item();
                  var30.id = var4;
                  var30.quantity = var3;
                  if(Client.groundItemDeque[class8.plane][var1][var2] == null) {
                     Client.groundItemDeque[class8.plane][var1][var2] = new Deque();
                  }

                  Client.groundItemDeque[class8.plane][var1][var2].addFront(var30);
                  groundItemSpawned(var1, var2);
               }

            } else {
               int var31;
               if(Client.packetType == (Client.RUNELITE_PACKET?58:134)) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var4 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var7 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
                     var2 = (var0 & 7) + class24.field343;
                     var5 = var4 >> 4 & 15;
                     var6 = var4 & 7;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
                     var2 = (var0 & 7) + class24.field343;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var4 = Client.secretPacketBuffer2.readUnsignedByte();
                     var5 = var4 >> 4 & 15;
                     var6 = var4 & 7;
                     var7 = Client.secretPacketBuffer2.readUnsignedByte();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var31 = var5 + 1;
                     if(class224.localPlayer.pathX[0] >= var1 - var31 && class224.localPlayer.pathX[0] <= var1 + var31 && class224.localPlayer.pathY[0] >= var2 - var31 && class224.localPlayer.pathY[0] <= var31 + var2 && Client.field1123 != 0 && var6 > 0 && Client.field1124 < 50) {
                        Client.field1089[Client.field1124] = var3;
                        Client.field917[Client.field1124] = var6;
                        Client.field1105[Client.field1124] = var7;
                        Client.audioEffects[Client.field1124] = null;
                        Client.field1128[Client.field1124] = var5 + (var2 << 8) + (var1 << 16);
                        ++Client.field1124;
                     }
                  }

               } else if(Client.packetType == (Client.RUNELITE_PACKET?59:164)) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var4 = Client.secretPacketBuffer2.runeliteReadInt();
                     var5 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
                     var2 = (var0 & 7) + class24.field343;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
                     var2 = (var0 & 7) + class24.field343;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var4 = Client.secretPacketBuffer2.readUnsignedByte();
                     var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     var1 = var1 * 128 + 64;
                     var2 = 64 + var2 * 128;
                     GraphicsObject var42 = new GraphicsObject(var3, class8.plane, var1, var2, class18.getTileHeight(var1, var2, class8.plane) - var4, var5, Client.gameCycle);
                     Client.graphicsObjectDeque.addFront(var42);
                  }

               } else if(Client.packetType == (Client.RUNELITE_PACKET?62:182)) {
                  if(Client.RUNELITE_PACKET) {
                     var0 = Client.secretPacketBuffer2.runeliteReadInt();
                     var3 = Client.secretPacketBuffer2.runeliteReadInt();
                     var4 = Client.secretPacketBuffer2.runeliteReadInt();
                     var5 = Client.secretPacketBuffer2.runeliteReadInt();
                     var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
                     var2 = (var0 & 7) + class24.field343;
                  } else {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
                     var2 = (var0 & 7) + class24.field343;
                     var3 = Client.secretPacketBuffer2.readUnsignedShort();
                     var4 = Client.secretPacketBuffer2.readUnsignedShort();
                     var5 = Client.secretPacketBuffer2.readUnsignedShort();
                  }

                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                     Deque var33 = Client.groundItemDeque[class8.plane][var1][var2];
                     if(var33 != null) {
                        for(Item var34 = (Item)var33.getFront(); var34 != null; var34 = (Item)var33.getNext()) {
                           if((var3 & 32767) == var34.id && var4 == var34.quantity) {
                              var34.quantity = var5;
                              break;
                           }
                        }

                        groundItemSpawned(var1, var2);
                     }
                  }

               } else {
                  int var10;
                  int var11;
                  int var12;
                  if(Client.packetType == (Client.RUNELITE_PACKET?75:3)) {
                     int var14;
                     int var32;
                     byte var35;
                     byte var36;
                     byte var37;
                     byte var41;
                     if(Client.RUNELITE_PACKET) {
                        var0 = Client.secretPacketBuffer2.runeliteReadInt();
                        var9 = Client.secretPacketBuffer2.runeliteReadInt();
                        var5 = Client.secretPacketBuffer2.runeliteReadInt();
                        var3 = Client.secretPacketBuffer2.runeliteReadInt();
                        var32 = Client.secretPacketBuffer2.runeliteReadInt();
                        var14 = Client.secretPacketBuffer2.runeliteReadInt();
                        var36 = Client.secretPacketBuffer2.runeliteReadByte();
                        var37 = Client.secretPacketBuffer2.runeliteReadByte();
                        var41 = Client.secretPacketBuffer2.runeliteReadByte();
                        var35 = Client.secretPacketBuffer2.runeliteReadByte();
                        var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
                        var2 = (var0 & 7) + class24.field343;
                        var10 = var9 >> 2;
                        var11 = var9 & 3;
                        var12 = Client.field957[var10];
                     } else {
                        var0 = Client.secretPacketBuffer2.method3230();
                        var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
                        var2 = (var0 & 7) + class24.field343;
                        var3 = Client.secretPacketBuffer2.method3236();
                        var35 = Client.secretPacketBuffer2.readByte();
                        var5 = Client.secretPacketBuffer2.readUnsignedShort();
                        var36 = Client.secretPacketBuffer2.readByte();
                        var37 = Client.secretPacketBuffer2.readByte();
                        var41 = Client.secretPacketBuffer2.readByte();
                        var9 = Client.secretPacketBuffer2.method3228();
                        var10 = var9 >> 2;
                        var11 = var9 & 3;
                        var12 = Client.field957[var10];
                        var32 = Client.secretPacketBuffer2.readByteOb1();
                        var14 = Client.secretPacketBuffer2.readUnsignedShortOb1();
                     }

                     Player var15;
                     if(var5 == Client.localInteractingIndex) {
                        var15 = class224.localPlayer;
                     } else {
                        var15 = Client.cachedPlayers[var5];
                     }

                     if(var15 != null) {
                        ObjectComposition var16 = WidgetNode.getObjectDefinition(var3);
                        int var17;
                        int var18;
                        if(var11 != 1 && var11 != 3) {
                           var17 = var16.sizeX;
                           var18 = var16.sizeY;
                        } else {
                           var17 = var16.sizeY;
                           var18 = var16.sizeX;
                        }

                        int var19 = var1 + (var17 >> 1);
                        int var20 = var1 + (var17 + 1 >> 1);
                        int var21 = var2 + (var18 >> 1);
                        int var22 = (var18 + 1 >> 1) + var2;
                        int[][] var23 = class62.tileHeights[class8.plane];
                        int var24 = var23[var20][var22] + var23[var19][var22] + var23[var19][var21] + var23[var20][var21] >> 2;
                        int var25 = (var1 << 7) + (var17 << 6);
                        int var26 = (var2 << 7) + (var18 << 6);
                        Model var27 = var16.method4499(var10, var11, var23, var25, var24, var26);
                        if(var27 != null) {
                           WorldListFetcher.method1532(class8.plane, var1, var2, var12, -1, 0, 0, var32 + 1, var14 + 1);
                           var15.field878 = var32 + Client.gameCycle;
                           var15.field860 = var14 + Client.gameCycle;
                           var15.model = var27;
                           var15.field867 = var1 * 128 + var17 * 64;
                           var15.field869 = var2 * 128 + var18 * 64;
                           var15.field856 = var24;
                           byte var28;
                           if(var37 > var35) {
                              var28 = var37;
                              var37 = var35;
                              var35 = var28;
                           }

                           if(var41 > var36) {
                              var28 = var41;
                              var41 = var36;
                              var36 = var28;
                           }

                           var15.field871 = var1 + var37;
                           var15.field873 = var1 + var35;
                           var15.field872 = var2 + var41;
                           var15.field880 = var2 + var36;
                        }
                     }

                  } else if(Client.packetType == (Client.RUNELITE_PACKET?77:138)) {
                     var0 = Client.secretPacketBuffer2.readUnsignedByte();
                     var1 = (var0 >> 4 & 7) + DecorativeObject.field2152;
                     var2 = (var0 & 7) + class24.field343;
                     var3 = var1 + Client.secretPacketBuffer2.readByte();
                     var4 = var2 + Client.secretPacketBuffer2.readByte();
                     var5 = Client.secretPacketBuffer2.readShort();
                     var6 = Client.secretPacketBuffer2.readUnsignedShort();
                     var7 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var31 = Client.secretPacketBuffer2.readUnsignedByte() * 4;
                     var9 = Client.secretPacketBuffer2.readUnsignedShort();
                     var10 = Client.secretPacketBuffer2.readUnsignedShort();
                     var11 = Client.secretPacketBuffer2.readUnsignedByte();
                     var12 = Client.secretPacketBuffer2.readUnsignedByte();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                        var1 = var1 * 128 + 64;
                        var2 = var2 * 128 + 64;
                        var3 = var3 * 128 + 64;
                        var4 = var4 * 128 + 64;
                        Projectile var13 = new Projectile(var6, class8.plane, var1, var2, class18.getTileHeight(var1, var2, class8.plane) - var7, var9 + Client.gameCycle, var10 + Client.gameCycle, var11, var12, var5, var31);
                        var13.method1765(var3, var4, class18.getTileHeight(var3, var4, class8.plane) - var31, var9 + Client.gameCycle);
                        Client.projectiles.addFront(var13);
                     }

                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "82"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class8.plane][var0][var1];
      if(var2 == null) {
         class51.region.method2814(class8.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
            ItemComposition var7 = Friend.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(var6.quantity + 1);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(var5 == null) {
            class51.region.method2814(class8.plane, var0, var1);
         } else {
            var2.addTail(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.getFront(); var6 != null; var6 = (Item)var2.getNext()) {
               if(var6.id != var5.id) {
                  if(var11 == null) {
                     var11 = var6;
                  }

                  if(var6.id != var11.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = var0 + (var1 << 7) + 1610612736;
            class51.region.addItemPile(class8.plane, var0, var1, class18.getTileHeight(var0 * 128 + 64, var1 * 128 + 64, class8.plane), var5, var9, var11, var10);
         }
      }
   }
}
