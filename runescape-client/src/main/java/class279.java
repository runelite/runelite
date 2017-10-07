import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
public class class279 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1574596097
   )
   public int field3754;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1497636907
   )
   public int field3755;

   class279(int var1, int var2, int var3, int var4) {
      this.method5028(var1, var2);
      this.method5029(var3, var4);
   }

   public class279(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-2015143167"
   )
   void method5028(int var1, int var2) {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   void method5029(int var1, int var2) {
      this.field3754 = var1;
      this.field3755 = var2;
   }
}
