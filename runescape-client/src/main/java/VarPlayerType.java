import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1170437943
   )
   public static int field3344;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("varplayers")
   public static NodeCache varplayers;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 551148241
   )
   public static int field3342;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 2139471647
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
      signature = "(Lfv;I)V",
      garbageValue = "1081552324"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;II)V",
      garbageValue = "1369179074"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Ljw;",
      garbageValue = "956826945"
   )
   public static class285 method4465(int var0) {
      class285[] var1 = class100.method1969();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class285 var3 = var1[var2];
         if(var0 == var3.field3785) {
            return var3;
         }
      }

      return null;
   }
}
