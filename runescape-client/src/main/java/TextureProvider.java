import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("TextureProvider")
public class TextureProvider implements class93 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1575235049
   )
   int field1181;
   @ObfuscatedName("d")
   class79[] field1182;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1404873405
   )
   int field1184 = 0;
   @ObfuscatedName("t")
   double field1185 = 1.0D;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1051252599
   )
   int field1186 = 128;
   @ObfuscatedName("u")
   IndexDataBase field1187;
   @ObfuscatedName("c")
   Deque field1189 = new Deque();
   @ObfuscatedName("ch")
   static Font field1192;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method1446(double var1) {
      this.field1185 = var1;
      this.method1459();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)[I",
      garbageValue = "-67"
   )
   @Export("load")
   public int[] load(int var1) {
      class79 var2 = this.field1182[var1];
      if(var2 != null) {
         if(var2.field1302 != null) {
            this.field1189.method2843(var2);
            var2.field1300 = true;
            return var2.field1302;
         }

         boolean var3 = var2.method1555(this.field1185, this.field1186, this.field1187);
         if(var3) {
            if(this.field1184 == 0) {
               class79 var4 = (class79)this.field1189.method2827();
               var4.method1556();
            } else {
               --this.field1184;
            }

            this.field1189.method2843(var2);
            var2.field1300 = true;
            return var2.field1302;
         }
      }

      return null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "2029731311"
   )
   public boolean vmethod1914(int var1) {
      return this.field1182[var1].field1303;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-305121075"
   )
   public boolean vmethod1912(int var1) {
      return this.field1186 == 64;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1452456015"
   )
   public void method1453(int var1) {
      for(int var2 = 0; var2 < this.field1182.length; ++var2) {
         class79 var3 = this.field1182[var2];
         if(var3 != null && var3.field1290 != 0 && var3.field1300) {
            var3.method1559(var1);
            var3.field1300 = false;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(IndexDataBase var1, IndexDataBase var2, int var3, double var4, int var6) {
      this.field1187 = var2;
      this.field1181 = var3;
      this.field1184 = this.field1181;
      this.field1185 = var4;
      this.field1186 = var6;
      int[] var7 = var1.method3304(0);
      int var8 = var7.length;
      this.field1182 = new class79[var1.method3305(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.getConfigData(0, var7[var9]));
         this.field1182[var7[var9]] = new class79(var10);
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1673530363"
   )
   public int vmethod1913(int var1) {
      return this.field1182[var1] != null?this.field1182[var1].field1294:0;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "3407"
   )
   public void method1459() {
      for(int var1 = 0; var1 < this.field1182.length; ++var1) {
         if(this.field1182[var1] != null) {
            this.field1182[var1].method1556();
         }
      }

      this.field1189 = new Deque();
      this.field1184 = this.field1181;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "-2120785780"
   )
   static String method1472(int var0) {
      return "<img=" + var0 + ">";
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "581811256"
   )
   static void method1473(int var0) {
      if(var0 != -1) {
         if(class112.method2112(var0)) {
            Widget[] var1 = class133.widgets[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if(var3.field2288 != null) {
                  class18 var4 = new class18();
                  var4.field189 = var3;
                  var4.field196 = var3.field2288;
                  Script.method910(var4, 2000000);
               }
            }

         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Z",
      garbageValue = "-356794397"
   )
   public static final boolean method1474(String var0, String var1, String var2, String var3) {
      return var0 != null && var2 != null?(!var0.startsWith("#") && !var2.startsWith("#")?var1.equals(var3):var0.equals(var2)):false;
   }
}
