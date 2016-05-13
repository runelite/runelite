import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("bl")
@Implements("SecondaryBufferProvider")
public final class class75 extends class77 implements ImageProducer, ImageObserver {
   @ObfuscatedName("lk")
   static class130 field1377;
   @ObfuscatedName("j")
   ImageConsumer field1378;
   @ObfuscatedName("s")
   ColorModel field1380;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "0"
   )
   final void vmethod1852(int var1, int var2, Component var3) {
      super.field1397 = var1;
      super.field1398 = var2;
      super.field1401 = new int[var1 * var2 + 1];
      this.field1380 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1400 = var3.createImage(this);
      this.method1593();
      var3.prepareImage(super.field1400, this);
      this.method1593();
      var3.prepareImage(super.field1400, this);
      this.method1593();
      var3.prepareImage(super.field1400, this);
      this.method1646();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "0"
   )
   @Export("draw")
   public final void vmethod1857(Graphics var1, int var2, int var3) {
      this.method1593();
      var1.drawImage(super.field1400, var2, var3, this);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIS)V",
      garbageValue = "128"
   )
   @Export("drawSub")
   public final void vmethod1858(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1598(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1400, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1378 = var1;
      var1.setDimensions(super.field1397, super.field1398);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1380);
      var1.setHints(14);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field1378 == var1;
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field1378 == var1) {
         this.field1378 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-8"
   )
   static final boolean method1591() {
      if(class167.field2697 == null) {
         return false;
      } else {
         String var0;
         int var1;
         try {
            int var2 = class167.field2697.method2962();
            if(0 == var2) {
               return false;
            }

            if(client.field326 == -1) {
               class167.field2697.method2961(client.field324.field2007, 0, 1);
               client.field324.field2005 = 0;
               client.field326 = client.field324.method2738();
               client.field325 = class188.field3063[client.field326];
               --var2;
            }

            if(-1 == client.field325) {
               if(var2 <= 0) {
                  return false;
               }

               class167.field2697.method2961(client.field324.field2007, 0, 1);
               client.field325 = client.field324.field2007[0] & 255;
               --var2;
            }

            if(-2 == client.field325) {
               if(var2 <= 1) {
                  return false;
               }

               class167.field2697.method2961(client.field324.field2007, 0, 2);
               client.field324.field2005 = 0;
               client.field325 = client.field324.method2584();
               var2 -= 2;
            }

            if(var2 < client.field325) {
               return false;
            }

            client.field324.field2005 = 0;
            class167.field2697.method2961(client.field324.field2007, 0, client.field325);
            client.field510 = 0;
            client.field331 = client.field330;
            client.field330 = client.field329 * -1;
            client.field329 = client.field326 * -1;
            if(178 == client.field326) {
               client.field495 = client.field324.method2492();
               client.field292 = client.field324.method2492();
               client.field326 = -1;
               return true;
            }

            int var3;
            int var4;
            int var5;
            int var6;
            int var7;
            int var8;
            if(client.field326 == 40) {
               client.field558 = true;
               class47.field1072 = client.field324.method2492();
               class95.field1634 = client.field324.method2492();
               class76.field1391 = client.field324.method2584();
               class103.field1779 = client.field324.method2492();
               class56.field1202 = client.field324.method2492();
               if(class56.field1202 >= 100) {
                  var6 = 64 + class47.field1072 * 128;
                  var1 = class95.field1634 * 128 + 64;
                  var7 = class107.method2369(var6, var1, class21.field581) - class76.field1391;
                  var3 = var6 - class77.field1404;
                  var4 = var7 - class7.field138;
                  var5 = var1 - class72.field1353;
                  var8 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
                  class59.field1222 = (int)(Math.atan2((double)var4, (double)var8) * 325.949D) & 2047;
                  class32.field750 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
                  if(class59.field1222 < 128) {
                     class59.field1222 = 128;
                  }

                  if(class59.field1222 > 383) {
                     class59.field1222 = 383;
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 90) {
               class104.method2280(true);
               client.field326 = -1;
               return true;
            }

            class173 var9;
            if(client.field326 == 172) {
               var6 = client.field324.method2529();
               var1 = client.field324.method2534();
               var7 = client.field324.method2495();
               var9 = class29.method645(var1);
               if(var7 != var9.field2774 || var9.field2775 != var6 || var9.field2770 != 0 || 0 != var9.field2810) {
                  var9.field2774 = var7;
                  var9.field2775 = var6;
                  var9.field2770 = 0;
                  var9.field2810 = 0;
                  class34.method701(var9);
                  class87.method2063(var9);
                  if(var9.field2767 == 0) {
                     class125.method2796(class217.field3171[var1 >> 16], var9, false);
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 246) {
               var6 = client.field324.method2497();
               class3 var57 = (class3)client.field308.method3777((long)var6);
               if(var57 != null) {
                  class38.method737(var57, true);
               }

               if(null != client.field441) {
                  class34.method701(client.field441);
                  client.field441 = null;
               }

               client.field326 = -1;
               return true;
            }

            if(71 == client.field326) {
               var6 = client.field324.method2492();
               var1 = client.field324.method2492();
               var7 = client.field324.method2492();
               var3 = client.field324.method2492();
               client.field528[var6] = true;
               client.field529[var6] = var1;
               client.field423[var6] = var7;
               client.field337[var6] = var3;
               client.field532[var6] = 0;
               client.field326 = -1;
               return true;
            }

            if(3 == client.field326) {
               for(var6 = 0; var6 < class126.field2053; ++var6) {
                  class52 var56 = class3.method38(var6);
                  if(null != var56) {
                     class176.field2918[var6] = 0;
                     class176.field2920[var6] = 0;
                  }
               }

               class8.method112();
               client.field464 += 32;
               client.field326 = -1;
               return true;
            }

            if(99 == client.field326) {
               class8.method112();
               var6 = client.field324.method2492();
               var1 = client.field324.method2613();
               var7 = client.field324.method2536();
               client.field427[var6] = var7;
               client.field399[var6] = var1;
               client.field415[var6] = 1;

               for(var3 = 0; var3 < 98; ++var3) {
                  if(var7 >= class155.field2301[var3]) {
                     client.field415[var6] = var3 + 2;
                  }
               }

               client.field467[++client.field468 - 1 & 31] = var6;
               client.field326 = -1;
               return true;
            }

            if(203 == client.field326) {
               var6 = client.field324.method2526();
               client.field412 = var6;
               class9.method125(false);
               class156.method3148(var6);
               class16.method198(client.field412);

               for(var1 = 0; var1 < 100; ++var1) {
                  client.field482[var1] = true;
               }

               client.field326 = -1;
               return true;
            }

            if(85 == client.field326) {
               class104.method2280(false);
               client.field326 = -1;
               return true;
            }

            if(12 == client.field326) {
               class134.field2089 = client.field324.method2520();
               class45.field1046 = client.field324.method2520();

               for(var6 = class134.field2089; var6 < class134.field2089 + 8; ++var6) {
                  for(var1 = class45.field1046; var1 < class45.field1046 + 8; ++var1) {
                     if(null != client.field345[class21.field581][var6][var1]) {
                        client.field345[class21.field581][var6][var1] = null;
                        class12.method161(var6, var1);
                     }
                  }
               }

               for(class16 var55 = (class16)client.field411.method3812(); null != var55; var55 = (class16)client.field411.method3817()) {
                  if(var55.field221 >= class134.field2089 && var55.field221 < class134.field2089 + 8 && var55.field232 >= class45.field1046 && var55.field232 < class45.field1046 + 8 && class21.field581 == var55.field227) {
                     var55.field230 = 0;
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(143 == client.field326) {
               class15.method194(client.field324, client.field325);
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 128) {
               client.field558 = true;
               class150.field2258 = client.field324.method2492();
               class17.field241 = client.field324.method2492();
               class1.field28 = client.field324.method2584();
               class119.field2006 = client.field324.method2492();
               class49.field1092 = client.field324.method2492();
               if(class49.field1092 >= 100) {
                  class77.field1404 = 64 + class150.field2258 * 128;
                  class72.field1353 = 64 + class17.field241 * 128;
                  class7.field138 = class107.method2369(class77.field1404, class72.field1353, class21.field581) - class1.field28;
               }

               client.field326 = -1;
               return true;
            }

            long var10;
            if(191 == client.field326) {
               var6 = client.field324.method2534();
               var1 = client.field324.method2535();
               var7 = client.field324.method2584();
               if(var7 == '\uffff') {
                  var7 = -1;
               }

               var3 = client.field324.method2584();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               for(var4 = var7; var4 <= var3; ++var4) {
                  var10 = (long)var4 + ((long)var6 << 32);
                  class208 var64 = client.field479.method3777(var10);
                  if(null != var64) {
                     var64.method3898();
                  }

                  client.field479.method3778(new class201(var1), var10);
               }

               client.field326 = -1;
               return true;
            }

            if(76 == client.field326) {
               var6 = client.field324.method2497();
               var1 = client.field324.method2497();
               if(class56.field1203 == null || !class56.field1203.isValid()) {
                  try {
                     Iterator var62 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var62.hasNext()) {
                        GarbageCollectorMXBean var58 = (GarbageCollectorMXBean)var62.next();
                        if(var58.isValid()) {
                           class56.field1203 = var58;
                           client.field557 = -1L;
                           client.field556 = -1L;
                        }
                     }
                  } catch (Throwable var52) {
                     ;
                  }
               }

               long var63 = class12.method162();
               var4 = -1;
               if(class56.field1203 != null) {
                  var10 = class56.field1203.getCollectionTime();
                  if(-1L != client.field556) {
                     long var61 = var10 - client.field556;
                     long var65 = var63 - client.field557;
                     if(0L != var65) {
                        var4 = (int)(var61 * 100L / var65);
                     }
                  }

                  client.field556 = var10;
                  client.field557 = var63;
               }

               client.field322.method2737(125);
               client.field322.method2531(var6);
               client.field322.method2587(var1);
               client.field322.method2681(class144.field2207);
               client.field322.method2681(var4);
               client.field326 = -1;
               return true;
            }

            class173 var12;
            if(232 == client.field326) {
               var6 = client.field324.method2536();
               var1 = client.field324.method2529();
               var12 = class29.method645(var6);
               if(var12.field2812 != var1 || -1 == var1) {
                  var12.field2812 = var1;
                  var12.field2834 = 0;
                  var12.field2754 = 0;
                  class34.method701(var12);
               }

               client.field326 = -1;
               return true;
            }

            class3 var13;
            if(112 == client.field326) {
               var6 = client.field324.method2584();
               var1 = client.field324.method2492();
               var7 = client.field324.method2536();
               var13 = (class3)client.field308.method3777((long)var7);
               if(var13 != null) {
                  class38.method737(var13, var6 != var13.field69);
               }

               class9.method118(var7, var6, var1);
               client.field326 = -1;
               return true;
            }

            if(6 == client.field326) {
               class8.method112();
               client.field301 = client.field324.method2492();
               client.field474 = client.field462;
               client.field326 = -1;
               return true;
            }

            if(223 == client.field326 || client.field326 == 54 || client.field326 == 83 || client.field326 == 239 || client.field326 == 140 || client.field326 == 97 || client.field326 == 199 || client.field326 == 78 || client.field326 == 18 || 49 == client.field326) {
               class103.method2276();
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 119) {
               for(var6 = 0; var6 < client.field491.length; ++var6) {
                  if(null != client.field491[var6]) {
                     client.field491[var6].field843 = -1;
                  }
               }

               for(var6 = 0; var6 < client.field515.length; ++var6) {
                  if(client.field515[var6] != null) {
                     client.field515[var6].field843 = -1;
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 170) {
               class25 var60 = new class25();
               var60.field635 = client.field324.method2500();
               var60.field632 = client.field324.method2584();
               var1 = client.field324.method2497();
               var60.field633 = var1;
               class15.method188(45);
               class167.field2697.method2960();
               class167.field2697 = null;
               class90.method2068(var60);
               client.field326 = -1;
               return false;
            }

            if(144 == client.field326) {
               var6 = client.field324.method2497();
               var1 = client.field324.method2584();
               if(var6 < -70000) {
                  var1 += '耀';
               }

               if(var6 >= 0) {
                  var12 = class29.method645(var6);
               } else {
                  var12 = null;
               }

               if(null != var12) {
                  for(var3 = 0; var3 < var12.field2883.length; ++var3) {
                     var12.field2883[var3] = 0;
                     var12.field2884[var3] = 0;
                  }
               }

               class15 var59 = (class15)class15.field204.method3777((long)var1);
               if(var59 != null) {
                  for(var4 = 0; var4 < var59.field210.length; ++var4) {
                     var59.field210[var4] = -1;
                     var59.field206[var4] = 0;
                  }
               }

               var3 = client.field324.method2584();

               for(var4 = 0; var4 < var3; ++var4) {
                  var5 = client.field324.method2584();
                  var8 = client.field324.method2492();
                  if(255 == var8) {
                     var8 = client.field324.method2497();
                  }

                  if(null != var12 && var4 < var12.field2883.length) {
                     var12.field2883[var4] = var5;
                     var12.field2884[var4] = var8;
                  }

                  class51.method1047(var1, var4, var5 - 1, var8);
               }

               if(var12 != null) {
                  class34.method701(var12);
               }

               class8.method112();
               client.field465[++client.field446 - 1 & 31] = var1 & 32767;
               client.field326 = -1;
               return true;
            }

            if(116 == client.field326) {
               var6 = client.field324.method2534();
               class114.field1975 = class38.field878.method2866(var6);
               client.field326 = -1;
               return true;
            }

            if(187 == client.field326) {
               var6 = client.field324.method2535();
               var1 = client.field324.method2527();
               class176.field2918[var1] = var6;
               if(var6 != class176.field2920[var1]) {
                  class176.field2920[var1] = var6;
               }

               class52.method1069(var1);
               client.field463[++client.field464 - 1 & 31] = var1;
               client.field326 = -1;
               return true;
            }

            if(66 == client.field326) {
               class14.method172();
               client.field326 = -1;
               return false;
            }

            if(138 == client.field326) {
               client.field476 = client.field324.method2492();
               if(1 == client.field476) {
                  client.field297 = client.field324.method2584();
               }

               if(client.field476 >= 2 && client.field476 <= 6) {
                  if(client.field476 == 2) {
                     client.field302 = 64;
                     client.field303 = 64;
                  }

                  if(client.field476 == 3) {
                     client.field302 = 0;
                     client.field303 = 64;
                  }

                  if(4 == client.field476) {
                     client.field302 = 128;
                     client.field303 = 64;
                  }

                  if(client.field476 == 5) {
                     client.field302 = 64;
                     client.field303 = 0;
                  }

                  if(6 == client.field476) {
                     client.field302 = 64;
                     client.field303 = 128;
                  }

                  client.field476 = 2;
                  client.field299 = client.field324.method2584();
                  client.field543 = client.field324.method2584();
                  client.field547 = client.field324.method2492();
               }

               if(client.field476 == 10) {
                  client.field298 = client.field324.method2584();
               }

               client.field326 = -1;
               return true;
            }

            String var14;
            if(client.field326 == 213) {
               var0 = client.field324.method2500();
               var14 = class223.method4001(class34.method711(class152.method3131(client.field324)));
               class125.method2783(6, var0, var14);
               client.field326 = -1;
               return true;
            }

            boolean var15;
            if(95 == client.field326) {
               var15 = client.field324.method2492() == 1;
               if(var15) {
                  class3.field66 = class12.method162() - client.field324.method2498();
                  class37.field871 = new class221(client.field324, true);
               } else {
                  class37.field871 = null;
               }

               client.field563 = client.field462;
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 35) {
               var6 = client.field324.method2526();
               var1 = client.field324.method2534();
               var12 = class29.method645(var1);
               if(var12.field2788 != 2 || var12.field2830 != var6) {
                  var12.field2788 = 2;
                  var12.field2830 = var6;
                  class34.method701(var12);
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 240) {
               client.field558 = false;

               for(var6 = 0; var6 < 5; ++var6) {
                  client.field528[var6] = false;
               }

               client.field326 = -1;
               return true;
            }

            int var16;
            class122 var17;
            int var18;
            String var19;
            int var20;
            String var21;
            int var22;
            int var35;
            if(client.field326 == 207) {
               var17 = client.field324;
               var1 = client.field325;
               class210 var66 = new class210();
               var66.field3140 = var17.method2492();
               var66.field3136 = var17.method2497();
               var66.field3134 = new int[var66.field3140];
               var66.field3135 = new int[var66.field3140];
               var66.field3133 = new Field[var66.field3140];
               var66.field3137 = new int[var66.field3140];
               var66.field3138 = new Method[var66.field3140];
               var66.field3139 = new byte[var66.field3140][][];

               for(var3 = 0; var3 < var66.field3140; ++var3) {
                  try {
                     var4 = var17.method2492();
                     String var69;
                     if(var4 != 0 && var4 != 1 && var4 != 2) {
                        if(var4 == 3 || var4 == 4) {
                           var19 = var17.method2500();
                           var69 = var17.method2500();
                           var18 = var17.method2492();
                           String[] var67 = new String[var18];

                           for(var20 = 0; var20 < var18; ++var20) {
                              var67[var20] = var17.method2500();
                           }

                           var21 = var17.method2500();
                           byte[][] var26 = new byte[var18][];
                           if(3 == var4) {
                              for(var22 = 0; var22 < var18; ++var22) {
                                 var16 = var17.method2497();
                                 var26[var22] = new byte[var16];
                                 var17.method2503(var26[var22], 0, var16);
                              }
                           }

                           var66.field3134[var3] = var4;
                           Class[] var70 = new Class[var18];

                           for(var16 = 0; var16 < var18; ++var16) {
                              var70[var16] = class179.method3473(var67[var16]);
                           }

                           Class var28 = class179.method3473(var21);
                           if(class179.method3473(var19).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var71 = class179.method3473(var19).getDeclaredMethods();
                           Method[] var30 = var71;

                           for(int var73 = 0; var73 < var30.length; ++var73) {
                              Method var76 = var30[var73];
                              if(var76.getName().equals(var69)) {
                                 Class[] var79 = var76.getParameterTypes();
                                 if(var79.length == var70.length) {
                                    boolean var77 = true;

                                    for(var35 = 0; var35 < var70.length; ++var35) {
                                       if(var79[var35] != var70[var35]) {
                                          var77 = false;
                                          break;
                                       }
                                    }

                                    if(var77 && var28 == var76.getReturnType()) {
                                       var66.field3138[var3] = var76;
                                    }
                                 }
                              }
                           }

                           var66.field3139[var3] = var26;
                        }
                     } else {
                        var19 = var17.method2500();
                        var69 = var17.method2500();
                        var18 = 0;
                        if(var4 == 1) {
                           var18 = var17.method2497();
                        }

                        var66.field3134[var3] = var4;
                        var66.field3137[var3] = var18;
                        if(class179.method3473(var19).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var66.field3133[var3] = class179.method3473(var19).getDeclaredField(var69);
                     }
                  } catch (ClassNotFoundException var47) {
                     var66.field3135[var3] = -1;
                  } catch (SecurityException var48) {
                     var66.field3135[var3] = -2;
                  } catch (NullPointerException var49) {
                     var66.field3135[var3] = -3;
                  } catch (Exception var50) {
                     var66.field3135[var3] = -4;
                  } catch (Throwable var51) {
                     var66.field3135[var3] = -5;
                  }
               }

               class211.field3143.method3849(var66);
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 195) {
               for(var6 = 0; var6 < class176.field2920.length; ++var6) {
                  if(class176.field2920[var6] != class176.field2918[var6]) {
                     class176.field2920[var6] = class176.field2918[var6];
                     class52.method1069(var6);
                     client.field463[++client.field464 - 1 & 31] = var6;
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 180) {
               var6 = client.field324.method2584();
               var1 = client.field324.method2492();
               var7 = client.field324.method2584();
               class153.method3134(var6, var1, var7);
               client.field326 = -1;
               return true;
            }

            class173 var23;
            if(84 == client.field326) {
               var6 = client.field324.method2536();
               var23 = class29.method645(var6);

               for(var7 = 0; var7 < var23.field2883.length; ++var7) {
                  var23.field2883[var7] = -1;
                  var23.field2883[var7] = 0;
               }

               class34.method701(var23);
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 70) {
               client.field295 = client.field324.method2527() * 30;
               client.field474 = client.field462;
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 111) {
               if(-1 != client.field412) {
                  class87.method2065(client.field412, 0);
               }

               client.field326 = -1;
               return true;
            }

            if(235 == client.field326) {
               var6 = client.field324.method2526();
               class15 var68 = (class15)class15.field204.method3777((long)var6);
               if(var68 != null) {
                  var68.method3898();
               }

               client.field465[++client.field446 - 1 & 31] = var6 & 32767;
               client.field326 = -1;
               return true;
            }

            boolean var24;
            long var25;
            long var27;
            long var29;
            if(client.field326 == 108) {
               var0 = client.field324.method2500();
               var25 = client.field324.method2498();
               var27 = (long)client.field324.method2584();
               var10 = (long)client.field324.method2513();
               class152 var72 = (class152)method1616(class115.method2441(), client.field324.method2492());
               var29 = var10 + (var27 << 32);
               var24 = false;

               for(var22 = 0; var22 < 100; ++var22) {
                  if(client.field382[var22] == var29) {
                     var24 = true;
                     break;
                  }
               }

               if(var72.field2271 && class16.method196(var0)) {
                  var24 = true;
               }

               if(!var24 && client.field358 == 0) {
                  client.field382[client.field530] = var29;
                  client.field530 = (client.field530 + 1) % 100;
                  String var75 = class223.method4001(class34.method711(class152.method3131(client.field324)));
                  if(var72.field2283 != -1) {
                     class52.method1050(9, class156.method3146(var72.field2283) + var0, var75, class34.method710(var25));
                  } else {
                     class52.method1050(9, var0, var75, class34.method710(var25));
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(105 == client.field326) {
               class45.field1046 = client.field324.method2520();
               class134.field2089 = client.field324.method2520();

               while(client.field324.field2005 < client.field325) {
                  client.field326 = client.field324.method2492();
                  class103.method2276();
               }

               client.field326 = -1;
               return true;
            }

            if(31 == client.field326) {
               class8.method112();
               client.field437 = client.field324.method2495();
               client.field474 = client.field462;
               client.field326 = -1;
               return true;
            }

            if(250 == client.field326) {
               class175.method3431(true);
               client.field324.method2738();
               var6 = client.field324.method2584();
               class15.method194(client.field324, var6);
               client.field326 = -1;
               return true;
            }

            class173 var31;
            if(client.field326 == 126) {
               var6 = client.field324.method2497();
               var1 = client.field324.method2536();
               class3 var74 = (class3)client.field308.method3777((long)var1);
               var13 = (class3)client.field308.method3777((long)var6);
               if(var13 != null) {
                  class38.method737(var13, null == var74 || var13.field69 != var74.field69);
               }

               if(null != var74) {
                  var74.method3898();
                  client.field308.method3778(var74, (long)var6);
               }

               var31 = class29.method645(var1);
               if(var31 != null) {
                  class34.method701(var31);
               }

               var31 = class29.method645(var6);
               if(var31 != null) {
                  class34.method701(var31);
                  class125.method2796(class217.field3171[var31.field2826 >>> 16], var31, true);
               }

               if(-1 != client.field412) {
                  class87.method2065(client.field412, 1);
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 163) {
               var0 = client.field324.method2500();
               var1 = client.field324.method2535();
               var12 = class29.method645(var1);
               if(!var0.equals(var12.field2825)) {
                  var12.field2825 = var0;
                  class34.method701(var12);
               }

               client.field326 = -1;
               return true;
            }

            if(177 == client.field326) {
               var6 = client.field324.method2527();
               var1 = client.field324.method2533();
               var7 = client.field324.method2534();
               var3 = client.field324.method2584();
               var31 = class29.method645(var7);
               if(var1 != var31.field2816 || var3 != var31.field2817 || var31.field2819 != var6) {
                  var31.field2816 = var1;
                  var31.field2817 = var3;
                  var31.field2819 = var6;
                  class34.method701(var31);
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 157) {
               class26.method616();

               for(var6 = 0; var6 < 2048; ++var6) {
                  client.field491[var6] = null;
               }

               class44.method907(client.field324);
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 36) {
               var6 = client.field324.method2497();
               var1 = client.field324.method2584();
               if(var6 < -70000) {
                  var1 += '耀';
               }

               if(var6 >= 0) {
                  var12 = class29.method645(var6);
               } else {
                  var12 = null;
               }

               for(; client.field324.field2005 < client.field325; class51.method1047(var1, var3, var4 - 1, var5)) {
                  var3 = client.field324.method2505();
                  var4 = client.field324.method2584();
                  var5 = 0;
                  if(var4 != 0) {
                     var5 = client.field324.method2492();
                     if(var5 == 255) {
                        var5 = client.field324.method2497();
                     }
                  }

                  if(var12 != null && var3 >= 0 && var3 < var12.field2883.length) {
                     var12.field2883[var3] = var4;
                     var12.field2884[var3] = var5;
                  }
               }

               if(null != var12) {
                  class34.method701(var12);
               }

               class8.method112();
               client.field465[++client.field446 - 1 & 31] = var1 & 32767;
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 2) {
               client.field544 = 1;
               client.field470 = client.field462;
               client.field326 = -1;
               return true;
            }

            boolean var32;
            String var33;
            String var34;
            if(client.field326 == 216) {
               while(client.field324.field2005 < client.field325) {
                  var6 = client.field324.method2492();
                  var32 = (var6 & 1) == 1;
                  var33 = client.field324.method2500();
                  var34 = client.field324.method2500();
                  client.field324.method2500();

                  class7 var78;
                  for(var4 = 0; var4 < client.field550; ++var4) {
                     var78 = client.field344[var4];
                     if(var32) {
                        if(var34.equals(var78.field133)) {
                           var78.field133 = var33;
                           var78.field135 = var34;
                           var33 = null;
                           break;
                        }
                     } else if(var33.equals(var78.field133)) {
                        var78.field133 = var33;
                        var78.field135 = var34;
                        var33 = null;
                        break;
                     }
                  }

                  if(null != var33 && client.field550 < 400) {
                     var78 = new class7();
                     client.field344[client.field550] = var78;
                     var78.field133 = var33;
                     var78.field135 = var34;
                     ++client.field550;
                  }
               }

               client.field470 = client.field462;
               client.field326 = -1;
               return true;
            }

            String var36;
            long var37;
            if(65 == client.field326) {
               var0 = client.field324.method2500();
               class10.field164 = var0;

               try {
                  var14 = client.field276.getParameter(class190.field3070.field3077);
                  var33 = client.field276.getParameter(class190.field3078.field3077);
                  var34 = var14 + "settings=" + var0 + "; version=1; path=/; domain=" + var33;
                  if(var0.length() == 0) {
                     var34 = var34 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var36 = var34 + "; Expires=";
                     var37 = class12.method162() + 94608000000L;
                     class111.field1964.setTime(new Date(var37));
                     var35 = class111.field1964.get(7);
                     var20 = class111.field1964.get(5);
                     int var96 = class111.field1964.get(2);
                     var22 = class111.field1964.get(1);
                     var16 = class111.field1964.get(11);
                     int var85 = class111.field1964.get(12);
                     int var93 = class111.field1964.get(13);
                     var19 = class111.field1963[var35 - 1] + ", " + var20 / 10 + var20 % 10 + "-" + class111.field1966[0][var96] + "-" + var22 + " " + var16 / 10 + var16 % 10 + ":" + var85 / 10 + var85 % 10 + ":" + var93 / 10 + var93 % 10 + " GMT";
                     var34 = var36 + var19 + "; Max-Age=" + 94608000L;
                  }

                  client var97 = client.field276;
                  var19 = "document.cookie=\"" + var34 + "\"";
                  JSObject.getWindow(var97).eval(var19);
               } catch (Throwable var46) {
                  ;
               }

               client.field326 = -1;
               return true;
            }

            if(168 == client.field326) {
               class175.method3431(false);
               client.field324.method2738();
               var6 = client.field324.method2584();
               class15.method194(client.field324, var6);
               client.field326 = -1;
               return true;
            }

            if(200 == client.field326) {
               var6 = client.field324.method2536();
               var1 = client.field324.method2526();
               var7 = client.field324.method2526();
               var9 = class29.method645(var6);
               var9.field2821 = (var7 << 16) + var1;
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 130) {
               var6 = client.field324.method2527();
               if('\uffff' == var6) {
                  var6 = -1;
               }

               var1 = client.field324.method2534();
               var7 = client.field324.method2536();
               var9 = class29.method645(var7);
               class51 var95;
               if(!var9.field2764) {
                  if(-1 == var6) {
                     var9.field2788 = 0;
                     client.field326 = -1;
                     return true;
                  }

                  var95 = class9.method128(var6);
                  var9.field2788 = 4;
                  var9.field2830 = var6;
                  var9.field2816 = var95.field1122;
                  var9.field2817 = var95.field1123;
                  var9.field2819 = var95.field1121 * 100 / var1;
                  class34.method701(var9);
               } else {
                  var9.field2885 = var6;
                  var9.field2780 = var1;
                  var95 = class9.method128(var6);
                  var9.field2816 = var95.field1122;
                  var9.field2817 = var95.field1123;
                  var9.field2818 = var95.field1126;
                  var9.field2859 = var95.field1125;
                  var9.field2815 = var95.field1138;
                  var9.field2819 = var95.field1121;
                  if(1 == var95.field1127) {
                     var9.field2823 = 1;
                  } else {
                     var9.field2823 = 2;
                  }

                  if(var9.field2820 > 0) {
                     var9.field2819 = var9.field2819 * 32 / var9.field2820;
                  } else if(var9.field2776 > 0) {
                     var9.field2819 = var9.field2819 * 32 / var9.field2776;
                  }

                  class34.method701(var9);
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 79) {
               var6 = client.field324.method2613();
               var1 = client.field324.method2518();
               var33 = client.field324.method2500();
               if(var1 >= 1 && var1 <= 8) {
                  if(var33.equalsIgnoreCase("null")) {
                     var33 = null;
                  }

                  client.field442[var1 - 1] = var33;
                  client.field294[var1 - 1] = 0 == var6;
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 173) {
               client.field293 = client.field324.method2492();
               client.field326 = -1;
               return true;
            }

            if(102 == client.field326) {
               field1377 = class32.method689(client.field324.method2492());
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 145) {
               var6 = client.field325 + client.field324.field2005;
               var1 = client.field324.method2584();
               var7 = client.field324.method2584();
               if(client.field412 != var1) {
                  client.field412 = var1;
                  class9.method125(false);
                  class156.method3148(client.field412);
                  class16.method198(client.field412);

                  for(var3 = 0; var3 < 100; ++var3) {
                     client.field482[var3] = true;
                  }
               }

               class3 var92;
               for(; var7-- > 0; var92.field68 = true) {
                  var3 = client.field324.method2497();
                  var4 = client.field324.method2584();
                  var5 = client.field324.method2492();
                  var92 = (class3)client.field308.method3777((long)var3);
                  if(var92 != null && var4 != var92.field69) {
                     class38.method737(var92, true);
                     var92 = null;
                  }

                  if(var92 == null) {
                     var92 = class9.method118(var3, var4, var5);
                  }
               }

               for(var13 = (class3)client.field308.method3780(); var13 != null; var13 = (class3)client.field308.method3781()) {
                  if(var13.field68) {
                     var13.field68 = false;
                  } else {
                     class38.method737(var13, true);
                  }
               }

               client.field479 = new class196(512);

               while(client.field324.field2005 < var6) {
                  var3 = client.field324.method2497();
                  var4 = client.field324.method2584();
                  var5 = client.field324.method2584();
                  var8 = client.field324.method2497();

                  for(var18 = var4; var18 <= var5; ++var18) {
                     var29 = ((long)var3 << 32) + (long)var18;
                     client.field479.method3778(new class201(var8), var29);
                  }
               }

               client.field326 = -1;
               return true;
            }

            boolean var40;
            if(client.field326 == 129) {
               var0 = client.field324.method2500();
               var25 = (long)client.field324.method2584();
               var27 = (long)client.field324.method2513();
               class152 var91 = (class152)method1616(class115.method2441(), client.field324.method2492());
               var37 = var27 + (var25 << 32);
               var40 = false;

               for(var20 = 0; var20 < 100; ++var20) {
                  if(client.field382[var20] == var37) {
                     var40 = true;
                     break;
                  }
               }

               if(class16.method196(var0)) {
                  var40 = true;
               }

               if(!var40 && client.field358 == 0) {
                  client.field382[client.field530] = var37;
                  client.field530 = (client.field530 + 1) % 100;
                  var21 = class223.method4001(class34.method711(class152.method3131(client.field324)));
                  byte var89;
                  if(var91.field2280) {
                     var89 = 7;
                  } else {
                     var89 = 3;
                  }

                  if(-1 != var91.field2283) {
                     class125.method2783(var89, class156.method3146(var91.field2283) + var0, var21);
                  } else {
                     class125.method2783(var89, var0, var21);
                  }
               }

               client.field326 = -1;
               return true;
            }

            boolean var39;
            byte var41;
            if(254 == client.field326) {
               var0 = client.field324.method2500();
               var1 = client.field324.method2584();
               var41 = client.field324.method2493();
               var39 = false;
               if(-128 == var41) {
                  var39 = true;
               }

               if(var39) {
                  if(0 == class110.field1959) {
                     client.field326 = -1;
                     return true;
                  }

                  var40 = false;

                  for(var4 = 0; var4 < class110.field1959 && (!class159.field2612[var4].field616.equals(var0) || class159.field2612[var4].field618 != var1); ++var4) {
                     ;
                  }

                  if(var4 < class110.field1959) {
                     while(var4 < class110.field1959 - 1) {
                        class159.field2612[var4] = class159.field2612[var4 + 1];
                        ++var4;
                     }

                     --class110.field1959;
                     class159.field2612[class110.field1959] = null;
                  }
               } else {
                  client.field324.method2500();
                  class24 var88 = new class24();
                  var88.field616 = var0;
                  var88.field617 = class32.method690(var88.field616, class1.field24);
                  var88.field618 = var1;
                  var88.field622 = var41;

                  for(var5 = class110.field1959 - 1; var5 >= 0; --var5) {
                     var8 = class159.field2612[var5].field617.compareTo(var88.field617);
                     if(var8 == 0) {
                        class159.field2612[var5].field618 = var1;
                        class159.field2612[var5].field622 = var41;
                        if(var0.equals(class106.field1881.field59)) {
                           client.field396 = var41;
                        }

                        client.field451 = client.field462;
                        client.field326 = -1;
                        return true;
                     }

                     if(var8 < 0) {
                        break;
                     }
                  }

                  if(class110.field1959 >= class159.field2612.length) {
                     client.field326 = -1;
                     return true;
                  }

                  for(var8 = class110.field1959 - 1; var8 > var5; --var8) {
                     class159.field2612[var8 + 1] = class159.field2612[var8];
                  }

                  if(0 == class110.field1959) {
                     class159.field2612 = new class24[100];
                  }

                  class159.field2612[1 + var5] = var88;
                  ++class110.field1959;
                  if(var0.equals(class106.field1881.field59)) {
                     client.field396 = var41;
                  }
               }

               client.field451 = client.field462;
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 104) {
               var6 = client.field324.method2505();
               var32 = client.field324.method2492() == 1;
               var33 = "";
               var39 = false;
               if(var32) {
                  var33 = client.field324.method2500();
                  if(class16.method196(var33)) {
                     var39 = true;
                  }
               }

               var36 = client.field324.method2500();
               if(!var39) {
                  class125.method2783(var6, var33, var36);
               }

               client.field326 = -1;
               return true;
            }

            if(125 == client.field326) {
               var0 = client.field324.method2500();
               Object[] var86 = new Object[var0.length() + 1];

               for(var7 = var0.length() - 1; var7 >= 0; --var7) {
                  if(var0.charAt(var7) == 115) {
                     var86[1 + var7] = client.field324.method2500();
                  } else {
                     var86[var7 + 1] = new Integer(client.field324.method2497());
                  }
               }

               var86[0] = new Integer(client.field324.method2497());
               class0 var87 = new class0();
               var87.field12 = var86;
               class16.method197(var87);
               client.field326 = -1;
               return true;
            }

            if(204 == client.field326) {
               var6 = client.field324.method2533();
               if(var6 == '\uffff') {
                  var6 = -1;
               }

               class77.method1660(var6);
               client.field326 = -1;
               return true;
            }

            if(221 == client.field326) {
               var6 = client.field324.method2530();
               var1 = client.field324.method2584();
               if('\uffff' == var1) {
                  var1 = -1;
               }

               class111.method2421(var1, var6);
               client.field326 = -1;
               return true;
            }

            if(227 == client.field326) {
               client.field451 = client.field462;
               if(0 == client.field325) {
                  client.field504 = null;
                  client.field416 = null;
                  class110.field1959 = 0;
                  class159.field2612 = null;
                  client.field326 = -1;
                  return true;
               }

               client.field416 = client.field324.method2500();
               long var83 = client.field324.method2498();
               client.field504 = class85.method1886(var83);
               class33.field779 = client.field324.method2493();
               var7 = client.field324.method2492();
               if(var7 == 255) {
                  client.field326 = -1;
                  return true;
               }

               class110.field1959 = var7;
               class24[] var90 = new class24[100];

               for(var4 = 0; var4 < class110.field1959; ++var4) {
                  var90[var4] = new class24();
                  var90[var4].field616 = client.field324.method2500();
                  var90[var4].field617 = class32.method690(var90[var4].field616, class1.field24);
                  var90[var4].field618 = client.field324.method2584();
                  var90[var4].field622 = client.field324.method2493();
                  client.field324.method2500();
                  if(var90[var4].field616.equals(class106.field1881.field59)) {
                     client.field396 = var90[var4].field622;
                  }
               }

               var40 = false;
               var8 = class110.field1959;

               while(var8 > 0) {
                  var40 = true;
                  --var8;

                  for(var18 = 0; var18 < var8; ++var18) {
                     if(var90[var18].field617.compareTo(var90[1 + var18].field617) > 0) {
                        class24 var94 = var90[var18];
                        var90[var18] = var90[var18 + 1];
                        var90[1 + var18] = var94;
                        var40 = false;
                     }
                  }

                  if(var40) {
                     break;
                  }
               }

               class159.field2612 = var90;
               client.field326 = -1;
               return true;
            }

            if(161 == client.field326) {
               client.field324.field2005 += 28;
               if(client.field324.method2514()) {
                  var17 = client.field324;
                  var1 = client.field324.field2005 - 28;
                  if(class149.field2242 != null) {
                     try {
                        class149.field2242.method4141(0L);
                        class149.field2242.method4128(var17.field2007, var1, 24);
                     } catch (Exception var45) {
                        ;
                     }
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 21) {
               while(true) {
                  class17 var43;
                  while(client.field324.field2005 < client.field325) {
                     var15 = client.field324.method2492() == 1;
                     var14 = client.field324.method2500();
                     var33 = client.field324.method2500();
                     var3 = client.field324.method2584();
                     var4 = client.field324.method2492();
                     var5 = client.field324.method2492();
                     boolean var81 = 0 != (var5 & 2);
                     boolean var42 = 0 != (var5 & 1);
                     if(var3 > 0) {
                        client.field324.method2500();
                        client.field324.method2492();
                        client.field324.method2497();
                     }

                     client.field324.method2500();

                     for(var35 = 0; var35 < client.field499; ++var35) {
                        var43 = client.field548[var35];
                        if(!var15) {
                           if(var14.equals(var43.field247)) {
                              if(var3 != var43.field244) {
                                 var24 = true;
                                 class38 var44 = (class38)client.field316.method3764();

                                 while(true) {
                                    if(null == var44) {
                                       if(var24) {
                                          client.field316.method3763(new class38(var14, var3));
                                       }

                                       var43.field244 = var3;
                                       break;
                                    }

                                    if(var44.field875.equals(var14)) {
                                       if(var3 != 0 && var44.field874 == 0) {
                                          var44.method3894();
                                          var24 = false;
                                       } else if(var3 == 0 && 0 != var44.field874) {
                                          var44.method3894();
                                          var24 = false;
                                       }
                                    }

                                    var44 = (class38)client.field316.method3765();
                                 }
                              }

                              var43.field240 = var33;
                              var43.field237 = var4;
                              var43.field238 = var81;
                              var43.field239 = var42;
                              var23 = null;
                              break;
                           }
                        } else if(var33.equals(var43.field247)) {
                           var43.field247 = var14;
                           var43.field240 = var33;
                           var23 = null;
                           break;
                        }
                     }
                  }

                  client.field544 = 2;
                  client.field470 = client.field462;
                  var15 = false;
                  var1 = client.field499;

                  while(var1 > 0) {
                     var15 = true;
                     --var1;

                     for(var7 = 0; var7 < var1; ++var7) {
                        var39 = false;
                        class17 var82 = client.field548[var7];
                        class17 var84 = client.field548[1 + var7];
                        if(client.field551 != var82.field244 && var84.field244 == client.field551) {
                           var39 = true;
                        }

                        if(!var39 && 0 == var82.field244 && 0 != var84.field244) {
                           var39 = true;
                        }

                        if(!var39 && !var82.field238 && var84.field238) {
                           var39 = true;
                        }

                        if(!var39 && !var82.field239 && var84.field239) {
                           var39 = true;
                        }

                        if(var39) {
                           var43 = client.field548[var7];
                           client.field548[var7] = client.field548[1 + var7];
                           client.field548[var7 + 1] = var43;
                           var15 = false;
                        }
                     }

                     if(var15) {
                        break;
                     }
                  }

                  client.field326 = -1;
                  return true;
               }
            }

            if(client.field326 == 192) {
               var6 = client.field324.method2526();
               var1 = client.field324.method2534();
               var12 = class29.method645(var1);
               if(1 != var12.field2788 || var6 != var12.field2830) {
                  var12.field2788 = 1;
                  var12.field2830 = var6;
                  class34.method701(var12);
               }

               client.field326 = -1;
               return true;
            }

            if(7 == client.field326) {
               var6 = client.field324.method2492();
               if(client.field324.method2492() == 0) {
                  client.field388[var6] = new class220();
                  client.field324.field2005 += 18;
               } else {
                  --client.field324.field2005;
                  client.field388[var6] = new class220(client.field324, false);
               }

               client.field438 = client.field462;
               client.field326 = -1;
               return true;
            }

            if(234 == client.field326) {
               class45.field1046 = client.field324.method2613();
               class134.field2089 = client.field324.method2613();
               client.field326 = -1;
               return true;
            }

            if(231 == client.field326) {
               var6 = client.field324.method2533();
               var1 = client.field324.method2534();
               var7 = var6 >> 10 & 31;
               var3 = var6 >> 5 & 31;
               var4 = var6 & 31;
               var5 = (var4 << 3) + (var3 << 11) + (var7 << 19);
               class173 var80 = class29.method645(var1);
               if(var5 != var80.field2790) {
                  var80.field2790 = var5;
                  class34.method701(var80);
               }

               client.field326 = -1;
               return true;
            }

            if(152 == client.field326) {
               var6 = client.field324.method2526();
               var41 = client.field324.method2684();
               class176.field2918[var6] = var41;
               if(class176.field2920[var6] != var41) {
                  class176.field2920[var6] = var41;
               }

               class52.method1069(var6);
               client.field463[++client.field464 - 1 & 31] = var6;
               client.field326 = -1;
               return true;
            }

            if(58 == client.field326) {
               var6 = client.field324.method2526();
               var1 = client.field324.method2534();
               var12 = class29.method645(var1);
               if(var12 != null && 0 == var12.field2767) {
                  if(var6 > var12.field2858 - var12.field2781) {
                     var6 = var12.field2858 - var12.field2781;
                  }

                  if(var6 < 0) {
                     var6 = 0;
                  }

                  if(var12.field2787 != var6) {
                     var12.field2787 = var6;
                     class34.method701(var12);
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(164 == client.field326) {
               var6 = client.field324.method2535();
               var23 = class29.method645(var6);
               var23.field2788 = 3;
               var23.field2830 = class106.field1881.field34.method3491();
               class34.method701(var23);
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 38) {
               var6 = client.field324.method2536();
               var32 = client.field324.method2613() == 1;
               var12 = class29.method645(var6);
               if(var32 != var12.field2773) {
                  var12.field2773 = var32;
                  class34.method701(var12);
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 151) {
               client.field512 = client.field324.method2492();
               if(255 == client.field512) {
                  client.field512 = 0;
               }

               client.field513 = client.field324.method2492();
               if(255 == client.field513) {
                  client.field513 = 0;
               }

               client.field326 = -1;
               return true;
            }

            class90.method2067("" + client.field326 + "," + client.field330 + "," + client.field331 + "," + client.field325, (Throwable)null);
            class14.method172();
         } catch (IOException var53) {
            class115.method2442();
         } catch (Exception var54) {
            var0 = "" + client.field326 + "," + client.field330 + "," + client.field331 + "," + client.field325 + "," + (class22.field594 + class106.field1881.field866[0]) + "," + (class114.field1981 + class106.field1881.field863[0]) + ",";

            for(var1 = 0; var1 < client.field325 && var1 < 50; ++var1) {
               var0 = var0 + client.field324.field2007[var1] + ",";
            }

            class90.method2067(var0, var54);
            class14.method172();
         }

         return true;
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-609991327"
   )
   synchronized void method1593() {
      if(this.field1378 != null) {
         this.field1378.setPixels(0, 0, super.field1397, super.field1398, this.field1380, super.field1401, 0, super.field1397);
         this.field1378.imageComplete(2);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1965413454"
   )
   synchronized void method1598(int var1, int var2, int var3, int var4) {
      if(this.field1378 != null) {
         this.field1378.setPixels(var1, var2, var3, var4, this.field1380, super.field1401, var2 * super.field1397 + var1, super.field1397);
         this.field1378.imageComplete(2);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "([Lclass112;IB)Lclass112;",
      garbageValue = "7"
   )
   public static class112 method1616(class112[] var0, int var1) {
      class112[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class112 var4 = var2[var3];
         if(var1 == var4.vmethod3150()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass144;I)V",
      garbageValue = "136852755"
   )
   static void method1618(class144 var0) {
      int var1;
      int var2;
      int var3;
      int var4;
      if(class31.field744) {
         if(1 == class140.field2159 || !class89.field1563 && class140.field2159 == 4) {
            var1 = class31.field748 + 280;
            if(class140.field2169 >= var1 && class140.field2169 <= 14 + var1 && class140.field2170 >= 4 && class140.field2170 <= 18) {
               class2.method27(0, 0);
            } else if(class140.field2169 >= var1 + 15 && class140.field2169 <= 80 + var1 && class140.field2170 >= 4 && class140.field2170 <= 18) {
               class2.method27(0, 1);
            } else {
               var2 = 390 + class31.field748;
               if(class140.field2169 >= var2 && class140.field2169 <= 14 + var2 && class140.field2170 >= 4 && class140.field2170 <= 18) {
                  class2.method27(1, 0);
               } else if(class140.field2169 >= var2 + 15 && class140.field2169 <= var2 + 80 && class140.field2170 >= 4 && class140.field2170 <= 18) {
                  class2.method27(1, 1);
               } else {
                  var3 = 500 + class31.field748;
                  if(class140.field2169 >= var3 && class140.field2169 <= 14 + var3 && class140.field2170 >= 4 && class140.field2170 <= 18) {
                     class2.method27(2, 0);
                  } else if(class140.field2169 >= 15 + var3 && class140.field2169 <= var3 + 80 && class140.field2170 >= 4 && class140.field2170 <= 18) {
                     class2.method27(2, 1);
                  } else {
                     var4 = 610 + class31.field748;
                     if(class140.field2169 >= var4 && class140.field2169 <= var4 + 14 && class140.field2170 >= 4 && class140.field2170 <= 18) {
                        class2.method27(3, 0);
                     } else if(class140.field2169 >= var4 + 15 && class140.field2169 <= 80 + var4 && class140.field2170 >= 4 && class140.field2170 <= 18) {
                        class2.method27(3, 1);
                     } else if(class140.field2169 >= class31.field748 + 708 && class140.field2170 >= 4 && class140.field2169 <= 758 + class31.field748 && class140.field2170 <= 20) {
                        class31.field744 = false;
                        class20.field569.method1674(class31.field748, 0);
                        class121.field2016.method1674(382 + class31.field748, 0);
                        class31.field718.method1841(382 + class31.field748 - class31.field718.field1427 / 2, 18);
                     } else if(class31.field747 != -1) {
                        class25 var5 = class25.field636[class31.field747];
                        class90.method2068(var5);
                        class31.field744 = false;
                        class20.field569.method1674(class31.field748, 0);
                        class121.field2016.method1674(class31.field748 + 382, 0);
                        class31.field718.method1841(class31.field748 + 382 - class31.field718.field1427 / 2, 18);
                     }
                  }
               }
            }
         }
      } else {
         if((1 == class140.field2159 || !class89.field1563 && class140.field2159 == 4) && class140.field2169 >= 765 + class31.field748 - 50 && class140.field2170 >= 453) {
            class76.field1388.field143 = !class76.field1388.field143;
            class7.method101();
            if(!class76.field1388.field143) {
               class26.method618(class102.field1776, "scape main", "", 255, false);
            } else {
               class107.method2373();
            }
         }

         if(client.field286 != 5) {
            ++class31.field728;
            if(client.field286 == 10 || 11 == client.field286) {
               short var12;
               if(client.field285 == 0) {
                  if(1 == class140.field2159 || !class89.field1563 && class140.field2159 == 4) {
                     var1 = 5 + class31.field748;
                     var12 = 463;
                     byte var6 = 100;
                     byte var7 = 35;
                     if(class140.field2169 >= var1 && class140.field2169 <= var6 + var1 && class140.field2170 >= var12 && class140.field2170 <= var7 + var12) {
                        if(class38.method734()) {
                           class31.field744 = true;
                        }

                        return;
                     }
                  }

                  if(null != class87.field1537 && class38.method734()) {
                     class31.field744 = true;
                  }
               }

               var1 = class140.field2159;
               var2 = class140.field2169;
               var3 = class140.field2170;
               if(!class89.field1563 && var1 == 4) {
                  var1 = 1;
               }

               String var13;
               if(class31.field732 == 0) {
                  var4 = 180 + class31.field720 - 80;
                  var12 = 291;
                  if(1 == var1 && var2 >= var4 - 75 && var2 <= var4 + 75 && var3 >= var12 - 20 && var3 <= 20 + var12) {
                     var13 = class122.method2758("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                     class103.method2275(var13, true, "openjs", false);
                  }

                  var4 = 180 + class31.field720 + 80;
                  if(var1 == 1 && var2 >= var4 - 75 && var2 <= var4 + 75 && var3 >= var12 - 20 && var3 <= var12 + 20) {
                     if(0 != (client.field279 & 33554432)) {
                        class31.field733 = "";
                        class31.field734 = "This is a <col=00ffff>Tournament<col=ffffff> world.";
                        class31.field725 = "Max stats and high level gear are provided.";
                        class31.field738 = "Your normal account will not be affected.";
                        class31.field732 = 1;
                        class31.field729 = 0;
                     } else if(0 != (client.field279 & 4)) {
                        if((client.field279 & 1024) != 0) {
                           class31.field734 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
                           class31.field725 = "Players can attack each other almost everywhere";
                           class31.field738 = "and the Protect Item prayer won\'t work.";
                        } else {
                           class31.field734 = "This is a <col=ff0000>PvP<col=ffffff> world.";
                           class31.field725 = "Players can attack each other";
                           class31.field738 = "almost everywhere.";
                        }

                        class31.field733 = "Warning!";
                        class31.field732 = 1;
                        class31.field729 = 0;
                     } else if(0 != (client.field279 & 1024)) {
                        class31.field734 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
                        class31.field725 = "The Protect Item prayer will";
                        class31.field738 = "not work on this world.";
                        class31.field733 = "Warning!";
                        class31.field732 = 1;
                        class31.field729 = 0;
                     } else {
                        class31.field734 = "";
                        class31.field725 = "Enter your username/email & password.";
                        class31.field738 = "";
                        class31.field732 = 2;
                        class31.field729 = 0;
                     }
                  }
               } else if(class31.field732 != 1) {
                  short var14;
                  if(2 == class31.field732) {
                     var14 = 231;
                     var4 = var14 + 30;
                     if(var1 == 1 && var3 >= var4 - 15 && var3 < var4) {
                        class31.field729 = 0;
                     }

                     var4 += 15;
                     if(1 == var1 && var3 >= var4 - 15 && var3 < var4) {
                        class31.field729 = 1;
                     }

                     var4 += 15;
                     var14 = 361;
                     if(1 == var1 && var3 >= var14 - 15 && var3 < var14) {
                        class8.method107("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field732 = 5;
                        return;
                     }

                     int var15 = 180 + class31.field720 - 80;
                     short var16 = 321;
                     if(1 == var1 && var2 >= var15 - 75 && var2 <= var15 + 75 && var3 >= var16 - 20 && var3 <= var16 + 20) {
                        class31.field737 = class31.field737.trim();
                        if(class31.field737.length() == 0) {
                           class8.method107("", "Please enter your username/email address.", "");
                           return;
                        }

                        if(class31.field740.length() == 0) {
                           class8.method107("", "Please enter your password.", "");
                           return;
                        }

                        class8.method107("", "Connecting to server...", "");
                        class31.field719 = class76.field1388.field146.containsKey(Integer.valueOf(class36.method715(class31.field737)))?class159.field2610:class159.field2608;
                        class15.method188(20);
                        return;
                     }

                     var15 = 80 + class31.field720 + 180;
                     if(1 == var1 && var2 >= var15 - 75 && var2 <= var15 + 75 && var3 >= var16 - 20 && var3 <= var16 + 20) {
                        class31.field732 = 0;
                        class31.field737 = "";
                        class31.field740 = "";
                        class87.field1540 = 0;
                        class44.field1035 = "";
                        class31.field739 = true;
                     }

                     while(true) {
                        while(class20.method551()) {
                           boolean var10 = false;

                           for(int var11 = 0; var11 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var11) {
                              if(class109.field1917 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var11)) {
                                 var10 = true;
                                 break;
                              }
                           }

                           if(class137.field2133 == 13) {
                              class31.field732 = 0;
                              class31.field737 = "";
                              class31.field740 = "";
                              class87.field1540 = 0;
                              class44.field1035 = "";
                              class31.field739 = true;
                           } else if(class31.field729 == 0) {
                              if(class137.field2133 == 85 && class31.field737.length() > 0) {
                                 class31.field737 = class31.field737.substring(0, class31.field737.length() - 1);
                              }

                              if(84 == class137.field2133 || 80 == class137.field2133) {
                                 class31.field729 = 1;
                              }

                              if(var10 && class31.field737.length() < 320) {
                                 class31.field737 = class31.field737 + class109.field1917;
                              }
                           } else if(1 == class31.field729) {
                              if(class137.field2133 == 85 && class31.field740.length() > 0) {
                                 class31.field740 = class31.field740.substring(0, class31.field740.length() - 1);
                              }

                              if(class137.field2133 == 84 || 80 == class137.field2133) {
                                 class31.field729 = 0;
                              }

                              if(84 == class137.field2133) {
                                 class31.field737 = class31.field737.trim();
                                 if(class31.field737.length() == 0) {
                                    class8.method107("", "Please enter your username/email address.", "");
                                    return;
                                 }

                                 if(class31.field740.length() == 0) {
                                    class8.method107("", "Please enter your password.", "");
                                    return;
                                 }

                                 class8.method107("", "Connecting to server...", "");
                                 class31.field719 = class76.field1388.field146.containsKey(Integer.valueOf(class36.method715(class31.field737)))?class159.field2610:class159.field2608;
                                 class15.method188(20);
                                 return;
                              }

                              if(var10 && class31.field740.length() < 20) {
                                 class31.field740 = class31.field740 + class109.field1917;
                              }
                           }
                        }

                        return;
                     }
                  }

                  if(class31.field732 == 3) {
                     var4 = 180 + class31.field720;
                     var12 = 276;
                     if(1 == var1 && var2 >= var4 - 75 && var2 <= 75 + var4 && var3 >= var12 - 20 && var3 <= var12 + 20) {
                        class31.field734 = "";
                        class31.field725 = "Enter your username/email & password.";
                        class31.field738 = "";
                        class31.field732 = 2;
                        class31.field729 = 0;
                     }

                     var4 = class31.field720 + 180;
                     var12 = 326;
                     if(var1 == 1 && var2 >= var4 - 75 && var2 <= 75 + var4 && var3 >= var12 - 20 && var3 <= 20 + var12) {
                        class8.method107("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field732 = 5;
                        return;
                     }
                  } else {
                     boolean var8;
                     int var9;
                     if(class31.field732 == 4) {
                        var4 = class31.field720 + 180 - 80;
                        var12 = 321;
                        if(1 == var1 && var2 >= var4 - 75 && var2 <= var4 + 75 && var3 >= var12 - 20 && var3 <= 20 + var12) {
                           class44.field1035.trim();
                           if(class44.field1035.length() != 6) {
                              class8.method107("", "Please enter a 6-digin PIN.", "");
                              return;
                           }

                           class87.field1540 = Integer.parseInt(class44.field1035);
                           class44.field1035 = "";
                           class31.field719 = class31.field739?class159.field2607:class159.field2614;
                           class8.method107("", "Connecting to server...", "");
                           class15.method188(20);
                           return;
                        }

                        if(1 == var1 && var2 >= 180 + class31.field720 - 9 && var2 <= class31.field720 + 180 + 130 && var3 >= 263 && var3 <= 296) {
                           class31.field739 = !class31.field739;
                        }

                        if(1 == var1 && var2 >= 180 + class31.field720 - 34 && var2 <= 180 + class31.field720 + 34 && var3 >= 351 && var3 <= 363) {
                           var13 = class122.method2758("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                           class103.method2275(var13, true, "openjs", false);
                        }

                        var4 = 180 + class31.field720 + 80;
                        if(1 == var1 && var2 >= var4 - 75 && var2 <= var4 + 75 && var3 >= var12 - 20 && var3 <= var12 + 20) {
                           class31.field732 = 0;
                           class31.field737 = "";
                           class31.field740 = "";
                           class87.field1540 = 0;
                           class44.field1035 = "";
                        }

                        while(class20.method551()) {
                           var8 = false;

                           for(var9 = 0; var9 < "1234567890".length(); ++var9) {
                              if(class109.field1917 == "1234567890".charAt(var9)) {
                                 var8 = true;
                                 break;
                              }
                           }

                           if(class137.field2133 == 13) {
                              class31.field732 = 0;
                              class31.field737 = "";
                              class31.field740 = "";
                              class87.field1540 = 0;
                              class44.field1035 = "";
                           } else {
                              if(85 == class137.field2133 && class44.field1035.length() > 0) {
                                 class44.field1035 = class44.field1035.substring(0, class44.field1035.length() - 1);
                              }

                              if(84 == class137.field2133) {
                                 class44.field1035.trim();
                                 if(class44.field1035.length() != 6) {
                                    class8.method107("", "Please enter a 6-digin PIN.", "");
                                    return;
                                 }

                                 class87.field1540 = Integer.parseInt(class44.field1035);
                                 class44.field1035 = "";
                                 class31.field719 = class31.field739?class159.field2607:class159.field2614;
                                 class8.method107("", "Connecting to server...", "");
                                 class15.method188(20);
                                 return;
                              }

                              if(var8 && class44.field1035.length() < 6) {
                                 class44.field1035 = class44.field1035 + class109.field1917;
                              }
                           }
                        }
                     } else if(class31.field732 == 5) {
                        var4 = class31.field720 + 180 - 80;
                        var12 = 321;
                        if(var1 == 1 && var2 >= var4 - 75 && var2 <= var4 + 75 && var3 >= var12 - 20 && var3 <= var12 + 20) {
                           class172.method3364();
                           return;
                        }

                        var4 = 80 + class31.field720 + 180;
                        if(var1 == 1 && var2 >= var4 - 75 && var2 <= 75 + var4 && var3 >= var12 - 20 && var3 <= var12 + 20) {
                           class31.field734 = "";
                           class31.field725 = "Enter your username/email & password.";
                           class31.field738 = "";
                           class31.field732 = 2;
                           class31.field729 = 0;
                           class31.field740 = "";
                        }

                        while(class20.method551()) {
                           var8 = false;

                           for(var9 = 0; var9 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var9) {
                              if(class109.field1917 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var9)) {
                                 var8 = true;
                                 break;
                              }
                           }

                           if(13 == class137.field2133) {
                              class31.field734 = "";
                              class31.field725 = "Enter your username/email & password.";
                              class31.field738 = "";
                              class31.field732 = 2;
                              class31.field729 = 0;
                              class31.field740 = "";
                           } else {
                              if(85 == class137.field2133 && class31.field737.length() > 0) {
                                 class31.field737 = class31.field737.substring(0, class31.field737.length() - 1);
                              }

                              if(class137.field2133 == 84) {
                                 class172.method3364();
                                 return;
                              }

                              if(var8 && class31.field737.length() < 320) {
                                 class31.field737 = class31.field737 + class109.field1917;
                              }
                           }
                        }
                     } else if(class31.field732 == 6) {
                        while(true) {
                           do {
                              if(!class20.method551()) {
                                 var14 = 321;
                                 if(var1 == 1 && var3 >= var14 - 20 && var3 <= 20 + var14) {
                                    class31.field734 = "";
                                    class31.field725 = "Enter your username/email & password.";
                                    class31.field738 = "";
                                    class31.field732 = 2;
                                    class31.field729 = 0;
                                    class31.field740 = "";
                                 }

                                 return;
                              }
                           } while(class137.field2133 != 84 && 13 != class137.field2133);

                           class31.field734 = "";
                           class31.field725 = "Enter your username/email & password.";
                           class31.field738 = "";
                           class31.field732 = 2;
                           class31.field729 = 0;
                           class31.field740 = "";
                        }
                     }
                  }
               } else {
                  while(class20.method551()) {
                     if(class137.field2133 == 84) {
                        class31.field734 = "";
                        class31.field725 = "Enter your username/email & password.";
                        class31.field738 = "";
                        class31.field732 = 2;
                        class31.field729 = 0;
                     } else if(class137.field2133 == 13) {
                        class31.field732 = 0;
                     }
                  }

                  var4 = 180 + class31.field720 - 80;
                  var12 = 321;
                  if(var1 == 1 && var2 >= var4 - 75 && var2 <= 75 + var4 && var3 >= var12 - 20 && var3 <= 20 + var12) {
                     class31.field734 = "";
                     class31.field725 = "Enter your username/email & password.";
                     class31.field738 = "";
                     class31.field732 = 2;
                     class31.field729 = 0;
                  }

                  var4 = 260 + class31.field720;
                  if(var1 == 1 && var2 >= var4 - 75 && var2 <= var4 + 75 && var3 >= var12 - 20 && var3 <= 20 + var12) {
                     class31.field732 = 0;
                  }
               }
            }
         }
      }

   }
}
