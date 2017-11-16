import java.awt.Image;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("varplayer_ref")
   public static IndexDataBase varplayer_ref;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1105227355
   )
   public static int field3338;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("varplayers")
   public static NodeCache varplayers;
   @ObfuscatedName("ao")
   static Image field3337;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1046914783
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "1440202247"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfs;IB)V",
      garbageValue = "126"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Lii;",
      garbageValue = "-110301867"
   )
   public static class258 method4260(int var0) {
      class258 var1 = (class258)class258.field3435.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class258.field3438.getConfigData(11, var0);
         var1 = new class258();
         if(var2 != null) {
            var1.method4427(new Buffer(var2));
         }

         var1.method4426();
         class258.field3435.put(var1, (long)var0);
         return var1;
      }
   }
}
