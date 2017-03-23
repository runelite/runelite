import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fl")
public class class164 extends CacheableNode {
   @ObfuscatedName("u")
   public final int[] field2171;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -591386089
   )
   public final int field2172;
   @ObfuscatedName("h")
   public final int[] field2173;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1764747087
   )
   public final int field2174;
   @ObfuscatedName("gc")
   static Widget field2177;

   class164(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2174 = var1;
      this.field2172 = var2;
      this.field2171 = var3;
      this.field2173 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-552071341"
   )
   public boolean method3189(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2173.length) {
         int var3 = this.field2173[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2171[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LOverlay;",
      garbageValue = "-1597998494"
   )
   public static Overlay method3192(int var0) {
      Overlay var1 = (Overlay)Overlay.field3042.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Overlay.field3047.getConfigData(4, var0);
         var1 = new Overlay();
         if(var2 != null) {
            var1.method3761(new Buffer(var2), var0);
         }

         var1.method3770();
         Overlay.field3042.put(var1, (long)var0);
         return var1;
      }
   }
}
