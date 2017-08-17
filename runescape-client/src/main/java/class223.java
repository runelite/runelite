import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
public class class223 {
   @ObfuscatedName("h")
   public static final boolean[] field2836;
   @ObfuscatedName("f")
   public static int[] field2835;

   static {
      field2836 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false};
      field2835 = new int[99];
      int var0 = 0;

      for(int var1 = 0; var1 < 99; ++var1) {
         int var2 = var1 + 1;
         int var3 = (int)((double)var2 + 300.0D * Math.pow(2.0D, (double)var2 / 7.0D));
         var0 += var3;
         field2835[var1] = var0 / 4;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1582605423"
   )
   public static void method4085() {
      while(true) {
         Deque var1 = class237.field3224;
         FileSystem var0;
         synchronized(class237.field3224) {
            var0 = (FileSystem)class237.field3220.popFront();
         }

         if(var0 == null) {
            return;
         }

         var0.data.method4228(var0.index, (int)var0.hash, var0.field3194, false);
      }
   }
}
