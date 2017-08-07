import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("is")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("varplayers")
   static NodeCache varplayers;
   @ObfuscatedName("fd")
   static byte[][] field3269;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1383272857
   )
   public static int field3270;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("varplayer_ref")
   static IndexDataBase varplayer_ref;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1526769239
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfh;IB)V",
      garbageValue = "103"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;B)V",
      garbageValue = "47"
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
