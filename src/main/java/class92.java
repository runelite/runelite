import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ck")
public final class class92 {
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1335548949
   )
   int field1579;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1519621921
   )
   int field1580;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1719752105
   )
   int field1581;
   @ObfuscatedName("s")
   public class84 field1582;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -943911581
   )
   public int field1583;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1499608827
   )
   int field1585;
   @ObfuscatedName("br")
   static class80[] field1587;

   @ObfuscatedName("u")
   static final int method2177(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return var1;
      } else {
         var1 = var1 * (var0 & 127) / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("m")
   public static class80 method2178() {
      class80 var0 = new class80();
      var0.field1422 = class76.field1379;
      var0.field1416 = class76.field1381;
      var0.field1419 = class76.field1386[0];
      var0.field1421 = class76.field1382[0];
      var0.field1418 = class102.field1764[0];
      var0.field1417 = class76.field1383[0];
      var0.field1420 = class115.field1968;
      var0.field1423 = class30.field708[0];
      class1.method7();
      return var0;
   }

   @ObfuscatedName("r")
   static char method2179(char var0) {
      return 181 != var0 && var0 != 402?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("a")
   public static class172 method2180(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class172.field2850[var1] == null || null == class172.field2850[var1][var2]) {
         boolean var3 = class103.method2303(var1);
         if(!var3) {
            return null;
         }
      }

      return class172.field2850[var1][var2];
   }

   @ObfuscatedName("ck")
   static final boolean method2181(class172 var0) {
      if(null == var0.field2854) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.field2854.length; ++var1) {
            int var2 = class89.method2100(var0, var1);
            int var3 = var0.field2855[var1];
            if(2 == var0.field2854[var1]) {
               if(var2 >= var3) {
                  return false;
               }
            } else if(var0.field2854[var1] == 3) {
               if(var2 <= var3) {
                  return false;
               }
            } else if(4 == var0.field2854[var1]) {
               if(var3 == var2) {
                  return false;
               }
            } else if(var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}
