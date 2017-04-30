import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fy")
public class class180 {
   @ObfuscatedName("n")
   static final class180 field2672;
   @ObfuscatedName("c")
   static final class180 field2673;
   @ObfuscatedName("q")
   static final class180 field2674;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1429956435
   )
   final int field2675;
   @ObfuscatedName("t")
   public final String field2676;
   @ObfuscatedName("d")
   static final class180 field2677;
   @ObfuscatedName("f")
   static class20 field2678;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = 255309897
   )
   static int field2680;

   static {
      field2677 = new class180("LIVE", 0);
      field2673 = new class180("BUILDLIVE", 3);
      field2672 = new class180("RC", 1);
      field2674 = new class180("WIP", 2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CI)B",
      garbageValue = "-1175397805"
   )
   public static byte method3276(char var0) {
      byte var1;
      if(var0 > 0 && var0 < 128 || var0 >= 160 && var0 <= 255) {
         var1 = (byte)var0;
      } else if(var0 == 8364) {
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

      return var1;
   }

   @ObfuscatedName("dt")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2112772903"
   )
   static final String method3282(int var0) {
      return var0 < 999999999?Integer.toString(var0):"*";
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;Lclass142;I)Lclass142;",
      garbageValue = "1806008258"
   )
   static final class142 method3283(Buffer var0, class142 var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = CombatInfo1.method596(var2);
         var1 = new class142(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new class141(var0.readString());
         } else {
            var6 = new class154(var0.readInt());
         }

         var1.method2729((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "0"
   )
   class180(String var1, int var2) {
      this.field2676 = var1;
      this.field2675 = var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1609065503"
   )
   public static int method3284() {
      return class105.keyboardIdleTicks;
   }
}
