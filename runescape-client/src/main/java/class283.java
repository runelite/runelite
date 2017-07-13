import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
public enum class283 implements RSEnum {
   @ObfuscatedName("a")
   field3769(0, 0),
   @ObfuscatedName("j")
   field3766(1, 1),
   @ObfuscatedName("n")
   field3767(2, 2),
   @ObfuscatedName("r")
   field3768(3, 3),
   @ObfuscatedName("v")
   field3765(4, 4);

   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 851980113
   )
   public final int field3770;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 112031373
   )
   final int field3771;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class283(int var3, int var4) {
      this.field3770 = var3;
      this.field3771 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1952293135"
   )
   public int rsOrdinal() {
      return this.field3771;
   }
}
