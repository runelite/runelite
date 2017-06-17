import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
public final class class82 extends Node {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 704307743
   )
   int field1306;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 272055805
   )
   int field1307;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 717058801
   )
   int field1308;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 573092601
   )
   int field1309;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1512017617
   )
   int field1310;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1067688845
   )
   int field1311;
   @ObfuscatedName("as")
   @Export("authCode")
   static String authCode;
   @ObfuscatedName("f")
   class117 field1313;
   @ObfuscatedName("p")
   static Deque field1314;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1532687559
   )
   int field1315;
   @ObfuscatedName("q")
   int[] field1316;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1282945037
   )
   int field1317;
   @ObfuscatedName("a")
   class117 field1318;
   @ObfuscatedName("g")
   ObjectComposition field1319;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 621215589
   )
   int field1320;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -993986701
   )
   int field1322;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-753262682"
   )
   void method1514() {
      int var1 = this.field1308;
      ObjectComposition var2 = this.field1319.getImpostor();
      if(var2 != null) {
         this.field1308 = var2.ambientSoundId;
         this.field1311 = var2.field3466 * 128;
         this.field1307 = var2.field3488;
         this.field1315 = var2.field3442;
         this.field1316 = var2.field3490;
      } else {
         this.field1308 = -1;
         this.field1311 = 0;
         this.field1307 = 0;
         this.field1315 = 0;
         this.field1316 = null;
      }

      if(var1 != this.field1308 && this.field1313 != null) {
         WorldMapType1.field442.method1780(this.field1313);
         this.field1313 = null;
      }

   }

   @ObfuscatedName("ij")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass210;S)V",
      garbageValue = "27169"
   )
   static final void method1523(int var0, int var1, int var2, int var3, SpritePixels var4, class210 var5) {
      if(var4 != null) {
         int var6 = Client.mapScale + Client.mapAngle & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class136.SINE[var6];
            int var9 = class136.COSINE[var6];
            var8 = var8 * 256 / (Client.mapScaleDelta + 256);
            var9 = var9 * 256 / (Client.mapScaleDelta + 256);
            int var10 = var3 * var8 + var9 * var2 >> 16;
            int var11 = var9 * var3 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method4990(var10 + var5.field2607 / 2 - var4.maxWidth / 2, var5.field2611 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2607, var5.field2611, var5.field2609, var5.field2608);
            } else {
               var4.method4950(var0 + var5.field2607 / 2 + var10 - var4.maxWidth / 2, var1 + var5.field2611 / 2 - var11 - var4.maxHeight / 2);
            }
         }
      }

   }

   static {
      field1314 = new Deque();
   }
}
