import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class225 implements class134 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -477517981
   )
   public final int field3219;
   @ObfuscatedName("c")
   public static final class225 field3220;
   @ObfuscatedName("n")
   public static final class225 field3221;
   @ObfuscatedName("q")
   public static final class225 field3222;
   @ObfuscatedName("t")
   public static final class225 field3223;
   @ObfuscatedName("d")
   public static final class225 field3224;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2042424991
   )
   final int field3225;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1946751124"
   )
   public int vmethod4163() {
      return this.field3225;
   }

   static {
      field3224 = new class225(0, 0);
      field3220 = new class225(1, 1);
      field3221 = new class225(2, 2);
      field3222 = new class225(3, 3);
      field3223 = new class225(4, 4);
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class225(int var1, int var2) {
      this.field3219 = var1;
      this.field3225 = var2;
   }
}
