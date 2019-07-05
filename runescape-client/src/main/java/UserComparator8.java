import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
@Implements("UserComparator8")
public class UserComparator8 extends AbstractUserComparator {
   @ObfuscatedName("m")
   final boolean field940;

   public UserComparator8(boolean var1) {
      this.field940 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lke;Lke;B)I",
      garbageValue = "0"
   )
   int method350(Buddy var1, Buddy var2) {
      if (Client.worldId == var1.world0) {
         if (var2.world0 != Client.worldId) {
            return this.field940 ? -1 : 1;
         }
      } else if (var2.world0 == Client.worldId) {
         return this.field940 ? 1 : -1;
      }

      return this.method12(var1, var2);
   }

   @Export("compare")
   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.method350((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("ke")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   static final void method3349() {
      Client.field129 = Client.cycleCntr;
      VertexNormal.field945 = true;
   }
}
