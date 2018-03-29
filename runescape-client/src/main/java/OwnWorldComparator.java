import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bo")
@Implements("OwnWorldComparator")
public class OwnWorldComparator implements Comparator {
   @ObfuscatedName("ps")
   @ObfuscatedSignature(
      signature = "Ldz;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("c")
   boolean field854;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ll;Ll;I)I",
      garbageValue = "-654494058"
   )
   int method1183(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      if(var2.world == var1.world) {
         return 0;
      } else {
         if(this.field854) {
            if(Client.world == var1.world) {
               return -1;
            }

            if(var2.world == Client.world) {
               return 1;
            }
         }

         return var1.world < var2.world?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method1183((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
