import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class class202 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 948592083
   )
   int field2466;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1126528825
   )
   int field2461;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -838967553
   )
   int field2465;
   @ObfuscatedName("d")
   byte[] field2462;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -825601429
   )
   int field2460;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 290497403
   )
   int field2464;
   @ObfuscatedName("q")
   byte[] field2459;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1508733483
   )
   int field2467;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 481855359
   )
   int field2463;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)[B",
      garbageValue = "-1429102273"
   )
   static byte[] method3687(byte[] var0) {
      int var1 = var0.length;
      byte[] var2 = new byte[var1];
      System.arraycopy(var0, 0, var2, 0, var1);
      return var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1098189942"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      Projectile.addChatMessage(var0, var1, var2, (String)null);
   }
}
