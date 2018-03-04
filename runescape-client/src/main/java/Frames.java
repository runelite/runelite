import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "[Ldy;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Ljk;Ljk;IZ)V",
      garbageValue = "0"
   )
   public Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
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
            byte[] var13 = var2.getChild(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.addFront(var10);
         }

         this.skeletons[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-4"
   )
   public boolean method3141(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILct;ZB)I",
      garbageValue = "1"
   )
   static int method3142(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class20.field338:class81.field1267;
      if(var0 == 1800) {
         int[] var4 = class81.intStack;
         int var5 = ++class81.intStackSize - 1;
         int var7 = class85.getWidgetConfig(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.name == null) {
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
            } else {
               class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class81.intStack[--class81.intStackSize];
         --var8;
         if(var3.actions != null && var8 < var3.actions.length && var3.actions[var8] != null) {
            class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class81.scriptStringStack[++UrlRequester.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }
}
