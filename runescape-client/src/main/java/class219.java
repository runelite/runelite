import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class219 implements class218 {
   @ObfuscatedName("gq")
   static SpritePixels field2788;
   @ObfuscatedName("e")
   public static final class219 field2789;
   @ObfuscatedName("c")
   public static final class219 field2790;
   @ObfuscatedName("b")
   public static final class219 field2791;
   @ObfuscatedName("y")
   public static final class219 field2792;
   @ObfuscatedName("n")
   public static final class219 field2793;
   @ObfuscatedName("x")
   public static final class219 field2794;
   @ObfuscatedName("f")
   static final class219 field2795;
   @ObfuscatedName("h")
   public static final class219 field2796;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -579863335
   )
   public final int field2797;
   @ObfuscatedName("i")
   public static final class219 field2798;
   @ObfuscatedName("v")
   public static final class219 field2799;

   class219(String var1, int var2, boolean var3, class6[] var4, boolean var5, class6[] var6) {
      this.field2797 = var2;
   }

   class219(String var1, int var2, class6[] var3, class6[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZZ)V",
      garbageValue = "1"
   )
   class219(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (class6[])null, var4, (class6[])null);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-70"
   )
   public int vmethod5009() {
      return this.field2797;
   }

   static {
      field2798 = new class219("", 10);
      field2790 = new class219("", 11);
      field2789 = new class219("", 12);
      field2799 = new class219("", 13);
      field2791 = new class219("", 14);
      field2792 = new class219("", 15, new class6[]{class6.field195, class6.field195}, (class6[])null);
      field2796 = new class219("", 16, new class6[]{class6.field195, class6.field195}, (class6[])null);
      field2794 = new class219("", 17, new class6[]{class6.field195, class6.field195}, (class6[])null);
      field2795 = new class219("", 73, true, true);
      field2793 = new class219("", 76, true, false);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "10"
   )
   class219(String var1, int var2) {
      this(var1, var2, false, (class6[])null, false, (class6[])null);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[Lclass231;",
      garbageValue = "-1746239288"
   )
   public static class231[] method4055() {
      return new class231[]{class231.field3176, class231.field3178, class231.field3177, class231.field3179};
   }
}
