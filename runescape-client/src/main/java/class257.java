import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
public enum class257 implements RSEnum {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   field3545(0, 0),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   field3546(1, 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   field3547(2, 2);

   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1504443569
   )
   final int field3549;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1026947103
   )
   public final int field3551;

   class257(int var3, int var4) {
      this.field3551 = var3;
      this.field3549 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1952293135"
   )
   public int rsOrdinal() {
      return this.field3549;
   }
}
