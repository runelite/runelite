import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class46 extends class204 {
   @ObfuscatedName("w")
   public static class193 field1026 = new class193(64);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1347450021
   )
   public int field1027;
   @ObfuscatedName("e")
   public static class167 field1028;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -562392587
   )
   public int field1029 = -1;
   @ObfuscatedName("p")
   public boolean field1030 = true;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 709546331
   )
   public int field1032 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -199053981
   )
   public int field1033;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -451388277
   )
   public int field1034;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1138563021
   )
   public int field1035;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -272366765
   )
   public int field1036;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1146137973
   )
   public int field1037;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1508445095
   )
   public int field1038 = 0;
   @ObfuscatedName("ch")
   static class143 field1040;

   @ObfuscatedName("w")
   void method959() {
      if(-1 != this.field1032) {
         this.method962(this.field1032);
         this.field1035 = this.field1027;
         this.field1036 = this.field1033;
         this.field1037 = this.field1034;
      }

      this.method962(this.field1038);
   }

   @ObfuscatedName("f")
   void method960(class119 var1) {
      while(true) {
         int var2 = var1.method2523();
         if(0 == var2) {
            return;
         }

         this.method961(var1, var2);
      }
   }

   @ObfuscatedName("s")
   void method961(class119 var1, int var2) {
      if(1 == var2) {
         this.field1038 = var1.method2527();
      } else if(var2 == 2) {
         this.field1029 = var1.method2523();
      } else if(5 == var2) {
         this.field1030 = false;
      } else if(var2 == 7) {
         this.field1032 = var1.method2527();
      } else if(8 == var2) {
         ;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-257108577"
   )
   void method962(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var10 != var8) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var4 == var10) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.field1027 = (int)(var12 * 256.0D);
      this.field1033 = (int)(var14 * 256.0D);
      this.field1034 = (int)(256.0D * var16);
      if(this.field1033 < 0) {
         this.field1033 = 0;
      } else if(this.field1033 > 255) {
         this.field1033 = 255;
      }

      if(this.field1034 < 0) {
         this.field1034 = 0;
      } else if(this.field1034 > 255) {
         this.field1034 = 255;
      }

   }

   @ObfuscatedName("f")
   static void method973(int var0, String var1, String var2, String var3) {
      class27 var4 = (class27)class11.field172.get(Integer.valueOf(var0));
      if(null == var4) {
         var4 = new class27();
         class11.field172.put(Integer.valueOf(var0), var4);
      }

      class35 var5 = var4.method636(var0, var1, var2, var3);
      class11.field171.method3806(var5, (long)var5.field760);
      class11.field173.method3854(var5);
      client.field470 = client.field463;
   }

   @ObfuscatedName("w")
   public static class42 method974(int var0) {
      class42 var1 = (class42)class42.field964.method3754((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class42.field970.method3280(12, var0);
         var1 = new class42();
         if(var2 != null) {
            var1.method857(new class119(var2));
         }

         var1.method859();
         class42.field964.method3756(var1, (long)var0);
         return var1;
      }
   }
}
