import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
public class class97 implements class158 {
   @ObfuscatedName("f")
   public static final class97 field1617 = new class97(0, 2);
   @ObfuscatedName("e")
   public static final class97 field1618 = new class97(1, 1);
   @ObfuscatedName("i")
   public static final class97 field1619 = new class97(3, 0);
   @ObfuscatedName("k")
   public static final class97 field1620 = new class97(2, 3);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -876794511
   )
   public final int field1621;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1509070715
   )
   final int field1622;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2056039019"
   )
   public int vmethod3974() {
      return this.field1622;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1621 = var1;
      this.field1622 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "381227072"
   )
   public static int method1898(int var0) {
      class194 var1 = class25.method555(var0);
      int var2 = var1.field2848;
      int var3 = var1.field2849;
      int var4 = var1.field2852;
      int var5 = class165.field2170[var4 - var3];
      return class165.widgetSettings[var2] >> var3 & var5;
   }
}
