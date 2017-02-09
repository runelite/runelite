import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public abstract class class119 {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1915939163
   )
   public int field1846;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1779926033
   )
   public int field1847;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1153052327
   )
   public int field1848;
   @ObfuscatedName("br")
   static class184 field1849;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1548984237
   )
   public int field1850;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "2140491642"
   )
   public abstract boolean vmethod2275(int var1, int var2, int var3, CollisionData var4);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "([BIIB)I",
      garbageValue = "-62"
   )
   static int method2279(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2259[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-98213361"
   )
   static void method2280(int var0) {
      if(var0 != -1) {
         if(class15.method193(var0)) {
            Widget[] var1 = Widget.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(null != var3.field2130) {
                  class18 var4 = new class18();
                  var4.field190 = var3;
                  var4.field198 = var3.field2130;
                  class99.method1923(var4, 2000000);
               }
            }

         }
      }
   }
}
