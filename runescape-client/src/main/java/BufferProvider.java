import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("g")
   @Export("image")
   public Image image;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1781787305
   )
   @Export("width")
   public int width;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 966713999
   )
   @Export("height")
   int height;
   @ObfuscatedName("e")
   @Export("pixels")
   public int[] pixels;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-1084945969"
   )
   public abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1200705536"
   )
   public final void method3954() {
      class219.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "2"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "0"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "476611925"
   )
   public static byte[] method3959(Object var0, boolean var1) {
      if(null == var0) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof class156) {
         class156 var2 = (class156)var0;
         return var2.vmethod2952();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
