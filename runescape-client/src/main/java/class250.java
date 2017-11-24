import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public class class250 extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   public static IndexDataBase field3387;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   public static NodeCache field3388;
   @ObfuscatedName("fa")
   static byte[][] field3386;
   @ObfuscatedName("k")
   public boolean field3389;

   static {
      field3388 = new NodeCache(64);
   }

   public class250() {
      this.field3389 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "1700393117"
   )
   public void method4468(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4469(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfr;II)V",
      garbageValue = "-1356725111"
   )
   void method4469(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field3389 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;Lid;I)V",
      garbageValue = "-93768855"
   )
   public static void method4477(IndexDataBase var0, IndexDataBase var1) {
      KitDefinition.identKit_ref = var0;
      KitDefinition.field3418 = var1;
      KitDefinition.field3419 = KitDefinition.identKit_ref.fileCount(3);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "100427489"
   )
   static final void method4474(int var0, int var1, int var2) {
      int var3;
      for(var3 = 0; var3 < 8; ++var3) {
         for(int var4 = 0; var4 < 8; ++var4) {
            class61.tileHeights[var0][var3 + var1][var4 + var2] = 0;
         }
      }

      if(var1 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var1][var3 + var2] = class61.tileHeights[var0][var1 - 1][var3 + var2];
         }
      }

      if(var2 > 0) {
         for(var3 = 1; var3 < 8; ++var3) {
            class61.tileHeights[var0][var3 + var1][var2] = class61.tileHeights[var0][var3 + var1][var2 - 1];
         }
      }

      if(var1 > 0 && class61.tileHeights[var0][var1 - 1][var2] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2];
      } else if(var2 > 0 && class61.tileHeights[var0][var1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1][var2 - 1];
      } else if(var1 > 0 && var2 > 0 && class61.tileHeights[var0][var1 - 1][var2 - 1] != 0) {
         class61.tileHeights[var0][var1][var2] = class61.tileHeights[var0][var1 - 1][var2 - 1];
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Lkl;",
      garbageValue = "-1977901791"
   )
   public static IndexedSprite method4476() {
      IndexedSprite var0 = new IndexedSprite();
      var0.width = class295.field3846;
      var0.originalHeight = class295.field3847;
      var0.offsetX = class295.field3848[0];
      var0.offsetY = class295.offsetsY[0];
      var0.originalWidth = class295.field3845[0];
      var0.height = class285.field3788[0];
      var0.palette = class115.field1599;
      var0.pixels = class15.spritePixels[0];
      class295.field3848 = null;
      class295.offsetsY = null;
      class295.field3845 = null;
      class285.field3788 = null;
      class115.field1599 = null;
      class15.spritePixels = null;
      return var0;
   }
}
