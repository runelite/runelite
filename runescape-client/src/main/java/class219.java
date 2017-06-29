import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class219 implements class218 {
   @ObfuscatedName("y")
   public static final class219 field2794;
   @ObfuscatedName("w")
   public static final class219 field2795;
   @ObfuscatedName("a")
   public static final class219 field2796;
   @ObfuscatedName("t")
   public static final class219 field2797;
   @ObfuscatedName("s")
   public static final class219 field2798;
   @ObfuscatedName("r")
   public static final class219 field2799;
   @ObfuscatedName("v")
   public static final class219 field2800;
   @ObfuscatedName("i")
   public static final class219 field2801;
   @ObfuscatedName("j")
   static final class219 field2802;
   @ObfuscatedName("k")
   public static final class219 field2803;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1432960777
   )
   public final int field2804;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IZZ)V",
      garbageValue = "1"
   )
   class219(String var1, int var2, boolean var3, boolean var4) {
      this(var1, var2, var3, (class6[])null, var4, (class6[])null);
   }

   class219(String var1, int var2, boolean var3, class6[] var4, boolean var5, class6[] var6) {
      this.field2804 = var2;
   }

   class219(String var1, int var2, class6[] var3, class6[] var4) {
      this(var1, var2, var3 != null, var3, var4 != null, var4);
   }

   static {
      field2801 = new class219("", 10);
      field2795 = new class219("", 11);
      field2796 = new class219("", 12);
      field2797 = new class219("", 13);
      field2798 = new class219("", 14);
      field2799 = new class219("", 15, new class6[]{class6.field64, class6.field64}, (class6[])null);
      field2800 = new class219("", 16, new class6[]{class6.field64, class6.field64}, (class6[])null);
      field2794 = new class219("", 17, new class6[]{class6.field64, class6.field64}, (class6[])null);
      field2802 = new class219("", 73, true, true);
      field2803 = new class219("", 76, true, false);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1204543302"
   )
   public int rsOrdinal() {
      return this.field2804;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "10"
   )
   class219(String var1, int var2) {
      this(var1, var2, false, (class6[])null, false, (class6[])null);
   }
}
