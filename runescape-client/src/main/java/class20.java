import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("j")
public class class20 {
   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      signature = "Lcl;"
   )
   @Export("topContextMenuRow")
   static ContextMenuRow topContextMenuRow;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "10033992"
   )
   static void method166(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method166(var0, var1, var2, var5 - 1);
         method166(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("fr")
   @ObfuscatedSignature(
      signature = "(IZZZI)Lia;",
      garbageValue = "-1577422433"
   )
   @Export("openCacheIndex")
   static IndexData openCacheIndex(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class166.dat2File != null) {
         var4 = new IndexFile(var0, class166.dat2File, class151.idxFiles[var0], 1000000);
      }

      return new IndexData(var4, class162.indexStore255, var0, var1, var2, var3);
   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-775823596"
   )
   static void method168(int var0) {
      if(var0 == -1 && !Client.field1039) {
         class155.field2105.method4140();
         class223.field2646 = 1;
         Huffman.field2471 = null;
      } else if(var0 != -1 && var0 != Client.field1015 && Client.field971 != 0 && !Client.field1039) {
         IndexData var1 = class155.indexTrack1;
         int var2 = Client.field971;
         class223.field2646 = 1;
         Huffman.field2471 = var1;
         class223.field2648 = var0;
         TextureProvider.field1658 = 0;
         class223.field2645 = var2;
         class223.field2647 = false;
         VertexNormal.field1888 = 2;
      }

      Client.field1015 = var0;
   }
}
