import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("SequenceDefinition")
public class SequenceDefinition extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("SequenceDefinition_indexCache")
   public static AbstractIndexCache SequenceDefinition_indexCache;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static AbstractIndexCache field773;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   public static AbstractIndexCache field774;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("SequenceDefinition_cached")
   public static EvictingDualNodeHashTable SequenceDefinition_cached;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   public static EvictingDualNodeHashTable field775;
   @ObfuscatedName("u")
   @Export("frameIds")
   public int[] frameIds;
   @ObfuscatedName("g")
   @Export("frameIds2")
   int[] frameIds2;
   @ObfuscatedName("l")
   @Export("frameLengths")
   public int[] frameLengths;
   @ObfuscatedName("e")
   public int[] field776;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -736885973
   )
   @Export("frameCount")
   public int frameCount;
   @ObfuscatedName("d")
   int[] field777;
   @ObfuscatedName("k")
   public boolean field778;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1309695045
   )
   public int field779;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1308226131
   )
   @Export("shield")
   public int shield;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1629538741
   )
   @Export("weapon")
   public int weapon;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -28345361
   )
   public int field780;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1339014215
   )
   public int field781;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 2012242069
   )
   public int field782;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1147391369
   )
   public int field783;

   SequenceDefinition() {
      this.frameCount = -1;
      this.field778 = false;
      this.field779 = 5;
      this.shield = -1;
      this.weapon = -1;
      this.field780 = 99;
      this.field781 = -1;
      this.field782 = -1;
      this.field783 = 2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lgr;S)V",
      garbageValue = "259"
   )
   @Export("read")
   void read(Buffer var1) {
      while (true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "154075720"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      int[] var10000;
      int var3;
      int var4;
      if (var2 == 1) {
         var3 = var1.readUnsignedShort();
         this.frameLengths = new int[var3];

         for (var4 = 0; var4 < var3; ++var4) {
            this.frameLengths[var4] = var1.readUnsignedShort();
         }

         this.frameIds = new int[var3];

         for (var4 = 0; var4 < var3; ++var4) {
            this.frameIds[var4] = var1.readUnsignedShort();
         }

         for (var4 = 0; var4 < var3; ++var4) {
            var10000 = this.frameIds;
            var10000[var4] += var1.readUnsignedShort() << 16;
         }
      } else if (var2 == 2) {
         this.frameCount = var1.readUnsignedShort();
      } else if (var2 == 3) {
         var3 = var1.readUnsignedByte();
         this.field777 = new int[var3 + 1];

         for (var4 = 0; var4 < var3; ++var4) {
            this.field777[var4] = var1.readUnsignedByte();
         }

         this.field777[var3] = 9999999;
      } else if (var2 == 4) {
         this.field778 = true;
      } else if (var2 == 5) {
         this.field779 = var1.readUnsignedByte();
      } else if (var2 == 6) {
         this.shield = var1.readUnsignedShort();
      } else if (var2 == 7) {
         this.weapon = var1.readUnsignedShort();
      } else if (var2 == 8) {
         this.field780 = var1.readUnsignedByte();
      } else if (var2 == 9) {
         this.field781 = var1.readUnsignedByte();
      } else if (var2 == 10) {
         this.field782 = var1.readUnsignedByte();
      } else if (var2 == 11) {
         this.field783 = var1.readUnsignedByte();
      } else if (var2 == 12) {
         var3 = var1.readUnsignedByte();
         this.frameIds2 = new int[var3];

         for (var4 = 0; var4 < var3; ++var4) {
            this.frameIds2[var4] = var1.readUnsignedShort();
         }

         for (var4 = 0; var4 < var3; ++var4) {
            var10000 = this.frameIds2;
            var10000[var4] += var1.readUnsignedShort() << 16;
         }
      } else if (var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field776 = new int[var3];

         for (var4 = 0; var4 < var3; ++var4) {
            this.field776[var4] = var1.readMedium();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("init")
   void init() {
      if (this.field781 == -1) {
         if (this.field777 != null) {
            this.field781 = 2;
         } else {
            this.field781 = 0;
         }
      }

      if (this.field782 == -1) {
         if (this.field777 != null) {
            this.field782 = 2;
         } else {
            this.field782 = 0;
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ldu;II)Ldu;",
      garbageValue = "128527714"
   )
   @Export("animateSequence")
   public Model animateSequence(Model var1, int var2) {
      var2 = this.frameIds[var2];
      Frames var3 = ItemContainer.getFrames(var2 >> 16);
      var2 &= 65535;
      if (var3 == null) {
         return var1.toSharedSequenceModel(true);
      } else {
         Model var4 = var1.toSharedSequenceModel(!var3.hasAlphaTransform(var2));
         var4.animate(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ldu;IIB)Ldu;",
      garbageValue = "-65"
   )
   @Export("animateObject")
   Model animateObject(Model var1, int var2, int var3) {
      var2 = this.frameIds[var2];
      Frames var4 = ItemContainer.getFrames(var2 >> 16);
      var2 &= 65535;
      if (var4 == null) {
         return var1.toSharedSequenceModel(true);
      } else {
         Model var5 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var2));
         var3 &= 3;
         if (var3 == 1) {
            var5.rotateY270Ccw();
         } else if (var3 == 2) {
            var5.rotateY180();
         } else if (var3 == 3) {
            var5.rotateY90Ccw();
         }

         var5.animate(var4, var2);
         if (var3 == 1) {
            var5.rotateY90Ccw();
         } else if (var3 == 2) {
            var5.rotateY180();
         } else if (var3 == 3) {
            var5.rotateY270Ccw();
         }

         return var5;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ldu;II)Ldu;",
      garbageValue = "-1692496767"
   )
   @Export("animateSpotAnimation")
   Model animateSpotAnimation(Model var1, int var2) {
      var2 = this.frameIds[var2];
      Frames var3 = ItemContainer.getFrames(var2 >> 16);
      var2 &= 65535;
      if (var3 == null) {
         return var1.toSharedSpotAnimationModel(true);
      } else {
         Model var4 = var1.toSharedSpotAnimationModel(!var3.hasAlphaTransform(var2));
         var4.animate(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ldu;ILjh;II)Ldu;",
      garbageValue = "-386360993"
   )
   @Export("animateSequence2")
   public Model animateSequence2(Model var1, int var2, SequenceDefinition var3, int var4) {
      var2 = this.frameIds[var2];
      Frames var5 = ItemContainer.getFrames(var2 >> 16);
      var2 &= 65535;
      if (var5 == null) {
         return var3.animateSequence(var1, var4);
      } else {
         var4 = var3.frameIds[var4];
         Frames var6 = ItemContainer.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if (var6 == null) {
            var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2));
            var7.animate(var5, var2);
            return var7;
         } else {
            var7 = var1.toSharedSequenceModel(!var5.hasAlphaTransform(var2) & !var6.hasAlphaTransform(var4));
            var7.animate2(var5, var2, var6, var4, this.field777);
            return var7;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ldu;II)Ldu;",
      garbageValue = "-15433768"
   )
   @Export("animateWidget")
   public Model animateWidget(Model var1, int var2) {
      int var3 = this.frameIds[var2];
      Frames var4 = ItemContainer.getFrames(var3 >> 16);
      var3 &= 65535;
      if (var4 == null) {
         return var1.toSharedSequenceModel(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if (this.frameIds2 != null && var2 < this.frameIds2.length) {
            var6 = this.frameIds2[var2];
            var5 = ItemContainer.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if (var5 != null && var6 != 65535) {
            var7 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var3) & !var5.hasAlphaTransform(var6));
            var7.animate(var4, var3);
            var7.animate(var5, var6);
            return var7;
         } else {
            var7 = var1.toSharedSequenceModel(!var4.hasAlphaTransform(var3));
            var7.animate(var4, var3);
            return var7;
         }
      }
   }

   static {
      SequenceDefinition_cached = new EvictingDualNodeHashTable(64);
      field775 = new EvictingDualNodeHashTable(100);
   }
}
