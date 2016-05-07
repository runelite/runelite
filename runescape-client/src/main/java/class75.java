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
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("bl")
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
   public final void vmethod1857(Graphics var1, int var2, int var3) {
      this.method1593();
      var1.drawImage(super.field1400, var2, var3, this);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIS)V",
      garbageValue = "128"
   )
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
         String var1;
         int var2;
         try {
            int var0 = class167.field2697.method2962();
            if(0 == var0) {
               return false;
            }

            if(client.field326 == -1) {
               class167.field2697.method2961(client.field324.field2007, 0, 1);
               client.field324.field2005 = 0;
               client.field326 = client.field324.method2738();
               client.field325 = class188.field3063[client.field326];
               --var0;
            }

            if(-1 == client.field325) {
               if(var0 <= 0) {
                  return false;
               }

               class167.field2697.method2961(client.field324.field2007, 0, 1);
               client.field325 = client.field324.field2007[0] & 255;
               --var0;
            }

            if(-2 == client.field325) {
               if(var0 <= 1) {
                  return false;
               }

               class167.field2697.method2961(client.field324.field2007, 0, 2);
               client.field324.field2005 = 0;
               client.field325 = client.field324.method2584();
               var0 -= 2;
            }

            if(var0 < client.field325) {
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

            int var4;
            int var5;
            int var6;
            int var31;
            int var34;
            int var55;
            if(client.field326 == 40) {
               client.field558 = true;
               class47.field1072 = client.field324.method2492();
               class95.field1634 = client.field324.method2492();
               class76.field1391 = client.field324.method2584();
               class103.field1779 = client.field324.method2492();
               class56.field1202 = client.field324.method2492();
               if(class56.field1202 >= 100) {
                  var31 = 64 + class47.field1072 * 128;
                  var2 = class95.field1634 * 128 + 64;
                  var34 = class107.method2369(var31, var2, class21.field581) - class76.field1391;
                  var4 = var31 - class77.field1404;
                  var5 = var34 - class7.field138;
                  var6 = var2 - class72.field1353;
                  var55 = (int)Math.sqrt((double)(var4 * var4 + var6 * var6));
                  class59.field1222 = (int)(Math.atan2((double)var5, (double)var55) * 325.949D) & 2047;
                  class32.field750 = (int)(Math.atan2((double)var4, (double)var6) * -325.949D) & 2047;
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

            class173 var78;
            if(client.field326 == 172) {
               var31 = client.field324.method2529();
               var2 = client.field324.method2534();
               var34 = client.field324.method2495();
               var78 = class29.method645(var2);
               if(var34 != var78.field2774 || var78.field2775 != var31 || var78.field2770 != 0 || 0 != var78.field2810) {
                  var78.field2774 = var34;
                  var78.field2775 = var31;
                  var78.field2770 = 0;
                  var78.field2810 = 0;
                  class34.method701(var78);
                  class87.method2063(var78);
                  if(var78.field2767 == 0) {
                     class125.method2796(class217.field3171[var2 >> 16], var78, false);
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 246) {
               var31 = client.field324.method2497();
               class3 var99 = (class3)client.field308.method3777((long)var31);
               if(var99 != null) {
                  class38.method737(var99, true);
               }

               if(null != client.field441) {
                  class34.method701(client.field441);
                  client.field441 = null;
               }

               client.field326 = -1;
               return true;
            }

            if(71 == client.field326) {
               var31 = client.field324.method2492();
               var2 = client.field324.method2492();
               var34 = client.field324.method2492();
               var4 = client.field324.method2492();
               client.field528[var31] = true;
               client.field529[var31] = var2;
               client.field423[var31] = var34;
               client.field337[var31] = var4;
               client.field532[var31] = 0;
               client.field326 = -1;
               return true;
            }

            if(3 == client.field326) {
               for(var31 = 0; var31 < class126.field2053; ++var31) {
                  class52 var97 = class3.method38(var31);
                  if(null != var97) {
                     class176.field2918[var31] = 0;
                     class176.field2920[var31] = 0;
                  }
               }

               class8.method112();
               client.field464 += 32;
               client.field326 = -1;
               return true;
            }

            if(99 == client.field326) {
               class8.method112();
               var31 = client.field324.method2492();
               var2 = client.field324.method2613();
               var34 = client.field324.method2536();
               client.field427[var31] = var34;
               client.field399[var31] = var2;
               client.field415[var31] = 1;

               for(var4 = 0; var4 < 98; ++var4) {
                  if(var34 >= class155.field2301[var4]) {
                     client.field415[var31] = var4 + 2;
                  }
               }

               client.field467[++client.field468 - 1 & 31] = var31;
               client.field326 = -1;
               return true;
            }

            if(203 == client.field326) {
               var31 = client.field324.method2526();
               client.field412 = var31;
               class9.method125(false);
               class156.method3148(var31);
               class16.method198(client.field412);

               for(var2 = 0; var2 < 100; ++var2) {
                  client.field482[var2] = true;
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

               for(var31 = class134.field2089; var31 < class134.field2089 + 8; ++var31) {
                  for(var2 = class45.field1046; var2 < class45.field1046 + 8; ++var2) {
                     if(null != client.field345[class21.field581][var31][var2]) {
                        client.field345[class21.field581][var31][var2] = null;
                        class12.method161(var31, var2);
                     }
                  }
               }

               for(class16 var100 = (class16)client.field411.method3812(); null != var100; var100 = (class16)client.field411.method3817()) {
                  if(var100.field221 >= class134.field2089 && var100.field221 < class134.field2089 + 8 && var100.field232 >= class45.field1046 && var100.field232 < class45.field1046 + 8 && class21.field581 == var100.field227) {
                     var100.field230 = 0;
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

            long var73;
            if(191 == client.field326) {
               var31 = client.field324.method2534();
               var2 = client.field324.method2535();
               var34 = client.field324.method2584();
               if(var34 == '\uffff') {
                  var34 = -1;
               }

               var4 = client.field324.method2584();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               for(var5 = var34; var5 <= var4; ++var5) {
                  var73 = (long)var5 + ((long)var31 << 32);
                  class208 var72 = client.field479.method3777(var73);
                  if(null != var72) {
                     var72.method3898();
                  }

                  client.field479.method3778(new class201(var2), var73);
               }

               client.field326 = -1;
               return true;
            }

            if(76 == client.field326) {
               var31 = client.field324.method2497();
               var2 = client.field324.method2497();
               if(class56.field1203 == null || !class56.field1203.isValid()) {
                  try {
                     Iterator var94 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var94.hasNext()) {
                        GarbageCollectorMXBean var96 = (GarbageCollectorMXBean)var94.next();
                        if(var96.isValid()) {
                           class56.field1203 = var96;
                           client.field557 = -1L;
                           client.field556 = -1L;
                        }
                     }
                  } catch (Throwable var28) {
                     ;
                  }
               }

               long var95 = class12.method162();
               var5 = -1;
               if(class56.field1203 != null) {
                  var73 = class56.field1203.getCollectionTime();
                  if(-1L != client.field556) {
                     long var69 = var73 - client.field556;
                     long var79 = var95 - client.field557;
                     if(0L != var79) {
                        var5 = (int)(var69 * 100L / var79);
                     }
                  }

                  client.field556 = var73;
                  client.field557 = var95;
               }

               client.field322.method2737(125);
               client.field322.method2531(var31);
               client.field322.method2587(var2);
               client.field322.method2681(class144.field2207);
               client.field322.method2681(var5);
               client.field326 = -1;
               return true;
            }

            class173 var3;
            if(232 == client.field326) {
               var31 = client.field324.method2536();
               var2 = client.field324.method2529();
               var3 = class29.method645(var31);
               if(var3.field2812 != var2 || -1 == var2) {
                  var3.field2812 = var2;
                  var3.field2834 = 0;
                  var3.field2754 = 0;
                  class34.method701(var3);
               }

               client.field326 = -1;
               return true;
            }

            class3 var71;
            if(112 == client.field326) {
               var31 = client.field324.method2584();
               var2 = client.field324.method2492();
               var34 = client.field324.method2536();
               var71 = (class3)client.field308.method3777((long)var34);
               if(var71 != null) {
                  class38.method737(var71, var31 != var71.field69);
               }

               class9.method118(var34, var31, var2);
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
               for(var31 = 0; var31 < client.field491.length; ++var31) {
                  if(null != client.field491[var31]) {
                     client.field491[var31].field843 = -1;
                  }
               }

               for(var31 = 0; var31 < client.field515.length; ++var31) {
                  if(client.field515[var31] != null) {
                     client.field515[var31].field843 = -1;
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 170) {
               class25 var98 = new class25();
               var98.field635 = client.field324.method2500();
               var98.field632 = client.field324.method2584();
               var2 = client.field324.method2497();
               var98.field633 = var2;
               class15.method188(45);
               class167.field2697.method2960();
               class167.field2697 = null;
               class90.method2068(var98);
               client.field326 = -1;
               return false;
            }

            if(144 == client.field326) {
               var31 = client.field324.method2497();
               var2 = client.field324.method2584();
               if(var31 < -70000) {
                  var2 += '耀';
               }

               if(var31 >= 0) {
                  var3 = class29.method645(var31);
               } else {
                  var3 = null;
               }

               if(null != var3) {
                  for(var4 = 0; var4 < var3.field2883.length; ++var4) {
                     var3.field2883[var4] = 0;
                     var3.field2884[var4] = 0;
                  }
               }

               class15 var93 = (class15)class15.field204.method3777((long)var2);
               if(var93 != null) {
                  for(var5 = 0; var5 < var93.field210.length; ++var5) {
                     var93.field210[var5] = -1;
                     var93.field206[var5] = 0;
                  }
               }

               var4 = client.field324.method2584();

               for(var5 = 0; var5 < var4; ++var5) {
                  var6 = client.field324.method2584();
                  var55 = client.field324.method2492();
                  if(255 == var55) {
                     var55 = client.field324.method2497();
                  }

                  if(null != var3 && var5 < var3.field2883.length) {
                     var3.field2883[var5] = var6;
                     var3.field2884[var5] = var55;
                  }

                  class51.method1047(var2, var5, var6 - 1, var55);
               }

               if(var3 != null) {
                  class34.method701(var3);
               }

               class8.method112();
               client.field465[++client.field446 - 1 & 31] = var2 & 32767;
               client.field326 = -1;
               return true;
            }

            if(116 == client.field326) {
               var31 = client.field324.method2534();
               class114.field1975 = class38.field878.method2866(var31);
               client.field326 = -1;
               return true;
            }

            if(187 == client.field326) {
               var31 = client.field324.method2535();
               var2 = client.field324.method2527();
               class176.field2918[var2] = var31;
               if(var31 != class176.field2920[var2]) {
                  class176.field2920[var2] = var31;
               }

               class52.method1069(var2);
               client.field463[++client.field464 - 1 & 31] = var2;
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

            String var37;
            if(client.field326 == 213) {
               var1 = client.field324.method2500();
               var37 = class223.method4001(class34.method711(class152.method3131(client.field324)));
               class125.method2783(6, var1, var37);
               client.field326 = -1;
               return true;
            }

            boolean var39;
            if(95 == client.field326) {
               var39 = client.field324.method2492() == 1;
               if(var39) {
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
               var31 = client.field324.method2526();
               var2 = client.field324.method2534();
               var3 = class29.method645(var2);
               if(var3.field2788 != 2 || var3.field2830 != var31) {
                  var3.field2788 = 2;
                  var3.field2830 = var31;
                  class34.method701(var3);
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 240) {
               client.field558 = false;

               for(var31 = 0; var31 < 5; ++var31) {
                  client.field528[var31] = false;
               }

               client.field326 = -1;
               return true;
            }

            int var13;
            class122 var42;
            int var56;
            String var58;
            int var66;
            String var67;
            int var80;
            if(client.field326 == 207) {
               var42 = client.field324;
               var2 = client.field325;
               class210 var91 = new class210();
               var91.field3140 = var42.method2492();
               var91.field3136 = var42.method2497();
               var91.field3134 = new int[var91.field3140];
               var91.field3135 = new int[var91.field3140];
               var91.field3133 = new Field[var91.field3140];
               var91.field3137 = new int[var91.field3140];
               var91.field3138 = new Method[var91.field3140];
               var91.field3139 = new byte[var91.field3140][][];

               for(var4 = 0; var4 < var91.field3140; ++var4) {
                  try {
                     var5 = var42.method2492();
                     String var76;
                     if(var5 != 0 && var5 != 1 && var5 != 2) {
                        if(var5 == 3 || var5 == 4) {
                           var58 = var42.method2500();
                           var76 = var42.method2500();
                           var56 = var42.method2492();
                           String[] var74 = new String[var56];

                           for(var66 = 0; var66 < var56; ++var66) {
                              var74[var66] = var42.method2500();
                           }

                           var67 = var42.method2500();
                           byte[][] var90 = new byte[var56][];
                           if(3 == var5) {
                              for(var80 = 0; var80 < var56; ++var80) {
                                 var13 = var42.method2497();
                                 var90[var80] = new byte[var13];
                                 var42.method2503(var90[var80], 0, var13);
                              }
                           }

                           var91.field3134[var4] = var5;
                           Class[] var89 = new Class[var56];

                           for(var13 = 0; var13 < var56; ++var13) {
                              var89[var13] = class179.method3473(var74[var13]);
                           }

                           Class var87 = class179.method3473(var67);
                           if(class179.method3473(var58).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var88 = class179.method3473(var58).getDeclaredMethods();
                           Method[] var92 = var88;

                           for(int var16 = 0; var16 < var92.length; ++var16) {
                              Method var17 = var92[var16];
                              if(var17.getName().equals(var76)) {
                                 Class[] var18 = var17.getParameterTypes();
                                 if(var18.length == var89.length) {
                                    boolean var19 = true;

                                    for(int var20 = 0; var20 < var89.length; ++var20) {
                                       if(var18[var20] != var89[var20]) {
                                          var19 = false;
                                          break;
                                       }
                                    }

                                    if(var19 && var87 == var17.getReturnType()) {
                                       var91.field3138[var4] = var17;
                                    }
                                 }
                              }
                           }

                           var91.field3139[var4] = var90;
                        }
                     } else {
                        var58 = var42.method2500();
                        var76 = var42.method2500();
                        var56 = 0;
                        if(var5 == 1) {
                           var56 = var42.method2497();
                        }

                        var91.field3134[var4] = var5;
                        var91.field3137[var4] = var56;
                        if(class179.method3473(var58).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var91.field3133[var4] = class179.method3473(var58).getDeclaredField(var76);
                     }
                  } catch (ClassNotFoundException var23) {
                     var91.field3135[var4] = -1;
                  } catch (SecurityException var24) {
                     var91.field3135[var4] = -2;
                  } catch (NullPointerException var25) {
                     var91.field3135[var4] = -3;
                  } catch (Exception var26) {
                     var91.field3135[var4] = -4;
                  } catch (Throwable var27) {
                     var91.field3135[var4] = -5;
                  }
               }

               class211.field3143.method3849(var91);
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 195) {
               for(var31 = 0; var31 < class176.field2920.length; ++var31) {
                  if(class176.field2920[var31] != class176.field2918[var31]) {
                     class176.field2920[var31] = class176.field2918[var31];
                     class52.method1069(var31);
                     client.field463[++client.field464 - 1 & 31] = var31;
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 180) {
               var31 = client.field324.method2584();
               var2 = client.field324.method2492();
               var34 = client.field324.method2584();
               class153.method3134(var31, var2, var34);
               client.field326 = -1;
               return true;
            }

            class173 var33;
            if(84 == client.field326) {
               var31 = client.field324.method2536();
               var33 = class29.method645(var31);

               for(var34 = 0; var34 < var33.field2883.length; ++var34) {
                  var33.field2883[var34] = -1;
                  var33.field2883[var34] = 0;
               }

               class34.method701(var33);
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
               var31 = client.field324.method2526();
               class15 var84 = (class15)class15.field204.method3777((long)var31);
               if(var84 != null) {
                  var84.method3898();
               }

               client.field465[++client.field446 - 1 & 31] = var31 & 32767;
               client.field326 = -1;
               return true;
            }

            boolean var11;
            long var57;
            long var63;
            long var68;
            if(client.field326 == 108) {
               var1 = client.field324.method2500();
               var57 = client.field324.method2498();
               var63 = (long)client.field324.method2584();
               var73 = (long)client.field324.method2513();
               class152 var59 = (class152)method1616(class115.method2441(), client.field324.method2492());
               var68 = var73 + (var63 << 32);
               var11 = false;

               for(var80 = 0; var80 < 100; ++var80) {
                  if(client.field382[var80] == var68) {
                     var11 = true;
                     break;
                  }
               }

               if(var59.field2271 && class16.method196(var1)) {
                  var11 = true;
               }

               if(!var11 && client.field358 == 0) {
                  client.field382[client.field530] = var68;
                  client.field530 = (client.field530 + 1) % 100;
                  String var85 = class223.method4001(class34.method711(class152.method3131(client.field324)));
                  if(var59.field2283 != -1) {
                     class52.method1050(9, class156.method3146(var59.field2283) + var1, var85, class34.method710(var57));
                  } else {
                     class52.method1050(9, var1, var85, class34.method710(var57));
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
               var31 = client.field324.method2584();
               class15.method194(client.field324, var31);
               client.field326 = -1;
               return true;
            }

            class173 var81;
            if(client.field326 == 126) {
               var31 = client.field324.method2497();
               var2 = client.field324.method2536();
               class3 var86 = (class3)client.field308.method3777((long)var2);
               var71 = (class3)client.field308.method3777((long)var31);
               if(var71 != null) {
                  class38.method737(var71, null == var86 || var71.field69 != var86.field69);
               }

               if(null != var86) {
                  var86.method3898();
                  client.field308.method3778(var86, (long)var31);
               }

               var81 = class29.method645(var2);
               if(var81 != null) {
                  class34.method701(var81);
               }

               var81 = class29.method645(var31);
               if(var81 != null) {
                  class34.method701(var81);
                  class125.method2796(class217.field3171[var81.field2826 >>> 16], var81, true);
               }

               if(-1 != client.field412) {
                  class87.method2065(client.field412, 1);
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 163) {
               var1 = client.field324.method2500();
               var2 = client.field324.method2535();
               var3 = class29.method645(var2);
               if(!var1.equals(var3.field2825)) {
                  var3.field2825 = var1;
                  class34.method701(var3);
               }

               client.field326 = -1;
               return true;
            }

            if(177 == client.field326) {
               var31 = client.field324.method2527();
               var2 = client.field324.method2533();
               var34 = client.field324.method2534();
               var4 = client.field324.method2584();
               var81 = class29.method645(var34);
               if(var2 != var81.field2816 || var4 != var81.field2817 || var81.field2819 != var31) {
                  var81.field2816 = var2;
                  var81.field2817 = var4;
                  var81.field2819 = var31;
                  class34.method701(var81);
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 157) {
               class26.method616();

               for(var31 = 0; var31 < 2048; ++var31) {
                  client.field491[var31] = null;
               }

               class44.method907(client.field324);
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 36) {
               var31 = client.field324.method2497();
               var2 = client.field324.method2584();
               if(var31 < -70000) {
                  var2 += '耀';
               }

               if(var31 >= 0) {
                  var3 = class29.method645(var31);
               } else {
                  var3 = null;
               }

               for(; client.field324.field2005 < client.field325; class51.method1047(var2, var4, var5 - 1, var6)) {
                  var4 = client.field324.method2505();
                  var5 = client.field324.method2584();
                  var6 = 0;
                  if(var5 != 0) {
                     var6 = client.field324.method2492();
                     if(var6 == 255) {
                        var6 = client.field324.method2497();
                     }
                  }

                  if(var3 != null && var4 >= 0 && var4 < var3.field2883.length) {
                     var3.field2883[var4] = var5;
                     var3.field2884[var4] = var6;
                  }
               }

               if(null != var3) {
                  class34.method701(var3);
               }

               class8.method112();
               client.field465[++client.field446 - 1 & 31] = var2 & 32767;
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
            String var36;
            String var82;
            if(client.field326 == 216) {
               while(client.field324.field2005 < client.field325) {
                  var31 = client.field324.method2492();
                  var32 = (var31 & 1) == 1;
                  var36 = client.field324.method2500();
                  var82 = client.field324.method2500();
                  client.field324.method2500();

                  for(var5 = 0; var5 < client.field550; ++var5) {
                     class7 var60 = client.field344[var5];
                     if(var32) {
                        if(var82.equals(var60.field133)) {
                           var60.field133 = var36;
                           var60.field135 = var82;
                           var36 = null;
                           break;
                        }
                     } else if(var36.equals(var60.field133)) {
                        var60.field133 = var36;
                        var60.field135 = var82;
                        var36 = null;
                        break;
                     }
                  }

                  if(null != var36 && client.field550 < 400) {
                     class7 var77 = new class7();
                     client.field344[client.field550] = var77;
                     var77.field133 = var36;
                     var77.field135 = var82;
                     ++client.field550;
                  }
               }

               client.field470 = client.field462;
               client.field326 = -1;
               return true;
            }

            int var9;
            String var49;
            long var61;
            if(65 == client.field326) {
               var1 = client.field324.method2500();
               class10.field164 = var1;

               try {
                  var37 = client.field276.getParameter(class190.field3070.field3077);
                  var36 = client.field276.getParameter(class190.field3078.field3077);
                  var82 = var37 + "settings=" + var1 + "; version=1; path=/; domain=" + var36;
                  if(var1.length() == 0) {
                     var82 = var82 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
                  } else {
                     var49 = var82 + "; Expires=";
                     var61 = class12.method162() + 94608000000L;
                     class111.field1964.setTime(new Date(var61));
                     var9 = class111.field1964.get(7);
                     var66 = class111.field1964.get(5);
                     int var83 = class111.field1964.get(2);
                     var80 = class111.field1964.get(1);
                     var13 = class111.field1964.get(11);
                     int var14 = class111.field1964.get(12);
                     int var15 = class111.field1964.get(13);
                     var58 = class111.field1963[var9 - 1] + ", " + var66 / 10 + var66 % 10 + "-" + class111.field1966[0][var83] + "-" + var80 + " " + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + ":" + var15 / 10 + var15 % 10 + " GMT";
                     var82 = var49 + var58 + "; Max-Age=" + 94608000L;
                  }

                  client var70 = client.field276;
                  var58 = "document.cookie=\"" + var82 + "\"";
                  JSObject.getWindow(var70).eval(var58);
               } catch (Throwable var22) {
                  ;
               }

               client.field326 = -1;
               return true;
            }

            if(168 == client.field326) {
               class175.method3431(false);
               client.field324.method2738();
               var31 = client.field324.method2584();
               class15.method194(client.field324, var31);
               client.field326 = -1;
               return true;
            }

            if(200 == client.field326) {
               var31 = client.field324.method2536();
               var2 = client.field324.method2526();
               var34 = client.field324.method2526();
               var78 = class29.method645(var31);
               var78.field2821 = (var34 << 16) + var2;
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 130) {
               var31 = client.field324.method2527();
               if('\uffff' == var31) {
                  var31 = -1;
               }

               var2 = client.field324.method2534();
               var34 = client.field324.method2536();
               var78 = class29.method645(var34);
               class51 var65;
               if(!var78.field2764) {
                  if(-1 == var31) {
                     var78.field2788 = 0;
                     client.field326 = -1;
                     return true;
                  }

                  var65 = class9.method128(var31);
                  var78.field2788 = 4;
                  var78.field2830 = var31;
                  var78.field2816 = var65.field1122;
                  var78.field2817 = var65.field1123;
                  var78.field2819 = var65.field1121 * 100 / var2;
                  class34.method701(var78);
               } else {
                  var78.field2885 = var31;
                  var78.field2780 = var2;
                  var65 = class9.method128(var31);
                  var78.field2816 = var65.field1122;
                  var78.field2817 = var65.field1123;
                  var78.field2818 = var65.field1126;
                  var78.field2859 = var65.field1125;
                  var78.field2815 = var65.field1138;
                  var78.field2819 = var65.field1121;
                  if(1 == var65.field1127) {
                     var78.field2823 = 1;
                  } else {
                     var78.field2823 = 2;
                  }

                  if(var78.field2820 > 0) {
                     var78.field2819 = var78.field2819 * 32 / var78.field2820;
                  } else if(var78.field2776 > 0) {
                     var78.field2819 = var78.field2819 * 32 / var78.field2776;
                  }

                  class34.method701(var78);
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 79) {
               var31 = client.field324.method2613();
               var2 = client.field324.method2518();
               var36 = client.field324.method2500();
               if(var2 >= 1 && var2 <= 8) {
                  if(var36.equalsIgnoreCase("null")) {
                     var36 = null;
                  }

                  client.field442[var2 - 1] = var36;
                  client.field294[var2 - 1] = 0 == var31;
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
               var31 = client.field325 + client.field324.field2005;
               var2 = client.field324.method2584();
               var34 = client.field324.method2584();
               if(client.field412 != var2) {
                  client.field412 = var2;
                  class9.method125(false);
                  class156.method3148(client.field412);
                  class16.method198(client.field412);

                  for(var4 = 0; var4 < 100; ++var4) {
                     client.field482[var4] = true;
                  }
               }

               class3 var64;
               for(; var34-- > 0; var64.field68 = true) {
                  var4 = client.field324.method2497();
                  var5 = client.field324.method2584();
                  var6 = client.field324.method2492();
                  var64 = (class3)client.field308.method3777((long)var4);
                  if(var64 != null && var5 != var64.field69) {
                     class38.method737(var64, true);
                     var64 = null;
                  }

                  if(var64 == null) {
                     var64 = class9.method118(var4, var5, var6);
                  }
               }

               for(var71 = (class3)client.field308.method3780(); var71 != null; var71 = (class3)client.field308.method3781()) {
                  if(var71.field68) {
                     var71.field68 = false;
                  } else {
                     class38.method737(var71, true);
                  }
               }

               client.field479 = new class196(512);

               while(client.field324.field2005 < var31) {
                  var4 = client.field324.method2497();
                  var5 = client.field324.method2584();
                  var6 = client.field324.method2584();
                  var55 = client.field324.method2497();

                  for(var56 = var5; var56 <= var6; ++var56) {
                     var68 = ((long)var4 << 32) + (long)var56;
                     client.field479.method3778(new class201(var55), var68);
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 129) {
               var1 = client.field324.method2500();
               var57 = (long)client.field324.method2584();
               var63 = (long)client.field324.method2513();
               class152 var53 = (class152)method1616(class115.method2441(), client.field324.method2492());
               var61 = var63 + (var57 << 32);
               boolean var62 = false;

               for(var66 = 0; var66 < 100; ++var66) {
                  if(client.field382[var66] == var61) {
                     var62 = true;
                     break;
                  }
               }

               if(class16.method196(var1)) {
                  var62 = true;
               }

               if(!var62 && client.field358 == 0) {
                  client.field382[client.field530] = var61;
                  client.field530 = (client.field530 + 1) % 100;
                  var67 = class223.method4001(class34.method711(class152.method3131(client.field324)));
                  byte var75;
                  if(var53.field2280) {
                     var75 = 7;
                  } else {
                     var75 = 3;
                  }

                  if(-1 != var53.field2283) {
                     class125.method2783(var75, class156.method3146(var53.field2283) + var1, var67);
                  } else {
                     class125.method2783(var75, var1, var67);
                  }
               }

               client.field326 = -1;
               return true;
            }

            boolean var38;
            boolean var43;
            if(254 == client.field326) {
               var1 = client.field324.method2500();
               var2 = client.field324.method2584();
               byte var48 = client.field324.method2493();
               var38 = false;
               if(-128 == var48) {
                  var38 = true;
               }

               if(var38) {
                  if(0 == class110.field1959) {
                     client.field326 = -1;
                     return true;
                  }

                  var43 = false;

                  for(var5 = 0; var5 < class110.field1959 && (!class159.field2612[var5].field616.equals(var1) || class159.field2612[var5].field618 != var2); ++var5) {
                     ;
                  }

                  if(var5 < class110.field1959) {
                     while(var5 < class110.field1959 - 1) {
                        class159.field2612[var5] = class159.field2612[var5 + 1];
                        ++var5;
                     }

                     --class110.field1959;
                     class159.field2612[class110.field1959] = null;
                  }
               } else {
                  client.field324.method2500();
                  class24 var54 = new class24();
                  var54.field616 = var1;
                  var54.field617 = class32.method690(var54.field616, class1.field24);
                  var54.field618 = var2;
                  var54.field622 = var48;

                  for(var6 = class110.field1959 - 1; var6 >= 0; --var6) {
                     var55 = class159.field2612[var6].field617.compareTo(var54.field617);
                     if(var55 == 0) {
                        class159.field2612[var6].field618 = var2;
                        class159.field2612[var6].field622 = var48;
                        if(var1.equals(class106.field1881.field59)) {
                           client.field396 = var48;
                        }

                        client.field451 = client.field462;
                        client.field326 = -1;
                        return true;
                     }

                     if(var55 < 0) {
                        break;
                     }
                  }

                  if(class110.field1959 >= class159.field2612.length) {
                     client.field326 = -1;
                     return true;
                  }

                  for(var55 = class110.field1959 - 1; var55 > var6; --var55) {
                     class159.field2612[var55 + 1] = class159.field2612[var55];
                  }

                  if(0 == class110.field1959) {
                     class159.field2612 = new class24[100];
                  }

                  class159.field2612[1 + var6] = var54;
                  ++class110.field1959;
                  if(var1.equals(class106.field1881.field59)) {
                     client.field396 = var48;
                  }
               }

               client.field451 = client.field462;
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 104) {
               var31 = client.field324.method2505();
               var32 = client.field324.method2492() == 1;
               var36 = "";
               var38 = false;
               if(var32) {
                  var36 = client.field324.method2500();
                  if(class16.method196(var36)) {
                     var38 = true;
                  }
               }

               var49 = client.field324.method2500();
               if(!var38) {
                  class125.method2783(var31, var36, var49);
               }

               client.field326 = -1;
               return true;
            }

            if(125 == client.field326) {
               var1 = client.field324.method2500();
               Object[] var50 = new Object[var1.length() + 1];

               for(var34 = var1.length() - 1; var34 >= 0; --var34) {
                  if(var1.charAt(var34) == 115) {
                     var50[1 + var34] = client.field324.method2500();
                  } else {
                     var50[var34 + 1] = new Integer(client.field324.method2497());
                  }
               }

               var50[0] = new Integer(client.field324.method2497());
               class0 var41 = new class0();
               var41.field12 = var50;
               class16.method197(var41);
               client.field326 = -1;
               return true;
            }

            if(204 == client.field326) {
               var31 = client.field324.method2533();
               if(var31 == '\uffff') {
                  var31 = -1;
               }

               class77.method1660(var31);
               client.field326 = -1;
               return true;
            }

            if(221 == client.field326) {
               var31 = client.field324.method2530();
               var2 = client.field324.method2584();
               if('\uffff' == var2) {
                  var2 = -1;
               }

               class111.method2421(var2, var31);
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
               long var45 = client.field324.method2498();
               client.field504 = class85.method1886(var45);
               class33.field779 = client.field324.method2493();
               var34 = client.field324.method2492();
               if(var34 == 255) {
                  client.field326 = -1;
                  return true;
               }

               class110.field1959 = var34;
               class24[] var51 = new class24[100];

               for(var5 = 0; var5 < class110.field1959; ++var5) {
                  var51[var5] = new class24();
                  var51[var5].field616 = client.field324.method2500();
                  var51[var5].field617 = class32.method690(var51[var5].field616, class1.field24);
                  var51[var5].field618 = client.field324.method2584();
                  var51[var5].field622 = client.field324.method2493();
                  client.field324.method2500();
                  if(var51[var5].field616.equals(class106.field1881.field59)) {
                     client.field396 = var51[var5].field622;
                  }
               }

               var43 = false;
               var55 = class110.field1959;

               while(var55 > 0) {
                  var43 = true;
                  --var55;

                  for(var56 = 0; var56 < var55; ++var56) {
                     if(var51[var56].field617.compareTo(var51[1 + var56].field617) > 0) {
                        class24 var46 = var51[var56];
                        var51[var56] = var51[var56 + 1];
                        var51[1 + var56] = var46;
                        var43 = false;
                     }
                  }

                  if(var43) {
                     break;
                  }
               }

               class159.field2612 = var51;
               client.field326 = -1;
               return true;
            }

            if(161 == client.field326) {
               client.field324.field2005 += 28;
               if(client.field324.method2514()) {
                  var42 = client.field324;
                  var2 = client.field324.field2005 - 28;
                  if(class149.field2242 != null) {
                     try {
                        class149.field2242.method4141(0L);
                        class149.field2242.method4128(var42.field2007, var2, 24);
                     } catch (Exception var21) {
                        ;
                     }
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 21) {
               while(client.field324.field2005 < client.field325) {
                  var39 = client.field324.method2492() == 1;
                  var37 = client.field324.method2500();
                  var36 = client.field324.method2500();
                  var4 = client.field324.method2584();
                  var5 = client.field324.method2492();
                  var6 = client.field324.method2492();
                  boolean var47 = 0 != (var6 & 2);
                  boolean var8 = 0 != (var6 & 1);
                  if(var4 > 0) {
                     client.field324.method2500();
                     client.field324.method2492();
                     client.field324.method2497();
                  }

                  client.field324.method2500();

                  for(var9 = 0; var9 < client.field499; ++var9) {
                     class17 var10 = client.field548[var9];
                     if(!var39) {
                        if(var37.equals(var10.field247)) {
                           if(var4 != var10.field244) {
                              var11 = true;

                              for(class38 var12 = (class38)client.field316.method3764(); null != var12; var12 = (class38)client.field316.method3765()) {
                                 if(var12.field875.equals(var37)) {
                                    if(var4 != 0 && var12.field874 == 0) {
                                       var12.method3894();
                                       var11 = false;
                                    } else if(var4 == 0 && 0 != var12.field874) {
                                       var12.method3894();
                                       var11 = false;
                                    }
                                 }
                              }

                              if(var11) {
                                 client.field316.method3763(new class38(var37, var4));
                              }

                              var10.field244 = var4;
                           }

                           var10.field240 = var36;
                           var10.field237 = var5;
                           var10.field238 = var47;
                           var10.field239 = var8;
                           var33 = null;
                           break;
                        }
                     } else if(var36.equals(var10.field247)) {
                        var10.field247 = var37;
                        var10.field240 = var36;
                        var33 = null;
                        break;
                     }
                  }
               }

               client.field544 = 2;
               client.field470 = client.field462;
               var39 = false;
               var2 = client.field499;

               while(var2 > 0) {
                  var39 = true;
                  --var2;

                  for(var34 = 0; var34 < var2; ++var34) {
                     var38 = false;
                     class17 var40 = client.field548[var34];
                     class17 var44 = client.field548[1 + var34];
                     if(client.field551 != var40.field244 && var44.field244 == client.field551) {
                        var38 = true;
                     }

                     if(!var38 && 0 == var40.field244 && 0 != var44.field244) {
                        var38 = true;
                     }

                     if(!var38 && !var40.field238 && var44.field238) {
                        var38 = true;
                     }

                     if(!var38 && !var40.field239 && var44.field239) {
                        var38 = true;
                     }

                     if(var38) {
                        class17 var52 = client.field548[var34];
                        client.field548[var34] = client.field548[1 + var34];
                        client.field548[var34 + 1] = var52;
                        var39 = false;
                     }
                  }

                  if(var39) {
                     break;
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(client.field326 == 192) {
               var31 = client.field324.method2526();
               var2 = client.field324.method2534();
               var3 = class29.method645(var2);
               if(1 != var3.field2788 || var31 != var3.field2830) {
                  var3.field2788 = 1;
                  var3.field2830 = var31;
                  class34.method701(var3);
               }

               client.field326 = -1;
               return true;
            }

            if(7 == client.field326) {
               var31 = client.field324.method2492();
               if(client.field324.method2492() == 0) {
                  client.field388[var31] = new class220();
                  client.field324.field2005 += 18;
               } else {
                  --client.field324.field2005;
                  client.field388[var31] = new class220(client.field324, false);
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
               var31 = client.field324.method2533();
               var2 = client.field324.method2534();
               var34 = var31 >> 10 & 31;
               var4 = var31 >> 5 & 31;
               var5 = var31 & 31;
               var6 = (var5 << 3) + (var4 << 11) + (var34 << 19);
               class173 var7 = class29.method645(var2);
               if(var6 != var7.field2790) {
                  var7.field2790 = var6;
                  class34.method701(var7);
               }

               client.field326 = -1;
               return true;
            }

            if(152 == client.field326) {
               var31 = client.field324.method2526();
               byte var35 = client.field324.method2684();
               class176.field2918[var31] = var35;
               if(class176.field2920[var31] != var35) {
                  class176.field2920[var31] = var35;
               }

               class52.method1069(var31);
               client.field463[++client.field464 - 1 & 31] = var31;
               client.field326 = -1;
               return true;
            }

            if(58 == client.field326) {
               var31 = client.field324.method2526();
               var2 = client.field324.method2534();
               var3 = class29.method645(var2);
               if(var3 != null && 0 == var3.field2767) {
                  if(var31 > var3.field2858 - var3.field2781) {
                     var31 = var3.field2858 - var3.field2781;
                  }

                  if(var31 < 0) {
                     var31 = 0;
                  }

                  if(var3.field2787 != var31) {
                     var3.field2787 = var31;
                     class34.method701(var3);
                  }
               }

               client.field326 = -1;
               return true;
            }

            if(164 == client.field326) {
               var31 = client.field324.method2535();
               var33 = class29.method645(var31);
               var33.field2788 = 3;
               var33.field2830 = class106.field1881.field34.method3491();
               class34.method701(var33);
               client.field326 = -1;
               return true;
            }

            if(client.field326 == 38) {
               var31 = client.field324.method2536();
               var32 = client.field324.method2613() == 1;
               var3 = class29.method645(var31);
               if(var32 != var3.field2773) {
                  var3.field2773 = var32;
                  class34.method701(var3);
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
         } catch (IOException var29) {
            class115.method2442();
         } catch (Exception var30) {
            var1 = "" + client.field326 + "," + client.field330 + "," + client.field331 + "," + client.field325 + "," + (class22.field594 + class106.field1881.field866[0]) + "," + (class114.field1981 + class106.field1881.field863[0]) + ",";

            for(var2 = 0; var2 < client.field325 && var2 < 50; ++var2) {
               var1 = var1 + client.field324.field2007[var2] + ",";
            }

            class90.method2067(var1, var30);
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
      int var9;
      int var10;
      int var11;
      if(class31.field744) {
         if(1 == class140.field2159 || !class89.field1563 && class140.field2159 == 4) {
            var1 = class31.field748 + 280;
            if(class140.field2169 >= var1 && class140.field2169 <= 14 + var1 && class140.field2170 >= 4 && class140.field2170 <= 18) {
               class2.method27(0, 0);
            } else if(class140.field2169 >= var1 + 15 && class140.field2169 <= 80 + var1 && class140.field2170 >= 4 && class140.field2170 <= 18) {
               class2.method27(0, 1);
            } else {
               var9 = 390 + class31.field748;
               if(class140.field2169 >= var9 && class140.field2169 <= 14 + var9 && class140.field2170 >= 4 && class140.field2170 <= 18) {
                  class2.method27(1, 0);
               } else if(class140.field2169 >= var9 + 15 && class140.field2169 <= var9 + 80 && class140.field2170 >= 4 && class140.field2170 <= 18) {
                  class2.method27(1, 1);
               } else {
                  var10 = 500 + class31.field748;
                  if(class140.field2169 >= var10 && class140.field2169 <= 14 + var10 && class140.field2170 >= 4 && class140.field2170 <= 18) {
                     class2.method27(2, 0);
                  } else if(class140.field2169 >= 15 + var10 && class140.field2169 <= var10 + 80 && class140.field2170 >= 4 && class140.field2170 <= 18) {
                     class2.method27(2, 1);
                  } else {
                     var11 = 610 + class31.field748;
                     if(class140.field2169 >= var11 && class140.field2169 <= var11 + 14 && class140.field2170 >= 4 && class140.field2170 <= 18) {
                        class2.method27(3, 0);
                     } else if(class140.field2169 >= var11 + 15 && class140.field2169 <= 80 + var11 && class140.field2170 >= 4 && class140.field2170 <= 18) {
                        class2.method27(3, 1);
                     } else if(class140.field2169 >= class31.field748 + 708 && class140.field2170 >= 4 && class140.field2169 <= 50 + 708 + class31.field748 && class140.field2170 <= 20) {
                        class31.field744 = false;
                        class20.field569.method1674(class31.field748, 0);
                        class121.field2016.method1674(382 + class31.field748, 0);
                        class31.field718.method1841(382 + class31.field748 - class31.field718.field1427 / 2, 18);
                     } else if(class31.field747 != -1) {
                        class25 var16 = class25.field636[class31.field747];
                        class90.method2068(var16);
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
               if(client.field285 == 0) {
                  if(1 == class140.field2159 || !class89.field1563 && class140.field2159 == 4) {
                     var1 = 5 + class31.field748;
                     short var2 = 463;
                     byte var3 = 100;
                     byte var4 = 35;
                     if(class140.field2169 >= var1 && class140.field2169 <= var3 + var1 && class140.field2170 >= var2 && class140.field2170 <= var4 + var2) {
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
               var9 = class140.field2169;
               var10 = class140.field2170;
               if(!class89.field1563 && var1 == 4) {
                  var1 = 1;
               }

               short var5;
               String var6;
               if(class31.field732 == 0) {
                  var11 = 180 + class31.field720 - 80;
                  var5 = 291;
                  if(1 == var1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                     var6 = class122.method2758("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws";
                     class103.method2275(var6, true, "openjs", false);
                  }

                  var11 = 180 + class31.field720 + 80;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
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
                  short var12;
                  if(2 == class31.field732) {
                     var12 = 231;
                     var11 = var12 + 30;
                     if(var1 == 1 && var10 >= var11 - 15 && var10 < var11) {
                        class31.field729 = 0;
                     }

                     var11 += 15;
                     if(1 == var1 && var10 >= var11 - 15 && var10 < var11) {
                        class31.field729 = 1;
                     }

                     var11 += 15;
                     var12 = 361;
                     if(1 == var1 && var10 >= var12 - 15 && var10 < var12) {
                        class8.method107("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field732 = 5;
                        return;
                     }

                     int var13 = 180 + class31.field720 - 80;
                     short var14 = 321;
                     if(1 == var1 && var9 >= var13 - 75 && var9 <= var13 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
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

                     var13 = 80 + class31.field720 + 180;
                     if(1 == var1 && var9 >= var13 - 75 && var9 <= var13 + 75 && var10 >= var14 - 20 && var10 <= var14 + 20) {
                        class31.field732 = 0;
                        class31.field737 = "";
                        class31.field740 = "";
                        class87.field1540 = 0;
                        class44.field1035 = "";
                        class31.field739 = true;
                     }

                     while(true) {
                        while(class20.method551()) {
                           boolean var7 = false;

                           for(int var8 = 0; var8 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var8) {
                              if(class109.field1917 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var8)) {
                                 var7 = true;
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

                              if(var7 && class31.field737.length() < 320) {
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

                              if(var7 && class31.field740.length() < 20) {
                                 class31.field740 = class31.field740 + class109.field1917;
                              }
                           }
                        }

                        return;
                     }
                  } else if(class31.field732 == 3) {
                     var11 = 180 + class31.field720;
                     var5 = 276;
                     if(1 == var1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                        class31.field734 = "";
                        class31.field725 = "Enter your username/email & password.";
                        class31.field738 = "";
                        class31.field732 = 2;
                        class31.field729 = 0;
                     }

                     var11 = class31.field720 + 180;
                     var5 = 326;
                     if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                        class8.method107("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
                        class31.field732 = 5;
                        return;
                     }
                  } else {
                     boolean var15;
                     int var17;
                     if(class31.field732 == 4) {
                        var11 = class31.field720 + 180 - 80;
                        var5 = 321;
                        if(1 == var1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
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

                        if(1 == var1 && var9 >= 180 + class31.field720 - 9 && var9 <= class31.field720 + 180 + 130 && var10 >= 263 && var10 <= 296) {
                           class31.field739 = !class31.field739;
                        }

                        if(1 == var1 && var9 >= 180 + class31.field720 - 34 && var9 <= 180 + class31.field720 + 34 && var10 >= 351 && var10 <= 363) {
                           var6 = class122.method2758("secure", true) + "m=totp-authenticator/disableTOTPRequest";
                           class103.method2275(var6, true, "openjs", false);
                        }

                        var11 = 180 + class31.field720 + 80;
                        if(1 == var1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           class31.field732 = 0;
                           class31.field737 = "";
                           class31.field740 = "";
                           class87.field1540 = 0;
                           class44.field1035 = "";
                        }

                        while(class20.method551()) {
                           var15 = false;

                           for(var17 = 0; var17 < "1234567890".length(); ++var17) {
                              if(class109.field1917 == "1234567890".charAt(var17)) {
                                 var15 = true;
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

                              if(var15 && class44.field1035.length() < 6) {
                                 class44.field1035 = class44.field1035 + class109.field1917;
                              }
                           }
                        }
                     } else if(class31.field732 == 5) {
                        var11 = class31.field720 + 180 - 80;
                        var5 = 321;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           class172.method3364();
                           return;
                        }

                        var11 = 80 + class31.field720 + 180;
                        if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= var5 + 20) {
                           class31.field734 = "";
                           class31.field725 = "Enter your username/email & password.";
                           class31.field738 = "";
                           class31.field732 = 2;
                           class31.field729 = 0;
                           class31.field740 = "";
                        }

                        while(class20.method551()) {
                           var15 = false;

                           for(var17 = 0; var17 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".length(); ++var17) {
                              if(class109.field1917 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"£$%^&*()-_=+[{]};:\'@#~,<.>/?\\| ".charAt(var17)) {
                                 var15 = true;
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

                              if(var15 && class31.field737.length() < 320) {
                                 class31.field737 = class31.field737 + class109.field1917;
                              }
                           }
                        }
                     } else if(class31.field732 == 6) {
                        while(true) {
                           do {
                              if(!class20.method551()) {
                                 var12 = 321;
                                 if(var1 == 1 && var10 >= var12 - 20 && var10 <= 20 + var12) {
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

                  var11 = 180 + class31.field720 - 80;
                  var5 = 321;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= 75 + var11 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                     class31.field734 = "";
                     class31.field725 = "Enter your username/email & password.";
                     class31.field738 = "";
                     class31.field732 = 2;
                     class31.field729 = 0;
                  }

                  var11 = 80 + 180 + class31.field720;
                  if(var1 == 1 && var9 >= var11 - 75 && var9 <= var11 + 75 && var10 >= var5 - 20 && var10 <= 20 + var5) {
                     class31.field732 = 0;
                  }
               }

            }
         }
      }
   }
}
