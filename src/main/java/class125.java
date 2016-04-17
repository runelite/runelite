import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public abstract class class125 {
   @ObfuscatedName("i")
   static int[] field2035;
   @ObfuscatedName("w")
   static boolean field2037 = false;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1075955707"
   )
   abstract byte[] vmethod2915();

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "337898845"
   )
   abstract void vmethod2916(byte[] var1);

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([Lclass112;II)Lclass112;",
      garbageValue = "-1957321659"
   )
   public static class112 method2926(class112[] var0, int var1) {
      class112[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class112 var4 = var2[var3];
         if(var1 == var4.vmethod3266()) {
            return var4;
         }
      }

      return null;
   }
}
