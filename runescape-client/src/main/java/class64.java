import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
public class class64 {
   @ObfuscatedName("ez")
   @ObfuscatedGetter(
      longValue = 7422934189023485029L
   )
   static long field749;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lji;"
   )
   final IndexData field746;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -640562887
   )
   final int field748;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1132242421
   )
   int field747;

   @ObfuscatedSignature(
      signature = "(Lji;Ljava/lang/String;)V"
   )
   class64(IndexData var1, String var2) {
      this.field747 = 0;
      this.field746 = var1;
      this.field748 = var1.size();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-34"
   )
   boolean method1134() {
      this.field747 = 0;

      for(int var1 = 0; var1 < this.field748; ++var1) {
         if(!this.field746.method4783(var1) || this.field746.method4772(var1)) {
            ++this.field747;
         }
      }

      return this.field747 >= this.field748;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "-1111361006"
   )
   @Export("encodeStringCp1252")
   public static int encodeStringCp1252(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var3[var6 + var4] = (byte)var7;
         } else if(var7 == 8364) {
            var3[var6 + var4] = -128;
         } else if(var7 == 8218) {
            var3[var6 + var4] = -126;
         } else if(var7 == 402) {
            var3[var6 + var4] = -125;
         } else if(var7 == 8222) {
            var3[var6 + var4] = -124;
         } else if(var7 == 8230) {
            var3[var6 + var4] = -123;
         } else if(var7 == 8224) {
            var3[var6 + var4] = -122;
         } else if(var7 == 8225) {
            var3[var6 + var4] = -121;
         } else if(var7 == 710) {
            var3[var6 + var4] = -120;
         } else if(var7 == 8240) {
            var3[var6 + var4] = -119;
         } else if(var7 == 352) {
            var3[var6 + var4] = -118;
         } else if(var7 == 8249) {
            var3[var6 + var4] = -117;
         } else if(var7 == 338) {
            var3[var6 + var4] = -116;
         } else if(var7 == 381) {
            var3[var6 + var4] = -114;
         } else if(var7 == 8216) {
            var3[var6 + var4] = -111;
         } else if(var7 == 8217) {
            var3[var6 + var4] = -110;
         } else if(var7 == 8220) {
            var3[var6 + var4] = -109;
         } else if(var7 == 8221) {
            var3[var6 + var4] = -108;
         } else if(var7 == 8226) {
            var3[var6 + var4] = -107;
         } else if(var7 == 8211) {
            var3[var6 + var4] = -106;
         } else if(var7 == 8212) {
            var3[var6 + var4] = -105;
         } else if(var7 == 732) {
            var3[var6 + var4] = -104;
         } else if(var7 == 8482) {
            var3[var6 + var4] = -103;
         } else if(var7 == 353) {
            var3[var6 + var4] = -102;
         } else if(var7 == 8250) {
            var3[var6 + var4] = -101;
         } else if(var7 == 339) {
            var3[var6 + var4] = -100;
         } else if(var7 == 382) {
            var3[var6 + var4] = -98;
         } else if(var7 == 376) {
            var3[var6 + var4] = -97;
         } else {
            var3[var6 + var4] = 63;
         }
      }

      return var5;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcr;ZI)I",
      garbageValue = "-639289657"
   )
   static int method1137(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = UnitPriceComparator.getWidget(class81.intStack[--class171.intStackSize]);
      } else {
         var3 = var2?class49.field604:class81.field1270;
      }

      if(var0 == 1927) {
         if(class81.field1274 >= 10) {
            throw new RuntimeException();
         } else if(var3.onResizeListener == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.source = var3;
            var4.params = var3.onResizeListener;
            var4.field784 = class81.field1274 + 1;
            Client.field1049.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fv")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-522334513"
   )
   static boolean method1136() {
      if(Client.field1120 != null && Client.field1121 < Client.field1120.size()) {
         while(Client.field1121 < Client.field1120.size()) {
            class64 var0 = (class64)Client.field1120.get(Client.field1121);
            if(!var0.method1134()) {
               return false;
            }

            ++Client.field1121;
         }

         return true;
      } else {
         return true;
      }
   }
}
