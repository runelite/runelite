import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class178 {
   @ObfuscatedName("cx")
   static Font field2670;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1161933149
   )
   public final int field2671;
   @ObfuscatedName("x")
   static final class178 field2672 = new class178("RC", 1);
   @ObfuscatedName("q")
   static final class178 field2673 = new class178("WIP", 2);
   @ObfuscatedName("d")
   public final String field2674;
   @ObfuscatedName("p")
   static final class178 field2676 = new class178("LIVE", 0);
   @ObfuscatedName("g")
   static final class178 field2679 = new class178("BUILDLIVE", 3);

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class178(String var1, int var2) {
      this.field2674 = var1;
      this.field2671 = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "127"
   )
   public static void method3254() {
      Sequence.field3047.reset();
      Sequence.field3050.reset();
   }
}
