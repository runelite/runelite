import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("SpotAnimationDefinition_modelIndexCache")
   static IndexDataBase SpotAnimationDefinition_modelIndexCache;
   @ObfuscatedName("jf")
   @ObfuscatedGetter(
      intValue = -425019147
   )
   @Export("menuY")
   static int menuY;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[Ldy;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Ljm;Ljm;IZ)V",
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1944805564"
   )
   public boolean method3079(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljs;IIIBZB)V",
      garbageValue = "36"
   )
   @Export("requestNetFile")
   static void requestNetFile(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class264.NetCache_pendingPriorityWrites.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class264.NetCache_pendingPriorityResponses.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class264.NetCache_pendingWrites.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class264.NetCache_pendingPriorityWrites.put(var8, var6);
                  --class264.NetCache_pendingWritesCount;
                  ++class264.NetCache_pendingPriorityWritesCount;
               }

            } else {
               if(!var5) {
                  var8 = (FileRequest)class264.NetCache_pendingResponses.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class264.NetCache_pendingPriorityWrites.put(var8, var6);
                  ++class264.NetCache_pendingPriorityWritesCount;
               } else {
                  class264.NetCache_pendingWritesQueue.push(var8);
                  class264.NetCache_pendingWrites.put(var8, var6);
                  ++class264.NetCache_pendingWritesCount;
               }

            }
         }
      }
   }
}
