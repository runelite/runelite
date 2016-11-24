import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import java.awt.image.ColorModel;
import java.awt.image.DirectColorModel;
import java.awt.image.ImageConsumer;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("n")
   ColorModel field3192;
   @ObfuscatedName("r")
   ImageConsumer field3193;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -1997198715
   )
   protected static int field3197;

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-38"
   )
   final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[1 + var1 * var2];
      this.field3192 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method4152();
      var3.prepareImage(super.image, this);
      this.method4152();
      var3.prepareImage(super.image, this);
      this.method4152();
      var3.prepareImage(super.image, this);
      this.method4112();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-1512190862"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method4152();
      var1.drawImage(super.image, var2, var3, this);
   }

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field3193 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field3192);
      var1.setHints(14);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(var1 == this.field3193) {
         this.field3193 = null;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "64"
   )
   synchronized void method4150(int var1, int var2, int var3, int var4) {
      if(this.field3193 != null) {
         this.field3193.setPixels(var1, var2, var3, var4, this.field3192, super.pixels, var1 + var2 * super.width, super.width);
         this.field3193.imageComplete(2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1982994138"
   )
   synchronized void method4152() {
      if(this.field3193 != null) {
         this.field3193.setPixels(0, 0, super.width, super.height, this.field3192, super.pixels, 0, super.width);
         this.field3193.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "-40"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method4150(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field3193;
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-928089902"
   )
   static void method4178() {
      try {
         File var0 = new File(Ignore.field211, "random.dat");
         int var2;
         if(var0.exists()) {
            class104.field1689 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         } else {
            label37:
            for(int var1 = 0; var1 < class65.field1105.length; ++var1) {
               for(var2 = 0; var2 < class104.field1685.length; ++var2) {
                  File var3 = new File(class104.field1685[var2] + class65.field1105[var1] + File.separatorChar + "random.dat");
                  if(var3.exists()) {
                     class104.field1689 = new class72(new FileOnDisk(var3, "rw", 25L), 24, 0);
                     break label37;
                  }
               }
            }
         }

         if(class104.field1689 == null) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            class104.field1689 = new class72(new FileOnDisk(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }
}
