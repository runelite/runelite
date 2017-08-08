import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ec")
@Implements("DecorativeObject")
public final class DecorativeObject {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhg;"
   )
   static Widget field2164;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -691856725
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 2064029715
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 942793769
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 529888723
   )
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -568432803
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1703587219
   )
   @Export("y")
   int y;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1787392687
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -254552543
   )
   @Export("renderFlag")
   int renderFlag;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1925630649
   )
   @Export("rotation")
   int rotation;

   DecorativeObject() {
      this.hash = 0;
      this.renderInfoBitPacked = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-22"
   )
   static boolean method2935(int var0, int var1) {
      return var0 != 4 || var1 < 8;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1738898059"
   )
   public static boolean method2934(int var0) {
      return var0 >= class222.field2784.field2804 && var0 <= class222.field2802.field2804;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;I)Z",
      garbageValue = "1224744477"
   )
   public static boolean method2936(IndexDataBase var0, IndexDataBase var1) {
      Area.field3286 = var1;
      if(!var0.method4130()) {
         return false;
      } else {
         Area.field3279 = var0.fileCount(35);
         Area.field3276 = new Area[Area.field3279];

         for(int var2 = 0; var2 < Area.field3279; ++var2) {
            byte[] var3 = var0.getConfigData(35, var2);
            if(var3 != null) {
               Area.field3276[var2] = new Area(var2);
               Area.field3276[var2].method4300(new Buffer(var3));
               Area.field3276[var2].method4290();
            }
         }

         return true;
      }
   }
}
