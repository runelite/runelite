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
import java.net.Socket;
import java.util.Hashtable;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("by")
public final class class75 extends class77 implements ImageProducer, ImageObserver {
   @ObfuscatedName("w")
   ColorModel field1380;
   @ObfuscatedName("x")
   ImageConsumer field1381;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -511715305
   )
   public static int field1384;

   @ObfuscatedName("l")
   public static String method1600(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(181 != var5 && var5 != 402) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(46 != var5 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("x")
   public final void vmethod1870(Graphics var1, int var2, int var3) {
      this.method1609();
      var1.drawImage(super.field1398, var2, var3, this);
   }

   @ObfuscatedName("t")
   public final void vmethod1871(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1605(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1398, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1381 = var1;
      var1.setDimensions(super.field1396, super.field1397);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1380);
      var1.setHints(14);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field1381) {
         this.field1381 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("e")
   synchronized void method1605(int var1, int var2, int var3, int var4) {
      if(this.field1381 != null) {
         this.field1381.setPixels(var1, var2, var3, var4, this.field1380, super.field1395, super.field1396 * var2 + var1, super.field1396);
         this.field1381.imageComplete(2);
      }
   }

   @ObfuscatedName("p")
   synchronized void method1609() {
      if(null != this.field1381) {
         this.field1381.setPixels(0, 0, super.field1396, super.field1397, this.field1380, super.field1395, 0, super.field1396);
         this.field1381.imageComplete(2);
      }
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field1381;
   }

   @ObfuscatedName("w")
   final void vmethod1869(int var1, int var2, Component var3) {
      super.field1396 = var1;
      super.field1397 = var2;
      super.field1395 = new int[var2 * var1 + 1];
      this.field1380 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1398 = var3.createImage(this);
      this.method1609();
      var3.prepareImage(super.field1398, this);
      this.method1609();
      var3.prepareImage(super.field1398, this);
      this.method1609();
      var3.prepareImage(super.field1398, this);
      this.method1670();
   }

   @ObfuscatedName("bs")
   static final void method1625(String var0, String var1, int var2, int var3, int var4, int var5) {
      if(!client.field433) {
         if(client.field435 < 500) {
            client.field440[client.field435] = var0;
            client.field441[client.field435] = var1;
            client.field448[client.field435] = var2;
            client.field439[client.field435] = var3;
            client.field436[client.field435] = var4;
            client.field437[client.field435] = var5;
            ++client.field435;
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1438242974"
   )
   static final void method1626() {
      try {
         if(client.field327 == 0) {
            if(null != class9.field173) {
               class9.field173.method3005();
               class9.field173 = null;
            }

            class5.field104 = null;
            client.field347 = false;
            client.field328 = 0;
            client.field327 = 1;
         }

         if(1 == client.field327) {
            if(null == class5.field104) {
               class5.field104 = class123.field2036.method2885(class107.field1891, class93.field1607);
            }

            if(class5.field104.field2235 == 2) {
               throw new IOException();
            }

            if(1 == class5.field104.field2235) {
               class9.field173 = new class143((Socket)class5.field104.field2234, class123.field2036);
               class5.field104 = null;
               client.field327 = 2;
            }
         }

         if(2 == client.field327) {
            client.field318.field2011 = 0;
            client.field318.method2573(14);
            class9.field173.method3002(client.field318.field2012, 0, 1);
            client.field528.field2011 = 0;
            client.field327 = 3;
         }

         int var0;
         if(client.field327 == 3) {
            if(null != class17.field253) {
               class17.field253.method1195();
            }

            if(null != class153.field2299) {
               class153.field2299.method1195();
            }

            var0 = class9.field173.method2999();
            if(class17.field253 != null) {
               class17.field253.method1195();
            }

            if(class153.field2299 != null) {
               class153.field2299.method1195();
            }

            if(var0 != 0) {
               class173.method3473(var0);
               return;
            }

            client.field528.field2011 = 0;
            client.field327 = 5;
         }

         int var1;
         int var2;
         if(client.field327 == 5) {
            int[] var11 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            client.field318.field2011 = 0;
            client.field318.method2573(1);
            client.field318.method2573(class31.field736.vmethod3196());
            client.field318.method2494(var11[0]);
            client.field318.method2494(var11[1]);
            client.field318.method2494(var11[2]);
            client.field318.method2494(var11[3]);
            switch(class31.field736.field2627) {
            case 0:
            case 3:
               client.field318.method2653(class33.field778);
               client.field318.field2011 += 5;
               break;
            case 1:
               client.field318.method2494(((Integer)class41.field989.field156.get(Integer.valueOf(class87.method2073(class31.field734)))).intValue());
               client.field318.field2011 += 4;
               break;
            case 2:
               client.field318.field2011 += 8;
            }

            client.field318.method2661(class31.field735);
            client.field318.method2526(class4.field89, class4.field81);
            client.field337.field2011 = 0;
            if(client.field303 == 40) {
               client.field337.method2573(18);
            } else {
               client.field337.method2573(16);
            }

            client.field337.method2492(0);
            var1 = client.field337.field2011;
            client.field337.method2494(110);
            client.field337.method2606(client.field318.field2012, 0, client.field318.field2011);
            var2 = client.field337.field2011;
            client.field337.method2661(class31.field734);
            client.field337.method2573((client.field508?1:0) << 1 | (client.field413?1:0));
            client.field337.method2492(class15.field235);
            client.field337.method2492(class15.field233);
            class122 var3 = client.field337;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class149.field2252.method4169(0L);
               class149.field2252.method4154(var4);

               for(var5 = 0; var5 < 24 && 0 == var4[var5]; ++var5) {
                  ;
               }

               if(var5 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var9) {
               for(int var6 = 0; var6 < 24; ++var6) {
                  var4[var6] = -1;
               }
            }

            var3.method2606(var4, 0, 24);
            client.field337.method2661(class93.field1604);
            client.field337.method2494(class155.field2322);
            class119 var20 = new class119(class14.field224.method3203());
            class14.field224.method3201(var20);
            client.field337.method2606(var20.field2012, 0, var20.field2012.length);
            client.field337.method2573(class82.field1432);
            client.field337.method2494(class148.field2246.field2701);
            client.field337.method2494(class114.field1988.field2701);
            client.field337.method2494(class46.field1076.field2701);
            client.field337.method2494(class22.field608.field2701);
            client.field337.method2494(class47.field1086.field2701);
            client.field337.method2494(class18.field271.field2701);
            client.field337.method2494(class19.field289.field2701);
            client.field337.method2494(class8.field152.field2701);
            client.field337.method2494(class35.field795.field2701);
            client.field337.method2494(class8.field151.field2701);
            client.field337.method2494(class4.field82.field2701);
            client.field337.method2494(class39.field917.field2701);
            client.field337.method2494(class9.field169.field2701);
            client.field337.method2494(class96.field1649.field2701);
            client.field337.method2494(class108.field1913.field2701);
            client.field337.method2494(class82.field1440.field2701);
            client.field337.method2644(var11, var2, client.field337.field2011);
            client.field337.method2589(client.field337.field2011 - var1);
            class9.field173.method3002(client.field337.field2012, 0, client.field337.field2011);
            client.field318.method2749(var11);

            for(var5 = 0; var5 < 4; ++var5) {
               var11[var5] += 50;
            }

            client.field528.method2749(var11);
            client.field327 = 6;
         }

         if(client.field327 == 6 && class9.field173.method3000() > 0) {
            var0 = class9.field173.method2999();
            if(21 == var0 && client.field303 == 20) {
               client.field327 = 7;
            } else if(2 == var0) {
               client.field327 = 9;
            } else if(15 == var0 && client.field303 == 40) {
               client.field339 = -1;
               client.field327 = 13;
            } else if(var0 == 23 && client.field336 < 1) {
               ++client.field336;
               client.field327 = 0;
            } else {
               if(29 != var0) {
                  class173.method3473(var0);
                  return;
               }

               client.field327 = 11;
            }
         }

         if(client.field327 == 7 && class9.field173.method3000() > 0) {
            client.field330 = (class9.field173.method2999() + 3) * 60;
            client.field327 = 8;
         }

         if(8 == client.field327) {
            client.field328 = 0;
            class21.method590("You have only just left another world.", "Your profile will be transferred in:", client.field330 / 60 + " seconds.");
            if(--client.field330 <= 0) {
               client.field327 = 0;
            }

         } else {
            if(client.field327 == 9 && class9.field173.method3000() >= 13) {
               boolean var12 = class9.field173.method2999() == 1;
               class9.field173.method3001(client.field528.field2012, 0, 4);
               client.field528.field2011 = 0;
               boolean var13 = false;
               if(var12) {
                  var1 = client.field528.method2751() << 24;
                  var1 |= client.field528.method2751() << 16;
                  var1 |= client.field528.method2751() << 8;
                  var1 |= client.field528.method2751();
                  var2 = class87.method2073(class31.field734);
                  if(class41.field989.field156.size() >= 10 && !class41.field989.field156.containsKey(Integer.valueOf(var2))) {
                     Iterator var17 = class41.field989.field156.entrySet().iterator();
                     var17.next();
                     var17.remove();
                  }

                  class41.field989.field156.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class11.method152();
               }

               client.field461 = class9.field173.method2999();
               client.field463 = class9.field173.method2999() == 1;
               client.field416 = class9.field173.method2999();
               client.field416 <<= 8;
               client.field416 += class9.field173.method2999();
               client.field409 = class9.field173.method2999();
               class9.field173.method3001(client.field528.field2012, 0, 1);
               client.field528.field2011 = 0;
               client.field301 = client.field528.method2751();
               class9.field173.method3001(client.field528.field2012, 0, 2);
               client.field528.field2011 = 0;
               client.field339 = client.field528.method2508();
               client var15;
               if(client.field409 == 1) {
                  try {
                     var15 = client.field294;
                     JSObject.getWindow(var15).call("zap", (Object[])null);
                  } catch (Throwable var8) {
                     ;
                  }
               } else {
                  try {
                     var15 = client.field294;
                     JSObject.getWindow(var15).call("unzap", (Object[])null);
                  } catch (Throwable var7) {
                     ;
                  }
               }

               client.field327 = 10;
            }

            if(10 == client.field327) {
               if(class9.field173.method3000() >= client.field339) {
                  client.field528.field2011 = 0;
                  class9.field173.method3001(client.field528.field2012, 0, client.field339);
                  class29.method671();
                  class82.method1886(client.field528);
                  class23.field625 = -1;
                  class26.method644(false);
                  client.field301 = -1;
               }

            } else {
               if(11 == client.field327 && class9.field173.method3000() >= 2) {
                  client.field528.field2011 = 0;
                  class9.field173.method3001(client.field528.field2012, 0, 2);
                  client.field528.field2011 = 0;
                  class8.field158 = client.field528.method2508();
                  client.field327 = 12;
               }

               if(client.field327 == 12 && class9.field173.method3000() >= class8.field158) {
                  client.field528.field2011 = 0;
                  class9.field173.method3001(client.field528.field2012, 0, class8.field158);
                  client.field528.field2011 = 0;
                  String var14 = client.field528.method2683();
                  String var16 = client.field528.method2683();
                  String var18 = client.field528.method2683();
                  class21.method590(var14, var16, var18);
                  class138.method2937(10);
               }

               if(client.field327 != 13) {
                  ++client.field328;
                  if(client.field328 > 2000) {
                     if(client.field336 < 1) {
                        if(class93.field1607 == class21.field592) {
                           class93.field1607 = class18.field267;
                        } else {
                           class93.field1607 = class21.field592;
                        }

                        ++client.field336;
                        client.field327 = 0;
                     } else {
                        class173.method3473(-3);
                     }
                  }
               } else {
                  if(client.field339 == -1) {
                     if(class9.field173.method3000() < 2) {
                        return;
                     }

                     class9.field173.method3001(client.field528.field2012, 0, 2);
                     client.field528.field2011 = 0;
                     client.field339 = client.field528.method2508();
                  }

                  if(class9.field173.method3000() >= client.field339) {
                     class9.field173.method3001(client.field528.field2012, 0, client.field339);
                     client.field528.field2011 = 0;
                     var0 = client.field339;
                     client.field318.field2011 = 0;
                     client.field528.field2011 = 0;
                     client.field301 = -1;
                     client.field343 = 1;
                     client.field344 = -1;
                     client.field345 = -1;
                     client.field339 = 0;
                     client.field341 = 0;
                     client.field394 = 0;
                     client.field435 = 0;
                     client.field433 = false;
                     client.field334 = 0;
                     client.field533 = 0;

                     for(var1 = 0; var1 < 2048; ++var1) {
                        client.field415[var1] = null;
                     }

                     class167.field2692 = null;

                     for(var1 = 0; var1 < client.field331.length; ++var1) {
                        class34 var19 = client.field331[var1];
                        if(var19 != null) {
                           var19.field851 = -1;
                           var19.field844 = false;
                        }
                     }

                     class15.field234 = new class196(32);
                     class138.method2937(30);

                     for(var1 = 0; var1 < 100; ++var1) {
                        client.field499[var1] = true;
                     }

                     class56.method1241();
                     class82.method1886(client.field528);
                     if(var0 != client.field528.field2011) {
                        throw new RuntimeException();
                     }
                  }
               }
            }
         }
      } catch (IOException var10) {
         if(client.field336 < 1) {
            if(class21.field592 == class93.field1607) {
               class93.field1607 = class18.field267;
            } else {
               class93.field1607 = class21.field592;
            }

            ++client.field336;
            client.field327 = 0;
         } else {
            class173.method3473(-2);
         }
      }
   }
}
