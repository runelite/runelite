import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ik")
@Implements("VarPlayerType")
public class VarPlayerType extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("varplayers")
   static NodeCache varplayers;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1996318971
   )
   public static int field3283;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lif;"
   )
   public static IndexDataBase field3286;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -241820073
   )
   @Export("configType")
   public int configType;

   static {
      varplayers = new NodeCache(64);
   }

   VarPlayerType() {
      this.configType = 0;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfe;II)V",
      garbageValue = "327096854"
   )
   @Export("decode")
   void decode(Buffer var1, int var2) {
      if(var2 == 5) {
         this.configType = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfe;B)V",
      garbageValue = "11"
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
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-408011722"
   )
   public static String method4239(CharSequence var0) {
      String var1 = PendingSpawn.method1478(class82.method1582(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }
}
