import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class164 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -198923963
   )
   static int field2325;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;I)Z",
      garbageValue = "-2027019132"
   )
   public static boolean method3160(IndexDataBase var0, IndexDataBase var1) {
      Area.field3291 = var1;
      if(!var0.method4292()) {
         return false;
      } else {
         Area.field3297 = var0.fileCount(35);
         class3.field24 = new Area[Area.field3297];

         for(int var2 = 0; var2 < Area.field3297; ++var2) {
            byte[] var3 = var0.getConfigData(35, var2);
            if(var3 != null) {
               class3.field24[var2] = new Area(var2);
               class3.field24[var2].method4392(new Buffer(var3));
               class3.field24[var2].method4401();
            }
         }

         return true;
      }
   }
}
