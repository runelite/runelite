import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
@Implements("BufferProvider")
public abstract class BufferProvider {
   @ObfuscatedName("m")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1113917055
   )
   @Export("height")
   int height;
   @ObfuscatedName("h")
   @Export("image")
   public Image image;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1617290727
   )
   @Export("width")
   public int width;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-1"
   )
   public abstract void init(int var1, int var2, Component var3);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "958654020"
   )
   public abstract void drawSub(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1193407075"
   )
   public final void method3985() {
      class219.setRasterBuffer(this.pixels, this.width, this.height);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "-855827731"
   )
   public abstract void draw(Graphics var1, int var2, int var3);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)LMessageNode;",
      garbageValue = "750158672"
   )
   static MessageNode method3988(int var0, int var1) {
      ChatLineBuffer var2 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var0));
      return var2.method890(var1);
   }
}
