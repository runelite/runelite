import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public abstract class class77 {
   @ObfuscatedName("d")
   public int[] field1393;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2084272227
   )
   public int field1394;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2043611535
   )
   int field1395;
   @ObfuscatedName("k")
   public Image field1396;
   @ObfuscatedName("r")
   static int[] field1397;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "91"
   )
   abstract void vmethod1971(int var1, int var2, Component var3);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIB)V",
      garbageValue = "0"
   )
   public abstract void vmethod1970(Graphics var1, int var2, int var3);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIII)V",
      garbageValue = "-1669287626"
   )
   public abstract void vmethod1972(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "102"
   )
   public final void method1782() {
      class79.method1942(this.field1393, this.field1394, this.field1395);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1707170066"
   )
   static final int method1784(int var0, int var1) {
      int var2 = class1.method9(var0 - 1, var1 - 1) + class1.method9(1 + var0, var1 - 1) + class1.method9(var0 - 1, 1 + var1) + class1.method9(1 + var0, 1 + var1);
      int var3 = class1.method9(var0 - 1, var1) + class1.method9(1 + var0, var1) + class1.method9(var0, var1 - 1) + class1.method9(var0, var1 + 1);
      int var4 = class1.method9(var0, var1);
      return var3 / 8 + var2 / 16 + var4 / 4;
   }
}
