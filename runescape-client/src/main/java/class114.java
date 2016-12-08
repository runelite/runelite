import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class114 {
   @ObfuscatedName("m")
   static String field1799 = null;
   @ObfuscatedName("o")
   static Applet field1800 = null;
   @ObfuscatedName("fl")
   @ObfuscatedGetter(
      intValue = 310564147
   )
   static int field1803;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1090136335"
   )
   public static int method2153() {
      return ++class115.mouseIdleTicks - 1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)J",
      garbageValue = "-67"
   )
   public static synchronized long method2154() {
      long var0 = System.currentTimeMillis();
      if(var0 < class155.field2127) {
         class155.field2124 += class155.field2127 - var0;
      }

      class155.field2127 = var0;
      return var0 + class155.field2124;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-38"
   )
   static void method2155(int var0) {
      if(var0 == -1 && !Client.field493) {
         class138.field1926.method2488();
         class138.field1929 = 1;
         class138.field1930 = null;
      } else if(var0 != -1 && var0 != Client.field522 && Client.field521 != 0 && !Client.field493) {
         class184 var1 = class119.field1864;
         int var2 = Client.field521;
         class138.field1929 = 1;
         class138.field1930 = var1;
         class138.field1931 = var0;
         class181.field2711 = 0;
         class138.field1932 = var2;
         CombatInfo1.field665 = false;
         WidgetNode.field186 = 2;
      }

      Client.field522 = var0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "1385230924"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2820.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field2828.method3203(3, var0);
         var1 = new KitDefinition();
         if(null != var2) {
            var1.method3401(new Buffer(var2));
         }

         KitDefinition.field2820.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)Ljava/lang/String;",
      garbageValue = "1550666942"
   )
   public static String method2157(Buffer var0, int var1) {
      try {
         int var2 = var0.method2842();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class9.field78.method2659(var0.payload, var0.offset, var3, 0, var2);
         String var4 = class172.method3175(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }
}
