import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("seq_ref")
   static IndexDataBase seq_ref;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("skel_ref")
   static IndexDataBase skel_ref;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljf;"
   )
   @Export("skin_ref")
   static IndexDataBase skin_ref;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("m")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("z")
   int[] field3758;
   @ObfuscatedName("i")
   @Export("frameLengths")
   public int[] frameLengths;
   @ObfuscatedName("u")
   public int[] field3759;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -724152763
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("y")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("a")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1045267649
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1812357421
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1195258271
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 959648751
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1184041425
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -590031183
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1710823885
   )
   @Export("replyMode")
   public int replyMode;

   static {
      sequences = new NodeCache(64);
      skeletons = new NodeCache(100);
   }

   Sequence() {
      this.frameStep = -1;
      this.stretches = false;
      this.forcedPriority = 5;
      this.leftHandItem = -1;
      this.rightHandItem = -1;
      this.maxLoops = 99;
      this.precedenceAnimating = -1;
      this.priority = -1;
      this.replyMode = 2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "780254539"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgc;II)V",
      garbageValue = "1894563450"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedShort();
         this.frameLengths = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameLengths[var4] = var1.readUnsignedShort();
         }

         this.frameIDs = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 2) {
         this.frameStep = var1.readUnsignedShort();
      } else if(var2 == 3) {
         var3 = var1.readUnsignedByte();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.readUnsignedByte();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.forcedPriority = var1.readUnsignedByte();
      } else if(var2 == 6) {
         this.leftHandItem = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.rightHandItem = var1.readUnsignedShort();
      } else if(var2 == 8) {
         this.maxLoops = var1.readUnsignedByte();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.readUnsignedByte();
      } else if(var2 == 10) {
         this.priority = var1.readUnsignedByte();
      } else if(var2 == 11) {
         this.replyMode = var1.readUnsignedByte();
      } else if(var2 == 12) {
         var3 = var1.readUnsignedByte();
         this.field3758 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3758[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3758[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3759 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3759[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1898970171"
   )
   @Export("post")
   void post() {
      if(this.precedenceAnimating == -1) {
         if(this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.priority == -1) {
         if(this.interleaveLeave != null) {
            this.priority = 2;
         } else {
            this.priority = 0;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lei;II)Lei;",
      garbageValue = "548528508"
   )
   @Export("transformActorModel")
   public Model transformActorModel(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = Item.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.toSharedModel(true);
      } else {
         Model var4 = var1.toSharedModel(!var3.method3063(var2));
         var4.method2695(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lei;III)Lei;",
      garbageValue = "-1290132857"
   )
   @Export("transformObjectModel")
   Model transformObjectModel(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = Item.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.toSharedModel(true);
      } else {
         Model var5 = var1.toSharedModel(!var4.method3063(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.rotateY270Ccw();
         } else if(var3 == 2) {
            var5.rotateY180Ccw();
         } else if(var3 == 3) {
            var5.rotateY90Ccw();
         }

         var5.method2695(var4, var2);
         if(var3 == 1) {
            var5.rotateY90Ccw();
         } else if(var3 == 2) {
            var5.rotateY180Ccw();
         } else if(var3 == 3) {
            var5.rotateY270Ccw();
         }

         return var5;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lei;II)Lei;",
      garbageValue = "-1959822597"
   )
   @Export("transformSpotAnimModel")
   Model transformSpotAnimModel(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = Item.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.toSharedSpotAnimModel(true);
      } else {
         Model var4 = var1.toSharedSpotAnimModel(!var3.method3063(var2));
         var4.method2695(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lei;ILke;II)Lei;",
      garbageValue = "-264937213"
   )
   @Export("applyTransformations")
   public Model applyTransformations(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = Item.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.transformActorModel(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = Item.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.toSharedModel(!var5.method3063(var2));
            var7.method2695(var5, var2);
            return var7;
         } else {
            var7 = var1.toSharedModel(!var5.method3063(var2) & !var6.method3063(var4));
            var7.method2745(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lei;IB)Lei;",
      garbageValue = "-122"
   )
   public Model method5180(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = Item.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.toSharedModel(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3758 != null && var2 < this.field3758.length) {
            var6 = this.field3758[var2];
            var5 = Item.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.toSharedModel(!var4.method3063(var3) & !var5.method3063(var6));
            var7.method2695(var4, var3);
            var7.method2695(var5, var6);
            return var7;
         } else {
            var7 = var1.toSharedModel(!var4.method3063(var3));
            var7.method2695(var4, var3);
            return var7;
         }
      }
   }
}
