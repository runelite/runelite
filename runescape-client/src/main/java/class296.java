import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
public class class296 {
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = -1269709663
   )
   static int field3815;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "-57"
   )
   static byte[] method5513(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }
}
