import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("p")
public class class9 {
   @ObfuscatedName("gh")
   static class176 field160;
   @ObfuscatedName("r")
   static final BigInteger field164 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
   @ObfuscatedName("a")
   static final BigInteger field170 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   @ObfuscatedName("px")
   static class224 field172;
   @ObfuscatedName("fa")
   @ObfuscatedGetter(
      intValue = 1171667829
   )
   static int field175;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(CB)B",
      garbageValue = "57"
   )
   public static byte method106(char var0) {
      byte var1;
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 == 8364) {
            var1 = -128;
         } else if(var0 == 8218) {
            var1 = -126;
         } else if(var0 == 402) {
            var1 = -125;
         } else if(var0 == 8222) {
            var1 = -124;
         } else if(var0 == 8230) {
            var1 = -123;
         } else if(var0 == 8224) {
            var1 = -122;
         } else if(var0 == 8225) {
            var1 = -121;
         } else if(var0 == 710) {
            var1 = -120;
         } else if(var0 == 8240) {
            var1 = -119;
         } else if(var0 == 352) {
            var1 = -118;
         } else if(var0 == 8249) {
            var1 = -117;
         } else if(var0 == 338) {
            var1 = -116;
         } else if(var0 == 381) {
            var1 = -114;
         } else if(var0 == 8216) {
            var1 = -111;
         } else if(var0 == 8217) {
            var1 = -110;
         } else if(var0 == 8220) {
            var1 = -109;
         } else if(var0 == 8221) {
            var1 = -108;
         } else if(var0 == 8226) {
            var1 = -107;
         } else if(var0 == 8211) {
            var1 = -106;
         } else if(var0 == 8212) {
            var1 = -105;
         } else if(var0 == 732) {
            var1 = -104;
         } else if(var0 == 8482) {
            var1 = -103;
         } else if(var0 == 353) {
            var1 = -102;
         } else if(var0 == 8250) {
            var1 = -101;
         } else if(var0 == 339) {
            var1 = -100;
         } else if(var0 == 382) {
            var1 = -98;
         } else if(var0 == 376) {
            var1 = -97;
         } else {
            var1 = 63;
         }
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Lclass55;",
      garbageValue = "-1030591293"
   )
   @Export("getItemDefinition")
   public static class55 method108(int var0) {
      class55 var1 = (class55)class55.field1177.method3834((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class55.field1174.method3340(10, var0);
         var1 = new class55();
         var1.field1181 = var0;
         if(null != var2) {
            var1.method1162(new class122(var2));
         }

         var1.method1161();
         if(var1.field1190 != -1) {
            var1.method1198(method108(var1.field1190), method108(var1.field1225));
         }

         if(var1.field1223 != -1) {
            var1.method1164(method108(var1.field1223), method108(var1.field1222));
         }

         if(var1.field1214 != -1) {
            var1.method1166(method108(var1.field1214), method108(var1.field1224));
         }

         if(!class30.field721 && var1.field1196) {
            var1.field1183 = "Members object";
            var1.field1182 = false;
            var1.field1189 = null;
            var1.field1180 = null;
            var1.field1188 = 0;
         }

         class55.field1177.method3836(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "-623"
   )
   static final int method109(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "721186039"
   )
   public static int method110(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }
}
