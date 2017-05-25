import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class25 {
   @ObfuscatedName("h")
   class212 field371;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 159288117
   )
   int field375;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1965431535"
   )
   public static int method177(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   class25(int var1, class212 var2) {
      this.field375 = var1;
      this.field371 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;I)Z",
      garbageValue = "-448933486"
   )
   public static boolean method178(IndexDataBase var0, IndexDataBase var1) {
      class242.field3281 = var1;
      if(!var0.method4178()) {
         return false;
      } else {
         class242.field3293 = var0.method4184(35);
         class242.field3276 = new class242[class242.field3293];

         for(int var2 = 0; var2 < class242.field3293; ++var2) {
            byte[] var3 = var0.getConfigData(35, var2);
            if(var3 != null) {
               class242.field3276[var2] = new class242(var2);
               class242.field3276[var2].method4365(new Buffer(var3));
               class242.field3276[var2].method4367();
            }
         }

         return true;
      }
   }
}
