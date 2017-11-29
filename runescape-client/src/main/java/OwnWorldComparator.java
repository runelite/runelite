import java.util.Comparator;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("OwnWorldComparator")
public class OwnWorldComparator implements Comparator {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   static IndexDataBase field864;
   @ObfuscatedName("d")
   boolean field863;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ly;Ly;B)I",
      garbageValue = "32"
   )
   int method1177(GrandExchangeEvent var1, GrandExchangeEvent var2) {
      if(var2.world == var1.world) {
         return 0;
      } else {
         if(this.field863) {
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
      return this.method1177((GrandExchangeEvent)var1, (GrandExchangeEvent)var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-418853766"
   )
   static void method1186(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if(World.field1220[var5] != var0) {
            var2[var4] = World.field1220[var5];
            var3[var4] = World.field1219[var5];
            ++var4;
         }
      }

      World.field1220 = var2;
      World.field1219 = var3;
      MouseRecorder.method1127(World.worldList, 0, World.worldList.length - 1, World.field1220, World.field1219);
   }
}
