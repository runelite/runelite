import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
public class class279 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -533984679
   )
   public int field3756;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1938888847
   )
   public int field3754;

   class279(int var1, int var2, int var3, int var4) {
      this.method5023(var1, var2);
      this.method5021(var3, var4);
   }

   public class279(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "355627596"
   )
   void method5023(int var1, int var2) {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "1"
   )
   void method5021(int var1, int var2) {
      this.field3756 = var1;
      this.field3754 = var2;
   }
}
