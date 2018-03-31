import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
public class class308 extends class221 {
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      signature = "Lez;"
   )
   @Export("region")
   static Region region;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -454494735
   )
   public int field3868;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lko;"
   )
   public Name field3865;
   @ObfuscatedName("k")
   public short field3866;

   @ObfuscatedSignature(
      signature = "(Lko;I)V"
   )
   class308(Name var1, int var2) {
      this.field3868 = (int)(ScriptVarType.method28() / 1000L);
      this.field3865 = var1;
      this.field3866 = (short)var2;
   }
}
