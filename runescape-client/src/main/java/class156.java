import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public abstract class class156 {
   @ObfuscatedName("dv")
   @ObfuscatedGetter(
      intValue = 325499291
   )
   static int field2112;
   @ObfuscatedName("g")
   static boolean field2113 = false;
   @ObfuscatedName("i")
   public static Buffer field2116;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-338686629"
   )
   abstract byte[] vmethod3013();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "8"
   )
   abstract void vmethod3014(byte[] var1);

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass145;I)V",
      garbageValue = "77997746"
   )
   public static void method3023(class145 var0) {
      class210.field3117 = var0;
   }
}
