import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("Nameable")
public class Nameable implements Comparable {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   @Export("name")
   Name name;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkz;"
   )
   Name field3830;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lkz;",
      garbageValue = "-999810288"
   )
   public Name method5271() {
      return this.name;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1556278433"
   )
   public String method5267() {
      return this.name == null?"":this.name.getName();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "1823860623"
   )
   public String method5263() {
      return this.field3830 == null?"":this.field3830.getName();
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      signature = "(Lkz;Lkz;I)V",
      garbageValue = "-201225227"
   )
   void method5264(Name var1, Name var2) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.name = var1;
         this.field3830 = var2;
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(Lku;I)I",
      garbageValue = "-1796643174"
   )
   public int vmethod5448(Nameable var1) {
      return this.name.method5430(var1.name);
   }

   public int compareTo(Object var1) {
      return this.vmethod5448((Nameable)var1);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgc;Ljava/lang/String;I)I",
      garbageValue = "-1931613317"
   )
   public static int method5280(Buffer var0, String var1) {
      int var2 = var0.offset;
      int var4 = var1.length();
      byte[] var5 = new byte[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var5[var6] = (byte)var7;
         } else if(var7 == 8364) {
            var5[var6] = -128;
         } else if(var7 == 8218) {
            var5[var6] = -126;
         } else if(var7 == 402) {
            var5[var6] = -125;
         } else if(var7 == 8222) {
            var5[var6] = -124;
         } else if(var7 == 8230) {
            var5[var6] = -123;
         } else if(var7 == 8224) {
            var5[var6] = -122;
         } else if(var7 == 8225) {
            var5[var6] = -121;
         } else if(var7 == 710) {
            var5[var6] = -120;
         } else if(var7 == 8240) {
            var5[var6] = -119;
         } else if(var7 == 352) {
            var5[var6] = -118;
         } else if(var7 == 8249) {
            var5[var6] = -117;
         } else if(var7 == 338) {
            var5[var6] = -116;
         } else if(var7 == 381) {
            var5[var6] = -114;
         } else if(var7 == 8216) {
            var5[var6] = -111;
         } else if(var7 == 8217) {
            var5[var6] = -110;
         } else if(var7 == 8220) {
            var5[var6] = -109;
         } else if(var7 == 8221) {
            var5[var6] = -108;
         } else if(var7 == 8226) {
            var5[var6] = -107;
         } else if(var7 == 8211) {
            var5[var6] = -106;
         } else if(var7 == 8212) {
            var5[var6] = -105;
         } else if(var7 == 732) {
            var5[var6] = -104;
         } else if(var7 == 8482) {
            var5[var6] = -103;
         } else if(var7 == 353) {
            var5[var6] = -102;
         } else if(var7 == 8250) {
            var5[var6] = -101;
         } else if(var7 == 339) {
            var5[var6] = -100;
         } else if(var7 == 382) {
            var5[var6] = -98;
         } else if(var7 == 376) {
            var5[var6] = -97;
         } else {
            var5[var6] = 63;
         }
      }

      var0.putShortSmart(var5.length);
      var0.offset += class313.huffman.compress(var5, 0, var5.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }
}
