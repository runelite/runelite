import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
public class class294 extends class216 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1249656305
   )
   public int field3748;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public Name field3747;
   @ObfuscatedName("a")
   public short field3749;

   @ObfuscatedSignature(
      signature = "(Lkp;I)V"
   )
   class294(Name var1, int var2) {
      this.field3748 = (int)(class188.currentTimeMs() / 1000L);
      this.field3747 = var1;
      this.field3749 = (short)var2;
   }
}
