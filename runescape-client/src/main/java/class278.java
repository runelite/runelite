import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
public class class278 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1285966121
   )
   public int field3726;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2089711821
   )
   public int field3725;

   class278(int var1, int var2, int var3, int var4) {
      this.method4914(var1, var2);
      this.method4913(var3, var4);
   }

   public class278(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "376484171"
   )
   void method4914(int var1, int var2) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1324177647"
   )
   void method4913(int var1, int var2) {
      this.field3726 = var1;
      this.field3725 = var2;
   }
}
