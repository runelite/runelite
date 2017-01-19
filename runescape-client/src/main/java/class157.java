import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class157 {
   @ObfuscatedName("c")
   @Export("validInterfaces")
   static boolean[] validInterfaces;
   @ObfuscatedName("b")
   static ModIcon[] field2129;
   @ObfuscatedName("s")
   public static class182 field2130;
   @ObfuscatedName("et")
   static SpritePixels[] field2131;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "908090067"
   )
   public static void method2950() {
      PlayerComposition.field2184.reset();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)LCombatInfo2;",
      garbageValue = "10"
   )
   public static CombatInfo2 method2951(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field2847.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class6.field73.method3182(33, var0);
         var1 = new CombatInfo2();
         if(null != var2) {
            var1.method3408(new Buffer(var2));
         }

         CombatInfo2.field2847.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "670764753"
   )
   static void method2956(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(var0 != World.field680[var5]) {
            var2[var4] = World.field680[var5];
            var3[var4] = World.field673[var5];
            ++var4;
         }
      }

      World.field680 = var2;
      World.field673 = var3;
      class47.method833(World.worldList, 0, World.worldList.length - 1, World.field680, World.field673);
   }
}
