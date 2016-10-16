import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1629661899
   )
   int field1803;
   @ObfuscatedName("t")
   int[] field1804;
   @ObfuscatedName("y")
   int[][] field1805;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -7333375
   )
   int field1806;

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      signature = "(LActor;II)V",
      garbageValue = "-687348725"
   )
   static final void method2258(Actor var0, int var1) {
      class158.method3156(var0.x, var0.y, var1);
   }

   FrameMap(int var1, byte[] var2) {
      this.field1806 = var1;
      Buffer var3 = new Buffer(var2);
      this.field1803 = var3.method2481();
      this.field1804 = new int[this.field1803];
      this.field1805 = new int[this.field1803][];

      int var4;
      for(var4 = 0; var4 < this.field1803; ++var4) {
         this.field1804[var4] = var3.method2481();
      }

      for(var4 = 0; var4 < this.field1803; ++var4) {
         this.field1805[var4] = new int[var3.method2481()];
      }

      for(var4 = 0; var4 < this.field1803; ++var4) {
         for(int var5 = 0; var5 < this.field1805[var4].length; ++var5) {
            this.field1805[var4][var5] = var3.method2481();
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1500866454"
   )
   public static void method2259() {
      Object var0 = class173.field2762;
      synchronized(class173.field2762) {
         if(class173.field2759 != 0) {
            class173.field2759 = 1;

            try {
               class173.field2762.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "998331415"
   )
   public static boolean method2260() {
      try {
         if(class186.field3002 == 2) {
            if(class132.field2090 == null) {
               class132.field2090 = class183.method3506(XItemContainer.field200, class186.field3003, class186.field3004);
               if(class132.field2090 == null) {
                  return false;
               }
            }

            if(class130.field2083 == null) {
               class130.field2083 = new class62(class186.field3001, class186.field3008);
            }

            if(class186.field3007.method3622(class132.field2090, class186.field3000, class130.field2083, 22050)) {
               class186.field3007.method3584();
               class186.field3007.method3617(class186.field3005);
               class186.field3007.method3586(class132.field2090, class186.field3006);
               class186.field3002 = 0;
               class132.field2090 = null;
               class130.field2083 = null;
               XItemContainer.field200 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class186.field3007.method3587();
         class186.field3002 = 0;
         class132.field2090 = null;
         class130.field2083 = null;
         XItemContainer.field200 = null;
      }

      return false;
   }
}
