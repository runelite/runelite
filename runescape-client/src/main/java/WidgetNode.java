import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("b")
   boolean field181 = false;
   @ObfuscatedName("dd")
   @ObfuscatedGetter(
      intValue = -73792087
   )
   static int field182;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1217387061
   )
   @Export("id")
   int id;
   @ObfuscatedName("po")
   @ObfuscatedGetter(
      intValue = -1521400559
   )
   protected static int field184;
   @ObfuscatedName("qf")
   @ObfuscatedGetter(
      intValue = -963119421
   )
   protected static int field185;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1714182885
   )
   public static int field186;
   @ObfuscatedName("fp")
   @ObfuscatedGetter(
      intValue = -99647795
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2089961641
   )
   int field191;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BIIII[LCollisionData;I)V",
      garbageValue = "1923410140"
   )
   static final void method184(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var7 + var1 < 103 && var8 + var2 > 0 && var2 + var8 < 103) {
                  var5[var6].flags[var1 + var7][var8 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               GameObject.method1878(var10, var7, var1 + var8, var2 + var9, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "247"
   )
   public static void method185() {
      if(class103.field1678.toLowerCase().indexOf("microsoft") != -1) {
         class105.field1727[186] = 57;
         class105.field1727[187] = 27;
         class105.field1727[188] = 71;
         class105.field1727[189] = 26;
         class105.field1727[190] = 72;
         class105.field1727[191] = 73;
         class105.field1727[192] = 58;
         class105.field1727[219] = 42;
         class105.field1727[220] = 74;
         class105.field1727[221] = 43;
         class105.field1727[222] = 59;
         class105.field1727[223] = 28;
      } else {
         class105.field1727[44] = 71;
         class105.field1727[45] = 26;
         class105.field1727[46] = 72;
         class105.field1727[47] = 73;
         class105.field1727[59] = 57;
         class105.field1727[61] = 27;
         class105.field1727[91] = 42;
         class105.field1727[92] = 74;
         class105.field1727[93] = 43;
         class105.field1727[192] = 28;
         class105.field1727[222] = 58;
         class105.field1727[520] = 59;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1572986761"
   )
   public static boolean method186(int var0) {
      return (var0 >> 31 & 1) != 0;
   }
}
