import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1725687583
   )
   static int field1406;
   @ObfuscatedName("u")
   static int[] field1408;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -575635587
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1957266407
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Led;",
      garbageValue = "-83"
   )
   protected final Model getModel() {
      return GameObject.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lji;",
      garbageValue = "154626736"
   )
   public static class279 method1926(int var0) {
      class279 var1 = (class279)class279.field3550.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class279.field3549.getConfigData(34, var0);
         var1 = new class279();
         if(var2 != null) {
            var1.method4925(new Buffer(var2));
         }

         var1.method4924();
         class279.field3550.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1063167102"
   )
   public static boolean method1927() {
      return class229.field2680 != 0?true:class229.field2679.method4169();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Ljava/lang/String;",
      garbageValue = "52"
   )
   public static String method1925(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 131) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != '.' && var5 != '?' && var5 != '!') {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
