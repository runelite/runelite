import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
public class class60 {
   @ObfuscatedName("r")
   @Export("worldServersDownload")
   static class26 worldServersDownload;
   @ObfuscatedName("l")
   class182 field1063;
   @ObfuscatedName("t")
   XHashTable field1065 = new XHashTable(256);
   @ObfuscatedName("b")
   class182 field1066;
   @ObfuscatedName("i")
   XHashTable field1067 = new XHashTable(256);

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "-1906153577"
   )
   class55 method1191(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1065.method2428(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class53 var8 = class53.method1046(this.field1066, var1, var2);
         if(null == var8) {
            return null;
         } else {
            var7 = var8.method1052();
            this.field1065.method2425(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1009.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II[IB)Lclass55;",
      garbageValue = "30"
   )
   class55 method1192(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1065.method2428(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1067.method2428(var5);
         if(var8 == null) {
            var8 = class54.method1067(this.field1063, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1067.method2425(var8, var5);
         }

         var7 = var8.method1072(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1065.method2425(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "1672509354"
   )
   public class55 method1198(int var1, int[] var2) {
      if(this.field1066.method3392() == 1) {
         return this.method1191(0, var1, var2);
      } else if(this.field1066.method3398(var1) == 1) {
         return this.method1191(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "1438939171"
   )
   public class55 method1201(int var1, int[] var2) {
      if(this.field1063.method3392() == 1) {
         return this.method1192(0, var1, var2);
      } else if(this.field1063.method3398(var1) == 1) {
         return this.method1192(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   public class60(class182 var1, class182 var2) {
      this.field1066 = var1;
      this.field1063 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "-879666293"
   )
   public static FileOnDisk method1204(String var0, String var1, boolean var2) {
      File var3 = new File(class104.field1678, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class105.field1715 == 33) {
         var4 = "_rc";
      } else if(class105.field1715 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class104.field1686, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("dn")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "88753918"
   )
   static void method1205(int var0, int var1) {
      class38 var2 = class180.field2698;
      class44.menuAction(var2.field797, var2.field790, var2.field791, var2.field792, var2.field793, var2.field793, var0, var1);
      class180.field2698 = null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-56"
   )
   public static void method1206() {
      try {
         if(class138.field1915 == 1) {
            int var0 = class39.field800.method2561();
            if(var0 > 0 && class39.field800.method2565()) {
               var0 -= class138.field1917;
               if(var0 < 0) {
                  var0 = 0;
               }

               class39.field800.method2558(var0);
               return;
            }

            class39.field800.method2668();
            class39.field800.method2653();
            if(class138.field1918 != null) {
               class138.field1915 = 2;
            } else {
               class138.field1915 = 0;
            }

            class49.field952 = null;
            XGrandExchangeOffer.field41 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class39.field800.method2668();
         class138.field1915 = 0;
         class49.field952 = null;
         XGrandExchangeOffer.field41 = null;
         class138.field1918 = null;
      }

   }
}
