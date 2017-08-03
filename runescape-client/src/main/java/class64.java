import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
public class class64 {
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BB)Lji;",
      garbageValue = "-63"
   )
   public static final SpritePixels method1103(byte[] var0) {
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

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "1807291556"
   )
   @Export("isIgnored")
   static boolean isIgnored(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = class9.method48(var0, MouseInput.field715);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class9.method48(var3.name, MouseInput.field715))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class9.method48(var3.previousName, MouseInput.field715))) {
               return true;
            }
         }

         return false;
      }
   }

   @ObfuscatedName("jm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)V",
      garbageValue = "762171443"
   )
   static final void method1102(String var0, int var1) {
      Client.secretPacketBuffer1.putOpcode(251);
      Client.secretPacketBuffer1.putByte(VertexNormal.getLength(var0) + 1);
      Client.secretPacketBuffer1.putString(var0);
      Client.secretPacketBuffer1.method3227(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "751249002"
   )
   static int method1104(int var0) {
      MessageNode var1 = (MessageNode)class98.field1494.get((long)var0);
      return var1 == null?-1:(var1.previous == class98.field1495.field2458?-1:((MessageNode)var1.previous).id);
   }
}
