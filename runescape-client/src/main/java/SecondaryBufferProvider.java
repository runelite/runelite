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
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
@Implements("SecondaryBufferProvider")
public final class SecondaryBufferProvider extends BufferProvider implements ImageProducer, ImageObserver {
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = -877113411
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 562630895
   )
   static int field1430;
   @ObfuscatedName("a")
   public static String field1431;
   @ObfuscatedName("k")
   ColorModel field1432;
   @ObfuscatedName("q")
   ImageConsumer field1434;

   public synchronized void addConsumer(ImageConsumer var1) {
      this.field1434 = var1;
      var1.setDimensions(super.width, super.height);
      var1.setProperties((Hashtable)null);
      var1.setColorModel(this.field1432);
      var1.setHints(14);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass0;I)V",
      garbageValue = "776925187"
   )
   static void method1661(class0 var0) {
      WallObject.method2150(var0, 200000);
   }

   public synchronized boolean isConsumer(ImageConsumer var1) {
      return var1 == this.field1434;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "-98"
   )
   @Export("drawSub")
   public final void drawSub(Graphics var1, int var2, int var3, int var4, int var5) {
      this.method1664(var2, var3, var4, var5);
      Shape var6 = var1.getClip();
      var1.clipRect(var2, var3, var4, var5);
      var1.drawImage(super.image, 0, 0, this);
      var1.setClip(var6);
   }

   public synchronized void removeConsumer(ImageConsumer var1) {
      if(this.field1434 == var1) {
         this.field1434 = null;
      }

   }

   public void startProduction(ImageConsumer var1) {
      this.addConsumer(var1);
   }

   public void requestTopDownLeftRightResend(ImageConsumer var1) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-52"
   )
   synchronized void method1663() {
      if(this.field1434 != null) {
         this.field1434.setPixels(0, 0, super.width, super.height, this.field1432, super.pixels, 0, super.width);
         this.field1434.imageComplete(2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1411313607"
   )
   synchronized void method1664(int var1, int var2, int var3, int var4) {
      if(this.field1434 != null) {
         this.field1434.setPixels(var1, var2, var3, var4, this.field1432, super.pixels, var1 + var2 * super.width, super.width);
         this.field1434.imageComplete(2);
      }
   }

   public boolean imageUpdate(Image var1, int var2, int var3, int var4, int var5, int var6) {
      return true;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "419331807"
   )
   final void init(int var1, int var2, Component var3) {
      super.width = var1;
      super.height = var2;
      super.pixels = new int[1 + var1 * var2];
      this.field1432 = new DirectColorModel(32, 16711680, '\uff00', 255);
      super.image = var3.createImage(this);
      this.method1663();
      var3.prepareImage(super.image, this);
      this.method1663();
      var3.prepareImage(super.image, this);
      this.method1663();
      var3.prepareImage(super.image, this);
      this.method1720();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1167827362"
   )
   public static void method1682() {
      NPCComposition.field903.reset();
      NPCComposition.npcModelCache.reset();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "42"
   )
   @Export("draw")
   public final void draw(Graphics var1, int var2, int var3) {
      this.method1663();
      var1.drawImage(super.image, var2, var3, this);
   }
}
