import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1095778789
   )
   @Export("y")
   int y;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1059862525
   )
   @Export("z")
   int z;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1596640761
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("o")
   public static class123[] field1994;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1398382327
   )
   @Export("x")
   int x;

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   VertexNormal() {
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1952505812"
   )
   static final void method2620() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               if(Client.field1037 != -1) {
                  if(var1 == Client.field1037) {
                     Client.field1037 = var1 + 1;
                  } else if(Client.field1037 == var1 + 1) {
                     Client.field1037 = var1;
                  }
               }

               var0 = false;
            }
         }
      }

   }
}
