import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class175 extends CacheableNode {
   @ObfuscatedName("x")
   public class171 field2797;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -434961739
   )
   public int field2798;
   @ObfuscatedName("dq")
   @Export("mapRegions")
   static int[] mapRegions;
   @ObfuscatedName("j")
   public byte field2801;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "58"
   )
   public static boolean method3419(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!class214.field3186.method3342(var0)) {
         return false;
      } else {
         int var1 = class214.field3186.method3299(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == Widget.widgets[var0][var2]) {
                  byte[] var3 = class214.field3186.method3290(var0, var2);
                  if(var3 != null) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = (var0 << 16) + var2;
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3423(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3442(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)[Lclass156;",
      garbageValue = "-120"
   )
   public static class156[] method3420() {
      return new class156[]{class156.field2328, class156.field2329, class156.field2321, class156.field2324};
   }
}
