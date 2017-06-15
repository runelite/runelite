import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -84778561
   )
   @Export("y")
   int y;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -942021299
   )
   @Export("x")
   int x;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 583486269
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 43215933
   )
   @Export("z")
   int z;

   VertexNormal() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "112"
   )
   static int method2490(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class223.method3959(class83.intStack[--class83.intStackSize]);
      } else {
         var3 = var2?class43.field582:class31.field457;
      }

      if(var0 == 1927) {
         if(class83.field1336 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2706 == null) {
            return 0;
         } else {
            class69 var4 = new class69();
            var4.field822 = var3;
            var4.field821 = var3.field2706;
            var4.field830 = class83.field1336 + 1;
            Client.field1105.method3505(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)I",
      garbageValue = "1417242193"
   )
   public static int method2491(String var0) {
      return var0.length() + 2;
   }

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }
}
