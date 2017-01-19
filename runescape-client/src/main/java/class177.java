import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class177 implements class158 {
   @ObfuscatedName("c")
   static final class177 field2668 = new class177(1, 0, true, true, true);
   @ObfuscatedName("f")
   static final class177 field2670 = new class177(2, 1, true, true, false);
   @ObfuscatedName("h")
   static final class177 field2671 = new class177(3, 2, false, false, true);
   @ObfuscatedName("a")
   static final class177 field2672 = new class177(4, 3, false, false, true);
   @ObfuscatedName("g")
   static final class177 field2673 = new class177(5, 10, false, false, true);
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -279020001
   )
   final int field2674;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1650786381
   )
   public final int field2675;
   @ObfuscatedName("b")
   public final boolean field2676;
   @ObfuscatedName("x")
   public final boolean field2677;
   @ObfuscatedName("s")
   static final class177 field2678 = new class177(0, -1, true, false, true);

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "17064"
   )
   public int vmethod3916() {
      return this.field2674;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class177(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2674 = var1;
      this.field2675 = var2;
      this.field2676 = var4;
      this.field2677 = var5;
   }
}
