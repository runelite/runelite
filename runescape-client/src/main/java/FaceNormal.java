import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1182570493
   )
   @Export("x")
   int x;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -912250773
   )
   @Export("z")
   int z;
   @ObfuscatedName("j")
   public static class72[] field1560;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -918826145
   )
   @Export("y")
   int y;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I[BLclass116;I)V",
      garbageValue = "2049861972"
   )
   static void method1835(int var0, byte[] var1, class116 var2) {
      class180 var3 = new class180();
      var3.field2704 = 0;
      var3.hash = (long)var0;
      var3.field2701 = var1;
      var3.field2702 = var2;
      Deque var4 = class183.field2733;
      synchronized(class183.field2733) {
         class183.field2733.method2333(var3);
      }

      Object var9 = class183.field2732;
      synchronized(class183.field2732) {
         if(class183.field2731 == 0) {
            class22.field252.method1912(new class183(), 5);
         }

         class183.field2731 = 600;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)Lclass186;",
      garbageValue = "-125"
   )
   public static class186 method1836(int var0) {
      class186 var1 = (class186)class186.field2769.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class186.field2774.getConfigData(5, var0);
         var1 = new class186();
         if(null != var2) {
            var1.method3326(new Buffer(var2));
         }

         class186.field2769.put(var1, (long)var0);
         return var1;
      }
   }
}
