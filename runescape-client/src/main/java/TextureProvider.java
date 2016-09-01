import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("TextureProvider")
public class TextureProvider implements class95 {
   @ObfuscatedName("nb")
   @ObfuscatedGetter(
      intValue = 536280995
   )
   static int field1667;
   @ObfuscatedName("r")
   Deque field1668 = new Deque();
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1828204919
   )
   int field1669;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2132328993
   )
   int field1670 = 0;
   @ObfuscatedName("l")
   class170 field1671;
   @ObfuscatedName("i")
   double field1672 = 1.0D;
   @ObfuscatedName("x")
   class86[] field1673;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 415576383
   )
   int field1676 = 128;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(D)V",
      garbageValue = "0.9"
   )
   public void method2223(double var1) {
      this.field1672 = var1;
      this.method2229();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "2052637982"
   )
   public int vmethod2226(int var1) {
      return this.field1673[var1] != null?this.field1673[var1].field1481:0;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "18"
   )
   public boolean vmethod2227(int var1) {
      return this.field1673[var1].field1483;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1009419415"
   )
   public void method2229() {
      for(int var1 = 0; var1 < this.field1673.length; ++var1) {
         if(null != this.field1673[var1]) {
            this.field1673[var1].method1929();
         }
      }

      this.field1668 = new Deque();
      this.field1670 = this.field1669;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1234255520"
   )
   public void method2230(int var1) {
      for(int var2 = 0; var2 < this.field1673.length; ++var2) {
         class86 var3 = this.field1673[var2];
         if(var3 != null && var3.field1486 != 0 && var3.field1490) {
            var3.method1935(var1);
            var3.field1490 = false;
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-297443635"
   )
   public boolean vmethod2242(int var1) {
      return this.field1676 == 64;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-6085327"
   )
   @Export("load")
   public int[] load(int var1) {
      class86 var2 = this.field1673[var1];
      if(null != var2) {
         if(var2.field1488 != null) {
            this.field1668.method3846(var2);
            var2.field1490 = true;
            return var2.field1488;
         }

         boolean var3 = var2.method1928(this.field1672, this.field1676, this.field1671);
         if(var3) {
            if(this.field1670 == 0) {
               class86 var4 = (class86)this.field1668.method3849();
               var4.method1929();
            } else {
               --this.field1670;
            }

            this.field1668.method3846(var2);
            var2.field1490 = true;
            return var2.field1488;
         }
      }

      return null;
   }

   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;IDI)V",
      garbageValue = "64"
   )
   public TextureProvider(class170 var1, class170 var2, int var3, double var4, int var6) {
      this.field1671 = var2;
      this.field1669 = var3;
      this.field1670 = this.field1669;
      this.field1672 = var4;
      this.field1676 = var6;
      int[] var7 = var1.method3289(0);
      int var8 = var7.length;
      this.field1673 = new class86[var1.method3299(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.method3290(0, var7[var9]));
         this.field1673[var7[var9]] = new class86(var10);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)[B",
      garbageValue = "1"
   )
   public static byte[] method2250(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 <= 0 || var4 >= 128) && (var4 < 160 || var4 > 255)) {
            if(var4 == 8364) {
               var2[var3] = -128;
            } else if(var4 == 8218) {
               var2[var3] = -126;
            } else if(var4 == 402) {
               var2[var3] = -125;
            } else if(var4 == 8222) {
               var2[var3] = -124;
            } else if(var4 == 8230) {
               var2[var3] = -123;
            } else if(var4 == 8224) {
               var2[var3] = -122;
            } else if(var4 == 8225) {
               var2[var3] = -121;
            } else if(var4 == 710) {
               var2[var3] = -120;
            } else if(var4 == 8240) {
               var2[var3] = -119;
            } else if(var4 == 352) {
               var2[var3] = -118;
            } else if(var4 == 8249) {
               var2[var3] = -117;
            } else if(var4 == 338) {
               var2[var3] = -116;
            } else if(var4 == 381) {
               var2[var3] = -114;
            } else if(var4 == 8216) {
               var2[var3] = -111;
            } else if(var4 == 8217) {
               var2[var3] = -110;
            } else if(var4 == 8220) {
               var2[var3] = -109;
            } else if(var4 == 8221) {
               var2[var3] = -108;
            } else if(var4 == 8226) {
               var2[var3] = -107;
            } else if(var4 == 8211) {
               var2[var3] = -106;
            } else if(var4 == 8212) {
               var2[var3] = -105;
            } else if(var4 == 732) {
               var2[var3] = -104;
            } else if(var4 == 8482) {
               var2[var3] = -103;
            } else if(var4 == 353) {
               var2[var3] = -102;
            } else if(var4 == 8250) {
               var2[var3] = -101;
            } else if(var4 == 339) {
               var2[var3] = -100;
            } else if(var4 == 382) {
               var2[var3] = -98;
            } else if(var4 == 376) {
               var2[var3] = -97;
            } else {
               var2[var3] = 63;
            }
         } else {
            var2[var3] = (byte)var4;
         }
      }

      return var2;
   }
}
