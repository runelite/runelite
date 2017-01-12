import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("x")
   Deque field1191 = new Deque();
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1698385573
   )
   int field1192;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1089799925
   )
   int field1193 = 0;
   @ObfuscatedName("f")
   double field1194 = 1.0D;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1934178515
   )
   int field1195 = 128;
   @ObfuscatedName("d")
   class182 field1196;
   @ObfuscatedName("u")
   class79[] field1198;
   @ObfuscatedName("r")
   static int[] field1199;
   @ObfuscatedName("ep")
   static ModIcon[] field1200;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "111"
   )
   public boolean vmethod1855(int var1) {
      return this.field1198[var1].field1306;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method1386(double var1) {
      this.field1194 = var1;
      this.method1391();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1843347045"
   )
   public int vmethod1854(int var1) {
      return null != this.field1198[var1]?this.field1198[var1].field1301:0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1566895212"
   )
   public boolean vmethod1856(int var1) {
      return this.field1195 == 64;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1371368845"
   )
   public void method1391() {
      for(int var1 = 0; var1 < this.field1198.length; ++var1) {
         if(this.field1198[var1] != null) {
            this.field1198[var1].method1502();
         }
      }

      this.field1191 = new Deque();
      this.field1193 = this.field1192;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "2073707454"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1198[var1];
      if(null != var2) {
         if(null != var2.field1313) {
            this.field1191.method2387(var2);
            var2.field1314 = true;
            return var2.field1313;
         }

         boolean var3 = var2.method1504(this.field1194, this.field1195, this.field1196);
         if(var3) {
            if(this.field1193 == 0) {
               class79 var4 = (class79)this.field1191.method2386();
               var4.method1502();
            } else {
               --this.field1193;
            }

            this.field1191.method2387(var2);
            var2.field1314 = true;
            return var2.field1313;
         }
      }

      return null;
   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IDI)V",
      garbageValue = "128"
   )
   public TextureProvider(class182 var1, class182 var2, int var3, double var4, int var6) {
      this.field1196 = var2;
      this.field1192 = var3;
      this.field1193 = this.field1192;
      this.field1194 = var4;
      this.field1195 = var6;
      int[] var7 = var1.method3314(0);
      int var8 = var7.length;
      this.field1198 = new class79[var1.method3323(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method3272(0, var7[var9]));
         this.field1198[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-63"
   )
   public void method1402(int var1) {
      for(int var2 = 0; var2 < this.field1198.length; ++var2) {
         class79 var3 = this.field1198[var2];
         if(null != var3 && var3.field1311 != 0 && var3.field1314) {
            var3.method1503(var1);
            var3.field1314 = false;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)LSpritePixels;",
      garbageValue = "1819430786"
   )
   public static SpritePixels method1410(class182 var0, int var1, int var2) {
      return !XGrandExchangeOffer.method60(var0, var1, var2)?null:ChatMessages.method850();
   }
}
