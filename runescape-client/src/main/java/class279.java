import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
public class class279 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1282865791
   )
   public int field3741;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1224417301
   )
   public int field3742;

   class279(int var1, int var2, int var3, int var4) {
      this.method4864(var1, var2);
      this.method4866(var3, var4);
   }

   public class279(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "65280"
   )
   void method4864(int var1, int var2) {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1987534259"
   )
   void method4866(int var1, int var2) {
      this.field3741 = var1;
      this.field3742 = var2;
   }
}
