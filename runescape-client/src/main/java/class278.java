import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
public class class278 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1574493663
   )
   public int field3742;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2010611039
   )
   public int field3743;

   class278(int var1, int var2, int var3, int var4) {
      this.method4832(var1, var2);
      this.method4833(var3, var4);
   }

   public class278(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "637073341"
   )
   void method4832(int var1, int var2) {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-879460963"
   )
   void method4833(int var1, int var2) {
      this.field3742 = var1;
      this.field3743 = var2;
   }
}
