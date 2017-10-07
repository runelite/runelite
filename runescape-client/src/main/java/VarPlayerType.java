import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("varplayers")
   static NodeCache varplayers;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("varplayer_ref")
   static IndexDataBase varplayer_ref;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -921575957
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "-222142095"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfg;B)V",
      garbageValue = "99"
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
