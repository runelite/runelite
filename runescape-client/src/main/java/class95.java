import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("TextureProvider")
public class class95 implements class92 {
   @ObfuscatedName("i")
   class199 field1627 = new class199();
   @ObfuscatedName("t")
   class83[] field1628;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1904377175
   )
   int field1629;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1206173773
   )
   int field1630 = 0;
   @ObfuscatedName("z")
   double field1631 = 1.0D;
   @ObfuscatedName("f")
   class167 field1633;
   @ObfuscatedName("q")
   static int[] field1634;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1716764885
   )
   int field1635 = 128;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = -532260669
   )
   static int field1636;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1721058115"
   )
   public int vmethod2128(int var1) {
      return this.field1628[var1] != null?this.field1628[var1].field1447:0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1515104039"
   )
   public boolean vmethod2129(int var1) {
      return this.field1628[var1].field1448;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "47"
   )
   public boolean vmethod2130(int var1) {
      return this.field1635 == 64;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "0"
   )
   static final String method2131(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "349392757"
   )
   public void method2132(int var1) {
      for(int var2 = 0; var2 < this.field1628.length; ++var2) {
         class83 var3 = this.field1628[var2];
         if(var3 != null && var3.field1449 != 0 && var3.field1456) {
            var3.method1849(var1);
            var3.field1456 = false;
         }
      }

   }

   @ObfuscatedSignature(
      signature = "(Lclass167;Lclass167;IDI)V",
      garbageValue = "20"
   )
   public class95(class167 var1, class167 var2, int var3, double var4, int var6) {
      this.field1633 = var2;
      this.field1629 = var3;
      this.field1630 = this.field1629;
      this.field1631 = var4;
      this.field1635 = var6;
      int[] var7 = var1.method3230(0);
      int var8 = var7.length;
      this.field1628 = new class83[var1.method3231(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         class119 var10 = new class119(var1.method3221(0, var7[var9]));
         this.field1628[var7[var9]] = new class83(var10);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2138(double var1) {
      this.field1631 = var1;
      this.method2146();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2105336694"
   )
   public void method2146() {
      for(int var1 = 0; var1 < this.field1628.length; ++var1) {
         if(this.field1628[var1] != null) {
            this.field1628[var1].method1848();
         }
      }

      this.field1627 = new class199();
      this.field1630 = this.field1629;
   }

   @ObfuscatedName("dh")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1693618417"
   )
   static final void method2148(String var0) {
      if(null != var0) {
         String var1 = class36.method723(var0, class96.field1641);
         if(null != var1) {
            for(int var2 = 0; var2 < client.field553; ++var2) {
               class7 var3 = client.field400[var2];
               String var4 = var3.field135;
               String var5 = class36.method723(var4, class96.field1641);
               boolean var6;
               if(null != var0 && null != var4) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --client.field553;

                  for(int var7 = var2; var7 < client.field553; ++var7) {
                     client.field400[var7] = client.field400[1 + var7];
                  }

                  client.field475 = client.field467;
                  client.field325.method2733(182);
                  client.field325.method2453(class102.method2237(var0));
                  client.field325.method2586(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "648919497"
   )
   @Export("load")
   public int[] vmethod2149(int var1) {
      class83 var2 = this.field1628[var1];
      if(null != var2) {
         if(null != var2.field1455) {
            this.field1627.method3788(var2);
            var2.field1456 = true;
            return var2.field1455;
         }

         boolean var3 = var2.method1847(this.field1631, this.field1635, this.field1633);
         if(var3) {
            if(this.field1630 == 0) {
               class83 var4 = (class83)this.field1627.method3776();
               var4.method1848();
            } else {
               --this.field1630;
            }

            this.field1627.method3788(var2);
            var2.field1456 = true;
            return var2.field1455;
         }
      }

      return null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1436812011"
   )
   public static boolean method2150() {
      return class183.field2981 != 0?true:class183.field2976.method3554();
   }
}
