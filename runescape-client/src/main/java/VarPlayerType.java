import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("varplayer_ref")
   public static IndexDataBase varplayer_ref;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1578546595
   )
   public static int field3357;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("varplayers")
   public static NodeCache varplayers;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1494274557
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   public VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "970060912"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfr;IB)V",
      garbageValue = "-123"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-462361013"
   )
   public static int method4439() {
      return ++MouseInput.mouseIdleTicks - 1;
   }
}
