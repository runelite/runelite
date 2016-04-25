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
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Hashtable;
import java.util.Random;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public final class class75 extends class77 implements ImageProducer, ImageObserver {
   @ObfuscatedName("h")
   ImageConsumer field1355;
   @ObfuscatedName("j")
   ColorModel field1356;
   @ObfuscatedName("bb")
   static class80[] field1359;
   @ObfuscatedName("n")
   static class154 field1360;
   @ObfuscatedName("w")
   public static class119 field1361;
   @ObfuscatedName("qs")
   public static class77 field1363;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-1018784558"
   )
   public final void vmethod1872(int var1, int var2, Component var3) {
      super.field1373 = var1;
      super.field1374 = var2;
      super.field1376 = new int[var2 * var1 + 1];
      this.field1356 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1380 = var3.createImage(this);
      this.method1607();
      var3.prepareImage(super.field1380, this);
      this.method1607();
      var3.prepareImage(super.field1380, this);
      this.method1607();
      var3.prepareImage(super.field1380, this);
      this.method1678();
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1355 = var1;
      var1.setDimensions(super.field1373, super.field1374);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1356);
      var1.setHints(14);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "40"
   )
   public final void vmethod1871(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1602(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1380, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field1355 == var1) {
         this.field1355 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "400560759"
   )
   synchronized void method1602(int var1, int var2, int var3, int var4) {
      if(this.field1355 != null) {
         this.field1355.setPixels(var1, var2, var3, var4, this.field1356, super.field1376, super.field1373 * var2 + var1, super.field1373);
         this.field1355.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field1355 == var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1221116847"
   )
   synchronized void method1607() {
      if(this.field1355 != null) {
         this.field1355.setPixels(0, 0, super.field1373, super.field1374, this.field1356, super.field1376, 0, super.field1373);
         this.field1355.imageComplete(2);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "0"
   )
   public final void vmethod1873(Graphics var1, int var2, int var3) {
      this.method1607();
      var1.drawImage(super.field1380, var2, var3, this);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass212;I)Ljava/lang/String;",
      garbageValue = "1518316485"
   )
   public static String method1629(CharSequence var0, class212 var1) {
      if(null == var0) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = 160 == var5 || 32 == var5 || var5 == 95 || 45 == var5;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || 32 == var5 || 95 == var5 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var13 = var3 - var2;
         if(var13 >= 1) {
            byte var6;
            if(null == var1) {
               var6 = 12;
            } else {
               switch(var1.field3152) {
               case 7:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var13 <= var6) {
               StringBuilder var14 = new StringBuilder(var13);

               for(int var15 = var2; var15 < var3; ++var15) {
                  char var7 = var0.charAt(var15);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else {
                     boolean var9 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                     if(var9) {
                        var8 = true;
                     } else {
                        char[] var10 = class164.field2645;
                        int var11 = 0;

                        label156:
                        while(true) {
                           char var12;
                           if(var11 >= var10.length) {
                              var10 = class164.field2647;

                              for(var11 = 0; var11 < var10.length; ++var11) {
                                 var12 = var10[var11];
                                 if(var7 == var12) {
                                    var8 = true;
                                    break label156;
                                 }
                              }

                              var8 = false;
                              break;
                           }

                           var12 = var10[var11];
                           if(var12 == var7) {
                              var8 = true;
                              break;
                           }

                           ++var11;
                        }
                     }
                  }

                  if(var8) {
                     char var16;
                     switch(var7) {
                     case ' ':
                     case '-':
                     case '_':
                     case ' ':
                        var16 = 95;
                        break;
                     case '#':
                     case '[':
                     case ']':
                        var16 = var7;
                        break;
                     case 'À':
                     case 'Á':
                     case 'Â':
                     case 'Ã':
                     case 'Ä':
                     case 'à':
                     case 'á':
                     case 'â':
                     case 'ã':
                     case 'ä':
                        var16 = 97;
                        break;
                     case 'Ç':
                     case 'ç':
                        var16 = 99;
                        break;
                     case 'È':
                     case 'É':
                     case 'Ê':
                     case 'Ë':
                     case 'è':
                     case 'é':
                     case 'ê':
                     case 'ë':
                        var16 = 101;
                        break;
                     case 'Í':
                     case 'Î':
                     case 'Ï':
                     case 'í':
                     case 'î':
                     case 'ï':
                        var16 = 105;
                        break;
                     case 'Ñ':
                     case 'ñ':
                        var16 = 110;
                        break;
                     case 'Ò':
                     case 'Ó':
                     case 'Ô':
                     case 'Õ':
                     case 'Ö':
                     case 'ò':
                     case 'ó':
                     case 'ô':
                     case 'õ':
                     case 'ö':
                        var16 = 111;
                        break;
                     case 'Ù':
                     case 'Ú':
                     case 'Û':
                     case 'Ü':
                     case 'ù':
                     case 'ú':
                     case 'û':
                     case 'ü':
                        var16 = 117;
                        break;
                     case 'ß':
                        var16 = 98;
                        break;
                     case 'ÿ':
                     case 'Ÿ':
                        var16 = 121;
                        break;
                     default:
                        var16 = Character.toLowerCase(var7);
                     }

                     if(var16 != 0) {
                        var14.append(var16);
                     }
                  }
               }

               if(var14.length() == 0) {
                  return null;
               }

               return var14.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(JLjava/lang/String;I)I",
      garbageValue = "-1084025141"
   )
   static final int method1630(long var0, String var2) {
      Random var3 = new Random();
      class119 var4 = new class119(128);
      class119 var5 = new class119(128);
      int[] var6 = new int[]{var3.nextInt(), var3.nextInt(), (int)(var0 >> 32), (int)var0};
      var4.method2503(10);

      int var7;
      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2488(var3.nextInt());
      }

      var4.method2488(var6[0]);
      var4.method2488(var6[1]);
      var4.method2490(var0);
      var4.method2490(0L);

      for(var7 = 0; var7 < 4; ++var7) {
         var4.method2488(var3.nextInt());
      }

      var4.method2519(class9.field153, class9.field154);
      var5.method2503(10);

      for(var7 = 0; var7 < 3; ++var7) {
         var5.method2488(var3.nextInt());
      }

      var5.method2490(var3.nextLong());
      var5.method2619(var3.nextLong());
      byte[] var22 = new byte[24];

      try {
         class149.field2215.method4132(0L);
         class149.field2215.method4109(var22);

         int var8;
         for(var8 = 0; var8 < 24 && 0 == var22[var8]; ++var8) {
            ;
         }

         if(var8 >= 24) {
            throw new IOException();
         }
      } catch (Exception var20) {
         for(int var9 = 0; var9 < 24; ++var9) {
            var22[var9] = -1;
         }
      }

      var5.method2494(var22, 0, 24);
      var5.method2490(var3.nextLong());
      var5.method2519(class9.field153, class9.field154);
      var7 = class116.method2447(var2);
      if(var7 % 8 != 0) {
         var7 += 8 - var7 % 8;
      }

      class119 var21 = new class119(var7);
      var21.method2491(var2);
      var21.field1971 = var7;
      var21.method2515(var6);
      class119 var23 = new class119(var5.field1971 + var4.field1971 + 5 + var21.field1971);
      var23.method2503(2);
      var23.method2503(var4.field1971);
      var23.method2494(var4.field1973, 0, var4.field1971);
      var23.method2503(var5.field1971);
      var23.method2494(var5.field1973, 0, var5.field1971);
      var23.method2486(var21.field1971);
      var23.method2494(var21.field1973, 0, var21.field1971);
      String var10 = class135.method2846(var23.field1973);

      try {
         URL var11 = new URL(class59.method1248("services", false) + "m=accountappeal/login.ws");
         URLConnection var12 = var11.openConnection();
         var12.setDoInput(true);
         var12.setDoOutput(true);
         var12.setConnectTimeout(5000);
         OutputStreamWriter var13 = new OutputStreamWriter(var12.getOutputStream());
         var13.write("data2=" + class156.method3132(var10) + "&dest=" + class156.method3132("passwordchoice.ws"));
         var13.flush();
         InputStream var14 = var12.getInputStream();
         var23 = new class119(new byte[1000]);

         do {
            int var15 = var14.read(var23.field1973, var23.field1971, 1000 - var23.field1971);
            if(var15 == -1) {
               var13.close();
               var14.close();
               String var24 = new String(var23.field1973);
               if(var24.startsWith("OFFLINE")) {
                  return 4;
               } else if(var24.startsWith("WRONG")) {
                  return 7;
               } else if(var24.startsWith("RELOAD")) {
                  return 3;
               } else if(var24.startsWith("Not permitted for social network accounts.")) {
                  return 6;
               } else {
                  var23.method2489(var6);

                  while(var23.field1971 > 0 && 0 == var23.field1973[var23.field1971 - 1]) {
                     --var23.field1971;
                  }

                  var24 = new String(var23.field1973, 0, var23.field1971);
                  boolean var16;
                  if(var24 == null) {
                     var16 = false;
                  } else {
                     label103: {
                        try {
                           new URL(var24);
                        } catch (MalformedURLException var18) {
                           var16 = false;
                           break label103;
                        }

                        var16 = true;
                     }
                  }

                  if(var16) {
                     class46.method970(var24, true, false);
                     return 2;
                  } else {
                     return 5;
                  }
               }
            }

            var23.field1971 += var15;
         } while(var23.field1971 < 1000);

         return 5;
      } catch (Throwable var19) {
         var19.printStackTrace();
         return 5;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass144;I)V",
      garbageValue = "-1928017839"
   )
   static void method1631(class144 var0) {
      if(class140.field2134 == 1 || !class139.field2116 && 4 == class140.field2134) {
         int var1 = 280 + class31.field696;
         if(class140.field2135 >= var1 && class140.field2135 <= 14 + var1 && class140.field2136 >= 4 && class140.field2136 <= 18) {
            class116.method2442(0, 0);
            return;
         }

         if(class140.field2135 >= var1 + 15 && class140.field2135 <= 80 + var1 && class140.field2136 >= 4 && class140.field2136 <= 18) {
            class116.method2442(0, 1);
            return;
         }

         int var2 = class31.field696 + 390;
         if(class140.field2135 >= var2 && class140.field2135 <= var2 + 14 && class140.field2136 >= 4 && class140.field2136 <= 18) {
            class116.method2442(1, 0);
            return;
         }

         if(class140.field2135 >= var2 + 15 && class140.field2135 <= var2 + 80 && class140.field2136 >= 4 && class140.field2136 <= 18) {
            class116.method2442(1, 1);
            return;
         }

         int var3 = class31.field696 + 500;
         if(class140.field2135 >= var3 && class140.field2135 <= 14 + var3 && class140.field2136 >= 4 && class140.field2136 <= 18) {
            class116.method2442(2, 0);
            return;
         }

         if(class140.field2135 >= var3 + 15 && class140.field2135 <= 80 + var3 && class140.field2136 >= 4 && class140.field2136 <= 18) {
            class116.method2442(2, 1);
            return;
         }

         int var4 = 610 + class31.field696;
         if(class140.field2135 >= var4 && class140.field2135 <= 14 + var4 && class140.field2136 >= 4 && class140.field2136 <= 18) {
            class116.method2442(3, 0);
            return;
         }

         if(class140.field2135 >= 15 + var4 && class140.field2135 <= 80 + var4 && class140.field2136 >= 4 && class140.field2136 <= 18) {
            class116.method2442(3, 1);
            return;
         }

         if(class140.field2135 >= class31.field696 + 708 && class140.field2136 >= 4 && class140.field2135 <= 50 + class31.field696 + 708 && class140.field2136 <= 20) {
            class31.field726 = false;
            class186.field3010.method1698(class31.field696, 0);
            class31.field700.method1698(class31.field696 + 382, 0);
            class31.field701.method1867(class31.field696 + 382 - class31.field701.field1403 / 2, 18);
            return;
         }

         if(-1 != class31.field717) {
            class25 var5 = class25.field616[class31.field717];
            class21.method572(var5);
            class31.field726 = false;
            class186.field3010.method1698(class31.field696, 0);
            class31.field700.method1698(class31.field696 + 382, 0);
            class31.field701.method1867(382 + class31.field696 - class31.field701.field1403 / 2, 18);
            return;
         }
      }

   }
}
