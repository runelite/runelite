import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eo")
public class class151 implements class111 {
   @ObfuscatedName("a")
   static final class151 field2242 = new class151(0, -1, true, false, true);
   @ObfuscatedName("r")
   static final class151 field2243 = new class151(1, 0, true, true, true);
   @ObfuscatedName("f")
   static final class151 field2244 = new class151(2, 1, true, true, false);
   @ObfuscatedName("s")
   static final class151 field2245 = new class151(3, 2, false, false, true);
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1356493025
   )
   final int field2247;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1795541395
   )
   public final int field2248;
   @ObfuscatedName("m")
   public final boolean field2249;
   @ObfuscatedName("j")
   public final boolean field2250;
   @ObfuscatedName("fu")
   @ObfuscatedGetter(
      intValue = 143597477
   )
   static int field2251;
   @ObfuscatedName("hj")
   @Export("localPlayer")
   static class2 field2253;
   @ObfuscatedName("y")
   static final class151 field2254 = new class151(4, 3, false, false, true);

   class151(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2247 = var1;
      this.field2248 = var2;
      this.field2249 = var4;
      this.field2250 = var5;
   }

   @ObfuscatedName("a")
   public int vmethod3184() {
      return this.field2247;
   }

   @ObfuscatedName("g")
   public static void method3161() {
      try {
         if(class182.field2947 == 1) {
            int var0 = class182.field2942.method3623();
            if(var0 > 0 && class182.field2942.method3666()) {
               var0 -= class45.field1043;
               if(var0 < 0) {
                  var0 = 0;
               }

               class182.field2942.method3622(var0);
               return;
            }

            class182.field2942.method3628();
            class182.field2942.method3681();
            if(class182.field2946 != null) {
               class182.field2947 = 2;
            } else {
               class182.field2947 = 0;
            }

            class182.field2950 = null;
            class136.field2121 = null;
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class182.field2942.method3628();
         class182.field2947 = 0;
         class182.field2950 = null;
         class136.field2121 = null;
         class182.field2946 = null;
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "5"
   )
   static final void method3162() {
      for(class29 var0 = (class29)client.field429.method3860(); var0 != null; var0 = (class29)client.field429.method3861()) {
         if(var0.field696 == class48.field1078 && !var0.field693) {
            if(client.field303 >= var0.field685) {
               var0.method658(client.field409);
               if(var0.field693) {
                  var0.method3946();
               } else {
                  class77.field1396.method1968(var0.field696, var0.field687, var0.field688, var0.field689, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.method3946();
         }
      }

   }
}
