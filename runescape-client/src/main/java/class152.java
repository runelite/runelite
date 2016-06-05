import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class152 implements class112 {
   @ObfuscatedName("g")
   public static final class152 field2290 = new class152(2, 1, true, true, false);
   @ObfuscatedName("t")
   public static final class152 field2291 = new class152(0, -1, true, false, true);
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -965436289
   )
   final int field2292;
   @ObfuscatedName("h")
   public static final class152 field2293 = new class152(3, 2, false, false, true);
   @ObfuscatedName("z")
   public static final class152 field2294 = new class152(4, 3, false, false, true);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1983553145
   )
   public final int field2296;
   @ObfuscatedName("s")
   public final boolean field2297;
   @ObfuscatedName("d")
   public final boolean field2298;
   @ObfuscatedName("i")
   public static final class152 field2299 = new class152(1, 0, true, true, true);
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = -1877613691
   )
   static int field2300;
   @ObfuscatedName("hd")
   @Export("localPlayer")
   static class2 field2301;

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "0"
   )
   class152(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2292 = var1;
      this.field2296 = var2;
      this.field2297 = var4;
      this.field2298 = var5;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-59"
   )
   public int vmethod3145() {
      return this.field2292;
   }
}
