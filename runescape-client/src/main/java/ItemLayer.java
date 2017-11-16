import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1419262687
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1459735091
   )
   @Export("x")
   int x;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1103379355
   )
   @Export("y")
   int y;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Leu;"
   )
   @Export("top")
   Renderable top;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1819898349
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1915055005
   )
   @Export("height")
   int height;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Liv;",
      garbageValue = "1474994425"
   )
   public static CombatInfo2 method2417(int var0) {
      CombatInfo2 var1 = (CombatInfo2)CombatInfo2.field3424.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = CombatInfo2.field3413.getConfigData(33, var0);
         var1 = new CombatInfo2();
         if(var2 != null) {
            var1.method4389(new Buffer(var2));
         }

         CombatInfo2.field3424.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1732837656"
   )
   public static int method2416(int var0) {
      var0 = (var0 & 1431655765) + (var0 >>> 1 & 1431655765);
      var0 = (var0 >>> 2 & 858993459) + (var0 & 858993459);
      var0 = var0 + (var0 >>> 4) & 252645135;
      var0 += var0 >>> 8;
      var0 += var0 >>> 16;
      return var0 & 255;
   }
}
