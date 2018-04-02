import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("sequences")
   public static NodeCache sequences;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("skeletons")
   public static NodeCache skeletons;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -145939929
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "Llq;"
   )
   static IndexedSprite field3764;
   @ObfuscatedName("gt")
   @ObfuscatedGetter(
      intValue = -1137123045
   )
   @Export("cameraX")
   static int cameraX;
   @ObfuscatedName("x")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("z")
   int[] field3748;
   @ObfuscatedName("p")
   @Export("frameLengths")
   public int[] frameLengths;
   @ObfuscatedName("w")
   public int[] field3759;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1455720483
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("d")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("a")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -131931259
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 2055205033
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 882121669
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1202001239
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1875667801
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -244398935
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1732219259
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "-944928397"
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "796592874"
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
         this.field3748 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3748[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3748[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3759 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3759[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1645234562"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Led;II)Led;",
      garbageValue = "-154817742"
   )
   @Export("transformActorModel")
   public Model transformActorModel(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class230.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.toSharedModel(true);
      } else {
         Model var4 = var1.toSharedModel(!var3.method3079(var2));
         var4.method2759(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Led;III)Led;",
      garbageValue = "2129475365"
   )
   @Export("transformObjectModel")
   Model transformObjectModel(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class230.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.toSharedModel(true);
      } else {
         Model var5 = var1.toSharedModel(!var4.method3079(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.rotateY270Ccw();
         } else if(var3 == 2) {
            var5.rotateY180Ccw();
         } else if(var3 == 3) {
            var5.rotateY90Ccw();
         }

         var5.method2759(var4, var2);
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Led;II)Led;",
      garbageValue = "-814049924"
   )
   @Export("transformSpotAnimModel")
   Model transformSpotAnimModel(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class230.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.toSharedSpotAnimModel(true);
      } else {
         Model var4 = var1.toSharedSpotAnimModel(!var3.method3079(var2));
         var4.method2759(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Led;ILkn;II)Led;",
      garbageValue = "1501538762"
   )
   @Export("applyTransformations")
   public Model applyTransformations(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class230.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.transformActorModel(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class230.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.toSharedModel(!var5.method3079(var2));
            var7.method2759(var5, var2);
            return var7;
         } else {
            var7 = var1.toSharedModel(!var5.method3079(var2) & !var6.method3079(var4));
            var7.method2692(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Led;IB)Led;",
      garbageValue = "-3"
   )
   public Model method5182(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class230.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.toSharedModel(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3748 != null && var2 < this.field3748.length) {
            var6 = this.field3748[var2];
            var5 = class230.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.toSharedModel(!var4.method3079(var3) & !var5.method3079(var6));
            var7.method2759(var4, var3);
            var7.method2759(var5, var6);
            return var7;
         } else {
            var7 = var1.toSharedModel(!var4.method3079(var3));
            var7.method2759(var4, var3);
            return var7;
         }
      }
   }
}
