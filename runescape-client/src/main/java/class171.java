import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class171 {
   @ObfuscatedName("eg")
   static ModIcon[] field2357;
   @ObfuscatedName("bt")
   static ModIcon[] field2358;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "1226401050"
   )
   public static void method3299(class182 var0) {
      class194.field2851 = var0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)Lclass48;",
      garbageValue = "-21"
   )
   static class48 method3300(int var0) {
      class48 var1 = (class48)class48.field936.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = XClanMember.field275.method3329(var0, 0);
         if(null == var2) {
            return null;
         } else {
            var1 = new class48();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.method2995();
            var1.field932 = var3.method3097();
            var1.field940 = var3.method3097();
            var1.field938 = var3.method3097();
            var1.field937 = var3.method3097();
            var3.offset = 0;
            var3.method3094();
            var1.field939 = new int[var4];
            var1.field934 = new int[var4];
            var1.field935 = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.field939[var5++] = var6) {
               var6 = var3.method3097();
               if(var6 == 3) {
                  var1.field935[var5] = var3.method3057();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.field934[var5] = var3.method2995();
               } else {
                  var1.field934[var5] = var3.method3033();
               }
            }

            class48.field936.put(var1, (long)var0);
            return var1;
         }
      }
   }
}
