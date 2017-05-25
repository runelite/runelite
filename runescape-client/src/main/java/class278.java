import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
public class class278 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 136267637
   )
   public int field3734;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1989063683
   )
   public int field3735;

   class278(int var1, int var2, int var3, int var4) {
      this.method4976(var1, var2);
      this.method4979(var3, var4);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "945698575"
   )
   void method4976(int var1, int var2) {
   }

   public class278(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1729152106"
   )
   void method4979(int var1, int var2) {
      this.field3735 = var1;
      this.field3734 = var2;
   }
}
