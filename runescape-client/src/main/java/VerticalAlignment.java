import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements Enumerated {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3242(2, 0),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3241(1, 1),
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   field3243(0, 2);

   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1688464985
   )
   @Export("value")
   public final int value;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1193385339
   )
   final int field3245;

   VerticalAlignment(int var3, int var4) {
      this.value = var3;
      this.field3245 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "60"
   )
   public int rsOrdinal() {
      return this.field3245;
   }
}
