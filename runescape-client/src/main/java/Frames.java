import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("configsIndex")
   static IndexData configsIndex;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "[Ldu;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Lir;Lir;IZ)V"
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "34"
   )
   public boolean method3117(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "-1909405820"
   )
   static int method3124(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 5504) {
         class80.intStackSize -= 2;
         var3 = class80.intStack[class80.intStackSize];
         int var4 = class80.intStack[class80.intStackSize + 1];
         if(!Client.field1068) {
            Client.field907 = var3;
            Client.mapAngle = var4;
         }

         return 1;
      } else if(var0 == 5505) {
         class80.intStack[++class80.intStackSize - 1] = Client.field907;
         return 1;
      } else if(var0 == 5506) {
         class80.intStack[++class80.intStackSize - 1] = Client.mapAngle;
         return 1;
      } else if(var0 == 5530) {
         var3 = class80.intStack[--class80.intStackSize];
         if(var3 < 0) {
            var3 = 0;
         }

         Client.field1061 = var3;
         return 1;
      } else if(var0 == 5531) {
         class80.intStack[++class80.intStackSize - 1] = Client.field1061;
         return 1;
      } else {
         return 2;
      }
   }
}
