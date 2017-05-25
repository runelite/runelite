import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
@Implements("Frames")
public class Frames extends CacheableNode {
   @ObfuscatedName("i")
   Frame[] field2124;
   @ObfuscatedName("u")
   static IndexDataBase field2126;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;Lclass186;I)Lclass186;",
      garbageValue = "1761253637"
   )
   static final class186 method2913(Buffer var0, class186 var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = ChatLineBuffer.method1895(var2);
         var1 = new class186(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new class185(var0.readString());
         } else {
            var6 = new class198(var0.readInt());
         }

         var1.method3575((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1812793090"
   )
   public boolean method2914(int var1) {
      return this.field2124[var1].field1882;
   }

   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IZ)V",
      garbageValue = "0"
   )
   public Frames(IndexDataBase var1, IndexDataBase var2, int var3, boolean var4) {
      Deque var5 = new Deque();
      int var6 = var1.method4184(var3);
      this.field2124 = new Frame[var6];
      int[] var7 = var1.method4183(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.getConfigData(var3, var7[var8]);
         FrameMap var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(FrameMap var12 = (FrameMap)var5.method3660(); var12 != null; var12 = (FrameMap)var5.method3661()) {
            if(var12.field2034 == var11) {
               var10 = var12;
               break;
            }
         }

         if(var10 == null) {
            byte[] var13 = var2.method4265(var11, 0);
            var10 = new FrameMap(var11, var13);
            var5.method3655(var10);
         }

         this.field2124[var7[var8]] = new Frame(var9, var10);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "34"
   )
   public static void method2916() {
      PlayerComposition.field2613.reset();
   }
}
