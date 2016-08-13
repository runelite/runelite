import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -373759415
   )
   int field1698;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1447933277
   )
   int field1699;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -864284919
   )
   int field1700;
   @ObfuscatedName("gg")
   @ObfuscatedGetter(
      intValue = 203936363
   )
   @Export("plane")
   static int plane;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -779095069
   )
   int field1703;
   @ObfuscatedName("o")
   static int[][][] field1704;

   VertexNormal(VertexNormal var1) {
      this.field1703 = var1.field1703;
      this.field1699 = var1.field1699;
      this.field1700 = var1.field1700;
      this.field1698 = var1.field1698;
   }

   VertexNormal() {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass69;B)V",
      garbageValue = "2"
   )
   static final void method2284(class69 var0) {
      var0.field1336 = false;
      if(null != var0.field1334) {
         var0.field1334.field1333 = 0;
      }

      for(class69 var1 = var0.vmethod3870(); var1 != null; var1 = var0.vmethod3871()) {
         method2284(var1);
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-834878277"
   )
   public static boolean method2285() {
      return class186.field3010 != 0?true:class59.field1266.method3756();
   }
}
