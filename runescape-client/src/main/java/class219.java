import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public class class219 implements class218 {
   @ObfuscatedName("g")
   public static final class219 field2788;
   @ObfuscatedName("n")
   public static final class219 field2789;
   @ObfuscatedName("p")
   public static final class219 field2790;
   @ObfuscatedName("j")
   public static final class219 field2791;
   @ObfuscatedName("f")
   public static final class219 field2792;
   @ObfuscatedName("m")
   public static final class219 field2793;
   @ObfuscatedName("c")
   public static final class219 field2794;
   @ObfuscatedName("z")
   public static final class219 field2795;
   @ObfuscatedName("h")
   static final class219 field2796;
   @ObfuscatedName("i")
   public static final class219 field2797;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1077419163
   )
   public final int field2799;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1469137335"
   )
   public int vmethod5059() {
      return this.field2799;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZZ)V",
      garbageValue = "1"
   )
   class219(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (class6[])null, var4, (class6[])null);
   }

   static {
      field2789 = new class219("", 10);
      field2790 = new class219("", 11);
      field2797 = new class219("", 12);
      field2791 = new class219("", 13);
      field2792 = new class219("", 14);
      field2793 = new class219("", 15, new class6[]{class6.field124, class6.field124}, (class6[])null);
      field2794 = new class219("", 16, new class6[]{class6.field124, class6.field124}, (class6[])null);
      field2795 = new class219("", 17, new class6[]{class6.field124, class6.field124}, (class6[])null);
      field2796 = new class219("", 73, true, true);
      field2788 = new class219("", 76, true, false);
   }

   class219(String var1, int var2, boolean var3, class6[] var4, boolean var5, class6[] var6) {
      this.field2799 = var2;
   }

   class219(String var1, int var2, class6[] var3, class6[] var4) {
      this(var1, var2, var3 != null, var3, null != var4, var4);
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "10"
   )
   class219(String var1, int var2) {
      this(var1, var2, false, (class6[])null, false, (class6[])null);
   }
}
