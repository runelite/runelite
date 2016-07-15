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

@ObfuscatedName("ck")
@Implements("SecondaryBufferProvider")
public final class class78 extends class80 implements ImageProducer, ImageObserver {
   @ObfuscatedName("e")
   ColorModel field1442;
   @ObfuscatedName("l")
   ImageConsumer field1443;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-22"
   )
   synchronized void method1694(int var1, int var2, int var3, int var4) {
      if(null != this.field1443) {
         this.field1443.setPixels(var1, var2, var3, var4, this.field1442, super.field1464, var1 + super.field1459 * var2, super.field1459);
         this.field1443.imageComplete(2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "2003148099"
   )
   public final void vmethod1966(int var1, int var2, Component var3) {
      super.field1459 = var1;
      super.field1461 = var2;
      super.field1464 = new int[var1 * var2 + 1];
      this.field1442 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.field1462 = var3.createImage(this);
      this.method1721();
      var3.prepareImage(super.field1462, this);
      this.method1721();
      var3.prepareImage(super.field1462, this);
      this.method1721();
      var3.prepareImage(super.field1462, this);
      this.method1776();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "462088111"
   )
   @Export("draw")
   public final void vmethod1975(Graphics var1, int var2, int var3) {
      this.method1721();
      var1.drawImage(super.field1462, var2, var3, this);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "30"
   )
   @Export("drawSub")
   public final void vmethod1968(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1694(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.field1462, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1443 = var1;
      var1.setDimensions(super.field1459, super.field1461);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1442);
      var1.setHints(14);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return this.field1443 == var1;
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field1443 == var1) {
         this.field1443 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "30"
   )
   @Export("addChatMessage")
   static void method1710(int var0, String var1, String var2, String var3) {
      class29 var4 = (class29)class11.field191.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new class29();
         class11.field191.put(Integer.valueOf(var0), var4);
      }

      class37 var5 = var4.method649(var0, var1, var2, var3);
      class11.field188.method3883(var5, (long)var5.field833);
      class11.field184.method3927(var5);
      client.field308 = client.field506;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "16711680"
   )
   synchronized void method1721() {
      if(null != this.field1443) {
         this.field1443.setPixels(0, 0, super.field1459, super.field1461, this.field1442, super.field1464, 0, super.field1459);
         this.field1443.imageComplete(2);
      }
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([Lclass27;II[I[II)V",
      garbageValue = "-1934482141"
   )
   static void method1732(class27[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = 1 + var2;
         int var7 = (var2 + var1) / 2;
         class27 var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].field684;
                     var12 = var8.field684;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].field677;
                     var12 = var8.field677;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method604()?1:0;
                     var12 = var8.method604()?1:0;
                  } else {
                     var11 = var0[var6].field674;
                     var12 = var8.field674;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].field684;
                     var12 = var8.field684;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].field677;
                     var12 = var8.field677;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method604()?1:0;
                     var12 = var8.method604()?1:0;
                  } else {
                     var11 = var0[var5].field674;
                     var12 = var8.field674;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               class27 var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method1732(var0, var1, var6, var3, var4);
         method1732(var0, 1 + var6, var2, var3, var4);
      }

   }

   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "(Lclass176;I)Z",
      garbageValue = "-1766817060"
   )
   static boolean method1733(class176 var0) {
      if(client.field464) {
         if(class27.method644(var0) != 0) {
            return false;
         }

         if(var0.field2796 == 0) {
            return false;
         }
      }

      return var0.field2814;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1811332947"
   )
   public static void method1734() {
      class176.field2788.method3835();
      class176.field2789.method3835();
      class176.field2893.method3835();
      class176.field2791.method3835();
   }
}
