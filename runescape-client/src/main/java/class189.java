import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class189 extends CacheableNode {
   @ObfuscatedName("e")
   public static NodeCache field2786 = new NodeCache(64);
   @ObfuscatedName("i")
   public static class182 field2787;
   @ObfuscatedName("f")
   public boolean field2788 = false;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-3"
   )
   public void method3393(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3394(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   void method3394(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2788 = true;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "1849822213"
   )
   public static String method3395(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Z",
      garbageValue = "267491063"
   )
   static boolean method3399(String var0) {
      if(null == var0) {
         return false;
      } else {
         String var1 = class118.method2244(var0, class108.field1724);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(class118.method2244(var3.name, class108.field1724))) {
               return true;
            }

            if(var1.equalsIgnoreCase(class118.method2244(var3.previousName, class108.field1724))) {
               return true;
            }
         }

         return false;
      }
   }
}
