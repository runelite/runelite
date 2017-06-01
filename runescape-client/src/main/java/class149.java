import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class149 implements class178 {
   @ObfuscatedName("e")
   public static final class149 field2213;
   @ObfuscatedName("c")
   public static final class149 field2214;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -361698659
   )
   public final int field2215;
   @ObfuscatedName("v")
   public static final class149 field2216;
   @ObfuscatedName("i")
   public static final class149 field2217;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 283909179
   )
   final int field2218;

   static {
      field2217 = new class149(0, 0);
      field2214 = new class149(1, 1);
      field2213 = new class149(2, 2);
      field2216 = new class149(3, 3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int vmethod5009() {
      return this.field2218;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class149(int var1, int var2) {
      this.field2215 = var1;
      this.field2218 = var2;
   }
}
