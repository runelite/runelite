import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
public class class278 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1329353221
   )
   public int field3739;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -156855171
   )
   public int field3740;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1866928433"
   )
   void method4898(int var1, int var2) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-194901966"
   )
   void method4901(int var1, int var2) {
      this.field3739 = var1;
      this.field3740 = var2;
   }

   class278(int var1, int var2, int var3, int var4) {
      this.method4898(var1, var2);
      this.method4901(var3, var4);
   }

   public class278(int var1, int var2) {
      this(0, 0, var1, var2);
   }
}
