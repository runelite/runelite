import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -110285891
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1142238929
   )
   @Export("height")
   int height;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1258824509
   )
   @Export("orientation")
   int orientation;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1767118865
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -103350489
   )
   @Export("y")
   int y;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1263735871
   )
   @Export("relativeX")
   int relativeX;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1332610643
   )
   @Export("offsetX")
   int offsetX;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 49490511
   )
   @Export("relativeY")
   int relativeY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -467325123
   )
   @Export("offsetY")
   int offsetY;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1787362761
   )
   @Export("drawPriority")
   int drawPriority;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1347592071
   )
   @Export("cycle")
   int cycle;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1352407209
   )
   @Export("hash")
   public int hash;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -711057623
   )
   @Export("flags")
   int flags;

   GameObject() {
      this.hash = 0;
      this.flags = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BIB)I",
      garbageValue = "-1"
   )
   @Export("encodeStringCp1252")
   public static int encodeStringCp1252(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
      int var5 = var2 - var1;

      for(int var6 = 0; var6 < var5; ++var6) {
         char var7 = var0.charAt(var6 + var1);
         if((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
            if(var7 == 8364) {
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
         } else {
            var3[var6 + var4] = (byte)var7;
         }
      }

      return var5;
   }
}
