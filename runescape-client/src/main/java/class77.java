import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("BufferProvider")
public abstract class class77 {
   @ObfuscatedName("y")
   @Export("image")
   public Image field1362;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 682906673
   )
   @Export("width")
   public int field1363;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 177486947
   )
   @Export("height")
   int field1364;
   @ObfuscatedName("j")
   @Export("pixels")
   public int[] field1368;

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-662173642"
   )
   public final void method1685() {
      class79.method1791(this.field1368, this.field1363, this.field1364);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "2144576879"
   )
   public abstract void vmethod1879(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "0"
   )
   public abstract void vmethod1887(Graphics var1, int var2, int var3);

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)Lclass35;",
      garbageValue = "31"
   )
   static class35 method1694(int var0, int var1) {
      class27 var2 = (class27)class11.field166.get(Integer.valueOf(var0));
      return var2.method640(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "1568651033"
   )
   public abstract void vmethod1878(int var1, int var2, Component var3);
}
