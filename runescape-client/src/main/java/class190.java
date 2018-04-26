import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
public class class190 {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Ljx;"
   )
   @Export("mapAreaType")
   public static Area[] mapAreaType;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 561921555
   )
   static int field2515;
   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   @Export("indexTrack2")
   static IndexData indexTrack2;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Ljp;",
      garbageValue = "-1405155802"
   )
   public static VarCString method3560(int var0) {
      VarCString var1 = (VarCString)VarCString.field3478.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarCString.field3481.getConfigData(15, var0);
         var1 = new VarCString();
         if(var2 != null) {
            var1.method4887(new Buffer(var2));
         }

         VarCString.field3478.put(var1, (long)var0);
         return var1;
      }
   }
}
