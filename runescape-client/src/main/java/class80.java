import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("BufferProvider")
public abstract class class80 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 749899811
   )
   @Export("width")
   public int field1459;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2048177747
   )
   @Export("height")
   int field1461;
   @ObfuscatedName("a")
   @Export("image")
   public Image field1462;
   @ObfuscatedName("c")
   @Export("pixels")
   public int[] field1464;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)V",
      garbageValue = "2003148099"
   )
   public abstract void vmethod1966(int var1, int var2, Component var3);

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   public final void method1776() {
      class82.method1932(this.field1464, this.field1459, this.field1461);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "462088111"
   )
   public abstract void vmethod1975(Graphics var1, int var2, int var3);

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIB)V",
      garbageValue = "30"
   )
   public abstract void vmethod1968(Graphics var1, int var2, int var3, int var4, int var5);
}
