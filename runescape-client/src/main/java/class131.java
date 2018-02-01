import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
public class class131 {
   @ObfuscatedName("p")
   @Export("Viewport_containsMouse")
   public static boolean Viewport_containsMouse;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2035121927
   )
   @Export("Viewport_mouseX")
   public static int Viewport_mouseX;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 648497225
   )
   @Export("Viewport_mouseY")
   public static int Viewport_mouseY;
   @ObfuscatedName("s")
   @Export("Viewport_false0")
   public static boolean Viewport_false0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 807624593
   )
   static int field1873;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2074655975
   )
   static int field1869;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -334386227
   )
   static int field1875;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2006995183
   )
   @Export("Viewport_entityCountAtMouse")
   public static int Viewport_entityCountAtMouse;
   @ObfuscatedName("n")
   @Export("Viewport_entityIdsAtMouse")
   public static int[] Viewport_entityIdsAtMouse;

   static {
      Viewport_containsMouse = false;
      Viewport_mouseX = 0;
      Viewport_mouseY = 0;
      Viewport_false0 = false;
      Viewport_entityCountAtMouse = 0;
      Viewport_entityIdsAtMouse = new int[1000];
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[Lfo;",
      garbageValue = "754587895"
   )
   public static ServerPacket[] method2739() {
      return new ServerPacket[]{ServerPacket.field2220, ServerPacket.field2209, ServerPacket.field2207, ServerPacket.field2219, ServerPacket.field2248, ServerPacket.field2203, ServerPacket.field2204, ServerPacket.field2276, ServerPacket.field2206, ServerPacket.field2224, ServerPacket.field2208, ServerPacket.field2244, ServerPacket.field2210, ServerPacket.field2211, ServerPacket.field2212, ServerPacket.field2226, ServerPacket.field2214, ServerPacket.field2215, ServerPacket.field2216, ServerPacket.field2199, ServerPacket.field2218, ServerPacket.field2265, ServerPacket.field2236, ServerPacket.field2201, ServerPacket.field2222, ServerPacket.field2223, ServerPacket.field2217, ServerPacket.field2225, ServerPacket.field2221, ServerPacket.field2227, ServerPacket.field2198, ServerPacket.field2263, ServerPacket.field2230, ServerPacket.field2231, ServerPacket.field2202, ServerPacket.field2239, ServerPacket.field2234, ServerPacket.field2235, ServerPacket.field2228, ServerPacket.field2237, ServerPacket.field2238, ServerPacket.field2232, ServerPacket.field2240, ServerPacket.field2241, ServerPacket.field2229, ServerPacket.field2243, ServerPacket.field2242, ServerPacket.field2268, ServerPacket.field2246, ServerPacket.field2247, ServerPacket.field2200, ServerPacket.field2249, ServerPacket.field2250, ServerPacket.field2251, ServerPacket.field2252, ServerPacket.field2213, ServerPacket.field2254, ServerPacket.field2253, ServerPacket.field2256, ServerPacket.field2257, ServerPacket.field2258, ServerPacket.field2255, ServerPacket.field2260, ServerPacket.field2261, ServerPacket.field2262, ServerPacket.field2233, ServerPacket.field2264, ServerPacket.field2205, ServerPacket.field2266, ServerPacket.field2259, ServerPacket.field2245, ServerPacket.field2269, ServerPacket.field2270, ServerPacket.field2271, ServerPacket.field2272, ServerPacket.field2273, ServerPacket.field2274, ServerPacket.field2275, ServerPacket.field2267, ServerPacket.field2277, ServerPacket.field2278};
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ljd;",
      garbageValue = "-16711936"
   )
   public static class263 method2740(int var0) {
      class263 var1 = (class263)class263.field3453.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class263.field3455.getConfigData(34, var0);
         var1 = new class263();
         if(var2 != null) {
            var1.method4709(new Buffer(var2));
         }

         var1.method4713();
         class263.field3453.put(var1, (long)var0);
         return var1;
      }
   }
}
