import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
public class class252 extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   public static NodeCache field3368;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3370;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   IterableHashTable field3367;

   static {
      field3368 = new NodeCache(64);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "-319250593"
   )
   void method4335(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3367 = class46.method629(var1, this.field3367);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-612375336"
   )
   public int method4336(int var1, int var2) {
      return class112.method2023(this.field3367, var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "176500004"
   )
   public String method4347(int var1, String var2) {
      return class232.method4001(this.field3367, var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "13033"
   )
   public void method4333() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "-1186265880"
   )
   public void method4337(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4335(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)[Lhn;",
      garbageValue = "1400908667"
   )
   public static Permission[] method4350() {
      return new Permission[]{Permission.field3144, Permission.field3143, Permission.field3140, Permission.field3149, Permission.field3142, Permission.field3141};
   }
}
