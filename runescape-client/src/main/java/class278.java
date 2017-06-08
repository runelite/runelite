import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
public class class278 {
   @ObfuscatedName("a")
   static Widget field3737;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1743289389
   )
   public int field3738;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2115932207
   )
   public int field3739;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1214023749"
   )
   void method4942(int var1, int var2) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-475401088"
   )
   void method4943(int var1, int var2) {
      this.field3739 = var1;
      this.field3738 = var2;
   }

   class278(int var1, int var2, int var3, int var4) {
      this.method4942(var1, var2);
      this.method4943(var3, var4);
   }

   public class278(int var1, int var2) {
      this(0, 0, var1, var2);
   }
}
