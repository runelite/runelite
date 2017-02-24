import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1966651911
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 608913587
   )
   @Export("height")
   int height;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 714805795
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1647496229
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -731917617
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1276934755
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 533336611
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 549059217
   )
   int field1624;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2004806303
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 193197027
   )
   @Export("hash")
   public int hash = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1257433039
   )
   int field1628;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2035961657
   )
   @Export("flags")
   int flags = 0;
   @ObfuscatedName("qn")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -763654325
   )
   @Export("x")
   int x;

   @ObfuscatedName("ct")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-895648730"
   )
   static final void method1981() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[1 + var1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[1 + var1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[1 + var1];
               Client.menuTypes[1 + var1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[1 + var1];
               Client.menuActionParams1[1 + var1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[1 + var1];
               Client.menuIdentifiers[var1 + 1] = var4;
               if(Client.field433 != -1) {
                  if(var1 == Client.field433) {
                     Client.field433 = var1 + 1;
                  } else if(1 + var1 == Client.field433) {
                     Client.field433 = var1;
                  }
               }

               var0 = false;
            }
         }
      }

   }
}
