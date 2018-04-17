import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lll;"
   )
   static IndexedSprite field2074;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "[Ldj;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Ljf;Ljf;IZ)V",
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1892091747"
   )
   public boolean method3063(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-910139558"
   )
   public static int method3065() {
      return ++MouseInput.mouseIdleTicks - 1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lha;III)I",
      garbageValue = "-107378961"
   )
   static int method3062(IterableHashTable var0, int var1, int var2) {
      if(var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null?var2:var3.value;
      }
   }
}
