import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ej")
public final class class132 {
   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "([LWidget;IIIZB)V",
      garbageValue = "-79"
   )
   static void method2874(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class13.method149(var6, var2, var3, var4);
            class116.method2496(var6, var2, var3);
            if(var6.itemId > var6.scrollWidth - var6.width) {
               var6.itemId = var6.scrollWidth - var6.width;
            }

            if(var6.itemId < 0) {
               var6.itemId = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               Projectile.method93(var0, var6, var4);
            }
         }
      }

   }

   @ObfuscatedName("rq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-95"
   )
   protected static final void method2876() {
      CollisionData.field1963.vmethod3139();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field2249[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field2250[var0] = 0L;
      }

      class92.field1615 = 0;
   }
}
