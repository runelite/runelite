import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class139 extends class283 {
   @ObfuscatedName("f")
   @Export("tileOverlayIds")
   static byte[][][] tileOverlayIds;
   @ObfuscatedName("jl")
   @ObfuscatedGetter(
      intValue = 1380868771
   )
   static int field1897;
   @ObfuscatedName("w")
   final boolean field1896;

   public class139(boolean var1) {
      this.field1896 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lkd;Lkd;I)I",
      garbageValue = "-573424448"
   )
   int method3164(ChatPlayer var1, ChatPlayer var2) {
      if(Client.world == var1.world) {
         if(var2.world != Client.world) {
            return this.field1896?-1:1;
         }
      } else if(var2.world == Client.world) {
         return this.field1896?1:-1;
      }

      return this.method5320(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3164((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1705301378"
   )
   public static boolean method3167(int var0) {
      return var0 == WorldMapDecorationType.field2778.rsOrdinal;
   }

   @ObfuscatedName("kf")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "814507959"
   )
   public static boolean method3161() {
      return Client.rights >= 2;
   }
}
