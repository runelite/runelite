import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
public final class class22 {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("NetCache_responseArchiveBuffer")
   public static Buffer NetCache_responseArchiveBuffer;
   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      signature = "Lis;"
   )
   @Export("studioGame")
   static StudioGame studioGame;
   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("indexCache16")
   static IndexCache indexCache16;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1976624405
   )
   int field169;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -698663527
   )
   int field164;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1588021801
   )
   int field166;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2138505015
   )
   int field167;
   @ObfuscatedSignature(
      signature = "Lal;"
   )
   final WorldMapManager this$0;

   @ObfuscatedSignature(
      signature = "(Lal;)V"
   )
   class22(WorldMapManager var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1573773621"
   )
   public static int method297() {
      return ++MouseHandler.MouseHandler_idleCycles - 1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "61"
   )
   static final void method294(String var0) {
      StringBuilder var1 = (new StringBuilder()).append(var0);
      Object var2 = null;
      String var3 = var1.append(" is already on your ignore list").toString();
      WorldMapIcon1.method219(30, "", var3);
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(IZZZB)Lit;",
      garbageValue = "-15"
   )
   @Export("newIndexCache")
   static IndexCache newIndexCache(int var0, boolean var1, boolean var2, boolean var3) {
      IndexStore var4 = null;
      if(class168.dat2File != null) {
         var4 = new IndexStore(var0, class168.dat2File, IndexStoreAction.idxFiles[var0], 1000000);
      }

      return new IndexCache(var4, Fonts.indexStore255, var0, var1, var2, var3);
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(Lho;I)V",
      garbageValue = "1002272291"
   )
   static void method295(Widget var0) {
      if(var0.cycle == Client.__client_oo) {
         Client.__client_od[var0.rootIndex] = true;
      }

   }

   @ObfuscatedName("jo")
   @ObfuscatedSignature(
      signature = "(Lho;IIII)V",
      garbageValue = "1417616898"
   )
   static final void method296(Widget var0, int var1, int var2, int var3) {
      SpriteMask var4 = var0.getSpriteMask(false);
      if(var4 != null) {
         if(Client.minimapState < 3) {
            UnitPriceComparator.compass.__ay_513(var1, var2, var4.width, var4.height, 25, 25, Client.minimapOrientation, 256, var4.xStarts, var4.xWidths);
         } else {
            Rasterizer2D.method5948(var1, var2, 0, var4.xStarts, var4.xWidths);
         }
      }

   }
}
