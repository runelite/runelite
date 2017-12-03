import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
public enum class268 implements Enumerated {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   field3613(0, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   field3614(2, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   field3615(1, 2);

   @ObfuscatedName("db")
   @ObfuscatedGetter(
      intValue = 1266214211
   )
   @Export("myWorldPort")
   static int myWorldPort;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 353127977
   )
   public final int field3616;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1633020473
   )
   final int field3617;

   class268(int var3, int var4) {
      this.field3616 = var3;
      this.field3617 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1035813094"
   )
   public int rsOrdinal() {
      return this.field3617;
   }
}
