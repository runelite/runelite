import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hb")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("jg")
   @ObfuscatedGetter(
      intValue = -1624607533
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1812031595
   )
   static int field2618;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 92996023
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1162280981
   )
   @Export("worldX")
   public int worldX;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1435309081
   )
   @Export("worldY")
   public int worldY;

   public Coordinates() {
      this.plane = -1;
   }

   public Coordinates(Coordinates var1) {
      this.plane = var1.plane;
      this.worldX = var1.worldX;
      this.worldY = var1.worldY;
   }

   public Coordinates(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   public Coordinates(int var1) {
      if(var1 == -1) {
         this.plane = -1;
      } else {
         this.plane = var1 >> 28 & 3;
         this.worldX = var1 >> 14 & 16383;
         this.worldY = var1 & 16383;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-68"
   )
   public int method3913() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIIB)V",
      garbageValue = "41"
   )
   public void method3912(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LCoordinates;I)Z",
      garbageValue = "1730608390"
   )
   boolean method3914(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method3914((Coordinates)var1));
   }

   public int hashCode() {
      return this.method3913();
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1724632212"
   )
   static final void method3911(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.field1061; ++var4) {
         if(Client.widgetBoundsWidth[var4] + Client.widgetPositionX[var4] > var0 && Client.widgetPositionX[var4] < var0 + var2 && Client.widgetPositionY[var4] + Client.widgetBoundsHeight[var4] > var1 && Client.widgetPositionY[var4] < var3 + var1) {
            Client.field1132[var4] = true;
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BB)LSpritePixels;",
      garbageValue = "1"
   )
   public static final SpritePixels method3928(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var3 * var2];
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
}
