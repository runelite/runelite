import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
public class class62 {
   @ObfuscatedName("cw")
   static class146 field1259;
   @ObfuscatedName("r")
   class170 field1260;
   @ObfuscatedName("z")
   XHashTable field1262 = new XHashTable(256);
   @ObfuscatedName("j")
   XHashTable field1263 = new XHashTable(256);
   @ObfuscatedName("i")
   static class170 field1264;
   @ObfuscatedName("x")
   class170 field1265;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass65;",
      garbageValue = "1707020632"
   )
   class65 method1303(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class65 var7 = (class65)this.field1262.method3830(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class61 var8 = class61.method1294(this.field1265, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method1293();
            this.field1262.method3819(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1275.length;
            }

            return var7;
         }
      }
   }

   public class62(class170 var1, class170 var2) {
      this.field1265 = var1;
      this.field1260 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass65;",
      garbageValue = "1009419415"
   )
   public class65 method1304(int var1, int[] var2) {
      if(this.field1265.method3300() == 1) {
         return this.method1303(0, var1, var2);
      } else if(this.field1265.method3299(var1) == 1) {
         return this.method1303(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass65;",
      garbageValue = "-1350472051"
   )
   public class65 method1305(int var1, int[] var2) {
      if(this.field1260.method3300() == 1) {
         return this.method1310(0, var1, var2);
      } else if(this.field1260.method3299(var1) == 1) {
         return this.method1310(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass65;",
      garbageValue = "1591553488"
   )
   class65 method1310(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class65 var7 = (class65)this.field1262.method3830(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class73 var8 = (class73)this.field1263.method3830(var5);
         if(var8 == null) {
            var8 = class73.method1581(this.field1260, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1263.method3819(var8, var5);
         }

         var7 = var8.method1565(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1262.method3819(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "(LWidgetNode;ZI)V",
      garbageValue = "442713722"
   )
   static final void method1313(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1) {
         class160.method3204(var2);
      }

      for(class204 var4 = (class204)Client.widgetFlags.method3821(); var4 != null; var4 = (class204)Client.widgetFlags.method3822()) {
         if((var4.hash >> 48 & 65535L) == (long)var2) {
            var4.unlink();
         }
      }

      Widget var6 = World.method628(var3);
      if(var6 != null) {
         class75.method1606(var6);
      }

      class47.method971();
      if(Client.widgetRoot != -1) {
         int var5 = Client.widgetRoot;
         if(class175.method3419(var5)) {
            class52.method1059(Widget.widgets[var5], 1);
         }
      }

   }
}
