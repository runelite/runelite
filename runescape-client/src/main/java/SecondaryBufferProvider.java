import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("h")
   ImageConsumer field1430;
   @ObfuscatedName("i")
   ColorModel field1431;
   @ObfuscatedName("t")
   static int[] field1434;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "99"
   )
   final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[var1 * var2 + 1];
      this.field1431 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method1673();
      var3.prepareImage(super.image, this);
      this.method1673();
      var3.prepareImage(super.image, this);
      this.method1673();
      var3.prepareImage(super.image, this);
      this.method1734();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "-117"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method1673();
      var1.drawImage(super.image, var2, var3, this);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1430 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1431);
      var1.setHints(14);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-949670356"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1644(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field1430) {
         this.field1430 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-33"
   )
   synchronized void method1644(int var1, int var2, int var3, int var4) {
      if(this.field1430 != null) {
         this.field1430.setPixels(var1, var2, var3, var4, this.field1431, super.pixels, var1 + var2 * super.width, super.width);
         this.field1430.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field1430;
   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "2005216276"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 23) {
         class128.region.method2006(class173.plane, var0, var1);
      }

      if(var2 == 6) {
         Client.field499 = var6;
         Client.field411 = var7;
         Client.field413 = 2;
         Client.field412 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field378.method2801(38);
         Client.field378.method2700(var3 >> 14 & 32767);
         Client.field378.method2701(var0 + class193.baseX);
         Client.field378.method2666(class140.field2165[82]?1:0);
         Client.field378.method2672(var1 + DecorativeObject.baseY);
      }

      if(var2 == 5) {
         Client.field499 = var6;
         Client.field411 = var7;
         Client.field413 = 2;
         Client.field412 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field378.method2801(212);
         Client.field378.method2672(var3 >> 14 & 32767);
         Client.field378.method2672(class193.baseX + var0);
         Client.field378.method2569(class140.field2165[82]?1:0);
         Client.field378.method2701(var1 + DecorativeObject.baseY);
      }

      NPC var8;
      if(var2 == 8) {
         var8 = Client.cachedNPCs[var3];
         if(null != var8) {
            Client.field499 = var6;
            Client.field411 = var7;
            Client.field413 = 2;
            Client.field412 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field378.method2801(101);
            Client.field378.method2529(class140.field2165[82]?1:0);
            Client.field378.method2577(var3);
            Client.field378.method2610(WidgetNode.field65);
            Client.field378.method2672(Client.field456);
         }
      }

      Player var19;
      if(var2 == 51) {
         var19 = Client.cachedPlayers[var3];
         if(var19 != null) {
            Client.field499 = var6;
            Client.field411 = var7;
            Client.field413 = 2;
            Client.field412 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field378.method2801(176);
            Client.field378.method2672(var3);
            Client.field378.method2666(class140.field2165[82]?1:0);
         }
      }

      if(var2 == 13) {
         var8 = Client.cachedNPCs[var3];
         if(var8 != null) {
            Client.field499 = var6;
            Client.field411 = var7;
            Client.field413 = 2;
            Client.field412 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field378.method2801(91);
            Client.field378.method2529(class140.field2165[82]?1:0);
            Client.field378.method2577(var3);
         }
      }

      if(var2 == 15) {
         var19 = Client.cachedPlayers[var3];
         if(null != var19) {
            Client.field499 = var6;
            Client.field411 = var7;
            Client.field413 = 2;
            Client.field412 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field378.method2801(172);
            Client.field378.method2731(WidgetNode.field65);
            Client.field378.method2568(class140.field2165[82]?1:0);
            Client.field378.method2577(var3);
            Client.field378.method2700(Client.field456);
         }
      }

      Widget var20;
      if(var2 == 58) {
         var20 = class136.method2889(var1, var0);
         if(null != var20) {
            Client.field378.method2801(153);
            Client.field378.method2610(WidgetNode.field65);
            Client.field378.method2577(Client.field456);
            Client.field378.method2701(Client.field457);
            Client.field378.method2577(var0);
            Client.field378.method2610(var1);
            Client.field378.method2672(var20.item);
         }
      }

      if(var2 == 49) {
         var19 = Client.cachedPlayers[var3];
         if(var19 != null) {
            Client.field499 = var6;
            Client.field411 = var7;
            Client.field413 = 2;
            Client.field412 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field378.method2801(94);
            Client.field378.method2672(var3);
            Client.field378.method2569(class140.field2165[82]?1:0);
         }
      }

      if(var2 == 36) {
         Client.field378.method2801(214);
         Client.field378.method2700(var0);
         Client.field378.method2672(var3);
         Client.field378.method2709(var1);
         Client.field414 = 0;
         Actor.field895 = class173.method3412(var1);
         Client.field415 = var0;
      }

      if(var2 == 10) {
         var8 = Client.cachedNPCs[var3];
         if(var8 != null) {
            Client.field499 = var6;
            Client.field411 = var7;
            Client.field413 = 2;
            Client.field412 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field378.method2801(200);
            Client.field378.method2700(var3);
            Client.field378.method2568(class140.field2165[82]?1:0);
         }
      }

      if(var2 == 1001) {
         Client.field499 = var6;
         Client.field411 = var7;
         Client.field413 = 2;
         Client.field412 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field378.method2801(84);
         Client.field378.method2569(class140.field2165[82]?1:0);
         Client.field378.method2672(var1 + DecorativeObject.baseY);
         Client.field378.method2577(var0 + class193.baseX);
         Client.field378.method2577(var3 >> 14 & 32767);
      }

      if(var2 == 31) {
         Client.field378.method2801(88);
         Client.field378.method2656(var1);
         Client.field378.method2577(var0);
         Client.field378.method2577(class24.field641);
         Client.field378.method2577(var3);
         Client.field378.method2731(RSCanvas.field2197);
         Client.field378.method2672(class5.field96);
         Client.field414 = 0;
         Actor.field895 = class173.method3412(var1);
         Client.field415 = var0;
      }

      if(var2 == 16) {
         Client.field499 = var6;
         Client.field411 = var7;
         Client.field413 = 2;
         Client.field412 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field378.method2801(68);
         Client.field378.method2672(var3);
         Client.field378.method2701(var0 + class193.baseX);
         Client.field378.method2577(class5.field96);
         Client.field378.method2709(RSCanvas.field2197);
         Client.field378.method2577(class24.field641);
         Client.field378.method2672(DecorativeObject.baseY + var1);
         Client.field378.method2529(class140.field2165[82]?1:0);
      }

      if(var2 == 11) {
         var8 = Client.cachedNPCs[var3];
         if(null != var8) {
            Client.field499 = var6;
            Client.field411 = var7;
            Client.field413 = 2;
            Client.field412 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field378.method2801(140);
            Client.field378.method2529(class140.field2165[82]?1:0);
            Client.field378.method2672(var3);
         }
      }

      if(var2 == 19) {
         Client.field499 = var6;
         Client.field411 = var7;
         Client.field413 = 2;
         Client.field412 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field378.method2801(185);
         Client.field378.method2666(class140.field2165[82]?1:0);
         Client.field378.method2672(var3);
         Client.field378.method2700(var1 + DecorativeObject.baseY);
         Client.field378.method2577(class193.baseX + var0);
      }

      if(var2 == 24) {
         var20 = class173.method3412(var1);
         boolean var9 = true;
         if(var20.contentType > 0) {
            var9 = class137.method2908(var20);
         }

         if(var9) {
            Client.field378.method2801(25);
            Client.field378.method2709(var1);
         }
      }

      if(var2 == 2) {
         Client.field499 = var6;
         Client.field411 = var7;
         Client.field413 = 2;
         Client.field412 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field378.method2801(70);
         Client.field378.method2700(var1 + DecorativeObject.baseY);
         Client.field378.method2672(var3 >> 14 & 32767);
         Client.field378.method2672(var0 + class193.baseX);
         Client.field378.method2610(WidgetNode.field65);
         Client.field378.method2700(Client.field456);
         Client.field378.method2568(class140.field2165[82]?1:0);
      }

      if(var2 == 7) {
         var8 = Client.cachedNPCs[var3];
         if(null != var8) {
            Client.field499 = var6;
            Client.field411 = var7;
            Client.field413 = 2;
            Client.field412 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field378.method2801(209);
            Client.field378.method2700(class24.field641);
            Client.field378.method2666(class140.field2165[82]?1:0);
            Client.field378.method2672(var3);
            Client.field378.method2610(RSCanvas.field2197);
            Client.field378.method2672(class5.field96);
         }
      }

      int var21;
      if(var2 == 25) {
         var20 = class136.method2889(var1, var0);
         if(var20 != null) {
            class116.method2478();
            var21 = class144.method3020(Projectile.method96(var20));
            int var15 = var20.item;
            Widget var22 = class136.method2889(var1, var0);
            if(var22 != null && var22.field2893 != null) {
               class0 var12 = new class0();
               var12.field13 = var22;
               var12.field8 = var22.field2893;
               class12.method155(var12);
            }

            Client.field457 = var15;
            Client.field455 = true;
            WidgetNode.field65 = var1;
            Client.field456 = var0;
            class18.field285 = var21;
            class32.method673(var22);
            Client.field453 = 0;
            Client.field458 = class134.method2868(var20);
            if(null == Client.field458) {
               Client.field458 = "Null";
            }

            if(var20.field2862) {
               Client.field459 = var20.name + class137.method2909(16777215);
            } else {
               Client.field459 = class137.method2909('\uff00') + var20.field2918 + class137.method2909(16777215);
            }
         }

      } else {
         if(var2 == 1005) {
            var20 = class173.method3412(var1);
            if(null != var20 && var20.itemQuantities[var0] >= 100000) {
               class110.method2416(27, "", var20.itemQuantities[var0] + " x " + class92.getItemDefinition(var3).name);
            } else {
               Client.field378.method2801(255);
               Client.field378.method2577(var3);
            }

            Client.field414 = 0;
            Actor.field895 = class173.method3412(var1);
            Client.field415 = var0;
         }

         if(var2 == 43) {
            Client.field378.method2801(142);
            Client.field378.method2701(var3);
            Client.field378.method2672(var0);
            Client.field378.method2656(var1);
            Client.field414 = 0;
            Actor.field895 = class173.method3412(var1);
            Client.field415 = var0;
         }

         if(var2 == 35) {
            Client.field378.method2801(126);
            Client.field378.method2701(var3);
            Client.field378.method2610(var1);
            Client.field378.method2700(var0);
            Client.field414 = 0;
            Actor.field895 = class173.method3412(var1);
            Client.field415 = var0;
         }

         if(var2 == 37) {
            Client.field378.method2801(181);
            Client.field378.method2701(var0);
            Client.field378.method2656(var1);
            Client.field378.method2577(var3);
            Client.field414 = 0;
            Actor.field895 = class173.method3412(var1);
            Client.field415 = var0;
         }

         if(var2 == 45) {
            var19 = Client.cachedPlayers[var3];
            if(var19 != null) {
               Client.field499 = var6;
               Client.field411 = var7;
               Client.field413 = 2;
               Client.field412 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field378.method2801(82);
               Client.field378.method2666(class140.field2165[82]?1:0);
               Client.field378.method2700(var3);
            }
         }

         if(var2 == 26) {
            class16.method192();
         }

         if(var2 == 21) {
            Client.field499 = var6;
            Client.field411 = var7;
            Client.field413 = 2;
            Client.field412 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field378.method2801(171);
            Client.field378.method2700(var3);
            Client.field378.method2666(class140.field2165[82]?1:0);
            Client.field378.method2701(var1 + DecorativeObject.baseY);
            Client.field378.method2700(class193.baseX + var0);
         }

         if(var2 == 1004) {
            Client.field499 = var6;
            Client.field411 = var7;
            Client.field413 = 2;
            Client.field412 = 0;
            Client.field378.method2801(255);
            Client.field378.method2577(var3);
         }

         if(var2 == 38) {
            class116.method2478();
            var20 = class173.method3412(var1);
            Client.field453 = 1;
            class24.field641 = var0;
            RSCanvas.field2197 = var1;
            class5.field96 = var3;
            class32.method673(var20);
            Client.field312 = class137.method2909(16748608) + class92.getItemDefinition(var3).name + class137.method2909(16777215);
            if(Client.field312 == null) {
               Client.field312 = "null";
            }

         } else {
            if(var2 == 33) {
               Client.field378.method2801(95);
               Client.field378.method2672(var0);
               Client.field378.method2610(var1);
               Client.field378.method2701(var3);
               Client.field414 = 0;
               Actor.field895 = class173.method3412(var1);
               Client.field415 = var0;
            }

            if(var2 == 48) {
               var19 = Client.cachedPlayers[var3];
               if(null != var19) {
                  Client.field499 = var6;
                  Client.field411 = var7;
                  Client.field413 = 2;
                  Client.field412 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field378.method2801(226);
                  Client.field378.method2701(var3);
                  Client.field378.method2569(class140.field2165[82]?1:0);
               }
            }

            if(var2 == 47) {
               var19 = Client.cachedPlayers[var3];
               if(null != var19) {
                  Client.field499 = var6;
                  Client.field411 = var7;
                  Client.field413 = 2;
                  Client.field412 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field378.method2801(92);
                  Client.field378.method2700(var3);
                  Client.field378.method2569(class140.field2165[82]?1:0);
               }
            }

            if(var2 == 22) {
               Client.field499 = var6;
               Client.field411 = var7;
               Client.field413 = 2;
               Client.field412 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field378.method2801(108);
               Client.field378.method2700(DecorativeObject.baseY + var1);
               Client.field378.method2577(var0 + class193.baseX);
               Client.field378.method2569(class140.field2165[82]?1:0);
               Client.field378.method2672(var3);
            }

            if(var2 == 1) {
               Client.field499 = var6;
               Client.field411 = var7;
               Client.field413 = 2;
               Client.field412 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field378.method2801(236);
               Client.field378.method2656(RSCanvas.field2197);
               Client.field378.method2672(DecorativeObject.baseY + var1);
               Client.field378.method2700(var3 >> 14 & 32767);
               Client.field378.method2701(class24.field641);
               Client.field378.method2672(class5.field96);
               Client.field378.method2701(class193.baseX + var0);
               Client.field378.method2569(class140.field2165[82]?1:0);
            }

            if(var2 == 28) {
               Client.field378.method2801(25);
               Client.field378.method2709(var1);
               var20 = class173.method3412(var1);
               if(var20.dynamicValues != null && var20.dynamicValues[0][0] == 5) {
                  var21 = var20.dynamicValues[0][1];
                  class179.widgetSettings[var21] = 1 - class179.widgetSettings[var21];
                  RSCanvas.method2982(var21);
               }
            }

            if(var2 == 42) {
               Client.field378.method2801(143);
               Client.field378.method2700(var0);
               Client.field378.method2709(var1);
               Client.field378.method2577(var3);
               Client.field414 = 0;
               Actor.field895 = class173.method3412(var1);
               Client.field415 = var0;
            }

            if(var2 == 9) {
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  Client.field499 = var6;
                  Client.field411 = var7;
                  Client.field413 = 2;
                  Client.field412 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field378.method2801(128);
                  Client.field378.method2666(class140.field2165[82]?1:0);
                  Client.field378.method2700(var3);
               }
            }

            if(var2 == 20) {
               Client.field499 = var6;
               Client.field411 = var7;
               Client.field413 = 2;
               Client.field412 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field378.method2801(100);
               Client.field378.method2569(class140.field2165[82]?1:0);
               Client.field378.method2701(var3);
               Client.field378.method2700(class193.baseX + var0);
               Client.field378.method2700(DecorativeObject.baseY + var1);
            }

            if(var2 == 44) {
               var19 = Client.cachedPlayers[var3];
               if(null != var19) {
                  Client.field499 = var6;
                  Client.field411 = var7;
                  Client.field413 = 2;
                  Client.field412 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field378.method2801(58);
                  Client.field378.method2701(var3);
                  Client.field378.method2666(class140.field2165[82]?1:0);
               }
            }

            if(var2 == 57 || var2 == 1007) {
               var20 = class136.method2889(var1, var0);
               if(null != var20) {
                  var21 = var20.item;
                  Widget var10 = class136.method2889(var1, var0);
                  if(var10 != null) {
                     if(var10.field2902 != null) {
                        class0 var11 = new class0();
                        var11.field13 = var10;
                        var11.field9 = var3;
                        var11.field0 = var5;
                        var11.field8 = var10.field2902;
                        class12.method155(var11);
                     }

                     boolean var16 = true;
                     if(var10.contentType > 0) {
                        var16 = class137.method2908(var10);
                     }

                     if(var16) {
                        int var13 = Projectile.method96(var10);
                        int var14 = var3 - 1;
                        boolean var17 = (var13 >> 1 + var14 & 1) != 0;
                        if(var17) {
                           if(var3 == 1) {
                              Client.field378.method2801(164);
                              Client.field378.method2709(var1);
                              Client.field378.method2701(var0);
                              Client.field378.method2701(var21);
                           }

                           if(var3 == 2) {
                              Client.field378.method2801(231);
                              Client.field378.method2709(var1);
                              Client.field378.method2701(var0);
                              Client.field378.method2701(var21);
                           }

                           if(var3 == 3) {
                              Client.field378.method2801(207);
                              Client.field378.method2709(var1);
                              Client.field378.method2701(var0);
                              Client.field378.method2701(var21);
                           }

                           if(var3 == 4) {
                              Client.field378.method2801(225);
                              Client.field378.method2709(var1);
                              Client.field378.method2701(var0);
                              Client.field378.method2701(var21);
                           }

                           if(var3 == 5) {
                              Client.field378.method2801(78);
                              Client.field378.method2709(var1);
                              Client.field378.method2701(var0);
                              Client.field378.method2701(var21);
                           }

                           if(var3 == 6) {
                              Client.field378.method2801(134);
                              Client.field378.method2709(var1);
                              Client.field378.method2701(var0);
                              Client.field378.method2701(var21);
                           }

                           if(var3 == 7) {
                              Client.field378.method2801(61);
                              Client.field378.method2709(var1);
                              Client.field378.method2701(var0);
                              Client.field378.method2701(var21);
                           }

                           if(var3 == 8) {
                              Client.field378.method2801(241);
                              Client.field378.method2709(var1);
                              Client.field378.method2701(var0);
                              Client.field378.method2701(var21);
                           }

                           if(var3 == 9) {
                              Client.field378.method2801(30);
                              Client.field378.method2709(var1);
                              Client.field378.method2701(var0);
                              Client.field378.method2701(var21);
                           }

                           if(var3 == 10) {
                              Client.field378.method2801(131);
                              Client.field378.method2709(var1);
                              Client.field378.method2701(var0);
                              Client.field378.method2701(var21);
                           }
                        }
                     }
                  }
               }
            }

            if(var2 == 41) {
               Client.field378.method2801(115);
               Client.field378.method2701(var3);
               Client.field378.method2672(var0);
               Client.field378.method2731(var1);
               Client.field414 = 0;
               Actor.field895 = class173.method3412(var1);
               Client.field415 = var0;
            }

            if(var2 == 17) {
               Client.field499 = var6;
               Client.field411 = var7;
               Client.field413 = 2;
               Client.field412 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field378.method2801(102);
               Client.field378.method2701(Client.field456);
               Client.field378.method2701(var1 + DecorativeObject.baseY);
               Client.field378.method2577(class193.baseX + var0);
               Client.field378.method2731(WidgetNode.field65);
               Client.field378.method2577(var3);
               Client.field378.method2568(class140.field2165[82]?1:0);
            }

            if(var2 == 1003) {
               Client.field499 = var6;
               Client.field411 = var7;
               Client.field413 = 2;
               Client.field412 = 0;
               var8 = Client.cachedNPCs[var3];
               if(var8 != null) {
                  NPCComposition var18 = var8.composition;
                  if(null != var18.field938) {
                     var18 = var18.method813();
                  }

                  if(null != var18) {
                     Client.field378.method2801(244);
                     Client.field378.method2700(var18.id);
                  }
               }
            }

            if(var2 == 4) {
               Client.field499 = var6;
               Client.field411 = var7;
               Client.field413 = 2;
               Client.field412 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field378.method2801(80);
               Client.field378.method2700(var3 >> 14 & 32767);
               Client.field378.method2577(var1 + DecorativeObject.baseY);
               Client.field378.method2672(var0 + class193.baseX);
               Client.field378.method2666(class140.field2165[82]?1:0);
            }

            if(var2 == 30 && null == Client.field464) {
               class151.method3162(var1, var0);
               Client.field464 = class136.method2889(var1, var0);
               class32.method673(Client.field464);
            }

            if(var2 == 32) {
               Client.field378.method2801(29);
               Client.field378.method2701(var3);
               Client.field378.method2709(var1);
               Client.field378.method2577(var0);
               Client.field378.method2700(Client.field456);
               Client.field378.method2731(WidgetNode.field65);
               Client.field414 = 0;
               Actor.field895 = class173.method3412(var1);
               Client.field415 = var0;
            }

            if(var2 == 29) {
               Client.field378.method2801(25);
               Client.field378.method2709(var1);
               var20 = class173.method3412(var1);
               if(var20.dynamicValues != null && var20.dynamicValues[0][0] == 5) {
                  var21 = var20.dynamicValues[0][1];
                  if(var20.field2916[0] != class179.widgetSettings[var21]) {
                     class179.widgetSettings[var21] = var20.field2916[0];
                     RSCanvas.method2982(var21);
                  }
               }
            }

            if(var2 == 50) {
               var19 = Client.cachedPlayers[var3];
               if(null != var19) {
                  Client.field499 = var6;
                  Client.field411 = var7;
                  Client.field413 = 2;
                  Client.field412 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field378.method2801(127);
                  Client.field378.method2529(class140.field2165[82]?1:0);
                  Client.field378.method2672(var3);
               }
            }

            if(var2 == 46) {
               var19 = Client.cachedPlayers[var3];
               if(var19 != null) {
                  Client.field499 = var6;
                  Client.field411 = var7;
                  Client.field413 = 2;
                  Client.field412 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field378.method2801(26);
                  Client.field378.method2700(var3);
                  Client.field378.method2666(class140.field2165[82]?1:0);
               }
            }

            if(var2 == 34) {
               Client.field378.method2801(103);
               Client.field378.method2577(var3);
               Client.field378.method2577(var0);
               Client.field378.method2709(var1);
               Client.field414 = 0;
               Actor.field895 = class173.method3412(var1);
               Client.field415 = var0;
            }

            if(var2 == 40) {
               Client.field378.method2801(132);
               Client.field378.method2731(var1);
               Client.field378.method2577(var0);
               Client.field378.method2577(var3);
               Client.field414 = 0;
               Actor.field895 = class173.method3412(var1);
               Client.field415 = var0;
            }

            if(var2 == 39) {
               Client.field378.method2801(0);
               Client.field378.method2672(var0);
               Client.field378.method2610(var1);
               Client.field378.method2701(var3);
               Client.field414 = 0;
               Actor.field895 = class173.method3412(var1);
               Client.field415 = var0;
            }

            if(var2 == 1002) {
               Client.field499 = var6;
               Client.field411 = var7;
               Client.field413 = 2;
               Client.field412 = 0;
               Client.field378.method2801(144);
               Client.field378.method2701(var3 >> 14 & 32767);
            }

            if(var2 == 12) {
               var8 = Client.cachedNPCs[var3];
               if(null != var8) {
                  Client.field499 = var6;
                  Client.field411 = var7;
                  Client.field413 = 2;
                  Client.field412 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field378.method2801(20);
                  Client.field378.method2569(class140.field2165[82]?1:0);
                  Client.field378.method2700(var3);
               }
            }

            if(var2 == 18) {
               Client.field499 = var6;
               Client.field411 = var7;
               Client.field413 = 2;
               Client.field412 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field378.method2801(86);
               Client.field378.method2701(DecorativeObject.baseY + var1);
               Client.field378.method2701(var3);
               Client.field378.method2568(class140.field2165[82]?1:0);
               Client.field378.method2700(var0 + class193.baseX);
            }

            if(var2 == 3) {
               Client.field499 = var6;
               Client.field411 = var7;
               Client.field413 = 2;
               Client.field412 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field378.method2801(149);
               Client.field378.method2701(var1 + DecorativeObject.baseY);
               Client.field378.method2569(class140.field2165[82]?1:0);
               Client.field378.method2700(var3 >> 14 & 32767);
               Client.field378.method2577(class193.baseX + var0);
            }

            if(var2 == 14) {
               var19 = Client.cachedPlayers[var3];
               if(var19 != null) {
                  Client.field499 = var6;
                  Client.field411 = var7;
                  Client.field413 = 2;
                  Client.field412 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field378.method2801(42);
                  Client.field378.method2568(class140.field2165[82]?1:0);
                  Client.field378.method2709(RSCanvas.field2197);
                  Client.field378.method2672(class5.field96);
                  Client.field378.method2577(class24.field641);
                  Client.field378.method2701(var3);
               }
            }

            if(Client.field453 != 0) {
               Client.field453 = 0;
               class32.method673(class173.method3412(RSCanvas.field2197));
            }

            if(Client.field455) {
               class116.method2478();
            }

            if(null != Actor.field895 && Client.field414 == 0) {
               class32.method673(Actor.field895);
            }

         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1563845306"
   )
   synchronized void method1673() {
      if(null != this.field1430) {
         this.field1430.setPixels(0, 0, super.width, super.height, this.field1431, super.pixels, 0, super.width);
         this.field1430.imageComplete(2);
      }
   }
}
