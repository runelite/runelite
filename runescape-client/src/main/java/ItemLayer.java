import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("lp")
   @ObfuscatedGetter(
      intValue = 250957781
   )
   static int field1706;
   @ObfuscatedName("k")
   static int[][][] field1710;
   @ObfuscatedName("ex")
   @ObfuscatedGetter(
      intValue = 344683843
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("es")
   @ObfuscatedGetter(
      intValue = -2087746071
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1867159185
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1110033737
   )
   @Export("x")
   int x;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1369336829
   )
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lei;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1649014185
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -750409929
   )
   @Export("height")
   int height;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Ljf;",
      garbageValue = "-1398927717"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.sequences.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class3.seq_ref.getConfigData(12, var0);
         var1 = new Sequence();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         Sequence.sequences.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-74"
   )
   public static void method2521() {
      class210.field2596.method3969();
      class210.field2594 = 1;
      class184.field2516 = null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "([BIIII[Lfa;B)V",
      garbageValue = "23"
   )
   static final void method2519(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var7 + var1][var8 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               CombatInfoListHolder.loadTerrain(var10, var7, var8 + var1, var9 + var2, var3, var4, 0);
            }
         }
      }

   }
}
