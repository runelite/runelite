import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 240707839
   )
   public static int field3378;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("varplayers")
   public static NodeCache varplayers;
   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "Lkg;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1128845797
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "-2106061408"
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "1328932662"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }
}
