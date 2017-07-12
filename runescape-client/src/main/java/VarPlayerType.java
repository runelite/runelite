import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("a")
   @Export("varplayers")
   public static NodeCache varplayers;
   @ObfuscatedName("i")
   @Export("varplayer_ref")
   public static IndexDataBase varplayer_ref;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 971956589
   )
   public static int field3289;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2137069147
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   public VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1931581430"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "-52"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.decode(var1, var2);
      }
   }
}
