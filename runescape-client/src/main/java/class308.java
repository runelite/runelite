import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
public class class308 extends class221 {
   @ObfuscatedName("mi")
   @ObfuscatedGetter(
      intValue = 2021021085
   )
   static int field3880;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1100300905
   )
   public int field3877;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   public Name field3878;
   @ObfuscatedName("n")
   public short field3879;

   @ObfuscatedSignature(
      signature = "(Lkb;I)V"
   )
   class308(Name var1, int var2) {
      this.field3877 = (int)(class289.method5267() / 1000L);
      this.field3878 = var1;
      this.field3879 = (short)var2;
   }
}
