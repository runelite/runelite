import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class137 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -653445989
   )
   int field1914;
   @ObfuscatedName("m")
   byte[] field1915;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -236679251
   )
   int field1916;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1938156673
   )
   int field1917;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 446425797
   )
   int field1918;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1718243319
   )
   int field1919;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 219812769
   )
   int field1920;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1111926781
   )
   int field1921;
   @ObfuscatedName("o")
   byte[] field1922;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-1045669656"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2943.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class217.field3166.method3203(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3610();
         if(var1.field2980 != -1) {
            var1.method3552(getItemDefinition(var1.field2980), getItemDefinition(var1.note));
         }

         if(var1.field2989 != -1) {
            var1.method3553(getItemDefinition(var1.field2989), getItemDefinition(var1.field2988));
         }

         if(var1.field2955 != -1) {
            var1.method3557(getItemDefinition(var1.field2955), getItemDefinition(var1.field2950));
         }

         if(!Widget.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field2987 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.field2986 = 0;
         }

         ItemComposition.field2943.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("b")
   public static String method2417(long var0) {
      if(var0 > 0L && var0 < 6582952005840035281L) {
         if(0L == var0 % 37L) {
            return null;
         } else {
            int var2 = 0;

            for(long var3 = var0; var3 != 0L; var3 /= 37L) {
               ++var2;
            }

            StringBuilder var5;
            char var8;
            for(var5 = new StringBuilder(var2); var0 != 0L; var5.append(var8)) {
               long var6 = var0;
               var0 /= 37L;
               var8 = class205.field3080[(int)(var6 - var0 * 37L)];
               if(var8 == 95) {
                  int var9 = var5.length() - 1;
                  var5.setCharAt(var9, Character.toUpperCase(var5.charAt(var9)));
                  var8 = 160;
               }
            }

            var5.reverse();
            var5.setCharAt(0, Character.toUpperCase(var5.charAt(0)));
            return var5.toString();
         }
      } else {
         return null;
      }
   }
}
