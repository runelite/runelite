import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public class class137 {
   @ObfuscatedName("u")
   byte[] field1887;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1365630943
   )
   int field1889;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2073321775
   )
   int field1890;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1842092719
   )
   int field1891;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 958162947
   )
   int field1892;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1899269885
   )
   int field1893;
   @ObfuscatedName("x")
   byte[] field1894;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1156876627
   )
   int field1895;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 739206747
   )
   int field1896;
   @ObfuscatedName("by")
   static class184 field1898;

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-116722532"
   )
   static final void method2459() {
      Client.field402 = 0;
      int var0 = FrameMap.baseX + (class148.localPlayer.x >> 7);
      int var1 = XItemContainer.baseY + (class148.localPlayer.y >> 7);
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field402 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field402 = 1;
      }

      if(Client.field402 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field402 = 0;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "896579005"
   )
   public static void method2460() {
      ItemComposition.field2938.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZS)[B",
      garbageValue = "12068"
   )
   public static byte[] method2461(Object var0, boolean var1) {
      if(null == var0) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var5 = (byte[])((byte[])((byte[])var0));
         if(var1) {
            int var3 = var5.length;
            byte[] var4 = new byte[var3];
            System.arraycopy(var5, 0, var4, 0, var3);
            return var4;
         } else {
            return var5;
         }
      } else if(var0 instanceof class156) {
         class156 var2 = (class156)var0;
         return var2.vmethod3000();
      } else {
         throw new IllegalArgumentException();
      }
   }
}
