import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
public class class195 {
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1925799121
   )
   static int field2576;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 488390171
   )
   static int field2573;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1337749063
   )
   static int field2574;
   @ObfuscatedName("z")
   static byte[][] field2578;
   @ObfuscatedName("n")
   static byte[][] field2575;
   @ObfuscatedName("l")
   static byte[][] field2580;
   @ObfuscatedName("s")
   static int[] field2572;
   @ObfuscatedName("y")
   static int[] field2579;

   static {
      field2576 = 0;
      field2573 = 0;
      field2574 = 0;
      field2578 = new byte[1000][];
      field2575 = new byte[250][];
      field2580 = new byte[50][];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IZI)[B",
      garbageValue = "2017559262"
   )
   static synchronized byte[] method3810(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2576 > 0) {
         var2 = field2578[--field2576];
         field2578[field2576] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2573 > 0) {
         var2 = field2575[--field2573];
         field2575[field2573] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(field2574 > 0) {
         var2 = field2580[--field2574];
         field2580[field2574] = null;
         return var2;
      }

      if(MilliTimer.field2156 != null) {
         for(int var4 = 0; var4 < field2572.length; ++var4) {
            if(field2572[var4] != var0) {
               if(var0 < field2572[var4]) {
                  ;
               }
            } else if(field2579[var4] > 0) {
               byte[] var3 = MilliTimer.field2156[var4][--field2579[var4]];
               MilliTimer.field2156[var4][field2579[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }
}
