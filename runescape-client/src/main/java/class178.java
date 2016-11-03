import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fs")
public class class178 extends CacheableNode {
   @ObfuscatedName("f")
   public final int[] field2941;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1617539541
   )
   public final int field2942;
   @ObfuscatedName("c")
   public final int[] field2944;
   @ObfuscatedName("r")
   static int[] field2945;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2060608379
   )
   public final int field2947;
   @ObfuscatedName("ng")
   static class59 field2948;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-39"
   )
   public boolean method3472(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2944.length) {
         int var3 = this.field2944[var2];
         if(var1 >= var3 && var1 <= this.field2941[var2] + var3) {
            return true;
         }
      }

      return false;
   }

   class178(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2947 = var1;
      this.field2942 = var2;
      this.field2941 = var3;
      this.field2944 = var4;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1478105406"
   )
   static final void method3474(int var0, int var1, int var2, int var3) {
      if(Client.field326 == 1) {
         class140.field2179[Client.field389 / 100].method1760(Client.field320 - 8, Client.field390 - 8);
      }

      if(Client.field326 == 2) {
         class140.field2179[Client.field389 / 100 + 4].method1760(Client.field320 - 8, Client.field390 - 8);
      }

      Client.field401 = 0;
      int var4 = class47.baseX + (class165.localPlayer.x >> 7);
      int var5 = class21.baseY + (class165.localPlayer.y >> 7);
      if(var4 >= 3053 && var4 <= 3156 && var5 >= 3056 && var5 <= 3136) {
         Client.field401 = 1;
      }

      if(var4 >= 3072 && var4 <= 3118 && var5 >= 9492 && var5 <= 9535) {
         Client.field401 = 1;
      }

      if(Client.field401 == 1 && var4 >= 3139 && var4 <= 3199 && var5 >= 3008 && var5 <= 3062) {
         Client.field401 = 0;
      }

   }
}
