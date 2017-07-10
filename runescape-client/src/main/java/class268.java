import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
public final class class268 {
   @ObfuscatedName("i")
   static final char[] field3681;

   static {
      field3681 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILIndexFile;LIndexData;I)V",
      garbageValue = "926420545"
   )
   static void method4858(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.field3213 = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = class236.field3247;
      synchronized(class236.field3247) {
         class236.field3247.method3603(var3);
      }

      class43.method644();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LModIcon;",
      garbageValue = "1464020501"
   )
   public static ModIcon method4861() {
      ModIcon var0 = new ModIcon();
      var0.width = class286.field3801;
      var0.originalHeight = class286.field3796;
      var0.offsetX = class286.field3799[0];
      var0.offsetY = class286.field3800[0];
      var0.originalWidth = class7.field239[0];
      var0.height = class226.field3146[0];
      var0.palette = class278.field3745;
      var0.pixels = class210.field2609[0];
      XGrandExchangeOffer.method113();
      return var0;
   }
}
