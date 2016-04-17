import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class159 implements class112 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 867842175
   )
   final int field2589;
   @ObfuscatedName("w")
   public static final class159 field2590 = new class159(0, 1);
   @ObfuscatedName("c")
   public static final class159 field2591 = new class159(1, 3);
   @ObfuscatedName("a")
   public static final class159 field2592 = new class159(2, 0);
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1911989683
   )
   public final int field2593;
   @ObfuscatedName("d")
   public static final class159 field2596 = new class159(3, 2);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1405875737"
   )
   public int vmethod3266() {
      return this.field2589;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)Z",
      garbageValue = "-29"
   )
   public static final boolean method3267(String var0, String var1, String var2, String var3) {
      return var0 != null && null != var2?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "2"
   )
   class159(int var1, int var2) {
      this.field2593 = var1;
      this.field2589 = var2;
   }
}
