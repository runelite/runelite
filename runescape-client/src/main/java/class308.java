import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
public class class308 extends class221 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 397546375
   )
   public int field3874;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   public Name field3872;
   @ObfuscatedName("l")
   public short field3873;

   @ObfuscatedSignature(
      signature = "(Lkb;I)V"
   )
   class308(Name var1, int var2) {
      this.field3874 = (int)(WorldMapRegion.method465() / 1000L);
      this.field3872 = var1;
      this.field3873 = (short)var2;
   }
}
