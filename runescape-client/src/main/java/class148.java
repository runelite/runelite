import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ez")
public enum class148 implements Enumerated {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   field2085(1, 0),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   field2083(0, 1),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   field2086(3, 2),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   field2084(2, 3);

   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1832281831
   )
   public final int field2082;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2098358223
   )
   final int field2087;

   class148(int var3, int var4) {
      this.field2082 = var3;
      this.field2087 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "744101166"
   )
   public int rsOrdinal() {
      return this.field2087;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-24"
   )
   static final void method3166(int var0) {
      class131.Viewport_entityIdsAtMouse[++class131.Viewport_entityCountAtMouse - 1] = var0;
   }
}
