import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("c")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 51813605
   )
   @Export("width")
   public int width;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -242183661
   )
   @Export("height")
   int height;
   @ObfuscatedName("a")
   @Export("image")
   public Image image;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "-2028014659"
   )
   public abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "60372805"
   )
   public final void method3906() {
      Rasterizer2D.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "1036417207"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIS)V",
      garbageValue = "3395"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-1133599261"
   )
   static Class method3914(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }
}
