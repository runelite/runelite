import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
public enum class284 implements RSEnum {
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   field3752(0, 0),
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   field3753(1, 1),
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   field3757(2, 2),
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   field3755(3, 3),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljp;"
   )
   field3754(4, 4);

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1544766853
   )
   public final int field3756;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -686373895
   )
   final int field3758;

   class284(int var3, int var4) {
      this.field3756 = var3;
      this.field3758 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "316484705"
   )
   public int rsOrdinal() {
      return this.field3758;
   }
}
