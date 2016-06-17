import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
public abstract class class107 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 838376127
   )
   public int field1860;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1616702191
   )
   public int field1861;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1301630879
   )
   public int field1862;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1321771441
   )
   static int field1863;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1497834813
   )
   public int field1864;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIILclass108;I)Z",
      garbageValue = "504031139"
   )
   public abstract boolean vmethod2385(int var1, int var2, int var3, class108 var4);

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1523267400"
   )
   static void method2386(int var0, int var1, int var2, int var3) {
      class173 var4 = class165.method3247(var0, var1);
      if(var4 != null && var4.field2747 != null) {
         class0 var5 = new class0();
         var5.field10 = var4;
         var5.field12 = var4.field2747;
         class90.method2092(var5, 200000);
      }

      client.field319 = var3;
      client.field442 = true;
      class3.field56 = var0;
      client.field443 = var1;
      class138.field2115 = var2;
      class4.method37(var4);
   }
}
