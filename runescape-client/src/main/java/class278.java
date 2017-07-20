import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
public class class278 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1430011439
   )
   public int field3726;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 342842465
   )
   public int field3727;

   class278(int var1, int var2, int var3, int var4) {
      this.method4805(var1, var2);
      this.method4800(var3, var4);
   }

   public class278(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1284828894"
   )
   void method4805(int var1, int var2) {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1694379253"
   )
   void method4800(int var1, int var2) {
      this.field3726 = var1;
      this.field3727 = var2;
   }
}
