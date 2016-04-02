import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("co")
@Implements("GameObject")
public final class class98 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 534015205
   )
   @Export("offsetX")
   int field1634;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1204053613
   )
   @Export("height")
   int field1635;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 725357343
   )
   @Export("x")
   int field1636;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2084398495
   )
   @Export("flags")
   int field1637 = 0;
   @ObfuscatedName("p")
   @Export("renderable")
   public class85 field1638;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1394600415
   )
   @Export("relativeX")
   int field1639;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1401278977
   )
   @Export("orientation")
   int field1641;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 956537745
   )
   @Export("y")
   int field1642;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -273267811
   )
   @Export("offsetY")
   int field1643;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1191738867
   )
   int field1644;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -170621567
   )
   int field1645;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -494180877
   )
   @Export("hash")
   public int field1646 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -275687597
   )
   @Export("relativeY")
   int field1647;
   @ObfuscatedName("in")
   static class173 field1649;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1098883741
   )
   @Export("plane")
   int field1650;

   @ObfuscatedName("e")
   static final boolean method2210(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else if(class18.method192(var0)) {
         return true;
      } else {
         char[] var1 = class164.field2655;

         int var2;
         char var3;
         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         var1 = class164.field2653;

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var3 == var0) {
               return true;
            }
         }

         return false;
      }
   }
}
