import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public final class class89 {
   @ObfuscatedName("ii")
   @ObfuscatedGetter(
      intValue = -10007647
   )
   static int field1555;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1916021239
   )
   int field1556;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -210341587
   )
   int field1557;
   @ObfuscatedName("u")
   boolean field1559 = true;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1673021753
   )
   int field1560;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1740024489
   )
   int field1561;
   @ObfuscatedName("aq")
   static boolean field1563;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -99228613
   )
   int field1564;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -94295523
   )
   int field1566;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-34"
   )
   public static void method2066(Component var0) {
      var0.addMouseListener(class140.field2158);
      var0.addMouseMotionListener(class140.field2158);
      var0.addFocusListener(class140.field2158);
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class89(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1560 = var1;
      this.field1556 = var2;
      this.field1557 = var3;
      this.field1564 = var4;
      this.field1566 = var5;
      this.field1561 = var6;
      this.field1559 = var7;
   }
}
