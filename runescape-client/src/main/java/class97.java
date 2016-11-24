import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
public class class97 implements class165 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -718561761
   )
   final int field1623;
   @ObfuscatedName("d")
   public static final class97 field1624 = new class97(2, 1);
   @ObfuscatedName("m")
   public static final class97 field1625 = new class97(0, 2);
   @ObfuscatedName("h")
   public static final class97 field1626 = new class97(3, 3);
   @ObfuscatedName("n")
   public static final class97 field1627 = new class97(1, 0);
   @ObfuscatedName("f")
   static String field1629;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1550205641
   )
   public final int field1632;

   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "0"
   )
   class97(int var1, int var2) {
      this.field1632 = var1;
      this.field1623 = var2;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-1187750909"
   )
   static final void method1953(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field419.method2466(); var10 != null; var10 = (class25)Client.field419.method2461()) {
         if(var10.field573 == var0 && var1 == var10.field578 && var2 == var10.field574 && var10.field577 == var3) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class25();
         var9.field573 = var0;
         var9.field577 = var3;
         var9.field578 = var1;
         var9.field574 = var2;
         class1.method21(var9);
         Client.field419.method2454(var9);
      }

      var9.field579 = var4;
      var9.field580 = var5;
      var9.field583 = var6;
      var9.field581 = var7;
      var9.field582 = var8;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1689281815"
   )
   public int vmethod4132() {
      return this.field1623;
   }
}
