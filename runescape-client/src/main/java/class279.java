import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
public class class279 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -924618121
   )
   public int field3724;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 88741947
   )
   public int field3725;

   class279(int var1, int var2, int var3, int var4) {
      this.method4944(var1, var2);
      this.method4946(var3, var4);
   }

   public class279(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "424694992"
   )
   void method4944(int var1, int var2) {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "101"
   )
   void method4946(int var1, int var2) {
      this.field3724 = var1;
      this.field3725 = var2;
   }
}
