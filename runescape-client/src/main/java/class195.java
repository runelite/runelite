import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gx")
public class class195 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2023728193
   )
   static int field2572;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 417969381
   )
   static int field2577;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1421004581
   )
   static int field2574;
   @ObfuscatedName("j")
   static byte[][] field2575;
   @ObfuscatedName("k")
   static byte[][] field2576;
   @ObfuscatedName("x")
   static byte[][] field2573;
   @ObfuscatedName("w")
   public static byte[][][] field2578;

   static {
      field2572 = 0;
      field2577 = 0;
      field2574 = 0;
      field2575 = new byte[1000][];
      field2576 = new byte[250][];
      field2573 = new byte[50][];
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IZB)[B",
      garbageValue = "3"
   )
   static synchronized byte[] method3742(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2572 > 0) {
         var2 = field2575[--field2572];
         field2575[field2572] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2577 > 0) {
         var2 = field2576[--field2577];
         field2576[field2577] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(field2574 > 0) {
         var2 = field2573[--field2574];
         field2573[field2574] = null;
         return var2;
      }

      if(field2578 != null) {
         for(int var4 = 0; var4 < PacketNode.field2491.length; ++var4) {
            if(PacketNode.field2491[var4] != var0) {
               if(var0 < PacketNode.field2491[var4]) {
                  ;
               }
            } else if(GrandExchangeEvents.field265[var4] > 0) {
               byte[] var3 = field2578[var4][--GrandExchangeEvents.field265[var4]];
               field2578[var4][GrandExchangeEvents.field265[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "82"
   )
   static void method3750(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1220[var5] != var0) {
            var2[var4] = World.field1220[var5];
            var3[var4] = World.field1224[var5];
            ++var4;
         }
      }

      World.field1220 = var2;
      World.field1224 = var3;
      MapIcon.method574(FaceNormal.worldList, 0, FaceNormal.worldList.length - 1, World.field1220, World.field1224);
   }
}
