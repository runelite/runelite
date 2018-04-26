import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kc")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("seq_ref")
   static IndexDataBase seq_ref;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("skel_ref")
   static IndexDataBase skel_ref;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   @Export("skin_ref")
   static IndexDataBase skin_ref;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("l")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("s")
   int[] field3768;
   @ObfuscatedName("y")
   @Export("frameLengths")
   public int[] frameLengths;
   @ObfuscatedName("c")
   public int[] field3764;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 59290843
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("i")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("o")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -374528621
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1347861919
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1105982699
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1359798023
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1366492101
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1711214881
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1459553941
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgg;I)V",
      garbageValue = "-429730259"
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "1790314451"
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
         this.field3768 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3768[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3768[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3764 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3764[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2132986177"
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lee;II)Lee;",
      garbageValue = "-2006824105"
   )
   @Export("transformActorModel")
   public Model transformActorModel(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class236.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.toSharedModel(true);
      } else {
         Model var4 = var1.toSharedModel(!var3.method3145(var2));
         var4.method2791(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lee;III)Lee;",
      garbageValue = "1791839979"
   )
   @Export("transformObjectModel")
   Model transformObjectModel(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class236.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.toSharedModel(true);
      } else {
         Model var5 = var1.toSharedModel(!var4.method3145(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.rotateY270Ccw();
         } else if(var3 == 2) {
            var5.rotateY180Ccw();
         } else if(var3 == 3) {
            var5.rotateY90Ccw();
         }

         var5.method2791(var4, var2);
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lee;II)Lee;",
      garbageValue = "-2049747053"
   )
   @Export("transformSpotAnimModel")
   Model transformSpotAnimModel(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class236.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.toSharedSpotAnimModel(true);
      } else {
         Model var4 = var1.toSharedSpotAnimModel(!var3.method3145(var2));
         var4.method2791(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lee;ILkc;II)Lee;",
      garbageValue = "-607342615"
   )
   @Export("applyTransformations")
   public Model applyTransformations(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class236.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.transformActorModel(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class236.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.toSharedModel(!var5.method3145(var2));
            var7.method2791(var5, var2);
            return var7;
         } else {
            var7 = var1.toSharedModel(!var5.method3145(var2) & !var6.method3145(var4));
            var7.method2835(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lee;II)Lee;",
      garbageValue = "1611928179"
   )
   public Model method5264(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class236.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.toSharedModel(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3768 != null && var2 < this.field3768.length) {
            var6 = this.field3768[var2];
            var5 = class236.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.toSharedModel(!var4.method3145(var3) & !var5.method3145(var6));
            var7.method2791(var4, var3);
            var7.method2791(var5, var6);
            return var7;
         } else {
            var7 = var1.toSharedModel(!var4.method3145(var3));
            var7.method2791(var4, var3);
            return var7;
         }
      }
   }
}
