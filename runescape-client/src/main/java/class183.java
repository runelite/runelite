import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class183 {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final class183 field2484;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final class183 field2489;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final class183 field2482;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final class183 field2490;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final class183 field2481;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final class183 field2485;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final class183 field2486;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final class183 field2487;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final class183 field2488;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   public static final class183 field2483;
   @ObfuscatedName("y")
   @Export("tt")
   static int[] tt;

   static {
      field2484 = new class183(2);
      field2489 = new class183(4);
      field2482 = new class183(7);
      field2490 = new class183(4);
      field2481 = new class183(6);
      field2485 = new class183(15);
      field2486 = new class183(5);
      field2487 = new class183(14);
      field2488 = new class183(5);
      field2483 = new class183(3);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2"
   )
   class183(int var1) {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "1"
   )
   @Export("djb2Hash")
   public static int djb2Hash(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + MessageNode.charToByteCp1252(var0.charAt(var3));
      }

      return var2;
   }
}
