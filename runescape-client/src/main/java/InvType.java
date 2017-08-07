import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("im")
@Implements("InvType")
public class InvType extends CacheableNode {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1521275737
   )
   @Export("canvasHeight")
   protected static int canvasHeight;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("inventoryCache")
   public static NodeCache inventoryCache;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   public static IndexDataBase field3265;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1441477987
   )
   @Export("size")
   public int size;

   static {
      inventoryCache = new NodeCache(64);
   }

   public InvType() {
      this.size = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfh;II)V",
      garbageValue = "-559368762"
   )
   void method4266(Buffer var1, int var2) {
      if(var2 == 2) {
         this.size = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "-2140478677"
   )
   @Export("decode")
   public void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4266(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "4"
   )
   public static boolean method4272(char var0) {
      return var0 >= 65 && var0 <= 90 || var0 >= 97 && var0 <= 122;
   }
}
