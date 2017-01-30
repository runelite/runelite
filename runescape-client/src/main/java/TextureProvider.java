import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bh")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("g")
   Deque field1198 = new Deque();
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -457006225
   )
   int field1200 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1225698173
   )
   int field1201 = 128;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1958741969
   )
   int field1202;
   @ObfuscatedName("j")
   class182 field1203;
   @ObfuscatedName("p")
   class79[] field1207;
   @ObfuscatedName("d")
   double field1208 = 1.0D;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method1431(double var1) {
      this.field1208 = var1;
      this.method1434();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "1782998639"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1207[var1];
      if(var2 != null) {
         if(var2.field1307 != null) {
            this.field1198.method2408(var2);
            var2.field1313 = true;
            return var2.field1307;
         }

         boolean var3 = var2.method1541(this.field1208, this.field1201, this.field1203);
         if(var3) {
            if(this.field1200 == 0) {
               class79 var4 = (class79)this.field1198.method2411();
               var4.method1543();
            } else {
               --this.field1200;
            }

            this.field1198.method2408(var2);
            var2.field1313 = true;
            return var2.field1307;
         }
      }

      return null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2061564768"
   )
   public int vmethod1900(int var1) {
      return null != this.field1207[var1]?this.field1207[var1].field1304:0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-30"
   )
   public void method1434() {
      for(int var1 = 0; var1 < this.field1207.length; ++var1) {
         if(null != this.field1207[var1]) {
            this.field1207[var1].method1543();
         }
      }

      this.field1198 = new Deque();
      this.field1200 = this.field1202;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "-40"
   )
   public boolean vmethod1902(int var1) {
      return this.field1201 == 64;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1943117439"
   )
   public void method1437(int var1) {
      for(int var2 = 0; var2 < this.field1207.length; ++var2) {
         class79 var3 = this.field1207[var2];
         if(null != var3 && var3.field1310 != 0 && var3.field1313) {
            var3.method1544(var1);
            var3.field1313 = false;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass182;Lclass182;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class182 var1, class182 var2, int var3, double var4, int var6) {
      this.field1203 = var2;
      this.field1202 = var3;
      this.field1200 = this.field1202;
      this.field1208 = var4;
      this.field1201 = var6;
      int[] var7 = var1.method3280(0);
      int var8 = var7.length;
      this.field1207 = new class79[var1.method3309(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1207[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "251270991"
   )
   static final void method1442() {
      for(int var0 = 0; var0 < Client.field316; ++var0) {
         int var1 = Client.field419[var0];
         NPC var2 = Client.cachedNPCs[var1];
         if(var2 != null) {
            class22.method211(var2, var2.composition.field2999);
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-988273456"
   )
   static boolean method1451(String var0, int var1) {
      return Ignore.method191(var0, var1, "openjs");
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IS)LSpotanim;",
      garbageValue = "-4792"
   )
   public static Spotanim method1452(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.field2797.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class3.field38.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.field2790 = var0;
         if(null != var2) {
            var1.method3454(new Buffer(var2));
         }

         Spotanim.field2797.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "35"
   )
   public boolean vmethod1901(int var1) {
      return this.field1207[var1].field1305;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Lclass158;IB)Lclass158;",
      garbageValue = "-85"
   )
   public static class158 method1454(class158[] var0, int var1) {
      class158[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class158 var4 = var2[var3];
         if(var1 == var4.vmethod4074()) {
            return var4;
         }
      }

      return null;
   }
}
