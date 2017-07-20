import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
@Implements("BaseVarType")
public enum BaseVarType implements RSEnum {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   @Export("INTEGER")
   INTEGER(1, 0, Integer.class, new class2()),
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   @Export("LONG")
   LONG(0, 1, Long.class, new class3()),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   @Export("STRING")
   STRING(2, 2, String.class, new class5());

   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1915927309
   )
   final int field21;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1542253373
   )
   final int field25;

   @ObfuscatedSignature(
      signature = "(IILjava/lang/Class;Lc;)V"
   )
   BaseVarType(int var3, int var4, Class var5, class0 var6) {
      this.field25 = var3;
      this.field21 = var4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1443879177"
   )
   public int rsOrdinal() {
      return this.field21;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "254328503"
   )
   public static int method16(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-1486185323"
   )
   static int method14(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("fl")
   @ObfuscatedSignature(
      signature = "(Lcm;II)V",
      garbageValue = "793744238"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class22.method157(var0.x, var0.y, var1);
   }
}
