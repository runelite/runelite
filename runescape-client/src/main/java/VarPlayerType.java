import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("varplayer_ref")
   public static IndexDataBase varplayer_ref;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1871218061
   )
   public static int field3446;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("varplayers")
   public static NodeCache varplayers;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 948611537
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "-87"
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "95"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }
}
