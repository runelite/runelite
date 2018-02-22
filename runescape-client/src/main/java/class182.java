import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
public class class182 {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static final class182 field2453;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static final class182 field2445;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static final class182 field2447;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static final class182 field2448;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static final class182 field2449;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static final class182 field2450;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static final class182 field2456;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static final class182 field2455;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static final class182 field2451;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgt;"
   )
   public static final class182 field2452;

   static {
      field2453 = new class182(3);
      field2445 = new class182(5);
      field2447 = new class182(4);
      field2448 = new class182(15);
      field2449 = new class182(5);
      field2450 = new class182(14);
      field2456 = new class182(7);
      field2455 = new class182(6);
      field2451 = new class182(2);
      field2452 = new class182(4);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "3"
   )
   class182(int var1) {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "1146608386"
   )
   static final void method3439(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class7.boundingBoxes.addFirst(new BoundingBox2D(var7, var9, var8, var10, -49088));
   }
}
