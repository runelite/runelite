import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
public enum class150 implements RSEnum {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   field2202(1, 0),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   field2203(0, 1),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   field2201(2, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lew;"
   )
   field2204(3, 3);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -179661423
   )
   final int field2199;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -512797031
   )
   public final int field2200;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 177285035
   )
   public static int field2205;

   class150(int var3, int var4) {
      this.field2200 = var3;
      this.field2199 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "316484705"
   )
   public int rsOrdinal() {
      return this.field2199;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lia;I)V",
      garbageValue = "1839814448"
   )
   public static void method2928(IndexDataBase var0) {
      Enum.field3396 = var0;
   }
}
