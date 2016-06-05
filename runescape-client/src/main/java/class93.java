import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("GroundObject")
public final class class93 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 419701853
   )
   int field1604;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1540541957
   )
   @Export("x")
   int field1605;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1028360221
   )
   @Export("y")
   int field1606;
   @ObfuscatedName("h")
   @Export("renderable")
   public class85 field1607;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 203710671
   )
   @Export("hash")
   public int field1608;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2026382977
   )
   @Export("floor")
   int field1609;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1323824936"
   )
   static void method2123(int var0) {
      if(var0 != -1) {
         if(class173.method3380(var0)) {
            class173[] var1 = class216.field3168[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               class173 var3 = var1[var2];
               if(null != var3.field2827) {
                  class0 var4 = new class0();
                  var4.field2 = var3;
                  var4.field5 = var3.field2827;
                  class28.method637(var4, 2000000);
               }
            }

         }
      }
   }
}
