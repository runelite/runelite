import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   static AbstractArchive field382;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   static AbstractArchive field383;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   static AbstractArchive field384;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("HitSplatDefinition_cached")
   static EvictingDualNodeHashTable HitSplatDefinition_cached;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   static EvictingDualNodeHashTable field385;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("HitSplatDefinition_cachedFonts")
   static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 431076793
   )
   @Export("fontId")
   int fontId;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1151968735
   )
   public int field386;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -102270561
   )
   public int field387;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1533306389
   )
   int field388;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1677628889
   )
   int field389;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1683792491
   )
   int field390;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1845590719
   )
   int field391;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -389283589
   )
   public int field392;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1751286975
   )
   public int field393;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 199815415
   )
   public int field394;
   @ObfuscatedName("b")
   String field395;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1003116765
   )
   public int field396;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1498880475
   )
   public int field397;
   @ObfuscatedName("p")
   @Export("transforms")
   public int[] transforms;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 516423393
   )
   @Export("transformVarbit")
   int transformVarbit;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1841054487
   )
   @Export("transformVarp")
   int transformVarp;

   HitSplatDefinition() {
      this.fontId = -1;
      this.field386 = 16777215;
      this.field387 = 70;
      this.field388 = -1;
      this.field389 = -1;
      this.field390 = -1;
      this.field391 = -1;
      this.field392 = 0;
      this.field393 = 0;
      this.field394 = -1;
      this.field395 = "";
      this.field396 = -1;
      this.field397 = 0;
      this.transformVarbit = -1;
      this.transformVarp = -1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "1963348982"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while (true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "1789835753"
   )
   @Export("decodeNext")
   void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         this.fontId = var1.method51();
      } else if (var2 == 2) {
         this.field386 = var1.readMedium();
      } else if (var2 == 3) {
         this.field388 = var1.method51();
      } else if (var2 == 4) {
         this.field390 = var1.method51();
      } else if (var2 == 5) {
         this.field389 = var1.method51();
      } else if (var2 == 6) {
         this.field391 = var1.method51();
      } else if (var2 == 7) {
         this.field392 = var1.method44();
      } else if (var2 == 8) {
         this.field395 = var1.readStringCp1252NullCircumfixed();
      } else if (var2 == 9) {
         this.field387 = var1.readUnsignedShort();
      } else if (var2 == 10) {
         this.field393 = var1.method44();
      } else if (var2 == 11) {
         this.field394 = 0;
      } else if (var2 == 12) {
         this.field396 = var1.readUnsignedByte();
      } else if (var2 == 13) {
         this.field397 = var1.method44();
      } else if (var2 == 14) {
         this.field394 = var1.readUnsignedShort();
      } else if (var2 == 17 || var2 == 18) {
         this.transformVarbit = var1.readUnsignedShort();
         if (this.transformVarbit == 65535) {
            this.transformVarbit = -1;
         }

         this.transformVarp = var1.readUnsignedShort();
         if (this.transformVarp == 65535) {
            this.transformVarp = -1;
         }

         int var3 = -1;
         if (var2 == 18) {
            var3 = var1.readUnsignedShort();
            if (var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.transforms = new int[var4 + 2];

         for (int var5 = 0; var5 <= var4; ++var5) {
            this.transforms[var5] = var1.readUnsignedShort();
            if (this.transforms[var5] == 65535) {
               this.transforms[var5] = -1;
            }
         }

         this.transforms[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Ljm;",
      garbageValue = "-35"
   )
   @Export("transform")
   public final HitSplatDefinition transform() {
      int var1 = -1;
      if (this.transformVarbit != -1) {
         var1 = WorldMapSection2.getVarbit(this.transformVarbit);
      } else if (this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if (var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1 ? LoginScreenAnimation.getHitSplatDefinition(var2) : null;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IS)Ljava/lang/String;",
      garbageValue = "1000"
   )
   @Export("getString")
   public String getString(int var1) {
      String var2 = this.field395;

      while (true) {
         int var3 = var2.indexOf("%1");
         if (var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + ByteArrayPool.method4001(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lln;",
      garbageValue = "-1692599381"
   )
   public Sprite method123() {
      if (this.field388 < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)field385.get((long)this.field388);
         if (var1 != null) {
            return var1;
         } else {
            var1 = class322.readSprite(field383, this.field388, 0);
            if (var1 != null) {
               field385.put(var1, (long)this.field388);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Lln;",
      garbageValue = "-15"
   )
   public Sprite method124() {
      if (this.field389 < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)field385.get((long)this.field389);
         if (var1 != null) {
            return var1;
         } else {
            var1 = class322.readSprite(field383, this.field389, 0);
            if (var1 != null) {
               field385.put(var1, (long)this.field389);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)Lln;",
      garbageValue = "-49"
   )
   public Sprite method125() {
      if (this.field390 < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)field385.get((long)this.field390);
         if (var1 != null) {
            return var1;
         } else {
            var1 = class322.readSprite(field383, this.field390, 0);
            if (var1 != null) {
               field385.put(var1, (long)this.field390);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lln;",
      garbageValue = "393569067"
   )
   public Sprite method126() {
      if (this.field391 < 0) {
         return null;
      } else {
         Sprite var1 = (Sprite)field385.get((long)this.field391);
         if (var1 != null) {
            return var1;
         } else {
            var1 = class322.readSprite(field383, this.field391, 0);
            if (var1 != null) {
               field385.put(var1, (long)this.field391);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lkk;",
      garbageValue = "1389815135"
   )
   @Export("getFont")
   public Font getFont() {
      if (this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)HitSplatDefinition_cachedFonts.get((long)this.fontId);
         if (var1 != null) {
            return var1;
         } else {
            var1 = GraphicsDefaults.method5823(field383, field384, this.fontId, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedFonts.put(var1, (long)this.fontId);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   public static int method4972(long var0) {
      return (int)(var0 >>> 17 & 4294967295L);
   }

   static {
      HitSplatDefinition_cached = new EvictingDualNodeHashTable(64);
      field385 = new EvictingDualNodeHashTable(64);
      HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(20);
   }
}
