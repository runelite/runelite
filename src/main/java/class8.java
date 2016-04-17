import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class8 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1126651823
   )
   int field145 = 1;
   @ObfuscatedName("d")
   boolean field147;
   @ObfuscatedName("k")
   LinkedHashMap field150 = new LinkedHashMap();
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 416767951
   )
   static int field151 = 4;
   @ObfuscatedName("p")
   static int[] field153;
   @ObfuscatedName("c")
   boolean field154;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -1427971491
   )
   protected static int field155;
   @ObfuscatedName("bg")
   static class168 field156;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(S)Lclass119;",
      garbageValue = "2048"
   )
   class119 method143() {
      class119 var1 = new class119(100);
      var1.method2603(field151);
      var1.method2603(this.field147?1:0);
      var1.method2603(this.field154?1:0);
      var1.method2603(this.field145);
      var1.method2603(this.field150.size());
      Iterator var2 = this.field150.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2786(((Integer)var3.getKey()).intValue());
         var1.method2786(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   class8(class119 var1) {
      if(var1 != null && null != var1.field1993) {
         int var2 = var1.method2613();
         if(var2 >= 0 && var2 <= field151) {
            if(var1.method2613() == 1) {
               this.field147 = true;
            }

            if(var2 > 1) {
               this.field154 = var1.method2613() == 1;
            }

            if(var2 > 3) {
               this.field145 = var1.method2613();
            }

            if(var2 > 2) {
               int var3 = var1.method2613();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.method2618();
                  int var6 = var1.method2618();
                  this.field150.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method144(true);
         }
      } else {
         this.method144(true);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   void method144(boolean var1) {
   }

   class8() {
      this.method144(true);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass25;Lclass25;IZI)I",
      garbageValue = "-1471888403"
   )
   static int method154(class25 var0, class25 var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.field648;
         int var5 = var1.field648;
         if(!var3) {
            if(-1 == var4) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return 2 == var2?var0.field651 - var1.field651:(var2 == 3?(var0.field649.equals("-")?(var1.field649.equals("-")?0:(var3?-1:1)):(var1.field649.equals("-")?(var3?1:-1):var0.field649.compareTo(var1.field649))):(4 == var2?(var0.method700()?(var1.method700()?0:1):(var1.method700()?-1:0)):(5 == var2?(var0.method680()?(var1.method680()?0:1):(var1.method680()?-1:0)):(6 == var2?(var0.method681()?(var1.method681()?0:1):(var1.method681()?-1:0)):(var2 == 7?(var0.method679()?(var1.method679()?0:1):(var1.method679()?-1:0)):var0.field646 - var1.field646)))));
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass167;III)[Lclass80;",
      garbageValue = "-1271242953"
   )
   static class80[] method155(class167 var0, int var1, int var2) {
      if(!class30.method748(var0, var1, var2)) {
         return null;
      } else {
         class80[] var4 = new class80[class76.field1384];

         for(int var5 = 0; var5 < class76.field1384; ++var5) {
            class80 var6 = var4[var5] = new class80();
            var6.field1425 = class76.field1385;
            var6.field1426 = class103.field1773;
            var6.field1421 = class76.field1389[var5];
            var6.field1424 = class76.field1387[var5];
            var6.field1419 = class126.field2042[var5];
            var6.field1420 = class77.field1397[var5];
            var6.field1423 = field153;
            var6.field1422 = class76.field1388[var5];
         }

         class15.method203();
         return var4;
      }
   }
}
