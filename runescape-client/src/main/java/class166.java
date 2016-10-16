import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fz")
public final class class166 {
   @ObfuscatedName("ft")
   @ObfuscatedGetter(
      intValue = -530970853
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("ey")
   static ModIcon[] field2699;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-906752708"
   )
   public static boolean method3195(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-533429245"
   )
   static final void method3214() {
      for(int var0 = 0; var0 < Client.field309; ++var0) {
         int var1 = Client.field307[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(null != var2) {
            class16.method188(var2, var2.composition.field902);
         }
      }

   }

   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "74"
   )
   static final void method3218(String var0) {
      if(!var0.equals("")) {
         Client.field300.method2748(150);
         Client.field300.method2467(class113.method2395(var0));
         Client.field300.method2472(var0);
      }
   }
}
