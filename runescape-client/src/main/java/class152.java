import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class152 extends RuntimeException {
   @ObfuscatedName("b")
   Throwable field2231;
   @ObfuscatedName("v")
   String field2233;
   @ObfuscatedName("i")
   public static Applet field2236;
   @ObfuscatedName("c")
   public static String field2238;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 441268647
   )
   static int field2239;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "-2139150487"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field3354.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class17.field309.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.method4371(new Buffer(var2));
         }

         KitDefinition.field3354.put(var1, (long)var0);
         return var1;
      }
   }
}
