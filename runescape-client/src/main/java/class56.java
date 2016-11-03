import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class56 extends CacheableNode {
   @ObfuscatedName("f")
   public static NodeCache field1221 = new NodeCache(64);
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2015703923
   )
   public static int field1222;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1618432473
   )
   public int field1224 = 0;
   @ObfuscatedName("k")
   public static class170 field1225;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1742743969"
   )
   void method1165(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.method1166(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-11"
   )
   void method1166(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field1224 = var1.method2691();
      }

   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;S)[Ljava/lang/String;",
      garbageValue = "-31005"
   )
   static final String[] method1174(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
