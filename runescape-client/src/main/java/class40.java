import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class40 implements class165 {
   @ObfuscatedName("o")
   static final class40 field808 = new class40(2);
   @ObfuscatedName("r")
   static final class40 field810 = new class40(3);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -489158683
   )
   final int field811;
   @ObfuscatedName("y")
   static final class40 field817 = new class40(1);
   @ObfuscatedName("k")
   static final class40 field818 = new class40(0);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-505678853"
   )
   public int vmethod4057() {
      return this.field811;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "38"
   )
   static final int method771(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) + ((var1 & '\uff00') * var2 + var3 * (var0 & '\uff00') & 16711680) >> 8;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "0"
   )
   class40(int var1) {
      this.field811 = var1;
   }
}
