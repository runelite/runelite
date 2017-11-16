import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
public class class133 {
   @ObfuscatedName("b")
   public static boolean field1903;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1942696395
   )
   static int field1900;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1393692891
   )
   static int field1906;
   @ObfuscatedName("g")
   static boolean field1908;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -720744231
   )
   static int field1904;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -571131171
   )
   static int field1905;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1851971339
   )
   static int field1901;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 435464835
   )
   public static int field1907;
   @ObfuscatedName("j")
   public static int[] field1902;

   static {
      field1903 = false;
      field1900 = 0;
      field1906 = 0;
      field1908 = false;
      field1907 = 0;
      field1902 = new int[1000];
   }

   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-94"
   )
   static void method2596() {
      Client.field905.method1868();
      Client.field905.field1461.offset = 0;
      Client.field905.serverPacket = null;
      Client.field905.field1467 = null;
      Client.field905.field1468 = null;
      Client.field905.field1459 = null;
      Client.field905.packetLength = 0;
      Client.field905.field1457 = 0;
      Client.field910 = 0;
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.field1108 = 0;
      Client.destinationX = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         Client.cachedPlayers[var0] = null;
      }

      class275.localPlayer = null;

      for(var0 = 0; var0 < Client.cachedNPCs.length; ++var0) {
         NPC var1 = Client.cachedNPCs[var0];
         if(var1 != null) {
            var1.interacting = -1;
            var1.field1187 = false;
         }
      }

      class17.method121();
      class2.setGameState(30);

      for(var0 = 0; var0 < 100; ++var0) {
         Client.field1052[var0] = true;
      }

      World.method1560();
   }
}
