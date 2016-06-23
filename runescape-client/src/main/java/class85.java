import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("Renderable")
public abstract class class85 extends class204 {
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -374201515
   )
   @Export("modelHeight")
   public int field1468 = 1000;

   @ObfuscatedName("eh")
   @ObfuscatedSignature(
      signature = "(Lclass173;IB)Ljava/lang/String;",
      garbageValue = "74"
   )
   static String method1967(class173 var0, int var1) {
      return !class167.method3361(class18.method205(var0), var1) && null == var0.field2859?null:(null != var0.field2854 && var0.field2854.length > var1 && null != var0.field2854[var1] && var0.field2854[var1].trim().length() != 0?var0.field2854[var1]:null);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)Lclass105;",
      garbageValue = "1006"
   )
   @Export("getModel")
   protected class105 vmethod1968() {
      return null;
   }

   @ObfuscatedName("ai")
   void vmethod2396(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class105 var10 = this.vmethod1968();
      if(var10 != null) {
         this.field1468 = var10.field1468;
         var10.vmethod2396(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }
}
