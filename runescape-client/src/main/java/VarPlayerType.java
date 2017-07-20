import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("varplayers")
   public static NodeCache varplayers;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("varplayer_ref")
   public static IndexDataBase varplayer_ref;
   @ObfuscatedName("ny")
   @ObfuscatedGetter(
      intValue = -2132107025
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1699515887
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "1688301855"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "960029405"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.decode(var1, var2);
      }
   }
}
