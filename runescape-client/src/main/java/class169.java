import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fi")
public class class169 {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final class169 field2412;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final class169 field2411;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final class169 field2410;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final class169 field2413;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final class169 field2414;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final class169 field2417;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final class169 field2416;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final class169 field2415;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final class169 field2418;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lfi;"
   )
   public static final class169 field2419;
   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   static Widget field2420;

   static {
      field2412 = new class169(5);
      field2411 = new class169(7);
      field2410 = new class169(14);
      field2413 = new class169(6);
      field2414 = new class169(15);
      field2417 = new class169(3);
      field2416 = new class169(5);
      field2415 = new class169(4);
      field2418 = new class169(2);
      field2419 = new class169(4);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5"
   )
   class169(int var1) {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static void method3187() {
      FileOnDisk var0 = null;

      try {
         var0 = CollisionData.getPreferencesFile("", class41.field528.field3261, true);
         Buffer var1 = Buffer.preferences.serialize();
         var0.write(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method2475(true);
         }
      } catch (Exception var2) {
         ;
      }

   }
}
