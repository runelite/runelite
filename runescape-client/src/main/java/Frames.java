import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("s")
   public static int[] field2042;
   @ObfuscatedName("e")
   public static short[] field2043;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 560840327
   )
   @Export("port1")
   static int port1;
   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   static Widget field2040;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "[Leu;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Lil;Lil;IZ)V"
   )
   Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.fileCount(var3);
      this.skeletons = new Frame[var6];
      int[] var7 = var1.getChilds(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.getFront(); var12 != null; var12 = (FrameMap)var5.getNext()) {
            if(var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13;
            if(var4) {
               var13 = var2.getChild(0, var11);
            } else {
               var13 = var2.getChild(var11, 0);
            }

            var10 = new FrameMap(var11, var13);
            var5.addFront(var10);
         }

         this.skeletons[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-79"
   )
   public boolean method2932(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILcv;ZI)I",
      garbageValue = "1172966436"
   )
   static int method2941(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class82.field1267:CombatInfo1.field1216;
      if(var0 == 1500) {
         class82.intStack[++class82.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class82.intStack[++class82.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class82.intStack[++class82.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class82.intStack[++class82.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class82.intStack[++class82.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class82.intStack[++class82.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2114520108"
   )
   public static void method2942() {
      ItemComposition.items.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }
}
