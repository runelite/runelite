import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class51 implements class103 {
   @ObfuscatedName("a")
   static class234 field668;
   @ObfuscatedName("p")
   static IndexDataBase field669;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Lclass109;",
      garbageValue = "53"
   )
   public class109 vmethod1820() {
      return new class55();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LModel;IB)V",
      garbageValue = "19"
   )
   public static final void method731(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.field1930; ++var2) {
         if(var0.field1964[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.field1931[var3];
            int var7 = Model.field1931[var4];
            int var8 = Model.field1931[var5];
            int var9 = Model.field1937[var3];
            int var10 = Model.field1937[var4];
            int var11 = Model.field1937[var5];
            int var12 = Math.min(var6, Math.min(var7, var8)) - var1;
            int var13 = Math.max(var6, Math.max(var7, var8)) + var1;
            int var14 = Math.min(var9, Math.min(var10, var11)) - var1;
            int var15 = Math.max(var9, Math.max(var10, var11)) + var1;
            class266.method4731(var12, var14, var13, var15, -49088);
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LFrames;",
      garbageValue = "1905306874"
   )
   @Export("getFrames")
   static Frames getFrames(int var0) {
      Frames var1 = (Frames)Sequence.field3606.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         var1 = class24.method197(Sequence.field3614, Sequence.field3609, var0, false);
         if(var1 != null) {
            Sequence.field3606.put(var1, (long)var0);
         }

         return var1;
      }
   }
}
