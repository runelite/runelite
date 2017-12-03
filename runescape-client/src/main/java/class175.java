import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public class class175 {
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Lev;"
   )
   @Export("socket")
   static Task socket;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BII)I",
      garbageValue = "-1071384032"
   )
   public static int method3182(byte[] var0, int var1) {
      return ClientPacket.method3168(var0, 0, var1);
   }
}
