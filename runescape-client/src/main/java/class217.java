import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hy")
public class class217 extends CacheableNode {
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "[Lkb;"
   )
   static SpritePixels[] field2676;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -2057688857
   )
   public final int field2673;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1927362729
   )
   public final int field2672;
   @ObfuscatedName("r")
   public final int[] field2674;
   @ObfuscatedName("g")
   public final int[] field2675;

   class217(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2673 = var1;
      this.field2672 = var2;
      this.field2674 = var3;
      this.field2675 = var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "992714552"
   )
   public boolean method3961(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2675.length) {
         int var3 = this.field2675[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2674[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IS)Lie;",
      garbageValue = "-1866"
   )
   public static FloorUnderlayDefinition method3957(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Ljq;",
      garbageValue = "-1303806733"
   )
   public static class285 method3960(int var0) {
      class285[] var1 = ScriptState.method1001();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class285 var3 = var1[var2];
         if(var0 == var3.field3785) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lcg;Lcg;IZIZI)I",
      garbageValue = "-1929595185"
   )
   static int method3959(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class34.method351(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class34.method351(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }
}
