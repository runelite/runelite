import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
public class class278 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -867301261
   )
   public int field3744;
   @ObfuscatedName("y")
   public static int[] field3745;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 691711281
   )
   public int field3746;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   void method4906(int var1, int var2) {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2038940911"
   )
   void method4907(int var1, int var2) {
      this.field3746 = var1;
      this.field3744 = var2;
   }

   class278(int var1, int var2, int var3, int var4) {
      this.method4906(var1, var2);
      this.method4907(var3, var4);
   }

   public class278(int var1, int var2) {
      this(0, 0, var1, var2);
   }
}
