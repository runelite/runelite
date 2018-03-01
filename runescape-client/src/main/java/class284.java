import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jz")
public enum class284 implements Enumerated {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   field3700(2, 0),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   field3696(1, 1),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljz;"
   )
   field3695(0, 2);

   @ObfuscatedName("om")
   @ObfuscatedSignature(
      signature = "Ldg;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 774622127
   )
   public static int field3699;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1113098479
   )
   public final int field3698;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 670969701
   )
   final int field3697;

   class284(int var3, int var4) {
      this.field3698 = var3;
      this.field3697 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "846888120"
   )
   public int rsOrdinal() {
      return this.field3697;
   }
}
