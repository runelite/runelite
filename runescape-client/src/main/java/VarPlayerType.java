import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("varplayer_ref")
   static IndexDataBase varplayer_ref;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("varplayers")
   public static NodeCache varplayers;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1618823997
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lgh;I)V",
      garbageValue = "-735230306"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgh;IB)V",
      garbageValue = "-103"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Ljk;",
      garbageValue = "1386430881"
   )
   public static class262 method4426(int var0) {
      class262 var1 = (class262)class262.field3464.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class262.field3467.getConfigData(11, var0);
         var1 = new class262();
         if(var2 != null) {
            var1.method4573(new Buffer(var2));
         }

         var1.method4572();
         class262.field3464.put(var1, (long)var0);
         return var1;
      }
   }
}
