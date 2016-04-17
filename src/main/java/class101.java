import java.awt.Component;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cw")
@Implements("Tile")
public final class class101 extends class208 {
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1165593907
   )
   int field1734;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2009149543
   )
   @Export("x")
   int field1735;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1173976085
   )
   @Export("y")
   int field1736;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -2048833915
   )
   int field1737;
   @ObfuscatedName("y")
   class89 field1738;
   @ObfuscatedName("k")
   class97 field1739;
   @ObfuscatedName("r")
   class87 field1740;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1692486595
   )
   @Export("plane")
   int field1741;
   @ObfuscatedName("p")
   class94 field1742;
   @ObfuscatedName("n")
   boolean field1743;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1027340907
   )
   int field1744;
   @ObfuscatedName("x")
   @Export("objects")
   class98[] field1745 = new class98[5];
   @ObfuscatedName("z")
   int[] field1746 = new int[5];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 996706625
   )
   int field1747;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1335040197
   )
   int field1748;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -340264769
   )
   int field1749;
   @ObfuscatedName("u")
   boolean field1750;
   @ObfuscatedName("m")
   @Export("itemLayer")
   class99 field1751;
   @ObfuscatedName("q")
   class93 field1753;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 958702655
   )
   int field1754;
   @ObfuscatedName("g")
   boolean field1755;
   @ObfuscatedName("b")
   class101 field1756;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1612777779
   )
   int field1758 = 0;

   class101(int var1, int var2, int var3) {
      this.field1737 = this.field1741 = var1;
      this.field1735 = var2;
      this.field1736 = var3;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-48"
   )
   public static void method2371(Component var0) {
      var0.removeMouseListener(class140.field2145);
      var0.removeMouseMotionListener(class140.field2145);
      var0.removeFocusListener(class140.field2145);
      class140.field2148 = 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "1675876249"
   )
   static void method2372(byte[] var0) {
      class119 var1 = new class119(var0);
      var1.field1992 = var0.length - 2;
      class76.field1384 = var1.method2615();
      class76.field1389 = new int[class76.field1384];
      class76.field1387 = new int[class76.field1384];
      class126.field2042 = new int[class76.field1384];
      class77.field1397 = new int[class76.field1384];
      class76.field1388 = new byte[class76.field1384][];
      var1.field1992 = var0.length - 7 - class76.field1384 * 8;
      class76.field1385 = var1.method2615();
      class103.field1773 = var1.method2615();
      int var2 = (var1.method2613() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class76.field1384; ++var3) {
         class76.field1389[var3] = var1.method2615();
      }

      for(var3 = 0; var3 < class76.field1384; ++var3) {
         class76.field1387[var3] = var1.method2615();
      }

      for(var3 = 0; var3 < class76.field1384; ++var3) {
         class126.field2042[var3] = var1.method2615();
      }

      for(var3 = 0; var3 < class76.field1384; ++var3) {
         class77.field1397[var3] = var1.method2615();
      }

      var1.field1992 = var0.length - 7 - class76.field1384 * 8 - (var2 - 1) * 3;
      class8.field153 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class8.field153[var3] = var1.method2617();
         if(0 == class8.field153[var3]) {
            class8.field153[var3] = 1;
         }
      }

      var1.field1992 = 0;

      for(var3 = 0; var3 < class76.field1384; ++var3) {
         int var4 = class126.field2042[var3];
         int var5 = class77.field1397[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class76.field1388[var3] = var7;
         int var8 = var1.method2613();
         int var9;
         if(0 == var8) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.method2699();
            }
         } else if(1 == var8) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var10 * var4 + var9] = var1.method2699();
               }
            }
         }
      }

   }
}
