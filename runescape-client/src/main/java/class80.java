import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ct")
@Implements("BufferProvider")
public abstract class class80 {
   @ObfuscatedName("e")
   @Export("pixels")
   public int[] field1467;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 949312787
   )
   @Export("width")
   public int field1468;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1977405087
   )
   @Export("height")
   int field1469;
   @ObfuscatedName("l")
   @Export("image")
   public Image field1470;
   @ObfuscatedName("v")
   public static class227 field1473;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;III)V",
      garbageValue = "85277585"
   )
   public abstract void vmethod1959(Graphics var1, int var2, int var3);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Graphics;IIIIS)V",
      garbageValue = "10294"
   )
   public abstract void vmethod1960(Graphics var1, int var2, int var3, int var4, int var5);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1228218293"
   )
   public static void method1774(int var0) {
      if(class186.field3004 != 0) {
         class40.field903 = var0;
      } else {
         class186.field3007.method3653(var0);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;B)V",
      garbageValue = "-60"
   )
   abstract void vmethod1969(int var1, int var2, Component var3);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILclass170;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-269318697"
   )
   public static void method1781(int var0, class170 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3319(var2);
      int var7 = var1.method3368(var6, var3);
      class186.field3004 = 1;
      class128.field2089 = var1;
      class105.field1834 = var6;
      class186.field3009 = var7;
      class40.field903 = var4;
      class133.field2111 = var5;
      class186.field3010 = var0;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1024590987"
   )
   public final void method1782() {
      class82.method1873(this.field1467, this.field1468, this.field1469);
   }
}
