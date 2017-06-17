import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
public class class257 implements RSEnum {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1309149023
   )
   final int field3548;
   @ObfuscatedName("m")
   static final class257 field3549;
   @ObfuscatedName("p")
   static final class257 field3550;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1348149273
   )
   public final int field3551;
   @ObfuscatedName("e")
   static final class257 field3552;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "665522131"
   )
   public int rsOrdinal() {
      return this.field3548;
   }

   static {
      field3550 = new class257(2, 0);
      field3549 = new class257(0, 1);
      field3552 = new class257(1, 2);
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class257(int var1, int var2) {
      this.field3551 = var1;
      this.field3548 = var2;
   }
}
