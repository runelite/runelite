import java.util.Comparator;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bu")
@Implements("OwnWorldComparator")
public class OwnWorldComparator implements Comparator {
   @ObfuscatedName("t")
   boolean field846;

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "1992914999"
   )
   int method1246(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      if(var2.world == var1.world) {
         return 0;
      } else {
         if(this.field846) {
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

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1246((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }
}
