import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "[Ldz;"
   )
   @Export("skeletons")
   Frame[] skeletons;

   @ObfuscatedSignature(
      signature = "(Lik;Lik;IZ)V",
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1753141207"
   )
   public boolean method3008(int var1) {
      return this.skeletons[var1].showing;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "81"
   )
   public static void method3004(int var0, int var1) {
      Varbit var3 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var8 = Varbit.varbit_ref.getConfigData(14, var0);
         var3 = new Varbit();
         if(var8 != null) {
            var3.decode(new Buffer(var8));
         }

         Varbit.varbits.put(var3, (long)var0);
         var2 = var3;
      }

      int var4 = var2.configId;
      int var5 = var2.leastSignificantBit;
      int var6 = var2.mostSignificantBit;
      int var7 = class222.varpsMasks[var6 - var5];
      if(var1 < 0 || var1 > var7) {
         var1 = 0;
      }

      var7 <<= var5;
      class222.widgetSettings[var4] = class222.widgetSettings[var4] & ~var7 | var1 << var5 & var7;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-91294148"
   )
   static synchronized byte[] method3009(int var0) {
      return class185.method3612(var0, false);
   }
}
