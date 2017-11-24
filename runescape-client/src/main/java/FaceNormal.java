import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 282292665
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1100016869
   )
   @Export("y")
   int y;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -237826729
   )
   @Export("z")
   int z;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-339386545"
   )
   public static void method2996() {
      Object var0 = class243.field3309;
      synchronized(class243.field3309) {
         if(class243.field3308 != 0) {
            class243.field3308 = 1;

            try {
               class243.field3309.wait();
            } catch (InterruptedException var3) {
               ;
            }
         }

      }
   }
}
