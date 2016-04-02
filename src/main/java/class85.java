import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ch")
@Implements("Renderable")
public abstract class class85 extends class204 {
   @ObfuscatedName("cm")
   @ObfuscatedGetter(
      intValue = 754566913
   )
   @Export("modelHeight")
   public int field1438 = 1000;
   @ObfuscatedName("dk")
   @ObfuscatedGetter(
      intValue = 473997581
   )
   @Export("baseX")
   static int field1439;

   @ObfuscatedName("ap")
   void vmethod2392(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class105 var10 = this.vmethod1921();
      if(null != var10) {
         this.field1438 = var10.field1438;
         var10.vmethod2392(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("f")
   protected class105 vmethod1921() {
      return null;
   }
}
