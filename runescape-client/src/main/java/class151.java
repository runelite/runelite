import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
public class class151 extends class297 {
   @ObfuscatedName("cj")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexSprites")
   static IndexData indexSprites;
   @ObfuscatedName("o")
   final boolean field2147;

   public class151(boolean var1) {
      this.field2147 = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lkv;Lkv;I)I",
      garbageValue = "-419852224"
   )
   int method3123(ChatPlayer var1, ChatPlayer var2) {
      if(Client.world == var1.world) {
         if(var2.world != Client.world) {
            return this.field2147?-1:1;
         }
      } else if(var2.world == Client.world) {
         return this.field2147?1:-1;
      }

      return this.method5282(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3123((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljf;I)V",
      garbageValue = "-1683734580"
   )
   public static void method3130(IndexDataBase var0) {
      VarPlayerType.varplayer_ref = var0;
      class289.field3777 = VarPlayerType.varplayer_ref.fileCount(16);
   }
}
