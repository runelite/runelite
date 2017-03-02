import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class97 implements class158 {
   @ObfuscatedName("i")
   public static final class97 field1624 = new class97(1, 2);
   @ObfuscatedName("t")
   public static final class97 field1625 = new class97(2, 3);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1117347143
   )
   final int field1626;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -2006698951
   )
   public final int field1627;
   @ObfuscatedName("l")
   public static final class97 field1628 = new class97(3, 1);
   @ObfuscatedName("b")
   public static final class97 field1630 = new class97(0, 0);

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int vmethod4183() {
      return this.field1626;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1627 = var1;
      this.field1626 = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1581049138"
   )
   static void method1987() {
      class47.chatLineMap.clear();
      class47.field924.method2383();
      class47.field923.method2529();
      class47.field925 = 0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass18;S)V",
      garbageValue = "256"
   )
   static void method1988(class18 var0) {
      class112.method2151(var0, 200000);
   }
}
