import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1536394269
   )
   public static int field3351;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("varplayers")
   public static NodeCache varplayers;
   @ObfuscatedName("lv")
   @ObfuscatedGetter(
      intValue = 688460923
   )
   static int field3350;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -648830709
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   public VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgj;I)V",
      garbageValue = "-36074608"
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgj;II)V",
      garbageValue = "1692997891"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }
}
