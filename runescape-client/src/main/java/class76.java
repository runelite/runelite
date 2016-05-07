import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class76 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 696148323
   )
   public static int field1386;
   @ObfuscatedName("x")
   public static int[] field1387;
   @ObfuscatedName("pf")
   static class8 field1388;
   @ObfuscatedName("u")
   public static int[] field1389;
   @ObfuscatedName("d")
   public static int[] field1390;
   @ObfuscatedName("nj")
   @ObfuscatedGetter(
      intValue = 452928601
   )
   static int field1391;
   @ObfuscatedName("e")
   public static String[] field1392;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -625573327
   )
   static int field1395;
   @ObfuscatedName("b")
   public static int[] field1396;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;Lclass167;Lclass184;B)Z",
      garbageValue = "81"
   )
   public static boolean method1638(class167 var0, class167 var1, class167 var2, class184 var3) {
      class183.field2980 = var0;
      class183.field2978 = var1;
      class90.field1571 = var2;
      class183.field2972 = var3;
      return true;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass122;I)I",
      garbageValue = "1732658369"
   )
   static int method1641(class122 var0) {
      int var1 = var0.method2750(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(1 == var1) {
         var2 = var0.method2750(5);
      } else if(var1 == 2) {
         var2 = var0.method2750(8);
      } else {
         var2 = var0.method2750(11);
      }

      return var2;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1794568473"
   )
   static int method1642(int var0, int var1) {
      long var2 = (long)((var0 << 16) + var1);
      return class124.field2045 != null && class124.field2045.field3125 == var2?class171.field2735.field2005 * 99 / (class171.field2735.field2007.length - class124.field2045.field2750) + 1:0;
   }
}
