import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
public class class64 {
   @ObfuscatedName("la")
   @ObfuscatedSignature(
      signature = "[Lhj;"
   )
   static Widget[] field807;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1629536121"
   )
   static void method1082(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1286[var5] != var0) {
            var2[var4] = World.field1286[var5];
            var3[var4] = World.field1284[var5];
            ++var4;
         }
      }

      World.field1286 = var2;
      World.field1284 = var3;
      Script.method1897(class266.worldList, 0, class266.worldList.length - 1, World.field1286, World.field1284);
   }
}
