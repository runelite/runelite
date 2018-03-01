import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lg")
public final class class316 {
   @ObfuscatedName("d")
   public static final char[] field3914;

   static {
      field3914 = new char[]{'_', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
   }

   @ObfuscatedName("eq")
   @ObfuscatedSignature(
      signature = "(IZZZI)Ljs;",
      garbageValue = "-169025461"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class167.dat2File != null) {
         var4 = new IndexFile(var0, class167.dat2File, SoundTaskDataProvider.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, ContextMenuRow.indexStore255, var0, var1, var2, var3);
   }
}
