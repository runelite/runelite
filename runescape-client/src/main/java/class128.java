import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
public abstract class class128 {
   @ObfuscatedName("e")
   static boolean field2092 = false;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = 614980693
   )
   static int field2093;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)[B",
      garbageValue = "0"
   )
   abstract byte[] vmethod2809();

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "1"
   )
   abstract void vmethod2810(byte[] var1);

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "2"
   )
   public static char method2822(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }
}
