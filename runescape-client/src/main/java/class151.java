import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ea")
public class class151 extends class297 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = -8873859351953491735L
   )
   public static long field2101;
   @ObfuscatedName("t")
   final boolean field2102;

   public class151(boolean var1) {
      this.field2102 = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lkp;Lkp;S)I",
      garbageValue = "6682"
   )
   int method3119(ChatPlayer var1, ChatPlayer var2) {
      if(Client.world == var1.world) {
         if(var2.world != Client.world) {
            return this.field2102?-1:1;
         }
      } else if(var2.world == Client.world) {
         return this.field2102?1:-1;
      }

      return this.method5273(var1, var2);
   }

   public int compare(Object var1, Object var2) {
      return this.method3119((ChatPlayer)var1, (ChatPlayer)var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "699240423"
   )
   public static void method3120() {
      WorldMapRegion.field457.method3950(5);
      WorldMapRegion.field462.method3950(5);
   }
}
