import java.awt.Image;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class159 implements class112 {
   @ObfuscatedName("g")
   public static final class159 field2625 = new class159(3, 2);
   @ObfuscatedName("qp")
   protected static Image field2626;
   @ObfuscatedName("h")
   public static final class159 field2628 = new class159(2, 3);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1820807673
   )
   public final int field2629;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -738484643
   )
   final int field2630;
   @ObfuscatedName("t")
   public static final class159 field2632 = new class159(0, 0);
   @ObfuscatedName("i")
   public static final class159 field2634 = new class159(1, 1);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-59"
   )
   public int vmethod3145() {
      return this.field2630;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class159(int var1, int var2) {
      this.field2629 = var1;
      this.field2630 = var2;
   }
}
