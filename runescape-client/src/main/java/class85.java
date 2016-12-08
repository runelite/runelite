import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public final class class85 {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1635833597
   )
   int field1447;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1894957359
   )
   int field1448;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1774292619
   )
   int field1450;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -489051357
   )
   int field1451;
   @ObfuscatedName("v")
   boolean field1452 = true;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -714399129
   )
   int field1453;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -885269941
   )
   int field1454;

   @ObfuscatedSignature(
      signature = "(IIIIIIZ)V",
      garbageValue = "0"
   )
   class85(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.field1454 = var1;
      this.field1447 = var2;
      this.field1453 = var3;
      this.field1450 = var4;
      this.field1451 = var5;
      this.field1448 = var6;
      this.field1452 = var7;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILObjectComposition;II)V",
      garbageValue = "-2082753416"
   )
   static void method1662(int var0, int var1, int var2, ObjectComposition var3, int var4) {
      class31 var5 = new class31();
      var5.field709 = var0;
      var5.field710 = var1 * 128;
      var5.field711 = var2 * 128;
      int var6 = var3.field2905;
      int var7 = var3.field2938;
      if(var4 == 1 || var4 == 3) {
         var6 = var3.field2938;
         var7 = var3.field2905;
      }

      var5.field712 = (var1 + var6) * 128;
      var5.field713 = (var2 + var7) * 128;
      var5.field715 = var3.field2934;
      var5.field718 = var3.field2898 * 128;
      var5.field722 = var3.field2936;
      var5.field708 = var3.field2893;
      var5.field721 = var3.field2923;
      if(var3.impostorIds != null) {
         var5.field725 = var3;
         var5.method651();
      }

      class31.field723.method2361(var5);
      if(var5.field721 != null) {
         var5.field720 = var5.field722 + (int)(Math.random() * (double)(var5.field708 - var5.field722));
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BIII)I",
      garbageValue = "1892907899"
   )
   public static int method1663(byte[] var0, int var1, int var2) {
      int var3 = -1;

      for(int var4 = var1; var4 < var2; ++var4) {
         var3 = var3 >>> 8 ^ Buffer.field2106[(var3 ^ var0[var4]) & 255];
      }

      var3 = ~var3;
      return var3;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZB)I",
      garbageValue = "113"
   )
   static int method1664(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method616()?(var1.method616()?0:1):(var1.method616()?-1:0)):(var2 == 5?(var0.method597()?(var1.method597()?0:1):(var1.method597()?-1:0)):(var2 == 6?(var0.method598()?(var1.method598()?0:1):(var1.method598()?-1:0)):(var2 == 7?(var0.method596()?(var1.method596()?0:1):(var1.method596()?-1:0)):var0.id - var1.id)))));
      }
   }
}
