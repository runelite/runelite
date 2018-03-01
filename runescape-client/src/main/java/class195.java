import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
public class class195 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1721588775
   )
   static int field2576;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -982817801
   )
   static int field2572;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1031977875
   )
   static int field2574;
   @ObfuscatedName("r")
   static byte[][] field2575;
   @ObfuscatedName("e")
   static byte[][] field2583;
   @ObfuscatedName("y")
   static byte[][] field2573;
   @ObfuscatedName("k")
   static int[] field2578;
   @ObfuscatedName("p")
   static byte[][][] field2579;
   @ObfuscatedName("x")
   public static short[][] field2580;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1575003633
   )
   @Export("canvasHeight")
   public static int canvasHeight;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Ljs;"
   )
   @Export("indexCache3")
   static IndexData indexCache3;

   static {
      field2576 = 0;
      field2572 = 0;
      field2574 = 0;
      field2575 = new byte[1000][];
      field2583 = new byte[250][];
      field2573 = new byte[50][];
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IZB)[B",
      garbageValue = "83"
   )
   static synchronized byte[] method3820(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2576 > 0) {
         var2 = field2575[--field2576];
         field2575[field2576] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2572 > 0) {
         var2 = field2583[--field2572];
         field2583[field2572] = null;
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

      if(field2579 != null) {
         for(int var4 = 0; var4 < field2578.length; ++var4) {
            if(field2578[var4] != var0) {
               if(var0 < field2578[var4]) {
                  ;
               }
            } else if(Item.field1396[var4] > 0) {
               byte[] var3 = field2579[var4][--Item.field1396[var4]];
               field2579[var4][Item.field1396[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }
}
