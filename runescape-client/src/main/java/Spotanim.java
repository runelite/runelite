import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iz")
@Implements("Spotanim")
public class Spotanim extends CacheableNode {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   static NodeCache field3300;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("spotanims")
   static NodeCache spotanims;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3298;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   public static IndexDataBase field3297;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1763866085
   )
   @Export("id")
   int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1488361447
   )
   public int field3299;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -849953681
   )
   int field3302;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -324480233
   )
   int field3308;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2071299459
   )
   int field3311;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1653588881
   )
   int field3310;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -449965283
   )
   int field3306;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -280831309
   )
   int field3312;
   @ObfuscatedName("x")
   short[] field3304;
   @ObfuscatedName("k")
   short[] field3307;
   @ObfuscatedName("p")
   short[] field3305;
   @ObfuscatedName("r")
   short[] field3303;

   static {
      spotanims = new NodeCache(64);
      field3300 = new NodeCache(30);
   }

   Spotanim() {
      this.field3299 = -1;
      this.field3308 = 128;
      this.field3311 = 128;
      this.field3310 = 0;
      this.field3306 = 0;
      this.field3312 = 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "-294492867"
   )
   void method4225(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3302 = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.field3299 = var1.readUnsignedShort();
      } else if(var2 == 4) {
         this.field3308 = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.field3311 = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.field3310 = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.field3306 = var1.readUnsignedByte();
      } else if(var2 == 8) {
         this.field3312 = var1.readUnsignedByte();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.field3304 = new short[var3];
            this.field3305 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3304[var4] = (short)var1.readUnsignedShort();
               this.field3305[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.field3307 = new short[var3];
            this.field3303 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field3307[var4] = (short)var1.readUnsignedShort();
               this.field3303[var4] = (short)var1.readUnsignedShort();
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Leo;",
      garbageValue = "-542470919"
   )
   public final Model method4231(int var1) {
      Model var2 = (Model)field3300.get((long)this.id);
      if(var2 == null) {
         ModelData var3 = ModelData.method2331(field3298, this.field3302, 0);
         if(var3 == null) {
            return null;
         }

         int var4;
         if(this.field3304 != null) {
            for(var4 = 0; var4 < this.field3304.length; ++var4) {
               var3.recolor(this.field3304[var4], this.field3305[var4]);
            }
         }

         if(this.field3307 != null) {
            for(var4 = 0; var4 < this.field3307.length; ++var4) {
               var3.method2347(this.field3307[var4], this.field3303[var4]);
            }
         }

         var2 = var3.light(this.field3306 + 64, this.field3312 + 850, -30, -50, -30);
         field3300.put(var2, (long)this.id);
      }

      Model var5;
      if(this.field3299 != -1 && var1 != -1) {
         var5 = class31.getAnimation(this.field3299).method4595(var2, var1);
      } else {
         var5 = var2.method2430(true);
      }

      if(this.field3308 != 128 || this.field3311 != 128) {
         var5.method2487(this.field3308, this.field3311, this.field3308);
      }

      if(this.field3310 != 0) {
         if(this.field3310 == 90) {
            var5.method2439();
         }

         if(this.field3310 == 180) {
            var5.method2439();
            var5.method2439();
         }

         if(this.field3310 == 270) {
            var5.method2439();
            var5.method2439();
            var5.method2439();
         }
      }

      return var5;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "-31"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4225(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II[BII)I",
      garbageValue = "1994055205"
   )
   public static int method4227(CharSequence var0, int var1, int var2, byte[] var3, int var4) {
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
}
