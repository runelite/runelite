import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lq")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -238620789
   )
   public int field3862;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1946798317
   )
   public int field3861;

   Bounds(int var1, int var2, int var3, int var4) {
      this.method5647(var1, var2);
      this.method5651(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "430979017"
   )
   void method5647(int var1, int var2) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIS)V",
      garbageValue = "-2707"
   )
   void method5651(int var1, int var2) {
      this.field3862 = var1;
      this.field3861 = var2;
   }
}
