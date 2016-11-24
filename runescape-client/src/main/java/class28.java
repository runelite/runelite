import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class28 extends Node {
   @ObfuscatedName("ea")
   static SpritePixels[] field657;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1828610225
   )
   int field658;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -582393739
   )
   int field660;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 522442543
   )
   int field661;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -509191837
   )
   int field662;
   @ObfuscatedName("dy")
   @Export("xteaKeys")
   static int[][] xteaKeys;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1309000950"
   )
   public static boolean method632() {
      try {
         if(class138.field1917 == 2) {
            if(null == Buffer.field2288) {
               Buffer.field2288 = class144.method2777(class1.field12, class138.field1918, Frames.field1566);
               if(Buffer.field2288 == null) {
                  return false;
               }
            }

            if(NPC.field760 == null) {
               NPC.field760 = new class60(class138.field1915, class138.field1913);
            }

            if(class138.field1919.method2552(Buffer.field2288, class138.field1914, NPC.field760, 22050)) {
               class138.field1919.method2553();
               class138.field1919.method2550(class101.field1649);
               class138.field1919.method2601(Buffer.field2288, class34.field742);
               class138.field1917 = 0;
               Buffer.field2288 = null;
               NPC.field760 = null;
               class1.field12 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class138.field1919.method2556();
         class138.field1917 = 0;
         Buffer.field2288 = null;
         NPC.field760 = null;
         class1.field12 = null;
      }

      return false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1109455326"
   )
   void method633(int var1, int var2, int var3, int var4) {
      this.field660 = var1;
      this.field662 = var2;
      this.field658 = var3;
      this.field661 = var4;
   }

   class28(int var1, int var2, int var3, int var4) {
      this.field660 = var1;
      this.field662 = var2;
      this.field658 = var3;
      this.field661 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-18"
   )
   public static int method635(CharSequence var0) {
      return class178.method3312(var0, 10, true);
   }
}
