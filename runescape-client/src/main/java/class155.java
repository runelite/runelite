import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class155 extends class283 {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lho;"
   )
   public static class224 field2105;
   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexSoundEffects")
   static IndexData indexSoundEffects;
   @ObfuscatedName("ck")
   @ObfuscatedSignature(
      signature = "Lia;"
   )
   @Export("indexTrack1")
   static IndexData indexTrack1;
   @ObfuscatedName("b")
   final boolean field2102;

   public class155(boolean var1) {
      this.field2102 = var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lku;Lku;I)I",
      garbageValue = "-2140606897"
   )
   int method3149(ChatPlayer var1, ChatPlayer var2) {
      return var2.rank != var1.rank ?(this.field2102?var1.rank - var2.rank :var2.rank - var1.rank):this.method5214(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3149((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "-82626173"
   )
   public static byte[] method3154() {
      byte[] var0 = new byte[24];

      try {
         class166.randomDat.seek(0L);
         class166.randomDat.read(var0);

         int var1;
         for(var1 = 0; var1 < 24 && var0[var1] == 0; ++var1) {
            ;
         }

         if(var1 >= 24) {
            throw new IOException();
         }
      } catch (Exception var4) {
         for(int var2 = 0; var2 < 24; ++var2) {
            var0[var2] = -1;
         }
      }

      return var0;
   }
}
