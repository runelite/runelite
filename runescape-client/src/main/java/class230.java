import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
public class class230 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)Lkd;",
      garbageValue = "-1758826923"
   )
   public static final SpritePixels method4239(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var2 * var3];
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lik;I)V",
      garbageValue = "1488154849"
   )
   public static void method4240(IndexDataBase var0) {
      class222.field2712 = var0;
   }
}
