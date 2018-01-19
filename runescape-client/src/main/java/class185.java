import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class185 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1727850895
   )
   static int field2538;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1882613653
   )
   static int field2535;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2073123387
   )
   static int field2537;
   @ObfuscatedName("r")
   static byte[][] field2536;
   @ObfuscatedName("h")
   static byte[][] field2539;
   @ObfuscatedName("d")
   static byte[][] field2542;
   @ObfuscatedName("b")
   public static int[] field2541;
   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static Widget field2540;

   static {
      field2538 = 0;
      field2535 = 0;
      field2537 = 0;
      field2536 = new byte[1000][];
      field2539 = new byte[250][];
      field2542 = new byte[50][];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IZI)[B",
      garbageValue = "1046412926"
   )
   static synchronized byte[] method3556(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2538 > 0) {
         var2 = field2536[--field2538];
         field2536[field2538] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2535 > 0) {
         var2 = field2539[--field2535];
         field2539[field2535] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(field2537 > 0) {
         var2 = field2542[--field2537];
         field2542[field2537] = null;
         return var2;
      }

      if(class254.field3404 != null) {
         for(int var4 = 0; var4 < Frames.field2042.length; ++var4) {
            if(Frames.field2042[var4] != var0) {
               if(var0 < Frames.field2042[var4]) {
                  ;
               }
            } else if(field2541[var4] > 0) {
               byte[] var3 = class254.field3404[var4][--field2541[var4]];
               class254.field3404[var4][field2541[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(CIS)I",
      garbageValue = "3920"
   )
   public static int method3555(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
