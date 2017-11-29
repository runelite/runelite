import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("Friend")
public class Friend {
   @ObfuscatedName("ow")
   @ObfuscatedGetter(
      intValue = -874935777
   )
   static int field777;
   @ObfuscatedName("d")
   @Export("name")
   String name;
   @ObfuscatedName("x")
   @Export("previousName")
   String previousName;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 866337399
   )
   @Export("world")
   int world;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -649592805
   )
   @Export("rank")
   int rank;
   @ObfuscatedName("v")
   boolean field783;
   @ObfuscatedName("m")
   boolean field781;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "39"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      Varbit var1 = class61.method1089(var0);
      int var2 = var1.configId;
      int var3 = var1.leastSignificantBit;
      int var4 = var1.mostSignificantBit;
      int var5 = class218.varpsMasks[var4 - var3];
      return class218.widgetSettings[var2] >> var3 & var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lid;IIB)[Lky;",
      garbageValue = "63"
   )
   static SpritePixels[] method1108(IndexDataBase var0, int var1, int var2) {
      if(!GroundObject.method2603(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels[] var4 = new SpritePixels[class295.field3849];

         for(int var5 = 0; var5 < class295.field3849; ++var5) {
            SpritePixels var6 = var4[var5] = new SpritePixels();
            var6.maxWidth = class295.field3846;
            var6.maxHeight = class295.field3847;
            var6.offsetX = class295.field3848[var5];
            var6.offsetY = class295.offsetsY[var5];
            var6.width = class295.field3845[var5];
            var6.height = class285.field3788[var5];
            int var7 = var6.height * var6.width;
            byte[] var8 = TotalQuantityComparator.spritePixels[var5];
            var6.pixels = new int[var7];

            for(int var9 = 0; var9 < var7; ++var9) {
               var6.pixels[var9] = class115.field1599[var8[var9] & 255];
            }
         }

         class295.field3848 = null;
         class295.offsetsY = null;
         class295.field3845 = null;
         class285.field3788 = null;
         class115.field1599 = null;
         TotalQuantityComparator.spritePixels = null;
         return var4;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "2131642541"
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

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(IZII)V",
      garbageValue = "2065112344"
   )
   public static final void method1111(int var0, boolean var1, int var2) {
      if(var0 >= 8000 && var0 <= 48000) {
         AbstractSoundSystem.sampleRate = var0;
         AbstractSoundSystem.highMemory = var1;
         AbstractSoundSystem.priority = var2;
      } else {
         throw new IllegalArgumentException();
      }
   }
}
