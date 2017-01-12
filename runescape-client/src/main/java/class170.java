import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fe")
public class class170 {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "1616658844"
   )
   public static final boolean method3216(String var0, String var1, String var2, String var3) {
      return var0 != null && null != var2?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass68;B)V",
      garbageValue = "40"
   )
   static final void method3230(class68 var0) {
      var0.field1135 = false;
      if(null != var0.field1136) {
         var0.field1136.field1167 = 0;
      }

      for(class68 var1 = var0.vmethod2671(); null != var1; var1 = var0.vmethod2672()) {
         method3230(var1);
      }

   }
}
