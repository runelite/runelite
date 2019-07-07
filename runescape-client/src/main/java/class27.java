import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public final class class27 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static AbstractArchive field1143;
   @ObfuscatedName("f")
   final int[] field225;

   class27() {
      this.field225 = new int[4096];
   }

   class27(int[] var1) {
      this.field225 = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-695741813"
   )
   final int method430(int var1, int var2) {
      return this.field225[var1 + var2 * 64];
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)[Lge;",
      garbageValue = "37"
   )
   public static ServerPacket[] method429() {
      return new ServerPacket[]{ServerPacket.field789, ServerPacket.field790, ServerPacket.field791, ServerPacket.field792, ServerPacket.field793, ServerPacket.field794, ServerPacket.field795, ServerPacket.field796, ServerPacket.field797, ServerPacket.field798, ServerPacket.field799, ServerPacket.field800, ServerPacket.field801, ServerPacket.field802, ServerPacket.field803, ServerPacket.field804, ServerPacket.field805, ServerPacket.field806, ServerPacket.field807, ServerPacket.field808, ServerPacket.field809, ServerPacket.field810, ServerPacket.field811, ServerPacket.field812, ServerPacket.field813, ServerPacket.field814, ServerPacket.field815, ServerPacket.field816, ServerPacket.field817, ServerPacket.field818, ServerPacket.field819, ServerPacket.field820, ServerPacket.field821, ServerPacket.field822, ServerPacket.field823, ServerPacket.field824, ServerPacket.field825, ServerPacket.field826, ServerPacket.field827, ServerPacket.field828, ServerPacket.field829, ServerPacket.field830, ServerPacket.field831, ServerPacket.field832, ServerPacket.field833, ServerPacket.field834, ServerPacket.field835, ServerPacket.field836, ServerPacket.field837, ServerPacket.field838, ServerPacket.field839, ServerPacket.field840, ServerPacket.field841, ServerPacket.field842, ServerPacket.field843, ServerPacket.field844, ServerPacket.field845, ServerPacket.field846, ServerPacket.field847, ServerPacket.field848, ServerPacket.field849, ServerPacket.field850, ServerPacket.field851, ServerPacket.field852, ServerPacket.field853, ServerPacket.field854, ServerPacket.field855, ServerPacket.field856, ServerPacket.field857, ServerPacket.field858, ServerPacket.field859, ServerPacket.field860, ServerPacket.field861, ServerPacket.field862, ServerPacket.field863, ServerPacket.field864, ServerPacket.field865, ServerPacket.field866, ServerPacket.field867, ServerPacket.field868, ServerPacket.field869, ServerPacket.field870, ServerPacket.field871, ServerPacket.field872, ServerPacket.field873};
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BI)Lln;",
      garbageValue = "-143338910"
   )
   @Export("convertJpgToSprite")
   public static final Sprite convertJpgToSprite(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var3 * var2];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         return new Sprite(var4, var2, var3);
      } catch (IOException var6) {
      } catch (InterruptedException var7) {
      }

      return new Sprite(0, 0);
   }
}
