import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("Renderable")
public abstract class class88 extends class207 {
   @ObfuscatedName("cz")
   @ObfuscatedGetter(
      intValue = -1994798555
   )
   @Export("modelHeight")
   public int field1538 = 1000;

   @ObfuscatedName("af")
   void vmethod2416(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class108 var10 = this.vmethod1990();
      if(var10 != null) {
         this.field1538 = var10.field1538;
         var10.vmethod2416(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Lclass108;",
      garbageValue = "503322838"
   )
   @Export("getModel")
   protected class108 vmethod1990() {
      return null;
   }
}
