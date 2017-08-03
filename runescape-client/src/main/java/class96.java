import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
public class class96 {
   @ObfuscatedName("x")
   static byte[] field1471;
   @ObfuscatedName("y")
   static byte[] field1467;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "[Lfw;"
   )
   static Buffer[] field1469;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -280651609
   )
   static int field1470;
   @ObfuscatedName("v")
   static int[] field1468;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -945733449
   )
   static int field1472;
   @ObfuscatedName("i")
   static int[] field1480;
   @ObfuscatedName("r")
   static int[] field1476;
   @ObfuscatedName("g")
   static int[] field1475;
   @ObfuscatedName("s")
   static int[] field1466;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1260675089
   )
   static int field1477;
   @ObfuscatedName("p")
   static int[] field1478;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lfw;"
   )
   static Buffer field1479;
   @ObfuscatedName("ku")
   @ObfuscatedGetter(
      intValue = -1448466717
   )
   static int field1481;

   static {
      field1471 = new byte[2048];
      field1467 = new byte[2048];
      field1469 = new Buffer[2048];
      field1470 = 0;
      field1468 = new int[2048];
      field1472 = 0;
      field1480 = new int[2048];
      field1476 = new int[2048];
      field1475 = new int[2048];
      field1466 = new int[2048];
      field1477 = 0;
      field1478 = new int[2048];
      field1479 = new Buffer(new byte[5000]);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lev;IIII)V",
      garbageValue = "-500500788"
   )
   public static final void method1799(Model var0, int var1, int var2, int var3) {
      if(ScriptState.method1057(var0, var1, var2, var3)) {
         class7.field224.method3577(new class10(var0, var1, var2, var3, -65281));
      } else if(class11.field252 == class7.field227) {
         class7.field224.method3577(new class10(var0, var1, var2, var3, -16776961));
      }

   }
}
