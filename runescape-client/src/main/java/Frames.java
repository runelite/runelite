import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("Frames")
public class Frames extends DualNode {
   @ObfuscatedName("o")
   @Export("IndexStoreActionHandler_thread")
   static Thread IndexStoreActionHandler_thread;
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "[Llq;"
   )
   @Export("__en_bc")
   static IndexedSprite[] __en_bc;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Ldz;"
   )
   @Export("frames")
   Animation[] frames;

   @ObfuscatedSignature(
      signature = "(Lir;Lir;IZ)V",
      garbageValue = "0"
   )
   public Frames(AbstractIndexCache var1, AbstractIndexCache var2, int var3, boolean var4) {
      NodeDeque var5 = new NodeDeque();
      int var6 = var1.__s_396(var3);
      this.frames = new Animation[var6];
      int[] var7 = var1.__j_395(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.takeRecord(var3, var7[var8]);
         Skeleton var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(Skeleton var12 = (Skeleton)var5.last(); var12 != null; var12 = (Skeleton)var5.previous()) {
            if(var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.getRecord(var11, 0);
            var10 = new Skeleton(var11, var13);
            var5.addFirst(var10);
         }

         this.frames[var7[var8]] = new Animation(var9, var10);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1018278334"
   )
   @Export("hasAlphaTransform")
   public boolean hasAlphaTransform(int var1) {
      return this.frames[var1].hasAlphaTransform;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lir;I)V",
      garbageValue = "1204337492"
   )
   public static void method3241(AbstractIndexCache var0) {
      VarcInt.__iw_m = var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Llh;ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1776656760"
   )
   static String method3238(IterableNodeHashTable var0, int var1, String var2) {
      if(var0 == null) {
         return var2;
      } else {
         ObjectNode var3 = (ObjectNode)var0.get((long)var1);
         return var3 == null?var2:(String)var3.obj;
      }
   }
}
