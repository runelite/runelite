import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public final class class92 {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1371074865
   )
   int field1607;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 334370885
   )
   int field1608;
   @ObfuscatedName("b")
   boolean field1609 = true;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1441106553
   )
   int field1610;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 888220753
   )
   int field1612;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1235296181
   )
   int field1613;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1269975215
   )
   int field1614;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "112"
   )
   static String method2126(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class92(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1613 = var1;
      this.field1607 = var2;
      this.field1608 = var3;
      this.field1614 = var4;
      this.field1610 = var5;
      this.field1612 = var6;
      this.field1609 = var7;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-2343"
   )
   static void method2127() {
      Object var0 = class173.field2746;
      synchronized(class173.field2746) {
         if(class173.field2743 == 0) {
            class54.field1146.method2910(new class173(), 5);
         }

         class173.field2743 = 600;
      }
   }
}
