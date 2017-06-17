import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public abstract class class176 {
   @ObfuscatedName("m")
   static boolean field2428;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)[B",
      garbageValue = "128"
   )
   abstract byte[] vmethod3256();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-33"
   )
   abstract void vmethod3260(byte[] var1);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)LEnum;",
      garbageValue = "-58"
   )
   public static Enum method3269(int var0) {
      Enum var1 = (Enum)Enum.field3408.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Enum.field3406.getConfigData(8, var0);
         var1 = new Enum();
         if(var2 != null) {
            var1.method4339(new Buffer(var2));
         }

         Enum.field3408.put(var1, (long)var0);
         return var1;
      }
   }

   static {
      field2428 = false;
   }
}
