import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class177 {
   @ObfuscatedName("w")
   @Export("spritePixels")
   public static byte[][] spritePixels;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IS)Lclass244;",
      garbageValue = "512"
   )
   @Export("getVarClientStringType")
   public static class244 getVarClientStringType(int var0) {
      class244 var1 = (class244)class244.field3318.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class244.field3320.getConfigData(15, var0);
         var1 = new class244();
         if(var2 != null) {
            var1.method4272(new Buffer(var2));
         }

         class244.field3318.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "-1824904467"
   )
   public static void method3372(IndexDataBase var0) {
      class2.varplayer_ref = var0;
      VarPlayerType.field3283 = class2.varplayer_ref.fileCount(16);
   }
}
