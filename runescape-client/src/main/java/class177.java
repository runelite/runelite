import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class177 implements class158 {
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -813090975
   )
   public final int field2641;
   @ObfuscatedName("x")
   static final class177 field2642 = new class177(1, 0, true, true, true);
   @ObfuscatedName("i")
   static final class177 field2643 = new class177(2, 1, true, true, false);
   @ObfuscatedName("a")
   static final class177 field2644 = new class177(3, 2, false, false, true);
   @ObfuscatedName("f")
   static final class177 field2645 = new class177(4, 3, false, false, true);
   @ObfuscatedName("c")
   static final class177 field2646 = new class177(5, 10, false, false, true);
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1430560177
   )
   final int field2647;
   @ObfuscatedName("z")
   public final boolean field2648;
   @ObfuscatedName("g")
   public final boolean field2649;
   @ObfuscatedName("u")
   static final class177 field2650 = new class177(0, -1, true, false, true);

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "1"
   )
   public int vmethod4062() {
      return this.field2647;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class177(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2647 = var1;
      this.field2641 = var2;
      this.field2649 = var4;
      this.field2648 = var5;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)I",
      garbageValue = "482760664"
   )
   public static int method3249(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + XClanMember.method240(var0.charAt(var3));
      }

      return var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)LModIcon;",
      garbageValue = "0"
   )
   public static ModIcon method3250() {
      ModIcon var0 = new ModIcon();
      var0.width = class225.field3214;
      var0.originalHeight = class202.field3060;
      var0.offsetX = class225.field3213[0];
      var0.offsetY = class225.field3216[0];
      var0.originalWidth = class225.field3217[0];
      var0.height = class178.field2653[0];
      var0.palette = class225.field3218;
      var0.pixels = class119.field1845[0];
      class225.field3213 = null;
      class225.field3216 = null;
      class225.field3217 = null;
      class178.field2653 = null;
      class225.field3218 = null;
      class119.field1845 = (byte[][])null;
      return var0;
   }
}
