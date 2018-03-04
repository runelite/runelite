import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kx")
public class class308 extends class221 {
   @ObfuscatedName("as")
   static int[] field3866;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2124611625
   )
   public int field3865;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   public Name field3863;
   @ObfuscatedName("e")
   public short field3864;

   @ObfuscatedSignature(
      signature = "(Lko;I)V"
   )
   class308(Name var1, int var2) {
      this.field3865 = (int)(PendingSpawn.currentTimeMs() / 1000L);
      this.field3863 = var1;
      this.field3864 = (short)var2;
   }
}
