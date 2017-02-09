import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public abstract class class163 {
   @ObfuscatedName("y")
   static boolean field2284 = false;
   @ObfuscatedName("r")
   static int[] field2287;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "2117218087"
   )
   abstract byte[] vmethod3147();

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-2095375693"
   )
   abstract void vmethod3148(byte[] var1);

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Z",
      garbageValue = "-83"
   )
   public static boolean method3149(CharSequence var0) {
      return class181.method3269(var0, 10, true);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "31"
   )
   static String method3157(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1995651403"
   )
   static void method3158() {
      if(class8.loadWorlds()) {
         class41.worldSelectShown = true;
      }

   }
}
