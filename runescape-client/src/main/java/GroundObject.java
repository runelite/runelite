import java.awt.FontMetrics;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("de")
@Implements("GroundObject")
public final class GroundObject {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1846575161
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1224047661
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -425840813
   )
   @Export("y")
   int y;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2054426095
   )
   @Export("renderInfoBitPacked")
   int renderInfoBitPacked;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -686534875
   )
   @Export("floor")
   int floor;
   @ObfuscatedName("dv")
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("j")
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("aw")
   static FontMetrics field1880;

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1652964262"
   )
   static final void method2496(int var0, int var1) {
      if(Client.field930 == 2) {
         class24.method201((Client.field933 - class61.baseX << 7) + Client.field936, Client.field937 + (Client.field1136 - class23.baseY << 7), Client.field979 * 2);
         if(Client.field1020 > -1 && Client.gameCycle % 20 < 10) {
            class60.field732[0].method5097(Client.field1020 + var0 - 12, var1 + Client.field1163 - 28);
         }

      }
   }
}
