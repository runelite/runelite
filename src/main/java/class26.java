import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class26 {
   @ObfuscatedName("fd")
   @ObfuscatedGetter(
      intValue = 1675624939
   )
   @Export("cameraX")
   static int field673;
   @ObfuscatedName("ad")
   static int[] field676;

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(Lclass66;B)V",
      garbageValue = "12"
   )
   static final void method720(class66 var0) {
      var0.field1274 = false;
      if(var0.field1271 != null) {
         var0.field1271.field1270 = 0;
      }

      for(class66 var1 = var0.vmethod3806(); null != var1; var1 = var0.vmethod3797()) {
         method720(var1);
      }

   }
}
