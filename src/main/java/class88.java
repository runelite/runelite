import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public final class class88 {
   @ObfuscatedName("e")
   boolean field1532 = true;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1838885315
   )
   int field1533;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 130856537
   )
   int field1534;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1392151033
   )
   int field1535;
   @ObfuscatedName("ie")
   @ObfuscatedGetter(
      intValue = -1746051767
   )
   static int field1536;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1755682431
   )
   int field1538;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1852973911
   )
   int field1539;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 246233117
   )
   int field1541;

   @ObfuscatedName("a")
   static class80 method2098(class166 var0, int var1, int var2) {
      return !class12.method176(var0, var1, var2)?null:class92.method2178();
   }

   class88(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1539 = var1;
      this.field1533 = var2;
      this.field1541 = var3;
      this.field1534 = var4;
      this.field1535 = var5;
      this.field1538 = var6;
      this.field1532 = var7;
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(Lclass172;B)V",
      garbageValue = "-58"
   )
   static void method2099(class172 var0) {
      class172 var1 = var0.field2762 == -1?null:class92.method2180(var0.field2762);
      int var2;
      int var3;
      if(var1 == null) {
         var2 = class6.field107;
         var3 = class31.field749;
      } else {
         var2 = var1.field2752;
         var3 = var1.field2759;
      }

      class3.method48(var0, var2, var3, false);
      class49.method1030(var0, var2, var3);
   }
}
