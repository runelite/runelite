import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
public enum class268 implements Enumerated {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   field3625(2, 0),
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   field3622(0, 1),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljo;"
   )
   field3623(1, 2);

   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1507023201
   )
   public final int field3621;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 602754273
   )
   final int field3624;

   class268(int var3, int var4) {
      this.field3621 = var3;
      this.field3624 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "744101166"
   )
   public int rsOrdinal() {
      return this.field3624;
   }
}
