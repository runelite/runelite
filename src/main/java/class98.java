import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("GameObject")
public final class class98 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -563618469
   )
   int field1656;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 676605175
   )
   @Export("height")
   int field1657;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 598252231
   )
   @Export("x")
   int field1658;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -464699425
   )
   @Export("y")
   int field1659;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 922777225
   )
   @Export("offsetY")
   int field1660;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1193924659
   )
   @Export("offsetX")
   int field1661;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1069453069
   )
   @Export("relativeX")
   int field1662;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -690198353
   )
   @Export("relativeY")
   int field1664;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -557836453
   )
   @Export("plane")
   int field1665;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 218253745
   )
   int field1667;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -903846043
   )
   @Export("hash")
   public int field1668 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1194486915
   )
   @Export("flags")
   int field1669 = 0;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -1910904893
   )
   protected static int field1671;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1002185445
   )
   @Export("orientation")
   int field1672;
   @ObfuscatedName("y")
   @Export("renderable")
   public class85 field1673;

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-629368998"
   )
   static void method2282(int var0, int var1, int var2, int var3) {
      class173 var4 = class210.method4010(var0, var1);
      if(null != var4 && var4.field2864 != null) {
         class0 var5 = new class0();
         var5.field2 = var4;
         var5.field4 = var4.field2864;
         class168.method3449(var5, 200000);
      }

      client.field393 = var3;
      client.field447 = true;
      class9.field169 = var0;
      client.field386 = var1;
      class161.field2636 = var2;
      class23.method657(var4);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-146185429"
   )
   public static int method2283(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass168;IIIBZI)V",
      garbageValue = "2"
   )
   static void method2284(class168 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class172 var8 = (class172)class171.field2738.method3868(var6);
      if(null == var8) {
         var8 = (class172)class171.field2718.method3868(var6);
         if(var8 == null) {
            var8 = (class172)class171.field2721.method3868(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method3979();
                  class171.field2738.method3875(var8, var6);
                  --class171.field2739;
                  ++class171.field2727;
               }

            } else {
               if(!var5) {
                  var8 = (class172)class171.field2713.method3868(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new class172();
               var8.field2745 = var0;
               var8.field2741 = var3;
               var8.field2740 = var4;
               if(var5) {
                  class171.field2738.method3875(var8, var6);
                  ++class171.field2727;
               } else {
                  class171.field2720.method3963(var8);
                  class171.field2721.method3875(var8, var6);
                  ++class171.field2739;
               }

            }
         }
      }
   }
}
