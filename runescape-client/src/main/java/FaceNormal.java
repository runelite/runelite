import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("FaceNormal")
public class FaceNormal {
   @ObfuscatedName("u")
   static Buffer field2150;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -346069527
   )
   @Export("y")
   int y;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -645269187
   )
   @Export("z")
   int z;
   @ObfuscatedName("f")
   public static String[] field2153;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1170390967
   )
   @Export("x")
   int x;
   @ObfuscatedName("if")
   static Widget field2155;

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1959014692"
   )
   static final boolean method2868() {
      return Client.menuOptionCount <= 0?false:Client.field1075 && class50.field659[81] && Client.field1074 != -1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Lclass251;",
      garbageValue = "872750746"
   )
   public static class251 method2869(int var0) {
      class251 var1 = (class251)class251.field3400.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class251.field3399.getConfigData(11, var0);
         var1 = new class251();
         if(var2 != null) {
            var1.method4438(new Buffer(var2));
         }

         var1.method4437();
         class251.field3400.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-389800888"
   )
   public static String method2870(String var0) {
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
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
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
